package com.esuizhen.cloudservice.followup.dao.followupRecords;

import java.util.List; 



import com.esuizhen.cloudservice.followup.bean.FollowupConvMainQuestionItemReq;

public interface FollowupConvMainQuestionItemDao {

	public FollowupConvMainQuestionItemReq getMQIIdAndFCQId(Integer patientId);
	
	public List<Long> getMQIIdBypatientId(Integer patientId);
	
	public FollowupConvMainQuestionItemReq getInfoByMQIId(Long mainQuestionItemId);
	
	public Integer insert(FollowupConvMainQuestionItemReq req);
	
	public void deleteByMQIId(Long mainQuestionItemId);
	
}
