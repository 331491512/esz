package com.esuizhen.cloudservice.user.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.user.bean.UserRegisterReq;
import com.esuizhen.cloudservice.user.service.UserDeviceService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.user.UserRegisterResp;
import com.westangel.common.util.LogUtil;

/**
 * <p>Title: UserDeviceController</p>
 * <p>Description: 临时（游客）业务控制类</p>
 * @author YYCHEN
 * @date 2016年4月20日 下午7:23:18
 */
@Controller
public class TouristController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private UserDeviceService userDeviceService;

	@RequestMapping(value = "/guest/access", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<UserRegisterResp> guestUserAccess(@RequestBody UserRegisterReq userRegisterReq,
			Locale locale) {
		LogUtil.log.info("游客用户临时接入(guestUserAccess)==========>>");
		TMsgResponse<UserRegisterResp> tMsgResponse = new TMsgResponse<UserRegisterResp>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(userDeviceService.guestUserAccess(userRegisterReq));
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		} 
		return tMsgResponse;
	}

}
