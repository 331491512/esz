/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.bean<br/>  
 * <b>文件名：</b>UserProfileDetailReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月10日-下午2:37:50<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean;

import java.io.Serializable;

import com.westangel.common.bean.DoctorProfile;
import com.westangel.common.bean.PatientProfile;
import com.westangel.common.bean.UserProfile;
import com.westangel.common.bean.UserStatisProfile;

/** 
* @ClassName: UserProfileDetailReq 
* @Description: 用户详细信息获取
* @author YYCHEN
* @date 2015年12月10日 下午2:37:50  
*/
public class UserProfileDetailResp implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private UserProfile userProfile;
	private DoctorProfile doctorProfile;
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

	public DoctorProfile getDoctorProfile() {
		return doctorProfile;
	}

	public void setDoctorProfile(DoctorProfile doctorProfile) {
		this.doctorProfile = doctorProfile;
	}

	public PatientProfile getPatientProfile() {
		return patientProfile;
	}

	public void setPatientProfile(PatientProfile patientProfile) {
		this.patientProfile = patientProfile;
	}

}
