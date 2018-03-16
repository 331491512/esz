package com.westangel.commonservice.push.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.push.PushContent;
import com.westangel.common.bean.push.PushUserAlias;
import com.westangel.commonservice.push.bean.PushBindReq;
import com.westangel.commonservice.push.model.PushBindInfo;
import com.westangel.commonservice.push.model.PushUserBriefInfo;
import com.westangel.commonservice.push.model.weixin.WeixinChannelInfo;
import com.westangel.commonservice.push.model.weixin.WeixinTemplateInfo;
import com.westangel.commonservice.push.model.xiaomi.XiaomiChannelInfo;

/**
 * 
* @ClassName: PushDao 
* @Description:  
* @author LIPENG
* @date 2015年12月14日 下午8:21:11 
*
 */
public interface PushDao {
	/**
	 * 
	* @Title: bind 
	* @Description: 绑定 
	* @param @param req    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void addBind(Object param);
	
	/**
	 * 
	* @Title: binds4User 
	* @Description: 用户获取绑定信息 
	* @param @param userId
	* @param @param userRole
	* @param @param businessId
	* @param @param productId
	* @param @return    设定文件 
	* @return List<PushBindInfo>    返回类型 
	* @throws
	 */
	public List<PushBindInfo> binds4User(
			@Param("userId") Long userId, 
			@Param("userRole") Integer userRole, 
			@Param("businessId") Integer businessId,
			@Param("productId") Integer productId);
	
	/**
	 * 
	* @Title: updateWeinxinChannel 
	* @Description: 添加微信通道 
	* @param @param channelInfo    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateWeinxinChannel(WeixinChannelInfo channelInfo);
	
	/**
	 * 
	* @Title: weixinChannelInfo 
	* @Description: 获取微信通道信息 
	* @param @param channelInfo
	* @param @return    设定文件 
	* @return WeixinChannelInfo    返回类型 
	* @throws
	 */
	public WeixinChannelInfo getWeixinChannelInfo(@Param("serviceName") String serviceName);

	/**
	 * 
	* @Title: weixinChannelList 
	* @Description: 获取微信的通道列表 
	* @param @return    设定文件 
	* @return List<WeixinChannelInfo>    返回类型 
	* @throws
	 */
	public List<WeixinChannelInfo> weixinChannelList();
	
	/**
	 * 
	* @Title: weixinTemplateList 
	* @Description: 获取微信的模版列表 
	* @param @return    设定文件 
	* @return List<WeixinTemplateInfo>    返回类型 
	* @throws
	 */
	public List<WeixinTemplateInfo> weixinTemplateList();
	
	/**
	 * 
	* @Title: addWeixinTemplate 
	* @Description: 添加微信模版 
	* @param @param template    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void addWeixinTemplate(WeixinTemplateInfo template);
	
	/**
	 * 
	* @Title: updateWeixinTemplate 
	* @Description: 更新微信模版 
	* @param @param template    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateWeixinTemplate(WeixinTemplateInfo template);
	
	/**
	 * 
	* @Title: updateXiaomiChannel 
	* @Description: 添加或更新小米通道 
	* @param @param channelInfo    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateXiaomiChannel(XiaomiChannelInfo channelInfo);
	
	/**
	 * 
	* @Title: xiaomiChannelList 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<XiaomiChannelInfo>    返回类型 
	* @throws
	 */
	public List<XiaomiChannelInfo> xiaomiChannelList();
	/**
	 * 
	* @Title: addUserAlias 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userAlias    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void addUserAlias(PushUserAlias userAlias);
	/**
	 * 
	* @Title: removeUserAlias 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userAlias    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void removeUserAlias(PushUserAlias userAlias);
	
	/**
	 * 
	* @Title: userList4Alias 
	* @Description: 获取指定的分组用户列表 
	* @param @param businessId
	* @param @param alias
	* @param @return    设定文件 
	* @return List<PushUserBriefInfo>    返回类型 
	* @throws
	 */
	public List<PushUserBriefInfo> userList4Alias(
			@Param("businessId") Integer businessId,  
			@Param("alias") String alias);
	
	/**
	 * 查询推送消息
	 * @author lichenghao
	 * @title :queryPushConten
	 * @Description:TODO
	 * @return PushConten
	 * @date 2016年6月16日 下午6:14:26
	 */
	public PushContent queryPushConten(PushContent param);
}
