package com.esuizhen.cloudservice.user.bean.followuppatient;

import java.util.Date;

/**
 * 2017-8-8 17:10:46
 * 
 * @author zhuguo
 *
 */
public class PatientConfirmedDateReq {
	// 患者id
	private Long patientId;

	// 操作者id
	private Long operatorId;

	// 操作者姓名
	private String operatorName;

	// 原确诊时间
	private Date oldConfirmedDate;

	// 原确诊时间状态
	private String confirmedDateSource;

	// 现确诊时间
	private Date confirmedDate;

	// 修改时间
	private Date updateDate;

	// 修改次数
	private int confirmedDateModCount;

	public int getConfirmedDateModCount() {
		return confirmedDateModCount;
	}

	public void setConfirmedDateModCount(int confirmedDateModCount) {
		this.confirmedDateModCount = confirmedDateModCount;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public Date getOldConfirmedDate() {
		return oldConfirmedDate;
	}

	public void setOldConfirmedDate(Date oldConfirmedDate) {
		this.oldConfirmedDate = oldConfirmedDate;
	}

	public String getConfirmedDateSource() {
		return confirmedDateSource;
	}

	public void setConfirmedDateSource(String confirmedDateSource) {
		this.confirmedDateSource = confirmedDateSource;
	}

	public Date getConfirmedDate() {
		return confirmedDate;
	}

	public void setConfirmedDate(Date confirmedDate) {
		this.confirmedDate = confirmedDate;
	}

}
