/**
 * 
 */
package com.esuizhen.cloudservice.followup.controller.meta;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskDetailInfo;
import com.esuizhen.cloudservice.followup.model.meta.FollowupOperatorInfo;
import com.esuizhen.cloudservice.followup.model.meta.FollowupResultValue;
import com.esuizhen.cloudservice.followup.model.meta.FollowupWay;
import com.esuizhen.cloudservice.followup.service.meta.FollowupMetaInfoService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
 * 元数据相关接口
 * @author DaLoong
 * @date  2016-8-13 上午10:48:12
 */
@Controller
public class FollowupMetaInfoController {

	@Autowired
	private FollowupMetaInfoService metaInfoService;
	
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	/**
	 * 随访人员元数据
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/operator/list" , method=RequestMethod.GET)
	public TMsgResponse<List<FollowupOperatorInfo>> getFollowupOperatorList(Integer hospitalId,String followupTaskId, Long doctorId, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<FollowupOperatorInfo>> msg = new TMsgResponse<List<FollowupOperatorInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//随访人员
			msg.result = metaInfoService.getFollowupOperatorList(hospitalId,followupTaskId, doctorId);
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
	 * 随访结果元数据
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/followupresultvalue/list" , method=RequestMethod.GET)
	public TMsgResponse<List<FollowupResultValue>> getMetaInfoFollowupResultValueList(Integer type, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<FollowupResultValue>> msg = new TMsgResponse<List<FollowupResultValue>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//随访结果元数据
			msg.result = metaInfoService.getMetaInfoFollowupResultValueList(type);
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
	 * 随访方式元数据
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/followupway/list" , method=RequestMethod.GET)
	public TMsgResponse<List<FollowupWay>> getMetaInfoFollowupWayList(Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<FollowupWay>> msg = new TMsgResponse<List<FollowupWay>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//随访方式元数据
			msg.result = metaInfoService.getMetaInfoFollowupWayList();
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
}
