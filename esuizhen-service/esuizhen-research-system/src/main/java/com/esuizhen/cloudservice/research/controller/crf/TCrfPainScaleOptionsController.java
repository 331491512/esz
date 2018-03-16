package com.esuizhen.cloudservice.research.controller.crf;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.research.model.crf.TCrfPainScaleOptions;
import com.esuizhen.cloudservice.research.service.crf.TCrfPainScaleOptionsService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
 * @ClassName: CrfObservationClinicSymptomOptionsController
 * @Description: 疼痛指数处理器
 * @author wang_hw
 * @date 2016年4月5日 下午8:28:27
 */
@Controller
public class TCrfPainScaleOptionsController {

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private TCrfPainScaleOptionsService crfPainScaleOptionsService;

	@ResponseBody
	@RequestMapping(value = "/crf/pain/scale/save", method = RequestMethod.POST)
	public TMsgResponse<String> saveCrfPainScaleInfo(@RequestBody TCrfPainScaleOptions crfPainScaleOptions, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<String> tMsgResponse = new TMsgResponse<String>();
		tMsgResponse.respCode = ErrorMessage.SUCCESS.code;
		tMsgResponse.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			this.crfPainScaleOptionsService.saveCrfPainScaleInfo(crfPainScaleOptions);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			tMsgResponse.respCode = ErrorMessage.E1500.code;
			tMsgResponse.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * <p>Title:queryCrfPainScaleInfo</p>
	 * <p>Description:根据模板设置项ID获取疼痛指数信息</p>
	 * @author YYCHEN
	 * @date 2016年10月19日 下午3:52:05
	 * @param locale
	 * @param crfObserveId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/crf/pain/scale/query", method = RequestMethod.GET)
	public TMsgResponse<TCrfPainScaleOptions> queryCrfPainScaleInfo(Locale locale, String crfObserveId) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TCrfPainScaleOptions> tMsgResponse = new TMsgResponse<TCrfPainScaleOptions>();
		tMsgResponse.respCode = ErrorMessage.SUCCESS.code;
		tMsgResponse.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			TCrfPainScaleOptions crfPainScaleOptions = this.crfPainScaleOptionsService.getCrfPainScaleInfoByCrfObserveId(crfObserveId);
			if (crfPainScaleOptions == null) {
				tMsgResponse.respCode = ErrorMessage.E1404.code;
				tMsgResponse.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}else{
				tMsgResponse.setResult(crfPainScaleOptions);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			tMsgResponse.respCode = ErrorMessage.E1500.code;
			tMsgResponse.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return tMsgResponse;
	}
}
