package com.esuizhen.cloudservice.ehr.service.symptom;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.ehr.bean.PatientSymptomInfo;

public interface SymptomService {
	
	/**
	 * 患者症状信息列表查询
	 * @param patientId
	 * @param inhospitalId
	 * @param symptomName
	 * @return
	 */
	List<PatientSymptomInfo> patientSymptomList(Map<String,Object> paramsMap);
	/**
	 * 患者症状信息保存
	 * @param patientSymptom
	 * @return
	 */
	int savePatientSymptom(List<PatientSymptomInfo> patientSymptom);
	
	/**
	 * 删除患者症状信息
	 * @param patientSymptom
	 * @return
	 */
	int deletePatientSymptom(Map<String,Object> paramsMap);

}
