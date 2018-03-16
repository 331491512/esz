package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "eci_surgery_intensive_care", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "eci_surgery_intensive_care_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class EciSurgeryIntensiveCare {
    private String intensiveId;
    private String inhospitalId;
    private String intensiveCareName;
    private Timestamp inIntensiveCareTime;
    private Timestamp outIntensiveCareTime;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "intensiveId", nullable = false, length = 128)
    public String getIntensiveId() {
        return intensiveId;
    }

    public void setIntensiveId(String intensiveId) {
        this.intensiveId = intensiveId;
    }

    @Basic
    @Column(name = "inhospitalId", nullable = false, length = 128)
    public String getInhospitalId() {
        return inhospitalId;
    }

    public void setInhospitalId(String inhospitalId) {
        this.inhospitalId = inhospitalId;
    }

    @Basic
    @Column(name = "intensiveCareName", nullable = true, length = 64)
    public String getIntensiveCareName() {
        return intensiveCareName;
    }

    public void setIntensiveCareName(String intensiveCareName) {
        this.intensiveCareName = intensiveCareName;
    }

    @Basic
    @Column(name = "inIntensiveCareTime", nullable = true)
    public Timestamp getInIntensiveCareTime() {
        return inIntensiveCareTime;
    }

    public void setInIntensiveCareTime(Timestamp inIntensiveCareTime) {
        this.inIntensiveCareTime = inIntensiveCareTime;
    }

    @Basic
    @Column(name = "outIntensiveCareTime", nullable = true)
    public Timestamp getOutIntensiveCareTime() {
        return outIntensiveCareTime;
    }

    public void setOutIntensiveCareTime(Timestamp outIntensiveCareTime) {
        this.outIntensiveCareTime = outIntensiveCareTime;
    }

    @Basic
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateTime", nullable = false)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EciSurgeryIntensiveCare that = (EciSurgeryIntensiveCare) o;

        if (intensiveId != null ? !intensiveId.equals(that.intensiveId) : that.intensiveId != null) return false;
        if (inhospitalId != null ? !inhospitalId.equals(that.inhospitalId) : that.inhospitalId != null) return false;
        if (intensiveCareName != null ? !intensiveCareName.equals(that.intensiveCareName) : that.intensiveCareName != null)
            return false;
        if (inIntensiveCareTime != null ? !inIntensiveCareTime.equals(that.inIntensiveCareTime) : that.inIntensiveCareTime != null)
            return false;
        if (outIntensiveCareTime != null ? !outIntensiveCareTime.equals(that.outIntensiveCareTime) : that.outIntensiveCareTime != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = intensiveId != null ? intensiveId.hashCode() : 0;
        result = 31 * result + (inhospitalId != null ? inhospitalId.hashCode() : 0);
        result = 31 * result + (intensiveCareName != null ? intensiveCareName.hashCode() : 0);
        result = 31 * result + (inIntensiveCareTime != null ? inIntensiveCareTime.hashCode() : 0);
        result = 31 * result + (outIntensiveCareTime != null ? outIntensiveCareTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
