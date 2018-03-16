package com.esuizhen.cloudservice.followup.dao.statis;

import java.util.LinkedHashMap;

import org.apache.ibatis.annotations.Param;

/**
* @ClassName: FollowupResultDao 
* @Description: 随访结果数据统计
* @author wang_hw
* @date 2016年1月15日 下午6:46:31
 */
public interface StatisDao{

	
	public LinkedHashMap<String, Object> querySURStatisResult(
			@Param("doctorId") String doctorId , 
			@Param("confirmedDateBegin") String confirmedDateBegin , 
			@Param("confirmedDateEnd") String confirmedDateEnd , 
			@Param("diseaseTypeIds") String diseaseTypeIds);
	
}
