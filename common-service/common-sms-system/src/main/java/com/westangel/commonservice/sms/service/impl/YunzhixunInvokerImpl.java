package com.westangel.commonservice.sms.service.impl;
import java.security.KeyManagementException;    
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.westangel.common.bean.ProductInfo;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.sms.bean.yunzhixun.Client;
import com.westangel.commonservice.sms.dao.SmsDao;
import com.westangel.commonservice.sms.model.SmsTemplateMessageInfo;
import com.westangel.commonservice.sms.model.yuntongxun.YuntongxunCallChannelInfo;
import com.westangel.commonservice.sms.model.yuntongxun.YuntongxunCallChannelMap;
import com.westangel.commonservice.sms.model.yuntongxun.YuntongxunCallRecord;
import com.westangel.commonservice.sms.model.yunzhixun.AppBill;
import com.westangel.commonservice.sms.model.yunzhixun.Callback;
import com.westangel.commonservice.sms.model.yunzhixun.ClientBill;
import com.westangel.commonservice.sms.model.yunzhixun.TemplateSMS;
import com.westangel.commonservice.sms.model.yunzhixun.VoiceCode;
import com.westangel.commonservice.sms.service.SmsInvoker;
import com.westangel.commonservice.sms.util.DateUtil;
import com.westangel.commonservice.sms.util.EncryptUtil;

