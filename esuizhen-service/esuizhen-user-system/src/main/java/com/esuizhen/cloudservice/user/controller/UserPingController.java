package com.esuizhen.cloudservice.user.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.user.model.UUserPing;
import com.esuizhen.cloudservice.user.service.UUserPingService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.InsufficientParameterExcption;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.NetWorkUtil;

/**
 * <p>Title: UserPingController</p>
 * <p>Description: </p>
 * @author YYCHEN
 * @date 2016年4月20日 下午7:46:47
 */
@Controller
public class UserPingController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private UUserPingService uUserPingService;

	@RequestMapping(value = "/statis/ping", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> userStatisPing(Locale locale, HttpServletRequest request, @RequestBody List<UUserPing> userPings) {
		LogUtil.log.info("用户统计Ping(userStatisPing)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			String ip = NetWorkUtil.getIpAddress(request);
			this.uUserPingService.userStatisPing(userPings, ip);
		} catch(InsufficientParameterExcption e){
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		} 
		return tMsgResponse;
	}
	
	@RequestMapping(value = "/statis/ping/wx", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> userStatisPingWX(Locale locale, HttpServletRequest request, @RequestBody List<UUserPing> userPings) {
		LogUtil.log.info("用户统计页面Ping(userStatisPingWX)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			String ip = NetWorkUtil.getIpAddress(request);
			this.uUserPingService.userStatisPingWX(userPings, ip);
		}catch(EmptyParamExcption e){
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		} 
		return tMsgResponse;
	}

}
