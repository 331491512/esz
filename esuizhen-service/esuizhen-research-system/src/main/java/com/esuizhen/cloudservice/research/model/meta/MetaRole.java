package com.esuizhen.cloudservice.research.model.meta;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:MetaRole</p>
 * <p>Description:专题医生角色bean</p>
 * @author YYCHEN
 * @date 2016年10月19日 下午5:46:12
 */
public class MetaRole implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//专题角色ID。主键。
	private Integer roleId;
	//专题角色名称。
	private String roleName;
	//状态
	private Integer state;
	//备注。
	private String remark;
	//记录创建时间
	private Date createTime;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
}
