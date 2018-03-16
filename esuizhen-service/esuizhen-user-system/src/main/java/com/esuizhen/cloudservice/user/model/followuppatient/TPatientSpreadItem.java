package com.esuizhen.cloudservice.user.model.followuppatient;

public class TPatientSpreadItem {
	/**
	 * 患者总数
	 */
	private Integer totalCount;
	/**
	 * 待随访总数
	 */
	private Integer waitFollowupCount;
	/**
	 * 随访进行中患者总数
	 */
	private Integer followupingCount;
	/**
	 * 无需随访患者总数
	 */
	private Integer noFollowupCount;
	/**
	 * 失访患者总数
	 */
	private Integer lostFollowupCount;
	/**
	 * 疑似重复患者总数
	 */
	private Integer similarCount;
	/**
	 * 核心数据缺失/疑似错误患者总数
	 */
	private Integer faultCount;
	/**
	 * 核心数据缺失总数
	 */
	private Integer missingCount;
	/**
	 * 疑似错误患者总数
	 */
	private Integer invalidCount;
	/**
	 * 261新增属性
	 * @return
	 */
	
	/**
	 * 周期内已完成任务的患者数
	 */
	private Integer hasCycleFinishTaskCount;
	/**
	 * 尚未分入任务患者数
	 */
	private Integer unassignTaskCount;
	/**
	 * 随访死亡人数
	 */
	private Integer followupAfterDeathCount;
	/**
	 * 随访失访人数
	 */
	private Integer followupAfterLostCount;
	/**
	 * 随访过的无需随访患者总数
	 */
	private Integer followupAfterNotCount;
	/**
	 * 当前可随访患者总数
	 */
	private Integer currentFollowupCount;
	
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getWaitFollowupCount() {
		return waitFollowupCount;
	}
	public void setWaitFollowupCount(Integer waitFollowupCount) {
		this.waitFollowupCount = waitFollowupCount;
	}
	public Integer getFollowupingCount() {
		return followupingCount;
	}
	public void setFollowupingCount(Integer followupingCount) {
		this.followupingCount = followupingCount;
	}
	public Integer getNoFollowupCount() {
		return noFollowupCount;
	}
	public void setNoFollowupCount(Integer noFollowupCount) {
		this.noFollowupCount = noFollowupCount;
	}
	public Integer getLostFollowupCount() {
		return lostFollowupCount;
	}
	public void setLostFollowupCount(Integer lostFollowupCount) {
		this.lostFollowupCount = lostFollowupCount;
	}
	public Integer getSimilarCount() {
		return similarCount;
	}
	public void setSimilarCount(Integer similarCount) {
		this.similarCount = similarCount;
	}
	public Integer getFaultCount() {
		return faultCount;
	}
	public void setFaultCount(Integer faultCount) {
		this.faultCount = faultCount;
	}
	public Integer getMissingCount() {
		return missingCount;
	}
	public void setMissingCount(Integer missingCount) {
		this.missingCount = missingCount;
	}
	public Integer getInvalidCount() {
		return invalidCount;
	}
	public void setInvalidCount(Integer invalidCount) {
		this.invalidCount = invalidCount;
	}
	public Integer getHasCycleFinishTaskCount() {
		return hasCycleFinishTaskCount;
	}
	public void setHasCycleFinishTaskCount(Integer hasCycleFinishTaskCount) {
		this.hasCycleFinishTaskCount = hasCycleFinishTaskCount;
	}
	public Integer getUnassignTaskCount() {
		return unassignTaskCount;
	}
	public void setUnassignTaskCount(Integer unassignTaskCount) {
		this.unassignTaskCount = unassignTaskCount;
	}
	public Integer getFollowupAfterDeathCount() {
		return followupAfterDeathCount;
	}
	public void setFollowupAfterDeathCount(Integer followupAfterDeathCount) {
		this.followupAfterDeathCount = followupAfterDeathCount;
	}
	public Integer getFollowupAfterLostCount() {
		return followupAfterLostCount;
	}
	public void setFollowupAfterLostCount(Integer followupAfterLostCount) {
		this.followupAfterLostCount = followupAfterLostCount;
	}
	public Integer getFollowupAfterNotCount() {
		return followupAfterNotCount;
	}
	public void setFollowupAfterNotCount(Integer followupAfterNotCount) {
		this.followupAfterNotCount = followupAfterNotCount;
	}
	public Integer getCurrentFollowupCount() {
		return currentFollowupCount;
	}
	public void setCurrentFollowupCount(Integer currentFollowupCount) {
		this.currentFollowupCount = currentFollowupCount;
	}
	
}
