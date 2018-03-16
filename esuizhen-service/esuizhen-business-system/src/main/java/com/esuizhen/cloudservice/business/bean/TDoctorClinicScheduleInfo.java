/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.model.business;<br/>  
 * <b>文件名：</b>TDoctorClinicScheduleInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月12日下午5:55:18<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;

import java.util.Date;

/** 
* @ClassName: TDoctorClinicScheduleInfo.java
* @Description: 医生出诊时间信息
* @author lichenghao
* @date 2015年12月12日 下午5:55:18  
*/
public class TDoctorClinicScheduleInfo {
	/**
	 * 门诊日期
	 */
	private Date clinicDate;
	/**
	 * 门诊时间
	 */
	private int clinicDay;
	/**
	 * 医生编号
	 */
	private Long doctorId;
	/**
	 * 医生userId
	 */
	private Long doctorUserId;
	/**
	 * 医院编号
	 */
	private Long hospitalId;
	/**
	 * 门诊类别, 费用
	 */
	private String moningSchedule;
	private Integer moningLimit;
	private Integer moningSet;
	private String afternoonSchedule;
	private Integer afternoonLimit;
	private Integer afternoonSet;
	private String eveningSchedule;
	private Integer eveningLimit;
	private Integer eveningSet;
	//早上预约号
	private Integer moningUsage;
	//下午预约号
	private Integer afternoonUsage;
	//晚上预约号
	private Integer eveningUsage;
	//加号项Id
	private Long clinicItemId;
	//0本周  1下周
	private Integer week;
	public int getClinicDay() {
		return clinicDay;
	}
	public void setClinicDay(int clinicDay) {
		this.clinicDay = clinicDay;
	}
	public String getMoningSchedule() {
		return moningSchedule;
	}
	public void setMoningSchedule(String moningSchedule) {
		this.moningSchedule = moningSchedule;
	}
	public String getAfternoonSchedule() {
		return afternoonSchedule;
	}
	public void setAfternoonSchedule(String afternoonSchedule) {
		this.afternoonSchedule = afternoonSchedule;
	}
	public String getEveningSchedule() {
		return eveningSchedule;
	}
	public void setEveningSchedule(String eveningSchedule) {
		this.eveningSchedule = eveningSchedule;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Long getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Integer getMoningLimit() {
		return moningLimit;
	}
	public void setMoningLimit(Integer moningLimit) {
		this.moningLimit = moningLimit;
	}
	public Integer getAfternoonLimit() {
		return afternoonLimit;
	}
	public void setAfternoonLimit(Integer afternoonLimit) {
		this.afternoonLimit = afternoonLimit;
	}
	public Integer getEveningLimit() {
		return eveningLimit;
	}
	public void setEveningLimit(Integer eveningLimit) {
		this.eveningLimit = eveningLimit;
	}
	public Long getDoctorUserId() {
		return doctorUserId;
	}
	public void setDoctorUserId(Long doctorUserId) {
		this.doctorUserId = doctorUserId;
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
	public Long getClinicItemId() {
		return clinicItemId;
	}
	public void setClinicItemId(Long clinicItemId) {
		this.clinicItemId = clinicItemId;
	}
	public Integer getWeek() {
		return week;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
	public Integer getMoningSet() {
		return moningSet;
	}
	public void setMoningSet(Integer moningSet) {
		this.moningSet = moningSet;
	}
	public Integer getAfternoonSet() {
		return afternoonSet;
	}
	public void setAfternoonSet(Integer afternoonSet) {
		this.afternoonSet = afternoonSet;
	}
	public Integer getEveningSet() {
		return eveningSet;
	}
	public void setEveningSet(Integer eveningSet) {
		this.eveningSet = eveningSet;
	}
	
	public Date getClinicDate() {
		return clinicDate;
	}
	public void setClinicDate(Date clinicDate) {
		this.clinicDate = clinicDate;
	}
	public TDoctorClinicScheduleInfo(){}
	public TDoctorClinicScheduleInfo(Long doctorId,Long doctorUserId,Long hospitalId){
		this.doctorId=doctorId;
		this.doctorUserId=doctorUserId;
		this.hospitalId=hospitalId;
		this.moningSchedule="";
		this.afternoonSchedule="";
		this.eveningSchedule="";
		this.moningSet=0;
		this.afternoonSet=0;
		this.eveningSet=0;
	}
}
