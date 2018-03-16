package com.esuizhen.cloudservice.ehr.controller.medical;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.model.medical.ChangeVersion;
import com.esuizhen.cloudservice.ehr.service.medical.MedicalCatalogueService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class MedicalCatalogueController {
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private MedicalCatalogueService medicalCatalogueService;

	/**
	 * 增加病案编目修改版本表信息
	 * 
	 * @param resp
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/medical/catalogue/isnert", method = RequestMethod.POST)
	public TMsgResponse<Integer> insertChangeVersion(@RequestBody ChangeVersion resp, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Integer> msg = new TMsgResponse<Integer>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			msg.result = medicalCatalogueService.insertChangeVersion(resp);

			// 如果为空
			if (msg.result == 0) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 删除病案编目修改版本表信息
	 * 
	 * @param resp
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/medical/catalogue/delete", method = RequestMethod.POST)
	public TMsgResponse<Integer> deleteChangeVersion(@RequestBody ChangeVersion resp, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Integer> msg = new TMsgResponse<Integer>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			msg.result = medicalCatalogueService.deleteChangeVersion(resp);

			// 如果为空
			if (msg.result == 0) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 查询病案编目修改版本表信息
	 * 
	 * @param resp
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/medical/catalogue/list", method = RequestMethod.GET)
	public TMsgResponse<List<ChangeVersion>> queryChangeVersionList(Long patientId,Integer hospitalId,String visitId, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<ChangeVersion>> msg = new TMsgResponse<List<ChangeVersion>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			msg.result = medicalCatalogueService.queryChangeVersionList(patientId,hospitalId,visitId);

			// 如果为空
			if (msg.result == null) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 查询病案编目修改版本表信息
	 * 
	 * @param resp
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/medical/catalogue/info", method = RequestMethod.POST)
	public TMsgResponse<ChangeVersion> queryChangeVersionInfo(@RequestBody ChangeVersion resp, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<ChangeVersion> msg = new TMsgResponse<ChangeVersion>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			msg.result = medicalCatalogueService.queryChangeVersionInfo(resp);

			// 如果为空
			if (msg.result == null) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}
