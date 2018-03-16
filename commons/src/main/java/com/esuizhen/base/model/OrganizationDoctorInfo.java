package com.esuizhen.base.model;

public class OrganizationDoctorInfo {
	//医生编号
	private Long doctorId;
	//医生科室
	private Integer deptId;
	//医生级别
	private Integer doctorLevel;
	//是否本地 1 是  0不是
	private Integer isLocal;
	private Integer hospitalId;
	
	// add by zhuguo
	// 用户角色
	private String userRole;
	
	// 部署位置
	private String deployLocation;
	// end
	
	public String getUserRole() {
		return userRole;
	}
	public String getDeployLocation() {
		return deployLocation;
	}
	public void setDeployLocation(String deployLocation) {
		this.deployLocation = deployLocation;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getDoctorLevel() {
		return doctorLevel;
	}
	public void setDoctorLevel(Integer doctorLevel) {
		this.doctorLevel = doctorLevel;
	}
	public Integer getIsLocal() {
		return isLocal;
	}
	public void setIsLocal(Integer isLocal) {
		this.isLocal = isLocal;
	}
}
