package com.esuizhen.bigdata.bean;

import java.sql.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/12/14 0014.
 */
public class MergePatientReq {

    private Long goalPatientId;
    private List<Long> otherPatientIds;
    private String patientNo;
    private String trueName;
    private Integer sex;
    private Date birthDate;
    private String identification;
    private Long operatorId;
    private String mergeReason;
    private Long retainPatientId;

    public String getMergeReason() {
        return mergeReason;
    }

    public void setMergeReason(String mergeReason) {
        this.mergeReason = mergeReason;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Long getGoalPatientId() {
        return goalPatientId;
    }

    public void setGoalPatientId(Long goalPatientId) {
        this.goalPatientId = goalPatientId;
    }

    public List<Long> getOtherPatientIds() {
        return otherPatientIds;
    }

    public void setOtherPatientIds(List<Long> otherPatientIds) {
        this.otherPatientIds = otherPatientIds;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public Long getRetainPatientId() {
        return retainPatientId;
    }

    public void setRetainPatientId(Long retainPatientId) {
        this.retainPatientId = retainPatientId;
    }
}
