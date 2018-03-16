package com.esuizhen.cloudservice.ehr.service.progressdiagnosis;

import java.util.List;



public interface TProgressDiagnosisInfoService<T>{
	
	/**
	 * 创建继发情况信息
	 * @param diagnosis
	 * @return
	 */
	int createTProgressDiagnosisInfo(T progressDiagnosis);
	
	/**
	 * 根据主键Id删除继发情况信息
	 * @param diagnosisId
	 * @return
	 */
	int deleteTProgressDiagnosisInfoById(String issuedId);
	
	/**
	 * 根据主键Id查询继发情况信息
	 * @param inhospitalId
	 * @return
	 */
	T queryTProgressDiagnosisInfoById(String issuedId);
	
	/**
	 * 根据主诊卡Id查询继发情况列表
	 * @param inhospitalId
	 * @return
	 */
	List<T> queryTProgressDiagnosisInfoByDiagnosisCardId(String diagnosisCardId);
}
