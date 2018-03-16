package com.esuizhen.bigdata.domain.ods;

import javax.persistence.*;

/**
 * Created by Nidan on 2016年12月22 上午 10:08
 */
@Entity
@Table(name = "meta_retrieval_condition_type", schema = "ods_db", catalog="")
public class TMetaRetrievalConditionType {
    private int conditionTypeId;
    private String conditionTypeName;
    private String conditionIds;
    private String remark;

    @Id
    @Column(name = "conditionTypeId")
    public int getConditionTypeId() {
        return conditionTypeId;
    }

    public void setConditionTypeId(int conditionTypeId) {
        this.conditionTypeId = conditionTypeId;
    }

    @Basic
    @Column(name = "conditionTypeName")
    public String getConditionTypeName() {
        return conditionTypeName;
    }

    public void setConditionTypeName(String conditionTypeName) {
        this.conditionTypeName = conditionTypeName;
    }

    @Basic
    @Column(name = "conditionIds")
    public String getConditionIds() {
        return conditionIds;
    }

    public void setConditionIds(String conditionIds) {
        this.conditionIds = conditionIds;
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

        TMetaRetrievalConditionType that = (TMetaRetrievalConditionType) o;

        if (conditionTypeId != that.conditionTypeId) return false;
        if (conditionTypeName != null ? !conditionTypeName.equals(that.conditionTypeName) : that.conditionTypeName != null)
            return false;
        if (conditionIds != null ? !conditionIds.equals(that.conditionIds) : that.conditionIds != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = conditionTypeId;
        result = 31 * result + (conditionTypeName != null ? conditionTypeName.hashCode() : 0);
        result = 31 * result + (conditionIds != null ? conditionIds.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
