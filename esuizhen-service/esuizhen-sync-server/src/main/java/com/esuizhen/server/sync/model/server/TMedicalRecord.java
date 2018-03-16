package com.esuizhen.server.sync.model.server;

import java.io.Serializable;
import java.util.Date;
/**
 * Created by Nidan on 2017年03月21 上午 11:40
 */
public class TMedicalRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private String emrId;

    private String emrNo;

    private Long patientId;

    private String patientNo;

    private String patientUuid;

    private String uuid;

    private Integer emrType;

    private Integer emrSubType;

    private Integer subdivision;

    private String remark;

    private Long creatorId;

    private Integer hospitalId;

    private Integer sourceFlag;

    private Integer structFlag;

    private Integer plainContentType;

    private String plainContent;

    private Integer visibleFlag;

    private Date visitTime;

    private Date createTime;

    private Date updateTime;

    private Integer syncFlag;

    private Date syncTime;

    private String creatorUuid;

    public String getEmrId() {
        return emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId == null ? null : emrId.trim();
    }

    public String getEmrNo() {
        return emrNo;
    }

    public void setEmrNo(String emrNo) {
        this.emrNo = emrNo == null ? null : emrNo.trim();
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Integer getEmrType() {
        return emrType;
    }

    public void setEmrType(Integer emrType) {
        this.emrType = emrType;
    }

    public Integer getEmrSubType() {
        return emrSubType;
    }

    public void setEmrSubType(Integer emrSubType) {
        this.emrSubType = emrSubType;
    }

    public Integer getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(Integer subdivision) {
        this.subdivision = subdivision;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getSourceFlag() {
        return sourceFlag;
    }

    public void setSourceFlag(Integer sourceFlag) {
        this.sourceFlag = sourceFlag;
    }

    public Integer getStructFlag() {
        return structFlag;
    }

    public void setStructFlag(Integer structFlag) {
        this.structFlag = structFlag;
    }

    public Integer getPlainContentType() {
        return plainContentType;
    }

    public void setPlainContentType(Integer plainContentType) {
        this.plainContentType = plainContentType;
    }

    public String getPlainContent() {
        return plainContent;
    }

    public void setPlainContent(String plainContent) {
        this.plainContent = plainContent == null ? null : plainContent.trim();
    }

    public Integer getVisibleFlag() {
        return visibleFlag;
    }

    public void setVisibleFlag(Integer visibleFlag) {
        this.visibleFlag = visibleFlag;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
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

    public String getCreatorUuid() {
        return creatorUuid;
    }

    public void setCreatorUuid(String creatorUuid) {
        this.creatorUuid = creatorUuid == null ? null : creatorUuid.trim();
    }
}