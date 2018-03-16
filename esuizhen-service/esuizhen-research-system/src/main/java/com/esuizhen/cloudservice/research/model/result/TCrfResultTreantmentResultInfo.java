package com.esuizhen.cloudservice.research.model.result;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:TCrfResultTreantmentResultInfo</p>
 * <p>Description:CRF治疗效果bean</p>
 * @author YYCHEN
 * @date 2016年10月21日 上午10:18:33
 */
public class TCrfResultTreantmentResultInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//治疗效果ID
	private String crfTreantmentResultId;
	//Crf结果ID
	private String crfResultId;
	//填写日期，默认当前日期。
	private Date fillDate;
	//治疗效果： 1：稳定；2：复发；3：转移;17：病情减轻。
	private Integer effectType;
	//发生日期；如结果为复发或转移时，需要填写发生日期。
	private Date happenDate;
	//身体部位；当结果为转移时，需要记录转移的部位。
	private Integer bodyPartId;
	//身体部位名称
	private String bodyPartName;
	//创建时间（单据上传时间）
	private Date createTime;
	//更新时间
	private Date updateTime;
	

	private Integer followupWay;
	
	private Long operator;
	
	private Integer page;
	
	private Integer num;
	
	/**
	 * 随访状态
	 */
	private Integer followupResultValue;
	/**
	 * 复发部位
	 */
	private String relapseParts;
	/**
	 * 复发时间
	 */
	private Date relapseDate;
	/** 
	 * 转移部位
	 */
	private String transferParts;
	
	/**
	 *转移时间 
	 */
	private Date transferDate;
	
	/**
	 * 死亡日期
	 */
	private Date deathDate;
	
	/**
	 * 死亡原因
	 */
	private String deathCause;
	
	/**
	 * 其他原因
	 */
	private String otherCause;
	
	/**
	 * 医院编号
	 */
	private Integer hospitalId;
	
	/**
	 * 患者编号
	 */
	private Long patientId;
	/**
	 * 数据来源标识。
		1：B端填写（短信和电话）
		2：微信端患者填写；
		3：院内(同步);【随访结果同步服务端需要过滤掉此标识的记录】
		4：:医生填写

	 */
	private Integer sourceFlag;
	
	/**
	 * 随访时间
	 */
	private Date followupTime;

	public String getCrfTreantmentResultId() {
		return crfTreantmentResultId;
	}

	public void setCrfTreantmentResultId(String crfTreantmentResultId) {
		this.crfTreantmentResultId = crfTreantmentResultId;
	}

	public String getCrfResultId() {
		return crfResultId;
	}

	public void setCrfResultId(String crfResultId) {
		this.crfResultId = crfResultId;
	}

	public Date getFillDate() {
		return fillDate;
	}

	public void setFillDate(Date fillDate) {
		this.fillDate = fillDate;
	}

	public Integer getEffectType() {
		return effectType;
	}

	public void setEffectType(Integer effectType) {
		this.effectType = effectType;
	}

	public Date getHappenDate() {
		return happenDate;
	}

	public void setHappenDate(Date happenDate) {
		this.happenDate = happenDate;
	}

	public Integer getBodyPartId() {
		return bodyPartId;
	}

	public void setBodyPartId(Integer bodyPartId) {
		this.bodyPartId = bodyPartId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public String getBodyPartName() {
		return bodyPartName;
	}

	public void setBodyPartName(String bodyPartName) {
		this.bodyPartName = bodyPartName;
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

	public Integer getFollowupWay() {
		return followupWay;
	}

	public void setFollowupWay(Integer followupWay) {
		this.followupWay = followupWay;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
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

	public Integer getFollowupResultValue() {
		return followupResultValue;
	}

	public void setFollowupResultValue(Integer followupResultValue) {
		this.followupResultValue = followupResultValue;
	}

	public String getRelapseParts() {
		return relapseParts;
	}

	public void setRelapseParts(String relapseParts) {
		this.relapseParts = relapseParts;
	}

	public Date getRelapseDate() {
		return relapseDate;
	}

	public void setRelapseDate(Date relapseDate) {
		this.relapseDate = relapseDate;
	}

	public String getTransferParts() {
		return transferParts;
	}

	public void setTransferParts(String transferParts) {
		this.transferParts = transferParts;
	}

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public String getDeathCause() {
		return deathCause;
	}

	public void setDeathCause(String deathCause) {
		this.deathCause = deathCause;
	}

	public String getOtherCause() {
		return otherCause;
	}

	public void setOtherCause(String otherCause) {
		this.otherCause = otherCause;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Integer getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public Date getFollowupTime() {
		return followupTime;
	}

	public void setFollowupTime(Date followupTime) {
		this.followupTime = followupTime;
	}
}
