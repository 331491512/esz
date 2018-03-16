package com.esuizhen.cloudservice.research.controller.result;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultPainScaleInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultPainScaleService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
 * <p>Title:TCrfResultPainScaleController</p>
 * <p>Description:CRF临床症状-疼痛指数</p>
 * @author YYCHEN
 * @date 2016年10月21日 上午9:29:22
 */
@Controller
public class TCrfResultPainScaleController {
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private TCrfResultPainScaleService crfResultPainScaleService;
	
	@RequestMapping(value = "/crf/result/pain/scale/query", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<TCrfResultMainInfo<TCrfResultPainScaleInfo>> queryCrfResultPainScaleInfo(Locale locale, String crfObserveId, Long patientId) {
		LogUtil.log.info("CRF临床症状-疼痛指数结果（queryCrfResultPainScaleInfo）==========>>");
		TMsgResponse<TCrfResultMainInfo<TCrfResultPainScaleInfo>> tMsgResponse = new TMsgResponse<TCrfResultMainInfo<TCrfResultPainScaleInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			TCrfResultMainInfo<TCrfResultPainScaleInfo> crfResultMainInfo = this.crfResultPainScaleService.queryCrfResultPainScaleInfo(crfObserveId, patientId);
			if (crfResultMainInfo == null) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			}else{
				tMsgResponse.setResult(crfResultMainInfo);
			}
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	@RequestMapping(value = "/crf/crf/result/pain/scale/save", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> saveCrfResultPainScale(Locale locale, @RequestBody TCrfResultMainInfo<TCrfResultPainScaleInfo> crfResultMainInfo) {
		LogUtil.log.info("CRF临床症状-疼痛指数结果保存(saveCrfResultPainScale)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.crfResultPainScaleService.saveGenenalPhysicalExam(crfResultMainInfo);
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
}
