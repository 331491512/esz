package com.esuizhen.cloudservice.followup.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.esuizhen.cloudservice.followup.bean.TPatientFollowupResultDetailInfo;
import com.esuizhen.cloudservice.followup.dao.followup.FollowupPlanDao;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupSmsResultService;
import com.westangel.common.util.LogUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "classpath:spring/application.xml" })
public class FollowupSmsResultServiceTest 
{
	
	@Autowired
	private FollowupSmsResultService followupSmsResultService;
	
	@Autowired
	private FollowupPlanDao dao;
	
	
	@Test
	public  void replySmsFollowupResult()
	{
		TPatientFollowupResultDetailInfo patientFRDInfo=new TPatientFollowupResultDetailInfo();
		followupSmsResultService.replySmsFollowupResult("18701699260", "4", "2016-08-31");
		LogUtil.log.info(followupSmsResultService.toString());
	}
}
