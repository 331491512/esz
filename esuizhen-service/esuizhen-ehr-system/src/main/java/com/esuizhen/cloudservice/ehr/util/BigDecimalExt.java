package com.esuizhen.cloudservice.ehr.util;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import com.westangel.common.util.LogUtil;

public class BigDecimalExt{

	public BigDecimal toDecimal(String val){
		if(StringUtils.isNotEmpty(val)){
			try{
				return new BigDecimal(val);
			}catch(Exception e){
				LogUtil.log.info(val+"=====BigDecimal====="+e.getMessage());
			}
		}
		return new BigDecimal(0);
	}
}
