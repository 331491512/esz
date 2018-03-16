package com.esuizhen.cloudservice.followup.dao.followupresult;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupTaskPatient;

public interface FollowupTaskPatientDao {

	public Integer updateFollowupTaskPatient(TFollowupTaskPatient followupTaskPatient);
	
	public TFollowupTaskPatient queryFollowupTaskByPatientId(
			@Param("followupTaskId")String followupTaskId, 
			@Param("followupAssignId")String followupAssignId,
			@Param("patientId")Long patientId);
	
	public TFollowupTaskPatient queryUnfinishedFollowupTaskByPatientId(@Param("patientId")Long patientId,@Param("followupTime")Date followupTime);
}
