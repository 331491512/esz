package com.esuizhen.cloudservice.followup.model.questionnaire;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: TFollowupQuestionnaireStem
 * @Description: 问卷中问题明细
 * @author wang_hw
 * @date 2015年12月7日 上午11:13:22
 */
public class TFollowupQuestionnaireStem
{
	/**
	 * 问卷题干项ID。主键。QSTEYYYYMMDDHHMMSSnnnnnn
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
	 * 记录创建时间（如第一次上传时间）。
	 */
	private Date createTime;
	/**
	 * 记录更新时间
	 */
	private Date updateTime;

	/**
	 * 最后随访日期
	 */
	private Date latestFollowupTime;
	
	/**
	 * 随访状态
	 */
	private Integer followupState;
	/**
	 * 选项列表
	 */
	private List<TFollowupQuestionnaireOptions> questionOptions;
	
	public String getQuestionnaireStemId()
	{
		return questionnaireStemId;
	}

	public void setQuestionnaireStemId(String questionnaireStemId)
	{
		this.questionnaireStemId = questionnaireStemId;
	}

	public String getQuestionnaireId()
	{
		return questionnaireId;
	}

	public void setQuestionnaireId(String questionnaireId)
	{
		this.questionnaireId = questionnaireId;
	}

	public Integer getMandatoryFlag()
	{
		return mandatoryFlag;
	}

	public void setMandatoryFlag(Integer mandatoryFlag)
	{
		this.mandatoryFlag = mandatoryFlag;
	}

	public Integer getSectionId()
	{
		return sectionId;
	}

	public void setSectionId(Integer sectionId)
	{
		this.sectionId = sectionId;
	}

	public String getSectionTitle()
	{
		return sectionTitle;
	}

	public void setSectionTitle(String sectionTitle)
	{
		this.sectionTitle = sectionTitle;
	}

	public Integer getStemIndex()
	{
		return stemIndex;
	}

	public void setStemIndex(Integer stemIndex)
	{
		this.stemIndex = stemIndex;
	}

	public String getStemCode()
	{
		return stemCode;
	}

	public void setStemCode(String stemCode)
	{
		this.stemCode = stemCode;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public Integer getQuestionType()
	{
		return questionType;
	}

	public void setQuestionType(Integer questionType)
	{
		this.questionType = questionType;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public Date getUpdateTime()
	{
		return updateTime;
	}

	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}

	public List<TFollowupQuestionnaireOptions> getQuestionOptions()
	{
		return questionOptions;
	}

	public void setQuestionOptions(List<TFollowupQuestionnaireOptions> questionOptions)
	{
		this.questionOptions = questionOptions;
	}

	public Date getLatestFollowupTime()
	{
		return latestFollowupTime;
	}

	public void setLatestFollowupTime(Date latestFollowupTime)
	{
		this.latestFollowupTime = latestFollowupTime;
	}

	public Integer getFollowupState()
	{
		return followupState;
	}

	public void setFollowupState(Integer followupState)
	{
		this.followupState = followupState;
	}
	
	

}
