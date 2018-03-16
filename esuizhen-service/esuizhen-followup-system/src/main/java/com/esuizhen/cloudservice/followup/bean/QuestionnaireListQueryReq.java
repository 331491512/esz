/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.bean;<br/>  
 * <b>文件名：</b>QuestionnaireListQueryReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月5日下午3:29:16<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.bean;
/** 
* @ClassName: QuestionnaireListQueryReq
* @Description: 
* @author lichenghao
* @date 2016年8月5日 下午3:29:16  
*/
public class QuestionnaireListQueryReq {
	private String subject;
	private String followupTaskId;//随访任务Id
	private int page;
	private int num;
	private Long author;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFollowupTaskId() {
		return followupTaskId;
	}
	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Long getAuthor() {
		return author;
	}
	public void setAuthor(Long author) {
		this.author = author;
	}
}
