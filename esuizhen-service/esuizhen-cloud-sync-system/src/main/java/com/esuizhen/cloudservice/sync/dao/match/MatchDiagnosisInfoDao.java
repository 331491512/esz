package com.esuizhen.cloudservice.sync.dao.match;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.bean.TPatientDiagnosisNoteDetailInfo;
import com.esuizhen.cloudservice.sync.model.DiagnosisInfo;
import com.westangel.common.bean.sync.UuidRelationship;

/**
 * 
 * @author YYCHEN
 *
 */
public interface MatchDiagnosisInfoDao {
	
	/**
	 * 
	 * @param diagnosisInfo
	 * @return
	 */
	public int insert(DiagnosisInfo diagnosisInfo);

	public int updatePatientUuid(@Param("uuidFinal")String uuidFinal, @Param("uuidRelationships")List<UuidRelationship> uuidRelationships);
	
	public int delete(String diagnosisId);
	
	public List<TPatientDiagnosisNoteDetailInfo> findByPatientUuid(String patientUuid);
}
