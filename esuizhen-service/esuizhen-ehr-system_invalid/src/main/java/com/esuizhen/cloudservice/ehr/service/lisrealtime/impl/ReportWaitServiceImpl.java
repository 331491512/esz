package com.esuizhen.cloudservice.ehr.service.lisrealtime.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.esuizhen.base.dao.global.GreyTestControlDao;
import com.esuizhen.base.dao.global.GreyTestPatientDao;
import com.esuizhen.base.service.global.GreyTestService;
import com.esuizhen.cloudservice.ehr.dao.lisrealtime.RealtimeDetectionReportDao;
import com.esuizhen.cloudservice.ehr.dao.lisrealtime.RealtimeExamReportDao;
import com.esuizhen.cloudservice.ehr.model.lisrealtime.TReportPushBatch;
import com.esuizhen.cloudservice.ehr.service.lisrealtime.ReportWaitService;
import com.westangel.common.util.DateUtil;


@Service
public class ReportWaitServiceImpl implements ReportWaitService {
	
	@Autowired
	private GreyTestService greyTestService;
	
	@Autowired
	private RealtimeDetectionReportDao detectionReportDao;
	
	@Autowired
	private RealtimeExamReportDao examReportDao;
	
	@Autowired 
	private GreyTestControlDao greyTestControlDao;
	
	@Autowired
	private GreyTestPatientDao greyTestPatientDao;

	@Value("${report.before.reportDay}")
	private Integer reportDay;
	
	@Override
	public List<TReportPushBatch> queryWaitPushDetectionReport(){
		List<TReportPushBatch> resultList=null;
		String reportTime=this.getReportTime();
		//查询符合规则的患者
		if(greyTestService.getTwGreyTestControl()==1){
			resultList=this.detectionReportDao.queryWaitPushDetectionReportByGreyTest(reportTime);
		}else{
			resultList=this.detectionReportDao.queryWaitPushDetectionReport(reportTime);
		}
		return resultList;
	}
	
	@Override
	public List<TReportPushBatch> queryWaitPushExamReport(){
		List<TReportPushBatch> resultList=null;
		String reportTime=this.getReportTime();
		//查询符合规则的患者
		if(greyTestService.getTwGreyTestControl()==1){
			resultList=this.examReportDao.queryWaitPushExamReportByGreyTest(reportTime);
		}else{
			resultList=this.examReportDao.queryWaitPushExamReport(reportTime);
		}
		return resultList;
	}
	
	public String getReportTime(){
		Date offDate=DateUtil.getOffsetDate(-reportDay);
		String reportTime=DateUtil.convertToStr(offDate, DateUtil.YMR_SLASH)+" 00:00:00";
		return reportTime;
	}
}
