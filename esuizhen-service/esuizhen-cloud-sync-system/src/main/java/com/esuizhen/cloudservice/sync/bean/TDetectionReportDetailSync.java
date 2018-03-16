package com.esuizhen.cloudservice.sync.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:TDetectionReportDetailSync</p>
 * <p>Description:检验单信息详情</p>
 * @author YYCHEN
 * @date 2016年5月6日 下午4:33:58
 */
public class TDetectionReportDetailSync implements Serializable {
	private static final long serialVersionUID = 1L;

	//化验单详情记录ID
	private String detectionDetailId;
	//化验单ID
	private String detectionReportId;
	//患者ID
	private Long patientId;
	//病案号。医院对患者的标识
	private String patientNo;
	//检验项目序号
	private Long seqNo;
	//检验类型名称
	private String detectionTypeName;
	//检验项目ID 
	private Integer detectionItemId;
	//检验项目代码
	private String detectionItemCode;
	//原始LIS检验项目代码
	private String rawDetectionItemCode;
	//检验项目名称
	private String detectionItemName;
	//检验项目英文名
	private String detectionItemEnglishName;
	//检验结果
	private String detectionResult;
	//异常提示
	private String prompt;
	//结果类型。
	private Integer resultType;
	//单位
	private String unit;
	//参考范围
	private String refrenceRange;
	//参考范围（下限）
	private String refrenceRangeMin;
	//参考范围（上限）
	private String refrenceRangeMax;
	//检验（实验）方法
	private String detectionWay;
	//试剂品牌
	private String reagentBrand;
	//仪器名称
	private String instrument;
	
	private String detectionMethod;
	//创建时间（单据创建时间）
	private Date createTime;
	//更新时间
	private Date updateTime;
	private Date syncTime;
	private Long detailID;
	private Long mainID;
	//add by fanpanwei
	private Integer promptType;
	private Date rawCreateTime;
	
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
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public Long getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}
	public Long getDetailID() {
		return detailID;
	}
	public void setDetailID(Long detailID) {
		this.detailID = detailID;
	}
	public Long getMainID() {
		return mainID;
	}
	public void setMainID(Long mainID) {
		this.mainID = mainID;
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
	public String getRawDetectionItemCode() {
		return rawDetectionItemCode;
	}
	public void setRawDetectionItemCode(String rawDetectionItemCode) {
		this.rawDetectionItemCode = rawDetectionItemCode;
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
	public String getDetectionWay() {
		return detectionWay;
	}
	public void setDetectionWay(String detectionWay) {
		this.detectionWay = detectionWay;
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
	public String getDetectionMethod() {
		return detectionMethod;
	}
	public void setDetectionMethod(String detectionMethod) {
		this.detectionMethod = detectionMethod;
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
	public Date getSyncTime() {
		return syncTime;
	}
	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}
	
	public Integer getPromptType() {
		return promptType;
	}
	public void setPromptType(Integer promptType) {
		this.promptType = promptType;
	}
	public Date getRawCreateTime() {
		return rawCreateTime;
	}
	public void setRawCreateTime(Date rawCreateTime) {
		this.rawCreateTime = rawCreateTime;
	}
	
}
