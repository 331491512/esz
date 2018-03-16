package com.esuizhen.cloudservice.followup.model.review;

import java.util.Date;

public class FollowupReviewAppoint {
    private String appointId;

    private Long patientId;

    private Integer hospitalId;

    private Integer followupTaskId;

    private Integer followupAssignId;

    private Date applyTime;

    private Integer appointDeptId;

    private String appointDeptName;

    private String appointDoctorId;

    private String appointDoctorName;

    private Date appointDate;

    private Integer appointTimeRange;

    private String doctorReply;

    private String appointResult;

    private Integer operatorId;

    private String operatorName;

    private String remark;

    private Date createTime;

    private Date updateTime;
    
    private String sourceFlag;
    
    /**
     * 以下为患者在基本信息
     * @return
     */
    private String trueName;
    private String sex;
    private String identification;
    private String mobile;
    private String diseaseTypeName;
    /**
     * 1-可以拨打，0-拨打电话按钮置灰
     */
    private Integer callFlag;
    public String getAppointId() {
        return appointId;
    }

    public void setAppointId(String appointId) {
        this.appointId = appointId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getFollowupTaskId() {
        return followupTaskId;
    }

    public void setFollowupTaskId(Integer followupTaskId) {
        this.followupTaskId = followupTaskId;
    }

    public Integer getFollowupAssignId() {
        return followupAssignId;
    }

    public void setFollowupAssignId(Integer followupAssignId) {
        this.followupAssignId = followupAssignId;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getAppointDeptId() {
        return appointDeptId;
    }

    public void setAppointDeptId(Integer appointDeptId) {
        this.appointDeptId = appointDeptId;
    }

    public String getAppointDeptName() {
        return appointDeptName;
    }

    public void setAppointDeptName(String appointDeptName) {
        this.appointDeptName = appointDeptName;
    }

    public String getAppointDoctorId() {
        return appointDoctorId;
    }

    public void setAppointDoctorId(String appointDoctorId) {
        this.appointDoctorId = appointDoctorId;
    }

    public String getAppointDoctorName() {
        return appointDoctorName;
    }

    public void setAppointDoctorName(String appointDoctorName) {
        this.appointDoctorName = appointDoctorName;
    }

    public Date getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(Date appointDate) {
        this.appointDate = appointDate;
    }

    public Integer getAppointTimeRange() {
        return appointTimeRange;
    }

    public void setAppointTimeRange(Integer appointTimeRange) {
        this.appointTimeRange = appointTimeRange;
    }

    public String getDoctorReply() {
        return doctorReply;
    }

    public void setDoctorReply(String doctorReply) {
        this.doctorReply = doctorReply;
    }

    public String getAppointResult() {
        return appointResult;
    }

    public void setAppointResult(String appointResult) {
        this.appointResult = appointResult;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

	public String getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(String sourceFlag) {
		this.sourceFlag = sourceFlag;
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

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDiseaseTypeName() {
		return diseaseTypeName;
	}

	public void setDiseaseTypeName(String diseaseTypeName) {
		this.diseaseTypeName = diseaseTypeName;
	}

	public Integer getCallFlag() {
		return callFlag;
	}

	public void setCallFlag(Integer callFlag) {
		this.callFlag = callFlag;
	}
}