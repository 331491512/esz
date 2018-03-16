package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_qualityoflife_scale_general_options", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_qualityoflife_scale_general_options_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEQualityoflifeScaleGeneralOptions {
    private Integer scaleOptionsId;
    private Integer scaleTypeId;
    private Integer optionIndex;
    private String content;
    private Integer indicateValue;

    @Id
    @Column(name = "scaleOptionsId", nullable = false)
    public Integer getScaleOptionsId() {
        return scaleOptionsId;
    }

    public void setScaleOptionsId(Integer scaleOptionsId) {
        this.scaleOptionsId = scaleOptionsId;
    }

    @Basic
    @Column(name = "scaleTypeId", nullable = false)
    public Integer getScaleTypeId() {
        return scaleTypeId;
    }

    public void setScaleTypeId(Integer scaleTypeId) {
        this.scaleTypeId = scaleTypeId;
    }

    @Basic
    @Column(name = "optionIndex", nullable = false)
    public Integer getOptionIndex() {
        return optionIndex;
    }

    public void setOptionIndex(Integer optionIndex) {
        this.optionIndex = optionIndex;
    }

    @Basic
    @Column(name = "content", nullable = false, length = 255)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "indicateValue", nullable = false)
    public Integer getIndicateValue() {
        return indicateValue;
    }

    public void setIndicateValue(Integer indicateValue) {
        this.indicateValue = indicateValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaEQualityoflifeScaleGeneralOptions that = (MetaEQualityoflifeScaleGeneralOptions) o;

        if (scaleOptionsId != null ? !scaleOptionsId.equals(that.scaleOptionsId) : that.scaleOptionsId != null)
            return false;
        if (scaleTypeId != null ? !scaleTypeId.equals(that.scaleTypeId) : that.scaleTypeId != null) return false;
        if (optionIndex != null ? !optionIndex.equals(that.optionIndex) : that.optionIndex != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (indicateValue != null ? !indicateValue.equals(that.indicateValue) : that.indicateValue != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = scaleOptionsId != null ? scaleOptionsId.hashCode() : 0;
        result = 31 * result + (scaleTypeId != null ? scaleTypeId.hashCode() : 0);
        result = 31 * result + (optionIndex != null ? optionIndex.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (indicateValue != null ? indicateValue.hashCode() : 0);
        return result;
    }
}
