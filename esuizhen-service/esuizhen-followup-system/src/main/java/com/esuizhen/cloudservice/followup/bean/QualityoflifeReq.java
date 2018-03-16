package com.esuizhen.cloudservice.followup.bean;

import java.util.Date;

public class QualityoflifeReq {
	
	private Long patientId;
	
	private Integer isTumourDeath;
	
	private Date deathDate;
	
	/**
	 * 7：门诊
	 * 8:住院
	 */
	private Integer followupWay;
	
	private Long operator;
	
	private Integer hospitalId;
	
	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public Integer getFollowupWay() {
		return followupWay;
	}

	public void setFollowupWay(Integer followupWay) {
		this.followupWay = followupWay;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Integer getIsTumourDeath() {
		return isTumourDeath;
	}

	public void setIsTumourDeath(Integer isTumourDeath) {
		this.isTumourDeath = isTumourDeath;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}
	
}
