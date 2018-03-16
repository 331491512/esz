package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_radiotherapy_part", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_radiotherapy_part_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaERadiotherapyPart {
    private Integer radiotherapyPartId;
    private String radiotherapyPartName;
    private Timestamp createTime;
    private Long creator;

    @Id
    @Column(name = "radiotherapyPartId", nullable = false)
    public Integer getRadiotherapyPartId() {
        return radiotherapyPartId;
    }

    public void setRadiotherapyPartId(Integer radiotherapyPartId) {
        this.radiotherapyPartId = radiotherapyPartId;
    }

    @Basic
    @Column(name = "radiotherapyPartName", nullable = false, length = 100)
    public String getRadiotherapyPartName() {
        return radiotherapyPartName;
    }

    public void setRadiotherapyPartName(String radiotherapyPartName) {
        this.radiotherapyPartName = radiotherapyPartName;
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

        MetaERadiotherapyPart that = (MetaERadiotherapyPart) o;

        if (radiotherapyPartId != null ? !radiotherapyPartId.equals(that.radiotherapyPartId) : that.radiotherapyPartId != null)
            return false;
        if (radiotherapyPartName != null ? !radiotherapyPartName.equals(that.radiotherapyPartName) : that.radiotherapyPartName != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = radiotherapyPartId != null ? radiotherapyPartId.hashCode() : 0;
        result = 31 * result + (radiotherapyPartName != null ? radiotherapyPartName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        return result;
    }
}
