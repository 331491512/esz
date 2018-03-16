package com.esuizhen.cloudservice.ehr.controller.outhospital;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.service.outhospital.OuthospitalService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class OuthospitalController {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private OuthospitalService outhospitalService;
	
	/**
	 * 获取出院信息
	 * @author lichenghao
	 * @title :getOutHospitalDateList
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2016年5月3日 下午5:29:09
	 */
	@ResponseBody
	@RequestMapping(value = "/out/hospital/date/list", method = RequestMethod.GET)
	public TMsgResponse<Object>  getOutHospitalDateList(Long patientId,Integer hospitalId, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info,null, locale));
		try {
			msg.result = outhospitalService.getOutHospitalDateList(patientId, hospitalId);
		} catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1400.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info,null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
}
