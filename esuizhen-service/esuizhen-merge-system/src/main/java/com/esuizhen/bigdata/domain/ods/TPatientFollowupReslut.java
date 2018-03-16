package com.esuizhen.bigdata.domain.ods;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Nidan on 2016年12月22 上午 10:08
 */
@Entity
@Table(name = "patient_followup_reslut", schema = "ods_db", catalog="")
public class TPatientFollowupReslut {
    private long id;
    private Long patientId;
    private Integer result12;
    private Integer result24;
    private Integer result36;
    private Integer result48;
    private Integer result60;
    private Timestamp calculateTime;
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
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "result12")
    public Integer getResult12() {
        return result12;
    }

    public void setResult12(Integer result12) {
        this.result12 = result12;
    }

    @Basic
    @Column(name = "result24")
    public Integer getResult24() {
        return result24;
    }

    public void setResult24(Integer result24) {
        this.result24 = result24;
    }

    @Basic
    @Column(name = "result36")
    public Integer getResult36() {
        return result36;
    }

    public void setResult36(Integer result36) {
        this.result36 = result36;
    }

    @Basic
    @Column(name = "result48")
    public Integer getResult48() {
        return result48;
    }

    public void setResult48(Integer result48) {
        this.result48 = result48;
    }

    @Basic
    @Column(name = "result60")
    public Integer getResult60() {
        return result60;
    }

    public void setResult60(Integer result60) {
        this.result60 = result60;
    }

    @Basic
    @Column(name = "calculateTime")
    public Timestamp getCalculateTime() {
        return calculateTime;
    }

    public void setCalculateTime(Timestamp calculateTime) {
        this.calculateTime = calculateTime;
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

        TPatientFollowupReslut that = (TPatientFollowupReslut) o;

        if (id != that.id) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (result12 != null ? !result12.equals(that.result12) : that.result12 != null) return false;
        if (result24 != null ? !result24.equals(that.result24) : that.result24 != null) return false;
        if (result36 != null ? !result36.equals(that.result36) : that.result36 != null) return false;
        if (result48 != null ? !result48.equals(that.result48) : that.result48 != null) return false;
        if (result60 != null ? !result60.equals(that.result60) : that.result60 != null) return false;
        if (calculateTime != null ? !calculateTime.equals(that.calculateTime) : that.calculateTime != null)
            return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (result12 != null ? result12.hashCode() : 0);
        result = 31 * result + (result24 != null ? result24.hashCode() : 0);
        result = 31 * result + (result36 != null ? result36.hashCode() : 0);
        result = 31 * result + (result48 != null ? result48.hashCode() : 0);
        result = 31 * result + (result60 != null ? result60.hashCode() : 0);
        result = 31 * result + (calculateTime != null ? calculateTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
