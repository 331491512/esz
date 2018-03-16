package com.esuizhen.cloudservice.research.model.crf;

import java.util.Date;


public class TCrfExamItemDetailOptions{

	//明细ID
	private String crfObserveItemId;
	//观察项ID
	private String crfObserveId;
	//观察项
	private String subjectElementId;
	//项目类型
	private Integer examTypeId;
	//明细子元素
	private Integer examItemId;
	//项目目
	private String examItemName;
	//1:  靶病灶（默认）　2：非靶病灶	0：未知
	private Integer flag;
	//排序索引
	private Integer index;
	//记录创建时间。
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	public String getCrfObserveItemId() {
		return crfObserveItemId;
	}
	public void setCrfObserveItemId(String crfObserveItemId) {
		this.crfObserveItemId = crfObserveItemId;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getCrfObserveId() {
		return crfObserveId;
	}
	public void setCrfObserveId(String crfObserveId) {
		this.crfObserveId = crfObserveId;
	}
	public String getSubjectElementId() {
		return subjectElementId;
	}
	public void setSubjectElementId(String subjectElementId) {
		this.subjectElementId = subjectElementId;
	}
	public Integer getExamTypeId() {
		return examTypeId;
	}
	public void setExamTypeId(Integer examTypeId) {
		this.examTypeId = examTypeId;
	}
	public Integer getExamItemId() {
		return examItemId;
	}
	public void setExamItemId(Integer examItemId) {
		this.examItemId = examItemId;
	}
	public String getExamItemName() {
		return examItemName;
	}
	public void setExamItemName(String examItemName) {
		this.examItemName = examItemName;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
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

