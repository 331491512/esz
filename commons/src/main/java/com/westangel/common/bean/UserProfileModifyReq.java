package com.westangel.common.bean;

import java.io.Serializable;

import com.westangel.common.bean.DoctorProfile;
import com.westangel.common.bean.PatientProfile;
import com.westangel.common.bean.UserProfile;

/** 
* @ClassName: UserProfileModifyReq 
* @Description: TODO
* @author YYCHEN
* @date 2015年12月17日 下午6:07:42  
*/
public class UserProfileModifyReq implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private UserProfile userProfile;
	private DoctorProfile doctorProfile;
	private PatientProfile patientProfile;
	
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
