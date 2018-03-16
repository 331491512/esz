package com.esuizhen.cloudservice.user.bean;

import java.util.Date; 
import java.util.List;

import com.westangel.common.bean.ehr.MetaCDiseaseType;

public class DiseaseKnowledge {

	private Long articleId;

	private Integer isDelete;
	
	private Long doctorId;
	
	private List<Integer> diseaseTypeTagIds;
	
	private List<String> tagNameArray;
	
	private String tagNames;
	
	private String tagName;
	
	private String articleTitle;
	
	private String pictureUrl;
	
	private String summary;
	
	private Integer summaryFlag;
	
	private String content;
	
	private Date createTime;
	
	private Date updateTime;
	
	private int state;
	
	private Integer sortIndex;
	
	private Integer pageNumber;
	private Integer pageSize;

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public List<Integer> getDiseaseTypeTagIds() {
		return diseaseTypeTagIds;
	}

	public void setDiseaseTypeTagIds(List<Integer> diseaseTypeTagIds) {
		this.diseaseTypeTagIds = diseaseTypeTagIds;
	}

	public String getTagNames() {
		return tagNames;
	}

	public void setTagNames(String tagNames) {
		this.tagNames = tagNames;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Integer getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(Integer sortIndex) {
		this.sortIndex = sortIndex;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Integer getSummaryFlag() {
		return summaryFlag;
	}

	public void setSummaryFlag(Integer summaryFlag) {
		this.summaryFlag = summaryFlag;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<String> getTagNameArray() {
		return tagNameArray;
	}

	public void setTagNameArray(List<String> tagNameArray) {
		this.tagNameArray = tagNameArray;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
