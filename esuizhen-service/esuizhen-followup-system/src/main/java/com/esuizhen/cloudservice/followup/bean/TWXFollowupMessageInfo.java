/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.bean;<br/>  
 * <b>文件名：</b>TWXFollowupMessageInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月18日下午7:48:02<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.bean;
/** 
* @ClassName: TWXFollowupMessageInfo
* @Description: 
* @author lichenghao
* @date 2016年7月18日 下午7:48:02  
*/
public class TWXFollowupMessageInfo {
	//消息内容
	private String content;
	//回复内容
	private String replyContent;
	//回复状态  0:未回复  1：已回复
	private String replyState;
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
	public String getReplyState() {
		return replyState;
	}
	public void setReplyState(String replyState) {
		this.replyState = replyState;
	}
}
