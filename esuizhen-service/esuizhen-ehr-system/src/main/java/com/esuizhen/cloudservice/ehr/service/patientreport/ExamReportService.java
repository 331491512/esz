package com.esuizhen.cloudservice.ehr.service.patientreport;

import java.util.List;

import com.esuizhen.cloudservice.ehr.bean.TExamReportDetailInfo;
import com.esuizhen.cloudservice.ehr.bean.TExamReportListReq;
import com.esuizhen.cloudservice.ehr.bean.TReportSimpleInfo;
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
	
	/**
	 * 获取检查报告列表
	 * @author lichenghao
	 * @title :getInspectionResultList
	 * @Description:TODO
	 * @return Page<TReportSimpleInfo>
	 * @date 2016年5月3日 下午4:18:12
	 */
	Page<TReportSimpleInfo> getInspectionResultList(Long patientId, Integer hospitalId, Integer resultFlag, Integer sortFlag,
			Integer page, Integer num);
	
	/**
	 * 获取检查报告详情
	 * @author lichenghao
	 * @title :getExamReportDetail
	 * @Description:TODO
	 * @return Object
	 * @date 2016年5月3日 下午4:18:56
	 */
	TExamReportDetailInfo getExamReportDetail(String reportId);
	
}
