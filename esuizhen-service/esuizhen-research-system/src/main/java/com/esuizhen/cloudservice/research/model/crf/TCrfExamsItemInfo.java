package com.esuizhen.cloudservice.research.model.crf;

/**
* @ClassName: TCrfExamItemInfo 
* @Description: CRF检查项目信息（影像检查病灶）
* @author wang_hw
* @date 2016年4月6日 下午3:56:39
 */
public class TCrfExamsItemInfo{
	
	/**
	 * 明细子元素。 外键：ehr_db.meta_exam_item. examItemId 如“病灶部位”对应的examItemId. 为NULL表示无明细子元素。
	 */
	private Integer examItemId;
	
	/**
	 * 项目编码。如病灶对应的organCode(ICD-O)
	 */
	private String examItemCode;
	
	/**
	 * 项目名称
	 */
	private String examItemName;

	public Integer getExamItemId()
	{
		return examItemId;
	}

	public void setExamItemId(Integer examItemId)
	{
		this.examItemId = examItemId;
	}

	public String getExamItemCode()
	{
		return examItemCode;
	}

	public void setExamItemCode(String examItemCode)
	{
		this.examItemCode = examItemCode;
	}

	public String getExamItemName()
	{
		return examItemName;
	}

	public void setExamItemName(String examItemName)
	{
		this.examItemName = examItemName;
	}


	
}

