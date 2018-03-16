package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_disease_body_part", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_disease_body_part_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEDiseaseBodyPart {
    private Integer deseaseBodyPartId;
    private String deseaseBodyPartName;
    private Integer sortIndex;
    private Timestamp createTime;
//    private Collection<MetaCDiseaseType> metaCDiseaseTypesByDeseaseBodyPartId;

    @Id
    @Column(name = "deseaseBodyPartId", nullable = false)
    public Integer getDeseaseBodyPartId() {
        return deseaseBodyPartId;
    }

    public void setDeseaseBodyPartId(Integer deseaseBodyPartId) {
        this.deseaseBodyPartId = deseaseBodyPartId;
    }

    @Basic
    @Column(name = "deseaseBodyPartName", nullable = false, length = 100)
    public String getDeseaseBodyPartName() {
        return deseaseBodyPartName;
    }

    public void setDeseaseBodyPartName(String deseaseBodyPartName) {
        this.deseaseBodyPartName = deseaseBodyPartName;
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
    @Column(name = "createTime", nullable = false)
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

        MetaEDiseaseBodyPart that = (MetaEDiseaseBodyPart) o;

        if (deseaseBodyPartId != null ? !deseaseBodyPartId.equals(that.deseaseBodyPartId) : that.deseaseBodyPartId != null)
            return false;
        if (deseaseBodyPartName != null ? !deseaseBodyPartName.equals(that.deseaseBodyPartName) : that.deseaseBodyPartName != null)
            return false;
        if (sortIndex != null ? !sortIndex.equals(that.sortIndex) : that.sortIndex != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deseaseBodyPartId != null ? deseaseBodyPartId.hashCode() : 0;
        result = 31 * result + (deseaseBodyPartName != null ? deseaseBodyPartName.hashCode() : 0);
        result = 31 * result + (sortIndex != null ? sortIndex.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "metaEDiseaseBodyPartByDiseaseBodyPartId")
//    public Collection<MetaCDiseaseType> getMetaCDiseaseTypesByDeseaseBodyPartId() {
//        return metaCDiseaseTypesByDeseaseBodyPartId;
//    }
//
//    public void setMetaCDiseaseTypesByDeseaseBodyPartId(Collection<MetaCDiseaseType> metaCDiseaseTypesByDeseaseBodyPartId) {
//        this.metaCDiseaseTypesByDeseaseBodyPartId = metaCDiseaseTypesByDeseaseBodyPartId;
//    }
}
