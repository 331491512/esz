package com.esuizhen.cloudservice.ehr.model.treatment;

import java.util.Date;

public class TreatmentRadiotherapyDetailInfo {
    private String treatmentRadiotherapyDetailId;

    private String treatmentId;
    
    private String treatmentRadiotherapyRecordId;
    private String inhospitalId;

    private Long patientId;

    private String patientNo;

    private Integer hospitalId;

    private String radiotherapyBodyPart;
    
    /**
     * 射野
     */
    private String scanPart;

    private String radiotherapyBodyPartName;

    private Float totalDose;

    private Float singleDose;

    private Integer counts;

    private Date beginTime;

    private Date endTime;

    private Date createTime;

    private Date updateTime;
    
    /**
	 * 门诊记录
	 */
	private String clinicMedicalId;
	
	/**
	 * 总剂量(文本类型)
	 */
	private String totalDoseText;
	/**
	 * 单次剂量(文本类型)
	 */
	private String singleDoseText;

    public String getTreatmentRadiotherapyDetailId() {
        return treatmentRadiotherapyDetailId;
    }

    public void setTreatmentRadiotherapyDetailId(String treatmentRadiotherapyDetailId) {
        this.treatmentRadiotherapyDetailId = treatmentRadiotherapyDetailId;
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

    public String getRadiotherapyBodyPart() {
        return radiotherapyBodyPart;
    }

    public void setRadiotherapyBodyPart(String radiotherapyBodyPart) {
        this.radiotherapyBodyPart = radiotherapyBodyPart;
    }

    public String getScanPart() {
		return scanPart;
	}

	public void setScanPart(String scanPart) {
		this.scanPart = scanPart;
	}

	public String getRadiotherapyBodyPartName() {
        return radiotherapyBodyPartName;
    }

    public void setRadiotherapyBodyPartName(String radiotherapyBodyPartName) {
        this.radiotherapyBodyPartName = radiotherapyBodyPartName;
    }

    public Float getTotalDose() {
        return totalDose;
    }

    public void setTotalDose(Float totalDose) {
        this.totalDose = totalDose;
    }

    public Float getSingleDose() {
        return singleDose;
    }

    public void setSingleDose(Float singleDose) {
        this.singleDose = singleDose;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
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

	public String getTreatmentRadiotherapyRecordId() {
		return treatmentRadiotherapyRecordId;
	}

	public void setTreatmentRadiotherapyRecordId(
			String treatmentRadiotherapyRecordId) {
		this.treatmentRadiotherapyRecordId = treatmentRadiotherapyRecordId;
	}

	public String getClinicMedicalId() {
		return clinicMedicalId;
	}

	public void setClinicMedicalId(String clinicMedicalId) {
		this.clinicMedicalId = clinicMedicalId;
	}

	public String getTotalDoseText() {
		return totalDoseText;
	}

	public void setTotalDoseText(String totalDoseText) {
		this.totalDoseText = totalDoseText;
	}

	public String getSingleDoseText() {
		return singleDoseText;
	}

	public void setSingleDoseText(String singleDoseText) {
		this.singleDoseText = singleDoseText;
	}
}