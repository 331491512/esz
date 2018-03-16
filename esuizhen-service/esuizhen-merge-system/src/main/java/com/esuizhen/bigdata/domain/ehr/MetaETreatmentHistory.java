package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_treatment_history", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_treatment_history_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaETreatmentHistory {
    private Integer treatmentHistoryId;
    private String treatmentHistoryCode;
    private String treatmentHistoryName;

    @Id
    @Column(name = "treatmentHistoryId", nullable = false)
    public Integer getTreatmentHistoryId() {
        return treatmentHistoryId;
    }

    public void setTreatmentHistoryId(Integer treatmentHistoryId) {
        this.treatmentHistoryId = treatmentHistoryId;
    }

    @Basic
    @Column(name = "treatmentHistoryCode", nullable = true, length = 64)
    public String getTreatmentHistoryCode() {
        return treatmentHistoryCode;
    }

    public void setTreatmentHistoryCode(String treatmentHistoryCode) {
        this.treatmentHistoryCode = treatmentHistoryCode;
    }

    @Basic
    @Column(name = "treatmentHistoryName", nullable = true, length = 64)
    public String getTreatmentHistoryName() {
        return treatmentHistoryName;
    }

    public void setTreatmentHistoryName(String treatmentHistoryName) {
        this.treatmentHistoryName = treatmentHistoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaETreatmentHistory that = (MetaETreatmentHistory) o;

        if (treatmentHistoryId != null ? !treatmentHistoryId.equals(that.treatmentHistoryId) : that.treatmentHistoryId != null)
            return false;
        if (treatmentHistoryCode != null ? !treatmentHistoryCode.equals(that.treatmentHistoryCode) : that.treatmentHistoryCode != null)
            return false;
        if (treatmentHistoryName != null ? !treatmentHistoryName.equals(that.treatmentHistoryName) : that.treatmentHistoryName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = treatmentHistoryId != null ? treatmentHistoryId.hashCode() : 0;
        result = 31 * result + (treatmentHistoryCode != null ? treatmentHistoryCode.hashCode() : 0);
        result = 31 * result + (treatmentHistoryName != null ? treatmentHistoryName.hashCode() : 0);
        return result;
    }
}
