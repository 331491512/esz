package com.esuizhen.base.dao.global;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.base.model.GreyTestPatient;

public interface GreyTestPatientDao {
	
	public List<GreyTestPatient> listGreyTestPatient(@Param("productType") Integer productType);
	
}
