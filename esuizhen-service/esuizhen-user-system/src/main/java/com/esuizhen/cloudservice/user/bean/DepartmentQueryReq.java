/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>DepartmentQueryReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月19日上午8:46:37<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;
/** 
* @ClassName: DepartmentQueryReq
* @Description: 
* @author lichenghao
* @date 2016年8月19日 上午8:46:37  
*/
public class DepartmentQueryReq {
	private Integer hospitalId;
	private String deptName;
	private String reqFlag;
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getReqFlag() {
		return reqFlag;
	}
	public void setReqFlag(String reqFlag) {
		this.reqFlag = reqFlag;
	}
}
