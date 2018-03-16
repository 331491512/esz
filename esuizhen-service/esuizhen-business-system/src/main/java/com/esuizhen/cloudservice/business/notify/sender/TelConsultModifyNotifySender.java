package com.esuizhen.cloudservice.business.notify.sender;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.esuizhen.cloudservice.business.dao.business.UserDao;
import com.esuizhen.cloudservice.business.model.business.ProductServiceApply;
import com.esuizhen.cloudservice.business.service.business.impl.ProductApplyServiceImpl;
import com.esuizhen.cloudservice.business.util.ProductUtil;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.common.bean.message.structuration.TBottomInfo;
import com.westangel.common.bean.message.structuration.TButtonItemInfo;
import com.westangel.common.bean.message.structuration.TButtonMsg;
import com.westangel.common.bean.message.structuration.TStructuredMsg;
import com.westangel.common.bean.push.PushContent;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.sms.SmsTemplateSendReq;
import com.westangel.common.constant.Constant;
import com.westangel.common.service.MessageInnerService;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.service.SmsInnerService;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.ImMessageUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PushContentUtil;
import com.westangel.common.util.PushNotifyUtil;
import com.westangel.common.util.PushUtil;
import com.westangel.common.util.SmsUtil;

/**
 * 电话咨询-修改相关的通知发送
 * 
 * @author bigdragon
 *
 */
@Component
public class TelConsultModifyNotifySender {
	private Locale locale = Locale.getDefault();

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

	public void sendModifyTelConsultTimeNotify(ProductServiceApply psa, boolean isAllowed) {
		try {

			// 1.给微信患者发生推送
			if (isAllowed) {
				String vendorName = userDao.getUserTrueName(psa.getVendor(), 2);
				if (vendorName == null)
					vendorName = "";
				String code = psa.getInPackage() == 1 ? "push.service.telconsult.vip.modify.notify.topatient"
						: "push.service.telconsult.modify.notify.topatient";
				String content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(code,
						new Object[] { vendorName, DateUtil.getDateTimeShortStr(psa.getConsultOrderTime()) }));

				PushNotifyInfo notifyInfo = PushUtil.getWxDataPushNotifyInfo(psa.getBuyer(), content);
				PushNotifyUtil.setSendWxProductId(notifyInfo, psa.getWxProductId());
				pushInnerService.push(notifyInfo);
				// 2.给患者发送
				String templateNmae = "DianHuanZiXunGengGaiShiJian";
				if (psa.getInPackage() == 1)
					templateNmae = "DianHuanZiXunVIPGengGaiShiJian";
				SmsTemplateSendReq req = SmsUtil.getSmsTemplateSendReq(templateNmae,
						userDao.getUserMobile(psa.getBuyer()), null);
				req.getValues().add(vendorName);
				req.getValues().add(DateUtil.getDateTimeShortStr(psa.getConsultOrderTime()));
				smsService.sendTemplate(req);
				// 2.给医生发送tips
				content = pushInnerService.getMessage(
						PushContentUtil.getBusinessPushContent("tips.service.telconsult.modify.notify.todoctor",
								new Object[] { DateUtil.getDateTimeShortStr(psa.getConsultOrderTime()) }));
				ImMessageInfo im = ImMessageUtil.getSysImMessageTips(2, psa.getBuyer(), psa.getVendor(), content);
				messageService.sendInnerMessage(im);
			}
			// 对于不允许修改电话时间（1小时内)的情况，则发出一条提前拨打电话的通知

			// 发出Botton
			// 3. 发送医生按钮提示：提前拨打电话按钮
			TStructuredMsg<TButtonMsg> struMsg = new TStructuredMsg<TButtonMsg>();
			TButtonMsg buttonMsg = new TButtonMsg();
			struMsg.setMsgType("button");
			struMsg.setMsgBody(buttonMsg);
			// 设置标题。带颜色
			buttonMsg.setTitle(ProductUtil.getProductName(psa.getProductType()));
			buttonMsg.setPrice(psa.getRealPrice() + "");
			String intervalTime = DateUtil.getIntervalTimeStr(psa.getIntervalTime());
			String orderTime = DateUtil.getDateTimeShortStr(psa.getConsultOrderTime());
			String description = pushInnerService
					.getMessage(PushContentUtil.getBusinessPushContent(
							"button.text.telconsult.description.firstline.ordertime", new Object[] { orderTime }))
					+ pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(
							"button.text.telconsult.description.intervaltime", new Object[] { intervalTime }));
			buttonMsg.setDescription(description);

