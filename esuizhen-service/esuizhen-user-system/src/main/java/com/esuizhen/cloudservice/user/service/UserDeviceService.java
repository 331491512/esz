package com.esuizhen.cloudservice.user.service;

import com.esuizhen.cloudservice.user.bean.UserRegisterReq;
import com.esuizhen.cloudservice.user.model.UUserPing;
import com.westangel.common.bean.user.UserRegisterResp;
import com.westangel.common.excption.RejectRequestExcption;

public interface UserDeviceService {
	
	/**
	 * <p>Title: guestUserAccess</p>
	 * <p>Description: 游客用户临时接入</p>
	 * @date 2016年4月19日 下午6:08:36
	 * @param userRegisterReq
	 * @return
	 * @throws RejectRequestExcption 
	 */
	public UserRegisterResp guestUserAccess(UserRegisterReq userRegisterReq) throws RejectRequestExcption;

	/**
	 * <p>Title:renovateDeviceInfo</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月18日 下午5:37:11
	 * @param userPing
	 * @return
	 */
	public boolean renovateDeviceInfo(UUserPing userPing);
}
