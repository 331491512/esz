package com.esuizhen.cloudservice.user.dao;

import com.esuizhen.cloudservice.user.bean.AutiPatientApproveInfo;
import com.esuizhen.cloudservice.user.bean.SpecialDiseaseReq;

/** 
 * @ClassName: SpecialDiseaseApprovalDao.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月24日
 */
public interface SpecialDiseaseApprovalDao {

	public AutiPatientApproveInfo getAutiPatientApproveInfo(SpecialDiseaseReq req);
	public void updateAutiPatientApproveInfo(AutiPatientApproveInfo autiPatientApproveInfo);
	public void insertAutiPatientApproveInfo(AutiPatientApproveInfo autiPatientApproveInfo);
	
}
