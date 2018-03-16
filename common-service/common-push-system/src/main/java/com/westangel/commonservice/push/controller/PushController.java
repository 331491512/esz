package com.westangel.commonservice.push.controller;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.westangel.common.bean.TBMsgResponse;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.push.PushContent;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.push.PushUserAlias;
import com.westangel.common.bean.weixin.WeixinJSConfigGetReq;
import com.westangel.common.bean.weixin.WeixinJSConfigInfo;
import com.westangel.common.bean.weixin.WeixinLocationGetReq;
import com.westangel.common.bean.weixin.WeixinLocationInfo;
import com.westangel.common.bean.weixin.WeixinOpenIdGetReq;
import com.westangel.common.bean.weixin.WeixinOpenIdInfo;
import com.westangel.common.bean.weixin.WeixinQRInfo;
import com.westangel.common.bean.weixin.WeixinQRReq;
import com.westangel.common.bean.weixin.WeixinUserGetReq;
import com.westangel.common.bean.weixin.WeixinUserInfo;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.push.bean.PushBindReq;
import com.westangel.commonservice.push.model.weixin.WeixinChannelInfo;
import com.westangel.commonservice.push.model.weixin.WeixinTemplateInfo;
import com.westangel.commonservice.push.model.xiaomi.XiaomiChannelInfo;
import com.westangel.commonservice.push.service.PushService;
import com.westangel.commonservice.push.service.weixin.WeixinService;
import com.westangel.commonservice.push.service.xiaomi.XiaomiService;
import com.westangel.commonservice.push.timerTask.TimerTask;
/**
 * 
* @ClassName: pushController 
* @Description: 推送控制层 
* @author LIPENG
* @date 2015年12月14日 下午8:06:17 
*
 */
@Controller
public class PushController {
	@Resource(name="pushService")
	PushService pushService;
		
	@Autowired
	WeixinService weixinService;
	
	@Autowired
	XiaomiService xiaomiService;
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	TimerTask timerTask;
	
