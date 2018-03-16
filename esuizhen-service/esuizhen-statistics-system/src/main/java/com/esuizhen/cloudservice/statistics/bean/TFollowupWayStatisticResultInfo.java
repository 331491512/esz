package com.esuizhen.cloudservice.statistics.bean;



public class TFollowupWayStatisticResultInfo extends TStatisticResultInfo {
	private static final long serialVersionUID = 1L;
	
	private TFollowupWayStatisticInfo followupWayStatistic;
	
	private Integer followupWaySearchId;
	
	private Integer outPatientFlagSearchId;
	
	private Integer followupWayTotalSearchId;

	public TFollowupWayStatisticInfo getFollowupWayStatistic() {
		return followupWayStatistic;
	}

	public void setFollowupWayStatistic(
			TFollowupWayStatisticInfo followupWayStatistic) {
		this.followupWayStatistic = followupWayStatistic;
	}

	public Integer getFollowupWaySearchId() {
		return followupWaySearchId;
	}

	public void setFollowupWaySearchId(Integer followupWaySearchId) {
		this.followupWaySearchId = followupWaySearchId;
	}

	public Integer getOutPatientFlagSearchId() {
		return outPatientFlagSearchId;
	}

	public void setOutPatientFlagSearchId(Integer outPatientFlagSearchId) {
		this.outPatientFlagSearchId = outPatientFlagSearchId;
	}

	public Integer getFollowupWayTotalSearchId() {
		return followupWayTotalSearchId;
	}

	public void setFollowupWayTotalSearchId(Integer followupWayTotalSearchId) {
		this.followupWayTotalSearchId = followupWayTotalSearchId;
	}
}
