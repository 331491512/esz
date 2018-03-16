package com.esuizhen.bigdata.domain.followup;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name = "meta_special_disease_treatment", schema = "followup_db", catalog="")
//@Audited
//@AuditTable(value = "meta_special_disease_treatment_audit",schema = "followup_db_audit",catalog = "followup_db_audit")
public class MetaSpecialDiseaseTreatment {
    private int sdtId;
    private String sdtName;
    private Timestamp createTime;

    @Id
    @Column(name = "sdtId", nullable = false)
    public int getSdtId() {
        return sdtId;
    }

    public void setSdtId(int sdtId) {
        this.sdtId = sdtId;
    }

    @Basic
    @Column(name = "sdtName", nullable = true, length = 60)
    public String getSdtName() {
        return sdtName;
    }

    public void setSdtName(String sdtName) {
        this.sdtName = sdtName;
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

        MetaSpecialDiseaseTreatment that = (MetaSpecialDiseaseTreatment) o;

        if (sdtId != that.sdtId) return false;
        if (sdtName != null ? !sdtName.equals(that.sdtName) : that.sdtName != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sdtId;
        result = 31 * result + (sdtName != null ? sdtName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
