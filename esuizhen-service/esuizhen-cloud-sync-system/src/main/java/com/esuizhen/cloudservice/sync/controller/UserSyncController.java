package com.esuizhen.cloudservice.sync.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.sync.service.DoctorService;
import com.esuizhen.cloudservice.sync.service.PatientService;
import com.esuizhen.cloudservice.sync.service.UserService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.user.TConfirmUserReq;
import com.westangel.common.bean.user.TConfirmUserResp;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.ParamMismatchExcption;
import com.westangel.common.util.LogUtil;

@Controller
public class UserSyncController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private UserService userService;
	
	/**
	 * 
	* @Title: confirm 
	* @Description: 用户确认是否本人 
	* @param @param locale
	* @param @param confirmUserInfo
	* @param @return    设定文件 
	* @return TMsgResponse<Void>    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<TConfirmUserResp> confirm(Locale locale, @RequestBody TConfirmUserReq confirmUserReq) {
		LogUtil.log.info("Users confirm the data imported from the ToB client, confirm()==========>>>>>>>>>>");
		TMsgResponse<TConfirmUserResp> tMsgResponse = new TMsgResponse<TConfirmUserResp>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		if (confirmUserReq.getUserRole() == null) {
			return tMsgResponse;
		}
		try {
			TConfirmUserResp resp = null;
			//如果是患者
			if (Constant.User.ROLE_PATIENT == confirmUserReq.getUserRole() ||
					Constant.User.ROLE_PATIENT.equals(confirmUserReq.getUserRole())) {
				resp = patientService.confirmPateint(confirmUserReq);
			}
			//如果是医生
			else if (Constant.User.ROLE_DOCTOR == confirmUserReq.getUserRole() ||
					Constant.User.ROLE_DOCTOR.equals(confirmUserReq.getUserRole())){
				resp = doctorService.confirmDoctor(confirmUserReq);
			}
			tMsgResponse.setResult(resp);
		} catch(EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(EmptyObjectExcption ex){
			ex.printStackTrace();
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(ParamMismatchExcption ex){
			LogUtil.logError.error("smsInnerService.checkCaptcha()" + ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1418.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1418.info, new Object[]{ex.getMessage()}, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			ex.printStackTrace();
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("Users confirm the data completed ToB end import, confirm()==========<<<<<<<<<<");
		return tMsgResponse;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :affirm
	 * @Description:确认是否匹配
	 * @return TMsgResponse<TConfirmUserResp>
	 * @date 2017年4月5日 下午5:39:44
	 */
	@RequestMapping(value = "/affirm", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<TConfirmUserResp> affirm(Locale locale, @RequestBody TConfirmUserReq confirmUserReq){
		LogUtil.log.info("Users confirm the status of the message, affirm()==========>>>>>>>>>>");
		TMsgResponse<TConfirmUserResp> tMsgResponse = new TMsgResponse<TConfirmUserResp>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			TConfirmUserResp resp = userService.affirm(confirmUserReq);
			tMsgResponse.setResult(resp);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("Users confirm the status of the message to be confirmed, affirm()==========<<<<<<<<<<");
		return tMsgResponse;
	}
	
	@RequestMapping(value = "/scanning", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<Void> scanning(Locale locale, Boolean flag) {
		LogUtil.log.info("scanning, scanning()==========>>>>>>>>>>");
		if (flag == null) {
			flag = true;
		}
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			userService.scanning(flag);
		} catch (Exception ex) {
			ex.printStackTrace();
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("Scanning, scanning()==========<<<<<<<<<<");
		return tMsgResponse;
	}
}
