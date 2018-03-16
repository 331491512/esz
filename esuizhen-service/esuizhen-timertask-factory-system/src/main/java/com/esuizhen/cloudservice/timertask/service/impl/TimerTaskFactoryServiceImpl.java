package com.esuizhen.cloudservice.timertask.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.timertask.dao.TimerTaskDao;
import com.esuizhen.cloudservice.timertask.service.TimerTaskFactoryService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.timertask.Timertask;
import com.westangel.common.constant.Constant;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.service.TimertaskService;
import com.westangel.common.util.ImMessageUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PushContentUtil;
import com.westangel.common.util.PushNotifyUtil;
import com.westangel.common.util.PushUtil;

@Service
@Transactional
public class TimerTaskFactoryServiceImpl implements TimerTaskFactoryService , com.westangel.common.service.TimerTaskFactoryService
{

	@Autowired
	private TimerTaskDao dao;
	
	@Autowired
	private BusinessCreateHandler businessCreateHandler;
	
	@Autowired
	private TimertaskService timertaskService;
	
	@Autowired
	private PushInnerService pushInnerService;
	
	@Autowired
	private MessageSource messageSource ;
	
	@Value("${server.api.url.root}")
	private String apiUrl;
	
	@Value("${tel.info.hour}")
	private String telInfoHour;
	
	@Value("${tel.info.five.minute}")
	private String telInfoFive;
	
	@Value("${tel.info.fifen.minute}")
	private String telInfoFifteen;
	
	@Value("${tel.ifno.thirty.minute}")
	private String telInfoThirty;
	
	@Value("${timertask.cancel.path}")
	private String timertaskCancelPath;
	
	@Value("${timertask.tel.path}")
	private String telPath;
	
	@Value("${followu.wx.template.name}")
	private String followuWxTtemplateName;
	
	@Value("${server.wx.url.root}")
	private String wxUrl;
	
	@Value("${server.questionnaire.write.path}")
	private String writePath ;
	
	@Value("${followup.start.info}")
	private String startInfo ;
	
	@Value("${followup.check.info}")
	private String checkInfo ;
	
	@Value("${followup.questionnaire.info}")
	private String questionnaireInfo ;
	
	@Value("${followup.type.start.info}")
	private String typeStartInfo ;
	
	@Value("${followup.type.check.info}")
	private String typeCheckInfo ;
	
	@Value("${followup.type.questionnaire.info}")
	private String typeQuestionnaireInfo ;
	
	@Value("${server.h5.patient.followup.follow}")
	private String patientFollowupFollow;
	
	@Value("${server.ehr.query.path}")
	private String ehrPath;
	
	@Value("${url.api.business.to.appointmentreview}")
	private String reviewAlertUrl;
	
	@Value("${url.api.user.profile}")
	private String patientProfile;
	
