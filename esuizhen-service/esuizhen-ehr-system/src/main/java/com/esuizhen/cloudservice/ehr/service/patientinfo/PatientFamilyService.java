package com.esuizhen.cloudservice.ehr.service.patientinfo;

import java.util.Map;

/** 
 *@className PatientFamilyService
 *@Description:
 *@author yuanwenming
 *@date 2017年5月26日
 */
public interface PatientFamilyService {
	boolean addOrModifyPatientFamily(Map<String,Object> paramsMap);
}
