package com.esuizhen.bigdata.domain.ods;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Nidan on 2016年12月22 上午 10:08
 */
@Entity
@Table(name = "patient_baseinfo", schema = "ods_db", catalog="")
public class TPatientBaseinfo {
    private long id;
    private long patientId;
    private int sex;
    private Integer age;
    private Integer provincedId;
    private Integer diseaseTypeId;
    private Integer weixinFlag;
    private String mobile;
    private Integer followupResultValueId;
    private Integer followupResultType;
    private Integer liveStatus;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "patientId")
    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "sex")
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "provincedId")
    public Integer getProvincedId() {
        return provincedId;
    }

    public void setProvincedId(Integer provincedId) {
        this.provincedId = provincedId;
    }

    @Basic
    @Column(name = "diseaseTypeId")
    public Integer getDiseaseTypeId() {
        return diseaseTypeId;
    }

    public void setDiseaseTypeId(Integer diseaseTypeId) {
        this.diseaseTypeId = diseaseTypeId;
    }

    @Basic
    @Column(name = "weixinFlag")
    public Integer getWeixinFlag() {
        return weixinFlag;
    }

    public void setWeixinFlag(Integer weixinFlag) {
        this.weixinFlag = weixinFlag;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "followupResultValueId")
    public Integer getFollowupResultValueId() {
        return followupResultValueId;
    }

    public void setFollowupResultValueId(Integer followupResultValueId) {
        this.followupResultValueId = followupResultValueId;
    }

    @Basic
    @Column(name = "followupResultType")
    public Integer getFollowupResultType() {
        return followupResultType;
    }

    public void setFollowupResultType(Integer followupResultType) {
        this.followupResultType = followupResultType;
    }

    @Basic
    @Column(name = "liveStatus")
    public Integer getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(Integer liveStatus) {
        this.liveStatus = liveStatus;
    }

    @Basic
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateTime")
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

        TPatientBaseinfo that = (TPatientBaseinfo) o;

        if (id != that.id) return false;
        if (patientId != that.patientId) return false;
        if (sex != that.sex) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (provincedId != null ? !provincedId.equals(that.provincedId) : that.provincedId != null) return false;
        if (diseaseTypeId != null ? !diseaseTypeId.equals(that.diseaseTypeId) : that.diseaseTypeId != null)
            return false;
        if (weixinFlag != null ? !weixinFlag.equals(that.weixinFlag) : that.weixinFlag != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (followupResultValueId != null ? !followupResultValueId.equals(that.followupResultValueId) : that.followupResultValueId != null)
            return false;
        if (followupResultType != null ? !followupResultType.equals(that.followupResultType) : that.followupResultType != null)
            return false;
        if (liveStatus != null ? !liveStatus.equals(that.liveStatus) : that.liveStatus != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (patientId ^ (patientId >>> 32));
        result = 31 * result + sex;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (provincedId != null ? provincedId.hashCode() : 0);
        result = 31 * result + (diseaseTypeId != null ? diseaseTypeId.hashCode() : 0);
        result = 31 * result + (weixinFlag != null ? weixinFlag.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (followupResultValueId != null ? followupResultValueId.hashCode() : 0);
        result = 31 * result + (followupResultType != null ? followupResultType.hashCode() : 0);
        result = 31 * result + (liveStatus != null ? liveStatus.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
