package com.esuizhen.cloudservice.ehr.bean;

public class CommonReq {
	/**
	 * 患者id
	 */
	private Long patientId;
	
	/**
	 * 住院id
	 */
	private String inhospitalId;
	
	/**
	 * 门诊id
	 */
	private String clinicMedicalId;
	
	/**
	 * 患者类型。1：普通（默认）；2：特病; -1: 被合并掉的疑似重复患者(类软删除)
	 */
	private Integer patientType;
	
	/**
	 * 门诊住院标识；1：门诊；2：住院
	 */
	private Integer outPatientFlag;
	/**
	 * 第几页
	 */
	private Integer page;
	/**
	 * 每页条数
	 */
	private Integer num;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getInhospitalId() {
		return inhospitalId;
	}

	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}

	public String getClinicMedicalId() {
		return clinicMedicalId;
	}

	public void setClinicMedicalId(String clinicMedicalId) {
		this.clinicMedicalId = clinicMedicalId;
	}

	public Integer getPatientType() {
		return patientType;
	}

	public void setPatientType(Integer patientType) {
		this.patientType = patientType;
	}

	public Integer getOutPatientFlag() {
		return outPatientFlag;
	}

	public void setOutPatientFlag(Integer outPatientFlag) {
		this.outPatientFlag = outPatientFlag;
	}

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
}
