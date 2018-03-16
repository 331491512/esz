package com.esuizhen.cloudservice.research.controller.result;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTestInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultTestInfoService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class TCrfResultTestInfoController {

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private TCrfResultTestInfoService crfResultTestService;

	@ResponseBody
	@RequestMapping(value = "/crf/result/test/query", method = RequestMethod.GET)
	public TMsgResponse<TCrfResultMainInfo<List<TCrfResultTestInfo>>> queryCrfResultTest(String crfObserveId,
			Long patientId, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TCrfResultMainInfo<List<TCrfResultTestInfo>>> msg = new TMsgResponse<TCrfResultMainInfo<List<TCrfResultTestInfo>>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			msg.result = crfResultTestService.queryCrfResultTest(crfObserveId, patientId);

			if (msg.result == null) {
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

	@ResponseBody
	@RequestMapping(value = "/crf/result/test/save", method = RequestMethod.POST)
	public TMsgResponse<String> saveCrfResultTest(
			@RequestBody TCrfResultMainInfo<List<TCrfResultTestInfo>> crfResultMainInfo, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 创建
			crfResultTestService.saveCrfResultTest(crfResultMainInfo);

		} catch (Exception ex) {
			ex.printStackTrace();
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/crf/result/test/record/query", method = RequestMethod.GET)
	public TMsgResponse<Page<TCrfResultMainInfo<List<TCrfResultTestInfo>>>> queryCrfResultTestRecord(Locale locale,
			String projectId, Long patientId, Integer page, Integer num) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Page<TCrfResultMainInfo<List<TCrfResultTestInfo>>>> msg = new TMsgResponse<Page<TCrfResultMainInfo<List<TCrfResultTestInfo>>>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			msg.result = crfResultTestService.queryCrfResultTestRecord(projectId, patientId, page, num);

			if (msg.result == null || msg.result.getDataList() == null || msg.result.getDataList().size() < 1) {
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
