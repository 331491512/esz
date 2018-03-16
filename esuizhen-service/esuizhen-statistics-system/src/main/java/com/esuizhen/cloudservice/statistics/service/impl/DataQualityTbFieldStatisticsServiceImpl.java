package com.esuizhen.cloudservice.statistics.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.statistics.bean.DataQualityTbFieldStatisticsReq;
import com.esuizhen.cloudservice.statistics.bean.DataQualityTbFieldStatisticsRes;
import com.esuizhen.cloudservice.statistics.dao.DataQualityTbFieldStatisticsDao;
import com.esuizhen.cloudservice.statistics.service.DataQualityTbFieldStatisticsService;

/**
 * 
 * @author zhuguo
 * @date 2017-7-5 10:34:22
 */
@Service
@Transactional
public class DataQualityTbFieldStatisticsServiceImpl implements
		DataQualityTbFieldStatisticsService {

	@Autowired
	private DataQualityTbFieldStatisticsDao dataQualityTbFieldStatisticsDao;

	/**
	 * 数据质量分析
	 * 
	 * @author zhuguo
	 */
	@Override
	public List<DataQualityTbFieldStatisticsRes> statisticsDataQualityTbField(
			DataQualityTbFieldStatisticsReq req) {

		// 查询传入的时间，是否有记录
		DataQualityTbFieldStatisticsReq SearchReq = dataQualityTbFieldStatisticsDao
				.queryDataSearchConfig(req);

		if (null != SearchReq) {
			// 查询随访系统表是否存在
			String tobDynamicTabName = SearchReq.getTobDynamicTabName();
			tobDynamicTabName = tobDynamicTabName.substring(
					tobDynamicTabName.indexOf(".") + 1,
					tobDynamicTabName.length());
			int tobDynamicTab = dataQualityTbFieldStatisticsDao
					.queryTableExists(tobDynamicTabName);

			// 创建随访系统表不存在则创建
			if (tobDynamicTab == 0) {
				createTobDynamicTab(req);
			}

			// 查询中间库表是否存在
			String middleDynamicTabName = SearchReq.getMiddleDynamicTabName();
			middleDynamicTabName = middleDynamicTabName.substring(
					middleDynamicTabName.indexOf(".") + 1,
					middleDynamicTabName.length());
			int middleDynamicTab = dataQualityTbFieldStatisticsDao
					.queryTableExists(middleDynamicTabName);

			// 中间库表不存在则创建
			if (middleDynamicTab == 0) {
				createMiddleDynamicTab(req);
			}

			// 需要确认下，从数据库查的没有标识，表中是否需要加上。已确认，从页面传入。
			SearchReq.setCondition(req.getCondition());

			// 传入SearchReq中查询的信息
			List<DataQualityTbFieldStatisticsRes> result = dataQualityTbFieldStatisticsDao
					.statisticsDataQualityTbField(SearchReq);
			return result;
		} else {

			// 如果没有记录，需要调用存储过程，生成传入的时间、库、表创建新的表
			createTobDynamicTab(req);
			createMiddleDynamicTab(req);

			// 处理随访系统表和中间库表名字中的时间
			String tbBeginDate = req.getBeginDate().replace("-", "");
			String tbEndDate = req.getEndDate().replace("-", "");
			req.setTobDynamicTabName("data_quality_db.tob_data_quality_tbfield_statistics_"
					+ tbBeginDate + "_" + tbEndDate);

			req.setMiddleDynamicTabName("data_quality_db.middle_data_quality_tbfield_statistics_"
					+ tbBeginDate + "_" + tbEndDate);

			// 设置MD5值
			req.setSearchMd5(tbBeginDate + "_" + tbEndDate);

			// 向查询表中插入本次查询的条件
			int insertResult = dataQualityTbFieldStatisticsDao
					.insertSearchToTable(req);

			if (insertResult > 0) {
				// 查询数据
				List<DataQualityTbFieldStatisticsRes> result = dataQualityTbFieldStatisticsDao
						.statisticsDataQualityTbField(req);
				return result;
			}
		}
		return null;
	}

	/**
	 * 判断Condition的类型，创建随访表-公共方法
	 * 
	 * @param req
	 */
	private void createTobDynamicTab(DataQualityTbFieldStatisticsReq req) {
		// 患者信息
		if (req.getCondition().equals("1")) {

			// 患者表-随访系统
			req.setDatabaseName("user_db");
			req.setTableName("u_patient");
			dataQualityTbFieldStatisticsDao.creatTableToDate(req);

			// 家庭信息表-随访系统
			req.setDatabaseName("user_db");
			req.setTableName("u_patient_family");
			dataQualityTbFieldStatisticsDao.creatTableToDate(req);

			// 用户表-随访系统
			req.setDatabaseName("user_db");
			req.setTableName("u_user");
			dataQualityTbFieldStatisticsDao.creatTableToDate(req);
			
			// 住院表-随访系统
			req.setDatabaseName("ehr_db");
			req.setTableName("ei_inhospital_note");
			dataQualityTbFieldStatisticsDao.creatTableToDate(req);

		} else if (req.getCondition().equals("2")) {

			// 住院信息-随访系统
			req.setDatabaseName("ehr_db");
			req.setTableName("ei_inhospital_note");
			dataQualityTbFieldStatisticsDao.creatTableToDate(req);
			
			// 诊断信息-随访系统
			req.setDatabaseName("ehr_db");
			req.setTableName("e_diagnosis_info");
			dataQualityTbFieldStatisticsDao.creatTableToDate(req);

		} else if (req.getCondition().equals("3")) {

			// 病案诊断信息-随访系统
			req.setDatabaseName("ehr_db");
			req.setTableName("e_diagnosis_info");
			dataQualityTbFieldStatisticsDao.creatTableToDate(req);

		} else if (req.getCondition().equals("4")) {

			// 病案手术与操作信息-随访系统
			req.setDatabaseName("ehr_db");
			req.setTableName("eci_surgery_note");
			dataQualityTbFieldStatisticsDao.creatTableToDate(req);

		} else if (req.getCondition().equals("5")) {

			// 治疗信息-随访系统
			req.setDatabaseName("ehr_db");
			req.setTableName("eci_treatment_note");
			dataQualityTbFieldStatisticsDao.creatTableToDate(req);

		} else if (req.getCondition().equals("6")) {

			// 放疗信息-随访系统
			req.setDatabaseName("ehr_db");
			req.setTableName("eci_treatment_radiotherapy_detail");
			dataQualityTbFieldStatisticsDao.creatTableToDate(req);

		} else if (req.getCondition().equals("7")) {

			// 化疗信息-随访系统
			req.setDatabaseName("ehr_db");
			req.setTableName("eci_treatment_chemotherapy_medication");
			dataQualityTbFieldStatisticsDao.creatTableToDate(req);

			// 化疗信息详细表-随访系统
			req.setDatabaseName("ehr_db");
			req.setTableName("eci_treatment_chemotherapy_medication_detail");
			dataQualityTbFieldStatisticsDao.creatTableToDate(req);

		} else if (req.getCondition().equals("8")) {

			// 病案费用信息-随访系统
			req.setDatabaseName("ehr_db");
			req.setTableName("ei_inhospital_cost");
			dataQualityTbFieldStatisticsDao.creatTableToDate(req);

		}
	}

	/**
	 * 判断Condition的类型，创建中间库表-公共方法
	 * 
	 * @param req
	 */
	private void createMiddleDynamicTab(DataQualityTbFieldStatisticsReq req) {
		// 患者信息
		if (req.getCondition().equals("1")) {

			req.setDatabaseName("data_quality_db");
			req.setTableName("mid_inhospitalinfo_temp");
			dataQualityTbFieldStatisticsDao.creatTableToDateMid(req);

			req.setDatabaseName("data_quality_db");
			req.setTableName("mid_patient_temp");
			dataQualityTbFieldStatisticsDao.creatTableToDateMid(req);

		} else if (req.getCondition().equals("2")) {

			req.setDatabaseName("data_quality_db");
			req.setTableName("mid_inhospitalinfo_temp");
			dataQualityTbFieldStatisticsDao.creatTableToDateMid(req);

		} else if (req.getCondition().equals("3")) {

			req.setDatabaseName("data_quality_db");
			req.setTableName("mid_diagnosis_temp");
			dataQualityTbFieldStatisticsDao.creatTableToDateMid(req);

		} else if (req.getCondition().equals("4")) {

			req.setDatabaseName("data_quality_db");
			req.setTableName("mid_operationinfo_temp");
			dataQualityTbFieldStatisticsDao.creatTableToDateMid(req);

		} else if (req.getCondition().equals("5")) {

			req.setDatabaseName("data_quality_db");
			req.setTableName("mid_treatinfo_temp");
			dataQualityTbFieldStatisticsDao.creatTableToDateMid(req);

		} else if (req.getCondition().equals("6")) {

			req.setDatabaseName("data_quality_db");
			req.setTableName("mid_radiationinfo_temp");
			dataQualityTbFieldStatisticsDao.creatTableToDateMid(req);

		} else if (req.getCondition().equals("7")) {

			req.setDatabaseName("data_quality_db");
			req.setTableName("mid_chemotherapyinfo_temp");
			dataQualityTbFieldStatisticsDao.creatTableToDateMid(req);

		} else if (req.getCondition().equals("8")) {

			req.setDatabaseName("data_quality_db");
			req.setTableName("mid_costinfo_temp");
			dataQualityTbFieldStatisticsDao.creatTableToDateMid(req);

		}
	}
}
