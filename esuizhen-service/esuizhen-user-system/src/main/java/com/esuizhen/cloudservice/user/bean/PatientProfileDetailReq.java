/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>PatientProfileDetailReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年10月12日下午4:11:29<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;
/** 
* @ClassName: PatientProfileDetailReq
* @Description: 
* @author lichenghao
* @date 2016年10月12日 下午4:11:29  
*/
public class PatientProfileDetailReq {
	//患者编号
	private Long patientId;
	//医生编号
	private Long doctorId;
	//医院编号
	private Integer hospitalId;
	
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	public PatientProfileDetailReq(){}
	
	public PatientProfileDetailReq(Long patientId,Long doctorId,Integer hospitalId){
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.hospitalId = hospitalId;
	}
}
