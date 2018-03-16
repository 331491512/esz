package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_pay_channel", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_pay_channel_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEPayChannel {
    private Integer payChannelId;
    private String payChannelCode;
    private String payChannelName;

    @Id
    @Column(name = "payChannelId", nullable = false)
    public Integer getPayChannelId() {
        return payChannelId;
    }

    public void setPayChannelId(Integer payChannelId) {
        this.payChannelId = payChannelId;
    }

    @Basic
    @Column(name = "payChannelCode", nullable = true, length = 64)
    public String getPayChannelCode() {
        return payChannelCode;
    }

    public void setPayChannelCode(String payChannelCode) {
        this.payChannelCode = payChannelCode;
    }

    @Basic
    @Column(name = "payChannelName", nullable = true, length = 64)
    public String getPayChannelName() {
        return payChannelName;
    }

    public void setPayChannelName(String payChannelName) {
        this.payChannelName = payChannelName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaEPayChannel that = (MetaEPayChannel) o;

        if (payChannelId != null ? !payChannelId.equals(that.payChannelId) : that.payChannelId != null) return false;
        if (payChannelCode != null ? !payChannelCode.equals(that.payChannelCode) : that.payChannelCode != null)
            return false;
        if (payChannelName != null ? !payChannelName.equals(that.payChannelName) : that.payChannelName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = payChannelId != null ? payChannelId.hashCode() : 0;
        result = 31 * result + (payChannelCode != null ? payChannelCode.hashCode() : 0);
        result = 31 * result + (payChannelName != null ? payChannelName.hashCode() : 0);
        return result;
    }
}
