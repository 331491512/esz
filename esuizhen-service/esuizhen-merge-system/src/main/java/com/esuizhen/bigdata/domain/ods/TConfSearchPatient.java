package com.esuizhen.bigdata.domain.ods;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Nidan on 2016年12月22 上午 10:08
 */
@Entity
@Table(name = "conf_search_patient", schema = "ods_db", catalog="")
public class TConfSearchPatient {
    private int tableId;
    private String tableName;
    private Timestamp clearTime;
    private int index;
    private int state;

    @Id
    @Column(name = "tableId")
    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    @Basic
    @Column(name = "tableName")
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Basic
    @Column(name = "clearTime")
    public Timestamp getClearTime() {
        return clearTime;
    }

    public void setClearTime(Timestamp clearTime) {
        this.clearTime = clearTime;
    }

    @Basic
    @Column(name = "index")
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Basic
    @Column(name = "state")
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TConfSearchPatient that = (TConfSearchPatient) o;

        if (tableId != that.tableId) return false;
        if (index != that.index) return false;
        if (state != that.state) return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
        if (clearTime != null ? !clearTime.equals(that.clearTime) : that.clearTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tableId;
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + (clearTime != null ? clearTime.hashCode() : 0);
        result = 31 * result + index;
        result = 31 * result + state;
        return result;
    }
}
