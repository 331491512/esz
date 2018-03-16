package com.esuizhen.server.sync.dao.temp;

import java.util.List;

import com.esuizhen.server.sync.model.temp.SyncRDeptPatient;

public interface TempRDeptPatientDao {

	void insert(SyncRDeptPatient rDeptPatient);
	
	List<SyncRDeptPatient> queryDeptPatientByBatchId(Object object);
}
