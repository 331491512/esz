package com.esuizhen.cloudservice.research.bean;

import java.io.Serializable;

/**
 * <p>Title:TProjectSubcenterDetailInfo</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年10月19日 下午5:14:32
 */
public class TProjectSubcenterRoleInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//分中心ID
	private Long subcenterId;
	//专题ID
	private String projectId;
	//医生ID。
	private Long doctorId;
	//医生在该分中心所属角色ID
	private Integer roleId;
	//分中心角色名称
	private String roleName;
	public Long getSubcenterId() {
		return subcenterId;
	}
	public void setSubcenterId(Long subcenterId) {
		this.subcenterId = subcenterId;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
