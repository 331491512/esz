package com.esuizhen.server.sync.dao.server;

import org.apache.ibatis.annotations.Param;

/**
 * author:lhy
 * descp:user dao 
 * date:2017.03.17
 */

public interface SignedHospitalDao {
	//获取同步开关
	public int getHospitalSingned(@Param("hospitalId")Integer hospitalId);
}
