
package com.esuizhen.cloudservice.research.controller.crf;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.research.model.crf.TCrfScheme;
import com.esuizhen.cloudservice.research.model.crf.TCrfSchemeChemotherapyMedication;
import com.esuizhen.cloudservice.research.model.crf.TCrfSchemeOther;
import com.esuizhen.cloudservice.research.model.crf.TCrfSchemeOtherInfo;
import com.esuizhen.cloudservice.research.model.crf.TCrfSchemeRadiotherapy;
import com.esuizhen.cloudservice.research.service.crf.TCrfSchemeService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
* @ClassName: TCrfSchemeController 
* @Description: 放化疗方案处理器
* @author wang_hw
* @date 2016年4月14日 下午6:22:38
 */
@Controller
public class TCrfSchemeController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TCrfSchemeService crfSchemeService; 
	/**
	 * @author wang_hw
	 * @title :queryCrfSchemeChemotherapyMedicationDetail
	 * @Description:观察项-化疗/靶向用药方案明细查看
	 * @return TMsgResponse<TCrfScheme>
	 * @date 2016年4月14日 下午6:17:53
	 */
	@ResponseBody
	@RequestMapping(value="/crf/treatment/scheme/chemotherapy/medication/detail/query" , method=RequestMethod.GET)
	public TMsgResponse<List<TCrfScheme>> queryCrfSchemeChemotherapyMedicationDetail(String crfObserveId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TCrfScheme>> msg = new TMsgResponse<List<TCrfScheme>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = crfSchemeService.queryCrfSchemeChemotherapyMedicationDetail(crfObserveId);
			
			if(msg.result==null || msg.result.size()<1)
			{
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * @author wang_hw
	 * @title :create
	 * @Description:CRF观察项-化疗/靶向用药方案明细设置
	 * @return TMsgResponse<String>
	 * @date 2016年4月14日 下午6:18:11
	 */
	@ResponseBody
	@RequestMapping(value="/crf/treatment/scheme/chemotherapy/medication/detail/save" , method=RequestMethod.POST)
	public TMsgResponse<String> saveCrfSchemeChemotherapyMedicationDetail(@RequestBody TCrfSchemeChemotherapyMedication crfSchemeChemotherapyMedication  , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//保存
			crfSchemeService.saveCrfSchemeChemotherapyMedicationDetail(crfSchemeChemotherapyMedication);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * @author wang_hw
	 * @title :queryCrfSchemeRadiotherapyDetail
	 * @Description:观察项-放疗方案明细查看
	 * @return TMsgResponse<String>
	 * @date 2016年4月14日 下午6:18:26
	 */
	@ResponseBody
	@RequestMapping(value="/crf/treatment/scheme/radiotherapy/detail/query" , method=RequestMethod.GET)
	public TMsgResponse<List<TCrfScheme>> queryCrfSchemeRadiotherapyDetail(String crfObserveId, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TCrfScheme>> msg = new TMsgResponse<List<TCrfScheme>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = crfSchemeService.queryCrfSchemeRadiotherapyDetail(crfObserveId);
			
			if(msg.result==null || msg.result.size()<1)
			{
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * @author wang_hw
	 * @title :saveCrfSchemeRadiotherapyDetail
	 * @Description:观察项-放疗方案明细设置
	 * @return TMsgResponse<String>
	 * @date 2016年4月14日 下午6:18:43
	 */
	@ResponseBody
	@RequestMapping(value="/crf/treatment/scheme/radiotherapy/detail/save" , method=RequestMethod.POST)
	public TMsgResponse<String> saveCrfSchemeRadiotherapyDetail(@RequestBody TCrfSchemeRadiotherapy crfSchemeRadiotherapy , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//保存
			crfSchemeService.saveCrfSchemeRadiotherapyDetail(crfSchemeRadiotherapy);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/crf/treatment/scheme/other/detail/query" , method=RequestMethod.GET)
	public TMsgResponse<List<TCrfSchemeOtherInfo>> queryCrfSchemeOtherDetail (String crfObserveId, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TCrfSchemeOtherInfo>> msg = new TMsgResponse<List<TCrfSchemeOtherInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = crfSchemeService.queryCrfTreatmentSchemeOtherDetail(crfObserveId);
			
			if(msg.result==null || msg.result.size()<1)
			{
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/crf/treatment/scheme/other/detail/save" , method=RequestMethod.POST)
	public TMsgResponse<String> saveCrfTreatmentSchemeOtherDetail(@RequestBody TCrfSchemeOther  crfSchemeOther , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//保存
			crfSchemeService.saveCrfTreatmentSchemeOtherDetail(crfSchemeOther);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}

