package com.esuizhen.cloudservice.ehr.service.medicalRecord;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.TOuthospitalSummaryInfo;
import com.westangel.common.bean.Page;

public interface OuthospitalSummaryService {
	
	TOuthospitalSummaryInfo queryOuthospitalSummary(String inhospitalId);
	
	/**
	 * 分页查询出院列表
	 * @param obj
	 * @return
	 */
	Page<TOuthospitalSummaryInfo> queryPageOuthospitalList(CommonReq req);
}
