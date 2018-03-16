package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_medication_computing_method", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_medication_computing_method_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEMedicationComputingMethod {
    private Integer computingMethodId;
    private String computingMethodName;
    private String remark;

    @Id
    @Column(name = "computingMethodId", nullable = false)
    public Integer getComputingMethodId() {
        return computingMethodId;
    }

    public void setComputingMethodId(Integer computingMethodId) {
        this.computingMethodId = computingMethodId;
    }

    @Basic
    @Column(name = "computingMethodName", nullable = false, length = 30)
    public String getComputingMethodName() {
        return computingMethodName;
    }

    public void setComputingMethodName(String computingMethodName) {
        this.computingMethodName = computingMethodName;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 100)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaEMedicationComputingMethod that = (MetaEMedicationComputingMethod) o;

        if (computingMethodId != null ? !computingMethodId.equals(that.computingMethodId) : that.computingMethodId != null)
            return false;
        if (computingMethodName != null ? !computingMethodName.equals(that.computingMethodName) : that.computingMethodName != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = computingMethodId != null ? computingMethodId.hashCode() : 0;
        result = 31 * result + (computingMethodName != null ? computingMethodName.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
