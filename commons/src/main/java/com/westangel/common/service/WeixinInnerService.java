package com.westangel.common.service;

import com.westangel.common.bean.push.PushContent;
import com.westangel.common.bean.weixin.WeixinJSConfigGetReq;
import com.westangel.common.bean.weixin.WeixinJSConfigInfo;
import com.westangel.common.bean.weixin.WeixinLocationGetReq;
import com.westangel.common.bean.weixin.WeixinLocationInfo;
import com.westangel.common.bean.weixin.WeixinMediaGetReq;
import com.westangel.common.bean.weixin.WeixinOpenIdGetReq;
import com.westangel.common.bean.weixin.WeixinOpenIdInfo;
import com.westangel.common.bean.weixin.WeixinQRInfo;
import com.westangel.common.bean.weixin.WeixinQRReq;
import com.westangel.common.bean.weixin.WeixinSendMessageReq;
import com.westangel.common.bean.weixin.WeixinUserGetReq;
import com.westangel.common.bean.weixin.WeixinUserInfo;

public interface WeixinInnerService {
	/**
	 * 
	* @Title: getOpenId 
	* @Description: 根据code获取用户openId 
	* @param @param code
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public WeixinOpenIdInfo getOpenId(WeixinOpenIdGetReq req);
	
	/**
	 * 
	* @Title: getUser 
	* @Description: 根据open id获取用户信息 
	* @param @param req
	* @param @return    设定文件 
	* @return WeixinUserInfo    返回类型 
	* @throws
	 */
	public WeixinUserInfo getUser(WeixinUserGetReq req);
	
	/**
	 * 
	* @Title: getQR 
	* @Description: 获取微信二维码 
	* @param @param req
	* @param @return    设定文件 
	* @return WeixinQRInfo    返回类型 
	* @throws
	 */
	public WeixinQRInfo getQR(WeixinQRReq req);
	
	/**
	 * 
	* @Title: downloadMediaFile 
	* @Description: 获取媒体文件 
	* @param @param req    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public boolean downloadMediaFile(WeixinMediaGetReq req);
	

	/**
	 * 
	* @Title: getLocation 
	* @Description: 根据经纬度获取位置信息 
	* @param @param req
	* @param @return    设定文件 
	* @return WeixinLocationInfo    返回类型 
	* @throws
	 */
	public WeixinLocationInfo getLocation(WeixinLocationGetReq req);
	/**
	 * 
	* @Title: getJSConfig 
	* @Description: 获取JSConfig 
	* @param @param req
	* @param @return    设定文件 
	* @return WeixinJSConfigInfo    返回类型 
	* @throws
	 */
	public WeixinJSConfigInfo getJSConfig(WeixinJSConfigGetReq req);
	/**
	 * 
	* @Title: sendMessage 
	* @Description: 发送消息给openId 
	* @param @param req
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean sendMessage(WeixinSendMessageReq req);
	
	/**
	 * 微信设备绑定
	 * @author lichenghao
	 * @title :WeiXin_bind
	 * @Description:TODO
	 * @return boolean
	 * @date 2016年4月29日 下午5:46:48
	 */
	public void WeiXin_bind(Object obj);
	
	/**
	 * 获取消息
	 * @author lichenghao
	 * @title :getMessage
	 * @Description:TODO
	 * @return String
	 * @date 2016年6月16日 下午7:30:52
	 */
	public String getMessage(PushContent content); 
}
