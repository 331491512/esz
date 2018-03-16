package com.esuizhen.cloudservice.ehr.service.patientreport;

import com.esuizhen.cloudservice.ehr.bean.PatientReportResp;
import com.westangel.common.bean.Page;

/**
 * @ClassName: PatientReportService
 * @Description: 检查检验
 * @author zhuguo
 * @date 2017-5-31 10:31:46
 */
public interface PatientReportService {

	public Page<PatientReportResp> getNewReportList(PatientReportResp resp);

	public Page<PatientReportResp> getMoreReportList(PatientReportResp resp);
}
