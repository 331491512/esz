package com.esuizhen.cloudservice.ehr.model.inhospital;

import java.util.Date;

public class PatientClinicInfoQueryReq {
	/**
	 * 第几页
	 */
	private Integer page;
	/**
	 * 每页个数
	 */
	private Integer num;
	/**
	 * 患者id
	 */
	private Long patientId;
	/**
	 * 起始门诊日期
	 */
	private Date clinicDateStart;
	/**
	 * 结束门诊日期
	 */
	private Date clinicDateEnd;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Date getClinicDateStart() {
		return clinicDateStart;
	}
	public void setClinicDateStart(Date clinicDateStart) {
		this.clinicDateStart = clinicDateStart;
	}
	public Date getClinicDateEnd() {
		return clinicDateEnd;
	}
	public void setClinicDateEnd(Date clinicDateEnd) {
		this.clinicDateEnd = clinicDateEnd;
	}
}
