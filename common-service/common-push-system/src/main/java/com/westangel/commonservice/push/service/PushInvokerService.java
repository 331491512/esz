package com.westangel.commonservice.push.service;

import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.commonservice.push.model.PushBindInfo;

/**
* @author 作者 :LIPENG
* @Description:  推送适配接口
* @version 创建时间：2015年12月6日 下午4:06:57
* 类说明
*/
public interface PushInvokerService {
	//推送消息
	public void pushNotify(PushNotifyInfo notify, PushBindInfo bind);
}
