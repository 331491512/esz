package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "e_medical_photo_ocrs", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "e_medical_photo_ocrs_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class EMedicalPhotoOcrs {
    private String emrPhotoId;
    private String emrId;
    private Integer ocrApply;
    private Integer ocrFlag;
    private String picFileUrl;
    private Integer plainContentType;
    private String plainContent;
    private Timestamp createTime;
    private Timestamp updateTime;
//    private EMedicalRecord eMedicalRecordByEmrId;

    @Id
    @Column(name = "emrPhotoId", nullable = false, length = 128)
    public String getEmrPhotoId() {
        return emrPhotoId;
    }

    public void setEmrPhotoId(String emrPhotoId) {
        this.emrPhotoId = emrPhotoId;
    }

    @Basic
    @Column(name = "emrId", nullable = false, length = 128)
    public String getEmrId() {
        return emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId;
    }

    @Basic
    @Column(name = "ocrApply", nullable = false)
    public Integer getOcrApply() {
        return ocrApply;
    }

    public void setOcrApply(Integer ocrApply) {
        this.ocrApply = ocrApply;
    }

    @Basic
    @Column(name = "ocrFlag", nullable = false)
    public Integer getOcrFlag() {
        return ocrFlag;
    }

    public void setOcrFlag(Integer ocrFlag) {
        this.ocrFlag = ocrFlag;
    }

    @Basic
    @Column(name = "picFileUrl", nullable = false, length = 512)
    public String getPicFileUrl() {
        return picFileUrl;
    }

    public void setPicFileUrl(String picFileUrl) {
        this.picFileUrl = picFileUrl;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EMedicalPhotoOcrs that = (EMedicalPhotoOcrs) o;

        if (emrPhotoId != null ? !emrPhotoId.equals(that.emrPhotoId) : that.emrPhotoId != null) return false;
        if (emrId != null ? !emrId.equals(that.emrId) : that.emrId != null) return false;
        if (ocrApply != null ? !ocrApply.equals(that.ocrApply) : that.ocrApply != null) return false;
        if (ocrFlag != null ? !ocrFlag.equals(that.ocrFlag) : that.ocrFlag != null) return false;
        if (picFileUrl != null ? !picFileUrl.equals(that.picFileUrl) : that.picFileUrl != null) return false;
        if (plainContentType != null ? !plainContentType.equals(that.plainContentType) : that.plainContentType != null)
            return false;
        if (plainContent != null ? !plainContent.equals(that.plainContent) : that.plainContent != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = emrPhotoId != null ? emrPhotoId.hashCode() : 0;
        result = 31 * result + (emrId != null ? emrId.hashCode() : 0);
        result = 31 * result + (ocrApply != null ? ocrApply.hashCode() : 0);
        result = 31 * result + (ocrFlag != null ? ocrFlag.hashCode() : 0);
        result = 31 * result + (picFileUrl != null ? picFileUrl.hashCode() : 0);
        result = 31 * result + (plainContentType != null ? plainContentType.hashCode() : 0);
        result = 31 * result + (plainContent != null ? plainContent.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "emrId", referencedColumnName = "emrId", nullable = false)
//    public EMedicalRecord geteMedicalRecordByEmrId() {
//        return eMedicalRecordByEmrId;
//    }
//
//    public void seteMedicalRecordByEmrId(EMedicalRecord eMedicalRecordByEmrId) {
//        this.eMedicalRecordByEmrId = eMedicalRecordByEmrId;
//    }
}
