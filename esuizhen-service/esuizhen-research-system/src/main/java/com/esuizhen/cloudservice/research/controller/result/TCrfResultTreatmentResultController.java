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
import com.esuizhen.cloudservice.research.model.result.TCrfResultTreantmentResultInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultTreatmentResultService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
 * <p>Title:TCrfResultPainScaleController</p>
 * <p>Description:CRF治疗效果</p>
 * @author YYCHEN
 * @date 2016年10月21日 上午9:29:22
 */
@Controller
public class TCrfResultTreatmentResultController {
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private TCrfResultTreatmentResultService crfResultTreatmentResultService;
	
	@RequestMapping(value = "/crf/result/treatment/result/query", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<TCrfResultMainInfo<TCrfResultTreantmentResultInfo>> queryCrfResultTreatmentResultInfo(Locale locale, String crfObserveId, Long patientId) {
		LogUtil.log.info("CRF治疗效果（queryCrfResultTreatmentResultInfo）==========>>");
		TMsgResponse<TCrfResultMainInfo<TCrfResultTreantmentResultInfo>> tMsgResponse = new TMsgResponse<TCrfResultMainInfo<TCrfResultTreantmentResultInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			TCrfResultMainInfo<TCrfResultTreantmentResultInfo> crfResultMainInfo = this.crfResultTreatmentResultService.queryCrfResultTreatmentResultInfo(crfObserveId, patientId);
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
	
	@RequestMapping(value = "/crf/result/treatment/result/save", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> saveCrfResultTreatmentResultInfo (Locale locale, @RequestBody TCrfResultMainInfo<TCrfResultTreantmentResultInfo> crfResultMainInfo) {
		LogUtil.log.info("CRF治疗效果(saveCrfResultPainScale)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.crfResultTreatmentResultService.saveCrfResultTreatmentResultInfo(crfResultMainInfo);
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
}
