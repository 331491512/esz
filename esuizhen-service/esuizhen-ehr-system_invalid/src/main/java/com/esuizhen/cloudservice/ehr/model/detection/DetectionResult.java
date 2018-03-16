package com.esuizhen.cloudservice.ehr.model.detection;


/** 
 * @ClassName: DetecTionItem.java
 * @Description: 
 * @author fanpanwei	
 * @date   2017年4月24日
 */
public class DetectionResult {
	private String detectionReportId;
	private String value;
	private String prompt;
	private Integer promptType;
	public String getDetectionReportId() {
		return detectionReportId;
	}
	public void setDetectionReportId(String detectionReportId) {
		this.detectionReportId = detectionReportId;
	}
	public String getDetectionResult() {
		return value;
	}
	public void setDetectionResult(String detectionResult) {
		this.value = detectionResult;
	}
	public Integer getPromptType() {
		return promptType;
	}
	public void setPromptType(Integer promptType) {
		this.promptType = promptType;
	}
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
}
