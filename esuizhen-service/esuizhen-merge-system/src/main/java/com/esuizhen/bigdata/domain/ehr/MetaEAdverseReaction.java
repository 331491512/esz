package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_adverse_reaction", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_adverse_reaction_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEAdverseReaction {
    private Integer adverseReactionId;
    private String adverseReactionName;
    private Timestamp createTime;
    private Long creator;
    private String grade1;
    private String grade2;
    private String grade3;
    private String grade4;
    private String grade5;

    @Id
    @Column(name = "adverseReactionId", nullable = false)
    public Integer getAdverseReactionId() {
        return adverseReactionId;
    }

    public void setAdverseReactionId(Integer adverseReactionId) {
        this.adverseReactionId = adverseReactionId;
    }

    @Basic
    @Column(name = "adverseReactionName", nullable = false, length = 255)
    public String getAdverseReactionName() {
        return adverseReactionName;
    }

    public void setAdverseReactionName(String adverseReactionName) {
        this.adverseReactionName = adverseReactionName;
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

    @Basic
    @Column(name = "grade1", nullable = true, length = 255)
    public String getGrade1() {
        return grade1;
    }

    public void setGrade1(String grade1) {
        this.grade1 = grade1;
    }

    @Basic
    @Column(name = "grade2", nullable = true, length = 255)
    public String getGrade2() {
        return grade2;
    }

    public void setGrade2(String grade2) {
        this.grade2 = grade2;
    }

    @Basic
    @Column(name = "grade3", nullable = true, length = 255)
    public String getGrade3() {
        return grade3;
    }

    public void setGrade3(String grade3) {
        this.grade3 = grade3;
    }

    @Basic
    @Column(name = "grade4", nullable = true, length = 255)
    public String getGrade4() {
        return grade4;
    }

    public void setGrade4(String grade4) {
        this.grade4 = grade4;
    }

    @Basic
    @Column(name = "grade5", nullable = true, length = 255)
    public String getGrade5() {
        return grade5;
    }

    public void setGrade5(String grade5) {
        this.grade5 = grade5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaEAdverseReaction that = (MetaEAdverseReaction) o;

        if (adverseReactionId != null ? !adverseReactionId.equals(that.adverseReactionId) : that.adverseReactionId != null)
            return false;
        if (adverseReactionName != null ? !adverseReactionName.equals(that.adverseReactionName) : that.adverseReactionName != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;
        if (grade1 != null ? !grade1.equals(that.grade1) : that.grade1 != null) return false;
        if (grade2 != null ? !grade2.equals(that.grade2) : that.grade2 != null) return false;
        if (grade3 != null ? !grade3.equals(that.grade3) : that.grade3 != null) return false;
        if (grade4 != null ? !grade4.equals(that.grade4) : that.grade4 != null) return false;
        if (grade5 != null ? !grade5.equals(that.grade5) : that.grade5 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adverseReactionId != null ? adverseReactionId.hashCode() : 0;
        result = 31 * result + (adverseReactionName != null ? adverseReactionName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        result = 31 * result + (grade1 != null ? grade1.hashCode() : 0);
        result = 31 * result + (grade2 != null ? grade2.hashCode() : 0);
        result = 31 * result + (grade3 != null ? grade3.hashCode() : 0);
        result = 31 * result + (grade4 != null ? grade4.hashCode() : 0);
        result = 31 * result + (grade5 != null ? grade5.hashCode() : 0);
        return result;
    }
}
