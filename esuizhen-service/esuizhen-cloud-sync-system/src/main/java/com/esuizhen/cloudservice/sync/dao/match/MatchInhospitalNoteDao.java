package com.esuizhen.cloudservice.sync.dao.match;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.bean.TPatientInHospitalNoteDetailInfo;
import com.esuizhen.cloudservice.sync.model.InhospitalNote;
import com.westangel.common.bean.sync.UuidRelationship;

/**
 * 
 * @author YYCHEN
 *
 */
public interface MatchInhospitalNoteDao {
	
	/**
	 * 
	 * @param inhospitalNote
	 * @return
	 */
	public int insert(InhospitalNote inhospitalNote);

	public int updatePatientUuid(@Param("uuidFinal")String uuidFinal, @Param("uuidRelationships")List<UuidRelationship> uuidRelationships);
	
	public int delete(String inhospitalId);

	public List<TPatientInHospitalNoteDetailInfo> findByPatientUuid(String patientFinalUuid);
}
