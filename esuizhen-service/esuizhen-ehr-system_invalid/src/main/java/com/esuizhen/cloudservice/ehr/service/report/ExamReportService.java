package com.esuizhen.cloudservice.ehr.service.report;

import java.util.List;

import com.esuizhen.cloudservice.ehr.bean.TExamReportListReq;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.ExamReport;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.EmptyObjectExcption;

public interface ExamReportService {

	/**
	 * 获取检查报告列表
	 * @param req
	 * @return
	 * @throws EmptyObjectExcption
	 */
	Page<ExamReport> getExamReportList(TExamReportListReq req) throws EmptyObjectExcption;

	/**
	 * 添加检查报告
	 * @param examReportList
	 */
	List<ExamReport> batchAddExamReport(List<ExamReport> examReportList);
	
}
