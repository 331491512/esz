/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.bean<br/>  
 * <b>文件名：</b>MedicalRecordPatientCreateReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月11日-上午10:24:44<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: MedicalRecordPatientCreateReq 
* @Description: TODO
* @author YYCHEN
* @date 2015年12月11日 上午10:24:44  
*/
public class MedicalRecordPatientCreateReq implements Serializable {
	private static final long serialVersionUID = 1L;
	private String mobile;
	private String trueName;
	private String sourceDiseaseCode;
	private String sourceDiagnosis;
	private Date confirmedDate;
	private Long doctorId;
	private Integer hasMedicalRecord;
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

	public void setTrueName(String trueName) {
		this.trueName = trueName;
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

	public Date getConfirmedDate() {
		return confirmedDate;
	}

	public void setConfirmedDate(Date confirmedDate) {
		this.confirmedDate = confirmedDate;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getHasMedicalRecord() {
		return hasMedicalRecord;
	}

	public void setHasMedicalRecord(Integer hasMedicalRecord) {
		this.hasMedicalRecord = hasMedicalRecord;
	}

}
