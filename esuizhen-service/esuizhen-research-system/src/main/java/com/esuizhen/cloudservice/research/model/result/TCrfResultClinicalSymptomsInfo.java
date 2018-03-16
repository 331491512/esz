package com.esuizhen.cloudservice.research.model.result;

import java.util.Date;
import java.util.List;


public class TCrfResultClinicalSymptomsInfo{
	
	/**
	 * 症状记录ID。
	 */
	private String crfSymptomResultId;
	/**
	 * 症状结果ID
	 */
	private String crfResultId;
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	/**
	 * 记录更新时间
	 */
	private Date updateTime;
	
	//临床症状结果详情数据列表
	private List<TCrfResultClinicalSymptomsDetailInfo> crfResultClinicalSymptomsDetailList;
	//临床症状-中医项目结果详情列表
	private List<TCrfResultTcmSymptomsDetail> crfResultTcmSymptomsDetailList;

	public List<TCrfResultTcmSymptomsDetail> getCrfResultTcmSymptomsDetailList() {
		return crfResultTcmSymptomsDetailList;
	}

	public void setCrfResultTcmSymptomsDetailList(List<TCrfResultTcmSymptomsDetail> crfResultTcmSymptomsDetailList) {
		this.crfResultTcmSymptomsDetailList = crfResultTcmSymptomsDetailList;
	}

	public String getCrfSymptomResultId() {
		return crfSymptomResultId;
	}

	public void setCrfSymptomResultId(String crfSymptomResultId) {
		this.crfSymptomResultId = crfSymptomResultId;
	}

	public String getCrfResultId() {
		return crfResultId;
	}

	public void setCrfResultId(String crfResultId) {
		this.crfResultId = crfResultId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public List<TCrfResultClinicalSymptomsDetailInfo> getCrfResultClinicalSymptomsDetailList() {
		return crfResultClinicalSymptomsDetailList;
	}

	public void setCrfResultClinicalSymptomsDetailList(
			List<TCrfResultClinicalSymptomsDetailInfo> crfResultClinicalSymptomsDetailList) {
		this.crfResultClinicalSymptomsDetailList = crfResultClinicalSymptomsDetailList;
	}
}

