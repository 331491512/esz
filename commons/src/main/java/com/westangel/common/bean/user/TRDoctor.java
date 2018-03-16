package com.westangel.common.bean.user;

import java.io.Serializable;
import java.util.Date;


public class TRDoctor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 医生ID
	 */
	private Long doctorId;
	/**
	 * 住院医师
	 */
	private Long inhospitalDoctorId;
	/**
	 * 主治医师
	 */
	private Long inchargeDoctorId;
	/**
	 * 主任医师
	 */
	private Long directorDoctorId;
	/**
	 * 科主任医师
	 */
	private Long deptDoctorId;
	/**
	 * 科秘
	 */
	private Long deptSecDoctorId;
	/**
	 * 院长
	 */
	private Long deanDoctorId;
	/**
	 * 医生级别
	 */
	private Integer doctorLevel;
	/**
	 * 医院id
	 */
	private Integer hospitalId;
	/**
	 * 数据状态 0：停用 1：启用
	 */
	private Integer state;
	/**
	 * createTime
	 */
	private Date createTime;
	/**
	 * updateTime
	 */
	private Date updateTime;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	
	public Long getDoctorId() {
		return this.doctorId;
	}
	public void setInhospitalDoctorId(Long inhospitalDoctorId) {
		this.inhospitalDoctorId = inhospitalDoctorId;
	}
	
	public Long getInhospitalDoctorId() {
		return this.inhospitalDoctorId;
	}
	public void setInchargeDoctorId(Long inchargeDoctorId) {
		this.inchargeDoctorId = inchargeDoctorId;
	}
	
	public Long getInchargeDoctorId() {
		return this.inchargeDoctorId;
	}
	public void setDirectorDoctorId(Long directorDoctorId) {
		this.directorDoctorId = directorDoctorId;
	}
	
	public Long getDirectorDoctorId() {
		return this.directorDoctorId;
	}
	public void setDeptDoctorId(Long deptDoctorId) {
		this.deptDoctorId = deptDoctorId;
	}
	
	public Long getDeptDoctorId() {
		return this.deptDoctorId;
	}
	public void setDeptSecDoctorId(Long deptSecDoctorId) {
		this.deptSecDoctorId = deptSecDoctorId;
	}
	
	public Long getDeptSecDoctorId() {
		return this.deptSecDoctorId;
	}
	public void setDeanDoctorId(Long deanDoctorId) {
		this.deanDoctorId = deanDoctorId;
	}
	
	public Long getDeanDoctorId() {
		return this.deanDoctorId;
	}
	public void setDoctorLevel(Integer doctorLevel) {
		this.doctorLevel = doctorLevel;
	}
	
	public Integer getDoctorLevel() {
		return this.doctorLevel;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	public Integer getHospitalId() {
		return this.hospitalId;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	public Integer getState() {
		return this.state;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}


}

