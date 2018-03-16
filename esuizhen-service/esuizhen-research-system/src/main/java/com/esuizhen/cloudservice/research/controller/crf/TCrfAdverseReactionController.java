package com.esuizhen.cloudservice.research.controller.crf;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.research.model.crf.TCrfAdverseReaction;
import com.esuizhen.cloudservice.research.model.crf.TCrfAdverseReactionInfo;
import com.esuizhen.cloudservice.research.service.crf.TCrfAdverseReactionService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
* @ClassName: TCrfAdverseReactionController 
* @Description: CRF-观察项-不良反映控制器
* @author wang_hw
* @date 2016年4月15日 下午6:20:23
 */
@Controller
public class TCrfAdverseReactionController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TCrfAdverseReactionService crfAdverseReactionService; 
	
	/**
	 * @author wang_hw
	 * @title :queryCrfAdverseReaction
	 * @Description:CRF-观察项-不良反映查看
	 * @return TMsgResponse<TCrfAdverseReactionInfo>
	 * @date 2016年4月15日 下午6:29:51
	 */
	@ResponseBody
	@RequestMapping(value="/crf/adverse/reaction/query" , method=RequestMethod.GET)
	public TMsgResponse<List<TCrfAdverseReactionInfo>> queryCrfAdverseReaction(String crfObserveId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TCrfAdverseReactionInfo>> msg = new TMsgResponse<List<TCrfAdverseReactionInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = crfAdverseReactionService.queryCrfAdverseReaction(crfObserveId);
			
			if(msg.result==null || msg.result.size()<1)
			{
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * @author wang_hw
	 * @title :saveCrfAdverseReaction
	 * @Description:CRF-观察项-不良反映设置
	 * @return TMsgResponse<String>
	 * @date 2016年4月15日 下午6:31:00
	 */
	@ResponseBody
	@RequestMapping(value="/crf/adverse/reaction/save" , method=RequestMethod.POST)
	public TMsgResponse<String> saveCrfAdverseReaction(@RequestBody TCrfAdverseReaction crfAdverseReaction , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//创建
			crfAdverseReactionService.saveCrfAdverseReaction(crfAdverseReaction);
			
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

