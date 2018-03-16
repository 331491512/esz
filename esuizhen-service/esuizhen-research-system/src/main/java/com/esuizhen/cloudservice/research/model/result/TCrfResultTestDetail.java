package com.esuizhen.cloudservice.research.model.result;

import java.util.Date;

/**
* @ClassName: TCrfResultTestDetail 
* @Description: 检验结果明细
* @author wang_hw
* @date 2016年5月30日 下午5:49:06
 */
public class TCrfResultTestDetail{
	
	/**
	 * 检验详情结果记录ID
	 */
	private String crfTestResultDetailId;
	/**
	 * 检验结果ID。
	 */
	private String crfTestResultId;
	/**
	 * 检验项目序号
	 */
	private Integer seqNo;
	/**
	 * 检验项目ID。
	 */
	private Integer detectionItemId;
	/**
	 * 检验项目名
	 */
	private String detectionItemName;
	/**
	 * 检验结果
	 */
	private String detectionResult;
	//单位
	private String unit;
	/**
	 * prompt
	 */
	private String prompt;
	/**
	 * 参考范围（下限）
	 */
	private String refrenceRangeMin;
	/**
	 * 参考范围（上限）
	 */
	private String refrenceRangeMax;
	/**
	 * 参考范围
	 */
	private String refrenceRange;
	/**
	 * 临床意义判定
	 */
	private String clinicalSignificance;
	/**
	 * 创建时间（单据上传时间）
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public void setCrfTestResultDetailId(String value) {
		this.crfTestResultDetailId = value;
	}
	
	public String getCrfTestResultDetailId() {
		return this.crfTestResultDetailId;
	}
	public void setCrfTestResultId(String value) {
		this.crfTestResultId = value;
	}
	
	public String getCrfTestResultId() {
		return this.crfTestResultId;
	}
	public void setSeqNo(Integer value) {
		this.seqNo = value;
	}
	
	public Integer getSeqNo() {
		return this.seqNo;
	}
	public void setDetectionItemId(Integer value) {
		this.detectionItemId = value;
	}
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getDetectionItemId() {
		return this.detectionItemId;
	}
	public void setDetectionItemName(String value) {
		this.detectionItemName = value;
	}
	
	public String getDetectionItemName() {
		return this.detectionItemName;
	}
	public void setDetectionResult(String value) {
		this.detectionResult = value;
	}
	
	public String getDetectionResult() {
		return this.detectionResult;
	}
	public void setPrompt(String value) {
		this.prompt = value;
	}
	
	public String getPrompt() {
		return this.prompt;
	}
	public void setRefrenceRangeMin(String value) {
		this.refrenceRangeMin = value;
	}
	
	public String getRefrenceRangeMin() {
		return this.refrenceRangeMin;
	}
	public void setRefrenceRangeMax(String value) {
		this.refrenceRangeMax = value;
	}
	
	public String getRefrenceRangeMax() {
		return this.refrenceRangeMax;
	}
	public void setRefrenceRange(String value) {
		this.refrenceRange = value;
	}
	
	public String getRefrenceRange() {
		return this.refrenceRange;
	}
	public void setClinicalSignificance(String value) {
		this.clinicalSignificance = value;
	}
	
	public String getClinicalSignificance() {
		return this.clinicalSignificance;
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


}

