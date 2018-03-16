package com.westangel.common.bean.user;

import java.io.Serializable;

public class RConfDataPrivilege implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 角色ID。
	 */
	private Integer userRole;
	
	/**
	 * 数据ID。
	 */
	private Integer dataId;
	
	/**
	 * 权限。1：查(1)；2：增(10)；4：改(100)；8：删(1000) 四种基本功能（操作）权限。
	 * 如果一个角色拥有多个权限，则取上述权限“或”操作。
	 */
	private Integer privilege;

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public Integer getDataId() {
		return dataId;
	}

	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}

	public Integer getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Integer privilege) {
		this.privilege = privilege;
	}
}
