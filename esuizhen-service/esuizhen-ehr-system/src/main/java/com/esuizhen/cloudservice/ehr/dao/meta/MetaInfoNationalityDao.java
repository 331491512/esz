package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoNationality;

/**
* @ClassName: MetaInfoNationalityDao 
* @Description: 国籍元数据操作接口
* @author wang_hw
* @date 2016年7月1日 上午11:46:22
 */
public interface MetaInfoNationalityDao{
	
	/**
	 * @author wang_hw
	 * @title :getMetaInfoNationalityList
	 * @Description:国籍列表查询
	 * @return List<TMetaInfoNationality>
	 * @date 2016年7月1日 上午11:46:36
	 */
	public List<TMetaInfoNationality> getMetaInfoNationalityList(@Param("nationalityName")String nationalityName);
	public List<TMetaInfoNationality> getMetaInfoNationalityListByName(@Param("nationalityName")String nationalityName);
	
}
