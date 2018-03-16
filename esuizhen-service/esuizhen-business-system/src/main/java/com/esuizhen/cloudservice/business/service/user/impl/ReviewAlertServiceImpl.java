/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.service.user.impl;<br/>  
 * <b>文件名：</b>ReviewAlertServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年8月23日下午4:03:25<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.service.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.business.bean.DoctorClinicUsageSetReq;
import com.esuizhen.cloudservice.business.bean.ReviewAlertDetailGetReq;
import com.esuizhen.cloudservice.business.bean.ReviewAlertDetailSetReq;
import com.esuizhen.cloudservice.business.bean.ReviewAlertPatientListGetReq;
import com.esuizhen.cloudservice.business.bean.ReviewAlertStatisReq;
import com.esuizhen.cloudservice.business.bean.ReviewAlertToPatientSendReq;
import com.esuizhen.cloudservice.business.dao.business.BusinessSendDao;
import com.esuizhen.cloudservice.business.dao.business.DoctorDao;
import com.esuizhen.cloudservice.business.dao.business.ProductApplyDao;
import com.esuizhen.cloudservice.business.dao.business.ReviewAlertDao;
import com.esuizhen.cloudservice.business.dao.business.UserDao;
import com.esuizhen.cloudservice.business.model.business.ProductServiceApply;
import com.esuizhen.cloudservice.business.model.business.TReviewAlertDetailInfo;
import com.esuizhen.cloudservice.business.model.business.TReviewAlertStatisInfo;
import com.esuizhen.cloudservice.business.service.business.ProductApplyService;
import com.esuizhen.cloudservice.business.service.user.ReviewAlertService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.DoctorSimpleInfo;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.message.structuration.TBottomInfo;
import com.westangel.common.bean.message.structuration.TButtonMsg;
import com.westangel.common.bean.message.structuration.TStructuredMsg;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.sms.SmsTemplateSendReq;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.service.MessageInnerService;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.service.SmsInnerService;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.ImMessageUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;
import com.westangel.common.util.PushContentUtil;
import com.westangel.common.util.PushUtil;
import com.westangel.common.util.SmsUtil;

/** 
* @ClassName: ReviewAlertServiceImpl
* @Description: 
* @author lichenghao
* @date 2017年8月23日 下午4:03:25  
*/
@Service
public class ReviewAlertServiceImpl implements ReviewAlertService {
	@Value("${server.wx.service.url.root}")
	private String wxRootUrl;
	@Value("${default.doctor.man.userPictureUrl}")
	private String manUrl;
	@Value("${default.doctor.wonman.userPictureUrl}")
	private String womanUrl;
	
	@Value("${event.api.url.root}")
	private String eventUrl;
	@Value("${url.to.review.alert.patient.list}")
	private String toPatientReviewAlertList;
	
	@Value("${server.h5.url.root}")
	private String wxH5Url;
	@Value("${url.api.business.to.text.consulting}")
	private String richTextUrl; 
	@Value("${url.api.business.to.appointmentreview}")
	private String reviewAlertUrl;
	@Value("${server.ehr.query.path}")
	private String ehrPath;
	@Value("${server.questionnaire.write.path}")
	private String questionnaireWrite;
	@Value("${wx.h5.hospital.service.appoint.detail}")
	private String appointDetailUrl;
	@Autowired
	private MessageInnerService messageService;
	@Autowired
	private PushInnerService pushInnerService;
	@Autowired
	private SmsInnerService smsService;
	@Autowired
	private ProductApplyService productApplyService;
	
	@Autowired
	private ReviewAlertDao reviewAlertDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private BusinessSendDao businessSendDao;
	@Autowired
	private ProductApplyDao productApplyDao;
	
