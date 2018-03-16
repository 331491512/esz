/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>HospitalsCertificatedOfPatientListReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年1月9日下午5:33:35<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;
/** 
* @ClassName: HospitalsCertificatedOfPatientListReq
* @Description: 
* @author lichenghao
* @date 2017年1月9日 下午5:33:35  
*/
public class HospitalsCertificatedOfPatientListReq {
	private Long patientId;//患者编号
	private Integer certificatedFlag;//请求认证标识  1:已审核 （默认） 0 ：待审核   -1审核失败
	private Integer hospitalId;
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Integer getCertificatedFlag() {
		return certificatedFlag;
	}
	public void setCertificatedFlag(Integer certificatedFlag) {
		this.certificatedFlag = certificatedFlag;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
}
