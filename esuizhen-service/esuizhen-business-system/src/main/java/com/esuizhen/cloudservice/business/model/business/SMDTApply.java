package com.esuizhen.cloudservice.business.model.business;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:TProductGroupInfo</p>
 * <p>Description:MDT组信息</p>
 * @author YYCHEN
 * @date 2016年9月28日 下午2:49:21
 */
public class SMDTApply implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键
	private Long id;
	//产品服务申请ID
	private String productApplyId;
	//产品服务类型
	private Integer productType;
	//是否存在（引荐医生指导下）病情评估。 0：否（默认）；1：是；
	private Integer diseaseEvaluationFlag;
	//主要诊断
	private String diagnosis;
	//病理诊断
	private String pathologyDiagnosis;
	//要求与目的
	private String goal;
	//引荐（经治）医生电话
	private String recommendedDoctorMobile;
	//申请单位医院ID
	private Integer applyHospitalId;
	//科室ID。
	private Integer deptId;
	//子科室ID
	private Integer subDeptId;
	//会诊单位hospitalID
	private Integer consultHospitalId;
	//EMR子类型标识。用于显示和打印。逗号分隔或json表示
	private Integer emrChildTypes;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//处理流程状态id
	private Integer mdtFlowStateId;
	//病理切片完成标识 0：否 1：是
	private Integer pathologySectionFlag;
	//切片数量
	private Integer sectionCount;
	//封蜡完成标识 0：否 1：是
	private Integer sealWaxFlag;
	//样本号
	private String sampleNo;
	//包装邮寄完成标识 0：否 1：是
	private Integer packExpressFlag;
	//快递公司名称
	private String expressCompany;
	//快递单号
	private String expressNo;
	//临床印象
	private String clinicImpression;
	//标本是否检查完好 0：否 1：是（默认）
	private Integer specimenIntactFlag;
	//是否需要放射科专家协同会诊 0：否 1：是(默认)
	private Integer needRadiateFlag;
	//放射专家组Id
	private Long radiateUserId;
	public Long getId() {
		return id;
	}
	public Long getRadiateUserId() {
		return radiateUserId;
	}
	public void setRadiateUserId(Long radiateUserId) {
		this.radiateUserId = radiateUserId;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Integer getDiseaseEvaluationFlag() {
		return diseaseEvaluationFlag;
	}
	public void setDiseaseEvaluationFlag(Integer diseaseEvaluationFlag) {
		this.diseaseEvaluationFlag = diseaseEvaluationFlag;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getPathologyDiagnosis() {
		return pathologyDiagnosis;
	}
	public void setPathologyDiagnosis(String pathologyDiagnosis) {
		this.pathologyDiagnosis = pathologyDiagnosis;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getRecommendedDoctorMobile() {
		return recommendedDoctorMobile;
	}
	public void setRecommendedDoctorMobile(String recommendedDoctorMobile) {
		this.recommendedDoctorMobile = recommendedDoctorMobile;
	}
	public Integer getApplyHospitalId() {
		return applyHospitalId;
	}
	public void setApplyHospitalId(Integer applyHospitalId) {
		this.applyHospitalId = applyHospitalId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getSubDeptId() {
		return subDeptId;
	}
	public void setSubDeptId(Integer subDeptId) {
		this.subDeptId = subDeptId;
	}
	public Integer getConsultHospitalId() {
		return consultHospitalId;
	}
	public void setConsultHospitalId(Integer consultHospitalId) {
		this.consultHospitalId = consultHospitalId;
	}
	public Integer getEmrChildTypes() {
		return emrChildTypes;
	}
	public void setEmrChildTypes(Integer emrChildTypes) {
		this.emrChildTypes = emrChildTypes;
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
	public Integer getMdtFlowStateId() {
		return mdtFlowStateId;
	}
	public void setMdtFlowStateId(Integer mdtFlowStateId) {
		this.mdtFlowStateId = mdtFlowStateId;
	}
	public Integer getPathologySectionFlag() {
		return pathologySectionFlag;
	}
	public void setPathologySectionFlag(Integer pathologySectionFlag) {
		this.pathologySectionFlag = pathologySectionFlag;
	}
	public Integer getSectionCount() {
		return sectionCount;
	}
	public void setSectionCount(Integer sectionCount) {
		this.sectionCount = sectionCount;
	}
	public Integer getSealWaxFlag() {
		return sealWaxFlag;
	}
	public void setSealWaxFlag(Integer sealWaxFlag) {
		this.sealWaxFlag = sealWaxFlag;
	}
	public String getSampleNo() {
		return sampleNo;
	}
	public void setSampleNo(String sampleNo) {
		this.sampleNo = sampleNo;
	}
	public Integer getPackExpressFlag() {
		return packExpressFlag;
	}
	public void setPackExpressFlag(Integer packExpressFlag) {
		this.packExpressFlag = packExpressFlag;
	}
	public String getExpressCompany() {
		return expressCompany;
	}
	public void setExpressCompany(String expressCompany) {
		this.expressCompany = expressCompany;
	}
	public String getExpressNo() {
		return expressNo;
	}
	public void setExpressNo(String expressNo) {
		this.expressNo = expressNo;
	}
	public String getClinicImpression() {
		return clinicImpression;
	}
	public void setClinicImpression(String clinicImpression) {
		this.clinicImpression = clinicImpression;
	}
	public Integer getSpecimenIntactFlag() {
		return specimenIntactFlag;
	}
	public void setSpecimenIntactFlag(Integer specimenIntactFlag) {
		this.specimenIntactFlag = specimenIntactFlag;
	}
	public Integer getNeedRadiateFlag() {
		return needRadiateFlag;
	}
	public void setNeedRadiateFlag(Integer needRadiateFlag) {
		this.needRadiateFlag = needRadiateFlag;
	}
}
