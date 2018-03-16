package com.esuizhen.cloudservice.ehr.model.inhospitalcost;

import java.math.BigDecimal;
import java.util.Date;


public class TInhospitalCostInfo{
	
	/**
	 * 费用ID
	 */
	private String costId;
	/**
	 * 患者ID
	 */
	private Long patientid;
	/**
	 * 住院唯一标识
	 */
	private String inhospitalId;
	/**
	 * 总费用
	 */
	private BigDecimal totalCost;
	/**
	 * 自付金额
	 */
	private BigDecimal selfCost;
	/**
	 * 一般医疗服务费
	 */
	private BigDecimal generalMedicalServices;
	/**
	 * 一般医疗操作费
	 */
	private BigDecimal commonMedicalProceduresCost;
	/**
	 * 护理费
	 */
	private BigDecimal nursingFees;
	/**
	 * 其他费用
	 */
	private BigDecimal generalMedicalOther;
	/**
	 * 病理诊断费
	 */
	private BigDecimal pathologicalDiagnosis;
	/**
	 * 实验室诊断费
	 */
	private BigDecimal laboratoryDiagnosis;
	/**
	 * 影像学诊断费
	 */
	private BigDecimal imagingDiagnosis;
	/**
	 * 临床诊断项目费
	 */
	private BigDecimal clinicalDiagnosis;
	/**
	 * 非手术治疗项目费
	 */
	private BigDecimal nonSurgicalTreatmentProgram;
	/**
	 * 临床物理治疗费
	 */
	private BigDecimal clinicalPhysicalTherapyFee;
	/**
	 * 手术治疗费
	 */
	private BigDecimal surgicalTreatmentCosts;
	/**
	 * 麻醉费
	 */
	private BigDecimal anesthesiaFees;
	/**
	 * 手术费
	 */
	private BigDecimal surgeryFees;
	/**
	 * 康复费
	 */
	private BigDecimal rehabilitationCosts;
	/**
	 * 中医治疗费
	 */
	private BigDecimal tcmTreatmentCosts;
	/**
	 * 西药费
	 */
	private BigDecimal medicineCosts;
	/**
	 * 抗菌药物费用
	 */
	private BigDecimal antimicrobialDrugCosts;
	/**
	 * 中成药费
	 */
	private BigDecimal medicineCosts2;
	/**
	 * 中草药费
	 */
	private BigDecimal herbalFee;
	/**
	 * 血费
	 */
	private BigDecimal bloodFee;
	/**
	 * 白蛋白类制品费
	 */
	private BigDecimal albuminFee;
	/**
	 * 球蛋白类制品费
	 */
	private BigDecimal globulinFee;
	/**
	 * 凝血因子类制品费
	 */
	private BigDecimal coagulationFactorfee;
	/**
	 * 细胞因子类制品费
	 */
	private BigDecimal cytokinesFee;
	/**
	 * 检查用一次性医用材料费 
	 */
	private BigDecimal checkDisposableMedicalMaterialCosts;
	/**
	 * 治疗用一次性医用材料费
	 */
	private BigDecimal therapeuticDisposableMedicalCosts;
	/**
	 * 手术用一次性医用材料费 
	 */
	private BigDecimal surgicalDisposableMedicalCosts;
	/**
	 * 其他费用
	 */
	private BigDecimal otherCosts;
	/**
	 * 床位费
	 */
	private BigDecimal bedCharges;
	/**
	 * 挂号费
	 */
	private BigDecimal registrationFee;
	/**
	 * 诊察（诊疗）费
	 */
	private BigDecimal examinationFee;
	/**
	 * 接生费
	 */
	private BigDecimal birthRate;
	/**
	 * 监护及辅助呼吸费
	 */
	private BigDecimal careAssistedRespirationRate;
	/**
	 * 一般检查费
	 */
	private BigDecimal routineInspectionFees;
	/**
	 * 核素检查费
	 */
	private BigDecimal radionuclideExaminationFee;
	/**
	 * 超声费
	 */
	private BigDecimal ultrasoundFee;
	/**
	 * 精神治疗费
	 */
	private BigDecimal psychiatricTreatmentCosts;
	/**
	 * 介入治疗费
	 */
	private BigDecimal interventionalTreatmentCosts;
	/**
	 * 特殊治疗费
	 */
	private BigDecimal specialTreatmentCosts;
	/**
	 * 核素治疗费
	 */
	private BigDecimal radionuclideTherapyCosts;
	/**
	 * 放射费
	 */
	private BigDecimal radiationFee;
	/**
	 * 介入用一次性医用材料费
	 */
	private BigDecimal interventionalDisposableFee;
	/**
	 * operator
	 */
	private String operator;
	/**
	 * createTime
	 */
	private Date createTime;
	/**
	 * updateTime
	 */
	private Date updateTime;
	
	
	public void setPatientid(Long patientid) {
		this.patientid = patientid;
	}
	
