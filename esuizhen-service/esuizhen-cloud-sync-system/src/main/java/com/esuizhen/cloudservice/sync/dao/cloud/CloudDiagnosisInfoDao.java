package com.esuizhen.cloudservice.sync.dao.cloud;

import java.util.List;

import com.esuizhen.cloudservice.sync.model.DiagnosisInfo;

/**
 * 
 * @author YYCHEN
 *
 */
public interface CloudDiagnosisInfoDao {
	
	/**
	 * 
	 * @param diagnosisInfo
	 * @return
	 */
	public int insert(DiagnosisInfo diagnosisInfo);
	
	/**
	 * 
	 * @param patientId
	 * @return
	 */
	public List<DiagnosisInfo> findSourceDiagnosisByPatientId(Long patientId);
}
