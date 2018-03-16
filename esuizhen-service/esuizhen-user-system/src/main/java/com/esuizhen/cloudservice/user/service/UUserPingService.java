package com.esuizhen.cloudservice.user.service;

import java.util.List;

import com.esuizhen.cloudservice.user.model.UUserPing;
import com.westangel.common.excption.InsufficientParameterExcption;

/**
 * <p>Title: UUserPingService</p>
 * <p>Description: 临时用户业务层接口</p>
 * @author YYCHEN
 * @date 2016年4月19日 下午6:44:11
 */
public interface UUserPingService {

	/**
	 * <p>Title: userStatisPing</p>
	 * <p>Description: </p>
	 * @date 2016年4月20日 下午7:48:31
	 * @param pingInfoes
	 * @param ip
	 * @return
	 * @throws InsufficientParameterExcption 
	 */
	public boolean userStatisPing(List<UUserPing> pingInfoes, String ip) throws InsufficientParameterExcption;

	public void userStatisPingWX(List<UUserPing> userPings, String ip);
}
