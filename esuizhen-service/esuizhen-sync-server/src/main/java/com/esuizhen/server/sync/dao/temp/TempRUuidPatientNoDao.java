package com.esuizhen.server.sync.dao.temp;

import java.util.List;

import com.esuizhen.server.sync.model.temp.SyncRUuidPatientNo;

public interface TempRUuidPatientNoDao {

	void insert(SyncRUuidPatientNo rUuidPatientNo);

	List<SyncRUuidPatientNo> queryRUuidPatientNoList(Object object);
}