	@Value("${url.api.business.service.inspection.report.out.check}")
	private String reportCheck;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public Integer createFollowupPlanTimerTask(String followupId){
		return createFollowupPlanTimerTask(followupId,null,null);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_UNCOMMITTED)
	public Integer createFollowupPlanTimerTask(String followupId,String doctorName,Integer wxProductId)
	{
		LogUtil.log.info("创建定时任务开始...");
		Integer code = ErrorMessage.SUCCESS.code;
		try 
		{
			//只返回开启计划详情
			List<LinkedHashMap<String , Object>> followupList = dao.queryFollowupPlanDetailInfo(followupId+"");
			Timertask startTask = null ;
			List<Timertask> taskList = new ArrayList<Timertask>();
			String questionnaireFirst = null;
			
			//问卷相关文案
			String questionnaireKeyWord3 = pushInnerService
					.getMessage(PushContentUtil.getFollowupPushContent(null, "followup.plan.questionnaire.keyword.3"));;
			String questionnaireRemark = null;
			
			//复查相关文案
			String checkInfoFirst = null;
			String checkInfoKeyWord3 = pushInnerService
					.getMessage(PushContentUtil.getFollowupPushContent(null, "followup.plan.checkinfo.keyword.3"));
			String checkInfokeyWord4 = pushInnerService
					.getMessage(PushContentUtil.getFollowupPushContent(null, "followup.plan.checkinfo.keyword.4"));
			
			//随访计划开启相关文案
			String followupStartFirst = null;
			String followupStartKeyWord3 = pushInnerService.getMessage(PushContentUtil.getFollowupPushContent(null, "followup.plan.start.keyword3"));
			String followupStartRemark = pushInnerService.getMessage(PushContentUtil.getFollowupPushContent(null, "followup.plan.start.remark"));
			
			for(int i=0; i<followupList.size(); i++)
			{
				LinkedHashMap<String , Object> map = followupList.get(i);
				Integer actionType = Integer.parseInt(map.get("actionType")+"");
				
				//推送模版内容
				List<String> contentList = new ArrayList<String>();
				switch (actionType)
				{
					case 0:
						if (followupStartFirst == null)
							followupStartFirst = pushInnerService.getMessage(PushContentUtil.getFollowupPushContent(null,
									"followup.plan.start.first", new Object[] { map.get("followupSource") }));
						contentList.add(followupStartFirst);
						contentList.add(map.get("trueName")+"");
						contentList.add(sdf.format((Date) map.get("followupDate")));
						contentList.add(followupStartKeyWord3);
						contentList.add(followupStartRemark);
						break;
					case 2:
						if (checkInfoFirst == null)
							checkInfoFirst = pushInnerService.getMessage(PushContentUtil.getFollowupPushContent(null,
									"followup.plan.checkinfo.first", new Object[] { map.get("followupSource") }));
						contentList.add(checkInfoFirst);
						contentList.add(map.get("trueName")+"");
						contentList.add(sdf.format((Date) map.get("followupDate")));
						contentList.add(checkInfoKeyWord3);
						contentList.add(checkInfokeyWord4);
						break;
					case 3:
						if(questionnaireFirst==null)
							questionnaireFirst = pushInnerService.getMessage(PushContentUtil.getFollowupPushContent(null,
									"followup.plan.questionnaire.first", new Object[] { map.get("followupSource") }));
						contentList.add(questionnaireFirst);
						contentList.add(map.get("trueName")+"");
						contentList.add(sdf.format((Date) map.get("followupDate")));
						contentList.add(questionnaireKeyWord3);
						if(questionnaireRemark==null)
							questionnaireRemark = pushInnerService.getMessage(PushContentUtil.getFollowupPushContent(null,
									"followup.plan.questionnaire.remark", new Object[] { map.get("trueName") }));
						contentList.add(questionnaireRemark);
						break;
					default:
						contentList.add(0, "");
						contentList.add(3, "");
						break;
				}
				
				//推送消息
				Timertask timertask = new Timertask();
				timertask.setTaskType(1);
				timertask.setUserId(map.get("userId")+"");
				timertask.setActionType(1);
				timertask.setActionPushType("wx_template_push");
				timertask.setWxProductId(wxProductId);
				timertask.setPushContent(JsonUtil.toJson(contentList));
				timertask.setWxTemplateName(followuWxTtemplateName);
				if(3==actionType)
				{
					timertask.setWxTemplateUrl(wxUrl+writePath+"?followupItemId="+map.get("followupItemId"));
				}else if(2==actionType){
					timertask.setWxTemplateName("fuchatixing");
					String fromUserName = map.get("openId")==null ? "" : map.get("openId")+"";
//					timertask.setWxTemplateUrl(wxUrl+reviewAlertUrl+"?fromUserName="+fromUserName+"&hospitalId=1&hospitalUserId=9");
					timertask.setWxTemplateUrl(wxUrl+ehrPath+"?fromUserName="+fromUserName);
				}else if(0==actionType)
				{
					String fromUserName = map.get("openId")==null ? "" : map.get("openId")+"";
					timertask.setWxTemplateUrl(wxUrl+patientFollowupFollow+"?fromUserName="+fromUserName);
				}
				timertask.setServiceType(21);
				timertask.setActionTime((Date) map.get("followupDate"));
				timertask.setServiceTargetId(followupId);
				
				//回写任务
				List<String> sqlList = new ArrayList<String>();
				sqlList.add(messageSource.getMessage("timertask.update.followup.plan.detail", new Object[]{map.get("followupItemId")}, null));
				boolean isLast = (i!=followupList.size()-1 ? false : true );
				Object[] obj = new Object[]{isLast ? 2 : 1 , map.get("intervalMonths")+"" , map.get("patientId")+""};
				sqlList.add(messageSource.getMessage("timertask.update.followup.var.patient", obj, null));
				
				Timertask timertask2 = new Timertask();
				timertask2.setTaskType(1);
				timertask2.setUserId(map.get("userId")+"");
				timertask2.setActionType(2);
				timertask2.setSqlContent(JsonUtil.toJson(sqlList));
				timertask2.setServiceType(21);
				timertask2.setActionTime((Date) map.get("followupDate"));
				timertask2.setServiceTargetId(followupId);
				
				if(0==Integer.parseInt(map.get("actionType")+""))
				{//如果为任务开启则记录任务，执行开启推送
					startTask = timertask;
				}else
				{
					taskList.add(timertask);
					taskList.add(timertask2);
				}
			}
			//如果有定时任务  添加
			if(taskList.size()!=0)
				code = timertaskService.createTimetaskList(taskList);
			
			//推送提示消息
			if(startTask!=null)
			{
				List<String> list = JsonUtil.toObject(startTask.getPushContent() , List.class);
				LogUtil.log.debug(doctorName);
				if(doctorName!=null){
					list.remove(3);
					list.remove(0);
					list.add(0, pushInnerService.getMessage(PushContentUtil.getFollowupPushContent(wxProductId==null?null:wxProductId+"", "followup.start.info.doctor", new Object[]{doctorName})));
					list.add(3,pushInnerService.getMessage(PushContentUtil.getFollowupPushContent(wxProductId==null?null:wxProductId+"", "followup.type.start.info.sourceDiagnosis")));
					list.remove(4);
					startTask.setWxTemplateUrl(startTask.getWxTemplateUrl().replace(patientFollowupFollow, patientProfile));
				}
				PushNotifyInfo notify = PushUtil.getWxTemplatePushNotifyInfo(startTask.getWxTemplateName(), startTask.getWxTemplateUrl(), list);
				notify.setUserId(Long.parseLong(startTask.getUserId()));
				PushNotifyUtil.setSendWxProductId(notify, wxProductId);
				try {
					LogUtil.log.debug(JsonUtil.toJson(notify));
					pushInnerService.push(notify);
				} catch (Exception e) {
					LogUtil.logError.error(e.getMessage());
				}
			}
			
			LogUtil.log.info("创建定时任务结束...");
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.logError.error(e.getMessage());
			throw new RuntimeException();
		}
		
		return code;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer createGeneralserviceTimer(String productApplyId ,Integer productType , String taskTag)
	{
		Integer code = ErrorMessage.SUCCESS.code;
		try 
		{
			LinkedHashMap<String, Object> param = new LinkedHashMap<String, Object>();
			param.put("serviceTargetId", productApplyId);
			param.put("serviceType", productType);
			param.put("taskTag", taskTag);
			Integer count = dao.queryTaskCount(param);
			if(count>0)
			{
				return code;
			}
			
			//获取咨询信息
			LinkedHashMap<String , Object> serviceApplyMap = dao.queryProductServiceApplyDetailInfo(productApplyId+"");
			if(serviceApplyMap==null)
			{//没有对应的业务数据直接返回
				code = ErrorMessage.E1404.code;
				return code;
			}
			
			//回调参数组装
			Long time = null ;
			Integer acceptFlag = null ;
			if("cancel".equals(taskTag))
			{
				acceptFlag = 6 ;
				time = ((Date) serviceApplyMap.get("idleCancelTime")).getTime();
			}else if("expire".equals(taskTag))
			{
				acceptFlag = 5 ;
				time = ((Date) serviceApplyMap.get("expireTime")).getTime();
			}
			
			//如果时间或标志为空，直接返回
			if(time==null || acceptFlag==null)
			{
				code = ErrorMessage.E1400.code;
				return code;
			}
			
			//写入参数
			serviceApplyMap.put("taskTag", taskTag);
			serviceApplyMap.put("time", time);
			serviceApplyMap.put("acceptFlag", acceptFlag);
			
			//任务列表
			List<Timertask> taskList = new ArrayList<Timertask>();
			//创建基础定时任务
			businessCreateHandler.createProductApplyTimertask(taskList, serviceApplyMap);
			//创建图文咨询
			if(Constant.Business.PRODUCT_TYPE_RICHTEXT==(Integer)serviceApplyMap.get("productType")
					&&"cancel".equals(taskTag)){
				LogUtil.log.debug("--------create rich text timertask------------");
				businessCreateHandler.createRichTextTimertask(taskList, serviceApplyMap);
			}
			//创建私人医生定时
			else if(Constant.Business.PRODUCT_TYPE_PRIVATE_DOCTOR==(Integer)serviceApplyMap.get("productType") && "expire".equals(serviceApplyMap.get("taskTag")))
			{   
				businessCreateHandler.createPrivateDoctorTimertask(taskList, serviceApplyMap);
			}
			//创建随访消息定时
			else if(Constant.Business.PRODUCT_TYPE_FOLLOWUP_MESSAGE==(Integer)serviceApplyMap.get("productType")
					&&"cancel".equals(taskTag)){
				businessCreateHandler.createFollowupMessageTimertask(taskList,serviceApplyMap);
			}
			code = timertaskService.createTimetaskList(taskList);
		} catch (Exception e) {
			e.printStackTrace();
			code = ErrorMessage.E1417.code;
			throw new RuntimeException();
		}
		return code;
	}
	

	@Override
	public Integer createTelconsultTimer(String productApplyId)
	{
		Integer code = ErrorMessage.SUCCESS.code;
		try 
		{
			LinkedHashMap<String , Object> serviceApplyMap = dao.queryProductServiceApplyDetailInfo(productApplyId+"");
			
			Long date = ((Date) serviceApplyMap.get("consultOrderTime")).getTime();
			Timertask timertask1 = null;
			//提前一小时推送
			if((date-60*60*1000)>new Date().getTime())
			{//距离到期时间大于一小时的时候生成提前一小时提醒任务
				Map<String , Object> eventInfoMap1 = new HashMap<String , Object>();
				eventInfoMap1.put("eventKey", "EVENT_TELCONSULT_SHOW");
				eventInfoMap1.put("userId", serviceApplyMap.get("patientUserId")+"");
				eventInfoMap1.put("patientTrueName", serviceApplyMap.get("trueName")+"");
				eventInfoMap1.put("userPictureUrl", serviceApplyMap.get("patientPictureUrl")+"");
				eventInfoMap1.put("patientMobile", serviceApplyMap.get("patientMobile")+"");
				eventInfoMap1.put("productApplyId", serviceApplyMap.get("productApplyId")+"");
				if(serviceApplyMap.get("contactMobile")!=null&&!"".equals((serviceApplyMap.get("contactMobile")+"").trim())){
					eventInfoMap1.put("patientMobile", serviceApplyMap.get("contactMobile")+"");
				}
				
				
				Map<String , Object> eventMap1 = new HashMap<String , Object>();
				eventMap1.put("eventType", Constant.Push.EVENT_TYPE_ALERT);
				eventMap1.put("eventInfo", JsonUtil.toJson(eventInfoMap1));
				eventMap1.put("eventTip", telInfoHour);
				
				
				timertask1 = new Timertask();
				timertask1.setTaskType(1);
				timertask1.setUserId(serviceApplyMap.get("userId")+"");
				timertask1.setActionType(1);
				timertask1.setPushContent(JsonUtil.toJson(eventMap1));
				timertask1.setActionPushType("app_push");
				timertask1.setServiceType(2);
				timertask1.setActionTime(new Date(date-60*60*1000L));
				timertask1.setServiceTargetId(productApplyId);
			}
			
			
			//提前5分钟推送
			Map<String , Object> eventInfoMap2 = new HashMap<String , Object>();
			eventInfoMap2.put("eventKey", "EVENT_TELCONSULT_SHOW");
			eventInfoMap2.put("userId", serviceApplyMap.get("patientUserId")+"");
			eventInfoMap2.put("patientTrueName", serviceApplyMap.get("trueName")+"");
			eventInfoMap2.put("userPictureUrl", serviceApplyMap.get("patientPictureUrl")+"");
			eventInfoMap2.put("patientMobile", serviceApplyMap.get("patientMobile")+"");
			eventInfoMap2.put("productApplyId", serviceApplyMap.get("productApplyId")+"");
			if(serviceApplyMap.get("contactMobile")!=null&&!"".equals((serviceApplyMap.get("contactMobile")+"").trim())){
				eventInfoMap2.put("patientMobile", serviceApplyMap.get("contactMobile")+"");
			}
			Map<String , Object> eventMap2 = new HashMap<String , Object>();
			eventMap2.put("eventType", Constant.Push.EVENT_TYPE_ALERT);
			eventMap2.put("eventInfo", JsonUtil.toJson(eventInfoMap2));
			eventMap2.put("eventTip", telInfoFive);
			
			Timertask timertask2 = new Timertask();
			timertask2.setTaskType(1);
			timertask2.setUserId(serviceApplyMap.get("userId")+"");
			timertask2.setActionType(1);
			timertask2.setActionPushType("app_push");
			timertask2.setPushContent(JsonUtil.toJson(eventMap2));
			timertask2.setServiceType(2);
			timertask2.setActionTime(new Date(date-5*60*1000L));
			timertask2.setServiceTargetId(productApplyId);
			
			//过了15分钟之后推送
			Map<String , Object> eventInfoMap3 = new HashMap<String , Object>();
			eventInfoMap3.put("eventKey", "EVENT_TELCONSULT_MAKECALL");
			eventInfoMap3.put("userId", serviceApplyMap.get("patientUserId")+"");
			eventInfoMap3.put("patientTrueName", serviceApplyMap.get("trueName")+"");
			eventInfoMap3.put("userPictureUrl", serviceApplyMap.get("patientPictureUrl")+"");
			eventInfoMap3.put("patientMobile", serviceApplyMap.get("patientMobile")+"");
			eventInfoMap3.put("productApplyId", serviceApplyMap.get("productApplyId")+"");
			if(serviceApplyMap.get("contactMobile")!=null&&!"".equals((serviceApplyMap.get("contactMobile")+"").trim())){
				eventInfoMap3.put("patientMobile", serviceApplyMap.get("contactMobile")+"");
			}
			Map<String , Object> eventMap3 = new HashMap<String , Object>();
			eventMap3.put("eventType", Constant.Push.EVENT_TYPE_ALERT);
			eventMap3.put("eventInfo", JsonUtil.toJson(eventInfoMap3));
			eventMap3.put("eventTip", telInfoFifteen.replace("{0}", serviceApplyMap.get("trueName")+""));
			
			Timertask timertask3 = new Timertask();
			timertask3.setTaskType(1);
			timertask3.setUserId(serviceApplyMap.get("userId")+"");
			timertask3.setActionType(1);
			timertask3.setActionPushType("app_push");
			timertask3.setPushContent(JsonUtil.toJson(eventMap3));
			timertask3.setServiceType(2);
			timertask3.setActionTime(new Date(date+15*60*1000L));
			timertask3.setServiceTargetId(productApplyId);
			
			//过了半小时之后取消申请(调用取消接口，推送取消消息)
			Map<String , Object> httpContentMap = new HashMap<String , Object>();
			httpContentMap.put("productApplyId", productApplyId);
			httpContentMap.put("acceptFlag", 11);
			
			Timertask timertask5 = new Timertask();
			timertask5.setTaskType(1);
			timertask5.setUserId(serviceApplyMap.get("userId")+"");
			timertask5.setActionType(8);
			timertask5.setServiceType(2);
			timertask5.setHttpUrl(apiUrl+timertaskCancelPath);
			timertask5.setHttpContent(JsonUtil.toJson(httpContentMap));
			timertask5.setActionTime(new Date(date+30*60*1000L));
			timertask5.setServiceTargetId(productApplyId);
			
			//到点拨打电话
			Timertask timertask6 = new Timertask();
			timertask6.setTaskType(1);
			timertask6.setUserId(serviceApplyMap.get("userId")+"");
			timertask6.setActionType(8);
			timertask6.setServiceType(2);
			timertask6.setHttpUrl(apiUrl+telPath+productApplyId);
			timertask6.setActionTime(new Date(date));
			timertask6.setServiceTargetId(productApplyId);
			
			//提前5分中的时候给患者发送推送
			Timertask timertask7 = new Timertask();
			timertask7.setTaskType(1);
			timertask7.setUserId(serviceApplyMap.get("patientUserId")+"");
			timertask7.setActionType(1);
			timertask7.setActionPushType("wx_data_push");
			timertask7.setWxProductId((Integer)serviceApplyMap.get("wxProductId"));
			String key = "1".equals(serviceApplyMap.get("inPackage")+"") ? "push.service.telconsult.vip.alert.before.5min.topatient" : "push.service.telconsult.alert.before.5min.topatient";
			timertask7.setPushContent(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(key,  new Object[]{serviceApplyMap.get("doctorTrueName")})));
			timertask7.setServiceType(2);
			timertask7.setActionTime(new Date(date-5*60*1000L));
			timertask7.setServiceTargetId(productApplyId);
			
			//提前5分中的时候给患者发送短信
			List<String> dataList = new ArrayList<String>();
			dataList.add(serviceApplyMap.get("doctorTrueName")+"");
			Timertask timertask8 = new Timertask();
			timertask8.setTaskType(1);
			timertask8.setUserId(serviceApplyMap.get("userId")+"");
			timertask8.setActionType(1);
			timertask8.setActionPushType("sms_data_push");
			timertask8.setContactMobile(serviceApplyMap.get("patientMobile")+"");
			timertask8.setWxTemplateName("1".equals(serviceApplyMap.get("inPackage")+"") ? "DianHuaZiXunVIPQian5FenZhong" : "DianHuaZiXunVIPQian5FenZhong");
			timertask8.setPushContent(JsonUtil.toJson(dataList));
			timertask8.setServiceType(2);
			timertask8.setActionTime(new Date(date-5*60*1000L));
			timertask8.setServiceTargetId(productApplyId);
			
			//保存任务列表
			List<Timertask> taskList = new ArrayList<Timertask>();
			if(timertask1!=null)
			{
				taskList.add(timertask1);
			}
			taskList.add(timertask2);
			taskList.add(timertask3);
			taskList.add(timertask5);
			taskList.add(timertask6);
			taskList.add(timertask7);
			taskList.add(timertask8);
			code = timertaskService.createTimetaskList(taskList);
		} catch (Exception e) {
			e.printStackTrace();
			code = ErrorMessage.E1417.code;
		}
		return code;
	}
	
