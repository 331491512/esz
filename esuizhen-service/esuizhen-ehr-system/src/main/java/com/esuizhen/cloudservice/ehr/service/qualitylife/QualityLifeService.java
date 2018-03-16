package com.esuizhen.cloudservice.ehr.service.qualitylife;

import com.esuizhen.cloudservice.ehr.bean.AttendPatientReq;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.QualityoflifeInfo;

public interface QualityLifeService {

	/**
	 * 保存身体状态评分
	 * @param qualityoflifeInfo
	 */
	public void saveQualityoflifeInfo(QualityoflifeInfo qualityoflifeInfo);
	
	/**
	 * 查询身体状态评分
	 * @param req
	 * @return
	 */
	public QualityoflifeInfo queryQualityoflifeInfo(AttendPatientReq req);
}
