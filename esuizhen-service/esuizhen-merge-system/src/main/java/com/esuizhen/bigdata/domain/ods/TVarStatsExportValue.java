package com.esuizhen.bigdata.domain.ods;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Nidan on 2016年12月22 上午 10:11
 */
@Entity
@Table(name = "var_stats_export_value", schema = "ods_db", catalog="")
public class TVarStatsExportValue {
    private long id;
    private String exportTemplateId;
    private int searchId;
    private String values;
    private Timestamp createTime;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "exportTemplateId")
    public String getExportTemplateId() {
        return exportTemplateId;
    }

    public void setExportTemplateId(String exportTemplateId) {
        this.exportTemplateId = exportTemplateId;
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
    @Column(name = "values")
    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    @Basic
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TVarStatsExportValue that = (TVarStatsExportValue) o;

        if (id != that.id) return false;
        if (searchId != that.searchId) return false;
        if (exportTemplateId != null ? !exportTemplateId.equals(that.exportTemplateId) : that.exportTemplateId != null)
            return false;
        if (values != null ? !values.equals(that.values) : that.values != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (exportTemplateId != null ? exportTemplateId.hashCode() : 0);
        result = 31 * result + searchId;
        result = 31 * result + (values != null ? values.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
