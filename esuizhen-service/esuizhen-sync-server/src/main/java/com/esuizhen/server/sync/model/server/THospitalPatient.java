package com.esuizhen.server.sync.model.server;

import java.io.Serializable;
import java.util.Date;
/**
 * Created by Nidan on 2017年03月24 下午 17:01
 */
public class THospitalPatient implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Long patientId;

    private Integer hospitalId;

    private String patientNo;

    private Integer sourceFlag;

    private Integer syncFlag;

    private Date lastestFollowupResultSyncTime;

    private Integer hospitalCertificateState;

    private Date createTime;

    private String hospitalUuid;

    private String patientUuid;

    private Date inhospitalDate;

    private Date certificateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo == null ? null : patientNo.trim();
    }

    public Integer getSourceFlag() {
        return sourceFlag;
    }

    public void setSourceFlag(Integer sourceFlag) {
        this.sourceFlag = sourceFlag;
    }

    public Integer getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(Integer syncFlag) {
        this.syncFlag = syncFlag;
    }

    public Date getLastestFollowupResultSyncTime() {
        return lastestFollowupResultSyncTime;
    }

    public void setLastestFollowupResultSyncTime(Date lastestFollowupResultSyncTime) {
        this.lastestFollowupResultSyncTime = lastestFollowupResultSyncTime;
    }

    public Integer getHospitalCertificateState() {
        return hospitalCertificateState;
    }

    public void setHospitalCertificateState(Integer hospitalCertificateState) {
        this.hospitalCertificateState = hospitalCertificateState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getHospitalUuid() {
        return hospitalUuid;
    }

    public void setHospitalUuid(String hospitalUuid) {
        this.hospitalUuid = hospitalUuid == null ? null : hospitalUuid.trim();
    }

    public String getPatientUuid() {
        return patientUuid;
    }

    public void setPatientUuid(String patientUuid) {
        this.patientUuid = patientUuid == null ? null : patientUuid.trim();
    }

    public Date getInhospitalDate() {
        return inhospitalDate;
    }

    public void setInhospitalDate(Date inhospitalDate) {
        this.inhospitalDate = inhospitalDate;
    }

    public Date getCertificateTime() {
        return certificateTime;
    }

    public void setCertificateTime(Date certificateTime) {
        this.certificateTime = certificateTime;
    }
}