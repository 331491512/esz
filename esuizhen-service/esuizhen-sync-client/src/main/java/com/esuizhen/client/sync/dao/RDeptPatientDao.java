package com.esuizhen.client.sync.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.client.sync.bean.TBatchDataResultInfo;
import com.esuizhen.client.sync.model.TBatchDetailInfo;

public interface RDeptPatientDao {

	List<LinkedHashMap> getBatchSyncRDeptPatient(@Param("detailInfo")TBatchDetailInfo detailInfo);

	void updateRDeptPatientSyncflag(@Param("ids") String clinicMedicalIds);

	void updateSyncResult(@Param("tBatchDataResultInfo") TBatchDataResultInfo tBatchDataResultInfo);

}
