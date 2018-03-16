package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_physical_signs", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_physical_signs_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEPhysicalSigns {
    private Integer physicalSignsId;
    private String physicalSignsName;
    private Timestamp createTime;
    private Long creator;

    @Id
    @Column(name = "physicalSignsId", nullable = false)
    public Integer getPhysicalSignsId() {
        return physicalSignsId;
    }

    public void setPhysicalSignsId(Integer physicalSignsId) {
        this.physicalSignsId = physicalSignsId;
    }

    @Basic
    @Column(name = "physicalSignsName", nullable = false, length = 100)
    public String getPhysicalSignsName() {
        return physicalSignsName;
    }

    public void setPhysicalSignsName(String physicalSignsName) {
        this.physicalSignsName = physicalSignsName;
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
    @Column(name = "creator", nullable = false)
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

        MetaEPhysicalSigns that = (MetaEPhysicalSigns) o;

        if (physicalSignsId != null ? !physicalSignsId.equals(that.physicalSignsId) : that.physicalSignsId != null)
            return false;
        if (physicalSignsName != null ? !physicalSignsName.equals(that.physicalSignsName) : that.physicalSignsName != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = physicalSignsId != null ? physicalSignsId.hashCode() : 0;
        result = 31 * result + (physicalSignsName != null ? physicalSignsName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        return result;
    }
}
