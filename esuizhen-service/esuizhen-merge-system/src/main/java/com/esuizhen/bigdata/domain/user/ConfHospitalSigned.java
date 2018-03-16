package com.esuizhen.bigdata.domain.user;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "conf_hospital_signed", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "conf_hospital_signed_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class ConfHospitalSigned {
    private int id;
    private int hospitalId;
    private String hospitalName;
    private String clazz;
    private int signedFlag;
    private int toBSystemDeployFlag;
    private Integer dataAchieveFlag;
    private Integer outerNetFlag;
    private Integer normalSuifangFlag;
    private Integer siSuifangFlag;
    private int interconnectionFlag;
    private Integer weixinPublishFlag;
    private Integer hospitalServiceFlag;
    private Integer suifangReportFlag;
    private Integer paitentsMonitorServiceFlag;
    private Integer weixinSuifangThirtyPercentFlag;
    private Integer zhuantiSuifangFlag;
    private Integer weituoSuifangFlag;
    private String deployModules;
    private String deployVersion;
    private int interconnectionWay;
    private Integer initSyncPatientsCount;
    private Integer initSyncDoctorsCount;
    private String remark;
    private Timestamp deployTime;
    private Timestamp initSyncTime;
    private Timestamp increSyncTime;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "hospitalId", nullable = false)
    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Basic
    @Column(name = "hospitalName", nullable = true, length = 100)
    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    @Basic
    @Column(name = "class", nullable = true, length = 10)
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Basic
    @Column(name = "signedFlag", nullable = false)
    public int getSignedFlag() {
        return signedFlag;
    }

    public void setSignedFlag(int signedFlag) {
        this.signedFlag = signedFlag;
    }

    @Basic
    @Column(name = "toBSystemDeployFlag", nullable = false)
    public int getToBSystemDeployFlag() {
        return toBSystemDeployFlag;
    }

    public void setToBSystemDeployFlag(int toBSystemDeployFlag) {
        this.toBSystemDeployFlag = toBSystemDeployFlag;
    }

    @Basic
    @Column(name = "dataAchieveFlag", nullable = true)
    public Integer getDataAchieveFlag() {
        return dataAchieveFlag;
    }

    public void setDataAchieveFlag(Integer dataAchieveFlag) {
        this.dataAchieveFlag = dataAchieveFlag;
    }

    @Basic
    @Column(name = "outerNetFlag", nullable = true)
    public Integer getOuterNetFlag() {
        return outerNetFlag;
    }

    public void setOuterNetFlag(Integer outerNetFlag) {
        this.outerNetFlag = outerNetFlag;
    }

    @Basic
    @Column(name = "normalSuifangFlag", nullable = true)
    public Integer getNormalSuifangFlag() {
        return normalSuifangFlag;
    }

    public void setNormalSuifangFlag(Integer normalSuifangFlag) {
        this.normalSuifangFlag = normalSuifangFlag;
    }

    @Basic
    @Column(name = "siSuifangFlag", nullable = true)
    public Integer getSiSuifangFlag() {
        return siSuifangFlag;
    }

    public void setSiSuifangFlag(Integer siSuifangFlag) {
        this.siSuifangFlag = siSuifangFlag;
    }

    @Basic
    @Column(name = "interconnectionFlag", nullable = false)
    public int getInterconnectionFlag() {
        return interconnectionFlag;
    }

    public void setInterconnectionFlag(int interconnectionFlag) {
        this.interconnectionFlag = interconnectionFlag;
    }

    @Basic
    @Column(name = "weixinPublishFlag", nullable = true)
    public Integer getWeixinPublishFlag() {
        return weixinPublishFlag;
    }

    public void setWeixinPublishFlag(Integer weixinPublishFlag) {
        this.weixinPublishFlag = weixinPublishFlag;
    }

    @Basic
    @Column(name = "hospitalServiceFlag", nullable = true)
    public Integer getHospitalServiceFlag() {
        return hospitalServiceFlag;
    }

    public void setHospitalServiceFlag(Integer hospitalServiceFlag) {
        this.hospitalServiceFlag = hospitalServiceFlag;
    }

    @Basic
    @Column(name = "suifangReportFlag", nullable = true)
    public Integer getSuifangReportFlag() {
        return suifangReportFlag;
    }

    public void setSuifangReportFlag(Integer suifangReportFlag) {
        this.suifangReportFlag = suifangReportFlag;
    }

    @Basic
    @Column(name = "paitentsMonitorServiceFlag", nullable = true)
    public Integer getPaitentsMonitorServiceFlag() {
        return paitentsMonitorServiceFlag;
    }

    public void setPaitentsMonitorServiceFlag(Integer paitentsMonitorServiceFlag) {
        this.paitentsMonitorServiceFlag = paitentsMonitorServiceFlag;
    }

    @Basic
    @Column(name = "weixinSuifangThirtyPercentFlag", nullable = true)
    public Integer getWeixinSuifangThirtyPercentFlag() {
        return weixinSuifangThirtyPercentFlag;
    }

    public void setWeixinSuifangThirtyPercentFlag(Integer weixinSuifangThirtyPercentFlag) {
        this.weixinSuifangThirtyPercentFlag = weixinSuifangThirtyPercentFlag;
    }

    @Basic
    @Column(name = "zhuantiSuifangFlag", nullable = true)
    public Integer getZhuantiSuifangFlag() {
        return zhuantiSuifangFlag;
    }

    public void setZhuantiSuifangFlag(Integer zhuantiSuifangFlag) {
        this.zhuantiSuifangFlag = zhuantiSuifangFlag;
    }

    @Basic
    @Column(name = "weituoSuifangFlag", nullable = true)
    public Integer getWeituoSuifangFlag() {
        return weituoSuifangFlag;
    }

    public void setWeituoSuifangFlag(Integer weituoSuifangFlag) {
        this.weituoSuifangFlag = weituoSuifangFlag;
    }

    @Basic
    @Column(name = "deployModules", nullable = true, length = 500)
    public String getDeployModules() {
        return deployModules;
    }

    public void setDeployModules(String deployModules) {
        this.deployModules = deployModules;
    }

    @Basic
    @Column(name = "deployVersion", nullable = true, length = 20)
    public String getDeployVersion() {
        return deployVersion;
    }

    public void setDeployVersion(String deployVersion) {
        this.deployVersion = deployVersion;
    }

    @Basic
    @Column(name = "interconnectionWay", nullable = false)
    public int getInterconnectionWay() {
        return interconnectionWay;
    }

    public void setInterconnectionWay(int interconnectionWay) {
        this.interconnectionWay = interconnectionWay;
    }

    @Basic
    @Column(name = "initSyncPatientsCount", nullable = true)
    public Integer getInitSyncPatientsCount() {
        return initSyncPatientsCount;
    }

    public void setInitSyncPatientsCount(Integer initSyncPatientsCount) {
        this.initSyncPatientsCount = initSyncPatientsCount;
    }

    @Basic
    @Column(name = "initSyncDoctorsCount", nullable = true)
    public Integer getInitSyncDoctorsCount() {
        return initSyncDoctorsCount;
    }

    public void setInitSyncDoctorsCount(Integer initSyncDoctorsCount) {
        this.initSyncDoctorsCount = initSyncDoctorsCount;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "deployTime", nullable = true)
    public Timestamp getDeployTime() {
        return deployTime;
    }

    public void setDeployTime(Timestamp deployTime) {
        this.deployTime = deployTime;
    }

    @Basic
    @Column(name = "initSyncTime", nullable = true)
    public Timestamp getInitSyncTime() {
        return initSyncTime;
    }

    public void setInitSyncTime(Timestamp initSyncTime) {
        this.initSyncTime = initSyncTime;
    }

    @Basic
    @Column(name = "increSyncTime", nullable = true)
    public Timestamp getIncreSyncTime() {
        return increSyncTime;
    }

    public void setIncreSyncTime(Timestamp increSyncTime) {
        this.increSyncTime = increSyncTime;
    }

    @Basic
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateTime", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfHospitalSigned that = (ConfHospitalSigned) o;

        if (id != that.id) return false;
        if (hospitalId != that.hospitalId) return false;
        if (signedFlag != that.signedFlag) return false;
        if (toBSystemDeployFlag != that.toBSystemDeployFlag) return false;
        if (interconnectionFlag != that.interconnectionFlag) return false;
        if (interconnectionWay != that.interconnectionWay) return false;
        if (hospitalName != null ? !hospitalName.equals(that.hospitalName) : that.hospitalName != null) return false;
        if (clazz != null ? !clazz.equals(that.clazz) : that.clazz != null) return false;
        if (dataAchieveFlag != null ? !dataAchieveFlag.equals(that.dataAchieveFlag) : that.dataAchieveFlag != null)
            return false;
        if (outerNetFlag != null ? !outerNetFlag.equals(that.outerNetFlag) : that.outerNetFlag != null) return false;
        if (normalSuifangFlag != null ? !normalSuifangFlag.equals(that.normalSuifangFlag) : that.normalSuifangFlag != null)
            return false;
        if (siSuifangFlag != null ? !siSuifangFlag.equals(that.siSuifangFlag) : that.siSuifangFlag != null)
            return false;
        if (weixinPublishFlag != null ? !weixinPublishFlag.equals(that.weixinPublishFlag) : that.weixinPublishFlag != null)
            return false;
        if (hospitalServiceFlag != null ? !hospitalServiceFlag.equals(that.hospitalServiceFlag) : that.hospitalServiceFlag != null)
            return false;
        if (suifangReportFlag != null ? !suifangReportFlag.equals(that.suifangReportFlag) : that.suifangReportFlag != null)
            return false;
        if (paitentsMonitorServiceFlag != null ? !paitentsMonitorServiceFlag.equals(that.paitentsMonitorServiceFlag) : that.paitentsMonitorServiceFlag != null)
            return false;
        if (weixinSuifangThirtyPercentFlag != null ? !weixinSuifangThirtyPercentFlag.equals(that.weixinSuifangThirtyPercentFlag) : that.weixinSuifangThirtyPercentFlag != null)
            return false;
        if (zhuantiSuifangFlag != null ? !zhuantiSuifangFlag.equals(that.zhuantiSuifangFlag) : that.zhuantiSuifangFlag != null)
            return false;
        if (weituoSuifangFlag != null ? !weituoSuifangFlag.equals(that.weituoSuifangFlag) : that.weituoSuifangFlag != null)
            return false;
        if (deployModules != null ? !deployModules.equals(that.deployModules) : that.deployModules != null)
            return false;
        if (deployVersion != null ? !deployVersion.equals(that.deployVersion) : that.deployVersion != null)
            return false;
        if (initSyncPatientsCount != null ? !initSyncPatientsCount.equals(that.initSyncPatientsCount) : that.initSyncPatientsCount != null)
            return false;
        if (initSyncDoctorsCount != null ? !initSyncDoctorsCount.equals(that.initSyncDoctorsCount) : that.initSyncDoctorsCount != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (deployTime != null ? !deployTime.equals(that.deployTime) : that.deployTime != null) return false;
        if (initSyncTime != null ? !initSyncTime.equals(that.initSyncTime) : that.initSyncTime != null) return false;
        if (increSyncTime != null ? !increSyncTime.equals(that.increSyncTime) : that.increSyncTime != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + hospitalId;
        result = 31 * result + (hospitalName != null ? hospitalName.hashCode() : 0);
        result = 31 * result + (clazz != null ? clazz.hashCode() : 0);
        result = 31 * result + signedFlag;
        result = 31 * result + toBSystemDeployFlag;
        result = 31 * result + (dataAchieveFlag != null ? dataAchieveFlag.hashCode() : 0);
        result = 31 * result + (outerNetFlag != null ? outerNetFlag.hashCode() : 0);
        result = 31 * result + (normalSuifangFlag != null ? normalSuifangFlag.hashCode() : 0);
        result = 31 * result + (siSuifangFlag != null ? siSuifangFlag.hashCode() : 0);
        result = 31 * result + interconnectionFlag;
        result = 31 * result + (weixinPublishFlag != null ? weixinPublishFlag.hashCode() : 0);
        result = 31 * result + (hospitalServiceFlag != null ? hospitalServiceFlag.hashCode() : 0);
        result = 31 * result + (suifangReportFlag != null ? suifangReportFlag.hashCode() : 0);
        result = 31 * result + (paitentsMonitorServiceFlag != null ? paitentsMonitorServiceFlag.hashCode() : 0);
        result = 31 * result + (weixinSuifangThirtyPercentFlag != null ? weixinSuifangThirtyPercentFlag.hashCode() : 0);
        result = 31 * result + (zhuantiSuifangFlag != null ? zhuantiSuifangFlag.hashCode() : 0);
        result = 31 * result + (weituoSuifangFlag != null ? weituoSuifangFlag.hashCode() : 0);
        result = 31 * result + (deployModules != null ? deployModules.hashCode() : 0);
        result = 31 * result + (deployVersion != null ? deployVersion.hashCode() : 0);
        result = 31 * result + interconnectionWay;
        result = 31 * result + (initSyncPatientsCount != null ? initSyncPatientsCount.hashCode() : 0);
        result = 31 * result + (initSyncDoctorsCount != null ? initSyncDoctorsCount.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (deployTime != null ? deployTime.hashCode() : 0);
        result = 31 * result + (initSyncTime != null ? initSyncTime.hashCode() : 0);
        result = 31 * result + (increSyncTime != null ? increSyncTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
