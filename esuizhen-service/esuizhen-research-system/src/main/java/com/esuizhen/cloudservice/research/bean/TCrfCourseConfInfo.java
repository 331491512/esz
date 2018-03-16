package com.esuizhen.cloudservice.research.bean;

import java.io.Serializable;
import java.util.List;

/** 
* @ClassName: TCrfCourseInfo 
* @Description: CRF随访周期信息
* @author YYCHEN
* @date 2016年04月06日 下午16:51:01  
*/
public class TCrfCourseConfInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//CRF随访周期ID
	private String crfCourseId;
	//Crf模板Id
	private String crfTemplateId;
	//周期名
	private String crfCourseItemName;
	//周期序号
	private Integer crfCourseIndex;
	//随访周期值
	private Integer followupPeriod;
	//随访周期单位
	private String followupPeriodUnit;
	//随访频率
	private Integer followupFrequency;
	//随访频率单位
	private String followupFrequencyUnit;
	//随访次数
	private Integer followupCount;
	//CRF随访周期明细信息
	private List<TCrfCourseDetailInfo> crfCourseItemList;
	
	public String getCrfCourseId() {
		return crfCourseId;
	}
	public void setCrfCourseId(String crfCourseId) {
		this.crfCourseId = crfCourseId;
	}
	public String getCrfTemplateId() {
		return crfTemplateId;
	}
	public void setCrfTemplateId(String crfTemplateId) {
		this.crfTemplateId = crfTemplateId;
	}
	public String getCrfCourseItemName() {
		return crfCourseItemName;
	}
	public void setCrfCourseItemName(String crfCourseItemName) {
		this.crfCourseItemName = crfCourseItemName;
	}
	public Integer getCrfCourseIndex() {
		return crfCourseIndex;
	}
	public void setCrfCourseIndex(Integer crfCourseIndex) {
		this.crfCourseIndex = crfCourseIndex;
	}
	public Integer getFollowupPeriod() {
		return followupPeriod;
	}
	public void setFollowupPeriod(Integer followupPeriod) {
		this.followupPeriod = followupPeriod;
	}
	public String getFollowupPeriodUnit() {
		return followupPeriodUnit;
	}
	public void setFollowupPeriodUnit(String followupPeriodUnit) {
		this.followupPeriodUnit = followupPeriodUnit;
	}
	public Integer getFollowupFrequency() {
		return followupFrequency;
	}
	public void setFollowupFrequency(Integer followupFrequency) {
		this.followupFrequency = followupFrequency;
	}
	public String getFollowupFrequencyUnit() {
		return followupFrequencyUnit;
	}
	public void setFollowupFrequencyUnit(String followupFrequencyUnit) {
		this.followupFrequencyUnit = followupFrequencyUnit;
	}
	public List<TCrfCourseDetailInfo> getCrfCourseItemList() {
		return crfCourseItemList;
	}
	public void setCrfCourseItemList(List<TCrfCourseDetailInfo> crfCourseItemList) {
		this.crfCourseItemList = crfCourseItemList;
	}
	public Integer getFollowupCount() {
		return followupCount;
	}
	public void setFollowupCount(Integer followupCount) {
		this.followupCount = followupCount;
	}
}
