package com.esuizhen.cloudservice.ehr.service.icd10;

import java.util.Date;
import java.util.List;

import com.esuizhen.cloudservice.ehr.model.icd10.MetaEicd10;

/**
* @ClassName: MetaEicd10Service 
* @Description: ICD-10源数据服务接口 
* @author wang_hw
* @date 2015年12月14日 下午5:56:50
 */
public interface MetaEicd10Service{
	
	/**
	 * @author wang_hw
	 * @title :insertMetaEicd10
	 * @Description:录入ICD-10
	 * @return void
	 * @date 2015年12月14日 下午5:57:13
	 */
	public void insertMetaEicd10(MetaEicd10 metaEicd10);
	
	
	/**
	 * @author wang_hw
	 * @title :updateMetaEicd10
	 * @Description:修改ICD-10
	 * @return void
	 * @date 2015年12月14日 下午5:57:25
	 */
	public void updateMetaEicd10(MetaEicd10 metaEicd10);
	
	/**
	 * @author wang_hw
	 * @title :deleteMetaEicd10
	 * @Description:删除ICD-10
	 * @return void
	 * @date 2015年12月14日 下午5:57:40
	 */
	public void deleteMetaEicd10(Long diseaseCode);
	
	/**
	 * @author wang_hw
	 * @title :queryMetaEicd10
	 * @Description:查询ICD-10明细
	 * @return MetaEicd10
	 * @date 2015年12月14日 下午5:57:54
	 */
	public MetaEicd10 queryMetaEicd10(Long diseaseCode);
	
	/**
	 * @author wang_hw
	 * @title :queryMetaEicd10List
	 * @Description:查询ICD-10
	 * @return List<MetaEicd10>
	 * @date 2015年12月14日 下午6:03:02
	 */
	public List<MetaEicd10> selectMetaEicd10List(String createTime);
	
	/**
	 * @author wang_hw
	 * @title :selectMetaEicd10List
	 * @Description:查询ICD-10列表
	 * @return List<MetaEicd10>
	 * @date 2015年12月15日 下午7:38:25
	 */
	public List<MetaEicd10> selectMetaEicd10List(String diseaseTypeId , String diseaseBodyPartId, String diseaseCode);

}
