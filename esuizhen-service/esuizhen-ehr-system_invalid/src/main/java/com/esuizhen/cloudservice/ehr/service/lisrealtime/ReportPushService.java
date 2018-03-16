package com.esuizhen.cloudservice.ehr.service.lisrealtime;

public interface ReportPushService {

	public void addReportBatchWait();
	
	public void pushReportBatch();
}
