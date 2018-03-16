package com.esuizhen.cloudservice.ehr.service.disease;

import java.util.List;

import com.esuizhen.cloudservice.ehr.model.disease.MetaEdiseaseBodyPart;

public interface MetaEdiseaseBodyPartService{
	
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
	public List<MetaEdiseaseBodyPart> selectMetaEdiseaseBodyPartTypeList(String diseaseTypeId , String createTime);
	
	/**
	 * @author wang_hw
	 * @title :selectMetaEdiseaseBodyPartList
	 * @Description:获取身体部位列表
	 * @return List<MetaEdiseaseBodyPart>
	 * @date 2016年2月16日 上午10:24:19
	 */
	public List<MetaEdiseaseBodyPart> selectMetaEdiseaseBodyPartList();

}
