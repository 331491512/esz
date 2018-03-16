package com.esuizhen.cloudservice.business.service.business.mdt;

import com.esuizhen.cloudservice.business.bean.TPatientActivitySignupReq;

/** 
 * @ClassName: PatientActivityService.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月28日
 */
public interface PatientActivityService {
	public Integer searchPatientActivity(TPatientActivitySignupReq req);
	public void markPatientActivity(TPatientActivitySignupReq req);

}
