package com.westangel.commonservice.authorization.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.authorization.RConfFuncPrivilege;
import com.westangel.common.excption.InsufficientParameterExcption;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.authorization.service.RConfFuncPrivilegeService;

@Controller
public class RConfFuncPrivilegeController {
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private RConfFuncPrivilegeService confFuncPrivilegeService;

	@ResponseBody
	@RequestMapping(value = "/role/resource/save", method = RequestMethod.POST)
	public TMsgResponse<Void> saveRoleResource(Locale locale, @RequestBody List<RConfFuncPrivilege> confFuncPrivileges) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.confFuncPrivilegeService.saveRoleResource(confFuncPrivileges);
		} catch(InsufficientParameterExcption ex){
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1403.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
}
