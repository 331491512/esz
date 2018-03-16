package com.esuizhen.cloudservice.business.bean;

import java.util.Date;

/**
 * Created by Nidan on 2017年05月15 下午 20:47
 */
public class ServiceProgressResp {

    private Integer id;
    private String productApplyId;
    private String progressName;
    private Integer processState;
    private Date happenTime;
    private Date createTime;
    private Date updateTime;

    public ServiceProgressResp() {

    }

    public ServiceProgressResp(String productApplyId, String progressName, Integer processState, Date happenTime, Date createTime, Date updateTime) {
        this.productApplyId = productApplyId;
        this.progressName = progressName;
        this.processState = processState;
        this.happenTime = happenTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getProductApplyId() {
        return productApplyId;
    }

    public void setProductApplyId(String productApplyId) {
        this.productApplyId = productApplyId;
    }

    public String getProgressName() {
        return progressName;
    }

    public void setProgressName(String progressName) {
        this.progressName = progressName;
    }

    public Integer getProcessState() {
        return processState;
    }

    public void setProcessState(Integer processState) {
        this.processState = processState;
    }

    public Date getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(Date happenTime) {
        this.happenTime = happenTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
