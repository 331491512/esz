package com.esuizhen.cloudservice.ehr.service.adversereaction;

import java.util.List;

import com.esuizhen.cloudservice.ehr.bean.AttendPatientReq;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.AdverseReactionResultInfo;

public interface AdverseReactionService {
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
