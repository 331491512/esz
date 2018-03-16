/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.sync;<br/>  
 * <b>文件名：</b>THospitalIncreSyncLog.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年2月10日上午9:18:28<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.sync;

import java.util.Date;

/** 
* @ClassName: THospitalIncreSyncLog
* @Description: 
* @author lichenghao
* @date 2017年2月10日 上午9:18:28  
*/
public class THospitalIncreLog {
	//医院编号
	private Integer hospitalId;
	//同步日期
	private Date increDate;
	//患者数
	private int patientNum = 0;
	//诊断信息数
	private int diagnosisNum = 0;
	//住院信息数
	private int inhospitalNum = 0;
	//出院小结信息数
	private int outhospitalNum = 0;
	//治疗信息数
	private int treatmentNum = 0;
	//手术信息数
	private int surgeryNum = 0;
	//门诊信息数
	private int clinicMedicalNum = 0;
	//检查报告信息数
	private int detectionReportNum = 0;
	//检查详情信息数
	private int detectionDetailNum = 0;
	//检验信息数
	private int examReportNum = 0;
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Date getIncreDate() {
		return increDate;
	}
	public void setIncreDate(Date increDate) {
		this.increDate = increDate;
	}
	public int getPatientNum() {
		return patientNum;
	}
	public void setPatientNum(int patientNum) {
		this.patientNum = patientNum;
	}
	public int getDiagnosisNum() {
		return diagnosisNum;
	}
	public void setDiagnosisNum(int diagnosisNum) {
		this.diagnosisNum = diagnosisNum;
	}
	public int getInhospitalNum() {
		return inhospitalNum;
	}
	public void setInhospitalNum(int inhospitalNum) {
		this.inhospitalNum = inhospitalNum;
	}
	public int getOuthospitalNum() {
		return outhospitalNum;
	}
	public void setOuthospitalNum(int outhospitalNum) {
		this.outhospitalNum = outhospitalNum;
	}
	public int getTreatmentNum() {
		return treatmentNum;
	}
	public void setTreatmentNum(int treatmentNum) {
		this.treatmentNum = treatmentNum;
	}
	public int getSurgeryNum() {
		return surgeryNum;
	}
	public void setSurgeryNum(int surgeryNum) {
		this.surgeryNum = surgeryNum;
	}
	public int getClinicMedicalNum() {
		return clinicMedicalNum;
	}
	public void setClinicMedicalNum(int clinicMedicalNum) {
		this.clinicMedicalNum = clinicMedicalNum;
	}
	public int getDetectionReportNum() {
		return detectionReportNum;
	}
	public void setDetectionReportNum(int detectionReportNum) {
		this.detectionReportNum = detectionReportNum;
	}
	public int getDetectionDetailNum() {
		return detectionDetailNum;
	}
	public void setDetectionDetailNum(int detectionDetailNum) {
		this.detectionDetailNum = detectionDetailNum;
	}
	public int getExamReportNum() {
		return examReportNum;
	}
	public void setExamReportNum(int examReportNum) {
		this.examReportNum = examReportNum;
	}
}
