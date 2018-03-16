package com.esuizhen.cloudservice.followup.service.questionnaire.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.followup.bean.FollowupQuestionnaireResultReq;
import com.esuizhen.cloudservice.followup.bean.QuestionnaireListQueryReq;
import com.esuizhen.cloudservice.followup.bean.QuestionnaireQueryReq;
import com.esuizhen.cloudservice.followup.bean.QuestionnaireResultListReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupQuestionnaireDetailInfoReq;
import com.esuizhen.cloudservice.followup.dao.conf.FollowupContentTemplateInfoDao;
import com.esuizhen.cloudservice.followup.dao.followup.FollowupPlanDao;
import com.esuizhen.cloudservice.followup.dao.questionnaire.QuestionnaireDao;
import com.esuizhen.cloudservice.followup.dao.questionnaire.QuestionnaireOptionsDetailDao;
import com.esuizhen.cloudservice.followup.dao.questionnaire.QuestionnaireResultDao;
import com.esuizhen.cloudservice.followup.dao.questionnaire.QuestionnaireResultOptionsDetailDao;
import com.esuizhen.cloudservice.followup.dao.questionnaire.QuestionnaireResultStemDao;
import com.esuizhen.cloudservice.followup.dao.questionnaire.QuestionnaireStemDao;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupContentTemplateInfo;
import com.esuizhen.cloudservice.followup.model.followup.TFollowupPlanDetialInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultDetailInfo;
import com.esuizhen.cloudservice.followup.model.questionnaire.TFollowupQuestionnaireDetailInfo;
import com.esuizhen.cloudservice.followup.model.questionnaire.TFollowupQuestionnaireOptions;
import com.esuizhen.cloudservice.followup.model.questionnaire.TFollowupQuestionnaireStem;
import com.esuizhen.cloudservice.followup.model.questionnaire.TQuestionnairePatientInfo;
import com.esuizhen.cloudservice.followup.model.questionnaire.TQuestionnaireResult;
import com.esuizhen.cloudservice.followup.model.questionnaire.TQuestionnaireResultOptionsDetail;
import com.esuizhen.cloudservice.followup.model.questionnaire.TQuestionnaireResultStem;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupResultService;
import com.esuizhen.cloudservice.followup.service.questionnaire.QuestionnaireService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;

@Service
@Transactional
public class QuestionnaireServiceImpl implements QuestionnaireService
{
	@Autowired
	private QuestionnaireDao dao;

	@Autowired
	private QuestionnaireStemDao stemDao;
	
	@Autowired
	private QuestionnaireOptionsDetailDao optionsDao;
	
	@Autowired
	private QuestionnaireResultStemDao resultStemDao;
	
	@Autowired
	private QuestionnaireResultOptionsDetailDao resultOptionsDetailDao;
	
	@Autowired
	private FollowupPlanDao followupPlanDao;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private QuestionnaireResultDao resultDao;
	
	@Value("${server.wx.url.root}")
	private String wxUrl;
	
	@Value("${server.questionnaire.result.path}")
	private String resultPath;
	
	@Autowired
	private FollowupResultService followupResultService;
	
	@Autowired
	private FollowupContentTemplateInfoDao followupContentTemplateInfoDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String addFollowupQuestionnaire(TFollowupQuestionnaireDetailInfo detailInfo)
	{
		//创建问卷模版
		TFollowupContentTemplateInfo contentTemplateInfo=new TFollowupContentTemplateInfo();
		contentTemplateInfo.setContentTemplateId(GeneralUtil.generateUniqueID("CONT"));
		contentTemplateInfo.setContentTemplateName(detailInfo.getSubject());
		contentTemplateInfo.setContentTemplateType(6);
		contentTemplateInfo.setContent(detailInfo.getDescription());
		contentTemplateInfo.setAuthor(detailInfo.getAuthor());
		contentTemplateInfo.setIsPublish(1);
		contentTemplateInfo.setNeedReply(0);
		//添加问卷模板
		followupContentTemplateInfoDao.insertFollowupContentTemplateInfo(contentTemplateInfo);
		//问卷模板Id
		detailInfo.setContentTemplateId(contentTemplateInfo.getContentTemplateId());
		this.createQuestionnaire(detailInfo);
		return detailInfo.getQuestionnaireId();
	}

