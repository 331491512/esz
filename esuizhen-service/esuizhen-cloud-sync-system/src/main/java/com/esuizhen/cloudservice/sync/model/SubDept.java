package com.esuizhen.cloudservice.sync.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 子科室bean
 * @author YYCHEN
 *
 */
public class SubDept implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer subDeptId;
	private Integer deptId;
	private String deptUuid;
	private String subDeptName;
	private Integer level;
	private String tel;
	private String introduction;
	private Date createTime;
	private Date updateTime;
	
	public Integer getSubDeptId() {
		return subDeptId;
	}
	public void setSubDeptId(Integer subDeptId) {
		this.subDeptId = subDeptId;
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
	public String getSubDeptName() {
		return subDeptName;
	}
	public void setSubDeptName(String subDeptName) {
		this.subDeptName = subDeptName;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
