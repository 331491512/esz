/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.bean;<br/>  
 * <b>文件名：</b>QuestionnaireResultListReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年9月5日上午10:26:00<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.questionnaire.bean;
/** 
* @ClassName: QuestionnaireResultListReq
* @Description: 
* @author lichenghao
* @date 2016年9月5日 上午10:26:00  
*/
public class QuestionnaireResultListReq {
	//随访计划项Id
	private String followupItemId;
	//患者Id
	private Long patientId;
	//问卷标题
	private String subject;
	//请求标识
	private Integer reqFlag;
	//分页索引
	private Integer page;
	//每页个数
	private Integer num;
	public String getFollowupItemId() {
		return followupItemId;
	}
	public void setFollowupItemId(String followupItemId) {
		this.followupItemId = followupItemId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Integer getReqFlag() {
		return reqFlag;
	}
	public void setReqFlag(Integer reqFlag) {
		this.reqFlag = reqFlag;
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
}