	@Override
	public void sendReviewAlertToDoctor() {
		//存储过程调用
		LogUtil.log.info("-------call review alert pro--------");
		reviewAlertDao.callProReviewAlert();
		List<LinkedHashMap> list = reviewAlertDao.queryNotSendReviewAlert();
		if(list==null||list.isEmpty())
			return;
		String linkUrl = eventUrl+toPatientReviewAlertList+"?reqFlag=0&reviewBatchId=";
		for(HashMap<String, Object> map:list){
			try {
				//发送给医生提醒消息
				TStructuredMsg<TButtonMsg>  struMsg = getMsg((String)map.get("content"),
						"点击查看",linkUrl+map.get("reviewBatchId")+"&titleName="+map.get("titleName"));
				//版本大于3.6.4有点击查看按钮
				Integer flag = userDao.compareAppVersion("3.6.4", (Long)map.get("userId"));
				if(flag==null||flag<1)
					struMsg.getMsgBody().setBottom(null);
				messageService.sendInnerMessage(
						ImMessageUtil.getEDoctorAssistCustomMessage((Long)map.get("userId"), JsonUtil.toJson(struMsg), null));
				//更新推送状态
				reviewAlertDao.updateReviewAlertSend(map);
			} catch (Exception e) {
				LogUtil.log.error("send review alert to doctor error.reviewBatchId:{},doctorId:{}",map.get("reviewBatchId"),map.get("doctorId"));
			}
		}
	}
	
	//获取消息
	private TStructuredMsg getMsg(String description,String bottomText,String bottomUrl){
		TStructuredMsg<TButtonMsg>  struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		TBottomInfo bottom = new TBottomInfo();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		buttonMsg.setBottom(bottom);
		buttonMsg.setDescription(description);
		bottom.setText(bottomText);
		bottom.setUrl(bottomUrl);
		return struMsg;
	}
	
