package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;

public class RiskfactorsSleepInfo {
    private String sleepInfoId;

    private String riskfactorsId;

    private Integer sleepDes;

    private Date createTime;

    private Date updateTime;

    public String getSleepInfoId() {
        return sleepInfoId;
    }

    public void setSleepInfoId(String sleepInfoId) {
        this.sleepInfoId = sleepInfoId;
    }

    public String getRiskfactorsId() {
        return riskfactorsId;
    }

    public void setRiskfactorsId(String riskfactorsId) {
        this.riskfactorsId = riskfactorsId;
    }

    public Integer getSleepDes() {
        return sleepDes;
    }

    public void setSleepDes(Integer sleepDes) {
        this.sleepDes = sleepDes;
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