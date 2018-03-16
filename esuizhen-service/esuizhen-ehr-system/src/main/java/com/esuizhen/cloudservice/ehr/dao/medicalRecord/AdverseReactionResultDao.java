package com.esuizhen.cloudservice.ehr.dao.medicalRecord;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.bean.AttendPatientReq;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.AdverseReactionResultInfo;

public interface AdverseReactionResultDao {

	public List<AdverseReactionResultInfo>queryAdverseReactionResult(AttendPatientReq req);
	
	public Integer insertAdverseReactionResultInfo(AdverseReactionResultInfo info);
	
	public Integer updateAdverseReactionResultInfo(AdverseReactionResultInfo info);
	
	public void deleteAdverseReactionResultInfo(@Param("adverseReactionRecordId") String adverseReactionRecordId);
	
}
