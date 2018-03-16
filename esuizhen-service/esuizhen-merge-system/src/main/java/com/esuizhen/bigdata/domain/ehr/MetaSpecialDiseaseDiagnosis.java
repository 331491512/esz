package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_special_disease_diagnosis", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_special_disease_diagnosis_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaSpecialDiseaseDiagnosis {
    private Integer specialDiseaseDiagnosisId;
    private String specialDiseaseDiagnosisName;
    private Timestamp createTime;

    @Id
    @Column(name = "specialDiseaseDiagnosisId", nullable = false)
    public Integer getSpecialDiseaseDiagnosisId() {
        return specialDiseaseDiagnosisId;
    }

    public void setSpecialDiseaseDiagnosisId(Integer specialDiseaseDiagnosisId) {
        this.specialDiseaseDiagnosisId = specialDiseaseDiagnosisId;
    }

    @Basic
    @Column(name = "specialDiseaseDiagnosisName", nullable = true, length = 60)
    public String getSpecialDiseaseDiagnosisName() {
        return specialDiseaseDiagnosisName;
    }

    public void setSpecialDiseaseDiagnosisName(String specialDiseaseDiagnosisName) {
        this.specialDiseaseDiagnosisName = specialDiseaseDiagnosisName;
    }

    @Basic
    @Column(name = "createTime", nullable = true)
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

        MetaSpecialDiseaseDiagnosis that = (MetaSpecialDiseaseDiagnosis) o;

        if (specialDiseaseDiagnosisId != null ? !specialDiseaseDiagnosisId.equals(that.specialDiseaseDiagnosisId) : that.specialDiseaseDiagnosisId != null)
            return false;
        if (specialDiseaseDiagnosisName != null ? !specialDiseaseDiagnosisName.equals(that.specialDiseaseDiagnosisName) : that.specialDiseaseDiagnosisName != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = specialDiseaseDiagnosisId != null ? specialDiseaseDiagnosisId.hashCode() : 0;
        result = 31 * result + (specialDiseaseDiagnosisName != null ? specialDiseaseDiagnosisName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
