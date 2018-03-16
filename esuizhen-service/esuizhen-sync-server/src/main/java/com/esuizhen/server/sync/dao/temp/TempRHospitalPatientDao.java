package com.esuizhen.server.sync.dao.temp;

import java.util.List;

import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.HospitalPatientRes;
import com.esuizhen.server.sync.model.temp.SyncRHospitalPatient;

public interface TempRHospitalPatientDao {

	void insert(SyncRHospitalPatient rHospitalPatient);

	List<HospitalPatientRes> getSyncHospitalPatient(TBatchDetailInfo detail);
}
