package com.esuizhen.cloudservice.ehr.dao.lisrealtime;

import com.esuizhen.cloudservice.ehr.model.lisrealtime.TReportPushBatch;

public interface ReportPushLogDao {
	
	public void  insertReportPushLog(TReportPushBatch reportPushBatch);

}