	@Override
	public Integer cancelFollowupPlanTimerTask(String followupId)
	{
		return timertaskService.cancelTimetask(21, followupId, null);
	}
	
	@Override
	public void creatDoAcceptTimeTask(String productApplyId , String param)
	{
		Date actionTime = new Date(System.currentTimeMillis()+60*1000L);
		creatDoAcceptTimeTask(productApplyId, param, null, actionTime);
	}
	
	@Override
	public void creatDoAcceptTimeTask(String productApplyId, String param,String taskTag,Long addTimer){
		Date actionTime = null;
		if(addTimer!=null)
			actionTime = new Date(System.currentTimeMillis()+addTimer);
		else
			actionTime = new Date(System.currentTimeMillis()+60*1000L);
		creatDoAcceptTimeTask(productApplyId, param, taskTag, actionTime);
	}
	
	@Override
	public void creatDoAcceptTimeTask(String productApplyId, String param,String taskTag,Date actionTime){
		LinkedHashMap<String , Object> serviceApplyMap = dao.queryProductServiceApplyDetailInfo(productApplyId+"");
		Timertask timertask = new Timertask();
		timertask.setTaskTag(taskTag);
		timertask.setTaskType(1);
		timertask.setUserId(serviceApplyMap.get("userId")+"");
		timertask.setActionType(8);
		timertask.setServiceType(2);
		timertask.setHttpUrl(apiUrl+timertaskCancelPath);
		timertask.setHttpContent(param);
		//如果有延时时间  按照当前系统时间+延时时间执行 否则延后1min执行
		timertask.setActionTime(actionTime);
		timertask.setServiceTargetId(productApplyId);
		Integer code = timertaskService.createTimetask(timertask);
		if(code!=ErrorMessage.SUCCESS.code)
		{
			throw new RuntimeException();
		}
	}
	
