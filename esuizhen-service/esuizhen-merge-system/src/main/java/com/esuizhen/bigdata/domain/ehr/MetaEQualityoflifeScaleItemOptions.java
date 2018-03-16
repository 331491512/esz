package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_qualityoflife_scale_item_options", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_qualityoflife_scale_item_options_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEQualityoflifeScaleItemOptions {
    private Integer scaleOptionsId;
    private Integer scaleItemId;
    private Integer optionIndex;
    private String content;
    private Integer indicateValue;
//    private MetaEQualityoflifeScaleItem metaEQualityoflifeScaleItemByScaleItemId;

    @Id
    @Column(name = "scaleOptionsId", nullable = false)
    public Integer getScaleOptionsId() {
        return scaleOptionsId;
    }

    public void setScaleOptionsId(Integer scaleOptionsId) {
        this.scaleOptionsId = scaleOptionsId;
    }

    @Basic
    @Column(name = "scaleItemId", nullable = false)
    public Integer getScaleItemId() {
        return scaleItemId;
    }

    public void setScaleItemId(Integer scaleItemId) {
        this.scaleItemId = scaleItemId;
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

        MetaEQualityoflifeScaleItemOptions that = (MetaEQualityoflifeScaleItemOptions) o;

        if (scaleOptionsId != null ? !scaleOptionsId.equals(that.scaleOptionsId) : that.scaleOptionsId != null)
            return false;
        if (scaleItemId != null ? !scaleItemId.equals(that.scaleItemId) : that.scaleItemId != null) return false;
        if (optionIndex != null ? !optionIndex.equals(that.optionIndex) : that.optionIndex != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (indicateValue != null ? !indicateValue.equals(that.indicateValue) : that.indicateValue != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = scaleOptionsId != null ? scaleOptionsId.hashCode() : 0;
        result = 31 * result + (scaleItemId != null ? scaleItemId.hashCode() : 0);
        result = 31 * result + (optionIndex != null ? optionIndex.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (indicateValue != null ? indicateValue.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "scaleItemId", referencedColumnName = "scaleItemId", nullable = false)
//    public MetaEQualityoflifeScaleItem getMetaEQualityoflifeScaleItemByScaleItemId() {
//        return metaEQualityoflifeScaleItemByScaleItemId;
//    }
//
//    public void setMetaEQualityoflifeScaleItemByScaleItemId(MetaEQualityoflifeScaleItem metaEQualityoflifeScaleItemByScaleItemId) {
//        this.metaEQualityoflifeScaleItemByScaleItemId = metaEQualityoflifeScaleItemByScaleItemId;
//    }
}