	private void createQuestionnaire(TFollowupQuestionnaireDetailInfo detailInfo) {
		// 问卷ID
		String questionnaireId = GeneralUtil.generateUniqueID("QUES");
		// 保存问卷信息
		detailInfo.setQuestionnaireId(questionnaireId);
		detailInfo.setIsPublish(1);
		dao.insertQuestionnaire(detailInfo);
		//判断题干是否存在抛出错误
		if (detailInfo.getStemList() == null || detailInfo.getStemList().size() < 1) {// 如果title列表为空则直接错误返回
			throw new RuntimeException();
		}
		//定义全量
		List<TFollowupQuestionnaireOptions> optionsAll = new ArrayList<TFollowupQuestionnaireOptions>();
		// 保存题目信息
		for (int i = 0; i < detailInfo.getStemList().size(); i++) {
			// 问题ID
			String questionnaireStemId = GeneralUtil.generateUniqueID("QSTE");
			TFollowupQuestionnaireStem stem = detailInfo.getStemList().get(i);
			stem.setQuestionnaireStemId(questionnaireStemId);
			stem.setQuestionnaireId(questionnaireId);
			stem.setStemIndex(i + 1);
//			stem.setQuestionType(1);
			stem.setStemCode(stem.getStemIndex().toString());
			dao.insertQuestionnaireStem(stem);
			// 判断是否有问题选项
			if (stem.getQuestionOptions() != null) {
				if (stem.getQuestionOptions().size() > 0) {
					// 加载题肢
					loadingOptionns(optionsAll, stem, stem.getQuestionOptions(), "0", 0);
				}
			}
		}
		//保存全部题肢
		if (optionsAll.size() > 0){
			System.out.println(JsonUtil.toJson(optionsAll));
			dao.insertQuestionnaireOptions(optionsAll);
		}
	}
	/**
	 * 
	 * @author lichenghao
	 * @title :loadingOptionns
	 * @Description:选项迭代
	 * @return void
	 * @date 2016年8月26日 下午4:53:25
	 */
	private void loadingOptionns(List<TFollowupQuestionnaireOptions>optionsAll,TFollowupQuestionnaireStem stem,List<TFollowupQuestionnaireOptions> options,String parentOptions,Integer level){
		int j = 1;
		if(options!=null)
			for(TFollowupQuestionnaireOptions option : options){
				optionsAll.add(option);
				String questionnaireOptionId = GeneralUtil.generateUniqueID("QOPT");
				option.setLevel(level);
				option.setQuestionnaireOptionId(questionnaireOptionId);
				option.setQuestionnaireStemId(stem.getQuestionnaireStemId());
				option.setQuestionnaireId(stem.getQuestionnaireId());
				option.setOptionIndex(j++);
				option.setStemCode(stem.getStemCode());
				option.setParentOptionId(parentOptions);
				if(option.getFillFlag()==null){//如果需要填写
					option.setFillFlag(0);
				}
				if(option.getFillContentType()==null)//如果填写，默认为text
					option.setFillContentType(1);
				if(StringUtils.isEmpty(option.getNextStemCode())){//填写下一题
					option.setNextStemCode((stem.getStemIndex()+1)+"");
				}
				if(option.getIsChecked()==null)//如果没有选中 默认填充0
					option.setIsChecked(0);
				if(option.getQuestionOptions()!=null)
					loadingOptionns(optionsAll,stem,option.getQuestionOptions(),option.getQuestionnaireOptionId(),level+1);
			}
	}
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteFollowupQuestionnaire(String questionnaireId)
	{
		// 删除模板
		dao.deleteTemplateById(questionnaireId);
		
		//删除题肢
		dao.deleteQuestionnaireOptionsByQuestionnaireId(questionnaireId);
		
		//删除题干
		dao.deleteQuestionnaireStemByQuestionnaireId(questionnaireId);
		
		// 删除问卷
		dao.deleteQuestionnaireById(questionnaireId);
	}
	
