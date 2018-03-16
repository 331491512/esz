/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.bean;<br/>  
 * <b>文件名：</b>TDiagnosisItemDetail.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月3日上午11:37:47<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.bean;
/** 
* @ClassName: TDiagnosisItemDetail
* @Description: 检验项目详细信息
* @author lichenghao
* @date 2016年5月3日 上午11:37:47  
*/
public class TDetectionItemInfo {
	
	private String detectionDetailId;
	private String detectionReportId;
	
	private Long patientId;
	private String patientNo;
	private String detectionItemId;
	private String detectionItemCode;
	private String detectionTypeName;
	private String detectionItemEnglishName;
	//检验项名称
	private String detectionItemName;
	//检验结果
	private String detectionResult;
	//单位
	private String unit;
	//参考范围（下限）
	private String refrenceRangeMin;
	//参考范围（上限）
	private String refrenceRangeMax;
	//参考范围
	private String refrenceRange;
	//提示
	private String prompt;
	
	private Integer promptType;
	
	
	public String getDetectionDetailId() {
		return detectionDetailId;
	}
	public void setDetectionDetailId(String detectionDetailId) {
		this.detectionDetailId = detectionDetailId;
	}
	public String getDetectionItemName() {
		return detectionItemName;
	}
	public String getDetectionItemId() {
		return detectionItemId;
	}
	public void setDetectionItemId(String detectionItemId) {
		this.detectionItemId = detectionItemId;
	}
	public String getDetectionItemCode() {
		return detectionItemCode;
	}
	public void setDetectionItemCode(String detectionItemCode) {
		this.detectionItemCode = detectionItemCode;
	}
	public String getDetectionTypeName() {
		return detectionTypeName;
	}
	public void setDetectionTypeName(String detectionTypeName) {
		this.detectionTypeName = detectionTypeName;
	}
	public String getDetectionItemEnglishName() {
		return detectionItemEnglishName;
	}
	public void setDetectionItemEnglishName(String detectionItemEnglishName) {
		this.detectionItemEnglishName = detectionItemEnglishName;
	}
	public String getDetectionReportId() {
		return detectionReportId;
	}
	public void setDetectionReportId(String detectionReportId) {
		this.detectionReportId = detectionReportId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public void setDetectionItemName(String detectionItemName) {
		this.detectionItemName = detectionItemName;
	}
	public String getDetectionResult() {
		return detectionResult;
	}
	public void setDetectionResult(String detectionResult) {
		this.detectionResult = detectionResult;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getRefrenceRangeMin() {
		return refrenceRangeMin;
	}
	public void setRefrenceRangeMin(String refrenceRangeMin) {
		this.refrenceRangeMin = refrenceRangeMin;
	}
	public String getRefrenceRangeMax() {
		return refrenceRangeMax;
	}
	public void setRefrenceRangeMax(String refrenceRangeMax) {
		this.refrenceRangeMax = refrenceRangeMax;
	}
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public String getRefrenceRange() {
		return refrenceRange;
	}
	public void setRefrenceRange(String refrenceRange) {
		this.refrenceRange = refrenceRange;
	}
	public Integer getPromptType() {
		return promptType;
	}
	public void setPromptType(Integer promptType) {
		this.promptType = promptType;
	}
	
}
