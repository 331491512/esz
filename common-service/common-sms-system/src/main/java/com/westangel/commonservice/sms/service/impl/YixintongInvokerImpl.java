package com.westangel.commonservice.sms.service.impl;

import com.westangel.common.bean.ProductInfo;
import com.westangel.common.bean.sms.SmsSendReportInfo;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.TimeUtil;
import com.westangel.commonservice.sms.dao.SmsDao;
import com.westangel.commonservice.sms.model.SmsCaptchaRecordInfo;
import com.westangel.commonservice.sms.model.SmsTemplateMessageInfo;
import com.westangel.commonservice.sms.model.yixintong.*;
import com.westangel.commonservice.sms.service.SmsInvoker;
import com.westangel.commonservice.sms.util.ObjectXMLConvertUtil;
import com.westangel.commonservice.sms.util.SmsUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import org.springframework.util.StringUtils;
//import com.mysql.jdbc.StringUtils;
/**
 * 
* @ClassName: YixintongServiceImpl 
* @Description: 易信通 
* @author LIPENG
* @date 2015年12月21日 下午4:37:46 
*
 */
@Service(value="yixintongService")
public class YixintongInvokerImpl implements SmsInvoker {
	
	@Autowired
	SmsDao smsDao;
	
	@Autowired
	YixintongChannelMap channelMap;
	
	@Value("${yixintong.url}")
	private String yixintongUrl;
	
	@PostConstruct
	public void initConfigure()
	{
		//配置通道
		List<YixintongChannelInfo> channels = smsDao.getYixintongChannelList();
		if (null != channels) {
			for(YixintongChannelInfo channel:channels){
				channelMap.put(key4BusinessProduct(channel.getBusinessId(), channel.getProductId()), channel);
			}
		}
	}
		
	/**
	 * 发送验证码
	 */
	@Override
	public boolean sendCapatcha(ProductInfo product, String mobile, String templateText) 
	{
		boolean ret = false;
		SmsCaptchaRecordInfo record = smsDao.getCaptcha(product.getBusinessId(), product.getProductId(), mobile, null);
		
		if (null != record) {
			Long timing = 0L;
			try {
				timing = TimeUtil.timingWithNow(record.getOccurTime());	
			} catch (Exception e) {
			}
			if (timing > 30*60000) {
				record = null;
			}			
		}
		String captcha = (null != record)?record.getCaptcha():SmsUtil.getCaptchaNum();
		String content = org.springframework.util.StringUtils.replace(templateText, "{0}", captcha);		
		if (sendSms(mobile, content, product)){
			smsDao.saveCaptcha(product.getBusinessId(), product.getProductId(), mobile, captcha);
			ret = true;
		}
		return ret;
	}
	
	/**
	 * 发送短信
	 */
	@Override
	public boolean sendContent(ProductInfo product, List<String> moblies, String content) 
	{
		String mobiles = new String();
		for(int i = 0; i < moblies.size(); i++){
			mobiles += moblies.get(i);
			if (i != moblies.size()-1) {
				mobiles += ",";
			}
		}
		return sendSms(mobiles, content, product);
	}
	
	/**
	 * 发送模版短信
	 */
	@Override
	public boolean sendTemplateMessage(ProductInfo product, String mobile, SmsTemplateMessageInfo message) 
	{
		String content = new String();
		content += message.getExpression();
		for(int i = 0; i < message.getValues().size(); i++){
			String part = "{"+i+"}";
			content = org.springframework.util.StringUtils.replace(content, part, message.getValues().get(i));
		}
		return sendSms(mobile, content, product);
	}

