package com.esuizhen.cloudservice.ehr.dao.progressdiagnosis;

import java.util.List;
import java.util.Map;



public interface TProgressDiagnosisInfoDao<T>{
	
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
	
	int deleteTProgressDiagnosisInfoByDiagnosisCardId(String diagnosisCardId);
	
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
	
	/**
	 * 根据条件查询继发情况
	 * @param params
	 * @return
	 */
	T queryTProgressDiagnosisInfoBySelective(Map<String,Object> params);
}
