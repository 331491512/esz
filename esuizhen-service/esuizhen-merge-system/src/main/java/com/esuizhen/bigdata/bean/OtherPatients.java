package com.esuizhen.bigdata.bean;

import java.util.Date;

/**
 * Created by Nidan on 2017年01月05 下午 21:14
 */
public class OtherPatients {

    private Long patientId;
    private String patientNo;
    private String trueName;
    private Date deathDate;
    private String deathReason;
    private Integer isAfterFollowupResult;
    private Integer isAfterOutpatient;

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

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public String getDeathReason() {
        return deathReason;
    }

    public void setDeathReason(String deathReason) {
        this.deathReason = deathReason;
    }

    public Integer getIsAfterFollowupResult() {
        return isAfterFollowupResult;
    }

    public void setIsAfterFollowupResult(Integer isAfterFollowupResult) {
        this.isAfterFollowupResult = isAfterFollowupResult;
    }

    public Integer getIsAfterOutpatient() {
        return isAfterOutpatient;
    }

    public void setIsAfterOutpatient(Integer isAfterOutpatient) {
        this.isAfterOutpatient = isAfterOutpatient;
    }
}
