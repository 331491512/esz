package com.esuizhen.cloudservice.business.bean;

import java.io.Serializable;

/**
 * <p>Title:TProductGroupInfo</p>
 * <p>Description:MDT组信息</p>
 * @author YYCHEN
 * @date 2016年9月28日 下午2:49:21
 */
public class TMDTWaxExpressReq implements Serializable {
	private static final long serialVersionUID = 1L;

	//产品服务申请ID
	private String productApplyId;
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
	//处理流程状态id
	private Integer mdtFlowStateId;
	//暂存还是提交  0：暂存  1：提交
	private Integer flag;
	//基层病历医生UserId
	private Long basicPathologyUserId;
	
	private String specimenName;
	private String specimenSource;
	//
	private Integer productType;
	//
	private Integer diseaseEvaluationFlag;
	//
	private String diagnosis;
	//
	private String pathologyDiagnosis;
	//
	private String goal;
	//
	private String recommendedDoctorMobile;
	//
	private Integer applyHospitalId;
	//
	private Integer deptId;
	//
	private Integer subDeptId;
	//
	private Integer consultHospitalId;
	//
	private String emrChildTypes;
	//
	private String clinicImpression;
	//
	private Integer needRadiateFlag;
	//
	private Long radiateUserId;
	//
	private Integer specimenIntactFlag;
	//
	private String specimenDestroyReson;
	public String getProductApplyId() {
		return productApplyId;
	}
	public Integer getSubDeptId() {
		return subDeptId;
	}
	public void setSubDeptId(Integer subDeptId) {
		this.subDeptId = subDeptId;
	}
	public Integer getProductType() {
		return productType;
	}
	public String getClinicImpression() {
		return clinicImpression;
	}
	public void setClinicImpression(String clinicImpression) {
		this.clinicImpression = clinicImpression;
	}
	public Long getBasicPathologyUserId() {
		return basicPathologyUserId;
	}
	public void setBasicPathologyUserId(Long basicPathologyUserId) {
		this.basicPathologyUserId = basicPathologyUserId;
	}
	public Integer getNeedRadiateFlag() {
		return needRadiateFlag;
	}
	public void setNeedRadiateFlag(Integer needRadiateFlag) {
		this.needRadiateFlag = needRadiateFlag;
	}
	public Long getRadiateUserId() {
		return radiateUserId;
	}
	public void setRadiateUserId(Long radiateUserId) {
		this.radiateUserId = radiateUserId;
	}
	public Integer getSpecimenIntactFlag() {
		return specimenIntactFlag;
	}
	public void setSpecimenIntactFlag(Integer specimenIntactFlag) {
		this.specimenIntactFlag = specimenIntactFlag;
	}
	public String getSpecimenDestroyReson() {
		return specimenDestroyReson;
	}
	public void setSpecimenDestroyReson(String specimenDestroyReson) {
		this.specimenDestroyReson = specimenDestroyReson;
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
	public Integer getConsultHospitalId() {
		return consultHospitalId;
	}
	public void setConsultHospitalId(Integer consultHospitalId) {
		this.consultHospitalId = consultHospitalId;
	}
	public String getEmrChildTypes() {
		return emrChildTypes;
	}
	public void setEmrChildTypes(String emrChildTypes) {
		this.emrChildTypes = emrChildTypes;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
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
	public Integer getMdtFlowStateId() {
		return mdtFlowStateId;
	}
	public void setMdtFlowStateId(Integer mdtFlowStateId) {
		this.mdtFlowStateId = mdtFlowStateId;
	}
	public String getSpecimenName()
	{
		return specimenName;
	}
	public void setSpecimenName(String specimenName)
	{
		this.specimenName = specimenName;
	}
	public String getSpecimenSource()
	{
		return specimenSource;
	}
	public void setSpecimenSource(String specimenSource)
	{
		this.specimenSource = specimenSource;
	}
	
	
}
