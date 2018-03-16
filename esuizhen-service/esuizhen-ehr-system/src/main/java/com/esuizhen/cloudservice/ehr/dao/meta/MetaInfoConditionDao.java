package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.List; 

import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoCondition;


/**
 * 条件元数据操作接口
* @ClassName: TMetaInfoConditionDao 
* @Description: (这里用一句话描述这个类的作用) 
* @author wang_hw
* @date 2016年7月1日 上午11:23:18
 */
public interface MetaInfoConditionDao
{
	/**
	 * @author wang_hw
	 * @title :getMetaInfoConditionList
	 * @Description:条件元数据查询
	 * @return List<TMetaInfoCondition>
	 * @date 2016年7月1日 上午11:23:47
	 */
	public List<TMetaInfoCondition> getMetaInfoConditionList(String bussinessType);
	
}