	@Override
	public Integer createMdtAlertTimer(String productApplyId) {
		// TODO Auto-generated method stub
		LinkedHashMap<String , Object> map = dao.queryProductServiceApplyDetailInfo(productApplyId+"");
		Integer code = 1;
		if(map==null||StringUtils.isEmpty(map.get("agentMobile")+"")){
			return code;
		}
		List taskList = new ArrayList();
		
		List<Object> contentList = new ArrayList<Object>();
		contentList.add(map.get("trueName")+"");
		
		Timertask timertask = new Timertask();
		timertask.setTaskType(1);
		timertask.setActionType(1);
		timertask.setTaskTag("cancel");
		timertask.setUserId(map.get("userId")+"");
		timertask.setActionPushType("sms_data_push");
		timertask.setContactMobile(map.get("agentMobile")+"");
		timertask.setPushContent(JsonUtil.toJson(contentList));
		timertask.setWxTemplateName("HuiZhenQianYiTianTiXing");
		timertask.setServiceType(Constant.Business.PRODUCT_TYPE_MDT);
		timertask.setServiceTargetId(productApplyId);
		timertask.setActionTime(new Date(((Date) map.get("consultOrderTime")).getTime()-24*60*60*1000L));
		taskList.add(timertask);
		
		
		String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(
				"push.service.mdt.befor.one.day.notify.toagentapplicant", new Object[] { map.get("trueName") })); 
		ImMessageInfo im = ImMessageUtil.getEDoctorAssistTextMessage((Long)map.get("agentApplicant"), content, null);
		
