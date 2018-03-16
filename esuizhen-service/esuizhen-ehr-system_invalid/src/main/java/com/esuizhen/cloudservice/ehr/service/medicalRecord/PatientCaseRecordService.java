package com.esuizhen.cloudservice.ehr.service.medicalRecord;

import java.util.List;

import com.esuizhen.cloudservice.ehr.bean.AttendPatientReq;
import com.esuizhen.cloudservice.ehr.bean.GenenalExamSignsInfo;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.AdverseReactionResultInfo;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.QualityoflifeInfo;

public interface PatientCaseRecordService {

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
	
	/**
	 * 保存不良反应结果查询
	 * @param req
	 */
	public void saveAdverseReactionResult(List<AdverseReactionResultInfo> infoList);
	
	/**
	 * 查询不良反应结果查询
	 * @param req
	 */
	public List<AdverseReactionResultInfo> queryAdverseReactionResult (AttendPatientReq req);
	
	
}
