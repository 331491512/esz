package com.westangel.timertask.job;

import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.timertask.Timertask;
import com.westangel.common.service.MessageInnerService;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.service.SmsInnerService;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PushNotifyUtil;
import com.westangel.common.util.PushUtil;
import com.westangel.timertask.common.TaskAbstract;
import com.westangel.timertask.dao.OpPushResultDao;
import com.westangel.timertask.dao.OpPushResultQueueDao;
import com.westangel.timertask.dao.OpPushRuleConfDao;
import com.westangel.timertask.model.OpPushQueryResult;
import com.westangel.timertask.model.OpPushResult;
import com.westangel.timertask.model.OpPushResultQueue;
import com.westangel.timertask.model.OpPushRuleConf;
import com.westangel.timertask.service.TimertaskService;
import com.westangel.timertask.util.TaskUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class DayJob extends TaskAbstract
{

	@Autowired
	private TimertaskService service;
	
	@Autowired
	private PushInnerService pushService;
	
	@Autowired
	private SmsInnerService smsInnerService;
	
	@Autowired
	private MessageInnerService messageInnerService;
	
	@Autowired
	private OpPushRuleConfDao opPushRuleConfDao;
	
	@Autowired
	private OpPushResultDao opPushResultDao;
	
	@Autowired
	private OpPushResultQueueDao opPushResultQueueDao;
	
	@Value("${server.api.url.root}")
	private String urlRoot;
	
	@Value("${attention.wx.template.name}")
	private String attentionName;
	
	@Value("${article.page.path}")
	private String articlePath;
	
	@Value("${server.h5.url.root}")
	private String wxUrl;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
	private SimpleDateFormat sdfYear = new SimpleDateFormat("yyyyMMdd");
	@Override
	@Scheduled(cron="${timer.day.timer}")
	public void job()
	{
		List<Timertask> taskList = new ArrayList<Timertask>();
		LogUtil.log.info("任务获取扫描(天)");
		taskList.addAll(service.queryTimetaskByServiceType(null , 1 , null));
		LogUtil.log.info("任务获取扫描(周)");
		taskList.addAll(service.queryTimetaskByServiceType(null , 2 , null));
		LogUtil.log.info("任务获取扫描(月)");
		taskList.addAll(service.queryTimetaskByServiceType(null , 3 , null));
		LogUtil.log.info("任务获取扫描(年)");
		taskList.addAll(service.queryTimetaskByServiceType(null , 4 , null));
		//循环任务
		for(int i=0; i<taskList.size(); i++)
		{//任务执行
			Timertask timetask = taskList.get(i);
			
			//成功失败标志
			boolean flag = false;
			
			if(getDateNum(new Date())>=getDateNum(timetask.getTime()) && timetask.getRetry()==0)
			{
				TaskUtil.service=this.service;
				flag = TaskUtil.execTask(timetask , pushService , smsInnerService , messageInnerService, service.queryUserOpenId(timetask.getUserId(),timetask.getWxProductId()) , urlRoot);
			}
			else
			{
//				if(getDateNum(new Date())<getDateNum(timetask.getTime()) && timetask.getRetry()!=0)
//				{
//					timetask.setRetry(0);
//					service.updateTimetask(timetask);
//				}
				continue;
			}
			
			//执行完成记录
			if(flag&&1==timetask.getTaskType())
			{//如果为临时任务则删除
				service.deleteTimetask(timetask.getTimerTaskId());
			}else if(flag&&2==timetask.getTaskType())
			{//如果为永久任务执行成功则记录执行成功数
//				timetask.setRetry(1);
				service.updateTimetask(timetask);
			}
			
		}
	}
	
	
	@Scheduled(cron="${timer.push.timer}")
	public void push()
	{
		LogUtil.log.info("任务开始扫描(精准推送)");
		try
		{
			//查询正在启用的规则配置列表
			List<OpPushRuleConf> opPushRuleConfList = opPushRuleConfDao.queryOpPushRuleConfList();
			for(OpPushRuleConf opPushRuleConf : opPushRuleConfList)
			{
				//根据最后执行日期和执行周期计算出下次执行日期
				Integer nextDayTime = Integer.parseInt(sdfYear.format(addDate(opPushRuleConf.getLastTime() , opPushRuleConf.getPushCycle())));
				Integer currentDayTime = Integer.parseInt(sdfYear.format(new Date()));
				
				//当前时间与执行时间到小时
				Integer currentTimeNum = getDateNum(new Date());
				Integer execTimeNum = getDateNum(opPushRuleConf.getPushTime());
				
				if(currentTimeNum<execTimeNum||currentDayTime < nextDayTime)
				{
					LogUtil.log.info("未到执行时间跳过:"+"nextDayTime:"+nextDayTime+"currentDayTime:"+currentDayTime+"execTimeNum:"+execTimeNum+"currentTimeNum:"+currentTimeNum);
					continue;
					
				}
				if(opPushRuleConf.getIsLoop()==0)
				{//循环处理
					//查询推送信息
					List<OpPushQueryResult> opPushQueryResultList = opPushRuleConfDao.queryPushCircleList(opPushRuleConf.getPushRuleId());
					List<OpPushResult> opPushResultList = new ArrayList<OpPushResult>();

					for(OpPushQueryResult opPushQueryResult : opPushQueryResultList)
					{
						try{
							//初始化推送队列
							initPushResultQueue(opPushQueryResult);
							//获取本次要推送的文章
							List<Integer> pushArticle=getNowPushAtricleId(opPushRuleConf,opPushQueryResult);
							//获取推送列表
							List<OpPushQueryResult> pushList=opPushRuleConfDao.queryPushArticleList(pushArticle,opPushRuleConf.getPushRuleId(),opPushQueryResult.getPatientId());

							this.recordPushResultQueue(opPushQueryResult.getPushAtricleIdJson(),opPushQueryResult.getAllPushArticleIdJson(),opPushQueryResult,opPushQueryResult.getPushResultQueueId());

							for(OpPushQueryResult pushQueryResult : pushList)
							{
								//推送文章
								pushMessage(pushQueryResult.getUserId() , opPushRuleConf.getTitle() , opPushRuleConf.getContent() , opPushRuleConf.getBak(), pushQueryResult.getArticleId(), pushQueryResult.getArticleTitle(),opPushRuleConf.getIsUseTitle());

								if(pushQueryResult.getPushTimes()==null)
									productPushResult(opPushResultList , pushQueryResult ,1);
								else
									productPushResult(opPushResultList , pushQueryResult ,pushQueryResult.getPushTimes()+1);
							}
						}catch(Exception e){
							LogUtil.logError.error(e.getMessage());
						}
						/*这块的业务逻辑有问题
						//最新文章列表
						List<Integer> newPushList = new ArrayList<Integer>();
						Set<Integer> newPushSet = new HashSet<Integer>();
						
						getNewPushList(opPushQueryResult.getNewPushArticleId(), newPushList  , newPushSet); 
						
						//已推送列表、推送队列
						List<Integer> pushList = null;
						List<Integer> allPushList = null;
						
						//全部推送文章队列
						if(StringUtils.isEmpty(opPushQueryResult.getAllPushArticleIdJson()))
						{
							pushList = new ArrayList<Integer>();
							pushList.add(newPushList.get(0));
							allPushList = newPushList;
							
							//记录推送队列
							recordPushResultQueue(pushList , allPushList ,opPushQueryResult , null );
							
							//推送文章
							opPushQueryResult.setArticleId(pushList.get(0));
							isPushFinish(opPushRuleConf , opPushQueryResult , pushList.get(0));
							pushMessage(opPushQueryResult.getUserId() , opPushRuleConf.getTitle() , opPushRuleConf.getContent() , opPushRuleConf.getBak(), pushList.get(0), null,opPushRuleConf.getIsUseTitle());
						}else
						{
							
							pushList =JsonUtil.toList(opPushQueryResult.getPushAtricleIdJson());
							allPushList = JsonUtil.toList(opPushQueryResult.getAllPushArticleIdJson());
							
							//执行推送逻辑
							execCirclePush(pushList , allPushList ,opPushRuleConf , opPushQueryResult ,newPushSet , newPushList);
							
						}*/

						//组装推送日志
						//if(opPushQueryResult.getPushTimes()==null)
						//{
						//	productPushResult(opPushResultList , opPushQueryResult ,1);
						//}else if(opPushQueryResult.getPushTimes()!=null &&opPushQueryResult.getPushTimes()<opPushRuleConf.getPushArticleMaxNum())
						//{
						//	productPushResult(opPushResultList , opPushQueryResult ,opPushQueryResult.getPushTimes()+1);
						//}
						
					}
					
					//记录推送日志
					recordPushResult(opPushResultList);
				}else
				{//单次处理
					//查询推送列表
					List<OpPushQueryResult> pushList = opPushRuleConfDao.queryPushList(opPushRuleConf);
					
					List<OpPushResult> opPushResultList = new ArrayList<OpPushResult>();
					for(OpPushQueryResult opPushQueryResult : pushList)
					{
						if(opPushQueryResult.getPushResultId()==null){
							//推送文章
							pushMessage(opPushQueryResult.getUserId() , opPushRuleConf.getTitle() , opPushRuleConf.getContent() , opPushRuleConf.getBak(), opPushQueryResult.getArticleId(), opPushQueryResult.getArticleTitle(),opPushRuleConf.getIsUseTitle());
							productPushResult(opPushResultList , opPushQueryResult ,1);
						}
					}
					recordPushResult(opPushResultList);
				}
				
				//修改推送配置
				//opPushRuleConf.setLastTime(addDate(opPushRuleConf.getLastTime() , opPushRuleConf.getPushCycle()));
				opPushRuleConf.setLastTime(new Date());
				opPushRuleConfDao.updateOpPushRuleConf(opPushRuleConf);
			}
		}catch(Exception ex)
		{
			LogUtil.logError.error("任务结束扫描异常结束"+ex.getMessage());
			ex.printStackTrace();
		}
		
		LogUtil.log.info("任务结束扫描(精准推送)");
	}

	/**
	 * 初始化全部推送队列和已推送队列
	 * @param opPushQueryResult
	 */
	private void initPushResultQueue(OpPushQueryResult opPushQueryResult) {
		String newPushArticle=opPushQueryResult.getNewPushArticleId();
		if(!StringUtils.isBlank(newPushArticle)){
			opPushQueryResult.setAllPushArticleIdJson("["+newPushArticle+"]");
			//去除已推送队列中不匹配的文章
			removePushAtricleByNewPushArticle(opPushQueryResult);
		}else{
			//没有文章则清除
			opPushQueryResult.setAllPushArticleIdJson(newPushArticle);
			opPushQueryResult.setPushAtricleIdJson(newPushArticle);
		}
	}

	/**
	 * 获取本次要推送的文章
	 * @param opPushRuleConf
	 * @param opPushQueryResult
	 */
	private List<Integer> getNowPushAtricleId(OpPushRuleConf opPushRuleConf,OpPushQueryResult opPushQueryResult) {
		String[] newPushArray = opPushQueryResult.getNewPushArticleId().split(",");
		List<Integer> pushList=new ArrayList<>();
		boolean judge=false;
		if(!StringUtils.isBlank(opPushQueryResult.getPushAtricleIdJson())){
			List<Integer> pushAtricleId=JsonUtil.toList(opPushQueryResult.getPushAtricleIdJson());
			if(pushAtricleId!=null&&pushAtricleId.size()>0){
				//移除已推送的文章
				List<Integer> allPushAtricleId=new ArrayList<>();
				for (String newPush : newPushArray) {
					boolean result=true;
					for (Integer push : pushAtricleId){
						if(push.equals(Integer.valueOf(newPush)))
							result=false;
					}
					if(result)
						allPushAtricleId.add(Integer.valueOf(newPush));
				}
				if(opPushRuleConf.getPushArticleMaxNum()>=newPushArray.length){
					for (int i = 0; i < newPushArray.length; i++)
						pushList.add(Integer.valueOf(newPushArray[i]));
					opPushQueryResult.setPushAtricleIdJson(JsonUtil.toJson(new ArrayList<>()));
				}else{
					if(newPushArray.length>(pushAtricleId.size()+opPushRuleConf.getPushArticleMaxNum())){
						for (int i = 0; i < opPushRuleConf.getPushArticleMaxNum(); i++) {
							pushList.add(allPushAtricleId.get(i));
						}
						pushAtricleId.addAll(pushList);
						opPushQueryResult.setPushAtricleIdJson(JsonUtil.toJson(pushAtricleId));
					}else if(newPushArray.length==(pushAtricleId.size()+opPushRuleConf.getPushArticleMaxNum())){
						for (int i = 0; i < opPushRuleConf.getPushArticleMaxNum(); i++) {
							pushList.add(allPushAtricleId.get(i));
						}
						opPushQueryResult.setPushAtricleIdJson(JsonUtil.toJson(new ArrayList<>()));
					}else{
						int size=opPushRuleConf.getPushArticleMaxNum()-(newPushArray.length-pushAtricleId.size());
						for (int i = 0; i < size; i++) {
							pushList.add(Integer.valueOf(newPushArray[i]));
						}
						opPushQueryResult.setPushAtricleIdJson(JsonUtil.toJson(pushList));
						pushList.addAll(allPushAtricleId);
					}
				}
			}else {
				judge=true;
			}
		}else{
			judge=true;
		}
		if(judge){
			int size=newPushArray.length>opPushRuleConf.getPushArticleMaxNum()?opPushRuleConf.getPushArticleMaxNum():newPushArray.length;
			for (int i = 0; i < size; i++) {
				pushList.add(Integer.valueOf(newPushArray[i]));
			}
			opPushQueryResult.setPushAtricleIdJson(JsonUtil.toJson(pushList));
		}
		return pushList;
	}

	/**
	 * 去除已推送队列中不匹配的文章
	 * @param opPushQueryResult
	 */
	private void removePushAtricleByNewPushArticle(OpPushQueryResult opPushQueryResult) {

		if(!StringUtils.isBlank(opPushQueryResult.getPushAtricleIdJson())){
			List<Integer> pushAtricleId=JsonUtil.toList(opPushQueryResult.getPushAtricleIdJson());
			if(pushAtricleId!=null&&pushAtricleId.size()>0){
				String[] newPushArray = opPushQueryResult.getNewPushArticleId().split(",");
				List<Integer> pushList=new ArrayList<>();
				for (Integer id : pushAtricleId){
					boolean result=false;
					for (String atricleId : newPushArray){
						if(id.equals(Integer.valueOf(atricleId))){
							result=true;
						}
					}
					if(result)
						pushList.add(id);
				}
				opPushQueryResult.setPushAtricleIdJson(JsonUtil.toJson(pushList));
			}
		}
	}

	/**
	 * @author wang_hw
	 * @title :isPushFinish
	 * @Description:判断是否完成推送
	 * @return boolean
	 * @date 2016年11月28日 下午4:25:48
	 */
	public boolean isPushFinish(OpPushRuleConf opPushRuleConf , OpPushQueryResult opPushQueryResult , Integer articleId)
	{
		Integer pushArticleMaxNum = opPushRuleConf.getPushArticleMaxNum() == null ? 1 : opPushRuleConf.getPushArticleMaxNum();
		OpPushResult opPushResult =  opPushResultDao.queryOpPushResult(opPushRuleConf.getPushRuleId().intValue(), opPushQueryResult.getPatientId(), articleId);
		if(opPushResult!=null)
		{
			opPushQueryResult.setPushTimes(opPushResult.getPushTimes());
		}else
		{
			return false;
		}
		Integer pushTimes = (opPushResult==null || opPushResult.getPushTimes()==null) ? 0 : opPushResult.getPushTimes();
		
		if(pushTimes>=pushArticleMaxNum)
		{
			LogUtil.log.info("文章已达到最大推送次数跳过pushTimes="+pushTimes+",pushArticleMaxNum="+pushArticleMaxNum+"articleId="+articleId);
			return true;
		}
		return false;
	}
	/**
	 * @author wang_hw
	 * @title :execCirclePush
	 * @Description:推送逻辑执行
	 * @return boolean
	 * @date 2016年10月10日 上午11:47:53
	 */
	public boolean execCirclePush(List<Integer> pushList , List<Integer> allPushList ,OpPushRuleConf opPushRuleConf, OpPushQueryResult opPushQueryResult , Set<Integer> newPushSet , List<Integer> newPushList)
	{
		//根据已推送队列和全部推送队列处理推送
		LogUtil.log.info("循环推送逻辑执行开始");
		boolean isPush = false;
		try {
			int index = pushList.size();
			
			for(int i=index; i<allPushList.size(); i++)
			{
				if(isPushFinish(opPushRuleConf , opPushQueryResult , allPushList.get(i)))
				{
					continue;
				}
				
				if(newPushSet.contains(allPushList.get(i)))
				{
					pushList.add(allPushList.get(i));
					
					//记录推送队列
					recordPushResultQueue(pushList , allPushList , opPushQueryResult , opPushQueryResult.getPushResultQueueId());
					opPushQueryResult.setArticleId(allPushList.get(i));
					
					//推送文章
					pushMessage(opPushQueryResult.getUserId() , opPushRuleConf.getTitle() , opPushRuleConf.getContent() , opPushRuleConf.getBak(), allPushList.get(i), null,opPushRuleConf.getIsUseTitle());
					isPush = true;
					break;
					
				}else
				{
					pushList.add(allPushList.get(i));
					break;
				}
			}
			
			//如果推送完开始下一轮推送
			if(pushList.size()==allPushList.size())
			{
				if(isPush)
				{//如果已经推送
					//设置结果
					pushList = new ArrayList<Integer>();
					allPushList = newPushList;
				}else
				{//如果没有推送
					//推送文章
					isPushFinish(opPushRuleConf , opPushQueryResult , pushList.get(0));
					pushMessage(opPushQueryResult.getUserId() , opPushRuleConf.getTitle() , opPushRuleConf.getContent() , opPushRuleConf.getBak() , newPushList.get(0) , null,opPushRuleConf.getIsUseTitle());
					opPushQueryResult.setArticleId(newPushList.get(0));
					
					//设置结果
					pushList = new ArrayList<Integer>();
					pushList.add(newPushList.get(0));
					allPushList = newPushList;
				}
				
				//记录推送队列
				recordPushResultQueue(pushList , allPushList , opPushQueryResult , opPushQueryResult.getPushResultQueueId());
				
			}
		} catch (Exception e) {
			LogUtil.logError.error("循环推送逻辑执行失败:"+e.getMessage());
		}
		LogUtil.log.info("循环推送逻辑执行结束");
		
		return isPush;
	}
	/**
	 * @author wang_hw
	 * @title :recordPushResultQueue
	 * @Description:记录推送队列
	 * @return void
	 * @date 2016年10月10日 上午11:19:37
	 */
	public void recordPushResultQueue(List<Integer> pushList , List<Integer> allPushList ,OpPushQueryResult opPushQueryResult , Integer pushResultQueueId)
	{
		LogUtil.log.info("记录推送队列开始");
		try {
			
			OpPushResultQueue opPushResultQueue = new OpPushResultQueue();
			opPushResultQueue.setPushAtricleIdJson(JsonUtil.toJson(pushList));
			opPushResultQueue.setAllPushArticleIdJson(JsonUtil.toJson(allPushList));
			opPushResultQueue.setPushResultQueueId(pushResultQueueId);
			opPushResultQueue.setPatientId(opPushQueryResult.getPatientId());
			opPushResultQueue.setPushRuleId(opPushQueryResult.getPushRuleId());
			
			OpPushResultQueue opPushResultQueueResult = opPushResultQueueDao.queryOpPushResultQueueByPatientId(opPushQueryResult.getPushRuleId(), opPushQueryResult.getPatientId());
			if(opPushResultQueueResult==null || opPushResultQueueResult.getPushRuleId()==null)
			{
				opPushResultQueueDao.insertOpPushResultQueue(opPushResultQueue);
				LogUtil.log.info("记录推送队列(insert)");
			}else
			{
				opPushResultQueueDao.updateOpPushResultQueue(opPushResultQueue);
				LogUtil.log.info("记录推送队列开始(update)");
			}
		} catch (Exception e) 
		{
			LogUtil.log.info("记录推送队列失败："+e.getMessage());
		}
		LogUtil.log.info("记录推送队列结束");
	}

	public void recordPushResultQueue(String pushList , String allPushList ,OpPushQueryResult opPushQueryResult , Integer pushResultQueueId)
	{
		LogUtil.log.info("记录推送队列开始");
		try {

			OpPushResultQueue opPushResultQueue = new OpPushResultQueue();
			opPushResultQueue.setPushAtricleIdJson(pushList);
			opPushResultQueue.setAllPushArticleIdJson(allPushList);
			opPushResultQueue.setPushResultQueueId(pushResultQueueId);
			opPushResultQueue.setPatientId(opPushQueryResult.getPatientId());
			opPushResultQueue.setPushRuleId(opPushQueryResult.getPushRuleId());

			OpPushResultQueue opPushResultQueueResult = opPushResultQueueDao.queryOpPushResultQueueByPatientId(opPushQueryResult.getPushRuleId(), opPushQueryResult.getPatientId());
			if(opPushResultQueueResult==null || opPushResultQueueResult.getPushRuleId()==null)
			{
				opPushResultQueueDao.insertOpPushResultQueue(opPushResultQueue);
				LogUtil.log.info("记录推送队列(insert)");
			}else
			{
				opPushResultQueueDao.updateOpPushResultQueue(opPushResultQueue);
				LogUtil.log.info("记录推送队列开始(update)");
			}
		} catch (Exception e)
		{
			LogUtil.log.info("记录推送队列失败："+e.getMessage());
		}
		LogUtil.log.info("记录推送队列结束");
	}
	
	/**
	 * @author wang_hw
	 * @title :productPushResult
	 * @Description:组装推送日志
	 * @return void
	 * @date 2016年10月10日 上午11:21:19
	 */
	public void productPushResult(List<OpPushResult> opPushResultList , OpPushQueryResult opPushQueryResult , Integer pushTimes)
	{
		//记录推送日志
		OpPushResult opPushResult = new OpPushResult();
		opPushResult.setPatientId(opPushQueryResult.getPatientId());
		opPushResult.setArticleId(opPushQueryResult.getArticleId());
		opPushResult.setPushRuleId(opPushQueryResult.getPushRuleId());
		opPushResult.setPushTimes(pushTimes);
		opPushResultList.add(opPushResult);
	}
	
	/**
	 * @author wang_hw
	 * @title :recordPushResult
	 * @Description:记录推送日志
	 * @return void
	 * @date 2016年10月10日 上午11:26:10
	 */
	public void recordPushResult(List<OpPushResult> opPushResultList)
	{
		LogUtil.log.info("推送日志批量录入开始");
		try {
			
			List<OpPushResult> insertOpPushResultList = new ArrayList<OpPushResult>();
			for(OpPushResult opPushResult : opPushResultList)
			{
				OpPushResult searchOpPushResult = opPushResultDao.queryOpPushResult(opPushResult.getPushRuleId(), opPushResult.getPatientId(), opPushResult.getArticleId());
				if(searchOpPushResult!=null)
				{
					LogUtil.log.info("推送日志已存在修改中...");
					opPushResult.setPushResultId(searchOpPushResult.getPushResultId());
					opPushResultDao.updateOpPushResult(opPushResult);
				}else
				{
					insertOpPushResultList.add(opPushResult);
				}
			}
			if(insertOpPushResultList!=null && insertOpPushResultList.size()>0)
			{
				LogUtil.log.info("推送日志不为空录入中...");
				opPushResultDao.insertOpPushResultList(insertOpPushResultList);
			}
		} catch (Exception e) {
			LogUtil.logError.error("推送日志批量录入失败:"+e.getMessage());
		}
		LogUtil.log.info("推送日志批量录入结束");
	}
	
	/**
	 * @author wang_hw
	 * @title :getNewPushList
	 * @Description:获取最新文章列表
	 * @return void
	 * @date 2016年10月10日 上午11:12:59
	 */
	public void getNewPushList(String newPushArticleId ,List<Integer> newPushList , Set<Integer> newPushSet)
	{
		LogUtil.log.info("获取最新文章开始");
		try {
			String[] pushArray = newPushArticleId.split(",");
			for(String pushId : pushArray)
			{
				newPushList.add(Integer.parseInt(pushId));
				newPushSet.add(Integer.parseInt(pushId));
			}
		} catch (Exception e) {
			LogUtil.log.info("获取最新文章失败:"+e.getMessage());
		}
		LogUtil.log.info("获取最新文章结束");
	}
	
	/**
	 * @author wang_hw
	 * @title :pushMessage
	 * @Description:推送消息
	 * @return void
	 * @date 2016年10月10日 上午11:13:13
	 */
	public void pushMessage(Long userId , String title , String content , String bak , Integer articleId , String articleTitle , Integer isUseTitle)
	{
		LogUtil.log.info("推送文章开始:"+userId +","+title+","+content+","+bak+","+articleId);
		try {
			if(articleTitle==null)
			{
				articleTitle = opPushRuleConfDao.queryArticleTitle(articleId);
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			List<String> list = new ArrayList<String>();
			list.add(title);
			list.add(sdf.format(new Date()));
			list.add(isUseTitle!=null&&isUseTitle==1?articleTitle:content);
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
	
	/**
	 * @author wang_hw
	 * @title :addDate
	 * @Description:获取下次执行日期
	 * @return void
	 * @date 2016年10月11日 下午6:56:53
	 */
	public Date addDate(Date date , int pushCycle)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		switch (pushCycle)
		{
		case 1:
			cal.add(Calendar.DAY_OF_YEAR, 1);
			break;
		case 2:
			cal.add(Calendar.WEEK_OF_YEAR, 1);
			break;
		case 3:
			cal.add(Calendar.WEEK_OF_YEAR, 2);
			break;
		case 4:
			cal.add(Calendar.MONTH, 1);
			break;
		case 5:
			cal.add(Calendar.MONTH, 3);
			break;
		case 6:
			cal.add(Calendar.MONTH, 6);
			break;
		case 7:
			cal.add(Calendar.YEAR, 1);
			break;
		default:
			break;
		}
		date = cal.getTime();
		return date;
	}
	public Integer getDateNum(Date date)
	{
		Integer num = 0 ;
		try
		{
			num = Integer.parseInt(sdf.format(date));
		}catch(Exception ex)
		{
			LogUtil.logError.error(ex.getMessage());
		}
		return num ;
	}
}
