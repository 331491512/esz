package com.esuizhen.cloudservice.followup.dao.followupresult;

public interface FollowupResultQualityAnalysisDao {
	
	public void updateMoreDeathFollowupResultFlag();
	
	public void updateDeathNotFollowupResultFlag();
	
	public void updateDeathNotFollowupTimeFlag();
	
	public void updateDeathBeforeHasFollowupResultFlag();
	
	public void updateDeathAfterHasFollowupResultFlag();
	
	public void updateMedicalRecordNotFollowupResultFlag();
	
	public void updateDeathPatientIntoTask();
	
	public void updateLostPatientIntoTask();

}
