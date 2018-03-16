package com.esuizhen.cloudservice.followup.service.followupresult.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.followup.bean.FollowupMsgResultRes;
import com.esuizhen.cloudservice.followup.bean.FollowupMsgSendReq;
import com.esuizhen.cloudservice.followup.bean.FollowupPatientInfo;
import com.esuizhen.cloudservice.followup.bean.FollowupResultDetailQueryReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultStatisReq;
import com.esuizhen.cloudservice.followup.bean.FollowupSmsSendReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskPatientListQueryReq;
import com.esuizhen.cloudservice.followup.common.Constant;
import com.esuizhen.cloudservice.followup.common.DataAccessFilter;
import com.esuizhen.cloudservice.followup.dao.conf.FollowupGlobalConfigInfoDao;
import com.esuizhen.cloudservice.followup.dao.followupresult.FollowupTaskPatientDao;
import com.esuizhen.cloudservice.followup.dao.followupresult.FollowupWxResultDao;
import com.esuizhen.cloudservice.followup.dao.followuptask.FollowupTaskDao;
import com.esuizhen.cloudservice.followup.dao.user.UserDao;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupContentTemplateInfo;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupGlobalConfigInfo;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupSmsReqInfo;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupWxReqInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultDetailInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultStatisInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultValueInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupTaskPatient;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupPatientInfo;
import com.esuizhen.cloudservice.followup.service.conf.FollowupContentTemplateInfoService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupResultService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupWxResultService;
import com.esuizhen.cloudservice.followup.service.followupresult.thread.SmsMassFollowupRunnable;
import com.esuizhen.cloudservice.followup.service.followupresult.thread.WxMassFollowupRunnable;
import com.esuizhen.cloudservice.followup.util.MyHttpUtil;
import com.esuizhen.cloudservice.followup.util.MyJsonUtil;
import com.esuizhen.cloudservice.followup.util.UtilValidate;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.timertask.Timertask;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;
import com.westangel.common.util.PushContentUtil;
import com.westangel.common.util.PushUtil;

@Service(value = "followupWxResultService")
public class FollowupWxResultServiceImpl implements FollowupWxResultService {

	@Autowired
	private FollowupTaskDao followupTaskDao;
	
	@Autowired
	private FollowupWxResultDao followupWxResultDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private FollowupGlobalConfigInfoDao followupGlobalConfigInfoDao;

	@Autowired
	private FollowupTaskPatientDao followupTaskPatientDao;

	@Autowired
	private FollowupResultService followupResultService;
	
	@Autowired
	private PushInnerService pushInnerService;

	@Autowired
	private FollowupContentTemplateInfoService followupContentTemplateInfoService;

	@Value("${cloud.followup.url.root}")
	private String cloudFollowuUrlRoot;

	@Value("${cloud.sync.url.root}")
	private String cloudSyncUrlRoot;

	@Value("${local.url}")
	private String localUrl;

	@Value("${tob.server.api.url.root}")
	private String tobServerUrlRoot;

	@Value("${wxFollowupTemplateMessageSend}")
	private String wxFollowupTemplateMessageSendUrl;
	
	@Value("${server.wx.url.root}")
	private String wxHtmlRoot;
	@Value("${server.questionnaire.toB.path}")
	private String questionurl;

	@Override
	public Page<TFollowupResultStatisInfo> queryFollowupResultStatis(FollowupResultReq req) {
		PageHelper.startPage(req.getPage() + 1, req.getNum());

		req.setOperator(DataAccessFilter.getOperator(req.getUserRole(), req.getOperator()));
		List<TFollowupResultStatisInfo> list = followupWxResultDao.queryFollowupResultStatis(req);
		// 统计反馈人数
		Page myPage = PageUtil.returnPage((com.github.pagehelper.Page<TFollowupResultStatisInfo>) list);
		List<TFollowupResultStatisInfo> dataList = myPage.getDataList();
		if (UtilValidate.isNotEmpty(dataList)) {
			List<TFollowupResultStatisInfo> resultList = new ArrayList<TFollowupResultStatisInfo>();
			// 设置统计参数
			FollowupResultStatisReq statisReq = new FollowupResultStatisReq();
			statisReq.setOperator(req.getOperator());
			for (TFollowupResultStatisInfo data : dataList) {
				statisReq.setTemplateId(data.getContentTemplateId());
				statisReq.setSendTime(DateUtil.getDateStr(data.getSendTime()));
				statisReq.setReplyState(1);

				// 统计一天某模板的各状态反馈人数
				data.setFollowupResultValueList(this.statisFollowupResult(statisReq));
				resultList.add(data);
			}
			myPage.setDataList(resultList);
		}
		return myPage;
	}

