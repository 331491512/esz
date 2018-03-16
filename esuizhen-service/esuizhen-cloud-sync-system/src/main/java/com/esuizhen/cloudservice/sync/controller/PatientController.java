package com.esuizhen.cloudservice.sync.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.sync.bean.TPatientAndPatientNoRelationSync;
import com.esuizhen.cloudservice.sync.bean.TPatientContactInfo;
import com.esuizhen.cloudservice.sync.bean.TPatientSyncProfile;
import com.esuizhen.cloudservice.sync.bean.TPatientWeixinOpenIdInfo;
import com.esuizhen.cloudservice.sync.service.CheckBeforeSyncService;
import com.esuizhen.cloudservice.sync.service.PatientService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.util.LogUtil;

@Controller
public class PatientController {
	@Autowired
	MessageSource messageSource;
	@Autowired
	PatientService patientService;
	@Autowired
	CheckBeforeSyncService checkBeforeSyncService;
	
	/**
	 * 
	* @Title: syncPatientWeixinFromCloud 
	* @Description: C端到B端患者微信同步 
	* @param @param hospitalId
	* @param @param locale
	* @param @return    设定文件 
	* @return TMsgResponse<List<TPatientWeixinOpenIdInfo>>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/fromcloud/user/patient/weixin", method=RequestMethod.GET)
	public TMsgResponse<List<TPatientWeixinOpenIdInfo>> syncPatientWeixinFromCloud(Locale locale, Integer hospitalId, Integer page, Integer num) {
		LogUtil.log.info("Synchronous opening of WeChat's patients to ToB, syncPatientWeixinFromCloud()==========>>>>>>>>>>hospitalId=" + hospitalId);
		if (page == null || page < 0) {
			page = 0;
		}
		if (num == null || num < 1 || num > 200) {
			num = 100;
		}
		TMsgResponse<List<TPatientWeixinOpenIdInfo>> tMsgResponse = new TMsgResponse<List<TPatientWeixinOpenIdInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Page<TPatientWeixinOpenIdInfo> pageData = this.patientService.getIncrWeixinPatients(hospitalId, page, num);
			if (pageData.getCurrPage() == pageData.getTotalPage() ||
					pageData.getCurrPage() == pageData.getTotalPage() - 1) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.code);
				tMsgResponse.setRespMsg("Complete synchronization!");
			}
			tMsgResponse.setResult(pageData.getDataList());
		} catch(HospitalWithoutRightExcption hx){
			String returnMsg="云端未开启三通的医院Id:"+hospitalId;
			LogUtil.logError.error(returnMsg);
			tMsgResponse.setRespCode(ErrorMessage.E1406.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1406.info, null, locale));
			tMsgResponse.setErrorDesc(returnMsg);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			//msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("Synchronous opening of WeChat's patients to the ToB side data return, syncPatientWeixinFromCloud()==========<<<<<<<<<<");
		return tMsgResponse;
	}
	
	/**
	 	{ 
			"opFlag":0,  //0:新增； 1：修改
			"uuid":"350000es34n6i3n790djjde33s", 
			"trueName":"患者老王",
			"sex":1, 
			"birthDate":"2015-09-08 09:06:06"，
			"country":"中国",
			"mobile":"13566666666"，
			"city":"北京"，
			"nativePlace":"北京海淀区",
			"nation":"汉"，
			"idType":1,
			"identification":"42584521578755"，
			"profession":"程序猿"，
			"marriageStatus":1，
			"liveStatus":1，
			"deathDate":"2015-09-08 09:06:06"，
			"causeOfDeath":"在院肿瘤死亡"，
			"latestClinicDate":"2015-09-08 09:06:06"，
			"latestOutHospitalDate":"2015-09-08 09:06:06"，
			"latestFollowupTime":"2015-09-08 09:06:06"，
			"attendingDoctorUuid":"aasdfasdfasdfsafssdfgsaew"，
			" hospitalUuid ":"asdfa15415asdfew5415 ",
			" hospitalId ":15,
			" patientContactList":[{
			      "patientRelation ":0,
			      "familyName ":"张三",
			      "familyPhone":"12345678910",
			      "address ":"北京海淀"
			       },{
			      "patientRelation ":1,
			      "familyName ":"李四",
			      "familyPhone":"12345678010",
			      " address ":"北京海淀"
			}]
		}
	 * 
	 * @param patientSyncProfile
	 * @param locale
	 * 同步患者信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/tocloud/user/patient", method=RequestMethod.POST)	
	public TMsgResponse<Void> syncPatient(@RequestBody TPatientSyncProfile patientSyncProfile, Locale locale) {
		LogUtil.log.info("Start synchronizing patient data, syncPatient()==========>>>>>>>>>>>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.patientService.syncPatientInfo(patientSyncProfile);
		} catch(HospitalWithoutRightExcption hx){
			String returnMsg=patientSyncProfile==null?"calling method syncPatient;patientSyncProfile is null":"云端未开启三通的医院Id:"+patientSyncProfile.getHospitalId();
			LogUtil.logError.error(returnMsg);
			tMsgResponse.setRespCode(ErrorMessage.E1406.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1406.info, null, locale));
			tMsgResponse.setErrorDesc(returnMsg);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			//tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("Synchronous patient data is complete, syncPatient()==========<<<<<<<<<<");
		return tMsgResponse;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :transferDataToCloud
	 * @Description:2.1.16	将患者相关的数据迁移到生产库
	 * @return TMsgResponse<Void>
	 * @date 2016年11月12日 下午2:58:00
	 */
	@ResponseBody
	@RequestMapping(value="/transfer/patient/data/tocloud", method=RequestMethod.GET)	
	public TMsgResponse<Void> transferDataToCloud(Locale locale) {
		LogUtil.log.info("Start transfer patient data, transferDataToCloud()==========>>>>>>>>>>>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.patientService.transferDataToCloud();
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			//tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("transfer patient data is complete, transferDataToCloud()==========<<<<<<<<<<");
		return tMsgResponse;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :syncPatientOfPatientNoRelation
	 * @Description:同步患者病案号信息
	 * @return TMsgResponse<Void>
	 * @date 2016年12月20日 下午2:56:18
	 */
	@ResponseBody
	@RequestMapping(value="/tocloud/user/relation/patient/ofpatientno", method=RequestMethod.POST)	
	public TMsgResponse<String> syncPatientOfPatientNoRelation(@RequestBody TPatientAndPatientNoRelationSync patientOfPatientNo,Locale locale) {
		TMsgResponse<String> msg = new TMsgResponse<String>();
		try {
			patientService.syncPatientOfPatientNoRelation(patientOfPatientNo);
		} catch(HospitalWithoutRightExcption hx){
			String returnMsg=patientOfPatientNo==null?"calling method syncPatientOfPatientNoRelation;patientOfPatientNo is null":"云端未开启三通的医院Id:"+patientOfPatientNo.getHospitalId();
			LogUtil.logError.error(returnMsg);
			msg.setRespCode(ErrorMessage.E1406.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1406.info, null, locale));
			msg.setErrorDesc(returnMsg);
		} catch(EmptyObjectExcption e){
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			msg.setRespCode(ErrorMessage.E1404.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		}catch (Exception e) {
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		}
		return msg;
	}
	/**
	 * 
	 * @author fanpanwei
	 * @title :syncPatientFamilyInfo
	 * @Description:同步患者联系人信息
	 * @return TMsgResponse<Void>
	 * @date 2016年12月20日 下午2:56:18
	 */
	@ResponseBody
	@RequestMapping(value="/tocloud/user/patient/family", method=RequestMethod.POST)	
	public TMsgResponse<String> syncPatientFamilyInfo(@RequestBody TPatientContactInfo tPatientContactInfo,Locale locale) {
		TMsgResponse<String> msg = new TMsgResponse<String>();
		try {
			patientService.syncPatientContactInfo(tPatientContactInfo);
		} catch(HospitalWithoutRightExcption hx){
			String returnMsg=tPatientContactInfo==null?"calling method syncPatientFamilyInfo;tPatientContactInfo is null":"云端未开启三通的医院Id:"+tPatientContactInfo.getHospitalId();
			LogUtil.logError.error(returnMsg);
			msg.setRespCode(ErrorMessage.E1406.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1406.info, null, locale));
			msg.setErrorDesc(returnMsg);
		} catch(EmptyObjectExcption e){
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			msg.setRespCode(ErrorMessage.E1404.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		}catch (Exception e) {
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 获取微信用户
	 * @param uuid 患者uuid
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/wx/user/get",method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<Map<String,Object>> getWxUser(String uuid,Locale locale){
		TMsgResponse<Map<String,Object>> msg=new TMsgResponse<Map<String,Object>>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info,null,locale));
		try{
			msg.result=patientService.getWxUser(uuid);
		}catch(EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1410.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1410.info, null, locale));
			msg.setErrorDesc(ex.getMessage());
		}catch (Exception e){
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		}
		return msg;
	}
}
