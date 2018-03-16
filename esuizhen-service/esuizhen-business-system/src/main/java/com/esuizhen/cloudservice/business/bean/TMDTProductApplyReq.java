package com.esuizhen.cloudservice.business.bean;

import java.io.Serializable;

/**
 * <p>Title:TProductGroupInfo</p>
 * <p>Description:MDT组信息</p>
 * @author YYCHEN
 * @date 2016年9月28日 下午2:49:21
 */
public class TMDTProductApplyReq implements Serializable {
	private static final long serialVersionUID = 1L;

	//产品服务申请ID
	private String productApplyId;
	//患者用户ID。外键: u_user.userId
	private Long buyer;
	//申请医生的用户ID
	private Long agentApplicant;
	//产品服务类型
	private Integer productType;
	//产品ID
	private String productId;
	//实际价格
	private Float realPrice;
	//联系电话
	private String contactMobile;
	//处理流程状态id
	private Integer mdtFlowStateId;
	//要求与目的
	private String goal;
	//临床印象
	private String clinicImpression;
	//用户申请描述信息
	private String description;
	//申请单位医院ID
	private Integer applyHospitalId;
	//申请单位医院科室ID
	private Integer applyDeptId;
	
	public Long getBuyer() {
		return buyer;
	}
	public Integer getApplyHospitalId() {
		return applyHospitalId;
	}
	public Integer getApplyDeptId() {
		return applyDeptId;
	}
	public void setApplyDeptId(Integer applyDeptId) {
		this.applyDeptId = applyDeptId;
	}
	public void setApplyHospitalId(Integer applyHospitalId) {
		this.applyHospitalId = applyHospitalId;
	}
	public void setBuyer(Long buyer) {
		this.buyer = buyer;
	}
	public Long getAgentApplicant() {
		return agentApplicant;
	}
	public void setAgentApplicant(Long agentApplicant) {
		this.agentApplicant = agentApplicant;
	}
	public String getProductApplyId() {
		return productApplyId;
	}
	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
	}
	public Integer getProductType() {
		return productType;
	}
	public void setProductType(Integer productType) {
		this.productType = productType;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Float getRealPrice() {
		return realPrice;
	}
	public void setRealPrice(Float realPrice) {
		this.realPrice = realPrice;
	}
	public String getContactMobile() {
		return contactMobile;
	}
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	public Integer getMdtFlowStateId() {
		return mdtFlowStateId;
	}
	public void setMdtFlowStateId(Integer mdtFlowStateId) {
		this.mdtFlowStateId = mdtFlowStateId;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getClinicImpression() {
		return clinicImpression;
	}
	public void setClinicImpression(String clinicImpression) {
		this.clinicImpression = clinicImpression;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
