package com.esuizhen.cloudservice.ehr.dao.lisrealtime;

import java.util.List;

import com.esuizhen.cloudservice.ehr.model.lisrealtime.TReportPushBatch;

public interface ReportPushBatchDetailHistoryDao {
	
	public void  batchInsertReportPushBatchDetailHistory(List<TReportPushBatch> list);

}
