package com.esuizhen.cloudservice.statistics.bean;

import java.io.Serializable;

/**
 * <p>Title:TFollowupWayProgressInfo</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年8月10日 下午4:14:16
 */
public class TFollowupWayProgressInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//随访方式ID
	private Integer followupWayId;
	//随访方式名称
	private String followupWayName;
	//该方式随访的患者总数
	private Integer totalQuantity;
	//成功随访数
	private Integer finishedQuantity;
	//回复数（短信随访回复）
	private Integer replyQuantity;
	//未回复数（短信随访回复）
	private Integer unreplyQuantity;
	//发送失败数
	private Integer failQuantity;
	//有效随访数
	private Integer effectivedQuantity;
	//无效随访数
	private Integer invalidQuantity;
	//门诊数
	private Integer outpatientQuantity;
	//住院数
	private Integer inhospitalQuantity;
	public Integer getOutpatientQuantity() {
		return outpatientQuantity;
	}
	public void setOutpatientQuantity(Integer outpatientQuantity) {
		this.outpatientQuantity = outpatientQuantity;
	}
	public Integer getInhospitalQuantity() {
		return inhospitalQuantity;
	}
	public void setInhospitalQuantity(Integer inhospitalQuantity) {
		this.inhospitalQuantity = inhospitalQuantity;
	}
	public Integer getInvalidQuantity() {
		return invalidQuantity;
	}
	public void setInvalidQuantity(Integer invalidQuantity) {
		this.invalidQuantity = invalidQuantity;
	}
	public Integer getUnreplyQuantity() {
		return unreplyQuantity;
	}
	public void setUnreplyQuantity(Integer unreplyQuantity) {
		this.unreplyQuantity = unreplyQuantity;
	}
	public Integer getFailQuantity() {
		return failQuantity;
	}
	public void setFailQuantity(Integer failQuantity) {
		this.failQuantity = failQuantity;
	}
	public Integer getFollowupWayId() {
		return followupWayId;
	}
	public void setFollowupWayId(Integer followupWayId) {
		this.followupWayId = followupWayId;
	}
	public String getFollowupWayName() {
		return followupWayName;
	}
	public void setFollowupWayName(String followupWayName) {
		this.followupWayName = followupWayName;
	}
	public Integer getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public Integer getFinishedQuantity() {
		return finishedQuantity;
	}
	public void setFinishedQuantity(Integer finishedQuantity) {
		this.finishedQuantity = finishedQuantity;
	}
	public Integer getReplyQuantity() {
		return replyQuantity;
	}
	public void setReplyQuantity(Integer replyQuantity) {
		this.replyQuantity = replyQuantity;
	}
	public Integer getEffectivedQuantity() {
		return effectivedQuantity;
	}
	public void setEffectivedQuantity(Integer effectivedQuantity) {
		this.effectivedQuantity = effectivedQuantity;
	}
}
