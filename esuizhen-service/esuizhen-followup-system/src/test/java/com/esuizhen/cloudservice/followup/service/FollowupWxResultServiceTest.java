package com.esuizhen.cloudservice.followup.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.esuizhen.cloudservice.followup.dao.followup.FollowupPlanDao;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupWxResultService;
import com.westangel.common.util.LogUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "classpath:spring/application.xml" })
public class FollowupWxResultServiceTest 
{
	
	@Autowired
	private FollowupWxResultService followupWxResultService;
	
	@Autowired
	private FollowupPlanDao dao;
	
	
	@Test
	public  void replyWxFollowupResult()
	{
		Map<String,Object> detailInfoMap=new HashMap<String,Object>();
		detailInfoMap.put("id", "137969");
		detailInfoMap.put("patientUuid", "35d94f7f329d11e6806c9abe94f8e807");
		detailInfoMap.put("followupResultId", "RESU20160909105153591894");
		detailInfoMap.put("followupResultValue", 3);
		detailInfoMap.put("transferParts", "胃");
		detailInfoMap.put("transferDate", "2016-09-09 00:00:00");
		detailInfoMap.put("followUpWay", 4);
		detailInfoMap.put("followupTime", "2016-09-09 10:51:53");
		detailInfoMap.put("messageId", "WXMSG20160909104948451319");
		followupWxResultService.replyWxFollowupResult(detailInfoMap, null);
		LogUtil.log.info(followupWxResultService.toString());
	}
}
