package com.westangel.common.bean.trade;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Nidan on 2017年05月20 上午 10:26
 */
public class TProductSubTemplateInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String productSubTemplateId;//产品子模板ID。主键，唯一标识一个产品（商品）模板。
    private String productTemplateId;//产品模板ID。主键，唯一标识一个产品（商品）模板。
    private String productSubName;//子商品名。
    private Integer productSubType;//子类型
    private String introduction;//商品介绍。给卖家查看。
    private String publishIntroduction;//商品介绍。给买家查看。
    private Date createTime;//创建时间
    private Date updateTime;//更新时间

    public String getProductSubTemplateId() {
        return productSubTemplateId;
    }

    public void setProductSubTemplateId(String productSubTemplateId) {
        this.productSubTemplateId = productSubTemplateId;
    }

    public String getProductTemplateId() {
        return productTemplateId;
    }

    public void setProductTemplateId(String productTemplateId) {
        this.productTemplateId = productTemplateId;
    }

    public String getProductSubName() {
        return productSubName;
    }

    public void setProductSubName(String productSubName) {
        this.productSubName = productSubName;
    }

    public Integer getProductSubType() {
        return productSubType;
    }

    public void setProductSubType(Integer productSubType) {
        this.productSubType = productSubType;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPublishIntroduction() {
        return publishIntroduction;
    }

    public void setPublishIntroduction(String publishIntroduction) {
        this.publishIntroduction = publishIntroduction;
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
