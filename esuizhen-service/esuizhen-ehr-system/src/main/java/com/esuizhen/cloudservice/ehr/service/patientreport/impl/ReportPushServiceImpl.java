package com.esuizhen.cloudservice.ehr.service.patientreport.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.ConsultDoctorsOfPatientGetReq;
import com.esuizhen.cloudservice.ehr.dao.lisrealtime.RealtimeDetectionReportDao;
import com.esuizhen.cloudservice.ehr.dao.lisrealtime.RealtimeExamReportDao;
import com.esuizhen.cloudservice.ehr.dao.lisrealtime.ReportPushBatchDetailHistoryDao;
import com.esuizhen.cloudservice.ehr.dao.lisrealtime.ReportPushBatchDetailWaitDao;
import com.esuizhen.cloudservice.ehr.dao.lisrealtime.ReportPushBatchHistoryDao;
import com.esuizhen.cloudservice.ehr.dao.lisrealtime.ReportPushBatchWaitDao;
import com.esuizhen.cloudservice.ehr.dao.lisrealtime.ReportPushLogDao;
import com.esuizhen.cloudservice.ehr.dao.patient.InHospitalDao;
import com.esuizhen.cloudservice.ehr.dao.user.UserDao;
import com.esuizhen.cloudservice.ehr.model.lisrealtime.TReportPushBatch;
import com.esuizhen.cloudservice.ehr.service.doctor.DoctorService;
import com.esuizhen.cloudservice.ehr.service.patientreport.ReportPushService;
import com.esuizhen.cloudservice.ehr.service.patientreport.ReportWaitService;
import com.esuizhen.cloudservice.ehr.util.UtilValidate;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PushUtil;

@Service
public class ReportPushServiceImpl implements ReportPushService {
	
	private Locale locale=Locale.getDefault();
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private PushInnerService pushInnerService;
	
	@Autowired
	private ReportWaitService reportWaitService;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private RealtimeDetectionReportDao detectionReportDao;
	
	@Autowired
	private RealtimeExamReportDao examReportDao;
	
	@Autowired
	private ReportPushBatchWaitDao reportPushBatchWaitDao;
	
	@Autowired
	private ReportPushBatchHistoryDao reportPushBatchHistoryDao;
	
	@Autowired
	private ReportPushBatchDetailHistoryDao reportPushBatchDetailHistoryDao;
	
	@Autowired
	private ReportPushBatchDetailWaitDao reportPushBatchDetailWaitDao;
	
	@Autowired
	private ReportPushLogDao reportPushLogDao;
	
	@Autowired
	private InHospitalDao inHospitalDao;
	
	@Value("${server.wx.url.root}")
	private String wxHtmlRoot;
	
	/**
	 * 患者检查检验单进行待推关列表
	 * 规则：
	 * 1、按报告时间查询前一天（可自定义）的检验检查报告单
	 * 2、患者为微信注册
	 * 3、开通检查检验服务的医院
	 */
	@Override
	@Transactional
	public void addReportBatchWait() {
		//查询符合规则的患者
		List<TReportPushBatch>deteList=this.reportWaitService.queryWaitPushDetectionReport();
		List<TReportPushBatch>examList=this.reportWaitService.queryWaitPushExamReport();
		
		//批量插入待推送患者和检检查检验
		if(UtilValidate.isNotEmpty(deteList)){
			for(TReportPushBatch dete:deteList){
				dete=this.getMainDoctor(dete);
				
				//设置唯一主健
				dete.setReportPushBatchId(GeneralUtil.generateUniqueID("RPB"));
				this.reportPushBatchWaitDao.insertReportPushBatchWait(dete);
				
				//符合条件的检验
				dete.setReportPushItemId(GeneralUtil.generateUniqueID("RPI"));
				this.reportPushBatchDetailWaitDao.insertReportPushBatchDetailWait(dete);
			}
			//设置检验检查处理状态
			this.detectionReportDao.updateHandleFlagByPrimaryKey(deteList);
		}
		if(UtilValidate.isNotEmpty(examList)){
			for(TReportPushBatch exam:examList){
				exam=this.getMainDoctor(exam);
				
				//设置唯一主健
				exam.setReportPushBatchId(GeneralUtil.generateUniqueID("RPB"));
				this.reportPushBatchWaitDao.insertReportPushBatchWait(exam);
				
				//符合条件的检查
				exam.setReportPushItemId(GeneralUtil.generateUniqueID("RPI"));
				this.reportPushBatchDetailWaitDao.insertReportPushBatchDetailWait(exam);
			}
			//设置检验检查处理状态
			this.examReportDao.updateHandleFlagByPrimaryKey(examList);
		}
	}
	/**
	 * 推送
	 */
	@Override
	public void pushReportBatch() {
		//查询待推送记录列表
		List<TReportPushBatch> reportPushBatchList=this.reportPushBatchDetailWaitDao.queryReportPushBatchDetailWait();
		
		//循环推送
		for(TReportPushBatch reportPushBatch:reportPushBatchList){
			this.pushWxReportMsg(reportPushBatch);
		}
		
		//移到历史库
		this.moveToHistory(reportPushBatchList);
		
	}
	
