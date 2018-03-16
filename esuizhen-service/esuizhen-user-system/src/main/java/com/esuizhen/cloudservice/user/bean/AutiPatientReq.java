package com.esuizhen.cloudservice.user.bean;
/** 
 * @ClassName: AutiPatientListReq.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月22日
 */
public class AutiPatientReq {
	private String patientName;
	private String clinicNo;
	private String medicalcareCardNo;
	private String idNo;
	private Integer page;
	private Integer startIndex;
	private Integer num=10;
	private Long firstHospitalId;
	
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getClinicNo() {
		return clinicNo;
	}
	public void setClinicNo(String clinicNo) {
		this.clinicNo = clinicNo;
	}
	public String getMedicalcareCardNo() {
		return medicalcareCardNo;
	}
	public void setMedicalcareCardNo(String medicalcareCardNo) {
		this.medicalcareCardNo = medicalcareCardNo;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public Integer getPage() {
		return this.page;
	}
	public void setPage(Integer  page) {
		this.page = page;
	}
	public Integer getNum() {
		return this.num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Long getFirstHospitalId() {
		return firstHospitalId;
	}
	public void setFirstHospitalId(Long firstHospitalId) {
		this.firstHospitalId = firstHospitalId;
	}
	
}
