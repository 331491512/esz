package com.esuizhen.cloudservice.timertask.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.westangel.common.bean.timertask.Timertask;
import com.westangel.common.service.TimertaskService;
import com.westangel.common.util.LogUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "classpath:spring/application.xml" })
public class TimerTaskFactoryServiceTest
{
	@Autowired
	private TimerTaskFactoryService service;
	
	@Autowired
	private com.westangel.common.service.TimerTaskFactoryService service2;
	
	@Autowired
	private TimertaskService timertaskService;
	
	@Test
	public void createFollowupTask()
	{
		service2.createFollowupPlanTimerTask("TEMP20160216173259904507");
	}
	
	@Test
	@Ignore
	public void createGeneralserviceTimer()
	{
		Integer code = service.createGeneralserviceTimer("APPL20160127235550661690" , 5 , "expire");
		LogUtil.log.info("================================code:"+code+"");
	}
	
	@Test
	@Ignore
	public void createTelconsultTimer()
	{
		service.createTelconsultTimer("APPL20160128002436497654");
	}
	
	@Test
	@Ignore
	public void createTimetaskList()
	{
		Timertask timertask8 = new Timertask();
		timertask8.setTaskType(1);
		timertask8.setUserId("118");
		timertask8.setActionType(1);
		timertask8.setActionPushType("wx_data_push");
		timertask8.setPushContent("乐山大佛");
		timertask8.setServiceType(2);
		timertask8.setActionTime(new Date(System.currentTimeMillis()));
		timertask8.setServiceTargetId("1");
		
		Timertask timertask9 = new Timertask();
		timertask9.setTaskType(1);
		timertask9.setUserId("118");
		timertask9.setActionType(1);
		timertask9.setActionPushType("wx_data_push");
		timertask9.setPushContent("松岛枫");
		timertask9.setServiceType(2);
		timertask9.setActionTime(new Date(System.currentTimeMillis()));
		timertask9.setServiceTargetId("1");
		
		List<Timertask> list = new ArrayList<Timertask>();
		list.add(timertask8);
		list.add(timertask9);
//		timertaskService.createTimetaskList(list);
		timertaskService.createTimetask(timertask8);
	}
}
