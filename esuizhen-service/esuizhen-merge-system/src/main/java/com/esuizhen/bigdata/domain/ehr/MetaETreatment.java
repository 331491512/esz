package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_treatment", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_treatment_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaETreatment {
    private Integer treatmentTypeId;
    private String treatmentTypeName;
    private Integer flag;
    private Timestamp createTime;
    private Long creator;
//    private Collection<MetaETreatmentScheme> metaETreatmentSchemesByTreatmentTypeId;

    @Id
    @Column(name = "treatmentTypeId", nullable = false)
    public Integer getTreatmentTypeId() {
        return treatmentTypeId;
    }

    public void setTreatmentTypeId(Integer treatmentTypeId) {
        this.treatmentTypeId = treatmentTypeId;
    }

    @Basic
    @Column(name = "treatmentTypeName", nullable = false, length = 100)
    public String getTreatmentTypeName() {
        return treatmentTypeName;
    }

    public void setTreatmentTypeName(String treatmentTypeName) {
        this.treatmentTypeName = treatmentTypeName;
    }

    @Basic
    @Column(name = "flag", nullable = false)
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "createTime", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "creator", nullable = true)
    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaETreatment that = (MetaETreatment) o;

        if (treatmentTypeId != null ? !treatmentTypeId.equals(that.treatmentTypeId) : that.treatmentTypeId != null)
            return false;
        if (treatmentTypeName != null ? !treatmentTypeName.equals(that.treatmentTypeName) : that.treatmentTypeName != null)
            return false;
        if (flag != null ? !flag.equals(that.flag) : that.flag != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = treatmentTypeId != null ? treatmentTypeId.hashCode() : 0;
        result = 31 * result + (treatmentTypeName != null ? treatmentTypeName.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "metaETreatmentByTreatmentTypeId")
//    public Collection<MetaETreatmentScheme> getMetaETreatmentSchemesByTreatmentTypeId() {
//        return metaETreatmentSchemesByTreatmentTypeId;
//    }
//
//    public void setMetaETreatmentSchemesByTreatmentTypeId(Collection<MetaETreatmentScheme> metaETreatmentSchemesByTreatmentTypeId) {
//        this.metaETreatmentSchemesByTreatmentTypeId = metaETreatmentSchemesByTreatmentTypeId;
//    }
}
