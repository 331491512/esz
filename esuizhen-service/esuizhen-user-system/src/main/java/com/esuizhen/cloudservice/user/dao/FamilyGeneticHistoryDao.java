package com.esuizhen.cloudservice.user.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.user.bean.GeneticDiseaseContact;
import com.esuizhen.cloudservice.user.bean.SpecialDiseaseReq;

/** 
 * @ClassName: FamilyGeneticHistoryDao.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月24日
 */
public interface FamilyGeneticHistoryDao {
	public void updateGeneticHistory(GeneticDiseaseContact geneticDisease);
	public void insertGeneticHistory(GeneticDiseaseContact geneticDisease);
	public void deleteGeneticHistory(@Param("patientId")Long patientId,@Param("specialDiseaseRegisterId")Long specialDiseaseRegisterId);
	
	public List<GeneticDiseaseContact> findGeneticHistory(SpecialDiseaseReq req);
}
