package com.esuizhen.cloudservice.ehr.dao.lisrealtime;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.model.lisrealtime.TReportPushBatch;

public interface RealtimeExamReportDao {
	
	public List<TReportPushBatch> queryWaitPushExamReport(@Param("reportTime")String reportTime);
	
	public List<TReportPushBatch> queryWaitPushExamReportByGreyTest(@Param("reportTime")String reportTime);
	
	public void updateHandleFlagByPrimaryKey(@Param("list")List<TReportPushBatch> examReportIdList);
}
