package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "meta_nationality", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "meta_nationality_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class MetaNationality {
    private int nationalityId;
    private String nationalityCode;
    private String nationalityPyCode;
    private String nationalityRomeCode;
    private String nationalityName;

    @Id
    @Column(name = "nationalityId", nullable = false)
    public int getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(int nationalityId) {
        this.nationalityId = nationalityId;
    }

    @Basic
    @Column(name = "nationalityCode", nullable = false, length = 32)
    public String getNationalityCode() {
        return nationalityCode;
    }

    public void setNationalityCode(String nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    @Basic
    @Column(name = "nationalityPyCode", nullable = true, length = 32)
    public String getNationalityPyCode() {
        return nationalityPyCode;
    }

    public void setNationalityPyCode(String nationalityPyCode) {
        this.nationalityPyCode = nationalityPyCode;
    }

    @Basic
    @Column(name = "nationalityRomeCode", nullable = true, length = 32)
    public String getNationalityRomeCode() {
        return nationalityRomeCode;
    }

    public void setNationalityRomeCode(String nationalityRomeCode) {
        this.nationalityRomeCode = nationalityRomeCode;
    }

    @Basic
    @Column(name = "nationalityName", nullable = false, length = 64)
    public String getNationalityName() {
        return nationalityName;
    }

    public void setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaNationality that = (MetaNationality) o;

        if (nationalityId != that.nationalityId) return false;
        if (nationalityCode != null ? !nationalityCode.equals(that.nationalityCode) : that.nationalityCode != null)
            return false;
        if (nationalityPyCode != null ? !nationalityPyCode.equals(that.nationalityPyCode) : that.nationalityPyCode != null)
            return false;
        if (nationalityRomeCode != null ? !nationalityRomeCode.equals(that.nationalityRomeCode) : that.nationalityRomeCode != null)
            return false;
        if (nationalityName != null ? !nationalityName.equals(that.nationalityName) : that.nationalityName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nationalityId;
        result = 31 * result + (nationalityCode != null ? nationalityCode.hashCode() : 0);
        result = 31 * result + (nationalityPyCode != null ? nationalityPyCode.hashCode() : 0);
        result = 31 * result + (nationalityRomeCode != null ? nationalityRomeCode.hashCode() : 0);
        result = 31 * result + (nationalityName != null ? nationalityName.hashCode() : 0);
        return result;
    }
}
