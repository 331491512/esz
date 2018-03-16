/**
 * 
 * @author Da Loong
 * @date  2016年5月2日 下午6:11:07
 */
package com.esuizhen.cloudservice.user.bean;

/**
 * 医院简要信息
 * @author Da Loong
 * @date  2016年5月2日 下午6:11:07
 */
public class THospitalSimpleInfo {

	private Long userId;
	
	private int  hospitalId;
	
	private String hospitalName;
	
	private int  cityId;
	
	private String cityCode;
	
	private String cityName;

	
	private String patientNo;
	
	private String pictureUrl;
	
	/**
	 * 医院认证信息
	 */
	private String trueName;
	
	private String mobile;
	
	private String certificatedPatientNo;

	private Integer certificatedState;

	private String cause;

	private String checkResult;//认证失败原因

	private Integer failState;

	public Integer getFailState() {
		return failState;
	}

	public void setFailState(Integer failState) {
		this.failState = failState;
	}

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public Integer getCertificatedState() {
		return certificatedState;
	}

	public void setCertificatedState(Integer certificatedState) {
		this.certificatedState = certificatedState;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the hospitalId
	 */
	public int getHospitalId() {
		return hospitalId;
	}

	/**
	 * @param hospitalId the hospitalId to set
	 */
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	/**
	 * @return the hospitalName
	 */
	public String getHospitalName() {
		return hospitalName;
	}

	/**
	 * @param hospitalName the hospitalName to set
	 */
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	/**
	 * @return the cityId
	 */
	public int getCityId() {
		return cityId;
	}

	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	/**
	 * @return the cityCode
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * @param cityCode the cityCode to set
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	/**
	 * @return the city
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param city the city to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the pictureUrl
	 */
	public String getPictureUrl() {
		return pictureUrl;
	}

	/**
	 * @param pictureUrl the pictureUrl to set
	 */
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
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

	public String getCertificatedPatientNo() {
		return certificatedPatientNo;
	}

	public void setCertificatedPatientNo(String certificatedPatientNo) {
		this.certificatedPatientNo = certificatedPatientNo;
	}
}
