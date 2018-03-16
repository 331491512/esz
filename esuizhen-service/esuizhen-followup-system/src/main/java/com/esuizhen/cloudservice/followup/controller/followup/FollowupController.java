package com.esuizhen.cloudservice.followup.controller.followup;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.followup.model.followup.FollowupPlanTemplate;
import com.esuizhen.cloudservice.followup.model.followup.TFollowupPlan;
import com.esuizhen.cloudservice.followup.model.followup.TFollowupPlanDetialInfo;
import com.esuizhen.cloudservice.followup.service.followup.FollowupService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
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
public class FollowupController
{
	/**
	 * 随访接口
	 */
	@Autowired
	private FollowupService followupService; 
	
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * @author wang_hw
	 * @title :createPlanTemplate
	 * @Description:创建随访计划模版
	 * @return String
	 * @date 2015年12月2日 下午7:11:31
	 */
	@ResponseBody
	@RequestMapping(value="/plan/template/create" , method=RequestMethod.POST)
	public TMsgResponse<String> createPlanTemplate(@RequestBody FollowupPlanTemplate template , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//创建随访计划模版
			followupService.createFollowupPlanTemplate(template);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/detail/query" , method=RequestMethod.GET)
	public TMsgResponse<TFollowupPlan> queryFollowupPlanDetailInfo(Long doctorId , Long patientId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<TFollowupPlan> msg = new TMsgResponse<TFollowupPlan>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//随访计划明细查看
			msg.result = followupService.queryFollowupPlanDetailInfo(doctorId, patientId);
			if(msg.result==null)
			{
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * @author wang_hw
	 * @title :deletePlanTemplate
	 * @Description:删除随访计划模版
	 * @return String
	 * @date 2015年12月2日 下午7:11:31
	 */
	@ResponseBody
	@RequestMapping(value="/plan/template/delete" , method=RequestMethod.GET)
	public TMsgResponse<String> deletePlanTemplate(String planTemplateId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//删除随访计划模版
			followupService.deleteFollowupPlanTemplate(planTemplateId);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * @author wang_hw
	 * @title :updatePlanTemplate
	 * @Description:删除随访计划模版
	 * @return String
	 * @date 2015年12月2日 下午7:11:31
	 */
	@ResponseBody
	@RequestMapping(value="/plan/template/update" , method=RequestMethod.POST)
	public TMsgResponse<String> updatePlanTemplate(@RequestBody FollowupPlanTemplate template , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//修改随访计划模版
			followupService.updateFollowupPlanTemplate(template);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 
	 * @author wang_hw
	 * @title :queryFollowupPlanDetail
	 * @Description:查看随访计划模版详情
	 * @return TMsgResponse<FollowupPlanTemplate>
	 * @date 2015年12月3日 下午6:22:55
	 */
	@ResponseBody
	@RequestMapping(value="/plan/template/query" , method=RequestMethod.GET)
	public TMsgResponse<FollowupPlanTemplate> queryFollowupPlanDetail(String planTemplateId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<FollowupPlanTemplate> msg = new TMsgResponse<FollowupPlanTemplate>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查看随访计划模版
			msg.result=followupService.queryFollowupPlanTemplate(planTemplateId);
			
			if(msg.result==null)
			{//如果为空
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 
	 * @author wang_hw
	 * @title :followupPlanTemplatePublicList
	 * @Description:查询公开的随访列表
	 * @return TMsgResponse<Page>
	 * @date 2015年12月10日 上午9:31:10
	 */
	@ResponseBody
	@RequestMapping(value="/plan/template/list" , method=RequestMethod.GET)
	public TMsgResponse<Page> followupPlanTemplatePublicList(String doctorId , Integer page , Integer num ,  Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page> msg = new TMsgResponse<Page>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查看公开的随访计划
			msg.result=followupService.selectFollowupPlanTemplate(doctorId , page , num);
			
			if(msg.result==null || msg.result.getCurrSize()==0)
			{//如果为空
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/patient/list" , method=RequestMethod.GET)
	public TMsgResponse<Page> followupPatientList(Long doctorId , Integer page , Integer num , Integer sortFlag , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page> msg = new TMsgResponse<Page>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查看我的随访患者
			msg.result=followupService.followupPatientList(doctorId , page , num , sortFlag);
			
			if(msg.result==null || msg.result.getCurrSize()==0)
			{//如果为空
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			ex.printStackTrace();
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * 获取复查提醒元数据
	 * @author lichenghao
	 * @title :followupReviewItemList
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2016年3月27日 下午6:56:07
	 */
	@ResponseBody
	@RequestMapping(value="/review/Item/list" , method=RequestMethod.GET)
	public TMsgResponse<Object> followupReviewItemList(Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//获取复查提醒元数据
			msg.result=followupService.followupReviewList();
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	/**
	* @author fanpanwei
	* @date 2017年8月22日
	* @param 
	* @description:更新随访计划（问卷用）
	* @return
	 */
	@ResponseBody
	@RequestMapping(value="/plan/update" , method=RequestMethod.POST)
	public TMsgResponse<Object> modifyFollowupPlanDetail(@RequestBody TFollowupPlanDetialInfo followupPlanDetialInfo,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			followupService.updateFollowupPlanDetail(followupPlanDetialInfo);
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}
