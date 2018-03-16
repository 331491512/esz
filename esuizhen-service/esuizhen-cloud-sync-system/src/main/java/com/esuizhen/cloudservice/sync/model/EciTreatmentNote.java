package com.esuizhen.cloudservice.sync.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.westangel.common.constant.Constant;


/**
 * 治疗记录bean
 * @author fanpanwei
 *
 */
public class EciTreatmentNote implements Serializable {
	private Integer hospitalId;//医院ID
	private Integer sourceFlag;
	
	private String treatmentId;
	private String inhospitalId;
	private String emrId;
	private String emrNo;
	private Long patientId;
	private String patientUuid;
	private String patientNo;
	private Integer treatmentTypeId;
	private String opCode;
	private String treatmentName;
	private String treatmentWay;
	private Float treatmentDosage;
	private String dosageUnit;
	private String treatmentCourse;
	private Integer treatmentProcessFlag;
	private String treatmentEffect;
	private Long operationDoctor;
	private String operationDoctorUuid;
	private String treatmentDesc;
	private Date treatmentBeginTime;
	private Date treatmentEndTime;
	private String medicine;
	private String treatmentCode;
	private String scanPart;
	private String radiationValue;
	private String radiationUnit;
	private Date createTime;
	private Date updateTime;
	private Date syncTime;
	private Date rawCreateTime;
	private Integer isSurgeryFlag;//手术治疗记录标识：0-否；1-是
	private Integer syncFlag;
	
	public String getTreatmentId() {
		return treatmentId;
	}
	public void setTreatmentId(String treatmentId) {
		this.treatmentId = treatmentId;
	}
	public String getInhospitalId() {
		return inhospitalId;
	}
	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}
	public String getEmrId() {
		return emrId;
	}
	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}
	public String getEmrNo() {
		return emrNo;
	}
	public void setEmrNo(String emrNo) {
		this.emrNo = emrNo;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getPatientUuid() {
		return patientUuid;
	}
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Integer getTreatmentTypeId() {
		return treatmentTypeId;
	}
	public void setTreatmentTypeId(Integer treatmentTypeId) {
		this.treatmentTypeId = treatmentTypeId;
	}
	public String getOpCode() {
		return opCode;
	}
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}
	public String getTreatmentName() {
		return treatmentName;
	}
	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
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
	public String getTreatmentCourse() {
		return treatmentCourse;
	}
	public void setTreatmentCourse(String treatmentCourse) {
		this.treatmentCourse = treatmentCourse;
	}
	public Integer getTreatmentProcessFlag() {
		return treatmentProcessFlag;
	}
	public void setTreatmentProcessFlag(Integer treatmentProcessFlag) {
		this.treatmentProcessFlag = treatmentProcessFlag;
	}
	public String getTreatmentEffect() {
		return treatmentEffect;
	}
	public void setTreatmentEffect(String treatmentEffect) {
		this.treatmentEffect = treatmentEffect;
	}
	public Long getOperationDoctor() {
		return operationDoctor;
	}
	public void setOperationDoctor(Long operationDoctor) {
		this.operationDoctor = operationDoctor;
	}
	public String getOperationDoctorUuid() {
		return operationDoctorUuid;
	}
	public void setOperationDoctorUuid(String operationDoctorUuid) {
		this.operationDoctorUuid = operationDoctorUuid;
	}
	public String getTreatmentDesc() {
		return treatmentDesc;
	}
	public void setTreatmentDesc(String treatmentDesc) {
		this.treatmentDesc = treatmentDesc;
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
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public String getTreatmentCode() {
		return treatmentCode;
	}
	public void setTreatmentCode(String treatmentCode) {
		this.treatmentCode = treatmentCode;
	}
	public String getScanPart() {
		return scanPart;
	}
	public void setScanPart(String scanPart) {
		this.scanPart = scanPart;
	}
	public String getRadiationValue() {
		return radiationValue;
	}
	public void setRadiationValue(String radiationValue) {
		this.radiationValue = radiationValue;
	}
	public String getRadiationUnit() {
		return radiationUnit;
	}
	public void setRadiationUnit(String radiationUnit) {
		this.radiationUnit = radiationUnit;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getSyncTime() {
		return syncTime;
	}
	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}
	public Date getRawCreateTime() {
		return rawCreateTime;
	}
	public void setRawCreateTime(Date rawCreateTime) {
		this.rawCreateTime = rawCreateTime;
	}
	public Integer getSourceFlag() {
		return sourceFlag;
	}
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	public Integer getIsSurgeryFlag() {
		return isSurgeryFlag;
	}
	public void setIsSurgeryFlag(Integer isSurgeryFlag) {
		this.isSurgeryFlag = isSurgeryFlag;
	}
	
	
	public Integer getSyncFlag() {
		return syncFlag;
	}
	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}
	public MedicalRecord createMedicalRecord(){
		MedicalRecord medicalRecord = new MedicalRecord();
		BeanUtils.copyProperties(this, medicalRecord);
		medicalRecord.setEmrType(Constant.Ehr.EMRTYPE_HOSPITALIZATION);
		if("手术".equals(this.treatmentWay)){//手术是5
			medicalRecord.setEmrSubType(Constant.Ehr.EMRSUBTYPE_OPERATION);
		}else{//治疗是4
			medicalRecord.setEmrSubType(Constant.Ehr.EMRSUBTYPE_TREATMENT);
		}
		medicalRecord.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		medicalRecord.setVisibleFlag(Constant.User.VISIBLEFLAG_HOSPITAL);
		medicalRecord.setStructFlag(Constant.Ehr.STRUCTFLAG_YES);
		medicalRecord.setSyncFlag(Constant.SYNC_OK);
		//医疗记录发生时间、就诊时间（实际发生时间）。
		medicalRecord.setVisitTime(treatmentBeginTime);
		if (medicalRecord.getVisitTime() == null) {
			medicalRecord.setVisitTime(createTime==null?new Date():createTime);
		}
		return medicalRecord;
	}
}
