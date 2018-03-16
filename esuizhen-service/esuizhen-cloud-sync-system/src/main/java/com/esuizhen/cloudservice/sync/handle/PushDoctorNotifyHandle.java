/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.handle;<br/>  
 * <b>文件名：</b>PushDoctorNotifyHandle.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年4月5日上午11:16:35<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.handle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.esuizhen.cloudservice.sync.common.Const;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudQRcodeDao;
import com.google.gson.internal.LinkedTreeMap;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.common.bean.message.structuration.TButtonItemInfo;
import com.westangel.common.bean.message.structuration.TButtonMsg;
import com.westangel.common.bean.message.structuration.TStructuredMsg;
import com.westangel.common.bean.sms.SmsContentSendReq;
import com.westangel.common.bean.user.QRCode;
import com.westangel.common.bean.user.TTobeconfirmedDoctor;
import com.westangel.common.bean.user.TUserSyncConfirmInfo;
import com.westangel.common.bean.weixin.WeixinQRReq;
import com.westangel.common.constant.Constant;
import com.westangel.common.service.MessageInnerService;
import com.westangel.common.service.SmsInnerService;
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.ImMessageUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: PushDoctorNotifyHandle
* @Description: 
* @author lichenghao
* @date 2017年4月5日 上午11:16:35  
*/
@Component
public class PushDoctorNotifyHandle {
	
	@Autowired
	private MessageSource messageSource;
	private Locale locale = Locale.getDefault();
	@Autowired
	private CloudQRcodeDao cloudQRcodeDao;
	@Autowired
	private SmsInnerService smsInnerService;
	@Autowired
	private MessageInnerService messageInnerService;
	@Value("${server.api.url.root}")
	private String serverUrlRoot;
	@Value("${push.weixin.qr.get}")
	private String pushWeixinQrGetUrl;
	/**
	 * 
	 * @Title: sendNotify2Doctor @Description: 通过随诊助手向医生发送通知 @param @param
	 * uuid @param @param doctor 设定文件 @return void 返回类型 @throws
	 */
	private boolean sendNotify2Doctor(TTobeconfirmedDoctor doctor) {
		StringBuilder confirmContent = new StringBuilder();
		if (!StringUtils.isEmpty(doctor.getStaffNo())) {
			confirmContent.append(messageSource.getMessage("push.synchronized.information.todoctor.job.number", null, locale));
			confirmContent.append(doctor.getStaffNo());
			confirmContent.append("\n");
		}
		if (!StringUtils.isEmpty(doctor.getPositionTitleName())) {
			confirmContent.append(doctor.getPositionTitleName());
		}
		if (StringUtils.isNotEmpty(doctor.getSubDeptName())) {
			confirmContent.append("\t");
			confirmContent.append(doctor.getSubDeptName());
			confirmContent.append("\n");
		} else if (!StringUtils.isEmpty(doctor.getDeptName())) {
			confirmContent.append("\t");
			confirmContent.append(doctor.getDeptName());
			confirmContent.append("\n");
		}
		if (!StringUtils.isEmpty(doctor.getHospitalName())) {
			confirmContent.append(doctor.getHospitalName());
		}
		String content = messageSource.getMessage("push.synchronized.information.confirm.content", null, locale);
		TStructuredMsg<TButtonMsg>  struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		//设置标题。带颜色
		//buttonMsg.setTitle(content);
		buttonMsg.setDescription(content);
		
		//生成按钮
		List<TButtonItemInfo> buttonList = new LinkedList<TButtonItemInfo>();
		buttonMsg.setButton(buttonList);
		//按钮信息
		TButtonItemInfo button = new TButtonItemInfo();
		button.setText(messageSource.getMessage("button.synchronized.information.view.details", null, locale));
		button.setEventKey("SYNC_CONFIRM_DOCTOR_DETAIL");
		
		// 同步信息
		TUserSyncConfirmInfo info = new TUserSyncConfirmInfo();
		info.setUserId(doctor.getUserId());
		info.setUuid(doctor.getUuid());
		info.setTrueName(doctor.getTrueName());
		info.setTipText(confirmContent.toString());
		
		Map<String, Object> confirmInfo = new HashMap<String, Object>(1);
		confirmInfo.put("confirmInfo", info);
		button.setParam(confirmInfo);
		buttonList.add(button);
		//buttonMsg.setStyle("horizontal");
		
		//整个struMsg转换成json消息
		content = JSON.toJSONString(struMsg);
		String tipText = messageSource.getMessage("button.title.synchronized.information", null, locale);//chat提示
		//tipText = "您有新增的患者信息未同步";
		ImMessageInfo im = ImMessageUtil.getSysImMessageButton(1, 0L, doctor.getUserId(), content, Const.SYNCDOCTOR + doctor.getUserId(), tipText);
		// #TODO 删除
		im.setSpeakerId(2L);
		im.setSpeakerRole(0);
		im.setFromSystem(0);
		return messageInnerService.sendInnerMessage(im);
	}
	
