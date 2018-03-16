package com.esuizhen.cloudservice.user.bean;

import java.util.List;

/**
 * 
* @ClassName: TWeixinSyncDiseaseInfo 
* @Description: 微信同步疾病信息 
* @author LIPENG
* @date 2016年2月25日 下午4:19:13 
*
 */
public class TWeixinSyncDiseaseInfo {
	private Integer bussinessId;
	private Integer productId;
	private String openId;
	private Integer hospitalId;
	/**
	 * 病案号
	 */
	private String patientNo;
	/**
	 * 病种信息
	 */
	private List<TWeixinDiseaseProfile> profile;
	/** 
	* @return openId 
	*/
	public String getOpenId() {
		return openId;
	}
	/** 
	* @param openId 要设置的 openId 
	*/
	public void setOpenId(String openId) {
		this.openId = openId;
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
	* @return profile 
	*/
	public List<TWeixinDiseaseProfile> getProfile() {
		return profile;
	}
	/** 
	* @param profile 要设置的 profile 
	*/
	public void setProfile(List<TWeixinDiseaseProfile> profile) {
		this.profile = profile;
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
