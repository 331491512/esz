/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean;<br/>  
 * <b>文件名：</b>TSurvivalRateInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年4月11日下午6:51:18<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.bean;

import java.util.List;

/** 
* @ClassName: TSurvivalRateInfo
* @Description: 
* @author lichenghao
* @date 2016年4月11日 下午6:51:18  
*/
public class TSurvivalRateInfo {
	//病种Id
	private Integer diseaseTypeId;
	
	//病种名称
	private String diseaseTypeName;
	
	//患者总数
	private Integer patientCount;
	
	//有效随访总数
	private Integer effectiveCount;
	
	//无效随访总数
	private Integer invalidCount;
	
	//存活总数
	private Integer survivalCount;
	
	//死亡总数
	private Integer deathCount;
	
	//中位生存月
	private String middleMonth;
	
	//生存率集合
	private List<TSurvivalRateItem> survivalRates;
	
	/**********B端接口************/
	//查询主要条件编号
	private String typeId;
	// 条件名称
	private String typeName;
	// 患者总数
	private Integer totalNum;
	// 随访前失访人数
	private Integer beginLostFollowupNum;
	// 随访前死亡人数
	private Integer beginFollowupDeathNum;
	//随访总数
	private Integer followupNum;
	//随访率
	private String followupRate;
	// 有效随访患者数
	private Integer validNum;
	// 有效随访患者率
	private String validRate;
	// 无效随访患者数
	private Integer unvalidNum;
	// 无效随访率
	private String unvalidRate;
	// 死亡人数
	private Integer deathNum;
	// 死亡率
	private String deathRate;
	// 生存率
	private TSurvivalRateStaticInfo survivalRate;
	

	public Integer getDiseaseTypeId() {
		return diseaseTypeId;
	}

	public void setDiseaseTypeId(Integer diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}

	public String getDiseaseTypeName() {
		return diseaseTypeName;
	}

	public void setDiseaseTypeName(String diseaseTypeName) {
		this.diseaseTypeName = diseaseTypeName;
	}

	public List<TSurvivalRateItem> getSurvivalRates() {
		return survivalRates;
	}

	public void setSurvivalRates(List<TSurvivalRateItem> survivalRates) {
		this.survivalRates = survivalRates;
	}

	public Integer getPatientCount() {
		return patientCount;
	}

	public void setPatientCount(Integer patientCount) {
		this.patientCount = patientCount;
	}

	public Integer getEffectiveCount() {
		return effectiveCount;
	}

	public void setEffectiveCount(Integer effectiveCount) {
		this.effectiveCount = effectiveCount;
	}

	public Integer getInvalidCount() {
		return invalidCount;
	}

	public void setInvalidCount(Integer invalidCount) {
		this.invalidCount = invalidCount;
	}

	public Integer getSurvivalCount() {
		return survivalCount;
	}

	public void setSurvivalCount(Integer survivalCount) {
		this.survivalCount = survivalCount;
	}

	public Integer getDeathCount() {
		return deathCount;
	}

	public void setDeathCount(Integer deathCount) {
		this.deathCount = deathCount;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Integer getValidNum() {
		return validNum;
	}

	public void setValidNum(Integer validNum) {
		this.validNum = validNum;
	}

	public String getValidRate() {
		return validRate;
	}

	public void setValidRate(String validRate) {
		this.validRate = validRate;
	}

	public Integer getUnvalidNum() {
		return unvalidNum;
	}

	public void setUnvalidNum(Integer unvalidNum) {
		this.unvalidNum = unvalidNum;
	}

	public String getUnvalidRate() {
		return unvalidRate;
	}

	public void setUnvalidRate(String unvalidRate) {
		this.unvalidRate = unvalidRate;
	}

	public Integer getDeathNum() {
		return deathNum;
	}

	public void setDeathNum(Integer deathNum) {
		this.deathNum = deathNum;
	}

	public String getDeathRate() {
		return deathRate;
	}

	public void setDeathRate(String deathRate) {
		this.deathRate = deathRate;
	}

	public TSurvivalRateStaticInfo getSurvivalRate() {
		return survivalRate;
	}

	public void setSurvivalRate(TSurvivalRateStaticInfo survivalRate) {
		this.survivalRate = survivalRate;
	}

	public String getMiddleMonth() {
		return middleMonth;
	}

	public void setMiddleMonth(String middleMonth) {
		this.middleMonth = middleMonth;
	}

	public Integer getFollowupNum() {
		return followupNum;
	}

	public void setFollowupNum(Integer followupNum) {
		this.followupNum = followupNum;
	}

	public String getFollowupRate() {
		return followupRate;
	}

	public void setFollowupRate(String followupRate) {
		this.followupRate = followupRate;
	}

	public Integer getBeginLostFollowupNum() {
		return beginLostFollowupNum;
	}

	public void setBeginLostFollowupNum(Integer beginLostFollowupNum) {
		this.beginLostFollowupNum = beginLostFollowupNum;
	}

	public Integer getBeginFollowupDeathNum() {
		return beginFollowupDeathNum;
	}

	public void setBeginFollowupDeathNum(Integer beginFollowupDeathNum) {
		this.beginFollowupDeathNum = beginFollowupDeathNum;
	}
}
