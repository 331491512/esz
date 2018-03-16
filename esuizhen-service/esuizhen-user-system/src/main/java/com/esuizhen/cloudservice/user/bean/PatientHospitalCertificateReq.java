/**
 * 
 * @author Da Loong
 * @date  2016年5月28日 下午10:55:51
 */
package com.esuizhen.cloudservice.user.bean;

/**
 * @author Da Loong
 * @date  2016年5月28日 下午10:55:51
 */
public class PatientHospitalCertificateReq {

	private Long patientId;
	
	private Integer  hospitalId;
	
	private String patientNo;//病案号
	
	private String trueName;//姓名
	
	private String mobile;//医院留存手机号

	/**
	 * @return the patientId
	 */
	public Long getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the hospitalId
	 */
	public Integer getHospitalId() {
		return hospitalId;
	}

	/**
	 * @param hospitalId the hospitalId to set
	 */
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	/**
	 * @return the patientNo
	 */
	public String getPatientNo() {
		return patientNo;
	}

	/**
	 * @param patientNo the patientNo to set
	 */
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
