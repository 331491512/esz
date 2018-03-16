package com.esuizhen.cloudservice.sync.dao.match;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.westangel.common.bean.sync.UuidRelationship;

/**
 * 
 * @author YYCHEN
 *
 */
public interface MatchMedicalRecordDao {
	
	/**
	 * 
	 * @param medicalRecord
	 * @return
	 */
	public int insert(MedicalRecord medicalRecord);

	public int delete(String emrId);

	public int updatePatientUuid(@Param("uuidFinal")String uuidFinal, @Param("uuidRelationships")List<UuidRelationship> uuidRelationships);
	
	public MedicalRecord findByEmrId(String emrId);
}
