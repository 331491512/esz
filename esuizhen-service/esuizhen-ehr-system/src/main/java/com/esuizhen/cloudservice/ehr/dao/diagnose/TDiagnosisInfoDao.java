package com.esuizhen.cloudservice.ehr.dao.diagnose;

import java.util.List;
import java.util.Map;


public interface TDiagnosisInfoDao<T>{
	
	/**
	 * 添加诊断信息
	 * @param diagnosis
	 * @return
	 */
	int createDiagnosisInfo(T diagnosis);
	
	/**
	 * 修改诊断信息
	 * @param diagnosis
	 * @return
	 */
	int updateDiagnosisInfo(T diagnosis);
	
	/**
	 * 通过诊断Id删除诊断信息
	 * @param diagnosisId
	 * @return
	 */
	int deleteDiagnosisInfoById(String diagnosisId);
	
	/**
	 * 通过住院id删除关联的诊断信息
	 * @param inhospitalId
	 * @return
	 */
	int deleteDiagnosisInfoByInhospitalId(String inhospitalId);
	
	/**
	 * 根据主键Id查询诊断信息
	 * @param diagnosisId
	 * @return
	 */
	T queryDiagnosisInfoById(String diagnosisId);
	
	/**
	 * 根据住院病案首页Id等条件查询诊断信息
	 * @param param
	 * @return
	 */
	List<T> queryDiagnosisInfoBySelective(Map<String,Object> param);
	
	T queryDiagnosisInfoByPatientId(Long patientId);
	
	/**
	 * 修改诊断后，刷新病种
	 * @param paramMap
	 */
	void freshPatientDiseases(Map<String,Object> paramMap);
	
	/**
	 * 删除关联的诊断信息
	 * @param paramsMap
	 * @return
	 */
	int deleteDiagnosisInfo(Map<String,Object> paramsMap);
	
	/**
	 * 批量插入手术信息
	 */
	void batchInsertTDiagnosisInfo(Map<String,Object> paramsMap);
}
