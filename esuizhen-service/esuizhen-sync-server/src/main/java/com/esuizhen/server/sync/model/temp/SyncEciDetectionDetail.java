package com.esuizhen.server.sync.model.temp;

import java.io.Serializable;
import java.util.Date;

/**
 * 檢查詳情bean
 * @author LHY
 */
public class SyncEciDetectionDetail implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	private String detectionDetailId;  
	private String detectionReportId;   
	private Long patientId;  
	private String patientUuid;  
	private String patientNo;   
	private Integer seqNo;   
	private String detectionTypeName;  
	private Integer detectionItemId;   
	private String detectionItemCode;   
	private String detectionItemName;   
	private String detectionItemEnglishName;   
	private String detectionResult;  
	private String prompt;   
	private Integer promptType;   
	private Integer resultType;  
	private String unit;   
	private String refrenceRange;   
	private String refrenceRangeMin;   
	private String refrenceRangeMax;   
	private String detectionMethod;   
	private String reagentBrand;   
	private String instrument;   
	private Date createTime;  
	private Date updateTime;   
	private String rawDetectionItemCode;  
	private Long mainID;   
	private Long detailID;   
	private Date rawCreateTime;   
	private Integer mergeFlag;   
	private Long mergeFrom;   
	private String mergeFromUuid;   
	private Long mergeTarget;  
	private String mergeTargetUuid;   
	private Date mergeTime;
	private String batchId;
	private Integer sourceFlag;
	
	public Integer getSourceFlag() {
		return sourceFlag;
	}
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	public String getDetectionDetailId() {
		return detectionDetailId;
	}
	public void setDetectionDetailId(String detectionDetailId) {
		this.detectionDetailId = detectionDetailId;
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
	public String getPatientUuid() {
		return patientUuid;
	}
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public Integer getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
	public String getDetectionTypeName() {
		return detectionTypeName;
	}
	public void setDetectionTypeName(String detectionTypeName) {
		this.detectionTypeName = detectionTypeName;
	}
	public Integer getDetectionItemId() {
		return detectionItemId;
	}
	public void setDetectionItemId(Integer detectionItemId) {
		this.detectionItemId = detectionItemId;
	}
	public String getDetectionItemCode() {
		return detectionItemCode;
	}
	public void setDetectionItemCode(String detectionItemCode) {
		this.detectionItemCode = detectionItemCode;
	}
	public String getDetectionItemName() {
		return detectionItemName;
	}
	public void setDetectionItemName(String detectionItemName) {
		this.detectionItemName = detectionItemName;
	}
	public String getDetectionItemEnglishName() {
		return detectionItemEnglishName;
	}
	public void setDetectionItemEnglishName(String detectionItemEnglishName) {
		this.detectionItemEnglishName = detectionItemEnglishName;
	}
	public String getDetectionResult() {
		return detectionResult;
	}
	public void setDetectionResult(String detectionResult) {
		this.detectionResult = detectionResult;
	}
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public Integer getPromptType() {
		return promptType;
	}
	public void setPromptType(Integer promptType) {
		this.promptType = promptType;
	}
	public Integer getResultType() {
		return resultType;
	}
	public void setResultType(Integer resultType) {
		this.resultType = resultType;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getRefrenceRange() {
		return refrenceRange;
	}
	public void setRefrenceRange(String refrenceRange) {
		this.refrenceRange = refrenceRange;
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
	public String getDetectionMethod() {
		return detectionMethod;
	}
	public void setDetectionMethod(String detectionMethod) {
		this.detectionMethod = detectionMethod;
	}
	public String getReagentBrand() {
		return reagentBrand;
	}
	public void setReagentBrand(String reagentBrand) {
		this.reagentBrand = reagentBrand;
	}
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
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
	public String getRawDetectionItemCode() {
		return rawDetectionItemCode;
	}
	public void setRawDetectionItemCode(String rawDetectionItemCode) {
		this.rawDetectionItemCode = rawDetectionItemCode;
	}
	public Long getMainID() {
		return mainID;
	}
	public void setMainID(Long mainID) {
		this.mainID = mainID;
	}
	public Long getDetailID() {
		return detailID;
	}
	public void setDetailID(Long detailID) {
		this.detailID = detailID;
	}
	public Date getRawCreateTime() {
		return rawCreateTime;
	}
	public void setRawCreateTime(Date rawCreateTime) {
		this.rawCreateTime = rawCreateTime;
	}
	public Integer getMergeFlag() {
		return mergeFlag;
	}
	public void setMergeFlag(Integer mergeFlag) {
		this.mergeFlag = mergeFlag;
	}
	public Long getMergeFrom() {
		return mergeFrom;
	}
	public void setMergeFrom(Long mergeFrom) {
		this.mergeFrom = mergeFrom;
	}
	public String getMergeFromUuid() {
		return mergeFromUuid;
	}
	public void setMergeFromUuid(String mergeFromUuid) {
		this.mergeFromUuid = mergeFromUuid;
	}
	public Long getMergeTarget() {
		return mergeTarget;
	}
	public void setMergeTarget(Long mergeTarget) {
		this.mergeTarget = mergeTarget;
	}
	public String getMergeTargetUuid() {
		return mergeTargetUuid;
	}
	public void setMergeTargetUuid(String mergeTargetUuid) {
		this.mergeTargetUuid = mergeTargetUuid;
	}
	public Date getMergeTime() {
		return mergeTime;
	}
	public void setMergeTime(Date mergeTime) {
		this.mergeTime = mergeTime;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
}