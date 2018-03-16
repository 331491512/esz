package com.esuizhen.cloudservice.research.model.crf;

import java.util.Date;
import java.util.List;

import com.westangel.common.util.LogUtil;


public class TCrfDetectionDetail implements Cloneable
{
	/**
	 * 明细ID。主键。
	 */
	private String crfObserveItemId;
	/**
	 * 观察项ID。外键。
	 */
	private String crfObserveId;
	/**
	 * 观察项。三级标题。外键。meta_crf_subject_element.subjectElementId 如常规检验对应的Id。
	 */
	private String subjectElementId;
	/**
	 * 项目类型。 外键：ehr_db.meta_detection_type.detectionTypeId 如“血常规”对应的detectionTypeId.
	 */
	private Integer detectionTypeId;
	//项目类型。 外键：ehr_db.meta_detection_type.detectionTypeId 如“血常规”对应的detectionTypeName.
	private String detectionTypeName;
	/**
	 * 明细子元素。 外键：ehr_db.meta_e_detection_item. detectionItemId 如“血红蛋白”对应的detectionItemId.
	 */
	private Integer detectionItemId;
	
	/**
	 * 明细名称
	 */
	private String detectionItemName;
	/**
	 * 单位
	 */
	private String unit;
	
	/**
	 * 参考范围（左值）
	 */
	private Float refrenceRangeMin;
	
	/**
	 * 参考范围（右值）
	 */
	private Float refrenceRangeMax;
	
	/**
	 * 明细列表
	 */
	private List<TCrfDetectionItemInfo> detectionItemList;
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
	public void setDetectionTypeId(Integer value) {
		this.detectionTypeId = value;
	}
	
	public Integer getDetectionTypeId() {
		return this.detectionTypeId;
	}
	public void setDetectionItemId(Integer value) {
		this.detectionItemId = value;
	}
	
	public String getDetectionTypeName() {
		return detectionTypeName;
	}

	public void setDetectionTypeName(String detectionTypeName) {
		this.detectionTypeName = detectionTypeName;
	}

	public Integer getDetectionItemId() {
		return this.detectionItemId;
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

	public String getUnit()
	{
		return unit;
	}

	public void setUnit(String unit)
	{
		this.unit = unit;
	}

	public Float getRefrenceRangeMin()
	{
		return refrenceRangeMin;
	}

	public void setRefrenceRangeMin(Float refrenceRangeMin)
	{
		this.refrenceRangeMin = refrenceRangeMin;
	}

	public Float getRefrenceRangeMax()
	{
		return refrenceRangeMax;
	}

	public void setRefrenceRangeMax(Float refrenceRangeMax)
	{
		this.refrenceRangeMax = refrenceRangeMax;
	}

	
	public List<TCrfDetectionItemInfo> getDetectionItemList()
	{
		return detectionItemList;
	}

	public void setDetectionItemList(List<TCrfDetectionItemInfo> detectionItemList)
	{
		this.detectionItemList = detectionItemList;
	}

	@Override
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

	public String getDetectionItemName()
	{
		return detectionItemName;
	}

	public void setDetectionItemName(String detectionItemName)
	{
		this.detectionItemName = detectionItemName;
	}
	
	
}

