package com.esuizhen.cloudservice.ehr.model.medical;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author zhuguo
 * @date 2017-9-15 10:47:02
 */
public class ChangeVersion implements Serializable{
	private static final long serialVersionUID = -2820421159046683013L;

	// 编目版本ID
	private Long changeVersionId;

	// 患者ID
	private Long patientId;
	/**
	 * 医院ID
	 */
	private Integer hospitalId;

	// 就诊ID（住院或门诊ID）
	private String visitId;

	// 就诊类型(1:住院；2：门诊)
	private Integer visitType;

	/**
	 * 住院内容
	 */
	private String inhospitalContent;
	/**
	 * 诊断内容
	 */
	private String diagnosisContent;
	/**
	 * 手术内容
	 */
	private String surgeryContent;
	/**
	 * 重症监护室内容
	 */
	private String intensiveCareContent;
	/**
	 * 治疗内容
	 */
	private String treatmentContent;
	/**
	 * 表现与发病内容
	 */
	private String morbidityContent;
	/**
	 * 体格检查内容
	 */
	private String genenalExamSignsContent;
	/**
	 * 不良反应内容
	 */
	private String adverseReactionContent;
	/**
	 * 住院费用内容
	 */
	private String inhospitalCostInfoContent;
	/**
	 * 卡片标签。多个标签用逗号隔开
	 */
	private String cardTag;

	// 操作人
	private Long operator;

	// 创建时间
	private Date createTime;

	// 页数
	private Integer page;

	// 每页数量
	private Integer num;

	public Long getChangeVersionId() {
		return changeVersionId;
	}

	public void setChangeVersionId(Long changeVersionId) {
		this.changeVersionId = changeVersionId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public Integer getVisitType() {
		return visitType;
	}

	public void setVisitType(Integer visitType) {
		this.visitType = visitType;
	}

	public String getInhospitalContent() {
		return inhospitalContent;
	}

	public void setInhospitalContent(String inhospitalContent) {
		this.inhospitalContent = inhospitalContent;
	}

	public String getDiagnosisContent() {
		return diagnosisContent;
	}

	public void setDiagnosisContent(String diagnosisContent) {
		this.diagnosisContent = diagnosisContent;
	}

	public String getSurgeryContent() {
		return surgeryContent;
	}

	public void setSurgeryContent(String surgeryContent) {
		this.surgeryContent = surgeryContent;
	}

	public String getIntensiveCareContent() {
		return intensiveCareContent;
	}

	public void setIntensiveCareContent(String intensiveCareContent) {
		this.intensiveCareContent = intensiveCareContent;
	}

	public String getTreatmentContent() {
		return treatmentContent;
	}

	public void setTreatmentContent(String treatmentContent) {
		this.treatmentContent = treatmentContent;
	}

	public String getMorbidityContent() {
		return morbidityContent;
	}

	public void setMorbidityContent(String morbidityContent) {
		this.morbidityContent = morbidityContent;
	}

	public String getGenenalExamSignsContent() {
		return genenalExamSignsContent;
	}

	public void setGenenalExamSignsContent(String genenalExamSignsContent) {
		this.genenalExamSignsContent = genenalExamSignsContent;
	}

	public String getAdverseReactionContent() {
		return adverseReactionContent;
	}

	public void setAdverseReactionContent(String adverseReactionContent) {
		this.adverseReactionContent = adverseReactionContent;
	}

	public String getInhospitalCostInfoContent() {
		return inhospitalCostInfoContent;
	}

	public void setInhospitalCostInfoContent(String inhospitalCostInfoContent) {
		this.inhospitalCostInfoContent = inhospitalCostInfoContent;
	}

	public String getCardTag() {
		return cardTag;
	}

	public void setCardTag(String cardTag) {
		this.cardTag = cardTag;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
}