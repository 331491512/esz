package com.esuizhen.cloudservice.business.controller.business.mdt;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.business.bean.MdtDoctorOptionInfo;
import com.esuizhen.cloudservice.business.bean.TMsgResponse;
import com.esuizhen.cloudservice.business.service.business.mdt.MDTDoctorOptionService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.util.LogUtil;

/** 
 * @ClassName: MDTDoctorOptionController.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月28日
 */
@Controller
public class MDTDoctorOptionController {
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private MDTDoctorOptionService doctorOptionService;
	
	/**
	 * 
	* @author fanpanwei
	* @date 2016年9月28日
	* @param 
	* @description mdt医生建议接口
	* @return
	 */
	@ResponseBody
	@RequestMapping(value = "/service/mdt/option/submit", method = RequestMethod.POST)
	public TMsgResponse<Object> submitMdtDoctorOption(@RequestBody(required=false) MdtDoctorOptionInfo mdtOption,Locale locale){

		// 设置返回成功代码及提示消息
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info,null, locale));
		try {
			doctorOptionService.submitMdtDoctorOption(mdtOption);

		} catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info,null, locale));
			LogUtil.logError.error(e.getMessage());
			e.printStackTrace();
		}
		return msg;
	}
}
