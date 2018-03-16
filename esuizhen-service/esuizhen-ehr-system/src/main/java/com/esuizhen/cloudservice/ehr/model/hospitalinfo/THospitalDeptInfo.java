package com.esuizhen.cloudservice.ehr.model.hospitalinfo;

import java.util.Date;


public class THospitalDeptInfo{
	
	/**
	 * 科室ID。主键。 唯一标识一个科室。从10开始自增。（0-9表示系统预留的特殊用户）
	 */
	private Integer deptId;
	/**
	 * 医院ID。外键
	 */
	private Integer hospitalId;
	/**
	 * uuid
	 */
	private String uuid;
	/**
	 * 科室名字
	 */
	private String deptName;
	/**
	 * 科室等级
	 */
	private Integer level;
	/**
	 * 科室电话
	 */
	private String tel;
	/**
	 * 科室介绍
	 */
	private String introduction;
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	
	public Integer getDeptId() {
		return this.deptId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	public Integer getHospitalId() {
		return this.hospitalId;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getUuid() {
		return this.uuid;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public String getDeptName() {
		return this.deptName;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public Integer getLevel() {
		return this.level;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getTel() {
		return this.tel;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public String getIntroduction() {
		return this.introduction;
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

