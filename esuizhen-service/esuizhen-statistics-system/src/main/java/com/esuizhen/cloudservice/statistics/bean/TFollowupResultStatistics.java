package com.esuizhen.cloudservice.statistics.bean;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title:TFollowupProgressInfo</p>
 * <p>Description:随访结果统计信息bean</p>
 * @author YYCHEN
 * @date 2016年8月9日 上午10:49:49
 */
public class TFollowupResultStatistics implements Serializable {
	private static final long serialVersionUID = 1L;

	//随访结果ID
	private Integer followupResultValueId;
	//随访结果名称
	private String followupResultValueName;
	//数量
	private Integer quantity;
	//所占百分比
	private Float percentage;
	//显示百分比
	private Float showPercentage;
	//结果类型
	private Integer type;
	//随访结果细分，用于对无效随访结果的细分
	private List<TFollowupResultStatistics> detailedList;
	public Float getShowPercentage() {
		return showPercentage;
	}
	public void setShowPercentage(Float showPercentage) {
		this.showPercentage = showPercentage;
	}
	public Integer getFollowupResultValueId() {
		return followupResultValueId;
	}
	public void setFollowupResultValueId(Integer followupResultValueId) {
		this.followupResultValueId = followupResultValueId;
	}
	public String getFollowupResultValueName() {
		return followupResultValueName;
	}
	public void setFollowupResultValueName(String followupResultValueName) {
		this.followupResultValueName = followupResultValueName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Float getPercentage() {
		return percentage;
	}
	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public List<TFollowupResultStatistics> getDetailedList() {
		return detailedList;
	}
	public void setDetailedList(List<TFollowupResultStatistics> detailedList) {
		this.detailedList = detailedList;
	}
}
