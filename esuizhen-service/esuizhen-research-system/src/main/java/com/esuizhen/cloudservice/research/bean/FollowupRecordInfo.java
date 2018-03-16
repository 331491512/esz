package com.esuizhen.cloudservice.research.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:FollowupRecordInfo</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年5月30日 下午5:30:07
 */
public class FollowupRecordInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//随访日期
	private Date followupDate;
	//主要诊断名称
	private String mainDiagnosisName;
	//随访结果名称
	private String followupResultName;
	//随访方式名称
	private String followupWayName;
	//随访医生ID
	private Long doctorId;
	//医生姓名
	private String doctorName;
	//随访电话
	private String followupMobile;
	public Date getFollowupDate() {
		return followupDate;
	}
	public void setFollowupDate(Date followupDate) {
		this.followupDate = followupDate;
	}
	public String getMainDiagnosisName() {
		return mainDiagnosisName;
	}
	public void setMainDiagnosisName(String mainDiagnosisName) {
		this.mainDiagnosisName = mainDiagnosisName;
	}
	public String getFollowupResultName() {
		return followupResultName;
	}
	public void setFollowupResultName(String followupResultName) {
		this.followupResultName = followupResultName;
	}
	public String getFollowupWayName() {
		return followupWayName;
	}
	public void setFollowupWayName(String followupWayName) {
		this.followupWayName = followupWayName;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getFollowupMobile() {
		return followupMobile;
	}
	public void setFollowupMobile(String followupMobile) {
		this.followupMobile = followupMobile;
	}
}
