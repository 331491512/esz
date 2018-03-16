package com.esuizhen.cloudservice.followup.dao.followupRecords;

import java.util.List;

import com.esuizhen.cloudservice.followup.bean.FamilyHistoriesReq;
import com.esuizhen.cloudservice.followup.bean.FollowupConvQuestionReq;
import com.esuizhen.cloudservice.followup.bean.SymptomsReq;
import com.esuizhen.cloudservice.followup.bean.TreatmentDetailReq;
import com.esuizhen.cloudservice.followup.bean.TreatmentTypeReq;
import com.esuizhen.cloudservice.followup.bean.VerifiesReq;

public interface FollowupConvQuestionVerifyDao {
	
	public List<VerifiesReq> getVerifies(Long followupConvQuestionId);
	
	public void insert(VerifiesReq verifiesReq);
	
	public void deleteByMQIId(Long mainQuestionItemId);
}
