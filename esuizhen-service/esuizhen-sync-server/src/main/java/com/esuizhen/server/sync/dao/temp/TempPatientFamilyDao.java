package com.esuizhen.server.sync.dao.temp;

import java.util.List;

import com.esuizhen.server.sync.model.temp.SyncPatientFamily;

public interface TempPatientFamilyDao {

	void insert(SyncPatientFamily contact);
	
	List<SyncPatientFamily> queryPatientFamilyByBatchId(Object object);

}
