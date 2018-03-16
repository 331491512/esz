package com.esuizhen.bigdata.domain.ods;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Nidan on 2016年12月22 上午 10:08
 */
@Entity
@Table(name = "retrieval_parameter_mould", schema = "ods_db", catalog="")
public class TRetrievalParameterMould {
    private String mouldId;
    private String mouldName;
    private String paramentContent;
    private long userId;
    private Timestamp createTime;

    @Id
    @Column(name = "mouldId")
    public String getMouldId() {
        return mouldId;
    }

    public void setMouldId(String mouldId) {
        this.mouldId = mouldId;
    }

    @Basic
    @Column(name = "mouldName")
    public String getMouldName() {
        return mouldName;
    }

    public void setMouldName(String mouldName) {
        this.mouldName = mouldName;
    }

    @Basic
    @Column(name = "paramentContent")
    public String getParamentContent() {
        return paramentContent;
    }

    public void setParamentContent(String paramentContent) {
        this.paramentContent = paramentContent;
    }

    @Basic
    @Column(name = "userId")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

        TRetrievalParameterMould that = (TRetrievalParameterMould) o;

        if (userId != that.userId) return false;
        if (mouldId != null ? !mouldId.equals(that.mouldId) : that.mouldId != null) return false;
        if (mouldName != null ? !mouldName.equals(that.mouldName) : that.mouldName != null) return false;
        if (paramentContent != null ? !paramentContent.equals(that.paramentContent) : that.paramentContent != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mouldId != null ? mouldId.hashCode() : 0;
        result = 31 * result + (mouldName != null ? mouldName.hashCode() : 0);
        result = 31 * result + (paramentContent != null ? paramentContent.hashCode() : 0);
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
