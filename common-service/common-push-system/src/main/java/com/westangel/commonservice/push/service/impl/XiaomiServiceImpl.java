package com.westangel.commonservice.push.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.westangel.common.bean.push.PushConstValue;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.util.JsonUtil;
import com.westangel.commonservice.push.dao.PushDao;
import com.westangel.commonservice.push.model.PushBindInfo;
import com.westangel.commonservice.push.model.xiaomi.XiaomiChannelInfo;
import com.westangel.commonservice.push.model.xiaomi.XiaomiChannelMap;
import com.westangel.commonservice.push.service.PushInvokerService;
import com.westangel.commonservice.push.service.xiaomi.XiaomiService;
import com.xiaomi.xmpush.server.Constants;
import com.xiaomi.xmpush.server.Message;
import com.xiaomi.xmpush.server.Result;
import com.xiaomi.xmpush.server.Sender;

/**
* @author 作者 :LIPENG
* @Description: 小米推送实现类
* @version 创建时间：2015年12月6日 下午4:05:55
* 类说明
*/
@Service("xiaomiService")
public class XiaomiServiceImpl implements PushInvokerService, XiaomiService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	PushDao pushDao;

	@Autowired
	XiaomiChannelMap channelMap;
	
	/**
	 * 
	* @Title: initConfig 
	* @Description: 初始化通道配置 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@PostConstruct
	public void initConfig()
	{
		List<XiaomiChannelInfo> channels = pushDao.xiaomiChannelList();
		if (null != channels) {
			for (XiaomiChannelInfo channel : channels){
				channelMap.put(channel.key(), channel);
			}
		}
	}
	/**
	 * 推送
	 */
	@Override
	public void pushNotify(PushNotifyInfo notify, PushBindInfo bind) 
	{	
		// 是微信数据，暂时不处理
		if (PushConstValue.NotifyType.NotifyTypeWXData.ordinal() == notify.getPushType()){
			return;
		}
		// 是微信模版，暂时不处理
		else if (PushConstValue.NotifyType.NotifyTypeWXTemplate.ordinal() == notify.getPushType()){
			return;
		}
		
		try {
			XiaomiChannelInfo channel = null;
			Message message = null;
			//安卓
			if (PushConstValue.DeviceType.DeviceTypeAndroid.ordinal() == bind.getDeviceType()) {
				String key = ""+bind.getBusinessId()+"-"+bind.getProductId()+"android";
				channel = channelMap.get(key);
				
				Constants.useOfficial();
				message = new Message.Builder()
						.title(notify.getTipText())
						.description(notify.getTipText())
						.payload(notify.getContent())
						.restrictedPackageName(channel.getAppPackageName())
						.passThrough(1)
						.notifyType(1)
						.build();
			}
			//苹果
			else if (PushConstValue.DeviceType.DeviceTypeIOS.ordinal() == bind.getDeviceType()){
				String key = ""+bind.getBusinessId()+"-"+bind.getProductId()+"ios";
				channel = channelMap.get(key);
				
				if (1 == channel.getUseOfficial()) {
					Constants.useOfficial();	
				} else {
					Constants.useSandbox();
				}
				message = new Message.IOSBuilder()
						.description(notify.getTipText())
						.soundURL("default")
						.badge(1)
						.extra("content", notify.getContent())
						.build();
			}
			if (null != message) {
				Sender sender = new Sender(channel.getAppSecret());
				Result result = sender.send(message, bind.getDeviceToken(), 0);
				logger.info("xiaomipush:\n"+JsonUtil.toJson(notify)+" : "+bind.getDeviceType()+" : "+result.getErrorCode()+" : "+result.getMessageId()+" : "+result.getReason());
			} else {
				logger.info("xiaomipush:\n"+JsonUtil.toJson(notify)+" : "+bind.getDeviceType()+" : "+"message=null");
			}
		} catch (Exception e) {
			logger.error("xiaomipush:\n"+JsonUtil.toJson(notify)+" : "+bind.getDeviceType()+" : "+e.toString());
		}
	}

	/**
	 * 获取通道列表
	 */
	public List<XiaomiChannelInfo> channelList() {
		return channelMap.channelList();
	}
	
	/**
	 *更新小米通道 
	 */
	@Override
	@Transactional
	public void updateChannel(XiaomiChannelInfo channel) {
		pushDao.updateXiaomiChannel(channel);
		channelMap.remove(channel.key());
		channelMap.put(channel.key(), channel);
	}
}
