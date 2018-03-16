
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

import com.esuizhen.cloudservice.research.model.crf.TCrfDetection;
import com.esuizhen.cloudservice.research.model.crf.TCrfDetectionDetail;
import com.esuizhen.cloudservice.research.service.crf.TCrfDetectionService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
 * @ClassName: TCrfDetectionController
 * @Description: 观察项-检验信息处理器
 * @author wang_hw
 * @date 2016年4月12日 下午1:20:46
 */
@Controller
public class TCrfDetectionController {

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private TCrfDetectionService crfDetectionService;

	/**
	 * @author wang_hw
	 * @title :queryCrfDetectionItemDetail
	 * @Description:观察项-检验信息查看
	 * @return TMsgResponse<List<TCrfDetectionDetail>>
	 * @date 2016年4月12日 下午1:20:14
	 */
	@ResponseBody
	@RequestMapping(value = "/crf/detection/item/detail/query", method = RequestMethod.GET)
	public TMsgResponse<List<TCrfDetectionDetail>> queryCrfDetectionItemDetail(String crfObserveId, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TCrfDetectionDetail>> msg = new TMsgResponse<List<TCrfDetectionDetail>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			msg.result = crfDetectionService.queryCrfDetectionItemDetail(crfObserveId);

			if (msg.result == null || msg.result.size() < 1) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * @author wang_hw
	 * @title :saveCrfDetectionItemDetail
	 * @Description:观察项-检验信息设置
	 * @return TMsgResponse<String>
	 * @date 2016年4月12日 下午1:20:29
	 */
	@ResponseBody
	@RequestMapping(value = "/crf/detection/item/detail/save", method = RequestMethod.POST)
	public TMsgResponse<String> saveCrfDetectionItemDetail(@RequestBody TCrfDetection crfDetection, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 创建
			crfDetectionService.saveCrfDetectionItemDetail(crfDetection);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

}