	/**
	 * 
	 * @Title: auditDoctorSmsContentSend
	 * @Description: 向医生发送短信
	 * @param @param mobile 医生手机号
	 * @param @param auditState 审核状态
	 * @return void 返回类型
	 * @throws
	 */
	private boolean mergeDoctorSmsContentSend(String mobile) {
		if (StringUtils.isEmpty(mobile)) {
			return false;
		}
		SmsContentSendReq smsContentSendReq = new SmsContentSendReq();
		smsContentSendReq.setBusinessId(1);
		smsContentSendReq.setProductId(1);
		List<String> mobiles = new ArrayList<String>();
		mobiles.add(mobile);
		smsContentSendReq.setMobiles(mobiles);
		String mobileContent = messageSource.getMessage("sms.todoctor.synchronized.information", null, locale);
		smsContentSendReq.setContent(mobileContent);
		try {
			this.smsInnerService.sendContent(smsContentSendReq);
		} catch (Exception e) {
			LogUtil.log.error("给" + mobile + "医生发送确认身份消息短信时出错！" + e.getMessage());
		}
		return true;
	}
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean generateQRCode(Long userId) {
		// 审核通过获取二维码
		WeixinQRReq weixinQRReq = new WeixinQRReq();
		weixinQRReq.setBusinessId(1);
		weixinQRReq.setProductId(2);
		weixinQRReq.setUserId(userId);
		weixinQRReq.setUserRole(2);
		
		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-type", "application/json");
		String weixinQRJson = HttpUtil.postString(serverUrlRoot + pushWeixinQrGetUrl, JsonUtil.toJson(weixinQRReq), "utf-8", headerMap);
		TMsgResponse<LinkedTreeMap<String, Object>> tMsgResponse = JsonUtil.toObject(weixinQRJson, TMsgResponse.class);
		Map<String, Object> weixinQRMap = (Map<String, Object>) tMsgResponse.getResult();
		QRCode qrCode = new QRCode();
		qrCode.setUserRole(Constant.User.ROLE_DOCTOR);
		qrCode.setQrcodeUrl((String) weixinQRMap.get("QRUrl"));
		qrCode.setTicket((String) weixinQRMap.get("ticket"));
		qrCode.setTargetId((String) weixinQRMap.get("targetId"));
		qrCode.setBusinessId(1);
		qrCode.setProductId(2);
		qrCode.setUserId(userId);
		String ticketId = weixinQRMap.get("ticketId").toString();
		int index = ticketId.indexOf(".");
		if (index > 0) {
			ticketId = ticketId.substring(0, index);
		}
		qrCode.setTicketId(Long.parseLong(ticketId));
		if(this.cloudQRcodeDao.findByTicket(qrCode.getTicket()) == null){
			this.cloudQRcodeDao.insert(qrCode);
		}
		//向随诊助手发送推送
		this.pushImMessageSuizhenAssist(userId, Constant.User.AUDITSTATE_PRIMARYPASS, qrCode.getQrcodeUrl());
		return true;
	}
	
