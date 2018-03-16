package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;

public class RiskfactorsSotInfo {
    private String sotInfoId;

    private String riskfactorsId;

    private Integer firstAge;

    private Integer sustainYear;

    private Integer dailyMil;

    private Integer abstainYear;

    private String drinkTypeId;

    private Integer weekCount;

    private Integer monthCount;

    private Integer yearCount;

    private Date createTime;

    private Date updateTime;

    public String getSotInfoId() {
        return sotInfoId;
    }

    public void setSotInfoId(String sotInfoId) {
        this.sotInfoId = sotInfoId;
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

    public Integer getDailyMil() {
        return dailyMil;
    }

    public void setDailyMil(Integer dailyMil) {
        this.dailyMil = dailyMil;
    }

    public Integer getAbstainYear() {
        return abstainYear;
    }

    public void setAbstainYear(Integer abstainYear) {
        this.abstainYear = abstainYear;
    }

    public String getDrinkTypeId() {
        return drinkTypeId;
    }

    public void setDrinkTypeId(String drinkTypeId) {
        this.drinkTypeId = drinkTypeId;
    }

    public Integer getWeekCount() {
        return weekCount;
    }

    public void setWeekCount(Integer weekCount) {
        this.weekCount = weekCount;
    }

    public Integer getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(Integer monthCount) {
        this.monthCount = monthCount;
    }

    public Integer getYearCount() {
        return yearCount;
    }

    public void setYearCount(Integer yearCount) {
        this.yearCount = yearCount;
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