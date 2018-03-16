package com.esuizhen.cloudservice.ehr.dao.medicalRecord;

import java.util.List;

import com.esuizhen.cloudservice.ehr.bean.PatientReportResp;

/**
 * @ClassName: PatientReportDao
 * @Description: 检查检验
 * @author zhuguo
 * @date 2017-5-31 10:33:12
 */
public interface PatientReportDao {

	public List<PatientReportResp> getNewReportList(PatientReportResp resp);

	public List<PatientReportResp> getMoreReportList(PatientReportResp resp);
}
