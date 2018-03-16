package com.esuizhen.bigdata.domain.followup;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name = "questionnaire_options_detail", schema = "followup_db", catalog="")
//@Audited
//@AuditTable(value = "questionnaire_options_detail_audit",schema = "followup_db_audit",catalog = "followup_db_audit")
public class QuestionnaireOptionsDetail {
    private String questionnaireOptionId;
    private String questionnaireStemId;
    private String stemCode;
    private String questionnaireId;
    private int optionIndex;
    private Integer diseaseTypeId;
    private int contentType;
    private String content;
    private String indicateValue;
    private String nextStemCode;
    private String parentOptionId;
    private int level;
    private String title;
    private Integer questionType;
    private Integer fillFlag;
    private String fillContent;
    private String fillContent2;
    private int isChecked;
    private Timestamp createTime;
//    private QuestionnaireStem questionnaireStemByQuestionnaireStemId;

    @Id
    @Column(name = "questionnaireOptionId", nullable = false, length = 100)
    public String getQuestionnaireOptionId() {
        return questionnaireOptionId;
    }

    public void setQuestionnaireOptionId(String questionnaireOptionId) {
        this.questionnaireOptionId = questionnaireOptionId;
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
    @Column(name = "stemCode", nullable = false, length = 30)
    public String getStemCode() {
        return stemCode;
    }

    public void setStemCode(String stemCode) {
        this.stemCode = stemCode;
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
    @Column(name = "optionIndex", nullable = false)
    public int getOptionIndex() {
        return optionIndex;
    }

    public void setOptionIndex(int optionIndex) {
        this.optionIndex = optionIndex;
    }

    @Basic
    @Column(name = "diseaseTypeId", nullable = true)
    public Integer getDiseaseTypeId() {
        return diseaseTypeId;
    }

    public void setDiseaseTypeId(Integer diseaseTypeId) {
        this.diseaseTypeId = diseaseTypeId;
    }

    @Basic
    @Column(name = "contentType", nullable = false)
    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    @Basic
    @Column(name = "content", nullable = false, length = 1000)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "indicateValue", nullable = true, length = 255)
    public String getIndicateValue() {
        return indicateValue;
    }

    public void setIndicateValue(String indicateValue) {
        this.indicateValue = indicateValue;
    }

    @Basic
    @Column(name = "nextStemCode", nullable = false, length = 30)
    public String getNextStemCode() {
        return nextStemCode;
    }

    public void setNextStemCode(String nextStemCode) {
        this.nextStemCode = nextStemCode;
    }

    @Basic
    @Column(name = "parentOptionId", nullable = false, length = 24)
    public String getParentOptionId() {
        return parentOptionId;
    }

    public void setParentOptionId(String parentOptionId) {
        this.parentOptionId = parentOptionId;
    }

    @Basic
    @Column(name = "level", nullable = false)
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "questionType", nullable = true)
    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    @Basic
    @Column(name = "fillFlag", nullable = true)
    public Integer getFillFlag() {
        return fillFlag;
    }

    public void setFillFlag(Integer fillFlag) {
        this.fillFlag = fillFlag;
    }

    @Basic
    @Column(name = "fillContent", nullable = true, length = 255)
    public String getFillContent() {
        return fillContent;
    }

    public void setFillContent(String fillContent) {
        this.fillContent = fillContent;
    }

    @Basic
    @Column(name = "fillContent2", nullable = true, length = 255)
    public String getFillContent2() {
        return fillContent2;
    }

    public void setFillContent2(String fillContent2) {
        this.fillContent2 = fillContent2;
    }

    @Basic
    @Column(name = "isChecked", nullable = false)
    public int getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }

    @Basic
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionnaireOptionsDetail that = (QuestionnaireOptionsDetail) o;

        if (optionIndex != that.optionIndex) return false;
        if (contentType != that.contentType) return false;
        if (level != that.level) return false;
        if (isChecked != that.isChecked) return false;
        if (questionnaireOptionId != null ? !questionnaireOptionId.equals(that.questionnaireOptionId) : that.questionnaireOptionId != null)
            return false;
        if (questionnaireStemId != null ? !questionnaireStemId.equals(that.questionnaireStemId) : that.questionnaireStemId != null)
            return false;
        if (stemCode != null ? !stemCode.equals(that.stemCode) : that.stemCode != null) return false;
        if (questionnaireId != null ? !questionnaireId.equals(that.questionnaireId) : that.questionnaireId != null)
            return false;
        if (diseaseTypeId != null ? !diseaseTypeId.equals(that.diseaseTypeId) : that.diseaseTypeId != null)
            return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (indicateValue != null ? !indicateValue.equals(that.indicateValue) : that.indicateValue != null)
            return false;
        if (nextStemCode != null ? !nextStemCode.equals(that.nextStemCode) : that.nextStemCode != null) return false;
        if (parentOptionId != null ? !parentOptionId.equals(that.parentOptionId) : that.parentOptionId != null)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (questionType != null ? !questionType.equals(that.questionType) : that.questionType != null) return false;
        if (fillFlag != null ? !fillFlag.equals(that.fillFlag) : that.fillFlag != null) return false;
        if (fillContent != null ? !fillContent.equals(that.fillContent) : that.fillContent != null) return false;
        if (fillContent2 != null ? !fillContent2.equals(that.fillContent2) : that.fillContent2 != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionnaireOptionId != null ? questionnaireOptionId.hashCode() : 0;
        result = 31 * result + (questionnaireStemId != null ? questionnaireStemId.hashCode() : 0);
        result = 31 * result + (stemCode != null ? stemCode.hashCode() : 0);
        result = 31 * result + (questionnaireId != null ? questionnaireId.hashCode() : 0);
        result = 31 * result + optionIndex;
        result = 31 * result + (diseaseTypeId != null ? diseaseTypeId.hashCode() : 0);
        result = 31 * result + contentType;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (indicateValue != null ? indicateValue.hashCode() : 0);
        result = 31 * result + (nextStemCode != null ? nextStemCode.hashCode() : 0);
        result = 31 * result + (parentOptionId != null ? parentOptionId.hashCode() : 0);
        result = 31 * result + level;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (questionType != null ? questionType.hashCode() : 0);
        result = 31 * result + (fillFlag != null ? fillFlag.hashCode() : 0);
        result = 31 * result + (fillContent != null ? fillContent.hashCode() : 0);
        result = 31 * result + (fillContent2 != null ? fillContent2.hashCode() : 0);
        result = 31 * result + isChecked;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

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
