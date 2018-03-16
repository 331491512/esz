/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>PatientRemarkAddReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月20日下午2:32:54<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;
/** 
* @ClassName: PatientRemarkAddReq
* @Description: 
* @author lichenghao
* @date 2016年5月20日 下午2:32:54  
*/
public class PatientRemarkReq {
	//备注Id
	private Integer remarkId;
	//医生编号
	private Long doctorId;
	//患者编号
	private Long patientId;
	//备注信息
	private String remark;
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getRemarkId() {
		return remarkId;
	}
	public void setRemarkId(Integer remarkId) {
		this.remarkId = remarkId;
	}
}
