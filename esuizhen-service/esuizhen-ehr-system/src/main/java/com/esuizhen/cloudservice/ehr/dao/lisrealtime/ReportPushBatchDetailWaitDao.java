package com.esuizhen.cloudservice.ehr.dao.lisrealtime;

import java.util.List;

import com.esuizhen.cloudservice.ehr.model.lisrealtime.TReportPushBatch;

public interface ReportPushBatchDetailWaitDao {
	
	public List<TReportPushBatch> queryReportPushBatchDetailWait();
	
	public List<TReportPushBatch> queryReportPushBatchDetailAlreadly();
	
	public void  insertReportPushBatchDetailWait(TReportPushBatch reportPushBatch);

}
