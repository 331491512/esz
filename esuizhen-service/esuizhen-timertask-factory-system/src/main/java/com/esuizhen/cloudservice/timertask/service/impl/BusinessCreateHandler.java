/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.timertask.service.impl;<br/>  
 * <b>文件名：</b>BusinessCreateHandle.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年10月8日下午2:08:32<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.timertask.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.timertask.Timertask;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.PushContentUtil;
import com.westangel.common.util.PushUtil;

/** 
* @ClassName: BusinessCreateHandle
* @Description: 
* @author lichenghao
* @date 2016年10月8日 下午2:08:32  
*/
@Component
public class BusinessCreateHandler {
	
	@Autowired
	private PushInnerService pushInnerService;
	
	@Value("${server.api.url.root}")
	private String apiUrl;
	
	@Value("${server.h5.url.root}")
	private String weixinHtmlUrl;
	
	@Value("${timertask.cancel.path}")
	private String timertaskCancelPath;
	
	@Value("${url.api.business.to.text.consulting}")
	private String richTextUrl;
	@Value("${rich.text.time.send.message.path}")
	private String richTextSendMessageUrl;
	
	//所有服务创建定时任务
	public void createProductApplyTimertask(List<Timertask> taskList,LinkedHashMap<String , Object> serviceApplyMap){
		Map<String , Object> httpContentMap = new HashMap<String , Object>();
		httpContentMap.put("productApplyId", serviceApplyMap.get("productApplyId"));
		httpContentMap.put("acceptFlag", serviceApplyMap.get("acceptFlag"));
		Timertask timertask = new Timertask();
		timertask.setTaskType(1);
		timertask.setTaskTag((String)serviceApplyMap.get("taskTag"));
		timertask.setUserId(serviceApplyMap.get("userId")+"");
		timertask.setActionType(8);
		timertask.setServiceType((Integer)serviceApplyMap.get("productType"));
		timertask.setHttpUrl(apiUrl+timertaskCancelPath);
		timertask.setHttpContent(JsonUtil.toJson(httpContentMap));
		timertask.setActionTime(new Date((Long)serviceApplyMap.get("time")));
		timertask.setServiceTargetId((String)serviceApplyMap.get("productApplyId"));
		taskList.add(timertask);
	}
	//私人医生创建定时任务
	public void createPrivateDoctorTimertask(List<Timertask> taskList,LinkedHashMap<String , Object> serviceApplyMap){
		//私人医生申请一周前
		List<String> dataList = new ArrayList<String>();
		dataList.add(serviceApplyMap.get("doctorTrueName")+"");
		dataList.add(serviceApplyMap.get("periodFeeType")+"");
		Timertask timertask2 = new Timertask();
		timertask2.setTaskType(1);
		timertask2.setUserId(serviceApplyMap.get("patientUserId")+"");
		timertask2.setActionType(1);
		timertask2.setActionPushType("sms_data_push");
		timertask2.setContactMobile(serviceApplyMap.get("patientMobile")+"");
		timertask2.setWxTemplateName("SiRenYiShengDaoQiYiZhouQian");
		timertask2.setPushContent(JsonUtil.toJson(dataList));
		timertask2.setServiceType((Integer)serviceApplyMap.get("productType"));
		timertask2.setActionTime(new Date((Long)serviceApplyMap.get("time")-7*24*60*60*1000L));
		timertask2.setServiceTargetId((String)serviceApplyMap.get("productApplyId"));
		
		List<String> contentList = new ArrayList<String>();
		contentList.add(pushInnerService.getMessage(
				PushContentUtil.getBusinessPushContent("push.service.private.dcotor.notify.5min.head",
						new Object[] { "", serviceApplyMap.get("periodFeeType") + "" })));
		contentList.add(pushInnerService.getMessage(
				PushContentUtil.getBusinessPushContent("push.service.private.dcotor.notify.5min.name",
						new Object[]{serviceApplyMap.get("doctorTrueName")+"" , serviceApplyMap.get("periodFeeType")+""})));
		contentList.add(new SimpleDateFormat("yyyy年MM月dd日").format(new Date((Long)serviceApplyMap.get("time"))));
		contentList.add(pushInnerService.getMessage(
				PushContentUtil.getBusinessPushContent("push.service.private.dcotor.notify.5min.remark")));
		
		taskList.add(timertask2);
		
		Timertask timertask3 = new Timertask();
		timertask3.setTaskType(1);
		timertask3.setUserId(serviceApplyMap.get("patientUserId")+"");
		timertask3.setActionType(1);
		timertask3.setActionPushType("wx_template_push");
		timertask3.setWxProductId((Integer)serviceApplyMap.get("wxProductId"));
		timertask3.setPushContent(JsonUtil.toJson(contentList));
		timertask3.setWxTemplateName("sirenyishengdaoqiyizhouqian");
		timertask3.setServiceType((Integer)serviceApplyMap.get("productType"));
		timertask3.setActionTime(new Date((Long)serviceApplyMap.get("time")-7*24*60*60*1000L));
		timertask3.setServiceTargetId((String)serviceApplyMap.get("productApplyId"));
		
		taskList.add(timertask3);
	}
	