	@Transactional
	public void moveToHistory(List<TReportPushBatch> reportPushBatchList){
		//添加推送到历史库
		reportPushBatchList=this.reportPushBatchDetailWaitDao.queryReportPushBatchDetailAlreadly();
		if(UtilValidate.isNotEmpty(reportPushBatchList)){
			this.reportPushBatchHistoryDao.batchInsertReportPushBatchHistory(reportPushBatchList);
			this.reportPushBatchDetailHistoryDao.batchInsertReportPushBatchDetailHistory(reportPushBatchList);
		}
		
		//级联删除成功及失败次数超过3次的待推送列表
		this.reportPushBatchWaitDao.cascadeDeleteReportPushBatchWait();;
	}
	
	/**
	 * 发送微信消息
	 * @param reportPushBatch
	 */
	public void pushWxReportMsg(TReportPushBatch reportPushBatch){
		String openId=null;
		Integer productId=2;
		Integer hospitalId=reportPushBatch.getHospitalId();
		
		//推送
		reportPushBatch.setPushCount(reportPushBatch.getPushCount()+1);
		reportPushBatch.setPushTime(new Date());
		
		//查找第三方微信ID
		Map<String,Object> thirdparty=this.userDao.getThirdpartyByUserId(reportPushBatch.getUserId());
		if(UtilValidate.isNotEmpty(thirdparty)){
			openId=(String)thirdparty.get("openId");
			productId=(Integer)thirdparty.get("productId");
		}
		if(UtilValidate.isEmpty(openId)){
			//推送异常更新推送状态及原因
			reportPushBatch.setPushState(-2);	
			this.reportPushBatchWaitDao.updateReportPushBatchWait(reportPushBatch);
			LogUtil.log.error("【推送失败,该患者没有微信OPENID】");
			return;
		}
		// 向微信端发送消息
		String url="";
		String first = "";
		String test=reportPushBatch.getPushItemName();
		String testDate="";
		if(UtilValidate.isNotEmpty(reportPushBatch.getItemCheckTime())){
			testDate=DateUtil.convertToStr(reportPushBatch.getItemCheckTime(), DateUtil.YMR_SLASH);
		}
		if(reportPushBatch.getType()==1){//检查
			url=wxHtmlRoot+this.messageSource.getMessage("push.wx.patient.report.exam.url", new Object[]{reportPushBatch.getType(),reportPushBatch.getReportId(),openId,String.valueOf(hospitalId)}, locale);
			first=this.messageSource.getMessage("push.wx.patient.report.exam.first", null, locale);
		}else{
			url=wxHtmlRoot+this.messageSource.getMessage("push.wx.patient.report.detection.url", new Object[]{reportPushBatch.getType(),reportPushBatch.getReportId(),openId,String.valueOf(hospitalId)}, locale);
			if(UtilValidate.isNotEmpty(reportPushBatch.getPromptFlag()) && reportPushBatch.getPromptFlag()<0){
				first=this.messageSource.getMessage("push.wx.patient.report.detection.prompt.first", null, locale);
			}else{
				first=this.messageSource.getMessage("push.wx.patient.report.detection.first", null, locale);
			}
		}
		String remark = this.messageSource.getMessage("push.wx.patient.report.remark", null, locale);
		// 推送实名认证微信模板消息
		List<String> values = new ArrayList<String>();
		values.add(first);
		values.add(test);
		values.add(testDate);
		values.add(remark);
		PushNotifyInfo pushNotifyInfo = PushUtil.getWxTemplatePushNotifyInfo("jianchajianyuanjieguotongzhi",url, values);
		pushNotifyInfo.setUserId(reportPushBatch.getUserId());
		pushNotifyInfo.setProductId(productId);
		
		try{
			this.pushInnerService.push(pushNotifyInfo);
			//修改状态等信息
			reportPushBatch.setPushState(1);	
			this.reportPushBatchWaitDao.updateReportPushBatchWait(reportPushBatch);
		}catch(Exception e){
			//推送异常更新推送状态及原因
			reportPushBatch.setPushState(-1);	
			this.reportPushBatchWaitDao.updateReportPushBatchWait(reportPushBatch);
			LogUtil.log.error("【推送失败】"+e.getMessage());
		}
		reportPushBatch.setFirstText(first);
		reportPushLogDao.insertReportPushLog(reportPushBatch);
	}
	
	public TReportPushBatch getMainDoctor(TReportPushBatch reportPushBatch){
		Doctor doctor=null;
		//获取询问医师
		ConsultDoctorsOfPatientGetReq req=new ConsultDoctorsOfPatientGetReq();
		req.setHospitalId(reportPushBatch.getHospitalId());
		req.setPatientId(reportPushBatch.getPatientId());
		req.setReportId(reportPushBatch.getReportId());
		req.setType(reportPushBatch.getType());
		
		reportPushBatch.setDoctorId(null);
		reportPushBatch.setDoctorUserId(null);
		
		doctor=this.doctorService.getConsultDoctorOfPatient(req);
		if(UtilValidate.isEmpty(doctor) && UtilValidate.isNotEmpty(req.getHospitalId())){
			doctor=this.doctorService.getServiceDutyDoctor(req.getHospitalId());
		}
		if(UtilValidate.isNotEmpty(doctor)){
			reportPushBatch.setDoctorId(doctor.getDoctorId());
			reportPushBatch.setDoctorUserId(doctor.getUserId());
		}
		return reportPushBatch;
	}
}
