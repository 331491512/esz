/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.controller.business;<br/>  
 * <b>文件名：</b>BusinessController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月12日下午4:53:32<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.controller.business;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.business.bean.DoctorClinicScheduleSetReq;
import com.esuizhen.cloudservice.business.bean.DoctorClinicUsageReq;
import com.esuizhen.cloudservice.business.bean.DoctorClinicUsageSetReq;
import com.esuizhen.cloudservice.business.bean.DoctorSendFollowupNotifyReq;
import com.esuizhen.cloudservice.business.bean.DoctorSendKnowledgeArticleReq;
import com.esuizhen.cloudservice.business.bean.DoctorSendQuestionnarieReq;
import com.esuizhen.cloudservice.business.bean.DoctorSendReviewAlertReq;
import com.esuizhen.cloudservice.business.bean.FollowupReportApplyReq;
import com.esuizhen.cloudservice.business.bean.TDoctorAnnouncement;
import com.esuizhen.cloudservice.business.bean.TDoctorClinicInfo;
import com.esuizhen.cloudservice.business.bean.TDoctorInvitation;
import com.esuizhen.cloudservice.business.bean.TMsgResponse;
import com.esuizhen.cloudservice.business.model.business.TDoctorAnnouncementInfo;
import com.esuizhen.cloudservice.business.service.business.DoctorSendService;
import com.esuizhen.cloudservice.business.service.business.DoctorService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.ObjectAlreadyExistExcption;
import com.westangel.common.excption.RemoteCallExcption;
import com.westangel.common.util.LogUtil;

/**
 * @ClassName: BusinessController.java
 * @Description: 服务系统控制器
 * @author lichenghao
 * @date 2015年12月12日 下午4:53:32
 */
