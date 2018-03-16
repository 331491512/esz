package com.esuizhen.server.sync.model.server;

import java.io.Serializable;
import java.util.Date;
/**
 * Created by Nidan on 2017年03月21 上午 11:40
 */
public class TTreatmentNote implements Serializable {

    private static final long serialVersionUID = 1L;

    private String treatmentId;

    private String emrId;

    private Long patientId;

    private String patientNo;

    private String patientUuid;

    private Integer hospitalId;

    private Integer treatmentTypeId;

    private String opCode;

    private String treatmentName;

    private String treatmentWay;

    private Float treatmentDosage;

    private String dosageUnit;

    private String treatmentCourse;

    private Integer treatmentProcessFlag;

    private String treatmentEffect;

    private Integer operationDoctor;

    private Date treatmentBeginTime;

    private Date treatmentEndTime;

    private Date createTime;

    private Date updateTime;

    private String inhospitalId;

    private String treatmentCode;

    private String scanPart;

    private String radiationValue;

    private String radiationUnit;

    private Integer catalogState;

    private String medicine;

    private Integer sourceFlag;

    private String operationDoctorUuid;

    private Integer syncflag;

    private Date rawCreateTime;

    private String treatmentDesc;

    private Integer mergeFlag;

    private Date mergeTime;
    private String mergeFromUuid;
    private Long mergeTarget;
    private String mergeTargetUuid;
    private Integer tempId;
    private String rawTreatmentType;
    private Integer handleFlag;
    private String totalCourse;

    public Date getMergeTime() {
        return mergeTime;
    }

    public void setMergeTime(Date mergeTime) {
        this.mergeTime = mergeTime;
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

    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    public String getRawTreatmentType() {
        return rawTreatmentType;
    }

    public void setRawTreatmentType(String rawTreatmentType) {
        this.rawTreatmentType = rawTreatmentType;
    }

    public Integer getHandleFlag() {
        return handleFlag;
    }

    public void setHandleFlag(Integer handleFlag) {
        this.handleFlag = handleFlag;
    }

    public String getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(String totalCourse) {
        this.totalCourse = totalCourse;
    }

    public String getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(String treatmentId) {
        this.treatmentId = treatmentId == null ? null : treatmentId.trim();
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
        this.opCode = opCode == null ? null : opCode.trim();
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName == null ? null : treatmentName.trim();
    }

    public String getTreatmentWay() {
        return treatmentWay;
    }

    public void setTreatmentWay(String treatmentWay) {
        this.treatmentWay = treatmentWay == null ? null : treatmentWay.trim();
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
        this.dosageUnit = dosageUnit == null ? null : dosageUnit.trim();
    }

    public String getTreatmentCourse() {
        return treatmentCourse;
    }

    public void setTreatmentCourse(String treatmentCourse) {
        this.treatmentCourse = treatmentCourse == null ? null : treatmentCourse.trim();
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
        this.treatmentEffect = treatmentEffect == null ? null : treatmentEffect.trim();
    }

    public Integer getOperationDoctor() {
        return operationDoctor;
    }

    public void setOperationDoctor(Integer operationDoctor) {
        this.operationDoctor = operationDoctor;
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

    public String getInhospitalId() {
        return inhospitalId;
    }

    public void setInhospitalId(String inhospitalId) {
        this.inhospitalId = inhospitalId == null ? null : inhospitalId.trim();
    }

    public String getTreatmentCode() {
        return treatmentCode;
    }

    public void setTreatmentCode(String treatmentCode) {
        this.treatmentCode = treatmentCode == null ? null : treatmentCode.trim();
    }

    public String getScanPart() {
        return scanPart;
    }

    public void setScanPart(String scanPart) {
        this.scanPart = scanPart == null ? null : scanPart.trim();
    }

    public String getRadiationValue() {
        return radiationValue;
    }

    public void setRadiationValue(String radiationValue) {
        this.radiationValue = radiationValue == null ? null : radiationValue.trim();
    }

    public String getRadiationUnit() {
        return radiationUnit;
    }

    public void setRadiationUnit(String radiationUnit) {
        this.radiationUnit = radiationUnit == null ? null : radiationUnit.trim();
    }

    public Integer getCatalogState() {
        return catalogState;
    }

    public void setCatalogState(Integer catalogState) {
        this.catalogState = catalogState;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine == null ? null : medicine.trim();
    }

    public Integer getSourceFlag() {
        return sourceFlag;
    }

    public void setSourceFlag(Integer sourceFlag) {
        this.sourceFlag = sourceFlag;
    }

    public String getOperationDoctorUuid() {
        return operationDoctorUuid;
    }

    public void setOperationDoctorUuid(String operationDoctorUuid) {
        this.operationDoctorUuid = operationDoctorUuid == null ? null : operationDoctorUuid.trim();
    }

    public Integer getSyncflag() {
        return syncflag;
    }

    public void setSyncflag(Integer syncflag) {
        this.syncflag = syncflag;
    }

    public Date getRawCreateTime() {
        return rawCreateTime;
    }

    public void setRawCreateTime(Date rawCreateTime) {
        this.rawCreateTime = rawCreateTime;
    }

    public String getTreatmentDesc() {
        return treatmentDesc;
    }

    public void setTreatmentDesc(String treatmentDesc) {
        this.treatmentDesc = treatmentDesc == null ? null : treatmentDesc.trim();
    }

    public Integer getMergeFlag() {
        return mergeFlag;
    }

    public void setMergeFlag(Integer mergeFlag) {
        this.mergeFlag = mergeFlag;
    }
}