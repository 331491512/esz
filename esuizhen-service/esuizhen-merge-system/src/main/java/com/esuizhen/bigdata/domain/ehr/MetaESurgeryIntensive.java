package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_surgery_intensive", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_surgery_intensive_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaESurgeryIntensive {
    private Integer surgeryId;
    private String surgeryCode;
    private String surgeryName;

    @Id
    @Column(name = "surgeryId", nullable = false)
    public Integer getSurgeryId() {
        return surgeryId;
    }

    public void setSurgeryId(Integer surgeryId) {
        this.surgeryId = surgeryId;
    }

    @Basic
    @Column(name = "surgeryCode", nullable = true, length = 64)
    public String getSurgeryCode() {
        return surgeryCode;
    }

    public void setSurgeryCode(String surgeryCode) {
        this.surgeryCode = surgeryCode;
    }

    @Basic
    @Column(name = "surgeryName", nullable = true, length = 64)
    public String getSurgeryName() {
        return surgeryName;
    }

    public void setSurgeryName(String surgeryName) {
        this.surgeryName = surgeryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaESurgeryIntensive that = (MetaESurgeryIntensive) o;

        if (surgeryId != null ? !surgeryId.equals(that.surgeryId) : that.surgeryId != null) return false;
        if (surgeryCode != null ? !surgeryCode.equals(that.surgeryCode) : that.surgeryCode != null) return false;
        if (surgeryName != null ? !surgeryName.equals(that.surgeryName) : that.surgeryName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = surgeryId != null ? surgeryId.hashCode() : 0;
        result = 31 * result + (surgeryCode != null ? surgeryCode.hashCode() : 0);
        result = 31 * result + (surgeryName != null ? surgeryName.hashCode() : 0);
        return result;
    }
}
