package com.esuizhen.client.sync.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.client.sync.bean.TBatchDataResultInfo;
import com.esuizhen.client.sync.model.TBatchDetailInfo;

public interface PatientFamilyDao {

	List<LinkedHashMap> getBatchSyncPatientFamily(@Param("detailInfo")TBatchDetailInfo detailInfo);

	void updatePatientFamilySyncflag(@Param("contactIds") String contactIds);

	void updateSyncResult(@Param("tBatchDataResultInfo")  TBatchDataResultInfo tBatchDataResultInfo);
}
