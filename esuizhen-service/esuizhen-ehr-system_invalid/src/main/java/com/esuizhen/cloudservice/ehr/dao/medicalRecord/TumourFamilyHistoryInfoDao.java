package com.esuizhen.cloudservice.ehr.dao.medicalRecord;

import java.util.Map;

import com.esuizhen.cloudservice.ehr.bean.TumourFamilyHistoryInfo;

public interface TumourFamilyHistoryInfoDao  extends CommonDao<TumourFamilyHistoryInfo>{
    void deleteTumourFamilyHistoryInfo(Map<String,Object> paramsMap);
}