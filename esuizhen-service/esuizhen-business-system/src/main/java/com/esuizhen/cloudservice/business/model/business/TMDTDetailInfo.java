package com.esuizhen.cloudservice.business.model.business;

import java.util.Date;
import java.util.List;

import com.esuizhen.cloudservice.business.bean.ExpressAddress;
import com.esuizhen.cloudservice.business.bean.MdtDoctorOptionInfo;
import com.esuizhen.cloudservice.business.bean.TMDTDoctorInProductGroupInfo;
import com.westangel.common.bean.trade.TProductGroupMemberInfo;

public class TMDTDetailInfo {
	/**
	 * 会诊id
	 */
	private Long id;
	/**
	 * 产品申请号
	 */
	private String productApplyId;
	/**
	 * 订单号
	 */
	private String orderId;
	/**
	 * 产品编号
	 */
	private String productId;
	/**
	 *  标题
	 */
	private String orderTitle;
	/**
	 * 描述详情
	 */
	private String description;
	//治疗经过
	private String treatmentCourse;
	//其他描述
	private String explain;
	
	/**
	 * 患者编号
	 */
	private Long patientId;
	
	/**
	 * 患者userId
	 */
	private Long buyer;
	
	/**
	 * 患者姓名
	 */
	private String buyerName;
	
	/**
	 * 填写手机号
	 */
	private String contactMobile;
	
	/**
	 * 主要诊断
	 */
	private String diagnosis;
	
	/**
	 * 病理诊断
	 */
	private String pathologyDiagnosis;
	
	
	/**
	 * 要求与目的
	 */
	private String goal;
	
	/**
	 * 推荐医生
	 */
	private String recommendedDoctor;
	
	/**
	 * 代理医生userId
	 */
	private Long agentApplicant;
	
	/**
	 * 病历资料整理
	 */
	private String dataArrangement;
	/**
	 *  会诊阶段
	 *  0:提交申请 1:上传资料 2:反馈会诊状态 3:返回会诊结果
	 */
	private Integer progressState;
	/**
	 * 会诊状态
	 * 0:资料审核 1:资料待完善 2:资料审核通过 3:会诊安排中 4:会诊安排成功 5:会诊安排失败
	 * 6:等待专家会诊 7:会诊成功
	 */
	private Integer auditState;
	/**
	 * 显示的状态字符串
	 */
	private String auditStateName;
	/**
	 * 失败原因
	 */
	private String cause;
	/**
	 * 会诊意见结果
	 */
	private String summarization;
	/**
	 * 医生列表
	 */
	private List<TProductGroupMemberInfo> groupMemberList;
	/**
	 * 咨询结果附件列表
	 */
	private String consultAttachement;
	/**
	 * 咨询结果附件列表List
	 */
	private List<String> consultAttachementList; 
	
	//病历资料或会诊报告是否已转发给患者
	//1：已转发；0或空：未转发；
	private Integer forwardFlag;
	/**
	 * 上传的病历列表
	 */
	private List<TMDTEmrInfo> emrList;
	
	private String specimenName;
	
	private String specimenSource;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 更新时间
	 */
	private String updateTime;
	
