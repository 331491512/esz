/**
 * 
 */
package com.esuizhen.cloudservice.followup.model.followuptask;

/**
 * @author DaLoong
 * @date  2016-8-11 下午5:24:46
 */
public class TFollowupTaskContentTemplateRelation {

	String followupTaskId;
	String contentTemplateId;
	String contentTemplateName;
	int    contentTemplateType;//1：短信模板；4：微信模板；6：调查问卷
	
	/**
	 * @return the contentTemplateType
	 */
	public int getContentTemplateType() {
		return contentTemplateType;
	}
	/**
	 * @param contentTemplateType the contentTemplateType to set
	 */
	public void setContentTemplateType(int contentTemplateType) {
		this.contentTemplateType = contentTemplateType;
	}
	/**
	 * @return the followupTaskId
	 */
	public String getFollowupTaskId() {
		return followupTaskId;
	}
	/**
	 * @param followupTaskId the followupTaskId to set
	 */
	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}
	/**
	 * @return the contentTemplateId
	 */
	public String getContentTemplateId() {
		return contentTemplateId;
	}
	/**
	 * @param contentTemplateId the contentTemplateId to set
	 */
	public void setContentTemplateId(String contentTemplateId) {
		this.contentTemplateId = contentTemplateId;
	}
	public String getContentTemplateName() {
		return contentTemplateName;
	}
	public void setContentTemplateName(String contentTemplateName) {
		this.contentTemplateName = contentTemplateName;
	}
	
	
}
