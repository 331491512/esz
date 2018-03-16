package com.esuizhen.cloudservice.sync.bean;

public class TPatientWeixinOpenIdInfo {
	/**
	 * 患者uuid
	 */
	private String patientUuid;
	/**
	 * 微信openId
	 */
	private String weixinOpenId;
	/** 
	* @return patientUuid 
	*/
	public String getPatientUuid() {
		return patientUuid;
	}
	/** 
	* @param patientUuid 要设置的 patientUuid 
	*/
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}
	/** 
	* @return weixinOpenId 
	*/
	public String getWeixinOpenId() {
		return weixinOpenId;
	}
	/** 
	* @param weixinOpenId 要设置的 weixinOpenId 
	*/
	public void setWeixinOpenId(String weixinOpenId) {
		this.weixinOpenId = weixinOpenId;
	}
}
