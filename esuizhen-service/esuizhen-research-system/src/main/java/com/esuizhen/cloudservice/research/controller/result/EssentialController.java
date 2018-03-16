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

import com.esuizhen.cloudservice.research.model.result.TCrfResultBasicAllergies;
import com.esuizhen.cloudservice.research.model.result.TCrfResultBasicDemography;
import com.esuizhen.cloudservice.research.model.result.TCrfResultBasicPastmedicalHistory;
import com.esuizhen.cloudservice.research.model.result.TCrfResultDiagnosisInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultBasicAllergiesService;
import com.esuizhen.cloudservice.research.service.result.TCrfResultBasicDemographyService;
import com.esuizhen.cloudservice.research.service.result.TCrfResultBasicPastmedicalHistoryService;
import com.esuizhen.cloudservice.research.service.result.TCrfResultDiagnosisInfoService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.util.LogUtil;

@Controller
public class EssentialController {
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private TCrfResultBasicDemographyService crfResultBasicDemographyService;
	@Autowired
	private TCrfResultBasicAllergiesService crfResultBasicAllergiesService;
	@Autowired
	private TCrfResultBasicPastmedicalHistoryService crfResultBasicPastmedicalHistoryService;
	@Autowired
	private TCrfResultDiagnosisInfoService crfResultDiagnosisInfoService;