	@Override
	public Page<TFollowupResultDetailInfo> queryFollowupResultDetail(FollowupResultDetailQueryReq req) {
		PageHelper.startPage(req.getPage() + 1, req.getNum());
		// 数据筛选
		req.setOperator(DataAccessFilter.getOperator(req.getUserRole(), req.getOperator()));
		List<TFollowupResultDetailInfo> list = followupWxResultDao.queryFollowupResultDetail(req);
		return PageUtil.returnPage((com.github.pagehelper.Page<TFollowupResultDetailInfo>) list);
	}

	@Override
	public List<TFollowupResultValueInfo> statisFollowupResult(FollowupResultStatisReq req) {
		req.setReplyState(1);// 只统计已回复
		// 数据筛选
		req.setOperator(DataAccessFilter.getOperator(req.getUserRole(), req.getOperator()));
		return followupWxResultDao.statisFollowupResult(req);
	}

	@Override
	public Long statisFollowupResultTotal(FollowupResultStatisReq req) {
		// 数据筛选
		req.setOperator(DataAccessFilter.getOperator(req.getUserRole(), req.getOperator()));
		return followupWxResultDao.statisFollowupResultTotal(req);
	}
	//发送选中短信
	public FollowupMsgResultRes sendSpecifyWxFollowup(FollowupMsgSendReq followupMsgSendReq){
		if (followupMsgSendReq == null)
			throw new EmptyParamExcption(" param error followupWxReqInfo is null");
		if (StringUtils.isEmpty(followupMsgSendReq.getTemplateId()))
			throw new EmptyParamExcption(" param error templateId is null");
		if (followupMsgSendReq.getHospitalId() == null)
			throw new EmptyParamExcption(" param error hospitalId is null");
		List<FollowupPatientInfo> patientInfoList = followupMsgSendReq.getPatientInfoList();
		if (patientInfoList==null||patientInfoList.size()==0)
			throw new EmptyParamExcption(" param error patientInfoList is null");
		
		Integer patientCount = patientInfoList.size();
		Integer sendCount = 0;
		Integer repeatCount = 0;
		Integer failureCount = 0;
		
		String followupAssignId = followupMsgSendReq.getFollowupAssignId();
		String templateId = followupMsgSendReq.getTemplateId();
		Integer hospitalId = followupMsgSendReq.getHospitalId();
		String openId = null;
		String trueName = null;
		String mobile = null;
		String followupTaskId = followupMsgSendReq.getFollowupTaskId();;
		Long patientId = null;
		// 查询是否已存在发送微信
		Map<String, Object> sendParams = null;
		List<TFollowupWxReqInfo> wxReqList = null;
		LinkedHashMap<String, Object> patientMap = null;
		TFollowupWxReqInfo followupWxReqInfo = null;
		Date timerTaskDate = followupMsgSendReq.getTimerTaskDate();
		List<FollowupPatientInfo> tempFollowupPatientList = null;
		
		
		followupMsgSendReq.setPatientInfoList(null);
		for (FollowupPatientInfo followupPatientInfo : patientInfoList) {
			patientId = followupPatientInfo.getPatientId();
			trueName = followupPatientInfo.getTrueName();
			mobile = followupPatientInfo.getMobile();
			openId = followupPatientInfo.getOpenId();
			
			
			patientMap = userDao.queryUserInfoByPatientId(patientId);
			if (UtilValidate.isEmpty(openId)) {
				openId = (String) patientMap.get("openId");
				trueName = (String) patientMap.get("trueName");
			}
			if(UtilValidate.isEmpty(openId)){
				failureCount++;
				continue;
			};
			
			sendParams = new HashMap<String, Object>();
			sendParams.put("followupTaskId", followupTaskId);
			sendParams.put("followupTaskAssignId", followupAssignId);
			sendParams.put("patientId", patientId);
			sendParams.put("templateId", templateId);
			sendParams.put("state", "1");
			wxReqList = this.followupWxResultDao.queryFollowupWxReply(sendParams);
			if (UtilValidate.isNotEmpty(wxReqList)) {
				repeatCount++;
				LogUtil.log.debug("Wx message already exists:"+sendParams.toString());
				continue;
			}
			
			//如果系统设置开关以电话随访为准后，
			//或未开启电话随访为准但已获取到有效随访结果（“稳定”、“复发”、“转移”、“死亡”或根据系统开关判断“其他情况”）时，
			//此时在群发、选中群发对应的患者时
			//followupSmsResultDao
			followupMsgSendReq.setPatientId(patientId);
			String validFollowupFlag = followupResultService.getValidFollowupFlag(followupMsgSendReq);
			if(StringUtils.isBlank(validFollowupFlag)||"0".equals(validFollowupFlag)){
				failureCount++;
				continue;
			}
			sendCount++;
			// 定时任务发送
			if (UtilValidate.isNotEmpty(timerTaskDate)) {
				followupMsgSendReq.setTimerTaskDate(null);
				followupMsgSendReq.setPatientId(patientId);
				followupMsgSendReq.setTrueName(trueName);
				followupMsgSendReq.setMobile(mobile);
				followupMsgSendReq.setFollowupTaskId(followupTaskId);
				tempFollowupPatientList = new ArrayList<FollowupPatientInfo>();
				tempFollowupPatientList.add(followupPatientInfo);
				followupMsgSendReq.setPatientInfoList(tempFollowupPatientList);
				String param = JsonUtil.toJson(followupMsgSendReq);

				String timeTaskUrl = localUrl + "/timertask/create";
				Timertask timertask = new Timertask();
				timertask.setTaskType(1);
				timertask.setUserId(patientMap.get("userId") + "");
				timertask.setActionType(8);
				timertask.setServiceType(2);
				timertask.setHttpUrl(tobServerUrlRoot + "/followup/do/wx/send");
				timertask.setHttpContent(param);
				timertask.setActionTime(timerTaskDate);
				timertask.setServiceTargetId(GeneralUtil.generatorUUID("wx_temp"));
				LogUtil.log.debug("----------微信定时开始：" + JsonUtil.toJson(timertask));
				TMsgResponse<Object> tMsgResponse = MyHttpUtil.postJson(timeTaskUrl, timertask);
				LogUtil.log.debug("[微信定时任务调用返回状态]" + tMsgResponse.getRespCode() + "," + tMsgResponse.getRespMsg());
				continue;
			}
			followupWxReqInfo = new TFollowupWxReqInfo();
			followupWxReqInfo.setFollowupTaskId(followupTaskId);
			followupWxReqInfo.setFollowupAssignId(followupAssignId);
			followupWxReqInfo.setTemplateId(templateId);
			followupWxReqInfo.setHospitalId(hospitalId);
			followupWxReqInfo.setPatientId(patientId);
			followupWxReqInfo.setMessageId(GeneralUtil.generatorUUID("WXMSG"));
			followupWxReqInfo.setSendTime(new Date());
			followupWxReqInfo.setTrueName(trueName);
			followupWxReqInfo.setOpenId(openId);

			// 未发送
			followupWxReqInfo.setState(0);
			if (followupWxResultDao.insertFollowupWxReq(followupWxReqInfo) == 0)
				throw new EmptyObjectExcption(" create followup_wx_followupWxReqInfo error");
			// 消息推送(根据部署确定使用微信发送方式)
			followupWxReqInfo=this.sendWxAdapt(followupWxReqInfo, trueName, openId);

			if (followupWxResultDao.updateFollowupWxReq(followupWxReqInfo) == 0)
				throw new EmptyObjectExcption(" update followup_wx_followupWxReqInfo error");

			// 回填随访任务与患者关系微信状态
			TFollowupTaskPatient followupTaskPatient = new TFollowupTaskPatient();
			followupTaskPatient.setFollowupAssignId(followupAssignId);
			followupTaskPatient.setFollowupTaskId(followupTaskId);
			followupTaskPatient.setPatientId(patientId);
			followupTaskPatient.setWxReqId(followupWxReqInfo.getReqId());
			followupTaskPatient.setWxState(followupWxReqInfo.getState());
			followupTaskPatientDao.updateFollowupTaskPatient(followupTaskPatient);
		}
		FollowupMsgResultRes result = new FollowupMsgResultRes();
		result.setPatientCount(patientCount);
		result.setSendCount(sendCount);
		result.setRepeatCount(repeatCount);
		result.setFailureCount(failureCount);
		return result;
		
	}
	
	
	public TFollowupWxReqInfo sendWxAdapt(TFollowupWxReqInfo followupWxReqInfo,String trueName,String openId){
		try {
			//随访全局配置
			TFollowupGlobalConfigInfo globalConfig = followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
			TFollowupContentTemplateInfo templateInfo = followupContentTemplateInfoService.queryFollowupContentTemplateInfo(followupWxReqInfo.getTemplateId());
			if(1==globalConfig.getDeployLocation()){
				String url = this.cloudFollowuUrlRoot + wxFollowupTemplateMessageSendUrl;
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("hospitalId", followupWxReqInfo.getHospitalId());
				paramMap.put("messageId", followupWxReqInfo.getMessageId());
				paramMap.put("followupDate", DateUtil.convertToStr(new Date(), DateUtil.DATE_TIME_LINE));
				paramMap.put("trueName", trueName);
				paramMap.put("openId", openId);
				paramMap.put("signature", templateInfo.getSignature());
				paramMap.put("content", templateInfo.getContent());
				paramMap.put("replyContent", templateInfo.getAutoReplyContent());
	
				TMsgResponse<Object> tMsgResponse = MyHttpUtil.postJson(url, paramMap);
				if (tMsgResponse.getRespCode() == 0) {
					// 已发送
					followupWxReqInfo.setState(1);
					// 未回复
					followupWxReqInfo.setReplyState(0);
				}
			}else{
				LinkedHashMap<String,Object> user = userDao.queryPatientInfoByOpenId(openId);
				LinkedHashMap<String,Object> template = null;
				template = new LinkedHashMap<String,Object>();
				template.put("siganature", templateInfo.getSignature());
				template.put("content", templateInfo.getContent());
				List<String> values = new ArrayList<String>();
				values.add(pushInnerService.getMessage(PushContentUtil.getFollowupPushContent(null, "followup.questionnaire.info", new Object[]{template.get("siganature")})));
				values.add(trueName);
				values.add(DateUtil.getDateStr(new Date()));
				values.add(pushInnerService.getMessage(PushContentUtil.getFollowupPushContent(null, "followup.type.questionnaire.info")));
				values.add((String)template.get("content"));
				PushNotifyInfo notify = PushUtil.getWxTemplatePushNotifyInfo("suifangtixing", wxHtmlRoot+questionurl+"?hospitalId="+followupWxReqInfo.getHospitalId()+"&messageId="+followupWxReqInfo.getMessageId()+"&patientId="+user.get("patientId"), values);
				notify.setUserId((Long)user.get("userId"));
				notify.setProductId((Integer)user.get("productId"));
				pushInnerService.push(notify);
				// 已发送
				followupWxReqInfo.setState(1);
				// 未回复
				followupWxReqInfo.setReplyState(0);
			}
		} catch (Exception e) {
			LogUtil.logError.error(" send tob followup error:" + e.getMessage());
			// 发送失败
			followupWxReqInfo.setState(2);
		}
		return followupWxReqInfo;
	}

