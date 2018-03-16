package com.esuizhen.cloudservice.ehr.service.medicalRecord;

import java.util.Map;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.bean.RiskfactorsInfo;

public interface RiskfactorsInfoService {
	int insertRiskfactorsInfo(RiskfactorsInfo iskfactorsInfo);
	
	RiskfactorsInfo queryRiskfactorsInfo(CommonReq req);
	
	void deleteRiskfactorsInfo(Map<String,Object> paramsMap);
}
