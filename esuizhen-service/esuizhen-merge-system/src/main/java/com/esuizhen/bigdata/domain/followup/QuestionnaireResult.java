package com.esuizhen.bigdata.domain.followup;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name = "questionnaire_result", schema = "followup_db", catalog="")
//@Audited
//@AuditTable(value = "questionnaire_result_audit",schema = "followup_db_audit",catalog = "followup_db_audit")
public class QuestionnaireResult {
    private String questionnaireResultId;
    private String questionnaireId;
    private long patientId;
    private Long creatorId;
    private int creatorRole;
    private String questionnaireResultUrl;
    private String followupItemId;
    private Timestamp createTime;
    private Timestamp updateTime;
//    private Questionnaire questionnaireByQuestionnaireId;
//    private Collection<QuestionnaireResultStem> questionnaireResultStemsByQuestionnaireResultId;

    @Id
    @Column(name = "questionnaireResultId", nullable = false, length = 100)
    public String getQuestionnaireResultId() {
        return questionnaireResultId;
    }

    public void setQuestionnaireResultId(String questionnaireResultId) {
        this.questionnaireResultId = questionnaireResultId;
    }

    @Basic
    @Column(name = "questionnaireId", nullable = false, length = 100)
    public String getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(String questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    @Basic
    @Column(name = "patientId", nullable = false)
    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "creatorId", nullable = true)
    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    @Basic
    @Column(name = "creatorRole", nullable = false)
    public int getCreatorRole() {
        return creatorRole;
    }

    public void setCreatorRole(int creatorRole) {
        this.creatorRole = creatorRole;
    }

    @Basic
    @Column(name = "questionnaireResultUrl", nullable = true, length = 256)
    public String getQuestionnaireResultUrl() {
        return questionnaireResultUrl;
    }

    public void setQuestionnaireResultUrl(String questionnaireResultUrl) {
        this.questionnaireResultUrl = questionnaireResultUrl;
    }

    @Basic
    @Column(name = "followupItemId", nullable = true, length = 50)
    public String getFollowupItemId() {
        return followupItemId;
    }

    public void setFollowupItemId(String followupItemId) {
        this.followupItemId = followupItemId;
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

        QuestionnaireResult that = (QuestionnaireResult) o;

        if (patientId != that.patientId) return false;
        if (creatorRole != that.creatorRole) return false;
        if (questionnaireResultId != null ? !questionnaireResultId.equals(that.questionnaireResultId) : that.questionnaireResultId != null)
            return false;
        if (questionnaireId != null ? !questionnaireId.equals(that.questionnaireId) : that.questionnaireId != null)
            return false;
        if (creatorId != null ? !creatorId.equals(that.creatorId) : that.creatorId != null) return false;
        if (questionnaireResultUrl != null ? !questionnaireResultUrl.equals(that.questionnaireResultUrl) : that.questionnaireResultUrl != null)
            return false;
        if (followupItemId != null ? !followupItemId.equals(that.followupItemId) : that.followupItemId != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionnaireResultId != null ? questionnaireResultId.hashCode() : 0;
        result = 31 * result + (questionnaireId != null ? questionnaireId.hashCode() : 0);
        result = 31 * result + (int) (patientId ^ (patientId >>> 32));
        result = 31 * result + (creatorId != null ? creatorId.hashCode() : 0);
        result = 31 * result + creatorRole;
        result = 31 * result + (questionnaireResultUrl != null ? questionnaireResultUrl.hashCode() : 0);
        result = 31 * result + (followupItemId != null ? followupItemId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "questionnaireId", referencedColumnName = "questionnaireId", nullable = false, insertable = false, updatable = false)
//    public Questionnaire getQuestionnaireByQuestionnaireId() {
//        return questionnaireByQuestionnaireId;
//    }
//
//    public void setQuestionnaireByQuestionnaireId(Questionnaire questionnaireByQuestionnaireId) {
//        this.questionnaireByQuestionnaireId = questionnaireByQuestionnaireId;
//    }

//    @OneToMany(mappedBy = "questionnaireResultByQuestionnaireResultId")
//    public Collection<QuestionnaireResultStem> getQuestionnaireResultStemsByQuestionnaireResultId() {
//        return questionnaireResultStemsByQuestionnaireResultId;
//    }
//
//    public void setQuestionnaireResultStemsByQuestionnaireResultId(Collection<QuestionnaireResultStem> questionnaireResultStemsByQuestionnaireResultId) {
//        this.questionnaireResultStemsByQuestionnaireResultId = questionnaireResultStemsByQuestionnaireResultId;
//    }
}
