package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_detection_item", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_detection_item_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEDetectionItem {
    private Integer detectionItemId;
    private Integer detectionTypeId;
    private String detectionItemName;
    private String detectionItemEnglishName;
    private String unit;
    private Double refrenceRangeMin;
    private Double refrenceRangeMax;
    private String detectionWay;
    private String vendor;
    private Integer flag;
    private Timestamp createTime;
    private Long creator;

    @Id
    @Column(name = "detectionItemId", nullable = false)
    public Integer getDetectionItemId() {
        return detectionItemId;
    }

    public void setDetectionItemId(Integer detectionItemId) {
        this.detectionItemId = detectionItemId;
    }

    @Basic
    @Column(name = "detectionTypeId", nullable = false)
    public Integer getDetectionTypeId() {
        return detectionTypeId;
    }

    public void setDetectionTypeId(Integer detectionTypeId) {
        this.detectionTypeId = detectionTypeId;
    }

    @Basic
    @Column(name = "detectionItemName", nullable = false, length = 255)
    public String getDetectionItemName() {
        return detectionItemName;
    }

    public void setDetectionItemName(String detectionItemName) {
        this.detectionItemName = detectionItemName;
    }

    @Basic
    @Column(name = "detectionItemEnglishName", nullable = true, length = 255)
    public String getDetectionItemEnglishName() {
        return detectionItemEnglishName;
    }

    public void setDetectionItemEnglishName(String detectionItemEnglishName) {
        this.detectionItemEnglishName = detectionItemEnglishName;
    }

    @Basic
    @Column(name = "unit", nullable = true, length = 30)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "refrenceRangeMin", nullable = true, precision = 0)
    public Double getRefrenceRangeMin() {
        return refrenceRangeMin;
    }

    public void setRefrenceRangeMin(Double refrenceRangeMin) {
        this.refrenceRangeMin = refrenceRangeMin;
    }

    @Basic
    @Column(name = "refrenceRangeMax", nullable = true, precision = 0)
    public Double getRefrenceRangeMax() {
        return refrenceRangeMax;
    }

    public void setRefrenceRangeMax(Double refrenceRangeMax) {
        this.refrenceRangeMax = refrenceRangeMax;
    }

    @Basic
    @Column(name = "detectionWay", nullable = true, length = 45)
    public String getDetectionWay() {
        return detectionWay;
    }

    public void setDetectionWay(String detectionWay) {
        this.detectionWay = detectionWay;
    }

    @Basic
    @Column(name = "vendor", nullable = true, length = 50)
    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Basic
    @Column(name = "flag", nullable = false)
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "createTime", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "creator", nullable = true)
    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaEDetectionItem that = (MetaEDetectionItem) o;

        if (detectionItemId != null ? !detectionItemId.equals(that.detectionItemId) : that.detectionItemId != null)
            return false;
        if (detectionTypeId != null ? !detectionTypeId.equals(that.detectionTypeId) : that.detectionTypeId != null)
            return false;
        if (detectionItemName != null ? !detectionItemName.equals(that.detectionItemName) : that.detectionItemName != null)
            return false;
        if (detectionItemEnglishName != null ? !detectionItemEnglishName.equals(that.detectionItemEnglishName) : that.detectionItemEnglishName != null)
            return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        if (refrenceRangeMin != null ? !refrenceRangeMin.equals(that.refrenceRangeMin) : that.refrenceRangeMin != null)
            return false;
        if (refrenceRangeMax != null ? !refrenceRangeMax.equals(that.refrenceRangeMax) : that.refrenceRangeMax != null)
            return false;
        if (detectionWay != null ? !detectionWay.equals(that.detectionWay) : that.detectionWay != null) return false;
        if (vendor != null ? !vendor.equals(that.vendor) : that.vendor != null) return false;
        if (flag != null ? !flag.equals(that.flag) : that.flag != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = detectionItemId != null ? detectionItemId.hashCode() : 0;
        result = 31 * result + (detectionTypeId != null ? detectionTypeId.hashCode() : 0);
        result = 31 * result + (detectionItemName != null ? detectionItemName.hashCode() : 0);
        result = 31 * result + (detectionItemEnglishName != null ? detectionItemEnglishName.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (refrenceRangeMin != null ? refrenceRangeMin.hashCode() : 0);
        result = 31 * result + (refrenceRangeMax != null ? refrenceRangeMax.hashCode() : 0);
        result = 31 * result + (detectionWay != null ? detectionWay.hashCode() : 0);
        result = 31 * result + (vendor != null ? vendor.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        return result;
    }
}
