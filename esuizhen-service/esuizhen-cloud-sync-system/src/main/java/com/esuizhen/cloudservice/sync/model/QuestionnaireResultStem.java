package com.esuizhen.cloudservice.sync.model;

import java.util.Date;
import java.util.List;


public class QuestionnaireResultStem{
	
	/**
	 * 问卷题干项ID。主键。QRSTYYYYMMDDHHMMSSnnnnnn
	 */
	private String questionnaireResultStemId;
	/**
	 * questionnaireResultId
	 */
	private String questionnaireResultId;
	/**
	 * 题干ID
	 */
	private String questionnaireStemId;
	/**
	 * 问卷。外键。questionnaire.questionnaireId
	 */
	private String questionnaireId;
	/**
	 * 必答标志。 1：必答；0：非必答。 必答题必须回答了才能跳转下一题。
	 */
	private Integer mandatoryFlag;
	/**
	 * 问卷部分ID
	 */
	private Integer sectionId;
	/**
	 * 问卷部分标题。
	 */
	private String sectionTitle;
	/**
	 * 题干项索引。如问题1，问题2. 从1开始编号。
	 */
	private Integer stemIndex;
	/**
	 * 题干编号。在同一套题中唯一。用于方便记忆，同时作为问题决策树的出口分支编号索引（所谓问题决策树，指根据回答的不同，跳到不同的下一题）。
	 */
	private String stemCode;
	/**
	 * 题干内容
	 */
	private String content;
	/**
	 * 题型。 1：单选(默认)；2：多选；3: 填空；4：问答；5: 表格(矩阵)；9：其他
	 */
	private Integer questionType;
	/**
	 * 答题标志
	 */
	private Integer answerFlag;
	/**
	 * 记录创建时间（如第一次上传时间）。
	 */
	private Date createTime;
	/**
	 * 记录更新时间
	 */
	private Date updateTime;

	/**
	 * 子选项列表
	 */
	private List<QuestionnaireResultOptionsDetail> questionOptions;
	
	public void setQuestionnaireResultStemId(String value) {
		this.questionnaireResultStemId = value;
	}
	
	public String getQuestionnaireResultStemId() {
		return this.questionnaireResultStemId;
	}
	public void setQuestionnaireResultId(String value) {
		this.questionnaireResultId = value;
	}
	
	public String getQuestionnaireResultId() {
		return this.questionnaireResultId;
	}
	public void setQuestionnaireStemId(String value) {
		this.questionnaireStemId = value;
	}
	
	public String getQuestionnaireStemId() {
		return this.questionnaireStemId;
	}
	public void setQuestionnaireId(String value) {
		this.questionnaireId = value;
	}
	
	public String getQuestionnaireId() {
		return this.questionnaireId;
	}
	public void setMandatoryFlag(Integer value) {
		this.mandatoryFlag = value;
	}
	
	public Integer getMandatoryFlag() {
		return this.mandatoryFlag;
	}
	public void setSectionId(Integer value) {
		this.sectionId = value;
	}
	
	public Integer getSectionId() {
		return this.sectionId;
	}
	public void setSectionTitle(String value) {
		this.sectionTitle = value;
	}
	
	public String getSectionTitle() {
		return this.sectionTitle;
	}
	public void setStemIndex(Integer value) {
		this.stemIndex = value;
	}
	
	public Integer getStemIndex() {
		return this.stemIndex;
	}
	public void setStemCode(String value) {
		this.stemCode = value;
	}
	
	public String getStemCode() {
		return this.stemCode;
	}
	public void setContent(String value) {
		this.content = value;
	}
	
	public String getContent() {
		return this.content;
	}
	public void setQuestionType(Integer value) {
		this.questionType = value;
	}
	
	public Integer getQuestionType() {
		return this.questionType;
	}
	public void setAnswerFlag(Integer value) {
		this.answerFlag = value;
	}
	
	public Integer getAnswerFlag() {
		return this.answerFlag;
	}
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public List<QuestionnaireResultOptionsDetail> getQuestionOptions()
	{
		return questionOptions;
	}

	public void setQuestionOptions(List<QuestionnaireResultOptionsDetail> questionOptions)
	{
		this.questionOptions = questionOptions;
	}
	
	
}