	@Override
	public FollowupMsgResultRes sendWxMassFollowup(FollowupMsgSendReq followupMsgSendReq) {
		int totalCount = 0;
		int sendCount = 0;
		int repeatCount = 0;
		int failureCount = 0;
		List<FollowupPatientInfo> patientInfoList = null;
		FollowupPatientInfo followupPatientInfo=null;
		LinkedHashMap<String, Object> patientMap = null;
		Map<String, Object> sendParams = null;
		List<TFollowupWxReqInfo> wxReqList = null;
		FollowupMsgResultRes result = new FollowupMsgResultRes();
		
		String followupAssignId = followupMsgSendReq.getFollowupAssignId();
		String templateId = followupMsgSendReq.getTemplateId();
		String openId = null;
		String followupTaskId = followupMsgSendReq.getFollowupTaskId();;
		
		TFollowupTaskPatientListQueryReq taskPatientListQueryReq = followupMsgSendReq.getTaskPatientListQueryReq();
		List<TFollowupPatientInfo> rawList = followupTaskDao.queryFollowupTaskPatientList(taskPatientListQueryReq);
		followupMsgSendReq.setTaskPatientListQueryReq(null);
		if(rawList!=null&&rawList.size()>0&&rawList.get(0)!=null){
			patientInfoList=new ArrayList<FollowupPatientInfo>(); 
			totalCount=rawList.size();
			for (TFollowupPatientInfo rawPatientInfo : rawList) {
				openId=null;
				patientMap = userDao.queryUserInfoByPatientId(rawPatientInfo.getPatientId());
				if (UtilValidate.isNotEmpty(patientMap)) {
					openId = (String) patientMap.get("openId");
				}
				
				//trueName = (String) patientMap.get("trueName");
				if(UtilValidate.isEmpty(openId)){
					failureCount++;
					continue;
				};
				sendParams = new HashMap<String, Object>();
				sendParams.put("followupTaskId", followupTaskId);
				sendParams.put("followupTaskAssignId", followupAssignId);
				sendParams.put("patientId", rawPatientInfo.getPatientId());
				sendParams.put("templateId", templateId);
				sendParams.put("state", "1");
				wxReqList = this.followupWxResultDao.queryFollowupWxReply(sendParams);
				if (UtilValidate.isNotEmpty(wxReqList)) {
					repeatCount++;
					LogUtil.log.debug("Wx message already exists:"+sendParams.toString());
					continue;
				}
				//如果系统设置开关以电话随访为准后，
				//或未开启电话随访为准但已获取到有效随访结果（“稳定”、“复发”、“转移”、“死亡”或根据系统开关判断“其他情况”）时，
				//此时在群发、选中群发对应的患者时
				//followupSmsResultDao
				followupMsgSendReq.setPatientId(rawPatientInfo.getPatientId());
				String validFollowupFlag = followupResultService.getValidFollowupFlag(followupMsgSendReq);
				if(StringUtils.isBlank(validFollowupFlag)||"0".equals(validFollowupFlag)){
					failureCount++;
					continue;
				}
				sendCount++;
				followupPatientInfo = new FollowupPatientInfo();
				followupPatientInfo.setPatientId(rawPatientInfo.getPatientId());
				followupPatientInfo.setOpenId(openId);
				patientInfoList.add(followupPatientInfo);
			}
		}
		
		ExecutorService es = Executors.newFixedThreadPool(10);
		followupMsgSendReq.setPatientInfoList(patientInfoList);
		es.submit(new SmsMassFollowupRunnable(followupMsgSendReq));
		es.shutdown();

		result.setPatientCount(totalCount);
		result.setSendCount(sendCount);
		result.setRepeatCount(repeatCount);
		result.setFailureCount(failureCount);
		return result;
	}

