package com.esuizhen.cloudservice.ehr.dao.lisrealtime;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.model.lisrealtime.TReportPushBatch;

public interface RealtimeDetectionReportDao {
	
	public List<TReportPushBatch> queryWaitPushDetectionReport(@Param("reportTime")String reportTime);
	
	public List<TReportPushBatch> queryWaitPushDetectionReportByGreyTest(@Param("reportTime")String reportTime);
	
	public void updateHandleFlagByPrimaryKey(@Param("list")List<TReportPushBatch> detectionReportIdList);
}
