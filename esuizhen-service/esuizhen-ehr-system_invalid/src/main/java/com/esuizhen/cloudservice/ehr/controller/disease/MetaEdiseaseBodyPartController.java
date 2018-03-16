package com.esuizhen.cloudservice.ehr.controller.disease;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.model.disease.MetaEdiseaseBodyPart;
import com.esuizhen.cloudservice.ehr.service.disease.MetaEdiseaseBodyPartService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
@RequestMapping("/")
public class MetaEdiseaseBodyPartController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private MetaEdiseaseBodyPartService metaEdiseaseBodyPartService; 
	
	@ResponseBody
//	@RequestMapping(value="/create" , method=RequestMethod.POST)
	public TMsgResponse<String> create(@RequestBody MetaEdiseaseBodyPart metaEdiseaseBodyPart , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//创建
			metaEdiseaseBodyPartService.insertMetaEdiseaseBodyPart(metaEdiseaseBodyPart);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
//	@RequestMapping(value="/query" , method=RequestMethod.GET)
	public TMsgResponse<MetaEdiseaseBodyPart> query(Long metaEdiseaseBodyPartId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<MetaEdiseaseBodyPart> msg = new TMsgResponse<MetaEdiseaseBodyPart>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = metaEdiseaseBodyPartService.queryMetaEdiseaseBodyPart(metaEdiseaseBodyPartId);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
//	@RequestMapping(value="/delete" , method=RequestMethod.GET)
	public TMsgResponse<String> delete(Long metaEdiseaseBodyPartId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//删除
			metaEdiseaseBodyPartService.deleteMetaEdiseaseBodyPart(metaEdiseaseBodyPartId);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
//	@RequestMapping(value="/update" , method=RequestMethod.POST)
	public TMsgResponse<String> update(@RequestBody MetaEdiseaseBodyPart metaEdiseaseBodyPart , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//修改
			metaEdiseaseBodyPartService.updateMetaEdiseaseBodyPart(metaEdiseaseBodyPart);
			
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
	 * @title :metainfoDiseaseTypeList
	 * @Description:获取病种和疾病部位元数据
	 * @return TMsgResponse<List<MetaEdiseaseBodyPart>>
	 * @date 2015年12月29日 下午2:06:45
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/diseasetype/list" , method=RequestMethod.GET)
	public TMsgResponse<List<MetaEdiseaseBodyPart>> metainfoDiseaseTypeList(String diseaseTypeId , String timeFlag , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<MetaEdiseaseBodyPart>> msg = new TMsgResponse<List<MetaEdiseaseBodyPart>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询病种和疾病部位元数据
			msg.result = metaEdiseaseBodyPartService.selectMetaEdiseaseBodyPartTypeList(diseaseTypeId, timeFlag);
			
			if(msg.result==null || msg.result.size()<1)
			{
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
	
	@ResponseBody
	@RequestMapping(value="/metainfo/bodypart/list" , method=RequestMethod.GET)
	public TMsgResponse<List<MetaEdiseaseBodyPart>> metainfoBodypartList(Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<MetaEdiseaseBodyPart>> msg = new TMsgResponse<List<MetaEdiseaseBodyPart>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询病种和疾病部位元数据
			msg.result = metaEdiseaseBodyPartService.selectMetaEdiseaseBodyPartList();
			
			if(msg.result==null || msg.result.size()<1)
			{
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
}

