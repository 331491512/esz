package com.esuizhen.cloudservice.statistics.dao;

import java.util.LinkedHashMap;
import java.util.List;

import com.esuizhen.cloudservice.statistics.bean.FollowupPatientStatusStatisticsReq;

public interface PatientDao {
	//患者总数统计
	LinkedHashMap<String,Object> statisticsTotalPatient(FollowupPatientStatusStatisticsReq statisticsReq);
	//肿瘤患者统计
	LinkedHashMap<String,Object> statisticsTumorPatient(FollowupPatientStatusStatisticsReq statisticsReq);
	//任务患者统计
	LinkedHashMap<String,Object> statisticsTaskPatient(FollowupPatientStatusStatisticsReq statisticsReq);
	//失访患者
	LinkedHashMap<String,Object> statisticsLostFollowupPatient(FollowupPatientStatusStatisticsReq statisticsReq);
	//疑似重复患者
	LinkedHashMap<String,Object> statisticsSimilarPatient(FollowupPatientStatusStatisticsReq statisticsReq);
	//错误数据患者
	LinkedHashMap<String,Object> statisticsFaultPatient(FollowupPatientStatusStatisticsReq statisticsReq);
	/** #########263 新增功能########### */
	/**
	 * 肿瘤性质分布
	 * @return
	 */
	List<LinkedHashMap<String,Object>> statisticsTumorStatusPatient(FollowupPatientStatusStatisticsReq statisticsReq);
	/**
	 * 肿瘤部位统计
	 * @return
	 */
	List<LinkedHashMap<String,Object>> statisticsTumourPartPatient(FollowupPatientStatusStatisticsReq statisticsReq);
	/**
	 * 肿瘤病种统计
	 * @param req
	 * @return
	 */
	List<LinkedHashMap<String,Object>> statisticsDiseaseTypePatient(FollowupPatientStatusStatisticsReq req);
	/**
	 * 科室统计
	 * @param req
	 * @return
	 */
	List<LinkedHashMap<String,Object>> statisticsDepartmentPatient(FollowupPatientStatusStatisticsReq req);
	/**
	 * 地区统计
	 * @param req
	 * @return
	 */
	List<LinkedHashMap<String,Object>> statisticsAreaPatient(FollowupPatientStatusStatisticsReq req);
	/**
	 * 年龄统计
	 * @param req
	 * @return
	 */
	List<LinkedHashMap<String,Object>> statisticsAgePatient(FollowupPatientStatusStatisticsReq req);
	/**
	 * 性别统计
	 * @param req
	 * @return
	 */
	List<LinkedHashMap<String,Object>> statisticsSexPatient(FollowupPatientStatusStatisticsReq req);
	
}