	@Override
	public void scanWxReply() {
		TFollowupGlobalConfigInfo globalConfig = followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
		Integer hospitalId = globalConfig.getHospitalId();
		String wxUrl = cloudSyncUrlRoot + "/sync/fromcloud/followupresult?hospitalId=" + globalConfig.getHospitalId();
		LogUtil.log.debug("[扫描微信请求wxUrl]:" + wxUrl);
		// 调用微信接口获取回复结果
		String messageJson = MyHttpUtil.httpGet(wxUrl);
		LogUtil.log.debug("[微信回复结果messageJson]" + messageJson);
		TMsgResponse<List<Map<String, Object>>> tMsgResponse = MyJsonUtil.toObject(messageJson, TMsgResponse.class);
		List<Map<String, Object>> detailInfoMapList = tMsgResponse.getResult();

		// 微信赋值并操作随访结果
		List<Map<String, Object>> uuids = new ArrayList<Map<String, Object>>();
		if (UtilValidate.isNotEmpty(detailInfoMapList)) {
			Map<String, Object> uuidMap = null;
			// 据messageId查询微信
			String messageId = null;
			TFollowupWxReqInfo followupWxReqInfo = null;
			for (Map<String, Object> detailInfoMap : detailInfoMapList) {
				// 同步结果
				try {
					messageId = (String) detailInfoMap.get("messageId");
					LogUtil.log.debug("[扫描微信回复！]messageJson:" + messageJson);
					followupWxReqInfo = this.followupWxResultDao.queryFollowupWxReqByMessageId(messageId);

					if (UtilValidate.isEmpty(followupWxReqInfo)) {
						//20170512 将该方法去掉，非微信使用随访三通方式同步
//						LogUtil.log.debug("根据微信ID查询为空");
//						this.saveSyncFromcloudResult(hospitalId, detailInfoMap);
					} else {
						LogUtil.log.debug("根据微信ID查询【不】为空");
						this.replyWxFollowupResult(detailInfoMap, followupWxReqInfo);
					}
				} catch (Exception e) {
					LogUtil.log.debug("messageJson:" + messageJson + "处理失败！" + e.getMessage());
					continue;
				}
				// 回执参数
				uuidMap = new HashMap<String, Object>();
				uuidMap.put("id", detailInfoMap.get("id"));
				uuidMap.put("followupResultBuffId", detailInfoMap.get("followupResultBuffId"));
				uuids.add(uuidMap);
			}
		}

		// 同步结果通知
		String wxNotifyUrl = cloudSyncUrlRoot + "/sync/tocloud/result/notify";
		LogUtil.log.debug("[微信回执Url]" + wxNotifyUrl);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("hospitailId", hospitalId);
		paramMap.put("resultType", 1);
		paramMap.put("uuids", uuids);
		TMsgResponse<Object> msg = MyHttpUtil.postJson(wxNotifyUrl, paramMap);
		LogUtil.log.debug("[微信同步结果回执]" + wxNotifyUrl + ",返回结果：" + msg.getRespCode() + msg.getRespMsg());
	}

