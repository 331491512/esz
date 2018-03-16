package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;

public class RiskfactorsSmokeInfo {
    private String smokeInfoId;

    private String riskfactorsId;

    private Integer firstAge;

    private Integer sustainYear;

    private Integer dailyCount;

    private Integer abstainYear;

    private Integer passivitySmoke;

    private Date createTime;

    private Date updateTime;

    public String getSmokeInfoId() {
        return smokeInfoId;
    }

    public void setSmokeInfoId(String smokeInfoId) {
        this.smokeInfoId = smokeInfoId;
    }

    public String getRiskfactorsId() {
        return riskfactorsId;
    }

    public void setRiskfactorsId(String riskfactorsId) {
        this.riskfactorsId = riskfactorsId;
    }

    public Integer getFirstAge() {
        return firstAge;
    }

    public void setFirstAge(Integer firstAge) {
        this.firstAge = firstAge;
    }

    public Integer getSustainYear() {
        return sustainYear;
    }

    public void setSustainYear(Integer sustainYear) {
        this.sustainYear = sustainYear;
    }

    public Integer getDailyCount() {
        return dailyCount;
    }

    public void setDailyCount(Integer dailyCount) {
        this.dailyCount = dailyCount;
    }

    public Integer getAbstainYear() {
        return abstainYear;
    }

    public void setAbstainYear(Integer abstainYear) {
        this.abstainYear = abstainYear;
    }

    public Integer getPassivitySmoke() {
        return passivitySmoke;
    }

    public void setPassivitySmoke(Integer passivitySmoke) {
        this.passivitySmoke = passivitySmoke;
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