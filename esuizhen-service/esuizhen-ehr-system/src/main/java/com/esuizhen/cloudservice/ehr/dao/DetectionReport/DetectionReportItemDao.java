package com.esuizhen.cloudservice.ehr.dao.DetectionReport;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.bean.TDetectionItemInfo;
import com.esuizhen.cloudservice.ehr.model.detection.DetectionItemDetail;


public interface DetectionReportItemDao {
	void deleteDetectionReportDetail(@Param("detectionReportId") String detectionReportId);
	void insert(TDetectionItemInfo detectionItemInfo);
	
	List<DetectionItemDetail> getAllDetailGroupByType(@Param("detectionTypeName") String detectionTypeName,@Param("patientId") Long patientId);

	List<Map<String, Object>> getSpecifyDetailByReportId(@Param("detectionReportId") String detectionReportId);
}
