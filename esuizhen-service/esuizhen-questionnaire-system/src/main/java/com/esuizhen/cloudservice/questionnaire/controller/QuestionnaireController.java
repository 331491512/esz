package com.esuizhen.cloudservice.questionnaire.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.questionnaire.bean.FollowupMsgSendReq;
import com.esuizhen.cloudservice.questionnaire.bean.FollowupQuestionnaireResultReq;
import com.esuizhen.cloudservice.questionnaire.bean.QuestionnaireListQueryReq;
import com.esuizhen.cloudservice.questionnaire.bean.QuestionnaireQueryReq;
import com.esuizhen.cloudservice.questionnaire.bean.QuestionnaireResultListReq;
import com.esuizhen.cloudservice.questionnaire.bean.TFollowupQuestionnaireDetailInfoReq;
import com.esuizhen.cloudservice.questionnaire.bean.WXSendReq;
import com.esuizhen.cloudservice.questionnaire.model.TFollowupQuestionnaireDetailInfo;
import com.esuizhen.cloudservice.questionnaire.model.TQuestionnaireResult;
import com.esuizhen.cloudservice.questionnaire.model.TQuestionnaireResultStem;
import com.esuizhen.cloudservice.questionnaire.service.QuestionnaireHelper;
import com.esuizhen.cloudservice.questionnaire.service.QuestionnaireService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.ObjectAlreadyExistExcption;
import com.westangel.common.util.LogUtil;

/**
 * 
* @ClassName: FollowupController 
* @Description: 随访计划控制器
* @author wang_hw
* @date 2015年12月2日 下午6:18:25
 */
@Controller
public class QuestionnaireController
{
	/**
	 * 问卷服务
	 */
	@Autowired
	private QuestionnaireService questionnaireService; 
	@Autowired
	private QuestionnaireHelper questionnaireHelper; 
	
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	/**
	 * 
	 * @author wang_hw
	 * @title :addFollowupQuestionnaire
	 * @Description:添加问卷
	 * @return TMsgResponse<String>
	 * @date 2015年12月7日 下午1:57:35
	 */
	@ResponseBody
	@RequestMapping(value="/add" , method=RequestMethod.POST)
	public TMsgResponse<Map<String , String>> addFollowupQuestionnaire(@RequestBody TFollowupQuestionnaireDetailInfo detailInfo , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Map<String , String>> msg = new TMsgResponse<Map<String , String>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//添加问卷
			String questionnaireId = questionnaireService.addFollowupQuestionnaire(detailInfo);
			
			//设置返回结果
			Map<String , String> result = new HashMap<String , String>();
			result.put("questionnaireId", questionnaireId);
			msg.result=result;
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 
	 * @author wang_hw
	 * @title :deleteFollowupQuestionnaire
	 * @Description:修改随访问卷
	 * @return TMsgResponse<Map<String,String>>
	 * @date 2015年12月7日 下午8:22:37
	 */
	@ResponseBody
	@RequestMapping(value="/update" , method=RequestMethod.POST)
	public TMsgResponse<Map<String , String>> deleteFollowupQuestionnaire(@RequestBody TFollowupQuestionnaireDetailInfo detailInfo  , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Map<String , String>> msg = new TMsgResponse<Map<String , String>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//修改问卷
			String questionnaireId = questionnaireService.updateFollowupQuestionnaire(detailInfo);
			//设置返回结果
			Map<String , String> result = new HashMap<String , String>();
			result.put("questionnaireId", questionnaireId);
			msg.result=result;
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
			ex.printStackTrace();
		}
		return msg;
	}

