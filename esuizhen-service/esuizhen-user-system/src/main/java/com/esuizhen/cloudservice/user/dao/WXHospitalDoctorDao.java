package com.esuizhen.cloudservice.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.user.model.RWXHospitalDoctor;

public interface WXHospitalDoctorDao {
	/**
	 * 
	* @Title: selectDoctorOfHospital 
	* @Description: 查询医院关注时默认关注的医生 
	* @param @param hospitalId
	* @param @return    设定文件 
	* @return List<RWXHospitalDoctor>    返回类型 
	* @throws
	 */
	public List<RWXHospitalDoctor> selectDoctorOfHospital(@Param("hospitalId") Integer hospitalId);
}
