package com.esuizhen.cloudservice.ehr.service.treatment;

import java.util.Map;

import com.esuizhen.cloudservice.ehr.model.treatment.TreatmentChemotherapyMedicationInfo;

public interface TreatmentChemotherapyMedicationDetailInfoService {
	
	int saveTreatmentChemotherapyMedicationDetailInfo(TreatmentChemotherapyMedicationInfo chemotherapyMedicationInfo);
	
	void deleteTreatmentChemotherapyMedicationDetailInfo(Map<String,Object> paramsMap);
}
