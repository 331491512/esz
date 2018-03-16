package com.westangel.commonservice.sys.service;

import com.westangel.common.service.ContentTagService;
import com.westangel.commonservice.sys.bean.SysTag;

import java.util.List;

/**
 * Created by Nidan on 2017年03月14 上午 10:04
 */
public interface SysTagService extends ContentTagService {

    public List<SysTag> findSysTagByTagTypeId(Integer tagTypeId);
}
