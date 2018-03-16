package com.esuizhen.cloudservice.research.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>Title: TCrfCourseInfo</p>
 * <p>Description: CRF随访周期信息</p>
 * @author YYCHEN
 * @date 2016年4月12日 下午5:48:57
 */
public class TCrfCourseInfo implements Serializable {
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
	//随访频率单位
	private String followupPeriodUnit;
	//随访频率
	private Integer followupFrequency;
	//随访频率单位
	private String followupFrequencyUnit;
	//随访次数
	private Integer followupCount;
	//是否拷贝了基线
	private Integer isBaselineCopied;
	//TCrfCourseDetail详见附录TCrfCourseDetail的定义
	private List<TCrfCourseDetailInfo> crfCourseItemList;
	
	//当前服务器时间
	private Date curentTime;

	public Integer getFollowupCount() {
		return followupCount;
	}
	public void setFollowupCount(Integer followupCount) {
		this.followupCount = followupCount;
	}
	public Date getCurentTime() {
		return curentTime;
	}
	public void setCurentTime(Date curentTime) {
		this.curentTime = curentTime;
	}
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
	public Integer getIsBaselineCopied() {
		return isBaselineCopied;
	}
	public void setIsBaselineCopied(Integer isBaselineCopied) {
		this.isBaselineCopied = isBaselineCopied;
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
}
