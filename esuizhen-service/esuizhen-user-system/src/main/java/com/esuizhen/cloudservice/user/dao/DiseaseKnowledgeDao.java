package com.esuizhen.cloudservice.user.dao;


import java.util.List; 

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.user.bean.DiseaseKnowledge;


public interface DiseaseKnowledgeDao {

	public List<DiseaseKnowledge> findDiseaseKnowledge(DiseaseKnowledge diseaseKnowledge);

	public DiseaseKnowledge getDiseaseKnowledge(Long articleId);

	public void createDiseaseKnowledge(DiseaseKnowledge diseaseKnowledge);

	public void updateDiseaseKnowledge(DiseaseKnowledge diseaseKnowledge);
	
	public void saveArticleAndDoctor(@Param("doctorId")Long doctorId,
			@Param("articleId")Long articleId);

	/**
	* @author fanpanwei
	* @date 2017年3月29日
	* @param 
	* @description:删除患教文章
	* @return
	 */
	public void deleteArticle(Long articleId);
	/**
	* @author fanpanwei
	* @date 2017年3月29日
	* @param 
	* @description:删除患教文章和医生匹配关系表
	* @return
	 */
	public void deleteArticleAndDoctor(Long articleId);
	/**
	* @author fanpanwei
	* @date 2017年3月29日
	* @param 
	* @description:删除患教文章匹配的病种标签记录
	* @return
	 */
	public void deleteArticleAndTag(Long articleId);
	
	Integer judgeArticleByTitle(@Param("articleTitle") String articleTitle,@Param("articleId")Long articleId);
}
