/**
 * 
 */
package com.esuizhen.cloudservice.business.notify.sender;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import com.esuizhen.cloudservice.business.bean.TProductApply;
import com.esuizhen.cloudservice.business.dao.business.DoctorDao;
import com.esuizhen.cloudservice.business.dao.business.PatientDao;
import com.esuizhen.cloudservice.business.dao.business.ProductApplyDao;
import com.esuizhen.cloudservice.business.dao.business.UserDao;
import com.esuizhen.cloudservice.business.model.business.ProductServiceApply;
import com.esuizhen.cloudservice.business.model.business.ProductServiceConf;
import com.esuizhen.cloudservice.business.model.business.SMDTApply;
import com.esuizhen.cloudservice.business.util.ProductUtil;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.DoctorSimpleInfo;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.common.bean.message.structuration.TBottomInfo;
import com.westangel.common.bean.message.structuration.TButtonItemInfo;
import com.westangel.common.bean.message.structuration.TButtonMsg;
import com.westangel.common.bean.message.structuration.TStructuredMsg;
import com.westangel.common.bean.push.PushClientEventInfo;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.sms.SmsContentSendReq;
import com.westangel.common.bean.sms.SmsTemplateSendReq;
import com.westangel.common.bean.trade.TOrderPublishInfo;
import com.westangel.common.constant.Constant;
import com.westangel.common.service.MessageInnerService;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.service.SmsInnerService;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.ImMessageUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PushContentUtil;
import com.westangel.common.util.PushNotifyUtil;
import com.westangel.common.util.PushUtil;
import com.westangel.common.util.SmsUtil;

/**
 * 产品申请后需要发出的推送通知或消息
 * 
 * @author bigdragon
 * @date 2016/1/6
 *
 */
@Component
public class ProductApplyNotifySender {
	private Locale locale = Locale.getDefault();
	@Value("${server.api.url.root}")
	private String serverUrlRoot;

	@Value("${server.h5.url.root}")
	private String serverH5UrlRoot;

	@Value("${url.doctorservice.order.detail}")
	private String orderDetailUrl;

	@Value("${url.api.business.product.application.accept}")
	private String productAcceptUrl;

	@Value("${event.api.url.root}")
	private String eventUrlRoot;

	@Value("${url.api.business.mdt.disease.valuation}")
	private String mdtDiseaseEvaluation;

	@Value("${url.api.business.mdt.pay}")
	private String mdtPay;

	@Value("${url.api.business.mdt.upload}")
	private String mdtUpload;

	@Autowired
	private PushInnerService pushInnerService;

	@Autowired
	private MessageInnerService messageService;

	@Autowired
	private SmsInnerService smsService;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private PatientDao patientDao;

	@Autowired
	private ProductApplyDao productApplyDao;

	/**
	 * 电话咨询通知
	 * 
	 * @param orderInfo
	 */
	public void sendTelConsultingApplyNotify(TOrderPublishInfo orderInfo) {
		try {
			sendTelConsultingApplyNotifyToDoctor(orderInfo);
			sendTelConsultingApplyNotifyToPatient(orderInfo);
		} catch (Exception e) {
			LogUtil.logError.error("sendTelConsultingApplyNotify() exception: " + e.getMessage());
			// 注意，不再对外抛出异常。在这里终结异常。即：消息推送失败不能影响业务流程。
		}
	}

	/**
	 * 图文咨询通知
	 * 
	 * @param orderInfo
	 */
	public void sendRichTextConsultingApplyNotify(TOrderPublishInfo orderInfo) {
		try {
			//sendRichTextConsultingApplyNotifyToDoctor(orderInfo);
			sendRichTextConsultingApplyNotifyToPatient(orderInfo);
		} catch (Exception e) {
			LogUtil.logError.error("sendRichTextConsultingApplyNotify() exception: " + e.getMessage());
			// 注意，不再对外抛出异常。在这里终结异常。即：消息推送失败不能影响业务流程。

		}
	}

	/**
	 * 除图文咨询和电话咨询外的其他产品服务，使用本方法进行申请通知下发
	 * 目前所有产品都需要申请推送。但私人医生和预约挂号需要医生同意，MDT暂不需要。可以通过配置修改。
	 * 
	 * @param orderInfo
	 */
	public void sendOtherProductApplyNotify(TOrderPublishInfo orderInfo) {
		// TODO Auto-generated method stub
		try {
			ProductServiceConf conf = productApplyDao.getProductServiceConfById(orderInfo.getProductId());

			sendOtherProductApplyNotifyToDoctor(orderInfo, conf);
			sendOtherProductApplyNotifyToPatient(orderInfo, conf);
		} catch (Exception e) {
			LogUtil.logError.error("sendOtherProductApplyNotify() productType=" + orderInfo.getProductType()
					+ ". exception: " + e.getMessage());
			// 注意，不再对外抛出异常。在这里终结异常。即：消息推送失败不能影响业务流程。

		}

	}

