package com.esuizhen.cloudservice.sync.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.sync.model.QuestionnaireResult;
import com.esuizhen.cloudservice.sync.model.TFollowupQuestionnaireDetailInfo;
import com.esuizhen.cloudservice.sync.service.QuestionnaireService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/** 
 *@className QuestionnaireController
 *@Description:
 *@author yuanwenming
 *@date 2017年8月9日
 */
@Controller
public class QuestionnaireController {
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	QuestionnaireService questionnaireService;
	
	@ResponseBody
	@RequestMapping(value = "/questionnaire/message/send", method = RequestMethod.POST)
	public TMsgResponse<String> sendQuestionnaireFollowupMessage(@RequestBody TFollowupQuestionnaireDetailInfo detailInfo, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			questionnaireService.sendQuestionnaireFollowupMessage(detailInfo);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 同步问卷随访结果
	 * @param locale
	 * @param hospitalId
	 * @param page
	 * @param num
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/fromcloud/questionnaire/followupresult", method=RequestMethod.GET)
	public TMsgResponse<List<QuestionnaireResult>> syncQuestionnaireFollowupResultFromCloud(Locale locale, Integer hospitalId, Integer page, Integer num) {
		LogUtil.log.info("Synchronous questionnaire result to ToB, syncQuestionnaireFollowupResultFromCloud()==========>>>>>>>>>>hospitalId=" + hospitalId);
		if (page == null || page < 0) {
			page = 0;
		}
		if (num == null || num < 1 || num > 200) {
			num = 100;
		}
		TMsgResponse<List<QuestionnaireResult>> tMsgResponse = new TMsgResponse<List<QuestionnaireResult>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Page<QuestionnaireResult> pageData = questionnaireService.syncQuestionnaireFollowupResultFromCloud(hospitalId, page, num);
			/*if (pageData.getCurrPage() == pageData.getTotalPage() ||
					pageData.getCurrPage() == pageData.getTotalPage() - 1) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.code);
				tMsgResponse.setRespMsg("Complete synchronization!");
			}*/
			tMsgResponse.setResult(pageData.getDataList());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("Synchronous questionnaire result to ToB side data return, syncQuestionnaireFollowupResultFromCloud()==========<<<<<<<<<<");
		return tMsgResponse;
	}
}
