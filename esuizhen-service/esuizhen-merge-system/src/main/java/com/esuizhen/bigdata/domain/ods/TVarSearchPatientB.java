package com.esuizhen.bigdata.domain.ods;

import javax.persistence.*;

/**
 * Created by Nidan on 2016年12月22 上午 10:08
 */
@Entity
@Table(name = "var_search_patient_b", schema = "ods_db", catalog="")
public class TVarSearchPatientB {
    private long id;
    private int searchId;
    private Integer conditionId;
    private long patientId;
    private int flag;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "searchId")
    public int getSearchId() {
        return searchId;
    }

    public void setSearchId(int searchId) {
        this.searchId = searchId;
    }

    @Basic
    @Column(name = "conditionId")
    public Integer getConditionId() {
        return conditionId;
    }

    public void setConditionId(Integer conditionId) {
        this.conditionId = conditionId;
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
    @Column(name = "flag")
    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TVarSearchPatientB that = (TVarSearchPatientB) o;

        if (id != that.id) return false;
        if (searchId != that.searchId) return false;
        if (patientId != that.patientId) return false;
        if (flag != that.flag) return false;
        if (conditionId != null ? !conditionId.equals(that.conditionId) : that.conditionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + searchId;
        result = 31 * result + (conditionId != null ? conditionId.hashCode() : 0);
        result = 31 * result + (int) (patientId ^ (patientId >>> 32));
        result = 31 * result + flag;
        return result;
    }
}
