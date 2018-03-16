package com.westangel.commonservice.sys.dao;

import com.westangel.commonservice.sys.bean.ContentRule;
import com.westangel.commonservice.sys.bean.ContentSourceInfo;

import java.util.List;

/**
 * Created by Nidan on 2017年05月17 下午 18:21
 */
public interface ContentSourceDao {

    public List<ContentSourceInfo> getContentSourceList(String RuleId);

    public ContentRule getContentRule(String RuleId);
}
