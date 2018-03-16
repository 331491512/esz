/**
 * 
 */
package com.esuizhen.cloudservice.followup.model.followup;

/**
 * @author DaLoong
 * @date  2016-8-10 下午4:06:22
 */
public class TFollowupContentTemplateSimpleInfo {

	String contentTemplateId	;//	随访内容模板ID。主键。
	 //唯一标识一个随访内容模板。格式：
	 //CONTYYYYMMDDHHMMSSnnnnnn。
	 //如：CONT20151110152701000001。
	String contentTemplateName	;//	模板名称。如短信模板、微信模板
	Integer contentTemplateType	;//	模板类型：
	 //1：短信模板；4：微信模板 
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
	/**
	 * @return the contentTemplateName
	 */
	public String getContentTemplateName() {
		return contentTemplateName;
	}
	/**
	 * @param contentTemplateName the contentTemplateName to set
	 */
	public void setContentTemplateName(String contentTemplateName) {
		this.contentTemplateName = contentTemplateName;
	}
	/**
	 * @return the contentTemplateType
	 */
	public Integer getContentTemplateType() {
		return contentTemplateType;
	}
	/**
	 * @param contentTemplateType the contentTemplateType to set
	 */
	public void setContentTemplateType(Integer contentTemplateType) {
		this.contentTemplateType = contentTemplateType;
	}

	
}