	/**
	 * 
	 * @author wang_hw
	 * @title :updateFollowupQuestionnaire
	 * @Description:删除问卷
	 * @return TMsgResponse<Map<String,String>>
	 * @date 2015年12月11日 下午5:35:53
	 */
	@ResponseBody
	@RequestMapping(value="/delete" , method=RequestMethod.GET)
	public TMsgResponse<Map<String , String>> updateFollowupQuestionnaire(String questionnaireId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Map<String , String>> msg = new TMsgResponse<Map<String , String>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//删除问卷
			questionnaireService.deleteFollowupQuestionnaire(questionnaireId);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * @author wang_hw
	 * @title :queryFollowupQuestionnaire
	 * @Description:问卷明细查看
	 * @return TMsgResponse<TFollowupQuestionnaireDetailInfo>
	 * @date 2015年12月11日 下午5:36:34
	 */
	@ResponseBody
	@RequestMapping(value="/query" , method=RequestMethod.GET)
	public TMsgResponse<TFollowupQuestionnaireDetailInfoReq> queryFollowupQuestionnaire(QuestionnaireQueryReq req , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<TFollowupQuestionnaireDetailInfoReq> msg = new TMsgResponse<TFollowupQuestionnaireDetailInfoReq>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//问卷查看
			msg.result = questionnaireService.queryFollowupQuestionnaire(req);
			
			if(msg.result==null)
			{//如果为空
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		}catch(EmptyObjectExcption ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1404.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			LogUtil.logError.error(ex.getMessage(),ex);
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage(),ex);
		}
		return msg;
	}
	