	/**
	 * 修改问卷
	 * @author lichenghao
	 * @title :updateFollowupQuestionnaire
	 * @Description:标记原有问卷状态，取出模版Id，生成新的问卷
	 * @return String
	 * @date 2017年7月28日 下午3:11:24
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String updateFollowupQuestionnaire(TFollowupQuestionnaireDetailInfo detailInfo)
	{
		if(detailInfo==null||org.springframework.util.StringUtils.isEmpty(detailInfo.getQuestionnaireId()));
		//对原有问卷进行软删除，发布状态标志成-1
		dao.deleteSoftQuestionnaireById(detailInfo.getQuestionnaireId());
		this.createQuestionnaire(detailInfo);
		return detailInfo.getQuestionnaireId();
	}
	
	@Override
	public TFollowupQuestionnaireDetailInfoReq queryFollowupQuestionnaire(QuestionnaireQueryReq req)
	{
		
		if(StringUtils.isEmpty(req.getQuestionnaireId())&&StringUtils.isEmpty(req.getPatientId())&&StringUtils.isEmpty(req.getContentTemplateId())){
			throw new EmptyParamExcption(" param  is error param:"+JsonUtil.toJson(req)); 
		}
		//获取问卷模板
		TFollowupQuestionnaireDetailInfo questionnaireDetailInfo=dao.queryQuestionnaireById(req);
		if(questionnaireDetailInfo==null)
			throw new EmptyObjectExcption(" questionnaireDetailInfo is null");
		TFollowupQuestionnaireDetailInfoReq questionnaireDetailInfoReq=new TFollowupQuestionnaireDetailInfoReq();
		questionnaireDetailInfoReq.setQuestionnaireId(questionnaireDetailInfo.getQuestionnaireId());
		questionnaireDetailInfoReq.setSubject(questionnaireDetailInfo.getSubject());
		questionnaireDetailInfoReq.setDescription(questionnaireDetailInfo.getDescription());
		questionnaireDetailInfoReq.setContentTemplateId(questionnaireDetailInfo.getContentTemplateId());
		questionnaireDetailInfoReq.setFollowupTaskId(questionnaireDetailInfo.getFollowupTaskId());
		questionnaireDetailInfoReq.setIsPublish(questionnaireDetailInfo.getIsPublish());
		questionnaireDetailInfoReq.setAuthor(questionnaireDetailInfo.getAuthor());
		
		//获取问卷下题干
		List<TFollowupQuestionnaireStem> stemList = null;
		
		if(StringUtils.isEmpty(req.getQuestionnaireId())&&StringUtils.isEmpty(req.getContentTemplateId()))
		{//通过患者Id获取
			stemList = stemDao.queryStemByAuthor(req.getPatientId());
			req.setDiseaseTypeId(optionsDao.queryPatientDiseaseTypeId(req.getQuestionnaireId()));
		}
		else
		{//常规
			stemList = stemDao.queryStemByQuestionnaireId(questionnaireDetailInfoReq.getQuestionnaireId());
		}
		
		
		for(int i=0; i<stemList.size(); i++)
		{
			TFollowupQuestionnaireStem stem = stemList.get(i);
			//获取选项
			
			List<TFollowupQuestionnaireOptions> optionList = null ;
			
			if(i==1&&req.getPatientId()!=null)
			{//第二题动态获取
				optionList = optionsDao.queryOptionsDetailByStemId(stem.getQuestionnaireStemId() , req.getDiseaseTypeId());
			}else
			{//直接获取
				optionList = optionsDao.queryOptionsDetailByStemId(stem.getQuestionnaireStemId() , null);
			}
			stem.setQuestionOptions(optionList);
			
			for(TFollowupQuestionnaireOptions option :  optionList)
			{
				//如果为父选项获取子选项
				getOptions(option);
			}
			
		}
		questionnaireDetailInfoReq.setStemList(stemList);
		return questionnaireDetailInfoReq;
	}

	@Override
	public Page<TQuestionnaireResult> followupQuestionnaireResultList(QuestionnaireResultListReq req)
	{
		Map<String , Object> param = new HashMap<String , Object>();
		param.put("patientId", req.getPatientId());
		param.put("reqFlag", req.getReqFlag());
		param.put("followupItemId", req.getFollowupItemId());
		param.put("subject", req.getSubject());
		param.put("questionnaireResultUrl", wxUrl+resultPath+"?questionnaireResultId=");
		PageHelper.startPage(req.getPage()+1, req.getNum());
		List<TQuestionnaireResult> list = resultDao.selectFollowupQuestionnaireResult(param);
		return PageUtil.returnPage((com.github.pagehelper.Page<TQuestionnaireResult>)list);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String  writeFollowupQuestionnaireResult(TQuestionnaireResult result)
	{
		if(result.getStemList()==null || result.getStemList().size()<1)
		{
			return null;
		}
		
		if(StringUtils.isEmpty(result.getFollowupItemId()))
		{//如果没有随访计划ItemId则查询该患者前后十天的随访计划
			Map<String , String> followupMap = resultDao.queryPatientFollowupItemId(result.getPatientId() , null);
			if(followupMap!=null &&followupMap.containsKey("followupItemId"))
			{
				result.setFollowupItemId(followupMap.get("followupItemId"));
			}
		}
		
		if(!StringUtils.isEmpty(result.getFollowupItemId()))
		{
			TFollowupPlanDetialInfo followupPlanDetialInfo = new TFollowupPlanDetialInfo();
			followupPlanDetialInfo.setFollowupItemId(result.getFollowupItemId());
			followupPlanDetialInfo.setIsSurveryFeedback(1);
			followupPlanDetialInfo.setIsAlertSent(1);
			followupPlanDao.updateFollowupPlanDetail(followupPlanDetialInfo);;
		}
		
		if(2==result.getCreatorRole())
		{//如果是医生填写给患者推送消息
			
		}else if(1==result.getCreatorRole())
		{//如果是患者上传
			
			Map<String , String> followupMap = resultDao.queryPatientFollowupItemId(result.getPatientId() , result.getFollowupItemId());
			if(followupMap!=null&&followupMap.containsKey("followupId")&&followupMap.containsKey("followupItemId"))
			{
				Map<String , Object> eventInfoMap = new HashMap<String , Object>();
				eventInfoMap.put("patientId", result.getPatientId());
				eventInfoMap.put("followupId", followupMap.get("followupId"));
				eventInfoMap.put("followupItemId", followupMap.get("followupItemId"));
				eventInfoMap.put("tips", messageSource.getMessage("followup.questionnaire.write.info", null, null));
				
				Map<String , Object> eventMap = new HashMap<String , Object>();
				eventMap.put("eventType", Constant.Push.EVENT_TYPE_ALERT);
				eventMap.put("eventInfo", JsonUtil.toJson(eventInfoMap));
				eventMap.put("eventTip", messageSource.getMessage("followup.questionnaire.write.info", null, null));
			}
			
		}
		
		//同步问卷反馈到随访结果(第一题死亡)
		//随访结果记录
		TFollowupResultDetailInfo followupResult = null;
		int size = result.getStemList().get(0).getQuestionOptions().size();
		TQuestionnaireResultOptionsDetail detail = result.getStemList().get(0).getQuestionOptions().get(size-1);
		if(detail.getIsChecked()==1&&!StringUtils.isEmpty(detail.getFillContent2()))
		{//如果死亡日期不为空
			followupResult = new TFollowupResultDetailInfo();
			followupResult.setFollowupResultBuffId(GeneralUtil.generatorUUID("RBUFF"));
			followupResult.setFollowupTaskId(GeneralUtil.generatorUUID("EMPTYTASK"));
			followupResult.setPatientId(Long.parseLong(result.getPatientId()));
			followupResult.setOperator(9l);
			followupResult.setFollowupResultValue(4);
			followupResult.setFollowupWay(4);
			followupResult.setFollowupTime(new Date());
			followupResult.setCreateTime(new Date());
			followupResult.setUpdateTime(new Date());
			followupResult.setDeathCause(detail.getFillContent());
			followupResult.setHospitalId(0);
			followupResult.setSourceFlag(2);
			followupResult.setDeathDate(getDate(detail.getFillContent2()));
		}
		
		//同步问卷反馈到随访结果(稳定复发转移结果同步)
		TQuestionnaireResultOptionsDetail detail1 = result.getStemList().get(4).getQuestionOptions().get(0);
		TQuestionnaireResultOptionsDetail detail2 = result.getStemList().get(4).getQuestionOptions().get(1);
		TQuestionnaireResultOptionsDetail detail3 = result.getStemList().get(4).getQuestionOptions().get(2);
		if(1==detail1.getIsChecked()||1==detail2.getIsChecked()||1==detail3.getIsChecked())
		{
			followupResult = new TFollowupResultDetailInfo();
			if(1==detail1.getIsChecked())
			{//稳定
				followupResult.setFollowupResultValue(1);
			}else if(1==detail2.getIsChecked())
			{//复发
				followupResult.setFollowupResultValue(2);
				followupResult.setRelapseParts(detail2.getIndicateValue());
				followupResult.setRelapseDate(getDate(detail2.getFillContent2()));
				
			}else
			{//转移
				followupResult.setFollowupResultValue(3);
				followupResult.setRelapseParts(detail3.getIndicateValue());
				followupResult.setRelapseDate(getDate(detail3.getFillContent2()));
			}
			followupResult.setFollowupResultBuffId(GeneralUtil.generatorUUID("RBUFF"));
			followupResult.setFollowupTaskId(GeneralUtil.generatorUUID("EMPTYTASK"));
			followupResult.setPatientId(Long.parseLong(result.getPatientId()));
			followupResult.setOperator(9l);
			followupResult.setFollowupWay(4);
			followupResult.setHospitalId(0);
			followupResult.setFollowupTime(new Date());
			followupResult.setCreateTime(new Date());
			followupResult.setUpdateTime(new Date());
			followupResult.setSourceFlag(2);
		}
		if(followupResult!=null){
			//更新患者随访结果
			followupResultService.updateFollowupResultToC(followupResult);
		}
		
		//问卷结果ID
		String questionnaireResultId = GeneralUtil.generatorTimeUUID();
		//问卷结果
		result.setQuestionnaireResultId(questionnaireResultId);
		resultDao.insertQuestionnaireResult(result);
		
		for(TQuestionnaireResultStem stem : result.getStemList())
		{//保存问卷题干
			stem.setQuestionnaireResultStemId(GeneralUtil.generatorTimeUUID());
			stem.setQuestionnaireResultId(questionnaireResultId);
			stem.setAnswerFlag(1);
			//是否选中
			boolean isCheck = false;
			for(TQuestionnaireResultOptionsDetail option : stem.getQuestionOptions())
			{//保存问卷所选择的选项
				
				option.setQuestionnaireResultOptionId(GeneralUtil.generatorTimeUUID());
				option.setQuestionnaireId(stem.getQuestionnaireId());
				option.setQuestionnaireResultId(questionnaireResultId);
				option.setQuestionnaireResultStemId(stem.getQuestionnaireResultStemId());
				
				if(option.getIsChecked()==1)
				{
					isCheck = true;
					resultOptionsDetailDao.insertQuestionnaireResultOptionsDetail(option);
				}
				
				
				if(option.getQuestionOptions()!=null && option.getQuestionOptions().size()>0)
				{//递归保存问卷子选项
					saveResultOptions(option.getQuestionOptions() , option.getQuestionnaireResultOptionId() ,stem.getQuestionnaireId() , questionnaireResultId , stem.getQuestionnaireResultStemId());
				}
			}
			
			if(isCheck)
			{
				resultStemDao.insertQuestionnaireResultStem(stem);
			}
		}
		return questionnaireResultId;
	}
	
	/**
	 * @author wang_hw
	 * @title :saveResultOptions
	 * @Description:递归保存问卷结果信息
	 * @return void
	 * @date 2015年12月31日 下午2:22:04
	 */
	public boolean saveResultOptions(List<TQuestionnaireResultOptionsDetail> options , String questionnaireId , String questionnaireResultId , String questionnaireResultStemId)
	{
		boolean flag = false;
		for(TQuestionnaireResultOptionsDetail option :  options)
		{//保存问卷子选项
			boolean childFlag = false;
			option.setQuestionnaireResultOptionId(GeneralUtil.generateUniqueID("QREI"));
			if(option.getQuestionOptions()!=null && option.getQuestionOptions().size()>0)
			{
				childFlag = saveResultOptions(option.getQuestionOptions() , questionnaireId , questionnaireResultId , questionnaireResultStemId);
			}
			LogUtil.log.debug("---------OPTIONiD=" + option.getQuestionnaireOptionId() + "-------  childFlag="
					+ childFlag + "----option ischecked=" + option.getIsChecked());
			if(option.getIsChecked()!=null && (option.getIsChecked()==1||childFlag))
			{
				flag = true;
				option.setIsChecked(1);
				option.setQuestionnaireResultId(questionnaireResultId);
				option.setQuestionnaireResultStemId(questionnaireResultStemId);
				resultOptionsDetailDao.insertQuestionnaireResultOptionsDetail(option);
			}
		}
		return flag;
	}
	