	/**
	 * 医生二维码生成，推送消息
	 * @param doctorUserId
	 * @param auditState
	 */
	private boolean pushImMessageSuizhenAssist(Long doctorUserId, Integer auditState, String qrCodePath){
		try{
			if(doctorUserId != null && doctorUserId > 0){
				String content = null;
				String tipText = null;
				ImMessageInfo im = null;
				switch (auditState) {
				case 2:
					tipText = messageSource.getMessage("push.tips.audit.doctor.basepass", null, locale);
					List<String> picUrls = new ArrayList<String>(1);
					picUrls.add(qrCodePath);
					content = ImMessageUtil.getPicTextMessage(messageSource.getMessage("push.suizhenassist.audit.doctor.basepass", null, locale), picUrls);
					im = ImMessageUtil.getEDoctorAssistTextMessage(doctorUserId, content, tipText);
					im.setContentType(101);
					break;
				case 4:
					tipText = messageSource.getMessage("push.tips.audit.doctor.advpass", null, locale);
					content = messageSource.getMessage("push.suizhenassist.audit.doctor.advpass", null, locale);
					im = ImMessageUtil.getEDoctorAssistTextMessage(doctorUserId, content, tipText);
					break;
				case -1:
					tipText = messageSource.getMessage("push.tips.audit.doctor.basenotpass", null, locale);
					content = messageSource.getMessage("push.suizhenassist.audit.doctor.basenotpass", null, locale);
					im = ImMessageUtil.getEDoctorAssistTextMessage(doctorUserId, content, tipText);
					break;
				case -2:
					tipText = messageSource.getMessage("push.tips.audit.doctor.advnotpass", null, locale);
					content = messageSource.getMessage("push.suizhenassist.audit.doctor.advnotpass", null, locale);
					im = ImMessageUtil.getEDoctorAssistTextMessage(doctorUserId, content, tipText);
					break;
				}
				this.messageInnerService.sendInnerMessage(im);
				return true;
			}
		} catch (Exception e){
			LogUtil.logError.error("sendNotifyToPatientForOpenFollowupPlan() failed:" + e.getMessage());
		}
		return false;
	}
	
	/**
	 * 
	 * @Title: auditDoctorSmsContentSend
	 * @Description: 向医生发送短信
	 * @param @param mobile 医生手机号
	 * @param @param auditState 审核状态
	 * @return void 返回类型
	 * @throws
	 */
	private boolean auditDoctorSmsContentSend(String mobile, Integer auditState) {
		SmsContentSendReq smsContentSendReq = new SmsContentSendReq();
		smsContentSendReq.setBusinessId(1);
		smsContentSendReq.setProductId(1);
		List<String> mobiles = new ArrayList<String>(1);
		mobiles.add(mobile);
		smsContentSendReq.setMobiles(mobiles);
		String mobileContent = null;
		switch (auditState) {
		case -2:
			mobileContent = messageSource.getMessage("doctor.audit.mobile.send.m2", null, locale);
			break;
		case -1:
			mobileContent = messageSource.getMessage("doctor.audit.mobile.send.m1", null, locale);
			break;
		case 2:
			mobileContent = messageSource.getMessage("doctor.audit.mobile.send.2", null, locale);
			break;
		case 4:
			mobileContent = messageSource.getMessage("doctor.audit.mobile.send.4", null, locale);
			break;
		}
		smsContentSendReq.setContent(mobileContent);
		this.smsInnerService.sendContent(smsContentSendReq);
		return true;
	}
	
