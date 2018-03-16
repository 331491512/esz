/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.controller.conf<br/>  
 * <b>文件名：</b>FollowupReplyParseRulesInfoController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月11日下午5:11:39<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.controller.conf;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.followup.bean.FollowupReplyParseRulesInfoReq;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupReplyParseRulesInfo;
import com.esuizhen.cloudservice.followup.service.conf.FollowupReplyParseRulesInfoService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: FollowupReplyParseRulesInfoController
* @Description: 
* @author NiDan
* @date 2016年8月11日下午5:11:39 
*/
@Controller
public class FollowupReplyParseRulesInfoController {
	
	@Autowired
	private FollowupReplyParseRulesInfoService followupReplyParseRulesInfoService;
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value="/config/reply/parse/rules/save",method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<String> saveFollowupReplyParseRules(@RequestBody FollowupReplyParseRulesInfoReq req,Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			followupReplyParseRulesInfoService.saveFollowupReplyParseRulesInfo(req.getRules());
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	
	@RequestMapping(value="/config/reply/parse/rules/query",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<TFollowupReplyParseRulesInfo>> queryFollowupReplyParseRules(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<TFollowupReplyParseRulesInfo>> msg = new TMsgResponse<List<TFollowupReplyParseRulesInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			msg.result=followupReplyParseRulesInfoService.selectFollowupReplyParseRulesInfos();
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
