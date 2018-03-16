package com.westangel.common.bean;

import java.io.Serializable;
import java.util.Date;

public class PatientGroupMembers implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private Integer groupId;

	private Long patientId;

	private PatientSimpleInfo patientSimpleInfo;

	private Date createtTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Date getCreatetTime() {
		return createtTime;
	}

	public void setCreatetTime(Date createtTime) {
		this.createtTime = createtTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public PatientSimpleInfo getPatientSimpleInfo() {
		return patientSimpleInfo;
	}

	public void setPatientSimpleInfo(PatientSimpleInfo patientSimpleInfo) {
		this.patientSimpleInfo = patientSimpleInfo;
	}

}