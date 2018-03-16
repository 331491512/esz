package com.westangel.timertask.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Semaphore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.timertask.Timertask;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PushNotifyUtil;
import com.westangel.common.util.PushUtil;
import com.westangel.timertask.dao.OpPushRuleConfDao;
import com.westangel.timertask.dao.TimertaskDao;
import com.westangel.timertask.model.OpPushQueryResult;
import com.westangel.timertask.model.OpPushResult;
import com.westangel.timertask.service.TimertaskService;

@Service
public class TimertaskServiceImpl implements TimertaskService , com.westangel.common.service.TimertaskService
{

	@Autowired
	private TimertaskDao dao;
	
	/**
	 * 线程互斥
	 */
	public static Semaphore semp = new Semaphore(1);
	
	@Autowired
	private OpPushRuleConfDao opPushRuleConfDao;
	
	@Autowired
	private PushInnerService pushService;
	
	@Value("${attention.wx.template.name}")
	private String attentionName;
	
	@Value("${article.page.path}")
	private String articlePath;
	
	@Value("${server.h5.url.root}")
	private String wxUrl;
	
	@Override
	public Integer createTimetask(Timertask timetask)
	{
		Integer respCode = ErrorMessage.SUCCESS.code;
		try 
		{
			timetask.setTimerTaskId(GeneralUtil.generatorTimeUUID());
			dao.insertTimetask(timetask);
		} catch (Exception e) {
			LogUtil.logError.error(e.getMessage());
			respCode = ErrorMessage.E1500.code;
		}
		
		return respCode;
	}

	@Override
	public Integer cancelTimetask(int  serviceType , String serviceTargetId , String taskTag)
	{
		Integer respCode = ErrorMessage.SUCCESS.code;
		try 
		{
			dao.deleteTimetaskByTargetId(serviceType , serviceTargetId , taskTag);
		} catch (Exception e) {
			LogUtil.logError.error(e.getMessage());
			respCode = ErrorMessage.E1500.code;
		}
		return respCode;
		
	}

	@Override
	public void updateTimetask(Timertask timetask)
	{
		dao.updateTimetask(timetask);
	}

	@Override
	public Timertask queryTimetaskById(String timetaskId)
	{
		return dao.queryTimetaskById(timetaskId);
	}

	@Override
	public List<Timertask> queryTimetaskByServiceType(String serviceType , Integer periodType , String serviceTargetId)
	{
		return dao.queryTimetaskByServiceType(serviceType,periodType,serviceTargetId);
	}

	@Override
	public String queryUserOpenId(String userId,Integer productId)
	{
		return dao.queryUserOpenId(userId,productId);
	}

	@Override
	public void deleteTimetask(String timetaskId)
	{
		dao.deleteTimetask(timetaskId);
	}

	@Override
	public List<Timertask> queryTimetaskByServiceTypes(String serviceTypes)
	{
		return dao.queryTimetaskByServiceTypes(serviceTypes);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Integer createTimetaskList(List<Timertask> taskList)
	{
		Integer respCode = ErrorMessage.SUCCESS.code;
		try 
		{
			if(taskList==null||taskList.size()==0)
				return respCode;
			for(Timertask task : taskList)
			{
				task.setTimerTaskId(GeneralUtil.generatorTimeUUID());
			}
			dao.insertTimetaskList(taskList);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.logError.error(e.getMessage());
			throw new RuntimeException();
		}
		
		return respCode;
	}

	@Override
	public void testPush(Long pushRuleId)
	{
		//查询推送列表
		List<OpPushQueryResult> pushList = opPushRuleConfDao.queryTestPushList(pushRuleId);
		
		List<OpPushResult> opPushResultList = new ArrayList<OpPushResult>();
		for(OpPushQueryResult opPushQueryResult : pushList)
		{
			//推送文章
			pushMessage(opPushQueryResult.getUserId() , opPushQueryResult.getTitle() , opPushQueryResult.getContent() , opPushQueryResult.getBak(), opPushQueryResult.getArticleId() , opPushQueryResult.getArticleTitle());
		}
		
	}
	
	public void pushMessage(Long userId , String title , String content , String bak , Integer articleId , String articleTitle)
	{
		LogUtil.log.info("推送文章开始:"+userId +","+title+","+content+","+bak+","+articleId);
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			List<String> list = new ArrayList<String>();
			list.add(title);
			list.add(sdf.format(new Date()));
			list.add(content);
			list.add(bak);
			PushNotifyInfo notify = PushUtil.getWxTemplatePushNotifyInfo(attentionName, wxUrl+articlePath+"?articleId="+articleId+"&title="+articleTitle, list);
			notify.setUserId(userId);
			PushNotifyUtil.setSendWxProductId(notify, null);
			pushService.push(notify);
		} catch (Exception e) {
			LogUtil.logError.error(e.getMessage());
		}
		LogUtil.log.info("推送文章结束:"+userId +","+title+","+content+","+bak+","+articleId);
	}

	@Override
	public boolean execProcedure(String procedureContent) {
		try{
			dao.callProcedure(procedureContent);
			return true;
		}catch(Exception e){
			LogUtil.logError.error("call procedure error,msg:{}",e.getMessage());
			return false;
		}
	}

}
