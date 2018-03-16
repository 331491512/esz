package com.esuizhen.cloudservice.research.controller.crf;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.research.bean.TCrfPhysicalConditionScoreInfo;
import com.esuizhen.cloudservice.research.model.crf.TCrfExamItemDetailOptions;
import com.esuizhen.cloudservice.research.service.crf.TCrfPhysicalconditionScoreService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
 * <p>Title:TCrfPhysicalconditionScoreController</p>
 * <p>Description:身体状况评分设置处理器</p>
 * @author YYCHEN
 * @date 2016年10月25日 下午3:49:51
 */
@Controller
public class TCrfPhysicalconditionScoreController {

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private TCrfPhysicalconditionScoreService crfPhysicalconditionScoreService;

	@ResponseBody
	@RequestMapping(value = "/crf/physical/condition/score/save", method = RequestMethod.POST)
	public TMsgResponse<String> saveCrfPhysicalConditionScore(Locale locale, @RequestBody TCrfPhysicalConditionScoreInfo crfPhysicalConditionScoreInfo) {
		// 设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 保存
			this.crfPhysicalconditionScoreService.saveCrfPhysicalConditionScore(crfPhysicalConditionScoreInfo);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/crf/physical/condition/score/query", method = RequestMethod.GET)
	public TMsgResponse<List<TCrfExamItemDetailOptions>> queryCrfPhysicalConditionScoreInfo (String crfObserveId, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TCrfExamItemDetailOptions>> msg = new TMsgResponse<List<TCrfExamItemDetailOptions>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			msg.result = crfPhysicalconditionScoreService.queryCrfPhysicalConditionScoreInfo(crfObserveId);
			if (msg.result == null || msg.result.isEmpty()) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}
