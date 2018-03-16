package com.esuizhen.cloudservice.statistics.bean;

import java.io.Serializable;
import java.util.Date;

public class TCommonParam implements Serializable {
	private static final long serialVersionUID = 1L;

	// 页码
	private Integer page;
	// 每页大小
	private Integer num;
	// 用户ID
	private Long userId;
	// 开始日期
	private Date beginDate;
	// 结束日期
	private Date endDate;
	// 操作人ID，对应docotrId
	private Long operator;
	// 统计类别；10：按科室统计，20：按随访人员统计，30：按病种统计
	private Integer category;
	// 随访结果统计方法 0：按人次统计；1：按人数统计;
	private Integer statisticsMode;

	// 随访结果为其他时的类型 1：有效 2：无效
	private Integer otherFollowupResultType;

	// 问卷名称. 可选，支持模糊查询。
	private String subject;
	// 随访任务名称。可选，支持模糊查询。
	private String followupTaskName;
	// 随访任务状态
	private Integer state;
	/*
	 * 统计方式: 1：按随访人员统计; 2：按随访任务统计;
	 * 4：按病种统计
	 */
	private Integer statisticsMethods;
	/**
	 * 数据来源标识。1：B端填写（短信和电话）【默认】
	 * 2：微信端患者填写；
	 * 3：院内(同步);【随访结果同步服务端需要过滤掉此标识的记录】
	 * 4：医生填写 5：历史导入； 6：自动生成(门诊生存/住院生存)
	 */
	private Integer sourceFlag;

	/**
	 * 患者范围
	 */
	private Integer patientRangeFlag;
	/**
	 * 随访范围
	 */
	private Integer followupRangeFlag;

	// 病种类型
	private String sourceTumorFlags;

	/**
	 * 随访方式
	 */
	private String followupWay;
	/**
	 * 随访次数
	 */
	private Integer followupTimes;

	private String sql; // 数据权限拼接的sql

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public TCommonParam() {
		this.page = 0;
		this.num = 10;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getFollowupTaskName() {
		return followupTaskName;
	}

	public void setFollowupTaskName(String followupTaskName) {
		this.followupTaskName = followupTaskName;
	}

	public Integer getStatisticsMode() {
		return statisticsMode;
	}

	public void setStatisticsMode(Integer statisticsMode) {
		this.statisticsMode = statisticsMode;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getOtherFollowupResultType() {
		return otherFollowupResultType;
	}

	public void setOtherFollowupResultType(Integer otherFollowupResultType) {
		this.otherFollowupResultType = otherFollowupResultType;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
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

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getStatisticsMethods() {
		return statisticsMethods;
	}

	public void setStatisticsMethods(Integer statisticsMethods) {
		this.statisticsMethods = statisticsMethods;
	}

	public Integer getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public Integer getPatientRangeFlag() {
		return patientRangeFlag;
	}

	public void setPatientRangeFlag(Integer patientRangeFlag) {
		this.patientRangeFlag = patientRangeFlag;
	}

	public Integer getFollowupRangeFlag() {
		return followupRangeFlag;
	}

	public void setFollowupRangeFlag(Integer followupRangeFlag) {
		this.followupRangeFlag = followupRangeFlag;
	}

	public String getFollowupWay() {
		return followupWay;
	}

	public void setFollowupWay(String followupWay) {
		this.followupWay = followupWay;
	}

	public Integer getFollowupTimes() {
		return followupTimes;
	}

	public void setFollowupTimes(Integer followupTimes) {
		this.followupTimes = followupTimes;
	}

	public String getSourceTumorFlags() {
		return sourceTumorFlags;
	}

	public void setSourceTumorFlags(String sourceTumorFlags) {
		this.sourceTumorFlags = sourceTumorFlags;
	}
}
