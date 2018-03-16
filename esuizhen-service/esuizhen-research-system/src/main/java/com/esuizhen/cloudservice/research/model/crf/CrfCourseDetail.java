package com.esuizhen.cloudservice.research.model.crf;

import java.io.Serializable;
import java.util.Date;

/**
 * CRF随访周期详情表bean
 * @author YYCHEN
 *
 */
public class CrfCourseDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	//随访周期明细(观察时点)ID
	private String crfCourseItemId;
	//随访周期ID
	private String crfCourseId;
	//随访周期明细名
	private String crfCourseItemName;
	//随访周期明细序号
	private Integer crfCourseItemIndex;
	//
	private Integer index;
	//距离本周期起始时间的间隔
	private Integer distanceTime;
	//记录创建时间
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	
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
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
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
}
