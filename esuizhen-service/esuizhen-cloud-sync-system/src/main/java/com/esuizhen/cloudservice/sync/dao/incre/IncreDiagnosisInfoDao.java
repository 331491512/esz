package com.esuizhen.cloudservice.sync.dao.incre;

import com.esuizhen.cloudservice.sync.model.DiagnosisInfo;

/**
 * 
 * @author YYCHEN
 *
 */
public interface IncreDiagnosisInfoDao {
	
	/**
	 * 
	 * @param diagnosisInfo
	 * @return
	 */
	public int insert(DiagnosisInfo diagnosisInfo);
}
