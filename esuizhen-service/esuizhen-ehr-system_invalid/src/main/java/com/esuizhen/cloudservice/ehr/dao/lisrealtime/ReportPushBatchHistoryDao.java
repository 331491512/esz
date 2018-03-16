package com.esuizhen.cloudservice.ehr.dao.lisrealtime;

import java.util.List;

import com.esuizhen.cloudservice.ehr.model.lisrealtime.TReportPushBatch;

public interface ReportPushBatchHistoryDao {

	public List<TReportPushBatch> queryReportPushBatchHistory();
	
	public void insertReportPushBatchHistory(TReportPushBatch reportPushBatch);
	
	public void batchInsertReportPushBatchHistory(List<TReportPushBatch> reportPushBatch);
}
