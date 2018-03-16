package com.esuizhen.bigdata.domain.followup;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name="questionnaire",schema = "followup_db", catalog="")
//@Audited
//@AuditTable(value = "questionnaire_audit",schema = "followup_db_audit",catalog = "followup_db_audit")
public class Questionnaire {
    private String questionnaireId;
    private String subject;
    private String followupTaskId;
    private String description;
    private String contentTemplateId;
    private Integer isPublish;
    private Integer author;
    private Timestamp createTime;
    private Timestamp updateTime;
//    private Collection<QuestionnaireResult> questionnaireResultsByQuestionnaireId;
//    private Collection<QuestionnaireStem> questionnaireStemsByQuestionnaireId;

    @Id
    @Column(name = "questionnaireId", nullable = false, length = 100)
    public String getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(String questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    @Basic
    @Column(name = "subject", nullable = false, length = 300)
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "followupTaskId", nullable = true, length = 60)
    public String getFollowupTaskId() {
        return followupTaskId;
    }

    public void setFollowupTaskId(String followupTaskId) {
        this.followupTaskId = followupTaskId;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "contentTemplateId", nullable = true, length = 32)
    public String getContentTemplateId() {
        return contentTemplateId;
    }

    public void setContentTemplateId(String contentTemplateId) {
        this.contentTemplateId = contentTemplateId;
    }

    @Basic
    @Column(name = "isPublish", nullable = true)
    public Integer getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }

    @Basic
    @Column(name = "author", nullable = true)
    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
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

        Questionnaire that = (Questionnaire) o;

        if (questionnaireId != null ? !questionnaireId.equals(that.questionnaireId) : that.questionnaireId != null)
            return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        if (followupTaskId != null ? !followupTaskId.equals(that.followupTaskId) : that.followupTaskId != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (contentTemplateId != null ? !contentTemplateId.equals(that.contentTemplateId) : that.contentTemplateId != null)
            return false;
        if (isPublish != null ? !isPublish.equals(that.isPublish) : that.isPublish != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionnaireId != null ? questionnaireId.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (followupTaskId != null ? followupTaskId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (contentTemplateId != null ? contentTemplateId.hashCode() : 0);
        result = 31 * result + (isPublish != null ? isPublish.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "questionnaireByQuestionnaireId")
//    public Collection<QuestionnaireResult> getQuestionnaireResultsByQuestionnaireId() {
//        return questionnaireResultsByQuestionnaireId;
//    }
//
//    public void setQuestionnaireResultsByQuestionnaireId(Collection<QuestionnaireResult> questionnaireResultsByQuestionnaireId) {
//        this.questionnaireResultsByQuestionnaireId = questionnaireResultsByQuestionnaireId;
//    }

//    @OneToMany(mappedBy = "questionnaireByQuestionnaireId")
//    public Collection<QuestionnaireStem> getQuestionnaireStemsByQuestionnaireId() {
//        return questionnaireStemsByQuestionnaireId;
//    }
//
//    public void setQuestionnaireStemsByQuestionnaireId(Collection<QuestionnaireStem> questionnaireStemsByQuestionnaireId) {
//        this.questionnaireStemsByQuestionnaireId = questionnaireStemsByQuestionnaireId;
//    }
}
