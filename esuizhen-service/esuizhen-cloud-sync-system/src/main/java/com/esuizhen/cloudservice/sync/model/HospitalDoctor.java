package com.esuizhen.cloudservice.sync.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 医院、科室、医生关系bean
 * @author YYCHEN
 *
 */
public class HospitalDoctor implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer hospitalId;
	private String hospitalUuid;
	private Integer deptId;
	private String deptUuid;
	private String staffNo;
	private Long doctorId;
	private String doctorUuid;
	private Integer positionTitle;
	private Date createTime;
	private Date syncTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalUuid() {
		return hospitalUuid;
	}
	public void setHospitalUuid(String hospitalUuid) {
		this.hospitalUuid = hospitalUuid;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptUuid() {
		return deptUuid;
	}
	public void setDeptUuid(String deptUuid) {
		this.deptUuid = deptUuid;
	}
	public String getStaffNo() {
		return staffNo;
	}
	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorUuid() {
		return doctorUuid;
	}
	public void setDoctorUuid(String doctorUuid) {
		this.doctorUuid = doctorUuid;
	}
	public Integer getPositionTitle() {
		return positionTitle;
	}
	public void setPositionTitle(Integer positionTitle) {
		this.positionTitle = positionTitle;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getSyncTime() {
		return syncTime;
	}
	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}
}
