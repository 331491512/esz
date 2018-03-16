package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;

public class RiskfactorsExerciseInfo {
    private String exerciseInfoId;

    private String riskfactorsId;

    private Integer sustainYear;

    private Integer weekCount;

    private Integer everyTimeMinute;

    private String exerciseWay;

    private Date createTime;

    private Date updateTime;

    public String getExerciseInfoId() {
        return exerciseInfoId;
    }

    public void setExerciseInfoId(String exerciseInfoId) {
        this.exerciseInfoId = exerciseInfoId;
    }

    public String getRiskfactorsId() {
        return riskfactorsId;
    }

    public void setRiskfactorsId(String riskfactorsId) {
        this.riskfactorsId = riskfactorsId;
    }

    public Integer getSustainYear() {
        return sustainYear;
    }

    public void setSustainYear(Integer sustainYear) {
        this.sustainYear = sustainYear;
    }

    public Integer getWeekCount() {
        return weekCount;
    }

    public void setWeekCount(Integer weekCount) {
        this.weekCount = weekCount;
    }

    public Integer getEveryTimeMinute() {
        return everyTimeMinute;
    }

    public void setEveryTimeMinute(Integer everyTimeMinute) {
        this.everyTimeMinute = everyTimeMinute;
    }

    public String getExerciseWay() {
        return exerciseWay;
    }

    public void setExerciseWay(String exerciseWay) {
        this.exerciseWay = exerciseWay;
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
}