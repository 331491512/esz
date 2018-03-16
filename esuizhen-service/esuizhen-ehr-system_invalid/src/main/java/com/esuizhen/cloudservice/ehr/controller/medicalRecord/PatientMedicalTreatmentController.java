package com.esuizhen.cloudservice.ehr.controller.medicalRecord;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.bean.PatientMedicalTreatmentResp;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.PatientMedicalTreatmentService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
 * @ClassName: PatientMedicalTreatmentController
 * @Description: 历次就诊
 * @author zhuguo
 * @date 2017-5-27 18:02:05
 */
@Controller
public class PatientMedicalTreatmentController {

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private PatientMedicalTreatmentService patientMedicalTreatmentService;

	/**
	 * 患者历次就诊次数
	 * 
	 * @author zhuguo
	 * @param resp
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/patient/medical/treatment/total", method = RequestMethod.POST)
	public TMsgResponse<PatientMedicalTreatmentResp> getPatientMedicalTreatmentTotal(
			@RequestBody PatientMedicalTreatmentResp resp, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<PatientMedicalTreatmentResp> msg = new TMsgResponse<PatientMedicalTreatmentResp>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null,
				locale);
		try {
			msg.result = patientMedicalTreatmentService
					.getPatientMedicalTreatmentTotal(resp);

		} catch (Exception ex) {
			ex.printStackTrace();
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info,
					null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 患者历次就诊记录列表
	 * 
	 * @author zhuguo
	 * @param resp
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/patient/medical/treatment/list", method = RequestMethod.POST)
	public TMsgResponse<Page<PatientMedicalTreatmentResp>> getPatientMedicalTreatmentList(
			@RequestBody PatientMedicalTreatmentResp resp, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Page<PatientMedicalTreatmentResp>> msg = new TMsgResponse<Page<PatientMedicalTreatmentResp>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null,
				locale);
		try {
			msg.result = patientMedicalTreatmentService
					.getPatientMedicalTreatmentList(resp);

			// 如果为空
			if (msg.result == null) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info,
						null, locale);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info,
					null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 患者历次就诊记录详情
	 * 
	 * @author zhuguo
	 * @param resp
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/patient/medical/treatment/detail", method = RequestMethod.POST)
	public TMsgResponse<PatientMedicalTreatmentResp> getPatientMedicalTreatmentDetail(
			@RequestBody PatientMedicalTreatmentResp resp, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<PatientMedicalTreatmentResp> msg = new TMsgResponse<PatientMedicalTreatmentResp>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null,
				locale);
		try {

			// 其他诊断信息列表
			List<String> list = patientMedicalTreatmentService
					.getOtherDiagnosisList(resp);

			PatientMedicalTreatmentResp result = patientMedicalTreatmentService
					.getPatientMedicalTreatmentDetail(resp);

			// 将其他诊断信息放到结果里面
			result.setOtherDiagnosis(list);

			msg.result = result;

		} catch (Exception ex) {
			ex.printStackTrace();
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info,
					null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}
