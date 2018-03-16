package com.esuizhen.cloudservice.research.model.result;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:CrfResultBasicAllergies</p>
 * <p>Description:基本信息-既往病史结果bean</p>
 * @author YYCHEN
 * @date 2016年5月26日 下午3:23:44
 */
public class TCrfResultBasicPastmedicalHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键
	private String crfPastmedicalResultId;
	//结果项Id
	private String crfResultId;
	//疾病名称
	private String pastmedicalName;
	//确诊日期
	private Date confirmedDate;
	//确诊单位
	private String confirmedHospital;
	//主要治疗
	private String treatment;
	//目前状况
	private String currentState;
	//排序索引
	private Integer index;
	//记录创建时间。
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getCrfPastmedicalResultId() {
		return crfPastmedicalResultId;
	}
	public void setCrfPastmedicalResultId(String crfPastmedicalResultId) {
		this.crfPastmedicalResultId = crfPastmedicalResultId;
	}
	public String getCrfResultId() {
		return crfResultId;
	}
	public void setCrfResultId(String crfResultId) {
		this.crfResultId = crfResultId;
	}
	public String getPastmedicalName() {
		return pastmedicalName;
	}
	public void setPastmedicalName(String pastmedicalName) {
		this.pastmedicalName = pastmedicalName;
	}
	public Date getConfirmedDate() {
		return confirmedDate;
	}
	public void setConfirmedDate(Date confirmedDate) {
		this.confirmedDate = confirmedDate;
	}
	public String getConfirmedHospital() {
		return confirmedHospital;
	}
	public void setConfirmedHospital(String confirmedHospital) {
		this.confirmedHospital = confirmedHospital;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getCurrentState() {
		return currentState;
	}
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
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
}
