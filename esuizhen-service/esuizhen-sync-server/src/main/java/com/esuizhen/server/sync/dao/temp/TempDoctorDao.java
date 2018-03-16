package com.esuizhen.server.sync.dao.temp;

import java.util.List;

import com.esuizhen.server.sync.model.temp.SyncDoctor;

public interface TempDoctorDao {

	void insert(SyncDoctor doctor);

	List<SyncDoctor> queryDoctorByBatchId(Object object);

}
