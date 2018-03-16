package com.esuizhen.cloudservice.ehr.model.inhospital;

public class InhospitalPigeonholeReq {
	/**
	 * 住院id
	 */
	private String inhospitalId;
	/**
	 *门诊id 
	 */
	private String clinicMedicalId;
	/**
	 * 归档状态，old
	 */
	private Integer flag;
	/**
	 * 编目状态，新定义
	 */
	private Integer catalogState;
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
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getCatalogState() {
		return catalogState;
	}
	public void setCatalogState(Integer catalogState) {
		this.catalogState = catalogState;
	}
}
