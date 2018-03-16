package com.westangel.common.service;

import com.westangel.common.bean.LoginByThirdPartyReq;
import com.westangel.common.bean.LoginByThirdPartyResp;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.UserProfileDetailResp;
import com.westangel.common.bean.UserProfileModifyReq;
import com.westangel.common.bean.user.UserLoginOutResp;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.ParamMismatchExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.excption.RemoteCallExcption;

/**
 * 用户业务公共服务提供功能接口
 * @author YYCHEN
 *
 */
public interface UserService {
	/**
	 * 获取用户基本信息
	 * @param userId
	 * @param role
	 * @param relationId
	 * @return
	 */
	public UserProfileDetailResp getDetailUserProfile(Long userId, Integer role, Long relationId) throws EmptyParamExcption, EmptyObjectExcption;
	
	/**
	 * 设置用户基本信息
	 * @param userProfileModifyReq
	 * @return 用户ID
	 * @throws Exception
	 */
	public LoginByThirdPartyResp modifyUserProfile(UserProfileModifyReq userProfileModifyReq) throws EmptyParamExcption, EmptyObjectExcption, ParamMismatchExcption, RemoteCallExcption, RejectRequestExcption;
	
	/**
	 * 第三方登录
	 * @param loginByThirdPartyReq
	 * @return
	 */
	public LoginByThirdPartyResp loginByThirdParty(LoginByThirdPartyReq loginByThirdPartyReq) throws EmptyParamExcption;
	
	/**
	 * 通过微信二维码ticket反查用户信息
	 * @param ticket
	 * @return
	 */
	public UserLoginOutResp queryUserInfoByTicket(String ticket) throws EmptyParamExcption, EmptyObjectExcption;
	
	/**
	 * 取消微信关注
	 * @author lichenghao
	 * @title :cancelUserAttention
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月4日 下午1:33:01
	 */
	public TMsgResponse<Object> cancelUserAttention(Long userId,String fromUserName);
}
