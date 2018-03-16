package com.esuizhen.cloudservice.research.controller.result;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.research.bean.TProjectSubcenterDetailInfo;
import com.esuizhen.cloudservice.research.model.result.TProjectSubcenter;
import com.esuizhen.cloudservice.research.service.result.TProjectSubcenterService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.ObjectAlreadyExistExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.util.LogUtil;

@Controller
public class TProjectSubcenterController {

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private TProjectSubcenterService projectSubcenterService;

	@ResponseBody
	@RequestMapping(value = "/subcenter/list", method = RequestMethod.GET)
	public TMsgResponse<List<TProjectSubcenter>> listProjectSubcenter(Locale locale, String projectId) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TProjectSubcenter>> tMsgResponse = new TMsgResponse<List<TProjectSubcenter>>();
		tMsgResponse.respCode = ErrorMessage.SUCCESS.code;
		tMsgResponse.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			tMsgResponse.result = this.projectSubcenterService.listProjectSubcenter(projectId);
			if (tMsgResponse.result == null || tMsgResponse.getResult().isEmpty()) {
				tMsgResponse.respCode = ErrorMessage.E1404.code;
				tMsgResponse.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			tMsgResponse.respCode = ErrorMessage.E1500.code;
			tMsgResponse.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return tMsgResponse;
	}

	@ResponseBody
	@RequestMapping(value = "/subcenter/create", method = RequestMethod.POST)
	public TMsgResponse<Void> createProjectSubcenter(Locale locale, @RequestBody TProjectSubcenterDetailInfo projectSubcenterDetailInfo) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Void> msg = new TMsgResponse<Void>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 创建
			this.projectSubcenterService.createProjectSubcenter(projectSubcenterDetailInfo);
		} catch(RejectRequestExcption ex){
			msg.respCode = ErrorMessage.E1403.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1403.info, null, locale);
		} catch(ObjectAlreadyExistExcption ex){
			msg.respCode = ErrorMessage.E1409.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1409.info, null, locale);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}