@Controller
public class BusinessDoctorServiceController {
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private DoctorSendService doctorSendService;
	
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	/**
	 * 医生发布公告
	 * @author lichenghao
	 * @title :publishDoctorAnnouncement
	 * @Description:医生发布公告
	 * @return TMsgResponse<String>
	 * @date 2015年12月12日 下午4:57:16
	 */
	@ResponseBody
	@RequestMapping(value = "/doctor/announcement/publish", method = RequestMethod.POST)
	public TMsgResponse<String>  publishDoctorAnnouncement(@RequestBody TDoctorAnnouncement TDoctorAnnouncement, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			//创建实体到库
			doctorService.publishDoctorAnnouncement(TDoctorAnnouncement);
			msg.respMsg = messageSource.getMessage("publish.success",null,locale);
		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1400, locale);
			msg.respMsg = messageSource.getMessage("publish.error",null,locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getDoctorAnnouncement
	 * @Description:获取医生当前公告
	 * @return TMsgResponse<String>
	 * @date 2015年12月12日 下午5:59:21
	 */
	@ResponseBody
	@RequestMapping(value = "/doctor/announcement/current", method = RequestMethod.GET)
	public TMsgResponse<TDoctorAnnouncementInfo> getDoctorAnnouncement(Long doctorId,Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TDoctorAnnouncementInfo> msg = new TMsgResponse<TDoctorAnnouncementInfo>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			//查看当前公告
			msg.result = doctorService.queryTDoctorAnnouncementInfoByDoctorId(doctorId);
		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1400, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :listDoctorAnnouncementHistory
	 * @Description:获取医生公告历史
	 * @return TMsgResponse<List<TDoctorAnnouncementInfo>>
	 * @date 2015年12月14日 上午10:04:44
	 */
	@ResponseBody
	@RequestMapping(value = "/doctor/announcement/history/list", method = RequestMethod.GET)
	public TMsgResponse<List<TDoctorAnnouncementInfo>> listDoctorAnnouncementHistory(Long doctorId,Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TDoctorAnnouncementInfo>> msg = new TMsgResponse<List<TDoctorAnnouncementInfo>>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			//查看历史公告
			msg.result = doctorService.queryTDoctorAnnouncementInfoListByDoctorId(doctorId);
		} catch (Exception e) {
			e.printStackTrace();
			setTmgResponseCode(msg, ErrorMessage.E1400, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :deleteDoctorAnnouncement
	 * @Description:医生删除公告
	 * @return TMsgResponse<Object>
	 * @date 2015年12月14日 下午2:27:11
	 */
	@ResponseBody
	@RequestMapping(value = "/doctor/announcement/delete", method = RequestMethod.POST)
	public TMsgResponse<String> deleteDoctorAnnouncement(@RequestBody TDoctorAnnouncement tDoctorAnnouncement,Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			//删除公告
			doctorService.deleteDoctorAnnouncementsByDoctorIdAndAnnouncements(tDoctorAnnouncement.getDoctorId(), tDoctorAnnouncement.getAnnouncements());
		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1400, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * 发送复查提醒
	 * @author lichenghao
	 * @title :sendDoctorReviewAlert
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2016年3月30日 下午6:53:11
	 */
	@ResponseBody
	@RequestMapping(value = "/doctor/send/review/alert", method = RequestMethod.POST)
	public TMsgResponse<Object>  sendDoctorReviewAlert(@RequestBody DoctorSendReviewAlertReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		msg.respMsg = messageSource.getMessage("send.success",null,locale);
		try {
			doctorSendService.sendDoctorReviewAlert(req);
		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1400, locale);
			msg.respMsg = messageSource.getMessage("send.error",null,locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :sendDoctorQuestionnaire
	 * @Description:随访问卷发送
	 * @return TMsgResponse<Object>
	 * @date 2016年9月29日 下午12:06:33
	 */
	@ResponseBody
	@RequestMapping(value = "/doctor/send/questionnaire", method = RequestMethod.POST)
	public TMsgResponse<Object>  sendDoctorQuestionnaire (@RequestBody DoctorSendQuestionnarieReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		msg.respMsg = messageSource.getMessage("send.success",null,locale);
		try {
			doctorSendService.sendDoctorQuestionnaire(req);
		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1400, locale);
			msg.respMsg = messageSource.getMessage("send.error",null,locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :sendDoctorKnowledgeArticlet
	 * @Description:患教知识发送
	 * @return TMsgResponse<Object>
	 * @date 2016年9月29日 下午12:05:03
	 */
	@ResponseBody
	@RequestMapping(value = "/doctor/send/knowledge/article", method = RequestMethod.POST)
	public TMsgResponse<Object>  sendDoctorKnowledgeArticlet(@RequestBody DoctorSendKnowledgeArticleReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		msg.respMsg = messageSource.getMessage("send.success",null,locale);
		try {
			doctorSendService.sendDoctorKnowledgeArticlet(req);
		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1400, locale);
			msg.respMsg = messageSource.getMessage("send.error",null,locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 随访通知发送
	 * @author lichenghao
	 * @title :sendFollowupNotifySend
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2016年5月26日 下午3:16:16
	 */
	@ResponseBody
	@RequestMapping(value = "/doctor/followup/notify/send", method = RequestMethod.POST)
	public TMsgResponse<Object>  sendFollowupNotifySend(@RequestBody DoctorSendFollowupNotifyReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		msg.respMsg = messageSource.getMessage("send.success",null,locale);
		try {
			doctorSendService.sendDoctorFollowupNotifySend(req);
		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1400, locale);
			msg.respMsg = messageSource.getMessage("send.error",null,locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	/**
	 * 
	 * @author lichenghao
	 * @title :setDoctorClinicSchedule
	 * @Description:医生出诊时间设置
	 * @return TMsgResponse<String>
	 * @date 2015年12月14日 下午3:56:57
	 */
	@ResponseBody
	@RequestMapping(value = "/doctor/clinic/schedule/set", method = RequestMethod.POST)
	public TMsgResponse<String> setDoctorClinicSchedule(@RequestBody DoctorClinicScheduleSetReq req ,Locale locale) {
		TMsgResponse<String> msg = new TMsgResponse<String>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			doctorService.setDoctorClinicSchedule(req);
			msg.respMsg = messageSource.getMessage("set.success",null,locale);
		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1400, locale);
			msg.respMsg = messageSource.getMessage("set.error",null,locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 医生出诊时间获取
	 * @author lichenghao
	 * @title :getDoctorClinicSchedule
	 * @Description:TODO
	 * @return TMsgResponse<List<TDoctorClinicScheduleInfo>>
	 * @date 2015年12月14日 下午4:03:03
	 */
	@ResponseBody
	@RequestMapping(value = "/doctor/clinic/schedule/get", method = RequestMethod.GET)
	public TMsgResponse<TDoctorClinicInfo> getDoctorClinicSchedule(Long doctorId,Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TDoctorClinicInfo> msg = new TMsgResponse<TDoctorClinicInfo>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			msg.result = doctorService.getDoctorClinicScheduleInfo(doctorId);
		} catch (Exception e) {
			e.printStackTrace();
			setTmgResponseCode(msg, ErrorMessage.E1400, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 医生出诊预约情况获取
	 * @author lichenghao
	 * @title :getDoctorClinicUsage
	 * @Description:TODO
	 * @return TMsgResponse<TDoctorClinicInfo>
	 * @date 2016年1月18日 下午6:09:00
	 */
	@ResponseBody
	@RequestMapping(value = "/doctor/clinic/usage/get", method = RequestMethod.GET)
	public TMsgResponse<TDoctorClinicInfo> getDoctorClinicUsage(DoctorClinicUsageReq req,Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TDoctorClinicInfo> msg = new TMsgResponse<TDoctorClinicInfo>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			msg.result = doctorService.getDoctorClinicScheduleUsage(req);
		} catch (Exception e) {
			e.printStackTrace();
			setTmgResponseCode(msg, ErrorMessage.E1400, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * 预约挂号设置
	 * @author lichenghao
	 * @title :setDoctorClinicUsage
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2016年1月18日 下午6:10:30
	 */
	@ResponseBody
	@RequestMapping(value = "/doctor/clinic/usage/set", method = RequestMethod.POST)
	public TMsgResponse<String> setDoctorClinicUsage(@RequestBody DoctorClinicUsageSetReq doctorClinicUsageSetReq,Locale locale) {
		TMsgResponse<String> msg = new TMsgResponse<String>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			msg.result = doctorService.setDoctorClinicUsage(doctorClinicUsageSetReq,msg);
		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	/**
	 * 
	 * @author lichenghao
	 * @title :setDoctorClinicUsage
	 * @Description:预约门诊挂号检查
	 * @return TMsgResponse<String>
	 * @date 2017年8月29日 上午11:02:58
	 */
	@ResponseBody
	@RequestMapping(value = "/doctor/clinic/check", method = RequestMethod.POST)
	public TMsgResponse<String> checkDoctorClinic (@RequestBody DoctorClinicUsageSetReq doctorClinicUsageSetReq,Locale locale) {
		TMsgResponse<String> msg = new TMsgResponse<String>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			doctorService.checkDoctorClinicUsage(doctorClinicUsageSetReq);
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
		}catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 医生邀请患者上传病历\开启随访计划\关注微信等
	 * @author lichenghao
	 * @title :invitePatientDoSomething
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2015年12月14日 下午4:18:36
	 */
	@ResponseBody
	@RequestMapping(value = "/doctor/invite/patient/do/something", method = RequestMethod.POST)
	public TMsgResponse<String> invitePatientDoSomething(@RequestBody TDoctorInvitation doctorInvitation,Locale locale) {
		TMsgResponse<String> msg = new TMsgResponse<String>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			//医生邀请患者上传病历\开启随访计划\关注微信等
			/**消息发送接口*/
			doctorService.invitePatientDoSomething(doctorInvitation);
			if(doctorInvitation.getInviteType()==3){
				msg.respMsg = messageSource.getMessage("sms.msg.send.success",null, locale);
			}
		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1400, locale);
			if(doctorInvitation.getInviteType()==3){
				msg.respMsg = messageSource.getMessage("sms.msg.send.error",null, locale);
			}
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 随访报告发送
	 * @author lichenghao
	 * @title :applyFollowupReport
	 * @Description:TODO
	 * @return TMsgResponse<TDoctorStatisProfile>
	 * @date 2016年5月27日 下午6:51:03
	 */
	@ResponseBody
	@RequestMapping(value="/doctor/followup/report/apply",method=RequestMethod.POST)
	public TMsgResponse<String> applyFollowupReport(@RequestBody FollowupReportApplyReq req,Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			doctorService.followupReportApply(req);
		}catch(EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause()+"\t"+ex.getMessage());
			msg.setRespCode(ErrorMessage.E1419.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1419.info, null, locale));
		}catch(RemoteCallExcption ex){
			LogUtil.logError.error(ex.getCause()+"\t"+ex.getMessage());
			msg.setRespCode(ErrorMessage.E140902.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E140902.info, null, locale));
		}catch(EmptyObjectExcption ex){
			LogUtil.logError.error(ex.getCause()+"\t"+ex.getMessage());
			msg.setRespCode(ErrorMessage.E1417.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
		}catch(Exception ex){
			LogUtil.logError.error(ex.getCause()+"\t"+ex.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :setTmgResponseCode
	 * @Description:返回编码消息封装
	 * @return void
	 * @date 2015年12月13日 上午11:27:30
	 */
	public void setTmgResponseCode(TMsgResponse msg, ErrorMessage error, Locale locale) {
		msg.setCodeAndrespMsg(error.code, messageSource.getMessage(error.info, null, locale));
	}
	
}
