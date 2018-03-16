package com.westangel.commonservice.sys.dao;

import com.westangel.common.bean.sys.TagInfo;
import com.westangel.commonservice.sys.bean.SysTag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Nidan on 2017年02月22 下午 16:34
 */
public interface SysTagDao {

    public List<SysTag> findSysTags(@Param("tagTypeId") Integer tagTypeId);

    List<TagInfo> getPatientTags(Long patientId);

    List<TagInfo> findContentTagsByRule(String ruleId);
}
