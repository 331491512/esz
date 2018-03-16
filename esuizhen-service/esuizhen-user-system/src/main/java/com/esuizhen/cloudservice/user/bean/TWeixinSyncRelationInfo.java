package com.esuizhen.cloudservice.user.bean;

import java.util.List;

/**
 * 
* @ClassName: TWeixinSyncRelationInfo 
* @Description: 医患关系 
* @author LIPENG
* @date 2016年2月25日 下午4:39:51 
*
 */
public class TWeixinSyncRelationInfo {
	private Integer bussinessId;
	private Integer productId;
	private String patientOpenId;
	private String doctorTicket;
	private TWeixinPatientProfile patientProfile;
	private String patientNo;
	private Integer hospitalId;
	private List<TWeixinDiseaseProfile> diseaseProfile;
	/** 
	* @return patientOpenId 
	*/
	public String getPatientOpenId() {
		return patientOpenId;
	}
	/** 
	* @param patientOpenId 要设置的 patientOpenId 
	*/
	public void setPatientOpenId(String patientOpenId) {
		this.patientOpenId = patientOpenId;
	}
	/** 
	* @return doctorTicket 
	*/
	public String getDoctorTicket() {
		return doctorTicket;
	}
	/** 
	* @param doctorTicket 要设置的 doctorTicket 
	*/
	public void setDoctorTicket(String doctorTicket) {
		this.doctorTicket = doctorTicket;
	}
	/** 
	* @return bussinessId 
	*/
	public Integer getBussinessId() {
		return bussinessId;
	}
	/** 
	* @param bussinessId 要设置的 bussinessId 
	*/
	public void setBussinessId(Integer bussinessId) {
		this.bussinessId = bussinessId;
	}
	/** 
	* @return productId 
	*/
	public Integer getProductId() {
		return productId;
	}
	/** 
	* @param productId 要设置的 productId 
	*/
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	/** 
	* @return patientProfile 
	*/
	public TWeixinPatientProfile getPatientProfile() {
		return patientProfile;
	}
	/** 
	* @param patientProfile 要设置的 patientProfile 
	*/
	public void setPatientProfile(TWeixinPatientProfile patientProfile) {
		this.patientProfile = patientProfile;
	}
	/** 
	* @return diseaseProfile 
	*/
	public List<TWeixinDiseaseProfile> getDiseaseProfile() {
		return diseaseProfile;
	}
	/** 
	* @param diseaseProfile 要设置的 diseaseProfile 
	*/
	public void setDiseaseProfile(List<TWeixinDiseaseProfile> diseaseProfile) {
		this.diseaseProfile = diseaseProfile;
	}
	/** 
	* @return hospitalId 
	*/
	public Integer getHospitalId() {
		return hospitalId;
	}
	/** 
	* @param hospitalId 要设置的 hospitalId 
	*/
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	/** 
	* @return patientNo 
	*/
	public String getPatientNo() {
		return patientNo;
	}
	/** 
	* @param patientNo 要设置的 patientNo 
	*/
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
}
