package com.esuizhen.cloudservice.sync.dao.cloud;

import com.esuizhen.cloudservice.sync.model.MedicalRecord;

/**
 * 
 * @author YYCHEN
 *
 */
public interface CloudMedicalRecordDao {
	
	/**
	 * 
	 * @param medicalRecord
	 * @return
	 */
	public int insert(MedicalRecord medicalRecord);
}
