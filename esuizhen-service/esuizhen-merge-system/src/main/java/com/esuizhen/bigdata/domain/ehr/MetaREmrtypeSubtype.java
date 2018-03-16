package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_r_emrtype_subtype", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_r_emrtype_subtype_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaREmrtypeSubtype {
    private Integer id;
    private Integer emrSubType;
    private Integer emrType;
    private Timestamp createTime;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "emrSubType", nullable = false)
    public Integer getEmrSubType() {
        return emrSubType;
    }

    public void setEmrSubType(Integer emrSubType) {
        this.emrSubType = emrSubType;
    }

    @Basic
    @Column(name = "emrType", nullable = false)
    public Integer getEmrType() {
        return emrType;
    }

    public void setEmrType(Integer emrType) {
        this.emrType = emrType;
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

        MetaREmrtypeSubtype that = (MetaREmrtypeSubtype) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (emrSubType != null ? !emrSubType.equals(that.emrSubType) : that.emrSubType != null) return false;
        if (emrType != null ? !emrType.equals(that.emrType) : that.emrType != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (emrSubType != null ? emrSubType.hashCode() : 0);
        result = 31 * result + (emrType != null ? emrType.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