	public String getTreatmentCourse() {
		return treatmentCourse;
	}
	public void setTreatmentCourse(String treatmentCourse) {
		this.treatmentCourse = treatmentCourse;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	/**
	 *价格 
	 */
	private float realPrice;
	
	/**
	 * 购买状态
	 */
	private Integer subscriptionFlag; //购买状态  
	
	/**
	 * 期望时间
	 */
	private Date consultOrderTime; //预计开始时间
	
	private String trueName;
	private String sex;
	private String patientNo;
	private String mobile;
	private String identification;
	private String mdtApplyNo;
	private Integer applyHospitalId;
	private Integer deptId;
	private String recommendedDoctorMobile;
	private String clinicImpression;
	private String mdtProductExpectConsultDay;
	private String mdtFlowStateId;
	private Integer pathologySectionFlag;
	private Integer sectionCount;
	private Integer sealWaxFlag;
	private String sampleNo;
	private String sampleDamageCause;
	private Integer sampleCheckFlag;
	private Integer packExpressFlag;
	private String expressCompany;
	private String expressNo;
	private Integer needRadiateFlag;
	private String productName;
	private String deptName;
	private String applyHospitalName;
	private String agentApplicantName;
	private List<MdtDoctorOptionInfo> optionList;
	private ExpressAddress expressAddress;
	private String logisticsInfo;
	private List<TMDTDoctorInProductGroupInfo> productGroup;
	private String mailAddress;
	private Long radiateUserId;
	private Date acceptanceTime;
	private Long basicPathologyUserId;
	private String basicPathologyUserName;
	private String basicPathologyUserPhome;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/** 
	* @return productApplyId 
	*/
	public String getProductApplyId() {
		return productApplyId;
	}
	/** 
	* @param productApplyId 要设置的 productApplyId 
	*/
	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
	}
	/** 
	* @return orderId 
	*/
	public String getOrderId() {
		return orderId;
	}
	/** 
	* @param orderId 要设置的 orderId 
	*/
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/** 
	* @return orderTitle 
	*/
	public String getOrderTitle() {
		return orderTitle;
	}
	/** 
	* @param orderTitle 要设置的 orderTitle 
	*/
	public void setOrderTitle(String orderTitle) {
		this.orderTitle = orderTitle;
	}
	public Integer getForwardFlag() {
		return forwardFlag;
	}
	public void setForwardFlag(Integer forwardFlag) {
		this.forwardFlag = forwardFlag;
	}
	/** 
	* @return progressState 
	*/
	public Integer getProgressState() {
		return progressState;
	}
	/** 
	* @param progressState 要设置的 progressState 
	*/
	public void setProgressState(Integer progressState) {
		this.progressState = progressState;
	}
	/** 
	* @return auditState 
	*/
	public Integer getAuditState() {
		return auditState;
	}
	/** 
	* @param auditState 要设置的 auditState 
	*/
	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
	}
	/** 
	* @return auditStateName 
	*/
	public String getAuditStateName() {
		return auditStateName;
	}
	/** 
	* @param auditStateName 要设置的 auditStateName 
	*/
	public void setAuditStateName(String auditStateName) {
		this.auditStateName = auditStateName;
	}
	/** 
	* @return cause 
	*/
	public String getCause() {
		return cause;
	}
	/** 
	* @param cause 要设置的 cause 
	*/
	public void setCause(String cause) {
		this.cause = cause;
	}
	/** 
	* @return summarization 
	*/
	public String getSummarization() {
		return summarization;
	}
	/** 
	* @param summarization 要设置的 summarization 
	*/
	public void setSummarization(String summarization) {
		this.summarization = summarization;
	}
	/** 
	* @return groupMemberList 
	*/
	public List<TProductGroupMemberInfo> getGroupMemberList() {
		return groupMemberList;
	}
	/** 
	* @param groupMemberList 要设置的 groupMemberList 
	*/
	public void setGroupMemberList(List<TProductGroupMemberInfo> groupMemberList) {
		this.groupMemberList = groupMemberList;
	}
	/** 
	* @return emrList 
	*/
	public List<TMDTEmrInfo> getEmrList() {
		return emrList;
	}
	/** 
	* @param emrList 要设置的 emrList 
	*/
	public void setEmrList(List<TMDTEmrInfo> emrList) {
		this.emrList = emrList;
	}
	/** 
	* @return createTime 
	*/
	public String getCreateTime() {
		return createTime;
	}
	/** 
	* @param createTime 要设置的 createTime 
	*/
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/** 
	* @return updateTime 
	*/
	public String getUpdateTime() {
		return updateTime;
	}
	/** 
	* @param updateTime 要设置的 updateTime 
	*/
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	/** 
	* @return productId 
	*/
	public String getProductId() {
		return productId;
	}
	/** 
	* @param productId 要设置的 productId 
	*/
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/** 
	* @return consultAttachement 
	*/
	public String getConsultAttachement() {
		return consultAttachement;
	}
	/** 
	* @param consultAttachement 要设置的 consultAttachement 
	*/
	public void setConsultAttachement(String consultAttachement) {
		this.consultAttachement = consultAttachement;
	}
	/** 
	* @return consultAttachementList 
	*/
	public List<String> getConsultAttachementList() {
		return consultAttachementList;
	}
	/** 
	* @param consultAttachementList 要设置的 consultAttachementList 
	*/
	public void setConsultAttachementList(List<String> consultAttachementList) {
		this.consultAttachementList = consultAttachementList;
	}
	/** 
	* @return description 
	*/
	public String getDescription() {
		return description;
	}
	/** 
	* @param description 要设置的 description 
	*/
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRecommendedDoctor() {
		return recommendedDoctor;
	}
	public void setRecommendedDoctor(String recommendedDoctor) {
		this.recommendedDoctor = recommendedDoctor;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Long getBuyer() {
		return buyer;
	}
	public void setBuyer(Long buyer) {
		this.buyer = buyer;
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
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getContactMobile() {
		return contactMobile;
	}
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	public Integer getSubscriptionFlag() {
		return subscriptionFlag;
	}
	public void setSubscriptionFlag(Integer subscriptionFlag) {
		this.subscriptionFlag = subscriptionFlag;
	}
	public float getRealPrice() {
		return realPrice;
	}
	public void setRealPrice(float realPrice) {
		this.realPrice = realPrice;
	}
	public Date getConsultOrderTime() {
		return consultOrderTime;
	}
	public void setConsultOrderTime(Date consultOrderTime) {
		this.consultOrderTime = consultOrderTime;
	}
	public Long getAgentApplicant() {
		return agentApplicant;
	}
	public void setAgentApplicant(Long agentApplicant) {
		this.agentApplicant = agentApplicant;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getMdtApplyNo() {
		return mdtApplyNo;
	}
	public void setMdtApplyNo(String mdtApplyNo) {
		this.mdtApplyNo = mdtApplyNo;
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
	public String getRecommendedDoctorMobile() {
		return recommendedDoctorMobile;
	}
	public void setRecommendedDoctorMobile(String recommendedDoctorMobile) {
		this.recommendedDoctorMobile = recommendedDoctorMobile;
	}
	public String getClinicImpression() {
		return clinicImpression;
	}
	public void setClinicImpression(String clinicImpression) {
		this.clinicImpression = clinicImpression;
	}
	public String getMdtProductExpectConsultDay() {
		return mdtProductExpectConsultDay;
	}
	public void setMdtProductExpectConsultDay(String mdtProductExpectConsultDay) {
		this.mdtProductExpectConsultDay = mdtProductExpectConsultDay;
	}
	public String getMdtFlowStateId() {
		return mdtFlowStateId;
	}
	public void setMdtFlowStateId(String mdtFlowStateId) {
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
	public Integer getSampleCheckFlag() {
		return sampleCheckFlag;
	}
	public void setSampleCheckFlag(Integer sampleCheckFlag) {
		this.sampleCheckFlag = sampleCheckFlag;
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
	public Integer getNeedRadiateFlag() {
		return needRadiateFlag;
	}
	public void setNeedRadiateFlag(Integer needRadiateFlag) {
		this.needRadiateFlag = needRadiateFlag;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getApplyHospitalName() {
		return applyHospitalName;
	}
	public void setApplyHospitalName(String applyHospitalName) {
		this.applyHospitalName = applyHospitalName;
	}
	public String getAgentApplicantName() {
		return agentApplicantName;
	}
	public void setAgentApplicantName(String agentApplicantName) {
		this.agentApplicantName = agentApplicantName;
	}
	public List<MdtDoctorOptionInfo> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<MdtDoctorOptionInfo> optionList) {
		this.optionList = optionList;
	}
	public String getSampleDamageCause() {
		return sampleDamageCause;
	}
	public void setSampleDamageCause(String sampleDamageCause) {
		this.sampleDamageCause = sampleDamageCause;
	}
	public ExpressAddress getExpressAddress() {
		return expressAddress;
	}
	public void setExpressAddress(ExpressAddress expressAddress) {
		this.expressAddress = expressAddress;
	}
	public List<TMDTDoctorInProductGroupInfo> getProductGroup() {
		return productGroup;
	}
	public void setProductGroup(List<TMDTDoctorInProductGroupInfo> productGroup) {
		this.productGroup = productGroup;
	}
	public String getLogisticsInfo() {
		return logisticsInfo;
	}
	public void setLogisticsInfo(String logisticsInfo) {
		this.logisticsInfo = logisticsInfo;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public Long getRadiateUserId() {
		return radiateUserId;
	}
	public void setRadiateUserId(Long radiateUserId) {
		this.radiateUserId = radiateUserId;
	}
	public Date getAcceptanceTime() {
		return acceptanceTime;
	}
	public void setAcceptanceTime(Date acceptanceTime) {
		this.acceptanceTime = acceptanceTime;
	}
	public Long getBasicPathologyUserId() {
		return basicPathologyUserId;
	}
	public void setBasicPathologyUserId(Long basicPathologyUserId) {
		this.basicPathologyUserId = basicPathologyUserId;
	}
	public String getBasicPathologyUserName() {
		return basicPathologyUserName;
	}
	public void setBasicPathologyUserName(String basicPathologyUserName) {
		this.basicPathologyUserName = basicPathologyUserName;
	}
	public String getBasicPathologyUserPhome() {
		return basicPathologyUserPhome;
	}
	public void setBasicPathologyUserPhome(String basicPathologyUserPhome) {
		this.basicPathologyUserPhome = basicPathologyUserPhome;
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
	public String getDataArrangement()
	{
		return dataArrangement;
	}
	public void setDataArrangement(String dataArrangement)
	{
		this.dataArrangement = dataArrangement;
	}
	
	
}
