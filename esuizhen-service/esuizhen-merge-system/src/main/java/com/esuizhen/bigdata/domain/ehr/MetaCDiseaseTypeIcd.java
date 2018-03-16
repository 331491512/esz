package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_c_disease_type_icd", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_c_disease_type_icd_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaCDiseaseTypeIcd {
    private Integer id;
    private Integer icdDiseaseTypeId;
    private String icdDiseaseTypeName;
    private String diseaseCodePrefix;
    private Integer diseaseTypeId;
    private Integer sourceDiagnosisFlag;
    private Integer tumorFlag;
    private Timestamp createTime;
//    private MetaCDiseaseType metaCDiseaseTypeByDiseaseTypeId;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "icdDiseaseTypeId", nullable = false)
    public Integer getIcdDiseaseTypeId() {
        return icdDiseaseTypeId;
    }

    public void setIcdDiseaseTypeId(Integer icdDiseaseTypeId) {
        this.icdDiseaseTypeId = icdDiseaseTypeId;
    }

    @Basic
    @Column(name = "icdDiseaseTypeName", nullable = true, length = 500)
    public String getIcdDiseaseTypeName() {
        return icdDiseaseTypeName;
    }

    public void setIcdDiseaseTypeName(String icdDiseaseTypeName) {
        this.icdDiseaseTypeName = icdDiseaseTypeName;
    }

    @Basic
    @Column(name = "diseaseCodePrefix", nullable = false, length = 30)
    public String getDiseaseCodePrefix() {
        return diseaseCodePrefix;
    }

    public void setDiseaseCodePrefix(String diseaseCodePrefix) {
        this.diseaseCodePrefix = diseaseCodePrefix;
    }

    @Basic
    @Column(name = "diseaseTypeId", nullable = false)
    public Integer getDiseaseTypeId() {
        return diseaseTypeId;
    }

    public void setDiseaseTypeId(Integer diseaseTypeId) {
        this.diseaseTypeId = diseaseTypeId;
    }

    @Basic
    @Column(name = "sourceDiagnosisFlag", nullable = true)
    public Integer getSourceDiagnosisFlag() {
        return sourceDiagnosisFlag;
    }

    public void setSourceDiagnosisFlag(Integer sourceDiagnosisFlag) {
        this.sourceDiagnosisFlag = sourceDiagnosisFlag;
    }

    @Basic
    @Column(name = "tumorFlag", nullable = true)
    public Integer getTumorFlag() {
        return tumorFlag;
    }

    public void setTumorFlag(Integer tumorFlag) {
        this.tumorFlag = tumorFlag;
    }

    @Basic
    @Column(name = "createTime", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaCDiseaseTypeIcd that = (MetaCDiseaseTypeIcd) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (icdDiseaseTypeId != null ? !icdDiseaseTypeId.equals(that.icdDiseaseTypeId) : that.icdDiseaseTypeId != null)
            return false;
        if (icdDiseaseTypeName != null ? !icdDiseaseTypeName.equals(that.icdDiseaseTypeName) : that.icdDiseaseTypeName != null)
            return false;
        if (diseaseCodePrefix != null ? !diseaseCodePrefix.equals(that.diseaseCodePrefix) : that.diseaseCodePrefix != null)
            return false;
        if (diseaseTypeId != null ? !diseaseTypeId.equals(that.diseaseTypeId) : that.diseaseTypeId != null)
            return false;
        if (sourceDiagnosisFlag != null ? !sourceDiagnosisFlag.equals(that.sourceDiagnosisFlag) : that.sourceDiagnosisFlag != null)
            return false;
        if (tumorFlag != null ? !tumorFlag.equals(that.tumorFlag) : that.tumorFlag != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (icdDiseaseTypeId != null ? icdDiseaseTypeId.hashCode() : 0);
        result = 31 * result + (icdDiseaseTypeName != null ? icdDiseaseTypeName.hashCode() : 0);
        result = 31 * result + (diseaseCodePrefix != null ? diseaseCodePrefix.hashCode() : 0);
        result = 31 * result + (diseaseTypeId != null ? diseaseTypeId.hashCode() : 0);
        result = 31 * result + (sourceDiagnosisFlag != null ? sourceDiagnosisFlag.hashCode() : 0);
        result = 31 * result + (tumorFlag != null ? tumorFlag.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "diseaseTypeId", referencedColumnName = "diseaseTypeId", nullable = false)
//    public MetaCDiseaseType getMetaCDiseaseTypeByDiseaseTypeId() {
//        return metaCDiseaseTypeByDiseaseTypeId;
//    }
//
//    public void setMetaCDiseaseTypeByDiseaseTypeId(MetaCDiseaseType metaCDiseaseTypeByDiseaseTypeId) {
//        this.metaCDiseaseTypeByDiseaseTypeId = metaCDiseaseTypeByDiseaseTypeId;
//    }
}
