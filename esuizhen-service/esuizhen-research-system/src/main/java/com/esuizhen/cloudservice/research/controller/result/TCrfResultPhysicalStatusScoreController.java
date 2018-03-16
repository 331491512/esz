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

import com.esuizhen.cloudservice.research.model.result.TCrfResultPhysicalStatusScore;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultPhysicalStatusScoreService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class TCrfResultPhysicalStatusScoreController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private TCrfResultPhysicalStatusScoreService crfResultPhysicalStatusScoreService;

	/**
	 * <p>Title:queryCrfResultPhysicalStatusScoreRecord</p>
	 * <p>Description:CRF患者身体状况评分结果记录查询</p>
	 * @author YYCHEN
	 * @date 2016年6月1日 下午5:47:35
	 * @param locale
	 * @param projectId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	@RequestMapping(value = "/crf/result/physical/status/score/record/query", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<TCrfResultMainInfo<List<TCrfResultPhysicalStatusScore>>>> queryCrfResultPhysicalStatusScoreRecord(Locale locale, String projectId, Long patientId, Long doctorId) {
		LogUtil.log.info("CRF患者身体状况评分结果记录查询(queryCrfResultPhysicalStatusScoreRecord)==========>>");
		TMsgResponse<List<TCrfResultMainInfo<List<TCrfResultPhysicalStatusScore>>>> tMsgResponse = new TMsgResponse<List<TCrfResultMainInfo<List<TCrfResultPhysicalStatusScore>>>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<TCrfResultMainInfo<List<TCrfResultPhysicalStatusScore>>> crfResultMainInfos = this.crfResultPhysicalStatusScoreService.queryCrfResultPhysicalStatusScoreRecord(projectId, patientId, doctorId);
			if (crfResultMainInfos == null || crfResultMainInfos.isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			}else{
				tMsgResponse.setResult(crfResultMainInfos);
			}
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:queryCrfResultPhysicalStatusScoreI</p>
	 * <p>Description:CRF患者身体状况评分结果查询</p>
	 * @author YYCHEN
	 * @date 2016年6月1日 下午5:49:37
	 * @param locale
	 * @param crfObserveId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	@RequestMapping(value = "/crf/result/physical/status/score/query", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<TCrfResultMainInfo<TCrfResultPhysicalStatusScore>> queryCrfResultPhysicalStatusScoreI(Locale locale, String crfObserveId, Long patientId, Long doctorId) {
		LogUtil.log.info("CRF患者身体状况评分结果查询(queryCrfResultPhysicalStatusScoreI)==========>>");
		TMsgResponse<TCrfResultMainInfo<TCrfResultPhysicalStatusScore>> tMsgResponse = new TMsgResponse<TCrfResultMainInfo<TCrfResultPhysicalStatusScore>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			TCrfResultMainInfo<TCrfResultPhysicalStatusScore> crfResultMainInfo = this.crfResultPhysicalStatusScoreService.queryCrfResultPhysicalStatusScoreI(crfObserveId, patientId, doctorId);
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
	
	/**
	 * <p>Title:saveCrfResultPhysicalStatusScore</p>
	 * <p>Description:CRF患者身体状况评分保存</p>
	 * @author YYCHEN
	 * @date 2016年6月1日 下午5:51:51
	 * @param locale
	 * @param crfResultMainInfo
	 * @return
	 */
	@RequestMapping(value = "/crf/result/physical/status/score/save", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> saveCrfResultPhysicalStatusScore(Locale locale, @RequestBody List<TCrfResultMainInfo<TCrfResultPhysicalStatusScore>> crfResultMainInfoes) {
		LogUtil.log.info("CRF患者身体状况评分保存(saveCrfResultPhysicalStatusScore)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.crfResultPhysicalStatusScoreService.saveCrfResultPhysicalStatusScore(crfResultMainInfoes);
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
}
