package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "conf_hospital_wx", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "conf_hospital_wx_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class ConfHospitalWx {
    private int id;
    private int hospitalId;
    private String weixinId;
    private String weixinName;
    private String serviceName;
    private int productId;
    private String remark;
    private int enableFlag;
    private Timestamp createTime;
//    private UHospital uHospitalByHospitalId;

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
    @Column(name = "weixinId", nullable = true, length = 50)
    public String getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(String weixinId) {
        this.weixinId = weixinId;
    }

    @Basic
    @Column(name = "weixinName", nullable = true, length = 255)
    public String getWeixinName() {
        return weixinName;
    }

    public void setWeixinName(String weixinName) {
        this.weixinName = weixinName;
    }

    @Basic
    @Column(name = "serviceName", nullable = false, length = 45)
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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
    @Column(name = "remark", nullable = true, length = 50)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "enableFlag", nullable = false)
    public int getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(int enableFlag) {
        this.enableFlag = enableFlag;
    }

    @Basic
    @Column(name = "createTime", nullable = false)
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

        ConfHospitalWx that = (ConfHospitalWx) o;

        if (id != that.id) return false;
        if (hospitalId != that.hospitalId) return false;
        if (productId != that.productId) return false;
        if (enableFlag != that.enableFlag) return false;
        if (weixinId != null ? !weixinId.equals(that.weixinId) : that.weixinId != null) return false;
        if (weixinName != null ? !weixinName.equals(that.weixinName) : that.weixinName != null) return false;
        if (serviceName != null ? !serviceName.equals(that.serviceName) : that.serviceName != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + hospitalId;
        result = 31 * result + (weixinId != null ? weixinId.hashCode() : 0);
        result = 31 * result + (weixinName != null ? weixinName.hashCode() : 0);
        result = 31 * result + (serviceName != null ? serviceName.hashCode() : 0);
        result = 31 * result + productId;
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + enableFlag;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
//
//    @ManyToOne
//    @JoinColumn(name = "hospitalId", referencedColumnName = "hospitalId", nullable = false,insertable = false,updatable = false)
//    public UHospital getuHospitalByHospitalId() {
//        return uHospitalByHospitalId;
//    }
//
//    public void setuHospitalByHospitalId(UHospital uHospitalByHospitalId) {
//        this.uHospitalByHospitalId = uHospitalByHospitalId;
//    }
}
