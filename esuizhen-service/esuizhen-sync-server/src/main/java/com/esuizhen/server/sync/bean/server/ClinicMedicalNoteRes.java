package com.esuizhen.server.sync.bean.server;

import com.esuizhen.server.sync.bean.TBatchDataResultInfo;

import java.util.Date;

/**
 * Created by Nidan on 2017年03月21 上午 11:40
 */
public class ClinicMedicalNoteRes {

    private String clinicMedicalId;

    private String emrId;

    private String clinicNo;

    private Long patientId;

    private String patientNo;

    private Integer hospitalId;

    private Integer symptomSummary;

    private String diagnosis;

    private String diseaseCode;

    private String remark;

    private Integer clinicDoctor;

    private Integer visitTimes;

    private Date visitTime;

    private Integer syncFlag;

    private Date syncTime;

    private Date createTime;

    private Date updateTime;

    private String clinicDoctorUuid;

    private Date rawCreateTime;

    private Integer attendingDoctorId;

    private String attendingDoctoruuId;

    private String attendingDoctorNo;

    private String attendingDoctorName;

    private String patientUuid;

    private String deptName;

    private Integer mergeFlag;

    private Long mergeFrom;

    private Long mergeTarget;

    private Date mergeTime;

    private Integer opFlag;//upFlag用于标识云端是否已经存在

    private Integer cpFlag;//cpFlag标识是否存在电子病历主表

    private String mergeFromUuid;
    private String mergeTargetUuid;
    private String deptUuid;
    private Integer tempId;
    private String healthCardNo;
    private String patientName;
    private String patientIdno;
    private String patientAddress;
    private String patientMobile;
    private Integer patientSex;
    private Date patientBirth;
    private Integer patientAge;
    private Integer deptId;
    private Integer handleFlag;
    private Integer sourceFlag;

    public Integer getSourceFlag() {
        return sourceFlag;
    }

    public void setSourceFlag(Integer sourceFlag) {
        this.sourceFlag = sourceFlag;
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

    public String getHealthCardNo() {
        return healthCardNo;
    }

    public void setHealthCardNo(String healthCardNo) {
        this.healthCardNo = healthCardNo;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientIdno() {
        return patientIdno;
    }

    public void setPatientIdno(String patientIdno) {
        this.patientIdno = patientIdno;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile;
    }

    public Integer getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(Integer patientSex) {
        this.patientSex = patientSex;
    }

    public Date getPatientBirth() {
        return patientBirth;
    }

    public void setPatientBirth(Date patientBirth) {
        this.patientBirth = patientBirth;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getHandleFlag() {
        return handleFlag;
    }

    public void setHandleFlag(Integer handleFlag) {
        this.handleFlag = handleFlag;
    }

    public String getDeptUuid() {
        return deptUuid;
    }

    public void setDeptUuid(String deptUuid) {
        this.deptUuid = deptUuid;
    }

    public Integer getCpFlag() {
        return cpFlag;
    }

    public void setCpFlag(Integer cpFlag) {
        this.cpFlag = cpFlag;
    }

    
    public Integer getOpFlag() {
		return opFlag;
	}

	public void setOpFlag(Integer opFlag) {
		this.opFlag = opFlag;
	}

	public String getClinicMedicalId() {
        return clinicMedicalId;
    }

    public void setClinicMedicalId(String clinicMedicalId) {
        this.clinicMedicalId = clinicMedicalId == null ? null : clinicMedicalId.trim();
    }

    public String getEmrId() {
        return emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId == null ? null : emrId.trim();
    }

    public String getClinicNo() {
        return clinicNo;
    }

    public void setClinicNo(String clinicNo) {
        this.clinicNo = clinicNo == null ? null : clinicNo.trim();
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

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getSymptomSummary() {
        return symptomSummary;
    }

    public void setSymptomSummary(Integer symptomSummary) {
        this.symptomSummary = symptomSummary;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis == null ? null : diagnosis.trim();
    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode == null ? null : diseaseCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getClinicDoctor() {
        return clinicDoctor;
    }

    public void setClinicDoctor(Integer clinicDoctor) {
        this.clinicDoctor = clinicDoctor;
    }

    public Integer getVisitTimes() {
        return visitTimes;
    }

    public void setVisitTimes(Integer visitTimes) {
        this.visitTimes = visitTimes;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public Integer getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(Integer syncFlag) {
        this.syncFlag = syncFlag;
    }

    public Date getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
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

    public String getClinicDoctorUuid() {
        return clinicDoctorUuid;
    }

    public void setClinicDoctorUuid(String clinicDoctorUuid) {
        this.clinicDoctorUuid = clinicDoctorUuid == null ? null : clinicDoctorUuid.trim();
    }

    public Date getRawCreateTime() {
        return rawCreateTime;
    }

    public void setRawCreateTime(Date rawCreateTime) {
        this.rawCreateTime = rawCreateTime;
    }

    public Integer getAttendingDoctorId() {
        return attendingDoctorId;
    }

    public void setAttendingDoctorId(Integer attendingDoctorId) {
        this.attendingDoctorId = attendingDoctorId;
    }

    public String getAttendingDoctoruuId() {
        return attendingDoctoruuId;
    }

    public void setAttendingDoctoruuId(String attendingDoctoruuId) {
        this.attendingDoctoruuId = attendingDoctoruuId == null ? null : attendingDoctoruuId.trim();
    }

    public String getAttendingDoctorNo() {
        return attendingDoctorNo;
    }

    public void setAttendingDoctorNo(String attendingDoctorNo) {
        this.attendingDoctorNo = attendingDoctorNo == null ? null : attendingDoctorNo.trim();
    }

    public String getAttendingDoctorName() {
        return attendingDoctorName;
    }

    public void setAttendingDoctorName(String attendingDoctorName) {
        this.attendingDoctorName = attendingDoctorName == null ? null : attendingDoctorName.trim();
    }

    public String getPatientUuid() {
        return patientUuid;
    }

    public void setPatientUuid(String patientUuid) {
        this.patientUuid = patientUuid == null ? null : patientUuid.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
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

    public TBatchDataResultInfo createResultInfo(){
        TBatchDataResultInfo resultInfo = new TBatchDataResultInfo();
        resultInfo.setSyncTime(new Date());
        resultInfo.setResultId(this.clinicMedicalId);
        resultInfo.setOpFlag(this.opFlag);
        return resultInfo;
    }
}