	/**
	 * 
	* @Title: sendSms 
	* @Description: 发送短信内容 
	* @param @param mobiles
	* @param @param content
	* @param @param channel    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private boolean sendSms(String mobiles, String content, ProductInfo product)
	{	
		if (StringUtils.isEmpty(mobiles)) {
			throw new RuntimeException("发送的目标手机号不能为空！");
		}
		if (StringUtils.isEmpty(content)) {
			throw new RuntimeException("发送的短信内容不能为空！");
		}
		String key = key4BusinessProduct(product.getBusinessId(), product.getProductId());
		YixintongChannelInfo channel = channelMap.get(key);		
		if (null == channel) {
			throw new RuntimeException("易信通没有找到发送通道：(" + key + ")!");
		}
		boolean ret = false;
		List<NameValuePair> paras = new ArrayList<NameValuePair>();
		paras.add(new BasicNameValuePair("enterpriseID", channel.getEnterpriseID()));
		paras.add(new BasicNameValuePair("loginName", channel.getLoginName()));
		paras.add(new BasicNameValuePair("password", channel.getPassword()));
		paras.add(new BasicNameValuePair("subPort", channel.getSubPort()));
		paras.add(new BasicNameValuePair("mobiles", mobiles));
		paras.add(new BasicNameValuePair("content", content));
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		
		String result = HttpUtil.postForm(yixintongUrl+"/sendSMS.action", paras,"UTF-8", map);

		LogUtil.log.info("yixintong短信响应结果："+result);
		if (null == result) { 
			throw new RuntimeException("发送到服务器失败！");
		} else {
			if (-1 == com.mysql.jdbc.StringUtils.indexOfIgnoreCase(result, "<Result>0</Result>")){
				LogUtil.logError.error("sendSms:\n"+result);
				throw new RuntimeException("发送失败，请稍后再试！");
			} else {
				ret = true;
			}
		}
		return ret;
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
		try {
			throw new RuntimeException("易信通不提供双向回拨功能！");	
		} catch (Exception e) {
		}
		return false;
	}

	public String key4BusinessProduct(Integer businessId, Integer productId)
	{
		return ""+businessId+"-"+productId+"";
	}

	@Override
	public Object getReceipt(ProductInfo product) {
		// TODO Auto-generated method stub
		String key = key4BusinessProduct(product.getBusinessId(), product.getProductId());
		YixintongChannelInfo channel = channelMap.get(key);		
		if (null == channel) {
			throw new RuntimeException("易信通没有找到发送通道：(" + key + ")!");
		}
		List<NameValuePair> paras = new ArrayList<NameValuePair>();
		paras.add(new BasicNameValuePair("enterpriseID", channel.getEnterpriseID()));
		paras.add(new BasicNameValuePair("loginName", channel.getLoginName()));
		paras.add(new BasicNameValuePair("password", channel.getPassword()));
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		String result = HttpUtil.postForm(yixintongUrl+"/getSmsMo.action", paras,"UTF-8", map);
		LogUtil.log.debug(result);
		Response response = (Response)ObjectXMLConvertUtil.toObject(result);
		if(response==null || response.getMo()==null || response.getMo().getItems()==null)
			throw new EmptyObjectExcption("result is null");
		List<SmsItem> items = new ArrayList<SmsItem>();
		for(Item item:response.getMo().getItems())
			items.add(new SmsItem(item));
		return items;
	}

	@Override
	public Object getSmsSendReport(String channelName) {
		// TODO Auto-generated method stub
		String key = channelMap.keySet().iterator().next();
		YixintongChannelInfo channel = channelMap.get(key);
		if (null == channel) {
			throw new RuntimeException("易信通没有找到发送通道：(" + key + ")!");
		}
		List<NameValuePair> paras = new ArrayList<NameValuePair>();
		paras.add(new BasicNameValuePair("enterpriseID", channel.getEnterpriseID()));
		paras.add(new BasicNameValuePair("loginName", channel.getLoginName()));
		paras.add(new BasicNameValuePair("password", channel.getPassword()));
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		String result = HttpUtil.postForm(yixintongUrl+"/getSmsReport.action", paras,"UTF-8", map);
//		try {
//			result = new String(result.getBytes("GBK"),"UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		LogUtil.log.debug(result);
		Response response = (Response)ObjectXMLConvertUtil.toObject(result);
		if(response!=null&&"0".equals(response.getResult())&&response.getReport()!=null&&!"0".equals(response.getReport().getNum())){
			List<SmsSendReportInfo> list = new ArrayList<SmsSendReportInfo>();
			for(Item item : response.getReport().getItems())
				list.add(item.loadingSmsSendReportInfo(channelName));
			return list;
		}
		return null;
	}
}
