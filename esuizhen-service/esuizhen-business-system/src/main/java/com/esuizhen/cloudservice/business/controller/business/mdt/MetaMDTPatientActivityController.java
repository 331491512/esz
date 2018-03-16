package com.esuizhen.cloudservice.business.controller.business.mdt;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.business.bean.TMsgResponse;
import com.esuizhen.cloudservice.business.bean.TPatientActivitySignupReq;
import com.esuizhen.cloudservice.business.service.business.mdt.PatientActivityService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.util.LogUtil;

/** 
 * @ClassName: MetaMDTPatientActivityController.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月28日
 */
@Controller
public class MetaMDTPatientActivityController {
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private PatientActivityService patientActivityService;
	
	/**
	 * 
	* @author fanpanwei
	* @date 2016年9月28日
	* @param 
	* @description mdt患者活动报名接口
	* @return
	 */
	@ResponseBody
	@RequestMapping(value = "/patient/activity/mark", method = RequestMethod.POST)
	public TMsgResponse<Object> markPatientActivity(@RequestBody(required=false) TPatientActivitySignupReq req,Locale locale){


		// 设置返回成功代码及提示消息
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info,null, locale));
		try {
			Integer id = patientActivityService.searchPatientActivity(req);
			if(req.getExistFlag()!=null&&req.getExistFlag()==1){//判断是否参加活动
				if(id!=null){//已经参加活动情况
					msg.setRespCode(1);
					msg.setRespMsg("User Joined!");
				}else{//未参加活动情况
					msg.setRespCode(0);
					msg.setRespMsg("Not Join This Activity!");
				}
			}else{//报名活动
				if(id!=null){//判断记录是否存在
					msg.setRespCode(ErrorMessage.E1409.code);
					msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1409.info,null, locale));
				}else{
					patientActivityService.markPatientActivity(req);
				}
			}
		} catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1400.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info,null, locale));
			LogUtil.logError.error(e.getMessage());
			e.printStackTrace();
		}
		return msg;
	}
}
