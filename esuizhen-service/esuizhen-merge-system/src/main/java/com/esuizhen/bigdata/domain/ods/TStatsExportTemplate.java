package com.esuizhen.bigdata.domain.ods;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Nidan on 2016年12月22 上午 10:08
 */
@Entity
@Table(name = "stats_export_template", schema = "ods_db", catalog="")
public class TStatsExportTemplate {
    private String exportTemplateId;
    private String titles;
    private String subject;
    private String filename;
    private Timestamp createTime;

    @Id
    @Column(name = "exportTemplateId")
    public String getExportTemplateId() {
        return exportTemplateId;
    }

    public void setExportTemplateId(String exportTemplateId) {
        this.exportTemplateId = exportTemplateId;
    }

    @Basic
    @Column(name = "titles")
    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    @Basic
    @Column(name = "subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "filename")
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
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

        TStatsExportTemplate that = (TStatsExportTemplate) o;

        if (exportTemplateId != null ? !exportTemplateId.equals(that.exportTemplateId) : that.exportTemplateId != null)
            return false;
        if (titles != null ? !titles.equals(that.titles) : that.titles != null) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        if (filename != null ? !filename.equals(that.filename) : that.filename != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = exportTemplateId != null ? exportTemplateId.hashCode() : 0;
        result = 31 * result + (titles != null ? titles.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (filename != null ? filename.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
