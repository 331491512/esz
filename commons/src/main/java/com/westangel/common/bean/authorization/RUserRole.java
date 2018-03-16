package com.westangel.common.bean.authorization;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:RUserRole</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年7月8日 下午7:55:45
 */
public class RUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键
	private Long id;
	//用户Id
	private Long userId;
	//角色ID
	private Integer userRole;
	//角色名
	private String roleName;
	//角色类型
	private Integer roleType;
	//备注
	private String remark;
	//记录创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//本角色是否已经使用 1：使用  0：未使用
	private Integer useFlag;
	public Integer getUseFlag() {
		return useFlag;
	}
	public void setUseFlag(Integer useFlag) {
		this.useFlag = useFlag;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
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
