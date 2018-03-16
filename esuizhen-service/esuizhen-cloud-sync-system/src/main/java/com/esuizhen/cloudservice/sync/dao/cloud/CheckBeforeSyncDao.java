package com.esuizhen.cloudservice.sync.dao.cloud;

import org.apache.ibatis.annotations.Param;


public interface CheckBeforeSyncDao {
	//判断该医院是否有三通权限
	public Integer judgeHospitalRight(@Param("hospitalId") Integer hospitalId);
}
