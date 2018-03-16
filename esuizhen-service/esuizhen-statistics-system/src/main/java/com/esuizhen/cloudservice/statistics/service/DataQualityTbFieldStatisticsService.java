package com.esuizhen.cloudservice.statistics.service;

import java.util.List;

import com.esuizhen.cloudservice.statistics.bean.DataQualityTbFieldStatisticsReq;
import com.esuizhen.cloudservice.statistics.bean.DataQualityTbFieldStatisticsRes;

/**
 * 
 * @author zhuguo
 * @date 2017-7-5 10:34:22
 */
public interface DataQualityTbFieldStatisticsService {

	public List<DataQualityTbFieldStatisticsRes> statisticsDataQualityTbField(
			DataQualityTbFieldStatisticsReq req);
}
