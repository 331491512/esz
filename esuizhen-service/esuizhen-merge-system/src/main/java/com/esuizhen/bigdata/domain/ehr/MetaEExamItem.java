package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_exam_item", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_exam_item_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEExamItem {
    private Integer examItemId;
    private Integer examTypeId;
    private String examItemCode;
    private String examItemName;
    private Long creator;
//    private MetaEExamType metaEExamTypeByExamTypeId;

    @Id
    @Column(name = "examItemId", nullable = false)
    public Integer getExamItemId() {
        return examItemId;
    }

    public void setExamItemId(Integer examItemId) {
        this.examItemId = examItemId;
    }

    @Basic
    @Column(name = "examTypeId", nullable = false)
    public Integer getExamTypeId() {
        return examTypeId;
    }

    public void setExamTypeId(Integer examTypeId) {
        this.examTypeId = examTypeId;
    }

    @Basic
    @Column(name = "examItemCode", nullable = true, length = 30)
    public String getExamItemCode() {
        return examItemCode;
    }

    public void setExamItemCode(String examItemCode) {
        this.examItemCode = examItemCode;
    }

    @Basic
    @Column(name = "examItemName", nullable = false, length = 255)
    public String getExamItemName() {
        return examItemName;
    }

    public void setExamItemName(String examItemName) {
        this.examItemName = examItemName;
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

        MetaEExamItem that = (MetaEExamItem) o;

        if (examItemId != null ? !examItemId.equals(that.examItemId) : that.examItemId != null) return false;
        if (examTypeId != null ? !examTypeId.equals(that.examTypeId) : that.examTypeId != null) return false;
        if (examItemCode != null ? !examItemCode.equals(that.examItemCode) : that.examItemCode != null) return false;
        if (examItemName != null ? !examItemName.equals(that.examItemName) : that.examItemName != null) return false;
        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = examItemId != null ? examItemId.hashCode() : 0;
        result = 31 * result + (examTypeId != null ? examTypeId.hashCode() : 0);
        result = 31 * result + (examItemCode != null ? examItemCode.hashCode() : 0);
        result = 31 * result + (examItemName != null ? examItemName.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "examTypeId", referencedColumnName = "examTypeId", nullable = false)
//    public MetaEExamType getMetaEExamTypeByExamTypeId() {
//        return metaEExamTypeByExamTypeId;
//    }
//
//    public void setMetaEExamTypeByExamTypeId(MetaEExamType metaEExamTypeByExamTypeId) {
//        this.metaEExamTypeByExamTypeId = metaEExamTypeByExamTypeId;
//    }
}
