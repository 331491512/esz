package com.westangel.commonservice.authorization.bean;

import java.io.Serializable;

/**
 * <p>Title:CommonInfo</p>
 * <p>Description:通用包装类</p>
 * @author YYCHEN
 * @date 2016年7月8日 上午11:51:13
 * @param <T>
 */
public class CommonInfo<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//角色ID
	private Integer userRole;
	//资源类型
	private Integer resourceType;
	private T resultInfo;
	
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public Integer getResourceType() {
		return resourceType;
	}
	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}
	public T getResultInfo() {
		return resultInfo;
	}
	public void setResultInfo(T resultInfo) {
		this.resultInfo = resultInfo;
	}
}
