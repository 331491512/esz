package com.esuizhen.cloudservice.followup.service.followupresult.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.base.service.organization.OrganizationDoctorService;
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
import com.esuizhen.cloudservice.followup.dao.conf.FollowupLocalProfileDao;
import com.esuizhen.cloudservice.followup.dao.followupresult.FollowupResultWayDao;
import com.esuizhen.cloudservice.followup.dao.followupresult.FollowupSmsResultDao;
import com.esuizhen.cloudservice.followup.dao.followupresult.FollowupTaskPatientDao;
import com.esuizhen.cloudservice.followup.dao.followuptask.FollowupTaskDao;
import com.esuizhen.cloudservice.followup.dao.meta.FollowupMetaInfoDao;
import com.esuizhen.cloudservice.followup.dao.user.DoctorDao;
import com.esuizhen.cloudservice.followup.dao.user.PatientDao;
import com.esuizhen.cloudservice.followup.dao.user.UserDao;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupContentTemplateInfo;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupGlobalConfigInfo;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupLocalProfile;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupReplyParseRulesInfo;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupSmsReqInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultDetailInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultStatisInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultValueInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupTaskPatient;
import com.esuizhen.cloudservice.followup.model.followupresult.TPatientContactInfo;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupPatientInfo;
import com.esuizhen.cloudservice.followup.model.meta.FollowupResultValue;
import com.esuizhen.cloudservice.followup.service.conf.FollowupContentTemplateInfoService;
import com.esuizhen.cloudservice.followup.service.conf.FollowupReplyParseRulesInfoService;
import com.esuizhen.cloudservice.followup.service.followupdo.FollowupSmsSendCountService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupResultService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupSmsResultService;
import com.esuizhen.cloudservice.followup.service.followupresult.thread.SmsMassFollowupRunnable;
import com.esuizhen.cloudservice.followup.util.BeanUtils;
import com.esuizhen.cloudservice.followup.util.MyHttpUtil;
import com.esuizhen.cloudservice.followup.util.UtilValidate;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.sms.SmsSendReportInfo;
import com.westangel.common.bean.timertask.Timertask;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.ObjectAlreadyExistExcption;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;

@Service(value = "followupSmsResultService")
public class FollowupSmsResultServiceImpl implements FollowupSmsResultService {
	
	@Autowired
	FollowupTaskDao followupTaskDao;
	
	@Autowired
	private FollowupSmsResultDao followupSmsResultDao;

	@Autowired
	private FollowupTaskPatientDao followupTaskPatientDao;

	@Autowired
	private FollowupResultService followupResultService;

	@Autowired
	private FollowupSmsSendCountService followupSmsSendCountService;

	@Autowired
	private UserDao userDao;

	@Autowired
	private PatientDao patientDao;

	@Autowired
	private FollowupMetaInfoDao followupMetaInfoDao;
	
	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private FollowupGlobalConfigInfoDao followupGlobalConfigInfoDao;
	
	@Autowired
	private FollowupLocalProfileDao followupLocalProfileDao;
	
	@Autowired
	private FollowupReplyParseRulesInfoService followupReplyParseRulesInfoService;

	@Autowired
	private DataAccessFilter dataAccessFilter;
	
	@Autowired
	private FollowupContentTemplateInfoService followupContentTemplateInfoService;
	
	@Autowired
	private OrganizationDoctorService organizationDoctorService;
	
	@Autowired
	private FollowupResultWayDao followupResultDao;
	
	
	@Value("${tob.server.api.url.root}")
	private String tobServerUrlRoot;

	@Value("${local.url}")
	private String localUrl;

	@Value("${smsFollowupTemplateMessageSend}")
	private String smsFollowupTemplateMessageSendUrl;

