/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.controller.conf<br/>  
 * <b>文件名：</b>FollowupLocalProfileController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月11日下午4:33:09<br/>  
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

import com.esuizhen.cloudservice.followup.model.conf.TFollowupGlobalConfigInfo;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupLocalProfile;
import com.esuizhen.cloudservice.followup.service.conf.FollowupLocalProfileService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: FollowupLocalProfileController
* @Description: 
* @author NiDan
* @date 2016年8月11日下午4:33:09 
*/
@Controller
public class FollowupLocalProfileController {
	
	@Autowired
	private FollowupLocalProfileService followupLocalProfileService;
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value="/config/local/profile/set",method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<String> setFollowupLocalProfile(@RequestBody TFollowupLocalProfile req, Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			followupLocalProfileService.saveFollowupLocalProfile(req);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}

	@RequestMapping(value="/config/local/profile/get",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<TFollowupLocalProfile> getFollowupLocalProfile(Long userId,Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<TFollowupLocalProfile> msg = new TMsgResponse<TFollowupLocalProfile>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			msg.result=followupLocalProfileService.queryFollowupLocalProfileByUserId(userId);
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

}
