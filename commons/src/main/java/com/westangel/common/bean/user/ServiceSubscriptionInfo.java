package com.westangel.common.bean.user;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: ServiceSubscriptionInfo 
* @Description: 
* @author YYCHEN
* @date 2016年1月25日 下午20:13:33  
*/
public class ServiceSubscriptionInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long patientId;
	private Long doctorId;
	private Integer subscriptionFlag;
	private Integer agentApplyFlag;
	private Integer vipFlag;
	private Integer periodFeeType;
	private Date vipBeginTime;
	private Date vipEndTime;
	private String vipProductName;
	private Date createTime;
	private Date updateTime;
	
	/**
	 * @return the subscriptionFlag
	 */
	public Integer getSubscriptionFlag() {
		return subscriptionFlag;
	}
	/**
	 * @param subscriptionFlag the subscriptionFlag to set
	 */
	public void setSubscriptionFlag(Integer subscriptionFlag) {
		this.subscriptionFlag = subscriptionFlag;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
	 * @return the doctorId
	 */
	public Long getDoctorId() {
		return doctorId;
	}

	/**
	 * @param doctorId the doctorId to set
	 */
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the vipFlag
	 */
	public Integer getVipFlag() {
		return vipFlag;
	}
	/**
	 * @param vipFlag the vipFlag to set
	 */
	public void setVipFlag(Integer vipFlag) {
		this.vipFlag = vipFlag;
	}
	/**
	 * @return the periodFeeType
	 */
	public Integer getPeriodFeeType() {
		return periodFeeType;
	}
	/**
	 * @param periodFeeType the periodFeeType to set
	 */
	public void setPeriodFeeType(Integer periodFeeType) {
		this.periodFeeType = periodFeeType;
	}
	/**
	 * @return the vipBeginTime
	 */
	public Date getVipBeginTime() {
		return vipBeginTime;
	}
	/**
	 * @param vipBeginTime the vipBeginTime to set
	 */
	public void setVipBeginTime(Date vipBeginTime) {
		this.vipBeginTime = vipBeginTime;
	}
	/**
	 * @return the vipEndTime
	 */
	public Date getVipEndTime() {
		return vipEndTime;
	}
	/**
	 * @param vipEndTime the vipEndTime to set
	 */
	public void setVipEndTime(Date vipEndTime) {
		this.vipEndTime = vipEndTime;
	}
	/**
	 * @return the vipProductName
	 */
	public String getVipProductName() {
		return vipProductName;
	}
	/**
	 * @param vipProductName the vipProductName to set
	 */
	public void setVipProductName(String vipProductName) {
		this.vipProductName = vipProductName;
	}
	
	public Integer getAgentApplyFlag() {
		return agentApplyFlag;
	}
	public void setAgentApplyFlag(Integer agentApplyFlag) {
		this.agentApplyFlag = agentApplyFlag;
	}
	
	
}
