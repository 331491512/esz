package com.westangel.common.bean.authorization;

import java.io.Serializable;

/**
 * <p>Title:MetaRole</p>
 * <p>Description:角色bean</p>
 * @author YYCHEN
 * @date 2016年7月5日 下午5:13:02
 */
public class MetaRole implements Serializable {
	private static final long serialVersionUID = 1L;

	//角色ID
	private Integer userRole;
	//角色名
	private String roleName;
	//角色类型
	private Integer roleType;
	//科室ID
	private Integer deptId;
	//备注
	private String remark;
	
	//是否已被使用
	private Integer allowDeleteFlag;
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getAllowDeleteFlag() {
		return allowDeleteFlag;
	}
	public void setAllowDeleteFlag(Integer allowDeleteFlag) {
		this.allowDeleteFlag = allowDeleteFlag;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getRoleType() {
		return roleType;
	}
	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
