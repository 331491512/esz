/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>UserProfileDetailReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年10月12日下午3:52:03<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;
/** 
* @ClassName: UserProfileDetailReq
* @Description: 
* @author lichenghao
* @date 2016年10月12日 下午3:52:03  
*/
public class UserProfileDetailReq {
	//用户Id
	private Long userId;
	//用户角色
	private Integer role;
	//关联Id
	private Long relationId;
	//医院Id
	private Integer hospitalId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public Long getRelationId() {
		return relationId;
	}
	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
}
