/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>DeptOfpatientSaveReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月19日下午5:39:21<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;

import java.util.List;

/** 
* @ClassName: DeptOfpatientSaveReq
* @Description: 
* @author lichenghao
* @date 2016年8月19日 下午5:39:21  
*/
public class DeptOfpatientReq {
	private Integer deptId;
	private Integer hospitalId;
	private Long creator;
	private List<Integer> subDeptList;
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public List<Integer> getSubDeptList() {
		return subDeptList;
	}
	public void setSubDeptList(List<Integer> subDeptList) {
		this.subDeptList = subDeptList;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Long getCreator() {
		return creator;
	}
	public void setCreator(Long creator) {
		this.creator = creator;
	}
}
