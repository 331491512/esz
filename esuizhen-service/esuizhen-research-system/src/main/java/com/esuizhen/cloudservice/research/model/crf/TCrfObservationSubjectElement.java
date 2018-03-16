package com.esuizhen.cloudservice.research.model.crf;

import java.io.Serializable;
import java.util.Date;

/**
* @ClassName: CrfObservationSubjectElement 
* @Description: crf观察项标题项
* @author wang_hw
* @date 2016年4月5日 下午4:33:13
 */
public class TCrfObservationSubjectElement implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 观察项ID。主键。
	 */
	private String crfObserveId;
	/**
	 * 观察时点（随访周期明细）ID。外键。
	 */
	private String crfCourseItemId;
	/**
	 * 观察项标题元素。外键。meta_crf_subject_element.subjectElementId 二级（如“基本信息”）和三级（如“人口学”）元素均通过此字段设置。
	 */
	private String subjectElementId;
	/**
	 * 观察项标题元素名称。
	 */
	private String subjectElementName;
	/**
	 * 父标题元素。NULL表示无父标题。 如“人口学”对应的父标题元素是“基本信息”-S1。
	 */
	private String parentId;
	
	private Integer emrItemTypeId;
	
	/**
	 * subjectIndex
	 */
	private Integer subjectIndex;
	/**
	 * 记录创建时间。
	 */
	private Date createTime;
	/**
	 * updateTime
	 */
	private Date updateTime;
	
	private Integer collectFlag;
	//是否采集 0:不采集  1：采集
	private Integer collectionFlag;

	public Integer getCollectFlag() {
		return collectFlag;
	}

	public void setCollectFlag(Integer collectFlag) {
		this.collectFlag = collectFlag;
	}

	public void setCrfObserveId(String value) {
		this.crfObserveId = value;
	}
	
	public String getCrfObserveId() {
		return this.crfObserveId;
	}
	public void setCrfCourseItemId(String value) {
		this.crfCourseItemId = value;
	}
	
	public String getCrfCourseItemId() {
		return this.crfCourseItemId;
	}
	public Integer getCollectionFlag() {
		return collectionFlag;
	}

	public void setCollectionFlag(Integer collectionFlag) {
		this.collectionFlag = collectionFlag;
	}

	public void setSubjectElementId(String value) {
		this.subjectElementId = value;
	}
	
	public String getSubjectElementId() {
		return this.subjectElementId;
	}
	public void setParentId(String value) {
		this.parentId = value;
	}
	
	public String getParentId() {
		return this.parentId;
	}
	public void setSubjectIndex(Integer value) {
		this.subjectIndex = value;
	}
	
	public Integer getSubjectIndex() {
		return this.subjectIndex;
	}
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public String getSubjectElementName() {
		return subjectElementName;
	}

	public void setSubjectElementName(String subjectElementName) {
		this.subjectElementName = subjectElementName;
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

	public Integer getEmrItemTypeId()
	{
		return emrItemTypeId;
	}

	public void setEmrItemTypeId(Integer emrItemTypeId)
	{
		this.emrItemTypeId = emrItemTypeId;
	}

	

}

