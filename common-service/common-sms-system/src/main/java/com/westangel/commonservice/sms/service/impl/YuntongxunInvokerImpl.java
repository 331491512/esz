package com.westangel.commonservice.sms.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cloopen.rest.sdk.utils.EncryptUtil;
import com.westangel.common.bean.ProductInfo;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.StringUtil;
import com.westangel.commonservice.sms.bean.yuntongxun.YuntongxunCallerBillReq;
import com.westangel.commonservice.sms.dao.SmsDao;
import com.westangel.commonservice.sms.model.SmsTemplateMessageInfo;
import com.westangel.commonservice.sms.model.yuntongxun.YuntongxunCallChannelInfo;
import com.westangel.commonservice.sms.model.yuntongxun.YuntongxunCallChannelMap;
import com.westangel.commonservice.sms.model.yuntongxun.YuntongxunCallRecord;
import com.westangel.commonservice.sms.service.SmsInvoker;
import com.westangel.commonservice.sms.service.YuntongxunCallInvoker;
import com.westangel.commonservice.sms.service.yuntongxun.CcopHttpClient;

@Service(value="yuntongxunService")
public class YuntongxunInvokerImpl implements SmsInvoker,YuntongxunCallInvoker {
	private Logger logger = LoggerFactory.getLogger(getClass()); 
	
	@Value("${server.api.url.root}")
	private String apiRoot;
	
	@Value("${yuntongxun.url}")
	private String yuntongxunUrl;
	
	@Value("${yuntongxun.agreement}")
	private String serviceAgreement;
	
	/**
	 * 实时话单回调URL地址
	 */
	@Value("${call.yuntongxun.callerbill.path}")
	private String callerBillPath;
	
	@Autowired
	SmsDao smsDao;

	@Autowired
	YuntongxunCallChannelMap callChannelMap;
	
	@PostConstruct
	public void initConfigure()
	{
		//电话通道配置
		List<YuntongxunCallChannelInfo> channels = smsDao.getYuntongxunCallChannelList();
		if (null != channels) {
			for (YuntongxunCallChannelInfo channel:channels) {
				callChannelMap.put(key4BusinessProduct(channel.getBusinessId(), channel.getProductId()), channel);
			}
		}
	}
	
