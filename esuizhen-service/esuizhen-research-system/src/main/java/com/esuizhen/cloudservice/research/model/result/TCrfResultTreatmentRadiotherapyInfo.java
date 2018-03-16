package com.esuizhen.cloudservice.research.model.result;

import java.util.Date;
import java.util.List;


public class TCrfResultTreatmentRadiotherapyInfo{
	
	/**
	 * 放疗结果ID
	 */
	private String crfTreatmentRadiotherapyResultId;
	/**
	 * Crf结果ID
	 */
	private String crfResultId;
	/**
	 * 如果是从标准元数据表而来的方案，则须记录标准方案Id
	 */
	private Integer treatmentSchemeId;
	//方案索引
	private Integer schemeIndex;
	/**
	 * 方案名称
	 */
	private String schemeName;
	/**
	 * 排序索引，从0开始
	 */
	private Integer index;
	/**
	 * 放疗类型
	 */
	private String radiotherapyType;
	/**
	 * 放疗类型其他描述
	 */
	private String radiotherapyTypeDesc;
	/**
	 * 照射方式
	 */
	private String irradiationWay;
	/**
	 * 照射方式其他描述
	 */
	private String irradiationWayDesc;
	/**
	 * 开始时间
	 */
	private Date beginTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 创建时间（单据上传时间）
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 放疗结果明细列表
	 */
	private List<TCrfResultTreatmentRadiotherapyDetail> crfResultTreatmentRadiotherapyDetailList;
	
	public void setCrfTreatmentRadiotherapyResultId(String crfTreatmentRadiotherapyResultId) {
		this.crfTreatmentRadiotherapyResultId = crfTreatmentRadiotherapyResultId;
	}
	
	public String getCrfTreatmentRadiotherapyResultId() {
		return this.crfTreatmentRadiotherapyResultId;
	}
	public void setCrfResultId(String crfResultId) {
		this.crfResultId = crfResultId;
	}
	
	public Integer getSchemeIndex() {
		return schemeIndex;
	}

	public void setSchemeIndex(Integer schemeIndex) {
		this.schemeIndex = schemeIndex;
	}

	public String getCrfResultId() {
		return this.crfResultId;
	}
	public void setTreatmentSchemeId(Integer treatmentSchemeId) {
		this.treatmentSchemeId = treatmentSchemeId;
	}
	
	public Integer getTreatmentSchemeId() {
		return this.treatmentSchemeId;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	
	public String getSchemeName() {
		return this.schemeName;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	
	public Integer getIndex() {
		return this.index;
	}
	public void setRadiotherapyType(String radiotherapyType) {
		this.radiotherapyType = radiotherapyType;
	}
	
	public String getRadiotherapyType() {
		return this.radiotherapyType;
	}
	public void setRadiotherapyTypeDesc(String radiotherapyTypeDesc) {
		this.radiotherapyTypeDesc = radiotherapyTypeDesc;
	}
	
	public String getRadiotherapyTypeDesc() {
		return this.radiotherapyTypeDesc;
	}
	public void setIrradiationWay(String irradiationWay) {
		this.irradiationWay = irradiationWay;
	}
	
	public String getIrradiationWay() {
		return this.irradiationWay;
	}
	public void setIrradiationWayDesc(String irradiationWayDesc) {
		this.irradiationWayDesc = irradiationWayDesc;
	}
	
	public String getIrradiationWayDesc() {
		return this.irradiationWayDesc;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	public Date getBeginTime() {
		return this.beginTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public Date getEndTime() {
		return this.endTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public List<TCrfResultTreatmentRadiotherapyDetail> getCrfResultTreatmentRadiotherapyDetailList()
	{
		return crfResultTreatmentRadiotherapyDetailList;
	}

	public void setCrfResultTreatmentRadiotherapyDetailList(List<TCrfResultTreatmentRadiotherapyDetail> crfResultTreatmentRadiotherapyDetailList)
	{
		this.crfResultTreatmentRadiotherapyDetailList = crfResultTreatmentRadiotherapyDetailList;
	}

	

}

