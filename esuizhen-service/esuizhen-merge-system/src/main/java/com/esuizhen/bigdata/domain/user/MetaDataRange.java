package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "meta_data_range", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "meta_data_range_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class MetaDataRange {
    private int dataId;
    private String dataName;
    private String remark;

    @Id
    @Column(name = "dataId", nullable = false)
    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    @Basic
    @Column(name = "dataName", nullable = false, length = 50)
    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
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

        MetaDataRange that = (MetaDataRange) o;

        if (dataId != that.dataId) return false;
        if (dataName != null ? !dataName.equals(that.dataName) : that.dataName != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dataId;
        result = 31 * result + (dataName != null ? dataName.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
