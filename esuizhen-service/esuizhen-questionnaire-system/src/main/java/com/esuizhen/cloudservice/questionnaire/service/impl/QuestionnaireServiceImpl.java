package com.esuizhen.cloudservice.questionnaire.service.impl;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.questionnaire.bean.FollowupMsgSendReq;
import com.esuizhen.cloudservice.questionnaire.bean.FollowupQuestionnaireResultReq;
import com.esuizhen.cloudservice.questionnaire.bean.QuestionnaireListQueryReq;
import com.esuizhen.cloudservice.questionnaire.bean.QuestionnaireQueryReq;
import com.esuizhen.cloudservice.questionnaire.bean.QuestionnaireResultListReq;
import com.esuizhen.cloudservice.questionnaire.bean.TFollowupPlanDetialInfo;
import com.esuizhen.cloudservice.questionnaire.bean.TFollowupQuestionnaireDetailInfoReq;
import com.esuizhen.cloudservice.questionnaire.bean.TFollowupResultDetailInfo;
import com.esuizhen.cloudservice.questionnaire.bean.WXSendReq;
import com.esuizhen.cloudservice.questionnaire.dao.FollowupContentTemplateInfoDao;
import com.esuizhen.cloudservice.questionnaire.dao.FollowupGlobalConfigInfoDao;
import com.esuizhen.cloudservice.questionnaire.dao.FollowupQuestionnaireReqDao;
import com.esuizhen.cloudservice.questionnaire.dao.PatientDao;
import com.esuizhen.cloudservice.questionnaire.dao.QuestionnaireDao;
import com.esuizhen.cloudservice.questionnaire.dao.QuestionnaireOptionsDetailDao;
import com.esuizhen.cloudservice.questionnaire.dao.QuestionnaireResultDao;
import com.esuizhen.cloudservice.questionnaire.dao.QuestionnaireResultOptionsDetailDao;
import com.esuizhen.cloudservice.questionnaire.dao.QuestionnaireResultStemDao;
import com.esuizhen.cloudservice.questionnaire.dao.QuestionnaireStemDao;
import com.esuizhen.cloudservice.questionnaire.model.TFollowupContentTemplateInfo;
import com.esuizhen.cloudservice.questionnaire.model.TFollowupGlobalConfigInfo;
import com.esuizhen.cloudservice.questionnaire.model.TFollowupQuestionnaireDetailInfo;
import com.esuizhen.cloudservice.questionnaire.model.TFollowupQuestionnaireOptions;
import com.esuizhen.cloudservice.questionnaire.model.TFollowupQuestionnaireReqInfo;
import com.esuizhen.cloudservice.questionnaire.model.TFollowupQuestionnaireStem;
import com.esuizhen.cloudservice.questionnaire.model.TQuestionnairePatientInfo;
import com.esuizhen.cloudservice.questionnaire.model.TQuestionnaireResult;
import com.esuizhen.cloudservice.questionnaire.model.TQuestionnaireResultOptionsDetail;
import com.esuizhen.cloudservice.questionnaire.model.TQuestionnaireResultStem;
import com.esuizhen.cloudservice.questionnaire.service.FollowupTaskService;
import com.esuizhen.cloudservice.questionnaire.service.QuestionnaireService;
import com.esuizhen.cloudservice.questionnaire.service.thread.SendHttpRequestRunnable;
import com.esuizhen.cloudservice.questionnaire.util.MyHttpUtil;
import com.esuizhen.cloudservice.questionnaire.util.MyJsonUtil;
import com.esuizhen.cloudservice.questionnaire.util.UtilValidate;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.util.BeanUtils;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;
import com.westangel.common.util.PushContentUtil;
import com.westangel.common.util.PushUtil;
import com.westangel.common.util.ShortUrlBuilderUtil;

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
	private MessageSource messageSource;
	
	@Autowired
	private QuestionnaireResultDao resultDao;
	
	@Value("${server.wx.url.root}")
	private String wxUrl;
	
	@Value("${server.questionnaire.result.path}")
	private String resultPath;
	
	//
	@Value("${cloud.followup.url.root}")
	private String cloudFollowuUrlRoot;

	@Value("${cloud.sync.url.root}")
	private String cloudSyncUrlRoot;

	@Value("${local.url}")
	private String localUrl;
	
	@Value("${questionnaireFollowupMessageSendUrl}")
	private String questionnaireFollowupMessageSendUrl;
	
	@Value("${server.questionnaire.followup.tob.path}")
	private String questionnaireUrl;
	
	@Value("${smsFollowupTemplateMessageSend}")
	private String smsFollowupTemplateMessageSendUrl;
	
	
	@Value("${updateFollowupPlanDetailUrl}")
	private String updateFollowupPlanDetailUrl;
	
	@Value("${updateFollowupResultToCUrl}")
	private String updateFollowupResultToCUrl;
	
	@Value("${guessDeathDateUrl}")
	private String guessDeathDateUrl;
	
	@Autowired
	private FollowupContentTemplateInfoDao followupContentTemplateInfoDao;
	
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private FollowupGlobalConfigInfoDao followupGlobalConfigInfoDao;
	
	@Autowired
	private FollowupTaskService followupTaskService;
	
	@Autowired
	private PushInnerService pushInnerService;
	
	@Autowired
	private FollowupQuestionnaireReqDao followupQuestionnaireReqDao;
	
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
//			stem.setQuestionType(1);//前端传值过来，edit by yuan_wm
			stem.setStemCode(stem.getStemIndex().toString());
			dao.insertQuestionnaireStem(stem);
			if (stem.getQuestionOptions() != null && stem.getQuestionOptions().size() > 0) {// 判断是否有问题选项
				//加载题肢
				loadingOptionns(optionsAll, stem, stem.getQuestionOptions(), "0", 0);
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
		questionnaireDetailInfoReq.setType(questionnaireDetailInfo!=null?questionnaireDetailInfo.getType():2);
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
	public String  writeFollowupQuestionnaireResult(TQuestionnaireResult result)
	{
		if(result.getStemList()==null || result.getStemList().size()<1)return null;
		//保存问卷结果
		String questionnaireResultId = this.saveFollowupQuestionnaireResult(result);
		//问卷解析随访结果
		this.analyzeFollowupResult(result);
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
		//更新随访计划
		if(!StringUtils.isEmpty(result.getFollowupItemId()))
		{
			TFollowupPlanDetialInfo followupPlanDetialInfo = new TFollowupPlanDetialInfo();
			followupPlanDetialInfo.setFollowupItemId(result.getFollowupItemId());
			followupPlanDetialInfo.setIsSurveryFeedback(1);
			followupPlanDetialInfo.setIsAlertSent(1);
			followupPlanDetialInfo.setPatientId(Long.parseLong(result.getPatientId()));
		
			MyHttpUtil.postJson(cloudFollowuUrlRoot+updateFollowupPlanDetailUrl, followupPlanDetialInfo);
			//followupPlanDao.updateFollowupPlanDetail(followupPlanDetialInfo);;
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

	@Override
	public Map<String,Integer> sendQuestionnaireFollowup(FollowupMsgSendReq followupMsgSendReq) throws Exception{
		if (followupMsgSendReq == null)
			throw new EmptyParamExcption(" param error followupWxReqInfo is null");
		if (StringUtils.isEmpty(followupMsgSendReq.getTemplateId()))
			throw new EmptyParamExcption(" param error templateId is null");
		if (StringUtils.isEmpty(followupMsgSendReq.getTaskId()))
			throw new EmptyParamExcption(" param error taskId is null");
		if (followupMsgSendReq.getHospitalId() == null)
			throw new EmptyParamExcption(" param error hospitalId is null");
		Map<String, Object> hospitalMap = patientDao.queryHospitalInfoByHospitalId(followupMsgSendReq.getHospitalId());
		if(hospitalMap == null) {
			throw new EmptyParamExcption(" param error hospitalId is error");
		}
		int hospitalId = ((Number)hospitalMap.get("hospitalId")).intValue();
		String hospitalName = (String)hospitalMap.get("hospitalName");
		
		TMsgResponse<Object> tMsgResponse = null;
		//判断下发问卷是否同步到云端，如果同步，则返回前端
		QuestionnaireQueryReq req = new QuestionnaireQueryReq();
		req.setContentTemplateId(followupMsgSendReq.getTemplateId());
		TFollowupQuestionnaireDetailInfo questionnaire = dao.queryQuestionnaireById(req);
		if(questionnaire == null) {
			throw new EmptyParamExcption(" param error questionnaire is null");
		}
		followupMsgSendReq.setQuestionnaireId(questionnaire.getQuestionnaireId());
		if(questionnaire.getSyncFlag() != 1) {
			// 下发问卷至云端
			tMsgResponse = sendQuestionnaireFollowupMessage(followupMsgSendReq);
			if(tMsgResponse.getRespCode() != 0) {
				throw new EmptyParamExcption(" questionnaire to cloud is error");
			}
		}
		
		Map<String,Integer> viewResult = new HashMap<String,Integer>();
		//根据条件查询出需要给多少患者发送问卷,如果list不为空，以list数据为准，否则以查询条件为准。
		List<Map<String,Object>> patientInfoList = followupMsgSendReq.getPatientInfoList();
		if(patientInfoList == null || patientInfoList.size() == 0) {
			patientInfoList = followupTaskService.queryFollowupTaskPatientList(followupMsgSendReq);
		}
		if(patientInfoList != null && patientInfoList.size() > 0) {
			viewResult.put("totalNum", patientInfoList.size());
			viewResult.put("hasSendNum", 0);
			viewResult.put("repeatSendNum", 0);
			viewResult.put("invalidNum", 0);
			
			int repeatSendCount=0;
			for(Map<String,Object> map :patientInfoList) {
				boolean flag = true;//默认患者没有发送过问卷
				Long patientId = ((Number)map.get("patientId")).longValue();
				String trueName = null;
				String patientTrueName = (String)map.get("patientTrueName");
				if(StringUtils.isNotEmpty(patientTrueName)) {
					trueName = patientTrueName;
				}else {
					trueName = (String)map.get("trueName");
				}
				followupMsgSendReq.setPatientId(patientId);
				Map<String,Object> paramsMap = new HashMap<String,Object>();
				paramsMap.put("messageId", followupMsgSendReq.getQuestionnaireId());
				paramsMap.put("followupTaskId", followupMsgSendReq.getTaskId());
				paramsMap.put("followupAssignId", followupMsgSendReq.getAssignId());
				paramsMap.put("patientId", patientId);
				TFollowupQuestionnaireReqInfo questionnaireReqInfo = followupQuestionnaireReqDao.queryFollowupQuestionnaireReq(paramsMap);
				if(questionnaireReqInfo != null) {
					if(questionnaireReqInfo.getState() == 1) {
						repeatSendCount++;
						LogUtil.log.debug("[问卷随访下发-该患者已经随访过]" + paramsMap);
						continue;
					}
					flag = false;
				}
				//如果已经存在问卷结果，则不发送问卷
				Map<String , Object> questionnaireResultMap = new HashMap<String , Object>();
				questionnaireResultMap.put("followupItemId", followupMsgSendReq.getTaskId());
				questionnaireResultMap.put("patientId", patientId);
				questionnaireResultMap.put("questionnaireId", followupMsgSendReq.getQuestionnaireId());
				int questionnaireResultInt = resultDao.existsQuestionnaireResult(questionnaireResultMap);
				if(questionnaireResultInt > 0) {
					repeatSendCount++;
					LogUtil.log.debug("[问卷随访下发-该患者已经有过问卷随访结果了]" + questionnaireResultMap);
					continue;
				}
				/**
				 * 调查问卷以邮件或者微信发给患者
				 * 如果患者没有关注微信，以邮件通知
				 */
				// 判断患者是否关注微信
				tMsgResponse = existsWxUser(followupMsgSendReq);
				if(tMsgResponse.getRespCode() == 0 && tMsgResponse.getResult() != null) {
					Map<String,Object> resultMap = (Map<String,Object>)tMsgResponse.getResult();
					String openId = (String)resultMap.get("openId");
					String url = wxUrl+questionnaireUrl+"?hospitalId="+hospitalId+"&questionnaireId="+followupMsgSendReq.getQuestionnaireId()+"&patientId="+resultMap.get("patientId")+"&userId="+resultMap.get("userId")+"&sourceFlag=3&followupItemId="+followupMsgSendReq.getTaskId();
					//下发问卷请求
					TFollowupQuestionnaireReqInfo params = new TFollowupQuestionnaireReqInfo();
					params.setFollowupAssignId(followupMsgSendReq.getAssignId());
					params.setFollowupTaskId(followupMsgSendReq.getTaskId());
					params.setHospitalId(followupMsgSendReq.getHospitalId());
					params.setMessageId(followupMsgSendReq.getQuestionnaireId());
					params.setOpenId(openId);
					params.setPatientId(patientId);
					params.setTemplateId(followupMsgSendReq.getTemplateId());
					params.setTrueName(trueName);
					params.setSignature(hospitalName);
					params.setSendTime(new Date());
					params.setQuestionnaireUrl(url);
					if(StringUtils.isNotEmpty(openId)) {
						params.setChannel(1);
					}else {
						String mobile = null;
						Map<String, Object> patientMap = patientDao.getValidContactMobile(patientId);
						if(UtilValidate.isEmpty(patientMap)) {//无效电话
							Integer tmpValue = viewResult.get("invalidNum") + 1;
							viewResult.put("invalidNum", tmpValue);
							continue;
						}
						mobile = (String) patientMap.get("mobile");
						params.setMobile(mobile);
						List<Map> resultList = ShortUrlBuilderUtil.buiderShortUrlUTF(url);
						if(resultList == null) {
							LogUtil.log.error("生成短连接失败！！！");
							break;
						}
						String urlShort = (String)resultList.get(0).get("url_short");
						String contentTemplate="【{0}】{1}您好，现有一份调查问卷望您配合填写，感谢您的配合！点击链接填写：{2}。";
						String content = MessageFormat.format(contentTemplate, params.getSignature(),params.getTrueName(),urlShort);
						params.setContent(content);
						params.setChannel(2);
					}
					if(flag) {
						followupQuestionnaireReqDao.createFollowupQuestionnaireReq(params);
					}else {
						params.setReqId(questionnaireReqInfo.getReqId());
					}
					if(StringUtils.isNotEmpty(openId)) {//微信通知
						tMsgResponse = this.sendWx(params,viewResult);
					}else {//短信通知
						tMsgResponse = sendSms(params,viewResult);
					}
					Integer state = 0;
					if(tMsgResponse.getRespCode()==0) {
						Integer tmpValue = viewResult.get("hasSendNum") + 1;
						viewResult.put("hasSendNum", tmpValue);
						state = 1;
					}else {
						state = 2;
					}
					TFollowupQuestionnaireReqInfo updateParams = new TFollowupQuestionnaireReqInfo();
					updateParams.setReqId(params.getReqId());
					updateParams.setState(state);
					followupQuestionnaireReqDao.updateFollowupQuestionnaireReq(updateParams);
					//更新随访任务患者关系表信息，把问卷状态值置为3，标识患者已经回复,方便查询使用
					Map<String, Object> followupTaskPatientMap = new HashMap<String, Object>();
					followupTaskPatientMap.put("followupTaskId", followupMsgSendReq.getTaskId());
					followupTaskPatientMap.put("patientId", patientId);
					followupTaskPatientMap.put("questionnaireState", state);
					followupTaskPatientMap.put("questionnaireReqId", params.getReqId());
					followupTaskService.updateFollowupTaskPatient(followupTaskPatientMap);
				}else {//未同步的患者
					Integer tmpValue = viewResult.get("invalidNum") + 1;
					viewResult.put("invalidNum", tmpValue);
				}
			}
			viewResult.put("repeatSendNum", repeatSendCount);
		}
		return viewResult;
	}
	
	/**
	 * 下发问卷
	 */
	private TMsgResponse<Object> sendQuestionnaireFollowupMessage(FollowupMsgSendReq followupMsgSendReq) {
		String url = this.cloudSyncUrlRoot + "/sync/questionnaire/message/send";
		QuestionnaireQueryReq req = new QuestionnaireQueryReq();
		req.setQuestionnaireId(followupMsgSendReq.getQuestionnaireId());
		TFollowupQuestionnaireDetailInfo questionnaireDetailInfo = queryFollowupQuestionnaireSync(req);
		questionnaireDetailInfo.setFollowupTaskId(followupMsgSendReq.getTaskId());
		TFollowupContentTemplateInfo templateInfo = followupContentTemplateInfoDao.queryFollowupContentTemplateInfo(followupMsgSendReq.getTemplateId());
		questionnaireDetailInfo.setContentTemplateInfo(templateInfo);
		Map<String, Object> paramMap = BeanUtils.toMap(questionnaireDetailInfo);
		TMsgResponse<Object> tMsgResponse = MyHttpUtil.postJson(url, paramMap);
		TFollowupQuestionnaireDetailInfo questionnaireSync = new TFollowupQuestionnaireDetailInfo();
		questionnaireSync.setQuestionnaireId(followupMsgSendReq.getQuestionnaireId());
//		questionnaireSync.setFollowupTaskId(followupMsgSendReq.getTaskId());
		questionnaireSync.setSyncFlag(1);
		dao.updateQuestionnaireById(questionnaireSync);
		return tMsgResponse;
	}
	
	/**
	 * 判断患者是否关注微信
	 * @param followupMsgSendReq
	 */
	private TMsgResponse<Object> existsWxUser(FollowupMsgSendReq followupMsgSendReq) {
		Patient p = patientDao.findByPatientId(followupMsgSendReq.getPatientId());
		String url = this.cloudSyncUrlRoot + "/sync/wx/user/get?uuid="+p.getUuid();
		String messageJson = MyHttpUtil.httpGet(url);
		LogUtil.log.debug("[通过uuid查询云端的用户信息，messageJson]" + messageJson);
		TMsgResponse<Object> tMsgResponse = MyJsonUtil.toObject(messageJson, TMsgResponse.class);
		return tMsgResponse;
	}
	/**
	 * 短信推送
	 * @param followupMsgSendReq
	 * @return
	 */
	private TMsgResponse<Object> sendSms(TFollowupQuestionnaireReqInfo params,Map<String,Integer> viewResult) {
		// 未发送
		String url = localUrl + smsFollowupTemplateMessageSendUrl;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("businessId", 1);
		paramMap.put("productId", 1);
		paramMap.put("mobiles", params.getMobile().split(","));
		paramMap.put("content", params.getContent());
		TMsgResponse<Object> tMsgResponse = MyHttpUtil.postJson(url, paramMap);
		LogUtil.log.debug("sms send return message==>" + tMsgResponse);
		return tMsgResponse;
	}
	
	/**
	 * 微信推送
	 * @param followupMsgSendReq
	 * @return
	 */
	public TMsgResponse<Object> sendWx(TFollowupQuestionnaireReqInfo params,Map<String,Integer> viewResult){
		String url = this.cloudFollowuUrlRoot + questionnaireFollowupMessageSendUrl;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("hospitalId", params.getHospitalId());
		paramMap.put("messageId", params.getMessageId());
		paramMap.put("followupDate", DateUtil.convertToStr(new Date(), DateUtil.DATE_TIME_LINE));
		paramMap.put("openId", params.getOpenId());
		paramMap.put("url", params.getQuestionnaireUrl());
		paramMap.put("signature", params.getSignature());
		paramMap.put("content", params.getContent());
		TMsgResponse<Object> tMsgResponse = MyHttpUtil.postJson(url, paramMap);
		LogUtil.log.debug("wx send return message==>" + tMsgResponse);
		return tMsgResponse;
	}
	
	@Transactional
	@Override
	public void scanQuestionnaireReply() {
		TFollowupGlobalConfigInfo globalConfig = followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
		Integer hospitalId = globalConfig.getHospitalId();
		String questionnaireUrl = cloudSyncUrlRoot + "/sync/fromcloud/questionnaire/followupresult?hospitalId=" + hospitalId;
		LogUtil.log.debug("[扫描调查问卷结果请求wxUrl]:" + questionnaireUrl);
		// 调用微信接口获取回复结果
		String messageJson = MyHttpUtil.httpGet(questionnaireUrl);
		LogUtil.log.debug("[定时从云端拉取调查问卷回复结果messageJson]" + messageJson);
		TMsgResponse<List<Map<String, Object>>> tMsgResponse = MyJsonUtil.toObject(messageJson, TMsgResponse.class);
		if(tMsgResponse.getRespCode() != 0) {
			return;
		}
		List<Map<String, Object>> detailInfoMapList = tMsgResponse.getResult();
		if(detailInfoMapList != null && detailInfoMapList.size() > 0) {
			List<Map<String, Object>> notifyParamList = new ArrayList<Map<String, Object>>();
			for(Map<String, Object> questionnaireResultMap : detailInfoMapList) {
				String questionnaireResultId = (String)questionnaireResultMap.get("questionnaireResultId");
				String  followupItemId = (String)questionnaireResultMap.get("followupItemId");
				if(StringUtils.isEmpty(followupItemId)) {
					LogUtil.log.debug("[随访计划-随访任务id==>]:" + followupItemId);
					continue;
				}
				String patientUuid = (String)questionnaireResultMap.get("patientUuid");
				Patient p = patientDao.findByUuid(patientUuid);
				if(p == null) {
					LogUtil.log.debug("[通过患者uuid查询医院患者信息patientUuid==>]:" + patientUuid);
					continue;
				}
				Map<String , Object> reqMap = new HashMap<String , Object>();
				reqMap.put("followupItemId", followupItemId);
				reqMap.put("patientId", p.getPatientId());
				reqMap.put("questionnaireId", questionnaireResultMap.get("questionnaireId"));
				int questionnaireResultInt = resultDao.existsQuestionnaireResult(reqMap);
				if(questionnaireResultInt > 0) {
					LogUtil.log.debug("[B端已经存在此问卷结果，直接丢弃。reqMap==>]:" + reqMap);
					continue;
				}
				
				Map<String,Number> userMap = followupTaskService.queryUserByFollowupTaskId(followupItemId);
				if(userMap == null) {
					continue;
				}
				//更新随访任务患者关系表信息，把问卷状态值置为3，标识患者已经回复,方便查询使用
				Map<String, Object> followupTaskPatientMap = new HashMap<String, Object>();
				followupTaskPatientMap.put("followupTaskId", followupItemId);
				followupTaskPatientMap.put("patientId", p.getPatientId());
				followupTaskPatientMap.put("questionnaireState", 3);
				followupTaskService.updateFollowupTaskPatient(followupTaskPatientMap);
				//更新问卷下发信息，把replyState 置为1，标识患者已经回复
				TFollowupQuestionnaireReqInfo updateParams = new TFollowupQuestionnaireReqInfo();
				updateParams.setMessageId((String)questionnaireResultMap.get("questionnaireId"));
				updateParams.setFollowupTaskId(followupItemId);
				updateParams.setPatientId(p.getPatientId());
				updateParams.setReplyState(1);
				followupQuestionnaireReqDao.updateFollowupQuestionnaireReq(updateParams);
				
				TQuestionnaireResult questionnaireResult = new TQuestionnaireResult();
				questionnaireResult.setPatientId(p.getPatientId()+"");
				questionnaireResult.setCreatorId(((Long)userMap.get("operator")));
				questionnaireResult.setCreatorRole((Integer)userMap.get("userRole"));
				questionnaireResult.setQuestionnaireId((String)questionnaireResultMap.get("questionnaireId"));
				questionnaireResult.setQuestionnaireResultId(questionnaireResultId);
				questionnaireResult.setQuestionnaireResultUrl((String)questionnaireResultMap.get("questionnaireResultUrl"));
				questionnaireResult.setMergeFlag((Integer)questionnaireResultMap.get("mergeFlag"));
				questionnaireResult.setSourceFlag((Integer)questionnaireResultMap.get("sourceFlag"));
				questionnaireResult.setSyncFlag((Integer)questionnaireResultMap.get("syncFlag"));
				questionnaireResult.setFollowupItemId(followupItemId);
				resultDao.insertQuestionnaireResult(questionnaireResult);
				Map<String, Object> notifyParam = new HashMap<String, Object>();
				notifyParam.put("questionnaireResultId", questionnaireResultId);
				notifyParam.put("patientUuid", questionnaireResultMap.get("patientUuid"));
				notifyParamList.add(notifyParam);
				questionnaireResult = null;
				List<Map<String, Object>> stemList = (List<Map<String, Object>>)questionnaireResultMap.get("stemList");
				if(stemList != null && stemList.size() > 0) {
					for(Map<String, Object> questionnaireResultStemMap : stemList) {
						TQuestionnaireResultStem questionnaireResultStem = new TQuestionnaireResultStem();
						questionnaireResultStem.setAnswerFlag((Integer)questionnaireResultStemMap.get("answerFlag"));
						questionnaireResultStem.setContent((String)questionnaireResultStemMap.get("content"));
						questionnaireResultStem.setMandatoryFlag((Integer)questionnaireResultStemMap.get("mandatoryFlag"));
						questionnaireResultStem.setQuestionnaireId((String)questionnaireResultStemMap.get("questionnaireId"));
						questionnaireResultStem.setQuestionnaireResultId((String)questionnaireResultStemMap.get("questionnaireResultId"));
						questionnaireResultStem.setQuestionnaireResultStemId((String)questionnaireResultStemMap.get("questionnaireResultStemId"));
						questionnaireResultStem.setQuestionnaireStemId((String)questionnaireResultStemMap.get("questionnaireStemId"));
						questionnaireResultStem.setQuestionType((Integer)questionnaireResultStemMap.get("questionType"));
						questionnaireResultStem.setSectionId((Integer)questionnaireResultStemMap.get("sectionId"));
						questionnaireResultStem.setSectionTitle((String)questionnaireResultStemMap.get("sectionTitle"));
						questionnaireResultStem.setStemCode((String)questionnaireResultStemMap.get("stemCode"));
						questionnaireResultStem.setStemIndex((Integer)questionnaireResultStemMap.get("stemIndex"));
						resultStemDao.insertQuestionnaireResultStem(questionnaireResultStem);
						questionnaireResultStem = null;
						List<Map<String, Object>> questionOptionsList = (List<Map<String, Object>>)questionnaireResultStemMap.get("questionOptions");
						if(questionOptionsList != null && questionOptionsList.size() > 0) {
							Map<String, Object> paramsMap = new HashMap<String,Object>();
							paramsMap.put("questionnaireResultOptions", questionOptionsList);
							resultOptionsDetailDao.batchInsertQuestionnaireResultOptionsDetail(paramsMap);
							questionOptionsList = null;
						}
					}
				}
			}
			String questionnaireNotifyUrl = cloudSyncUrlRoot + "/sync/tocloud/result/notify";
			LogUtil.log.debug("[通知云端调查问卷结果已经同步请求questionnaireNotifyUrl]:" + questionnaireNotifyUrl);
			// 调用通知接口，告诉云端同步完成
			Map<String, Object> paramsMap = new HashMap<String,Object>();
			paramsMap.put("hospitalId", hospitalId);
			paramsMap.put("resultType", 4);
			paramsMap.put("uuids", notifyParamList);
			TMsgResponse<Object> notifyResult = MyHttpUtil.postJson(questionnaireNotifyUrl, paramsMap);
			LogUtil.log.debug("[通知云端调查问卷结果已经同步notifyResult=========]" + notifyResult);
		}
	}

	@Override
	public void sendWXMessage(WXSendReq req) {
		LogUtil.log.debug("###############start推送微信###############");
		if (req == null)
			throw new EmptyParamExcption(" param error WXSendReq is null");
		if (StringUtils.isEmpty(req.getMessageId()))
			throw new EmptyParamExcption(" param error messageId is null");
		if (req.getHospitalId() == null)
			throw new EmptyParamExcption(" param error hospitalId is null");
		if (StringUtils.isEmpty(req.getOpenId()))
			throw new EmptyParamExcption(" param error openId is null");
		
		Map<String, Object> user =  patientDao.queryPatientInfoByOpenId(req.getOpenId());
		req.setTrueName((String)user.get("trueName"));
		List<String> values = new ArrayList<String>();
		values.add(pushInnerService.getMessage(PushContentUtil.getFollowupPushContent(null, "followup.questionnaire.info", new Object[]{req.getSignature()})));
		values.add(req.getTrueName());
		values.add(DateUtil.getDateStr(req.getFollowupDate()));
		values.add(pushInnerService.getMessage(PushContentUtil.getFollowupPushContent(null, "followup.type.questionnaire.info")));
		values.add(req.getContent());
		
		String url = req.getUrl();
		LogUtil.log.debug("推送微信url===>" + url);
		PushNotifyInfo notify = PushUtil.getWxTemplatePushNotifyInfo("suifangtixing",url, values);
		notify.setUserId((Long)user.get("userId"));
		notify.setProductId((Integer)user.get("productId"));
		pushInnerService.push(notify);
		LogUtil.log.debug("###############推送微信end###############");
	}
	
	/**
	* @author fanpanwei
	* @date 2017年8月22日
	* @param 
	* @description:添加随访结果方法
	* @return
	 */
	private void addFollowupResult(TQuestionnaireResultOptionsDetail optionDetail,String patientId,String followupResultValue){
		TFollowupResultDetailInfo followupResult= new TFollowupResultDetailInfo();
		followupResult.setPatientId(Long.parseLong(patientId));
		Date nowDate = new Date();
		if("4".equals(followupResultValue)){//死亡
			//4标识死亡，可以没有死亡时间
			Date deathDate=null;
			//死亡时间自动估算控制
			if(StringUtils.isBlank(optionDetail.getFillContent2())){
				followupResult.setDeathDate(deathDate);
				TMsgResponse<Object> resp = MyHttpUtil.postJson(cloudFollowuUrlRoot+guessDeathDateUrl, followupResult);
				if(resp!=null){
					SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm:ss"); 
					try {
						deathDate=resp.getResult()!=null?format.parse(resp.getResult().toString()):null;
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else deathDate=getDate(optionDetail.getFillContent2());
			
			
			followupResult.setFollowupResultValue(4);
			followupResult.setDeathCause(optionDetail.getFillContent());
			followupResult.setDeathDate(deathDate);
		}else if("41".equals(followupResultValue)&&!StringUtils.isEmpty(optionDetail.getFillContent2())){
			//41 标识死亡，但是必须有死亡时间
			followupResult.setFollowupResultValue(4);
			followupResult.setDeathCause(optionDetail.getFillContent());
			followupResult.setDeathDate(getDate(optionDetail.getFillContent2()));
		}else if("1".equals(followupResultValue)){//稳定
			followupResult.setFollowupResultValue(1);
		}else if("2".equals(followupResultValue)){//复发
			followupResult.setFollowupResultValue(2);
			followupResult.setRelapseParts(optionDetail.getFillContent());
			followupResult.setRelapseDate(getDate(optionDetail.getFillContent2()));
		}else if("3".equals(followupResultValue)){//转移
			followupResult.setFollowupResultValue(3);
			followupResult.setTransferParts(optionDetail.getFillContent());
			followupResult.setTransferDate(getDate(optionDetail.getFillContent2()));
		}
		if(followupResult.getFollowupResultValue()!=null){
			followupResult.setFollowupResultBuffId(GeneralUtil.generatorUUID("RBUFF"));
			followupResult.setFollowupTaskId(GeneralUtil.generatorUUID("EMPTYTASK"));
			followupResult.setOperator(9l);
			followupResult.setFollowupWay(4);
			followupResult.setHospitalId(0);
			followupResult.setFollowupTime(nowDate);
			followupResult.setCreateTime(nowDate);
			followupResult.setUpdateTime(nowDate);
			followupResult.setSourceFlag(2);
			followupResult.setFollowupResultState(2);
			//更新患者随访结果
			ExecutorService es = Executors.newFixedThreadPool(10);
			es.submit(new SendHttpRequestRunnable(followupResult, cloudFollowuUrlRoot+updateFollowupResultToCUrl));
			es.shutdown();
			
			//MyHttpUtil.postJson(cloudFollowuUrlRoot+updateFollowupResultToCUrl, followupResult);
			
			//followupResultService.updateFollowupResultToC(followupResult);
		}
	}
	//解析随访结果
	private void analyzeFollowupResult(TQuestionnaireResult result){
		//StemType=1为解析随访结果题
		List<String> stemIdList = stemDao.getStemIdByStemType(result.getQuestionnaireId(),"1");
		if(stemIdList==null||stemIdList.size()==0)return;
		boolean cancelLoop = false;
		for(TQuestionnaireResultStem stem : result.getStemList())
		{//遍历问卷题干
			if(stemIdList.contains(stem.getQuestionnaireStemId())){
				for(TQuestionnaireResultOptionsDetail option : stem.getQuestionOptions())
				{//遍历问卷所选择的选项
					if(option.getIsChecked()==1)
					{//被选中
						TFollowupQuestionnaireOptions optionsDetail = optionsDao.queryQuestionnaireOptionsDetailById(option.getQuestionnaireOptionId());
						if(StringUtils.isNotBlank(optionsDetail.getIndicateValue())){
							this.addFollowupResult(option,result.getPatientId(),optionsDetail.getIndicateValue());
							cancelLoop=true;
							break;
						}
					}
				}
			}
			if(cancelLoop)break;
		}
	}
	
	
	/**
	 * 获取问卷相关项信息，用于同步到云端使用
	 * @param req
	 * @return
	 */
	private TFollowupQuestionnaireDetailInfo queryFollowupQuestionnaireSync(QuestionnaireQueryReq req)
	{
		
		if(StringUtils.isEmpty(req.getQuestionnaireId())&&StringUtils.isEmpty(req.getPatientId())&&StringUtils.isEmpty(req.getContentTemplateId())){
			throw new EmptyParamExcption(" param  is error param:"+JsonUtil.toJson(req)); 
		}
		//获取问卷项相关信息
		TFollowupQuestionnaireDetailInfo questionnaireDetailInfo=dao.queryQuestionnaireById(req);
		if(questionnaireDetailInfo==null)
			throw new EmptyObjectExcption(" questionnaireDetailInfo is null");
		List<TFollowupQuestionnaireStem> stemList = stemDao.queryStemOptionsByQuestionnaireId(questionnaireDetailInfo.getQuestionnaireId());
		questionnaireDetailInfo.setStemList(stemList);
		return questionnaireDetailInfo;
	}
}