	/**
	 * <p>Title:queryCrfResultDemography</p>
	 * <p>Description:CRF人口学信息查询</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 上午11:09:17
	 * @param locale
	 * @param crfObserveId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	@RequestMapping(value = "/crf/result/demography/query", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<TCrfResultMainInfo<TCrfResultBasicDemography>> queryCrfResultDemography(Locale locale, String crfObserveId, Long patientId, Long doctorId) {
		LogUtil.log.info("CRF人口学信息查询(queryCrfResultDemography)==========>>");
		TMsgResponse<TCrfResultMainInfo<TCrfResultBasicDemography>> tMsgResponse = new TMsgResponse<TCrfResultMainInfo<TCrfResultBasicDemography>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			TCrfResultMainInfo<TCrfResultBasicDemography> crfResultMainInfo = this.crfResultBasicDemographyService.queryCrfResultDemography(crfObserveId, patientId, doctorId);
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
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:saveCrfResultDemography</p>
	 * <p>Description:CRF人口学信息保存</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 上午11:09:28
	 * @param locale
	 * @param crfResultMainInfo
	 * @return
	 */
	@RequestMapping(value = "/crf/result/demography/save", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> saveCrfResultDemography(Locale locale, @RequestBody TCrfResultMainInfo<TCrfResultBasicDemography> crfResultMainInfo) {
		LogUtil.log.info("CRF人口学信息保存(saveCrfResultDemography)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.crfResultBasicDemographyService.saveCrfResultDemography(crfResultMainInfo);
		} catch(ParameterCannotBeNullException ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(ObjectNotAvailableExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * <p>Title:queryCrfResultAllergy</p>
	 * <p>Description:CRF过敏史信息查询</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 上午11:10:32
	 * @param locale
	 * @param crfObserveId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	@RequestMapping(value = "/crf/result/allergy/query", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<TCrfResultMainInfo<List<TCrfResultBasicAllergies>>> queryCrfResultAllergy(Locale locale, String crfObserveId, Long patientId, Long doctorId) {
		LogUtil.log.info("CRF过敏史信息查询(queryCrfResultAllergy)==========>>");
		TMsgResponse<TCrfResultMainInfo<List<TCrfResultBasicAllergies>>> tMsgResponse = new TMsgResponse<TCrfResultMainInfo<List<TCrfResultBasicAllergies>>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			TCrfResultMainInfo<List<TCrfResultBasicAllergies>> crfResultMainInfo = this.crfResultBasicAllergiesService.queryCrfResultAllergy(crfObserveId, patientId, doctorId);
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
		}
		return tMsgResponse;
	}

	/**
	 * <p>Title:saveCrfResultAllergy</p>
	 * <p>Description:CRF患者过敏史信息保存</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 上午11:52:08
	 * @param locale
	 * @param crfResultMainInfo
	 * @return
	 */
	@RequestMapping(value = "/crf/result/allergy/save", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> saveCrfResultAllergy (Locale locale, @RequestBody TCrfResultMainInfo<List<TCrfResultBasicAllergies>> crfResultMainInfo) {
		LogUtil.log.info("CRF患者过敏史信息保存(saveCrfResultAllergy)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.crfResultBasicAllergiesService.saveCrfResultAllergy(crfResultMainInfo);
		} catch(ParameterCannotBeNullException ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(ObjectNotAvailableExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:queryCrfResultPastmedicalHistory</p>
	 * <p>Description:CRF既往病史信息查询</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午4:50:01
	 * @param locale
	 * @param crfObserveId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	@RequestMapping(value = "/crf/result/pastmedical/history/query", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<TCrfResultMainInfo<List<TCrfResultBasicPastmedicalHistory>>> queryCrfResultPastmedicalHistory(Locale locale, String crfObserveId, Long patientId, Long doctorId) {
		LogUtil.log.info("CRF既往病史信息查询(queryCrfResultPastmedicalHistory)==========>>");
		TMsgResponse<TCrfResultMainInfo<List<TCrfResultBasicPastmedicalHistory>>> tMsgResponse = new TMsgResponse<TCrfResultMainInfo<List<TCrfResultBasicPastmedicalHistory>>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			TCrfResultMainInfo<List<TCrfResultBasicPastmedicalHistory>> crfResultMainInfo = this.crfResultBasicPastmedicalHistoryService.queryCrfResultPastmedicalHistory(crfObserveId, patientId, doctorId);
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
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:saveCrfResultPastmedicalHistory</p>
	 * <p>Description:CRF患者既往病史信息保存</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午4:55:36
	 * @param locale
	 * @param crfResultMainInfo
	 * @return
	 */
	@RequestMapping(value = "/crf/result/pastmedical/history/save", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> saveCrfResultPastmedicalHistory(Locale locale, @RequestBody TCrfResultMainInfo<List<TCrfResultBasicPastmedicalHistory>> crfResultMainInfo) {
		LogUtil.log.info("CRF患者既往病史信息保存(saveCrfResultPastmedicalHistory)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.crfResultBasicPastmedicalHistoryService.saveCrfResultPastmedicalHistory(crfResultMainInfo);
		} catch(ParameterCannotBeNullException ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(ObjectNotAvailableExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:queryCrfResultDiagnosis</p>
	 * <p>Description:CRF患者诊断信息结果查询</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午2:42:37
	 * @param locale
	 * @param crfObserveId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	@RequestMapping(value = "/crf/result/diagnosis/query", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<TCrfResultMainInfo<List<TCrfResultDiagnosisInfo>>> queryCrfResultDiagnosis(Locale locale, String crfObserveId, Long patientId, Long doctorId) {
		LogUtil.log.info("CRF患者诊断信息结果查询(queryCrfResultAllergy)==========>>");
		TMsgResponse<TCrfResultMainInfo<List<TCrfResultDiagnosisInfo>>> tMsgResponse = new TMsgResponse<TCrfResultMainInfo<List<TCrfResultDiagnosisInfo>>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			TCrfResultMainInfo<List<TCrfResultDiagnosisInfo>> crfResultMainInfo = this.crfResultDiagnosisInfoService.queryCrfResultDiagnosis(crfObserveId, patientId, doctorId);
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
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:saveCrfResultDiagnosis</p>
	 * <p>Description:CRF患者诊断信息结果保存</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午2:42:22
	 * @param locale
	 * @param crfResultMainInfo
	 * @return
	 */
	@RequestMapping(value = "/crf/result/diagnosis/save", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> saveCrfResultDiagnosis(Locale locale, @RequestBody TCrfResultMainInfo<List<TCrfResultDiagnosisInfo>> crfResultMainInfo) {
		LogUtil.log.info("CRF患者过敏史信息保存(saveCrfResultDiagnosis)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.crfResultDiagnosisInfoService.saveCrfResultDiagnosis(crfResultMainInfo);
		} catch(ParameterCannotBeNullException ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(ObjectNotAvailableExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
}
