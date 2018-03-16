package com.esuizhen.cloudservice.ehr.dao.DetectionReport;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.bean.TDetectionReportDetailInfo;
import com.esuizhen.cloudservice.ehr.model.detection.DetectionReport;
import com.westangel.common.bean.Doctor;


public interface DetectionReportDao {
	void deleteDetectionReport(@Param("detectionReportId") String detectionReportId);
	void insert(TDetectionReportDetailInfo detailInfo);
	
	List<DetectionReport> getAllReportGroupByType(@Param("patientId") Long patientId);
	Map<String, Object> getSpecifyReportByReportId(@Param("detectionReportId") String detectionReportId);
	
	Doctor getApplyDoctorByReportId(String reportId);
}
