package com.esuizhen.cloudservice.ehr.service.treatment;

import java.util.Map;

import com.esuizhen.cloudservice.ehr.model.treatment.TreatmentRadiotherapyInfo;

public interface TreatmentRadiotherapyDetailInfoService {
	int saveRadiotherapyDetailInfo(TreatmentRadiotherapyInfo radiotherapyInfo);
	
	void deleteRadiotherapyDetailInfo(Map<String,Object> paramsMap);
}
