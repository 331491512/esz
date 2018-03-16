package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_r_disease_type_keyword", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_r_disease_type_keyword_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaRDiseaseTypeKeyword {
    private Integer id;
    private Integer hospitalId;
    private Integer diseaseTypeId;
    private String diseaseTypeName;
    private String keyword;
    private String excludeKeyword;
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
    @Column(name = "hospitalId", nullable = false)
    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
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
    @Column(name = "diseaseTypeName", nullable = true, length = 100)
    public String getDiseaseTypeName() {
        return diseaseTypeName;
    }

    public void setDiseaseTypeName(String diseaseTypeName) {
        this.diseaseTypeName = diseaseTypeName;
    }

    @Basic
    @Column(name = "keyword", nullable = false, length = 255)
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Basic
    @Column(name = "excludeKeyword", nullable = true, length = 100)
    public String getExcludeKeyword() {
        return excludeKeyword;
    }

    public void setExcludeKeyword(String excludeKeyword) {
        this.excludeKeyword = excludeKeyword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaRDiseaseTypeKeyword that = (MetaRDiseaseTypeKeyword) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (hospitalId != null ? !hospitalId.equals(that.hospitalId) : that.hospitalId != null) return false;
        if (diseaseTypeId != null ? !diseaseTypeId.equals(that.diseaseTypeId) : that.diseaseTypeId != null)
            return false;
        if (diseaseTypeName != null ? !diseaseTypeName.equals(that.diseaseTypeName) : that.diseaseTypeName != null)
            return false;
        if (keyword != null ? !keyword.equals(that.keyword) : that.keyword != null) return false;
        if (excludeKeyword != null ? !excludeKeyword.equals(that.excludeKeyword) : that.excludeKeyword != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (hospitalId != null ? hospitalId.hashCode() : 0);
        result = 31 * result + (diseaseTypeId != null ? diseaseTypeId.hashCode() : 0);
        result = 31 * result + (diseaseTypeName != null ? diseaseTypeName.hashCode() : 0);
        result = 31 * result + (keyword != null ? keyword.hashCode() : 0);
        result = 31 * result + (excludeKeyword != null ? excludeKeyword.hashCode() : 0);
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
