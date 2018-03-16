package com.esuizhen.cloudservice.sync.dao.match;

import java.util.List;

import com.esuizhen.cloudservice.sync.bean.TPatientContactInfo;

/**
 * 患者联系人
 * @author YYCHEN
 *
 */
public interface MatchPatientContacInfoDao {
	
	public long insert(TPatientContactInfo patientContactInfo);
	
	public int delete(Long id);

	public List<TPatientContactInfo> findByPatientId(Long patientId);
	
	//add by fanpanwei
	public List<TPatientContactInfo> findByPatientUuid(String patientUuid);
}
