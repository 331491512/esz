package com.westangel.common.bean.push;

import java.io.Serializable;

public final class PushConstValue implements Serializable {
	private static final long serialVersionUID = 1L;
	//绑定类型
	public enum BindType{
		BindUNKNOWNType,
		//微信
		BindTypeWeixin,
		//小米
		BindTypeXiaomi,		
		//个推
		BindTypeGetui,
	};
	
	//设备类型
	public enum DeviceType {
		DeviceUNKNOWNType,
		//web
		DeviceTypeWeb,
		//微信
		DeviceTypeWeixin,
		//安卓
		DeviceTypeAndroid,
		//IOS
		DeviceTypeIOS,
	};
	
	//通知类型
	public enum NotifyType{
		NotifyUNKNOWNType,
		//微信数据
		NotifyTypeWXData,
		//微信模版
		NotifyTypeWXTemplate,		
		//客户端
		NotifyTypeClient,
	};

}