	@Override
	public void replyWxFollowupResult(Map<String, Object> detailInfoMap, TFollowupWxReqInfo followupWxReqInfo) {
		TFollowupResultDetailInfo followupResultDetailInfo = new TFollowupResultDetailInfo();
		Integer followupResultValue = (Integer) detailInfoMap.get("followupResultValue");
		// 调用入库规则
		BeanUtils.copyProperties(followupWxReqInfo, followupResultDetailInfo);
		followupResultDetailInfo.setFollowupResultValue(followupResultValue);
		followupResultDetailInfo.setFollowupWay(Constant.FOLLOWUPWAY.FOLLOWUPWAY_WX);
		followupResultDetailInfo.setReplyTime(new Date());
		followupResultDetailInfo.setReplyContent(followupResultValue + "");
		followupResultDetailInfo.setSyncFlag(1);
		if (UtilValidate.isNotEmpty(detailInfoMap.get("followupTime"))) {
			followupResultDetailInfo.setFollowupTime(DateUtil.stringToDate((String) detailInfoMap.get("followupTime"), "yyyy-MM-dd HH:mm:ss"));
		} else {
			followupResultDetailInfo.setFollowupTime(new Date());
		}
		if (UtilValidate.isNotEmpty(detailInfoMap.get("transferDate"))) {
			followupResultDetailInfo.setTransferDate(DateUtil.stringToDate((String) detailInfoMap.get("transferDate"), "yyyy-MM-dd HH:mm:ss"));
		}
		if (UtilValidate.isNotEmpty(detailInfoMap.get("relapseDate"))) {
			followupResultDetailInfo.setRelapseDate(DateUtil.stringToDate((String) detailInfoMap.get("relapseDate"), "yyyy-MM-dd HH:mm:ss"));
		}
		followupResultDetailInfo.setSourceFlag(1);
		followupResultDetailInfo.setRelapseParts((String) detailInfoMap.get("relapseParts"));
		followupResultDetailInfo.setTransferParts((String) detailInfoMap.get("transferParts"));
		followupResultDetailInfo.setDeathCause((String) detailInfoMap.get("deathCause"));
		if (UtilValidate.isNotEmpty(detailInfoMap.get("deathDate"))) {
			followupResultDetailInfo.setDeathDate(DateUtil.stringToDate((String) detailInfoMap.get("deathDate"), "yyyy-MM-dd HH:mm:ss"));
		}
		followupResultDetailInfo.setIsInHospitalDeath((Integer) detailInfoMap.get("isInHospitalDeath"));
		followupResultDetailInfo.setIsTumourDeath((Integer) detailInfoMap.get("isTumourDeath"));
		followupResultDetailInfo.setOtherCause((String) detailInfoMap.get("otherCause"));
		followupResultDetailInfo = this.followupResultService.storeRuleFollowupResult(followupResultDetailInfo);

		// 更新微信信下发请求表
		followupWxReqInfo.setFollowupTaskId(followupResultDetailInfo.getFollowupTaskId());
		followupWxReqInfo.setFollowupAssignId(followupResultDetailInfo.getFollowupAssignId());
		followupWxReqInfo.setPatientId(followupResultDetailInfo.getPatientId());
		followupWxReqInfo.setFollowupResultId(followupResultDetailInfo.getFollowupResultId());
		followupWxReqInfo.setFollowupResultBuffId(followupResultDetailInfo.getFollowupResultBuffId());
		followupWxReqInfo.setReplyState(1);// 已回复
		followupWxReqInfo.setReplyContent(followupResultValue + "");
		followupWxReqInfo.setReplyTime(new Date());
		followupWxReqInfo.setResultProcessState(1);// 标识为自动处理
		this.followupWxResultDao.updateFollowupWxReq(followupWxReqInfo);
	}

