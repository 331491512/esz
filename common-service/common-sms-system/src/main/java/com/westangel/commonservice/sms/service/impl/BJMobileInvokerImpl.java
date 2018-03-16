package com.westangel.commonservice.sms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.westangel.common.bean.ProductInfo;
import com.westangel.common.util.TimeUtil;
import com.westangel.commonservice.sms.dao.SmsDao;
import com.westangel.commonservice.sms.model.SmsCaptchaRecordInfo;
import com.westangel.commonservice.sms.model.SmsTemplateMessageInfo;
import com.westangel.commonservice.sms.model.BJMobile.BJMobileChannelInfo;
import com.westangel.commonservice.sms.model.BJMobile.BJMobileChannelMap;
import com.westangel.commonservice.sms.service.SmsInvoker;
import com.westangel.commonservice.sms.util.SmsUtil;

import smscommon.SmsClient;
import smsmessage.sms.SMSclientSubmit;


@Service(value="bjmoblieService")
public class BJMobileInvokerImpl implements SmsInvoker {
	private Logger logger=LoggerFactory.getLogger(getClass());
	@Autowired
	SmsDao smsDao;
	
	@Autowired
	BJMobileChannelMap channelMap;
	
	@PostConstruct
	public void initConfigure()
	{
		//电话通道配置
		List<BJMobileChannelInfo> channels = smsDao.getBJMobileChannelList();
		if (null != channels) {
			for (BJMobileChannelInfo channel:channels) {
				channelMap.put(key4BusinessProduct(channel.getBusinessId(), channel.getProductId()), channel);
			}
		}
	}
	
	@Override
	public boolean sendCapatcha(ProductInfo product, String mobile, String templateText) {
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
		if (sendSingleSms(mobile, content, product)){
			smsDao.saveCaptcha(product.getBusinessId(), product.getProductId(), mobile, captcha);
			ret = true;
		}
		return ret;
	}
	//初始化开启通道
	public BJMobileInvokerImpl(){
		SmsClient.getInstance();///建立socket连接
	}
	/**
	 * 
	* @Title: sendSingleSms 
	* @Description: 单条发送 
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean sendSingleSms(String mobile, String content, ProductInfo product){
		if (StringUtils.isEmpty(mobile)) {
			throw new RuntimeException("发送的目标手机号不能为空！");
		}
		if (StringUtils.isEmpty(content)) {
			throw new RuntimeException("发送的短信内容不能为空！");
		}		
		String key = key4BusinessProduct(product.getBusinessId(), product.getProductId());
		BJMobileChannelInfo channel = channelMap.get(key);		
		if (null == channel) {
			throw new RuntimeException("北京移动没有找到发送通道：(" + key + ")!");
		}
		
		try {				
			SMSclientSubmit mt = new SMSclientSubmit();///实例化用于下发短信的对象
			mt.setSrcID(channel.getAccessNumber()+"22");
			mt.setDestID(mobile);
			mt.setMsgContent(content);
			if (!StringUtils.isEmpty(channel.getServiceId())) {
				mt.setServiceID(channel.getServiceId());	
			}			
			mt.setPriority(1);//设置优先级，可选择字段，默认为1。
			String retVal = "1";//下发信息的返回值
			while ("1".equals(retVal) || "2".equals(retVal) || "3".equals(retVal)) {
				Thread.sleep(1000);
				retVal = mt.sendSMS();	///获得信息下发的标识，用于匹配状态报告
				if ("1".equals(retVal)) {						
					logger.error("下发缓冲池已满.");
				} else if ("2".equals(retVal)) {
					logger.error("没有建立连接");
				} else if ("3".equals(retVal)) {
					logger.error("流量超过设定值");
				}else{
					logger.info("企业下行消息标识 ["+retVal+"]，"
							+"目的号码 ["+mt.getDestID()+"]，"
							+"短信内容 ["+mt.getMsgContent()+"]");					
					}
				}
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}	
		
		return false;
	}
	
	/**
	 * 
	* @Title: sendSms 
	* @Description: 发送短信内容 
	* @param @param mobiles
	* @param @param content
	* @param @param product
	* @param @return    设定文件 
	* @return boolean    返回类型 
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
		BJMobileChannelInfo channel = channelMap.get(key);		
		if (null == channel) {
			throw new RuntimeException("北京移动没有找到发送通道：(" + key + ")!");
		}
		try {
			SMSclientSubmit mt = new SMSclientSubmit();
			mt.setSrcID(channel.getAccessNumber());
			mt.setDestID(mobiles);
			mt.setMsgContent(content);
			if (!StringUtils.isEmpty(channel.getServiceId())) {
				mt.setServiceID(channel.getServiceId());	
			}
			mt.setPriority(1);
			List<String> sendIDList = new ArrayList<String>();
			sendIDList.add("1");
			String id = sendIDList.get(0);
			try {
				while("1".equals(id) 
						|| "2".equals(id)
						|| "3".equals(id)
						|| "4".equals(id) 
						|| "5".equals(id) 
						|| "6".equals(id)){
					Thread.sleep(1000);
					sendIDList = mt.sendSMSList();
					id = sendIDList.get(0);
					if ("1".equals(id)) {
						logger.error("信息下发缓冲队列已满");
					} else if ("2".equals(id)){
						logger.error("没有建立连接");
					} else if ("3".equals(id)){
						logger.error("流量超出设定值");
					} else if ("4".equals(id)){
						logger.error("短信长度超出限制");
						throw new RuntimeException("短信长度超出限制！");
					} else if ("5".equals(id)){
						logger.error("群发数量超出");
					} else if ("6".equals(id)){			
						logger.error("分隔符不正确");
					} else {
						
					}
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return true;
	}

	@Override
	public boolean sendContent(ProductInfo product, List<String> moblies, String content) {
		try {
			//throw new RuntimeException("北京移动不提供发送短信通道！");
			for(String mobile:moblies)
				this.sendSingleSms(mobile, content, product);
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public boolean sendTemplateMessage(ProductInfo product, String mobile, SmsTemplateMessageInfo templateMessageInfo) {
		try {
			throw new RuntimeException("北京移动不提供发送模版短信通道！");
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public boolean callTwoway(ProductInfo product, String from, String to, String serFrom, String serTo,
			String userData, String maxCallTime, String callbackUrl) {
		try {
			throw new RuntimeException("北京移动不提供双向回拨功能！");
		}catch(Exception e){
			
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
		return null;
	}

	@Override
	public Object getSmsSendReport(String channelName) {
		// TODO Auto-generated method stub
		return null;
	}	
}
