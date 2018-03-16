package com.westangel.timertask.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.westangel.common.bean.sms.SmsTemplateSendReq;
import com.westangel.common.bean.timertask.Timertask;
import com.westangel.common.service.SmsInnerService;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.SmsUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "classpath:spring/application.xml" })
public class TimetaskServiceTest 
{
	
	@Autowired
	private TimertaskService service;
	
	@Autowired
	private com.westangel.common.service.TimertaskService service2;
	
	@Autowired
	private MessageSource messageSource ;
	
	@Autowired
	private SmsInnerService smsInnerService;
	
	@Test
	@Ignore
	public void sendMsg()
	{
		List<String> dataList = new ArrayList<String>();
		dataList.add("张三");
				
		SmsTemplateSendReq template = SmsUtil.getSmsTemplateSendReq("DianHuaZiXunYuQi30FenZhong", "18910225535", dataList);
		boolean flag = smsInnerService.sendTemplate(template);
		System.out.println("flag="+flag);
	}
	@Test
	@Ignore
	public void insertTimetask() 
	{
		Timertask timertask = new Timertask();
		timertask.setTaskType(1);
		timertask.setUserId("93");
		timertask.setActionType(1);
		timertask.setActionPushType("wx_template_push");
		timertask.setPushContent("推送");
		timertask.setSqlContent(messageSource.getMessage("timertask.update.followup.plan.detail", new Object[]{"123456"}, null));
		timertask.setServiceType(1);
		timertask.setActionTime(new Date());
		service2.createTimetask(timertask);
	}
	
	@Test
	@Ignore
	public void updateTimetask() 
	{
		Timertask timetask = new Timertask();
		timetask.setTimerTaskId("20160113151717348729");
		timetask.setActionPushType("app");
		service.updateTimetask(timetask);
	}
	
	@Test
	@Ignore
	public void queryTimetask() 
	{
		Timertask timetask = service.queryTimetaskById("20160113151717348729");
		LogUtil.log.info(timetask.toString());
		
	}
	
	@Test
	@Ignore
	public void deleteTimetask() 
	{
		service2.cancelTimetask(1,"20160113151858169191" , null);
		
	}
	
	@Test
	public void cancelTimetask() 
	{
		service2.cancelTimetask(21, "20160128180043577577",null);
		
	}
}
