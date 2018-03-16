/**
 * 
 */
package com.esuizhen.cloudservice.followup.model.meta;

/**
 * @author DaLoong
 * @date  2016-8-13 下午2:41:30
 */
public class FollowupResultValue {
	Integer  followupResultValueId ;//随访结果类型ID。主键。
	String   followupResultValueName	;//	随访结果类型名称
	Integer  type	;//结果类型。1: 有效结果；2：无效结果
	
	/**
	 * @return the followupResultValueId
	 */
	public Integer getFollowupResultValueId() {
		return followupResultValueId;
	}
	/**
	 * @param followupResultValueId the followupResultValueId to set
	 */
	public void setFollowupResultValueId(Integer followupResultValueId) {
		this.followupResultValueId = followupResultValueId;
	}
	/**
	 * @return the followupResultValueName
	 */
	public String getFollowupResultValueName() {
		return followupResultValueName;
	}
	/**
	 * @param followupResultValueName the followupResultValueName to set
	 */
	public void setFollowupResultValueName(String followupResultValueName) {
		this.followupResultValueName = followupResultValueName;
	}
	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	
}
