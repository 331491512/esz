package com.esuizhen.cloudservice.followup.service.daily.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.followup.common.Constant.DAILY;
import com.esuizhen.cloudservice.followup.dao.daily.DailyDao;
import com.esuizhen.cloudservice.followup.model.daily.DailyInfo;
import com.esuizhen.cloudservice.followup.model.daily.FollowupDailyListReq;
import com.esuizhen.cloudservice.followup.model.daily.FollowupDailyStatisResultQueryReq;
import com.esuizhen.cloudservice.followup.model.daily.TDailyStatisInfo;
import com.esuizhen.cloudservice.followup.model.statis.TStatisData;
import com.esuizhen.cloudservice.followup.service.daily.DailyService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.service.MessageInnerService;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.ImMessageUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;
import com.westangel.common.util.PushUtil;

@Service
public class DailyServiceImpl implements DailyService
{

	private Locale locale=Locale.getDefault();
	@Autowired
	private DailyDao dao;
	
	@Autowired
	private MessageInnerService messageService;
	
	@Autowired
	private PushInnerService pushService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Value("${server.h5.url.root.app}")
	private String appUrlRoot;
	
	@Value("${daily.app}")
	private String appUrlLink;
	

	@Override
	public void sendDailyInfo(Long doctorId) {
		// TODO Auto-generated method stub
		List<DailyInfo> list = dao.queryDailInfo(null);
		if(list!=null){
			for(DailyInfo dailyInfo : list){
				sendDailyToDoctor(dailyInfo);
			}
		}
	}
	
	private void sendDailyToDoctor(DailyInfo dailyInfo){
		try{
			//3.4.6 以下版本推送至随诊助手 否则 直接发送推送
			if(dailyInfo.getAppVersion()==null ||
						dailyInfo.getAppVersion().compareTo("3.4.6")<1)
			{
				String description = messageSource.getMessage("statis.follow.result.info", new Object[]{dailyInfo.getTitleDate(),dailyInfo.getCountnum(),dailyInfo.getActivation(),dailyInfo.getResultnum()}, locale);
				String linkUrl = appUrlRoot+appUrlLink+"?dailyDate="+DateUtil.getDateStr(new Date())+"&doctorId="+dailyInfo.getDoctorId();
				String content = ImMessageUtil.getRichTextMessage("随访日报", description, null, "查看日报详情", linkUrl);
				ImMessageInfo message = ImMessageUtil.getEDoctorAssistCustomMessage(dailyInfo.getUserId(), content, "随访日报");
				messageService.sendInnerMessage(message);
			}
			else{
				Map<String,Object> eventInfo = new HashMap<String,Object>();
				eventInfo.put("doctorId", dailyInfo.getDoctorId());
				eventInfo.put("dailyDate", DateUtil.getDateStr(new Date()));
				PushNotifyInfo pushinfo = PushUtil.getAppPushNotifyInfo(dailyInfo.getUserId(), Constant.Push.EVENT_TYPE_FOLLOWUP_DAILY, JsonUtil.toJson(eventInfo), dailyInfo.getTitleDate()+"随访日报");
				pushService.push(pushinfo);
			}
			dao.createDaily(dailyInfo);
		}catch(Exception e){
			LogUtil.logError.error(Constant.LOGTAG.ERR+" sendDailyToDoctor() ERROR "+e.getMessage());
		}
	}

	@Override
	public Object queryDailyStaticResult(FollowupDailyStatisResultQueryReq req) {
		// TODO Auto-generated method stub
		//默认当前日期
		if(req.getDailyDate()==null){
			req.setDailyDate(DateUtil.getDateStr(new Date()));
		}
		//1.新增患者
		if(DAILY.DATATYPE_NAP.equals(req.getDataType())){
			return getNewAddPatientResult(req);
		}
		else if(DAILY.DATATYPE_FRW.equals(req.getDataType())){
			return getFollowResultWay(req);
		}else if(DAILY.DATATYPE_FRT.equals(req.getDataType())){
			return getFollowResutlType(req);
		}else if(DAILY.DATATYPE_FRD.equals(req.getDataType())){
			return getFollowResultThreeMonth(req);
		}
		return null;
	}
	
	
	//3月随访结果统计
	private Object getFollowResultThreeMonth(FollowupDailyStatisResultQueryReq req) {
		TDailyStatisInfo info = new TDailyStatisInfo();
		info.setDataList(dao.queryFollowupResultThreeMonth(req));
		info.setDataListTwo(dao.queryFollowupResultThreeMonthPercentage(req));
		return info;
	}

