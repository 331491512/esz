package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_condition", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_condition_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaCondition {
    private Integer conditionId;
    private String bussinessType;
    private String showName;
    private String cloumnName;
    private String startSymbol;
    private String endSymbol;
    private Integer parentId;
    private Integer isConnection;
    private String conditionType;
    private String specialDesc;
    private Integer isShow;
    private Timestamp createTime;

    @Id
    @Column(name = "conditionId", nullable = false)
    public Integer getConditionId() {
        return conditionId;
    }

    public void setConditionId(Integer conditionId) {
        this.conditionId = conditionId;
    }

    @Basic
    @Column(name = "bussinessType", nullable = false, length = 32)
    public String getBussinessType() {
        return bussinessType;
    }

    public void setBussinessType(String bussinessType) {
        this.bussinessType = bussinessType;
    }

    @Basic
    @Column(name = "showName", nullable = false, length = 32)
    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    @Basic
    @Column(name = "cloumnName", nullable = false, length = 64)
    public String getCloumnName() {
        return cloumnName;
    }

    public void setCloumnName(String cloumnName) {
        this.cloumnName = cloumnName;
    }

    @Basic
    @Column(name = "startSymbol", nullable = true, length = 16)
    public String getStartSymbol() {
        return startSymbol;
    }

    public void setStartSymbol(String startSymbol) {
        this.startSymbol = startSymbol;
    }

    @Basic
    @Column(name = "endSymbol", nullable = true, length = 16)
    public String getEndSymbol() {
        return endSymbol;
    }

    public void setEndSymbol(String endSymbol) {
        this.endSymbol = endSymbol;
    }

    @Basic
    @Column(name = "parentId", nullable = true)
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "isConnection", nullable = false)
    public Integer getIsConnection() {
        return isConnection;
    }

    public void setIsConnection(Integer isConnection) {
        this.isConnection = isConnection;
    }

    @Basic
    @Column(name = "conditionType", nullable = true, length = 32)
    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    @Basic
    @Column(name = "specialDesc", nullable = true, length = 32)
    public String getSpecialDesc() {
        return specialDesc;
    }

    public void setSpecialDesc(String specialDesc) {
        this.specialDesc = specialDesc;
    }

    @Basic
    @Column(name = "isShow", nullable = true)
    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
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

        MetaCondition that = (MetaCondition) o;

        if (conditionId != null ? !conditionId.equals(that.conditionId) : that.conditionId != null) return false;
        if (bussinessType != null ? !bussinessType.equals(that.bussinessType) : that.bussinessType != null)
            return false;
        if (showName != null ? !showName.equals(that.showName) : that.showName != null) return false;
        if (cloumnName != null ? !cloumnName.equals(that.cloumnName) : that.cloumnName != null) return false;
        if (startSymbol != null ? !startSymbol.equals(that.startSymbol) : that.startSymbol != null) return false;
        if (endSymbol != null ? !endSymbol.equals(that.endSymbol) : that.endSymbol != null) return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;
        if (isConnection != null ? !isConnection.equals(that.isConnection) : that.isConnection != null) return false;
        if (conditionType != null ? !conditionType.equals(that.conditionType) : that.conditionType != null)
            return false;
        if (specialDesc != null ? !specialDesc.equals(that.specialDesc) : that.specialDesc != null) return false;
        if (isShow != null ? !isShow.equals(that.isShow) : that.isShow != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = conditionId != null ? conditionId.hashCode() : 0;
        result = 31 * result + (bussinessType != null ? bussinessType.hashCode() : 0);
        result = 31 * result + (showName != null ? showName.hashCode() : 0);
        result = 31 * result + (cloumnName != null ? cloumnName.hashCode() : 0);
        result = 31 * result + (startSymbol != null ? startSymbol.hashCode() : 0);
        result = 31 * result + (endSymbol != null ? endSymbol.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (isConnection != null ? isConnection.hashCode() : 0);
        result = 31 * result + (conditionType != null ? conditionType.hashCode() : 0);
        result = 31 * result + (specialDesc != null ? specialDesc.hashCode() : 0);
        result = 31 * result + (isShow != null ? isShow.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
