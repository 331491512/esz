/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.controller.conf<br/>  
 * <b>文件名：</b>FollowupContentTemplateInfoController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月11日下午4:40:39<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.controller.conf;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.followup.bean.FollowupContentTemplateQueryReq;
import com.esuizhen.cloudservice.followup.bean.FollowupContentTemplateResultRes;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupContentTemplateInfo;
import com.esuizhen.cloudservice.followup.service.conf.FollowupContentTemplateInfoService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: FollowupContentTemplateInfoController
* @Description: 随访内容模板Controller
* @author NiDan
* @date 2016年8月11日下午4:40:39 
*/
@Controller
public class FollowupContentTemplateInfoController {
	
	@Autowired
	private FollowupContentTemplateInfoService followupContentTemplateInfoService;
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value="/config/content/template/create",method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<String> createFollowupContentTemplateInfo(@RequestBody TFollowupContentTemplateInfo req, Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			followupContentTemplateInfoService.addFollowupContentTemplateInfo(req);
		}catch(Exception e){
			e.printStackTrace();
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		
		return msg;
	}
	
	@RequestMapping(value="/config/content/template/modify",method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<String> modifyFollowupContentTemplateInfo(@RequestBody TFollowupContentTemplateInfo req, Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			followupContentTemplateInfoService.modifyFollowupContentTemplateInfo(req);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	
	@RequestMapping(value="/config/content/template/detail/get",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<TFollowupContentTemplateInfo> queryFollowupContentTemplateDetail(String contentTemplateId,Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<TFollowupContentTemplateInfo> msg = new TMsgResponse<TFollowupContentTemplateInfo>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			msg.result=followupContentTemplateInfoService.queryFollowupContentTemplateInfo(contentTemplateId);
			if(msg.result==null){
				//如果为空
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	
	
	@RequestMapping(value="/config/content/template/query",method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Page<FollowupContentTemplateResultRes>> queryFollowupContentTemplate(@RequestBody(required=false) FollowupContentTemplateQueryReq req,Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<Page<FollowupContentTemplateResultRes>> msg = new TMsgResponse<Page<FollowupContentTemplateResultRes>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			msg.result=followupContentTemplateInfoService.selectTFollowupContentTemplateInfos(req);
			if(msg.result==null){
				//如果为空
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		}catch(Exception e){
			//设置错误代码及提示消息
			e.printStackTrace();
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	
	@RequestMapping(value="/config/content/template/delete",method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<String> deleteFollowupContentTemplate(@RequestBody TFollowupContentTemplateInfo followupContentTemplateInfo, Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			followupContentTemplateInfoService.deleteFollowupContentTemplateInfo(followupContentTemplateInfo);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	
	
}
