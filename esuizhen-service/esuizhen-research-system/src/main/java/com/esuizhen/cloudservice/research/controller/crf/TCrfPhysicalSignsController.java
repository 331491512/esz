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

import com.esuizhen.cloudservice.research.model.crf.TCrfPhysicalSigns;
import com.esuizhen.cloudservice.research.model.crf.TCrfPhysicalSignsInfo;
import com.esuizhen.cloudservice.research.service.crf.TCrfPhysicalSignsService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
 * @ClassName: TCrfPhysicalSignsController
 * @Description: 体征设置处理器
 * @author wang_hw
 * @date 2016年4月6日 上午11:24:22
 */
@Controller
public class TCrfPhysicalSignsController {

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private TCrfPhysicalSignsService crfPhysicalSignsService;

	/**
	 * @author wang_hw
	 * @title :saveCrfPhysicalSigns
	 * @Description:观察项-体征信息设置
	 * @return TMsgResponse<String>
	 * @date 2016年4月6日 上午11:24:40
	 */
	@ResponseBody
	@RequestMapping(value = "/crf/physical/signs/save", method = RequestMethod.POST)
	public TMsgResponse<String> saveCrfPhysicalSigns(@RequestBody TCrfPhysicalSigns crfPhysicalSigns, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 保存
			this.crfPhysicalSignsService.saveCrfPhysicalSigns(crfPhysicalSigns);
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
	 * @title :queryCrfPhysicalSigns
	 * @Description:观察项-体征信息查看
	 * @return TMsgResponse<List<TCrfPhysicalSignsInfo>>
	 * @date 2016年4月6日 上午11:24:55
	 */
	@ResponseBody
	@RequestMapping(value = "/crf/physical/signs/query", method = RequestMethod.GET)
	public TMsgResponse<List<TCrfPhysicalSignsInfo>> queryCrfPhysicalSigns(String crfObserveId, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TCrfPhysicalSignsInfo>> msg = new TMsgResponse<List<TCrfPhysicalSignsInfo>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			msg.result = crfPhysicalSignsService.queryCrfPhysicalSigns(crfObserveId);
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
