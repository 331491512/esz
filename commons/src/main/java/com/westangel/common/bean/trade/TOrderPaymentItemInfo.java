package com.westangel.common.bean.trade;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Nidan on 2017年05月10 下午 18:26
 */
public class TOrderPaymentItemInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer orderItemId;//订单支付项Id
    private Integer paymentItemId;//支付项Id
    private String orderId;//订单ID
    private float unitPrice;
    private Integer num;//数量
    private float price;
    private Date createTime;
    private Date updateTime;

    private String itemName;//支付项名称
    private Integer paymentType;//收支类型 -1：抵扣 1：支出

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getPaymentItemId() {
        return paymentItemId;
    }

    public void setPaymentItemId(Integer paymentItemId) {
        this.paymentItemId = paymentItemId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }
}
