/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.bean;<br/>  
 * <b>文件名：</b>PatientPastTreatmentReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月24日上午10:02:11<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;

/** 
* @ClassName: PatientPastTreatmentReq
* @Description: 
* @author lichenghao
* @date 2016年5月24日 上午10:02:11  
*/
public class PatientPastTreatmentReq {
	/**
	 * 治疗编号
	 */
	private String treatmentId;
	/**
	 * 患者编号
	 */
	private Long patientId;
	/**
	 * 病案号
	 */
	private String patientNo;
	/**
	 * 治疗时间
	 */
	private Date treatmentBeginTime;
	/**
	 * 治疗方式类型
	 */
	private Integer treatmentTypeId;
	/**
	 * 治疗方案
	 */
	private String treatmentName;
	/**
	 * 数据来源
	 */
	private Integer sourceFlag;
	/**
	 * 创建者
	 */
	private Long creatorId;
	
	/**
	 * 电子病历编号
	 */
	private String emrId;
	
	/**
	 * 结束日期
	 */
	private Date treatmentEndTime;
	/**
	 * 治疗方法
	 */
	private String treatmentWay;

	/**
	 * 总剂量
	 */
	private Float treatmentDosage;
	/**
	 * 总剂量单位
	 */
	private String dosageUnit;
	/**
	 * 治疗完成情况
	 */
	private Integer treatmentProcessFlag;
	/**
	 * 治疗用药
	 */
	private String medicine;
	//创建人姓名
	private String creatorName;
	/**
	 * 疗程
	 */
	private String treatmentCourse;
	/**
	 * 疗效
	 */
	private String treatmentEffect;
	public String getTreatmentId() {
		return treatmentId;
	}
	public void setTreatmentId(String treatmentId) {
		this.treatmentId = treatmentId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Date getTreatmentBeginTime() {
		return treatmentBeginTime;
	}
	public void setTreatmentBeginTime(Date treatmentBeginTime) {
		this.treatmentBeginTime = treatmentBeginTime;
	}
	public Integer getTreatmentTypeId() {
		return treatmentTypeId;
	}
	public void setTreatmentTypeId(Integer treatmentTypeId) {
		this.treatmentTypeId = treatmentTypeId;
	}
	public String getTreatmentName() {
		return treatmentName;
	}
	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
	}
	public Integer getSourceFlag() {
		return sourceFlag;
	}
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	public Long getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	public String getEmrId() {
		return emrId;
	}
	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}
	public Date getTreatmentEndTime() {
		return treatmentEndTime;
	}
	public void setTreatmentEndTime(Date treatmentEndTime) {
		this.treatmentEndTime = treatmentEndTime;
	}
	public String getTreatmentWay() {
		return treatmentWay;
	}
	public void setTreatmentWay(String treatmentWay) {
		this.treatmentWay = treatmentWay;
	}
	public Float getTreatmentDosage() {
		return treatmentDosage;
	}
	public void setTreatmentDosage(Float treatmentDosage) {
		this.treatmentDosage = treatmentDosage;
	}
	public String getDosageUnit() {
		return dosageUnit;
	}
	public void setDosageUnit(String dosageUnit) {
		this.dosageUnit = dosageUnit;
	}
	public Integer getTreatmentProcessFlag() {
		return treatmentProcessFlag;
	}
	public void setTreatmentProcessFlag(Integer treatmentProcessFlag) {
		this.treatmentProcessFlag = treatmentProcessFlag;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public String getTreatmentCourse() {
		return treatmentCourse;
	}
	public void setTreatmentCourse(String treatmentCourse) {
		this.treatmentCourse = treatmentCourse;
	}
	public String getTreatmentEffect() {
		return treatmentEffect;
	}
	public void setTreatmentEffect(String treatmentEffect) {
		this.treatmentEffect = treatmentEffect;
	}
}
