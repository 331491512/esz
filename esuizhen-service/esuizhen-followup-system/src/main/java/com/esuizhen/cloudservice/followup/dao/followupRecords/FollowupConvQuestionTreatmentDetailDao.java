package com.esuizhen.cloudservice.followup.dao.followupRecords;

import java.util.List;

import com.esuizhen.cloudservice.followup.bean.TreatmentDetailReq;

public interface FollowupConvQuestionTreatmentDetailDao {
	
	public List<TreatmentDetailReq> getTreatmentTypeDetails(Long followupConvQuestionId);
	
	public void insert(TreatmentDetailReq treatmentDetailReq);
	
	public void deleteByMQIId(Long mainQuestionItemId);
	
}
