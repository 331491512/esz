/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.model.conf<br/>  
 * <b>文件名：</b>TFollowupContentTemplateInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月10日下午4:34:09<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.model.conf;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: TFollowupContentTemplateInfo
* @Description: 
* @author NiDan
* @date 2016年8月10日下午4:34:09 
*/
public class TFollowupContentTemplateInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3720531906929603211L;
	
	/**
	 * 随访内容模板ID
	 */
	private String contentTemplateId;
	
	/**
	 * 模板名称
	 */
	private String contentTemplateName;
	
	/**
	 * 模板类型
	 */
	private Integer contentTemplateType;
	
	/**
	 * 模板内容
	 */
	private String content;
	
	/**
	 * 签名
	 */
	private String signature;
	
	/**
	 * 是否需要回复
	 */
	private Integer needReply;
	
	/**
	 * 自动回复内容
	 */
	private String autoReplyContent;
	
	/**
	 * 创建者ID
	 */
	private Integer author;
	
	/**
	 * 是否公开
	 */
	private Integer isPublish;
	
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	
	/**
	 * 记录更新时间
	 */
	private Date updateTime;
	
	public TFollowupContentTemplateInfo() {
		
	}

	public TFollowupContentTemplateInfo(String contentTemplateId, String contentTemplateName, Integer contentTemplateType,
			String content, String signature, Integer needReply, String autoReplyContent, Integer author,
			Integer isPublish, Date createTime, Date updateTime) {
		super();
		this.contentTemplateId = contentTemplateId;
		this.contentTemplateName = contentTemplateName;
		this.contentTemplateType = contentTemplateType;
		this.content = content;
		this.signature = signature;
		this.needReply = needReply;
		this.autoReplyContent = autoReplyContent;
		this.author = author;
		this.isPublish = isPublish;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

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

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getAutoReplyContent() {
		return autoReplyContent;
	}

	public void setAutoReplyContent(String autoReplyContent) {
		this.autoReplyContent = autoReplyContent;
	}

	public Integer getAuthor() {
		return author;
	}

	public void setAuthor(Integer author) {
		this.author = author;
	}

	public Integer getIsPublish() {
		return isPublish;
	}

	public void setIsPublish(Integer isPublish) {
		this.isPublish = isPublish;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
