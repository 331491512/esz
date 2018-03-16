package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "ei_inhospital_cost", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "ei_inhospital_cost_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class EiInhospitalCost {
    private Integer costId;
    private Integer patientid;
    private String inhospitalId;
    private Integer totalCost;
    private Integer selfCost;
    private Integer generalMedicalServices;
    private Integer commonMedicalProceduresCost;
    private Integer nursingFees;
    private Integer generalMedicalOther;
    private Integer pathologicalDiagnosis;
    private Integer laboratoryDiagnosis;
    private Integer imagingDiagnosis;
    private Integer clinicalDiagnosis;
    private Integer nonSurgicalTreatmentProgram;
    private Integer clinicalPhysicalTherapyFee;
    private Integer surgicalTreatmentCosts;
    private Integer anesthesiaFees;
    private Integer surgeryFees;
    private Integer rehabilitationCosts;
    private Integer tcmTreatmentCosts;
    private Integer medicineCosts;
    private Integer antimicrobialDrugCosts;
    private Integer medicineCosts2;
    private Integer herbalFee;
    private Integer bloodFee;
    private Integer albuminFee;
    private Integer globulinFee;
    private Integer coagulationFactorfee;
    private Integer cytokinesFee;
    private Integer checkDisposableMedicalMaterialCosts;
    private Integer therapeuticDisposableMedicalCosts;
    private Integer surgicalDisposableMedicalCosts;
    private Integer otherCosts;
    private Integer bedCharges;
    private Integer registrationFee;
    private Integer examinationFee;
    private Integer birthRate;
    private Integer careAssistedRespirationRate;
    private Integer routineInspectionFees;
    private Integer radionuclideExaminationFee;
    private Integer ultrasoundFee;
    private Integer psychiatricTreatmentCosts;
    private Integer interventionalTreatmentCosts;
    private Integer specialTreatmentCosts;
    private Integer radionuclideTherapyCosts;
    private Integer radiationFee;
    private Integer interventionalDisposableFee;
    private String operator;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "costId", nullable = false)
    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    @Basic
    @Column(name = "patientid", nullable = true)
    public Integer getPatientid() {
        return patientid;
    }

    public void setPatientid(Integer patientid) {
        this.patientid = patientid;
    }

    @Basic
    @Column(name = "inhospitalId", nullable = true, length = 128)
    public String getInhospitalId() {
        return inhospitalId;
    }

    public void setInhospitalId(String inhospitalId) {
        this.inhospitalId = inhospitalId;
    }

    @Basic
    @Column(name = "totalCost", nullable = true)
    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    @Basic
    @Column(name = "selfCost", nullable = true)
    public Integer getSelfCost() {
        return selfCost;
    }

    public void setSelfCost(Integer selfCost) {
        this.selfCost = selfCost;
    }

    @Basic
    @Column(name = "generalMedicalServices", nullable = true)
    public Integer getGeneralMedicalServices() {
        return generalMedicalServices;
    }

    public void setGeneralMedicalServices(Integer generalMedicalServices) {
        this.generalMedicalServices = generalMedicalServices;
    }

    @Basic
    @Column(name = "commonMedicalProceduresCost", nullable = true)
    public Integer getCommonMedicalProceduresCost() {
        return commonMedicalProceduresCost;
    }

    public void setCommonMedicalProceduresCost(Integer commonMedicalProceduresCost) {
        this.commonMedicalProceduresCost = commonMedicalProceduresCost;
    }

    @Basic
    @Column(name = "nursingFees", nullable = true)
    public Integer getNursingFees() {
        return nursingFees;
    }

    public void setNursingFees(Integer nursingFees) {
        this.nursingFees = nursingFees;
    }

    @Basic
    @Column(name = "generalMedicalOther", nullable = true)
    public Integer getGeneralMedicalOther() {
        return generalMedicalOther;
    }

    public void setGeneralMedicalOther(Integer generalMedicalOther) {
        this.generalMedicalOther = generalMedicalOther;
    }

    @Basic
    @Column(name = "pathologicalDiagnosis", nullable = true)
    public Integer getPathologicalDiagnosis() {
        return pathologicalDiagnosis;
    }

    public void setPathologicalDiagnosis(Integer pathologicalDiagnosis) {
        this.pathologicalDiagnosis = pathologicalDiagnosis;
    }

    @Basic
    @Column(name = "laboratoryDiagnosis", nullable = true)
    public Integer getLaboratoryDiagnosis() {
        return laboratoryDiagnosis;
    }

    public void setLaboratoryDiagnosis(Integer laboratoryDiagnosis) {
        this.laboratoryDiagnosis = laboratoryDiagnosis;
    }

    @Basic
    @Column(name = "imagingDiagnosis", nullable = true)
    public Integer getImagingDiagnosis() {
        return imagingDiagnosis;
    }

    public void setImagingDiagnosis(Integer imagingDiagnosis) {
        this.imagingDiagnosis = imagingDiagnosis;
    }

    @Basic
    @Column(name = "clinicalDiagnosis", nullable = true)
    public Integer getClinicalDiagnosis() {
        return clinicalDiagnosis;
    }

    public void setClinicalDiagnosis(Integer clinicalDiagnosis) {
        this.clinicalDiagnosis = clinicalDiagnosis;
    }

    @Basic
    @Column(name = "nonSurgicalTreatmentProgram", nullable = true)
    public Integer getNonSurgicalTreatmentProgram() {
        return nonSurgicalTreatmentProgram;
    }

    public void setNonSurgicalTreatmentProgram(Integer nonSurgicalTreatmentProgram) {
        this.nonSurgicalTreatmentProgram = nonSurgicalTreatmentProgram;
    }

    @Basic
    @Column(name = "clinicalPhysicalTherapyFee", nullable = true)
    public Integer getClinicalPhysicalTherapyFee() {
        return clinicalPhysicalTherapyFee;
    }

    public void setClinicalPhysicalTherapyFee(Integer clinicalPhysicalTherapyFee) {
        this.clinicalPhysicalTherapyFee = clinicalPhysicalTherapyFee;
    }

    @Basic
    @Column(name = "surgicalTreatmentCosts", nullable = true)
    public Integer getSurgicalTreatmentCosts() {
        return surgicalTreatmentCosts;
    }

    public void setSurgicalTreatmentCosts(Integer surgicalTreatmentCosts) {
        this.surgicalTreatmentCosts = surgicalTreatmentCosts;
    }

    @Basic
    @Column(name = "anesthesiaFees", nullable = true)
    public Integer getAnesthesiaFees() {
        return anesthesiaFees;
    }

    public void setAnesthesiaFees(Integer anesthesiaFees) {
        this.anesthesiaFees = anesthesiaFees;
    }

    @Basic
    @Column(name = "surgeryFees", nullable = true)
    public Integer getSurgeryFees() {
        return surgeryFees;
    }

    public void setSurgeryFees(Integer surgeryFees) {
        this.surgeryFees = surgeryFees;
    }

    @Basic
    @Column(name = "rehabilitationCosts", nullable = true)
    public Integer getRehabilitationCosts() {
        return rehabilitationCosts;
    }

    public void setRehabilitationCosts(Integer rehabilitationCosts) {
        this.rehabilitationCosts = rehabilitationCosts;
    }

    @Basic
    @Column(name = "tcmTreatmentCosts", nullable = true)
    public Integer getTcmTreatmentCosts() {
        return tcmTreatmentCosts;
    }

    public void setTcmTreatmentCosts(Integer tcmTreatmentCosts) {
        this.tcmTreatmentCosts = tcmTreatmentCosts;
    }

    @Basic
    @Column(name = "medicineCosts", nullable = true)
    public Integer getMedicineCosts() {
        return medicineCosts;
    }

    public void setMedicineCosts(Integer medicineCosts) {
        this.medicineCosts = medicineCosts;
    }

    @Basic
    @Column(name = "antimicrobialDrugCosts", nullable = true)
    public Integer getAntimicrobialDrugCosts() {
        return antimicrobialDrugCosts;
    }

    public void setAntimicrobialDrugCosts(Integer antimicrobialDrugCosts) {
        this.antimicrobialDrugCosts = antimicrobialDrugCosts;
    }

    @Basic
    @Column(name = "medicineCosts2", nullable = true)
    public Integer getMedicineCosts2() {
        return medicineCosts2;
    }

    public void setMedicineCosts2(Integer medicineCosts2) {
        this.medicineCosts2 = medicineCosts2;
    }

    @Basic
    @Column(name = "herbalFee", nullable = true)
    public Integer getHerbalFee() {
        return herbalFee;
    }

    public void setHerbalFee(Integer herbalFee) {
        this.herbalFee = herbalFee;
    }

    @Basic
    @Column(name = "bloodFee", nullable = true)
    public Integer getBloodFee() {
        return bloodFee;
    }

    public void setBloodFee(Integer bloodFee) {
        this.bloodFee = bloodFee;
    }

    @Basic
    @Column(name = "albuminFee", nullable = true)
    public Integer getAlbuminFee() {
        return albuminFee;
    }

    public void setAlbuminFee(Integer albuminFee) {
        this.albuminFee = albuminFee;
    }

    @Basic
    @Column(name = "globulinFee", nullable = true)
    public Integer getGlobulinFee() {
        return globulinFee;
    }

    public void setGlobulinFee(Integer globulinFee) {
        this.globulinFee = globulinFee;
    }

    @Basic
    @Column(name = "coagulationFactorfee", nullable = true)
    public Integer getCoagulationFactorfee() {
        return coagulationFactorfee;
    }

    public void setCoagulationFactorfee(Integer coagulationFactorfee) {
        this.coagulationFactorfee = coagulationFactorfee;
    }

    @Basic
    @Column(name = "cytokinesFee", nullable = true)
    public Integer getCytokinesFee() {
        return cytokinesFee;
    }

    public void setCytokinesFee(Integer cytokinesFee) {
        this.cytokinesFee = cytokinesFee;
    }

    @Basic
    @Column(name = "checkDisposableMedicalMaterialCosts", nullable = true)
    public Integer getCheckDisposableMedicalMaterialCosts() {
        return checkDisposableMedicalMaterialCosts;
    }

    public void setCheckDisposableMedicalMaterialCosts(Integer checkDisposableMedicalMaterialCosts) {
        this.checkDisposableMedicalMaterialCosts = checkDisposableMedicalMaterialCosts;
    }

    @Basic
    @Column(name = "therapeuticDisposableMedicalCosts", nullable = true)
    public Integer getTherapeuticDisposableMedicalCosts() {
        return therapeuticDisposableMedicalCosts;
    }

    public void setTherapeuticDisposableMedicalCosts(Integer therapeuticDisposableMedicalCosts) {
        this.therapeuticDisposableMedicalCosts = therapeuticDisposableMedicalCosts;
    }

    @Basic
    @Column(name = "surgicalDisposableMedicalCosts", nullable = true)
    public Integer getSurgicalDisposableMedicalCosts() {
        return surgicalDisposableMedicalCosts;
    }

    public void setSurgicalDisposableMedicalCosts(Integer surgicalDisposableMedicalCosts) {
        this.surgicalDisposableMedicalCosts = surgicalDisposableMedicalCosts;
    }

    @Basic
    @Column(name = "otherCosts", nullable = true)
    public Integer getOtherCosts() {
        return otherCosts;
    }

    public void setOtherCosts(Integer otherCosts) {
        this.otherCosts = otherCosts;
    }

    @Basic
    @Column(name = "bedCharges", nullable = true)
    public Integer getBedCharges() {
        return bedCharges;
    }

    public void setBedCharges(Integer bedCharges) {
        this.bedCharges = bedCharges;
    }

    @Basic
    @Column(name = "registrationFee", nullable = true)
    public Integer getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(Integer registrationFee) {
        this.registrationFee = registrationFee;
    }

    @Basic
    @Column(name = "examinationFee", nullable = true)
    public Integer getExaminationFee() {
        return examinationFee;
    }

    public void setExaminationFee(Integer examinationFee) {
        this.examinationFee = examinationFee;
    }

    @Basic
    @Column(name = "birthRate", nullable = true)
    public Integer getBirthRate() {
        return birthRate;
    }

    public void setBirthRate(Integer birthRate) {
        this.birthRate = birthRate;
    }

    @Basic
    @Column(name = "careAssistedRespirationRate", nullable = true)
    public Integer getCareAssistedRespirationRate() {
        return careAssistedRespirationRate;
    }

    public void setCareAssistedRespirationRate(Integer careAssistedRespirationRate) {
        this.careAssistedRespirationRate = careAssistedRespirationRate;
    }

    @Basic
    @Column(name = "routineInspectionFees", nullable = true)
    public Integer getRoutineInspectionFees() {
        return routineInspectionFees;
    }

    public void setRoutineInspectionFees(Integer routineInspectionFees) {
        this.routineInspectionFees = routineInspectionFees;
    }

    @Basic
    @Column(name = "radionuclideExaminationFee", nullable = true)
    public Integer getRadionuclideExaminationFee() {
        return radionuclideExaminationFee;
    }

    public void setRadionuclideExaminationFee(Integer radionuclideExaminationFee) {
        this.radionuclideExaminationFee = radionuclideExaminationFee;
    }

    @Basic
    @Column(name = "ultrasoundFee", nullable = true)
    public Integer getUltrasoundFee() {
        return ultrasoundFee;
    }

    public void setUltrasoundFee(Integer ultrasoundFee) {
        this.ultrasoundFee = ultrasoundFee;
    }

    @Basic
    @Column(name = "psychiatricTreatmentCosts", nullable = true)
    public Integer getPsychiatricTreatmentCosts() {
        return psychiatricTreatmentCosts;
    }

    public void setPsychiatricTreatmentCosts(Integer psychiatricTreatmentCosts) {
        this.psychiatricTreatmentCosts = psychiatricTreatmentCosts;
    }

    @Basic
    @Column(name = "interventionalTreatmentCosts", nullable = true)
    public Integer getInterventionalTreatmentCosts() {
        return interventionalTreatmentCosts;
    }

    public void setInterventionalTreatmentCosts(Integer interventionalTreatmentCosts) {
        this.interventionalTreatmentCosts = interventionalTreatmentCosts;
    }

    @Basic
    @Column(name = "specialTreatmentCosts", nullable = true)
    public Integer getSpecialTreatmentCosts() {
        return specialTreatmentCosts;
    }

    public void setSpecialTreatmentCosts(Integer specialTreatmentCosts) {
        this.specialTreatmentCosts = specialTreatmentCosts;
    }

    @Basic
    @Column(name = "radionuclideTherapyCosts", nullable = true)
    public Integer getRadionuclideTherapyCosts() {
        return radionuclideTherapyCosts;
    }

    public void setRadionuclideTherapyCosts(Integer radionuclideTherapyCosts) {
        this.radionuclideTherapyCosts = radionuclideTherapyCosts;
    }

    @Basic
    @Column(name = "radiationFee", nullable = true)
    public Integer getRadiationFee() {
        return radiationFee;
    }

    public void setRadiationFee(Integer radiationFee) {
        this.radiationFee = radiationFee;
    }

    @Basic
    @Column(name = "interventionalDisposableFee", nullable = true)
    public Integer getInterventionalDisposableFee() {
        return interventionalDisposableFee;
    }

    public void setInterventionalDisposableFee(Integer interventionalDisposableFee) {
        this.interventionalDisposableFee = interventionalDisposableFee;
    }

    @Basic
    @Column(name = "operator", nullable = true, length = 20)
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Basic
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateTime", nullable = false)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EiInhospitalCost that = (EiInhospitalCost) o;

        if (costId != null ? !costId.equals(that.costId) : that.costId != null) return false;
        if (patientid != null ? !patientid.equals(that.patientid) : that.patientid != null) return false;
        if (inhospitalId != null ? !inhospitalId.equals(that.inhospitalId) : that.inhospitalId != null) return false;
        if (totalCost != null ? !totalCost.equals(that.totalCost) : that.totalCost != null) return false;
        if (selfCost != null ? !selfCost.equals(that.selfCost) : that.selfCost != null) return false;
        if (generalMedicalServices != null ? !generalMedicalServices.equals(that.generalMedicalServices) : that.generalMedicalServices != null)
            return false;
        if (commonMedicalProceduresCost != null ? !commonMedicalProceduresCost.equals(that.commonMedicalProceduresCost) : that.commonMedicalProceduresCost != null)
            return false;
        if (nursingFees != null ? !nursingFees.equals(that.nursingFees) : that.nursingFees != null) return false;
        if (generalMedicalOther != null ? !generalMedicalOther.equals(that.generalMedicalOther) : that.generalMedicalOther != null)
            return false;
        if (pathologicalDiagnosis != null ? !pathologicalDiagnosis.equals(that.pathologicalDiagnosis) : that.pathologicalDiagnosis != null)
            return false;
        if (laboratoryDiagnosis != null ? !laboratoryDiagnosis.equals(that.laboratoryDiagnosis) : that.laboratoryDiagnosis != null)
            return false;
        if (imagingDiagnosis != null ? !imagingDiagnosis.equals(that.imagingDiagnosis) : that.imagingDiagnosis != null)
            return false;
        if (clinicalDiagnosis != null ? !clinicalDiagnosis.equals(that.clinicalDiagnosis) : that.clinicalDiagnosis != null)
            return false;
        if (nonSurgicalTreatmentProgram != null ? !nonSurgicalTreatmentProgram.equals(that.nonSurgicalTreatmentProgram) : that.nonSurgicalTreatmentProgram != null)
            return false;
        if (clinicalPhysicalTherapyFee != null ? !clinicalPhysicalTherapyFee.equals(that.clinicalPhysicalTherapyFee) : that.clinicalPhysicalTherapyFee != null)
            return false;
        if (surgicalTreatmentCosts != null ? !surgicalTreatmentCosts.equals(that.surgicalTreatmentCosts) : that.surgicalTreatmentCosts != null)
            return false;
        if (anesthesiaFees != null ? !anesthesiaFees.equals(that.anesthesiaFees) : that.anesthesiaFees != null)
            return false;
        if (surgeryFees != null ? !surgeryFees.equals(that.surgeryFees) : that.surgeryFees != null) return false;
        if (rehabilitationCosts != null ? !rehabilitationCosts.equals(that.rehabilitationCosts) : that.rehabilitationCosts != null)
            return false;
        if (tcmTreatmentCosts != null ? !tcmTreatmentCosts.equals(that.tcmTreatmentCosts) : that.tcmTreatmentCosts != null)
            return false;
        if (medicineCosts != null ? !medicineCosts.equals(that.medicineCosts) : that.medicineCosts != null)
            return false;
        if (antimicrobialDrugCosts != null ? !antimicrobialDrugCosts.equals(that.antimicrobialDrugCosts) : that.antimicrobialDrugCosts != null)
            return false;
        if (medicineCosts2 != null ? !medicineCosts2.equals(that.medicineCosts2) : that.medicineCosts2 != null)
            return false;
        if (herbalFee != null ? !herbalFee.equals(that.herbalFee) : that.herbalFee != null) return false;
        if (bloodFee != null ? !bloodFee.equals(that.bloodFee) : that.bloodFee != null) return false;
        if (albuminFee != null ? !albuminFee.equals(that.albuminFee) : that.albuminFee != null) return false;
        if (globulinFee != null ? !globulinFee.equals(that.globulinFee) : that.globulinFee != null) return false;
        if (coagulationFactorfee != null ? !coagulationFactorfee.equals(that.coagulationFactorfee) : that.coagulationFactorfee != null)
            return false;
        if (cytokinesFee != null ? !cytokinesFee.equals(that.cytokinesFee) : that.cytokinesFee != null) return false;
        if (checkDisposableMedicalMaterialCosts != null ? !checkDisposableMedicalMaterialCosts.equals(that.checkDisposableMedicalMaterialCosts) : that.checkDisposableMedicalMaterialCosts != null)
            return false;
        if (therapeuticDisposableMedicalCosts != null ? !therapeuticDisposableMedicalCosts.equals(that.therapeuticDisposableMedicalCosts) : that.therapeuticDisposableMedicalCosts != null)
            return false;
        if (surgicalDisposableMedicalCosts != null ? !surgicalDisposableMedicalCosts.equals(that.surgicalDisposableMedicalCosts) : that.surgicalDisposableMedicalCosts != null)
            return false;
        if (otherCosts != null ? !otherCosts.equals(that.otherCosts) : that.otherCosts != null) return false;
        if (bedCharges != null ? !bedCharges.equals(that.bedCharges) : that.bedCharges != null) return false;
        if (registrationFee != null ? !registrationFee.equals(that.registrationFee) : that.registrationFee != null)
            return false;
        if (examinationFee != null ? !examinationFee.equals(that.examinationFee) : that.examinationFee != null)
            return false;
        if (birthRate != null ? !birthRate.equals(that.birthRate) : that.birthRate != null) return false;
        if (careAssistedRespirationRate != null ? !careAssistedRespirationRate.equals(that.careAssistedRespirationRate) : that.careAssistedRespirationRate != null)
            return false;
        if (routineInspectionFees != null ? !routineInspectionFees.equals(that.routineInspectionFees) : that.routineInspectionFees != null)
            return false;
        if (radionuclideExaminationFee != null ? !radionuclideExaminationFee.equals(that.radionuclideExaminationFee) : that.radionuclideExaminationFee != null)
            return false;
        if (ultrasoundFee != null ? !ultrasoundFee.equals(that.ultrasoundFee) : that.ultrasoundFee != null)
            return false;
        if (psychiatricTreatmentCosts != null ? !psychiatricTreatmentCosts.equals(that.psychiatricTreatmentCosts) : that.psychiatricTreatmentCosts != null)
            return false;
        if (interventionalTreatmentCosts != null ? !interventionalTreatmentCosts.equals(that.interventionalTreatmentCosts) : that.interventionalTreatmentCosts != null)
            return false;
        if (specialTreatmentCosts != null ? !specialTreatmentCosts.equals(that.specialTreatmentCosts) : that.specialTreatmentCosts != null)
            return false;
        if (radionuclideTherapyCosts != null ? !radionuclideTherapyCosts.equals(that.radionuclideTherapyCosts) : that.radionuclideTherapyCosts != null)
            return false;
        if (radiationFee != null ? !radiationFee.equals(that.radiationFee) : that.radiationFee != null) return false;
        if (interventionalDisposableFee != null ? !interventionalDisposableFee.equals(that.interventionalDisposableFee) : that.interventionalDisposableFee != null)
            return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = costId != null ? costId.hashCode() : 0;
        result = 31 * result + (patientid != null ? patientid.hashCode() : 0);
        result = 31 * result + (inhospitalId != null ? inhospitalId.hashCode() : 0);
        result = 31 * result + (totalCost != null ? totalCost.hashCode() : 0);
        result = 31 * result + (selfCost != null ? selfCost.hashCode() : 0);
        result = 31 * result + (generalMedicalServices != null ? generalMedicalServices.hashCode() : 0);
        result = 31 * result + (commonMedicalProceduresCost != null ? commonMedicalProceduresCost.hashCode() : 0);
        result = 31 * result + (nursingFees != null ? nursingFees.hashCode() : 0);
        result = 31 * result + (generalMedicalOther != null ? generalMedicalOther.hashCode() : 0);
        result = 31 * result + (pathologicalDiagnosis != null ? pathologicalDiagnosis.hashCode() : 0);
        result = 31 * result + (laboratoryDiagnosis != null ? laboratoryDiagnosis.hashCode() : 0);
        result = 31 * result + (imagingDiagnosis != null ? imagingDiagnosis.hashCode() : 0);
        result = 31 * result + (clinicalDiagnosis != null ? clinicalDiagnosis.hashCode() : 0);
        result = 31 * result + (nonSurgicalTreatmentProgram != null ? nonSurgicalTreatmentProgram.hashCode() : 0);
        result = 31 * result + (clinicalPhysicalTherapyFee != null ? clinicalPhysicalTherapyFee.hashCode() : 0);
        result = 31 * result + (surgicalTreatmentCosts != null ? surgicalTreatmentCosts.hashCode() : 0);
        result = 31 * result + (anesthesiaFees != null ? anesthesiaFees.hashCode() : 0);
        result = 31 * result + (surgeryFees != null ? surgeryFees.hashCode() : 0);
        result = 31 * result + (rehabilitationCosts != null ? rehabilitationCosts.hashCode() : 0);
        result = 31 * result + (tcmTreatmentCosts != null ? tcmTreatmentCosts.hashCode() : 0);
        result = 31 * result + (medicineCosts != null ? medicineCosts.hashCode() : 0);
        result = 31 * result + (antimicrobialDrugCosts != null ? antimicrobialDrugCosts.hashCode() : 0);
        result = 31 * result + (medicineCosts2 != null ? medicineCosts2.hashCode() : 0);
        result = 31 * result + (herbalFee != null ? herbalFee.hashCode() : 0);
        result = 31 * result + (bloodFee != null ? bloodFee.hashCode() : 0);
        result = 31 * result + (albuminFee != null ? albuminFee.hashCode() : 0);
        result = 31 * result + (globulinFee != null ? globulinFee.hashCode() : 0);
        result = 31 * result + (coagulationFactorfee != null ? coagulationFactorfee.hashCode() : 0);
        result = 31 * result + (cytokinesFee != null ? cytokinesFee.hashCode() : 0);
        result = 31 * result + (checkDisposableMedicalMaterialCosts != null ? checkDisposableMedicalMaterialCosts.hashCode() : 0);
        result = 31 * result + (therapeuticDisposableMedicalCosts != null ? therapeuticDisposableMedicalCosts.hashCode() : 0);
        result = 31 * result + (surgicalDisposableMedicalCosts != null ? surgicalDisposableMedicalCosts.hashCode() : 0);
        result = 31 * result + (otherCosts != null ? otherCosts.hashCode() : 0);
        result = 31 * result + (bedCharges != null ? bedCharges.hashCode() : 0);
        result = 31 * result + (registrationFee != null ? registrationFee.hashCode() : 0);
        result = 31 * result + (examinationFee != null ? examinationFee.hashCode() : 0);
        result = 31 * result + (birthRate != null ? birthRate.hashCode() : 0);
        result = 31 * result + (careAssistedRespirationRate != null ? careAssistedRespirationRate.hashCode() : 0);
        result = 31 * result + (routineInspectionFees != null ? routineInspectionFees.hashCode() : 0);
        result = 31 * result + (radionuclideExaminationFee != null ? radionuclideExaminationFee.hashCode() : 0);
        result = 31 * result + (ultrasoundFee != null ? ultrasoundFee.hashCode() : 0);
        result = 31 * result + (psychiatricTreatmentCosts != null ? psychiatricTreatmentCosts.hashCode() : 0);
        result = 31 * result + (interventionalTreatmentCosts != null ? interventionalTreatmentCosts.hashCode() : 0);
        result = 31 * result + (specialTreatmentCosts != null ? specialTreatmentCosts.hashCode() : 0);
        result = 31 * result + (radionuclideTherapyCosts != null ? radionuclideTherapyCosts.hashCode() : 0);
        result = 31 * result + (radiationFee != null ? radiationFee.hashCode() : 0);
        result = 31 * result + (interventionalDisposableFee != null ? interventionalDisposableFee.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
