package com.esuizhen.cloudservice.research.controller.meta;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.research.bean.PatientParamentInfo;
import com.esuizhen.cloudservice.research.bean.TMetaInfoCRFSubjectElement;
import com.esuizhen.cloudservice.research.model.meta.MetaRole;
import com.esuizhen.cloudservice.research.service.meta.CrfMetaInfoService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class CrfMetaInfoController {

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private CrfMetaInfoService crfMetaInfoService;

	/**
	 * 获取CRF观察模板标题子元素元数据列表
	 * 
	 * @param parentId
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/metainfo/crf/subject/element/child/list", method = RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoCRFSubjectElement>> listMetaInfoCrfSubjectElementChild(String parentId,
			Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoCRFSubjectElement>> msg = new TMsgResponse<List<TMetaInfoCRFSubjectElement>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			msg.result = crfMetaInfoService.listMetaInfoCrfSubjectElementChild(parentId);

		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 获取CRF观察模板标题子元素元数据列表
	 * 
	 * @param parentId
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/patients/parament/get", method = RequestMethod.GET)
	public TMsgResponse<List<PatientParamentInfo>> listMetaInfoCrfSubjectElementChild(Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<PatientParamentInfo>> msg = new TMsgResponse<List<PatientParamentInfo>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			msg.result = crfMetaInfoService.getPatientsParament();
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "/meta/subcenter/role/list/query", method = RequestMethod.GET)
	public TMsgResponse<List<MetaRole>> queryMetaSubcenterRoleList(Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<MetaRole>> tMsgResponse = new TMsgResponse<List<MetaRole>>();
		tMsgResponse.respCode = ErrorMessage.SUCCESS.code;
		tMsgResponse.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			tMsgResponse.setResult(this.crfMetaInfoService.getMetaSubcenterRoleList());
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			tMsgResponse.respCode = ErrorMessage.E1500.code;
			tMsgResponse.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return tMsgResponse;
	}
}