	public String getCostId() {
		return costId;
	}

	public void setCostId(String costId) {
		this.costId = costId;
	}

	public Long getPatientid() {
		return this.patientid;
	}
	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}
	
	public String getInhospitalId() {
		return this.inhospitalId;
	}
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}
	
	public BigDecimal getTotalCost() {
		return this.totalCost;
	}
	public void setSelfCost(BigDecimal selfCost) {
		this.selfCost = selfCost;
	}
	
	public BigDecimal getSelfCost() {
		return this.selfCost;
	}
	public void setGeneralMedicalServices(BigDecimal generalMedicalServices) {
		this.generalMedicalServices = generalMedicalServices;
	}
	
	public BigDecimal getGeneralMedicalServices() {
		return this.generalMedicalServices;
	}
	public void setCommonMedicalProceduresCost(BigDecimal commonMedicalProceduresCost) {
		this.commonMedicalProceduresCost = commonMedicalProceduresCost;
	}
	
	public BigDecimal getCommonMedicalProceduresCost() {
		return this.commonMedicalProceduresCost;
	}
	public void setNursingFees(BigDecimal nursingFees) {
		this.nursingFees = nursingFees;
	}
	
	public BigDecimal getNursingFees() {
		return this.nursingFees;
	}
	public void setGeneralMedicalOther(BigDecimal generalMedicalOther) {
		this.generalMedicalOther = generalMedicalOther;
	}
	
	public BigDecimal getGeneralMedicalOther() {
		return this.generalMedicalOther;
	}
	public void setPathologicalDiagnosis(BigDecimal pathologicalDiagnosis) {
		this.pathologicalDiagnosis = pathologicalDiagnosis;
	}
	
	public BigDecimal getPathologicalDiagnosis() {
		return this.pathologicalDiagnosis;
	}
	public void setLaboratoryDiagnosis(BigDecimal laboratoryDiagnosis) {
		this.laboratoryDiagnosis = laboratoryDiagnosis;
	}
	
	public BigDecimal getLaboratoryDiagnosis() {
		return this.laboratoryDiagnosis;
	}
	public void setImagingDiagnosis(BigDecimal imagingDiagnosis) {
		this.imagingDiagnosis = imagingDiagnosis;
	}
	
	public BigDecimal getImagingDiagnosis() {
		return this.imagingDiagnosis;
	}
	public void setClinicalDiagnosis(BigDecimal clinicalDiagnosis) {
		this.clinicalDiagnosis = clinicalDiagnosis;
	}
	
	public BigDecimal getClinicalDiagnosis() {
		return this.clinicalDiagnosis;
	}
	public void setNonSurgicalTreatmentProgram(BigDecimal nonSurgicalTreatmentProgram) {
		this.nonSurgicalTreatmentProgram = nonSurgicalTreatmentProgram;
	}
	
	public BigDecimal getNonSurgicalTreatmentProgram() {
		return this.nonSurgicalTreatmentProgram;
	}
	public void setClinicalPhysicalTherapyFee(BigDecimal clinicalPhysicalTherapyFee) {
		this.clinicalPhysicalTherapyFee = clinicalPhysicalTherapyFee;
	}
	
	public BigDecimal getClinicalPhysicalTherapyFee() {
		return this.clinicalPhysicalTherapyFee;
	}
	public void setSurgicalTreatmentCosts(BigDecimal surgicalTreatmentCosts) {
		this.surgicalTreatmentCosts = surgicalTreatmentCosts;
	}
	
	public BigDecimal getSurgicalTreatmentCosts() {
		return this.surgicalTreatmentCosts;
	}
	public void setAnesthesiaFees(BigDecimal anesthesiaFees) {
		this.anesthesiaFees = anesthesiaFees;
	}
	
	public BigDecimal getAnesthesiaFees() {
		return this.anesthesiaFees;
	}
	public void setSurgeryFees(BigDecimal surgeryFees) {
		this.surgeryFees = surgeryFees;
	}
	
	public BigDecimal getSurgeryFees() {
		return this.surgeryFees;
	}
	public void setRehabilitationCosts(BigDecimal rehabilitationCosts) {
		this.rehabilitationCosts = rehabilitationCosts;
	}
	
	public BigDecimal getRehabilitationCosts() {
		return this.rehabilitationCosts;
	}
	public void setTcmTreatmentCosts(BigDecimal tcmTreatmentCosts) {
		this.tcmTreatmentCosts = tcmTreatmentCosts;
	}
	
	public BigDecimal getTcmTreatmentCosts() {
		return this.tcmTreatmentCosts;
	}
	public void setMedicineCosts(BigDecimal medicineCosts) {
		this.medicineCosts = medicineCosts;
	}
	
	public BigDecimal getMedicineCosts() {
		return this.medicineCosts;
	}
	public void setAntimicrobialDrugCosts(BigDecimal antimicrobialDrugCosts) {
		this.antimicrobialDrugCosts = antimicrobialDrugCosts;
	}
	
	public BigDecimal getAntimicrobialDrugCosts() {
		return this.antimicrobialDrugCosts;
	}
	public void setMedicineCosts2(BigDecimal medicineCosts2) {
		this.medicineCosts2 = medicineCosts2;
	}
	
	public BigDecimal getMedicineCosts2() {
		return this.medicineCosts2;
	}
	public void setHerbalFee(BigDecimal herbalFee) {
		this.herbalFee = herbalFee;
	}
	
	public BigDecimal getHerbalFee() {
		return this.herbalFee;
	}
	public void setBloodFee(BigDecimal bloodFee) {
		this.bloodFee = bloodFee;
	}
	
	public BigDecimal getBloodFee() {
		return this.bloodFee;
	}
	public void setAlbuminFee(BigDecimal albuminFee) {
		this.albuminFee = albuminFee;
	}
	
	public BigDecimal getAlbuminFee() {
		return this.albuminFee;
	}
	public void setGlobulinFee(BigDecimal globulinFee) {
		this.globulinFee = globulinFee;
	}
	
	public BigDecimal getGlobulinFee() {
		return this.globulinFee;
	}
	public void setCoagulationFactorfee(BigDecimal coagulationFactorfee) {
		this.coagulationFactorfee = coagulationFactorfee;
	}
	
	public BigDecimal getCoagulationFactorfee() {
		return this.coagulationFactorfee;
	}
	public void setCytokinesFee(BigDecimal cytokinesFee) {
		this.cytokinesFee = cytokinesFee;
	}
	
	public BigDecimal getCytokinesFee() {
		return this.cytokinesFee;
	}
	public void setCheckDisposableMedicalMaterialCosts(BigDecimal checkDisposableMedicalMaterialCosts) {
		this.checkDisposableMedicalMaterialCosts = checkDisposableMedicalMaterialCosts;
	}
	
	public BigDecimal getCheckDisposableMedicalMaterialCosts() {
		return this.checkDisposableMedicalMaterialCosts;
	}
	public void setTherapeuticDisposableMedicalCosts(BigDecimal therapeuticDisposableMedicalCosts) {
		this.therapeuticDisposableMedicalCosts = therapeuticDisposableMedicalCosts;
	}
	
	public BigDecimal getTherapeuticDisposableMedicalCosts() {
		return this.therapeuticDisposableMedicalCosts;
	}
	public void setSurgicalDisposableMedicalCosts(BigDecimal surgicalDisposableMedicalCosts) {
		this.surgicalDisposableMedicalCosts = surgicalDisposableMedicalCosts;
	}
	
	public BigDecimal getSurgicalDisposableMedicalCosts() {
		return this.surgicalDisposableMedicalCosts;
	}
	public void setOtherCosts(BigDecimal otherCosts) {
		this.otherCosts = otherCosts;
	}
	
	public BigDecimal getOtherCosts() {
		return this.otherCosts;
	}
	public void setBedCharges(BigDecimal bedCharges) {
		this.bedCharges = bedCharges;
	}
	
	public BigDecimal getBedCharges() {
		return this.bedCharges;
	}
	public void setRegistrationFee(BigDecimal registrationFee) {
		this.registrationFee = registrationFee;
	}
	
	public BigDecimal getRegistrationFee() {
		return this.registrationFee;
	}
	public void setExaminationFee(BigDecimal examinationFee) {
		this.examinationFee = examinationFee;
	}
	
	public BigDecimal getExaminationFee() {
		return this.examinationFee;
	}
	public void setBirthRate(BigDecimal birthRate) {
		this.birthRate = birthRate;
	}
	
	public BigDecimal getBirthRate() {
		return this.birthRate;
	}
	public void setCareAssistedRespirationRate(BigDecimal careAssistedRespirationRate) {
		this.careAssistedRespirationRate = careAssistedRespirationRate;
	}
	
	public BigDecimal getCareAssistedRespirationRate() {
		return this.careAssistedRespirationRate;
	}
	public void setRoutineInspectionFees(BigDecimal routineInspectionFees) {
		this.routineInspectionFees = routineInspectionFees;
	}
	
	public BigDecimal getRoutineInspectionFees() {
		return this.routineInspectionFees;
	}
	public void setRadionuclideExaminationFee(BigDecimal radionuclideExaminationFee) {
		this.radionuclideExaminationFee = radionuclideExaminationFee;
	}
	
	public BigDecimal getRadionuclideExaminationFee() {
		return this.radionuclideExaminationFee;
	}
	public void setUltrasoundFee(BigDecimal ultrasoundFee) {
		this.ultrasoundFee = ultrasoundFee;
	}
	
	public BigDecimal getUltrasoundFee() {
		return this.ultrasoundFee;
	}
	public void setPsychiatricTreatmentCosts(BigDecimal psychiatricTreatmentCosts) {
		this.psychiatricTreatmentCosts = psychiatricTreatmentCosts;
	}
	
	public BigDecimal getPsychiatricTreatmentCosts() {
		return this.psychiatricTreatmentCosts;
	}
	public void setInterventionalTreatmentCosts(BigDecimal interventionalTreatmentCosts) {
		this.interventionalTreatmentCosts = interventionalTreatmentCosts;
	}
	
	public BigDecimal getInterventionalTreatmentCosts() {
		return this.interventionalTreatmentCosts;
	}
	public void setSpecialTreatmentCosts(BigDecimal specialTreatmentCosts) {
		this.specialTreatmentCosts = specialTreatmentCosts;
	}
	
	public BigDecimal getSpecialTreatmentCosts() {
		return this.specialTreatmentCosts;
	}
	public void setRadionuclideTherapyCosts(BigDecimal radionuclideTherapyCosts) {
		this.radionuclideTherapyCosts = radionuclideTherapyCosts;
	}
	
	public BigDecimal getRadionuclideTherapyCosts() {
		return this.radionuclideTherapyCosts;
	}
	public void setRadiationFee(BigDecimal radiationFee) {
		this.radiationFee = radiationFee;
	}
	
	public BigDecimal getRadiationFee() {
		return this.radiationFee;
	}
	public void setInterventionalDisposableFee(BigDecimal interventionalDisposableFee) {
		this.interventionalDisposableFee = interventionalDisposableFee;
	}
	
	public BigDecimal getInterventionalDisposableFee() {
		return this.interventionalDisposableFee;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getOperator() {
		return this.operator;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}


}

