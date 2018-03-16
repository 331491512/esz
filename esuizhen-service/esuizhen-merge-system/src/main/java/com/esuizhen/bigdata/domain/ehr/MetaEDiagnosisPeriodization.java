package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
//@Table(name = "meta_e_diagnosis_periodization", schema = "ehr_db",catalog="")
@Table(name = "meta_e_diagnosis_periodization", schema = "ehr_db")
//@Audited
//@AuditTable(value = "meta_e_diagnosis_periodization_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEDiagnosisPeriodization {
    private Integer disagnosisPeriodizationId;
    private String disagnosisPeriodizationCode;
    private String disagnosisPeriodizationName;
    private Integer phase;
    private Integer index;//这个列名是比较2b的
    private Timestamp createTime;

    @Id
    @Column(name = "disagnosisPeriodizationId", nullable = false)
    public Integer getDisagnosisPeriodizationId() {
        return disagnosisPeriodizationId;
    }

    public void setDisagnosisPeriodizationId(Integer disagnosisPeriodizationId) {
        this.disagnosisPeriodizationId = disagnosisPeriodizationId;
    }

    @Basic
    @Column(name = "disagnosisPeriodizationCode", nullable = false, length = 30)
    public String getDisagnosisPeriodizationCode() {
        return disagnosisPeriodizationCode;
    }

    public void setDisagnosisPeriodizationCode(String disagnosisPeriodizationCode) {
        this.disagnosisPeriodizationCode = disagnosisPeriodizationCode;
    }

    @Basic
    @Column(name = "disagnosisPeriodizationName", nullable = false, length = 100)
    public String getDisagnosisPeriodizationName() {
        return disagnosisPeriodizationName;
    }

    public void setDisagnosisPeriodizationName(String disagnosisPeriodizationName) {
        this.disagnosisPeriodizationName = disagnosisPeriodizationName;
    }

    @Basic
    @Column(name = "phase", nullable = false)
    public Integer getPhase() {
        return phase;
    }

    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    @Basic
    @Column(name = "index2", nullable = false)
    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
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

        MetaEDiagnosisPeriodization that = (MetaEDiagnosisPeriodization) o;

        if (disagnosisPeriodizationId != null ? !disagnosisPeriodizationId.equals(that.disagnosisPeriodizationId) : that.disagnosisPeriodizationId != null)
            return false;
        if (disagnosisPeriodizationCode != null ? !disagnosisPeriodizationCode.equals(that.disagnosisPeriodizationCode) : that.disagnosisPeriodizationCode != null)
            return false;
        if (disagnosisPeriodizationName != null ? !disagnosisPeriodizationName.equals(that.disagnosisPeriodizationName) : that.disagnosisPeriodizationName != null)
            return false;
        if (phase != null ? !phase.equals(that.phase) : that.phase != null) return false;
        if (index != null ? !index.equals(that.index) : that.index != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = disagnosisPeriodizationId != null ? disagnosisPeriodizationId.hashCode() : 0;
        result = 31 * result + (disagnosisPeriodizationCode != null ? disagnosisPeriodizationCode.hashCode() : 0);
        result = 31 * result + (disagnosisPeriodizationName != null ? disagnosisPeriodizationName.hashCode() : 0);
        result = 31 * result + (phase != null ? phase.hashCode() : 0);
        result = 31 * result + (index != null ? index.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
