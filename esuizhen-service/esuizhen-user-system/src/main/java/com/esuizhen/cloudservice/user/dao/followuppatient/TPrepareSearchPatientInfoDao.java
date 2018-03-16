package com.esuizhen.cloudservice.user.dao.followuppatient;

import java.util.Map;

import com.esuizhen.cloudservice.user.model.followuppatient.TPrepareSearchPatientInfo;

public interface TPrepareSearchPatientInfoDao {
	/**
	 * 通过searchId获取搜索患者信息
	 * @param searchId
	 * @return
	 */
	TPrepareSearchPatientInfo getSearchPatientBySearchId(Integer searchId);
	
    int insert(Map<String,Object> paramsMap);

    int insertSelective(TPrepareSearchPatientInfo record);
    
    int update(Map<String,Object> paramsMap);
    
    int updateByPatientId(Map<String,Object> paramsMap);
}