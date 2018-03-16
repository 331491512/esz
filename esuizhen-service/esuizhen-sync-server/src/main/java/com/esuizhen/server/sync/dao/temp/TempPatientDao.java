package com.esuizhen.server.sync.dao.temp;

import java.util.List;

import com.esuizhen.server.sync.model.temp.SyncPatient;

public interface TempPatientDao {

	void insert(SyncPatient patient);
	
	List<SyncPatient> queryPatientByBatchId(Object object);

}
