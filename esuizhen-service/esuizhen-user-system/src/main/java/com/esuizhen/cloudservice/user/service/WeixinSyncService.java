package com.esuizhen.cloudservice.user.service;

import com.esuizhen.cloudservice.user.bean.TWeixinSyncDiseaseInfo;
import com.esuizhen.cloudservice.user.bean.TWeixinSyncPatientInfo;
import com.esuizhen.cloudservice.user.bean.TWeixinSyncRelationInfo;

public interface WeixinSyncService {
	/**
	 * 
	* @Title: syncPatient 
	* @Description: 患者 
	* @param @param patientInfo    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void syncPatient(TWeixinSyncPatientInfo patientInfo);
	/**
	 * 
	* @Title: syncDisease 
	* @Description: 疾病 
	* @param @param diseaseInfo    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void syncDisease(TWeixinSyncDiseaseInfo diseaseInfo);
	/**
	 * 
	* @Title: syncRelation 
	* @Description: 关系 
	* @param @param relationInfo    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void syncRelation(TWeixinSyncRelationInfo relationInfo);
}
