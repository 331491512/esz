package com.westangel.commonservice.sys.service;

import com.westangel.commonservice.sys.bean.ContentRule;

/**
 * Created by Nidan on 2017年05月17 下午 18:16
 */
public interface ContentSourceService {

    /**
     * 获取内容来源列表
     * @return
     */
    public ContentRule getContentSourceList(String ruleId);
}
