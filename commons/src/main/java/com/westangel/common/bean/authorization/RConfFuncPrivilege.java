package com.westangel.common.bean.authorization;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>Title:RConfFuncPrivilege</p>
 * <p>Description:角色功能权限bean</p>
 * @author YYCHEN
 * @date 2016年7月5日 下午5:58:16
 */
public class RConfFuncPrivilege implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键。
	private Integer id;
	//角色ID
	private Integer userRole;
	//资源ID
	private Integer resourceId;
	//
	private Integer resourceType;
	//备注
	private String remark;
	//记录创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//
	private List<RConfFuncPrivilege> subResourceList;
	
	public Integer getResourceType() {
		return resourceType;
	}
	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}
	public List<RConfFuncPrivilege> getSubResourceList() {
		return subResourceList;
	}
	public void setSubResourceList(List<RConfFuncPrivilege> subResourceList) {
		this.subResourceList = subResourceList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public Integer getResourceId() {
		return resourceId;
	}
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
