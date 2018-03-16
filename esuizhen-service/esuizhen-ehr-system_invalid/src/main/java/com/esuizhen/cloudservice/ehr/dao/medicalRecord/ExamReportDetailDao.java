package com.esuizhen.cloudservice.ehr.dao.medicalRecord;

import com.esuizhen.cloudservice.ehr.model.medicalRecord.ExamReportDetail;

public interface ExamReportDetailDao {
	
    int deleteByPrimaryKey(String examReportDetailId);
    
    int deleteByExamReportId(String examReportId);

    int insert(ExamReportDetail record);

    int insertSelective(ExamReportDetail record);

    ExamReportDetail selectByPrimaryKey(String examReportDetailId);

    int updateByPrimaryKeySelective(ExamReportDetail record);

    int updateByPrimaryKey(ExamReportDetail record);
}