	@Override
	public void saveSyncFromcloudResult(Integer hospitalId,Map<String, Object> syncFollowupResult) {
		String patientUuid = (String) syncFollowupResult.get("patientUuid");
		Integer currCycleDay = null;

		// 获取参数
		TFollowupResultDetailInfo followupResultDetailInfo = coventSyncFollowupResult(syncFollowupResult);
		followupResultDetailInfo.setHospitalId(hospitalId);

		// 查询患者最后一次随访结果
		TFollowupResultDetailInfo lastFollowupResultDetailInfo = followupResultService.queryLastFollowupResultByPatientUuid(patientUuid);
		
		Date lastFollowupTime =null;
		if(UtilValidate.isNotEmpty(lastFollowupResultDetailInfo)){
			Long patientId = lastFollowupResultDetailInfo.getPatientId();
			followupResultDetailInfo.setPatientId(patientId);
			
			//设置操作员
			if(UtilValidate.isEmpty(lastFollowupResultDetailInfo.getOperator())){
				followupResultDetailInfo.setOperator(9L);
			}else{
				followupResultDetailInfo.setOperator(lastFollowupResultDetailInfo.getOperator());
			}
			if (UtilValidate.isEmpty(lastFollowupResultDetailInfo.getFollowupResultId())) {
				this.followupResultService.insertFollowupResult(followupResultDetailInfo);
				return;
			}
			lastFollowupTime = lastFollowupResultDetailInfo.getFollowupTime();
		}else{
			return;
		}
		
		

		// 判断是否死亡（暂存记录必插）
		if (lastFollowupResultDetailInfo.getFollowupResultValue() == 4) {// 死亡
			this.followupResultService.insertFollowupResultBuff(followupResultDetailInfo);
			return;
		}

		// 查询全局设置（随访周期）
		TFollowupGlobalConfigInfo globalConfig = followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
		Integer cycleDay = globalConfig.getFollowupCycle();

		// 计算随访时间是否超出随访周期（当前日期-随访日期）
		try {
			currCycleDay = DateUtil.daysBetween(lastFollowupTime, new Date());
		} catch (ParseException e) {
			LogUtil.log.error("【随访周期计算错误】" + e.getMessage());
		}

		// 超过，直接插入结果记录
		if (currCycleDay > cycleDay) {
			this.followupResultService.insertFollowupResult(followupResultDetailInfo);
			this.followupResultService.insertFollowupResultBuff(followupResultDetailInfo);
		} else {// 不超，按优先级规则插入
			followupResultDetailInfo.setOperator(lastFollowupResultDetailInfo.getOperator());
			followupResultDetailInfo.setFollowupTaskId(lastFollowupResultDetailInfo.getFollowupTaskId());
			followupResultDetailInfo.setFollowupAssignId(lastFollowupResultDetailInfo.getFollowupAssignId());
			this.followupResultService.storeRuleSyncFollowupResult(followupResultDetailInfo);
		}

	}