	/**
	 * 
	* @Title: bind 
	* @Description: 绑定 
	* @param @param req
	* @param @return    设定文件 
	* @return TBMsgResponse    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/bind", method=RequestMethod.POST)
	public TBMsgResponse pushBind(@RequestBody PushBindReq req) {
		TBMsgResponse msgResponse = new TBMsgResponse();
		try {
			pushService.bind(req);
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: pushNotify 
	* @Description: 推送服务 
	* @param @param notify
	* @param @return    设定文件 
	* @return TBMsgResponse    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/notify", method=RequestMethod.POST)	
	public TBMsgResponse pushNotify(@RequestBody PushNotifyInfo notify) {
		TBMsgResponse msgResponse = new TBMsgResponse();
		try {
			pushService.push(notify);
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");			
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: weixinChannelList 
	* @Description: 获取微信通道列表 
	* @param @return    设定文件 
	* @return TMsgResponse<List<WeixinChannelInfo>>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/weixin/channel/list", method=RequestMethod.GET)
	public TMsgResponse<List<WeixinChannelInfo>> weixinChannelList()
	{
		TMsgResponse<List<WeixinChannelInfo>> msgResponse = new TMsgResponse<List<WeixinChannelInfo>>();
		try {
			msgResponse.setResult(weixinService.channelList());
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: updateWeixinChannel 
	* @Description: 更新微信通道 
	* @param @param channelInfo
	* @param @return    设定文件 
	* @return TBMsgResponse    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/weixin/channel/update", method=RequestMethod.POST)
	public TBMsgResponse updateWeixinChannel(@RequestBody WeixinChannelInfo channelInfo)
	{
		TBMsgResponse msgResponse = new TBMsgResponse();
		try {
			weixinService.updateChannel(channelInfo);
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");			
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());			
		}
		return msgResponse;
	}
	
	@ResponseBody
	@RequestMapping(value="/weixin/access/refresh", method=RequestMethod.GET)
	public void regetAccessTocken()
	{
		timerTask.weixinAccessToken();
	}

	/**
	 * 
	* @Title: syncAccessToken 
	* @Description:  同步微信的accessToken 
	* @param @param weixinServiceName
	* @param @param accessToken
	* @param @return    设定文件 
	* @return TBMsgResponse    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/weixin/access/sync", method=RequestMethod.GET)
	public TBMsgResponse syncAccessToken(String serviceName, String accessToken)
	{
		LogUtil.log.info("登录微信同步accessToken(syncAccessToken).......................serviceName=" + serviceName+"accessToken="+accessToken);
		TBMsgResponse msgResponse = new TBMsgResponse();
		try {
			weixinService.updateChannelAccessToken(serviceName, accessToken);
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");			
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
		}
		
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: weixinTemplateList 
	* @Description:  模版列表 
	* @param @return    设定文件 
	* @return TMsgResponse<List<WeixinTemplateInfo>>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/weixin/template/list", method=RequestMethod.POST)
	public TMsgResponse<List<WeixinTemplateInfo>> weixinTemplateList()
	{
		TMsgResponse<List<WeixinTemplateInfo>> msgResponse = new TMsgResponse<List<WeixinTemplateInfo>>();
		try {
			msgResponse.setResult(weixinService.templateList());
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: addWeixinTemplate 
	* @Description: 添加模版 
	* @param @param template
	* @param @return    设定文件 
	* @return TBMsgResponse    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/weixin/template/add", method=RequestMethod.POST)	
	public TBMsgResponse addWeixinTemplate(@RequestBody WeixinTemplateInfo template) {
		TBMsgResponse msgResponse = new TBMsgResponse();
		try {
			weixinService.addTemplate(template);
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: updateWeixinTemplate 
	* @Description: 更新模版 
	* @param @param template
	* @param @return    设定文件 
	* @return TBMsgResponse    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/weixin/template/update", method=RequestMethod.POST)	
	public TBMsgResponse updateWeixinTemplate(@RequestBody WeixinTemplateInfo template) {
		TBMsgResponse msgResponse = new TBMsgResponse();
		try {
			weixinService.updateTemplate(template);
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: getOpenId 
	* @Description: 获取openId 
	* @param @param req
	* @param @return    设定文件 
	* @return TMsgResponse<WeixinOpenIdInfo>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/weixin/openId/get", method=RequestMethod.POST)
	public TMsgResponse<WeixinOpenIdInfo> getOpenId(@RequestBody WeixinOpenIdGetReq req){
		TMsgResponse<WeixinOpenIdInfo> msgResponse = new TMsgResponse<WeixinOpenIdInfo>();
		try {
			WeixinOpenIdInfo openid = weixinService.getOpenId(req);
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
			msgResponse.setResult(openid);				
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: getUser 
	* @Description: 获取openId 
	* @param @param req
	* @param @return    设定文件 
	* @return TMsgResponse<WeixinOpenIdInfo>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/weixin/userinfo/get", method=RequestMethod.POST)
	public TMsgResponse<WeixinUserInfo> getUser(@RequestBody WeixinUserGetReq req){
		TMsgResponse<WeixinUserInfo> msgResponse = new TMsgResponse<WeixinUserInfo>();
		try {
			WeixinUserInfo openid = weixinService.getUser(req);
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
			msgResponse.setResult(openid);				
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: getQR 
	* @Description: 获取二维码 
	* @param @param req
	* @param @return    设定文件 
	* @return TMsgResponse<WeixinQRInfo>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/weixin/qr/get", method=RequestMethod.POST)	
	public TMsgResponse<WeixinQRInfo> getQR(@RequestBody WeixinQRReq req)
	{
		TMsgResponse<WeixinQRInfo> msgResponse = new TMsgResponse<WeixinQRInfo>();
		try {
			WeixinQRInfo qr = weixinService.getQR(req);
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
			msgResponse.setResult(qr);			
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: getLocation 
	* @Description: 获取位置信息 
	* @param @param req
	* @param @return    设定文件 
	* @return TMsgResponse<WeixinLocationInfo> 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/weixin/location/get", method=RequestMethod.GET)	
	public TMsgResponse<WeixinLocationInfo> getLocation(WeixinLocationGetReq req)
	{
		TMsgResponse<WeixinLocationInfo> msgResponse = new TMsgResponse<WeixinLocationInfo>();
		try {
			WeixinLocationInfo location = weixinService.getLocation(req);
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
			msgResponse.setResult(location);
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: getJSConfig 
	* @Description: 获取jsConfig信息 
	* @param @param req
	* @param @return    设定文件 
	* @return TMsgResponse<WeixinJSConfigInfo>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/weixin/jsconfig/get", method=RequestMethod.POST)
	public TMsgResponse<WeixinJSConfigInfo> getJSConfig(@RequestBody WeixinJSConfigGetReq req)
	{
		TMsgResponse<WeixinJSConfigInfo> msgResponse = new TMsgResponse<WeixinJSConfigInfo>();
		try {
			WeixinJSConfigInfo config = weixinService.getJSConfig(req);
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
			msgResponse.setResult(config);
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: xiaomiChannelList 
	* @Description: 小米通道列表 
	* @param @return    设定文件 
	* @return TMsgResponse<List<XiaomiChannelInfo>>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/xiaomi/channel/list", method=RequestMethod.GET)
	public TMsgResponse<List<XiaomiChannelInfo>> xiaomiChannelList()
	{
		TMsgResponse<List<XiaomiChannelInfo>> msgResponse = new TMsgResponse<List<XiaomiChannelInfo>>();
		try {
			msgResponse.setResult(xiaomiService.channelList());
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: updateXiaomiChannel 
	* @Description: 更新小米通道
	* @param @param template
	* @param @return    设定文件 
	* @return TBMsgResponse    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/xiaomi/channel/update", method=RequestMethod.POST)	
	public TBMsgResponse updateXiaomiChannel(@RequestBody XiaomiChannelInfo channel) {
		TBMsgResponse msgResponse = new TBMsgResponse();
		try {
			xiaomiService.updateChannel(channel);
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
		}
		return msgResponse;
	}
	/**
	 * 
	* @Title: addUserAlais 
	* @Description: 添加用户别名 
	* @param @param userAlias
	* @param @return    设定文件 
	* @return TBMsgResponse    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/alais/add", method=RequestMethod.POST)
	public TBMsgResponse addUserAlais(@RequestBody PushUserAlias userAlias){
		TBMsgResponse msgResponse = new TBMsgResponse();
		try {
			pushService.addUserAlias(userAlias);
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");			
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
		}
		return msgResponse;
	}
	/**
	 * 
	* @Title: removeUserAlais 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userAlias
	* @param @return    设定文件 
	* @return TBMsgResponse    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/alais/remove", method=RequestMethod.POST)
	public TBMsgResponse removeUserAlais(@RequestBody PushUserAlias userAlias){
		TBMsgResponse msgResponse = new TBMsgResponse();
		try {
			pushService.removeUserAlias(userAlias);
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");			
		} catch (Exception e) {
			msgResponse.setRespCode(1);
			msgResponse.setRespMsg(e.getMessage());
		}
		return msgResponse;
	}
	
	@ResponseBody
	@RequestMapping(value="/message", method=RequestMethod.POST)
	public TMsgResponse<String> getMessage(@RequestBody PushContent pushContent,Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		try {
			msg.setRespCode(0);
			msg.setRespMsg("success");
			msg.result = pushService.getMessage(pushContent);
		} catch (Exception e) {
			msg.setRespCode(1);
			msg.setRespMsg(e.getMessage());
		}
		return msg;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/weixin/channel/get", method=RequestMethod.GET)
	public TMsgResponse<Object> getWeiXinChannel(Integer businessId,Integer productId,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		try {
			msg.setRespCode(0);
			msg.setRespMsg("success");
			msg.result = weixinService.getWeiXinChannel(businessId,productId);
		} catch (Exception e) {
			msg.setRespCode(1);
			msg.setRespMsg(e.getMessage());
		}
		return msg;
	}
	
	public static void main(String[] args) {
		System.out.println(MessageFormat.format("{0}还能说什么", ""));
	}
}