		Timertask timertask1 = new Timertask();
		timertask1.setTaskType(1);
		timertask1.setActionType(16);
		timertask1.setTaskTag("cancel");
		timertask1.setUserId(map.get("userId")+"");
		timertask1.setPushContent(JsonUtil.toJson(im));
		timertask1.setServiceType(Constant.Business.PRODUCT_TYPE_MDT);
		timertask1.setServiceTargetId(productApplyId);
		timertask1.setActionTime(new Date(((Date) map.get("consultOrderTime")).getTime()-24*60*60*1000L));
		taskList.add(timertask1);
		
		code = timertaskService.createTimetaskList(taskList);
		if(code!=ErrorMessage.SUCCESS.code)
		{
			throw new RuntimeException();
		}
		return code;
	}
	
	
	/**
	 * 检查报状态变更提醒
	 */
	@Override
	public void createInspectionReportCheckTimer(String productApplyId) {
		// TODO Auto-generated method stub
		LinkedHashMap<String , Object> map = dao.queryProductServiceApplyDetailInfo(productApplyId+"");
		Timertask timertask = new Timertask();
		timertask.setTaskType(2);
		timertask.setActionType(8);
		timertask.setTaskTag("expire");
		timertask.setUserId(map.get("patientUserId")+"");
		timertask.setServiceType(110);
		timertask.setServiceTargetId(productApplyId);
		timertask.setActionTime((Date)map.get("expireTime"));
		String url = apiUrl+reportCheck+"?productApplyId="+productApplyId;
		timertask.setHttpUrl(url);
		timertaskService.createTimetask(timertask);
	}
}
