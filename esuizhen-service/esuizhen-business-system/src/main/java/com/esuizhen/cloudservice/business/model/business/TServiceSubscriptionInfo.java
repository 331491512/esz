package com.esuizhen.cloudservice.business.model.business;

/**
 * 
* @ClassName: TServiceSubscriptionInfo 
* @Description: 医生VIP患者列表 
* @author LIPENG
* @date 2016年2月24日 下午2:28:54 
*
 */
public class TServiceSubscriptionInfo {
	/**
	 * 患者userId
	 */
	private Long patientUserId;
	/**
	 * 订购标记
	 */
	private Integer subscriptionFlag;
	/**
	 * VIP标志
	 */
	private Integer vipFlag;
	/**
	 * 
	 */
	private Integer periodFeeType;
	/**
	 * VIP开始时间
	 */
	private String vipBeginTime;
	/**
	 * VIP结束时间
	 */
	private String vipEndTime;
	/**
	 * 产品名称
	 */
	private String vipProductName;
	/** 
	* @return patientUserId 
	*/
	public Long getPatientUserId() {
		return patientUserId;
	}
	/** 
	* @param patientUserId 要设置的 patientUserId 
	*/
	public void setPatientUserId(Long patientUserId) {
		this.patientUserId = patientUserId;
	}
	/** 
	* @return subscriptionFlag 
	*/
	public Integer getSubscriptionFlag() {
		return subscriptionFlag;
	}
	/** 
	* @param subscriptionFlag 要设置的 subscriptionFlag 
	*/
	public void setSubscriptionFlag(Integer subscriptionFlag) {
		this.subscriptionFlag = subscriptionFlag;
	}
	/** 
	* @return vipFlag 
	*/
	public Integer getVipFlag() {
		return vipFlag;
	}
	/** 
	* @param vipFlag 要设置的 vipFlag 
	*/
	public void setVipFlag(Integer vipFlag) {
		this.vipFlag = vipFlag;
	}
	/** 
	* @return periodFeeType 
	*/
	public Integer getPeriodFeeType() {
		return periodFeeType;
	}
	/** 
	* @param periodFeeType 要设置的 periodFeeType 
	*/
	public void setPeriodFeeType(Integer periodFeeType) {
		this.periodFeeType = periodFeeType;
	}
	/** 
	* @return vipBeginTime 
	*/
	public String getVipBeginTime() {
		return vipBeginTime;
	}
	/** 
	* @param vipBeginTime 要设置的 vipBeginTime 
	*/
	public void setVipBeginTime(String vipBeginTime) {
		this.vipBeginTime = vipBeginTime;
	}
	/** 
	* @return vipEndTime 
	*/
	public String getVipEndTime() {
		return vipEndTime;
	}
	/** 
	* @param vipEndTime 要设置的 vipEndTime 
	*/
	public void setVipEndTime(String vipEndTime) {
		this.vipEndTime = vipEndTime;
	}
	/** 
	* @return vipProductName 
	*/
	public String getVipProductName() {
		return vipProductName;
	}
	/** 
	* @param vipProductName 要设置的 vipProductName 
	*/
	public void setVipProductName(String vipProductName) {
		this.vipProductName = vipProductName;
	}
}
