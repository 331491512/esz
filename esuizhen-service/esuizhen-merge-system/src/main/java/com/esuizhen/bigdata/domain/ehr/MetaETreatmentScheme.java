package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_treatment_scheme", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_treatment_scheme_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaETreatmentScheme {
    private Integer treatmentSchemeId;
    private String treatmentSchemeName;
    private Integer treatmentPeriod;
    private Integer treatmentTypeId;
    private Timestamp createTime;
    private Long creator;
//    private MetaETreatment metaETreatmentByTreatmentTypeId;
//    private Collection<MetaETreatmentSchemeItemMedication> metaETreatmentSchemeItemMedicationsByTreatmentSchemeId;

    @Id
    @Column(name = "treatmentSchemeId", nullable = false)
    public Integer getTreatmentSchemeId() {
        return treatmentSchemeId;
    }

    public void setTreatmentSchemeId(Integer treatmentSchemeId) {
        this.treatmentSchemeId = treatmentSchemeId;
    }

    @Basic
    @Column(name = "treatmentSchemeName", nullable = false, length = 255)
    public String getTreatmentSchemeName() {
        return treatmentSchemeName;
    }

    public void setTreatmentSchemeName(String treatmentSchemeName) {
        this.treatmentSchemeName = treatmentSchemeName;
    }

    @Basic
    @Column(name = "treatmentPeriod", nullable = true)
    public Integer getTreatmentPeriod() {
        return treatmentPeriod;
    }

    public void setTreatmentPeriod(Integer treatmentPeriod) {
        this.treatmentPeriod = treatmentPeriod;
    }

    @Basic
    @Column(name = "treatmentTypeId", nullable = false)
    public Integer getTreatmentTypeId() {
        return treatmentTypeId;
    }

    public void setTreatmentTypeId(Integer treatmentTypeId) {
        this.treatmentTypeId = treatmentTypeId;
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

        MetaETreatmentScheme that = (MetaETreatmentScheme) o;

        if (treatmentSchemeId != null ? !treatmentSchemeId.equals(that.treatmentSchemeId) : that.treatmentSchemeId != null)
            return false;
        if (treatmentSchemeName != null ? !treatmentSchemeName.equals(that.treatmentSchemeName) : that.treatmentSchemeName != null)
            return false;
        if (treatmentPeriod != null ? !treatmentPeriod.equals(that.treatmentPeriod) : that.treatmentPeriod != null)
            return false;
        if (treatmentTypeId != null ? !treatmentTypeId.equals(that.treatmentTypeId) : that.treatmentTypeId != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = treatmentSchemeId != null ? treatmentSchemeId.hashCode() : 0;
        result = 31 * result + (treatmentSchemeName != null ? treatmentSchemeName.hashCode() : 0);
        result = 31 * result + (treatmentPeriod != null ? treatmentPeriod.hashCode() : 0);
        result = 31 * result + (treatmentTypeId != null ? treatmentTypeId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "treatmentTypeId", referencedColumnName = "treatmentTypeId", nullable = false)
//    public MetaETreatment getMetaETreatmentByTreatmentTypeId() {
//        return metaETreatmentByTreatmentTypeId;
//    }
//
//    public void setMetaETreatmentByTreatmentTypeId(MetaETreatment metaETreatmentByTreatmentTypeId) {
//        this.metaETreatmentByTreatmentTypeId = metaETreatmentByTreatmentTypeId;
//    }
//
//    @OneToMany(mappedBy = "metaETreatmentSchemeByTreatmentSchemeId")
//    public Collection<MetaETreatmentSchemeItemMedication> getMetaETreatmentSchemeItemMedicationsByTreatmentSchemeId() {
//        return metaETreatmentSchemeItemMedicationsByTreatmentSchemeId;
//    }
//
//    public void setMetaETreatmentSchemeItemMedicationsByTreatmentSchemeId(Collection<MetaETreatmentSchemeItemMedication> metaETreatmentSchemeItemMedicationsByTreatmentSchemeId) {
//        this.metaETreatmentSchemeItemMedicationsByTreatmentSchemeId = metaETreatmentSchemeItemMedicationsByTreatmentSchemeId;
//    }
}