	@Override
	public Page<TReviewAlertDetailInfo> getReviewAlertPatientList(ReviewAlertPatientListGetReq req) {
		//如果参数错误
		if(req==null||(StringUtils.isEmpty(req.getReviewBatchId())&&req.getDoctorId()==null)){
			throw new EmptyParamExcption("param error,req:"+JsonUtil.toJson(req));
		}
		if(req.getDomainFlag()==null){
			req.setDomainFlag(1);
		}
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("reviewBatchId", req.getReviewBatchId());
		params.put("confirmFlag", req.getReqFlag());
		params.put("manUrl", wxRootUrl+manUrl);
		params.put("wonmanUrl", wxRootUrl+womanUrl);
		params.put("defaultContent", pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.wx.patient.review.alert.default.content",null)));
		Long doctorId = req.getDoctorId();
		if(doctorId==null){
			Map batchMap = reviewAlertDao.queryreviewDetail(req.getReviewBatchId());
			if(batchMap!=null)
				doctorId = (Long)batchMap.get("doctorId");
		}
		params.put("doctorId", doctorId);
		params.put("domainFlag", req.getDomainFlag());
		List<TReviewAlertDetailInfo> list = null;
		PageHelper.startPage(req.getPage()+1,req.getNum());
		//废弃
		//list = reviewAlertDao.queryReviewAlertPatientListByBatchId(params);
		if(req.getReqFlag()==0){//待提醒患者
			int i = req.getDomainFlag();
			if(i>0)
				list = reviewAlertDao.queryWaitPatientList(params);
			if(i<0){
				params.put("defaultContent", pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.wx.patient.review.alert.default.expir.content",null)));
				list = reviewAlertDao.queryExpirPatientList(params);
			}
		}else{
			params.put("reqFlag",req.getReqFlag());
			list = reviewAlertDao.queryProductApplyReviewAlert(params);
		}
		return PageUtil.returnPage((com.github.pagehelper.Page<TReviewAlertDetailInfo>)list);
	}

	@Override
	public void setReviewAlertSet(ReviewAlertDetailSetReq req) {
		if(req==null||StringUtils.isEmpty(req.getReviewDetailId())&&req.getPatientId()==null)
			throw new EmptyParamExcption("param error,req:"+JsonUtil.toJson(req));
		TReviewAlertDetailInfo detailInfo = reviewAlertDao.queryReviewBatchDetailInfo(req);
		if(detailInfo==null){
			Map<String,Object> params = new HashMap<String, Object>();
			String batchId = GeneralUtil.generatorUUID("SRALD");
			params.put("reviewBatchId",batchId);
			params.put("doctorId", req.getDoctorId());
			params.put("followupItemId", req.getReviewDetailId());
			reviewAlertDao.initNotInReviewAlert(params);
			req.setReviewBatchId(batchId);
			String detailId = req.getReviewDetailId();
			req.setReviewDetailId(null);
			detailInfo = reviewAlertDao.queryReviewBatchDetailInfo(req);
			if(detailInfo!=null){
				detailId = detailInfo.getReviewDetailId();
			}
			req.setReviewDetailId(detailId);
		}
		if(detailInfo==null)
			throw new EmptyObjectExcption("review alert detail not found,reviewDetailId="+req.getReviewDetailId()+",patientId="+req.getPatientId());
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("reviewDetailId", req.getReviewDetailId());
		params.put("patientId", req.getPatientId());
		if(req.getConfirmFlag()!=null){//同意拒绝流程
			if(req.getConfirmFlag()==-1){//拒绝
				params.put("state", 4);
				params.put("cause", req.getCause());
			}else{//同意
				params.put("state", 3);
			}
			try{
				this.acceptProductServer(req.getReviewDetailId(),req.getConfirmFlag(),req.getCause());
			}catch(Exception e){
				LogUtil.logError.error("accept error,params:{}",JsonUtil.toJson(req));
			}
		}else{
			params.put("updateFlag", 1);//已修改
			params.put("alertContent", req.getAlertContent());
			params.put("alertTime", req.getAlertTime());
		}
		reviewAlertDao.updateReviewAlertDetail(params);
	}
	
	//处理服务并发送消息给患者
	private void acceptProductServer(String reviewDetailId, Integer confirmFlag,String cause) {
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("reviewDetailId",reviewDetailId);
		TReviewAlertDetailInfo info = reviewAlertDao.queryReviewBatchDetailInfo(params);
		Integer acceptFlag = confirmFlag==1?2:3;
		Date date = null;
		if(StringUtils.isNotEmpty(info.getAffirmTime())&&acceptFlag==2){
			date = DateUtil.stringToDate(info.getAffirmTime().replace("上午", "").replace("下午", "").replace("晚上", ""), "yyyy-MM-dd");
		}
		//更新服务状态
		productApplyService.setAcceptProduct(info.getProductApplyId(),acceptFlag,date);
		//更新原因
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("productApplyId", info.getProductApplyId());
		param.put("cause", cause);
		params.put("auditState", confirmFlag==2?1:3);
		{
			ProductServiceApply psa = productApplyDao.getProductServiceApplyInfo(info.getProductApplyId());
			if(StringUtils.isNotEmpty(psa.getDescription())){//将原因时间医生信息写入
				Map<String,Object> appoint = JsonUtil.toObject(psa.getDescription(), HashMap.class);
				appoint.put("refuse", cause);
				appoint.put("orderTime",info.getAffirmTime());
				appoint.put("doctorName",info.getDoctorName());
				appoint.put("appiontDept",info.getDeptName());
				params.put("description", JsonUtil.toJson(appoint));
			}
		}
		productApplyDao.modifyProductServiceApplyProgressState(param);
		//发送消息给患者
		DoctorSimpleInfo doctorInfo = doctorDao.queryDoctorSimpleInfo(info.getDoctorId(),null);
		//消息发送
		List<LinkedHashMap> list = reviewAlertDao.queryReviewAlertSendPatientList(params);
		Map<String,Object> map = list.get(0);
		List<String> values = new ArrayList<String>();
		List<String> smsList = new ArrayList<String>();
		String first="";
		String remark="";
		String smsName=null;
		//判断并推送
		if(confirmFlag==-1){
			first = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.wx.patient.review.alert.refuse.first"));
			remark = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.wx.patient.review.alert.refuse.remark",cause));
			smsList.add(cause);
			smsName="YuYueFuChaShiBai";
		}else{
			first = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.wx.patient.review.alert.agree.first"));
			remark = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.wx.patient.review.alert.agree.remark",
					doctorInfo.getHospitalName(),doctorInfo.getDeptName(),doctorInfo.getTrueName(),info.getAffirmTime()));
			smsList.add(doctorInfo.getHospitalName());
			smsList.add(doctorInfo.getDeptName());
			smsList.add(doctorInfo.getTrueName());
			smsList.add(info.getAffirmTime());
			smsName="YuYueFuChaChengGong";
		}
		values.add(first);
		values.add(doctorInfo.getTrueName());
		values.add(info.getAffirmTime());
		values.add(remark);
		String url = wxH5Url+appointDetailUrl+"?productApplyId="+info.getProductApplyId();
		PushNotifyInfo pushInfo = PushUtil.getWxTemplatePushNotifyInfo("jiuyitixing", url, values);
		pushInfo.setUserId((Long)map.get("patientUserId"));
		pushInfo.setProductId((Integer)map.get("productId"));
		//推送
		pushInnerService.push(pushInfo);
		//短信
		if(map.get("mobile")!=null){
			SmsTemplateSendReq smsReq = SmsUtil.getSmsTemplateSendReq(smsName, (String)map.get("mobile"), smsList);
			try{
				smsService.sendTemplate(smsReq);
			}catch(Exception e){
				LogUtil.logError.error("review alert send sms error,msg{}",e.getMessage());
			}
		}
	}

