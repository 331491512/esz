/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.service.business.impl;<br/>  
 * <b>文件名：</b>DoctorServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月31日下午2:31:37<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.service.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.esuizhen.cloudservice.business.bean.DoctorClinicScheduleSetReq;
import com.esuizhen.cloudservice.business.bean.DoctorClinicUsageReq;
import com.esuizhen.cloudservice.business.bean.DoctorClinicUsageSetReq;
import com.esuizhen.cloudservice.business.bean.FollowupReportApplyReq;
import com.esuizhen.cloudservice.business.bean.TDoctorAnnouncement;
import com.esuizhen.cloudservice.business.bean.TDoctorClinicInfo;
import com.esuizhen.cloudservice.business.bean.TDoctorClinicScheduleInfo;
import com.esuizhen.cloudservice.business.bean.TDoctorInvitation;
import com.esuizhen.cloudservice.business.bean.TMsgResponse;
import com.esuizhen.cloudservice.business.dao.business.DoctorClinicDao;
import com.esuizhen.cloudservice.business.dao.business.DoctorDao;
import com.esuizhen.cloudservice.business.dao.business.ProductApplyDao;
import com.esuizhen.cloudservice.business.dao.business.UserDao;
import com.esuizhen.cloudservice.business.model.business.DoctorAnnouncement;
import com.esuizhen.cloudservice.business.model.business.RegisteringDoctors;
import com.esuizhen.cloudservice.business.model.business.TDoctorAnnouncementInfo;
import com.esuizhen.cloudservice.business.service.business.DoctorService;
import com.westangel.common.bean.DoctorSimpleInfo;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.push.PushUser;
import com.westangel.common.bean.sms.SmsTemplateSendReq;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.ObjectAlreadyExistExcption;
import com.westangel.common.excption.RemoteCallExcption;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.service.SmsInnerService;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PushContentUtil;
import com.westangel.common.util.PushNotifyUtil;
import com.westangel.common.util.PushUtil;
import com.westangel.common.util.SmsUtil;

