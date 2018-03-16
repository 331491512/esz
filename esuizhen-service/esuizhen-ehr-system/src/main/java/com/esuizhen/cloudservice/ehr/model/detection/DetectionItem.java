package com.esuizhen.cloudservice.ehr.model.detection;

import java.util.Date;

/** 
 * @ClassName: DetecTionItem.java
 * @Description: 
 * @author fanpanwei	
 * @date   2017年4月24日
 */
public class DetectionItem {
	private String detectionReportId;
	private Date reportTime;
	private String hospitalName;
	public String getDetectionReportId() {
		return detectionReportId;
	}
	public void setDetectionReportId(String detectionReportId) {
		this.detectionReportId = detectionReportId;
	}
	public Date getReportTime() {
		return reportTime;
	}
	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
}
