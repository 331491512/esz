package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoCounty;

/**
* @ClassName: MetaInfoCountyDao 
* @Description: 地区元数据列表 
* @author wang_hw
* @date 2016年6月29日 下午7:50:45
 */
public interface MetaInfoCountyDao
{
	/**
	 * @author wang_hw
	 * @title :getMetaInfoCountyList
	 * @Description:获取区域列表
	 * @return List<TMetaInfoCounty>
	 * @date 2016年6月29日 下午7:51:05
	 */
	public List<TMetaInfoCounty> getMetaInfoCountyList(@Param("provinceCode")String provinceCode , @Param("cityCode")String cityCode , @Param("countyCode")String countyCode);
	
	/**
	 * @author wang_hw
	 * @title :getMetaInfoCountyList
	 * @Description:获取省级区域列表
	 * @return List<TMetaInfoCounty>
	 * @date 2016年6月29日 下午7:51:05
	 */
	public List<TMetaInfoCounty> getMetaInfoProvinceList();
}
