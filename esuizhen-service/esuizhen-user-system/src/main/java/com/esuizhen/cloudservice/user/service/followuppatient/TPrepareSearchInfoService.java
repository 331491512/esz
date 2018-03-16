package com.esuizhen.cloudservice.user.service.followuppatient;

public interface TPrepareSearchInfoService {
	
	/**
     * 根据搜索id获取搜索条数
     * @param searchId
     * @return
     */
    int getSearchCountById(Integer searchId);
}
