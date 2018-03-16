package com.esuizhen.cloudservice.ehr.service.treatment;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.model.treatment.TreatmentRadiotherapyInfo;

public interface TreatmentRadiotherapyInfoService {
	
	List<TreatmentRadiotherapyInfo> queryRadiotherapyInfo(CommonReq req);
	
	int saveRadiotherapyInfo(TreatmentRadiotherapyInfo radiotherapyInfo);
	
	void deleteRadiotherapyInfo(Map<String,Object> paramsMap);
}
