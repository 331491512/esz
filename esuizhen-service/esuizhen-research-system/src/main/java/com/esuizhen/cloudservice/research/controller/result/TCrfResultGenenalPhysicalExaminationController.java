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

import com.esuizhen.cloudservice.research.model.result.TCrfResultGenenalPhysicalExamination;
import com.esuizhen.cloudservice.research.model.result.TProjectThresholdPatient;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultGenenalPhysicalExaminationService;
import com.esuizhen.cloudservice.research.service.result.ProjectThresholdPatientService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.util.LogUtil;

/**
 * <p>Title:CrfResultGenenalPhysicalExaminationController</p>
 * <p>Description:患者体格检查-常规体检结果业务控制器</p>
 * @author YYCHEN
 * @date 2016年5月31日 下午3:45:23
 */
@Controller
public class TCrfResultGenenalPhysicalExaminationController {
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private TCrfResultGenenalPhysicalExaminationService crfResultGenenalPhysicalExaminationService;
	@Autowired
	private ProjectThresholdPatientService projectThresholdPatientService;
	
	/**
	 * <p>Title:queryCrfResultGenenaPhysicalExamRecord</p>
	 * <p>Description:CRF常规体检历史记录查询</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午3:47:07
	 * @param locale
	 * @param projectId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	@RequestMapping(value = "/crf/result/genenal/physical/exam/record/query", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<Page<TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination>>> queryCrfResultGenenaPhysicalExamRecord(Locale locale, String projectId, Long patientId, Long doctorId, Integer page, Integer num) {
		LogUtil.log.info("CRF常规体检历史记录查询(queryCrfResultGenenaPhysicalExamRecord)==========>>");
		TMsgResponse<Page<TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination>>> tMsgResponse = new TMsgResponse<Page<TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination>>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Page<TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination>> crfResultMainInfos = this.crfResultGenenalPhysicalExaminationService.queryCrfResultGenenaPhysicalExamRecord(projectId, patientId, doctorId, page, num);
			if (crfResultMainInfos == null || crfResultMainInfos.getDataList() == null || crfResultMainInfos.getDataList().isEmpty()) {
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
	 * <p>Title:queryCrfResultGenenalPhysicalExam</p>
	 * <p>Description:CRF常规体检结果查询</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午3:48:08
	 * @param locale
	 * @param crfObserveId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	@RequestMapping(value = "/crf/result/genenal/physical/exam/query", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination>> queryCrfResultGenenalPhysicalExam(Locale locale, String crfObserveId, Long patientId, Long doctorId) {
		LogUtil.log.info("CRF常规体检结果查询(queryCrfResultGenenalPhysicalExam)==========>>");
		TMsgResponse<TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination>> tMsgResponse = new TMsgResponse<TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination> crfResultMainInfo = this.crfResultGenenalPhysicalExaminationService.queryCrfResultGenenalPhysicalExam(crfObserveId, patientId, doctorId);
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
	 * <p>Title:saveGenenalPhysicalExam</p>
	 * <p>Description:CRF患者常规体检结果保存</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午4:21:18
	 * @param locale
	 * @param crfResultMainInfo
	 * @return
	 */
	@RequestMapping(value = "/crf/result/genenal/physical/exam/save", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> saveGenenalPhysicalExam(Locale locale, @RequestBody TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination> crfResultMainInfo) {
		LogUtil.log.info("CRF患者常规体检结果保存(queryCrfResultGenenalPhysicalExam)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.crfResultGenenalPhysicalExaminationService.saveGenenalPhysicalExam(crfResultMainInfo);
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:queryCrfProfilePhysicalExamThreshold</p>
	 * <p>Description:CRF常规体检项目阈值查询</p>
	 * @author YYCHEN
	 * @date 2016年6月1日 下午4:40:50
	 * @param locale
	 * @param projectId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	@RequestMapping(value = "/crf/profile/physical/exam/threshold/query", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<TProjectThresholdPatient>> queryCrfProfilePhysicalExamThreshold(Locale locale, String projectId, Long patientId, Long doctorId) {
		LogUtil.log.info("CRF常规体检项目阈值查询(queryCrfProfilePhysicalExamThreshold)==========>>");
		TMsgResponse<List<TProjectThresholdPatient>> tMsgResponse = new TMsgResponse<List<TProjectThresholdPatient>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<TProjectThresholdPatient> projectThresholdPatients = this.projectThresholdPatientService.queryCrfProfilePhysicalExamThreshold(projectId, patientId, doctorId);
			if (projectThresholdPatients == null || projectThresholdPatients.isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			}else{
				tMsgResponse.setResult(projectThresholdPatients);
			}
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	
	@RequestMapping(value = "/crf/profile/physical/exam/threshold/save", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> saveCrfProfilePhysicalExamThreshol(Locale locale, @RequestBody TCrfResultMainInfo<List<TProjectThresholdPatient>> crfResultMainInfo) {
		LogUtil.log.info("CRF患者常规检验项目阈值保存(saveCrfProfilePhysicalExamThreshold)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.projectThresholdPatientService.saveCrfProfilePhysicalExamThreshol(crfResultMainInfo);
		} catch(ParameterCannotBeNullException ex){
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
