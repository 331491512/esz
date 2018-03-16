package com.westangel.common.service;

import com.westangel.common.bean.sys.TagInfo;

import java.util.List;

/**
 * Created by Nidan on 2017年05月17 下午 20:54
 * 内容（服务，患者）标签服务
 */
public interface ContentTagService {

    /**
     * 根据规则获取内容标签
     * @param ruleId
     * @return
     */
    public List<TagInfo> getTagsByRuleId(String ruleId);

}
