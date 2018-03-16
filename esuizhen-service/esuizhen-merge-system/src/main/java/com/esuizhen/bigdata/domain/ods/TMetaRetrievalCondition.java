package com.esuizhen.bigdata.domain.ods;

import javax.persistence.*;

/**
 * Created by Nidan on 2016年12月22 上午 10:08
 */
@Entity
@Table(name = "meta_retrieval_condition", schema = "ods_db", catalog="")
public class TMetaRetrievalCondition {
    private int conditionId;
    private String conditionName;
    private String remark;

    @Id
    @Column(name = "conditionId")
    public int getConditionId() {
        return conditionId;
    }

    public void setConditionId(int conditionId) {
        this.conditionId = conditionId;
    }

    @Basic
    @Column(name = "conditionName")
    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    @Basic
    @Column(name = "remark")
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

        TMetaRetrievalCondition that = (TMetaRetrievalCondition) o;

        if (conditionId != that.conditionId) return false;
        if (conditionName != null ? !conditionName.equals(that.conditionName) : that.conditionName != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = conditionId;
        result = 31 * result + (conditionName != null ? conditionName.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
