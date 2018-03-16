package com.westangel.common.bean.user;

import java.util.Date;

/**
 * 
* @ClassName: TTobeconfirmedPatient 
* @Description: 待确认患者信息 
* @author LIPENG
* @date 2016年2月23日 下午1:31:40 
*
 */
public class TTobeconfirmedPatient {
	/**
	 * 用户Id
	 */
	private Long userId;
	/**
	 * uuid
	 */
	private String uuid;
	/**
	 * 患者ID
	 */
	private Long patientId;
	
	private String patientNo;
	
	private Integer sex;
	
	/**
	 * 姓名
	 */
	private String trueName;
	/**
	 * 电话
	 */
	private String mobile;
	/**
	 * 医院名称
	 */
	private String hospitalName;
	
	private String diseaseTypeName;
	
	private Date birthDate;
	/**
	 * 患者入院日期
	 */
	private Date inhospitalDate;
	
	
	/**
	 * 产品类型
	 */
	private Integer productId;
	
	/**
	 * 证件号
	 */
	private String identification;
	/**
	 * 匹配类型
	 */
	private Integer matchType;
	/** 
	* @return userId 
	*/
	public Long getUserId() {
		return userId;
	}
	public Date getInhospitalDate() {
		return inhospitalDate;
	}
	public void setInhospitalDate(Date inhospitalDate) {
		this.inhospitalDate = inhospitalDate;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getDiseaseTypeName() {
		return diseaseTypeName;
	}
	public void setDiseaseTypeName(String diseaseTypeName) {
		this.diseaseTypeName = diseaseTypeName;
	}
	/** 
	* @param userId 要设置的 userId 
	*/
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	/** 
	* @return patientId 
	*/
	public Long getPatientId() {
		return patientId;
	}
	/** 
	* @param patientId 要设置的 patientId 
	*/
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/** 
	* @return trueName 
	*/
	public String getTrueName() {
		return trueName;
	}
	/** 
	* @param trueName 要设置的 trueName 
	*/
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	/** 
	* @return hospitalName 
	*/
	public String getHospitalName() {
		return hospitalName;
	}
	/** 
	* @param hospitalName 要设置的 hospitalName 
	*/
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getMatchType() {
		return matchType;
	}
	public void setMatchType(Integer matchType) {
		this.matchType = matchType;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
}
