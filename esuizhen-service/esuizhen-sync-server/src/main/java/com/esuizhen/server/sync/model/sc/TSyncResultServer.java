package com.esuizhen.server.sync.model.sc;

import java.io.Serializable;
import java.util.Date;
/**
 * Created by Nidan on 2017年03月22 下午 15:10
 */
public class TSyncResultServer implements Serializable {

    private static final long serialVersionUID = 1L;

    private String batchId;

    private Integer syncFlag;

    private Date syncTime;

    private String cause;

    private Date createTime;

    private Date updateTime;

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId == null ? null : batchId.trim();
    }

    public Integer getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(Integer syncFlag) {
        this.syncFlag = syncFlag;
    }

    public Date getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause == null ? null : cause.trim();
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