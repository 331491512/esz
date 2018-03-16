/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.bean<br/>  
 * <b>文件名：</b>FollowupContentTemplateQueryReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月11日下午4:53:11<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.bean;
 
/** 
* @ClassName: FollowupContentTemplateQueryReq
* @Description: 
* @author NiDan
* @date 2016年8月11日下午4:53:11 
*/
public class FollowupContentTemplateQueryReq {
	
	private Integer contentTemplateType;
	private String contentTemplateName;
	private Integer needReply;
	private String followupTaskId; 
	private Long author;
	private Integer page;
	private Integer num;
	
	public Integer getContentTemplateType() {
		return contentTemplateType;
	}
	public void setContentTemplateType(Integer contentTemplateType) {
		this.contentTemplateType = contentTemplateType;
	}
	public String getContentTemplateName() {
		return contentTemplateName;
	}
	public void setContentTemplateName(String contentTemplateName) {
		this.contentTemplateName = contentTemplateName;
	}
	public Integer getNeedReply() {
		return needReply;
	}
	public void setNeedReply(Integer needReply) {
		this.needReply = needReply;
	}
	public String getFollowupTaskId() {
		return followupTaskId;
	}
	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Long getAuthor() {
		return author;
	}
	public void setAuthor(Long author) {
		this.author = author;
	}

}
