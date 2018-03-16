package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.List; 

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.bean.TMetaInfoIcd9Cm3;


public interface MetaInfoIcd9Cm3Dao {

	public List<TMetaInfoIcd9Cm3>getMetaInfoIcd9Cm3List(
			@Param("key")String key,
			@Param("opCode")String opCode,
			@Param("opName")String opName,
			@Param("mnemonicCode")String mnemonicCode
	);

}
