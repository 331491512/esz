package com.esuizhen.cloudservice.ehr.dao.treatment;

import java.util.Map;  

import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.esuizhen.cloudservice.ehr.model.treatment.TreatmentChemotherapyMedicationInfo;

public interface TreatmentChemotherapyMedicationInfoDao extends CommonDao<TreatmentChemotherapyMedicationInfo>{
	void deleteChemotherapyMedicationInfo(Map<String,Object> paramsMap);
}