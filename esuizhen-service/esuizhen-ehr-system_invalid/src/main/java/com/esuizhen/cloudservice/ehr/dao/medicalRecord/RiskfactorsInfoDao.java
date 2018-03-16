package com.esuizhen.cloudservice.ehr.dao.medicalRecord;

import java.util.Map;

import com.esuizhen.cloudservice.ehr.bean.RiskfactorsInfo;

public interface RiskfactorsInfoDao  extends CommonDao<RiskfactorsInfo>{
    void deleteRiskfactorsInfo(Map<String,Object> paramsMap);
}