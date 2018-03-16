package com.westangel.common.service;

import com.westangel.common.bean.push.PushContent;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.push.PushUserAlias;

/**
 * 
* @ClassName: PushNotifyService 
* @Description: 推送服务 
* @author LIPENG
* @date 2015年12月22日 下午4:27:50 
*
 */
public interface PushInnerService {
	/**
	 * 发送推送
	* @Title: push 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param notify    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void push(PushNotifyInfo notify);
	
	/**
	 * 
	* @Title: addUserAlias 
	* @Description: 为用户添加别名 
	* @param @param userAlias    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void addUserAlias(PushUserAlias userAlias);
	/**
	 * 
	* @Title: removeUserAlias 
	* @Description: 删除用户别名 
	* @param @param userAlias    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void removeUserAlias(PushUserAlias userAlias);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getMessage
	 * @Description:获取消息
	 * @return String
	 * @date 2016年6月16日 下午7:20:47
	 */
	public String getMessage(PushContent pushContent);
}