	@Override
	public void sendReviewAlertToPatient(ReviewAlertToPatientSendReq req) {
		if(req.getDoctorId()==null||(StringUtils.isEmpty(req.getReviewBatchId())&&req.getReviewDetailList()==null))
			throw new EmptyParamExcption("param error,req:"+JsonUtil.toJson(req));
		//未入复查预约表列表
		List<LinkedHashMap> rList = null;
		//筛选发送内容为随访计划详情，并重新生成提醒批次内容
		Map<String, Object> params = new HashMap<String, Object>();
		if(StringUtils.isEmpty(req.getReviewBatchId())){
			params.put("reviewBatchId",GeneralUtil.generatorUUID("SRALD"));
			params.put("doctorId", req.getDoctorId());
			params.put("reviewDetailList", req.getReviewDetailList());
			//初始化为进入复查提醒详情中的信息
			reviewAlertDao.initNotInReviewAlert(params);
			params.remove("reviewDetailList");
			params.put("confirmFlag", 0);
			params.put("defaultContent", pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.wx.patient.review.alert.default.content",null)));
			rList = reviewAlertDao.queryReviewAlertSendPatientList(params);
		}
		//获取列表
		params.put("reviewBatchId", req.getReviewBatchId());
		params.put("reviewDetailList", req.getReviewDetailList());
		params.put("confirmFlag", 0);
		params.put("defaultContent", pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.wx.patient.review.alert.default.content",null)));
		List<LinkedHashMap> list = reviewAlertDao.queryReviewAlertSendPatientList(params);
		if(list!=null&&rList!=null){
			list.addAll(rList);
		}else if(rList!=null){
			list = rList;
		}
		if(list==null||list.isEmpty())//判断发送列表不为空
			throw new EmptyObjectExcption("review alert list is null,req:"+JsonUtil.toJson(req));
		DoctorSimpleInfo doctorInfo = doctorDao.queryDoctorSimpleInfo(req.getDoctorId(),null);
		if(doctorInfo==null)//判断医生不为空
			throw new EmptyObjectExcption("doctor info is null,doctorId:"+req.getDoctorId());
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("hospitalId", doctorInfo.getHospitalId());
		param.put("productType", Constant.Business.PRODUCT_TYPE_REVIEW_APPOINTMENT);
		List<LinkedHashMap<String, Object>> productInfos = businessSendDao.getProductIdByHospitalId(param);
		boolean isHospital=true;
		if(productInfos==null||productInfos.isEmpty())
			isHospital=false;
		//内容准备
		String first = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.review.alert.notify", new Object[] {doctorInfo.getTrueName()}));
		String remark="";
		String url = "";
		if(isHospital){
			url = wxH5Url+reviewAlertUrl+"?hospitalId="+doctorInfo.getHospitalId()+"&hospitalUserId="+productInfos.get(0).get("vendor");
			remark = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.review.alert.to.appoint.notify.remark"));
		}else{
			url = wxH5Url+richTextUrl+"?doctorId="+doctorInfo.getDoctorId()+"&userId="+doctorInfo.getUserId();
			remark=pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.review.alert.notify.remark"));
		}
		//写入参数
		param.clear();
		param.put("first", first);
		param.put("remark", remark);
		param.put("url", url);
		param.put("doctorName", doctorInfo.getTrueName());
		final Map<String,Object> otherMap = param;
		//判断线程开启数
		int pSize = list.size()>3?3:list.size();
		//开启线程处理
		ExecutorService exec = Executors.newFixedThreadPool(pSize);
		final CountDownLatch doneSignal = new CountDownLatch(list.size());
		//循环推送
		for(final Map map:list){
			Runnable run = new Runnable() {
				@Override
				public void run() {
					try{
						sendAlertToPatient(map,otherMap);
					}catch(Exception e){
						LogUtil.log.error("send alert error,msg{}",e.getMessage());
					}
					doneSignal.countDown();
				}
			};
			exec.submit(run);
		}
		try {
			doneSignal.await();
		} catch (InterruptedException e) {
			LogUtil.log.error("send alert error,msg:{}",e.getMessage());
		}finally {
			exec.shutdown();
			LogUtil.log.info("alert send end,send size:{}",list.size());
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void sendAlertToPatient(Map detailInfo,Map otherInfo){
		List pushList = new ArrayList();
		pushList.add(otherInfo.get("first"));
		pushList.add(detailInfo.get("trueName"));
		pushList.add(DateUtil.getDateStr((Date)detailInfo.get("alertTime")));
		pushList.add(detailInfo.get("alertItem"));
		pushList.add(detailInfo.get("alertContent"));
		pushList.add(otherInfo.get("remark"));
		String url = (String)otherInfo.get("url");
		url+="&reviewDetailId="+detailInfo.get("reviewDetailId");
		//微信发送
		PushNotifyInfo info = PushUtil.getWxTemplatePushNotifyInfo("fuchatixing", url, pushList);
		info.setUserId((Long)detailInfo.get("patientUserId"));
		info.setProductId((Integer)detailInfo.get("productId"));
		try{
			pushInnerService.push(info);
		}catch(Exception e){
			LogUtil.logError.error("review alert send push error,msg{}",e.getMessage());
		}
		//短信发送
		if(StringUtils.isNotEmpty((String)detailInfo.get("mobile"))){
			pushList.clear();
			pushList.add(otherInfo.get("doctorName"));
			pushList.add(detailInfo.get("alertTime"));
			pushList.add(detailInfo.get("alertItem"));
			SmsTemplateSendReq smsReq = SmsUtil.getSmsTemplateSendReq("FuChaTiXing", null, pushList);
			smsReq.setMobile((String)detailInfo.get("mobile"));
			try{
				smsService.sendTemplate(smsReq);
			}catch(Exception e){
				LogUtil.logError.error("review alert send sms error,msg{}",e.getMessage());
			}
		}
		//预约方式
		
		//修改发送状态
		reviewAlertDao.updateReviewAlertDetailSend(detailInfo);
		String reviewDetailId = (String)detailInfo.get("reviewDetailId");
		Integer state = (Integer)detailInfo.get("state");
		//如果不是已发送 变为已发送
		if(state<1)
			state=1;
		detailInfo.clear();
		detailInfo.put("reviewDetailId", reviewDetailId);
		detailInfo.put("state", state);
		detailInfo.put("sendTime", new Date());
		reviewAlertDao.updateReviewAlertDetail(detailInfo);
	}

	@Override
	public TReviewAlertDetailInfo getReviewAlertGet(ReviewAlertDetailGetReq req) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(req.getReviewDetailId())||req.getPatientId()==null)
			throw new EmptyParamExcption("params error,params:"+JsonUtil.toJson(req));
		TReviewAlertDetailInfo detailInfo = reviewAlertDao.queryReviewBatchDetailInfo(req);
		if(detailInfo==null)
			throw new EmptyObjectExcption("get review detail is null,req="+JsonUtil.toJson(req));
		return detailInfo;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :updateReviewDetail
	 * @Description:更新复查提醒状态
	 * @return void
	 * @date 2017年8月29日 下午3:52:20
	 */
	@Override
	public void updateReviewDetail(ProductServiceApply psa, String countClinicDateAndClinicTime,
			String reviewDetailId) {
		Map<String,Object> params = new HashMap<String, Object>();
		if(psa.getState()<2){
			params.put("productApplyId", psa.getProductApplyId());
			params.put("affirmTime", countClinicDateAndClinicTime);
			params.put("reviewDetailId", reviewDetailId);
			params.put("confirmFlag", 1);
			params.put("state",2);
			reviewAlertDao.updateReviewAlertDetail(params);
			sendToDoctorMsage(reviewDetailId);
		}else{
			if(psa.getState()==2||psa.getState()==3){
				params.put("reviewDetailId", reviewDetailId);
				if(psa.getState()==2){
					params.put("state", 3);
				}else{
					params.put("state", 4);
				}
				reviewAlertDao.updateReviewAlertDetail(params);
			}
		}
	}
	//发送消息给医生
	private void sendToDoctorMsage(String reviewDetailId) {
		Map map = reviewAlertDao.querySendInfoByReviewDetailId(reviewDetailId);
				String linkUrl = eventUrl+toPatientReviewAlertList+"?reqFlag=1&reviewBatchId=";	
		TStructuredMsg<TButtonMsg>  struMsg = getMsg((String)map.get("content"),
				"点击查看",linkUrl+map.get("reviewBatchId")+"&titleName="+map.get("titleName"));
		//版本大于3.6.4有点击查看按钮
		Integer flag = userDao.compareAppVersion("3.6.4", (Long)map.get("userId"));
		if(flag==null||flag<1)
			struMsg.getMsgBody().setBottom(null);
		messageService.sendInnerMessage(
				ImMessageUtil.getEDoctorAssistCustomMessage((Long)map.get("userId"), JsonUtil.toJson(struMsg), null));
	}

	@Override
	public void scanningFollowupPlanSend() {
		// TODO Auto-generated method stub
		//开启线程处理
		ExecutorService exec = Executors.newFixedThreadPool(1);
		Runnable run = new Runnable() {
			@Override
			public void run() {
				try{
					//更新随访计划状态
					reviewAlertDao.callProFollowupPlanUpdate();
					boolean flag = true;
					//问卷相关文案
					String qkey3 = null;
					//复查相关文案
					String alterfirst=null;
					String alter4 = null;
					String alertremark = null;
					String alertremark2= null;
					String remark=null;
					//循环获取发送
					while (flag) {
						List<LinkedHashMap> list = reviewAlertDao.queryFollowupPlanNotSend();
						if(list==null||list.size()==0){
							flag=false;
							break;
						}
						String ehrUrl=wxH5Url+ehrPath;
						String questionUrl=wxH5Url+questionnaireWrite;
						String appointUrl=wxH5Url+reviewAlertUrl;
						String pushUrl = null;
						Integer actionType=null;
						String wxTemplateName=null;
						//问卷相关文案
						if(qkey3==null)
							qkey3 = pushInnerService
								.getMessage(PushContentUtil.getFollowupPushContent(null, "followup.plan.questionnaire.keyword.3"));
						//复查相关文案
						if(alterfirst==null)
							alterfirst = pushInnerService
								.getMessage(PushContentUtil.getFollowupPushContent(null, "followup.plan.checkinfo.first","易随诊"));
						if(alter4==null)
							alter4 = pushInnerService
								.getMessage(PushContentUtil.getFollowupPushContent(null, "followup.plan.checkinfo.keyword.4"));
						if(alertremark==null)
							alertremark=pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.review.alert.to.appoint.notify.remark"));
						if(alertremark2==null)
							alertremark2=pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.review.alert.notify.remark"));
						List<String> pushList =new ArrayList<String>();
						for(Map map : list){
							actionType = (Integer)map.get("actionType");
							pushList.clear();
							if(actionType==2){
								wxTemplateName="fuchatixing";
								//地址判断
								if(map.get("hospitalId")!=null){
									pushUrl=appointUrl+"?fromUserName="+map.get("openId")+"&hospitalId="+map.get("hospitalId")+"&hospitalUserId="+map.get("hospitalUserId");
									remark=alertremark;
								}else{
									pushUrl=ehrUrl+"?fromUserName="+map.get("openId");
									remark=alertremark2;
								}
								//组装内容
								pushList.add(alterfirst);
								pushList.add((String)map.get("trueName"));
								pushList.add(DateUtil.getDateStr((Date)map.get("followupDate")));
								pushList.add(map.get("checkItems")+"");
								pushList.add(alter4);
								pushList.add(remark);
							}else if(actionType==3){
								wxTemplateName="suifangtixing";
								pushUrl=questionUrl+"?followupItemId="+map.get("followupItemId")+"&fromUserName="+map.get("openId");
								//组装内容
								pushList.add(pushInnerService.getMessage(PushContentUtil.getFollowupPushContent(null,
									"followup.plan.questionnaire.first", new Object[] { map.get("followupSource") })));
								pushList.add(map.get("trueName")+"");
								pushList.add(map.get("followupDate")+"");
								pushList.add(qkey3);
								pushList.add(pushInnerService.getMessage(PushContentUtil.getFollowupPushContent(null,
									"followup.plan.questionnaire.remark", new Object[] { map.get("trueName") })));
							}
							PushNotifyInfo pushInfo = PushUtil.getWxTemplatePushNotifyInfo(wxTemplateName, pushUrl, pushList);
							pushInfo.setUserId((Long)map.get("userId"));
							pushInfo.setProductId((Integer)map.get("productId"));
							pushInnerService.push(pushInfo);
							reviewAlertDao.updateFollowupItemSend((String)map.get("followupItemId"));
						}
						if(list.size()<1000)
							flag =false;
					}
				}catch(Exception e){
					LogUtil.log.error("canning followup plan error,msg{}",e.getMessage());
				}
			}
		};
		exec.submit(run);
	}

	@Override
	public TReviewAlertStatisInfo getReviewAlertStatis(ReviewAlertStatisReq req) {
		// TODO Auto-generated method stub
		if(req.getDoctorId()==null)
			throw new EmptyParamExcption("doctorId is Null");
		if(req.getDomain()==null)//默认设置未来14天
			req.setDomain(1);
		return reviewAlertDao.statisAlertNum(req);
	}

	@Override
	public void createReviewDetail(ProductServiceApply psa, Map<String, Object> map, DoctorClinicUsageSetReq req) {
		// TODO Auto-generated method stub
		if(map.get("reviewDetailId")!=null)
			return;
		Map params = new HashMap<String,Object>();
		params.put("doctorId", map.get("doctorId"));
		params.put("affirmTime", req.getClinicDate());
		params.put("deptId", map.get("deptId"));
		params.put("patientId",map.get("patientId"));
		params.put("reviewDetailId",GeneralUtil.generatorUUID("RALD"));
		params.put("reviewBatchId", GeneralUtil.generatorUUID("RALB"));
		
//		TReviewAlertDetailInfo info = new TReviewAlertDetailInfo();
//		info.setAffirmTime(req.getClinicDate());
//		info.setDoctorId(map.get("doctorId")!=null?Long.parseLong(map.get("doctorId")+""):null);
//		info.setDeptId(map.get("deptId")!=null?Integer.parseInt(map.get("deptId")+""):null);
//		info.setPatientId(Math.round((Double)map.get("patientId")));
//		info.setReviewDetailId(GeneralUtil.generatorUUID("RALD"));
//		info.setReviewBatchId(GeneralUtil.generatorUUID("RALB"));
		int i = reviewAlertDao.createReviewAlertDetail(params);
		JsonUtil.toJson(params);
		if(i>0)
			this.updateReviewDetail(psa, req.countClinicDateAndClinicTime(), (String)params.get("reviewDetailId"));
	}
}
