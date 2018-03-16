package com.esuizhen.cloudservice.business.dao.business.mdt;

import com.esuizhen.cloudservice.business.bean.TPatientActivitySignupReq;

/** 
 * @ClassName: PatientActivityDao.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月28日
 */
public interface PatientActivityDao {
	
	Integer searchPatientActivity(TPatientActivitySignupReq req);
	void insertPatientActivity(TPatientActivitySignupReq req);
}
