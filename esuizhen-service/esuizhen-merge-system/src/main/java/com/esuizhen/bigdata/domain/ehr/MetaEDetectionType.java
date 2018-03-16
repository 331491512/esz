package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_detection_type", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_detection_type_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEDetectionType {
    private Integer detectionTypeId;
    private String detectionTypeName;
    private Integer parentId;
    private Timestamp createTime;
    private Integer reviewFlag;
    private Long creator;

    @Id
    @Column(name = "detectionTypeId", nullable = false)
    public Integer getDetectionTypeId() {
        return detectionTypeId;
    }

    public void setDetectionTypeId(Integer detectionTypeId) {
        this.detectionTypeId = detectionTypeId;
    }

    @Basic
    @Column(name = "detectionTypeName", nullable = false, length = 100)
    public String getDetectionTypeName() {
        return detectionTypeName;
    }

    public void setDetectionTypeName(String detectionTypeName) {
        this.detectionTypeName = detectionTypeName;
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
    @Column(name = "createTime", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "reviewFlag", nullable = true)
    public Integer getReviewFlag() {
        return reviewFlag;
    }

    public void setReviewFlag(Integer reviewFlag) {
        this.reviewFlag = reviewFlag;
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

        MetaEDetectionType that = (MetaEDetectionType) o;

        if (detectionTypeId != null ? !detectionTypeId.equals(that.detectionTypeId) : that.detectionTypeId != null)
            return false;
        if (detectionTypeName != null ? !detectionTypeName.equals(that.detectionTypeName) : that.detectionTypeName != null)
            return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (reviewFlag != null ? !reviewFlag.equals(that.reviewFlag) : that.reviewFlag != null) return false;
        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = detectionTypeId != null ? detectionTypeId.hashCode() : 0;
        result = 31 * result + (detectionTypeName != null ? detectionTypeName.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (reviewFlag != null ? reviewFlag.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        return result;
    }
}