/** 
* @ClassName: DoctorServiceImpl
* @Description: 
* @author lichenghao
* @date 2015年12月31日 下午2:31:37  
*/
@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorDao dao;
	@Autowired
	private DoctorClinicDao doctorClinicDao;
	@Autowired
	ProductApplyDao applyDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private PushInnerService pushInnerService;
	@Autowired
	private SmsInnerService smsService;
	
	@Value("${server.h5.url.root}")
	private String wxH5Url;
	@Value("${url.api.user.profile}")
	private String profile; 
	@Value("${url.api.user.personal.disease}")
	private String personal_disease;
	
	@Value("${url.api.business.to.text.consulting}")
	private String richTextUrl; 
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void publishDoctorAnnouncement(TDoctorAnnouncement tdoctorAnnouncement) {
		// TODO Auto-generated method stub
		DoctorAnnouncement doctorAnnouncement = new DoctorAnnouncement();
		//转到类实体
		tdoctorAnnouncement.setDoctorAnnmouncement(doctorAnnouncement);
		if(tdoctorAnnouncement.getPublishType()==2){
			DoctorSimpleInfo doctorInfo = dao.queryDoctorSimpleInfo(tdoctorAnnouncement.getDoctorId(),null);
			String name = "yizhutuisongtongzhi";
			List<String> values = new ArrayList<String>();
			String messageCode="";
			//医生公告发送
			if(tdoctorAnnouncement.getPatients()==null || tdoctorAnnouncement.getPatients().size()==0 ||tdoctorAnnouncement.getPatients().get(0)==0)
				messageCode = "push.doctor.announcement";
			else //随访通知发送
				messageCode = "push.followup.notify";
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(messageCode)));
			values.add(doctorInfo.getTrueName()!=null?doctorInfo.getTrueName():"");
			values.add(doctorInfo.getProfessionalRank()!=null?doctorInfo.getProfessionalRank():"");
			values.add(doctorInfo.getHospitalName()!=null?doctorInfo.getHospitalName():"");
			values.add(doctorInfo.getDeptName()!=null?doctorInfo.getDeptName():"");
			values.add(tdoctorAnnouncement.getAnnouncementContent());
			PushNotifyInfo pushInfo = PushUtil.getWxTemplatePushNotifyInfo(name, null, values);
			/**调用推送消息服务，推送医生公告*/
			if(tdoctorAnnouncement.getPatients()==null || tdoctorAnnouncement.getPatients().size()==0 ||tdoctorAnnouncement.getPatients().get(0)==0){
				//获取医生对应人员
				List<Long> patients = dao.queryPatientUserByDoctorId(tdoctorAnnouncement.getDoctorId());
				tdoctorAnnouncement.setPatients(patients);
			}
			if(tdoctorAnnouncement.getPatients()!=null&&tdoctorAnnouncement.getPatients().size()>0){
				sendAnnouncementSend(tdoctorAnnouncement.getPatients(),pushInfo);
			}
		}else{
			/**写入医院编号*/
			doctorAnnouncement.setHospitalId(dao.getHospitalIdByDoctorId(doctorAnnouncement.getDoctorId()));
			dao.createDoctorAnnouncement(doctorAnnouncement);
		}
	}
	
	public void sendAnnouncementSend(final List<Long> patientUserIds,final PushNotifyInfo pushInfo){
		ExecutorService exec = Executors.newFixedThreadPool(1);
		Runnable run = new Runnable(){
			@Override
			public void run()
			{
				//获取patientInfo
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("users", patientUserIds);
				List<PatientSimpleInfo> patients = userDao.getPatientInfo(param);
				for(PatientSimpleInfo info : patients){
					if(info.getWeixinFlag()!=0){
						//推送消息
						LogUtil.log.debug("------------------------"+info.getUserId());
						pushInfo.setUserId(info.getUserId());
						pushInfo.setProductId(info.getWeixinFlag());
						pushInnerService.push(pushInfo);
					}
				}
			}
		};
		exec.execute(run);
	}
	
	public boolean instr(String[] strs,String str){
		for(String s : strs){
			if(str.equals(s)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteDoctorAnnouncementsByDoctorIdAndAnnouncements(Long doctorId, Integer[] announcements) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("doctorId", doctorId);
		params.put("announcements", announcements);
		dao.deleteDoctorAnnouncement(params);
	}

	@Override
	public TDoctorAnnouncementInfo queryTDoctorAnnouncementInfoByDoctorId(Long doctorId) {
		// TODO Auto-generated method stub
		return dao.queryDoctorAnnouncementInfoByDoctorId(doctorId);
	}
	
	@Override
	public List<TDoctorAnnouncementInfo> queryTDoctorAnnouncementInfoListByDoctorId(Long doctorId) {
		// TODO Auto-generated method stub
		return dao.queryDoctorAnnouncementInfoListByDoctorId(doctorId);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void setDoctorClinicSchedule(DoctorClinicScheduleSetReq req) {
		// TODO Auto-generated method stub
		Long doctorId = req.getDoctorId();
		//获取该医生门诊
		TDoctorClinicInfo doctorClinicInfo = doctorClinicDao.queryDoctorClinicScheduleSampleInfo(doctorId);
		Long hospitalId = dao.getHospitalIdByDoctorId(doctorId);
		if(doctorClinicInfo == null){
			//该医生没有门诊 创建门诊
			RegisteringDoctors rd = new RegisteringDoctors();
			rd.setDoctorId(doctorId);
			rd.setDoctorUserId(dao.queryDoctorUserIdByDoctorId(doctorId));
			rd.setHospitalId(hospitalId);
			rd.setRegisteringFlag(1);
			doctorClinicDao.createRegisterDoctor(rd);
		}
		//更新门诊信息
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("doctorId", req.getDoctorId());
		params.put("introduction", req.getIntroduction());
		doctorClinicDao.modifyRegisteringDoctor(params);
		Long doctorUserId = dao.queryDoctorUserIdByDoctorId(doctorId);
		//如果没有门诊 返回
		if(req.getClinicScheduleList()==null||req.getClinicScheduleList().size()==0)
			return;
		//初始化门诊列表
		List<TDoctorClinicScheduleInfo> list = new ArrayList<TDoctorClinicScheduleInfo>();
		//完善门诊信息
		for(int i=1;i<=7;i++){
			TDoctorClinicScheduleInfo info = new TDoctorClinicScheduleInfo(doctorId, doctorUserId, hospitalId);
			info.setClinicDay(i);
			list.add(info);
			info.setMoningLimit(5);
			info.setAfternoonLimit(5);
			info.setEveningLimit(5);
		}
		//比对门诊
		for(TDoctorClinicScheduleInfo sInfo:req.getClinicScheduleList()){
			//门诊时间比对
			TDoctorClinicScheduleInfo info = list.get(sInfo.getClinicDay()-1);
			if(!StringUtils.isEmpty(sInfo.getMoningSchedule())){//设置早上
				info.setMoningSchedule(sInfo.getMoningSchedule());
				if(sInfo.getMoningSchedule().indexOf("停诊")<0);
					info.setMoningSet(1);
			}
			if(!StringUtils.isEmpty(sInfo.getAfternoonSchedule())){//设置下午
				info.setAfternoonSchedule(sInfo.getAfternoonSchedule());
				if(sInfo.getAfternoonSchedule().indexOf("停诊")<0);
				info.setAfternoonSet(1);
			}
			if(!StringUtils.isEmpty(sInfo.getEveningSchedule())){//设置晚上
				info.setEveningSchedule(sInfo.getEveningSchedule());
				if(sInfo.getEveningSchedule().indexOf("停诊")<0);
				info.setEveningSet(1);
			}
		}
		for(TDoctorClinicScheduleInfo info:list)//保存
			doctorClinicDao.createDoctorClinicSchedule(info);
	}

	@Override
	public TDoctorClinicInfo getDoctorClinicScheduleInfo(Long doctorId) {
		// TODO Auto-generated method stub
		return doctorClinicDao.queryDoctorClinicScheduleInfo(doctorId); 
	}

	@Override
	public void invitePatientDoSomething(TDoctorInvitation doctorInvitation) {
		// TODO Auto-generated method stub
		if(doctorInvitation.getInviteType()!=3||doctorInvitation.getInviteType()!=31){
			String msg = null;
			switch (doctorInvitation.getInviteType()) {
			case 1:
				msg = "push.service.invite.patient.do.something.1";
				break;
			case 2:
				msg = "push.service.invite.patient.do.something.2";
				if(doctorInvitation.getDoctorId()!=null&&doctorInvitation.getDoctorId()==Constant.User.SuizhenSys){
					msg = "push.service.invite.patient.do.something.2.1";
				}
				break;
			case 4:
				msg = "push.service.invite.patient.do.something.4";
			default:
				break;
			}
			if(doctorInvitation.getPatients().length>0){
				Map<String,Object> params = new HashMap<String,Object>();
				params.put("pats", doctorInvitation.getPatients());
				for(PushUser user : dao.queryPatientUserByPatientIds(params)){
					Long userId = user.getUserId();
					String content = null;
					String url = wxH5Url;
					if(doctorInvitation.getInviteType()==4){
						url+=personal_disease;
					}else{
						url+=profile;
					}
					url+="?fromUserName="+user.getOpenId();
					content = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(msg, new Object[]{doctorInvitation.getDoctorName(),url}));
					PushNotifyInfo notify = PushUtil.getWxDataPushNotifyInfo(userId, content);
					PushNotifyUtil.setSendWxProductId(notify, user.getProductId());
					pushInnerService.push(notify);
				}
			}
		}
		//关注微信
		if(doctorInvitation.getInviteType()==3){
			//内容发送
			SmsTemplateSendReq req = SmsUtil.getSmsTemplateSendReq("YaoQingJiHuoGuanZhuWeiXin", null, null);
			req.getValues().add(doctorInvitation.getDoctorName());
			if(doctorInvitation.getPatients()!=null&&doctorInvitation.getPatients().length>0){
				Map<String,Object> params = new HashMap<String,Object>();
				params.put("pats", doctorInvitation.getPatients());
				for(String mobile : dao.queryPatientPhoneByPatientId(params)){
					req.setMobile(mobile);
					smsService.sendTemplate(req);
				}
			}else{
				return;
			}
		}
		//医生空间邀请患者关注微信
		if(doctorInvitation.getInviteType()==31){
			//内容发送
			SmsTemplateSendReq req = SmsUtil.getSmsTemplateSendReq("YiShengYaoQingGuanZhuWeiXin", null, null);
			req.getValues().add(doctorInvitation.getHospitalName());
			req.getValues().add(doctorInvitation.getDoctorName());
			if(doctorInvitation.getPatients()!=null&&doctorInvitation.getPatients().length>0){
				Map<String,Object> params = new HashMap<String,Object>();
				params.put("pats", doctorInvitation.getPatients());
				for(String mobile : dao.queryPatientPhoneByPatientId(params)){
					req.setMobile(mobile);
					smsService.sendTemplate(req);
				}
			}else{
				return;
			}
		}
	}
	
	@Override
	public boolean checkDoctorClinicUsage(DoctorClinicUsageSetReq req) {
		if(req.getClinicDate()==null||req.getClinicTime()==null||req.getClinicDay()==null||req.getPatientId()==null||req.getDoctorId()==null){//参数错误
			throw new EmptyParamExcption("param error,params:"+JsonUtil.toJson(req));
		}
		if(doctorClinicDao.queryDoctorClinicPatientUsageById(req)!=null){//门诊已存在
			throw new ObjectAlreadyExistExcption("patient usage doctor clinic exist,params:"+JsonUtil.toJson(req));
		}
		List<Object> list=  doctorClinicDao.getDoctorClinicUsage(req);
		if(list==null||list.size()==0)//对象不存在
			throw new EmptyObjectExcption("doctor clinit not exist:"+JsonUtil.toJson(req));
		TDoctorClinicScheduleInfo dcs = (TDoctorClinicScheduleInfo)list.get(0);
		int limit=0;
		int set=0;
		int usage=0;
		switch (req.getClinicTime()) {
		case 0:
			usage=dcs.getMoningUsage();
			limit=dcs.getMoningLimit();
			set=dcs.getMoningSet();
			break;
		case 1:
			usage=dcs.getAfternoonUsage();
			limit=dcs.getAfternoonLimit();
			set=dcs.getAfternoonSet();
			break;
		case 2:
			usage=dcs.getEveningUsage();
			limit=dcs.getEveningLimit();
			set=dcs.getEveningSet();
			break;
		}
		if(set==0)
			throw new EmptyObjectExcption("clinic close,params:"+JsonUtil.toJson(req));
		if(usage>=limit)
			throw new EmptyObjectExcption("clinic already expired,params:"+JsonUtil.toJson(req));
		usage++;
		switch(req.getClinicTime()){
			case 0:
				dcs.setMoningUsage(usage);
				break;
			case 1:
				dcs.setAfternoonUsage(usage);
				break;
			case 2:
				dcs.setEveningUsage(usage);
				break;
		}
		req.setMoningUsage(dcs.getMoningUsage());
		req.setAfternoonUsage(dcs.getAfternoonUsage());
		req.setEveningUsage(dcs.getEveningUsage());
		return true;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String setDoctorClinicUsage(DoctorClinicUsageSetReq req,TMsgResponse msg) {
		boolean flag = false;
		try{
			flag = this.checkDoctorClinicUsage(req);//检查加号信息	
		}catch(EmptyObjectExcption e){
			msg.respCode=ErrorMessage.E1404.code;
			msg.respMsg="门诊不存在";
			LogUtil.logError.error(e.getMessage());
		}catch(EmptyParamExcption e){
			msg.respCode=ErrorMessage.E1410.code;
			msg.respMsg="请求参数错误";
			LogUtil.logError.error(e.getMessage());
		}catch(ObjectAlreadyExistExcption e){
			msg.respCode=ErrorMessage.E1409.code;
			msg.respMsg="已加号或门诊已满";
			LogUtil.logError.error(e.getMessage());
		}
		if(flag){
			//设置门诊编号
			req.setId(GeneralUtil.generatorUUID("CLIN"));
			doctorClinicDao.createDoctorClinicScheduleUsage(req);
			//获取门诊编号
			req.setId(doctorClinicDao.getDoctorClinicUsageId(req));
			//创建患者门诊预约加号
			doctorClinicDao.createDoctorClinicPatientUsage(req);
			return req.getId();
		}
		return null;
	}

	@Override
	public TDoctorClinicInfo getDoctorClinicScheduleUsage(DoctorClinicUsageReq req) {
		// TODO Auto-generated method stub
		Long doctorId = null;
		if(req.getDoctorId()==null&&req.getDoctorUserId()!=null)
			doctorId = dao.queryDoctorIdByDoctorUserId(req.getDoctorUserId());
		else 
			doctorId=req.getDoctorId();
		TDoctorClinicInfo info = doctorClinicDao.queryDoctorClinicScheduleInfo(doctorId);
		if(info==null)
			return info;
		req.setWeek(0);
		List list=  doctorClinicDao.getDoctorClinicUsage(req);
		req.setWeek(1);
		List list1=  doctorClinicDao.getDoctorClinicUsage(req);
		list.addAll(list1);
		info.setDataList(list);
		return info;
	}

	@Override
	@Transactional
	public void followupReportApply(FollowupReportApplyReq req) {
		// TODO Auto-generated method stub
		if(req.getUserId()==null)
			throw new EmptyParamExcption("param error : doctor is null");
		if(StringUtils.isEmpty(req.getEmail()))
			throw new EmptyParamExcption("param error : email is null");
		if(!StringUtils.isEmpty(applyDao.queryFollowupReportByUserId(req)))
			throw new RemoteCallExcption("report not send  userId="+req.getUserId());
		req.setProductapplyId(GeneralUtil.generateUniqueID("APPLY"));
		if(applyDao.addFollowupReportApply(req)==0){
			throw new EmptyObjectExcption("insert followupReportApply error");
		}
	}

	@Override
	public void backClincUsage(DoctorClinicUsageSetReq req) {
		// TODO Auto-generated method stub
		if(req.getId()==null)
			req.setId(doctorClinicDao.queryDoctorClinicPatientUsageById(req));
		doctorClinicDao.deleteDoctorClinicPatientUsageById(req);
		doctorClinicDao
			.updateDoctorClinicScheduleUsageById(req);
	}
}
