package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_diagnosis_type", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_diagnosis_type_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEDiagnosisType {
    private Integer diagnosisTypeId;
    private String diagnosisTypeName;

    @Id
    @Column(name = "diagnosisTypeId", nullable = false)
    public Integer getDiagnosisTypeId() {
        return diagnosisTypeId;
    }

    public void setDiagnosisTypeId(Integer diagnosisTypeId) {
        this.diagnosisTypeId = diagnosisTypeId;
    }

    @Basic
    @Column(name = "diagnosisTypeName", nullable = true, length = 100)
    public String getDiagnosisTypeName() {
        return diagnosisTypeName;
    }

    public void setDiagnosisTypeName(String diagnosisTypeName) {
        this.diagnosisTypeName = diagnosisTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaEDiagnosisType that = (MetaEDiagnosisType) o;

        if (diagnosisTypeId != null ? !diagnosisTypeId.equals(that.diagnosisTypeId) : that.diagnosisTypeId != null)
            return false;
        if (diagnosisTypeName != null ? !diagnosisTypeName.equals(that.diagnosisTypeName) : that.diagnosisTypeName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = diagnosisTypeId != null ? diagnosisTypeId.hashCode() : 0;
        result = 31 * result + (diagnosisTypeName != null ? diagnosisTypeName.hashCode() : 0);
        return result;
    }
}