	//随访结果反馈
	private Object getFollowResutlType(FollowupDailyStatisResultQueryReq req) {
		TDailyStatisInfo info = new TDailyStatisInfo();
		info.setCountNum(dao.queryFollowResultCount(req));
		if(info.getCountNum()==null||info.getCountNum()==0){
			return null;
		}
		info.setDataList(dao.queryFollowupResult(req));
		return info;
	}

	//随访方式结果反馈
	private Object getFollowResultWay(FollowupDailyStatisResultQueryReq req) {
		// TODO Auto-generated method stub
		TDailyStatisInfo info = new TDailyStatisInfo();
		info.setCountNum(dao.queryFollowWayResultCount(req));
		TStatisData isalert = dao.queryFollowupIsAlertCount(req);
		TStatisData isalertQ = dao.queryFollowupQuestionIsAlertCount(req);
		
		if(isalert.getValue()!=null&&!"0".equals(isalert.getValue())){
			if(info.getCountNum()==null){
				info.setCountNum(0);
			}
			info.setCountNum(info.getCountNum()+Integer.parseInt(isalert.getValue()));
		}
		if(isalertQ.getValue()!=null&&!"0".equals(isalertQ.getValue())){
			if(info.getCountNum()==null){
				info.setCountNum(0);
			}
			info.setCountNum(info.getCountNum()+Integer.parseInt(isalertQ.getValue()));
		}
		if(info.getCountNum()==null||info.getCountNum()==0){
			return null;
		}
		info.setDataList(dao.queryFollowupResultTypeCount(req));
		if(info.getDataList()==null){
			info.setDataList(new ArrayList());
		}
		info.getDataList().add(isalertQ);
		info.getDataList().add(isalert);
		return info;
	}

	//获取新增患者病种
	private Object getNewAddPatientDiseaseCount(FollowupDailyStatisResultQueryReq req) {
		// TODO Auto-generated method stub
		TDailyStatisInfo info = new TDailyStatisInfo();
		info.setDataList(dao.queryPatientDiseaseGroupResult(req));
		info.setCountNum(info.getDataList().size());
		return info;
	}

	//获取新增患者
	private Object getNewAddPatientResult(FollowupDailyStatisResultQueryReq req) {
		// TODO Auto-generated method stub
		Map<String,Object> params = new HashMap<String,Object>();
		DailyInfo info = dao.queryDailyNewAddPatient(req);
		if(info!=null){
//			if(info.getCountnum()!=null){
				TDailyStatisInfo sinfo = new TDailyStatisInfo();
				sinfo.setContrastum(dao.queryAfterDayNewAddPatient(req));
				sinfo.setCountNum(info.getCountnum());
				List list = new ArrayList();
				list.add(new TStatisData("unactivation",info.getUnactivation().toString()));
				list.add(new TStatisData("activation",info.getActivation().toString()));
				sinfo.setDataList(list);
				if(info.getActivation()>0){
					sinfo.setDataListTwo(dao.queryPatientDiseaseGroupResult(req));
				}
				return sinfo;
//			}
		}
		return info;
	}
	
	
	/**
	 * 随访日报列表
	 */
	@Override
	public Page<DailyInfo> getDailyInfoList(FollowupDailyListReq req) {
		// TODO Auto-generated method stub
		if(req.getDoctorId()==null)
			throw new EmptyParamExcption(" doctorId is null");
		PageHelper.startPage(req.getPage()+1, req.getNum());
		List<DailyInfo> list = dao.queryDailyInfoList(req.getDoctorId());
		return PageUtil.returnPage((com.github.pagehelper.Page<DailyInfo>)list);
	}
}
