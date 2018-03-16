package com.esuizhen.client.sync.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.client.sync.bean.TBatchDataResultInfo;
import com.esuizhen.client.sync.model.TBatchDetailInfo;
import com.esuizhen.client.sync.model.TableInfo;

public interface OuthospitalNoteDao {

	List<LinkedHashMap> getBatchSyncOuthospitalNote(@Param("detailInfo") TBatchDetailInfo detailInfo);

	void updateOuthospitalNoteSyncflag(@Param("outhospitalIds")  String outhospitalIds);

	void updateSyncResult(@Param("tBatchDataResultInfo")  TBatchDataResultInfo tBatchDataResultInfo);
}
