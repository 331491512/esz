package com.esuizhen.bigdata.domain.sc;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Nidan on 2017年03月31 下午 18:01
 */
@Entity
@Table(name = "r_uuid_patientno_sync_result_client", schema = "sc_db", catalog="")
public class TUuidPatientnoSyncResultClient implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long Id;

    private String batchId;

    private Integer syncFlag;

    private Date syncTime;

    private String cause;

    private Date createTime;

    private Date updateTime;

    @Id
    @Column(name = "id", nullable = true)
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Basic
    @Column(name = "batchId", nullable = true)
    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    @Basic
    @Column(name = "syncFlag", nullable = true)
    public Integer getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(Integer syncFlag) {
        this.syncFlag = syncFlag;
    }

    @Basic
    @Column(name = "syncTime", nullable = true)
    public Date getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }

    @Basic
    @Column(name = "cause", nullable = true)
    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Basic
    @Column(name = "createTime", nullable = true)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateTime", nullable = true)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
