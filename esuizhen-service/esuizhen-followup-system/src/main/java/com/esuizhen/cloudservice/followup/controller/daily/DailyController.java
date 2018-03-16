package com.esuizhen.cloudservice.followup.controller.daily;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.followup.model.daily.DailyInfo;
import com.esuizhen.cloudservice.followup.model.daily.FollowupDailyListReq;
import com.esuizhen.cloudservice.followup.model.daily.FollowupDailyStatisResultQueryReq;
import com.esuizhen.cloudservice.followup.service.daily.DailyService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

/**
 * 
* @ClassName: FollowupController 
* @Description: 随访统计控制器
* @author wang_hw
* @date 2015年12月2日 下午6:18:25
 */
@Controller
public class DailyController
{
	/**
	 * 统计接口
	 */
	@Autowired
	private DailyService dailyService; 
	
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	
	/**
	 * 日报计划发送
	 * @author lichenghao
	 * @title :sendFollowupDailyStatisToDoctor
	 * @Description:TODO
	 * @return TMsgResponse<TStatisResult>
	 * @date 2016年2月4日 下午5:58:11
	 */
	@ResponseBody
	@RequestMapping(value="/daily/statis/send/todoctor" , method=RequestMethod.GET)
	public TMsgResponse sendFollowupDailyStatisToDoctor(Long doctorId,Locale locale)
	{
		TMsgResponse msg = new TMsgResponse();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			RunSendDailyInfo();
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1417.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	private void RunSendDailyInfo(){
		ExecutorService exec = Executors.newFixedThreadPool(1);
		Runnable run = new Runnable(){
			@Override
			public void run()
			{
				dailyService.sendDailyInfo(null);
			}
		};
		exec.execute(run);
	}
	
	/**
	 * 随访日报统计
	 * @author lichenghao
	 * @title :queryDailyStatisResult
	 * @Description:TODO
	 * @return TMsgResponse
	 * @date 2016年5月26日 上午11:47:24
	 */
	@ResponseBody
	@RequestMapping(value="/daily/statis/result/query" , method=RequestMethod.GET)
	public TMsgResponse queryDailyStatisResult(FollowupDailyStatisResultQueryReq req,Locale locale){
		TMsgResponse msg = new TMsgResponse();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			msg.result = dailyService.queryDailyStaticResult(req);
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1417.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * 随访日报列表获取
	 * @author lichenghao
	 * @title :getDailyInfoList
	 * @Description:TODO
	 * @return TMsgResponse<Page<DailyInfo>>
	 * @date 2016年5月26日 上午11:51:28
	 */
	@ResponseBody
	@RequestMapping(value="/daily/statis/result/list" , method=RequestMethod.GET)
	public TMsgResponse<Page<DailyInfo>> getDailyInfoList(FollowupDailyListReq req,Locale locale){
		TMsgResponse<Page<DailyInfo>> msg = new TMsgResponse<Page<DailyInfo>>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			msg.result = dailyService.getDailyInfoList(req);
		}catch(EmptyParamExcption e){
			msg.setRespCode(ErrorMessage.E1419.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1419.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	
}
