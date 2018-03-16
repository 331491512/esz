package com.esuizhen.cloudservice.user.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.user.bean.DiseaseKnowledge;
import com.esuizhen.cloudservice.user.dao.DiseaseKnowledgeDao;
import com.esuizhen.cloudservice.user.dao.TagDao;
import com.esuizhen.cloudservice.user.service.DiseaseKnowledgeService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.util.PageUtil;

@Service
public class DiseaseKnowledgeServiceImpl implements DiseaseKnowledgeService {

	@Autowired
	private DiseaseKnowledgeDao diseaseKnowledgeDao;
	@Autowired
	private TagDao tagDao;
	

	@SuppressWarnings("unchecked")
	@Override
	public Page<DiseaseKnowledge> findDiseaseKnowledge(DiseaseKnowledge diseaseKnowledge) {
		Integer pageNumber = diseaseKnowledge.getPageNumber();
		Integer pageSize = diseaseKnowledge.getPageSize();
		PageHelper.startPage(pageNumber+1, pageSize);
		List<DiseaseKnowledge> ledgeList = this.diseaseKnowledgeDao.findDiseaseKnowledge(diseaseKnowledge);
		return PageUtil.returnPage((com.github.pagehelper.Page<?>) ledgeList);
	}

	@Override
	public DiseaseKnowledge getDiseaseKnowledge(Long articleId) {
		DiseaseKnowledge diseaseKnowledge = this.diseaseKnowledgeDao.getDiseaseKnowledge(articleId);
		if(diseaseKnowledge==null)return null;
		diseaseKnowledge.setDiseaseTypeTagIds(tagDao.getTagIdByArticleId(articleId));
		return diseaseKnowledge;
	}

	@Override
	public void createDiseaseKnowledge(DiseaseKnowledge diseaseKnowledge)throws Exception {
		this.diseaseKnowledgeDao.createDiseaseKnowledge(diseaseKnowledge);
		if(diseaseKnowledge.getDoctorId()!=null){
			this.diseaseKnowledgeDao.saveArticleAndDoctor(diseaseKnowledge.getDoctorId(),diseaseKnowledge.getArticleId());
		}else{
			throw new Exception("doctorId是必传项");
		}
		if(diseaseKnowledge.getDiseaseTypeTagIds()!=null
				&&diseaseKnowledge.getDiseaseTypeTagIds().size() > 0){
			tagDao.saveArticleTag(diseaseKnowledge.getArticleId(),diseaseKnowledge.getDiseaseTypeTagIds());
		}
		
		//this.diseaseKnowledgeDao.createDiseaseKnowledge(diseaseKnowledge);
	}

	@Override
	public void updateDiseaseKnowledge(DiseaseKnowledge diseaseKnowledge) {
		Long articleId = diseaseKnowledge.getArticleId();
		/*diseaseKnowledgeDao.deleteArticleAndDoctor(articleId);
		if(knowledge.getDoctorId()!=null){
			this.diseaseKnowledgeDao.saveArticleAndDoctor(diseaseKnowledge.getDoctorId(),diseaseKnowledge.getArticleId());
		}else{
			throw new Exception("doctorId是必传项");
		}*/
		diseaseKnowledgeDao.deleteArticleAndTag(articleId);
		if(diseaseKnowledge.getDiseaseTypeTagIds()!=null
				&&diseaseKnowledge.getDiseaseTypeTagIds().size() > 0){
			tagDao.saveArticleTag(diseaseKnowledge.getArticleId(),diseaseKnowledge.getDiseaseTypeTagIds());
		}
		this.diseaseKnowledgeDao.updateDiseaseKnowledge(diseaseKnowledge);
	}

	@Override
	public void deleteArticleDoc(Long articleId) {
		diseaseKnowledgeDao.deleteArticle(articleId);
		diseaseKnowledgeDao.deleteArticleAndDoctor(articleId);
		diseaseKnowledgeDao.deleteArticleAndTag(articleId);
	}
	@Override
	public Integer judgeArticleByTitle(String articleTitle,Long articleId){
		return diseaseKnowledgeDao.judgeArticleByTitle(articleTitle,articleId);
	}
}
