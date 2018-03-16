package com.esuizhen.cloudservice.sync.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 子科室、医生关系bean
 * @author YYCHEN
 *
 */
public class SubDeptDoctor implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer deptId;
	private String deptUuid;
	private Integer subDeptId;
	private String subDeptUuid;
	private Long doctorId;
	private String doctorUuid;
	private Integer positionTitle;
	private Date createTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Integer getSubDeptId() {
		return subDeptId;
	}
	public void setSubDeptId(Integer subDeptId) {
		this.subDeptId = subDeptId;
	}
	public String getSubDeptUuid() {
		return subDeptUuid;
	}
	public void setSubDeptUuid(String subDeptUuid) {
		this.subDeptUuid = subDeptUuid;
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
}
