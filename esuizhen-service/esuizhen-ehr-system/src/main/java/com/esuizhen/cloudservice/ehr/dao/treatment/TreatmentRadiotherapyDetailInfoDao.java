package com.esuizhen.cloudservice.ehr.dao.treatment;

import java.util.Map;  

import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.esuizhen.cloudservice.ehr.model.treatment.TreatmentRadiotherapyDetailInfo;

public interface TreatmentRadiotherapyDetailInfoDao extends CommonDao<TreatmentRadiotherapyDetailInfo>{
	void deleteRadiotherapyDetailInfo(Map<String,Object> paramsMap);
}