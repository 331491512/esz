/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.bean;<br/>  
 * <b>文件名：</b>FollowupQuestionnaireResultReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年7月28日下午6:29:45<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.bean;
/** 
* @ClassName: FollowupQuestionnaireResultReq
* @Description: 
* @author lichenghao
* @date 2017年7月28日 下午6:29:45  
*/
public class FollowupQuestionnaireResultReq {
	//问卷结果Id
	private String questionnaireResultId;
	//结果计划（与问卷Id、患者Id结合确认结果）
	private String followupItemId;
	//问卷Id
	private String questionnaireId;
	//患者Id
	private Long patientId;
	public String getQuestionnaireResultId() {
		return questionnaireResultId;
	}
	public void setQuestionnaireResultId(String questionnaireResultId) {
		this.questionnaireResultId = questionnaireResultId;
	}
	public String getFollowupItemId() {
		return followupItemId;
	}
	public void setFollowupItemId(String followupItemId) {
		this.followupItemId = followupItemId;
	}
	public String getQuestionnaireId() {
		return questionnaireId;
	}
	public void setQuestionnaireId(String questionnaireId) {
		this.questionnaireId = questionnaireId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
}
