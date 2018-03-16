/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.bean<br/>  
 * <b>文件名：</b>PatientProfileDetailReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月17日-下午2:39:02<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean;

import java.io.Serializable;

/** 
* @ClassName: PatientProfileDetailReq 
* @Description: TODO
* @author huangdongxing
* @date 2015年12月17日 下午2:39:02  
*/
public class PatientProfileDetailResp implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserProfile userProfile;
	private PatientProfile patientProfile;
	private UserStatisProfile statisProfile;

	public UserStatisProfile getStatisProfile() {
		return statisProfile;
	}

	public void setStatisProfile(UserStatisProfile statisProfile) {
		this.statisProfile = statisProfile;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public PatientProfile getPatientProfile() {
		return patientProfile;
	}

	public void setPatientProfile(PatientProfile patientProfile) {
		this.patientProfile = patientProfile;
	}

}
