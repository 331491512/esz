package com.esuizhen.bigdata.domain.user;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "u_thirdparty", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "u_thirdparty_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class UThirdparty {
    private int id;
    private long userId;
    private String openId;
    private int businessId;
    private int productId;
    private int thirdPartyType;
    private int state;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp releaseTime;
//    private UUser uUserByUserId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userId", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "openId", nullable = false, length = 50)
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Basic
    @Column(name = "businessId", nullable = false)
    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    @Basic
    @Column(name = "productId", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "thirdPartyType", nullable = false)
    public int getThirdPartyType() {
        return thirdPartyType;
    }

    public void setThirdPartyType(int thirdPartyType) {
        this.thirdPartyType = thirdPartyType;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    @Basic
    @Column(name = "releaseTime", nullable = true)
    public Timestamp getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Timestamp releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UThirdparty that = (UThirdparty) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (businessId != that.businessId) return false;
        if (productId != that.productId) return false;
        if (thirdPartyType != that.thirdPartyType) return false;
        if (state != that.state) return false;
        if (openId != null ? !openId.equals(that.openId) : that.openId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (releaseTime != null ? !releaseTime.equals(that.releaseTime) : that.releaseTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (openId != null ? openId.hashCode() : 0);
        result = 31 * result + businessId;
        result = 31 * result + productId;
        result = 31 * result + thirdPartyType;
        result = 31 * result + state;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (releaseTime != null ? releaseTime.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false, insertable = false, updatable = false)
//    public UUser getuUserByUserId() {
//        return uUserByUserId;
//    }
//
//    public void setuUserByUserId(UUser uUserByUserId) {
//        this.uUserByUserId = uUserByUserId;
//    }
}
