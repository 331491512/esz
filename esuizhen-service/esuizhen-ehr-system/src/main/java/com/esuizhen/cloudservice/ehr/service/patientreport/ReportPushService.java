package com.esuizhen.cloudservice.ehr.service.patientreport;

public interface ReportPushService {

	public void addReportBatchWait();
	
	public void pushReportBatch();
}
