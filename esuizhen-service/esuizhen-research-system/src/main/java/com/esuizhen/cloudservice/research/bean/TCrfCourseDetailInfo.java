package com.esuizhen.cloudservice.research.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.TCrfObservationSubjectElement;

/** 
* @ClassName: TCrfCourseInfo 
* @Description: CRF随访周期信息
* @author YYCHEN
* @date 2016年04月06日 下午16:51:01  
*/
public class TCrfCourseDetailInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//随访周期明细(观察时点)ID
	private String crfCourseItemId;
	//随访周期ID
	private String crfCourseId;
	//随访周期明细名
	private String crfCourseItemName;
	//随访周期明细序号
	private Integer crfCourseItemIndex;
	//距离本周期起始时间的间隔
	private Integer distanceTime;
	//本周期开始时间（动态查询得到）
	private Date crfCourseItemTime;
	//CRF观察信息
	private List<TCrfObservationSubjectElement> crfObserveList;
	
	//本期应随访时间
	private Date followupDate;
	
	//是否可用
	private Integer available;
	
	public Date getFollowupDate() {
		return followupDate;
	}
	public void setFollowupDate(Date followupDate) {
		this.followupDate = followupDate;
	}
	public Integer getAvailable() {
		return available;
	}
	public void setAvailable(Integer available) {
		this.available = available;
	}
	public Date getCrfCourseItemTime() {
		return crfCourseItemTime;
	}
	public void setCrfCourseItemTime(Date crfCourseItemTime) {
		this.crfCourseItemTime = crfCourseItemTime;
	}
	private Integer currentFlag;
	
	public Integer getCurrentFlag() {
		return currentFlag;
	}
	public void setCurrentFlag(Integer currentFlag) {
		this.currentFlag = currentFlag;
	}
	public String getCrfCourseItemId() {
		return crfCourseItemId;
	}
	public void setCrfCourseItemId(String crfCourseItemId) {
		this.crfCourseItemId = crfCourseItemId;
	}
	public String getCrfCourseId() {
		return crfCourseId;
	}
	public void setCrfCourseId(String crfCourseId) {
		this.crfCourseId = crfCourseId;
	}
	public String getCrfCourseItemName() {
		return crfCourseItemName;
	}
	public void setCrfCourseItemName(String crfCourseItemName) {
		this.crfCourseItemName = crfCourseItemName;
	}
	public Integer getCrfCourseItemIndex() {
		return crfCourseItemIndex;
	}
	public void setCrfCourseItemIndex(Integer crfCourseItemIndex) {
		this.crfCourseItemIndex = crfCourseItemIndex;
	}
	public Integer getDistanceTime() {
		return distanceTime;
	}
	public void setDistanceTime(Integer distanceTime) {
		this.distanceTime = distanceTime;
	}
	public List<TCrfObservationSubjectElement> getCrfObserveList() {
		return crfObserveList;
	}
	public void setCrfObserveList(List<TCrfObservationSubjectElement> crfObserveList) {
		this.crfObserveList = crfObserveList;
	}
}
