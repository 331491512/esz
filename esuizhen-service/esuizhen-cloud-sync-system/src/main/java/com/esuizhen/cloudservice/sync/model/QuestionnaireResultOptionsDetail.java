package com.esuizhen.cloudservice.sync.model;

import java.util.Date;
import java.util.List;


public class QuestionnaireResultOptionsDetail{
	/**
	 * 主键。
	 */
	private String questionnaireResultOptionId;
	/**
	 * questionnaireResultStemId
	 */
	private String questionnaireResultStemId;
	/**
	 * questionnaireResultId
	 */
	private String questionnaireResultId;
	/**
	 * 问卷题肢项ID。QOPTYYYYMMDDHHMMSSnnnnnn
	 */
	private String questionnaireOptionId;
	/**
	 * 问卷题干ID。外键。
	 */
	private String questionnaireStemId;
	/**
	 * 题干编号，与questionnaireStemId对应。
	 */
	private String stemCode;
	/**
	 * 问卷ID。外键。冗余字段，用于更方便的找到归属于同一套问卷的题肢。
	 */
	private String questionnaireId;
	/**
	 * 回答项索引。  从1开始编号。
	 */
	private Integer optionIndex;
	/**
	 * 1: 普通文本 2：xml  (如果题型套题型，使用xml格式）
	 */
	private Integer contentType;
	/**
	 * 题肢内容, 如A: xx， B:xxx 如果contentType=2，则如： <question>A</question> <question>B <subquestion>   <questionType>2</questionType>  <option>你好</option>  <option>是否</option> </subquestion> <question>
	 */
	private String content;
	/**
	 * 元素取值，如矩阵类型元素取值
	 */
	private String indicateValue;
	/**
	 * 问题决策树出口标识。 当用户选择了本项结果时，下一题该跳到哪里。如nextStemCode =Q4，表示下一题跳到stemCode=Q4的那题。 如果为空，则顺序跳到下一题。 如果为“0”（字符串0，不是空），则表示问题结束，不再跳转到下一题
	 */
	private String nextStemCode;
	/**
	 * 父节点ID。用来作题肢选项嵌套。 如多选套单选，再套多选。目前支持最多3级嵌套（含父级）。 取值为"0"表示没有父节点。否则表示有父节点，即本节点为嵌套的儿子节点。
	 */
	private String parentOptionId;
	/**
	 * 层级。顶级父节点level为0. 第一级的儿子节点level=1，第二级的儿子节点level=2。目前leve最大为2. level>0表示儿子节点。
	 */
	private Integer level;
	/**
	 * 对于level>0的子节点，title是其标题。
	 */
	private String title;
	/**
	 * 嵌套题的题型。
	 */
	private Integer questionType;
	/**
	 * 填写标志。对于选择题，可能出现“其他”选项，此时可以填写具体内容。 1：可以填写。 0：无需填写(默认)。 对于fillFlag=1的题，问卷结果中answerContent即为填写内容。
	 */
	private Integer fillFlag;
	/**
	 * 填写内容
	 */
	private String fillContent;
	
	/**
	 * 填写内容2
	 */
	private String fillContent2;
	/**
	 * 填写内容类型
	 */
	private Integer fillContentType;
	private Integer fillContentType2;
	
	/**
	 * isChecked
	 */
	private Integer isChecked;
	/**
	 * 记录创建时间（如第一次上传时间）。
	 */
	private Date createTime;
	/**
	 * updateTime
	 */
	private Date updateTime;

	/**
	 * 子选项列表
	 */
	private List<QuestionnaireResultOptionsDetail> questionOptions;
	
	public void setQuestionnaireResultOptionId(String value) {
		this.questionnaireResultOptionId = value;
	}
	
	public String getQuestionnaireResultOptionId() {
		return this.questionnaireResultOptionId;
	}
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
	public void setQuestionnaireOptionId(String value) {
		this.questionnaireOptionId = value;
	}
	
	public String getQuestionnaireOptionId() {
		return this.questionnaireOptionId;
	}
	public void setQuestionnaireStemId(String value) {
		this.questionnaireStemId = value;
	}
	
	public String getQuestionnaireStemId() {
		return this.questionnaireStemId;
	}
	public void setStemCode(String value) {
		this.stemCode = value;
	}
	
	public String getStemCode() {
		return this.stemCode;
	}
	public void setQuestionnaireId(String value) {
		this.questionnaireId = value;
	}
	
	public String getQuestionnaireId() {
		return this.questionnaireId;
	}
	public void setOptionIndex(Integer value) {
		this.optionIndex = value;
	}
	
	public Integer getOptionIndex() {
		return this.optionIndex;
	}
	public void setContentType(Integer value) {
		this.contentType = value;
	}
	
	public Integer getContentType() {
		return this.contentType;
	}
	public void setContent(String value) {
		this.content = value;
	}
	
	public String getContent() {
		return this.content;
	}
	public void setIndicateValue(String value) {
		this.indicateValue = value;
	}
	
	public String getIndicateValue() {
		return this.indicateValue;
	}
	public void setNextStemCode(String value) {
		this.nextStemCode = value;
	}
	
	public String getNextStemCode() {
		return this.nextStemCode;
	}
	public void setParentOptionId(String value) {
		this.parentOptionId = value;
	}
	
	public String getParentOptionId() {
		return this.parentOptionId;
	}
	public void setLevel(Integer value) {
		this.level = value;
	}
	
	public Integer getLevel() {
		return this.level;
	}
	public void setTitle(String value) {
		this.title = value;
	}
	
	public String getTitle() {
		return this.title;
	}
	public void setQuestionType(Integer value) {
		this.questionType = value;
	}
	
	public Integer getQuestionType() {
		return this.questionType;
	}
	public void setFillFlag(Integer value) {
		this.fillFlag = value;
	}
	
	public Integer getFillFlag() {
		return this.fillFlag;
	}
	public void setFillContent(String value) {
		this.fillContent = value;
	}
	
	public String getFillContent() {
		return this.fillContent;
	}
	public void setIsChecked(Integer value) {
		this.isChecked = value;
	}
	
	public Integer getIsChecked() {
		return this.isChecked;
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

	public String getFillContent2()
	{
		return fillContent2;
	}

	public void setFillContent2(String fillContent2)
	{
		this.fillContent2 = fillContent2;
	}

	public Integer getFillContentType() {
		return fillContentType;
	}

	public void setFillContentType(Integer fillContentType) {
		this.fillContentType = fillContentType;
	}

	public Integer getFillContentType2() {
		return fillContentType2;
	}

	public void setFillContentType2(Integer fillContentType2) {
		this.fillContentType2 = fillContentType2;
	}
}

