package com.esuizhen.cloudservice.sync.service;

import com.esuizhen.cloudservice.sync.bean.TSyncResultNotify;
import com.esuizhen.cloudservice.sync.model.QuestionnaireResult;
import com.esuizhen.cloudservice.sync.model.TFollowupQuestionnaireDetailInfo;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.HospitalWithoutRightExcption;

/** 
 *@className QuestionnaireService
 *@Description:
 *@author yuanwenming
 *@date 2017年8月9日
 */
public interface QuestionnaireService {
	void sendQuestionnaireFollowupMessage(TFollowupQuestionnaireDetailInfo detailInfo) throws Exception;
	
	Page<QuestionnaireResult> syncQuestionnaireFollowupResultFromCloud(Integer hospitalId, Integer pageIndex, Integer pageSize) throws HospitalWithoutRightExcption;
	/**
	 * 置同步标识，已经同步完成
	 * @param notify
	 */
	void setQuestionnaireResultSyncFlag(TSyncResultNotify notify);
}
