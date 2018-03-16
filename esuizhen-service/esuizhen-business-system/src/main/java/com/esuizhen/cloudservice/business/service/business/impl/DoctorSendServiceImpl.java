/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.service.business.impl;<br/>  
 * <b>文件名：</b>DoctorSendServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年9月29日下午2:10:53<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.service.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.esuizhen.cloudservice.business.bean.DoctorSendFollowupNotifyReq;
import com.esuizhen.cloudservice.business.bean.DoctorSendKnowledgeArticleReq;
import com.esuizhen.cloudservice.business.bean.DoctorSendQuestionnarieReq;
import com.esuizhen.cloudservice.business.bean.DoctorSendReviewAlertReq;
import com.esuizhen.cloudservice.business.bean.ReviewAppointInfoGetReq;
import com.esuizhen.cloudservice.business.dao.business.BusinessSendDao;
import com.esuizhen.cloudservice.business.dao.business.DoctorDao;
import com.esuizhen.cloudservice.business.dao.business.UserDao;
import com.esuizhen.cloudservice.business.service.business.DoctorSendService;
import com.westangel.common.bean.DoctorSimpleInfo;
import com.westangel.common.bean.PatientGroup;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.common.bean.message.structuration.TBottomInfo;
import com.westangel.common.bean.message.structuration.TButtonMsg;
import com.westangel.common.bean.message.structuration.TStructuredMsg;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.sms.SmsTemplateSendReq;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.service.MessageInnerService;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.service.SmsInnerService;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.ImMessageUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.PushContentUtil;
import com.westangel.common.util.PushUtil;
import com.westangel.common.util.SmsUtil;

/** 
* @ClassName: DoctorSendServiceImpl
* @Description: 
* @author lichenghao
* @date 2016年9月29日 下午2:10:53  
*/
@Service
public class DoctorSendServiceImpl implements DoctorSendService {
	
	@Autowired
	private PushInnerService pushInnerService;
	@Autowired
	private MessageInnerService messageInnerService;
	@Autowired
	private SmsInnerService smsService;
	@Autowired
	private UserDao userDao;
	@Autowired
	private DoctorDao dao;
	@Autowired
	private BusinessSendDao businessSendDao;
	
	@Value("${server.h5.url.root}")
	private String wxH5Url;
	
	
	@Value("${url.api.business.to.text.consulting}")
	private String richTextUrl; 
	
	@Value("${url.api.business.to.appointmentreview}")
	private String reviewAlertUrl;
	
	@Value("${server.questionnaire.view.path}")
	private String questionnaireListUrl;
	@Value("${server.questionnaire.write.path}")
	private String questionnaireDetailUrl;
	
	@Value("${url.h5.patient.knowledge.artical}")
	private String knowledgeArticleUrl;
	/**
	 * 发送复查提醒
	 */
	@Override
	public void sendDoctorReviewAlert(DoctorSendReviewAlertReq req) {
		// TODO Auto-generated method stub
		if(req.getDoctorUserId()==null)
			throw new EmptyParamExcption("param error doctorUserId is null");
		if(req.getPatientUserIds()==null&&req.getGroups()==null)
			throw new EmptyParamExcption("param error no send object param="+JsonUtil.toJson(req));
		if(StringUtils.isEmpty(req.getReviewContent()))
			throw new EmptyParamExcption("param error reviewContent is null");
		List<Long> patients = new ArrayList<Long>();
		if(req.getPatientUserIds()!=null)
			patients.addAll(req.getPatientUserIds());
		getGroupPatients(req.getGroups(),patients,req.getDoctorUserId());
		if(patients.size()>0){
			sendNotifySendFactory(patients, req, 2);
		}
	}
	
	/**
	 * 发送随访通知
	 */
	@Override
	public void sendDoctorFollowupNotifySend(DoctorSendFollowupNotifyReq req) {
		// TODO Auto-generated method stub
		if(req.getDoctorUserId()==null)
			throw new EmptyParamExcption("param error doctorUserId is null");
		if(req.getPatientUserIds()==null&&req.getGroups()==null)
			throw new EmptyParamExcption("param error no send object param="+JsonUtil.toJson(req));
		if(StringUtils.isEmpty(req.getContent()))
			throw new EmptyParamExcption("param error content is null");
		List<Long> patients = new ArrayList<Long>();
		if(req.getPatientUserIds()!=null)
			patients.addAll(req.getPatientUserIds());
		getGroupPatients(req.getGroups(),patients,req.getDoctorUserId());
		if(patients.size()>0){
			sendNotifySendFactory(patients, req, 1);
		}
	}
	
