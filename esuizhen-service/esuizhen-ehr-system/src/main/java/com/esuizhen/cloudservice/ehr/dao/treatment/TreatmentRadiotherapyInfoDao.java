package com.esuizhen.cloudservice.ehr.dao.treatment;

import java.util.Map;  

import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.esuizhen.cloudservice.ehr.model.treatment.TreatmentRadiotherapyInfo;

public interface TreatmentRadiotherapyInfoDao extends CommonDao<TreatmentRadiotherapyInfo>{
	void deleteRadiotherapyInfo(Map<String,Object> paramsMap);
}