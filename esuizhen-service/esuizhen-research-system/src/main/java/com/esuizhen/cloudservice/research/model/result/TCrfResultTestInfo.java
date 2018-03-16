package com.esuizhen.cloudservice.research.model.result;

import java.util.Date;
import java.util.List;

/**
* @ClassName: TCrfResultTestInfo 
* @Description: 检验结果信息
* @author wang_hw
* @date 2016年5月30日 下午5:48:39
 */
public class TCrfResultTestInfo
{
	/**
	 * 检验结果ID。
	 */
	private String crfTestResultId;
	/**
	 * Crf结果ID。
	 */
	private String crfResultId;
	/**
	 * 化验类型父ID
	 */
	private Integer detectionParentTypeId;
	/**
	 * 化验子类型ID。
	 */
	private Integer detectionTypeId;
	/**
	 * 化验类型名称。
	 */
	private String detectionTypeName;
	/**
	 * 检验医院ID
	 */
	private Integer hospitalId;
	/**
	 * 采样时间
	 */
	private Date sampleTime;
	//排序索引
	private Integer index;
	/**
	 * 报告时间
	 */
	private Date reportTime;
	/**
	 * 创建时间（单据上传时间）
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	//数据源，3：院内检查；1：患者上传
	private Integer dataSourceType;
	//数据源名称
	private String dataSourceTypeName;
	//记录发生时间
	private Date dataSourceTime;
	//病历主表ID
	private String emrId;

	/**
	 * 检验信息明细
	 */
	private List<TCrfResultTestDetail> crfResultTestDetailList;
	
	public Integer getIndex() {
		return index;
	}

	public Integer getDataSourceType() {
		return dataSourceType;
	}

	public void setDataSourceType(Integer dataSourceType) {
		this.dataSourceType = dataSourceType;
	}

	public String getDataSourceTypeName() {
		return dataSourceTypeName;
	}

	public void setDataSourceTypeName(String dataSourceTypeName) {
		this.dataSourceTypeName = dataSourceTypeName;
	}

	public Date getDataSourceTime() {
		return dataSourceTime;
	}

	public void setDataSourceTime(Date dataSourceTime) {
		this.dataSourceTime = dataSourceTime;
	}

	public String getEmrId() {
		return emrId;
	}

	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public void setCrfTestResultId(String value) {
		this.crfTestResultId = value;
	}
	
	public String getCrfTestResultId() {
		return this.crfTestResultId;
	}
	public void setCrfResultId(String value) {
		this.crfResultId = value;
	}
	
	public String getCrfResultId() {
		return this.crfResultId;
	}
	public void setDetectionParentTypeId(Integer value) {
		this.detectionParentTypeId = value;
	}
	
	public Integer getDetectionParentTypeId() {
		return this.detectionParentTypeId;
	}
	public void setDetectionTypeId(Integer value) {
		this.detectionTypeId = value;
	}
	
	public Integer getDetectionTypeId() {
		return this.detectionTypeId;
	}
	public void setDetectionTypeName(String value) {
		this.detectionTypeName = value;
	}
	
	public String getDetectionTypeName() {
		return this.detectionTypeName;
	}
	public void setHospitalId(Integer value) {
		this.hospitalId = value;
	}
	
	public Integer getHospitalId() {
		return this.hospitalId;
	}
	public void setSampleTime(Date value) {
		this.sampleTime = value;
	}
	
	public Date getSampleTime() {
		return this.sampleTime;
	}
	public void setReportTime(Date value) {
		this.reportTime = value;
	}
	
	public Date getReportTime() {
		return this.reportTime;
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


	public List<TCrfResultTestDetail> getCrfResultTestDetailList()
	{
		return crfResultTestDetailList;
	}

	public void setCrfResultTestDetailList(List<TCrfResultTestDetail> crfResultTestDetailList)
	{
		this.crfResultTestDetailList = crfResultTestDetailList;
	}

	
}

