package com.esuizhen.cloudservice.statistics.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>Title:TFollowupProgressInfo</p>
 * <p>Description:随访进展统计信息bean</p>
 * @author YYCHEN
 * @date 2016年8月9日 上午10:49:49
 */
public class TFollowupProgressInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//随访任务名称
	private String followupName;
	//任务总量
	private Integer totalQuantity;
	//计划完成时间
	private Date planFinishTime;
	//已完成随访数
	private Integer finishedQuantity;
	//完成率
	private Float finishedRate;
	//有效随访数
	private Integer effectivedQuantity;
	//有效率
	private Float effectivedRate;
	//无效随访数
	private Integer invalidQuantity;
	//未完成数
	private Integer noFinishedQuantity;
	//未完成率
	private Float noFinishedRate;
	//暂存数
	private Integer temporaryQuantity;
	//尚无结果数
	private Integer notResultQuantity;
	//失访患者人数
	private Integer lossQuantity;
	//无需随访患者数
	private Integer unnecessaryFollowupQuantity;
	//尚未分配入任务人数
	private Integer notassignedQuantity;
	//随访人员姓名
	private String trueName;
	//各个随访人员明细，用于查看各个随访人员的随访量
	private List<TFollowupProgressInfo> operatorList;
	//分随访进展统计信息。
	private List<TFollowupProgressInfo> subFollowTaskList;
	
	/**
	 * 可随访患者数
	 */
	private Integer hasFollowupCount;
	/**
	 * 周期内已完成任务的患者数
	 */
	private Integer hasCycleFinishTaskCount;
	/**
	 * 任务进行中的患者人数
	 */
	private Integer followupingCount;
	/**
	 * 随访死亡人数
	 */
	private Integer followupAfterDeathCount;
	/**
	 * 患者总数（排除防癌办患者）
	 */
	private Integer totalNum;
	public Integer getNotassignedQuantity() {
		return notassignedQuantity;
	}
	public void setNotassignedQuantity(Integer notassignedQuantity) {
		this.notassignedQuantity = notassignedQuantity;
	}
	public Integer getLossQuantity() {
		return lossQuantity;
	}
	public void setLossQuantity(Integer lossQuantity) {
		this.lossQuantity = lossQuantity;
	}
	public Integer getUnnecessaryFollowupQuantity() {
		return unnecessaryFollowupQuantity;
	}
	public void setUnnecessaryFollowupQuantity(Integer unnecessaryFollowupQuantity) {
		this.unnecessaryFollowupQuantity = unnecessaryFollowupQuantity;
	}
	public Float getEffectivedRate() {
		return effectivedRate;
	}
	public void setEffectivedRate(Float effectivedRate) {
		this.effectivedRate = effectivedRate;
	}
	public Float getFinishedRate() {
		return finishedRate;
	}
	public void setFinishedRate(Float finishedRate) {
		this.finishedRate = finishedRate;
	}
	public Float getNoFinishedRate() {
		return noFinishedRate;
	}
	public void setNoFinishedRate(Float noFinishedRate) {
		this.noFinishedRate = noFinishedRate;
	}
	public String getFollowupName() {
		return followupName;
	}
	public void setFollowupName(String followupName) {
		this.followupName = followupName;
	}
	public Integer getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public Date getPlanFinishTime() {
		return planFinishTime;
	}
	public void setPlanFinishTime(Date planFinishTime) {
		this.planFinishTime = planFinishTime;
	}
	public Integer getFinishedQuantity() {
		return finishedQuantity;
	}
	public void setFinishedQuantity(Integer finishedQuantity) {
		this.finishedQuantity = finishedQuantity;
	}
	public Integer getEffectivedQuantity() {
		return effectivedQuantity;
	}
	public void setEffectivedQuantity(Integer effectivedQuantity) {
		this.effectivedQuantity = effectivedQuantity;
	}
	public Integer getInvalidQuantity() {
		return invalidQuantity;
	}
	public void setInvalidQuantity(Integer invalidQuantity) {
		this.invalidQuantity = invalidQuantity;
	}
	public Integer getNoFinishedQuantity() {
		return noFinishedQuantity;
	}
	public void setNoFinishedQuantity(Integer noFinishedQuantity) {
		this.noFinishedQuantity = noFinishedQuantity;
	}
	public Integer getTemporaryQuantity() {
		return temporaryQuantity;
	}
	public void setTemporaryQuantity(Integer temporaryQuantity) {
		this.temporaryQuantity = temporaryQuantity;
	}
	public Integer getNotResultQuantity() {
		return notResultQuantity;
	}
	public void setNotResultQuantity(Integer notResultQuantity) {
		this.notResultQuantity = notResultQuantity;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public List<TFollowupProgressInfo> getOperatorList() {
		return operatorList;
	}
	public void setOperatorList(List<TFollowupProgressInfo> operatorList) {
		this.operatorList = operatorList;
	}
	public List<TFollowupProgressInfo> getSubFollowTaskList() {
		return subFollowTaskList;
	}
	public void setSubFollowTaskList(List<TFollowupProgressInfo> subFollowTaskList) {
		this.subFollowTaskList = subFollowTaskList;
	}
	public Integer getHasFollowupCount() {
		return hasFollowupCount;
	}
	public void setHasFollowupCount(Integer hasFollowupCount) {
		this.hasFollowupCount = hasFollowupCount;
	}
	public Integer getHasCycleFinishTaskCount() {
		return hasCycleFinishTaskCount;
	}
	public void setHasCycleFinishTaskCount(Integer hasCycleFinishTaskCount) {
		this.hasCycleFinishTaskCount = hasCycleFinishTaskCount;
	}
	public Integer getFollowupingCount() {
		return followupingCount;
	}
	public void setFollowupingCount(Integer followupingCount) {
		this.followupingCount = followupingCount;
	}
	public Integer getFollowupAfterDeathCount() {
		return followupAfterDeathCount;
	}
	public void setFollowupAfterDeathCount(Integer followupAfterDeathCount) {
		this.followupAfterDeathCount = followupAfterDeathCount;
	}
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
}
