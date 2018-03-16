package com.esuizhen.server.sync.model.server;

import java.io.Serializable;
import java.util.Date;
/**
 * Created by Nidan on 2017年03月21 上午 11:40
 */
public class TSurgeryNote implements Serializable {

    private static final long serialVersionUID = 1L;

    private String surgeryId;

    private String emrId;

    private Long patientId;

    private String patientNo;

    private String oldPatientNo;

    private Integer inhospitalTimes;

    private Integer oldInhospitalTimes;

    private String inhospitalNo;

    private String patientUuid;

    private Integer hospitalId;

    private Integer deptId;

    private String bedNo;

    private String opCode;

    private String surgeryName;

    private Integer surgeryDoctor;

    private Integer surgeryAssistant1;

    private Integer surgeryAssistant2;

    private Date surgeryDate;

    private Date surgeryBeginTime;

    private Date surgeryEndTime;

    private Integer anesthesiaDoctor;

    private String anesthesiaWay;

    private String preOperativeDiagnosis;

    private String inOperativeDiagnosis;

    private String bodyPosture;

    private Integer transfusion;

    private String surgeryNurses;

    private String operativeApproach;

    private String operativeProbe;

    private String operativeMeasures;

    private String operativeSituation;

    private String woundClosureWay;

    private String incisionBandagedWay;

    private String remark;

    private Date createTime;

    private Date updateTime;

    private String deptUuid;

    private String surgeryDoctorUuid;

    private String surgeryAssistant1Uuid;

    private String surgeryAssistant2Uuid;

    private String anesthesiaDoctorUuid;

    private String mainID;

    private String opLevel;

    private String surgeryDoctorName;

    private String anesthesiaDoctorName;

    private Integer incisionHealingId;

    private String incisionHealing;

    private Integer treatmentSchemeId;

    private String treatmentSchemeName;

    private Date rawCreateTime;

    private Date syncTime;

    private String surgeryAssistant1Name;

    private String surgeryAssistant2Name;

    private Integer mergeFlag;

    private Long mergeFrom;

    private Long mergeTarget;

    private Date mergeTime;

    private String mergeFromUuid;
    private String mergeTargetUuid;
    private Integer tempId;
    private String surgeryNursesUuid;
    private String operatorName;
    private Integer serialNum;
    private Integer handleFlag;

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

    public String getMergeFromUuid() {
        return mergeFromUuid;
    }

    public void setMergeFromUuid(String mergeFromUuid) {
        this.mergeFromUuid = mergeFromUuid;
    }

    public String getMergeTargetUuid() {
        return mergeTargetUuid;
    }

    public void setMergeTargetUuid(String mergeTargetUuid) {
        this.mergeTargetUuid = mergeTargetUuid;
    }

    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    public String getSurgeryNursesUuid() {
        return surgeryNursesUuid;
    }

    public void setSurgeryNursesUuid(String surgeryNursesUuid) {
        this.surgeryNursesUuid = surgeryNursesUuid;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }

    public Integer getHandleFlag() {
        return handleFlag;
    }

    public void setHandleFlag(Integer handleFlag) {
        this.handleFlag = handleFlag;
    }

    public String getSurgeryId() {
        return surgeryId;
    }

    public void setSurgeryId(String surgeryId) {
        this.surgeryId = surgeryId == null ? null : surgeryId.trim();
    }

    public String getEmrId() {
        return emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId == null ? null : emrId.trim();
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
        this.patientNo = patientNo == null ? null : patientNo.trim();
    }

    public String getOldPatientNo() {
        return oldPatientNo;
    }

    public void setOldPatientNo(String oldPatientNo) {
        this.oldPatientNo = oldPatientNo == null ? null : oldPatientNo.trim();
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
        this.inhospitalNo = inhospitalNo == null ? null : inhospitalNo.trim();
    }

    public String getPatientUuid() {
        return patientUuid;
    }

    public void setPatientUuid(String patientUuid) {
        this.patientUuid = patientUuid == null ? null : patientUuid.trim();
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

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo == null ? null : bedNo.trim();
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode == null ? null : opCode.trim();
    }

    public String getSurgeryName() {
        return surgeryName;
    }

    public void setSurgeryName(String surgeryName) {
        this.surgeryName = surgeryName == null ? null : surgeryName.trim();
    }

    public Integer getSurgeryDoctor() {
        return surgeryDoctor;
    }

    public void setSurgeryDoctor(Integer surgeryDoctor) {
        this.surgeryDoctor = surgeryDoctor;
    }

    public Integer getSurgeryAssistant1() {
        return surgeryAssistant1;
    }

    public void setSurgeryAssistant1(Integer surgeryAssistant1) {
        this.surgeryAssistant1 = surgeryAssistant1;
    }

    public Integer getSurgeryAssistant2() {
        return surgeryAssistant2;
    }

