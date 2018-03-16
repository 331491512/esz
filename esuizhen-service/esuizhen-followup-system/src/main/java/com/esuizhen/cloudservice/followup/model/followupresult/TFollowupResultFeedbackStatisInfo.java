package com.esuizhen.cloudservice.followup.model.followupresult;

import java.util.List;

public class TFollowupResultFeedbackStatisInfo {

	private Long totalCount;
	
	private Integer operatorCount;

	public Integer getOperatorCount() {
		return operatorCount;
	}

	public void setOperatorCount(Integer operatorCount) {
		this.operatorCount = operatorCount;
	}

	private List<TFollowupResultValueInfo> followupResultValueList;

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public List<TFollowupResultValueInfo> getFollowupResultValueList() {
		return followupResultValueList;
	}

	public void setFollowupResultValueList(List<TFollowupResultValueInfo> followupResultValueList) {
		this.followupResultValueList = followupResultValueList;
	}
}
