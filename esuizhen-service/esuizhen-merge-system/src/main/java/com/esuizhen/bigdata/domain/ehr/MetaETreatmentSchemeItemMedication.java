package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_treatment_scheme_item_medication", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_treatment_scheme_item_medication_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaETreatmentSchemeItemMedication {
    private Integer treatmentItemId;
    private Integer treatmentSchemeId;
    private Integer medicationType;
    private Long medicationId;
    private String medicationName;
    private String medicationEnglishName;
    private String drugUsage;
    private Integer treatmentPeriod;
    private Double totalCourse;
    private Timestamp createTime;
    private Long creator;
//    private MetaETreatmentScheme metaETreatmentSchemeByTreatmentSchemeId;

    @Id
    @Column(name = "treatmentItemId", nullable = false)
    public Integer getTreatmentItemId() {
        return treatmentItemId;
    }

    public void setTreatmentItemId(Integer treatmentItemId) {
        this.treatmentItemId = treatmentItemId;
    }

    @Basic
    @Column(name = "treatmentSchemeId", nullable = false)
    public Integer getTreatmentSchemeId() {
        return treatmentSchemeId;
    }

    public void setTreatmentSchemeId(Integer treatmentSchemeId) {
        this.treatmentSchemeId = treatmentSchemeId;
    }

    @Basic
    @Column(name = "medicationType", nullable = true)
    public Integer getMedicationType() {
        return medicationType;
    }

    public void setMedicationType(Integer medicationType) {
        this.medicationType = medicationType;
    }

    @Basic
    @Column(name = "medicationId", nullable = true)
    public Long getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(Long medicationId) {
        this.medicationId = medicationId;
    }

    @Basic
    @Column(name = "medicationName", nullable = false, length = 255)
    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    @Basic
    @Column(name = "medicationEnglishName", nullable = true, length = 255)
    public String getMedicationEnglishName() {
        return medicationEnglishName;
    }

    public void setMedicationEnglishName(String medicationEnglishName) {
        this.medicationEnglishName = medicationEnglishName;
    }

    @Basic
    @Column(name = "drugUsage", nullable = true, length = 255)
    public String getDrugUsage() {
        return drugUsage;
    }

    public void setDrugUsage(String drugUsage) {
        this.drugUsage = drugUsage;
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
    @Column(name = "totalCourse", nullable = true, precision = 0)
    public Double getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(Double totalCourse) {
        this.totalCourse = totalCourse;
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

        MetaETreatmentSchemeItemMedication that = (MetaETreatmentSchemeItemMedication) o;

        if (treatmentItemId != null ? !treatmentItemId.equals(that.treatmentItemId) : that.treatmentItemId != null)
            return false;
        if (treatmentSchemeId != null ? !treatmentSchemeId.equals(that.treatmentSchemeId) : that.treatmentSchemeId != null)
            return false;
        if (medicationType != null ? !medicationType.equals(that.medicationType) : that.medicationType != null)
            return false;
        if (medicationId != null ? !medicationId.equals(that.medicationId) : that.medicationId != null) return false;
        if (medicationName != null ? !medicationName.equals(that.medicationName) : that.medicationName != null)
            return false;
        if (medicationEnglishName != null ? !medicationEnglishName.equals(that.medicationEnglishName) : that.medicationEnglishName != null)
            return false;
        if (drugUsage != null ? !drugUsage.equals(that.drugUsage) : that.drugUsage != null) return false;
        if (treatmentPeriod != null ? !treatmentPeriod.equals(that.treatmentPeriod) : that.treatmentPeriod != null)
            return false;
        if (totalCourse != null ? !totalCourse.equals(that.totalCourse) : that.totalCourse != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = treatmentItemId != null ? treatmentItemId.hashCode() : 0;
        result = 31 * result + (treatmentSchemeId != null ? treatmentSchemeId.hashCode() : 0);
        result = 31 * result + (medicationType != null ? medicationType.hashCode() : 0);
        result = 31 * result + (medicationId != null ? medicationId.hashCode() : 0);
        result = 31 * result + (medicationName != null ? medicationName.hashCode() : 0);
        result = 31 * result + (medicationEnglishName != null ? medicationEnglishName.hashCode() : 0);
        result = 31 * result + (drugUsage != null ? drugUsage.hashCode() : 0);
        result = 31 * result + (treatmentPeriod != null ? treatmentPeriod.hashCode() : 0);
        result = 31 * result + (totalCourse != null ? totalCourse.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "treatmentSchemeId", referencedColumnName = "treatmentSchemeId", nullable = false)
//    public MetaETreatmentScheme getMetaETreatmentSchemeByTreatmentSchemeId() {
//        return metaETreatmentSchemeByTreatmentSchemeId;
//    }
//
//    public void setMetaETreatmentSchemeByTreatmentSchemeId(MetaETreatmentScheme metaETreatmentSchemeByTreatmentSchemeId) {
//        this.metaETreatmentSchemeByTreatmentSchemeId = metaETreatmentSchemeByTreatmentSchemeId;
//    }
}
