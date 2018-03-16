package com.esuizhen.cloudservice.ehr.controller.icd10;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.model.icd10.MetaEicd10;
import com.esuizhen.cloudservice.ehr.service.icd10.MetaEicd10Service;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
* @ClassName: MetaEicd10Controller 
* @Description: ICD-10请求控制器
* @author wang_hw
* @date 2015年12月14日 下午5:39:43
 */
@Controller
public class MetaEicd10Controller{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private MetaEicd10Service metaEicd10Service; 
	
	/**
	 * @author wang_hw
	 * @title :addMetainfoIcd10
	 * @Description:添加ICD-10
	 * @return TMsgResponse<String>
	 * @date 2015年12月14日 下午5:40:39
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/icd10/add" , method=RequestMethod.POST)
	public TMsgResponse<String> addMetainfoIcd10(@RequestBody MetaEicd10 metaEicd10 , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//新增ICD-10信息
			metaEicd10Service.insertMetaEicd10(metaEicd10);
			
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
	 * @title :query
	 * @Description:根据疾病编码查询
	 * @return TMsgResponse<MetaEicd10>
	 * @date 2015年12月14日 下午5:40:55
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/icd10/query" , method=RequestMethod.GET)
	public TMsgResponse<MetaEicd10> queryMetainfoIcd10(Long diseaseCode , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<MetaEicd10> msg = new TMsgResponse<MetaEicd10>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询ICD-10信息
			msg.result = metaEicd10Service.queryMetaEicd10(diseaseCode);
			
			if(msg.result==null)
			{//如果为空
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
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
	 * @author wang_hw
	 * @title :delete
	 * @Description:根据疾病编码删除
	 * @return TMsgResponse<String>
	 * @date 2015年12月14日 下午5:41:19
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/icd10/delete" , method=RequestMethod.GET)
	public TMsgResponse<String> deleteMetainfoIcd10(Long diseaseCode , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//删除ICD-10信息
			metaEicd10Service.deleteMetaEicd10(diseaseCode);
			
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
	 * @title :updateMetainfoIcd10
	 * @Description:根据疾病编码修改
	 * @return TMsgResponse<String>
	 * @date 2015年12月14日 下午5:42:08
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/icd10/update" , method=RequestMethod.POST)
	public TMsgResponse<String> updateMetainfoIcd10(@RequestBody MetaEicd10 metaEicd10 , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//修改ICD-10信息
			metaEicd10Service.updateMetaEicd10(metaEicd10);
			
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
	 * @title :metainfoIcd10List
	 * @Description:TODO
	 * @return TMsgResponse<List<MetaEicd10>>
	 * @date 2015年12月15日 下午7:35:52
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/icd10/list" , method=RequestMethod.GET)
	public TMsgResponse<List<MetaEicd10>> metainfoIcd10List(String timeFlag , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<MetaEicd10>> msg = new TMsgResponse<List<MetaEicd10>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询ICD-10列表
			msg.result = metaEicd10Service.selectMetaEicd10List(timeFlag);
			
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
	
	@ResponseBody
	@RequestMapping(value="/metainfo/icd10" , method=RequestMethod.GET)
	public TMsgResponse<List<MetaEicd10>> queryMetainfoIcd10(String diseaseTypeId , String diseaseBodyPartId, String diseaseCode ,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<MetaEicd10>> msg = new TMsgResponse<List<MetaEicd10>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询ICD-10列表
			msg.result = metaEicd10Service.selectMetaEicd10List(diseaseTypeId , diseaseBodyPartId , diseaseCode);
			
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
}

