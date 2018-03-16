package com.esuizhen.cloudservice.business.bean;

/**
 * Created by Nidan on 2017年05月15 上午 9:53
 */
public class MedicaRecordCopyServiceStateUpdateReq {
    //住院流水号
    private String inhospitalNo;
    //服务申请号
    private String productApplyId;
    //进行状态
    private Integer state;
    //快递单号
    private String expressNo;
    //原因
    private String cause;
    //服务领取码
    private String serviceCode;

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getInhospitalNo() {
        return inhospitalNo;
    }
    public void setInhospitalNo(String inhospitalNo) {
        this.inhospitalNo = inhospitalNo;
    }
    public String getProductApplyId() {
        return productApplyId;
    }
    public void setProductApplyId(String productApplyId) {
        this.productApplyId = productApplyId;
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    public String getCause() {
        return cause;
    }
    public void setCause(String cause) {
        this.cause = cause;
    }
    public String getExpressNo() {
        return expressNo;
    }
    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }
}
