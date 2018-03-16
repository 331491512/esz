package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_r_disease_type_icd_10", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_r_disease_type_icd_10_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaRDiseaseTypeIcd10 {
    private Integer id;
    private Integer hospitalId;
    private Integer diseaseTypeId;
    private String diseaseCode;
    private String diseaseTypeName;
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
    @Column(name = "diseaseCode", nullable = false, length = 30)
    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    @Basic
    @Column(name = "diseaseTypeName", nullable = false, length = 50)
    public String getDiseaseTypeName() {
        return diseaseTypeName;
    }

    public void setDiseaseTypeName(String diseaseTypeName) {
        this.diseaseTypeName = diseaseTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaRDiseaseTypeIcd10 that = (MetaRDiseaseTypeIcd10) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (hospitalId != null ? !hospitalId.equals(that.hospitalId) : that.hospitalId != null) return false;
        if (diseaseTypeId != null ? !diseaseTypeId.equals(that.diseaseTypeId) : that.diseaseTypeId != null)
            return false;
        if (diseaseCode != null ? !diseaseCode.equals(that.diseaseCode) : that.diseaseCode != null) return false;
        if (diseaseTypeName != null ? !diseaseTypeName.equals(that.diseaseTypeName) : that.diseaseTypeName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (hospitalId != null ? hospitalId.hashCode() : 0);
        result = 31 * result + (diseaseTypeId != null ? diseaseTypeId.hashCode() : 0);
        result = 31 * result + (diseaseCode != null ? diseaseCode.hashCode() : 0);
        result = 31 * result + (diseaseTypeName != null ? diseaseTypeName.hashCode() : 0);
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
