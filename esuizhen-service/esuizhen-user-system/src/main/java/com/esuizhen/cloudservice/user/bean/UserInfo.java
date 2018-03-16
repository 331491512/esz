/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean<br/>  
 * <b>文件名：</b>UserInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年10月19日上午10:51:27<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;
 
/** 
* @ClassName: UserInfo
* @Description: 
* @author NiDan
* @date 2016年10月19日上午10:51:27 
*/
public class UserInfo {
	
	private Long userId;
	
	private Long patientId;
	
	private String idFileUrl;
	
	private String patientNo;
	
	private Integer sex;
	
	private String identification;
	
	private Long doctorId;//申请医生的Id
	
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getIdFileUrl() {
		return idFileUrl;
	}
	public void setIdFileUrl(String idFileUrl) {
		this.idFileUrl = idFileUrl;
	}

}
