package com.esuizhen.cloudservice.followup.dao.followupRecords;



import com.esuizhen.cloudservice.followup.bean.FollowupConvQuestionReq;



public interface FollowupConventionRecordsDao {
	
	public void deleteByPatientId(Integer patientId);
	
	public Integer insert(FollowupConvQuestionReq followupConvQuestionReq);	
	
	public Long getFCQIdBypatientId(Integer patientId);
}
