package com.esuizhen.client.sync.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.client.sync.bean.TBatchDataResultInfo;
import com.esuizhen.client.sync.model.TBatchDetailInfo;
import com.esuizhen.client.sync.model.TableInfo;

public interface DetectionReportDao {

	List<LinkedHashMap> getBatchSyncDetectionReport(@Param("detailInfo") TBatchDetailInfo detailInfo);

	void updateDetectionReportSyncflag(@Param("detectionReportIds") String detectionReportIds);

	void updateSyncResult(@Param("tBatchDataResultInfo")  TBatchDataResultInfo tBatchDataResultInfo);

}
