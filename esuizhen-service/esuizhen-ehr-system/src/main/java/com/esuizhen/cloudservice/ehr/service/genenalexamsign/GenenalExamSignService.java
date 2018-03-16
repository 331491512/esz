package com.esuizhen.cloudservice.ehr.service.genenalexamsign;

import com.esuizhen.cloudservice.ehr.bean.AttendPatientReq;
import com.esuizhen.cloudservice.ehr.bean.GenenalExamSignsInfo;

public interface GenenalExamSignService {

	/**
	 * 保存常规体检与体征
	 * @param genenalExamSigns
	 */
	public void saveGenenalExamSignsInfo(GenenalExamSignsInfo genenalExamSigns);
	
	/**
	 * 查询常规体检与体征
	 * @param req
	 */
	public GenenalExamSignsInfo queryGenenalExamSignsInfo(AttendPatientReq req);
}
