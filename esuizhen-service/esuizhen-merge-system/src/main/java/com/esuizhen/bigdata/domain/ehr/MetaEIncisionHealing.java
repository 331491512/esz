package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_incision_healing", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_incision_healing_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEIncisionHealing {
    private Integer incisionHealingId;
    private String incisionHealingGroup;
    private String incisionHealingLevel;
    private String incisionHealingDesc;
    private String incisionHealingPy;
    private Timestamp createTime;

    @Id
    @Column(name = "incisionHealingId", nullable = false)
    public Integer getIncisionHealingId() {
        return incisionHealingId;
    }

    public void setIncisionHealingId(Integer incisionHealingId) {
        this.incisionHealingId = incisionHealingId;
    }

    @Basic
    @Column(name = "incisionHealingGroup", nullable = true, length = 16)
    public String getIncisionHealingGroup() {
        return incisionHealingGroup;
    }

    public void setIncisionHealingGroup(String incisionHealingGroup) {
        this.incisionHealingGroup = incisionHealingGroup;
    }

    @Basic
    @Column(name = "incisionHealingLevel", nullable = true, length = 16)
    public String getIncisionHealingLevel() {
        return incisionHealingLevel;
    }

    public void setIncisionHealingLevel(String incisionHealingLevel) {
        this.incisionHealingLevel = incisionHealingLevel;
    }

    @Basic
    @Column(name = "incisionHealingDesc", nullable = true, length = 64)
    public String getIncisionHealingDesc() {
        return incisionHealingDesc;
    }

    public void setIncisionHealingDesc(String incisionHealingDesc) {
        this.incisionHealingDesc = incisionHealingDesc;
    }

    @Basic
    @Column(name = "incisionHealingPy", nullable = true, length = 32)
    public String getIncisionHealingPy() {
        return incisionHealingPy;
    }

    public void setIncisionHealingPy(String incisionHealingPy) {
        this.incisionHealingPy = incisionHealingPy;
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

        MetaEIncisionHealing that = (MetaEIncisionHealing) o;

        if (incisionHealingId != null ? !incisionHealingId.equals(that.incisionHealingId) : that.incisionHealingId != null)
            return false;
        if (incisionHealingGroup != null ? !incisionHealingGroup.equals(that.incisionHealingGroup) : that.incisionHealingGroup != null)
            return false;
        if (incisionHealingLevel != null ? !incisionHealingLevel.equals(that.incisionHealingLevel) : that.incisionHealingLevel != null)
            return false;
        if (incisionHealingDesc != null ? !incisionHealingDesc.equals(that.incisionHealingDesc) : that.incisionHealingDesc != null)
            return false;
        if (incisionHealingPy != null ? !incisionHealingPy.equals(that.incisionHealingPy) : that.incisionHealingPy != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = incisionHealingId != null ? incisionHealingId.hashCode() : 0;
        result = 31 * result + (incisionHealingGroup != null ? incisionHealingGroup.hashCode() : 0);
        result = 31 * result + (incisionHealingLevel != null ? incisionHealingLevel.hashCode() : 0);
        result = 31 * result + (incisionHealingDesc != null ? incisionHealingDesc.hashCode() : 0);
        result = 31 * result + (incisionHealingPy != null ? incisionHealingPy.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
