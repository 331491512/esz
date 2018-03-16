package com.westangel.common.bean.authorization;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title:MetaResource</p>
 * <p>Description:资源元数据bean</p>
 * @author YYCHEN
 * @date 2016年7月5日 下午6:21:53
 */
public class MetaResource implements Serializable {
	private static final long serialVersionUID = 1L;

	//角色ID
	private Integer userRole;
	//资源ID
	private Integer resourceId;
	//资源名，通过点号分隔。如babm.guidang。全局唯一
	private String resourceName;
	//资源路径
	private String resourcePath;
	//资源显示名。如病案编目.归档
	private String resourceDisplayName;
	//资源类型
	private Integer resourceType;
	//父类资源Id
	private Integer parentId;
	//备注
	private String remark;
	//子资源列表
	private List<MetaResource> subResourceList;
	
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public List<MetaResource> getSubResourceList() {
		return subResourceList;
	}
	public void setSubResourceList(List<MetaResource> subResourceList) {
		this.subResourceList = subResourceList;
	}
	public String getResourcePath() {
		return resourcePath;
	}
	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}
	public Integer getResourceId() {
		return resourceId;
	}
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceDisplayName() {
		return resourceDisplayName;
	}
	public void setResourceDisplayName(String resourceDisplayName) {
		this.resourceDisplayName = resourceDisplayName;
	}
	public Integer getResourceType() {
		return resourceType;
	}
	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