	@Override
	public Page<TFollowupResultStatisInfo> queryFollowupResultStatis(FollowupResultReq req) {
		PageHelper.startPage(req.getPage() + 1, req.getNum());

		// 数据筛选
		req.setOperator(DataAccessFilter.getOperator(req.getUserRole(), req.getOperator()));
		List<TFollowupResultStatisInfo> list = followupSmsResultDao.queryFollowupResultStatis(req);

		// 统计反馈人数
		Page myPage = PageUtil.returnPage((com.github.pagehelper.Page<TFollowupResultStatisInfo>) list);
		List<TFollowupResultStatisInfo> dataList = myPage.getDataList();
		if (UtilValidate.isNotEmpty(dataList)) {
			List<TFollowupResultStatisInfo> resultList = new ArrayList<TFollowupResultStatisInfo>();
			FollowupResultStatisReq statisReq = new FollowupResultStatisReq();
			statisReq.setOperator(req.getOperator());
			for (TFollowupResultStatisInfo data : dataList) {
				// 设置统计参数
				statisReq.setTemplateId(data.getContentTemplateId());
				statisReq.setSendTime(DateUtil.getDateStr(data.getSendTime()));
				statisReq.setReplyState(1);// 只统计已回复

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
		List<TFollowupResultDetailInfo> list = followupSmsResultDao.queryFollowupResultDetail(req);
		return PageUtil.returnPage((com.github.pagehelper.Page<TFollowupResultDetailInfo>) list);
	}

	@Override
	public List<TFollowupResultValueInfo> statisFollowupResult(FollowupResultStatisReq req) {
		req.setReplyState(1);// 只统计已回复
		// 数据筛选
		req.setOperator(DataAccessFilter.getOperator(req.getUserRole(), req.getOperator()));
		return followupSmsResultDao.statisFollowupResult(req);
	}

	@Override
	public Long statisFollowupResultTotal(FollowupResultStatisReq req) {
		// 数据筛选
		req.setOperator(DataAccessFilter.getOperator(req.getUserRole(), req.getOperator()));
		return followupSmsResultDao.statisFollowupResultTotal(req);
	}

	@Override
	@Transactional
	public FollowupMsgResultRes sendSpecifySmsFollowup(FollowupMsgSendReq followupMsgSendReq){
		
		if (followupMsgSendReq == null)
			throw new EmptyParamExcption(" param error followupSmsReqInfo is null");
		if (StringUtils.isEmpty(followupMsgSendReq.getTemplateId()))
			throw new EmptyParamExcption(" param error templateId is null");
		if (followupMsgSendReq.getHospitalId() == null)
			throw new EmptyParamExcption(" param error hospitalId is null");
		List<FollowupPatientInfo> patientInfoList = followupMsgSendReq.getPatientInfoList();
		Date timerTaskDate = followupMsgSendReq.getTimerTaskDate();
		if (patientInfoList == null||patientInfoList.size()==0)
			throw new EmptyParamExcption(" param error patientInfoList is null");
		String followupTaskId = followupMsgSendReq.getFollowupTaskId();
		String followupAssignId = followupMsgSendReq.getFollowupAssignId();
		String templateId = followupMsgSendReq.getTemplateId();
		Integer hospitalId = followupMsgSendReq.getHospitalId();
		Long operator = followupMsgSendReq.getOperator();
		String contentText = followupMsgSendReq.getContent();
		
		List<TFollowupSmsReqInfo> smsReqList = null;
		Map<String,Object> paramsMap = null;
		LinkedHashMap<String, Object> patientMap = null;
		TFollowupTaskPatient followupTaskPatient = null;
		TFollowupSmsReqInfo followupSmsReqInfo = null;
		TFollowupContentTemplateInfo templateInfo = null;
		String url = null;
		String content = null;
		Map<String, Object> paramMap = null;
		TMsgResponse<Object> tMsgResponse = null;
		
		Integer patientCount = patientInfoList.size();
		//本次发送的
		Integer sendCount = 0;
		//重复发送的
		Integer repeatCount = 0;
		//无效联系方式
		Integer failureCount = 0;
		
		Long patientId = null;
		String mobile = null;
		String trueName = null;
		
		List<FollowupPatientInfo> tempFollowupPatientList = null;
		followupMsgSendReq.setPatientInfoList(null);
		for (FollowupPatientInfo followupPatientInfo : patientInfoList) {
			patientId = followupPatientInfo.getPatientId();
			mobile = followupPatientInfo.getMobile();
			trueName = followupPatientInfo.getTrueName();
			
			// 获取要发送的电话
			patientMap = userDao.getValidContactMobile(patientId);
			if (UtilValidate.isNotEmpty(patientMap)) {
				mobile = (String) patientMap.get("mobile");
				trueName = (String) patientMap.get("trueName");
			}
			//无效随访：
			//电话是空
			if(mobile==null||!mobile.startsWith("1")){
				failureCount++;
				continue;
			}
			
			// 查询是否已存在发送短信
			FollowupSmsSendReq sendReq = new FollowupSmsSendReq();
			sendReq.setFollowupTaskId(followupTaskId);
			sendReq.setFollowupTaskAssignId(followupAssignId);
			sendReq.setPatientId(patientId);
			sendReq.setTemplateId(templateId);
			sendReq.setState(1);

			paramsMap=BeanUtils.toMap(sendReq);
			smsReqList = this.followupSmsResultDao.queryFollowupSmsReply(paramsMap);
			if (UtilValidate.isNotEmpty(smsReqList)) {
				repeatCount++;
				LogUtil.log.debug("Sms message already exists:"+paramsMap.toString());
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
				tempFollowupPatientList = new ArrayList<FollowupPatientInfo>();
				tempFollowupPatientList.add(followupPatientInfo);
				followupMsgSendReq.setPatientInfoList(tempFollowupPatientList);
				followupMsgSendReq.setTimerTaskDate(null);
				String param = JsonUtil.toJson(followupMsgSendReq);
				String timeTaskUrl = localUrl + "/timertask/create";
				Timertask timertask = new Timertask();
				timertask.setTaskType(1);
				timertask.setUserId(patientMap.get("userId") + "");
				timertask.setActionType(8);
				timertask.setServiceType(2);
				timertask.setHttpUrl(tobServerUrlRoot + "/followup/do/sms/send");
				timertask.setHttpContent(param);
				timertask.setActionTime(timerTaskDate);
				timertask.setServiceTargetId(GeneralUtil.generatorUUID("sms_temp"));
				LogUtil.log.debug("----------短信定时开始：" + JsonUtil.toJson(timertask));
				tMsgResponse = MyHttpUtil.postJson(timeTaskUrl, timertask);
				LogUtil.log.debug("[短信定时任务调用返回状态]" + tMsgResponse.getRespCode() + "," + tMsgResponse.getRespMsg());
				continue;
			}

			// 创建下发记录
			followupSmsReqInfo = new TFollowupSmsReqInfo();
			followupSmsReqInfo.setFollowupTaskId(followupTaskId);
			followupSmsReqInfo.setFollowupAssignId(followupAssignId);
			followupSmsReqInfo.setTemplateId(templateId);
			followupSmsReqInfo.setHospitalId(hospitalId);
			followupSmsReqInfo.setPatientId(patientId);
			followupSmsReqInfo.setMessageId(GeneralUtil.generatorUUID("SMSMSG"));
			followupSmsReqInfo.setSendTime(new Date());
			followupSmsReqInfo.setTrueName(trueName);
			followupSmsReqInfo.setMobile(mobile);
			followupSmsReqInfo.setResultType(0);
			// 未发送
			followupSmsReqInfo.setState(0);
			if (followupSmsResultDao.insertFollowupSmsReq(followupSmsReqInfo) == 0)
				throw new EmptyObjectExcption(" create followup_sms_followupSmsReqInfo error");
			// 短信消息推送
			try {
				templateInfo = followupContentTemplateInfoService.queryFollowupContentTemplateInfo(templateId);
				url = localUrl + smsFollowupTemplateMessageSendUrl;
				content = getSmsContent(operator,patientId,templateInfo.getSignature(),contentText);
				paramMap = new HashMap<String, Object>();
				paramMap.put("businessId", 1);
				paramMap.put("productId", 1);
				paramMap.put("mobiles", mobile.split(","));
				paramMap.put("content", content);
				paramMap.put("sendBackUrl", tobServerUrlRoot + "/followup/do/sms/send/state/receipt");

				tMsgResponse = MyHttpUtil.postJson(url, paramMap);
				if (tMsgResponse.getRespCode() == 0) {
					// 已发送
					followupSmsReqInfo.setState(1);
				} else {
					followupSmsReqInfo.setState(2);
				}

			} catch (Exception e) {
				LogUtil.logError.error(" send tob followup error error:" + e.getMessage());
				// 发送失败
				followupSmsReqInfo.setState(2);
			}

			if (followupSmsResultDao.updateFollowupSmsReq(followupSmsReqInfo) == 0)
				throw new EmptyObjectExcption(" update followup_sms_followupSmsReqInfo error");

			// 回填随访任务与患者关系短信状态
			followupTaskPatient = new TFollowupTaskPatient();
			followupTaskPatient.setFollowupAssignId(followupAssignId);
			followupTaskPatient.setFollowupTaskId(followupTaskId);
			followupTaskPatient.setPatientId(patientId);
			followupTaskPatient.setSmsReqId(followupSmsReqInfo.getReqId());
			followupTaskPatient.setSmsState(followupSmsReqInfo.getState());
			followupTaskPatientDao.updateFollowupTaskPatient(followupTaskPatient);
			
		}
		FollowupMsgResultRes result = new FollowupMsgResultRes();
		result.setPatientCount(patientCount);
		result.setSendCount(sendCount);
		result.setRepeatCount(repeatCount);
		result.setFailureCount(failureCount);
		return result;
	}
	
	@Override
	public FollowupMsgResultRes sendSmsMassFollowup(FollowupMsgSendReq followupMsgSendReq) {
		int totalCount = 0;
		int sendCount = 0;
		int repeatCount = 0;
		int failureCount = 0;
		List<FollowupPatientInfo> patientInfoList = null;
		FollowupPatientInfo followupPatientInfo=null;
		LinkedHashMap<String, Object> patientMap = null;
		Map<String, Object> paramsMap = null;
		List<TFollowupSmsReqInfo> smsReqList = null;
		FollowupMsgResultRes result = new FollowupMsgResultRes();
		
		String followupAssignId = followupMsgSendReq.getFollowupAssignId();
		String templateId = followupMsgSendReq.getTemplateId();
		String mobile = null;
		String followupTaskId = followupMsgSendReq.getFollowupTaskId();;

		TFollowupTaskPatientListQueryReq taskPatientListQueryReq = followupMsgSendReq.getTaskPatientListQueryReq();
		List<TFollowupPatientInfo> rawList = followupTaskDao.queryFollowupTaskPatientList(taskPatientListQueryReq);
		followupMsgSendReq.setTaskPatientListQueryReq(null);
		if(rawList!=null&&rawList.size()>0&&rawList.get(0)!=null){
			patientInfoList=new ArrayList<FollowupPatientInfo>(); 
			totalCount=rawList.size();
			for (TFollowupPatientInfo rawPatientInfo : rawList) {
				mobile=null;
				patientMap = userDao.getValidContactMobile(rawPatientInfo.getPatientId());
				if (UtilValidate.isNotEmpty(patientMap)) {
					mobile = (String) patientMap.get("mobile");
				}
				//无效随访：
				//电话是空
				if(mobile==null||!mobile.startsWith("1")){
					failureCount++;
					continue;
				}
				FollowupSmsSendReq sendReq = new FollowupSmsSendReq();
				sendReq.setFollowupTaskId(followupTaskId);
				sendReq.setFollowupTaskAssignId(followupAssignId);
				sendReq.setPatientId(rawPatientInfo.getPatientId());
				sendReq.setTemplateId(templateId);
				sendReq.setState(1);

				paramsMap=BeanUtils.toMap(sendReq);
				smsReqList = this.followupSmsResultDao.queryFollowupSmsReply(paramsMap);
				
				if (UtilValidate.isNotEmpty(smsReqList)) {
					repeatCount++;
					LogUtil.log.debug("Sms message already exists:"+paramsMap.toString());
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
				followupPatientInfo.setMobile(mobile);
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
	public Page<TFollowupSmsReqInfo> queryFollowupSmsReply(FollowupSmsSendReq req) {
		req.setReplyState(1);// 只查询已回复
		// 数据筛选
		Map<String,Object> paramsMap=dataAccessFilter.decorteDataAccessParams(req,req.getOperator());
		String sql = organizationDoctorService.getDoctorIdSql(req.getOperator(), null);
		paramsMap.put("sql", sql);
		PageHelper.startPage(req.getPage() + 1, req.getNum());
		List<TFollowupSmsReqInfo> list = followupSmsResultDao.queryFollowupSmsReply(paramsMap);
		return PageUtil.returnPage((com.github.pagehelper.Page<TFollowupSmsReqInfo>) list);
	}

	@Override
	public void processFollowupSmsReply(TFollowupResultDetailInfo followupResultDetailInfo) {
		Date now = new Date();
		// 查询结果表，根据规则选择是否保存到结果表
		//add by fanpanwei 短信解析修改时，不重置回复时间
		if(followupResultDetailInfo.getFollowupResultBySmsFlag()==null
				||followupResultDetailInfo.getFollowupResultBySmsFlag()!=1
				||followupResultDetailInfo.getReplyTime()==null){
			followupResultDetailInfo.setReplyTime(now);
		}
		followupResultDetailInfo = followupResultService.storeRuleFollowupResult(followupResultDetailInfo);

		TFollowupSmsReqInfo followupSmsReqInfo = new TFollowupSmsReqInfo();
		// 更新短信下发相关状态
		if (UtilValidate.isNotEmpty(followupResultDetailInfo.getReqId())) {
			FollowupResultValue metaFollowupResultValue = this.followupMetaInfoDao.getMetaInfoFollowupResultValueById(followupResultDetailInfo.getFollowupResultValue());

			followupSmsReqInfo.setReqId(followupResultDetailInfo.getReqId());
			followupSmsReqInfo.setFollowupResultBuffId(followupResultDetailInfo.getFollowupResultBuffId());
			followupSmsReqInfo.setFollowupResultId(followupResultDetailInfo.getFollowupResultId());
			followupSmsReqInfo.setReplyState(1);// 已回复
			followupSmsReqInfo.setResultProcessState(2);// 标识为手工处理
			followupSmsReqInfo.setReplyTime(followupResultDetailInfo.getReplyTime());
			followupSmsReqInfo.setResultType(metaFollowupResultValue.getType());
			this.followupSmsResultDao.updateFollowupSmsReq(followupSmsReqInfo);
		}
	}

	@Override
	public void setInvalidSmsFollowup(Long reqId) {
		TFollowupSmsReqInfo followupSmsReqInfo = new TFollowupSmsReqInfo();
		followupSmsReqInfo.setReqId(reqId);
		followupSmsReqInfo.setReplyState(1);// 已回复
		followupSmsReqInfo.setResultType(2);// 设置为无效处理结果
		followupSmsReqInfo.setResultProcessState(2);// 标识为手工处理
		followupSmsResultDao.updateFollowupSmsReq(followupSmsReqInfo);
	}

	@Override
	public void modifyUserContactPhoneStatus(TPatientContactInfo patientContactInfo) {
		this.patientDao.updatePatientContactInfo(patientContactInfo);

	}
	
	@Override
	public void replySmsFollowupResult(String fromMobile, String content, String recTime) {
		TFollowupResultDetailInfo followupResultDetailInfo = new TFollowupResultDetailInfo();
		// 根据手机号查询最后一次短信下发请求
		TFollowupSmsReqInfo followupSmsReqInfo = this.followupSmsResultDao.queryFollowupSmsReqByMobileLast(fromMobile);

		if (UtilValidate.isEmpty(followupSmsReqInfo)) {
			LogUtil.log.debug("[手机号]" + fromMobile + "没有在TOB短信随访下发表中。");
			return;
		}
		Date recTimeTypeOfDate=null;
		if (UtilValidate.isNotEmpty(recTime)) {
			recTimeTypeOfDate=DateUtil.stringToDate(recTime, "yyyy-MM-dd HH:mm:ss");
		} else {
			recTimeTypeOfDate=new Date();
		}
		//add by fanpanwei 添加短信回复记录表
		this.addSmsReplyRecord(followupSmsReqInfo.getReqId(), fromMobile, content, recTimeTypeOfDate);
		
		//add by fanpanwei 本次随访任务已经收到患者短信时，这次任务中之后的收到的短信不再解析
		Map<String, Object> searchParams = new HashMap<String, Object>();
		searchParams.put("followupTaskId", followupSmsReqInfo.getFollowupTaskId());
		searchParams.put("followupAssignId", followupSmsReqInfo.getFollowupAssignId());
		searchParams.put("patientId", followupSmsReqInfo.getPatientId());
		searchParams.put("followupWay", 1);
		List<TFollowupResultDetailInfo> followupResultBuffDetailList = followupResultDao.queryFollowupResultBuff(searchParams);
		if(followupResultBuffDetailList!=null&&followupResultBuffDetailList.size()>0&&followupResultBuffDetailList.get(0)!=null){
			return;
		}
		
		// 解析短信回复结果
		TFollowupReplyParseRulesInfo rulesInfo = followupReplyParseRulesInfoService.queryTFollowupReplyByReplyContent(content);
		if (UtilValidate.isNotEmpty(rulesInfo)) {
			followupResultDetailInfo.setFollowupResultValue(rulesInfo.getFollowupResultValueId());
			FollowupResultValue metaFollowupResultValue = this.followupMetaInfoDao.getMetaInfoFollowupResultValueById(rulesInfo.getFollowupResultValueId());
			followupSmsReqInfo.setResultProcessState(1);// 标识为自动处理
			followupSmsReqInfo.setResultType(metaFollowupResultValue.getType());
		}
		// 调用入库规则
		followupResultDetailInfo.setFollowupAssignId(followupSmsReqInfo.getFollowupAssignId());
		followupResultDetailInfo.setFollowupTaskId(followupSmsReqInfo.getFollowupTaskId());
		followupResultDetailInfo.setPatientId(followupSmsReqInfo.getPatientId());
		followupResultDetailInfo.setFollowupWay(Constant.FOLLOWUPWAY.FOLLOWUPWAY_SMS);
		followupResultDetailInfo.setFollowupResultPhone(fromMobile);
		followupResultDetailInfo.setReplyContent(content);
		followupResultDetailInfo.setReplyTime(new Date());
		followupResultDetailInfo.setSendTime(followupSmsReqInfo.getSendTime());
		followupResultDetailInfo.setFollowupTime(followupSmsReqInfo.getSendTime());
		
		try {
			followupResultDetailInfo = this.followupResultService.storeRuleFollowupResult(followupResultDetailInfo);
		} catch (EmptyParamExcption e) {
			LogUtil.log.error("[按规则保存随访结果时参数不能为空]" + e.getMessage());
		}

		// 更新短信下发请求表
		followupSmsReqInfo.setFollowupResultBuffId(followupResultDetailInfo.getFollowupResultBuffId());
		followupSmsReqInfo.setFollowupResultId(followupResultDetailInfo.getFollowupResultId());
		followupSmsReqInfo.setReplyState(1);// 已回复

		followupSmsReqInfo.setReplyTime(recTimeTypeOfDate);
		followupSmsReqInfo.setReplyContent(content);
		this.followupSmsResultDao.updateFollowupSmsReq(followupSmsReqInfo);

		// 回复患者
		this.sendReplyNoticeToPatient(fromMobile,followupSmsReqInfo);
	}

	@Override
	public void replySmsFollowupResult(Map<String, Object> smsItemMap) {
		String fromMobile = (String) smsItemMap.get("fromMobile");
		String content = (String) smsItemMap.get("content");
		String recTime = (String) smsItemMap.get("recTime");

		this.replySmsFollowupResult(fromMobile, content, recTime);
	}

	@Override
	public void receiptSmsSendState(List<SmsSendReportInfo> smsSendReportInfoList) {
		TFollowupSmsReqInfo followupSmsReqInfo = null;

		for (SmsSendReportInfo smsSendReportInfo : smsSendReportInfoList) {
			LogUtil.log.debug("【短信状态回执手机号】" + smsSendReportInfo.getMobile());
			followupSmsReqInfo = this.followupSmsResultDao.queryFollowupSmsReqByMobileLast(smsSendReportInfo.getMobile());
			if (smsSendReportInfo.getStatus() == 0) {// 成功
				followupSmsReqInfo.setState(3);
			} else {
				followupSmsReqInfo.setState(2);
			}
			this.followupSmsResultDao.updateFollowupSmsReq(followupSmsReqInfo);
		}
	}

	// public Map<String, Object> processSendMobile(Long patientId) {
	// Map<String, Object> resultMap = null;
	// // 获取要发送的电话
	// List<LinkedHashMap<String, Object>> patientMapList =
	// userDao.getValidContactMobile(patientId);
	// if (UtilValidate.isNotEmpty(patientMapList)) {
	// resultMap = patientMapList.get(0);
	// saveFollowupSmsSendCount(resultMap);
	// patientMapList.remove(resultMap);
	//
	// for (LinkedHashMap<String, Object> patientMap : patientMapList) {
	// saveFollowupSmsSendCount(patientMap);
	// }
	// }
	// return resultMap;
	// }
	//
	// public void saveFollowupSmsSendCount(Map<String, Object> searchParams) {
	// TFollowupSmsSendCountInfo info =
	// followupSmsSendCountService.getFollowupSmsSendCount(searchParams);
	// if (UtilValidate.isEmpty(info)) {
	// info = new TFollowupSmsSendCountInfo();
	// info.setPatientFamilyId((Long) searchParams.get("patientFamilyId"));
	// info.setPatientId((Long) searchParams.get("patientId"));
	// info.setMobile((String) searchParams.get("mobile"));
	// info.setCurrSendCount(1);
	// this.followupSmsSendCountService.insertFollowupSmsSendCount(info);
	// } else {
	// info.setCurrSendCount(1);
	// this.followupSmsSendCountService.updateFollowupSmsSendCount(info);
	// }
	// }
	
	@Deprecated
	private String getSmsContent(Long patientId,String signature,String content){
		String result=signature+content;
		TFollowupGlobalConfigInfo globalConfig = followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
		Integer flag=globalConfig.getSmsTemplateShowPatientNameFlag();
		LinkedHashMap<String,Object> userMap=userDao.queryUserInfoByPatientId(patientId);
		String trueName=(String)userMap.get("trueName");
		if(flag==1 && UtilValidate.isNotEmpty(trueName)){
			result=signature+trueName+content;
		}
		return result;
	}
	
	private String getSmsContent(Long operator,Long patientId,String signature,String content){
		String patientTrueNameDef="{患者姓名}";
		String operatorMobileDef="{随访人员电话}";
		LinkedHashMap<String,Object> userMap=userDao.queryUserInfoByPatientId(patientId);
		String trueName=(String)userMap.get("trueName");
		if(content.indexOf(patientTrueNameDef)!=-1 && UtilValidate.isNotEmpty(trueName)){
			content=content.replace("{患者姓名}", trueName);
		}
		
		Doctor doctor = doctorDao.getDoctorById(operator);
		if(content.indexOf(operatorMobileDef)!=-1 && UtilValidate.isNotEmpty(doctor)){
			TFollowupLocalProfile localProfile=followupLocalProfileDao.queryFollowupLocalProfile(doctor.getUserId());
			content=content.replace("{随访人员电话}", localProfile.getLocalPhoneNumber());
		}
		return signature+content;
	}

	public static void main(String args[]){
		String content="{患者姓名},亲爱的患者朋友{患者姓名}，医生({随访人员电话})十分关心您出院后的康复情况，望您能够配合反馈病情：稳定回复1；复发回复2；转移回复3；其他情况回复4。您的反馈将有助于医生为您制定后续治疗方案，谢谢配合！";
		
		String patientTrueNameDef="{患者姓名}";
		String operatorMobileDef="{随访人员电话}";
		String trueName="张三";
		String signature="【重庆医院】";
		
		if(content.indexOf(patientTrueNameDef)!=-1 && UtilValidate.isNotEmpty(trueName)){
			content=content.replace("{患者姓名}", trueName);
		}
		content=content.replace("{随访人员电话}", "132123456");
		
		System.out.println(signature+content);
	}
	
	
	public List<HashMap<String,String>> queryFollowupSmsRecord(FollowupSmsSendReq req){
		return followupSmsResultDao.getFollowupSmsRecord(req);
	}
	//add by fanpanwei 系统收到患者短信回复时，再向患者发送一条收到回复的通知短信
	private void sendReplyNoticeToPatient(String fromMobile,TFollowupSmsReqInfo followupSmsReqInfo){
		if (followupSmsReqInfo.getNeedReply() == 1) {
			String url = localUrl + smsFollowupTemplateMessageSendUrl;
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("businessId", 1);
			paramMap.put("productId", 1);
			paramMap.put("mobiles", fromMobile.split(","));
			paramMap.put("content", followupSmsReqInfo.getSignature() + followupSmsReqInfo.getAutoReplyContent());
			MyHttpUtil.postJson(url, paramMap);
		}
	}
	
	//add by fanpanwei 添加短信回复记录
	private void addSmsReplyRecord(Long reqId,String fromMobile,String content,Date replyDate){
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("reqId", reqId);
		hm.put("mobile", fromMobile);
		hm.put("replyContent", content);
		hm.put("replyTime", replyDate);
		this.followupSmsResultDao.addFollowupSmsReplyRecord(hm);
	}
	
	public HashMap<String,Object> queryFollowupBuffBySms(TFollowupSmsReqInfo followupSmsReqInfo){
		return followupSmsResultDao.getFollowupBuffBySms(followupSmsReqInfo);
	}
}
