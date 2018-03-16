package com.westangel.commonservice.sys.service.impl;

import com.westangel.commonservice.sys.bean.ContentRule;
import com.westangel.commonservice.sys.dao.ContentSourceDao;
import com.westangel.commonservice.sys.service.ContentSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Nidan on 2017年05月17 下午 18:20
 */
@Service
public class ContentSourceServiceImpl implements ContentSourceService {

    @Autowired
    private ContentSourceDao contentSourceDao;

    @Override
    public ContentRule getContentSourceList(String ruleId) {

        ContentRule contentRule=contentSourceDao.getContentRule(ruleId);

        contentRule.setContentSourceInfos(contentSourceDao.getContentSourceList(ruleId));

        return contentRule;
    }

}
