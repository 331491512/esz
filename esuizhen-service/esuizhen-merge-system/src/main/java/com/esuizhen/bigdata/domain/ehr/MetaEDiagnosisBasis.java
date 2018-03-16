package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_diagnosis_basis", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_diagnosis_basis_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEDiagnosisBasis {
    private Integer diagnosisBasisId;
    private String diagnosisBasisCode;
    private String diagnosisBasisName;

    @Id
    @Column(name = "diagnosisBasisId", nullable = false)
    public Integer getDiagnosisBasisId() {
        return diagnosisBasisId;
    }

    public void setDiagnosisBasisId(Integer diagnosisBasisId) {
        this.diagnosisBasisId = diagnosisBasisId;
    }

    @Basic
    @Column(name = "diagnosisBasisCode", nullable = true, length = 32)
    public String getDiagnosisBasisCode() {
        return diagnosisBasisCode;
    }

    public void setDiagnosisBasisCode(String diagnosisBasisCode) {
        this.diagnosisBasisCode = diagnosisBasisCode;
    }

    @Basic
    @Column(name = "diagnosisBasisName", nullable = true, length = 64)
    public String getDiagnosisBasisName() {
        return diagnosisBasisName;
    }

    public void setDiagnosisBasisName(String diagnosisBasisName) {
        this.diagnosisBasisName = diagnosisBasisName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaEDiagnosisBasis that = (MetaEDiagnosisBasis) o;

        if (diagnosisBasisId != null ? !diagnosisBasisId.equals(that.diagnosisBasisId) : that.diagnosisBasisId != null)
            return false;
        if (diagnosisBasisCode != null ? !diagnosisBasisCode.equals(that.diagnosisBasisCode) : that.diagnosisBasisCode != null)
            return false;
        if (diagnosisBasisName != null ? !diagnosisBasisName.equals(that.diagnosisBasisName) : that.diagnosisBasisName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = diagnosisBasisId != null ? diagnosisBasisId.hashCode() : 0;
        result = 31 * result + (diagnosisBasisCode != null ? diagnosisBasisCode.hashCode() : 0);
        result = 31 * result + (diagnosisBasisName != null ? diagnosisBasisName.hashCode() : 0);
        return result;
    }
}
