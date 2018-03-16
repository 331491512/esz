package com.esuizhen.cloudservice.research.model.result;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:TRSubcenterDoctorRole</p>
 * <p>Description:专题分中心医生角色关系</p>
 * @author YYCHEN
 * @date 2016年10月20日 上午10:51:43
 */
public class TRSubcenterDoctorRole implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键
	private Long id;
	//分中心ID
	private Long subcenterId;
	//专题ID
	private String projectId;
	//医生ID
	private Long doctorId;
	//专题角色
	private Integer roleId;
	//记录创建时间
	private Date createTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSubcenterId() {
		return subcenterId;
	}
	public void setSubcenterId(Long subcenterId) {
		this.subcenterId = subcenterId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
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
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
