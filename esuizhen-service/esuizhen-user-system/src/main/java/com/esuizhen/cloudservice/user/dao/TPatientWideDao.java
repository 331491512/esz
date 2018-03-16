package com.esuizhen.cloudservice.user.dao;

import com.esuizhen.cloudservice.user.model.TPatientWide;

public interface TPatientWideDao {

	public TPatientWide queryPatientWideByPatientId(Long patientId);
	
	public void insertPatientWide(TPatientWide patientWide);
	
	public void updatePatientWide(TPatientWide patientWide);
	
	public void updateByPrimaryKey(TPatientWide patientWide);
}