	public void saveResultOptions(List<TQuestionnaireResultOptionsDetail> options , String questionnaireResultOptionId , String questionnaireId , String questionnaireResultId , String questionnaireResultStemId)
	{
		
		for(TQuestionnaireResultOptionsDetail option :  options)
		{//保存问卷子选项
			option.setQuestionnaireResultOptionId(GeneralUtil.generatorTimeUUID());
			option.setQuestionnaireId(questionnaireId);
			option.setQuestionnaireResultId(questionnaireResultId);
			option.setQuestionnaireResultStemId(questionnaireResultStemId);
			option.setParentOptionId(questionnaireResultOptionId);
			if(option.getIsChecked()==1)
			{
				resultOptionsDetailDao.insertQuestionnaireResultOptionsDetail(option);
			}
			
			if(option.getQuestionOptions()!=null && option.getQuestionOptions().size()>0)
			{
				saveResultOptions(option.getQuestionOptions() , option.getQuestionnaireResultOptionId() , questionnaireId , questionnaireResultId , questionnaireResultStemId);
			}
		}
	}
	
	/**
	 * @author wang_hw
	 * @title :getOptions
	 * @Description:递归获取结果选项选项列表
	 * @return void
	 * @date 2015年12月29日 下午6:45:08
	 */
	public void getResultOptions(TQuestionnaireResultOptionsDetail option)
	{
		List<TQuestionnaireResultOptionsDetail> options = resultOptionsDetailDao.queryResultOptionsDetailByParentOptionId(option.getQuestionnaireResultOptionId());
		option.setQuestionOptions(options);
		for(TQuestionnaireResultOptionsDetail op :  options)
		{
			if(op.getLevel()>0 && op.getLevel()<5)
			{
				getResultOptions(op);
			}
		}
	}
	
