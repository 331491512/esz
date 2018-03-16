package com.westangel.commonservice.authorization.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.authorization.MetaResource;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.authorization.service.MetaResourceService;
import com.westangel.commonservice.authorization.service.RoleService;

@Controller
public class ResourceController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private MetaResourceService metaResourceService;
	@Autowired
	private RoleService roleService;

	/**
	 * <p>Title:getMetaInfoResourceList</p>
	 * <p>Description:资源列表查询</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 下午6:51:27
	 * @param locale
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/metainfo/resource/list", method = RequestMethod.GET)
	public TMsgResponse<List<MetaResource>> getMetaInfoResourceList(Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<MetaResource>> tMsgResponse = new TMsgResponse<List<MetaResource>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<MetaResource> metaRoles = this.metaResourceService.getMetaInfoResourceList();
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
	
	/**
	 * <p>Title:getMetaInfoResourceSubList</p>
	 * <p>Description:子资源列表查询</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 下午6:54:11
	 * @param locale
	 * @param userId
	 * @param resourceId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/metainfo/resource/sub/list", method = RequestMethod.GET)
	public TMsgResponse<List<MetaResource>> getMetaInfoResourceSubList(Locale locale, Long userId, Integer resourceId) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<MetaResource>> tMsgResponse = new TMsgResponse<List<MetaResource>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<MetaResource> metaRoles = this.metaResourceService.getMetaInfoResourceSubList(userId, resourceId);
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
	@RequestMapping(value = "/resource/menu/list", method = RequestMethod.GET)
	public TMsgResponse<List<MetaResource>> getResourceMenuList(Locale locale, Long userId) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<MetaResource>> tMsgResponse = new TMsgResponse<List<MetaResource>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<MetaResource> metaRoles = this.metaResourceService.getResourceMenuList(userId);
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
	@RequestMapping(value = "/metainfo/resource/role/list", method = RequestMethod.GET)
	public TMsgResponse<List<MetaResource>> getMetaInfoResourceRoleList(Locale locale, Long userId, Integer userRole) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<MetaResource>> tMsgResponse = new TMsgResponse<List<MetaResource>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<MetaResource> metaRoles = this.roleService.getRoleResourceList(userId, userRole);
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
	@RequestMapping(value = "/role/resource/sub/list", method = RequestMethod.GET)
	public TMsgResponse<List<MetaResource>> getRoleResourceSubList(Locale locale, Long userId, Integer resourceId) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<MetaResource>> tMsgResponse = new TMsgResponse<List<MetaResource>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<MetaResource> metaRoles = this.metaResourceService.getRoleResourceSubList(userId, resourceId);
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
}