@Service(value="yunzhixunService")
public class YunzhixunInvokerImpl extends AbsRestClient implements SmsInvoker {
	private Logger logger=LoggerFactory.getLogger(getClass());
	
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
	public String findAccoutInfo(String accountSid, String authToken)
			throws NoSuchAlgorithmException, KeyManagementException {
		// TODO Auto-generated method stub
		String result = "";
		DefaultHttpClient httpclient=getDefaultHttpClient();
		try {
			//MD5加密
			EncryptUtil encryptUtil = new EncryptUtil();
			//构造请求URL内容
			String timestamp = DateUtil.dateToStr(new Date(),DateUtil.DATE_TIME_NO_SLASH);
			String signature=getSignature(accountSid, authToken,timestamp,encryptUtil);
			String url = getStringBuffer().append("/").append(version).
					append("/Accounts/").append(accountSid).append("")
					.append("?sig=").append(signature).toString();
			logger.info(url);
			HttpResponse response=get("application/json",accountSid,authToken,timestamp,url,httpclient,encryptUtil);
			//获取响应实体信息
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity, "UTF-8");
			}
			// 确保HTTP响应内容全部被读出或者内容流被关闭
			EntityUtils.consume(entity);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 关闭连接
		    httpclient.getConnectionManager().shutdown();
		}
		return result;
	}
	@Override
	public String createClient(String accountSid, String authToken, 
			String appId,String clientName,String chargeType
			,String charge,String mobile) {
		// TODO Auto-generated method stub
		String result = "";
		DefaultHttpClient httpclient=getDefaultHttpClient();
		try {
			//MD5加密
			EncryptUtil encryptUtil = new EncryptUtil();
			//构造请求URL内容
			String timestamp = DateUtil.dateToStr(new Date(), DateUtil.DATE_TIME_NO_SLASH);
			String signature=getSignature(accountSid, authToken,timestamp,encryptUtil);
			String url = getStringBuffer().append("/").append(version).
					append("/Accounts/").append(accountSid)
					.append("/Clients")
					.append("?sig=").append(signature).toString();
			Client client=new Client();
			client.setAppId(appId);
			client.setFriendlyName(clientName);
			client.setClientType(chargeType);
			client.setCharge(charge);
			client.setMobile(mobile);
			Gson gson = new Gson();
			String body = gson.toJson(client);
			body="{\"client\":"+body+"}";
			HttpResponse response=post("application/json",accountSid, authToken, timestamp, url, httpclient, encryptUtil, body);
			//获取响应实体信息
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity, "UTF-8");
			}
			// 确保HTTP响应内容全部被读出或者内容流被关闭
			EntityUtils.consume(entity);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 关闭连接
		    httpclient.getConnectionManager().shutdown();
		}
		return result;
	}
	@Override
	public String findClients(String accountSid, String authToken,
			String appId, String start, String limit) {
		// TODO Auto-generated method stub
		String result = "";
		DefaultHttpClient httpclient=getDefaultHttpClient();
		try {
			//MD5加密
			EncryptUtil encryptUtil = new EncryptUtil();
			//构造请求URL内容
			String timestamp = DateUtil.dateToStr(new Date(), DateUtil.DATE_TIME_NO_SLASH);
			String signature=getSignature(accountSid, authToken,timestamp,encryptUtil);
			String url = getStringBuffer().append("/").append(version)
					.append("/Accounts/").append(accountSid)
					.append("/clientList")
					.append("?sig=").append(signature).toString();
			Client client=new Client();
			client.setAppId(appId);
			client.setStart(start);
			client.setLimit(limit);
			Gson gson=new Gson();
			String body = gson.toJson(client);
			body="{\"client\":"+body+"}";
			logger.info(body);
			HttpResponse response=post("application/json",accountSid, authToken, timestamp, url, httpclient, encryptUtil, body);
			//获取响应实体信息
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity, "UTF-8");
			}
			// 确保HTTP响应内容全部被读出或者内容流被关闭
			EntityUtils.consume(entity);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 关闭连接
		    httpclient.getConnectionManager().shutdown();
		}
		return result;
	}
	@Override
	public String findClientByNbr(String accountSid, String authToken,String clientNumber,String appId) {
		// TODO Auto-generated method stub
		String result = "";
		DefaultHttpClient httpclient=getDefaultHttpClient();
		try {
			//MD5加密
			EncryptUtil encryptUtil = new EncryptUtil();
			//构造请求URL内容
			String timestamp = DateUtil.dateToStr(new Date(), DateUtil.DATE_TIME_NO_SLASH);
			String signature=getSignature(accountSid, authToken,timestamp,encryptUtil);
			String url = getStringBuffer().append("/").append(version)
					.append("/Accounts/").append(accountSid)
					.append("/Clients")
					.append("?sig=").append(signature)
					.append("&clientNumber=").append(clientNumber)
					.append("&appId=").append(appId)
					.toString();
			HttpResponse response=get("application/json",accountSid, authToken, timestamp, url, httpclient, encryptUtil);
			//获取响应实体信息
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity, "UTF-8");
			}
			EntityUtils.consume(entity);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 关闭连接
		    httpclient.getConnectionManager().shutdown();
		}
		return result;
	}
	@Override
	public String closeClient(String accountSid, String authToken, String clientId,String appId) {
		// TODO Auto-generated method stub
		String result = "";
		DefaultHttpClient httpclient=getDefaultHttpClient();
		try {
			//MD5加密
			EncryptUtil encryptUtil = new EncryptUtil();
			// 构造请求URL内容
			String timestamp = DateUtil.dateToStr(new Date(),
					DateUtil.DATE_TIME_NO_SLASH);// 时间戳
			String signature =getSignature(accountSid,authToken,timestamp,encryptUtil);
			String url = getStringBuffer().append("/").append(version)
					.append("/Accounts/").append(accountSid)
					.append("/dropClient")
					.append("?sig=").append(signature).toString();
			Client client=new Client();
			client.setClientNumber(clientId);
			client.setAppId(appId);
			Gson gson = new Gson();
			String body = gson.toJson(client);
			body="{\"client\":"+body+"}";
			logger.info(body);
			HttpResponse response=post("application/json",accountSid, authToken, timestamp, url, httpclient, encryptUtil, body);
			//获取响应实体信息
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity, "UTF-8");
			}
			// 确保HTTP响应内容全部被读出或者内容流被关闭
			EntityUtils.consume(entity);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			// 关闭连接
		    httpclient.getConnectionManager().shutdown();
		}
		return result;
	}
	@Override
	public String charegeClient(String accountSid, String authToken,
			String clientNumber, String chargeType, String charge,String appId) {
		// TODO Auto-generated method stub
		String result = "";
		DefaultHttpClient httpclient=getDefaultHttpClient();
		try {
			//MD5加密
			EncryptUtil encryptUtil = new EncryptUtil();
			// 构造请求URL内容
			String timestamp = DateUtil.dateToStr(new Date(),
					DateUtil.DATE_TIME_NO_SLASH);// 时间戳
			String signature =getSignature(accountSid,authToken,timestamp,encryptUtil);
			String url = getStringBuffer().append("/2014-06-30/Accounts/").append(accountSid)
					.append("/chargeClient")
					.append("?sig=").append(signature).toString();
			Client client=new Client();
			client.setClientNumber(clientNumber);
			client.setChargeType(chargeType);
			client.setCharge(charge);
			client.setAppId(appId);
			Gson gson = new Gson();
			String body = gson.toJson(client);
			body="{\"client\":"+body+"}";
			logger.info(body);
			HttpResponse response=post("application/json",accountSid, authToken, timestamp, url, httpclient, encryptUtil, body);
			//获取响应实体信息
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity, "UTF-8");
			}
			// 确保HTTP响应内容全部被读出或者内容流被关闭
			EntityUtils.consume(entity);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			// 关闭连接
		    httpclient.getConnectionManager().shutdown();
		}
		return result;
	}
	@Override
	public String billList(String accountSid, String authToken,
			String appId,String date) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String result = "";
				DefaultHttpClient httpclient=getDefaultHttpClient();
				try {
					//MD5加密
					EncryptUtil encryptUtil = new EncryptUtil();
					// 构造请求URL内容
					String timestamp = DateUtil.dateToStr(new Date(),
							DateUtil.DATE_TIME_NO_SLASH);// 时间戳
					String signature =getSignature(accountSid,authToken,timestamp,encryptUtil);
					String url = getStringBuffer().append("/").append(version)
							.append("/Accounts/").append(accountSid)
							.append("/billList")
							.append("?sig=").append(signature).toString();
					AppBill appBill=new AppBill();
					appBill.setAppId(appId);
					appBill.setDate(date);
					Gson gson = new Gson();
					String body = gson.toJson(appBill);
					body="{\"appBill\":"+body+"}";
					logger.info(body);
					HttpResponse response=post("application/json",accountSid, authToken, timestamp, url, httpclient, encryptUtil, body);
					//获取响应实体信息
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						result = EntityUtils.toString(entity, "UTF-8");
					}
					// 确保HTTP响应内容全部被读出或者内容流被关闭
					EntityUtils.consume(entity);
				} catch (Exception e) {
					e.printStackTrace();
				} finally{
					// 关闭连接
				    httpclient.getConnectionManager().shutdown();
				}
				return result;
	}
	@Override
	public String clientBillList(String accountSid, String authToken,
			String appId,String clientNumber,String date) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String result = "";
				DefaultHttpClient httpclient=getDefaultHttpClient();
				try {
					//MD5加密
					EncryptUtil encryptUtil = new EncryptUtil();
					// 构造请求URL内容
					String timestamp = DateUtil.dateToStr(new Date(),
							DateUtil.DATE_TIME_NO_SLASH);// 时间戳
					String signature =getSignature(accountSid,authToken,timestamp,encryptUtil);
					String url = getStringBuffer().append("/").append(version)
							.append("/Accounts/").append(accountSid)
							.append("/Clients/billList")
							.append("?sig=").append(signature).toString();
					ClientBill clientBill=new ClientBill();
					clientBill.setAppId(appId);
					clientBill.setClientNumber(clientNumber);
					clientBill.setDate(date);
					Gson gson = new Gson();
					String body = gson.toJson(clientBill);
					body="{\"clientBill\":"+body+"}";
					logger.info(body);
					HttpResponse response=post("application/json",accountSid, authToken, timestamp, url, httpclient, encryptUtil, body);
					//获取响应实体信息
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						result = EntityUtils.toString(entity, "UTF-8");
					}
					// 确保HTTP响应内容全部被读出或者内容流被关闭
					EntityUtils.consume(entity);
				} catch (Exception e) {
					e.printStackTrace();
				} finally{
					// 关闭连接
				    httpclient.getConnectionManager().shutdown();
				}
				return result;
	}
	@Override
	public HttpResponse callback(String accountSid, String authToken, String appId,
			String fromClient, String to,String fromSerNum,String toSerNum,String maxallowtime) {
		// TODO Auto-generated method stub
		HttpResponse response=null;
		DefaultHttpClient httpclient=getDefaultHttpClient();
		try {
			//MD5加密
			EncryptUtil encryptUtil = new EncryptUtil();
			// 构造请求URL内容
			String timestamp = DateUtil.dateToStr(new Date(),DateUtil.DATE_TIME_NO_SLASH);// 时间戳
			String signature =getSignature(accountSid,authToken,timestamp,encryptUtil);
			String url = getStringBuffer().append("/").append(version)
					.append("/Accounts/").append(accountSid)
					.append("/Calls/callBack")
					.append("?sig=").append(signature).toString();
			Callback callback=new Callback();
			callback.setAppId(appId);
			callback.setFromClient(fromClient);
			callback.setTo(to);
			callback.setFromSerNum(fromSerNum);
			callback.setToSerNum(toSerNum);
			callback.setMaxallowtime(maxallowtime);
			Gson gson = new Gson();
			String body = gson.toJson(callback);
			body="{\"callback\":"+body+"}";
			logger.info(body);
			response=post("application/json",accountSid, authToken, timestamp, url, httpclient, encryptUtil, body);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			// 关闭连接
		    httpclient.getConnectionManager().shutdown();
		}
		return response;
	}
	@Override
	public String voiceCode(String accountSid, String authToken, String appId,
			String to, String verifyCode) {
		// TODO Auto-generated method stub
		String result = "";
		DefaultHttpClient httpclient=getDefaultHttpClient();
		try {
			//MD5加密
			EncryptUtil encryptUtil = new EncryptUtil();
			// 构造请求URL内容
			String timestamp = DateUtil.dateToStr(new Date(),
					DateUtil.DATE_TIME_NO_SLASH);// 时间戳
			String signature =getSignature(accountSid,authToken,timestamp,encryptUtil);
			String url = getStringBuffer().append("/").append(version)
					.append("/Accounts/").append(accountSid)
					.append("/Calls/voiceCode")
					.append("?sig=").append(signature).toString();
			VoiceCode voiceCode=new VoiceCode();
			voiceCode.setAppId(appId);
			voiceCode.setVerifyCode(verifyCode);
			voiceCode.setTo(to);
			Gson gson = new Gson();
			String body = gson.toJson(voiceCode);
			body="{\"voiceCode\":"+body+"}";
			logger.info(body);
			HttpResponse response=post("application/json",accountSid, authToken, timestamp, url, httpclient, encryptUtil, body);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity, "UTF-8");
			}
			EntityUtils.consume(entity);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			// 关闭连接
		    httpclient.getConnectionManager().shutdown();
		}
		return result;
	}
	@Override
	public String templateSMS(String accountSid, String authToken,
			String appId, String templateId, String to, String param) {
		// TODO Auto-generated method stub
		String result = "";
		DefaultHttpClient httpclient=getDefaultHttpClient();
		try {
			//MD5加密
			EncryptUtil encryptUtil = new EncryptUtil();
			// 构造请求URL内容
			String timestamp = DateUtil.dateToStr(new Date(),
					DateUtil.DATE_TIME_NO_SLASH);// 时间戳
			String signature =getSignature(accountSid,authToken,timestamp,encryptUtil);
			String url = getStringBuffer().append("/").append(version)
					.append("/Accounts/").append(accountSid)
					.append("/Messages/templateSMS")
					.append("?sig=").append(signature).toString();
			TemplateSMS templateSMS=new TemplateSMS();
			templateSMS.setAppId(appId);
			templateSMS.setTemplateId(templateId);
			templateSMS.setTo(to);
			templateSMS.setParam(param);
			Gson gson = new Gson();
			String body = gson.toJson(templateSMS);
			body="{\"templateSMS\":"+body+"}";
			logger.info(body);
			HttpResponse response=post("application/json",accountSid, authToken, timestamp, url, httpclient, encryptUtil, body);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity, "UTF-8");
			}
			EntityUtils.consume(entity);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			// 关闭连接
		    httpclient.getConnectionManager().shutdown();
		}
		return result;
	}
	@Override
	public String findClientByMobile(String accountSid, String authToken,
			String mobile, String appId) {
		// TODO Auto-generated method stub
		String result = "";
		DefaultHttpClient httpclient=getDefaultHttpClient();
		try {
			//MD5加密
			EncryptUtil encryptUtil = new EncryptUtil();
			//构造请求URL内容
			String timestamp = DateUtil.dateToStr(new Date(), DateUtil.DATE_TIME_NO_SLASH);
			String signature=getSignature(accountSid, authToken,timestamp,encryptUtil);
			String url = getStringBuffer().append("/").append(version)
					.append("/Accounts/").append(accountSid)
					.append("/ClientsByMobile")
					.append("?sig=").append(signature)
					.append("&mobile=").append(mobile)
					.append("&appId=").append(appId)
					.toString();
			HttpResponse response=get("application/json",accountSid, authToken, timestamp, url, httpclient, encryptUtil);
			//获取响应实体信息
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity, "UTF-8");
			}
			EntityUtils.consume(entity);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 关闭连接
		    httpclient.getConnectionManager().shutdown();
		}
		return result;
	}
	@Override
	public String dispalyNumber(String accountSid, String authToken,
			String appId, String clientNumber, String display) {
		// TODO Auto-generated method stub
		String result = "";
		DefaultHttpClient httpclient=getDefaultHttpClient();
		try {
			//MD5加密
			EncryptUtil encryptUtil = new EncryptUtil();
			//构造请求URL内容
			String timestamp = DateUtil.dateToStr(new Date(), DateUtil.DATE_TIME_NO_SLASH);
			String signature=getSignature(accountSid, authToken,timestamp,encryptUtil);
			String url = getStringBuffer().append("/").append(version)
					.append("/Accounts/").append(accountSid)
					.append("/dispalyNumber")
					.append("?sig=").append(signature)
					.append("&appId=").append(appId)
					.append("&clientNumber=").append(clientNumber)
					.append("&display=").append(display)
					.toString();
			HttpResponse response=get("application/json",accountSid, authToken, timestamp, url, httpclient, encryptUtil);
			//获取响应实体信息
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity, "UTF-8");
			}
			EntityUtils.consume(entity);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 关闭连接
		    httpclient.getConnectionManager().shutdown();
		}
		return result;
	}
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
			throw new RuntimeException("云之讯没有找到拨打电话通道：(" + key + ")!");
		}
		
		try {
			//设置默认的用户数据
			if (StringUtils.isEmpty(userData)) {
				userData = ""+from+"-"+to+"";
			}
			String accountSid = channel.getSubAccountSid();// 主账户Id
			String authToken=channel.getSubToken();
			String appId=channel.getVoipAccount();//String	必选	应用Id
			
			//String fromClient="64483107417495";
			String fromClient=this.getFromClientByMobile(accountSid, authToken, appId, from, "1", "0", from);
			
			String fromSerNum=serFrom;
			String toSerNum=serTo;
			
			HttpResponse response=this.callback(accountSid, authToken, appId, fromClient, to,fromSerNum,toSerNum,maxCallTime);
			HttpEntity entity = response.getEntity();
			String callIdStr="",respStr="",respCode="";
			
			if (entity != null) {//{"resp":{"respCode":"000000","callback":{"callId":"d125cb0395998cec9f05ebe3d2f89173","createDate":"20170830144344"}}}
				respStr=JsonUtil.toJson(EntityUtils.toString(entity, "UTF-8"));
				JSONObject obj = JSONObject.parseObject(respStr.substring(1, respStr.length()-1).replace("\\", ""));//将json字符串转换为json对象
				JSONObject resp = (JSONObject) obj.get("resp");
				respCode=(String) resp.get("respCode");
				JSONObject callback = (JSONObject) resp.get("callback");
				callIdStr = (String) callback.get("callId");
			}
			EntityUtils.consume(entity);
			
			HashMap<String, Object> body = new HashMap<String, Object>();
			body.put("appId", channel.getVoipAccount());//String	必选	应用Id
			body.put("fromClient", fromClient);
			body.put("from",from);//	必选	主叫ClientNumber号码，ClientNumber必须是绑定了主叫正常的电话号码。
			body.put("to",to);//	必选	被叫正常电话号码。
			if (!StringUtils.isEmpty(serFrom)) {
				body.put("fromSerNum",serFrom);//	必选	主叫侧显示的号码，只能显示400号码或固话。查阅显号规则。
			}
			if (!StringUtils.isEmpty(serTo)) {
				body.put("toSerNum",serTo);//	必选	被叫侧显示的号码。可显示手机号码、400号码或固话。查阅显号规则。
			}
			body.put("maxallowtime",maxCallTime);//	可选	允许通话时长单位为秒（值必须为60的倍数，如60s、120s、180s）
			//保存请求
			YuntongxunCallRecord record = new YuntongxunCallRecord();
			record.setUserData(userData);
			//record.setCallSid(StringUtil.getRandomString(10)+System.currentTimeMillis());
			record.setRequest(JsonUtil.toJson(body));
			//record.setCallbackUrl(callbackUrl);
			smsDao.addYuntongxunCallRecord(record);
			
			
			if (entity==null) {
				throw new RuntimeException("云之讯拨打未知错误");
			}
			LogUtil.log.info(entity.toString());
			if (StringUtils.isEmpty(respStr)) {
				throw new RuntimeException("云之讯拨打结果解析错误");
			}
			//保存调用结果
			if (StringUtils.isEmpty(callIdStr)) {
				smsDao.saveYuntongxunCallRecordViaId(record.getId(), 
						"xxxxxxxxxxxxxxxxxxxx", 
						respStr);
			} else {
				smsDao.saveYuntongxunCallRecordViaId(record.getId(), 
						callIdStr, 
						respStr);
			}
			if (!"000000".equals(respCode)) {
				throw new RuntimeException("云之讯拨打错误："+respCode);
			}
			
			logger.info("callTwoway----------\n" + JsonUtil.toJson(body) + "----------\n" + respStr);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.toString());
		}
		
		return result;
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
	static class YZXCallRsp{
		
		//{"resp":{"respCode":"000000","callback":{"callId":"d125cb0395998cec9f05ebe3d2f89173","createDate":"20170830144344"}}}
		YZXResp resp;
		//YTXCallBack CallBack;
		boolean beSuccess(){
			if(resp!=null){
				return "000000".equals(resp.respCode);
			}else return false;
		}
	}
	static class YZXResp{
		String respCode;
		YZXCallback callback;
	}
	static class YZXCallback{
		String callId;
		String createDate;
	}
	@Override
	public boolean sendCapatcha(ProductInfo product, String mobile,
			String templateText) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sendContent(ProductInfo product, List<String> moblies,
			String content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sendTemplateMessage(ProductInfo product, String mobile,
			SmsTemplateMessageInfo templateMessageInfo) {
		// TODO Auto-generated method stub
		return false;
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
	
	private String getFromClientByMobile(String accountSid,String authToken,String appId,String clientName,String chargeType,String charge,String mobile) throws Exception{
		String fromClient = null;
		String respStr=this.createClient(accountSid, authToken, appId, clientName, chargeType, charge, mobile);
		//{"resp":{"client":{"balance":"0","clientNumber":"64483107843848","clientPwd":"269c7ace","createDate":"2017-09-05 11:26:16"},"respCode":"000000"}}
		String respCode="";
		JSONObject response =  null;
		JSONObject resp = null;
		try {
			response = JSONObject.parseObject(respStr);//将json字符串转换为json对象
			resp = (JSONObject) response.get("resp");
			respCode=(String) resp.get("respCode");
			
			if(!"000000".equals(respCode))throw new Exception("需要处理异常");
		} catch (Exception e) {
			respStr = findClientByMobile( accountSid,  authToken,mobile,  appId);
			response = JSONObject.parseObject(respStr);//将json字符串转换为json对象
			resp = (JSONObject) response.get("resp");
			respCode=(String) resp.get("respCode");
			if(!"000000".equals(respCode))throw new Exception("获取电话client错误");
			//{"client":{"balance":"0","clientNumber":"64483107778116","clientPwd":"2d48ea40","clientType":"1","createDate":"2017-09-04 11:48:15","friendlyName":"18610818134","mobile":"18610818134","roam":"0"},"count":"1","respCode":"000000"}
		}
		JSONObject clientObj = (JSONObject) resp.get("client");
		fromClient=(String) clientObj.get("clientNumber");
		//if(!StringUtils.isEmpty(fromClient))smsDao.updateFromClientByMobile(fromClient, mobile);
		return fromClient;
	}
}
