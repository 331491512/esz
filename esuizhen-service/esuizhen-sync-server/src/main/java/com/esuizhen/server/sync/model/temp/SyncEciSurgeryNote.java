package com.esuizhen.server.sync.model.temp;

import java.io.Serializable;
import java.util.Date;

/**
 * 手术bean
 * @author LHY
 */
public class SyncEciSurgeryNote implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String surgeryId;   
	private String inhospitalId;   
	private String emrId;   
	private String mainID;  
	private Integer tempId;   
	private Long patientId;   
	private String patientNo;   
	private String oldPatientNo;   
	private Integer inhospitalTimes;   
	private Integer oldInhospitalTimes;   
	private String inhospitalNo;   
	private String patientUuid;   
	private Integer hospitalId;   
	private Integer deptId;
	private String deptUuid;
	private String bedNo;   
	private String opCode;  
	private Integer treatmentSchemeId;   
	private String treatmentSchemeName;   
	private Integer opLevel;   
	private String surgeryName;   
	private long surgeryDoctor;   
	private String surgeryDoctorUuid;   
	private String surgeryDoctorName;   
	private Long surgeryAssistant1;   
	private String surgeryAssistant1Uuid;   
	private String surgeryAssistant1Name;   
	private Long surgeryAssistant2;   
	private String surgeryAssistant2Uuid;   
	private String surgeryAssistant2Name;   
	private Date surgeryDate;   
	private Date surgeryBeginTime;   
	private Date surgeryEndTime;   
	private Integer anesthesiaDoctor;   
	private String anesthesiaDoctorUuid;  
	private String anesthesiaDoctorName;  
	private String anesthesiaWay;  
	private String preOperativeDiagnosis;   
	private String inOperativeDiagnosis;   
	private String bodyPosture;   
	private Integer transfusion;   
	private String surgeryNurses;   
	private String surgeryNursesUuid;   
	private String operativeApproach;  
	private String operativeProbe;   
	private String operativeMeasures;  
	private String operativeSituation;   
	private String woundClosureWay;   
	private String incisionBandagedWay;  
	private String operatorName;  
	private String remark;   
	private Date createTime;  
	private Date updateTime;   
	private String incisionHealing;   
	private Integer serialNum;   
	private Integer incisionHealingId;   
	private Integer handleFlag;   
	private Date rawCreateTime;   
	private Integer mergeFlag;   
	private Long mergeFrom;   
	private String mergeFromUuid;   
	private Long mergeTarget;   
	private String mergeTargetUuid;   
	private Date mergeTime;
	private String batchId;
	private Integer sourceFlag;
	private Integer incisionGroup;
	private Integer incisionHealLevel;
	private Integer rawAnesthesiaWayId;
	private Integer anesthesiaWayId;
	
	public Integer getIncisionGroup() {
		return incisionGroup;
	}
	public void setIncisionGroup(Integer incisionGroup) {
		this.incisionGroup = incisionGroup;
	}
	public Integer getIncisionHealLevel() {
		return incisionHealLevel;
	}
	public void setIncisionHealLevel(Integer incisionHealLevel) {
		this.incisionHealLevel = incisionHealLevel;
	}
	public Integer getRawAnesthesiaWayId() {
		return rawAnesthesiaWayId;
	}
	public void setRawAnesthesiaWayId(Integer rawAnesthesiaWayId) {
		this.rawAnesthesiaWayId = rawAnesthesiaWayId;
	}
	public Integer getAnesthesiaWayId() {
		return anesthesiaWayId;
	}
	public void setAnesthesiaWayId(Integer anesthesiaWayId) {
		this.anesthesiaWayId = anesthesiaWayId;
	}
	public Integer getSourceFlag() {
		return sourceFlag;
	}
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	public String getSurgeryId() {
		return surgeryId;
	}
	public void setSurgeryId(String surgeryId) {
		this.surgeryId = surgeryId;
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
	public String getMainID() {
		return mainID;
	}
	public void setMainID(String mainID) {
		this.mainID = mainID;
	}
	public Integer getTempId() {
		return tempId;
	}
	public void setTempId(Integer tempId) {
		this.tempId = tempId;
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
	public String getOldPatientNo() {
		return oldPatientNo;
	}
	public void setOldPatientNo(String oldPatientNo) {
		this.oldPatientNo = oldPatientNo;
	}
	public Integer getInhospitalTimes() {
		return inhospitalTimes;
	}
	public void setInhospitalTimes(Integer inhospitalTimes) {
		this.inhospitalTimes = inhospitalTimes;
	}
	public Integer getOldInhospitalTimes() {
		return oldInhospitalTimes;
	}
	public void setOldInhospitalTimes(Integer oldInhospitalTimes) {
		this.oldInhospitalTimes = oldInhospitalTimes;
	}
	public String getInhospitalNo() {
		return inhospitalNo;
	}
	public void setInhospitalNo(String inhospitalNo) {
		this.inhospitalNo = inhospitalNo;
	}
	public String getPatientUuid() {
		return patientUuid;
	}
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptUuid() {
		return deptUuid;
	}
	public void setDeptUuid(String deptUuid) {
		this.deptUuid = deptUuid;
	}
	public String getBedNo() {
		return bedNo;
	}
	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}
	public String getOpCode() {
		return opCode;
	}
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}
	public Integer getTreatmentSchemeId() {
		return treatmentSchemeId;
	}
	public void setTreatmentSchemeId(Integer treatmentSchemeId) {
		this.treatmentSchemeId = treatmentSchemeId;
	}
	public String getTreatmentSchemeName() {
		return treatmentSchemeName;
	}
	public void setTreatmentSchemeName(String treatmentSchemeName) {
		this.treatmentSchemeName = treatmentSchemeName;
	}
	public Integer getOpLevel() {
		return opLevel;
	}
	public void setOpLevel(Integer opLevel) {
		this.opLevel = opLevel;
	}
	public String getSurgeryName() {
		return surgeryName;
	}
	public void setSurgeryName(String surgeryName) {
		this.surgeryName = surgeryName;
	}
	public long getSurgeryDoctor() {
		return surgeryDoctor;
	}
	public void setSurgeryDoctor(long surgeryDoctor) {
		this.surgeryDoctor = surgeryDoctor;
	}
	public String getSurgeryDoctorUuid() {
		return surgeryDoctorUuid;
	}
	public void setSurgeryDoctorUuid(String surgeryDoctorUuid) {
		this.surgeryDoctorUuid = surgeryDoctorUuid;
	}
	public String getSurgeryDoctorName() {
		return surgeryDoctorName;
	}
	public void setSurgeryDoctorName(String surgeryDoctorName) {
		this.surgeryDoctorName = surgeryDoctorName;
	}
	public Long getSurgeryAssistant1() {
		return surgeryAssistant1;
	}
	public void setSurgeryAssistant1(Long surgeryAssistant1) {
		this.surgeryAssistant1 = surgeryAssistant1;
	}
	public String getSurgeryAssistant1Uuid() {
		return surgeryAssistant1Uuid;
	}
	public void setSurgeryAssistant1Uuid(String surgeryAssistant1Uuid) {
		this.surgeryAssistant1Uuid = surgeryAssistant1Uuid;
	}
	public String getSurgeryAssistant1Name() {
		return surgeryAssistant1Name;
	}
	public void setSurgeryAssistant1Name(String surgeryAssistant1Name) {
		this.surgeryAssistant1Name = surgeryAssistant1Name;
	}
	public Long getSurgeryAssistant2() {
		return surgeryAssistant2;
	}
	public void setSurgeryAssistant2(Long surgeryAssistant2) {
		this.surgeryAssistant2 = surgeryAssistant2;
	}
	public String getSurgeryAssistant2Uuid() {
		return surgeryAssistant2Uuid;
	}
	public void setSurgeryAssistant2Uuid(String surgeryAssistant2Uuid) {
		this.surgeryAssistant2Uuid = surgeryAssistant2Uuid;
	}
	public String getSurgeryAssistant2Name() {
		return surgeryAssistant2Name;
	}
	public void setSurgeryAssistant2Name(String surgeryAssistant2Name) {
		this.surgeryAssistant2Name = surgeryAssistant2Name;
	}
	public Date getSurgeryDate() {
		return surgeryDate;
	}
	public void setSurgeryDate(Date surgeryDate) {
		this.surgeryDate = surgeryDate;
	}
	public Date getSurgeryBeginTime() {
		return surgeryBeginTime;
	}
	public void setSurgeryBeginTime(Date surgeryBeginTime) {
		this.surgeryBeginTime = surgeryBeginTime;
	}
	public Date getSurgeryEndTime() {
		return surgeryEndTime;
	}
	public void setSurgeryEndTime(Date surgeryEndTime) {
		this.surgeryEndTime = surgeryEndTime;
	}
	public Integer getAnesthesiaDoctor() {
		return anesthesiaDoctor;
	}
	public void setAnesthesiaDoctor(Integer anesthesiaDoctor) {
		this.anesthesiaDoctor = anesthesiaDoctor;
	}
	public String getAnesthesiaDoctorUuid() {
		return anesthesiaDoctorUuid;
	}
	public void setAnesthesiaDoctorUuid(String anesthesiaDoctorUuid) {
		this.anesthesiaDoctorUuid = anesthesiaDoctorUuid;
	}
	public String getAnesthesiaDoctorName() {
		return anesthesiaDoctorName;
	}
	public void setAnesthesiaDoctorName(String anesthesiaDoctorName) {
		this.anesthesiaDoctorName = anesthesiaDoctorName;
	}
	public String getAnesthesiaWay() {
		return anesthesiaWay;
	}
	public void setAnesthesiaWay(String anesthesiaWay) {
		this.anesthesiaWay = anesthesiaWay;
	}
	public String getPreOperativeDiagnosis() {
		return preOperativeDiagnosis;
	}
	public void setPreOperativeDiagnosis(String preOperativeDiagnosis) {
		this.preOperativeDiagnosis = preOperativeDiagnosis;
	}
	public String getInOperativeDiagnosis() {
		return inOperativeDiagnosis;
	}
	public void setInOperativeDiagnosis(String inOperativeDiagnosis) {
		this.inOperativeDiagnosis = inOperativeDiagnosis;
	}
	public String getBodyPosture() {
		return bodyPosture;
	}
	public void setBodyPosture(String bodyPosture) {
		this.bodyPosture = bodyPosture;
	}
	public Integer getTransfusion() {
		return transfusion;
	}
	public void setTransfusion(Integer transfusion) {
		this.transfusion = transfusion;
	}
	public String getSurgeryNurses() {
		return surgeryNurses;
	}
	public void setSurgeryNurses(String surgeryNurses) {
		this.surgeryNurses = surgeryNurses;
	}
	public String getSurgeryNursesUuid() {
		return surgeryNursesUuid;
	}
	public void setSurgeryNursesUuid(String surgeryNursesUuid) {
		this.surgeryNursesUuid = surgeryNursesUuid;
	}
	public String getOperativeApproach() {
		return operativeApproach;
	}
	public void setOperativeApproach(String operativeApproach) {
		this.operativeApproach = operativeApproach;
	}
	public String getOperativeProbe() {
		return operativeProbe;
	}
	public void setOperativeProbe(String operativeProbe) {
		this.operativeProbe = operativeProbe;
	}
	public String getOperativeMeasures() {
		return operativeMeasures;
	}
	public void setOperativeMeasures(String operativeMeasures) {
		this.operativeMeasures = operativeMeasures;
	}
	public String getOperativeSituation() {
		return operativeSituation;
	}
	public void setOperativeSituation(String operativeSituation) {
		this.operativeSituation = operativeSituation;
	}
	public String getWoundClosureWay() {
		return woundClosureWay;
	}
	public void setWoundClosureWay(String woundClosureWay) {
		this.woundClosureWay = woundClosureWay;
	}
	public String getIncisionBandagedWay() {
		return incisionBandagedWay;
	}
	public void setIncisionBandagedWay(String incisionBandagedWay) {
		this.incisionBandagedWay = incisionBandagedWay;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getIncisionHealing() {
		return incisionHealing;
	}
	public void setIncisionHealing(String incisionHealing) {
		this.incisionHealing = incisionHealing;
	}
	public Integer getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(Integer serialNum) {
		this.serialNum = serialNum;
	}
	public Integer getIncisionHealingId() {
		return incisionHealingId;
	}
	public void setIncisionHealingId(Integer incisionHealingId) {
		this.incisionHealingId = incisionHealingId;
	}
	public Integer getHandleFlag() {
		return handleFlag;
	}
	public void setHandleFlag(Integer handleFlag) {
		this.handleFlag = handleFlag;
	}
	public Date getRawCreateTime() {
		return rawCreateTime;
	}
	public void setRawCreateTime(Date rawCreateTime) {
		this.rawCreateTime = rawCreateTime;
	}
	public Integer getMergeFlag() {
		return mergeFlag;
	}
	public void setMergeFlag(Integer mergeFlag) {
		this.mergeFlag = mergeFlag;
	}
	public Long getMergeFrom() {
		return mergeFrom;
	}
	public void setMergeFrom(Long mergeFrom) {
		this.mergeFrom = mergeFrom;
	}
	public String getMergeFromUuid() {
		return mergeFromUuid;
	}
	public void setMergeFromUuid(String mergeFromUuid) {
		this.mergeFromUuid = mergeFromUuid;
	}
	public Long getMergeTarget() {
		return mergeTarget;
	}
	public void setMergeTarget(Long mergeTarget) {
		this.mergeTarget = mergeTarget;
	}
	public String getMergeTargetUuid() {
		return mergeTargetUuid;
	}
	public void setMergeTargetUuid(String mergeTargetUuid) {
		this.mergeTargetUuid = mergeTargetUuid;
	}
	public Date getMergeTime() {
		return mergeTime;
	}
	public void setMergeTime(Date mergeTime) {
		this.mergeTime = mergeTime;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
}