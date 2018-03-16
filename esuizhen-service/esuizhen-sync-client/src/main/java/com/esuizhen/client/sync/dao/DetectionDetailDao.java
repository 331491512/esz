package com.esuizhen.client.sync.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.client.sync.bean.TBatchDataResultInfo;
import com.esuizhen.client.sync.model.TBatchDetailInfo;
import com.esuizhen.client.sync.model.TableInfo;

public interface DetectionDetailDao {

	List<LinkedHashMap> getBatchSyncDetectionDetail(@Param("detailInfo")TBatchDetailInfo detailInfo);

	void updateDetectionDetailSyncflag(@Param("detectionDetailIds") String detectionDetailIds);

	void updateSyncResult(@Param("tBatchDataResultInfo") TBatchDataResultInfo tBatchDataResultInfo);

}
