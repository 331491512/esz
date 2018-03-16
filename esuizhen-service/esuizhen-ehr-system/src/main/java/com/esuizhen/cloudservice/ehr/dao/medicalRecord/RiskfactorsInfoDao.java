package com.esuizhen.cloudservice.ehr.dao.medicalRecord;

import java.util.Map;

import com.esuizhen.cloudservice.ehr.bean.RiskfactorsInfo;
import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;

public interface RiskfactorsInfoDao  extends CommonDao<RiskfactorsInfo>{
    void deleteRiskfactorsInfo(Map<String,Object> paramsMap);
}