package com.westangel.commonservice.push.service;

import com.westangel.common.service.PushInnerService;
import com.westangel.commonservice.push.bean.PushBindReq;

public interface PushService extends PushInnerService{
	/**
	 * 
	* @Title: bind 
	* @Description: 绑定 
	* @param @param req    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void bind(PushBindReq req);
}
