package com.esuizhen.cloudservice.user.service;

import com.esuizhen.cloudservice.user.bean.DiseaseKnowledge; 
import com.westangel.common.bean.Page;

public interface DiseaseKnowledgeService {
	
	public Page<DiseaseKnowledge> findDiseaseKnowledge(DiseaseKnowledge diseaseKnowledge);

	public DiseaseKnowledge getDiseaseKnowledge(Long articleId);

	public void createDiseaseKnowledge(DiseaseKnowledge diseaseKnowledge)throws Exception;

	public void updateDiseaseKnowledge(DiseaseKnowledge diseaseKnowledge);
	
	public void deleteArticleDoc(Long articleId);

	public Integer judgeArticleByTitle(String articleTitle,Long articleId);
}
