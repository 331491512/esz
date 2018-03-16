package com.esuizhen.cloudservice.user.bean;

import java.io.Serializable;

import com.westangel.common.bean.DoctorSimpleInfo;
import com.westangel.common.bean.HospitalProfile;

/** 
* @ClassName: DoctorHospitalSimpleInfo 
* @Description: 医生医院简要信息bean
* @author YYCHEN
* @date 2015年12月25日 下午14:53:33  
*/
public class DoctorHospitalSimpleInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	//医生信息
	private DoctorSimpleInfo doctorInfo;
	//医院
	private HospitalProfile hospitalInfo;
	
	public DoctorSimpleInfo getDoctorInfo() {
		return doctorInfo;
	}
	public void setDoctorInfo(DoctorSimpleInfo doctorInfo) {
		this.doctorInfo = doctorInfo;
	}
	public HospitalProfile getHospitalInfo() {
		return hospitalInfo;
	}
	public void setHospitalInfo(HospitalProfile hospitalInfo) {
		this.hospitalInfo = hospitalInfo;
	}
}
