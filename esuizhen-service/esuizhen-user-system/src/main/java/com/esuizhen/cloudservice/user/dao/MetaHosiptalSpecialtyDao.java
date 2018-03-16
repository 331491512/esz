package com.esuizhen.cloudservice.user.dao;

import java.util.List;

import com.westangel.common.bean.THospitalSpecialtyInfo;

/**
 * 
 * @author YYCHEN
 *
 */
public interface MetaHosiptalSpecialtyDao {

	/**
	 * 
	 * @author lichenghao
	 * @title :queryHospitalSpecialty
	 * @Description:获取特色专科
	 * @return List<THospitalSpecialtyInfo>
	 * @date 2016年6月8日 下午7:00:21
	 */
	public List<THospitalSpecialtyInfo> queryHospitalSpecialty(Object param);
}