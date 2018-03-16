package com.esuizhen.cloudservice.ehr.model.treatment;

import java.util.Date;
import java.util.List;

public class TreatmentRadiotherapyInfo {
    private String treatmentRadiotherapyRecordId;

    private String treatmentId;

    private String inhospitalId;

    private Long patientId;

    private String patientNo;

    private Integer hospitalId;

    private String radiotherapyType;

    private String radiotherapyTypeDesc;

    private String irradiationWay;

    private String irradiationWayDesc;

    private String radiationSource;

    private String radiationSourceDesc;
    
    private List<RadiationSourceInfo> radiationSourceArr;

    private String bodyPosition;

    private Date createTime;

    private Date updateTime;
    
    /**
     * 放疗明细信息列表
     */
    private List<TreatmentRadiotherapyDetailInfo> radiotherapyDetailInfos;
    
    /**
	 * 门诊记录
	 */
	private String clinicMedicalId;

    public String getTreatmentRadiotherapyRecordId() {
        return treatmentRadiotherapyRecordId;
    }

    public void setTreatmentRadiotherapyRecordId(String treatmentRadiotherapyRecordId) {
        this.treatmentRadiotherapyRecordId = treatmentRadiotherapyRecordId;
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

    public String getRadiotherapyType() {
        return radiotherapyType;
    }

    public void setRadiotherapyType(String radiotherapyType) {
        this.radiotherapyType = radiotherapyType;
    }

    public String getRadiotherapyTypeDesc() {
        return radiotherapyTypeDesc;
    }

    public void setRadiotherapyTypeDesc(String radiotherapyTypeDesc) {
        this.radiotherapyTypeDesc = radiotherapyTypeDesc;
    }

    public String getIrradiationWay() {
        return irradiationWay;
    }

    public void setIrradiationWay(String irradiationWay) {
        this.irradiationWay = irradiationWay;
    }

    public String getIrradiationWayDesc() {
        return irradiationWayDesc;
    }

    public void setIrradiationWayDesc(String irradiationWayDesc) {
        this.irradiationWayDesc = irradiationWayDesc;
    }

    public String getRadiationSource() {
        return radiationSource;
    }

    public void setRadiationSource(String radiationSource) {
        this.radiationSource = radiationSource;
    }

    public String getRadiationSourceDesc() {
        return radiationSourceDesc;
    }

    public void setRadiationSourceDesc(String radiationSourceDesc) {
        this.radiationSourceDesc = radiationSourceDesc;
    }

    public List<RadiationSourceInfo> getRadiationSourceArr() {
		return radiationSourceArr;
	}

	public void setRadiationSourceArr(List<RadiationSourceInfo> radiationSourceArr) {
		this.radiationSourceArr = radiationSourceArr;
	}

	public String getBodyPosition() {
        return bodyPosition;
    }

    public void setBodyPosition(String bodyPosition) {
        this.bodyPosition = bodyPosition;
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

	public List<TreatmentRadiotherapyDetailInfo> getRadiotherapyDetailInfos() {
		return radiotherapyDetailInfos;
	}

	public void setRadiotherapyDetailInfos(
			List<TreatmentRadiotherapyDetailInfo> radiotherapyDetailInfos) {
		this.radiotherapyDetailInfos = radiotherapyDetailInfos;
	}

	public String getClinicMedicalId() {
		return clinicMedicalId;
	}

	public void setClinicMedicalId(String clinicMedicalId) {
		this.clinicMedicalId = clinicMedicalId;
	}
}