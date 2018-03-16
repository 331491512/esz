package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_icd_o", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_icd_o_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEIcdO {
    private Integer organId;
    private String organCode;
    private String organName;
    private String mnemonicCode;
    private Timestamp createTime;

    @Id
    @Column(name = "organId", nullable = false)
    public Integer getOrganId() {
        return organId;
    }

    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    @Basic
    @Column(name = "organCode", nullable = false, length = 30)
    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    @Basic
    @Column(name = "organName", nullable = false, length = 100)
    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    @Basic
    @Column(name = "mnemonicCode", nullable = true, length = 30)
    public String getMnemonicCode() {
        return mnemonicCode;
    }

    public void setMnemonicCode(String mnemonicCode) {
        this.mnemonicCode = mnemonicCode;
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

        MetaEIcdO metaEIcdO = (MetaEIcdO) o;

        if (organId != null ? !organId.equals(metaEIcdO.organId) : metaEIcdO.organId != null) return false;
        if (organCode != null ? !organCode.equals(metaEIcdO.organCode) : metaEIcdO.organCode != null) return false;
        if (organName != null ? !organName.equals(metaEIcdO.organName) : metaEIcdO.organName != null) return false;
        if (mnemonicCode != null ? !mnemonicCode.equals(metaEIcdO.mnemonicCode) : metaEIcdO.mnemonicCode != null)
            return false;
        if (createTime != null ? !createTime.equals(metaEIcdO.createTime) : metaEIcdO.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = organId != null ? organId.hashCode() : 0;
        result = 31 * result + (organCode != null ? organCode.hashCode() : 0);
        result = 31 * result + (organName != null ? organName.hashCode() : 0);
        result = 31 * result + (mnemonicCode != null ? mnemonicCode.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
