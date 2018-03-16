package com.esuizhen.cloudservice.followup.dao.meta;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PhoneHomeMetaInfoDao {
	public Map<String, Object> queryPhoneHome(@Param("code") String code, @Param("phone") String phone);
}
