package com.esuizhen.cloudservice.followup.bean;

import java.util.Date;

public class TSmsItem {

	private String content;

	private String fromMobile;

	private Date recTime;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFromMobile() {
		return fromMobile;
	}

	public void setFromMobile(String fromMobile) {
		this.fromMobile = fromMobile;
	}

	public Date getRecTime() {
		return recTime;
	}

	public void setRecTime(Date recTime) {
		this.recTime = recTime;
	}
}
