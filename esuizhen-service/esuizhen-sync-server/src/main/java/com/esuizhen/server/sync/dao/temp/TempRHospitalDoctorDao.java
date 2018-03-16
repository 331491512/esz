package com.esuizhen.server.sync.dao.temp;

import java.util.List;

import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.HospitalDoctorRes;
import com.esuizhen.server.sync.model.temp.SyncRHospitalDoctor;

public interface TempRHospitalDoctorDao {

	void insert(SyncRHospitalDoctor rHospitalDoctor);

    List<HospitalDoctorRes> getSyncHospitalDoctor(TBatchDetailInfo detail);
}
	