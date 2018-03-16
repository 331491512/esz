package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;

public class RiskfactorsInfo {
    private String riskfactorsId;

    private Long patientId;

    private String inhospitalId;
    
    private String clinicMedicalId;

    private String riskfactorsTypeId;

    private String riskfactorsTypeName;

    private Long author;

    private Date createTime;

    private Date updateTime;
    
    private RiskfactorsSmokeInfo smokeInfo;
    
    private RiskfactorsSotInfo sotInfo;
    
    private RiskfactorsFoodInfo foodInfo;
    
    private RiskfactorsExerciseInfo exerciseInfo;
    
    private RiskfactorsSleepInfo sleepInfo;

    public String getRiskfactorsId() {
        return riskfactorsId;
    }

    public void setRiskfactorsId(String riskfactorsId) {
        this.riskfactorsId = riskfactorsId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getInhospitalId() {
        return inhospitalId;
    }

    public void setInhospitalId(String inhospitalId) {
        this.inhospitalId = inhospitalId;
    }

    public String getClinicMedicalId() {
		return clinicMedicalId;
	}

	public void setClinicMedicalId(String clinicMedicalId) {
		this.clinicMedicalId = clinicMedicalId;
	}

	public String getRiskfactorsTypeId() {
        return riskfactorsTypeId;
    }

    public void setRiskfactorsTypeId(String riskfactorsTypeId) {
        this.riskfactorsTypeId = riskfactorsTypeId;
    }

    public String getRiskfactorsTypeName() {
        return riskfactorsTypeName;
    }

    public void setRiskfactorsTypeName(String riskfactorsTypeName) {
        this.riskfactorsTypeName = riskfactorsTypeName;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
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

	public RiskfactorsSmokeInfo getSmokeInfo() {
		return smokeInfo;
	}

	public void setSmokeInfo(RiskfactorsSmokeInfo smokeInfo) {
		this.smokeInfo = smokeInfo;
	}

	public RiskfactorsSotInfo getSotInfo() {
		return sotInfo;
	}

	public void setSotInfo(RiskfactorsSotInfo sotInfo) {
		this.sotInfo = sotInfo;
	}

	public RiskfactorsFoodInfo getFoodInfo() {
		return foodInfo;
	}

	public void setFoodInfo(RiskfactorsFoodInfo foodInfo) {
		this.foodInfo = foodInfo;
	}

	public RiskfactorsExerciseInfo getExerciseInfo() {
		return exerciseInfo;
	}

	public void setExerciseInfo(RiskfactorsExerciseInfo exerciseInfo) {
		this.exerciseInfo = exerciseInfo;
	}

	public RiskfactorsSleepInfo getSleepInfo() {
		return sleepInfo;
	}

	public void setSleepInfo(RiskfactorsSleepInfo sleepInfo) {
		this.sleepInfo = sleepInfo;
	}
}