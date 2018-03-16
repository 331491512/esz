package com.esuizhen.cloudservice.research.model.crf;

import java.util.Date;

/**
* @ClassName: TCrfAdverseReactionInfo 
* @Description: CRF-观察项-不良反映明细信息
* @author wang_hw
* @date 2016年4月15日 下午6:19:01
 */
public class TCrfAdverseReactionInfo{
	
	/**
	 * 观察点ID
	 */
	private String crfObserveItemId;
	/**
	 * 观察项ID
	 */
	private String crfObserveId;
	/**
	 *  观察标题ID
	 */
	private String subjectElementId;
	/**
	 * 不良反应D 
	 */
	private Integer adverseReactionId;
	//排序索引
	private Integer index;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public void setCrfObserveItemId(String value) {
		this.crfObserveItemId = value;
	}
	
	public String getCrfObserveItemId() {
		return this.crfObserveItemId;
	}
	public void setCrfObserveId(String value) {
		this.crfObserveId = value;
	}
	
	public String getCrfObserveId() {
		return this.crfObserveId;
	}
	public void setSubjectElementId(String value) {
		this.subjectElementId = value;
	}
	
	public String getSubjectElementId() {
		return this.subjectElementId;
	}
	public void setAdverseReactionId(Integer value) {
		this.adverseReactionId = value;
	}
	
	public Integer getAdverseReactionId() {
		return this.adverseReactionId;
	}
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}


}

