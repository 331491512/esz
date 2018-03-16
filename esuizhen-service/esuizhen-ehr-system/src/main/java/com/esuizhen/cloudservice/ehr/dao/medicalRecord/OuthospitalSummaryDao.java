package com.esuizhen.cloudservice.ehr.dao.medicalRecord;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.ehr.model.medicalRecord.TOuthospitalSummaryInfo;

public interface OuthospitalSummaryDao {
	
	TOuthospitalSummaryInfo queryOuthospitalSummary(String inhospitalId);
	
	/**
	 * 查询出院列表
	 * @param obj
	 * @return
	 */
	List<TOuthospitalSummaryInfo> queryOuthospitalList(Map<String,Object> paramsMap);
}
