package com.esuizhen.cloudservice.followup.controller.followup;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.followup.bean.FollowupTaskPatientReq;
import com.esuizhen.cloudservice.followup.bean.FollowupTaskScreenPatientReq;
import com.esuizhen.cloudservice.followup.bean.FollowupTaskSeniorScreenPatientReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupPatientStatisInfo;
import com.esuizhen.cloudservice.followup.service.followup.FollowupPatientService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
 * 
* @ClassName: FollowupController 
* @Description: 随访计划控制器
* @author wang_hw
* @date 2015年12月2日 下午6:18:25
 */
@Controller
public class FollowupPatientController
{
	/**
	 * 随访患者查询接口类
	 */
	@Autowired
	private FollowupPatientService followupPatientService;

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getFollowupTaskPatientList
	 * @Description:患者常规检索
	 * @return TMsgResponse<TFollowupPatientStatisInfo>
	 * @date 2016年8月11日 上午7:32:19
	 */
	@ResponseBody
	@RequestMapping(value="/task/screen/patient/list",method=RequestMethod.POST)
	public TMsgResponse<TFollowupPatientStatisInfo> getFollowupTaskPatientList(@RequestBody FollowupTaskPatientReq req,Locale locale){
		TMsgResponse<TFollowupPatientStatisInfo> msg = new TMsgResponse<TFollowupPatientStatisInfo>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			msg.result = followupPatientService.getFollowupTaskPatientList(req);
		}catch(Exception e){
			e.printStackTrace();
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getFollowupTaskSeniorScreenPatientList
	 * @Description:患者高级检索
	 * @return TMsgResponse<TFollowupPatientStatisInfo>
	 * @date 2016年8月11日 上午7:32:40
	 */
	@ResponseBody
	@RequestMapping(value="/task/senior/screen/patient/list",method=RequestMethod.POST)
	public TMsgResponse<TFollowupPatientStatisInfo> getFollowupTaskSeniorScreenPatientList(@RequestBody FollowupTaskSeniorScreenPatientReq req,Locale locale){
		TMsgResponse<TFollowupPatientStatisInfo> msg = new TMsgResponse<TFollowupPatientStatisInfo>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			msg.result = followupPatientService.getFollowupTaskSeniorScreenPatientList(req);
		}catch(Exception e){
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 
	 * @author raox
	 * @title :getFollowupTaskPatientList
	 * @Description:按全部患者查询条件筛选随访任务
	 * @return TMsgResponse<TFollowupPatientStatisInfo>
	 * @date 2016年8月11日 上午7:32:19
	 */
	@ResponseBody
	@RequestMapping(value="/task/screen/patient/search",method=RequestMethod.POST)
	public TMsgResponse<TFollowupPatientStatisInfo> getFollowupTaskScreenPatientBySearch(@RequestBody FollowupTaskScreenPatientReq req,Locale locale){
		TMsgResponse<TFollowupPatientStatisInfo> msg = new TMsgResponse<TFollowupPatientStatisInfo>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			msg.result = followupPatientService.getFollowupTaskPatientList(req);
		}catch(Exception e){
			e.printStackTrace();
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 多条件筛选任务患者
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/task/overlap/screen/patient/list",method=RequestMethod.POST)
	public TMsgResponse<TFollowupPatientStatisInfo> getFollowupTaskPatientListWithOverlap(@RequestBody FollowupTaskPatientReq req,Locale locale){
		TMsgResponse<TFollowupPatientStatisInfo> msg = new TMsgResponse<TFollowupPatientStatisInfo>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			msg.result = followupPatientService.getFollowupTaskPatientListWithOverlap(req);
		}catch(Exception e){
			e.printStackTrace();
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
}
