package com.esuizhen.cloudservice.ehr.service.meta;

import java.util.List;


public interface TMetaInfoIncisionHealingService<T>{
	
	/**
     * 查询所有的切口愈合等级元数据
     * @return
     */
    List<T> selectByListAll();
}
