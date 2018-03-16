package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_icd_9_cm3", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_icd_9_cm3_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEIcd9Cm3 {
    private Integer opId;
    private String opCode;
    private String opName;
    private String mnemonicCode;
    private Timestamp createTime;

    @Id
    @Column(name = "opId", nullable = false)
    public Integer getOpId() {
        return opId;
    }

    public void setOpId(Integer opId) {
        this.opId = opId;
    }

    @Basic
    @Column(name = "opCode", nullable = false, length = 30)
    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    @Basic
    @Column(name = "opName", nullable = false, length = 255)
    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
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
    @Column(name = "createTime", nullable = true)
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

        MetaEIcd9Cm3 that = (MetaEIcd9Cm3) o;

        if (opId != null ? !opId.equals(that.opId) : that.opId != null) return false;
        if (opCode != null ? !opCode.equals(that.opCode) : that.opCode != null) return false;
        if (opName != null ? !opName.equals(that.opName) : that.opName != null) return false;
        if (mnemonicCode != null ? !mnemonicCode.equals(that.mnemonicCode) : that.mnemonicCode != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = opId != null ? opId.hashCode() : 0;
        result = 31 * result + (opCode != null ? opCode.hashCode() : 0);
        result = 31 * result + (opName != null ? opName.hashCode() : 0);
        result = 31 * result + (mnemonicCode != null ? mnemonicCode.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
