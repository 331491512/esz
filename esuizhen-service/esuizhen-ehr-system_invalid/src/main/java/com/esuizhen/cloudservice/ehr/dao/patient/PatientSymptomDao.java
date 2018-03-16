package com.esuizhen.cloudservice.ehr.dao.patient;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.bean.PatientSymptomInfo;

public interface PatientSymptomDao {
	/**
	 * 患者症状信息列表查询
	 * @param patientId
	 * @param inhospitalId
	 * @param symptomName
	 * @return
	 */
	List<PatientSymptomInfo> patientSymptomList(Map<String,Object> paramsMap);
	
	/**
	 * 插入患者症状信息
	 * @param patientSymptom
	 * @return
	 */
	int insertPatientSymptom(PatientSymptomInfo patientSymptom);
	
	/**
	 * 更新患者症状信息
	 * @param patientSymptom
	 * @return
	 */
	int updatePatientSymptom(PatientSymptomInfo patientSymptom);
	
	/**
	 * 删除患者症状信息
	 * @param patientSymptom
	 * @return
	 */
	int deletePatientSymptom(Map<String,Object> paramsMap);
	
	/**
	 * 根据患者id获取患者信息
	 * @param patientId
	 * @return
	 */
	Map<String,Object> queryPatientById(@Param("patientId") Long patientId);
}
