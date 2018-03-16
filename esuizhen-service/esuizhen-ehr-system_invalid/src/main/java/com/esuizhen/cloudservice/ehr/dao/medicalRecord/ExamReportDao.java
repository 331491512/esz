package com.esuizhen.cloudservice.ehr.dao.medicalRecord;

import java.util.List;

import com.esuizhen.cloudservice.ehr.bean.TExamReportListReq;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.ExamReport;
import com.westangel.common.bean.Doctor;

public interface ExamReportDao {
	
    int deleteByPrimaryKey(String examReportId);

    int insert(ExamReport record);

    int insertSelective(ExamReport record);

    ExamReport selectByPrimaryKey(String examReportid);
    
    Doctor getApplyDoctorByReportId(String reportId);
    
   //查询检查报告列表
  	public List<ExamReport> queryExamReportList(TExamReportListReq param);

  	Long queryExamReportTotalCount(TExamReportListReq param);

    int updateByPrimaryKeySelective(ExamReport record);

    int updateByPrimaryKey(ExamReport record);
    
}