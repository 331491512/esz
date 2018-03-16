package com.esuizhen.cloudservice.ehr.dao.disease;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.model.disease.MetaEdiseaseBodyPart;

/**
* @ClassName: MetaEdiseaseBodyPartDao 
* @Description: 身体部位元数据操作接口
* @author wang_hw
* @date 2015年12月29日 上午11:54:27
 */
public interface MetaEdiseaseBodyPartDao{
	
	/**
	 * @author wang_hw
	 * @title :insertMetaEdiseaseBodyPart
	 * @Description:录入身体部位元数据
	 * @return void
	 * @date 2015年12月29日 上午11:54:50
	 */
	public void insertMetaEdiseaseBodyPart(MetaEdiseaseBodyPart metaEdiseaseBodyPart);
	
	/**
	 * @author wang_hw
	 * @title :updateMetaEdiseaseBodyPart
	 * @Description:修改身体部位元数据
	 * @return void
	 * @date 2015年12月29日 上午11:55:19
	 */
	public void updateMetaEdiseaseBodyPart(MetaEdiseaseBodyPart metaEdiseaseBodyPart);
	
	/**
	 * @author wang_hw
	 * @title :deleteMetaEdiseaseBodyPart
	 * @Description:删除身体部位元数据
	 * @return void
	 * @date 2015年12月29日 上午11:55:35
	 */
	public void deleteMetaEdiseaseBodyPart(Long metaEdiseaseBodyPartId);
	
	/**
	 * @author wang_hw
	 * @title :queryMetaEdiseaseBodyPart
	 * @Description:根据ID查询身体部位元数据
	 * @return MetaEdiseaseBodyPart
	 * @date 2015年12月29日 上午11:56:00
	 */
	public MetaEdiseaseBodyPart queryMetaEdiseaseBodyPart(Long metaEdiseaseBodyPartId);
	
	/**
	 * @author wang_hw
	 * @title :selectMetaEdiseaseBodyPartList
	 * @Description:根据创建日期或疾病ID查询身体部位元数据
	 * @return List<MetaEdiseaseBodyPart>
	 * @date 2015年12月29日 上午11:57:23
	 */
	public List<MetaEdiseaseBodyPart> selectMetaEdiseaseBodyPartTypeList(@Param("diseaseTypeId") String diseaseTypeId , @Param("createTime") String createTime);
	
	/**
	 * @author wang_hw
	 * @title :selectMetaEdiseaseBodyPartList
	 * @Description:获取身体部位列表
	 * @return List<MetaEdiseaseBodyPart>
	 * @date 2016年2月16日 上午10:24:19
	 */
	public List<MetaEdiseaseBodyPart> selectMetaEdiseaseBodyPartList();
	/**
	 * 
	* @Title: selectDiseaseBodyPartByDiseaseTypeId 
	* @Description: 通过疾病类型id反查疾病部位 
	* @param @param diseaseTypeId
	* @param @return    设定文件 
	* @return Integer    返回类型 
	* @throws
	 */
	public Integer selectDiseaseBodyPartByDiseaseTypeId(Integer diseaseTypeId);
}
