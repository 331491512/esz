package com.esuizhen.cloudservice.followup.model.questionnaire;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: TFollowupQuestionnaireOptions
 * @Description: 问题答案
 * @author wang_hw
 * @date 2015年12月7日 上午11:19:39
 */
public class TFollowupQuestionnaireOptions
{
	/**
	 * 问卷题肢项ID。主键。QOPTYYYYMMDDHHMMSSnnnnnn
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
	 * 回答项索引。 从1开始编号。
	 */
	private Integer optionIndex;
	/**
	 * 1: 普通文本 2：xml (如果题型套题型，使用xml格式）
	 */
	private Integer contentType;
	/**
	 * 题肢内容
	 */
	private String content;
	/**
	 * 元素取值，如矩阵类型元素取值
	 */
	private String indicateValue;
	/**
	 * 问题决策树出口标识。 当用户选择了本项结果时，下一题该跳到哪里。如nextStemCode =Q4，表示下一题跳到stemCode=Q4的那题。
	 * 如果为空，则顺序跳到下一题。 如果为“0”（字符串0，不是空），则表示问题结束，不再跳转到下一题
	 */
	private String nextStemCode;
	/**
	 * 父节点ID。用来作题肢选项嵌套。 如多选套单选，再套多选。目前支持最多3级嵌套（含父级）。
	 * 取值为"0"表示没有父节点。否则表示有父节点，即本节点为嵌套的儿子节点。
	 */
	private String parentOptionId;
	/**
	 * 层级。顶级父节点level为0. 第一级的儿子节点level=1，第二级的儿子节点level=2。目前leve最大为2.
	 * level>0表示儿子节点。
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
	 * 填写标志。对于选择题，可能出现“其他”选项，此时可以填写具体内容。 1：可以填写。 0：无需填写(默认)。
	 * 对于fillFlag=1的题，问卷结果中answerContent即为填写内容。
	 */
	private Integer fillFlag;
	/**
	 * 填写内容
	 */
	private String fillContent;
	/**
	 * 填写内容类型
	 */
	private Integer fillContentType;
	private String fillContent2;
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
	 * 选项列表
	 */
	private List<TFollowupQuestionnaireOptions> questionOptions;
	
	public String getQuestionnaireOptionId()
	{
		return questionnaireOptionId;
	}
	public void setQuestionnaireOptionId(String questionnaireOptionId)
	{
		this.questionnaireOptionId = questionnaireOptionId;
	}
	public String getQuestionnaireStemId()
	{
		return questionnaireStemId;
	}
	public void setQuestionnaireStemId(String questionnaireStemId)
	{
		this.questionnaireStemId = questionnaireStemId;
	}
	public String getStemCode()
	{
		return stemCode;
	}
	public void setStemCode(String stemCode)
	{
		this.stemCode = stemCode;
	}
	public String getQuestionnaireId()
	{
		return questionnaireId;
	}
	public void setQuestionnaireId(String questionnaireId)
	{
		this.questionnaireId = questionnaireId;
	}
	public Integer getOptionIndex()
	{
		return optionIndex;
	}
	public void setOptionIndex(Integer optionIndex)
	{
		this.optionIndex = optionIndex;
	}
	public Integer getContentType()
	{
		return contentType;
	}
	public void setContentType(Integer contentType)
	{
		this.contentType = contentType;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getIndicateValue()
	{
		return indicateValue;
	}
	public void setIndicateValue(String indicateValue)
	{
		this.indicateValue = indicateValue;
	}
	public String getNextStemCode()
	{
		return nextStemCode;
	}
	public void setNextStemCode(String nextStemCode)
	{
		this.nextStemCode = nextStemCode;
	}
	public String getParentOptionId()
	{
		return parentOptionId;
	}
	public void setParentOptionId(String parentOptionId)
	{
		this.parentOptionId = parentOptionId;
	}
	public Integer getLevel()
	{
		return level;
	}
	public void setLevel(Integer level)
	{
		this.level = level;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public Integer getQuestionType()
	{
		return questionType;
	}
	public void setQuestionType(Integer questionType)
	{
		this.questionType = questionType;
	}
	public Integer getFillFlag()
	{
		return fillFlag;
	}
	public void setFillFlag(Integer fillFlag)
	{
		this.fillFlag = fillFlag;
	}
	public String getFillContent()
	{
		return fillContent;
	}
	public void setFillContent(String fillContent)
	{
		this.fillContent = fillContent;
	}
	public Integer getFillContentType() {
		return fillContentType;
	}
	public void setFillContentType(Integer fillContentType) {
		this.fillContentType = fillContentType;
	}
	public String getFillContent2() {
		return fillContent2;
	}
	public void setFillContent2(String fillContent2) {
		this.fillContent2 = fillContent2;
	}
	public Integer getFillContentType2() {
		return fillContentType2;
	}
	public void setFillContentType2(Integer fillContentType2) {
		this.fillContentType2 = fillContentType2;
	}
	public Integer getIsChecked()
	{
		return isChecked;
	}
	public void setIsChecked(Integer isChecked)
	{
		this.isChecked = isChecked;
	}
	public Date getCreateTime()
	{
		return createTime;
	}
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}
	public List<TFollowupQuestionnaireOptions> getQuestionOptions()
	{
		return questionOptions;
	}
	public void setQuestionOptions(List<TFollowupQuestionnaireOptions> questionOptions)
	{
		this.questionOptions = questionOptions;
	}
	
	
}
