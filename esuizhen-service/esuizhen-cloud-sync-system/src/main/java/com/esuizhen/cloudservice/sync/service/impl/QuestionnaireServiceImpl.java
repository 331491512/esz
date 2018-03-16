package com.esuizhen.cloudservice.sync.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.sync.bean.TSyncRecord;
import com.esuizhen.cloudservice.sync.bean.TSyncResultNotify;
import com.esuizhen.cloudservice.sync.dao.cloud.FollowupContentTemplateInfoDao;
import com.esuizhen.cloudservice.sync.dao.cloud.QuestionnaireDao;
import com.esuizhen.cloudservice.sync.dao.cloud.QuestionnaireResultDao;
import com.esuizhen.cloudservice.sync.model.QuestionnaireResult;
import com.esuizhen.cloudservice.sync.model.TFollowupQuestionnaireDetailInfo;
import com.esuizhen.cloudservice.sync.model.TFollowupQuestionnaireStem;
import com.esuizhen.cloudservice.sync.service.CheckBeforeSyncService;
import com.esuizhen.cloudservice.sync.service.QuestionnaireService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.util.PageUtil;

/** 
 *@className QuestionnaireServiceImpl
 *@Description:
 *@author yuanwenming
 *@date 2017年8月9日
 */
@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
	@Autowired
	private FollowupContentTemplateInfoDao followupContentTemplateInfoDao;
	
	@Autowired
	private QuestionnaireDao dao;
	
	@Autowired
	private CheckBeforeSyncService checkBeforeSyncService;
	
	@Autowired
	private QuestionnaireResultDao questionnaireResultDao;
	
	@Override
	public Page<QuestionnaireResult> syncQuestionnaireFollowupResultFromCloud(Integer hospitalId,
			Integer pageIndex, Integer pageSize)
			throws HospitalWithoutRightExcption {
		if(!checkBeforeSyncService.checkHospitalId(hospitalId)){
			throw new HospitalWithoutRightExcption();
		}
		PageHelper.startPage(pageIndex + 1, pageSize);
		List<QuestionnaireResult> followupResultDetailInfos = questionnaireResultDao.selectFollowupQuestionnaireResult(hospitalId);
		return PageUtil.returnPage((com.github.pagehelper.Page<QuestionnaireResult>)followupResultDetailInfos);
	}

	@Override
	public void setQuestionnaireResultSyncFlag(TSyncResultNotify notify) {
		List<TSyncRecord> uuids = notify.getUuids();
		if(uuids!=null&&uuids.size()>0){
			Map<String, Object> paramMap = new HashMap<String, Object>();
			for (TSyncRecord tSyncRecord : uuids) {
				paramMap.put("questionnaireResultId",tSyncRecord.getQuestionnaireResultId());
				paramMap.put("syncFlag", 1);
				questionnaireResultDao.setQuestionnaireResultSyncFlag(paramMap);
				paramMap.clear();
			}
		}
	}
	
	@Transactional
	@Override
	public void sendQuestionnaireFollowupMessage(
			TFollowupQuestionnaireDetailInfo detailInfo) throws Exception {
		//添加问卷模板
		int templateInfoInt =  followupContentTemplateInfoDao.queryFollowupContentTemplateInfo(detailInfo.getContentTemplateId());
		if(templateInfoInt == 0) {
			followupContentTemplateInfoDao.insertFollowupContentTemplateInfo(detailInfo.getContentTemplateInfo());
		}
		int questionnaireInt = dao.queryQuestionnaireById(detailInfo.getQuestionnaireId());
		if(questionnaireInt > 0) {
			return;
		}
		// 保存问卷信息
		dao.insertQuestionnaire(detailInfo);
		// 保存题目信息
		if(detailInfo.getStemList() != null && detailInfo.getStemList().size() > 0) {
			for(TFollowupQuestionnaireStem stem:detailInfo.getStemList()) {
				dao.insertQuestionnaireStem(stem);
				if (stem.getQuestionOptions() != null && stem.getQuestionOptions().size() > 0) {// 判断是否有问题选项
					//保存题肢
					dao.insertQuestionnaireOptions(stem.getQuestionOptions());
				}
			}
		}
	}
}
