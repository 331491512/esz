package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;

public class RiskfactorsFoodInfo {
    private String foodInfoId;

    private String riskfactorsId;

    private String foodDes;

    private Date createTime;

    private Date updateTime;

    public String getFoodInfoId() {
        return foodInfoId;
    }

    public void setFoodInfoId(String foodInfoId) {
        this.foodInfoId = foodInfoId;
    }

    public String getRiskfactorsId() {
        return riskfactorsId;
    }

    public void setRiskfactorsId(String riskfactorsId) {
        this.riskfactorsId = riskfactorsId;
    }

    public String getFoodDes() {
        return foodDes;
    }

    public void setFoodDes(String foodDes) {
        this.foodDes = foodDes;
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