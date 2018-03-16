package com.esuizhen.cloudservice.ehr.bean;

import com.westangel.common.bean.UserProfileDetailResp;

public class TConsultDoctorDetailResp {

	/**
	 * 开单医生类型：
	 * 1：开单医生
	 * 2：值班医生
	 */
	private Integer consultDoctorType;
	
	private UserProfileDetailResp userProfileDetailResp;
	
	public Integer getConsultDoctorType() {
		return consultDoctorType;
	}
	public void setConsultDoctorType(Integer consultDoctorType) {
		this.consultDoctorType = consultDoctorType;
	}
	public UserProfileDetailResp getUserProfileDetailResp() {
		return userProfileDetailResp;
	}
	public void setUserProfileDetailResp(UserProfileDetailResp userProfileDetailResp) {
		this.userProfileDetailResp = userProfileDetailResp;
	}
}
