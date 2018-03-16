package com.esuizhen.cloudservice.business.bean;
/** 
 * @ClassName: TPatientActivitySignupReq.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月28日
 */
public class TPatientActivitySignupReq {
	private Long userId;
	private String activityId; //	活动ID
	private String personName;  //	姓名
	private String personIdentity;	//	身份证号
	private String mobile;    //	手机号
	private Long recommendDoctorId; //	推荐医生ID。
	private Integer existFlag;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonIdentity() {
		return personIdentity;
	}
	public void setPersonIdentity(String personIdentity) {
		this.personIdentity = personIdentity;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Long getRecommendDoctorId() {
		return recommendDoctorId;
	}
	public void setRecommendDoctorId(Long recommendDoctorId) {
		this.recommendDoctorId = recommendDoctorId;
	}
	public Integer getExistFlag() {
		return existFlag;
	}
	public void setExistFlag(Integer existFlag) {
		this.existFlag = existFlag;
	}
	
}
