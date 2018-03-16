package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.List;

public interface TMetaInfoIncisionHealingDao<T> {
	
	/**
	 * 通过主键id查询切口愈合等级元数据
	 * @param incisionhealingid
	 * @return
	 */
    T selectByPrimaryKey(Integer incisionhealingid);
    
    /**
     * 查询所有的切口愈合等级元数据
     * @return
     */
    List<T> selectByListAll();
}