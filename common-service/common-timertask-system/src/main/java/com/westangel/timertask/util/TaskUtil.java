package com.westangel.timertask.util;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.sms.SmsTemplateSendReq;
import com.westangel.common.bean.timertask.Timertask;
import com.westangel.common.service.MessageInnerService;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.service.SmsInnerService;
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.JdbcUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PushNotifyUtil;
import com.westangel.common.util.PushUtil;
import com.westangel.common.util.SmsUtil;
import com.westangel.timertask.service.TimertaskService;

/**
 * @ClassName: TaskUtil
 * @Description: 任务工具类
 * @author wang_hw
 * @date 2016年1月13日 下午6:39:01
 */
public class TaskUtil
{
	public static TimertaskService service;
	public static boolean execTask(Timertask task , PushInnerService pushInnerService , SmsInnerService  smsInnerService , MessageInnerService messageInnerService, String openId , String urlRoot)
	{
		boolean flag = true ;
		try
		{
			switch (task.getActionType())
			{
			case 2://SQL
				LogUtil.log.info("执行SQL:"+task.getSqlContent());
				if(task.getSqlContent().startsWith("["))
				{
					List<String> sqlList = JsonUtil.toObject(task.getSqlContent(), List.class);
					for(String sql : sqlList)
					{
						LogUtil.log.info("执行SQL:"+sql);
						JdbcUtil.execSql(sql);
					}
				}else
				{
					flag = JdbcUtil.execSql(task.getSqlContent());
				}
				break;
			case 4://存储过程
				LogUtil.log.info("执行存储过程:"+task.getProcedureContent());
				if(service!=null)
					flag = service.execProcedure(task.getProcedureContent());
				else
					flag = JdbcUtil.execProcedure(task.getProcedureContent());
				break;
			case 8://http调用
				LogUtil.log.info("Http调用 url:"+task.getHttpUrl()+" param:"+task.getHttpContent());
				task.setHttpUrl(task.getHttpUrl().replace("{domain}", urlRoot));
				LogUtil.log.info("Http调用 url:"+task.getHttpUrl()+" param:"+task.getHttpContent());
				String result = null;
				if(StringUtils.isEmpty(task.getHttpContent()))
				{
					LogUtil.log.debug("timer task http get");
					LogUtil.log.debug(task.getHttpUrl());
					result = HttpUtil.get(task.getHttpUrl());
					LogUtil.log.debug(result);
				}else
				{
					LogUtil.log.debug("timer task http get");
					LogUtil.log.debug("url:{},data{}",task.getHttpUrl(),task.getHttpContent());
					result = HttpUtil.postWithJSON(task.getHttpUrl(), task.getHttpContent());
					LogUtil.log.debug(result);
				}
				LogUtil.log.info("Http调用 结果:"+result);
				TMsgResponse response = JsonUtil.toObject(result, TMsgResponse.class);
				if(response==null || response.getRespCode()!=ErrorMessage.SUCCESS.code)
				{
					flag = false;
				}
				break;
			case 16://短息发送
				LogUtil.log.info("开始组装发送参数");
				String message = task.getPushContent().replace("<br/>", "\\n");
				messageInnerService.sendInnerMessage(JsonUtil.toObject(message,ImMessageInfo.class ));
				break;
			default://推送
				LogUtil.log.info("开始组装推送参数");
				
				String content = task.getPushContent().replace("<br/>", "\\n");
				if("wx_data_push".equals(task.getActionPushType()))
				{//微信数据推送
					PushNotifyInfo pushNotifyInfo = PushUtil.getWxDataPushNotifyInfo(Long.parseLong(task.getUserId()) , content);
					PushNotifyUtil.setSendWxProductId(pushNotifyInfo, task.getWxProductId());
					pushInnerService.push(pushNotifyInfo);
					
				}else if("wx_template_push".equals(task.getActionPushType()))
				{//微信模版推送
					PushNotifyInfo notify = PushUtil.getWxTemplatePushNotifyInfo(task.getWxTemplateName(), task.getWxTemplateUrl(), JsonUtil.toObject(content , List.class));
					notify.setUserId(Long.parseLong(task.getUserId()));
					PushNotifyUtil.setSendWxProductId(notify, task.getWxProductId());
					pushInnerService.push(notify);
				}else if("sms_data_push".equals(task.getActionPushType()))
				{//发送短信模版
					SmsTemplateSendReq template = SmsUtil.getSmsTemplateSendReq(task.getWxTemplateName(), task.getContactMobile(), JsonUtil.toObject(content, List.class));
					smsInnerService.sendTemplate(template);
				}else
				{//App推送
					PushNotifyInfo notifyInfo = PushUtil.getAppPushNotifyInfo(Long.parseLong(task.getUserId()) , content);
					pushInnerService.push(notifyInfo);
				}
				break;
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
			flag = false;
			LogUtil.logError.error(ex.getMessage());
		}
		
		return flag;
	}
	
	public static void main(String[] args)
	{
		String str = "{domain}/followup/daily/statis/send/todoctor";
		System.out.println(str.replace("{domain}", "http://www.baidu.com"));
	}
}
