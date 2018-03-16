package com.esuizhen.cloudservice.user.controller.followuppatient;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.user.bean.followuppatient.PatientMedicalPhotoQueryReq;
import com.esuizhen.cloudservice.user.model.followuppatient.TMedicalPicInfo;
import com.esuizhen.cloudservice.user.service.CommonService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class PatientMedicalPhotoController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private CommonService<TMedicalPicInfo> commonService;
	
	/**
	 * 患者病历图片信息
	 * @param patientSearchInfo
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/patient/medical/photo/list/query",method=RequestMethod.POST)
	public TMsgResponse<Page<TMedicalPicInfo>> queryPatientMedicalPhotoList(@RequestBody PatientMedicalPhotoQueryReq req,Locale locale) {
		TMsgResponse<Page<TMedicalPicInfo>> tMsgResponse = new TMsgResponse<Page<TMedicalPicInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Page<TMedicalPicInfo> page = commonService.queryList(req,req.getPage(),req.getNum());
			tMsgResponse.setResult(page);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
}
