package com.westangel.commonservice.sys.service.impl;

import com.westangel.common.bean.sys.TagInfo;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.commonservice.sys.bean.SysTag;
import com.westangel.commonservice.sys.dao.SysTagDao;
import com.westangel.commonservice.sys.service.SysTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nidan on 2017年03月14 上午 10:05
 */
@Service
public class SysTagServiceImpl implements SysTagService {

    @Autowired
    private SysTagDao sysTagDao;

    @Override
    public List<SysTag> findSysTagByTagTypeId(Integer tagTypeId) {
        return sysTagDao.findSysTags(tagTypeId);
    }

    @Override
    public List<TagInfo> getTagsByRuleId(String ruleId) {
        if(ruleId==null){
            throw new EmptyParamExcption("ruleId is null");
        }
        return sysTagDao.findContentTagsByRule(ruleId);
    }
}
