package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_exam_type", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_exam_type_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEExamType {
    private Integer examTypeId;
    private String examTypeName;
    private Integer parentId;
    private Timestamp createTime;
    private Integer flag;
    private Integer reviewFlag;
    private Long creator;
//    private Collection<MetaEExamItem> metaEExamItemsByExamTypeId;

    @Id
    @Column(name = "examTypeId", nullable = false)
    public Integer getExamTypeId() {
        return examTypeId;
    }

    public void setExamTypeId(Integer examTypeId) {
        this.examTypeId = examTypeId;
    }

    @Basic
    @Column(name = "examTypeName", nullable = false, length = 100)
    public String getExamTypeName() {
        return examTypeName;
    }

    public void setExamTypeName(String examTypeName) {
        this.examTypeName = examTypeName;
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
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
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

        MetaEExamType that = (MetaEExamType) o;

        if (examTypeId != null ? !examTypeId.equals(that.examTypeId) : that.examTypeId != null) return false;
        if (examTypeName != null ? !examTypeName.equals(that.examTypeName) : that.examTypeName != null) return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (flag != null ? !flag.equals(that.flag) : that.flag != null) return false;
        if (reviewFlag != null ? !reviewFlag.equals(that.reviewFlag) : that.reviewFlag != null) return false;
        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = examTypeId != null ? examTypeId.hashCode() : 0;
        result = 31 * result + (examTypeName != null ? examTypeName.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (reviewFlag != null ? reviewFlag.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "metaEExamTypeByExamTypeId")
//    public Collection<MetaEExamItem> getMetaEExamItemsByExamTypeId() {
//        return metaEExamItemsByExamTypeId;
//    }
//
//    public void setMetaEExamItemsByExamTypeId(Collection<MetaEExamItem> metaEExamItemsByExamTypeId) {
//        this.metaEExamItemsByExamTypeId = metaEExamItemsByExamTypeId;
//    }
}
