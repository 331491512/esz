package com.esuizhen.cloudservice.user.model.followuppatient;

public class TLostFollowupSpreadItem {
	/**
	 * 未失访
	 */
	private Integer unlostFollowCount;
	/**
	 * 失访
	 */
	private Integer lostFollowCount;
	/**
	 * 其他情况
	 */
	private Integer otherConditionCount;
	/**
	 * 无人接听
	 */
	private Integer notcallCount;
	/**
	 * 空号
	 */
	private Integer emptyNumberCount;
	/**
	 * 错号
	 */
	private Integer errorNumberCount;
	/**
	 * 拒绝随访
	 */
	private Integer noFollowupCount;
	public Integer getUnlostFollowCount() {
		return unlostFollowCount;
	}
	public void setUnlostFollowCount(Integer unlostFollowCount) {
		this.unlostFollowCount = unlostFollowCount;
	}
	public Integer getLostFollowCount() {
		return lostFollowCount;
	}
	public void setLostFollowCount(Integer lostFollowCount) {
		this.lostFollowCount = lostFollowCount;
	}
	public Integer getOtherConditionCount() {
		return otherConditionCount;
	}
	public void setOtherConditionCount(Integer otherConditionCount) {
		this.otherConditionCount = otherConditionCount;
	}
	public Integer getNotcallCount() {
		return notcallCount;
	}
	public void setNotcallCount(Integer notcallCount) {
		this.notcallCount = notcallCount;
	}
	public Integer getEmptyNumberCount() {
		return emptyNumberCount;
	}
	public void setEmptyNumberCount(Integer emptyNumberCount) {
		this.emptyNumberCount = emptyNumberCount;
	}
	public Integer getErrorNumberCount() {
		return errorNumberCount;
	}
	public void setErrorNumberCount(Integer errorNumberCount) {
		this.errorNumberCount = errorNumberCount;
	}
	public Integer getNoFollowupCount() {
		return noFollowupCount;
	}
	public void setNoFollowupCount(Integer noFollowupCount) {
		this.noFollowupCount = noFollowupCount;
	}
	
}
