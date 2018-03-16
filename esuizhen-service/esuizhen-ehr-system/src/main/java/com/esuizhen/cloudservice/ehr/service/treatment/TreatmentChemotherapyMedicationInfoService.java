package com.esuizhen.cloudservice.ehr.service.treatment;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.model.treatment.TreatmentChemotherapyMedicationInfo;

public interface TreatmentChemotherapyMedicationInfoService {
	
	List<TreatmentChemotherapyMedicationInfo> queryChemotherapyMedicationInfo(CommonReq req);
	
	int saveChemotherapyMedicationInfo(TreatmentChemotherapyMedicationInfo chemotherapyMedicationInfo);
	
	void deleteChemotherapyMedicationInfo(Map<String,Object> paramsMap);
}