			// 生成按钮
			List<TButtonItemInfo> buttonList = new LinkedList<TButtonItemInfo>();
			buttonMsg.setButton(buttonList);
			TButtonItemInfo button = new TButtonItemInfo();
			// 提前拨打电话按钮信息
			button = new TButtonItemInfo();
			String code = isTooShortTime(psa.getConsultOrderTime()) ? "button.text.telconsult.button.makecall"
					: "button.text.telconsult.button.makecall.advance";
			button.setText(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(code)));
			button.setEventKey("SERVICE_DOING_MAKE_CALL");
			button.setEventUrl(serverUrlRoot + telConsultMakeCall + "?productApplyId=" + psa.getProductApplyId()
					+ "&userId=" + psa.getBuyer() + "&mobile=" + psa.getContactMobile());
			buttonList.add(button);
			buttonMsg.setStyle("vertical");

			// 设置底部信息
			TBottomInfo bottom = new TBottomInfo();
			buttonMsg.setBottom(bottom);
			code = "button.text.telconsult.description.bottom";
			bottom.setText(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(code)));
			bottom.setUrl(
					eventUrlRoot + orderDetailUrl + "?userId=" + psa.getVendor() + "&orderId=" + psa.getOrderId());

			// 整个struMsg转换成json消息
			String content = JSON.toJSONString(struMsg);
			// String tipText =
			// messageSource.getMessage("button.tips.telconsult.changetime",null,locale);

			ImMessageInfo im = ImMessageUtil.getSysImMessageButton(Constant.Business.PRODUCT_TYPE_TEL, psa.getBuyer(),
					psa.getVendor(), content, psa.getProductApplyId(), "");
			im.setHideInChatList(1);// 不显示tips
			messageService.sendInnerMessage(im);

		} catch (Exception e) {
			LogUtil.logError.error("ERROR in sendModifyTelConsultTimeNotify(): " + e.getMessage());
			// 注意，不再对外抛出异常。在这里终结异常。即：消息推送失败不能影响业务流程。
		}
	}

	private boolean isTooShortTime(Date consultOrderTime) {
		long interval = (consultOrderTime.getTime() - System.currentTimeMillis()) / 1000;
		if (interval <= 300) {
			LogUtil.log.warn("#######  modify telconsulting time: in 5 min!");
			return true;
		}
		return false;
	}

	/**
	 * 刷新电话咨询时间间隔显示
	 * 
	 * @param psa
	 */
	public void refreshTelConsultIntervalTime(ProductServiceApply psa) {
		// 先看看是否已经过期
		int intervalTime = psa.getIntervalTime();
		String tipsTag = "button.text.telconsult.description.intervaltime";
		if (intervalTime < 0) {
			intervalTime = -intervalTime;
			tipsTag = "button.text.telconsult.description.intervaltime.2";
		}
		// TODO Auto-generated method stub
		TStructuredMsg<TButtonMsg> struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		// 设置标题。带颜色
		buttonMsg.setTitle(ProductUtil.getProductName(psa.getProductType()));
		buttonMsg.setPrice(psa.getRealPrice() + "");
		String intervalTimeStr = DateUtil.getIntervalTimeStr(intervalTime);
		String orderTime = DateUtil.getDateTimeShortStr(psa.getConsultOrderTime());
		String description = pushInnerService
				.getMessage(PushContentUtil.getBusinessPushContent(
						"button.text.telconsult.description.firstline.ordertime", new Object[] { orderTime }))
				+ pushInnerService
						.getMessage(PushContentUtil.getBusinessPushContent(tipsTag, new Object[] { intervalTimeStr }));
		buttonMsg.setDescription(description);

		// 生成按钮
		List<TButtonItemInfo> buttonList = new LinkedList<TButtonItemInfo>();
		buttonMsg.setButton(buttonList);
		// 如果在一小时内，不出现更改时间按钮
		if (ProductApplyServiceImpl.isAllowedModifyTelConsultingTime(psa.getConsultOrderTime())) {

			if (psa.getProgressState() == 0) {// 更改时间后会将progressState置为1
				TButtonItemInfo button = new TButtonItemInfo();
				// 更改时间按钮信息
				button.setText(pushInnerService.getMessage(
						PushContentUtil.getBusinessPushContent("button.text.telconsult.button.changetime")));
				button.setEventKey("SERVICE_MODIFY_TEL_CONSULT_TIME");
				button.setEventUrl(serverUrlRoot + telConsultTimeModifyUrl);
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("productApplyId", psa.getProductApplyId());
				button.setParam(param);
				buttonList.add(button);
			}
		}

		// 提前拨打电话或拨打电话按钮信息
		TButtonItemInfo button = new TButtonItemInfo();
		String code = isTooShortTime(psa.getConsultOrderTime()) ? "button.text.telconsult.button.makecall"
				: "button.text.telconsult.button.makecall.advance";
		button.setText(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(code)));
		button.setEventKey("SERVICE_DOING_MAKE_CALL");
		button.setEventUrl(serverUrlRoot + telConsultMakeCall + "?productApplyId=" + psa.getProductApplyId()
				+ "&userId=" + psa.getBuyer() + "&mobile=" + psa.getContactMobile());
		buttonList.add(button);
		buttonMsg.setStyle("horizontal");

		// 设置底部信息
		TBottomInfo bottom = new TBottomInfo();
		buttonMsg.setBottom(bottom);
		code = "button.text.telconsult.description.bottom";
		bottom.setText(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(code)));
		bottom.setUrl(eventUrlRoot + orderDetailUrl + "?userId=" + psa.getVendor() + "&orderId=" + psa.getOrderId());

		// 整个struMsg转换成json消息
		String content = JSON.toJSONString(struMsg);
		ImMessageInfo im = ImMessageUtil.getSysImMessageButton(Constant.Business.PRODUCT_TYPE_TEL, psa.getBuyer(),
				psa.getVendor(), content, psa.getProductApplyId(), "");
		im.setHideInChatList(1);// 不在chatlist显示
		messageService.sendInnerMessage(im);
	}
}
