/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.bean;<br/>  
 * <b>文件名：</b>TTreatmentInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月24日下午3:17:32<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;

/** 
* @ClassName: TTreatmentInfo
* @Description: 
* @author lichenghao
* @date 2016年5月24日 下午3:17:32  
*/
public class TTreatmentInfo {
	//治疗编号
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
	 * 病案首页id
	 */
	private String inhospitalId;
	//治疗时间
	private Date treatmentBeginTime;
	/**
	 * 结束日期
	 */
	private Date treatmentEndTime;
	/**
	 * 治疗方法
	 */
	private String treatmentWay;
	//治疗类型
	private Integer  treatmentTypeId;
	//治疗类型名称
	private String treatmentTypeName;
	//治疗方案
	private String treatmentName;
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
	
	//治疗医生Id
	private Long operationDoctor;
	//信息来源 2.医生上传 3.医院同步
	private Integer sourceFlag;
	//创建人
	private Long creatorId;
	//创建人姓名
	private String creatorName;
	/**
	 * 编目状态
	 */
	private Integer catalogState;
	public String getTreatmentId() {
		return treatmentId;
	}
	public void setTreatmentId(String treatmentId) {
		this.treatmentId = treatmentId;
	}
	public Date getTreatmentBeginTime() {
		return treatmentBeginTime;
	}
	public void setTreatmentBeginTime(Date treatmentBeginTime) {
		this.treatmentBeginTime = treatmentBeginTime;
	}
	public Date getTreatmentEndTime() {
		return treatmentEndTime;
	}
	public void setTreatmentEndTime(Date treatmentEndTime) {
		this.treatmentEndTime = treatmentEndTime;
	}
	public Integer getTreatmentTypeId() {
		return treatmentTypeId;
	}
	public void setTreatmentTypeId(Integer treatmentTypeId) {
		this.treatmentTypeId = treatmentTypeId;
	}
	public String getTreatmentTypeName() {
		return treatmentTypeName;
	}
	public void setTreatmentTypeName(String treatmentTypeName) {
		this.treatmentTypeName = treatmentTypeName;
	}
	public String getTreatmentName() {
		return treatmentName;
	}
	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
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
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public Long getOperationDoctor() {
		return operationDoctor;
	}
	public void setOperationDoctor(Long operationDoctor) {
		this.operationDoctor = operationDoctor;
	}
	public Integer getCatalogState() {
		return catalogState;
	}
	public void setCatalogState(Integer catalogState) {
		this.catalogState = catalogState;
	}
	public String getTreatmentWay() {
		return treatmentWay;
	}
	public void setTreatmentWay(String treatmentWay) {
		this.treatmentWay = treatmentWay;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public String getInhospitalId() {
		return inhospitalId;
	}
	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}
}
