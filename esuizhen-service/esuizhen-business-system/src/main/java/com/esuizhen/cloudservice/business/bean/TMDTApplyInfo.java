/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>TDoctorClinicInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月14日下午3:52:07<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;



/** 
* @ClassName: TDoctorClinicInfo.java
* @Description: 
* @author lichenghao
* @date 2015年12月14日 下午3:52:07  
*/
public class TMDTApplyInfo {
	/**
	 * 会诊id
	 */
	private Long id;
	//服务申请号
	private String productApplyId;
	
	//主要诊断
	private String diagnosis;
	
	//要求与目的
	private String goal;
	
	//病理诊断
	private String pathologyDiagnosis;
	/**
	 * 会诊号
	 */
	private String mdtApplyNo;
	//临床印象
	private String clinicImpression;
	/**
	 * 申请日期
	 */
	private String createTime;
	/**
	 * 申请医院id
	 */
	private Integer applyHospitalId;
	/**
	 * 申请医院名称
	 */
	private String applyHospitalName;
	/**
	 * 申请医院的科室ID
	 */
	private Integer deptId;
	/**
	 * 申请医生id
	 */
	private Integer agentApplicant;
	/**
	 * 申请医生名称
	 */
	private String agentApplicantName;
	/**
	 * 
	 */
	private String recommendedDoctorMobile;
	/**
	 * 患者姓名
	 */
	private String trueName;
	/**
	 * 性 别
	 */
	private String sex;
	/**
	 * 患者手机号
	 */
	private String mobile;
	/**
	 * 病案号
	 */
	private String patientNo;
	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * 处理流程状态id
	 */
	private Integer mdtFlowStateId;
	/**
	 * 处理流程状态名称
	 */
	private String mdtFlowStateName;
	/**
	 * 会诊专家组
	 */
	private String productName;
	/**
	 * 会诊结果
	 */
	private String summarization;
	private Integer pathologySectionFlag;
	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getPathologyDiagnosis() {
		return pathologyDiagnosis;
	}

	public String getRecommendedDoctorMobile() {
		return recommendedDoctorMobile;
	}

	public void setRecommendedDoctorMobile(String recommendedDoctorMobile) {
		this.recommendedDoctorMobile = recommendedDoctorMobile;
	}

	public void setPathologyDiagnosis(String pathologyDiagnosis) {
		this.pathologyDiagnosis = pathologyDiagnosis;
	}

	public String getClinicImpression() {
		return clinicImpression;
	}

	public void setClinicImpression(String clinicImpression) {
		this.clinicImpression = clinicImpression;
	}

	public String getProductApplyId() {
		return productApplyId;
	}

	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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

	public Integer getMdtFlowStateId() {
		return mdtFlowStateId;
	}

	public void setMdtFlowStateId(Integer mdtFlowStateId) {
		this.mdtFlowStateId = mdtFlowStateId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getApplyHospitalName() {
		return applyHospitalName;
	}

	public void setApplyHospitalName(String applyHospitalName) {
		this.applyHospitalName = applyHospitalName;
	}

	public Integer getAgentApplicant() {
		return agentApplicant;
	}

	public void setAgentApplicant(Integer agentApplicant) {
		this.agentApplicant = agentApplicant;
	}

	public String getAgentApplicantName() {
		return agentApplicantName;
	}

	public void setAgentApplicantName(String agentApplicantName) {
		this.agentApplicantName = agentApplicantName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMdtFlowStateName() {
		return mdtFlowStateName;
	}

	public void setMdtFlowStateName(String mdtFlowStateName) {
		this.mdtFlowStateName = mdtFlowStateName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSummarization() {
		return summarization;
	}

	public void setSummarization(String summarization) {
		this.summarization = summarization;
	}

	public Integer getPathologySectionFlag() {
		return pathologySectionFlag;
	}

	public void setPathologySectionFlag(Integer pathologySectionFlag) {
		this.pathologySectionFlag = pathologySectionFlag;
	}
}
