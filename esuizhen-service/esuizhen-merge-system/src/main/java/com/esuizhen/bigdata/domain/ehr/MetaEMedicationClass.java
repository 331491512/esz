package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_medication_class", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_medication_class_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEMedicationClass {
    private Integer medicationClassId;
    private String medicationClassName;

    @Id
    @Column(name = "medicationClassId", nullable = false)
    public Integer getMedicationClassId() {
        return medicationClassId;
    }

    public void setMedicationClassId(Integer medicationClassId) {
        this.medicationClassId = medicationClassId;
    }

    @Basic
    @Column(name = "medicationClassName", nullable = false, length = 100)
    public String getMedicationClassName() {
        return medicationClassName;
    }

    public void setMedicationClassName(String medicationClassName) {
        this.medicationClassName = medicationClassName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaEMedicationClass that = (MetaEMedicationClass) o;

        if (medicationClassId != null ? !medicationClassId.equals(that.medicationClassId) : that.medicationClassId != null)
            return false;
        if (medicationClassName != null ? !medicationClassName.equals(that.medicationClassName) : that.medicationClassName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = medicationClassId != null ? medicationClassId.hashCode() : 0;
        result = 31 * result + (medicationClassName != null ? medicationClassName.hashCode() : 0);
        return result;
    }
}
