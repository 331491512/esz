package com.esuizhen.cloudservice.followup.dao.followupTableDao;


import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.followup.bean.FollowupTableReq;

public interface FollowupTableDao {
	
	public Integer isOpenedFollowupTable(@Param("patientId") Integer patientId);
	
	public FollowupTableReq getFollowupTable(@Param("patientId") Integer patientId,@Param("patientId2") Integer patientId2);

	
	public void updateDiagnosis(FollowupTableReq followupTableReq);
	public void updateInhospitalNote(FollowupTableReq followupTableReq);
	public void updateUser(FollowupTableReq followupTableReq);
	public void updateVarPatientMedical(FollowupTableReq followupTableReq);
	public void updatePatient(FollowupTableReq followupTableReq);
}
