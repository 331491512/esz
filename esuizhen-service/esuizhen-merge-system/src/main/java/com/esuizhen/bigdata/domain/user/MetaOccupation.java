package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "meta_occupation", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "meta_occupation_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class MetaOccupation {
    private int occupationId;
    private String occupationCode;
    private String parentCode;
    private String occupationName;
    private String description;

    @Id
    @Column(name = "occupationId", nullable = false)
    public int getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(int occupationId) {
        this.occupationId = occupationId;
    }

    @Basic
    @Column(name = "occupationCode", nullable = false, length = 32)
    public String getOccupationCode() {
        return occupationCode;
    }

    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
    }

    @Basic
    @Column(name = "parentCode", nullable = true, length = 32)
    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    @Basic
    @Column(name = "occupationName", nullable = false, length = 64)
    public String getOccupationName() {
        return occupationName;
    }

    public void setOccupationName(String occupationName) {
        this.occupationName = occupationName;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 512)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaOccupation that = (MetaOccupation) o;

        if (occupationId != that.occupationId) return false;
        if (occupationCode != null ? !occupationCode.equals(that.occupationCode) : that.occupationCode != null)
            return false;
        if (parentCode != null ? !parentCode.equals(that.parentCode) : that.parentCode != null) return false;
        if (occupationName != null ? !occupationName.equals(that.occupationName) : that.occupationName != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = occupationId;
        result = 31 * result + (occupationCode != null ? occupationCode.hashCode() : 0);
        result = 31 * result + (parentCode != null ? parentCode.hashCode() : 0);
        result = 31 * result + (occupationName != null ? occupationName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
