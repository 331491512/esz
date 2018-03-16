package com.esuizhen.cloudservice.sync.controller;

import java.util.List;  
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.sync.bean.MedicalRecordPost;
import com.esuizhen.cloudservice.sync.bean.MedicalRecordPostReq;
import com.esuizhen.cloudservice.sync.service.CloudMedcalPostSerivceService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.util.LogUtil;
/**
 * @author fanpanwei
 */
@Controller
public class MedicalRecordPostController {
	@Autowired
	MessageSource messageSource;
	@Autowired
	CloudMedcalPostSerivceService cloudMedcalPostSerivceService;
	
	/**
	 * 
	* @author fanpanwei
	* @date 2016年10月20日
	* @param 
	* @description 获取病案邮寄的列表
	* @return
	 */
	@ResponseBody
	@RequestMapping(value="/fromcloud/service/apply", method=RequestMethod.POST)
	public TMsgResponse<List<MedicalRecordPost>> getMedicalRecordPostInfo(Locale locale,@RequestBody MedicalRecordPostReq medicalRecordPostReq) {
		LogUtil.log.info("get MedicalRecordPost ToB, getMedicalRecordPostInfo()==========>>>>>>>>>>hospitalId=" + medicalRecordPostReq.getHospitalId());
		if (medicalRecordPostReq.getNum() == null || medicalRecordPostReq.getNum() < 1||medicalRecordPostReq.getNum()>100) {
			medicalRecordPostReq.setNum(100);
		}
		TMsgResponse<List<MedicalRecordPost>> tMsgResponse = new TMsgResponse<List<MedicalRecordPost>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<MedicalRecordPost> mrpList = this.cloudMedcalPostSerivceService.getMedicalPostList(medicalRecordPostReq);
			if(mrpList!=null&&mrpList.size()>0)tMsgResponse.setResult(mrpList);
		} catch(HospitalWithoutRightExcption hx){
			String returnMsg=medicalRecordPostReq==null?"calling method getMedicalRecordPostInfo;paramater:medicalRecordPostReq is null":"云端未开启三通的医院Id:"+medicalRecordPostReq.getHospitalId();
			LogUtil.logError.error(returnMsg);
			tMsgResponse.setRespCode(ErrorMessage.E1406.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1406.info, null, locale));
			tMsgResponse.setErrorDesc(returnMsg);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("Synchronous reviewResultto the ToB side data return, syncReviewOrderFromCloud()==========<<<<<<<<<<");
		return tMsgResponse;
	}
}
