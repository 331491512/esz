package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_icd_o_3", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_icd_o_3_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEIcdO3 {
    private String pathologyDiagnosisCode;
    private String pathologyDiagnosisName;
    private Timestamp createTime;

    @Id
    @Column(name = "pathologyDiagnosisCode", nullable = false, length = 30)
    public String getPathologyDiagnosisCode() {
        return pathologyDiagnosisCode;
    }

    public void setPathologyDiagnosisCode(String pathologyDiagnosisCode) {
        this.pathologyDiagnosisCode = pathologyDiagnosisCode;
    }

    @Basic
    @Column(name = "pathologyDiagnosisName", nullable = false, length = 100)
    public String getPathologyDiagnosisName() {
        return pathologyDiagnosisName;
    }

    public void setPathologyDiagnosisName(String pathologyDiagnosisName) {
        this.pathologyDiagnosisName = pathologyDiagnosisName;
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

        MetaEIcdO3 that = (MetaEIcdO3) o;

        if (pathologyDiagnosisCode != null ? !pathologyDiagnosisCode.equals(that.pathologyDiagnosisCode) : that.pathologyDiagnosisCode != null)
            return false;
        if (pathologyDiagnosisName != null ? !pathologyDiagnosisName.equals(that.pathologyDiagnosisName) : that.pathologyDiagnosisName != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pathologyDiagnosisCode != null ? pathologyDiagnosisCode.hashCode() : 0;
        result = 31 * result + (pathologyDiagnosisName != null ? pathologyDiagnosisName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
