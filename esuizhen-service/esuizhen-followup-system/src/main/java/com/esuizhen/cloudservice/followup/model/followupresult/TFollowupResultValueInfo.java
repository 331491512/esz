package com.esuizhen.cloudservice.followup.model.followupresult;

public class TFollowupResultValueInfo {

	/**
	 * 随访结果类型ID。主键。
	 */
	private Integer followupResultValueId;

	/**
	 * 随访结果类型名称
	 */
	private String followupResultValueName;

	/**
	 * 结果类型。1: 有效结果；2：无效结果
	 */
	private Integer type;

	/**
	 * 随访结果类型对应患者数
	 */
	private Integer count;

	public Integer getFollowupResultValueId() {
		return followupResultValueId;
	}

	public void setFollowupResultValueId(Integer followupResultValueId) {
		this.followupResultValueId = followupResultValueId;
	}

	public String getFollowupResultValueName() {
		return followupResultValueName;
	}

	public void setFollowupResultValueName(String followupResultValueName) {
		this.followupResultValueName = followupResultValueName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
