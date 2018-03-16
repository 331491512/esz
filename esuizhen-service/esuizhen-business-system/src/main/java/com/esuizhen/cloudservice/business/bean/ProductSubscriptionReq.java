package com.esuizhen.cloudservice.business.bean;

/**
 * Created by Nidan on 2017年02月20 下午 16:01
 */
public class ProductSubscriptionReq {

    private Long buyer;
    private Long vendor;
    private Integer productType;
    private Integer reqFlag;
    private Integer sort;
    private Integer num;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getBuyer() {
        return buyer;
    }

    public void setBuyer(Long buyer) {
        this.buyer = buyer;
    }

    public Long getVendor() {
        return vendor;
    }

    public void setVendor(Long vendor) {
        this.vendor = vendor;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getReqFlag() {
        return reqFlag;
    }

    public void setReqFlag(Integer reqFlag) {
        this.reqFlag = reqFlag;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
