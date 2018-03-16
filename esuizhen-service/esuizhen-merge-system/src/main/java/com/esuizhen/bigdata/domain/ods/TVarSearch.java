package com.esuizhen.bigdata.domain.ods;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Nidan on 2016年12月22 上午 10:08
 */
@Entity
@Table(name = "var_search", schema = "ods_db", catalog = "")
public class TVarSearch {
    private Integer searchId;
    private Integer totalNum=0;
    private String interfaceName;
    private String req;
    private Long operator;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String searchColumn;
    private String sqlContent;
    private String searchTableName;

    @Id
    @GeneratedValue
    @Column(name = "searchId")
    public Integer getSearchId() {
        return searchId;
    }

    public void setSearchId(Integer searchId) {
        this.searchId = searchId;
    }

    @Basic
    @Column(name = "totalNum")
    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    @Basic
    @Column(name = "interfaceName")
    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    @Basic
    @Column(name = "req")
    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }

    @Basic
    @Column(name = "operator")
    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
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

    @Basic
    @Column(name = "searchColumn")
    public String getSearchColumn() {
        return searchColumn;
    }

    public void setSearchColumn(String searchColumn) {
        this.searchColumn = searchColumn;
    }

    @Lob
    @Basic
    @Type(type = "text")
    @Column(name = "sqlContent")
    public String getSqlContent() {
        return sqlContent;
    }

    public void setSqlContent(String sqlContent) {
        this.sqlContent = sqlContent;
    }

    @Basic
    @Column(name = "searchTableName")
    public String getSearchTableName() {
        return searchTableName;
    }

    public void setSearchTableName(String searchTableName) {
        this.searchTableName = searchTableName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TVarSearch that = (TVarSearch) o;

        if (searchId != that.searchId) return false;
        if (totalNum != that.totalNum) return false;
        if (operator != that.operator) return false;
        if (interfaceName != null ? !interfaceName.equals(that.interfaceName) : that.interfaceName != null)
            return false;
        if (req != null ? !req.equals(that.req) : that.req != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (searchColumn != null ? !searchColumn.equals(that.searchColumn) : that.searchColumn != null) return false;
        if (sqlContent != null ? !sqlContent.equals(that.sqlContent) : that.sqlContent != null) return false;
        if (searchTableName != null ? !searchTableName.equals(that.searchTableName) : that.searchTableName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = searchId;
        result = 31 * result + totalNum;
        result = 31 * result + (interfaceName != null ? interfaceName.hashCode() : 0);
        result = 31 * result + (req != null ? req.hashCode() : 0);
        result = 31 * result + (int) (operator ^ (operator >>> 32));
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (searchColumn != null ? searchColumn.hashCode() : 0);
        result = 31 * result + (sqlContent != null ? sqlContent.hashCode() : 0);
        result = 31 * result + (searchTableName != null ? searchTableName.hashCode() : 0);
        return result;
    }
}
