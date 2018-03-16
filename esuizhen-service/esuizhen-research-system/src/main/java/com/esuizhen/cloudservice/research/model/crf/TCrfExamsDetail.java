package com.esuizhen.cloudservice.research.model.crf;

import java.util.Date;
import java.util.List;

import com.westangel.common.util.LogUtil;

/**
* @ClassName: TCrfExamDetail 
* @Description: 检查信息（影像检查病灶）明细
* @author wang_hw
* @date 2016年4月6日 下午3:56:13
 */
public class TCrfExamsDetail implements Cloneable{
	
	/**
	 * 明细ID。
	 */
	private String crfObserveItemId;
	/**
	 * 观察项ID。外键。
	 */
	private String crfObserveId;
	/**
	 * subjectElementId
	 */
	private String subjectElementId;
	/**
	 * 项目类型。 外键：ehr_db.meta_e_exam_type.examTypeId 如“PET-CT”对应的examTypeId.
	 */
	private Integer examTypeId;
	
	/**
	 * 项目类型名称
	 */
	private String examTypeName;
	/**
	 * 明细子元素。 外键：ehr_db.meta_e_exam_item.examItemId 如“病灶部位”对应的examItemId. 为NULL表示无明细子元素。
	 */
	private Integer examItemId;
	
	/**
	 * 明细子元素名称
	 */
	private String examItemName;
	
	/**
	 * 明细列表
	 */
	private List<TCrfExamsItemInfo> examItemList; 
	/**
	 * 1:  靶病灶（默认） 2：非靶病灶 0：未知
	 */
	private Integer flag;
	
	/**
	 * 项目编码。如病灶对应的organCode(ICD-O)
	 */
	private String examItemCode;
	
	//排序索引
	private Integer index;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public void setCrfObserveItemId(String value) {
		this.crfObserveItemId = value;
	}
	
	public String getCrfObserveItemId() {
		return this.crfObserveItemId;
	}
	public void setCrfObserveId(String value) {
		this.crfObserveId = value;
	}
	
	public String getCrfObserveId() {
		return this.crfObserveId;
	}
	public void setSubjectElementId(String value) {
		this.subjectElementId = value;
	}
	
	public String getSubjectElementId() {
		return this.subjectElementId;
	}
	public void setExamTypeId(Integer value) {
		this.examTypeId = value;
	}
	
	public Integer getExamTypeId() {
		return this.examTypeId;
	}
	public void setExamItemId(Integer value) {
		this.examItemId = value;
	}
	
	public Integer getExamItemId() {
		return this.examItemId;
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

	public List<TCrfExamsItemInfo> getExamItemList()
	{
		return examItemList;
	}

	public void setExamItemList(List<TCrfExamsItemInfo> examItemList)
	{
		this.examItemList = examItemList;
	}
	
	
	public String getExamItemName()
	{
		return examItemName;
	}

	public void setExamItemName(String examItemName)
	{
		this.examItemName = examItemName;
	}

	public Integer getFlag()
	{
		return flag;
	}

	public void setFlag(Integer flag)
	{
		this.flag = flag;
	}

	
	public String getExamItemCode()
	{
		return examItemCode;
	}

	public void setExamItemCode(String examItemCode)
	{
		this.examItemCode = examItemCode;
	}

	
	public String getExamTypeName()
	{
		return examTypeName;
	}

	public void setExamTypeName(String examTypeName)
	{
		this.examTypeName = examTypeName;
	}

	public Object clone()
	{
		try
		{
			return super.clone();
		}catch(Exception ex)
		{
			LogUtil.logError.error(ex.getMessage());
		}
		return null;
	}
}

