/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.model;<br/>  
 * <b>文件名：</b>TPatientNoInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年1月6日上午11:38:39<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.model;
/** 
* @ClassName: TPatientNoInfo
* @Description: 
* @author lichenghao
* @date 2017年1月6日 上午11:38:39  
*/
public class TPatientNoInfo {
	private Long patientId;
	private Integer hospitalId;
	private String patientNo;
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
}
