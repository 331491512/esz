package com.esuizhen.client.sync.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.client.sync.bean.TBatchDataResultInfo;
import com.esuizhen.client.sync.model.TBatchDetailInfo;

public interface RHospitalPatientDao {

	List<LinkedHashMap> getBatchSyncRHospitalPatient(@Param("detailInfo") TBatchDetailInfo detailInfo);

	void updateRHospitalPatientSyncflag(@Param("ids") String ids);

	void updateSyncResult(@Param("tBatchDataResultInfo") TBatchDataResultInfo tBatchDataResultInfo);

}
