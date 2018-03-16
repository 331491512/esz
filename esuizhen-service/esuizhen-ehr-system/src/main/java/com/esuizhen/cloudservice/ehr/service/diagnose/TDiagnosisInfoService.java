package com.esuizhen.cloudservice.ehr.service.diagnose;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.model.diagnose.PatientDiagnosisInfoReq;


public interface TDiagnosisInfoService<T>{
	
	/**
	 * 根据住院首页Id查询诊断信息
	 * @param inhospitalId
	 * @return
	 */
	List<T> queryDiagnosisInfoByInhospitalId(CommonReq req);
	
	/**
	 * 对诊断信息进行增、删、改
	 * 以及对住院首页进行修改
	 * @param inhospitalDetail
	 * @param diagnosis
	 * @return
	 */
	Map<String,Object> saveDiagnosisInfo(List<T> diagnosises);
	
	/**
	 * 查询患者诊断信息
	 * @param req
	 * @return
	 */
	List<T> queryPatientDiagnosisInfo(PatientDiagnosisInfoReq req);
}
