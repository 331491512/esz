/**
 * 
 */
package com.esuizhen.cloudservice.business.notify.sender;

import java.util.ArrayList;
import java.util.Date;
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
import com.esuizhen.cloudservice.business.bean.DoctorClinicUsageSetReq;
import com.esuizhen.cloudservice.business.dao.business.ProductApplyDao;
import com.esuizhen.cloudservice.business.dao.business.UserDao;
import com.esuizhen.cloudservice.business.model.business.ProductServiceApply;
import com.esuizhen.cloudservice.business.service.business.impl.ProductApplyServiceImpl;
import com.esuizhen.cloudservice.business.util.ProductUtil;
import com.westangel.common.bean.ExpressCompany;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.common.bean.message.structuration.TBottomInfo;
import com.westangel.common.bean.message.structuration.TButtonItemInfo;
import com.westangel.common.bean.message.structuration.TButtonMsg;
import com.westangel.common.bean.message.structuration.TStructuredMsg;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.sms.SmsTemplateSendReq;
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
 * 产品申请处理（接受或拒绝、取消等）需要发出的推送通知或消息
 * @author bigdragon
 * @date   2016/1/7
 *
 */
@Component
public class ApplyAcceptNotifySender {
	private Locale locale=Locale.getDefault();

	@Value("${server.api.url.root}")
	private String serverUrlRoot;

	@Value("${event.api.url.root}")
	private String eventUrlRoot;		

	@Value("${server.h5.url.root}")
	private String serverH5UrlRoot;

	@Value("${server.wx.url.root}")
	private String serverWxUrlRoot;

	@Value("${url.doctorservice.order.detail}")
	private String orderDetailUrl;
	
	@Value("${url.doctorservice.doctor.score}")
	private String doctorScoreUrl;
	
	@Value("${url.api.business.telconsult.time.modify}")
	private String telConsultTimeModifyUrl;
	
	@Value("${url.api.business.telconsult.makecall}")
	private String telConsultMakeCall;
	
	@Value("${url.api.business.to.text.consulting}")
	private String textPage;

	@Value("${url.api.business.to.tel.consulting}")
	private String telPage;

	@Value("${url.api.business.to.plus}")
	private String plusPage;
	
	@Value("${url.to.my.account}")
	private String myAccountUrl;
	
	@Autowired
	private PushInnerService pushInnerService;
	
	@Autowired
	private MessageInnerService messageService;
	
	@Autowired
	private SmsInnerService smsService;

	@Autowired
	private MessageSource messageSource;
	
	@Autowired 
	private UserDao  userDao;
	
	@Autowired 
	private ProductApplyDao  productDao;
	
	@Value("${url.api.business.record.post.index}")
	private String expressIndexPage;
	
	
	/**
	 * 图文咨询处理
	 * @param psa
	 */
	public void sendRichTextConsultingApplyAcceptNotify(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		try{
			sendRichTextConsultingApplyAcceptNotifyToDoctor(psa);
			sendRichTextConsultingApplyAcceptNotifyToPatient(psa);
		
		}catch(Exception e){
			//注意，不再对外抛出异常。在这里终结异常。即：消息推送失败不能影响业务流程。
			LogUtil.logError.error("sendRichTextConsultingApplyAcceptNotify() exception: "+e.getMessage());
		}

	}
	
	/**
	 * 电话咨询处理通知
	 * @param psa
	 */
	public void sendTelConsultingApplyAcceptNotify(ProductServiceApply psa) {
		try{
			
			sendTelConsultingApplyAcceptNotifyToDoctor(psa);
			sendTelConsultingApplyAcceptNotifyToPatient(psa);
		}
		catch(Exception e){
			//注意，不再对外抛出异常。在这里终结异常。即：消息推送失败不能影响业务流程。
			LogUtil.logError.error("sendTelConsultingApplyAcceptNotify() exception: "+e.getMessage());
		}
	}
	
	/** 
	 * 其他服务类型接收申请处理
	 * @param psa
	 */

