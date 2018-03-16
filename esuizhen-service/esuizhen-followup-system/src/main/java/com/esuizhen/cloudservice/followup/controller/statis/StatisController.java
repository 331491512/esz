package com.esuizhen.cloudservice.followup.controller.statis;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.followup.model.statis.TStatisResult;
import com.esuizhen.cloudservice.followup.service.statis.StatisService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
 * 
* @ClassName: FollowupController 
* @Description: 随访统计控制器
* @author wang_hw
* @date 2015年12月2日 下午6:18:25
 */
@Controller
public class StatisController
{
	/**
	 * 统计接口
	 */
	@Autowired
	private StatisService statisService; 
	
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	
	@ResponseBody
	@RequestMapping(value="/statis/result/query" , method=RequestMethod.GET)
	public TMsgResponse<TStatisResult> queryFollowupStatisResult(@RequestParam(defaultValue="SUR") String dataType , String doctorId ,String confirmedDateBegin ,String confirmedDateEnd , String diseaseTypeIds, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<TStatisResult> msg = new TMsgResponse<TStatisResult>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查看我的随访患者
			if("SUR".equals(dataType)||"SurvivalRate".equals(dataType))
			{
				msg.result=statisService.querySURStatisResult(doctorId, confirmedDateBegin, confirmedDateEnd, diseaseTypeIds);
			}
			
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
}
