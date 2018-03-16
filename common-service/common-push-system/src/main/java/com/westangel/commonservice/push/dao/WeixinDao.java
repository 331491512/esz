package com.westangel.commonservice.push.dao;

import org.apache.ibatis.annotations.Param;

import com.westangel.commonservice.push.model.weixin.Weixin2QRInfo;

/**
 * 
* @ClassName: WeixinDao 
* @Description: 微信数据层 
* @author LIPENG
* @date 2016年1月3日 上午11:38:18 
*
 */
public interface WeixinDao {
	/**
	 * 
	* @Title: getQR 
	* @Description: 获取微信服务号 
	* @param @param userId 用户编号
	* @param @param userRole 用户角色
	* @param @param targetId 专题编号
	* @param @param serviceName 微信服务号
	* @param @return    设定文件 
	* @return WeixinQRInfo    返回类型 
	* @throws
	 */
	public Weixin2QRInfo getQR(
			@Param("userId") Long userId,
			@Param("userRole") Integer userRole, 
			@Param("targetId") String targetId,
			@Param("serviceName") String serviceName); 
	
	/**
	 * 
	* @Title: saveQR 
	* @Description: 保存二维码信息 
	* @param @param qr    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void saveQR(Weixin2QRInfo qr);
	
	/**
	 * 
	* @Title: getSequence 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param serviceName
	* @param @return    设定文件 
	* @return Integer    返回类型 
	* @throws
	 */
	public Integer getSequence(@Param("serviceName") String serviceName);
}
