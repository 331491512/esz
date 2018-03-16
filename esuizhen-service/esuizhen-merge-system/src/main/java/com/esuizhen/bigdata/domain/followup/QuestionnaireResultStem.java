package com.esuizhen.bigdata.domain.followup;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name = "questionnaire_result_stem", schema = "followup_db", catalog="")
//@Audited
//@AuditTable(value = "questionnaire_result_stem_audit",schema = "followup_db_audit",catalog = "followup_db_audit")
public class QuestionnaireResultStem {
    private String questionnaireResultStemId;
    private String questionnaireResultId;
    private String questionnaireStemId;
    private String questionnaireId;
    private int mandatoryFlag;
    private Integer sectionId;
    private String sectionTitle;
    private int stemIndex;
    private String stemCode;
    private String content;
    private int questionType;
    private int answerFlag;
    private Timestamp createTime;
    private Timestamp updateTime;
//    private QuestionnaireResult questionnaireResultByQuestionnaireResultId;
//    private QuestionnaireStem questionnaireStemByQuestionnaireStemId;

    @Id
    @Column(name = "questionnaireResultStemId", nullable = false, length = 100)
    public String getQuestionnaireResultStemId() {
        return questionnaireResultStemId;
    }

    public void setQuestionnaireResultStemId(String questionnaireResultStemId) {
        this.questionnaireResultStemId = questionnaireResultStemId;
    }

    @Basic
    @Column(name = "questionnaireResultId", nullable = false, length = 100)
    public String getQuestionnaireResultId() {
        return questionnaireResultId;
    }

    public void setQuestionnaireResultId(String questionnaireResultId) {
        this.questionnaireResultId = questionnaireResultId;
    }

    @Basic
    @Column(name = "questionnaireStemId", nullable = false, length = 100)
    public String getQuestionnaireStemId() {
        return questionnaireStemId;
    }

    public void setQuestionnaireStemId(String questionnaireStemId) {
        this.questionnaireStemId = questionnaireStemId;
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
    @Column(name = "mandatoryFlag", nullable = false)
    public int getMandatoryFlag() {
        return mandatoryFlag;
    }

    public void setMandatoryFlag(int mandatoryFlag) {
        this.mandatoryFlag = mandatoryFlag;
    }

    @Basic
    @Column(name = "sectionId", nullable = true)
    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    @Basic
    @Column(name = "sectionTitle", nullable = false, length = 255)
    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    @Basic
    @Column(name = "stemIndex", nullable = false)
    public int getStemIndex() {
        return stemIndex;
    }

    public void setStemIndex(int stemIndex) {
        this.stemIndex = stemIndex;
    }

    @Basic
    @Column(name = "stemCode", nullable = false, length = 30)
    public String getStemCode() {
        return stemCode;
    }

    public void setStemCode(String stemCode) {
        this.stemCode = stemCode;
    }

    @Basic
    @Column(name = "content", nullable = false, length = 500)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "questionType", nullable = false)
    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    @Basic
    @Column(name = "answerFlag", nullable = false)
    public int getAnswerFlag() {
        return answerFlag;
    }

    public void setAnswerFlag(int answerFlag) {
        this.answerFlag = answerFlag;
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

        QuestionnaireResultStem that = (QuestionnaireResultStem) o;

        if (mandatoryFlag != that.mandatoryFlag) return false;
        if (stemIndex != that.stemIndex) return false;
        if (questionType != that.questionType) return false;
        if (answerFlag != that.answerFlag) return false;
        if (questionnaireResultStemId != null ? !questionnaireResultStemId.equals(that.questionnaireResultStemId) : that.questionnaireResultStemId != null)
            return false;
        if (questionnaireResultId != null ? !questionnaireResultId.equals(that.questionnaireResultId) : that.questionnaireResultId != null)
            return false;
        if (questionnaireStemId != null ? !questionnaireStemId.equals(that.questionnaireStemId) : that.questionnaireStemId != null)
            return false;
        if (questionnaireId != null ? !questionnaireId.equals(that.questionnaireId) : that.questionnaireId != null)
            return false;
        if (sectionId != null ? !sectionId.equals(that.sectionId) : that.sectionId != null) return false;
        if (sectionTitle != null ? !sectionTitle.equals(that.sectionTitle) : that.sectionTitle != null) return false;
        if (stemCode != null ? !stemCode.equals(that.stemCode) : that.stemCode != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionnaireResultStemId != null ? questionnaireResultStemId.hashCode() : 0;
        result = 31 * result + (questionnaireResultId != null ? questionnaireResultId.hashCode() : 0);
        result = 31 * result + (questionnaireStemId != null ? questionnaireStemId.hashCode() : 0);
        result = 31 * result + (questionnaireId != null ? questionnaireId.hashCode() : 0);
        result = 31 * result + mandatoryFlag;
        result = 31 * result + (sectionId != null ? sectionId.hashCode() : 0);
        result = 31 * result + (sectionTitle != null ? sectionTitle.hashCode() : 0);
        result = 31 * result + stemIndex;
        result = 31 * result + (stemCode != null ? stemCode.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + questionType;
        result = 31 * result + answerFlag;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "questionnaireResultId", referencedColumnName = "questionnaireResultId", nullable = false, insertable = false, updatable = false)
//    public QuestionnaireResult getQuestionnaireResultByQuestionnaireResultId() {
//        return questionnaireResultByQuestionnaireResultId;
//    }
//
//    public void setQuestionnaireResultByQuestionnaireResultId(QuestionnaireResult questionnaireResultByQuestionnaireResultId) {
//        this.questionnaireResultByQuestionnaireResultId = questionnaireResultByQuestionnaireResultId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "questionnaireStemId", referencedColumnName = "questionnaireStemId", nullable = false, insertable = false, updatable = false)
//    public QuestionnaireStem getQuestionnaireStemByQuestionnaireStemId() {
//        return questionnaireStemByQuestionnaireStemId;
//    }
//
//    public void setQuestionnaireStemByQuestionnaireStemId(QuestionnaireStem questionnaireStemByQuestionnaireStemId) {
//        this.questionnaireStemByQuestionnaireStemId = questionnaireStemByQuestionnaireStemId;
//    }
}