	@Override
	public boolean sendCapatcha(ProductInfo product, String mobile, String templateText)
	{
		try {
			throw new RuntimeException("云通讯不提供发送验证码通道！");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean sendContent(ProductInfo product, List<String> moblies, String content) 
	{
		try {
			throw new RuntimeException("云通讯不提供发送短信通道！");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean sendTemplateMessage(ProductInfo product, String mobile, SmsTemplateMessageInfo templateMessageInfo) 
	{
		try {
			throw new RuntimeException("云通讯不提供发送模版短信通道！");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
//	@Override
//	public void sendCaptcha(SmsCaptchaGetReq req) {
//
////		//默认发送成功
////		boolean isSuccess = true;
////		
////		HashMap<String, Object> result = null;
////		//初始化SDK
////		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
////		// 初始化服务器地址和端口
////		restAPI.init(serverAddress, serverPort);
////		// 初始化主帐号和主帐号TOKEN
////		restAPI.setAccount(mainAccount,mainToken);
////		// 初始化应用ID
////		restAPI.setAppId(appId);
////		//1:手机号 2：验证码 3：参数
////		result = restAPI.sendTemplateSMS(phone,"7231" ,new String[]{info,"400-002-6336"});
////		log.info("result=" + result);
////		if("000000".equals(result.get("statusCode")))
////		{
////			//正常返回输出data包体信息（map）
////			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
////			Set<String> keySet = data.keySet();
////			for(String key:keySet)
////			{
////				Object object = data.get(key);
////				log.error(key +" = "+object);
////			}
////		}else
////		{
////			//异常返回输出错误码和错误信息
////			log.error("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
////			isSuccess = false ;
////		}
////		return isSuccess;
//	
//	}
//
//	@Override
//	public void sendContent(SmsContentSendReq req) {
//		// TODO Auto-generated method stub
//		
//	}
	
	/**
	 * 双向回拨
	 */
	@Override
	public boolean callTwoway(
			ProductInfo product, 
			String from, 
			String to,
			String serFrom, 
			String serTo,
			String userData,
			String maxCallTime,
			String callbackUrl) 
	{
		if (StringUtils.isEmpty(from)) {
			throw new RuntimeException("from手机号不能为空！");
		}
		if (StringUtils.isEmpty(to)) {
			throw new RuntimeException("to手机号不能为空！");
		}
		
		boolean result = false;
		String key = key4BusinessProduct(product.getBusinessId(), product.getProductId());
		YuntongxunCallChannelInfo channel = callChannelMap.get(key);
		if (null == channel) {
			throw new RuntimeException("云通讯没有找到拨打电话通道：(" + key + ")!");
		}
		
		try {
			//设置默认的用户数据
			if (StringUtils.isEmpty(userData)) {
				userData = ""+from+"-"+to+"";
			}			
			CcopHttpClient chc = new CcopHttpClient();
			DefaultHttpClient httpClient = chc.registerSSL(yuntongxunUrl, "TLS", 8883, serviceAgreement);
			String timestamp = DateUtil.convertToStr(new Date(), DateUtil.DATE_TIME_NO_SLASH);
			EncryptUtil eu = new EncryptUtil();
			String signature = eu.md5Digest(channel.getSubAccountSid()+channel.getSubToken()+timestamp);
			
			String url = new StringBuffer()
					.append("/SubAccounts/").append(channel.getSubAccountSid())
					.append("/Calls/Callback?sig=").append(signature)
					.toString();
			String auth = eu.base64Encoder(channel.getSubAccountSid() + ":" + timestamp);
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("Accept", "application/json");
			map.put("Content-Type", "application/json;charset=utf-8");
			map.put("Authorization", auth);
			
			HashMap<String, String> body = new HashMap<String, String>();
			body.put("subAccountSid", channel.getSubAccountSid());
			body.put("voipAccount", channel.getVoipAccount());
			body.put("from", from);
			body.put("to", to);
			if (!StringUtils.isEmpty(serFrom)) {
				body.put("fromSerNum", serFrom);
			}
			if (!StringUtils.isEmpty(serTo)) {
				body.put("customerSerNum", serTo);
			}
			body.put("userData", !StringUtils.isEmpty(userData)?userData:""+from+"-"+to+"");
			body.put("hangupCdrUrl", ""+apiRoot+callerBillPath+"");
			body.put("maxCallTime", maxCallTime);
			body.put("needBothCdr", "0");
			
			//保存请求
			YuntongxunCallRecord record = new YuntongxunCallRecord();
			record.setUserData(userData);
			record.setCallSid(StringUtil.getRandomString(10)+System.currentTimeMillis());
			record.setRequest(JsonUtil.toJson(body));
			record.setCallbackUrl(callbackUrl);
			smsDao.addYuntongxunCallRecord(record);
			
			String json = HttpUtil.postString(httpClient, remoteURL(url), JsonUtil.toJson(body), map);
			if (StringUtils.isEmpty(json)) {
				throw new RuntimeException("云通讯拨打未知错误");
			}
			LogUtil.log.info(json);
			YTXCallRsp rsp = JsonUtil.toObject(json, YTXCallRsp.class);
			if (null == rsp) {
				throw new RuntimeException("云通讯拨打结果解析错误");
			}
			//保存调用结果
			if (StringUtils.isEmpty(rsp.CallBack.callSid)) {
				smsDao.saveYuntongxunCallRecordViaId(record.getId(), 
						"xxxxxxxxxxxxxxxxxxxx", 
						json);
			} else {
				smsDao.saveYuntongxunCallRecordViaId(record.getId(), 
						rsp.CallBack.callSid, 
						json);
			}
			if (!rsp.beSuccess()) {
				throw new RuntimeException("云通讯拨打错误："+rsp.statusCode);
			}
			
			logger.info("callTwoway----------\n" + JsonUtil.toJson(body) + "----------\n" + json);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.toString());
		}
		
		return result;
	}
	
	public String remoteURL(String URI)
	{
		StringBuffer url = new StringBuffer(serviceAgreement+"://");
		url.append(yuntongxunUrl).append(":").append(8883);
		url.append("/2013-12-26");
		return url.append(URI).toString();
	}
	
	/**
	 * 
	* @Title: callerBillCallback 
	* @Description: 主叫实时话单 
	* @param @param req    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void callerBillCallback(YuntongxunCallerBillReq req)
	{
		//保存回调结果
		YuntongxunCallRecord record = smsDao.queryYuntongxunCallRecordViaSid(req.getCallSid());
		if (null != record) {
			Integer result = Integer.parseInt(req.getByetype());
			smsDao.saveYuntongxunCallRecordViaSid(req.getCallSid(), JsonUtil.toJson(req), result);
			String callbackUrl = record.getCallbackUrl(), userData = record.getUserData();
			if (!StringUtils.isEmpty(callbackUrl) && !StringUtils.isEmpty(userData)) {
				if (1==result || 3==result || 4==result){//正常挂机
					callbackUrl = callbackUrl + "?userData=" + userData + "&result=0";
				} else if (2 == result){//欠费或者设置时间到
					callbackUrl = callbackUrl + "?userData=" + userData + "&result=0";
				} else if (-10 == result){//主叫未接通或者拒接
					callbackUrl = callbackUrl + "?userData=" + userData + "&result=2";
				} else if (-3 == result || -9 == result){//被叫未接或拒接
					callbackUrl = callbackUrl + "?userData=" + userData + "&result=3";
				} else {//其它未接通
					callbackUrl = callbackUrl + "?userData=" + userData + "&result=1";
				}
				String rstring = HttpUtil.get(callbackUrl);
				logger.info("\n----------\ncallerBillCallback\n"+rstring);
			}
		}
	}
	/**
	 * 
	* @Title: key4BusinessProduct 
	* @Description:  
	* @param @param businessId
	* @param @param productId
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String key4BusinessProduct(Integer businessId, Integer productId)
	{
		return ""+businessId+"-"+productId+"";
	}
	
	static class YTXCallBack{
		String appId;
		String customerSerNum;
		String fromSerNum;
		String dateCreated;
		String callSid;
	} 
	
	static class YTXCallRsp{
		String statusCode;
		YTXCallBack CallBack;
		boolean beSuccess(){
			return "000000".equals(statusCode);
		}
	}

	@Override
	public Object getReceipt(ProductInfo product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getSmsSendReport(String channelName) {
		// TODO Auto-generated method stub
		return null;
	}

}
