package com.esuizhen.cloudservice.sync.dao.incre;

import com.esuizhen.cloudservice.sync.bean.TPatientContactInfo;

/**
 * 患者联系人
 * @author YYCHEN
 *
 */
public interface IncrePatientContactInfoDao {
	
	public long insert(TPatientContactInfo patientContactInfo);
}
