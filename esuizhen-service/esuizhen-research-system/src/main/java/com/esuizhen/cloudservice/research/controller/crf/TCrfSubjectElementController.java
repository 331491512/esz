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

import com.esuizhen.cloudservice.research.bean.TCrfCourseDetailInfo;
import com.esuizhen.cloudservice.research.model.crf.TCrfObservationSubjectElement;
import com.esuizhen.cloudservice.research.model.crf.TCrfObservationSubjectElementSet;
import com.esuizhen.cloudservice.research.service.crf.TCrfSubjectElementService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class TCrfSubjectElementController {

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private TCrfSubjectElementService crfObservationSubjectElementService;

	/**
	 * @author wang_hw
	 * @title :queryCrfSubjectElementChild
	 * @Description:观察项-子标题元素（采集项）查看
	 * @return TMsgResponse<List<TCrfObservationSubjectElement>>
	 * @date 2016年4月5日 下午5:20:37
	 */
	@ResponseBody
	@RequestMapping(value = "/crf/subject/element/child/query", method = RequestMethod.GET)
	public TMsgResponse<List<TCrfObservationSubjectElement>> queryCrfSubjectElementChild(String crfCourseItemId,
			String parentId, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TCrfObservationSubjectElement>> msg = new TMsgResponse<List<TCrfObservationSubjectElement>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			msg.result = crfObservationSubjectElementService.queryCrfSubjectElementChild(crfCourseItemId, parentId);

			if (msg.result == null || msg.result.size() < 1) {
				// 设置错误代码及提示消息
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

	/**
	 * @author wang_hw
	 * @title :setCrfSubjectElementChild
	 * @Description:观察项-子标题元素(采集项)设置
	 * @return TMsgResponse<String>
	 * @date 2016年4月5日 下午5:20:54
	 */
	@ResponseBody
	@RequestMapping(value = "/crf/subject/element/child/set", method = RequestMethod.POST)
	public TMsgResponse<String> setCrfSubjectElementChild(
			@RequestBody TCrfObservationSubjectElementSet crfObservationSubjectElementSet, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// crf观察项设置
			crfObservationSubjectElementService.setCrfSubjectElementChild(crfObservationSubjectElementSet);
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
	 * @title :removeCrfSubjectElementChild
	 * @Description:观察项-子标题元素(采集项)删除
	 * @return TMsgResponse<String>
	 * @date 2016年4月5日 下午5:21:11
	 */
	@ResponseBody
	@RequestMapping(value = "/crf/subject/element/child/remove", method = RequestMethod.GET)
	public TMsgResponse<String> removeCrfSubjectElementChild(String crfObserveId, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 删除
			crfObservationSubjectElementService.removeCrfSubjectElementChild(crfObserveId);

		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * <p>
	 * Title:queryFollowupTimeAxis
	 * </p>
	 * <p>
	 * Description:患者随访时间轴查询
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年6月2日 下午5:08:35
	 * @param crfCourseItemId
	 * @param patientId
	 * @param doctorId
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/crf/result/outline/secondary/query", method = RequestMethod.GET)
	public TMsgResponse<TCrfCourseDetailInfo> queryFollowupTimeAxis(String crfCourseItemId, Long patientId,
			Long doctorId, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TCrfCourseDetailInfo> msg = new TMsgResponse<TCrfCourseDetailInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			msg.setResult(this.crfObservationSubjectElementService.queryFollowupTimeAxis(crfCourseItemId, patientId,
					doctorId));
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}
