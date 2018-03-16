package com.esuizhen.cloudservice.business.dao.business.mdt;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.business.bean.MetaMDTProductStateListReq;



/** 
 * @ClassName: MetaMDTProductDao.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月28日
 */
public interface MetaMDTProductDao {

	
	List<MetaMDTProductStateListReq> getMetaMDTProductStateList(@Param("map")Map map);
}
