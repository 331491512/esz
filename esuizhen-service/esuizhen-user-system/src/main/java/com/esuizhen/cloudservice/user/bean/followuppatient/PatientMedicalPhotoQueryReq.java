package com.esuizhen.cloudservice.user.bean.followuppatient;

public class PatientMedicalPhotoQueryReq {
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
}
