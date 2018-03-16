package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_tumour_periodization", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_tumour_periodization_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaETumourPeriodization {
    private Integer tumourId;
    private String tumourCode;
    private String tumourCodeT;
    private String tumourCodeN;
    private String tumourCodeM1;
    private String tumourCodeM2;

    @Id
    @Column(name = "tumourId", nullable = false)
    public Integer getTumourId() {
        return tumourId;
    }

    public void setTumourId(Integer tumourId) {
        this.tumourId = tumourId;
    }

    @Basic
    @Column(name = "tumourCode", nullable = true, length = 64)
    public String getTumourCode() {
        return tumourCode;
    }

    public void setTumourCode(String tumourCode) {
        this.tumourCode = tumourCode;
    }

    @Basic
    @Column(name = "tumourCodeT", nullable = true, length = 64)
    public String getTumourCodeT() {
        return tumourCodeT;
    }

    public void setTumourCodeT(String tumourCodeT) {
        this.tumourCodeT = tumourCodeT;
    }

    @Basic
    @Column(name = "tumourCodeN", nullable = true, length = 64)
    public String getTumourCodeN() {
        return tumourCodeN;
    }

    public void setTumourCodeN(String tumourCodeN) {
        this.tumourCodeN = tumourCodeN;
    }

    @Basic
    @Column(name = "tumourCodeM1", nullable = true, length = 64)
    public String getTumourCodeM1() {
        return tumourCodeM1;
    }

    public void setTumourCodeM1(String tumourCodeM1) {
        this.tumourCodeM1 = tumourCodeM1;
    }

    @Basic
    @Column(name = "tumourCodeM2", nullable = true, length = 64)
    public String getTumourCodeM2() {
        return tumourCodeM2;
    }

    public void setTumourCodeM2(String tumourCodeM2) {
        this.tumourCodeM2 = tumourCodeM2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaETumourPeriodization that = (MetaETumourPeriodization) o;

        if (tumourId != null ? !tumourId.equals(that.tumourId) : that.tumourId != null) return false;
        if (tumourCode != null ? !tumourCode.equals(that.tumourCode) : that.tumourCode != null) return false;
        if (tumourCodeT != null ? !tumourCodeT.equals(that.tumourCodeT) : that.tumourCodeT != null) return false;
        if (tumourCodeN != null ? !tumourCodeN.equals(that.tumourCodeN) : that.tumourCodeN != null) return false;
        if (tumourCodeM1 != null ? !tumourCodeM1.equals(that.tumourCodeM1) : that.tumourCodeM1 != null) return false;
        if (tumourCodeM2 != null ? !tumourCodeM2.equals(that.tumourCodeM2) : that.tumourCodeM2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tumourId != null ? tumourId.hashCode() : 0;
        result = 31 * result + (tumourCode != null ? tumourCode.hashCode() : 0);
        result = 31 * result + (tumourCodeT != null ? tumourCodeT.hashCode() : 0);
        result = 31 * result + (tumourCodeN != null ? tumourCodeN.hashCode() : 0);
        result = 31 * result + (tumourCodeM1 != null ? tumourCodeM1.hashCode() : 0);
        result = 31 * result + (tumourCodeM2 != null ? tumourCodeM2.hashCode() : 0);
        return result;
    }
}
