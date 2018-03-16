package com.esuizhen.cloudservice.questionnaire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.questionnaire.service.QuestionnaireService;
import com.westangel.common.util.LogUtil;

/** 
 *@className QuestionnaireResultReplyTimerTask
 *@Description:
 *@author yuanwenming
 *@date 2017年8月9日
 */
@Service("questionnaireResultReplyTimerTask")
public class QuestionnaireResultReplyTimerTask {
	@Autowired
	private QuestionnaireService questionnaireService;
	
	public void scanAllReply() {
		try {
			questionnaireService.scanQuestionnaireReply();
		} catch (Exception e) {
			LogUtil.log.error("[扫描问卷回复失败！]," + e.getMessage());
		}
	}
}
