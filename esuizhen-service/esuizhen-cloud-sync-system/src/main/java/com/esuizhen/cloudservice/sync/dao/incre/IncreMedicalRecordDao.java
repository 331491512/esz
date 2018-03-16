package com.esuizhen.cloudservice.sync.dao.incre;

import com.esuizhen.cloudservice.sync.model.MedicalRecord;

/**
 * 
 * @author YYCHEN
 *
 */
public interface IncreMedicalRecordDao {
	
	/**
	 * 
	 * @param medicalRecord
	 * @return
	 */
	public int insert(MedicalRecord medicalRecord);
}
