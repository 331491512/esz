package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoNation;

/**
* @ClassName: MetaInfoNationDao 
* @Description: 民族元数据接口
* @author wang_hw
* @date 2016年7月3日 下午4:48:54
 */
public interface MetaInfoNationDao
{
	/**
	 * @author wang_hw
	 * @title :getMetaInfoNationList
	 * @Description:根据名称查询民族元数据
	 * @return List<TMetaInfoNation>
	 * @date 2016年7月3日 下午4:49:17
	 */
	public List<TMetaInfoNation> getMetaInfoNationList(@Param("nationName")String nationName);
	public List<TMetaInfoNation> getMetaInfoNationListByName(@Param("nationName")String nationName);
}
