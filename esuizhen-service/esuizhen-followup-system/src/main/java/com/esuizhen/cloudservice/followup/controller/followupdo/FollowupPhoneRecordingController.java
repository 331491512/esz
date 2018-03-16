package com.esuizhen.cloudservice.followup.controller.followupdo;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.followup.bean.TelephoneRecordingReq;
import com.esuizhen.cloudservice.followup.service.followupdo.FollowupPhoneRecordingService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
 * 电话录音
 * 
 * @author xueyongyan date:20170522
 */
@Controller
@RequestMapping(value = "/do/")
public class FollowupPhoneRecordingController {
	/**
	 * 随访接口
	 */
	@Autowired
	private FollowupPhoneRecordingService phoneRecordingService;

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	/**
	 * @author xueyongyan
	 * @Description:将电话录音相关数据保存到数据库。
	 * @return String
	 * @date 20170522
	 */
	@ResponseBody
	@RequestMapping(value = "/phone/call/record/add", method = RequestMethod.POST)
	public TMsgResponse<String> telephoneRecordingAdd(@RequestBody TelephoneRecordingReq phoneCallReq, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 创建随访计划模版
			int flag = phoneRecordingService.savePhoneRecording(phoneCallReq);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/phone/call/record/list", method = RequestMethod.POST)
	public TMsgResponse<List<TelephoneRecordingReq>> telephoneRecordingList(@RequestBody TelephoneRecordingReq phoneCallReq, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TelephoneRecordingReq>> msg = new TMsgResponse<List<TelephoneRecordingReq>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 创建随访计划模版
			List<TelephoneRecordingReq> recordList = phoneRecordingService.queryFollowupPhoneRecordList(phoneCallReq);
			msg.setResult(recordList);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/phone/call/record/modify", method = RequestMethod.POST)
	public TMsgResponse<String> telephoneRecordingModify(@RequestBody TelephoneRecordingReq phoneCallReq, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 创建随访计划模版
			int flag = phoneRecordingService.updatePhoneCallRecord(phoneCallReq);

		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}
