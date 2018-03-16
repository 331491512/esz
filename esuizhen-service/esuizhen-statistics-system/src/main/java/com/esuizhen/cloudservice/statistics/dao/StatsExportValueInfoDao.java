package com.esuizhen.cloudservice.statistics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.search.StatsExportValueInfo;

public interface StatsExportValueInfoDao {
	/**
	 * <p>Title:insert</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年8月20日 下午6:15:01
	 * @param statsExportValueInfo
	 * @return
	 */
	int insert(StatsExportValueInfo statsExportValueInfo);
	
	int insertByBatch(@Param("statsExportValueInfoes")List<StatsExportValueInfo> statsExportValueInfoes);
}
