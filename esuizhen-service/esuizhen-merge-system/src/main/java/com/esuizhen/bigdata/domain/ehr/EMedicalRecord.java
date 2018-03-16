package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "e_medical_record", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "e_medical_record_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class EMedicalRecord {
    private String emrId;
    private Long rawId;
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
    private Timestamp visitTime;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer syncFlag;
    private Timestamp syncTime;
    private Integer handleFlag;
    private Timestamp rawCreateTime;
//    private Collection<EMedicalPhotoOcrs> eMedicalPhotoOcrsesByEmrId;
//    private MetaEEmrType metaEEmrTypeByEmrType;
//    private MetaEEmrSubtype metaEEmrSubtypeByEmrSubType;
//    private Collection<EciDetectionReport> eciDetectionReportsByEmrId;
//    private Collection<EciExamReport> eciExamReportsByEmrId;

    @Id
    @Column(name = "emrId", nullable = false, length = 128)
    public String getEmrId() {
        return emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId;
    }

    @Basic
    @Column(name = "rawId", nullable = true)
    public Long getRawId() {
        return rawId;
    }

    public void setRawId(Long rawId) {
        this.rawId = rawId;
    }

    @Basic
    @Column(name = "emrNo", nullable = true, length = 128)
    public String getEmrNo() {
        return emrNo;
    }

    public void setEmrNo(String emrNo) {
        this.emrNo = emrNo;
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
    @Column(name = "uuid", nullable = true, length = 32)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "emrType", nullable = false)
    public Integer getEmrType() {
        return emrType;
    }

    public void setEmrType(Integer emrType) {
        this.emrType = emrType;
    }

    @Basic
    @Column(name = "emrSubType", nullable = false)
    public Integer getEmrSubType() {
        return emrSubType;
    }

    public void setEmrSubType(Integer emrSubType) {
        this.emrSubType = emrSubType;
    }

    @Basic
    @Column(name = "subdivision", nullable = true)
    public Integer getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(Integer subdivision) {
        this.subdivision = subdivision;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 1000)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "creatorId", nullable = true)
    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
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
    @Column(name = "sourceFlag", nullable = false)
    public Integer getSourceFlag() {
        return sourceFlag;
    }

    public void setSourceFlag(Integer sourceFlag) {
        this.sourceFlag = sourceFlag;
    }

    @Basic
    @Column(name = "structFlag", nullable = false)
    public Integer getStructFlag() {
        return structFlag;
    }

    public void setStructFlag(Integer structFlag) {
        this.structFlag = structFlag;
    }

    @Basic
    @Column(name = "plainContentType", nullable = true)
    public Integer getPlainContentType() {
        return plainContentType;
    }

    public void setPlainContentType(Integer plainContentType) {
        this.plainContentType = plainContentType;
    }

    @Basic
    @Column(name = "plainContent", nullable = true, length = 4096)
    public String getPlainContent() {
        return plainContent;
    }

    public void setPlainContent(String plainContent) {
        this.plainContent = plainContent;
    }

    @Basic
    @Column(name = "visibleFlag", nullable = false)
    public Integer getVisibleFlag() {
        return visibleFlag;
    }

    public void setVisibleFlag(Integer visibleFlag) {
        this.visibleFlag = visibleFlag;
    }

    @Basic
    @Column(name = "visitTime", nullable = false)
    public Timestamp getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Timestamp visitTime) {
        this.visitTime = visitTime;
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
    @Column(name = "syncFlag", nullable = true)
    public Integer getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(Integer syncFlag) {
        this.syncFlag = syncFlag;
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

        EMedicalRecord that = (EMedicalRecord) o;

        if (emrId != null ? !emrId.equals(that.emrId) : that.emrId != null) return false;
        if (rawId != null ? !rawId.equals(that.rawId) : that.rawId != null) return false;
        if (emrNo != null ? !emrNo.equals(that.emrNo) : that.emrNo != null) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (patientNo != null ? !patientNo.equals(that.patientNo) : that.patientNo != null) return false;
        if (patientUuid != null ? !patientUuid.equals(that.patientUuid) : that.patientUuid != null) return false;
        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
        if (emrType != null ? !emrType.equals(that.emrType) : that.emrType != null) return false;
        if (emrSubType != null ? !emrSubType.equals(that.emrSubType) : that.emrSubType != null) return false;
        if (subdivision != null ? !subdivision.equals(that.subdivision) : that.subdivision != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (creatorId != null ? !creatorId.equals(that.creatorId) : that.creatorId != null) return false;
        if (hospitalId != null ? !hospitalId.equals(that.hospitalId) : that.hospitalId != null) return false;
        if (sourceFlag != null ? !sourceFlag.equals(that.sourceFlag) : that.sourceFlag != null) return false;
        if (structFlag != null ? !structFlag.equals(that.structFlag) : that.structFlag != null) return false;
        if (plainContentType != null ? !plainContentType.equals(that.plainContentType) : that.plainContentType != null)
            return false;
        if (plainContent != null ? !plainContent.equals(that.plainContent) : that.plainContent != null) return false;
        if (visibleFlag != null ? !visibleFlag.equals(that.visibleFlag) : that.visibleFlag != null) return false;
        if (visitTime != null ? !visitTime.equals(that.visitTime) : that.visitTime != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (syncFlag != null ? !syncFlag.equals(that.syncFlag) : that.syncFlag != null) return false;
        if (syncTime != null ? !syncTime.equals(that.syncTime) : that.syncTime != null) return false;
        if (handleFlag != null ? !handleFlag.equals(that.handleFlag) : that.handleFlag != null) return false;
        if (rawCreateTime != null ? !rawCreateTime.equals(that.rawCreateTime) : that.rawCreateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = emrId != null ? emrId.hashCode() : 0;
        result = 31 * result + (rawId != null ? rawId.hashCode() : 0);
        result = 31 * result + (emrNo != null ? emrNo.hashCode() : 0);
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (patientNo != null ? patientNo.hashCode() : 0);
        result = 31 * result + (patientUuid != null ? patientUuid.hashCode() : 0);
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (emrType != null ? emrType.hashCode() : 0);
        result = 31 * result + (emrSubType != null ? emrSubType.hashCode() : 0);
        result = 31 * result + (subdivision != null ? subdivision.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (creatorId != null ? creatorId.hashCode() : 0);
        result = 31 * result + (hospitalId != null ? hospitalId.hashCode() : 0);
        result = 31 * result + (sourceFlag != null ? sourceFlag.hashCode() : 0);
        result = 31 * result + (structFlag != null ? structFlag.hashCode() : 0);
        result = 31 * result + (plainContentType != null ? plainContentType.hashCode() : 0);
        result = 31 * result + (plainContent != null ? plainContent.hashCode() : 0);
        result = 31 * result + (visibleFlag != null ? visibleFlag.hashCode() : 0);
        result = 31 * result + (visitTime != null ? visitTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (syncFlag != null ? syncFlag.hashCode() : 0);
        result = 31 * result + (syncTime != null ? syncTime.hashCode() : 0);
        result = 31 * result + (handleFlag != null ? handleFlag.hashCode() : 0);
        result = 31 * result + (rawCreateTime != null ? rawCreateTime.hashCode() : 0);
        return result;
    }
//
//    @OneToMany(mappedBy = "eMedicalRecordByEmrId")
//    public Collection<EMedicalPhotoOcrs> geteMedicalPhotoOcrsesByEmrId() {
//        return eMedicalPhotoOcrsesByEmrId;
//    }
//
//    public void seteMedicalPhotoOcrsesByEmrId(Collection<EMedicalPhotoOcrs> eMedicalPhotoOcrsesByEmrId) {
//        this.eMedicalPhotoOcrsesByEmrId = eMedicalPhotoOcrsesByEmrId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "emrType", referencedColumnName = "emrType", nullable = false)
//    public MetaEEmrType getMetaEEmrTypeByEmrType() {
//        return metaEEmrTypeByEmrType;
//    }
//
//    public void setMetaEEmrTypeByEmrType(MetaEEmrType metaEEmrTypeByEmrType) {
//        this.metaEEmrTypeByEmrType = metaEEmrTypeByEmrType;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "emrSubType", referencedColumnName = "emrSubType", nullable = false)
//    public MetaEEmrSubtype getMetaEEmrSubtypeByEmrSubType() {
//        return metaEEmrSubtypeByEmrSubType;
//    }
//
//    public void setMetaEEmrSubtypeByEmrSubType(MetaEEmrSubtype metaEEmrSubtypeByEmrSubType) {
//        this.metaEEmrSubtypeByEmrSubType = metaEEmrSubtypeByEmrSubType;
//    }
//
//    @OneToMany(mappedBy = "eMedicalRecordByEmrId")
//    public Collection<EciDetectionReport> getEciDetectionReportsByEmrId() {
//        return eciDetectionReportsByEmrId;
//    }
//
//    public void setEciDetectionReportsByEmrId(Collection<EciDetectionReport> eciDetectionReportsByEmrId) {
//        this.eciDetectionReportsByEmrId = eciDetectionReportsByEmrId;
//    }
//
//    @OneToMany(mappedBy = "eMedicalRecordByEmrId")
//    public Collection<EciExamReport> getEciExamReportsByEmrId() {
//        return eciExamReportsByEmrId;
//    }
//
//    public void setEciExamReportsByEmrId(Collection<EciExamReport> eciExamReportsByEmrId) {
//        this.eciExamReportsByEmrId = eciExamReportsByEmrId;
//    }
}