	//随访消息服务创建
	public void createFollowupMessageTimertask(List<Timertask> taskList,
			LinkedHashMap<String, Object> serviceApplyMap) {
		// TODO Auto-generated method stub
		List<String> values = new ArrayList<String>();
		String templateName = "suifangtixing";
		String url = "";
		url = weixinHtmlUrl+richTextUrl+"?userId="+serviceApplyMap.get("userId")+"&doctorId="+serviceApplyMap.get("doctorId");
		//【{0}】医生为您发送了一条新消息
		values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.followup.message.to.patient",serviceApplyMap.get("doctorTrueName"))));
		values.add((String)serviceApplyMap.get("trueName"));
		values.add(DateUtil.getDateStr(new Date()));
		values.add("");
		values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.followup.message.to.patient.last.23")));
		
		//1小时提醒
		Timertask timertask = new Timertask();
		timertask.setTaskType(1);
		timertask.setActionType(0);
		timertask.setTaskTag((String)serviceApplyMap.get("taskTag"));
		timertask.setUserId(serviceApplyMap.get("patientUserId")+"");
		timertask.setServiceType((Integer)serviceApplyMap.get("productType"));
		timertask.setWxTemplateName(templateName);
		timertask.setActionPushType("wx_template_push");
		timertask.setPushContent(JsonUtil.toJson(values));
		timertask.setWxProductId((Integer)serviceApplyMap.get("wxProductId"));
		timertask.setWxTemplateUrl(url);
		timertask.setActionTime(new Date((Long)serviceApplyMap.get("time")-23*60*60*1000));
		timertask.setServiceTargetId((String)serviceApplyMap.get("productApplyId"));
		taskList.add(timertask);
		
		//8小时提醒
		values.remove(4);
		values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.followup.message.to.patient.last.16")));
		Timertask timertask2 = new Timertask();
		BeanUtils.copyProperties(timertask, timertask2);
		timertask2.setActionTime(new Date((Long)serviceApplyMap.get("time")-16*60*60*1000));
		timertask2.setPushContent(JsonUtil.toJson(values));
		taskList.add(timertask2);
		
		//23小时提醒
		values.remove(4);
		values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.followup.message.to.patient.last.1")));
		Timertask timertask3 = new Timertask();
		BeanUtils.copyProperties(timertask, timertask3);
		timertask3.setActionTime(new Date((Long)serviceApplyMap.get("time")-1*60*60*1000));
		timertask3.setPushContent(JsonUtil.toJson(values));
		taskList.add(timertask3);
	}
	
	//图文定时任务
	public void createRichTextTimertask(List<Timertask> taskList, LinkedHashMap<String, Object> serviceApplyMap) {
		Map<String , Object> httpContentMap = new HashMap<String , Object>();
		httpContentMap.put("productApplyId", serviceApplyMap.get("productApplyId"));
		httpContentMap.put("num",1);
		//1小时
		Timertask timertask = new Timertask();
		timertask.setTaskType(1);
		timertask.setTaskTag((String)serviceApplyMap.get("taskTag"));
		timertask.setUserId(serviceApplyMap.get("userId")+"");
		timertask.setActionType(8);
		timertask.setServiceType((Integer)serviceApplyMap.get("productType"));
		timertask.setHttpUrl(apiUrl+richTextSendMessageUrl);
		timertask.setHttpContent(JsonUtil.toJson(httpContentMap));
		timertask.setActionTime(new Date(((Date)serviceApplyMap.get("createTime")).getTime()+60*60*1000));
		timertask.setServiceTargetId((String)serviceApplyMap.get("productApplyId"));
		taskList.add(timertask);
		//12小时
		Timertask timertask1 = new Timertask();
		BeanUtils.copyProperties(timertask, timertask1);
		httpContentMap.put("num", 12);
		timertask1.setActionTime(new Date(((Date)serviceApplyMap.get("createTime")).getTime()+12*60*60*1000));
		timertask1.setHttpContent(JsonUtil.toJson(httpContentMap));
		taskList.add(timertask1);
		//-1小时
		timertask1 = new Timertask();
		BeanUtils.copyProperties(timertask, timertask1);
		httpContentMap.put("num", -1);
		timertask1.setActionTime(new Date((Long)serviceApplyMap.get("time")-60*60*1000));
		timertask1.setHttpContent(JsonUtil.toJson(httpContentMap));
		taskList.add(timertask1);
	}
}
