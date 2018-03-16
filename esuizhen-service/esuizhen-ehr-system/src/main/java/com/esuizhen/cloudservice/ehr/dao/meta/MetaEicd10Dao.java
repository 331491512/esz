package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.model.icd10.MetaEicd10;

/**
* @ClassName: MetaEicd10Dao 
* @Description:ICD-10数据操作接口 
* @author wang_hw
* @date 2015年12月14日 下午5:59:13
 */
public interface MetaEicd10Dao{
	
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
	public void deleteMetaEicd10ByCode(Long diseaseCode);
	

	/**
	 * @author wang_hw
	 * @title :queryMetaEicd10
	 * @Description:查询ICD-10明细
	 * @return MetaEicd10
	 * @date 2015年12月14日 下午5:57:54
	 */
	public MetaEicd10 queryMetaEicd10ByCode(Long diseaseCode);
	
	/**
	 * @author wang_hw
	 * @title :queryMetaEicd10List
	 * @Description:查询ICD-10
	 * @return List<MetaEicd10>
	 * @date 2015年12月14日 下午6:03:02
	 */
	public List<MetaEicd10> selectMetaEicd10List(
			@Param("diseaseCode") String diseaseCode , 
			@Param("diseaseTypeId") String diseaseTypeId ,
			@Param("deseaseBodyPartId") String deseaseBodyPartId ,
			@Param("createTime") String createTime );
	
}
