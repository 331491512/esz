package com.esuizhen.cloudservice.ehr.service.patientreport.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.PatientReportResp;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.PatientReportDao;
import com.esuizhen.cloudservice.ehr.service.patientreport.PatientReportService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.util.PageUtil;

/**
 * @ClassName: PatientReportServiceImpl
 * @Description: 检查检验
 * @author zhuguo
 * @date 2017-5-31 10:32:31
 */
@Service
@Transactional
public class PatientReportServiceImpl implements PatientReportService {

	@Autowired
	private PatientReportDao patientReportDao;

	/**
	 * 最近三个月检查检验列表
	 * 
	 * @author zhuguo
	 */
	@Override
	public Page<PatientReportResp> getNewReportList(PatientReportResp resp) {
		List<PatientReportResp> list = null;
		PageHelper.startPage(resp.getPage() + 1, resp.getNum());

		resp.setDays(readProperties());
		list = patientReportDao.getNewReportList(resp);

		return PageUtil
				.returnPage((com.github.pagehelper.Page<PatientReportResp>) list);
	}

	/**
	 * 三个月前检查检验列表
	 * 
	 * @author zhuguo
	 */
	@Override
	public Page<PatientReportResp> getMoreReportList(PatientReportResp resp) {
		List<PatientReportResp> list = null;
		PageHelper.startPage(resp.getPage() + 1, resp.getNum());

		resp.setDays(readProperties());
		list = patientReportDao.getMoreReportList(resp);

		return PageUtil
				.returnPage((com.github.pagehelper.Page<PatientReportResp>) list);
	}

	/**
	 * 读取配置文件中，需要查询的天数
	 * @return
	 */
	public Integer readProperties() {
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("config/config.properties");
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return Integer.parseInt(p.getProperty("patient.report.mapper.days"));
	}

}