	public void sendOtherApplyAcceptNotify(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		if (psa.getProductType() == Constant.Business.PRODUCT_TYPE_MDT
				|| psa.getProductType() == Constant.Business.PRODUCT_TYPE_OFFLINE
				|| psa.getProductType() == Constant.Business.PRODUCT_TYPE_REVIEW_APPOINTMENT)
			return;//MDT不发出推送 复查预约
		if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_INSPECTION_RESULT){
			//if(psa.getState()==5)  也不推送（2017-06-15）
			//	sendApplyCloseNotifyToPatient(psa);
			return;
		}
		try{
			switch(psa.getState()){
			  case  2: //同意
				  sendApplyAcceptOkNotifyToDoctor(psa);
				  sendApplyAcceptOkNotifyToPatient(psa);
				  break;
			  case  3: //拒绝
				  sendApplyRejectNotifyToDoctor(psa);
				  sendApplyRejectNotifyToPatient(psa);
				  break;	
			  case  6: //服务过期
			  case  7: //用户取消（患者通过客服取消）
				  sendApplyCancelNotifyToDoctor(psa);
				  sendApplyCancelNotifyToPatient(psa);
	              break;
			  case  5: //关闭（成功后）
				  //sendApplyCloseNotifyToDoctor(psa); //私人医生等，关闭后医生端不再需要推送
				  sendApplyCloseNotifyToPatient(psa);
				  break; 	
	        default:
	      	  break; //do nothing
			}
		}
		catch(Exception e){
			//注意，不再对外抛出异常。在这里终结异常。即：消息推送失败不能影响业务流程。
			LogUtil.logError.error("sendOtherApplyAcceptNotify() exception: "+e.getMessage());
		}
	
	}
	
	
	private void sendApplyCloseNotifyToPatient(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		String vendorName=getUserTrueName(psa.getVendor(),2);
		String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.text.service.description.expire.close.topatient",
				new Object[]{psa.getOrderTitle(),vendorName,psa.getOrderTitle(),DateUtil.getDateStr(psa.getExpireTime())}));
		PushNotifyInfo notifyInfo = PushUtil.getWxDataPushNotifyInfo(psa.getBuyer(),content);
		PushNotifyUtil.setSendWxProductId(notifyInfo, psa.getWxProductId());
		pushInnerService.push(notifyInfo);
		
		//2.发送短信
		if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_PRIVATE_DOCTOR){
			String templateName = "SiRenYiShengDaoQi";
			SmsTemplateSendReq req = SmsUtil.getSmsTemplateSendReq(templateName, userDao.getUserMobile(psa.getBuyer()), null);
			req.getValues().add(vendorName);
			if(psa.getPeriodFeeType()==2){
				req.getValues().add("包月");
			}else if(psa.getPeriodFeeType()==3){
				req.getValues().add("包年");
			}
			smsService.sendTemplate(req);
		}
	}

	private void sendApplyCloseNotifyToDoctor(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		TStructuredMsg<TButtonMsg>  struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		//设置标题。带颜色
		buttonMsg.setTitle(psa.getOrderTitle());
		buttonMsg.setPrice(psa.getRealPrice()+"");
		String description = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(
				"button.text.service.description.expire.close.todoctor", new Object[] { psa.getOrderTitle() }));
		buttonMsg.setDescription(description);
		
		//无按钮
	
		//设置底部信息
		TBottomInfo bottom = new TBottomInfo();
		buttonMsg.setBottom(bottom);
		bottom.setText(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("button.text.service.description.bottom")));
		bottom.setUrl(eventUrlRoot+orderDetailUrl+"?userId="+psa.getVendor()+
				"&orderId="+psa.getOrderId());
		
		//整个struMsg转换成json消息
		String content = JSON.toJSONString(struMsg);
		String tipText = pushInnerService.getMessage(
				PushContentUtil.getBusinessPushContent("tips.text.service.description.expire.close.todoctor",
						new Object[] { ProductUtil.getProductName(psa.getProductType()) }));// chat提示
		ImMessageInfo im = ImMessageUtil.getSysImMessageButton(psa.getProductType(),psa.getBuyer()
				,psa.getVendor(),content,psa.getProductApplyId(),tipText);
		messageService.sendInnerMessage(im);
	}

	private void sendApplyCancelNotifyToPatient(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		//1. 发给患者微信推送通知1
		String vendorName=getUserTrueName(psa.getVendor(),2);
		String code = psa.getInPackage()==1?"push.service.vip.cancel.notify.topatient":"push.service.cancel.notify.topatient";
		String content=pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(code, new Object[]{vendorName,psa.getOrderTitle()}));
		PushNotifyInfo notifyInfo = PushUtil.getWxDataPushNotifyInfo(psa.getBuyer(),content);
		PushNotifyUtil.setSendWxProductId(notifyInfo, psa.getWxProductId());
		pushInnerService.push(notifyInfo);
		
		//2.发送短信
		if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_PRIVATE_DOCTOR || psa.getProductType()== Constant.Business.PRODUCT_TYPE_CLINIC){
			String templateName = "SiRenYiShengWeiChuLi";
			if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_CLINIC){
				templateName = "YuYueJiaHaoWeiChuLi";
			}
			SmsTemplateSendReq req = SmsUtil.getSmsTemplateSendReq(templateName, userDao.getUserMobile(psa.getBuyer()), null);
			req.getValues().add(vendorName);
			smsService.sendTemplate(req);
		}
	}

	private void sendApplyCancelNotifyToDoctor(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		//先发出一个推送
		String buyerName = getUserTrueName(psa.getBuyer(),1);
		String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(
				"push.service.cancel.notify.todoctor", new Object[] { buyerName, psa.getOrderTitle() }));
		
		PushNotifyInfo notifyInfo = PushUtil.getAppPushNotifyInfoForServiceStateChange(psa.getBuyer(),
				psa.getVendor(),psa.getProductType(),content);
		pushInnerService.push(notifyInfo);
		
		// 再发一条提示消息
		TStructuredMsg<TButtonMsg>  struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		//设置标题。带颜色
		buttonMsg.setTitle(psa.getOrderTitle());
		buttonMsg.setPrice(psa.getRealPrice()+"");
		//buttonMsg.setState("tuikuan");
		String	description =pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(
				"button.text.service.description.cancel.24hour.timeout"));
		String tipText = pushInnerService
				.getMessage(PushContentUtil.getBusinessPushContent("button.tips.service.cancel.24hour.timeout",
						new Object[] { ProductUtil.getProductName(psa.getProductType()) }));
	
		buttonMsg.setDescription(description);
		
		//无按钮
	
		//设置底部信息
		TBottomInfo bottom = new TBottomInfo();
		buttonMsg.setBottom(bottom);
		bottom.setText(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(
				"button.text.service.description.bottom")));
		bottom.setUrl(eventUrlRoot+orderDetailUrl+"?userId="+psa.getVendor()+
				"&orderId="+psa.getOrderId());
		
		//整个struMsg转换成json消息
		content = JSON.toJSONString(struMsg);
		ImMessageInfo im = ImMessageUtil.getSysImMessageButton(psa.getProductType(),psa.getBuyer()
				,psa.getVendor(),content,psa.getProductApplyId(),tipText);
		messageService.sendInnerMessage(im);
	}

	private void sendApplyRejectNotifyToPatient(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		String vendorName=getUserTrueName(psa.getVendor(),2);
		String content="";
		String code = psa.getInPackage()==1?"push.service.vip.reject.notify.topatient":"push.service.reject.notify.topatient";
			content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(code, new Object[]{vendorName,psa.getOrderTitle()}));
		PushNotifyInfo notifyInfo = PushUtil.getWxDataPushNotifyInfo(psa.getBuyer(),content);
		PushNotifyUtil.setSendWxProductId(notifyInfo, psa.getWxProductId());
		pushInnerService.push(notifyInfo);
		//2.发送短信
		if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_PRIVATE_DOCTOR || psa.getProductType()==Constant.Business.PRODUCT_TYPE_CLINIC){
			String templateName = "SiRenYiShengJuJue";
			if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_CLINIC){
				templateName = "YuYueJiaHaoJuJue";
			}
			SmsTemplateSendReq req = SmsUtil.getSmsTemplateSendReq(templateName, userDao.getUserMobile(psa.getBuyer()), null);
			req.getValues().add(vendorName);
			smsService.sendTemplate(req);
		}
	}

	private void sendApplyRejectNotifyToDoctor(ProductServiceApply psa) {
		// TODO Auto-generated method stub

		TStructuredMsg<TButtonMsg>  struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		//设置标题。带颜色
		buttonMsg.setTitle(psa.getOrderTitle());
		buttonMsg.setPrice(psa.getRealPrice()+"");
		//buttonMsg.setState("tuikuan");//医生端不再显示退款
		String description = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(
				"button.text.service.description.reject", new Object[] { psa.getOrderTitle() }));
		buttonMsg.setDescription(description);
		
		//无按钮
	
		//设置底部信息
		TBottomInfo bottom = new TBottomInfo();
		buttonMsg.setBottom(bottom);
		bottom.setText(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(
				"button.text.service.description.bottom")));
		bottom.setUrl(eventUrlRoot+orderDetailUrl+"?userId="+psa.getVendor()+
				"&orderId="+psa.getOrderId());
		
		//整个struMsg转换成json消息
		String content = JSON.toJSONString(struMsg);
		String tips=pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(
				"tips.service.reject.notify.todoctor", new Object[]{ProductUtil.getProductName(psa.getProductType())}));
		ImMessageInfo im = ImMessageUtil.getSysImMessageButton(psa.getProductType(),psa.getBuyer()
				,psa.getVendor(),content,psa.getProductApplyId(),tips);
		messageService.sendInnerMessage(im);
		
	}

	private void sendApplyAcceptOkNotifyToPatient(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		//1. 发给患者微信
		String vendorName=getUserTrueName(psa.getVendor(),2);
		String content = "";
		String vipBeginTimeStr=DateUtil.getDateStr(new Date());
		String vipEndTimeStr=DateUtil.getDateStr(psa.getExpireTime());
		String consultOrderTime="";//DateUtil.getDateStr(psa.getConsultOrderTime());
		if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_PRIVATE_DOCTOR ){
			Long doctorId = userDao.getDoctorId(psa.getVendor());
			String parames = "?fromUserName="+userDao.getOpenIdByUserId(psa.getBuyer(),psa.getWxProductId())+"&userId="+psa.getVendor()+"&doctorId="+doctorId;
			String texturl=serverH5UrlRoot+textPage+parames;
			String telurl=serverH5UrlRoot+telPage+parames;
			String plusurl=serverH5UrlRoot+plusPage+parames;
			String code = psa.getPeriodFeeType()==2?"push.service.privatedoctor.baoyue.acceptok.notify.topatient":"push.service.privatedoctor.baonian.acceptok.notify.topatient";
			content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(code,
					new Object[] { vendorName, vipBeginTimeStr, vipEndTimeStr, texturl, telurl, plusurl }));
				
		}
		else if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_CLINIC){
			consultOrderTime = JsonUtil.toObject(psa.getRemark(), DoctorClinicUsageSetReq.class).countClinicDateAndClinicTime();
			content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.service.clinic.acceptok.notify.topatient",
					new Object[]{vendorName,consultOrderTime}));
		}
		else
			content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.service.acceptok.notify.topatient",
					new Object[]{vendorName,psa.getOrderTitle()}));
				
		
		PushNotifyInfo notifyInfo = PushUtil.getWxDataPushNotifyInfo(psa.getBuyer(),content);
		PushNotifyUtil.setSendWxProductId(notifyInfo, psa.getWxProductId());
		pushInnerService.push(notifyInfo);
		
		//2. 发给患者短信
		if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_PRIVATE_DOCTOR || psa.getProductType()==Constant.Business.PRODUCT_TYPE_CLINIC){
			String templateName = "SiRenYiShengBaoYueTongYi";
			String mobile = null;
			if(psa.getPeriodFeeType()==3)
				templateName="SiRenYiShengBaoNianTongYi";
			if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_CLINIC){
				templateName="YuYueJiaHaoTongYi";
				mobile = psa.getContactMobile();
			}else{
				mobile = userDao.getUserMobile(psa.getBuyer());
			}
			SmsTemplateSendReq req = SmsUtil.getSmsTemplateSendReq(templateName, mobile, null);
			req.getValues().add(vendorName);
			if(psa.getProductType()!=Constant.Business.PRODUCT_TYPE_CLINIC){
				req.getValues().add(vipBeginTimeStr);
				req.getValues().add(vipEndTimeStr);
			}else if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_CLINIC){
				req.getValues().add(consultOrderTime);
			}
			smsService.sendTemplate(req);
		}
	}

	private void sendApplyAcceptOkNotifyToDoctor(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		
		//私人医生业务需要打出打款提示
		TStructuredMsg<TButtonMsg>  struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		//设置标题。带颜色
		buttonMsg.setTitle(psa.getOrderTitle());
		if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_PRIVATE_DOCTOR){
			buttonMsg.setPrice(psa.getRealPrice()+"");
			buttonMsg.setState("dakuan");
		}
		String description = pushInnerService
				.getMessage(PushContentUtil.getBusinessPushContent("button.tips.service.after.acceptok"));  
		buttonMsg.setDescription(description);
		
		//无按钮
	
		//设置底部信息
		TBottomInfo bottom = new TBottomInfo();
		buttonMsg.setBottom(bottom);
		bottom.setText(pushInnerService
				.getMessage(PushContentUtil.getBusinessPushContent("button.text.telconsult.description.bottom")));
		bottom.setUrl(eventUrlRoot+orderDetailUrl+"?userId="+psa.getVendor()+
				"&orderId="+psa.getOrderId());
		
		//整个struMsg转换成json消息
		String content = JSON.toJSONString(struMsg);
		String tipText = pushInnerService
				.getMessage(PushContentUtil.getBusinessPushContent("tips.service.acceptok.notify.todoctor",
						new Object[] { ProductUtil.getProductName(psa.getProductType()) })); 
		ImMessageInfo im = ImMessageUtil.getSysImMessageButton(psa.getProductType(),psa.getBuyer()
				,psa.getVendor(),content,psa.getProductApplyId(),tipText);
		messageService.sendInnerMessage(im);
	
	}

	/**
	 * 以下为图文咨询处理
	 * @param psa
	 */
	
	private void sendRichTextConsultingApplyAcceptNotifyToPatient(
			ProductServiceApply psa) {
		// TODO Auto-generated method stub
		switch(psa.getState()){
		
			  case  6: //服务过期
			  case  7: //用户取消
				  sendRichTextConsultingApplyCancelNotifyToPatient(psa);
	            break;
			  case 8: //患者关闭
			  case 9: //医生关闭图文咨询
			  case 5: //服务到期自行关闭
			       sendRichTextConsultingApplyCloseNotifyToPatient(psa);
			  	break;

				  
	        default:
	      	  break; //do nothing
	      	  
			
			}

	}

	/**
	 * 患者关闭图文咨询
	 * @param psa
	 */

	private void sendRichTextConsultingApplyCloseNotifyToPatient(
			ProductServiceApply psa) {
		// TODO Auto-generated method stub
		//1. 发给患者微信推送通知1
		String vendorName=getUserTrueName(psa.getVendor(),2);
		String scoreUrl=serverWxUrlRoot+doctorScoreUrl+"?productApplyId="+psa.getProductApplyId()+"&userId="+psa.getVendor();
		String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.service.richtextconsult.close.notify.topatient", 
				new Object[]{vendorName,scoreUrl})); 
		PushNotifyInfo notifyInfo = PushUtil.getWxDataPushNotifyInfo(psa.getBuyer(),content);
		PushNotifyUtil.setSendWxProductId(notifyInfo, psa.getWxProductId());
		pushInnerService.push(notifyInfo);
	
	}


	private void sendRichTextConsultingApplyCancelNotifyToPatient(
			ProductServiceApply psa) {
		//1. 发给患者微信推送通知1
		String vendorName=getUserTrueName(psa.getVendor(),2);
		String code = psa.getInPackage()==1?"push.service.richtextconsult.vip.cancel.notify.topatient":"push.service.richtextconsult.cancel.notify.topatient";
		String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(code, new Object[]{vendorName}));
		PushNotifyInfo notifyInfo = PushUtil.getWxDataPushNotifyInfo(psa.getBuyer(),content);
		PushNotifyUtil.setSendWxProductId(notifyInfo, psa.getWxProductId());
		pushInnerService.push(notifyInfo);
		
		//2.发送给患者短信
		String temple = "TuWenZiXunWeiHuiFu";
		if(psa.getInPackage()==1)
			temple = "TuWenZiXunVIPWeiFuiFu";
		SmsTemplateSendReq req = SmsUtil.getSmsTemplateSendReq(temple, userDao.getUserMobile(psa.getBuyer()), null);
		req.getValues().add(vendorName);
		smsService.sendTemplate(req);		

	}

	private void sendRichTextConsultingApplyAcceptNotifyToDoctor(
			ProductServiceApply psa) {
		switch(psa.getState()){
		  case  6: //服务过期
		  case  7: //用户取消
			  sendRichTextConsultingApplyCancelNotifyToDoctor(psa);
            break;
		  case  5://自动到期关闭
			  sendRichTextConsultingApplyCloseNotifyToDoctor(psa);
			  break;
		  case  8: //患者关闭
			  sendRichTextConsultingApplyCloseByPatientNotifyToDoctor(psa);
			  break;
		  case 9: //医生关闭
			  sendRichTextConsultingApplyCloseDoctorNotifyToPatient(psa);
			  sendRichTextConsultingApplyCloseByDoctorNotifyToDoctor(psa);

        default:
      	  break; //do nothing
      	  
		
		}
		
	}


	private void sendRichTextConsultingApplyCloseByDoctorNotifyToDoctor(
			ProductServiceApply psa) {
		// TODO Auto-generated method stub
		//1.发消息tips给医生App
		String content = pushInnerService.getMessage(
				PushContentUtil.getBusinessPushContent("tips.service.richtextconsult.close.bydoctor.notify.todoctor")); 
		ImMessageInfo im = ImMessageUtil.getSysImMessageTips(1,psa.getBuyer(),psa.getVendor(),content);
		messageService.sendInnerMessage(im);
	
	}
	
	private void sendRichTextConsultingApplyCloseDoctorNotifyToPatient(ProductServiceApply psa){
		//医生向患者发送关闭图文咨询总结
		if(StringUtils.isEmpty(psa.getSummarization()))
			return;
		String venderName = userDao.getUserTrueName(psa.getVendor(), 2);
		String content = pushInnerService.getMessage(
				PushContentUtil.getBusinessPushContent("tips.service.richtextconsult.close.bydoctor.notify.topatient",new Object[]{venderName,psa.getSummarization()})); 
		
		ImMessageInfo im = ImMessageUtil.getSysImMessageInfo();
		im.setSpeakerId(psa.getVendor());
		im.setSpeakerRole(2);
		im.setFromSystem(0);
		im.setAudienceId(psa.getBuyer());
		im.setAudienceRole(1);
		im.setServiceId(1);
		im.setContentType(1);
		im.setContent(content);
		im.setPushContent(content);
		messageService.sendInnerMessage(im);
	}

	private void sendRichTextConsultingApplyCloseByPatientNotifyToDoctor(
			ProductServiceApply psa) {
		// TODO Auto-generated method stub
		//1.发消息tips给医生App
		String content =  pushInnerService.getMessage(
				PushContentUtil.getBusinessPushContent("tips.service.richtextconsult.close.bypatient.notify.todoctor"));
		ImMessageInfo im = ImMessageUtil.getSysImMessageTips(1,psa.getBuyer(),psa.getVendor(),content);
		messageService.sendInnerMessage(im);
		
		//2.发送一条推送给医生，此推送为业务状态通知(eventType=5),医生客户端需要据此重新检查订购关系
		content = pushInnerService.getMessage(
				PushContentUtil.getBusinessPushContent("tips.service.richtextconsult.close.bypatient.notify.todoctor"));
		
		PushNotifyInfo notifyInfo = PushUtil.getAppPushNotifyInfoForServiceStateChange(psa.getBuyer(),psa.getVendor(),1,content);
		pushInnerService.push(notifyInfo);
	
	}

	//到期自动关闭
	private void sendRichTextConsultingApplyCloseNotifyToDoctor(
			ProductServiceApply psa) {
		// TODO Auto-generated method stub
		//1.发消息tips给医生App
		String content = pushInnerService.getMessage(
				PushContentUtil.getBusinessPushContent("tips.service.richtextconsult.close.notify.todoctor")); 
		ImMessageInfo im = ImMessageUtil.getSysImMessageTips(1,psa.getBuyer(),psa.getVendor(),content);
		messageService.sendInnerMessage(im);
		

	}

	private void sendRichTextConsultingApplyCancelNotifyToDoctor(
			ProductServiceApply psa) {
		//1.先发出一个推送
		String buyerName = getUserTrueName(psa.getBuyer(),1);
		String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(
				"tips.service.richtextconsult.cancel.notify.todoctor", new Object[] { buyerName })); 
		
		PushNotifyInfo notifyInfo = PushUtil.getAppPushNotifyInfoForServiceStateChange(psa.getBuyer(),
				psa.getVendor(),Constant.Business.PRODUCT_TYPE_RICHTEXT,content);
		pushInnerService.push(notifyInfo);
	
		//2.发消息tips给医生App
		ImMessageInfo im = ImMessageUtil.getSysImMessageTips(1,psa.getBuyer(),psa.getVendor(),content);
	
		messageService.sendInnerMessage(im);
	
		
	}

	
	
	/**
	 *  以下为电话咨询处理
	 * @param psa
	 */
	private void sendTelConsultingApplyAcceptNotifyToDoctor(ProductServiceApply psa) {
		
		switch(psa.getState()){
		  case  2: //同意
			  sendTelConsultingApplyAcceptOkNotifyToDoctor(psa);
			  break;
		  case  3: //拒绝
			  sendTelConsultingApplyRejectNotifyToDoctor(psa);
			  break;	
		  case  6: //服务过期
		  case  7: //用户取消（患者通过客服取消）
			  sendTelConsultingApplyCancelNotifyToDoctor(psa);
              break;
		  case  5: //关闭（电话拨号成功后）
			  sendTelConsultingApplyCloseNotifyToDoctor(psa);
			  break; 	
		  case  10://患者未接听电话
			  //sendTelConsultingApplyNoAnswerNotifyToDoctor(psa);
			  break;
		  case  11://延误30分钟未接听电话
			  sendTelConsultingApplyDelayNotifyToDoctor(psa);
			  break;
          default:
        	  break; //do nothing
        	  
  		
		}
	}
	
	
	private void sendTelConsultingApplyDelayNotifyToDoctor(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		//先发出一个推送
		String buyerName = getUserTrueName(psa.getBuyer(),1);
		String code = psa.getProgressState()==2?"push.service.telconsult.cancel.30min.patient.nocall.notify.todoctor":"push.service.telconsult.cancel.30min.nocall.notify.todoctor";
		String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(code, new Object[]{buyerName}));
		
		PushNotifyInfo notifyInfo = PushUtil.getAppPushNotifyInfoForServiceStateChange(psa.getBuyer(),
				psa.getVendor(),Constant.Business.PRODUCT_TYPE_TEL,content);
		pushInnerService.push(notifyInfo);
		
		//发出一个按钮消息
		TStructuredMsg<TButtonMsg>  struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		//设置标题。带颜色
		buttonMsg.setTitle(ProductUtil.getProductName(psa.getProductType()));
		buttonMsg.setPrice(psa.getRealPrice()+"");
		//buttonMsg.setState("tuikuan");
		String orderTime = DateUtil.getDateTimeShortStr(psa.getConsultOrderTime());
		String description = pushInnerService
				.getMessage(PushContentUtil.getBusinessPushContent(
						"button.text.telconsult.description.firstline.ordertime", new Object[] { orderTime }))
				+ pushInnerService.getMessage(PushContentUtil
						.getBusinessPushContent("button.text.telconsult.description.cancel.30min.nocall"));
		buttonMsg.setDescription(description);
		
		//无按钮
	
		//设置底部信息
		TBottomInfo bottom = new TBottomInfo();
		buttonMsg.setBottom(bottom);
		bottom.setText(pushInnerService.getMessage(PushContentUtil
				.getBusinessPushContent("button.text.telconsult.description.bottom")));
		bottom.setUrl(eventUrlRoot+orderDetailUrl+"?userId="+psa.getVendor()+
				"&orderId="+psa.getOrderId());
		
		//整个struMsg转换成json消息
		content = JSON.toJSONString(struMsg);
		String tipText = pushInnerService.getMessage(PushContentUtil
				.getBusinessPushContent("button.tips.telconsult.cancel.30min.nocall"));
		ImMessageInfo im = ImMessageUtil.getSysImMessageButton(Constant.Business.PRODUCT_TYPE_TEL,psa.getBuyer()
				,psa.getVendor(),content,psa.getProductApplyId(),tipText);
		messageService.sendInnerMessage(im);
		
		//发送短信给医生
		String templateName;
		if(psa.getProgressState()==2)
			templateName = "DianHuaZiXunYuQiHuanZheWeiJinXin";
		else
			templateName = "DianHuaZiXunYuQiYiShengWeiJinXin";
		SmsTemplateSendReq req = SmsUtil.getSmsTemplateSendReq(templateName, userDao.getUserMobile(psa.getVendor()), null);
		req.getValues().add(buyerName);
		smsService.sendTemplate(req);
	}

	private void sendTelConsultingApplyNoAnswerNotifyToDoctor(
			ProductServiceApply psa) {
		
		TStructuredMsg<TButtonMsg>  struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		//设置标题。带颜色
		buttonMsg.setTitle(ProductUtil.getProductName(psa.getProductType()));
		buttonMsg.setPrice(psa.getRealPrice()+"");
		//buttonMsg.setState("tuikuan");
		String orderTime = DateUtil.getDateTimeShortStr(psa.getConsultOrderTime());
		String description = 
				pushInnerService.getMessage(PushContentUtil
						.getBusinessPushContent("button.text.telconsult.description.firstline.ordertime",new Object[]{orderTime}))
				+pushInnerService.getMessage(PushContentUtil
						.getBusinessPushContent("button.text.telconsult.description.call.failure"));
		buttonMsg.setDescription(description);
		
		//无按钮
	
		//设置底部信息
		TBottomInfo bottom = new TBottomInfo();
		buttonMsg.setBottom(bottom);
		bottom.setText(pushInnerService.getMessage(PushContentUtil
				.getBusinessPushContent("button.text.telconsult.description.bottom")));
		bottom.setUrl(eventUrlRoot+orderDetailUrl+"?userId="+psa.getVendor()+
				"&orderId="+psa.getOrderId());
		
		//整个struMsg转换成json消息
		String content = JSON.toJSONString(struMsg);
		String tipText = pushInnerService.getMessage(PushContentUtil
				.getBusinessPushContent("button.tips.telconsult.call.failure"));//chat提示
		ImMessageInfo im = ImMessageUtil.getSysImMessageButton(Constant.Business.PRODUCT_TYPE_TEL,psa.getBuyer()
				,psa.getVendor(),content,psa.getProductApplyId(),tipText);
		messageService.sendInnerMessage(im);
	}

	private void sendTelConsultingApplyCloseNotifyToDoctor(
			ProductServiceApply psa) {

		TStructuredMsg<TButtonMsg>  struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		//设置标题。带颜色
		buttonMsg.setTitle(ProductUtil.getProductName(psa.getProductType()));
		buttonMsg.setPrice(psa.getRealPrice()+"");
		buttonMsg.setState("dakuan");
		String orderTime = DateUtil.getDateTimeShortStr(psa.getConsultOrderTime());
		String description = 
				pushInnerService.getMessage(PushContentUtil
						.getBusinessPushContent("button.text.telconsult.description.firstline.ordertime",new Object[]{orderTime}))
				+pushInnerService.getMessage(PushContentUtil
						.getBusinessPushContent("button.text.telconsult.description.success"));
		buttonMsg.setDescription(description);
		
		//无按钮
	
		//设置底部信息
		TBottomInfo bottom = new TBottomInfo();
		buttonMsg.setBottom(bottom);
		bottom.setText(pushInnerService.getMessage(PushContentUtil
				.getBusinessPushContent("button.text.telconsult.description.bottom")));
		bottom.setUrl(eventUrlRoot+orderDetailUrl+"?userId="+psa.getVendor()+
				"&orderId="+psa.getOrderId());
		
		//整个struMsg转换成json消息
		String content = JSON.toJSONString(struMsg);
		String tipText = pushInnerService.getMessage(PushContentUtil
				.getBusinessPushContent("button.tips.telconsult.success"));//chat提示
		ImMessageInfo im = ImMessageUtil.getSysImMessageButton(Constant.Business.PRODUCT_TYPE_TEL,psa.getBuyer()
				,psa.getVendor(),content,psa.getProductApplyId(),tipText);
		messageService.sendInnerMessage(im);
	}

	private void sendTelConsultingApplyCancelNotifyToDoctor(
			ProductServiceApply psa) {
		//先发出一个推送
		String buyerName = getUserTrueName(psa.getBuyer(),1);
		String content =pushInnerService.getMessage(PushContentUtil
						.getBusinessPushContent("push.service.cancel.notify.todoctor",new Object[]{buyerName,psa.getOrderTitle()}));
		
		PushNotifyInfo notifyInfo = PushUtil.getAppPushNotifyInfoForServiceStateChange(psa.getBuyer(),
				psa.getVendor(),Constant.Business.PRODUCT_TYPE_TEL,content);
		pushInnerService.push(notifyInfo);
		
		// 再发一条提示消息
		TStructuredMsg<TButtonMsg>  struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		//设置标题。带颜色
		buttonMsg.setTitle(ProductUtil.getProductName(psa.getProductType()));
		buttonMsg.setPrice(psa.getRealPrice()+"");
		//buttonMsg.setState("tuikuan");
		String description="";
		String tipText="";//chat提示
		description = pushInnerService.getMessage(PushContentUtil
				.getBusinessPushContent("button.text.telconsult.description.cancel.24hour.timeout"));
		tipText = pushInnerService.getMessage(PushContentUtil
				.getBusinessPushContent("button.tips.telconsult.cancel.24hour.timeout",new Object[]{ProductUtil.getProductName(psa.getProductType())}));
		buttonMsg.setDescription(description);
		
		//无按钮
	
		//设置底部信息
		TBottomInfo bottom = new TBottomInfo();
		buttonMsg.setBottom(bottom);
		bottom.setText(pushInnerService.getMessage(PushContentUtil
				.getBusinessPushContent("button.text.telconsult.description.bottom")));
		bottom.setUrl(eventUrlRoot+orderDetailUrl+"?userId="+psa.getVendor()+
				"&orderId="+psa.getOrderId());
		
		//整个struMsg转换成json消息
		content = JSON.toJSONString(struMsg);
		ImMessageInfo im = ImMessageUtil.getSysImMessageButton(Constant.Business.PRODUCT_TYPE_TEL,psa.getBuyer()
				,psa.getVendor(),content,psa.getProductApplyId(),tipText);
		messageService.sendInnerMessage(im);
		
	}



	private void sendTelConsultingApplyRejectNotifyToDoctor(
			ProductServiceApply psa) {
	
		TStructuredMsg<TButtonMsg>  struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		//设置标题。带颜色
		buttonMsg.setTitle(ProductUtil.getProductName(psa.getProductType()));
		buttonMsg.setPrice(psa.getRealPrice()+"");
		//buttonMsg.setState("tuikuan");
		String description = Constant.Business.BUTTON_DESC_PREFIX
				+pushInnerService.getMessage(PushContentUtil
						.getBusinessPushContent("button.tips.service.after.reject"));
		buttonMsg.setDescription(description);
		
		//无按钮
	
		//设置底部信息
		TBottomInfo bottom = new TBottomInfo();
		buttonMsg.setBottom(bottom);
		bottom.setText(pushInnerService.getMessage(PushContentUtil
				.getBusinessPushContent("button.text.telconsult.description.bottom")));
		bottom.setUrl(eventUrlRoot+orderDetailUrl+"?userId="+psa.getVendor()+
				"&orderId="+psa.getOrderId());
		
		//整个struMsg转换成json消息
		String content = JSON.toJSONString(struMsg);
		String tips = pushInnerService
				.getMessage(PushContentUtil.getBusinessPushContent("tips.service.reject.notify.todoctor",
						new Object[] { ProductUtil.getProductName(psa.getProductType()) }));
		ImMessageInfo im = ImMessageUtil.getSysImMessageButton(Constant.Business.PRODUCT_TYPE_TEL,psa.getBuyer()
				,psa.getVendor(),content,psa.getProductApplyId(),tips);
		messageService.sendInnerMessage(im);
		
	}



	private void sendTelConsultingApplyAcceptOkNotifyToDoctor(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		//1.发消息tips给医生App
		String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("tips.service.telconsult.acceptok.notify.todoctor")); 
		ImMessageInfo im = ImMessageUtil.getSysImMessageTips(2,psa.getBuyer(),psa.getVendor(),content);
		messageService.sendInnerMessage(im);
	
		
		//2.发消息2给医生App
		//modified by Daloong. 不足一小时时，不发出此消息。
		if(ProductApplyServiceImpl.isAllowedModifyTelConsultingTime(psa.getConsultOrderTime())){
			content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("tips.service.telconsult.acceptok.notify.todoctor.2"));
			im = ImMessageUtil.getSysImMessageTips(2,psa.getBuyer(),psa.getVendor(),content);
			messageService.sendInnerMessage(im);
		}
			
		//3. 发送医生按钮提示：更改时间/提前拨打按钮
		TStructuredMsg<TButtonMsg>  struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		//设置标题。带颜色
		buttonMsg.setTitle(ProductUtil.getProductName(psa.getProductType()));
		buttonMsg.setPrice(psa.getRealPrice()+"");
		String intervalTime=getIntervalTimeStr(psa.getIntervalTime());
		String orderTime = DateUtil.getDateTimeShortStr(psa.getConsultOrderTime());
		String description = 
				pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("button.text.telconsult.description.firstline.ordertime",new Object[]{orderTime}))
				+pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("button.text.telconsult.description.intervaltime",new Object[]{intervalTime}));
		buttonMsg.setDescription(description);
		
		//生成按钮
		List<TButtonItemInfo> buttonList = new LinkedList<TButtonItemInfo>();
		buttonMsg.setButton(buttonList);
		//如果在一小时内，不出现更改时间按钮
		if(ProductApplyServiceImpl.isAllowedModifyTelConsultingTime(psa.getConsultOrderTime())){
		
			TButtonItemInfo button = new TButtonItemInfo();
			//更改时间按钮信息
			button.setText(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("button.text.telconsult.button.changetime")));
			button.setEventKey("SERVICE_MODIFY_TEL_CONSULT_TIME");
			button.setEventUrl(serverUrlRoot+telConsultTimeModifyUrl);
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("productApplyId",psa.getProductApplyId());
			button.setParam(param);
			buttonList.add(button);
		}
			
		//提前拨打电话或拨打电话按钮信息
		TButtonItemInfo button = new TButtonItemInfo();
		String code = isTooShortTime(psa.getConsultOrderTime())?"button.text.telconsult.button.makecall":"button.text.telconsult.button.makecall.advance";
		button.setText(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(code)));
		button.setEventKey("SERVICE_DOING_MAKE_CALL");
		button.setEventUrl(serverUrlRoot+telConsultMakeCall+"?productApplyId="+
		 psa.getProductApplyId()+"&userId="+psa.getBuyer()+"&mobile="+psa.getContactMobile());
		buttonList.add(button);
		buttonMsg.setStyle("horizontal");
			
		//设置底部信息
		TBottomInfo bottom = new TBottomInfo();
		buttonMsg.setBottom(bottom);
		bottom.setText(pushInnerService
				.getMessage(PushContentUtil.getBusinessPushContent("button.text.telconsult.description.bottom")));
		bottom.setUrl(eventUrlRoot+orderDetailUrl+"?userId="+psa.getVendor()+
				"&orderId="+psa.getOrderId());
		
		//整个struMsg转换成json消息
		content = JSON.toJSONString(struMsg);
		String tipText = pushInnerService
				.getMessage(PushContentUtil.getBusinessPushContent("tips.service.acceptok.notify.todoctor",
						new Object[] { ProductUtil.getProductName(psa.getProductType()) }));
		im = ImMessageUtil.getSysImMessageButton(Constant.Business.PRODUCT_TYPE_TEL,psa.getBuyer()
				,psa.getVendor(),content,psa.getProductApplyId(),tipText);
		messageService.sendInnerMessage(im);
	
	}
	
	private boolean isTooShortTime(Date consultOrderTime) {
		long interval = (consultOrderTime.getTime()-System.currentTimeMillis())/1000;
		if(interval<=300){
			LogUtil.log.warn("#######  modify telconsulting time: in 5 min!");
			return true;
		}
		return false;
	}
	
	private String getIntervalTimeStr(int intervalTime) {
		// TODO Auto-generated method stub
		return DateUtil.getIntervalTimeStr(intervalTime);
	}

	private void sendTelConsultingApplyAcceptNotifyToPatient(ProductServiceApply psa) {
		switch(psa.getState()){
		  case  2: //同意
			  sendTelConsultingApplyAcceptOkNotifyToPatient(psa);
			  break;
		  case  3: //拒绝
			  sendTelConsultingApplyRejectNotifyToPatient(psa);
			  break;	
		  case  6: //服务过期
		  case  7: //用户取消
			  sendTelConsultingApplyCancelNotifyToPatient(psa);
            break;
		  case  5: //关闭(成功拨打电话后）
			  sendTelConsultingApplyCloselNotifyToPatient(psa);
		     break;   	
		  case  11://10和4不给用户发推送。当变成11时再发。
			  if(psa.getProgressState()==2) 
				  //用户未接听电话
				  sendTelConsultingApplyNoAnswerNotifyToPatient(psa);
			  else
				  sendTelConsultingApplyNoCallNotifyToPatient(psa);
		     break;	  
        default:
      	  break; //do nothing
		}
  
	}
	
	private void sendTelConsultingApplyNoCallNotifyToPatient(
			ProductServiceApply psa) {
		// TODO Auto-generated method stub
		//1. 发给患者微信推送通知1
		String vendorName=getUserTrueName(psa.getVendor(),2);
		String code = psa.getInPackage()==1?"push.service.telconsult.vip.nocall.notify.topatient":"push.service.telconsult.nocall.notify.topatient";
		String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(code, new Object[]{vendorName}));

		PushNotifyInfo notifyInfo = PushUtil.getWxDataPushNotifyInfo(psa.getBuyer(),content);
		PushNotifyUtil.setSendWxProductId(notifyInfo, psa.getWxProductId());
		pushInnerService.push(notifyInfo);
		
		//2.发送给患者短信
		String temple = "DianHuaZiXunYuQiWeiBoDa";
		if(psa.getInPackage()==1)
			temple = "DianHuaZiXunVIPYuQiWeiBoDa";
		SmsTemplateSendReq req = SmsUtil.getSmsTemplateSendReq(temple, userDao.getUserMobile(psa.getBuyer()), null);
		req.getValues().add(vendorName);
		smsService.sendTemplate(req);

		
	}
	
	private void sendTelConsultingApplyNoAnswerNotifyToPatient(
			ProductServiceApply psa) {
		// TODO Auto-generated method stub
		//1. 发给患者微信推送通知1
		String vendorName=getUserTrueName(psa.getVendor(),2);
		String code = psa.getInPackage()==1?"push.service.telconsult.vip.noanswer.notify.topatient":"push.service.telconsult.noanswer.notify.topatient";
		String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(code, new Object[]{vendorName}));
		PushNotifyInfo notifyInfo = PushUtil.getWxDataPushNotifyInfo(psa.getBuyer(),content);
		PushNotifyUtil.setSendWxProductId(notifyInfo, psa.getWxProductId());
		pushInnerService.push(notifyInfo);
		
		//2.发送给患者短信
		String temple = "DianHuaZiXunHuanZheWeiJieTing";
		if(psa.getInPackage()==1)
			temple = "DianHuaZiXunVIPHuanZheWeiJieTing";
		SmsTemplateSendReq req = SmsUtil.getSmsTemplateSendReq(temple, userDao.getUserMobile(psa.getBuyer()), null);
		smsService.sendTemplate(req);

		
	}

	private void sendTelConsultingApplyCloselNotifyToPatient(
			ProductServiceApply psa) {
		// TODO Auto-generated method stub
		//1. 发给患者微信推送通知1
		String vendorName=getUserTrueName(psa.getVendor(),2);
		String scoreUrl=serverWxUrlRoot+doctorScoreUrl+"?productApplyId="+psa.getProductApplyId()+"&userId="+psa.getVendor();
		String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(
				"push.service.telconsult.close.notify.topatient", new Object[] { vendorName, scoreUrl }));
		PushNotifyInfo notifyInfo = PushUtil.getWxDataPushNotifyInfo(psa.getBuyer(),content);
		PushNotifyUtil.setSendWxProductId(notifyInfo, psa.getWxProductId());
		pushInnerService.push(notifyInfo);


	}

	private void sendTelConsultingApplyCancelNotifyToPatient(
			ProductServiceApply psa) {
		// TODO Auto-generated method stub
		//1. 发给患者微信推送通知1
		String vendorName=getUserTrueName(psa.getVendor(),2);
		String code = psa.getInPackage()==1?"push.service.telconsult.vip.cancel.notify.topatient":"push.service.telconsult.cancel.notify.topatient";
		String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(code, new Object[]{vendorName}));
					
		PushNotifyInfo notifyInfo = PushUtil.getWxDataPushNotifyInfo(psa.getBuyer(),content);
		PushNotifyUtil.setSendWxProductId(notifyInfo, psa.getWxProductId());
		pushInnerService.push(notifyInfo);
		//2.发送给患者短信
		String temple = "DianHuaZiXunWeiChuLi";
		if(psa.getInPackage()==1)
			temple = "DianHuaZiXunVIPWeiChuLi";
		SmsTemplateSendReq req = SmsUtil.getSmsTemplateSendReq(temple, userDao.getUserMobile(psa.getBuyer()), null);
		req.getValues().add(vendorName);
		smsService.sendTemplate(req);
	}



	private void sendTelConsultingApplyRejectNotifyToPatient(
			ProductServiceApply psa) {
		// TODO Auto-generated method stub
		//1. 发给患者微信推送通知1
		String vendorName=getUserTrueName(psa.getVendor(),2);
		String code = psa.getInPackage()==1?"push.service.telconsult.vip.reject.notify.topatient":"push.service.telconsult.reject.notify.topatient";
		String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(code, new Object[]{vendorName}));

		PushNotifyInfo notifyInfo = PushUtil.getWxDataPushNotifyInfo(psa.getBuyer(),content);
		PushNotifyUtil.setSendWxProductId(notifyInfo, psa.getWxProductId());
		pushInnerService.push(notifyInfo);
		//2. 发给患者短信
		String temple = "DianHuaZiXunJuJue";
		if(psa.getInPackage()==1)
			temple = "DianHuaZiXunVIPJuJue";
		SmsTemplateSendReq req = SmsUtil.getSmsTemplateSendReq(temple, userDao.getUserMobile(psa.getBuyer()), null);
		req.getValues().add(vendorName);
		smsService.sendTemplate(req);
	}



	private void sendTelConsultingApplyAcceptOkNotifyToPatient(ProductServiceApply psa) {

		//1. 发给患者微信推送通知1
		String vendorName=getUserTrueName(psa.getVendor(),2);
		String code = psa.getInPackage() == 1 ? "push.service.telconsult.vip.acceptok.notify.topatient"
				: "push.service.telconsult.acceptok.notify.topatient";
		String content = pushInnerService.getMessage(
				PushContentUtil.getBusinessPushContent(code,
						new Object[] { vendorName, DateUtil.getDateTimeShortStr(psa.getConsultOrderTime()) }));
		PushNotifyInfo notifyInfo = PushUtil.getWxDataPushNotifyInfo(psa.getBuyer(),content);
		PushNotifyUtil.setSendWxProductId(notifyInfo, psa.getWxProductId());
		pushInnerService.push(notifyInfo);
		
		//2. 发给患者短信
		String temple = "DianHuaZiXunAnPaiShiJian";
		if(psa.getInPackage()==1){
			temple="DianHuaZiXunVIPAnPaiShiJian";
		}
		SmsTemplateSendReq req = SmsUtil.getSmsTemplateSendReq(temple, userDao.getUserMobile(psa.getBuyer()), null);
		req.getValues().add(vendorName);
		req.getValues().add(DateUtil.getDateTimeShortStr(psa.getConsultOrderTime()));
		smsService.sendTemplate(req);
	}

	
	private String getUserTrueName(Long userId,int role) {
		// TODO Auto-generated method stub
		try{
			return userDao.getUserTrueName(userId,role);
		}
		catch(Exception e){
			e.printStackTrace();
			LogUtil.logError.error("ERROR in userDao.getUserTrueName():"+e.getMessage());
			
		}
		
		
		return "";
	}
	

	public void sendMakeProfitSuccessNotify(ProductServiceApply psa, String debitRecId) {
		try{
			String content = pushInnerService
					.getMessage(PushContentUtil.getBusinessPushContent("push.service.makeprofit.success.todoctor",
							new Object[] { psa.getOrderTitle(), psa.getRealPrice() + "" }));
			PushNotifyInfo notifyInfo = PushUtil.getAppPushNotifyInfoForNewProfit(psa.getBuyer(),psa.getVendor(),
					psa.getProductType(),psa.getRealPrice(),debitRecId,content);
			pushInnerService.push(notifyInfo);
		}
		catch(Exception e){
			e.printStackTrace();
			LogUtil.logError.error("ERROR in sendMakeProfitSuccessNotify():"+e.getMessage());
			
		}
	}

	public void sendHospitalPackApplyNotify(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		try{
			sendHospitalPackApplyAcceptNotifyToDoctor(psa);
		}
		catch(Exception e){
			//注意，不再对外抛出异常。在这里终结异常。即：消息推送失败不能影响业务流程。
			LogUtil.logError.error("sendHospitalPackApplyAcceptNotify() exception: "+e.getMessage());
		}
	}

	private void sendHospitalPackApplyAcceptNotifyToDoctor(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		if(psa.getState()==2){
			
			String buyerName = userDao.getUserTrueName(psa.getBuyer(), 1);
			String mobile = productDao.getHospitalProductMobileByHospitalUserId(psa.getVendor());
			SmsTemplateSendReq req = SmsUtil.getSmsTemplateSendReq("FuWuBaoShenQingChengGong", mobile, null);
			req.getValues().add(buyerName);
			req.getValues().add(psa.getContactMobile());
			req.getValues().add(psa.getOrderTitle());
			req.getValues().add(DateUtil.getDateStr(psa.getExpireTime()));
			smsService.sendTemplate(req);
		}
	}


	public void sendCopyOfMedicalRecordExpressSendNotifyToPatient(String expressNum,ProductServiceApply psa){
		String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.copyExpress.notify.info",new Object[]{expressNum}));
		PushNotifyInfo notifyInfo = PushUtil.getWxDataPushNotifyInfo(psa.getBuyer(),content);
		PushNotifyUtil.setSendWxProductId(notifyInfo, psa.getWxProductId());
		pushInnerService.push(notifyInfo);
	}
	
	
	/**
	 * 病案邮寄消息处理
	 * @author lichenghao
	 * @title :sendMedicalRecordMailApplyNotify
	 * @Description:TODO
	 * @return void
	 * @date 2016年6月20日 下午3:50:34
	 */
	public void sendMedicalRecordMailApplyNotify(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		sendMedicalRecordMailApplyNotifyToPatient(psa);
	}
	
	/**
	 * 病案邮寄消息向患者发送
	 * @author lichenghao
	 * @title :sendMedicalRecordMailApplyNotifyToPatient
	 * @Description:TODO
	 * @return void
	 * @date 2016年6月20日 下午3:54:39
	 */
	private void sendMedicalRecordMailApplyNotifyToPatient(ProductServiceApply psa){
		switch (psa.getState()) {
		case 3:
			sendMedicalRecordMailApplyRejectNotifyToPatient(psa);
			break;
		case 7:
			sendMedicalRecordMailApplyBossRejectNotifyToPatient(psa);
			break;
		case 4:
			sendMedicalRecordMailApplyHandleNotifyToPatient(psa);
			break;
		default:
			break;
		}
	}
	
	/**
	 * 病案邮寄消息向患者发送 拒绝
	 * @author lichenghao
	 * @title :sendMedicalRecordMailApplyRejectNotifyToPatient
	 * @Description:TODO
	 * @return void
	 * @date 2016年6月20日 下午3:56:09
	 */
	private void sendMedicalRecordMailApplyRejectNotifyToPatient(ProductServiceApply psa){
		String url = serverH5UrlRoot+expressIndexPage+"?productSubType="+psa.getProductSubType()+"&productApplyId="+psa.getProductApplyId()
				+"&orderId="+psa.getOrderId();
		//String url = serverWxUrlRoot+expressIndexPage+"?hospitalUserId="+psa.getVendor();
		List<String> values = new ArrayList<String>();
		values.add(pushInnerService.getMessage(PushContentUtil
				.getBusinessPushContent("push.service.medicalrecordmail.apply.reject.notify.topatient",psa.getRealPrice())));
		values.add(psa.getOrderId());
		values.add(pushInnerService.getMessage(PushContentUtil
				.getBusinessPushContent("push.service.medicalrecordmail.apply.description")));
		values.add(messageSource.getMessage("push.service.medicalrecordmail.apply.state.3",null ,null));
		values.add(DateUtil.getDateStr(new Date()));
		values.add(pushInnerService.getMessage(PushContentUtil
				.getBusinessPushContent("push.service.medicalrecordmail.apply.template.remark")));
		PushNotifyInfo notifyInfo = PushUtil.getWxTemplatePushNotifyInfo("dingdanzhuangtaigenxingtongzhi", url, values);
		notifyInfo.setUserId(psa.getBuyer());
		PushNotifyUtil.setSendWxProductId(notifyInfo, psa.getWxProductId());
		pushInnerService.push(notifyInfo);
	}
	
	/**
	 * 病案邮寄拒绝消息
	 */
	private void sendMedicalRecordMailApplyBossRejectNotifyToPatient(ProductServiceApply psa){
		//String url = serverWxUrlRoot+expressIndexPage+"?hospitalUserId="+psa.getVendor();
		String url = serverH5UrlRoot+expressIndexPage+"?productSubType="+psa.getProductSubType()+"&productApplyId="+psa.getProductApplyId()
				+"&orderId="+psa.getOrderId();
		List<String> values = new ArrayList<String>();
		values.add(pushInnerService.getMessage(PushContentUtil
				.getBusinessPushContent("push.service.order.cancel.title")));
		values.add(psa.getOrderId());
		values.add(pushInnerService.getMessage(PushContentUtil
				.getBusinessPushContent("push.service.medicalrecordmail.apply.reject.7.notify.topatient")));
		values.add(pushInnerService.getMessage(PushContentUtil
				.getBusinessPushContent("push.service.order.cancel.state")));
		values.add(DateUtil.getDateStr(new Date()));
		values.add(pushInnerService.getMessage(PushContentUtil
				.getBusinessPushContent("push.service.medicalrecordmail.apply.reject.7.notify.topatient.remark")));
		PushNotifyInfo notifyInfo = PushUtil.getWxTemplatePushNotifyInfo("dingdanzhuangtaigenxingtongzhi", url, values);
		notifyInfo.setUserId(psa.getBuyer());
		PushNotifyUtil.setSendWxProductId(notifyInfo, psa.getWxProductId());
		pushInnerService.push(notifyInfo);
	}
	
	/**
	 * 病案邮寄消息向患者发送
	 * @author lichenghao
	 * @title :sendMedicalRecordMailApplyRejectNotifyToPatient
	 * @Description:TODO
	 * @return void
	 * @date 2016年6月20日 下午3:56:09
	 */
	private void sendMedicalRecordMailApplyHandleNotifyToPatient(ProductServiceApply psa) {
		if (psa.getAuditState() != null && psa.getAuditState() == 4) {
			List<String> values = new ArrayList<String>();
			Map<String,String> par = JsonUtil.toObject(psa.getRemark(), HashMap.class);
			String empressNo = "";
			if(StringUtils.isNotEmpty(par.get("expressNo")))
				empressNo=par.get("expressNo");
			if(StringUtils.isBlank(empressNo))
				values.add(pushInnerService.getMessage(PushContentUtil
						.getBusinessPushContent("product.service.express.progress.5.first")));
			else
				values.add(pushInnerService.getMessage(PushContentUtil
						.getBusinessPushContent("push.service.medicalrecordmail.apply.handle.notify.topatient",new Object[]{empressNo})));
			values.add(psa.getOrderId());
			ExpressCompany express = productDao.queryExpressCompanyNameByProductId(psa.getProductId());
			if(express==null||express.getExpressCompanyName()==null)
				values.add(pushInnerService.getMessage(PushContentUtil
						.getBusinessPushContent("push.service.medicalrecordmail.apply.description")));
			else
				values.add(express.getExpressCompanyName());
			values.add(pushInnerService.getMessage(PushContentUtil
					.getBusinessPushContent("push.service.medicalrecordmail.apply.state.4")));
			values.add(DateUtil.getDateStr(new Date()));
			values.add(pushInnerService.getMessage(PushContentUtil
					.getBusinessPushContent("product.service.express.progress.remark")));
			//String url = serverWxUrlRoot+expressIndexPage+"?hospitalUserId="+psa.getVendor();
			String url = serverH5UrlRoot+expressIndexPage+"?productSubType="+psa.getProductSubType()+"&productApplyId="+psa.getProductApplyId()
					+"&orderId="+psa.getOrderId();
			PushNotifyInfo notifyInfo = PushUtil.getWxTemplatePushNotifyInfo("dingdanzhuangtaigenxingtongzhi", url,
					values);
			notifyInfo.setUserId(psa.getBuyer());
			PushNotifyUtil.setSendWxProductId(notifyInfo, psa.getWxProductId());
			pushInnerService.push(notifyInfo);
		}
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :sendFollowupMessageApplyAcceptNotify
	 * @Description:随访服务消息处理
	 * @return void
	 * @date 2016年10月9日 上午8:30:45
	 */
	public void sendFollowupMessageApplyAcceptNotify(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		switch(psa.getState()){
		  case 2: //同意
		  case 3: //拒绝
			  break;
		  case 5: //关闭
		  case 6: //服务过期
		  case 9: //医生关闭
			  sendFollowupMessageNotifyToPatient(psa);
			  break;
        default:
      	  break; //do nothing
		}
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :sendFollowupMessageNotifyToDoctor
	 * @Description:随访消息相关内容给患者
	 * @return void
	 * @date 2016年10月9日 上午8:34:45
	 */
	private void sendFollowupMessageNotifyToPatient(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("message.followup.message.to.patient.service.end"));
		ImMessageInfo im = ImMessageUtil.getSysImMessageTips(0,psa.getVendor(),psa.getBuyer(),content);
		im.setSpeakerRole(Constant.User.ROLE_DOCTOR);
		im.setAudienceRole(Constant.User.ROLE_PATIENT);
		messageService.sendInnerMessage(im);
	}
	
	/**
	 * 打赏服务推送
	 * @author lichenghao
	 * @title :sendGratuityNotify
	 * @Description:TODO
	 * @return void
	 * @date 2017年7月31日 下午2:13:48
	 */
	public void sendGratuityNotify(ProductServiceApply psa) {
		if(psa.getState()==5){
			this.sendGratuityNotifyToPatient(psa);
			this.sendGratuityNotifyToDoctor(psa);
		}
	}

	private void sendGratuityNotifyToDoctor(ProductServiceApply psa) {
		// 答谢医患对话
		String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.message.gratuity.end.to.doctor"));
		ImMessageInfo im = ImMessageUtil.getSysImMessageTips(0,psa.getBuyer(),psa.getVendor(),content);
		im.setSpeakerRole(Constant.User.ROLE_PATIENT);
		im.setAudienceRole(Constant.User.ROLE_DOCTOR);
		messageService.sendInnerMessage(im);
		String buyerTrueName = userDao.getUserTrueName(psa.getBuyer(), Constant.User.ROLE_PATIENT);
		//答谢随诊助手发出 button消息
		TStructuredMsg<TButtonMsg>  struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		TBottomInfo bottom = new TBottomInfo();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		buttonMsg.setBottom(bottom);
		bottom.setText("点击查看");
		bottom.setUrl(eventUrlRoot+myAccountUrl);
		//版本大于3.6.2有点击查看按钮
		Integer flag = userDao.compareAppVersion("3.6.2", psa.getVendor());
		if(flag==null||flag<1)
			buttonMsg.setBottom(null);
		String description = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.message.gratuity.end.aide.to.doctor",new Object[]{buyerTrueName,psa.getRealPrice()}));
		buttonMsg.setDescription(description);
		messageService.sendInnerMessage(
				ImMessageUtil.getEDoctorAssistCustomMessage(psa.getVendor(), JsonUtil.toJson(struMsg), null));
	}

	private void sendGratuityNotifyToPatient(ProductServiceApply psa) {
		//答谢说明
		String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.message.gratuity.end.to.patient"));
		ImMessageInfo im = ImMessageUtil.getSysImMessageTips(0,psa.getVendor(),psa.getBuyer(),content);
		im.setSpeakerRole(Constant.User.ROLE_DOCTOR);
		im.setAudienceRole(Constant.User.ROLE_PATIENT);
		messageService.sendInnerMessage(im);
	}
}
