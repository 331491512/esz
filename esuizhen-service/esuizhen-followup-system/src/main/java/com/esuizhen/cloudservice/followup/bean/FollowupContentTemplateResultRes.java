/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.bean<br/>  
 * <b>文件名：</b>FollowupContentTemplateResultRes.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月30日下午2:47:02<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.bean;

/**
 * @ClassName: FollowupContentTemplateResultRes
 * @Description:
 * @author NiDan
 * @date 2016年8月30日下午2:47:02
 */
public class FollowupContentTemplateResultRes {

	private String contentTemplateId;
	private String contentTemplateName;
	private Integer contentTemplateType;
	private String content;
	private Integer needReply;
	private Integer isPublish;
	private Integer isInUsage;

	public String getContentTemplateId() {
		return contentTemplateId;
	}

	public void setContentTemplateId(String contentTemplateId) {
		this.contentTemplateId = contentTemplateId;
	}

	public String getContentTemplateName() {
		return contentTemplateName;
	}

	public void setContentTemplateName(String contentTemplateName) {
		this.contentTemplateName = contentTemplateName;
	}

	public Integer getContentTemplateType() {
		return contentTemplateType;
	}

	public void setContentTemplateType(Integer contentTemplateType) {
		this.contentTemplateType = contentTemplateType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getNeedReply() {
		return needReply;
	}

	public void setNeedReply(Integer needReply) {
		this.needReply = needReply;
	}

	public Integer getIsPublish() {
		return isPublish;
	}

	public void setIsPublish(Integer isPublish) {
		this.isPublish = isPublish;
	}

	public Integer getIsInUsage() {
		return isInUsage;
	}

	public void setIsInUsage(Integer isInUsage) {
		this.isInUsage = isInUsage;
	}

}
