package com.westangel.timertask.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.westangel.common.bean.timertask.Timertask;
import com.westangel.common.service.MessageInnerService;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.service.SmsInnerService;
import com.westangel.common.util.LogUtil;
import com.westangel.timertask.common.TaskAbstract;
import com.westangel.timertask.service.TimertaskService;
import com.westangel.timertask.util.TaskUtil;

@Component
public class MinuteJob extends TaskAbstract
{

	@Autowired
	private TimertaskService service;
	
	@Autowired
	private PushInnerService pushService;
	
	@Autowired
	private SmsInnerService smsInnerService;
	
	@Autowired
	private MessageInnerService messageInnerService;
	
	@Value("${server.api.url.root}")
	private String urlRoot;
	
	@Override
	@Scheduled(cron="${timer.minute.timer}")
	public void job()
	{
		LogUtil.log.info("任务开始扫描(分钟)");
		List<Timertask> taskList =service.queryTimetaskByServiceType(null, 0 , null);
		
		for(int i=0; i<taskList.size(); i++)
		{//任务执行
			Timertask timetask = taskList.get(i);
			
			//成功失败标志
			boolean flag = false;
			
			if(System.currentTimeMillis()>timetask.getActionTime().getTime())
			{
				flag = TaskUtil.execTask(timetask , pushService , smsInnerService ,messageInnerService, service.queryUserOpenId(timetask.getUserId(),timetask.getWxProductId()) , urlRoot);
			}else
			{
				continue;
			}
			
			if(flag&&1==timetask.getTaskType())
			{//如果成功删除数据
				service.deleteTimetask(timetask.getTimerTaskId());
			}else
			{
				if(timetask.getRetry()>=10)
				{//如果大于等于10次删除
					service.deleteTimetask(timetask.getTimerTaskId());
				}else
				{//否则记录加一
					timetask.setRetry(timetask.getRetry()+1);
					service.updateTimetask(timetask);
				}
			}
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				LogUtil.logError.error(e.getMessage());
			}
			
		}
	}
}
