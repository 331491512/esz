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
import com.westangel.common.bean.authorization.MetaResource;
import com.westangel.common.bean.authorization.MetaRole;
import com.westangel.common.bean.authorization.RUserRole;
import com.westangel.common.excption.InsufficientParameterExcption;
import com.westangel.common.excption.ObjectAlreadyExistExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.authorization.service.RoleService;

@Controller
public class RoleController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private RoleService roleService;

	@ResponseBody
	@RequestMapping(value = "/role/add", method = RequestMethod.POST)
	public TMsgResponse<Void> addRole(Locale locale, @RequestBody MetaRole metaRole) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.roleService.addRole(metaRole);
		} catch(ObjectAlreadyExistExcption ex){
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1409.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1409.info, null, locale));
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
	
	@ResponseBody
	@RequestMapping(value = "/role/delete", method = RequestMethod.POST)
	public TMsgResponse<List<MetaResource>> deleteRole(Locale locale, @RequestBody MetaResource metaResource) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<MetaResource>> tMsgResponse = new TMsgResponse<List<MetaResource>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.roleService.deleteRole(metaResource);
		} catch(InsufficientParameterExcption ex){
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1403.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(RejectRequestExcption ex){
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1400.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
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
	
	@ResponseBody
	@RequestMapping(value = "/role/resource/list", method = RequestMethod.GET)
	public TMsgResponse<List<MetaResource>> getRoleResourceList(Locale locale, Integer userRole) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<MetaResource>> tMsgResponse = new TMsgResponse<List<MetaResource>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<MetaResource> metaRoles = this.roleService.getRoleResourceList(null, userRole);
			if (metaRoles == null || metaRoles.isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.code);
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				tMsgResponse.setResult(metaRoles);
			}
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	@ResponseBody
	@RequestMapping(value = "/user/role/list", method = RequestMethod.GET)
	public TMsgResponse<List<RUserRole>> getUserRoleList(Locale locale, Long userId) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<RUserRole>> tMsgResponse = new TMsgResponse<List<RUserRole>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<RUserRole> metaRoles = this.roleService.getUserRoleList(userId);
			if (metaRoles == null || metaRoles.isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.code);
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				tMsgResponse.setResult(metaRoles);
			}
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	@ResponseBody
	@RequestMapping(value = "/metainfo/role/list", method = RequestMethod.GET)
	public TMsgResponse<List<MetaRole>> getMetaInfoRoleList(Locale locale, Long userId) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<MetaRole>> tMsgResponse = new TMsgResponse<List<MetaRole>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<MetaRole> metaRoles = this.roleService.getMetaInfoRoleList(userId);
			if (metaRoles == null || metaRoles.isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.code);
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				tMsgResponse.setResult(metaRoles);
			}
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	@ResponseBody
	@RequestMapping(value = "/data/resource/list", method = RequestMethod.GET)
	public TMsgResponse<List<MetaResource>> getDataResourceList(Locale locale, Long userId, Integer userRole) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<MetaResource>> tMsgResponse = new TMsgResponse<List<MetaResource>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	@ResponseBody
	@RequestMapping(value = "/role/data/resource/update", method = RequestMethod.POST)
	public TMsgResponse<Void> updateRoleDataResourceList(Locale locale, @RequestBody Long userId) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			
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
