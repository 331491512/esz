package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.util.Collection;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_qualityoflife_scale_item", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_qualityoflife_scale_item_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEQualityoflifeScaleItem {
    private Integer scaleItemId;
    private Integer scaleTypeId;
    private Integer seqNo;
    private String questionTitle;
    private String questionDescription;
//    private MetaEQualityoflifeScale metaEQualityoflifeScaleByScaleTypeId;
//    private Collection<MetaEQualityoflifeScaleItemOptions> metaEQualityoflifeScaleItemOptionsesByScaleItemId;

    @Id
    @Column(name = "scaleItemId", nullable = false)
    public Integer getScaleItemId() {
        return scaleItemId;
    }

    public void setScaleItemId(Integer scaleItemId) {
        this.scaleItemId = scaleItemId;
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
    @Column(name = "seqNo", nullable = false)
    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    @Basic
    @Column(name = "questionTitle", nullable = true, length = 100)
    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    @Basic
    @Column(name = "questionDescription", nullable = false, length = 255)
    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaEQualityoflifeScaleItem that = (MetaEQualityoflifeScaleItem) o;

        if (scaleItemId != null ? !scaleItemId.equals(that.scaleItemId) : that.scaleItemId != null) return false;
        if (scaleTypeId != null ? !scaleTypeId.equals(that.scaleTypeId) : that.scaleTypeId != null) return false;
        if (seqNo != null ? !seqNo.equals(that.seqNo) : that.seqNo != null) return false;
        if (questionTitle != null ? !questionTitle.equals(that.questionTitle) : that.questionTitle != null)
            return false;
        if (questionDescription != null ? !questionDescription.equals(that.questionDescription) : that.questionDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = scaleItemId != null ? scaleItemId.hashCode() : 0;
        result = 31 * result + (scaleTypeId != null ? scaleTypeId.hashCode() : 0);
        result = 31 * result + (seqNo != null ? seqNo.hashCode() : 0);
        result = 31 * result + (questionTitle != null ? questionTitle.hashCode() : 0);
        result = 31 * result + (questionDescription != null ? questionDescription.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "scaleTypeId", referencedColumnName = "scaleTypeId", nullable = false)
//    public MetaEQualityoflifeScale getMetaEQualityoflifeScaleByScaleTypeId() {
//        return metaEQualityoflifeScaleByScaleTypeId;
//    }
//
//    public void setMetaEQualityoflifeScaleByScaleTypeId(MetaEQualityoflifeScale metaEQualityoflifeScaleByScaleTypeId) {
//        this.metaEQualityoflifeScaleByScaleTypeId = metaEQualityoflifeScaleByScaleTypeId;
//    }
//
//    @OneToMany(mappedBy = "metaEQualityoflifeScaleItemByScaleItemId")
//    public Collection<MetaEQualityoflifeScaleItemOptions> getMetaEQualityoflifeScaleItemOptionsesByScaleItemId() {
//        return metaEQualityoflifeScaleItemOptionsesByScaleItemId;
//    }
//
//    public void setMetaEQualityoflifeScaleItemOptionsesByScaleItemId(Collection<MetaEQualityoflifeScaleItemOptions> metaEQualityoflifeScaleItemOptionsesByScaleItemId) {
//        this.metaEQualityoflifeScaleItemOptionsesByScaleItemId = metaEQualityoflifeScaleItemOptionsesByScaleItemId;
//    }
}
