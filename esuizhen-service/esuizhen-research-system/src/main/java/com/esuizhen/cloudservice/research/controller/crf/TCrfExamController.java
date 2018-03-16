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

import com.esuizhen.cloudservice.research.model.crf.TCrfExams;
import com.esuizhen.cloudservice.research.model.crf.TCrfExamsDetail;
import com.esuizhen.cloudservice.research.service.crf.TCrfExamDetailService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class TCrfExamController {

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private TCrfExamDetailService crfExamDetailService;

	/**
	 * @author wang_hw
	 * @title :create
	 * @Description:观察项-检查信息(影像检查-病灶)明细设置
	 * @return TMsgResponse<String>
	 * @date 2016年4月6日 下午4:21:56
	 */
	@ResponseBody
	@RequestMapping(value = "/crf/exam/item/detail/save", method = RequestMethod.POST)
	public TMsgResponse<String> saveCrfExamItemDetail(Locale locale, @RequestBody TCrfExams crfExams) {
		// 设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 保存
			crfExamDetailService.saveCrfExamItemDetail(crfExams);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * @author wang_hw
	 * @title :queryCrfExamItemDetail
	 * @Description:观察项-检查信息(影像检查-病灶)明细查看
	 * @return TMsgResponse<List<TCrfExamDetail>>
	 * @date 2016年4月6日 下午4:24:39
	 */
	@ResponseBody
	@RequestMapping(value = "/crf/exam/item/detail/query", method = RequestMethod.GET)
	public TMsgResponse<List<TCrfExamsDetail>> queryCrfExamItemDetail(String crfObserveId, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TCrfExamsDetail>> msg = new TMsgResponse<List<TCrfExamsDetail>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			msg.result = crfExamDetailService.queryCrfExamItemDetail(crfObserveId);

			if (msg.result == null || msg.result.size() < 1) {
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
