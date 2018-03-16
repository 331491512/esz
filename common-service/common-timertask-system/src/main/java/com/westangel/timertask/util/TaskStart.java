package com.westangel.timertask.util;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;
import com.westangel.common.spring.SpringContext;
import com.westangel.common.util.LogUtil;

public class TaskStart
{
	public static void startTaskFactory()
	{
		try {
			TBScheduleManagerFactory scheduleManagerFactory = new TBScheduleManagerFactory();

			Properties p = new Properties();
			p.load(TaskStart.class.getClassLoader().getResourceAsStream("config/zookeeper.properties"));

			scheduleManagerFactory.setApplicationContext(SpringContext.getApplicationContext());
			scheduleManagerFactory.init(p);
			LogUtil.log.info("启动定时器成功");
		} catch (Exception e) 
		{
			e.printStackTrace();
			LogUtil.logError.error(e.getMessage());
			LogUtil.log.info("启动定时器失败");
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/application.xml");
		TBScheduleManagerFactory scheduleManagerFactory = new TBScheduleManagerFactory();

		Properties p = new Properties();
		p.load(TaskStart.class.getClassLoader().getResourceAsStream("config/zookeeper.properties"));
		scheduleManagerFactory.setApplicationContext(ctx);
		scheduleManagerFactory.init(p);
	}
}