	/**
	 * 
	 * @author wang_hw
	 * @title :followupQuestionnaireResultList
	 * @Description:患者问卷列表查看
	 * @return TMsgResponse<Page<TQuestionnaireResultSimpleInfo>>
	 * @date 2015年12月11日 下午6:46:57
	 */
	@ResponseBody
	@RequestMapping(value="/result/list" , method=RequestMethod.GET)
	public TMsgResponse<Page<TQuestionnaireResult>> followupQuestionnaireResultList(QuestionnaireResultListReq req , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page<TQuestionnaireResult>> msg = new TMsgResponse<Page<TQuestionnaireResult>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//患者问卷列表
			msg.result = questionnaireService.followupQuestionnaireResultList(req);
			
			if(msg.result==null || msg.result.getTotalNum()==0)
			{//如果为空
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * @author wang_hw
	 * @title :wirteFollowupQuestionnaireResult
	 * @Description:问卷结果填写-云端
	 * @return TMsgResponse<List<TQuestionnaireResultStem>>
	 * @date 2015年12月31日 下午2:08:54
	 */
	@ResponseBody
	@RequestMapping(value="/result/wirte" , method=RequestMethod.POST)
	public TMsgResponse<String> writeFollowupQuestionnaireResult(@RequestBody TQuestionnaireResult result, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//问卷结果填写
			msg.result = questionnaireService.writeFollowupQuestionnaireResult(result);
			//msg.result=questionnaireService.saveFollowupQuestionnaireResult(result);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			ex.printStackTrace();
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 问卷结果明细查看
	 * @author wang_hw
	 * @title :queryFollowupQuestionnaireResult
	 * @Description:TODO
	 * @return TMsgResponse<LinkedHashMap<String,Object>>
	 * @date 2015年12月11日 下午8:04:49
	 */
	@ResponseBody
	@RequestMapping(value="/result/query" , method=RequestMethod.GET)
	public TMsgResponse<List<TQuestionnaireResultStem>> queryFollowupQuestionnaireStemResult(FollowupQuestionnaireResultReq req , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TQuestionnaireResultStem>> msg = new TMsgResponse<List<TQuestionnaireResultStem>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//问卷结果查看
			TQuestionnaireResult questionResult = questionnaireService.queryFollowupQuestionnaireResult(req);
			msg.result = questionResult.getStemList();
		}catch(EmptyObjectExcption ex){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1404.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}catch(Exception ex){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryFollowupQuestionnaireList
	 * @Description:问卷列表获取
	 * @return TMsgResponse<Page<TFollowupQuestionnaireDetailInfo>>
	 * @date 2016年8月5日 下午4:42:29
	 */
	@ResponseBody
	@RequestMapping(value="/list" , method=RequestMethod.POST)
	public TMsgResponse<Page<TFollowupQuestionnaireDetailInfo>> queryFollowupQuestionnaireList(@RequestBody QuestionnaireListQueryReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page<TFollowupQuestionnaireDetailInfo>> msg = new TMsgResponse<Page<TFollowupQuestionnaireDetailInfo>>();
				msg.respCode=ErrorMessage.SUCCESS.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
				try
				{
					msg.result = questionnaireService.queryFollowupQuestionnaireList(req);
					if(msg.result==null)
					{//如果为空
						msg.respCode=ErrorMessage.E1404.code;
						msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
					}
				}catch(Exception ex)
				{
					//设置错误代码及提示消息
					msg.respCode=ErrorMessage.E1417.code;
					msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
					LogUtil.logError.error(ex.getMessage());
				}
				return msg;
	}
	
	/**
	 * @author 
	 * @title :saveFollowupQuestionnaireResult
	 * @Description:问卷结果填写-B端
	 * @return TMsgResponse<String>: resultId
	 * @date 2015年12月31日 下午2:08:54
	 */
	@ResponseBody
	@RequestMapping(value="/result/save" , method=RequestMethod.POST)
	public TMsgResponse<String> saveFollowupQuestionnaireResult(@RequestBody TQuestionnaireResult result, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//问卷结果填写
			msg.result = questionnaireService.saveFollowupQuestionnaireResult(result);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			ex.printStackTrace();
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryFollowupQuestionnaireResult
	 * @Description:问卷随访结果获取
	 * @return TMsgResponse<TQuestionnaireResult>
	 * @date 2017年7月27日 下午7:48:55
	 */
	@ResponseBody
	@RequestMapping(value="/result/detail" , method=RequestMethod.GET)
	public TMsgResponse<TQuestionnaireResult> queryFollowupQuestionnaireResult(FollowupQuestionnaireResultReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<TQuestionnaireResult> msg = new TMsgResponse<TQuestionnaireResult>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//问卷结果填写
			msg.result = questionnaireService.queryFollowupQuestionnaireResult(req);
			
		}catch(EmptyObjectExcption ex){
			//设置错误代码及提示消息
			ex.printStackTrace();
			msg.respCode=ErrorMessage.E1404.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}catch(Exception ex){
			//设置错误代码及提示消息
			ex.printStackTrace();
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@RequestMapping(value="/result/export" , method=RequestMethod.GET)
	public void exportPatientAnswerByQuestionnaireId(HttpServletResponse response,String questionnaireId,String followupTaskId, Locale locale) throws IOException
	{
		String[] headers = messageSource.getMessage("questionnaire.excel.header", null, locale).split(",");
		String[] headerFields = messageSource.getMessage("questionnaire.excel.field", null, locale).split(",");
		String fileName = messageSource.getMessage("questionnaire.excel.fileName", null, locale);
		response.setContentType("application/x-excel");
		response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream out = response.getOutputStream();
		questionnaireHelper.exportExcel(questionnaireId,followupTaskId, headers, headerFields, out);
		out.close();
	}
	
	/**
	 * 给患者发送问卷随访
	 * @param followupMsgSendReq
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/do/questionnaire/send", method = RequestMethod.POST)
	public TMsgResponse<Map<String,Integer>> sendQuestionnaireFollowup(@RequestBody FollowupMsgSendReq followupMsgSendReq, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Map<String,Integer>> msg = new TMsgResponse<Map<String,Integer>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			msg.result = questionnaireService.sendQuestionnaireFollowup(followupMsgSendReq);
		} catch (ObjectAlreadyExistExcption ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1409.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1409.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/wx/message/send" , method=RequestMethod.POST)
	public TMsgResponse<String> sendWXFollowupMessage(@RequestBody WXSendReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//模版更新
			questionnaireService.sendWXMessage(req);
		}catch(EmptyParamExcption e){
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=e.getMessage();
		}catch(EmptyObjectExcption e){
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=e.getMessage();
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 扫描问卷回复结果=========单元测试用，正式环境走定时任务
	 * @param followupMsgSendReq
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/test/questionnaire/sync/result", method = RequestMethod.GET)
	public TMsgResponse<Map<String,Integer>> scanQuestionnaireReply(Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Map<String,Integer>> msg = new TMsgResponse<Map<String,Integer>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			questionnaireService.scanQuestionnaireReply();
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}