	private void sendOtherProductApplyNotifyToPatient(TOrderPublishInfo orderInfo, ProductServiceConf conf) {
		// TODO Auto-generated method stub
		if (conf.getIsApplyPushNotifyToPatient() == 1) {
			sendApplyNotifyToPatient(conf.getProductType(), conf.getProductName(), orderInfo);
		}

	}

	private void sendApplyNotifyToPatient(int productType, String productName, TOrderPublishInfo orderInfo) {

		// 1. 发给患者微信推送通知。除图文咨询外，其他服务均调用此方法。
		String vendorName = getUserTrueName(orderInfo.getVendor(), 2);
		String content = null;
		String code = null;
		if (productType == Constant.Business.PRODUCT_TYPE_RICHTEXT) {
			code = orderInfo.getInPackage() == 1 ? "push.service.richtextconsult.vip.applynotify.topatient"
					: "push.service.richtextconsult.applynotify.topatient";
			content = pushInnerService
					.getMessage(PushContentUtil.getBusinessPushContent(code, new Object[] { vendorName }));
		} else if (productType == Constant.Business.PRODUCT_TYPE_TEL) {
			code = orderInfo.getInPackage() == 1 ? "push.service.telconsult.vip.applynotify.topatient"
					: "push.service.telconsult.applynotify.topatient";
			content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(code,
					new Object[] { DateUtil.getDateStr(new Date()), vendorName }));
		} else if (productType == Constant.Business.PRODUCT_TYPE_CLINIC) {
			code = "push.service.clinic.applynotify.topatient";
			content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(code,
					new Object[] { DateUtil.getDateStr(new Date()), vendorName }));
		} else if (productType == Constant.Business.PRODUCT_TYPE_PRIVATE_DOCTOR) {
			code = "push.service.private.dcotor.applynotify.topatient";
			content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(code,
					new Object[] { DateUtil.getDateStr(new Date()), vendorName }));
		} else {
			code = "push.service.applynotify.topatient";
			content = pushInnerService
					.getMessage(PushContentUtil.getBusinessPushContent(code, new Object[] { productName, vendorName }));
		}

		PushNotifyInfo notifyInfo = PushUtil.getWxDataPushNotifyInfo(orderInfo.getBuyer(), content);
		PushNotifyUtil.setSendWxProductId(notifyInfo, orderInfo.getWxProductId());
		pushInnerService.push(notifyInfo);
	}

	private void sendOtherProductApplyNotifyToDoctor(TOrderPublishInfo orderInfo, ProductServiceConf conf) {
		// TODO Auto-generated method stub
		// 1. 下发申请推送。目前所有服务申请都需要推送
		if (conf.getIsApplyPushNotifyToDoctor() == 1) {
			sendApplyNotifyToDoctor(conf.getProductType(), conf.getProductName(), orderInfo);
		}

		// 2. 发送接受按钮消息
		if (conf.getIsApplyAcceptNotify() == 1) {
			sendApplyAcceptButtonMessage(conf.getProductType(), conf.getProductName(), orderInfo);
		}

	}

	private void sendApplyNotifyToDoctor(int productType, String productName, TOrderPublishInfo orderInfo) {

		// TODO Auto-generated method stub
		// 1.发推送通知给医生App
		String buyerName = getUserTrueName(orderInfo.getBuyer(), 1);
		String content = "";
		if (productType == Constant.Business.PRODUCT_TYPE_RICHTEXT && orderInfo.getPlusPrice() > 0) {
			content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(
					"push.service.richtextconsult.plus.price.applynotify.todoctor",
					new Object[] { buyerName, orderInfo.getPlusPrice() }));
		} else {
			content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(
					"push.service.applynotify.todoctor", new Object[] { buyerName, productName }));
		}
		PushNotifyInfo notifyInfo = PushUtil.getAppPushNotifyInfoForServiceStateChange(orderInfo.getBuyer(),
				orderInfo.getVendor(), orderInfo.getProductType(), content);
		pushInnerService.push(notifyInfo);
		// 2.发送短信通知医生
		sendApplySmsTemplateSendToDoctor(productType, orderInfo, "HuanZheShenQingZiXunFuWuHou", productName, buyerName);
	}

	private void sendApplySmsTemplateSendToDoctor(int productType, TOrderPublishInfo orderInfo, String templateName,
			String productName, String buyerName) {
		// 发短信通知医生
		SmsTemplateSendReq req = SmsUtil.getSmsTemplateSendReq(templateName,
				userDao.getUserMobile(orderInfo.getVendor()), null);
		// 患者名称
		req.getValues().add(buyerName);
		if (productType == Constant.Business.PRODUCT_TYPE_RICHTEXT && orderInfo.getPlusPrice() > 0) {
			req.setTemplateName("HuanZheJiaJiaShenQingTuWenZiXunFuWuHou");
			req.getValues().add(orderInfo.getPlusPrice() + "");
		} else {
			req.getValues().add(productName);
		}
		smsService.sendTemplate(req);
	}

	private boolean sendApplyAcceptButtonMessage(int productType,String productName,TOrderPublishInfo orderInfo){
		
		TStructuredMsg<TButtonMsg>  struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		//设置标题。带颜色
		buttonMsg.setTitle(productName);
		buttonMsg.setPrice(orderInfo.getRealPrice()+"");
		
		//生成按钮
		List<TButtonItemInfo> buttonList = new LinkedList<TButtonItemInfo>();
		buttonMsg.setButton(buttonList);
		TButtonItemInfo button = new TButtonItemInfo();
		//拒绝按钮信息
		button.setText(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("button.text.service.button.reject")));
		button.setEventKey("SERVICE_APPLY_ACCEPT_NO");
		button.setEventUrl(serverUrlRoot+productAcceptUrl);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("productApplyId",orderInfo.getProductApplyId());
		param.put("acceptFlag",3);
		button.setParam(param);
	
		buttonList.add(button);
		//同意按钮信息
		button = new TButtonItemInfo();
		button.setText(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("button.text.service.button.accept.ok")));
		if(productType==Constant.Business.PRODUCT_TYPE_TEL)
			button.setEventKey("SERVICE_APPLY_TEL_ACCEPT_OK");
		else
			button.setEventKey("SERVICE_APPLY_ACCEPT_OK");
				
		button.setEventUrl(serverUrlRoot+productAcceptUrl);
		param = new HashMap<String,Object>();
		param.put("productApplyId",orderInfo.getProductApplyId());
		param.put("acceptFlag",2);
		button.setParam(param);
		buttonList.add(button);
	
		buttonMsg.setStyle("horizontal");
		
		//设置底部信息
		TBottomInfo bottom = new TBottomInfo();
		buttonMsg.setBottom(bottom);
		bottom.setText(pushInnerService
				.getMessage(PushContentUtil.getBusinessPushContent("button.text.service.description.bottom")));
		bottom.setUrl(eventUrlRoot+orderDetailUrl+"?userId="+orderInfo.getVendor()+
				"&orderId="+orderInfo.getOrderId());
		
		//整个struMsg转换成json消息
		String content = JSON.toJSONString(struMsg);
		String productTypeName = ProductUtil.getProductName(orderInfo.getProductType());
		String tipText = pushInnerService
				.getMessage(PushContentUtil.getBusinessPushContent("button.tips.service.new.apply",
						new Object[] { productTypeName == null ? productName : productTypeName }));// chat提示
		ImMessageInfo im = ImMessageUtil.getSysImMessageButton(productType,orderInfo.getBuyer()
				,orderInfo.getVendor(),content,orderInfo.getProductApplyId(),tipText);//Constant.Business.PRODUCT_TYPE_TEL
		return messageService.sendInnerMessage(im);
	}

	private void sendTelConsultingApplyNotifyToDoctor(TOrderPublishInfo orderInfo) {

		// TODO Auto-generated method stub
		// 1.发推送通知给医生App
		String productName = ProductUtil.getProductName(orderInfo.getProductType());
		sendApplyNotifyToDoctor(Constant.Business.PRODUCT_TYPE_TEL, productName, orderInfo);

		// 2. 发送医生第二条通知：同意或拒绝按钮
		sendApplyAcceptButtonMessage(Constant.Business.PRODUCT_TYPE_TEL, productName, orderInfo);

	}

	private void sendTelConsultingApplyNotifyToPatient(TOrderPublishInfo orderInfo) {

		// 1. 发给患者微信推送通知1
		sendApplyNotifyToPatient(Constant.Business.PRODUCT_TYPE_TEL,
				ProductUtil.getProductName(orderInfo.getProductType()), orderInfo);

	}
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :sendRichTextConsultingFirstNotifyToDoctor
	 * @Description:图文资讯申请首次发送
	 * @return void
	 * @date 2016年10月18日 上午11:52:18
	 */
	public void sendRichTextConsultingFirstNotifyToDoctor(ProductServiceApply psa,String message){
		TOrderPublishInfo orderInfo = new TOrderPublishInfo();
		orderInfo.setOrderId(psa.getOrderId());
		orderInfo.setProductType(psa.getProductType());
		orderInfo.setVendor(psa.getVendor());
		orderInfo.setBuyer(psa.getBuyer());
		orderInfo.setWxProductId(psa.getWxProductId());
		orderInfo.setInPackage(psa.getInPackage());
		//图文申请内容
		sendRichTextConsultingApplyNotifyToDoctor(orderInfo);
		//消息内容
		ImMessageInfo im = null;
		if(StringUtils.isNotEmpty(message)){
			im = JsonUtil.toObject(message, ImMessageInfo.class);
			messageService.sendInnerMessage(im);
		}
		
		//发送病历卡
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("userId", psa.getBuyer());
		LinkedHashMap<String, String> patient= patientDao.queryPatientInfoCard(param);
		if(patient.get("diagnosis")!=null||patient.get("pathologyDiagnosis")!=null){
			String nonull = "无";
			String title = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("im.message.patient.card.title"));
			String description = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("im.message.patient.card.description", new Object[]{
				patient.get("sex"),patient.get("age"),patient.get("diagnosis")==null?nonull:patient.get("diagnosis"),
						patient.get("pathologyDiagnosis")==null?nonull:patient.get("pathologyDiagnosis"),
						patient.get("followupResultValue")==null?nonull:patient.get("followupResultValue")
			}));
			String linkUrl="event://to/patient/profile?patientUserId="+psa.getBuyer();
			String content = ImMessageUtil.getRichTextMessage(title, description, null, null, linkUrl);
			im = ImMessageUtil.getSysImMessageButton(0, psa.getBuyer(), psa.getVendor(), content, psa.getProductApplyId(), null);
			im.setFromSystem(1);
			im.setHideInChatList(1);
			messageService.sendInnerMessage(im);
		}

		if(psa.getMessageSource()!=null&&1==psa.getMessageSource()){
			im = null;
			HashMap<String, Object> hm = patientDao.getHospitalByPatientUserId(psa.getBuyer());
			String title = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("im.message.ask.billing.doctor.title"));
			String linkUrl="event://public/html/servicelist/checkresult/check_result_index.html?"
					+ "hospitalId="+hm.get("hospitalId")
					+ "&hospitalUserId="+hm.get("hospitalUserId")
					+ "&patientId="+hm.get("patientId")
					+ "&userId="+psa.getBuyer();
			String description = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("im.message.ask.billing.doctor.desc"));
			String content = ImMessageUtil.getRichTextMessage(title, description, null, null, linkUrl);
			im = ImMessageUtil.getSysImMessageButton(0, psa.getBuyer(), psa.getVendor(), content, null, null);
			im.setFromSystem(1);
			im.setHideInChatList(1);
			messageService.sendInnerMessage(im);
		}
	}
	
	public void sendRichTextConsultingFirstNotifyToDoctor(ProductServiceApply psa,Integer num){
		if(num==null)
			return;
		DoctorSimpleInfo doctorInfo = doctorDao.queryDoctorSimpleInfo(null, psa.getVendor());
		String content = "";
		Patient patient = patientDao.findByUserId(psa.getBuyer());
		String tag = "";
		boolean sendSmsFlag = false;
		switch (num) {
		case -1:
			if(psa.getRealPrice()>0)
				tag="push.doctor.richtext.time.pay.-1";
			else
				tag="push.doctor.richtext.time.no.pay.-1";
			sendSmsFlag = true;
			break;
		case 1:
			tag="push.doctor.richtext.time.1";
			break;
		case 12:
			tag="push.doctor.richtext.time.12";
			break;
		}
		if(StringUtils.isBlank(tag))
			return;
		content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(tag, patient.getTrueName()));
		if(StringUtils.isBlank(content))
			return;
		try{
		//消息发送
		PushNotifyInfo notifyInfo = PushUtil.getAppPushNotifyInfoForApplyWaitHandle(psa.getBuyer(),psa.getVendor(), content);
		pushInnerService.push(notifyInfo);
		}catch(Exception e){
			LogUtil.logError.error("push Error,msg{}",e.getMessage());
		}
		if(sendSmsFlag){
			//短信发送
			List<String> mobiles = new ArrayList<String>();
			mobiles.add(doctorInfo.getMobile());
			SmsContentSendReq req = SmsUtil.getSmsContentSendReq(content, mobiles);
			req.setContent(content);
			try{
			smsService.sendContent(req);
			}catch(Exception e){
				LogUtil.logError.error("sms Error,msg{}",e.getMessage());
			}
		}
	}
	
	//服务申请时不推送
	private void sendRichTextConsultingApplyNotifyToDoctor(TOrderPublishInfo orderInfo) {

		String productName = ProductUtil.getProductName(orderInfo.getProductType());

		// modified by Daloong, 2016/1/30
		// 先发消息，再发新申请推送。因为Android端只显示最近的推送，确保新申请推送不会被覆盖

		// 1. 发送医生第二条tips：患者希望得到您的解答，如未回复，24小时内将退款
		String content = pushInnerService.getMessage(
				PushContentUtil.getBusinessPushContent("tips.service.richtextconsult.applynotify.todoctor.2"));
		ImMessageInfo im = ImMessageUtil.getSysImMessageTips(1, orderInfo.getBuyer(), orderInfo.getVendor(), content);
		im.setTipText(pushInnerService.getMessage(
				PushContentUtil.getBusinessPushContent("button.tips.service.new.apply", new Object[] { productName })));
		im.setHideInChatList(0);// 显示tips
		// 如果wxproductId不是null 则需要医生端向该通道推送消息
		if (orderInfo.getWxProductId() != null) {
			im.setAudienceProductId(orderInfo.getWxProductId());
		}
		messageService.sendInnerMessage(im);

		// 2.发出推送
		// 通过订购关系查询接口获得吸顶提示，不再下发消息
		// TODO Auto-generated method stub
		// .发推送通知给医生App
		sendApplyNotifyToDoctor(Constant.Business.PRODUCT_TYPE_RICHTEXT, productName, orderInfo);

	}

	private void sendRichTextConsultingApplyNotifyToPatient(TOrderPublishInfo orderInfo) {

		// 1. 发给患者微信推送通知1
		String doctorName = getUserTrueName(orderInfo.getVendor(), 2);
		String code = orderInfo.getInPackage() == 1 ? "push.service.richtextconsult.vip.applynotify.topatient"
				: "push.service.richtextconsult.applynotify.topatient";
		String content = pushInnerService
				.getMessage(PushContentUtil.getBusinessPushContent(code, new Object[] { doctorName }));
		PushNotifyInfo notifyInfo = PushUtil.getWxDataPushNotifyInfo(orderInfo.getBuyer(), content);
		PushNotifyUtil.setSendWxProductId(notifyInfo, orderInfo.getWxProductId());
		pushInnerService.push(notifyInfo);
	}

	private String getUserTrueName(Long userId, int role) {
		// TODO Auto-generated method stub
		try {
			return userDao.getUserTrueName(userId, role);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.logError.error("ERROR in userDao.getUserTrueName():" + e.getMessage());

		}
		return "";
	}

	// 医院服务包推送
	public void sendHospitalPackApplyNotify(TOrderPublishInfo orderInfo) {
		// TODO Auto-generated method stub
		try {
			sendHospitalPackApplyNotifyToDoctor(orderInfo);
		} catch (Exception e) {
			LogUtil.logError.error("sendHospitalPackApplyNotify() exception: " + e.getMessage());
			// 注意，不再对外抛出异常。在这里终结异常。即：消息推送失败不能影响业务流程。
		}
	}

	private void sendHospitalPackApplyNotifyToDoctor(TOrderPublishInfo orderInfo) {
		// TODO Auto-generated method stub

	}

	public void sendMdtApplyNotify(TOrderPublishInfo orderInfo) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try {
			ProductServiceConf conf = productApplyDao.getProductServiceConfById(orderInfo.getProductId());
			sendMdtApplyNotifyToPatient(orderInfo, conf);
			sendMdtApplyNotifyToAgent(orderInfo, conf);
		} catch (Exception e) {
			LogUtil.logError.error("sendMdtApplyNotify() productType=" + orderInfo.getProductType() + ". exception: "
					+ e.getMessage());
			// 注意，不再对外抛出异常。在这里终结异常。即：消息推送失败不能影响业务流程。

		}
	}

	private void sendMdtApplyNotifyToPatient(TOrderPublishInfo orderInfo, ProductServiceConf conf) {
		// TODO Auto-generated method stub
		String vendorName = "";
		if (orderInfo.getAgentApplicant() != null) {
			vendorName = orderInfo.getRecommendedDoctor();
			List<String> values = new ArrayList<String>();
			if (orderInfo.getState() == 1) {
				values.add(pushInnerService.getMessage(
						PushContentUtil.getBusinessPushContent("push.service.mdt.apply.mdt.upload.notify.topatient.1",
								new Object[] { orderInfo.getOrderTitle() })));
				values.add("会诊资料");
				values.add(userDao.getUserTrueName(orderInfo.getBuyer(), Constant.User.ROLE_PATIENT));
				values.add("请尽快上传");
				values.add(pushInnerService.getMessage(
						PushContentUtil.getBusinessPushContent("push.service.mdt.apply.mdt.upload.notify.topatient.2",
								new Object[] { orderInfo.getOrderTitle() })));
				String url = serverH5UrlRoot + mdtUpload + "?fromUserName="
						+ userDao.getOpenIdByUserId(orderInfo.getBuyer(),orderInfo.getWxProductId()) + "&orderId=" + orderInfo.getOrderId()
						+ "&productId=" + orderInfo.getProductId() + "&agentApplicant=" + orderInfo.getAgentApplicant()
						+ "&recommendedDoctor=" + URLEncoder.encode(vendorName) + "&allowGoldRoll=" + orderInfo.getAllowGoldRoll();
				PushNotifyInfo notifyInfo = PushUtil.getWxTemplatePushNotifyInfo("binglishangchuantongzhi", url,
						values);
				notifyInfo.setUserId(orderInfo.getBuyer());
				PushNotifyUtil.setSendWxProductId(notifyInfo, orderInfo.getWxProductId());
				pushInnerService.push(notifyInfo);
			} else {
				values.add(pushInnerService.getMessage(
						PushContentUtil.getBusinessPushContent("push.service.mdt.apply.pay.notify.topatient.1",
								new Object[] { vendorName, orderInfo.getOrderTitle() })));
				values.add("会诊费");
				values.add(orderInfo.getTotalPrice() + "元");
				values.add(pushInnerService.getMessage(
						PushContentUtil.getBusinessPushContent("push.service.mdt.apply.pay.notify.topatient.2")));
				values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(
						"push.service.mdt.apply.pay.notify.topatient.3", new Object[] { vendorName })));
				String url = serverH5UrlRoot + mdtPay + "?fromUserName="
						+ userDao.getOpenIdByUserId(orderInfo.getBuyer(),orderInfo.getWxProductId()) + "&orderId=" + orderInfo.getOrderId()
						+ "&productId=" + orderInfo.getProductId() + "&agentApplicant=" + orderInfo.getAgentApplicant()
						+ "&recommendedDoctor=" + URLEncoder.encode(vendorName) + "&allowGoldRoll=" + orderInfo.getAllowGoldRoll();
				PushNotifyInfo notifyInfo = PushUtil.getWxTemplatePushNotifyInfo("fukuantongzhi", url, values);
				notifyInfo.setUserId(orderInfo.getBuyer());
				PushNotifyUtil.setSendWxProductId(notifyInfo, orderInfo.getWxProductId());
				pushInnerService.push(notifyInfo);
			}
			return;
		}
		String recommendedDoctor = productApplyDao
				.getProductServiceApplyRecommendedDoctor(orderInfo.getProductApplyId());
		if (recommendedDoctor == null || "".equals(recommendedDoctor.trim()))
			return;

		String nname;
		try {
			nname = URLEncoder.encode(recommendedDoctor);
		} catch (Exception e) {
			nname = recommendedDoctor;
		}
		String url = serverH5UrlRoot + mdtDiseaseEvaluation + "?fromUserName="
				+ userDao.getOpenIdByUserId(orderInfo.getBuyer(),orderInfo.getWxProductId()) + "&productApplyId=" + orderInfo.getProductApplyId()
				+ "&recommendedDoctor=" + nname;
		List<String> values = new ArrayList<String>();
		values.add(pushInnerService
				.getMessage(PushContentUtil.getBusinessPushContent("push.service.mdt.apply.notify.topatient.1")));
		values.add(recommendedDoctor);
		values.add(pushInnerService
				.getMessage(PushContentUtil.getBusinessPushContent("push.service.mdt.apply.notify.topatient.2")));
		values.add(pushInnerService
				.getMessage(PushContentUtil.getBusinessPushContent("push.service.mdt.apply.notify.topatient.3")));
		PushNotifyInfo notifyInfo = PushUtil.getWxTemplatePushNotifyInfo("bingqingpinggubiaotianxie", url, values);
		notifyInfo.setUserId(orderInfo.getBuyer());
		PushNotifyUtil.setSendWxProductId(notifyInfo, orderInfo.getWxProductId());
		pushInnerService.push(notifyInfo);
		LogUtil.log.debug("============================ send bingqingpinggubiaotianxie from patient success");
	}

	private void sendMdtApplyNotifyToAgent(TOrderPublishInfo orderInfo, ProductServiceConf conf) {
		// 给申请人发送消息
		if (conf.getIsApplyPushNotifyToAgent() == 1) {
			sendMdtApplyNotifyToAgent(conf.getProductType(), conf.getProductName(), orderInfo);
		}
	}

	private void sendMdtApplyNotifyToAgent(int productType, String productName, TOrderPublishInfo orderInfo) {
		if (productType == Constant.Business.PRODUCT_TYPE_MDT) {
			if (orderInfo.getAgentApplicant() != null) {
				if (orderInfo.getState() == 1) {
					String message = pushInnerService.getMessage(PushContentUtil
							.getBusinessPushContent("push.service.mdt.apply.pay.ok.notify.toagent", new Object[] {
									userDao.getUserTrueName(orderInfo.getBuyer(), Constant.User.ROLE_PATIENT) }));
					TStructuredMsg<TButtonMsg> struMsg = new TStructuredMsg<TButtonMsg>();
					TButtonMsg buttonMsg = new TButtonMsg();
					struMsg.setMsgType("button");
					struMsg.setMsgBody(buttonMsg);
					// 设置标题。带颜色
					buttonMsg.setTitle(null);
					buttonMsg.setDescription(message);
					buttonMsg.setPrice(null);
					buttonMsg.setButton(null);
					TBottomInfo bottomInfo = new TBottomInfo();
					buttonMsg.setBottom(bottomInfo);
					bottomInfo.setText("点击去上传");
					bottomInfo.setUrl("event://mdt/emr/upload?orderId=" + orderInfo.getOrderId());
					ImMessageInfo im = ImMessageUtil.getEDoctorAssistCustomMessage(orderInfo.getAgentApplicant(),
							JsonUtil.toJson(struMsg), message);

					// pushcontent
					Map<String, Object> eventInfo = new HashMap<String, Object>();
					eventInfo.put("orderId", orderInfo.getOrderId());
					eventInfo.put("userId", Constant.User.SuizhenAssist);
					PushClientEventInfo event = new PushClientEventInfo();
					event.setEventType(Constant.Push.EVENT_TYPE_MDT_APPLY);
					event.setEventTip(message);
					event.setEventInfo(JsonUtil.toJson(eventInfo));

					// set pushcontent
					im.setPushContent(JsonUtil.toJson(event));
					messageService.sendInnerMessage(im);
					// 推送
					// PushNotifyInfo info =
					// PushUtil.getAppPushNotifyInfo(orderInfo.getAgentApplicant(),Constant.Push.EVENT_TYPE_MDT_APPLY,JsonUtil.toJson(eventInfo),message);
					// pushInnerService.push(info);
				}
			}
		}
	}

	//给医生推送消息
	public void sendNewsToDoctor(String tipContent, String description, Long doctorUserId) {
		String content = ImMessageUtil.getPicTextMessage(description, null);
		ImMessageInfo message = ImMessageUtil.getEDoctorAssistCustomMessage(doctorUserId, content, tipContent);
		//message.setServiceId(1);
		this.messageService.sendInnerMessage(message);
	}
	
	//给基层病理医生推送做病理消息
	public void sendReportToPathologyDoctor(SMDTApply smdtApply ,String productApplyId) {
		TProductApply productApply = this.productApplyDao.findApplyInfo(productApplyId);
		//获取病历医生列表
		List<Doctor> doctors = this.doctorDao.findPathologyDoctors(productApply.getApplyHospitalId());
		if (doctors == null || doctors.isEmpty()) {
			return;
		}
		
		boolean isPush = true;
		TProductApply productApply_mdt = this.productApplyDao.findApplyInfo(productApplyId);
		Doctor doc = this.doctorDao.findByUserId(productApply_mdt.getAgentApplicant());
		
		
		for (Doctor doctor : doctors) {
//			this.sendPathologyCheckNews(productApply.getPatientName(), productApply.getAgentApplicantName(), doctor);
			push(smdtApply , productApply , doctor);
			LogUtil.log.info("基层医生ID："+doc.getDoctorId()+"基层病理医生ID："+doctor.getDoctorId()+"是否为同一人："+(doc.getDoctorId().longValue()==doctor.getDoctorId().longValue()));
			if(doc.getDoctorId()!=null&&doctor.getDoctorId()!=null&&doc.getDoctorId().longValue()==doctor.getDoctorId().longValue())
			{
				isPush = false;
			}
		}
		
		if(isPush)
		{
			push(smdtApply , productApply , doc);
		}
	}
	
	public void push2(TProductApply productApply , Doctor doctor)
	{
		LogUtil.log.info("patientName"+productApply.getPatientName());
		String message = messageSource.getMessage("push.service.mdt.state7", new Object[] {productApply.getPatientName() }, Locale.getDefault());
		
		TStructuredMsg<TButtonMsg> struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		// 设置标题。带颜色
		buttonMsg.setTitle(null);
		buttonMsg.setDescription(message);
		buttonMsg.setPrice(null);
		buttonMsg.setButton(null);
		TBottomInfo bottomInfo = new TBottomInfo();
		buttonMsg.setBottom(bottomInfo);
		bottomInfo.setText("点击去上传");
		bottomInfo.setUrl("event://mdt/pathology/write?&cardType=16&patientId="+productApply.getPatientId()
				+"&patientName="+productApply.getPatientName()
				+"&patientUserId="+productApply.getBuyer()
				+"&doctorId="+doctor.getDoctorId()
				+"&productApplyId="+productApply.getProductApplyId());
		ImMessageInfo im = ImMessageUtil.getEDoctorAssistCustomMessage(doctor.getUserId(),
				JsonUtil.toJson(struMsg), message);

		// pushcontent
		Map<String,Object> eventInfo = new HashMap<String, Object>();
		eventInfo.put("userId", Constant.User.SuizhenAssist);
		PushClientEventInfo event = new PushClientEventInfo();
		event.setEventType(Constant.Push.EVENT_TYPE_MDT_STATE7);
		event.setEventTip(message);
		event.setEventInfo(JsonUtil.toJson(eventInfo));

		// set pushcontent
		im.setPushContent(JsonUtil.toJson(event));
		messageService.sendInnerMessage(im);
	}
	//给基层病理医生推送消息
	public void sendPathologyCheckNews(String patientName, String agentApplicantName, Doctor doctor) {
		String tipContent = messageSource.getMessage("text.mdt.title", null, locale);
		String description = messageSource.getMessage("push.service.mdt.apply.pathology.doctor.check.news",
				new String[]{doctor.getTrueName(), agentApplicantName, patientName}, locale);
		String content = ImMessageUtil.getPicTextMessage(description, null);
		ImMessageInfo message = ImMessageUtil.getEDoctorAssistCustomMessage(doctor.getUserId(), content, tipContent);
		//message.setServiceId(1);
		this.messageService.sendInnerMessage(message);
	}
	
	public void push(SMDTApply smdtApply , TProductApply productApply , Doctor doctor)
	{
		LogUtil.log.info("patientName"+productApply.getPatientName());
		String message = messageSource.getMessage("push.service.mdt.state5", new Object[] {productApply.getPatientName() }, Locale.getDefault());
		
		TStructuredMsg<TButtonMsg> struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		// 设置标题。带颜色
		buttonMsg.setTitle(null);
		buttonMsg.setDescription(message);
		buttonMsg.setPrice(null);
		buttonMsg.setButton(null);
		TBottomInfo bottomInfo = new TBottomInfo();
		buttonMsg.setBottom(bottomInfo);
		bottomInfo.setText("点击处理");
		bottomInfo.setUrl("event://mdt/specimen/check?id="+smdtApply.getId()+"&doctorId="+doctor.getDoctorId()+"&userId="+doctor.getUserId());
		ImMessageInfo im = ImMessageUtil.getEDoctorAssistCustomMessage(doctor.getUserId(),
				JsonUtil.toJson(struMsg), message);

		// pushcontent
		Map<String,Object> eventInfo = new HashMap<String, Object>();
		eventInfo.put("userId", Constant.User.SuizhenAssist);
		PushClientEventInfo event = new PushClientEventInfo();
		event.setEventType(Constant.Push.EVENT_TYPE_MDT_STATE5);
		event.setEventTip(message);
		event.setEventInfo(JsonUtil.toJson(eventInfo));

		// set pushcontent
		im.setPushContent(JsonUtil.toJson(event));
		messageService.sendInnerMessage(im);
	}

	/**
	 * 
	 * @author lichenghao
	 * @title :sendFollowupMessageApplyNotify
	 * @Description:随访消息发送
	 * @return void
	 * @date 2016年10月9日 上午8:53:25
	 */
	public void sendFollowupMessageApplyNotify(TOrderPublishInfo orderInfo) {
		// TODO Auto-generated method stub
		try{
			sendFollowupMessageApplyNotifyToPatient(orderInfo);
			sendFollowupMessageApplyNotifyToDoctor(orderInfo);
		} catch (Exception e) {
			LogUtil.logError.error("sendFollowupMessageApplyNotify() exception: " + e.getMessage());
			// 注意，不再对外抛出异常。在这里终结异常。即：消息推送失败不能影响业务流程。
	
		}
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :sendFollowupMessageApplyNotifyToDoctor
	 * @Description:随访消息 发给医生
	 * @return void
	 * @date 2016年10月9日 上午8:59:49
	 */
	private void sendFollowupMessageApplyNotifyToDoctor(TOrderPublishInfo orderInfo) {
		// TODO Auto-generated method stub
		String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("tips.followup.message.apply.notify.to.doctor"));
		ImMessageInfo im = ImMessageUtil.getSysImMessageTips(1,orderInfo.getBuyer(),orderInfo.getVendor(),content);
		messageService.sendInnerMessage(im);
	}


	/**
	 * 
	 * @author lichenghao
	 * @title :sendFollowupMessageApplyNotifyToPatient
	 * @Description:随访消息内容给患者
	 * @return void
	 * @date 2016年10月9日 上午8:55:26
	 */
	private void sendFollowupMessageApplyNotifyToPatient(TOrderPublishInfo orderInfo) {
		// TODO Auto-generated method stub
		//tips 消息
		String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("tips.followup.message.apply.notify.to.patient"));
		ImMessageInfo im = ImMessageUtil.getSysImMessageTips(0,orderInfo.getVendor(),orderInfo.getBuyer(),content);
		im.setSpeakerRole(Constant.User.ROLE_DOCTOR);
		im.setAudienceRole(Constant.User.ROLE_PATIENT);
		messageService.sendInnerMessage(im);
	}
}
