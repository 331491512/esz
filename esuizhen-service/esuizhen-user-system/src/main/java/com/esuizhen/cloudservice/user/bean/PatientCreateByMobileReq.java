/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.bean<br/>  
 * <b>文件名：</b>PatientCreateByMobileReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月14日-上午11:23:19<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;

import java.io.Serializable;

/** 
* @ClassName: PatientCreateByMobileReq 
* @Description: 根据手机号创建患者
* @author huangdongxing
* @date 2015年12月14日 上午11:23:19  
*/
public class PatientCreateByMobileReq implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 电话号码
	 */
	private String mobile;
	/**
	* 患者真实姓名
	*/
	private String trueName;
	/**
	* 原发诊断编码
	*/
	private String sourceDiseaseCode;
	/**
	* 原发诊断
	*/
	private String sourceDiagnosis;
	/**
	* 医生编号
	*/
	private Long doctorId;
	
	private Integer sourceFlag;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	/**
	 * @return the sourceFlag
	 */
	public Integer getSourceFlag() {
		return sourceFlag;
	}

	/**
	 * @param sourceFlag the sourceFlag to set
	 */
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public String getSourceDiseaseCode() {
		return sourceDiseaseCode;
	}

	public void setSourceDiseaseCode(String sourceDiseaseCode) {
		this.sourceDiseaseCode = sourceDiseaseCode;
	}

	public String getSourceDiagnosis() {
		return sourceDiagnosis;
	}

	public void setSourceDiagnosis(String sourceDiagnosis) {
		this.sourceDiagnosis = sourceDiagnosis;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

}
