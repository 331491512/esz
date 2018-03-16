package com.esuizhen.cloudservice.followup.model.followupresult;

import java.util.Date;
import java.util.List;

public class TFollowupResultStatisInfo {

	private Date sendTime;

	private String contentTemplateId;

	private String content;

	private Integer sendCount;

	private Integer noFeedbackCount;

	private List<TFollowupResultValueInfo> followupResultValueList;

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getContentTemplateId() {
		return contentTemplateId;
	}

	public void setContentTemplateId(String contentTemplateId) {
		this.contentTemplateId = contentTemplateId;
	}

	public Integer getSendCount() {
		return sendCount;
	}

	public void setSendCount(Integer sendCount) {
		this.sendCount = sendCount;
	}

	public Integer getNoFeedbackCount() {
		return noFeedbackCount;
	}

	public void setNoFeedbackCount(Integer noFeedbackCount) {
		this.noFeedbackCount = noFeedbackCount;
	}

	public List<TFollowupResultValueInfo> getFollowupResultValueList() {
		return followupResultValueList;
	}

	public void setFollowupResultValueList(List<TFollowupResultValueInfo> followupResultValueList) {
		this.followupResultValueList = followupResultValueList;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
