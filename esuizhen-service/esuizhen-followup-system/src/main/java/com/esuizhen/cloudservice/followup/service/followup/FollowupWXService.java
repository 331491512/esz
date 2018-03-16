package com.esuizhen.cloudservice.followup.service.followup;

import com.esuizhen.cloudservice.followup.bean.TWXFollowupMessageInfo;
import com.esuizhen.cloudservice.followup.bean.WXFollowupResultReq;
import com.esuizhen.cloudservice.followup.bean.WXFollowupSendReq;
import com.esuizhen.cloudservice.followup.bean.WXFollowupTemplateReq;

/**
 * 
* @ClassName: FollowupService 
* @Description: 随访，随访模版接口
* @author wang_hw
* @date 2015年12月2日 下午6:18:53
 */
public interface FollowupWXService
{	
	//微信模版更新
	void updateWXFollowupTemplate(WXFollowupTemplateReq req);
	//微信消息下发
	void sendWXFollowupMessage(WXFollowupSendReq req);
	
	//微信模版发送信息获取
	TWXFollowupMessageInfo getWXFollowupMessage(WXFollowupSendReq req);
	
	//微信随访消息结果提交
	void createWXFollowupResult(WXFollowupResultReq req);
	
	
}