	/**
	 * @author wang_hw
	 * @title :getOptions
	 * @Description:递归获取选项列表
	 * @return void
	 * @date 2015年12月29日 下午6:45:08
	 */
	public void getOptions(TFollowupQuestionnaireOptions option)
	{
		List<TFollowupQuestionnaireOptions> options = optionsDao.queryOptionsDetailByParentOptionId(option.getQuestionnaireOptionId());
		option.setQuestionOptions(options);
		for(TFollowupQuestionnaireOptions op :  options)
		{
			if(op.getLevel()>0 && op.getLevel()<5)
			{
				getOptions(op);
			}
		}
	}
	
	public Date getDate(String dateStr)
	{
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			date = sdf.parse(dateStr);
		}catch(Exception ex)
		{
			LogUtil.logError.error(ex.getMessage());
		}
		return date;
	}
	
	@Override
	public Page<TFollowupQuestionnaireDetailInfo> queryFollowupQuestionnaireList(QuestionnaireListQueryReq req) {
		// TODO Auto-generated method stub
		if(req.getNum()==0)
			req.setNum(10);
		if(StringUtils.isEmpty(req.getSubject()))
			req.setSubject(null);
		PageHelper.startPage(req.getPage() + 1, req.getNum());
		List<TFollowupQuestionnaireDetailInfo> list = dao.queryFollowups(req);
		return PageUtil.returnPage((com.github.pagehelper.Page<TFollowupQuestionnaireDetailInfo>)list);
	}

	@Override
	public String saveFollowupQuestionnaireResult(TQuestionnaireResult result) {
		// TODO Auto-generated method stub
		if(result.getStemList()==null || result.getStemList().size()<1)
		{
			throw new EmptyParamExcption("param error param:"+JsonUtil.toJson(result));
		}
		//如果返回结果Id  则更新
		if(StringUtils.isNotEmpty(result.getQuestionnaireResultId())){
			resultDao.deleteQuestionnaireOptionResult(result.getQuestionnaireResultId());
			resultDao.deleteQuestionnaireStemResult(result.getQuestionnaireResultId());
			resultDao.deleteQuestionnaireResult(result.getQuestionnaireResultId());
		}
		// 问卷结果ID
		String questionnaireResultId = GeneralUtil.generateUniqueID("QRES");

		// 问卷结果
		result.setQuestionnaireResultId(questionnaireResultId);
		resultDao.insertQuestionnaireResult(result);

		for (TQuestionnaireResultStem stem : result.getStemList()) {// 保存问卷题干
			if(stem.getQuestionOptions()!=null&&stem.getQuestionOptions().size()>0){
				stem.setQuestionnaireResultStemId(GeneralUtil.generateUniqueID("QRST"));
				stem.setQuestionnaireResultId(questionnaireResultId);
				stem.setQuestionnaireId(result.getQuestionnaireId());
				stem.setAnswerFlag(1);
				// 是否选中
				boolean isCheck = saveResultOptions(stem.getQuestionOptions(),stem.getQuestionnaireId(), questionnaireResultId, stem.getQuestionnaireResultStemId());
				if (isCheck) {
					resultStemDao.insertQuestionnaireResultStem(stem);
				}
			}
		}
		return questionnaireResultId;
	}
	
	/**
	 * 查询问卷结果
	 */
	@Override
	public TQuestionnaireResult queryFollowupQuestionnaireResult(FollowupQuestionnaireResultReq req) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(req.getQuestionnaireResultId())
				&&(req.getPatientId()==null&&StringUtils.isEmpty(req.getQuestionnaireId())&&StringUtils.isEmpty(req.getFollowupItemId())))
			throw new EmptyParamExcption("param error,param:"+JsonUtil.toJson(req));
		TQuestionnaireResult result = resultDao.queryQuestionnaireResult(req);
		if(result==null)
			throw new EmptyObjectExcption(" questionnaireresult is null");
		return result;
	}

	@Override
	public List<TQuestionnairePatientInfo> queryPatientAnswerByQuestionnaireId(String questionnaireId,String followupTaskId) {
		List<TQuestionnairePatientInfo> patientAnswerList=dao.queryPatientAnswerByQuestionnaireId(questionnaireId,followupTaskId);
		return patientAnswerList;
	}

	@Override
	public List<TQuestionnaireResultStem> queryFollowupQuestionnaireResult(String questionnaireResultId,
			String followupItemId) {
		// TODO Auto-generated method stub
		return null;
	}
}
