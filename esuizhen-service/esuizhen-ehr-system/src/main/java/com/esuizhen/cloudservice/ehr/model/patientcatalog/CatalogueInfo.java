package com.esuizhen.cloudservice.ehr.model.patientcatalog;

public class CatalogueInfo {
	/**
	 * 医院ID
	 */
	private Integer hospitalId;
	/**
	 * 医院名称
	 */
	private String hospitalName;
	/**
	 * 患者数量
	 */
	private Long patientQuantity;
	/**
	 * 今日新增数量
	 */
	private Long incPatientQuantityWithDate;
	/**
	 * 归档数量
	 */
	private Long archivedQuantity;
	/**
	 * 归档后更新数量
	 */
	private Long archivedQuantityWithUpdate;
	/**
	 * 今日归档数量
	 */
	private Long archivedQuantityWithDate;
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public Long getPatientQuantity() {
		return patientQuantity;
	}
	public void setPatientQuantity(Long patientQuantity) {
		this.patientQuantity = patientQuantity;
	}
	public Long getIncPatientQuantityWithDate() {
		return incPatientQuantityWithDate;
	}
	public void setIncPatientQuantityWithDate(Long incPatientQuantityWithDate) {
		this.incPatientQuantityWithDate = incPatientQuantityWithDate;
	}
	public Long getArchivedQuantity() {
		return archivedQuantity;
	}
	public void setArchivedQuantity(Long archivedQuantity) {
		this.archivedQuantity = archivedQuantity;
	}
	public Long getArchivedQuantityWithUpdate() {
		return archivedQuantityWithUpdate;
	}
	public void setArchivedQuantityWithUpdate(Long archivedQuantityWithUpdate) {
		this.archivedQuantityWithUpdate = archivedQuantityWithUpdate;
	}
	public Long getArchivedQuantityWithDate() {
		return archivedQuantityWithDate;
	}
	public void setArchivedQuantityWithDate(Long archivedQuantityWithDate) {
		this.archivedQuantityWithDate = archivedQuantityWithDate;
	}
}
