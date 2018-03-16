package com.esuizhen.cloudservice.ehr.controller.patient;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.bean.PatientDiagnosisListReq;
import com.esuizhen.cloudservice.ehr.bean.PatientInHospitalNoteListReq;
import com.esuizhen.cloudservice.ehr.bean.PatientPastTreatmentListReq;
import com.esuizhen.cloudservice.ehr.bean.PatientPastTreatmentReq;
import com.esuizhen.cloudservice.ehr.bean.PatientSymptomInfo;
import com.esuizhen.cloudservice.ehr.bean.TDiagnosisInfo;
import com.esuizhen.cloudservice.ehr.bean.TInhospitalInfo;
import com.esuizhen.cloudservice.ehr.bean.TTreatmentInfo;
import com.esuizhen.cloudservice.ehr.service.patient.PatientService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.PatientDiagnosisReq;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

@Controller
public class PatientController{

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private PatientService patientService;
	
	/**
	 * 获取患者出院信息
	 * @author lichenghao
	 * @title :getPatienInhospitalList
	 * @Description:TODO
	 * @return TMsgResponse<List<TInhospitalInfo>>
	 * @date 2016年5月18日 下午2:43:34
	 */
	@ResponseBody
	@RequestMapping(value="/inhospitalnote/list" , method=RequestMethod.GET)
	public TMsgResponse<Page<TInhospitalInfo>> getPatienInhospitalList(PatientInHospitalNoteListReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page<TInhospitalInfo>> msg = new TMsgResponse<Page<TInhospitalInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			msg.result = patientService.getPatienInhospitalList(req);
		}catch(Exception ex)
		{
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 获取出院信息
	 * @author lichenghao
	 * @title :getOutHospitalDateList
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2016年5月3日 下午5:29:09
	 */
	@ResponseBody
	@RequestMapping(value = "/out/hospital/date/list", method = RequestMethod.GET)
	public TMsgResponse<Object>  getOutHospitalDateList(Long patientId,Integer hospitalId, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info,null, locale));
		try {
			msg.result = patientService.getOutHospitalDateList(patientId, hospitalId);
		} catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1400.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info,null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/patient/diagnosis/list" , method=RequestMethod.GET)
	public TMsgResponse<Page<TDiagnosisInfo>> getPatientDiagnosisList(PatientDiagnosisListReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page<TDiagnosisInfo>> msg = new TMsgResponse<Page<TDiagnosisInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			msg.result = patientService.getPatientDiagnosisList(req);
		}catch(Exception ex)
		{
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 添加患者诊断
	 * @author lichenghao
	 * @title :addPatientDiagnosis
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2016年5月24日 下午3:03:26
	 */
	@ResponseBody
	@RequestMapping(value="/patient/diagnosis/add",method=RequestMethod.POST)
	public TMsgResponse<Object> addPatientDiagnosis (@RequestBody PatientDiagnosisReq req,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			patientService.createPatientDiagnosis(req);
		}catch(EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause()+"\t"+ex.getMessage());
			msg.respCode=ErrorMessage.E1419.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1419.info, null, locale);
		}catch(EmptyObjectExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1417.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
		}
		catch(Exception ex){
			LogUtil.logError.error(ex.getCause()+"\t"+ex.getMessage());
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
		}
		return msg;
	}
	
	/**
	 * 修改患者诊断
	 * @author lichenghao
	 * @title :modifyPatientDiagnosis
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2016年5月24日 下午3:03:48
	 */
	@ResponseBody
	@RequestMapping(value="/patient/diagnosis/modify",method=RequestMethod.POST)
	public TMsgResponse<Object> modifyPatientDiagnosis (@RequestBody PatientDiagnosisReq req,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			patientService.modifyPatientDiagnosis(req);
		}catch(EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause()+"\t"+ex.getMessage());
			msg.respCode=ErrorMessage.E1419.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1419.info, null, locale);
		}catch(EmptyObjectExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1417.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
		}catch(Exception ex){
			LogUtil.logError.error(ex.getCause()+"\t"+ex.getMessage());
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
		}
		return msg;
	}
	
	
	/**
	 * 删除患者诊断信息
	 * @author lichenghao
	 * @title :delPatientDiagnosis
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2016年5月18日 下午2:43:45
	 */
	@ResponseBody
	@RequestMapping(value="/patient/diagnosis/delete",method=RequestMethod.POST)
	public TMsgResponse<Object> delPatientDiagnosis(@RequestBody PatientDiagnosisReq req,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			patientService.delPatientDiagnosis(req);
		}
		catch(EmptyParamExcption e){
			msg.respCode=ErrorMessage.E1419.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1419.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		catch(EmptyObjectExcption e){
			msg.respCode=ErrorMessage.E1404.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		catch(Exception e){
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * 获取患者既往治疗信息
	 * @author lichenghao
	 * @title :getPatientPastTreatmentList
	 * @Description:TODO
	 * @return TMsgResponse<Page<TTreatmentInfo>>
	 * @date 2016年5月24日 下午3:30:59
	 */
	@ResponseBody
	@RequestMapping(value="/patient/past/treatment/list",method=RequestMethod.GET)
	public TMsgResponse<Page<TTreatmentInfo>> getPatientPastTreatmentList (PatientPastTreatmentListReq req,Locale locale){
		TMsgResponse<Page<TTreatmentInfo>> msg = new TMsgResponse<Page<TTreatmentInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			msg.result = patientService.getPatientPastTreatmentList(req);
		}
		catch(EmptyParamExcption e){
			msg.respCode=ErrorMessage.E1419.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1419.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		catch(Exception e){
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 新增既往治疗信息
	 * @author lichenghao
	 * @title :addPatientPastTreatment
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2016年5月24日 下午5:30:41
	 */
	@ResponseBody
	@RequestMapping(value="/patient/past/treatment/add",method=RequestMethod.POST)
	public TMsgResponse<String> addPatientPastTreatment (@RequestBody PatientPastTreatmentReq req,Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			patientService.addPatientPastTreatment(req);
		}
		catch(EmptyParamExcption e){
			msg.respCode=ErrorMessage.E1419.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1419.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		catch(Exception e){
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 修改既往治疗
	 * @author lichenghao
	 * @title :modifyPatientPastTreatment
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2016年5月24日 下午5:57:39
	 */
	@ResponseBody
	@RequestMapping(value="/patient/past/treatment/modify",method=RequestMethod.POST)
	public TMsgResponse<String> modifyPatientPastTreatment (@RequestBody PatientPastTreatmentReq req,Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			patientService.modifyPatientPastTreatment(req);
		}
		catch(EmptyParamExcption e){
			msg.respCode=ErrorMessage.E1419.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1419.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		catch(Exception e){
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/patient/past/treatment/delete",method=RequestMethod.POST)
	public TMsgResponse<String> delPatientBasicResultPastmedical(@RequestBody PatientPastTreatmentReq req,Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			patientService.delPatientPastTreatment(req);
		}
		catch(EmptyParamExcption e){
			msg.respCode=ErrorMessage.E1419.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1419.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		catch(Exception e){
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/patient/symptom/list",method=RequestMethod.GET)
	public TMsgResponse<List<PatientSymptomInfo>> patientSymptomList(Long patientId,String inhospitalId,String clinicMedicalId,String symptomName,Locale locale){
		TMsgResponse<List<PatientSymptomInfo>> msg = new TMsgResponse<List<PatientSymptomInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			Map<String,Object> paramsMap = new HashMap<String,Object>();
			paramsMap.put("patientId", patientId);
			paramsMap.put("inhospitalId", inhospitalId);
			paramsMap.put("clinicMedicalId", clinicMedicalId);
			paramsMap.put("symptomName", symptomName);
			msg.result = patientService.patientSymptomList(paramsMap);
		}
		catch(EmptyParamExcption e){
			msg.respCode=ErrorMessage.E1419.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1419.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		catch(Exception e){
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/patient/symptom/save",method=RequestMethod.POST)
	public TMsgResponse<String> savePatientSymptom(@RequestBody List<PatientSymptomInfo> patientSymptom,Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			patientService.savePatientSymptom(patientSymptom);
		}
		catch(EmptyParamExcption e){
			msg.respCode=ErrorMessage.E1419.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1419.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		catch(Exception e){
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
}

