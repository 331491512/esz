package com.esuizhen.cloudservice.research.model.crf;



public class TCrfDetectionItemInfo
{
	
	/**
	 * 观察项。三级标题。外键。meta_crf_subject_element.subjectElementId 如常规检验对应的Id。
	 */
	private String subjectElementId;
	/**
	 * 明细子元素。 外键：ehr_db.meta_detection_item.detectionItemId 如“血红蛋白”对应的detectionItemId.
	 */
	private Integer detectionItemId;
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
	


	public void setSubjectElementId(String value) {
		this.subjectElementId = value;
	}
	
	public String getSubjectElementId() {
		return this.subjectElementId;
	}
	public void setDetectionItemId(Integer value) {
		this.detectionItemId = value;
	}
	
	public Integer getDetectionItemId() {
		return this.detectionItemId;
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
}

