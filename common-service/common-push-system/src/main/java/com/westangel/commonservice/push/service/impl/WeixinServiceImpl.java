package com.westangel.commonservice.push.service.impl;

import com.westangel.common.bean.ProductInfo;
import com.westangel.common.bean.push.*;
import com.westangel.common.bean.weixin.*;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.StringUtil;
import com.westangel.commonservice.push.dao.PushDao;
import com.westangel.commonservice.push.dao.PushHistoryDao;
import com.westangel.commonservice.push.dao.WeixinDao;
import com.westangel.commonservice.push.model.PushBindInfo;
import com.westangel.commonservice.push.model.PushHistory;
import com.westangel.commonservice.push.model.weixin.*;
import com.westangel.commonservice.push.service.PushInvokerService;
import com.westangel.commonservice.push.service.PushService;
import com.westangel.commonservice.push.service.weixin.WeixinService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* @author 作者 :LIPENG
* @Description: 微信服务实现类
* @version 创建时间：2015年12月6日 下午4:05:21
* 类说明
*/
@Service(value="weixinService")
public class WeixinServiceImpl implements PushInvokerService, WeixinService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	PushDao pushDao;
	
	@Autowired
	WeixinDao weixinDao;
	
	@Autowired
	PushHistoryDao pushHistoryDao;
	
	@Autowired
	PushService pushService;
	
	@Autowired 
	WeixinChannelMap channelMap;
	
	@Autowired
	WeixinTemplateMap templateMap;
	
	@PostConstruct
	public void initConfig()
	{
		//获取通道配置
		List<WeixinChannelInfo> channels = pushDao.weixinChannelList();
		if (null != channels) {
			for (WeixinChannelInfo channel : channels){
				channelMap.put(channel.key(), channel);
			}
		}
		
		//获取微信模版
		List<WeixinTemplateInfo> templates = pushDao.weixinTemplateList();
		if (null != templates) {
			for (WeixinTemplateInfo template:templates){
				templateMap.put(template.key(), template);
			}
		}
	}
	
	/**
	 * 执行推送
	 */
	@Override
	public void pushNotify(PushNotifyInfo notify, PushBindInfo bind)
	{
		try{
			sendNotify(notify, bind);
		}catch(Exception e){
			LogUtil.logError.error("pushNotify error "+e.getMessage());
		}
	}
	/**
	 * 
	 * @author lichenghao
	 * @title :sendNotify
	 * @Description:统一的推送判断
	 * @return void
	 * @date 2017年2月9日 上午10:20:52
	 */
	private void sendNotify(PushNotifyInfo notify, PushBindInfo bind)throws Exception{
		logger.info(JsonUtil.toJson(notify));
		PushHistory history = PushHistory.createPushHistory(notify, bind);
		try{
			String result = null;
			WeixinChannelInfo channel = channel4Product(new ProductInfo(bind.getBusinessId(), bind.getProductId()));
			if (null == channel) {
				logger.info("\n----------\n未找到对应的微信通道："+bind.getBusinessId()+"-"+bind.getProductId()+"\n----------");
				throw new RuntimeException("未知的业务Id或产品Id");
			}
			//如果是微信数据
			if (PushConstValue.NotifyType.NotifyTypeWXData.ordinal() == notify.getPushType()) {
				try {
					PushWeixinData data = JsonUtil.toObject(notify.getContent(), PushWeixinData.class);
					result = sendData(data, bind.getDeviceToken(), channel);				
				} catch (Exception e) {
					logger.info("\n----------\n"+e.toString());
				}
			}
			//如果是微信模版
			else if (PushConstValue.NotifyType.NotifyTypeWXTemplate.ordinal() == notify.getPushType()){
				try {
					PushWeixinTemplate template = JsonUtil.toObject(notify.getContent(), PushWeixinTemplate.class);
					//模版名称处理
					template.setName(template.getName()+"-"+bind.getBusinessId()+"-"+bind.getProductId());
					result = sendTemplate(template, bind.getDeviceToken(), channel);				
				} catch (Exception e) {
					logger.info("\n----------\n"+e.toString());
				}
			}
			//如果是其它类型，暂时不做处理
			else {
				throw new RuntimeException("微信不支持的推送类型");
			}
			
			if(StringUtils.isNotEmpty(result)){
				Map<String,Object> map = JsonUtil.toObject(result, HashMap.class);
				if(map!=null&&((Double)map.get("errcode"))!=0l){
					throw new RuntimeException(result);
				}
			}
		}catch(Exception e){
			history.setResultCode(-1);//记录错误
			history.setResultMessage(e.getMessage());
			throw e;
		}finally{
			pushHistoryDao.insert(history);
		}
	}
	/**
	 * 
	* @Title: sendData 
	* @Description: 发送微信数据 
	* @param @param data
	* @param @param openId
	* @param @param channel    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private String sendData(PushWeixinData data, String openId, WeixinChannelInfo channel) throws Exception
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("touser", openId);
		map.put("msgtype", data.getContentType());
		if ("text".equalsIgnoreCase(data.getContentType())) {
			Map<String, String> content =  new HashMap<String, String>();
			String text = data.getContent();
			if (text.contains("<a href")) {
				if (text.contains("?")) {
					text = text.replaceFirst("\">", "&fromUserName="+openId + "\">");
				} else {
					text = text.replaceFirst("\">", "?fromUserName="+openId + "\">");
				}	
				logger.info("\n----------"+"sendAsData text="+text);
			}
			content.put("content", text);
			map.put("text", content);
		}else if("news".equalsIgnoreCase(data.getContentType())){
			map.put("news",JsonUtil.toObject(data.getContent(), Map.class));
		}
        
        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+channel.getAccessToken()+"";
        Map<String, String> hMap = new HashMap<String, String>();
        hMap.put("Content-Type", "application/json;charset=UTF-8");
        String result = HttpUtil.postString(url, JsonUtil.toJson(map), "utf-8", hMap);
        logger.info("\n----------"+"sendAsData\n"+result);
        return result;
    }
	
	/**
	 * 
	* @Title: sendTemplate 
	* @Description: 发送模版 
	* @param @param template
	* @param @param openId
	* @param @param channel    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private String sendTemplate(PushWeixinTemplate template, String openId, WeixinChannelInfo channel) throws Exception
	{
		//获取微信模版
		WeixinTemplateInfo wxTemplate = templateMap.get(template.getName());
		
		String url = template.getUrl();
		if (!StringUtils.isEmpty(url)) {
			if (url.contains("?")) {
				url = url.replaceAll("fromUserName", "xxx");
				url += "&fromUserName="+openId;
			} else {
				url += "?fromUserName="+openId;
			}
			logger.info("\n----------"+"sendTemplate url="+url);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("touser", openId);
		map.put("template_id", wxTemplate.getWeixinId());
		map.put("url", url);
		map.put("topcolor", "#FF0000");
		
		String[] keywords = wxTemplate.keywordList();
		Map<String, Object> map1 = new HashMap<String, Object>();
		List<String> values = template.getValues();
		if(wxTemplate.getName().equals("dingdanzhuangtaigenxingtongzhi")){
			for (int index=0; index<values.size(); index++){
				Map<String, String> map2 = new HashMap<String, String>();
				map2.put("value", values.get(index));
				if(index==3)
					map2.put("color", "#ff782e");
				else
					map2.put("color", "#173177");
				map1.put(keywords[index], map2);
			}

		}else{
			for (int index=0; index<values.size(); index++){
				Map<String, String> map2 = new HashMap<String, String>();
				map2.put("value", values.get(index));
				map2.put("color", "#173177");
				map1.put(keywords[index], map2);
			}
		}
		map.put("data", map1);
		
        url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+channel.getAccessToken()+"";
        Map<String, String> hMap = new HashMap<String, String>();
        hMap.put("Content-Type", "application/json;charset=UTF-8");
        String result = HttpUtil.postString(url, JsonUtil.toJson(map), "utf-8", hMap);            
        logger.info("\n----------\n"+"sendAsTemplate\n"+result);
        return result;
	}
	
	/**
	 * 发送微信消息
	 */
	@SuppressWarnings("finally")
	@Override
	public boolean sendMessage(WeixinSendMessageReq req) {
		boolean result = false;
		PushNotifyInfo notify = new PushNotifyInfo();
		notify.setBusinessId(req.getBusinessId());
		notify.setProductId(req.getProductId());
		notify.setContent(req.getContent());
		notify.setPushType(req.getContentType());
		PushBindInfo bind = new PushBindInfo();
		bind.setBusinessId(req.getBusinessId());
		bind.setProductId(req.getProductId());
		bind.setDeviceToken(req.getOpenId());
		try{
			sendNotify(notify, bind);
			result=true;
		}catch(Exception e){
			LogUtil.logError.error(e.getMessage());
		}finally{
			return result;
		}
//		WeixinChannelInfo channel = channel4Product(new ProductInfo(req.getBusinessId(), req.getProductId()));
//		if (null != channel) {
//			try {
//				if (PushConstValue.NotifyType.NotifyTypeWXData.ordinal() == req.getContentType()) {
//					PushWeixinData data = JsonUtil.toObject(req.getContent(), PushWeixinData.class);
//					sendData(data, req.getOpenId(), channel);
//				} else if (PushConstValue.NotifyType.NotifyTypeWXTemplate.ordinal() == req.getContentType()){
//					PushWeixinTemplate template = JsonUtil.toObject(req.getContent(), PushWeixinTemplate.class);
//					//模版名称处理
//					template.setName(template.getName()+"-"+channel.getBusinessId()+"-"+channel.getProductId());
//					sendTemplate(template, req.getOpenId(), channel);
//				}			
//				return true;
//			} catch (Exception e) {
//				LogUtil.logError.error("=============================="+e.getMessage());
//			}
//		}
	}
	
	/**
	 * 
	* @Title: channel4Product 
	* @Description: 获取channel信息 
	* @param @param product
	* @param @return    设定文件 
	* @return WeixinChannelInfo    返回类型 
	* @throws
	 */
	private WeixinChannelInfo channel4Product(ProductInfo product)
	{
		String key = ""+product.getBusinessId()+"-"+product.getProductId()+"";
		return channel4Channel(channelMap.get(key));
	}
	
	/**
	 * 获取微信通道列表
	 */

	@Override
	public List<WeixinChannelInfo> channelList() {
		return channelMap.channelList();
	}

	/**
	 * 更新微信通道信息
	 */
	@Override
	public void updateChannel(WeixinChannelInfo channel) {
		pushDao.updateWeinxinChannel(channel);
		channelMap.remove(channel.key());
		channelMap.put(channel.key(), channel);
	}

	/**
	 * 
	* @Title: updateChannelAccessToken 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param wxServiceName
	* @param @param accessToken    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@Override
	public void updateChannelAccessToken(String wxServiceName, String accessToken) {
		for (WeixinChannelInfo channel : channelMap.values()){
			if (StringUtils.equals(channel.getServiceName(), wxServiceName)){
				LogUtil.log.info("updateChannelAccessToken find" + wxServiceName);
				channel.setAccessToken(accessToken);
				updateChannel(channel);
				break;
			}
		}
		LogUtil.log.info("updateChannelAccessToken not find" + wxServiceName);
	}

	/**
	 * 
	* @Title: addTemplate 
	* @Description: 添加模版 
	* @param @param template    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@Override
	public void addTemplate(WeixinTemplateInfo template) {
		pushDao.addWeixinTemplate(template);
		templateMap.remove(template.key());
		templateMap.put(template.key(), template);
	}

	/**
	 * 
	* @Title: updateTemplate 
	* @Description: 更新微信模版 
	* @param @param template    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@Override
	public void updateTemplate(WeixinTemplateInfo template) {
		pushDao.updateWeixinTemplate(template);
		templateMap.remove(template.key());
		templateMap.put(template.key(), template);		
	}

	/**
	 * 
	* @Title: templateList 
	* @Description: 获取微信模版列表 
	* @param @return    设定文件 
	* @return List<WeixinTemplateInfo>    返回类型 
	* @throws
	 */
	@Override
	public List<WeixinTemplateInfo> templateList() {
		return templateMap.templateList();
	}
	
	/**
	 * 
	* @Title: getQR 
	* @Description: 获取微信二维码 
	* @param @param req
	* @param @return    设定文件 
	* @return WeixinQRInfo    返回类型 
	* @throws
	 */
	public WeixinQRInfo getQR(WeixinQRReq req)
	{
		WeixinQRInfo info = null;
		WeixinChannelInfo channel = channel4Product(new ProductInfo(req.getBusinessId(), req.getProductId()));
		
		if (null != channel) {
			Weixin2QRInfo qr = weixinDao.getQR(req.getUserId(), req.getUserRole(), req.getTargetId(), channel.getServiceName());
			//没有记录，从微信获取并保存
			if (null == qr || 0 == qr.getTicketId()) {
				Integer ticketId = weixinDao.getSequence(channel.getServiceName());
				if (null != qr) {
					qr = new Weixin2QRInfo();
					qr.setUserId(req.getUserId());
					qr.setUserRole(req.getUserRole());
					qr.setTargetId(req.getTargetId());
					qr.setServiceName(channel.getServiceName());
					qr.setTicketId(ticketId);
					weixinDao.saveQR(qr);
					qr = null;
				}
	            String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+channel.getAccessToken()+"";
				Map<String, String> scene_str = new HashMap<String, String>();
				scene_str.put("scene_str", ""+ticketId+"");
				Map<String, Object> scenemap = new HashMap<String, Object>();
				scenemap.put("scene", scene_str);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("action_name", "QR_LIMIT_STR_SCENE");						
				map.put("action_info", scenemap);
				
	            String result = HttpUtil.postString(url, JsonUtil.toJson(map));
	            logger.info("WeixinQRInfo getTicket\n"+result);		
	            WeixinTicketResp resp = JsonUtil.toObject(result, WeixinTicketResp.class);
	            if (null != resp){
		            if (!StringUtils.isEmpty(resp.getTicket())) {
						qr = new Weixin2QRInfo();
						qr.setUserId(req.getUserId());
						qr.setUserRole(req.getUserRole());
						qr.setTargetId(req.getTargetId());
						qr.setServiceName(channel.getServiceName());
						qr.setTicketId(ticketId);
						qr.setTicket(resp.getTicket());
						qr.setUrl(resp.getUrl());
						qr.setQrUrl("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+resp.getTicket());
						weixinDao.saveQR(qr);
					} else {
						throw new RuntimeException(resp.getErrmsg());
					}
	            } else {
	            	throw new RuntimeException("未知错误");   	
	            }
			}
			if (null != qr) {
				info = new WeixinQRInfo();
				info.setBusinessId(req.getBusinessId());
				info.setProductId(req.getProductId());
				info.setUserId(req.getUserId());
				info.setUserRole(req.getUserRole());
				info.setTargetId(req.getTargetId());
				info.setQRUrl(qr.getQrUrl());
				info.setTicket(qr.getTicket());
				info.setTicketId(qr.getTicketId());					
			}
		} else {
			throw new RuntimeException("错误的businessId或者productId");
		}
		return info;
	}
	
	/**
	 * 
	* @Title: downloadMediaFile 
	* @Description:  
	* @param @param req    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@Override
	public boolean downloadMediaFile(WeixinMediaGetReq req) {
		WeixinChannelInfo channel = channel4Product(new ProductInfo(req.getBusinessId(), req.getProductId()));
		if (null != channel) {
			String url = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token="+channel.getAccessToken()+"&media_id="+req.getMedia_id();
			return HttpUtil.getToFile(url, req.getPath());
		}
		LogUtil.logError.error("downloadMediaFile weixinChannel is null,req:"+JsonUtil.toJson(req));
		return false;
	}
	/**
	 * 
	* @Title: getOpenId 
	* @Description: 获取openId 
	* @param @param req
	* @param @return 
	* @return WeixinOpenIdInfo 
	* @throws
	 */
	@Override
	public WeixinOpenIdInfo getOpenId(WeixinOpenIdGetReq req) {
		WeixinOpenIdInfo openId = null;		
		WeixinChannelInfo channel = channel4Product(new ProductInfo(req.getBusinessId(), req.getProductId()));
		if (null != channel){
			String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+channel.getAppId()+"&secret="+channel.getAppSecret()+"&code="+req.getCode()+"&grant_type=authorization_code";
			String result = HttpUtil.get(url);
            logger.info("WeixinOpenIdInfo getOpenId\n"+result);		
            WeixinOpenIdResp resp = JsonUtil.toObject(result, WeixinOpenIdResp.class);
			if (null != resp) {
				if (!StringUtils.isEmpty(resp.getOpenid())){
					openId = new WeixinOpenIdInfo();
					openId.setBusinessId(req.getBusinessId());
					openId.setProductId(req.getProductId());
					openId.setOpenId(resp.getOpenid());
					openId.setAccess_token(resp.getAccess_token());
				} else {
					throw new RuntimeException(resp.getErrmsg());
				}
			} else {
				throw new RuntimeException("未知错误");
			}
		} else {
			throw new RuntimeException("错误的businessId或者productId");
		}
		return openId;
	}
	
	/**
	 * 
	* @Title: getUser 
	* @Description: 根据OpenId获取用户信息 
	* @param @param req
	* @param @return    设定文件 
	* @return WeixinUserInfo    返回类型 
	* @throws
	 */
	@Override
	public WeixinUserInfo getUser(WeixinUserGetReq req) {
		WeixinChannelInfo channel = channel4Product(new ProductInfo(req.getBusinessId(), req.getProductId()));
		if (null == channel) {
			throw new RuntimeException("错误的businessId或者productId");
		}
		String url = "";
		if(StringUtils.isNotEmpty(req.getAccess_token()))
			url="https://api.weixin.qq.com/sns/userinfo?access_token="+req.getAccess_token()+"&openid="+req.getOpenId()+"&lang=zh_CN";
		else
			url="https://api.weixin.qq.com/cgi-bin/user/info?access_token="+channel.getAccessToken()+"&openid="+req.getOpenId()+"&lang=zh_CN";
		String result = HttpUtil.get(url);
        logger.info("WeixinUserInfo getUser\n"+result);
        return JsonUtil.toObject(result, WeixinUserInfo.class);
	}
	/**
	 * 
	* @Title: channel4Channel 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param channel
	* @param @return    设定文件 
	* @return WeixinChannelInfo    返回类型 
	* @throws
	 */
	private WeixinChannelInfo channel4Channel(WeixinChannelInfo channel)
	{
		if (null == channel) {
			return null;
		}
		WeixinChannelInfo rechannel = pushDao.getWeixinChannelInfo(channel.getServiceName());
		return (null == rechannel) ? channel : rechannel;
	}
	
	/**
	 * 获取位置信息
	 */
	@Override
	public WeixinLocationInfo getLocation(WeixinLocationGetReq req) {
		WeixinLocationInfo location = null;
		String url = "http://api.map.baidu.com/geocoder/v2/?ak=TtZofQ91BbFf1H3xBkHz08IT&location="+req.getLat()+","+req.getLng()+"&output=json&pois=0";
		String result = HttpUtil.get(url);
		logger.info("WeixinLocationInfo getLocation\n"+result);
		BaiduLocationResp resp = JsonUtil.toObject(result, BaiduLocationResp.class);
		if ((null != resp) && (0 == resp.getStatus())) {
			location = new WeixinLocationInfo();
			location.setAdCode(resp.getResult().getAddressComponent().getAdcode());
			location.setCityCode(resp.getResult().getCityCode());
			location.setLat(resp.getResult().getLocation().getLat());
			location.setLng(resp.getResult().getLocation().getLng());
			location.setCountry(resp.getResult().getAddressComponent().getCountry());
			location.setProvince(resp.getResult().getAddressComponent().getProvince());
			location.setCity(resp.getResult().getAddressComponent().getCity());
			location.setDistrict(resp.getResult().getAddressComponent().getDistrict());
		} else {
			throw new RuntimeException("未知错误");
		}
		return location;
	}
		
	/**
	 * 获取JSConfig 信息
	 */
	@Override
	public WeixinJSConfigInfo getJSConfig(WeixinJSConfigGetReq req) {
		WeixinChannelInfo channel = channel4Product(new ProductInfo(req.getBusinessId(), req.getProductId()));
		if (null == channel) {
			throw new RuntimeException("错误的businessId或者productId");
		}
		String timestamp = System.currentTimeMillis()+"";
		String nonceStr = StringUtil.getRandomString(15);
		String jsString = "jsapi_ticket="+channel.getJsTicket()+"&noncestr="+nonceStr+"&timestamp="+timestamp+"&url="+req.getUrl();
		String signature = StringUtil.getSHA1String(jsString);
		WeixinJSConfigInfo config = new WeixinJSConfigInfo();
		config.setAppId(channel.getAppId());
		config.setTimestamp(timestamp);
		config.setNonceStr(nonceStr);
		config.setSignature(signature);
		return config;
	}
	
	static class BaiduLatLng{
		private double lng;
		private double lat;
		/** 
		* @return lng 
		*/
		public double getLng() {
			return lng;
		}
		/** 
		* @param lng 要设置的 lng 
		*/
		public void setLng(double lng) {
			this.lng = lng;
		}
		/** 
		* @return lat 
		*/
		public double getLat() {
			return lat;
		}
		/** 
		* @param lat 要设置的 lat 
		*/
		public void setLat(double lat) {
			this.lat = lat;
		}
	};
	
	static class BaiduAddressComponent{
		private String adcode;
		private String city;
		private String country; 
		private String direction;
		private String distance;
		private String district;
		private String province;
		private String street;
		private String street_number;
		private Integer country_code;
		/** 
		* @return city 
		*/
		public String getCity() {
			return city;
		}
		/** 
		* @param city 要设置的 city 
		*/
		public void setCity(String city) {
			this.city = city;
		}
		/** 
		* @return country 
		*/
		public String getCountry() {
			return country;
		}
		/** 
		* @param country 要设置的 country 
		*/
		public void setCountry(String country) {
			this.country = country;
		}
		/** 
		* @return direction 
		*/
		public String getDirection() {
			return direction;
		}
		/** 
		* @param direction 要设置的 direction 
		*/
		public void setDirection(String direction) {
			this.direction = direction;
		}
		/** 
		* @return distance 
		*/
		public String getDistance() {
			return distance;
		}
		/** 
		* @param distance 要设置的 distance 
		*/
		public void setDistance(String distance) {
			this.distance = distance;
		}
		/** 
		* @return district 
		*/
		public String getDistrict() {
			return district;
		}
		/** 
		* @param district 要设置的 district 
		*/
		public void setDistrict(String district) {
			this.district = district;
		}
		/** 
		* @return province 
		*/
		public String getProvince() {
			return province;
		}
		/** 
		* @param province 要设置的 province 
		*/
		public void setProvince(String province) {
			this.province = province;
		}
		/** 
		* @return street 
		*/
		public String getStreet() {
			return street;
		}
		/** 
		* @param street 要设置的 street 
		*/
		public void setStreet(String street) {
			this.street = street;
		}
		/** 
		* @return street_number 
		*/
		public String getStreet_number() {
			return street_number;
		}
		/** 
		* @param street_number 要设置的 street_number 
		*/
		public void setStreet_number(String street_number) {
			this.street_number = street_number;
		}
		/** 
		* @return country_code 
		*/
		public Integer getCountry_code() {
			return country_code;
		}
		/** 
		* @param country_code 要设置的 country_code 
		*/
		public void setCountry_code(Integer country_code) {
			this.country_code = country_code;
		}
		/** 
		* @return adcode 
		*/
		public String getAdcode() {
			return adcode;
		}
		/** 
		* @param adcode 要设置的 adcode 
		*/
		public void setAdcode(String adcode) {
			this.adcode = adcode;
		}
	};
	
	static class BaiduLocation{
		private BaiduLatLng location;
		private String formatted_address;
		private BaiduAddressComponent addressComponent;
		private List<String> poiRegions;
		private String sematic_description;
		private Integer cityCode;
		/** 
		* @return location 
		*/
		public BaiduLatLng getLocation() {
			return location;
		}
		/** 
		* @param location 要设置的 location 
		*/
		public void setLocation(BaiduLatLng location) {
			this.location = location;
		}
		/** 
		* @return formatted_address 
		*/
		public String getFormatted_address() {
			return formatted_address;
		}
		/** 
		* @param formatted_address 要设置的 formatted_address 
		*/
		public void setFormatted_address(String formatted_address) {
			this.formatted_address = formatted_address;
		}
		/** 
		* @return addressComponent 
		*/
		public BaiduAddressComponent getAddressComponent() {
			return addressComponent;
		}
		/** 
		* @param addressComponent 要设置的 addressComponent 
		*/
		public void setAddressComponent(BaiduAddressComponent addressComponent) {
			this.addressComponent = addressComponent;
		}
		/** 
		* @return cityCode 
		*/
		public Integer getCityCode() {
			return cityCode;
		}
		/** 
		* @param cityCode 要设置的 cityCode 
		*/
		public void setCityCode(Integer cityCode) {
			this.cityCode = cityCode;
		}
		/** 
		* @return poiRegions 
		*/
		public List<String> getPoiRegions() {
			return poiRegions;
		}
		/** 
		* @param poiRegions 要设置的 poiRegions 
		*/
		public void setPoiRegions(List<String> poiRegions) {
			this.poiRegions = poiRegions;
		}
		/** 
		* @return sematic_description 
		*/
		public String getSematic_description() {
			return sematic_description;
		}
		/** 
		* @param sematic_description 要设置的 sematic_description 
		*/
		public void setSematic_description(String sematic_description) {
			this.sematic_description = sematic_description;
		}
	};
	
	/**
	 * 
	* @ClassName: BaiduLocationResp 
	* @Description: 百度位置信息 
	* @author LIPENG
	* @date 2016年1月6日 下午5:15:01 
	*
	 */
	static class BaiduLocationResp{
		private Integer status;
		private BaiduLocation result;
		/** 
		* @return status 
		*/
		public Integer getStatus() {
			return status;
		}
		/** 
		* @param status 要设置的 status 
		*/
		public void setStatus(Integer status) {
			this.status = status;
		}
		/** 
		* @return result 
		*/
		public BaiduLocation getResult() {
			return result;
		}
		/** 
		* @param result 要设置的 result 
		*/
		public void setResult(BaiduLocation result) {
			this.result = result;
		}
	};
	
	/**
	 * 
	* @ClassName: WeixinOpenIdResp 
	* @Description: openId，微信返回
	* @author LIPENG
	* @date 2016年1月4日 上午11:30:49 
	*
	 */
	static class WeixinOpenIdResp{
		private Integer errcode;
		private String errmsg;
		private String access_token;
		private Integer expires_in;
		private String refresh_token;
		private String openid;
		private String scope;
		/** 
		* @return errcode 
		*/
		public Integer getErrcode() {
			return errcode;
		}
		/** 
		* @param errcode 要设置的 errcode 
		*/
		public void setErrcode(Integer errcode) {
			this.errcode = errcode;
		}
		/** 
		* @return errmsg 
		*/
		public String getErrmsg() {
			return errmsg;
		}
		/** 
		* @param errmsg 要设置的 errmsg 
		*/
		public void setErrmsg(String errmsg) {
			this.errmsg = errmsg;
		}
		/** 
		* @return access_token 
		*/
		public String getAccess_token() {
			return access_token;
		}
		/** 
		* @param access_token 要设置的 access_token 
		*/
		public void setAccess_token(String access_token) {
			this.access_token = access_token;
		}
		/** 
		* @return expires_in 
		*/
		public Integer getExpires_in() {
			return expires_in;
		}
		/** 
		* @param expires_in 要设置的 expires_in 
		*/
		public void setExpires_in(Integer expires_in) {
			this.expires_in = expires_in;
		}
		/** 
		* @return refresh_token 
		*/
		public String getRefresh_token() {
			return refresh_token;
		}
		/** 
		* @param refresh_token 要设置的 refresh_token 
		*/
		public void setRefresh_token(String refresh_token) {
			this.refresh_token = refresh_token;
		}
		/** 
		* @return openid 
		*/
		public String getOpenid() {
			return openid;
		}
		/** 
		* @param openid 要设置的 openid 
		*/
		public void setOpenid(String openid) {
			this.openid = openid;
		}
		/** 
		* @return scope 
		*/
		public String getScope() {
			return scope;
		}
		/** 
		* @param scope 要设置的 scope 
		*/
		public void setScope(String scope) {
			this.scope = scope;
		}
	}
	/**
	 * 
	* @ClassName: WeixinTicketResp 
	* @Description: ticket，微信返回
	* @author LIPENG
	* @date 2016年1月3日 下午3:42:40 
	*
	 */
	static class WeixinTicketResp{
		//错误码
		private Integer errcode;
		//错误信息
		private String errmsg;
		//
		private String ticket;
		//
		private Integer expire_seconds;
		//
		private String url;
		/** 
		* @return errcode 
		*/
		public Integer getErrcode() {
			return errcode;
		}
		/** 
		* @param errcode 要设置的 errcode 
		*/
		public void setErrcode(Integer errcode) {
			this.errcode = errcode;
		}
		/** 
		* @return errmsg 
		*/
		public String getErrmsg() {
			return errmsg;
		}
		/** 
		* @param errmsg 要设置的 errmsg 
		*/
		public void setErrmsg(String errmsg) {
			this.errmsg = errmsg;
		}
		/** 
		* @return ticket 
		*/
		public String getTicket() {
			return ticket;
		}
		/** 
		* @param ticket 要设置的 ticket 
		*/
		public void setTicket(String ticket) {
			this.ticket = ticket;
		}
		/** 
		* @return expire_seconds 
		*/
		public Integer getExpire_seconds() {
			return expire_seconds;
		}
		/** 
		* @param expire_seconds 要设置的 expire_seconds 
		*/
		public void setExpire_seconds(Integer expire_seconds) {
			this.expire_seconds = expire_seconds;
		}
		/** 
		* @return url 
		*/
		public String getUrl() {
			return url;
		}
		/** 
		* @param url 要设置的 url 
		*/
		public void setUrl(String url) {
			this.url = url;
		}
	}
	@Override
	public void WeiXin_bind(Object obj) {
		// TODO Auto-generated method stub
		pushDao.addBind(obj);
	}

	@Override
	public String getMessage(PushContent content) {
		// TODO Auto-generated method stub
		return pushService.getMessage(content);
	}

	@Override
	public Object getWeiXinChannel(Integer businessId, Integer productId) {
		// TODO Auto-generated method stub
		WeixinChannelInfo channel = channelMap.get(""+businessId+"-"+productId+"");
		if(channel==null)
			throw new EmptyObjectExcption(" channel is null businessId="+businessId+"   productId="+productId);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("appId", channel.getAppId());
		return map;
	}
}