	/**
	 * 
	 * @param doctor
	 * @param confirm
	 * @return
	 */
	public boolean sendNotifyToDoctorConfirmationResult(TTobeconfirmedDoctor doctor, Integer confirm){
		String content = messageSource.getMessage("push.synchronized.information.confirm.content", null, locale);
		TStructuredMsg<TButtonMsg>  struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		//设置标题。带颜色
		//buttonMsg.setTitle(content);
		buttonMsg.setDescription(content);
		
		//生成按钮
		List<TButtonItemInfo> buttonList = new LinkedList<TButtonItemInfo>();
		buttonMsg.setButton(buttonList);
		//按钮信息
		TButtonItemInfo button = new TButtonItemInfo();
		//button.setText(messageSource.getMessage("button.title.invite.patients.to.improve.disease.information", null, locale));
		//button.setText("点击前去确认");
		if (confirm == 1) {
			button.setText(messageSource.getMessage("button.synchronized.information.confirmed", null, locale) + messageSource.getMessage("button.synchronized.information.confirmed.been.me", null, locale));
		} else {
			button.setText(messageSource.getMessage("button.synchronized.information.confirmed", null, locale) + messageSource.getMessage("button.synchronized.information.confirmed.not.me", null, locale));
		}
		//button.setEventKey("SYNC_CONFIRM_DOCTOR_DETAIL");
		
		buttonList.add(button);
		//buttonMsg.setStyle("horizontal");
		
		//整个struMsg转换成json消息
		content = JSON.toJSONString(struMsg);
		String tipText = messageSource.getMessage("tips.synchronized.information.confirmed.text", null, locale);//chat提示
		ImMessageInfo im = ImMessageUtil.getSysImMessageButton(1, 0L, doctor.getUserId(), content, Const.SYNCDOCTOR + doctor.getUserId(), tipText);
		// #TODO 删除
		im.setSpeakerId(2L);
		im.setSpeakerRole(0);
		im.setFromSystem(0);
		return messageInnerService.sendInnerMessage(im);
	}
	
	
	private boolean sendNotifyToDoctorConfirmation(Long userId){
		TTobeconfirmedDoctor doctor = new TTobeconfirmedDoctor();
		doctor.setUserId(userId);
		doctor.setHospitalName("北京大学肿瘤医院");
		doctor.setDeptName("肿瘤科一级");
		doctor.setSubDeptName("肿瘤科");
		doctor.setPositionTitleName("主任医师");
		doctor.setStaffNo("KJJD.3215");
		doctor.setUuid("doctor1254125doctor" + userId);
		doctor.setTrueName("医老虎");
		
		StringBuilder confirmContent = new StringBuilder();
		if (!StringUtils.isEmpty(doctor.getStaffNo())) {
			confirmContent.append("工号：");
			confirmContent.append(doctor.getStaffNo());
			confirmContent.append("\n");
		}
		if (!StringUtils.isEmpty(doctor.getPositionTitleName())) {
			confirmContent.append(doctor.getPositionTitleName());
		}
		if (StringUtils.isNotEmpty(doctor.getSubDeptName())) {
			confirmContent.append("\t");
			confirmContent.append(doctor.getSubDeptName());
			confirmContent.append("\n");
		} else if (!StringUtils.isEmpty(doctor.getDeptName())) {
			confirmContent.append("\t");
			confirmContent.append(doctor.getDeptName());
			confirmContent.append("\n");
		}
		
		if (!StringUtils.isEmpty(doctor.getHospitalName())) {
			confirmContent.append(doctor.getHospitalName());
		}
		
		String content = "检测到" + doctor.getHospitalName() + "的院内数据与您的信息相似，请确认是否为您本人。\n确认匹配后，您将在易随诊app中享有院内数据的同步。";
		TStructuredMsg<TButtonMsg>  struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		//设置标题。带颜色
		//buttonMsg.setTitle(content);
		buttonMsg.setDescription(content);
		
		//生成按钮
		List<TButtonItemInfo> buttonList = new LinkedList<TButtonItemInfo>();
		buttonMsg.setButton(buttonList);
		//按钮信息
		TButtonItemInfo button = new TButtonItemInfo();
		//button.setText(messageSource.getMessage("button.title.invite.patients.to.improve.disease.information", null, locale));
		button.setText("点击前去确认");
		//button.setText("<font color=\"#999999\">已确认，是我本人</font>");
		//button.setText("<font color=\"#999999\">已确认，不是我</font>");
		button.setEventKey("SYNC_CONFIRM_DOCTOR_DETAIL");
		
		// 同步信息
		TUserSyncConfirmInfo info = new TUserSyncConfirmInfo();
		info.setUserId(doctor.getUserId());
		info.setUuid(doctor.getUuid());
		info.setTrueName(doctor.getTrueName());
		info.setTipText(confirmContent.toString());
		
		Map<String, Object> confirmInfo = new HashMap<String, Object>(1);
		confirmInfo.put("confirmInfo", info);
		button.setParam(confirmInfo);
		buttonList.add(button);
		//buttonMsg.setStyle("horizontal");
		
		//整个struMsg转换成json消息
		content = JSON.toJSONString(struMsg);
		String tipText = messageSource.getMessage("button.title.invite.patients.to.improve.disease.information", null, locale);//chat提示
		tipText = "同步医院个人信息确认";
		ImMessageInfo im = ImMessageUtil.getSysImMessageButton(1, 0L, userId, content, Const.SYNCDOCTOR + userId, tipText);
		// #TODO 删除
		im.setSpeakerId(2L);
		im.setSpeakerRole(0);
		im.setFromSystem(0);
		return messageInnerService.sendInnerMessage(im);
	}
	/**
	 * 
	 * @author lichenghao
	 * @title :pushNotifyToDoctor
	 * @Description:给医生推送合并消息
	 * @return void
	 * @date 2017年4月5日 上午11:21:50
	 */
	public void pushNotifyToDoctor(TTobeconfirmedDoctor doctor) {
		//推送
		this.sendNotify2Doctor(doctor);
		//短信
		this.mergeDoctorSmsContentSend(doctor.getMobile());
	}
}
