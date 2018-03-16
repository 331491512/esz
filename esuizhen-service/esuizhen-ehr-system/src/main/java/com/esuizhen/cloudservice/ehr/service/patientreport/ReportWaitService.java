package com.esuizhen.cloudservice.ehr.service.patientreport;

import java.util.List;

import com.esuizhen.cloudservice.ehr.model.lisrealtime.TReportPushBatch;

public interface ReportWaitService {

	List<TReportPushBatch> queryWaitPushDetectionReport();

	List<TReportPushBatch> queryWaitPushExamReport();

}
