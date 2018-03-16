/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>PatientHospitalCertificateConfirmReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年1月10日上午11:29:57<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;
/** 
* @ClassName: PatientHospitalCertificateConfirmReq
* @Description: 
* @author lichenghao
* @date 2017年1月10日 上午11:29:57  
*/
public class PatientHospitalCertificateConfirmReq {
	private Long historyId;//记录编号
	private Long patientId;//患者编号
	private Integer hospitalId;//医院编号
	private Integer certificatedFlag;//确认状态
	private String remark;//备注信息
	public Long getHistoryId() {
		return historyId;
	}
	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}
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
	public Integer getCertificatedFlag() {
		return certificatedFlag;
	}
	public void setCertificatedFlag(Integer certificatedFlag) {
		this.certificatedFlag = certificatedFlag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
