package com.esuizhen.base.dao.global;

import org.apache.ibatis.annotations.Select;

import com.esuizhen.base.model.GreyTestControl;

public interface GreyTestControlDao {
	
	@Select("SELECT * FROM com_sys_db.sys_grey_test_control where productType=#{productType} limit 1")
	public GreyTestControl getGreyTestControlByProductType(Integer productType);
	
}