	/**
	 * 患教知识发送
	 */
	@Override
	@Transactional
	public void sendDoctorKnowledgeArticlet(DoctorSendKnowledgeArticleReq req) {
		// TODO Auto-generated method stub
		if(req.getDoctorUserId()==null)
			throw new EmptyParamExcption("knowledge article send error,param doctorUserId is null");
		if(req.getPatientUserIds()==null&&req.getGroups()==null)
			throw new EmptyParamExcption("knowledge article send error,param patientUserIds is null or groups is null");
		if(StringUtils.isEmpty(req.getArticleId()))
			throw new EmptyParamExcption("knowledge article send error,param article is null");
		//判断疾病知识入患教库
		if(req.getInData()!=null&&req.getInData()==1){
			articletInDoctorKnowledgeData(dao.queryDoctorIdByDoctorUserId(req.getDoctorUserId()),req.getArticleId());
		}
		//加载要发送的患者
		List<Long> patients = new ArrayList<Long>();
		if(req.getPatientUserIds()!=null)
			patients.addAll(req.getPatientUserIds());
		getGroupPatients(req.getGroups(),patients,req.getDoctorUserId());
		if(patients.size()>0){
			sendNotifySendFactory(patients, req, 3);
		}
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :articletInDoctorKnowledgeData
	 * @Description:患教知识入库
	 * @return void
	 * @date 2016年9月29日 下午2:55:30
	 */
	private void articletInDoctorKnowledgeData(Long doctorId,String articleId){
		if(doctorId==null)
			throw new EmptyParamExcption("in doctor knowledge article error,param doctorId is null");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("articleId", articleId);
		param.put("doctorId", doctorId);
		businessSendDao.createDoctorKnowledgeArticle(param);
	}
	
	/**
	 * 问卷发送
	 */
	@Override
	public void sendDoctorQuestionnaire(DoctorSendQuestionnarieReq req) {
		// TODO Auto-generated method stub
		if (req.getDoctorUserId() == null)
			throw new EmptyParamExcption("questionnarie send error,param doctorUserId is null");
		if (req.getPatientUserIds() == null && req.getGroups() == null)
			throw new EmptyParamExcption("questionnarie send error,param patientUserIds is null or groups is null");
		if (StringUtils.isEmpty(req.getQuestionnaireId()))
			throw new EmptyParamExcption("questionnarieId article send error,param article is null");
		// 加载要发送的患者
		List<Long> patients = new ArrayList<Long>();
		if (req.getPatientUserIds() != null)
			patients.addAll(req.getPatientUserIds());
		getGroupPatients(req.getGroups(), patients, req.getDoctorUserId());
		if (patients.size() > 0) {
			sendNotifySendFactory(patients, req, 4);
		}
	}
	
	
	
	/**
	 * 获取分组下的患者
	 * @author lichenghao
	 * @title :getGroupPatients
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月26日 下午5:45:38
	 */
	private void getGroupPatients(List<PatientGroup> groups,List<Long> patients,Long doctorUserId){
		if(groups==null||groups.size()==0)
			return;
		if(patients==null)
			patients=new ArrayList<Long>();
		boolean isMdt = false;
		List<String> diseaseGroup = new ArrayList<String>();
		List<String> customGroup = new ArrayList<String>();
		for(PatientGroup group : groups){
			switch (group.getGroupWay()) {
			case 1:
				diseaseGroup.add(group.getGroupNo());
				break;
			case 9:
				isMdt=true;
			case 8:
			case 10:
				customGroup.add(group.getGroupNo());
			default:
				break;
			}
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("doctorUserId", doctorUserId);
		if(isMdt)
			patients.addAll(userDao.queryMdtGroupPatientUserId(param));
		if(diseaseGroup.size()>0){
			param.put("groups", diseaseGroup);
			patients.addAll(userDao.queryDieaseGroupPatientUserId(param));
		}
		if(customGroup.size()>0){
			param.put("groups", customGroup);
			patients.addAll(userDao.queryCustomGroupPatientUserId(param));
		}
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :sendNotifySend
	 * @Description:发送消息
	 * @return void
	 * @date 2016年9月29日 下午2:14:41
	 */
	private void sendNotifySendFactory(final List<Long> patientUserIds,final Object req,final int sendType){
		ExecutorService exec = Executors.newFixedThreadPool(1);
		Runnable run = new Runnable(){
			@Override
			public void run()
			{
				switch (sendType) {
				case 1://随访通知
					sendFollowupNotify(patientUserIds,req);
					break;
				case 2://复查提醒
					sendReviewAlert(patientUserIds, req);
					break;
				case 3://患教知识
					sendKnowledgeArticleNotify(patientUserIds,req);
					break;
				case 4://随访问卷
					sendQuestionNotify(patientUserIds,req);
					break;
				default:
					break;
				}
			}
		};
		exec.execute(run);
	}
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :sendKnowledgeArticleNotify
	 * @Description:发送患教知识消息
	 * @return void
	 * @date 2016年9月29日 下午3:20:44
	 */
	private void sendKnowledgeArticleNotify(List<Long> patientUserIds,Object obj){
		DoctorSendKnowledgeArticleReq req = (DoctorSendKnowledgeArticleReq)obj;
		DoctorSimpleInfo docotInfo = dao.queryDoctorSimpleInfo(null, req.getDoctorUserId());
		if(req.getSendFlag()!=null&&req.getSendFlag()==1){
			String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("im.doctor.send.article.notify"));
			ImMessageInfo info = ImMessageUtil.getSysImMessageTips(0, req.getPatientUserIds().get(0), req.getDoctorUserId(), content);
			messageInnerService.sendInnerMessage(info);
		}
		String templateName="huanjiaotongzhi";
		String url = wxH5Url+knowledgeArticleUrl+"?articleId="+req.getArticleId();
		String first=pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.doctor.send.knowledge.article.first"));
		String remark=pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.doctor.send.knowledge.article.remark"));
		List<String> values = new ArrayList<String>();
		values.add(first);
		values.add(businessSendDao.queryKnowledgeArticleTitle(req.getArticleId()));
		values.add(docotInfo.getTrueName());
		values.add(DateUtil.getDateStr(new Date()));
		values.add(remark);
		PushNotifyInfo pushInfo = PushUtil.getWxTemplatePushNotifyInfo(templateName, url, values);
		for(PatientSimpleInfo patient:getPatientsInfo(patientUserIds)){
			if(patient.getWeixinFlag()!=0){
				pushInfo.setUserId(patient.getUserId());
				pushInfo.setProductId(patient.getWeixinFlag());
				pushInnerService.push(pushInfo);
			}
		}
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :sendQuestionNotify
	 * @Description:发送问卷消息
	 * @return void
	 * @date 2016年9月29日 下午3:20:28
	 */
	private void sendQuestionNotify(List<Long> patientUserIds,Object obj){
		DoctorSendQuestionnarieReq req = (DoctorSendQuestionnarieReq)obj;
		DoctorSimpleInfo docotInfo = dao.queryDoctorSimpleInfo(null, req.getDoctorUserId());
		if(req.getSendFlag()!=null&&req.getSendFlag()==1){
			String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("im.doctor.send.questionnaire"));
			ImMessageInfo info = ImMessageUtil.getSysImMessageTips(0, req.getPatientUserIds().get(0), req.getDoctorUserId(), content);
			messageInnerService.sendInnerMessage(info);
		}
		String templateName="suifangtixing";
		String url = wxH5Url+questionnaireDetailUrl+"?questionnaireId="+req.getQuestionnaireId()+"&followupItemId="+GeneralUtil.generateUniqueID("APPQ");
		String first=pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.doctor.send.questionnaire.first",new Object[]{docotInfo.getTrueName()}));
		String remark=pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.doctor.send.questionnaire.remark"));
		List<String> values = new ArrayList<String>();
		values.add(first);
		values.add(docotInfo.getTrueName());
		values.add(DateUtil.getDateStr(new Date()));
		values.add(businessSendDao.queryQuestionnaireSubject(req.getQuestionnaireId()));
		values.add(remark);
		PushNotifyInfo pushInfo = null;
		//循环发送
		for(PatientSimpleInfo patientInfo:getPatientsInfo(patientUserIds)){
			if(patientInfo.getWeixinFlag()!=0){
				values.remove(1);
				values.add(1,patientInfo.getTrueName());
				pushInfo = PushUtil.getWxTemplatePushNotifyInfo(templateName, url, values);
				pushInfo.setUserId(patientInfo.getUserId());
				pushInfo.setProductId(patientInfo.getWeixinFlag());
				pushInnerService.push(pushInfo);
			}
		}
	}
	
	//获取患者基本信息集合
	@SuppressWarnings("unchecked")
	private List<PatientSimpleInfo> getPatientsInfo(List<Long> patientUserIds){
		//获取患者数据
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("users", patientUserIds);
		return (List<PatientSimpleInfo>)userDao.getPatientInfo(param);
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :sendFollowupNotify
	 * @Description:随访通知发送
	 * @return void
	 * @date 2016年9月29日 下午2:25:42
	 */
	private void sendFollowupNotify(List<Long> patientUserIds,Object obj){
		DoctorSendFollowupNotifyReq req  = (DoctorSendFollowupNotifyReq)obj;
		DoctorSimpleInfo doctorInfo = dao.queryDoctorSimpleInfo(null,req.getDoctorUserId());
		String name = "yizhutuisongtongzhi";
		String url = getToRichTextPage(doctorInfo);
		url+="&remark="+1;
		String remark = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.followup.notify.remark"));
		List<String> values = new ArrayList<String>();
		values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.followup.notify")));
		values.add(doctorInfo.getTrueName()!=null?doctorInfo.getTrueName():"");
		values.add(doctorInfo.getProfessionalRank()!=null?doctorInfo.getProfessionalRank():"");
		values.add(doctorInfo.getHospitalName()!=null?doctorInfo.getHospitalName():"");
		values.add(doctorInfo.getDeptName()!=null?doctorInfo.getDeptName():"");
		if(StringUtils.isEmpty(req.getContent()))
			values.add(req.getContent()+remark);
		else
			values.add(req.getContent()+remark);
		PushNotifyInfo pushInfo = PushUtil.getWxTemplatePushNotifyInfo(name, url, values);
		
		List<String> smsValues = new ArrayList<String>();
		smsValues.add(doctorInfo.getTrueName());
		smsValues.add(req.getContent());
		SmsTemplateSendReq smsReq = SmsUtil.getSmsTemplateSendReq("SuiFangTongZhi", null, smsValues);
		
		//获取患者数据
		List<PatientSimpleInfo> pinfos = getPatientsInfo(patientUserIds);
		if (pinfos != null && pinfos.size() > 0) {
			for (PatientSimpleInfo pinfo : pinfos) {
				// 如果开通微信
				if (pinfo.getWeixinFlag()!=0) {
					pushInfo.setUserId(pinfo.getUserId());
					pushInfo.setProductId(pinfo.getWeixinFlag());
					pushInnerService.push(pushInfo);
				}
				// 如果有手机号
				if (!StringUtils.isEmpty(pinfo.getMobile())) {
					smsReq.setMobile(pinfo.getMobile());
					smsService.sendTemplate(smsReq);
				}
			}
		}
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :sendReviewAlert
	 * @Description:复查提醒发送
	 * @return void
	 * @date 2016年9月29日 下午2:26:10
	 */
	private void sendReviewAlert(List<Long> patientUserIds,Object obj){
		DoctorSendReviewAlertReq req = (DoctorSendReviewAlertReq)obj;
		DoctorSimpleInfo doctorInfo = dao.queryDoctorSimpleInfo(null,req.getDoctorUserId());
		String doctorName=doctorInfo.getTrueName();
		
		boolean sendToReview = false;
		
		//判断医生所在的医院是否有复查预约
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("hospitalId", doctorInfo.getHospitalId());
		param.put("productType", Constant.Business.PRODUCT_TYPE_REVIEW_APPOINTMENT);
		List<LinkedHashMap<String, Object>> productInfos = businessSendDao.getProductIdByHospitalId(param);
		if(productInfos!=null&&productInfos.size()>0){
			sendToReview = true;
			//复查预约
			param.clear();
			param = new HashMap<String, Object>();
			param.put("appointId", GeneralUtil.generatorUUID("APPOINT"));
			param.put("operatorName", doctorInfo.getTrueName());
			param.put("operatorId", doctorInfo.getDoctorId());
			param.put("appointDoctorId", doctorInfo.getDoctorId());
			param.put("hospitalId", doctorInfo.getHospitalId());
			param.put("appointCheckItems", req.getReviewContent());
			param.put("appointDetails", req.getRemark());
			param.put("deptName", doctorInfo.getDeptName());
			param.put("appointDate", req.getReviewDate());
			param.put("sourceFlag", 2);
			businessSendDao.insertFolloupReviewAppoint(param);
		}
		
		
		if(req.getSendFlag()!=null&&req.getSendFlag()==1){
			String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("im.doctor.send.review.alert"));
			ImMessageInfo info = ImMessageUtil.getSysImMessageTips(0, req.getPatientUserIds().get(0), req.getDoctorUserId(), content); 
			messageInnerService.sendInnerMessage(info);
		}
		//拼装消息内容
		List<String> values = new ArrayList<String>();
		values.add(pushInnerService.getMessage(
				PushContentUtil.getBusinessPushContent("push.review.alert.notify", new Object[] { doctorName })));
		values.add("");
		values.add(DateUtil.getDateStr(req.getReviewDate()));
		values.add(req.getReviewContent());
		values.add(req.getRemark());
		
		//跳转链接
		String url = getToRichTextPage(doctorInfo);
		url+="&remark="+2;
		String remark = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.review.alert.notify.remark"));
		if(!StringUtils.isEmpty(param.get("appointId"))){
			url = wxH5Url+reviewAlertUrl+"?appointId="+param.get("appointId")+"&hospitalId="+doctorInfo.getHospitalId()+"&hospitalUserId="+productInfos.get(0).get("vendor");
			remark = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.review.alert.to.appoint.notify.remark"));
		}
		values.add(remark);
		List<String> smsValues = new ArrayList<String>();
		smsValues.add(doctorName);
		smsValues.add(DateUtil.getDateStr(req.getReviewDate()));
		smsValues.add(req.getReviewContent());
		SmsTemplateSendReq smsReq = SmsUtil.getSmsTemplateSendReq("FuChaTiXing", null, smsValues);
		
		//获取患者数据
		List<PatientSimpleInfo> pinfos = getPatientsInfo(patientUserIds);
		if(pinfos!=null&&pinfos.size()>0){
			for(PatientSimpleInfo pinfo : pinfos){
				//如果开通微信
				if(pinfo.getWeixinFlag()!=0){
					values.remove(1);
					values.add(1, pinfo.getTrueName());
					PushNotifyInfo info = PushUtil.getWxTemplatePushNotifyInfo("fuchatixing", url, values);
					info.setUserId(pinfo.getUserId());
					info.setProductId(pinfo.getWeixinFlag());
					pushInnerService.push(info);
				}
				//如果有手机号
				if(!StringUtils.isEmpty(pinfo.getMobile())){
					smsReq.setMobile(pinfo.getMobile());
					smsService.sendTemplate(smsReq);
				}
			}
		}
	}
	
	
	//跳转图文咨询
	private String getToRichTextPage(DoctorSimpleInfo doctor){
		String url = wxH5Url+richTextUrl;
		url+="?doctorId="+doctor.getDoctorId()+"&userId="+doctor.getUserId();
		return url;
	}
	
	
	/**
	 * 复查预约信息获取
	 */
	@Override
	public Object getReviewAppointInfo(ReviewAppointInfoGetReq req) {
		// TODO Auto-generated method stub
		return businessSendDao.queryReviewAppointInfo(req);
	}
}
