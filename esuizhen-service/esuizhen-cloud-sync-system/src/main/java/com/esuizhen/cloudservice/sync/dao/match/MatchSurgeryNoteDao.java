package com.esuizhen.cloudservice.sync.dao.match;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.bean.TPatientSurgeryNoteDetailInfo;
import com.esuizhen.cloudservice.sync.model.SurgeryNote;
import com.westangel.common.bean.sync.UuidRelationship;

/**
 * 
 * @author YYCHEN
 *
 */
public interface MatchSurgeryNoteDao {
	
	/**
	 * 
	 * @param surgeryNote
	 * @return
	 */
	public int insert(SurgeryNote surgeryNote);

	public int updatePatientUuid(@Param("uuidFinal")String uuidFinal, @Param("uuidRelationships")List<UuidRelationship> uuidRelationships);
	
	public int delete(@Param("surgeryId")String surgeryId);
	
	public List<TPatientSurgeryNoteDetailInfo> findByPatientUuid(@Param("patientUuid")String patientUuid);
}
