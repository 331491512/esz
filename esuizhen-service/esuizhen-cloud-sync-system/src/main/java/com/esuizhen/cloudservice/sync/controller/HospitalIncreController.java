/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.sync.controller<br/>  
 * <b>文件名：</b>HospitalIncreController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年02月10日-下午2:11:17<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.esuizhen.cloudservice.sync.service.HospitalIncreSyncStatisService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.sync.THospitalIncreLog;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

/**
 * <p>Title:ClinicMedicalController</p>
 * <p>Description:患者门诊信息业务控制类</p>
 * @author YYCHEN
 * @date 2016年9月7日 上午11:43:18
 */
@Controller
public class HospitalIncreController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private HospitalIncreSyncStatisService hospitalIncreService;
	/**
	 * 
	 * @author lichenghao
	 * @title :syncHospitalIncreLog
	 * @Description:同步医院日增量
	 * @return TMsgResponse<MedicalRecord>
	 * @date 2017年2月10日 下午4:07:16
	 */
	@RequestMapping(value = "/tocloud/hospital/incre/log", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<MedicalRecord> syncHospitalIncreLog(Locale locale, @RequestBody THospitalIncreLog req) {
		LogUtil.log.info("Synchronous hospital incre log , syncHospitalIncreLog(),START==========>>>>>>>>>>");
		TMsgResponse<MedicalRecord> tMsgResponse = new TMsgResponse<MedicalRecord>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			hospitalIncreService.syncHospitalIncreLog(req);
		}catch(EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1409.getCode());
			tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setErrorDesc(ex.getMessage());
		}catch(EmptyObjectExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setErrorDesc(ex.getMessage());
		}catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("Synchronous hospital incre log, syncHospitalIncreLog(), END==========<<<<<<<<<<");
		return tMsgResponse;
	}
}
