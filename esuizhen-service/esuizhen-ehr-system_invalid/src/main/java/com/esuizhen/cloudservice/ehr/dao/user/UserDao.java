package com.esuizhen.cloudservice.ehr.dao.user;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 用户简单数据查询。内部使用。
 * @author bigdragon
 *
 */
public interface UserDao {

	String getUserTrueName(@Param("patientId") Long patientId);
	
	Map<String,Object> getThirdpartyByUserId(Long userId);

}