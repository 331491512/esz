package com.esuizhen.cloudservice.followup.controller.followupRecords;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.followup.bean.FollowupConvQuestionReq;
import com.esuizhen.cloudservice.followup.service.FollowupRecords.FollowupRecordService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
 * @ClassName: FollowupRecordController
 * @Description: 常规随访记录
 * @author fanpanwei
 * @date 2017年01月18日 上午11:03:33
 */
@Controller
@RequestMapping(value = "/conv/")
public class FollowupRecordController {
	@Autowired
	private FollowupRecordService followupRecordService;

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	
	@ResponseBody
	@RequestMapping(value = "question", method = RequestMethod.GET)
	public TMsgResponse<FollowupConvQuestionReq> getFollowupConvQuestion(Integer patientId, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<FollowupConvQuestionReq> msg = new TMsgResponse<FollowupConvQuestionReq>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 正式随访结果历史
			msg.result = followupRecordService.getConventionFollowupRecords(patientId);
			if (msg.result == null) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "question/save", method = RequestMethod.POST)
	public TMsgResponse<String> saveFollowupConvQuestion(@RequestBody FollowupConvQuestionReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			this.followupRecordService.saveConventionFollowupRecords(req);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

}