	public TFollowupResultDetailInfo coventSyncFollowupResult(Map<String, Object> syncFollowupResult) {
		TFollowupResultDetailInfo followupResultDetailInfo = new TFollowupResultDetailInfo();
		Integer followupResultValue = (Integer) syncFollowupResult.get("followupResultValue");
		Integer sourceFlag = (Integer) syncFollowupResult.get("sourceFlag");

		followupResultDetailInfo.setFollowupResultValue(followupResultValue);
		if (UtilValidate.isNotEmpty(sourceFlag) && sourceFlag == 4) {
			followupResultDetailInfo.setFollowupWay(Constant.FOLLOWUPWAY.FOLLOWUPWAY_APP);
		} else {
			followupResultDetailInfo.setFollowupWay(Constant.FOLLOWUPWAY.FOLLOWUPWAY_WX);
		}
		followupResultDetailInfo.setReplyTime(new Date());
		followupResultDetailInfo.setReplyContent(followupResultValue + "");
		followupResultDetailInfo.setSyncFlag(1);

		if (UtilValidate.isNotEmpty(syncFollowupResult.get("followupTime"))) {
			followupResultDetailInfo.setFollowupTime(DateUtil.stringToDate((String) syncFollowupResult.get("followupTime"), "yyyy-MM-dd HH:mm:ss"));
		} else {
			followupResultDetailInfo.setFollowupTime(new Date());
		}
		if (UtilValidate.isNotEmpty(syncFollowupResult.get("transferDate"))) {
			followupResultDetailInfo.setTransferDate(DateUtil.stringToDate((String) syncFollowupResult.get("transferDate"), "yyyy-MM-dd HH:mm:ss"));
		}
		if (UtilValidate.isNotEmpty(syncFollowupResult.get("relapseDate"))) {
			followupResultDetailInfo.setRelapseDate(DateUtil.stringToDate((String) syncFollowupResult.get("relapseDate"), "yyyy-MM-dd HH:mm:ss"));
		}

		followupResultDetailInfo.setRelapseParts((String) syncFollowupResult.get("relapseParts"));
		followupResultDetailInfo.setTransferParts((String) syncFollowupResult.get("transferParts"));
		followupResultDetailInfo.setDeathCause((String) syncFollowupResult.get("deathCause"));
		followupResultDetailInfo.setDeathDate((Date) syncFollowupResult.get("deathDate"));
		followupResultDetailInfo.setIsInHospitalDeath((Integer) syncFollowupResult.get("isInHospitalDeath"));
		followupResultDetailInfo.setIsTumourDeath((Integer) syncFollowupResult.get("isTumourDeath"));
		followupResultDetailInfo.setOtherCause((String) syncFollowupResult.get("otherCause"));
		followupResultDetailInfo.setSourceFlag(sourceFlag);
		followupResultDetailInfo.setFollowupResultBuffId((String)syncFollowupResult.get("followupResultBuffId"));

		return followupResultDetailInfo;
	}

}
