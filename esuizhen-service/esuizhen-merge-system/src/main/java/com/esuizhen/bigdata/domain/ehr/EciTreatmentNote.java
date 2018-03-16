package com.esuizhen.bigdata.domain.ehr;


import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "eci_treatment_note", schema = "ehr_db", catalog="")
//@Audited
//@AuditTable(value = "eci_treatment_note_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class EciTreatmentNote {
    private String treatmentId;
    private String emrId;
    private Integer tempId;
    private Long patientId;
    private String patientNo;
    private String patientUuid;
    private Integer hospitalId;
    private String inHospitalId;
    private Integer treatmentTypeId;
    private String opCode;
    private String treatmentName;
    private String treatmentWay;
    private String treatmentCourse;
    private Integer treatmentProcessFlag;
    private String treatmentEffect;
    private Integer operationDoctor;
    private Integer treatmentType;
    private String treatmentDesc;
    private Timestamp treatmentBeginTime;
    private Timestamp treatmentEndTime;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer handleFlag;
    private Timestamp rawCreateTime;

    private Integer mergeFlag;
    private Long mergeFrom;
    private Long mergeTarget;
    private Timestamp mergeTime;

    private String rawTreatmentType;
    private String oldPatientNo;
    private Integer oldInhospitalTimes;

    @Basic
    @Column(name = "oldPatientNo",nullable = true)
    public String getOldPatientNo() {
        return oldPatientNo;
    }

    public void setOldPatientNo(String oldPatientNo) {
        this.oldPatientNo = oldPatientNo;
    }

    @Basic
    @Column(name = "oldInhospitalTimes",nullable = true)
    public Integer getOldInhospitalTimes() {
        return oldInhospitalTimes;
    }

    public void setOldInhospitalTimes(Integer oldInhospitalTimes) {
        this.oldInhospitalTimes = oldInhospitalTimes;
    }

    @Basic
    @Column(name="rawTreatmentType",nullable = true)
    public String getRawTreatmentType() {
        return rawTreatmentType;
    }

    public void setRawTreatmentType(String rawTreatmentType) {
        this.rawTreatmentType = rawTreatmentType;
    }

    @Basic
    @Column(name = "mergeFlag", nullable = true)
    public Integer getMergeFlag() {
        return mergeFlag;
    }

    public void setMergeFlag(Integer mergeFlag) {
        this.mergeFlag = mergeFlag;
    }

    @Basic
    @Column(name = "mergeFrom", nullable = true)
    public Long getMergeFrom() {
        return mergeFrom;
    }

    public void setMergeFrom(Long mergeFrom) {
        this.mergeFrom = mergeFrom;
    }

    @Basic
    @Column(name = "mergeTarget", nullable = true)
    public Long getMergeTarget() {
        return mergeTarget;
    }

    public void setMergeTarget(Long mergeTarget) {
        this.mergeTarget = mergeTarget;
    }

    @Basic
    @Column(name = "mergeTime", nullable = true)
    public Timestamp getMergeTime() {
        return mergeTime;
    }

    public void setMergeTime(Timestamp mergeTime) {
        this.mergeTime = mergeTime;
    }

    @Id
    //@GeneratedValue
    @Column(name = "treatmentId", nullable = false, length = 128)
    public String getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(String treatmentId) {
        this.treatmentId = treatmentId;
    }

    @Basic
    @Column(name = "emrId", nullable = true, length = 128)
    public String getEmrId() {
        return emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId;
    }

    @Basic
    @Column(name = "tempId", nullable = true)
    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    @Basic
    @Column(name = "patientId", nullable = false)
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "patientNo", nullable = true, length = 128)
    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    @Basic
    @Column(name = "patientUuid", nullable = true, length = 32)
    public String getPatientUuid() {
        return patientUuid;
    }

    public void setPatientUuid(String patientUuid) {
        this.patientUuid = patientUuid;
    }

    @Basic
    @Column(name = "hospitalId", nullable = true)
    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Basic
    @Column(name = "inHospitalId", nullable = true, length = 60)
    public String getInHospitalId() {
        return inHospitalId;
    }

    public void setInHospitalId(String inHospitalId) {
        this.inHospitalId = inHospitalId;
    }

    @Basic
    @Column(name = "treatmentTypeId", nullable = false)
    public Integer getTreatmentTypeId() {
        return treatmentTypeId;
    }

    public void setTreatmentTypeId(Integer treatmentTypeId) {
        this.treatmentTypeId = treatmentTypeId;
    }

    @Basic
    @Column(name = "opCode", nullable = true, length = 30)
    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    @Basic
    @Column(name = "treatmentName", nullable = false, length = 512)
    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    @Basic
    @Column(name = "treatmentWay", nullable = true, length = 50)
    public String getTreatmentWay() {
        return treatmentWay;
    }

    public void setTreatmentWay(String treatmentWay) {
        this.treatmentWay = treatmentWay;
    }

    @Basic
    @Column(name = "treatmentCourse", nullable = true, length = 20)
    public String getTreatmentCourse() {
        return treatmentCourse;
    }

    public void setTreatmentCourse(String treatmentCourse) {
        this.treatmentCourse = treatmentCourse;
    }

    @Basic
    @Column(name = "treatmentProcessFlag", nullable = true)
    public Integer getTreatmentProcessFlag() {
        return treatmentProcessFlag;
    }

    public void setTreatmentProcessFlag(Integer treatmentProcessFlag) {
        this.treatmentProcessFlag = treatmentProcessFlag;
    }

    @Basic
    @Column(name = "treatmentEffect", nullable = true, length = 20)
    public String getTreatmentEffect() {
        return treatmentEffect;
    }

    public void setTreatmentEffect(String treatmentEffect) {
        this.treatmentEffect = treatmentEffect;
    }

    @Basic
    @Column(name = "operationDoctor", nullable = true)
    public Integer getOperationDoctor() {
        return operationDoctor;
    }

    public void setOperationDoctor(Integer operationDoctor) {
        this.operationDoctor = operationDoctor;
    }

    @Basic
    @Column(name = "treatmentType", nullable = true)
    public Integer getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(Integer treatmentType) {
        this.treatmentType = treatmentType;
    }

    @Basic
    @Column(name = "treatmentDesc", nullable = true, length = 128)
    public String getTreatmentDesc() {
        return treatmentDesc;
    }

    public void setTreatmentDesc(String treatmentDesc) {
        this.treatmentDesc = treatmentDesc;
    }

    @Basic
    @Column(name = "treatmentBeginTime", nullable = true)
    public Timestamp getTreatmentBeginTime() {
        return treatmentBeginTime;
    }

    public void setTreatmentBeginTime(Timestamp treatmentBeginTime) {
        this.treatmentBeginTime = treatmentBeginTime;
    }

    @Basic
    @Column(name = "treatmentEndTime", nullable = true)
    public Timestamp getTreatmentEndTime() {
        return treatmentEndTime;
    }

    public void setTreatmentEndTime(Timestamp treatmentEndTime) {
        this.treatmentEndTime = treatmentEndTime;
    }

    @Basic
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateTime", nullable = false)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "handleFlag", nullable = true)
    public Integer getHandleFlag() {
        return handleFlag;
    }

    public void setHandleFlag(Integer handleFlag) {
        this.handleFlag = handleFlag;
    }

    @Basic
    @Column(name = "rawCreateTime", nullable = true)
    public Timestamp getRawCreateTime() {
        return rawCreateTime;
    }

    public void setRawCreateTime(Timestamp rawCreateTime) {
        this.rawCreateTime = rawCreateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EciTreatmentNote that = (EciTreatmentNote) o;

        if (treatmentId != null ? !treatmentId.equals(that.treatmentId) : that.treatmentId != null) return false;
        if (emrId != null ? !emrId.equals(that.emrId) : that.emrId != null) return false;
        if (tempId != null ? !tempId.equals(that.tempId) : that.tempId != null) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (patientNo != null ? !patientNo.equals(that.patientNo) : that.patientNo != null) return false;
        if (patientUuid != null ? !patientUuid.equals(that.patientUuid) : that.patientUuid != null) return false;
        if (hospitalId != null ? !hospitalId.equals(that.hospitalId) : that.hospitalId != null) return false;
        if (inHospitalId != null ? !inHospitalId.equals(that.inHospitalId) : that.inHospitalId != null) return false;
        if (treatmentTypeId != null ? !treatmentTypeId.equals(that.treatmentTypeId) : that.treatmentTypeId != null)
            return false;
        if (opCode != null ? !opCode.equals(that.opCode) : that.opCode != null) return false;
        if (treatmentName != null ? !treatmentName.equals(that.treatmentName) : that.treatmentName != null)
            return false;
        if (treatmentWay != null ? !treatmentWay.equals(that.treatmentWay) : that.treatmentWay != null) return false;
        if (treatmentCourse != null ? !treatmentCourse.equals(that.treatmentCourse) : that.treatmentCourse != null)
            return false;
        if (treatmentProcessFlag != null ? !treatmentProcessFlag.equals(that.treatmentProcessFlag) : that.treatmentProcessFlag != null)
            return false;
        if (treatmentEffect != null ? !treatmentEffect.equals(that.treatmentEffect) : that.treatmentEffect != null)
            return false;
        if (operationDoctor != null ? !operationDoctor.equals(that.operationDoctor) : that.operationDoctor != null)
            return false;
        if (treatmentType != null ? !treatmentType.equals(that.treatmentType) : that.treatmentType != null)
            return false;
        if (treatmentDesc != null ? !treatmentDesc.equals(that.treatmentDesc) : that.treatmentDesc != null)
            return false;
        if (treatmentBeginTime != null ? !treatmentBeginTime.equals(that.treatmentBeginTime) : that.treatmentBeginTime != null)
            return false;
        if (treatmentEndTime != null ? !treatmentEndTime.equals(that.treatmentEndTime) : that.treatmentEndTime != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (handleFlag != null ? !handleFlag.equals(that.handleFlag) : that.handleFlag != null) return false;
        if (rawCreateTime != null ? !rawCreateTime.equals(that.rawCreateTime) : that.rawCreateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = treatmentId != null ? treatmentId.hashCode() : 0;
        result = 31 * result + (emrId != null ? emrId.hashCode() : 0);
        result = 31 * result + (tempId != null ? tempId.hashCode() : 0);
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (patientNo != null ? patientNo.hashCode() : 0);
        result = 31 * result + (patientUuid != null ? patientUuid.hashCode() : 0);
        result = 31 * result + (hospitalId != null ? hospitalId.hashCode() : 0);
        result = 31 * result + (inHospitalId != null ? inHospitalId.hashCode() : 0);
        result = 31 * result + (treatmentTypeId != null ? treatmentTypeId.hashCode() : 0);
        result = 31 * result + (opCode != null ? opCode.hashCode() : 0);
        result = 31 * result + (treatmentName != null ? treatmentName.hashCode() : 0);
        result = 31 * result + (treatmentWay != null ? treatmentWay.hashCode() : 0);
        result = 31 * result + (treatmentCourse != null ? treatmentCourse.hashCode() : 0);
        result = 31 * result + (treatmentProcessFlag != null ? treatmentProcessFlag.hashCode() : 0);
        result = 31 * result + (treatmentEffect != null ? treatmentEffect.hashCode() : 0);
        result = 31 * result + (operationDoctor != null ? operationDoctor.hashCode() : 0);
        result = 31 * result + (treatmentType != null ? treatmentType.hashCode() : 0);
        result = 31 * result + (treatmentDesc != null ? treatmentDesc.hashCode() : 0);
        result = 31 * result + (treatmentBeginTime != null ? treatmentBeginTime.hashCode() : 0);
        result = 31 * result + (treatmentEndTime != null ? treatmentEndTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (handleFlag != null ? handleFlag.hashCode() : 0);
        result = 31 * result + (rawCreateTime != null ? rawCreateTime.hashCode() : 0);
        return result;
    }
}
