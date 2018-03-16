package com.esuizhen.cloudservice.user.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Nidan on 2017年05月10 上午 10:32
 */
public class TExpressAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    private String addressId;

    private Long userId;

    private String cityCode;

    private String cityAddress;

    private String addressDetail;

    private String receiptContact;

    private String receiptPhone;

    private String zipCode;

    private String remark;

    private Integer isDefault;

    private Date createTime;

    private Date updateTime;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId == null ? null : addressId.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getCityAddress() {
        return cityAddress;
    }

    public void setCityAddress(String cityAddress) {
        this.cityAddress = cityAddress == null ? null : cityAddress.trim();
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
    }

    public String getReceiptContact() {
        return receiptContact;
    }

    public void setReceiptContact(String receiptContact) {
        this.receiptContact = receiptContact == null ? null : receiptContact.trim();
    }

    public String getReceiptPhone() {
        return receiptPhone;
    }

    public void setReceiptPhone(String receiptPhone) {
        this.receiptPhone = receiptPhone == null ? null : receiptPhone.trim();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
