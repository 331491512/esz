package com.esuizhen.cloudservice.ehr.model.medicalRecord;

import java.util.Date;

public class TOuthospitalSummaryInfo {
	
	private String outhospitalId;
	
	private String patientId;
	
	private String inhospitalId;
	
	private String patientNo;
	
	private String trueName;
	
	private String sex;
	
	private Integer age;
	
	private String outhospitalDeptId;
	
	private Integer inhospitalDays;
	
	private Date inhospitalDate;
	
	private Date outhospitalDate;
	
	private String summaryContent;
	
	private Integer inhospitalTimes;
	
	private String hospitalName;

	public String getOuthospitalId() {
		return outhospitalId;
	}

	public void setOuthospitalId(String outhospitalId) {
		this.outhospitalId = outhospitalId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getInhospitalId() {
		return inhospitalId;
	}

	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}

	public Integer getInhospitalTimes() {
		return inhospitalTimes;
	}

	public void setInhospitalTimes(Integer inhospitalTimes) {
		this.inhospitalTimes = inhospitalTimes;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getOuthospitalDeptId() {
		return outhospitalDeptId;
	}

	public void setOuthospitalDeptId(String outhospitalDeptId) {
		this.outhospitalDeptId = outhospitalDeptId;
	}

	public Integer getInhospitalDays() {
		return inhospitalDays;
	}

	public void setInhospitalDays(Integer inhospitalDays) {
		this.inhospitalDays = inhospitalDays;
	}

	public Date getInhospitalDate() {
		return inhospitalDate;
	}

	public void setInhospitalDate(Date inhospitalDate) {
		this.inhospitalDate = inhospitalDate;
	}

	public Date getOuthospitalDate() {
		return outhospitalDate;
	}

	public void setOuthospitalDate(Date outhospitalDate) {
		this.outhospitalDate = outhospitalDate;
	}

	public String getSummaryContent() {
		return summaryContent;
	}

	public void setSummaryContent(String summaryContent) {
		this.summaryContent = summaryContent;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
}
