package com.esuizhen.cloudservice.ehr.dao.treatment;

import java.util.Map;  

import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.esuizhen.cloudservice.ehr.model.treatment.TreatmentChemotherapyMedicationDetailInfo;

public interface TreatmentChemotherapyMedicationDetailInfoDao extends CommonDao<TreatmentChemotherapyMedicationDetailInfo>{
	void deleteTreatmentChemotherapyMedicationDetailInfo(Map<String,Object> paramsMap);
}