package com.esuizhen.cloudservice.user.bean;
/**
 * 
* @ClassName: TWeixinSyncUserInfo 
* @Description: 微信同步用户信息 
* @author LIPENG
* @date 2016年2月25日 下午4:19:00 
*
 */
public class TWeixinSyncPatientInfo {
	private Integer bussinessId;
	private Integer productId;
	private Integer hospitalId;
	private String openId;
	private TWeixinPatientProfile profile;
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
	public TWeixinPatientProfile getProfile() {
		return profile;
	}
	/** 
	* @param profile 要设置的 profile 
	*/
	public void setProfile(TWeixinPatientProfile profile) {
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
}
