package com.esuizhen.cloudservice.user.model.followuppatient;

import java.util.List;

public class TMedicalPicInfo {
	/**
	 * 病历Id
	 */
	private String emrId;
	/**
	 * 病历时间
	 */
	private String medicalTime;
	/**
	 * 病历类型
	 */
	private String emrTypeName;
	/**
	 * 病历子类型
	 */
	private String emrSubTypeName;
	/**
	 * 图片Url集合
	 */
	private List<String> picFileUrls;
	public String getEmrId() {
		return emrId;
	}
	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}
	public String getMedicalTime() {
		return medicalTime;
	}
	public void setMedicalTime(String medicalTime) {
		this.medicalTime = medicalTime;
	}
	public String getEmrTypeName() {
		return emrTypeName;
	}
	public void setEmrTypeName(String emrTypeName) {
		this.emrTypeName = emrTypeName;
	}
	public String getEmrSubTypeName() {
		return emrSubTypeName;
	}
	public void setEmrSubTypeName(String emrSubTypeName) {
		this.emrSubTypeName = emrSubTypeName;
	}
	public List<String> getPicFileUrls() {
		return picFileUrls;
	}
	public void setPicFileUrls(List<String> picFileUrls) {
		this.picFileUrls = picFileUrls;
	}
}