    public void setSurgeryAssistant2(Integer surgeryAssistant2) {
        this.surgeryAssistant2 = surgeryAssistant2;
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

    public String getAnesthesiaWay() {
        return anesthesiaWay;
    }

    public void setAnesthesiaWay(String anesthesiaWay) {
        this.anesthesiaWay = anesthesiaWay == null ? null : anesthesiaWay.trim();
    }

    public String getPreOperativeDiagnosis() {
        return preOperativeDiagnosis;
    }

    public void setPreOperativeDiagnosis(String preOperativeDiagnosis) {
        this.preOperativeDiagnosis = preOperativeDiagnosis == null ? null : preOperativeDiagnosis.trim();
    }

    public String getInOperativeDiagnosis() {
        return inOperativeDiagnosis;
    }

    public void setInOperativeDiagnosis(String inOperativeDiagnosis) {
        this.inOperativeDiagnosis = inOperativeDiagnosis == null ? null : inOperativeDiagnosis.trim();
    }

    public String getBodyPosture() {
        return bodyPosture;
    }

    public void setBodyPosture(String bodyPosture) {
        this.bodyPosture = bodyPosture == null ? null : bodyPosture.trim();
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
        this.surgeryNurses = surgeryNurses == null ? null : surgeryNurses.trim();
    }

    public String getOperativeApproach() {
        return operativeApproach;
    }

    public void setOperativeApproach(String operativeApproach) {
        this.operativeApproach = operativeApproach == null ? null : operativeApproach.trim();
    }

    public String getOperativeProbe() {
        return operativeProbe;
    }

    public void setOperativeProbe(String operativeProbe) {
        this.operativeProbe = operativeProbe == null ? null : operativeProbe.trim();
    }

    public String getOperativeMeasures() {
        return operativeMeasures;
    }

    public void setOperativeMeasures(String operativeMeasures) {
        this.operativeMeasures = operativeMeasures == null ? null : operativeMeasures.trim();
    }

    public String getOperativeSituation() {
        return operativeSituation;
    }

    public void setOperativeSituation(String operativeSituation) {
        this.operativeSituation = operativeSituation == null ? null : operativeSituation.trim();
    }

    public String getWoundClosureWay() {
        return woundClosureWay;
    }

    public void setWoundClosureWay(String woundClosureWay) {
        this.woundClosureWay = woundClosureWay == null ? null : woundClosureWay.trim();
    }

    public String getIncisionBandagedWay() {
        return incisionBandagedWay;
    }

    public void setIncisionBandagedWay(String incisionBandagedWay) {
        this.incisionBandagedWay = incisionBandagedWay == null ? null : incisionBandagedWay.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getDeptUuid() {
        return deptUuid;
    }

    public void setDeptUuid(String deptUuid) {
        this.deptUuid = deptUuid == null ? null : deptUuid.trim();
    }

    public String getSurgeryDoctorUuid() {
        return surgeryDoctorUuid;
    }

    public void setSurgeryDoctorUuid(String surgeryDoctorUuid) {
        this.surgeryDoctorUuid = surgeryDoctorUuid == null ? null : surgeryDoctorUuid.trim();
    }

    public String getSurgeryAssistant1Uuid() {
        return surgeryAssistant1Uuid;
    }

    public void setSurgeryAssistant1Uuid(String surgeryAssistant1Uuid) {
        this.surgeryAssistant1Uuid = surgeryAssistant1Uuid == null ? null : surgeryAssistant1Uuid.trim();
    }

    public String getSurgeryAssistant2Uuid() {
        return surgeryAssistant2Uuid;
    }

    public void setSurgeryAssistant2Uuid(String surgeryAssistant2Uuid) {
        this.surgeryAssistant2Uuid = surgeryAssistant2Uuid == null ? null : surgeryAssistant2Uuid.trim();
    }

    public String getAnesthesiaDoctorUuid() {
        return anesthesiaDoctorUuid;
    }

    public void setAnesthesiaDoctorUuid(String anesthesiaDoctorUuid) {
        this.anesthesiaDoctorUuid = anesthesiaDoctorUuid == null ? null : anesthesiaDoctorUuid.trim();
    }

    public String getMainID() {
        return mainID;
    }

    public void setMainID(String mainID) {
        this.mainID = mainID == null ? null : mainID.trim();
    }

    public String getOpLevel() {
        return opLevel;
    }

    public void setOpLevel(String opLevel) {
        this.opLevel = opLevel == null ? null : opLevel.trim();
    }

    public String getSurgeryDoctorName() {
        return surgeryDoctorName;
    }

    public void setSurgeryDoctorName(String surgeryDoctorName) {
        this.surgeryDoctorName = surgeryDoctorName == null ? null : surgeryDoctorName.trim();
    }

    public String getAnesthesiaDoctorName() {
        return anesthesiaDoctorName;
    }

    public void setAnesthesiaDoctorName(String anesthesiaDoctorName) {
        this.anesthesiaDoctorName = anesthesiaDoctorName == null ? null : anesthesiaDoctorName.trim();
    }

    public Integer getIncisionHealingId() {
        return incisionHealingId;
    }

    public void setIncisionHealingId(Integer incisionHealingId) {
        this.incisionHealingId = incisionHealingId;
    }

    public String getIncisionHealing() {
        return incisionHealing;
    }

    public void setIncisionHealing(String incisionHealing) {
        this.incisionHealing = incisionHealing == null ? null : incisionHealing.trim();
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
        this.treatmentSchemeName = treatmentSchemeName == null ? null : treatmentSchemeName.trim();
    }

    public Date getRawCreateTime() {
        return rawCreateTime;
    }

    public void setRawCreateTime(Date rawCreateTime) {
        this.rawCreateTime = rawCreateTime;
    }

    public Date getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }

    public String getSurgeryAssistant1Name() {
        return surgeryAssistant1Name;
    }

    public void setSurgeryAssistant1Name(String surgeryAssistant1Name) {
        this.surgeryAssistant1Name = surgeryAssistant1Name == null ? null : surgeryAssistant1Name.trim();
    }

    public String getSurgeryAssistant2Name() {
        return surgeryAssistant2Name;
    }

    public void setSurgeryAssistant2Name(String surgeryAssistant2Name) {
        this.surgeryAssistant2Name = surgeryAssistant2Name == null ? null : surgeryAssistant2Name.trim();
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

    public Long getMergeTarget() {
        return mergeTarget;
    }

    public void setMergeTarget(Long mergeTarget) {
        this.mergeTarget = mergeTarget;
    }

    public Date getMergeTime() {
        return mergeTime;
    }

    public void setMergeTime(Date mergeTime) {
        this.mergeTime = mergeTime;
    }
}