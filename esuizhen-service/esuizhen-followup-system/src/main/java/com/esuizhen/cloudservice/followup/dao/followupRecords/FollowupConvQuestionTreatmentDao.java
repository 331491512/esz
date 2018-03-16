package com.esuizhen.cloudservice.followup.dao.followupRecords;

import java.util.List;

import com.esuizhen.cloudservice.followup.bean.FamilyHistoriesReq;
import com.esuizhen.cloudservice.followup.bean.FollowupConvQuestionReq;
import com.esuizhen.cloudservice.followup.bean.SymptomsReq;
import com.esuizhen.cloudservice.followup.bean.TreatmentDetailReq;
import com.esuizhen.cloudservice.followup.bean.TreatmentTypeReq;
import com.esuizhen.cloudservice.followup.bean.VerifiesReq;

public interface FollowupConvQuestionTreatmentDao {
	
	public List<TreatmentTypeReq> getTreatmentTypes(Long followupConvQuestionId);
	
	public void insert(TreatmentTypeReq treatmentTypeReq);
	
	public void deleteByMQIId(Long mainQuestionItemId);
	
	public Integer judgeTreatmentTypes(TreatmentTypeReq treatmentTypeReq);
}
