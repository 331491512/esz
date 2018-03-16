/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.controller<br/>  
 * <b>文件名：</b>PatientService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月8日-下午2:11:17<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
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

import com.esuizhen.cloudservice.sync.bean.TDoctorSyncProfile;
import com.esuizhen.cloudservice.sync.service.DoctorService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: DoctorController 
* @Description: 医生相关业务控制类
* @author YYCHEN
* @date 2015年12月8日 下午2:11:17  
*/
@Controller
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * 将Tob新增的医生同步到云端
	 * 
	   "opFlag":0,  //0:新增； 1：修改
		"uuid":”350000es34n6i3n790djjde33s”，
		"userNumber":”001256”,
		"trueName”:”老王”,
		"sex":1,
		"mobile":"13566666666",
		"email":"laowang@test.com"，
		"deptUuid":"asfasdfasdf415454",
		"childDeptUuid":1,
		"professionalRankId":13,
		"positionTitleId":101, 
		"hospitalId":15,
		"idType":1,
		"identification": "10045614782215455555",
		"birthDate":"2015-09-08 09:06:06"
	 * 
	 * @param locale
	 * @param doctorSyncProfile
	 * @return
	 */
	@RequestMapping(value = "/tocloud/user/doctor", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> syncDoctor(Locale locale, @RequestBody TDoctorSyncProfile doctorSyncProfile) {
		LogUtil.log.info("Sync doctor data, syncDoctor()==========>>>>>>>>>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.doctorService.synchDoctor(doctorSyncProfile);
		} catch(HospitalWithoutRightExcption hx){
			String returnMsg=doctorSyncProfile==null?"calling method syncDoctor;paramater:doctorSyncProfile is null":"云端未开启三通的医院Id:"+doctorSyncProfile.getHospitalId();
			LogUtil.logError.error(returnMsg);
			tMsgResponse.setRespCode(ErrorMessage.E1406.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1406.info, null, locale));
			tMsgResponse.setErrorDesc(returnMsg);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("Synchronous doctor data complete, syncDoctor()==========<<<<<<<<<<");
		return tMsgResponse;
	}
	
}
