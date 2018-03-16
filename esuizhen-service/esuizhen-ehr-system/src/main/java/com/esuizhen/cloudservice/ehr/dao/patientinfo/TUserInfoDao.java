package com.esuizhen.cloudservice.ehr.dao.patientinfo;

import java.util.List;  

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.esuizhen.cloudservice.ehr.model.patientinfo.TUserInfo;
import com.westangel.common.bean.HospitalSearchReq;

public interface TUserInfoDao extends CommonDao<TUserInfo>
{
	public void updateUserInfo(TUserInfo userInfo);
	/**
	 * 查询医院信息列表
	 * @return
	 */
	List<HospitalSearchReq> queryHospitalByName(@Param("hospitalName")String hospitalName);
}
