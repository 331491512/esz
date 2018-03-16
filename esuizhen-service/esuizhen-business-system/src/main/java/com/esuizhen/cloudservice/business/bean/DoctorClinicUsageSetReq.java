/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>DoctorClinicUsageSetReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年1月18日下午6:11:58<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;
/** 
* @ClassName: DoctorClinicUsageSetReq
* @Description: 预约挂号设置
* @author lichenghao
* @date 2016年1月18日 下午6:11:58  
*/
public class DoctorClinicUsageSetReq {
	//编号
	private String id;
	//医生用户编号
	private Long doctorUserId;
	//患者用户编号
	private Long patientUserId;
	//患者编号
	private Long patientId;
	//医生编号
	private Long doctorId;
	//门诊日期
	private String clinicDate;
	//门诊时间
	private Integer clinicTime;
	//年份
	private Integer year;
	//第几周
	private Integer week;
	//周几
	private Integer clinicDay;
	//早上预约号
	private Integer moningUsage;
	//下午预约号
	private Integer afternoonUsage;
	//晚上预约号
	private Integer eveningUsage;
	public Long getDoctorUserId() {
		return doctorUserId;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDoctorUserId(Long doctorUserId) {
		this.doctorUserId = doctorUserId;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getWeek() {
		return week;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
	public Integer getClinicDay() {
		return clinicDay;
	}
	public void setClinicDay(Integer clinicDay) {
		this.clinicDay = clinicDay;
	}
	public Integer getMoningUsage() {
		return moningUsage;
	}
	public void setMoningUsage(Integer moningUsage) {
		this.moningUsage = moningUsage;
	}
	public Integer getAfternoonUsage() {
		return afternoonUsage;
	}
	public void setAfternoonUsage(Integer afternoonUsage) {
		this.afternoonUsage = afternoonUsage;
	}
	public Integer getEveningUsage() {
		return eveningUsage;
	}
	public void setEveningUsage(Integer eveningUsage) {
		this.eveningUsage = eveningUsage;
	}
	public Long getPatientUserId() {
		return patientUserId;
	}

	public void setPatientUserId(Long patientUserId) {
		this.patientUserId = patientUserId;
	}

	public String getClinicDate() {
		return clinicDate;
	}

	public void setClinicDate(String clinicDate) {
		this.clinicDate = clinicDate;
	}

	public Integer getClinicTime() {
		return clinicTime;
	}

	public void setClinicTime(Integer clinicTime) {
		this.clinicTime = clinicTime;
	}
	
	public String countClinicDateAndClinicTime(){
		String time="";
		if(this.clinicTime!=null)
		if(this.clinicTime==0){
			time="上午";
		}else if(this.clinicTime==1){
			time="下午";
		}else if(this.clinicTime==2){
			time="晚上";
		}
		return this.clinicDate+time;
	}

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
}
