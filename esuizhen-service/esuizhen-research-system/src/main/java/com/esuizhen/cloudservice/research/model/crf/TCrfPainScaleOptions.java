package com.esuizhen.cloudservice.research.model.crf;

import java.io.Serializable;
import java.util.Date;

/**
 * CRF疼痛指数bean
 * @author YYCHEN
 *
 */
public class TCrfPainScaleOptions implements Serializable {
	private static final long serialVersionUID = 1L;

	//疼痛指数ID。主键。 CRPSYYYYMMDDHHMMSSnnnnnn
	private String crfPainScaleId;
	//观察项ID
	private String crfObserveId;
	//观察项。外键。meta_crf_subject_element.subjectElementId 如疼痛指数对应的Id。
	private String subjectElementId;
	//是否采集该项：0：不采集；1：采集。（默认）
	private Integer collectionFlag;
	//记录创建时间
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	public String getCrfPainScaleId() {
		return crfPainScaleId;
	}
	public void setCrfPainScaleId(String crfPainScaleId) {
		this.crfPainScaleId = crfPainScaleId;
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
	public Integer getCollectionFlag() {
		return collectionFlag;
	}
	public void setCollectionFlag(Integer collectionFlag) {
		this.collectionFlag = collectionFlag;
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
