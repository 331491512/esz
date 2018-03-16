package com.esuizhen.cloudservice.followup.bean;

import java.util.Date;

public class FollowupResultReq {

	private String templateId;
	
	private String startSendTime;
	
	private String endSendTime;
	
	private Integer followupWay;
	
	private Integer userRole;
	
	private Long operator;
	
	private Integer page;
	
	private Integer num;
	
	/**
	 * param update lichenghao 
	 */
	/**
	 * 随访状态
	 */
	private Integer followupResultValue;
	/**
	 * 复发部位
	 */
	private String relapseParts;
	/**
	 * 复发时间
	 */
	private Date relapseDate;
	/** 
	 * 转移部位
	 */
	private String transferParts;
	
	/**
	 *转移时间 
	 */
	private Date transferDate;
	
	/**
	 * 死亡日期
	 */
	private Date deathDate;
	
	/**
	 * 死亡原因
	 */
	private String deathCause;
	
	/**
	 * 其他原因
	 */
	private String otherCause;
	
	/**
	 * 医院编号
	 */
	private Integer hospitalId;
	
	/**
	 * 患者编号
	 */
	private Long patientId;
	/**
	 * 数据来源标识。
		1：B端填写（短信和电话）
		2：微信端患者填写；
		3：院内(同步);【随访结果同步服务端需要过滤掉此标识的记录】
		4：:医生填写

	 */
	private Integer sourceFlag;
	
	/**
	 * 随访时间
	 */
	private Date followupTime;
	// 权限sql
	private String sql;

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getStartSendTime() {
		return startSendTime;
	}

	public void setStartSendTime(String startSendTime) {
		this.startSendTime = startSendTime;
	}

	public String getEndSendTime() {
		return endSendTime;
	}

	public void setEndSendTime(String endSendTime) {
		this.endSendTime = endSendTime;
	}

	public Integer getFollowupWay() {
		return followupWay;
	}

	public void setFollowupWay(Integer followupWay) {
		this.followupWay = followupWay;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getFollowupResultValue() {
		return followupResultValue;
	}

	public void setFollowupResultValue(Integer followupResultValue) {
		this.followupResultValue = followupResultValue;
	}

	public String getRelapseParts() {
		return relapseParts;
	}

	public void setRelapseParts(String relapseParts) {
		this.relapseParts = relapseParts;
	}


	public String getTransferParts() {
		return transferParts;
	}

	public void setTransferParts(String transferParts) {
		this.transferParts = transferParts;
	}

	public String getOtherCause() {
		return otherCause;
	}

	public void setOtherCause(String otherCause) {
		this.otherCause = otherCause;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Integer getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}


	public String getDeathCause() {
		return deathCause;
	}

	public void setDeathCause(String deathCause) {
		this.deathCause = deathCause;
	}

	public Date getFollowupTime() {
		return followupTime;
	}

	public void setFollowupTime(Date followupTime) {
		this.followupTime = followupTime;
	}

	public Date getRelapseDate() {
		return relapseDate;
	}

	public void setRelapseDate(Date relapseDate) {
		this.relapseDate = relapseDate;
	}

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}
}
