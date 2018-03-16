/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>DoctorClinicUsageReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年8月28日下午8:06:56<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;
/** 
* @ClassName: DoctorClinicUsageReq
* @Description: 
* @author lichenghao
* @date 2017年8月28日 下午8:06:56  
*/
public class DoctorClinicUsageReq {
	private Long doctorUserId;
	private Long doctorId;
	private int week;
	private Integer clinicDay;
	public Long getDoctorUserId() {
		return doctorUserId;
	}
	public void setDoctorUserId(Long doctorUserId) {
		this.doctorUserId = doctorUserId;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public Integer getClinicDay() {
		return clinicDay;
	}
	public void setClinicDay(Integer clinicDay) {
		this.clinicDay = clinicDay;
	}
}
