package com.westangel.commonservice.sys.bean;

import com.westangel.common.bean.sys.TagInfo;

import java.util.List;

/**
 * Created by Nidan on 2017年05月17 下午 21:51
 */
public class ActivityReq {

    private String ruleId;

    private Integer page;

    private Integer num;

    private List<TagInfo> tagInfos;

    public List<TagInfo> getTagInfos() {
        return tagInfos;
    }

    public void setTagInfos(List<TagInfo> tagInfos) {
        this.tagInfos = tagInfos;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }
}
