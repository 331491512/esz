/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.bean;<br/>  
 * <b>文件名：</b>FollowupWXSendReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月18日下午7:12:31<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.questionnaire.bean;

import java.util.Date;

/**
 * @ClassName: FollowupWXSendReq
 * @Description:
 * @author lichenghao
 * @date 2016年7月18日 下午7:12:31
 */
public class WXSendReq {
	// 微信Id
	private String openId;
	// 模版编号
	private String templateId;
	// 医院编号
	private Integer hospitalId;
	// 随访日期
	private Date followupDate;
	// 随访者姓名
	private String trueName;
	// 消息编号
	private String messageId;
	// 发送状态
	private Integer state;
	// 签名
	private String signature;
	// 内容
	private String content;
	// 回复内容
	private String replyContent;
	
	private String url;

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Date getFollowupDate() {
		return followupDate;
	}

	public void setFollowupDate(Date followupDate) {
		this.followupDate = followupDate;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
