package com.esuizhen.cloudservice.ehr.model.treatment;

import java.util.Date;
import java.util.List;

public class TreatmentChemotherapyMedicationInfo {
    private String chemotherapyMedicationRecordId;

    private String treatmentId;

    private String inhospitalId;

    private Long patientId;

    private String patientNo;

    private Integer hospitalId;

    private String schemeCategory;
    
    private String schemeCategoryDesc; // add by xueyongyan 20170427 做显示方案类别的其他，用

    private Integer chemotherapyType;

    private String chemotherapyTypeDesc;

    private String remark;

    private Date beginTime;

    private Date endTime;

    private Date createTime;

    private Date updateTime;
    
    private Long operatorId;
    
    private Integer treatmentSchemeId;
    
    private String treatmentName;
    
    private List<TreatmentChemotherapyMedicationDetailInfo> chemotherapyMedicationDetailInfos;
    
    
    public String getSchemeCategoryDesc() {
		return schemeCategoryDesc;
	}

	public void setSchemeCategoryDesc(String schemeCategoryDesc) {
		this.schemeCategoryDesc = schemeCategoryDesc;
	}

	/**
	 * 门诊记录
	 */
	private String clinicMedicalId;

    public String getChemotherapyMedicationRecordId() {
        return chemotherapyMedicationRecordId;
    }

    public void setChemotherapyMedicationRecordId(String chemotherapyMedicationRecordId) {
        this.chemotherapyMedicationRecordId = chemotherapyMedicationRecordId;
    }

    public String getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(String treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getInhospitalId() {
        return inhospitalId;
    }

    public void setInhospitalId(String inhospitalId) {
        this.inhospitalId = inhospitalId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getSchemeCategory() {
        return schemeCategory;
    }

    public void setSchemeCategory(String schemeCategory) {
        this.schemeCategory = schemeCategory;
    }

    public Integer getChemotherapyType() {
        return chemotherapyType;
    }

    public void setChemotherapyType(Integer chemotherapyType) {
        this.chemotherapyType = chemotherapyType;
    }

    public String getChemotherapyTypeDesc() {
        return chemotherapyTypeDesc;
    }

    public void setChemotherapyTypeDesc(String chemotherapyTypeDesc) {
        this.chemotherapyTypeDesc = chemotherapyTypeDesc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

	public List<TreatmentChemotherapyMedicationDetailInfo> getChemotherapyMedicationDetailInfos() {
		return chemotherapyMedicationDetailInfos;
	}

	public void setChemotherapyMedicationDetailInfos(
			List<TreatmentChemotherapyMedicationDetailInfo> chemotherapyMedicationDetailInfos) {
		this.chemotherapyMedicationDetailInfos = chemotherapyMedicationDetailInfos;
	}

	public String getClinicMedicalId() {
		return clinicMedicalId;
	}

	public void setClinicMedicalId(String clinicMedicalId) {
		this.clinicMedicalId = clinicMedicalId;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public Integer getTreatmentSchemeId() {
		return this.treatmentSchemeId;
	}

	public void setTreatmentSchemeId(Integer treatmentSchemeId) {
		this.treatmentSchemeId = treatmentSchemeId;
	}

	public String getTreatmentName() {
		return treatmentName;
	}

	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
	}
}