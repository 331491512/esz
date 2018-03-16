package com.esuizhen.bigdata.domain.ods;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Nidan on 2016年12月22 上午 10:08
 */
@Entity
@Table(name = "conf_retrieval_parameter", schema = "ods_db", catalog="")
public class TConfRetrievalParameter {
    private int paramentId;
    private String paramentName;
    private String paramentValue;
    private Integer conditionTypeId;
    private Integer parentId;
    private int paramentType;
    private Integer paramentGetType;
    private String paramentContent;
    private String expansion;
    private String description;
    private Integer state;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "paramentId")
    public int getParamentId() {
        return paramentId;
    }

    public void setParamentId(int paramentId) {
        this.paramentId = paramentId;
    }

    @Basic
    @Column(name = "paramentName")
    public String getParamentName() {
        return paramentName;
    }

    public void setParamentName(String paramentName) {
        this.paramentName = paramentName;
    }

    @Basic
    @Column(name = "paramentValue")
    public String getParamentValue() {
        return paramentValue;
    }

    public void setParamentValue(String paramentValue) {
        this.paramentValue = paramentValue;
    }

    @Basic
    @Column(name = "conditionTypeId")
    public Integer getConditionTypeId() {
        return conditionTypeId;
    }

    public void setConditionTypeId(Integer conditionTypeId) {
        this.conditionTypeId = conditionTypeId;
    }

    @Basic
    @Column(name = "parentId")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "paramentType")
    public int getParamentType() {
        return paramentType;
    }

    public void setParamentType(int paramentType) {
        this.paramentType = paramentType;
    }

    @Basic
    @Column(name = "paramentGetType")
    public Integer getParamentGetType() {
        return paramentGetType;
    }

    public void setParamentGetType(Integer paramentGetType) {
        this.paramentGetType = paramentGetType;
    }

    @Basic
    @Column(name = "paramentContent")
    public String getParamentContent() {
        return paramentContent;
    }

    public void setParamentContent(String paramentContent) {
        this.paramentContent = paramentContent;
    }

    @Basic
    @Column(name = "expansion")
    public String getExpansion() {
        return expansion;
    }

    public void setExpansion(String expansion) {
        this.expansion = expansion;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateTime")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TConfRetrievalParameter that = (TConfRetrievalParameter) o;

        if (paramentId != that.paramentId) return false;
        if (paramentType != that.paramentType) return false;
        if (paramentName != null ? !paramentName.equals(that.paramentName) : that.paramentName != null) return false;
        if (paramentValue != null ? !paramentValue.equals(that.paramentValue) : that.paramentValue != null)
            return false;
        if (conditionTypeId != null ? !conditionTypeId.equals(that.conditionTypeId) : that.conditionTypeId != null)
            return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;
        if (paramentGetType != null ? !paramentGetType.equals(that.paramentGetType) : that.paramentGetType != null)
            return false;
        if (paramentContent != null ? !paramentContent.equals(that.paramentContent) : that.paramentContent != null)
            return false;
        if (expansion != null ? !expansion.equals(that.expansion) : that.expansion != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paramentId;
        result = 31 * result + (paramentName != null ? paramentName.hashCode() : 0);
        result = 31 * result + (paramentValue != null ? paramentValue.hashCode() : 0);
        result = 31 * result + (conditionTypeId != null ? conditionTypeId.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + paramentType;
        result = 31 * result + (paramentGetType != null ? paramentGetType.hashCode() : 0);
        result = 31 * result + (paramentContent != null ? paramentContent.hashCode() : 0);
        result = 31 * result + (expansion != null ? expansion.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
