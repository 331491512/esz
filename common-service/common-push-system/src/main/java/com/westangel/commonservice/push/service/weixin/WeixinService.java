package com.westangel.commonservice.push.service.weixin;

import java.util.List;

import com.westangel.common.service.WeixinInnerService;
import com.westangel.commonservice.push.model.weixin.WeixinChannelInfo;
import com.westangel.commonservice.push.model.weixin.WeixinTemplateInfo;

public interface WeixinService extends WeixinInnerService{
	
	/**
	 * 
	* @Title: channelList 
	* @Description: 通道列表 
	* @param @return    设定文件 
	* @return List<WeixinChannelInfo>    返回类型 
	* @throws
	 */
	public List<WeixinChannelInfo> channelList();
	/**
	 * 
	* @Title: updateChannel 
	* @Description: 更新通道信息 
	* @param @param channel    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateChannel(WeixinChannelInfo channel);
	
	/**
	 * 
	* @Title: updateChannelAccessToken 
	* @Description: 更新 
	* @param @param wxServiceName
	* @param @param accessToken    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateChannelAccessToken(String wxServiceName, String accessToken);
	/**
	 * 
	* @Title: templateList 
	* @Description: 模版列表 
	* @param @return    设定文件 
	* @return List<WeixinTemplateInfo>    返回类型 
	* @throws
	 */
	public List<WeixinTemplateInfo> templateList();
	/**
	 * 
	* @Title: addTemplate 
	* @Description: 添加模版 
	* @param @param template    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void addTemplate(WeixinTemplateInfo template);
	/**
	 * 
	* @Title: updateTemplate 
	* @Description: 更新模版 
	* @param @param template    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateTemplate(WeixinTemplateInfo template);
	
	/**
	 * 微信通道获取
	 * @param businessId
	 * @param productId
	 * @return
	 */
	public Object getWeiXinChannel(Integer businessId, Integer productId);
}
