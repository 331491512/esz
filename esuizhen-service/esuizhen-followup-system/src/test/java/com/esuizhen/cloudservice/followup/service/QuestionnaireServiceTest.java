package com.esuizhen.cloudservice.followup.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.esuizhen.cloudservice.followup.dao.followup.FollowupResultDao;
import com.esuizhen.cloudservice.followup.dao.questionnaire.QuestionnaireResultDao;
import com.esuizhen.cloudservice.followup.model.followup.FollowupResult;
import com.esuizhen.cloudservice.followup.model.questionnaire.TQuestionnairePatientInfo;
import com.esuizhen.cloudservice.followup.service.questionnaire.QuestionnaireService;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.LogUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "classpath:spring/application.xml" })
public class QuestionnaireServiceTest 
{
	@Autowired
	private QuestionnaireService questionnaireService;
	
	@Autowired
	private QuestionnaireResultDao dao;
	
	@Autowired
	private FollowupResultDao followupResultDao;
	
	@Test
	@Ignore
	public void queryPatientFollowupItemId()
	{
		FollowupResult followupResult = new FollowupResult();
		followupResult.setFollowupResultValue(1);
		followupResult.setFollowupResultId(GeneralUtil.generateUniqueID("RESU"));
		followupResult.setFollowupTaskId("1");
		followupResult.setPatientId(153L);
		followupResult.setOperator(9);
		followupResult.setFollowupWay(4);
		followupResult.setFollowupTime(new Date());
		followupResult.setCreateTime(new Date());
		followupResult.setUpdateTime(new Date());
		followupResultDao.insertFollowupResult(followupResult);
	}
	
	@Test
	@Ignore
	public void selectFollowupQuestionnaireResult()
	{
		Map<String , Object> param = new HashMap<String , Object>();
		param.put("reqFlag", 1);
		param.put("patientId", 153);
		param.put("followupItemId", "20160205113114664779");
		dao.selectFollowupQuestionnaireResult(param);
	}
	
	@Test
	public void queryPatientAnswerByQuestionnaireId()
	{
		String questionnaireId="QUES20170313171656240810";
		List<TQuestionnairePatientInfo>list=null;//questionnaireService.queryPatientAnswerByQuestionnaireId(questionnaireId);
		for(TQuestionnairePatientInfo t:list){
			LogUtil.log.info(t.getPatientNo());
			LogUtil.log.info(t.getQuestionnaireAnswerList().toString());
		}
	}
	
	
	public static void main(String[] args)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("未知结果");
		System.out.println(sdf.format(new Date()));
	}
	
}
