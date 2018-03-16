package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "e_search_template_result_detail", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "e_search_template_result_detail_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class ESearchTemplateResultDetail {
    private Integer templateDetailId;
    private Integer templateId;
    private Integer conditionId;
    private String connectKey;
    private String cloumnName;
    private String value;
    private String operator;
    private String startSymbol;
    private String endSymbol;
    private String startMatchSymbol;
    private String endMatchSymbol;
    private String specialDesc;
    private String conditionType;
    private String groupStart;
    private String groupEnd;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "templateDetailId", nullable = false)
    public Integer getTemplateDetailId() {
        return templateDetailId;
    }

    public void setTemplateDetailId(Integer templateDetailId) {
        this.templateDetailId = templateDetailId;
    }

    @Basic
    @Column(name = "templateId", nullable = false)
    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    @Basic
    @Column(name = "conditionId", nullable = false)
    public Integer getConditionId() {
        return conditionId;
    }

    public void setConditionId(Integer conditionId) {
        this.conditionId = conditionId;
    }

    @Basic
    @Column(name = "connectKey", nullable = false, length = 32)
    public String getConnectKey() {
        return connectKey;
    }

    public void setConnectKey(String connectKey) {
        this.connectKey = connectKey;
    }

    @Basic
    @Column(name = "cloumnName", nullable = false, length = 32)
    public String getCloumnName() {
        return cloumnName;
    }

    public void setCloumnName(String cloumnName) {
        this.cloumnName = cloumnName;
    }

    @Basic
    @Column(name = "value", nullable = false, length = 128)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "operator", nullable = false, length = 16)
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
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
    @Column(name = "startMatchSymbol", nullable = true, length = 16)
    public String getStartMatchSymbol() {
        return startMatchSymbol;
    }

    public void setStartMatchSymbol(String startMatchSymbol) {
        this.startMatchSymbol = startMatchSymbol;
    }

    @Basic
    @Column(name = "endMatchSymbol", nullable = true, length = 16)
    public String getEndMatchSymbol() {
        return endMatchSymbol;
    }

    public void setEndMatchSymbol(String endMatchSymbol) {
        this.endMatchSymbol = endMatchSymbol;
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
    @Column(name = "conditionType", nullable = true, length = 32)
    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    @Basic
    @Column(name = "groupStart", nullable = true, length = 32)
    public String getGroupStart() {
        return groupStart;
    }

    public void setGroupStart(String groupStart) {
        this.groupStart = groupStart;
    }

    @Basic
    @Column(name = "groupEnd", nullable = true, length = 32)
    public String getGroupEnd() {
        return groupEnd;
    }

    public void setGroupEnd(String groupEnd) {
        this.groupEnd = groupEnd;
    }

    @Basic
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateTime", nullable = false)
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

        ESearchTemplateResultDetail that = (ESearchTemplateResultDetail) o;

        if (templateDetailId != null ? !templateDetailId.equals(that.templateDetailId) : that.templateDetailId != null)
            return false;
        if (templateId != null ? !templateId.equals(that.templateId) : that.templateId != null) return false;
        if (conditionId != null ? !conditionId.equals(that.conditionId) : that.conditionId != null) return false;
        if (connectKey != null ? !connectKey.equals(that.connectKey) : that.connectKey != null) return false;
        if (cloumnName != null ? !cloumnName.equals(that.cloumnName) : that.cloumnName != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (startSymbol != null ? !startSymbol.equals(that.startSymbol) : that.startSymbol != null) return false;
        if (endSymbol != null ? !endSymbol.equals(that.endSymbol) : that.endSymbol != null) return false;
        if (startMatchSymbol != null ? !startMatchSymbol.equals(that.startMatchSymbol) : that.startMatchSymbol != null)
            return false;
        if (endMatchSymbol != null ? !endMatchSymbol.equals(that.endMatchSymbol) : that.endMatchSymbol != null)
            return false;
        if (specialDesc != null ? !specialDesc.equals(that.specialDesc) : that.specialDesc != null) return false;
        if (conditionType != null ? !conditionType.equals(that.conditionType) : that.conditionType != null)
            return false;
        if (groupStart != null ? !groupStart.equals(that.groupStart) : that.groupStart != null) return false;
        if (groupEnd != null ? !groupEnd.equals(that.groupEnd) : that.groupEnd != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = templateDetailId != null ? templateDetailId.hashCode() : 0;
        result = 31 * result + (templateId != null ? templateId.hashCode() : 0);
        result = 31 * result + (conditionId != null ? conditionId.hashCode() : 0);
        result = 31 * result + (connectKey != null ? connectKey.hashCode() : 0);
        result = 31 * result + (cloumnName != null ? cloumnName.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (startSymbol != null ? startSymbol.hashCode() : 0);
        result = 31 * result + (endSymbol != null ? endSymbol.hashCode() : 0);
        result = 31 * result + (startMatchSymbol != null ? startMatchSymbol.hashCode() : 0);
        result = 31 * result + (endMatchSymbol != null ? endMatchSymbol.hashCode() : 0);
        result = 31 * result + (specialDesc != null ? specialDesc.hashCode() : 0);
        result = 31 * result + (conditionType != null ? conditionType.hashCode() : 0);
        result = 31 * result + (groupStart != null ? groupStart.hashCode() : 0);
        result = 31 * result + (groupEnd != null ? groupEnd.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
