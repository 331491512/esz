package com.westangel.timertask.util;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.westangel.common.util.LogUtil;

//@Component("webstart")
public class WebStart implements ApplicationListener<ApplicationEvent>
{

	private boolean isStart = false;
	@Override
	public void onApplicationEvent(ApplicationEvent event)
	{
		if (event instanceof ContextRefreshedEvent && !isStart) 
		{
			isStart = true;
			LogUtil.log.info("启动定时器开始");
			TaskStart.startTaskFactory();
			LogUtil.log.info("启动定时器完成");
		}
	}

}
