package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "meta_nation", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "meta_nation_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class MetaNation {
    private int nationId;
    private String nationCode;
    private String nationName;
    private String romeCode;
    private String pyCode;

    @Id
    @Column(name = "nationId", nullable = false)
    public int getNationId() {
        return nationId;
    }

    public void setNationId(int nationId) {
        this.nationId = nationId;
    }

    @Basic
    @Column(name = "nationCode", nullable = true, length = 32)
    public String getNationCode() {
        return nationCode;
    }

    public void setNationCode(String nationCode) {
        this.nationCode = nationCode;
    }

    @Basic
    @Column(name = "nationName", nullable = false, length = 64)
    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    @Basic
    @Column(name = "romeCode", nullable = false, length = 16)
    public String getRomeCode() {
        return romeCode;
    }

    public void setRomeCode(String romeCode) {
        this.romeCode = romeCode;
    }

    @Basic
    @Column(name = "pyCode", nullable = false, length = 16)
    public String getPyCode() {
        return pyCode;
    }

    public void setPyCode(String pyCode) {
        this.pyCode = pyCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaNation that = (MetaNation) o;

        if (nationId != that.nationId) return false;
        if (nationCode != null ? !nationCode.equals(that.nationCode) : that.nationCode != null) return false;
        if (nationName != null ? !nationName.equals(that.nationName) : that.nationName != null) return false;
        if (romeCode != null ? !romeCode.equals(that.romeCode) : that.romeCode != null) return false;
        if (pyCode != null ? !pyCode.equals(that.pyCode) : that.pyCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nationId;
        result = 31 * result + (nationCode != null ? nationCode.hashCode() : 0);
        result = 31 * result + (nationName != null ? nationName.hashCode() : 0);
        result = 31 * result + (romeCode != null ? romeCode.hashCode() : 0);
        result = 31 * result + (pyCode != null ? pyCode.hashCode() : 0);
        return result;
    }
}
