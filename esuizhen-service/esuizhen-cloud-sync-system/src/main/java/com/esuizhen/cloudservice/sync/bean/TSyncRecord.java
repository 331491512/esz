package com.esuizhen.cloudservice.sync.bean;

import java.io.Serializable;

/**
 * <p>Title:TSyncRecord</p>
 * <p>Description:ToB端通知云端具体消息体</p>
 * @author YYCHEN
 * @date 2016年9月9日 上午11:36:36
 */
public class TSyncRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	/**
	 * 患者uuid
	 */
	private String patientUuid;
	/**
	 * 微信openId
	 */
	private String weixinOpenId;
	/**
	 * 随访uuid
	 */
	private String followupResultId;
	/**
	 * 随访缓冲uuid
	 */
	private String followupResultBuffId;
	
	private String productApplyId;
	/**
	 * 问卷结果id
	 */
	private String questionnaireResultId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPatientUuid() {
		return patientUuid;
	}
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}
	public String getWeixinOpenId() {
		return weixinOpenId;
	}
	public void setWeixinOpenId(String weixinOpenId) {
		this.weixinOpenId = weixinOpenId;
	}
	public String getFollowupResultId() {
		return followupResultId;
	}
	public void setFollowupResultId(String followupResultId) {
		this.followupResultId = followupResultId;
	}
	public String getFollowupResultBuffId() {
		return followupResultBuffId;
	}
	public void setFollowupResultBuffId(String followupResultBuffId) {
		this.followupResultBuffId = followupResultBuffId;
	}
	public String getProductApplyId() {
		return productApplyId;
	}
	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
	}
	public String getQuestionnaireResultId() {
		return questionnaireResultId;
	}
	public void setQuestionnaireResultId(String questionnaireResultId) {
		this.questionnaireResultId = questionnaireResultId;
	}
	
}
