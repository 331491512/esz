package com.esuizhen.cloudservice.ehr.service.medicalRecord;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.ehr.bean.TumourFamilyHistoryInfo;

public interface TumourFamilyHistoryInfoService {
	int batchInsertTumourFamilyHistoryInfo(List<TumourFamilyHistoryInfo> tumourFamilyHistoryInfos);
	
	void deleteTumourFamilyHistoryInfo(Map<String,Object> paramsMap);
}
