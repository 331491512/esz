package com.esuizhen.cloudservice.sync.dao.cloud;

import java.util.List;

import com.esuizhen.cloudservice.sync.bean.TPatientContactInfo;

/**
 * 患者联系人
 * @author YYCHEN
 *
 */
public interface CloudPatientContacInfoDao {
	
	public long insert(TPatientContactInfo patientContactInfo);

	public List<TPatientContactInfo> find(TPatientContactInfo patientContactInfo);

	public int update(TPatientContactInfo cloudPatientFamily);
	
	public int updateSourceFlag(TPatientContactInfo cloudPatientFamily);
	
	
}
