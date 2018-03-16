package com.esuizhen.client.sync.dao;

import com.esuizhen.client.sync.bean.TBatchDataResultInfo;
import com.esuizhen.client.sync.model.TBatchDetailInfo;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

public interface PatientDao {

	List<LinkedHashMap> getBatchSyncPatient(@Param("detailInfo") TBatchDetailInfo detailInfo);

	List<LinkedHashMap> getBatchSyncUserByPatientUserId(@Param("userIds") String userIds);
	
	void updatePatientSyncflag(Object obj);

	void updateSyncResult(@Param("tBatchDataResultInfo")  TBatchDataResultInfo tBatchDataResultInfo);

	public List<LinkedHashMap> getBatchMegerPatient();
}
