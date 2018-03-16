package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_qualityoflife_scale", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_qualityoflife_scale_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEQualityoflifeScale {
    private Integer scaleTypeId;
    private String scaleTypeName;
    private String remark;
    private Integer isUseGeneralOptions;
    private Timestamp createTime;
    private Long creator;
//    private Collection<MetaEQualityoflifeScaleItem> metaEQualityoflifeScaleItemsByScaleTypeId;

    @Id
    @Column(name = "scaleTypeId", nullable = false)
    public Integer getScaleTypeId() {
        return scaleTypeId;
    }

    public void setScaleTypeId(Integer scaleTypeId) {
        this.scaleTypeId = scaleTypeId;
    }

    @Basic
    @Column(name = "scaleTypeName", nullable = false, length = 100)
    public String getScaleTypeName() {
        return scaleTypeName;
    }

    public void setScaleTypeName(String scaleTypeName) {
        this.scaleTypeName = scaleTypeName;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "isUseGeneralOptions", nullable = false)
    public Integer getIsUseGeneralOptions() {
        return isUseGeneralOptions;
    }

    public void setIsUseGeneralOptions(Integer isUseGeneralOptions) {
        this.isUseGeneralOptions = isUseGeneralOptions;
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
    @Column(name = "creator", nullable = false)
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

        MetaEQualityoflifeScale that = (MetaEQualityoflifeScale) o;

        if (scaleTypeId != null ? !scaleTypeId.equals(that.scaleTypeId) : that.scaleTypeId != null) return false;
        if (scaleTypeName != null ? !scaleTypeName.equals(that.scaleTypeName) : that.scaleTypeName != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (isUseGeneralOptions != null ? !isUseGeneralOptions.equals(that.isUseGeneralOptions) : that.isUseGeneralOptions != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = scaleTypeId != null ? scaleTypeId.hashCode() : 0;
        result = 31 * result + (scaleTypeName != null ? scaleTypeName.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (isUseGeneralOptions != null ? isUseGeneralOptions.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "metaEQualityoflifeScaleByScaleTypeId")
//    public Collection<MetaEQualityoflifeScaleItem> getMetaEQualityoflifeScaleItemsByScaleTypeId() {
//        return metaEQualityoflifeScaleItemsByScaleTypeId;
//    }
//
//    public void setMetaEQualityoflifeScaleItemsByScaleTypeId(Collection<MetaEQualityoflifeScaleItem> metaEQualityoflifeScaleItemsByScaleTypeId) {
//        this.metaEQualityoflifeScaleItemsByScaleTypeId = metaEQualityoflifeScaleItemsByScaleTypeId;
//    }
}
