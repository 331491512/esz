package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "eci_surgery_note", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "eci_surgery_note_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class EciSurgeryNote {
    private String surgeryId;
    private String inhospitalId;
    private String emrId;
    private String mainId;
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
    private String bedNo;
    private String opCode;
    private Integer treatmentSchemeId;
    private String treatmentSchemeName;
    private Integer opLevel;
    private String surgeryName;
    private Long surgeryDoctor;
    private String surgeryDoctorName;
    private Long surgeryAssistant1;
    private String surgeryAssistant1Name;
    private Long surgeryAssistant2;
    private String surgeryAssistant2Name;
    private Timestamp surgeryDate;
    private Timestamp surgeryBeginTime;
    private Timestamp surgeryEndTime;
    private Integer anesthesiaDoctor;
    private String anesthesiaDoctorName;
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
    private String operatorName;
    private String remark;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp syncTime;
    private Integer syncFlag;
    private String incisionHealing;
    private Integer serialNum;
    private Integer incisionHealingId;
    private Integer handleFlag;
    private Timestamp rawCreateTime;
    private String treatmentId;

    private Integer mergeFlag;
    private Long mergeFrom;
    private Long mergeTarget;
    private Timestamp mergeTime;

    @Basic
    @Column(name = "treatmentId", nullable = true)
    public String getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(String treatmentId) {
        this.treatmentId = treatmentId;
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
    @Column(name = "surgeryId", nullable = false, length = 128)
    public String getSurgeryId() {
        return surgeryId;
    }

    public void setSurgeryId(String surgeryId) {
        this.surgeryId = surgeryId;
    }

    @Basic
    @Column(name = "inhospitalId", nullable = true, length = 128)
    public String getInhospitalId() {
        return inhospitalId;
    }

    public void setInhospitalId(String inhospitalId) {
        this.inhospitalId = inhospitalId;
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
    @Column(name = "mainID", nullable = true, length = 128)
    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId;
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
    @Column(name = "patientNo", nullable = false, length = 128)
    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    @Basic
    @Column(name = "oldPatientNo", nullable = true, length = 128)
    public String getOldPatientNo() {
        return oldPatientNo;
    }

    public void setOldPatientNo(String oldPatientNo) {
        this.oldPatientNo = oldPatientNo;
    }

    @Basic
    @Column(name = "inhospitalTimes", nullable = true)
    public Integer getInhospitalTimes() {
        return inhospitalTimes;
    }

    public void setInhospitalTimes(Integer inhospitalTimes) {
        this.inhospitalTimes = inhospitalTimes;
    }

    @Basic
    @Column(name = "oldInhospitalTimes", nullable = true)
    public Integer getOldInhospitalTimes() {
        return oldInhospitalTimes;
    }

    public void setOldInhospitalTimes(Integer oldInhospitalTimes) {
        this.oldInhospitalTimes = oldInhospitalTimes;
    }

    @Basic
    @Column(name = "inhospitalNo", nullable = true, length = 128)
    public String getInhospitalNo() {
        return inhospitalNo;
    }

    public void setInhospitalNo(String inhospitalNo) {
        this.inhospitalNo = inhospitalNo;
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
    @Column(name = "hospitalId", nullable = false)
    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Basic
    @Column(name = "deptId", nullable = true)
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "bedNo", nullable = true, length = 20)
    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
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
    @Column(name = "treatmentSchemeId", nullable = true)
    public Integer getTreatmentSchemeId() {
        return treatmentSchemeId;
    }

    public void setTreatmentSchemeId(Integer treatmentSchemeId) {
        this.treatmentSchemeId = treatmentSchemeId;
    }

    @Basic
    @Column(name = "treatmentSchemeName", nullable = true, length = 255)
    public String getTreatmentSchemeName() {
        return treatmentSchemeName;
    }

    public void setTreatmentSchemeName(String treatmentSchemeName) {
        this.treatmentSchemeName = treatmentSchemeName;
    }

    @Basic
    @Column(name = "opLevel", nullable = true)
    public Integer getOpLevel() {
        return opLevel;
    }

    public void setOpLevel(Integer opLevel) {
        this.opLevel = opLevel;
    }

    @Basic
    @Column(name = "surgeryName", nullable = false, length = 512)
    public String getSurgeryName() {
        return surgeryName;
    }

    public void setSurgeryName(String surgeryName) {
        this.surgeryName = surgeryName;
    }

    @Basic
    @Column(name = "surgeryDoctor", nullable = true)
    public Long getSurgeryDoctor() {
        return surgeryDoctor;
    }

    public void setSurgeryDoctor(Long surgeryDoctor) {
        this.surgeryDoctor = surgeryDoctor;
    }

    @Basic
    @Column(name = "surgeryDoctorName", nullable = true, length = 32)
    public String getSurgeryDoctorName() {
        return surgeryDoctorName;
    }

    public void setSurgeryDoctorName(String surgeryDoctorName) {
        this.surgeryDoctorName = surgeryDoctorName;
    }

    @Basic
    @Column(name = "surgeryAssistant1", nullable = true)
    public Long getSurgeryAssistant1() {
        return surgeryAssistant1;
    }

    public void setSurgeryAssistant1(Long surgeryAssistant1) {
        this.surgeryAssistant1 = surgeryAssistant1;
    }

    @Basic
    @Column(name = "surgeryAssistant1Name", nullable = true, length = 32)
    public String getSurgeryAssistant1Name() {
        return surgeryAssistant1Name;
    }

    public void setSurgeryAssistant1Name(String surgeryAssistant1Name) {
        this.surgeryAssistant1Name = surgeryAssistant1Name;
    }

    @Basic
    @Column(name = "surgeryAssistant2", nullable = true)
    public Long getSurgeryAssistant2() {
        return surgeryAssistant2;
    }

    public void setSurgeryAssistant2(Long surgeryAssistant2) {
        this.surgeryAssistant2 = surgeryAssistant2;
    }

    @Basic
    @Column(name = "surgeryAssistant2Name", nullable = true, length = 32)
    public String getSurgeryAssistant2Name() {
        return surgeryAssistant2Name;
    }

    public void setSurgeryAssistant2Name(String surgeryAssistant2Name) {
        this.surgeryAssistant2Name = surgeryAssistant2Name;
    }

    @Basic
    @Column(name = "surgeryDate", nullable = true)
    public Timestamp getSurgeryDate() {
        return surgeryDate;
    }

    public void setSurgeryDate(Timestamp surgeryDate) {
        this.surgeryDate = surgeryDate;
    }

    @Basic
    @Column(name = "surgeryBeginTime", nullable = true)
    public Timestamp getSurgeryBeginTime() {
        return surgeryBeginTime;
    }

    public void setSurgeryBeginTime(Timestamp surgeryBeginTime) {
        this.surgeryBeginTime = surgeryBeginTime;
    }

    @Basic
    @Column(name = "surgeryEndTime", nullable = true)
    public Timestamp getSurgeryEndTime() {
        return surgeryEndTime;
    }

    public void setSurgeryEndTime(Timestamp surgeryEndTime) {
        this.surgeryEndTime = surgeryEndTime;
    }

    @Basic
    @Column(name = "anesthesiaDoctor", nullable = true)
    public Integer getAnesthesiaDoctor() {
        return anesthesiaDoctor;
    }

    public void setAnesthesiaDoctor(Integer anesthesiaDoctor) {
        this.anesthesiaDoctor = anesthesiaDoctor;
    }

    @Basic
    @Column(name = "anesthesiaDoctorName", nullable = true, length = 32)
    public String getAnesthesiaDoctorName() {
        return anesthesiaDoctorName;
    }

    public void setAnesthesiaDoctorName(String anesthesiaDoctorName) {
        this.anesthesiaDoctorName = anesthesiaDoctorName;
    }

    @Basic
    @Column(name = "anesthesiaWay", nullable = true, length = 20)
    public String getAnesthesiaWay() {
        return anesthesiaWay;
    }

    public void setAnesthesiaWay(String anesthesiaWay) {
        this.anesthesiaWay = anesthesiaWay;
    }

    @Basic
    @Column(name = "preOperativeDiagnosis", nullable = true, length = 100)
    public String getPreOperativeDiagnosis() {
        return preOperativeDiagnosis;
    }

    public void setPreOperativeDiagnosis(String preOperativeDiagnosis) {
        this.preOperativeDiagnosis = preOperativeDiagnosis;
    }

    @Basic
    @Column(name = "inOperativeDiagnosis", nullable = true, length = 100)
    public String getInOperativeDiagnosis() {
        return inOperativeDiagnosis;
    }

    public void setInOperativeDiagnosis(String inOperativeDiagnosis) {
        this.inOperativeDiagnosis = inOperativeDiagnosis;
    }

    @Basic
    @Column(name = "bodyPosture", nullable = true, length = 20)
    public String getBodyPosture() {
        return bodyPosture;
    }

    public void setBodyPosture(String bodyPosture) {
        this.bodyPosture = bodyPosture;
    }

    @Basic
    @Column(name = "transfusion", nullable = true)
    public Integer getTransfusion() {
        return transfusion;
    }

    public void setTransfusion(Integer transfusion) {
        this.transfusion = transfusion;
    }

    @Basic
    @Column(name = "surgeryNurses", nullable = true, length = 30)
    public String getSurgeryNurses() {
        return surgeryNurses;
    }

    public void setSurgeryNurses(String surgeryNurses) {
        this.surgeryNurses = surgeryNurses;
    }

    @Basic
    @Column(name = "operativeApproach", nullable = true, length = 300)
    public String getOperativeApproach() {
        return operativeApproach;
    }

    public void setOperativeApproach(String operativeApproach) {
        this.operativeApproach = operativeApproach;
    }

    @Basic
    @Column(name = "operativeProbe", nullable = true, length = 300)
    public String getOperativeProbe() {
        return operativeProbe;
    }

    public void setOperativeProbe(String operativeProbe) {
        this.operativeProbe = operativeProbe;
    }

    @Basic
    @Column(name = "operativeMeasures", nullable = true, length = 1000)
    public String getOperativeMeasures() {
        return operativeMeasures;
    }

    public void setOperativeMeasures(String operativeMeasures) {
        this.operativeMeasures = operativeMeasures;
    }

    @Basic
    @Column(name = "operativeSituation", nullable = true, length = 300)
    public String getOperativeSituation() {
        return operativeSituation;
    }

    public void setOperativeSituation(String operativeSituation) {
        this.operativeSituation = operativeSituation;
    }

    @Basic
    @Column(name = "woundClosureWay", nullable = true, length = 50)
    public String getWoundClosureWay() {
        return woundClosureWay;
    }

    public void setWoundClosureWay(String woundClosureWay) {
        this.woundClosureWay = woundClosureWay;
    }

    @Basic
    @Column(name = "incisionBandagedWay", nullable = true, length = 50)
    public String getIncisionBandagedWay() {
        return incisionBandagedWay;
    }

    public void setIncisionBandagedWay(String incisionBandagedWay) {
        this.incisionBandagedWay = incisionBandagedWay;
    }

    @Basic
    @Column(name = "operatorName", nullable = true, length = 32)
    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 5000)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
    @Column(name = "syncTime", nullable = true)
    public Timestamp getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Timestamp syncTime) {
        this.syncTime = syncTime;
    }

    @Basic
    @Column(name = "syncFlag", nullable = true)
    public Integer getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(Integer syncFlag) {
        this.syncFlag = syncFlag;
    }

    @Basic
    @Column(name = "incisionHealing", nullable = true, length = 30)
    public String getIncisionHealing() {
        return incisionHealing;
    }

    public void setIncisionHealing(String incisionHealing) {
        this.incisionHealing = incisionHealing;
    }

    @Basic
    @Column(name = "serialNum", nullable = true)
    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }

    @Basic
    @Column(name = "incisionHealingId", nullable = true)
    public Integer getIncisionHealingId() {
        return incisionHealingId;
    }

    public void setIncisionHealingId(Integer incisionHealingId) {
        this.incisionHealingId = incisionHealingId;
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

        EciSurgeryNote that = (EciSurgeryNote) o;

        if (surgeryId != null ? !surgeryId.equals(that.surgeryId) : that.surgeryId != null) return false;
        if (inhospitalId != null ? !inhospitalId.equals(that.inhospitalId) : that.inhospitalId != null) return false;
        if (emrId != null ? !emrId.equals(that.emrId) : that.emrId != null) return false;
        if (mainId != null ? !mainId.equals(that.mainId) : that.mainId != null) return false;
        if (tempId != null ? !tempId.equals(that.tempId) : that.tempId != null) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (patientNo != null ? !patientNo.equals(that.patientNo) : that.patientNo != null) return false;
        if (oldPatientNo != null ? !oldPatientNo.equals(that.oldPatientNo) : that.oldPatientNo != null) return false;
        if (inhospitalTimes != null ? !inhospitalTimes.equals(that.inhospitalTimes) : that.inhospitalTimes != null)
            return false;
        if (oldInhospitalTimes != null ? !oldInhospitalTimes.equals(that.oldInhospitalTimes) : that.oldInhospitalTimes != null)
            return false;
        if (inhospitalNo != null ? !inhospitalNo.equals(that.inhospitalNo) : that.inhospitalNo != null) return false;
        if (patientUuid != null ? !patientUuid.equals(that.patientUuid) : that.patientUuid != null) return false;
        if (hospitalId != null ? !hospitalId.equals(that.hospitalId) : that.hospitalId != null) return false;
        if (deptId != null ? !deptId.equals(that.deptId) : that.deptId != null) return false;
        if (bedNo != null ? !bedNo.equals(that.bedNo) : that.bedNo != null) return false;
        if (opCode != null ? !opCode.equals(that.opCode) : that.opCode != null) return false;
        if (treatmentSchemeId != null ? !treatmentSchemeId.equals(that.treatmentSchemeId) : that.treatmentSchemeId != null)
            return false;
        if (treatmentSchemeName != null ? !treatmentSchemeName.equals(that.treatmentSchemeName) : that.treatmentSchemeName != null)
            return false;
        if (opLevel != null ? !opLevel.equals(that.opLevel) : that.opLevel != null) return false;
        if (surgeryName != null ? !surgeryName.equals(that.surgeryName) : that.surgeryName != null) return false;
        if (surgeryDoctor != null ? !surgeryDoctor.equals(that.surgeryDoctor) : that.surgeryDoctor != null)
            return false;
        if (surgeryDoctorName != null ? !surgeryDoctorName.equals(that.surgeryDoctorName) : that.surgeryDoctorName != null)
            return false;
        if (surgeryAssistant1 != null ? !surgeryAssistant1.equals(that.surgeryAssistant1) : that.surgeryAssistant1 != null)
            return false;
        if (surgeryAssistant1Name != null ? !surgeryAssistant1Name.equals(that.surgeryAssistant1Name) : that.surgeryAssistant1Name != null)
            return false;
        if (surgeryAssistant2 != null ? !surgeryAssistant2.equals(that.surgeryAssistant2) : that.surgeryAssistant2 != null)
            return false;
        if (surgeryAssistant2Name != null ? !surgeryAssistant2Name.equals(that.surgeryAssistant2Name) : that.surgeryAssistant2Name != null)
            return false;
        if (surgeryDate != null ? !surgeryDate.equals(that.surgeryDate) : that.surgeryDate != null) return false;
        if (surgeryBeginTime != null ? !surgeryBeginTime.equals(that.surgeryBeginTime) : that.surgeryBeginTime != null)
            return false;
        if (surgeryEndTime != null ? !surgeryEndTime.equals(that.surgeryEndTime) : that.surgeryEndTime != null)
            return false;
        if (anesthesiaDoctor != null ? !anesthesiaDoctor.equals(that.anesthesiaDoctor) : that.anesthesiaDoctor != null)
            return false;
        if (anesthesiaDoctorName != null ? !anesthesiaDoctorName.equals(that.anesthesiaDoctorName) : that.anesthesiaDoctorName != null)
            return false;
        if (anesthesiaWay != null ? !anesthesiaWay.equals(that.anesthesiaWay) : that.anesthesiaWay != null)
            return false;
        if (preOperativeDiagnosis != null ? !preOperativeDiagnosis.equals(that.preOperativeDiagnosis) : that.preOperativeDiagnosis != null)
            return false;
        if (inOperativeDiagnosis != null ? !inOperativeDiagnosis.equals(that.inOperativeDiagnosis) : that.inOperativeDiagnosis != null)
            return false;
        if (bodyPosture != null ? !bodyPosture.equals(that.bodyPosture) : that.bodyPosture != null) return false;
        if (transfusion != null ? !transfusion.equals(that.transfusion) : that.transfusion != null) return false;
        if (surgeryNurses != null ? !surgeryNurses.equals(that.surgeryNurses) : that.surgeryNurses != null)
            return false;
        if (operativeApproach != null ? !operativeApproach.equals(that.operativeApproach) : that.operativeApproach != null)
            return false;
        if (operativeProbe != null ? !operativeProbe.equals(that.operativeProbe) : that.operativeProbe != null)
            return false;
        if (operativeMeasures != null ? !operativeMeasures.equals(that.operativeMeasures) : that.operativeMeasures != null)
            return false;
        if (operativeSituation != null ? !operativeSituation.equals(that.operativeSituation) : that.operativeSituation != null)
            return false;
        if (woundClosureWay != null ? !woundClosureWay.equals(that.woundClosureWay) : that.woundClosureWay != null)
            return false;
        if (incisionBandagedWay != null ? !incisionBandagedWay.equals(that.incisionBandagedWay) : that.incisionBandagedWay != null)
            return false;
        if (operatorName != null ? !operatorName.equals(that.operatorName) : that.operatorName != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (syncTime != null ? !syncTime.equals(that.syncTime) : that.syncTime != null) return false;
        if (syncFlag != null ? !syncFlag.equals(that.syncFlag) : that.syncFlag != null) return false;
        if (incisionHealing != null ? !incisionHealing.equals(that.incisionHealing) : that.incisionHealing != null)
            return false;
        if (serialNum != null ? !serialNum.equals(that.serialNum) : that.serialNum != null) return false;
        if (incisionHealingId != null ? !incisionHealingId.equals(that.incisionHealingId) : that.incisionHealingId != null)
            return false;
        if (handleFlag != null ? !handleFlag.equals(that.handleFlag) : that.handleFlag != null) return false;
        if (rawCreateTime != null ? !rawCreateTime.equals(that.rawCreateTime) : that.rawCreateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = surgeryId != null ? surgeryId.hashCode() : 0;
        result = 31 * result + (inhospitalId != null ? inhospitalId.hashCode() : 0);
        result = 31 * result + (emrId != null ? emrId.hashCode() : 0);
        result = 31 * result + (mainId != null ? mainId.hashCode() : 0);
        result = 31 * result + (tempId != null ? tempId.hashCode() : 0);
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (patientNo != null ? patientNo.hashCode() : 0);
        result = 31 * result + (oldPatientNo != null ? oldPatientNo.hashCode() : 0);
        result = 31 * result + (inhospitalTimes != null ? inhospitalTimes.hashCode() : 0);
        result = 31 * result + (oldInhospitalTimes != null ? oldInhospitalTimes.hashCode() : 0);
        result = 31 * result + (inhospitalNo != null ? inhospitalNo.hashCode() : 0);
        result = 31 * result + (patientUuid != null ? patientUuid.hashCode() : 0);
        result = 31 * result + (hospitalId != null ? hospitalId.hashCode() : 0);
        result = 31 * result + (deptId != null ? deptId.hashCode() : 0);
        result = 31 * result + (bedNo != null ? bedNo.hashCode() : 0);
        result = 31 * result + (opCode != null ? opCode.hashCode() : 0);
        result = 31 * result + (treatmentSchemeId != null ? treatmentSchemeId.hashCode() : 0);
        result = 31 * result + (treatmentSchemeName != null ? treatmentSchemeName.hashCode() : 0);
        result = 31 * result + (opLevel != null ? opLevel.hashCode() : 0);
        result = 31 * result + (surgeryName != null ? surgeryName.hashCode() : 0);
        result = 31 * result + (surgeryDoctor != null ? surgeryDoctor.hashCode() : 0);
        result = 31 * result + (surgeryDoctorName != null ? surgeryDoctorName.hashCode() : 0);
        result = 31 * result + (surgeryAssistant1 != null ? surgeryAssistant1.hashCode() : 0);
        result = 31 * result + (surgeryAssistant1Name != null ? surgeryAssistant1Name.hashCode() : 0);
        result = 31 * result + (surgeryAssistant2 != null ? surgeryAssistant2.hashCode() : 0);
        result = 31 * result + (surgeryAssistant2Name != null ? surgeryAssistant2Name.hashCode() : 0);
        result = 31 * result + (surgeryDate != null ? surgeryDate.hashCode() : 0);
        result = 31 * result + (surgeryBeginTime != null ? surgeryBeginTime.hashCode() : 0);
        result = 31 * result + (surgeryEndTime != null ? surgeryEndTime.hashCode() : 0);
        result = 31 * result + (anesthesiaDoctor != null ? anesthesiaDoctor.hashCode() : 0);
        result = 31 * result + (anesthesiaDoctorName != null ? anesthesiaDoctorName.hashCode() : 0);
        result = 31 * result + (anesthesiaWay != null ? anesthesiaWay.hashCode() : 0);
        result = 31 * result + (preOperativeDiagnosis != null ? preOperativeDiagnosis.hashCode() : 0);
        result = 31 * result + (inOperativeDiagnosis != null ? inOperativeDiagnosis.hashCode() : 0);
        result = 31 * result + (bodyPosture != null ? bodyPosture.hashCode() : 0);
        result = 31 * result + (transfusion != null ? transfusion.hashCode() : 0);
        result = 31 * result + (surgeryNurses != null ? surgeryNurses.hashCode() : 0);
        result = 31 * result + (operativeApproach != null ? operativeApproach.hashCode() : 0);
        result = 31 * result + (operativeProbe != null ? operativeProbe.hashCode() : 0);
        result = 31 * result + (operativeMeasures != null ? operativeMeasures.hashCode() : 0);
        result = 31 * result + (operativeSituation != null ? operativeSituation.hashCode() : 0);
        result = 31 * result + (woundClosureWay != null ? woundClosureWay.hashCode() : 0);
        result = 31 * result + (incisionBandagedWay != null ? incisionBandagedWay.hashCode() : 0);
        result = 31 * result + (operatorName != null ? operatorName.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (syncTime != null ? syncTime.hashCode() : 0);
        result = 31 * result + (syncFlag != null ? syncFlag.hashCode() : 0);
        result = 31 * result + (incisionHealing != null ? incisionHealing.hashCode() : 0);
        result = 31 * result + (serialNum != null ? serialNum.hashCode() : 0);
        result = 31 * result + (incisionHealingId != null ? incisionHealingId.hashCode() : 0);
        result = 31 * result + (handleFlag != null ? handleFlag.hashCode() : 0);
        result = 31 * result + (rawCreateTime != null ? rawCreateTime.hashCode() : 0);
        return result;
    }
}
