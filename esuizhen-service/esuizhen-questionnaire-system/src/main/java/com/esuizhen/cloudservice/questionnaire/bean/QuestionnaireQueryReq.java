/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.bean;<br/>  
 * <b>文件名：</b>QuestionnaireQueryReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月26日上午10:53:07<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.questionnaire.bean;
/** 
* @ClassName: QuestionnaireQueryReq
* @Description: 
* @author lichenghao
* @date 2016年8月26日 上午10:53:07  
*/
public class QuestionnaireQueryReq {
	
	/**
	 * 问卷Id
	 */
	private String questionnaireId;
	/**
	 * 问卷模版Id
	 */
	private String contentTemplateId;

	
	/**
	 * 患者Id
	 */
	private String patientId;
	
	/**
	 * 病种Id
	 */
	private String diseaseTypeId;

	public String getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(String questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public String getContentTemplateId() {
		return contentTemplateId;
	}

	public void setContentTemplateId(String contentTemplateId) {
		this.contentTemplateId = contentTemplateId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getDiseaseTypeId() {
		return diseaseTypeId;
	}

	public void setDiseaseTypeId(String diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}
}
