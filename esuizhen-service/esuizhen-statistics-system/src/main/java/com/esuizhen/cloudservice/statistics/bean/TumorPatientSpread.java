 /**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean<br/>  
 * <b>文件名：</b>TumorPatientSpread.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年11月25日下午5:42:44<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>   
 */
package com.esuizhen.cloudservice.statistics.bean;
 
/** 
* @ClassName: TumorPatientSpread
* @Description: 
* @author NiDan
* @date 2016年11月25日下午5:42:44 
*/
public class TumorPatientSpread {

	/**
	 * 患者总数
	 */
	private Integer patientCount;
	/**
	 * 恶性肿瘤患者数
	 */
	private Integer malignantTumor;
	/**
	 * 良性肿瘤患者数
	 */
	private Integer benignTumor;
	/**
	 * 动态未定
	 */
	private Integer dynamicUncertain;
	/**
	 * 非肿瘤
	 */
	private Integer nonTumor;
	/**
	 * 未知
	 */
	private Integer unKnowDisease;
	/**
	 * 失访数
	 */
	private Integer lostFollowupCount;
	
	public Integer getLostFollowupCount() {
		return lostFollowupCount;
	}
	public void setLostFollowupCount(Integer lostFollowupCount) {
		this.lostFollowupCount = lostFollowupCount;
	}
	public Integer getPatientCount() {
		return patientCount;
	}
	public void setPatientCount(Integer patientCount) {
		this.patientCount = patientCount;
	}
	public Integer getMalignantTumor() {
		return malignantTumor;
	}
	public void setMalignantTumor(Integer malignantTumor) {
		this.malignantTumor = malignantTumor;
	}
	public Integer getBenignTumor() {
		return benignTumor;
	}
	public void setBenignTumor(Integer benignTumor) {
		this.benignTumor = benignTumor;
	}
	public Integer getDynamicUncertain() {
		return dynamicUncertain;
	}
	public void setDynamicUncertain(Integer dynamicUncertain) {
		this.dynamicUncertain = dynamicUncertain;
	}
	public Integer getNonTumor() {
		return nonTumor;
	}
	public void setNonTumor(Integer nonTumor) {
		this.nonTumor = nonTumor;
	}
	public Integer getUnKnowDisease() {
		return unKnowDisease;
	}
	public void setUnKnowDisease(Integer unKnowDisease) {
		this.unKnowDisease = unKnowDisease;
	}
	
}
