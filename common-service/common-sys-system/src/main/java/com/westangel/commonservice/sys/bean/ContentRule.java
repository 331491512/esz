package com.westangel.commonservice.sys.bean;

import java.util.List;

/**
 * Created by Nidan on 2017年05月25 下午 12:55
 */
public class ContentRule {

    private String ruleId;
    private String pageTitle;//页面标题
    private Integer pageNum;//显示条数
    private String remark;//备注

    private List<ContentSourceInfo> contentSourceInfos;

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<ContentSourceInfo> getContentSourceInfos() {
        return contentSourceInfos;
    }

    public void setContentSourceInfos(List<ContentSourceInfo> contentSourceInfos) {
        this.contentSourceInfos = contentSourceInfos;
    }
}
