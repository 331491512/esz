package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "e_symptom_info", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "e_symptom_info_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class ESymptomInfo {
    private String symptomId;
    private String emrId;
    private Long patientId;
    private String patientNo;
    private Integer symptomTypeId;
    private String symptomName;
    private Integer relationId;
    private String relationName;
    private Integer familyHistoryDiseaseTypeId;
    private String familyHistoryDiseaseTypeName;
    private String riskFactors;
    private Integer symptomDegree;
    private String remark;
    private Timestamp visitTime;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String diseaseTransfer;

    @Id
    @Column(name = "symptomId", nullable = false, length = 60)
    public String getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(String symptomId) {
        this.symptomId = symptomId;
    }

    @Basic
    @Column(name = "emrId", nullable = false, length = 60)
    public String getEmrId() {
        return emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId;
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
    @Column(name = "patientNo", nullable = false, length = 20)
    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    @Basic
    @Column(name = "symptomTypeId", nullable = false)
    public Integer getSymptomTypeId() {
        return symptomTypeId;
    }

    public void setSymptomTypeId(Integer symptomTypeId) {
        this.symptomTypeId = symptomTypeId;
    }

    @Basic
    @Column(name = "symptomName", nullable = false, length = 50)
    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    @Basic
    @Column(name = "relationId", nullable = true)
    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    @Basic
    @Column(name = "relationName", nullable = true, length = 64)
    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    @Basic
    @Column(name = "familyHistoryDiseaseTypeId", nullable = true)
    public Integer getFamilyHistoryDiseaseTypeId() {
        return familyHistoryDiseaseTypeId;
    }

    public void setFamilyHistoryDiseaseTypeId(Integer familyHistoryDiseaseTypeId) {
        this.familyHistoryDiseaseTypeId = familyHistoryDiseaseTypeId;
    }

    @Basic
    @Column(name = "familyHistoryDiseaseTypeName", nullable = true, length = 64)
    public String getFamilyHistoryDiseaseTypeName() {
        return familyHistoryDiseaseTypeName;
    }

    public void setFamilyHistoryDiseaseTypeName(String familyHistoryDiseaseTypeName) {
        this.familyHistoryDiseaseTypeName = familyHistoryDiseaseTypeName;
    }

    @Basic
    @Column(name = "riskFactors", nullable = true, length = 64)
    public String getRiskFactors() {
        return riskFactors;
    }

    public void setRiskFactors(String riskFactors) {
        this.riskFactors = riskFactors;
    }

    @Basic
    @Column(name = "symptomDegree", nullable = false)
    public Integer getSymptomDegree() {
        return symptomDegree;
    }

    public void setSymptomDegree(Integer symptomDegree) {
        this.symptomDegree = symptomDegree;
    }

    @Basic
    @Column(name = "remark", nullable = false, length = 256)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
    @Column(name = "diseaseTransfer", nullable = true, length = 64)
    public String getDiseaseTransfer() {
        return diseaseTransfer;
    }

    public void setDiseaseTransfer(String diseaseTransfer) {
        this.diseaseTransfer = diseaseTransfer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ESymptomInfo that = (ESymptomInfo) o;

        if (symptomId != null ? !symptomId.equals(that.symptomId) : that.symptomId != null) return false;
        if (emrId != null ? !emrId.equals(that.emrId) : that.emrId != null) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (patientNo != null ? !patientNo.equals(that.patientNo) : that.patientNo != null) return false;
        if (symptomTypeId != null ? !symptomTypeId.equals(that.symptomTypeId) : that.symptomTypeId != null)
            return false;
        if (symptomName != null ? !symptomName.equals(that.symptomName) : that.symptomName != null) return false;
        if (relationId != null ? !relationId.equals(that.relationId) : that.relationId != null) return false;
        if (relationName != null ? !relationName.equals(that.relationName) : that.relationName != null) return false;
        if (familyHistoryDiseaseTypeId != null ? !familyHistoryDiseaseTypeId.equals(that.familyHistoryDiseaseTypeId) : that.familyHistoryDiseaseTypeId != null)
            return false;
        if (familyHistoryDiseaseTypeName != null ? !familyHistoryDiseaseTypeName.equals(that.familyHistoryDiseaseTypeName) : that.familyHistoryDiseaseTypeName != null)
            return false;
        if (riskFactors != null ? !riskFactors.equals(that.riskFactors) : that.riskFactors != null) return false;
        if (symptomDegree != null ? !symptomDegree.equals(that.symptomDegree) : that.symptomDegree != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (visitTime != null ? !visitTime.equals(that.visitTime) : that.visitTime != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (diseaseTransfer != null ? !diseaseTransfer.equals(that.diseaseTransfer) : that.diseaseTransfer != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = symptomId != null ? symptomId.hashCode() : 0;
        result = 31 * result + (emrId != null ? emrId.hashCode() : 0);
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (patientNo != null ? patientNo.hashCode() : 0);
        result = 31 * result + (symptomTypeId != null ? symptomTypeId.hashCode() : 0);
        result = 31 * result + (symptomName != null ? symptomName.hashCode() : 0);
        result = 31 * result + (relationId != null ? relationId.hashCode() : 0);
        result = 31 * result + (relationName != null ? relationName.hashCode() : 0);
        result = 31 * result + (familyHistoryDiseaseTypeId != null ? familyHistoryDiseaseTypeId.hashCode() : 0);
        result = 31 * result + (familyHistoryDiseaseTypeName != null ? familyHistoryDiseaseTypeName.hashCode() : 0);
        result = 31 * result + (riskFactors != null ? riskFactors.hashCode() : 0);
        result = 31 * result + (symptomDegree != null ? symptomDegree.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (visitTime != null ? visitTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (diseaseTransfer != null ? diseaseTransfer.hashCode() : 0);
        return result;
    }
}
