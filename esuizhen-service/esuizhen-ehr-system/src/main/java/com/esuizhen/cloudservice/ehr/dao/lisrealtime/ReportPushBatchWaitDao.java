package com.esuizhen.cloudservice.ehr.dao.lisrealtime;

import java.util.List;

import com.esuizhen.cloudservice.ehr.model.lisrealtime.TReportPushBatch;

public interface ReportPushBatchWaitDao {

	public List<TReportPushBatch> queryReportPushBatchWait();
	
	public void insertReportPushBatchWait(TReportPushBatch reportPushBatch);
	
	public void updateReportPushBatchWait(TReportPushBatch reportPushBatch);
	
	public void cascadeDeleteReportPushBatchWait();
}
