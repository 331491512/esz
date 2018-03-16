package com.esuizhen.cloudservice.sync.dao.match;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.model.HospitalPatient;
import com.westangel.common.bean.sync.UuidRelationship;

/**
 * 
 * @author YYCHEN
 *
 */
public interface MatchHospitalPatientDao {
	public long insert(HospitalPatient hospitalPatient);

	public int updatePatientUuid(@Param("uuidFinal")String uuidFinal, @Param("uuidRelationships")List<UuidRelationship> uuidRelationships);

	public List<HospitalPatient> findByPatientUuid(String patientFinalUuid);

	public int delete(Long id);
}
