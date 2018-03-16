package com.esuizhen.server.sync.dao.temp;

import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.DetectionReportRes;
import com.esuizhen.server.sync.model.temp.SyncEciDetectionReport;

import java.util.List;

public interface TempEciDetectionReportDao {

	void insert(SyncEciDetectionReport eciDetectionReport);

    List<DetectionReportRes> getSyncDetectionReport(TBatchDetailInfo detail);

    /**
     * 需要将数据同时同步到lis_realtime_db(实时库)中
     * @param detail
     * @return
     */
    List<DetectionReportRes> getSyncDetectionReportByRealtime(TBatchDetailInfo detail);
}
