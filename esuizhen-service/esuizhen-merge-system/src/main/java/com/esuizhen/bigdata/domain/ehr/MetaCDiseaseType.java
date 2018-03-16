package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_c_disease_type", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_c_disease_type_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaCDiseaseType {
    private Integer diseaseTypeId;
    private String diseaseTypeName;
    private Integer hospitalId;
    private Timestamp createTime;
    private Integer sortIndex;
    private Integer diseaseBodyPartId;
    private Integer creator;
//    private MetaEDiseaseBodyPart metaEDiseaseBodyPartByDiseaseBodyPartId;
//    private Collection<MetaCDiseaseTypeIcd> metaCDiseaseTypeIcdsByDiseaseTypeId;
//    private Collection<MetaRDiseaseTypeIcd10> metaRDiseaseTypeIcd10sByDiseaseTypeId;
//    private Collection<MetaRDiseaseTypeKeyword> metaRDiseaseTypeKeywordsByDiseaseTypeId;

    @Id
    @Column(name = "diseaseTypeId", nullable = false)
    public Integer getDiseaseTypeId() {
        return diseaseTypeId;
    }

    public void setDiseaseTypeId(Integer diseaseTypeId) {
        this.diseaseTypeId = diseaseTypeId;
    }

    @Basic
    @Column(name = "diseaseTypeName", nullable = false, length = 100)
    public String getDiseaseTypeName() {
        return diseaseTypeName;
    }

    public void setDiseaseTypeName(String diseaseTypeName) {
        this.diseaseTypeName = diseaseTypeName;
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
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "sortIndex", nullable = false)
    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    @Basic
    @Column(name = "diseaseBodyPartId", nullable = true)
    public Integer getDiseaseBodyPartId() {
        return diseaseBodyPartId;
    }

    public void setDiseaseBodyPartId(Integer diseaseBodyPartId) {
        this.diseaseBodyPartId = diseaseBodyPartId;
    }

    @Basic
    @Column(name = "creator", nullable = true)
    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaCDiseaseType that = (MetaCDiseaseType) o;

        if (diseaseTypeId != null ? !diseaseTypeId.equals(that.diseaseTypeId) : that.diseaseTypeId != null)
            return false;
        if (diseaseTypeName != null ? !diseaseTypeName.equals(that.diseaseTypeName) : that.diseaseTypeName != null)
            return false;
        if (hospitalId != null ? !hospitalId.equals(that.hospitalId) : that.hospitalId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (sortIndex != null ? !sortIndex.equals(that.sortIndex) : that.sortIndex != null) return false;
        if (diseaseBodyPartId != null ? !diseaseBodyPartId.equals(that.diseaseBodyPartId) : that.diseaseBodyPartId != null)
            return false;
        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = diseaseTypeId != null ? diseaseTypeId.hashCode() : 0;
        result = 31 * result + (diseaseTypeName != null ? diseaseTypeName.hashCode() : 0);
        result = 31 * result + (hospitalId != null ? hospitalId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (sortIndex != null ? sortIndex.hashCode() : 0);
        result = 31 * result + (diseaseBodyPartId != null ? diseaseBodyPartId.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "diseaseBodyPartId", referencedColumnName = "deseaseBodyPartId")
//    public MetaEDiseaseBodyPart getMetaEDiseaseBodyPartByDiseaseBodyPartId() {
//        return metaEDiseaseBodyPartByDiseaseBodyPartId;
//    }
//
//    public void setMetaEDiseaseBodyPartByDiseaseBodyPartId(MetaEDiseaseBodyPart metaEDiseaseBodyPartByDiseaseBodyPartId) {
//        this.metaEDiseaseBodyPartByDiseaseBodyPartId = metaEDiseaseBodyPartByDiseaseBodyPartId;
//    }
//
//    @OneToMany(mappedBy = "metaCDiseaseTypeByDiseaseTypeId")
//    public Collection<MetaCDiseaseTypeIcd> getMetaCDiseaseTypeIcdsByDiseaseTypeId() {
//        return metaCDiseaseTypeIcdsByDiseaseTypeId;
//    }
//
//    public void setMetaCDiseaseTypeIcdsByDiseaseTypeId(Collection<MetaCDiseaseTypeIcd> metaCDiseaseTypeIcdsByDiseaseTypeId) {
//        this.metaCDiseaseTypeIcdsByDiseaseTypeId = metaCDiseaseTypeIcdsByDiseaseTypeId;
//    }
//
//    @OneToMany(mappedBy = "metaCDiseaseTypeByDiseaseTypeId")
//    public Collection<MetaRDiseaseTypeIcd10> getMetaRDiseaseTypeIcd10sByDiseaseTypeId() {
//        return metaRDiseaseTypeIcd10sByDiseaseTypeId;
//    }
//
//    public void setMetaRDiseaseTypeIcd10sByDiseaseTypeId(Collection<MetaRDiseaseTypeIcd10> metaRDiseaseTypeIcd10sByDiseaseTypeId) {
//        this.metaRDiseaseTypeIcd10sByDiseaseTypeId = metaRDiseaseTypeIcd10sByDiseaseTypeId;
//    }
//
//    @OneToMany(mappedBy = "metaCDiseaseTypeByDiseaseTypeId")
//    public Collection<MetaRDiseaseTypeKeyword> getMetaRDiseaseTypeKeywordsByDiseaseTypeId() {
//        return metaRDiseaseTypeKeywordsByDiseaseTypeId;
//    }
//
//    public void setMetaRDiseaseTypeKeywordsByDiseaseTypeId(Collection<MetaRDiseaseTypeKeyword> metaRDiseaseTypeKeywordsByDiseaseTypeId) {
//        this.metaRDiseaseTypeKeywordsByDiseaseTypeId = metaRDiseaseTypeKeywordsByDiseaseTypeId;
//    }
}
