package com.westangel.commonservice.push.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.westangel.common.bean.push.PushConstValue;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.commonservice.push.model.PushBindInfo;
import com.westangel.commonservice.push.model.getui.GetuiChannelInfo;
import com.westangel.commonservice.push.service.PushInvokerService;

/**
* @author 作者 :LIPENG
* @Description: 个推推送实现类
* @version 创建时间：2015年12月6日 下午4:54:00
* 类说明
*/
@Service("getuiService")
public class GetuiServiceImpl implements PushInvokerService {
	//通道－产品映射
	private Map<String, GetuiChannelInfo> channelMap;

	@PostConstruct
	public void initConfiguration() {
		channelMap = new HashMap<String, GetuiChannelInfo>();
	}
	
	@Override
	public void pushNotify(PushNotifyInfo notify, PushBindInfo bind) {
		String key = ""+notify.getBusinessId()+""+notify.getProductId()+"";
		GetuiChannelInfo channel = channelMap.get(key);
		
		// 是微信数据，暂时不处理
		if (PushConstValue.NotifyType.NotifyTypeWXData.ordinal() == notify.getPushType()){	
		}
		// 是微信模版，暂时不处理
		else if (PushConstValue.NotifyType.NotifyTypeWXTemplate.ordinal() == notify.getPushType()){
		} else {
			this.pushNotifyViaChannel(notify, channel, bind);
		}
	}
	
	//通过通道发送
	private void pushNotifyViaChannel(PushNotifyInfo notify, GetuiChannelInfo channel, PushBindInfo bind)
	{
		
	}	
}
