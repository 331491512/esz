package com.esuizhen.cloudservice.statistics.dao;

import java.util.List;

import com.esuizhen.cloudservice.statistics.bean.DataQualityTbFieldStatisticsReq;
import com.esuizhen.cloudservice.statistics.bean.DataQualityTbFieldStatisticsRes;

/**
 * 
 * @author zhuguo
 * @date 2017-7-5 10:34:22
 */
public interface DataQualityTbFieldStatisticsDao {

	public List<DataQualityTbFieldStatisticsRes> statisticsDataQualityTbField(
			DataQualityTbFieldStatisticsReq req);

	public DataQualityTbFieldStatisticsReq queryDataSearchConfig(
			DataQualityTbFieldStatisticsReq req);

	public void creatTableToDate(DataQualityTbFieldStatisticsReq req);

	public void creatTableToDateMid(DataQualityTbFieldStatisticsReq req);

	public Integer insertSearchToTable(DataQualityTbFieldStatisticsReq req);
	
	public Integer queryTableExists(String tableName);
}
