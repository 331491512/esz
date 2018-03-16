package com.westangel.commonservice.sms.model.wodong;

/**
 * Created by Nidan on 2017年07月13 上午 9:56
 */
public class WodongChannelInfo {

    /**
     * 主键。自增
     */
    private Integer id;
    /**
     * 业务Id
     */
    private Integer businessId;
    /**
     * 产品Id
     */
    private Integer productId;
    /**
     * 用户ID
     */
    private String UserId;
    /**
     * 用户名
     */
    private String account;
    /**
     * 密码（32位md5加密）
     */
    private String password;
    /**
     * 扩展号
     */
    private String ext;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
}
