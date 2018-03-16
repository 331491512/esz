package com.esuizhen.cloudservice.research.model.crf;

import java.util.Date;


/**
* @ClassName: CrfObservationClinicSymptomOptions 
* @Description: 诊断详细信息
* @author wang_hw
* @date 2016年4月5日 下午8:10:01
 */
public class TCrfSymptomInfo{
	/**
	 * 明细ID。主键。
	 */
	private String crfObserveItemId;
	/**
	 * 观察项ID。外键。
	 */
	private String crfObserveId;
	/**
	 * 观察项。外键。meta_crf_subject_element.subjectElementId 如临床症状对应的Id。
	 */
	private String subjectElementId;
	/**
	 * 症状ID。
	 */
	private Integer symptomId;
	
	/**
	 * 症状名称
	 */
	private String symptomName;
	/**
	 * 轻微症状描述
	 */
	private String slightDescription;
	/**
	 * 中度症状描述
	 */
	private String mediumDescription;
	/**
	 * severeDescription
	 */
	private String severeDescription;
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
	public void setSymptomId(Integer value) {
		this.symptomId = value;
	}
	
	public Integer getSymptomId() {
		return this.symptomId;
	}
	public void setSlightDescription(String value) {
		this.slightDescription = value;
	}
	
	public String getSlightDescription() {
		return this.slightDescription;
	}
	public void setMediumDescription(String value) {
		this.mediumDescription = value;
	}
	
	public String getMediumDescription() {
		return this.mediumDescription;
	}
	public void setSevereDescription(String value) {
		this.severeDescription = value;
	}
	
	public String getSevereDescription() {
		return this.severeDescription;
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

	public String getSymptomName()
	{
		return symptomName;
	}

	public void setSymptomName(String symptomName)
	{
		this.symptomName = symptomName;
	}


}

