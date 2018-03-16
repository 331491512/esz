package com.esuizhen.server.sync.dao.temp;

import java.util.List;

import com.esuizhen.server.sync.model.temp.SyncRDoctorPatient;

public interface TempRDoctorPatientDao {

	void insert(SyncRDoctorPatient rDoctorPatient);
	
	List<SyncRDoctorPatient> queryDoctorPatientByBatchId(Object object);
}
