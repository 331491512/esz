/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.controller<br/>  
 * <b>文件名：</b>PatientService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月8日-下午2:11:17<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.esuizhen.cloudservice.user.bean.*;
import com.esuizhen.cloudservice.user.model.TPatientNoInfo;
import com.esuizhen.cloudservice.user.service.PatientService;
import com.esuizhen.cloudservice.user.service.RemarkService;
import com.esuizhen.cloudservice.user.service.UserService;
import com.westangel.common.bean.*;
import com.westangel.common.excption.*;
import com.westangel.common.util.LogUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @ClassName: PatientController
 * @Description: 患者接口控制
 * @author YYCHEN
 * @date 2015年12月8日 下午2:11:17
 */
@Controller
public class PatientController {

	@Autowired
	private UserService userService;
	@Resource(name = "patientService")
	private PatientService patientService;
	@Autowired
	private RemarkService remarkService;
	@Autowired
	private MessageSource messageSource;

	/**
	 * @Title: getDetailPatientProfile @Description:
	 * 根据患者编号查询患者详细信息 @param @return TMsgResponse<Patient> @throws
	 */
	@RequestMapping("/patient/profile/detail")
	@ResponseBody
	public TMsgResponse<PatientProfileDetailResp> getDetailPatientProfile(Locale locale, PatientProfileDetailReq req) {
		LogUtil.log.info("根据患者编号查询患者详细信息(getDetailPatientProfile)==========>>");
		TMsgResponse<PatientProfileDetailResp> tMsgResponse = new TMsgResponse<PatientProfileDetailResp>();
		if (req!=null&&req.getPatientId() == null) {
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			return tMsgResponse;
		}
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			PatientProfileDetailResp patientProfileDetailResp = patientService.searchPatientById(req);
			if (patientProfileDetailResp != null) {
				patientProfileDetailResp.setStatisProfile(this.userService.getUserStatisProfile(patientProfileDetailResp.getUserProfile(), null));
			}
			tMsgResponse.setResult(patientProfileDetailResp);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * 
	 * @Title: getPatientsOfDoctorList @Description:
	 * 根据医生编号查询患者信息列表 @param @return TMsgResponse<Page> @throws
	 */
	@RequestMapping("/patient/ofdoctor/list")
	@ResponseBody
	public TMsgResponse<Page<PatientSimpleInfo>> getPatientsOfDoctorList(Locale locale, Long doctorId, String patientName, Integer reqFlag, Integer page, Integer num) {
		LogUtil.log.info("根据医生编号查询患者信息列表(getPatientsOfDoctorList)==========>>");
		TMsgResponse<Page<PatientSimpleInfo>> tMsgResponse = new TMsgResponse<Page<PatientSimpleInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Page<PatientSimpleInfo> list = patientService.searchPatientSimpleInfoList(doctorId, patientName, reqFlag, page, num);
			if (list == null || list.getDataList() == null || list.getDataList().isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				tMsgResponse.setResult(list);
			}
		} catch (EmptyParamExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * 
	 * @Title: createPatientByMobile @Description: 根据电话号码创建患者 @param @return
	 * TMsgResponse<Void> @throws
	 */
	@RequestMapping("/patient/create/bymobile")
	@ResponseBody
	public TMsgResponse<Object> createPatientByMobile(@RequestBody PatientCreateByMobileReq patientCreateByMobileReq,
			Locale locale) {
		LogUtil.log.info("根据电话号码创建患者(createPatientByMobile)==========>>");
		TMsgResponse<Object> tMsgResponse = new TMsgResponse<Object>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.result = patientService.createPatientByMobile(patientCreateByMobileReq);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage("add.error", null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * 
	 * @Title: createPatientByMedicalRecord @Description:
	 * 通过病历创建患者 @param @return TMsgResponse<Void> @throws
	 */
	@RequestMapping("/patient/create/bymedical")
	@ResponseBody
	public TMsgResponse<Void> createPatientByMedicalRecord(
			@RequestBody MedicalRecordPatientCreateReq medicalRecordPatientCreateReq, Locale locale) {
		LogUtil.log.info("通过病历创建患者(createPatientByMedicalRecord)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			patientService.createPatientByMedicalRecord(medicalRecordPatientCreateReq);
		} catch(EmptyParamExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * 
	 * @Title: searchPatientBykeyword @Description:
	 * 模糊查询某个医生的病人。按关键词查询。最多返回100个记录。按照姓名排序。 患者入组时使用。
	 * 关键词和患者姓名、手机号、病种进行模糊匹配。 @param @return TMsgResponse<Void> @throws
	 */
	@RequestMapping("/patient/ofdoctor/search/bykeyword")
	@ResponseBody
	public TMsgResponse<List<PatientSimpleInfo>> searchPatientBykeyword(
			@RequestBody PatientKeywordSearchReq patientKeywordSearchReq, Locale locale) {
		LogUtil.log.info("关键词和患者姓名、手机号、病种进行模糊匹配(searchPatientBykeyword)==========>>");
		TMsgResponse<List<PatientSimpleInfo>> tMsgResponse = new TMsgResponse<List<PatientSimpleInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<PatientSimpleInfo> list = this.patientService.searchPatientBykeyword(patientKeywordSearchReq);
			tMsgResponse.setResult(list);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

	
	
	
	/**
	 * 获取患者信息
	 * @param locale
	 * @param id
	 * @param tag
	 * @param doctorId
	 * @return
	 */
	@RequestMapping("/patient/simple/info")
	@ResponseBody
	public TMsgResponse<PatientSimpleInfo> getPatientSimpleInfo(Locale locale, Long id, String tag, Long doctorId) {
		LogUtil.log.info("获取患者信息(getPatientSimpleInfo)==========>>");
		TMsgResponse<PatientSimpleInfo> tMsgResponse = new TMsgResponse<PatientSimpleInfo>();
		if (id == null || StringUtils.isBlank(tag) || (!"user".equalsIgnoreCase(tag) && !"patient".equalsIgnoreCase(tag))) {
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			return tMsgResponse;
		}
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			PatientSimpleInfo patientSimpleInfo = this.patientService.getPatientSimpleInfoById(id, tag, doctorId);
			tMsgResponse.setResult(patientSimpleInfo);
		} catch (EmptyParamExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * @Title: releasePatientOfDoctor 
	 * @Description: 创建医患关系
	 * @param 
	 * @return
	 * @throws
	 */
	@RequestMapping("/relation/patient/ofdoctor/create")
	@ResponseBody
	public TMsgResponse<Void> createPatientOfDoctorRelation(Locale locale, Long doctorId, Long patientId, Integer sourceFlag) {
		LogUtil.log.info("创建医患关系(createPatientOfDoctorRelation())==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.patientService.createPatientOfDoctorRelation(doctorId, patientId, sourceFlag);
		} catch (EmptyParamExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (ParamFormatErrorExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (ObjectNotAvailableExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	@RequestMapping("/relation/patient/ofhospital/create")
	@ResponseBody
	public TMsgResponse<Void> createPatientOfHospitalRelation(Locale locale, Integer hospitalId, Long patientId, Integer sourceFlag) {
		LogUtil.log.info("创建医院、患者关系(createPatientOfHospitalRelation())==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.patientService.createPatientOfHospitalRelation(hospitalId, patientId, sourceFlag);
		} catch (EmptyParamExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (ParamFormatErrorExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (ObjectNotAvailableExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * @Title: releasePatientOfDoctor 
	 * @Description: 解除医患关系
	 * @param 
	 * @return
	 * @throws
	 */
	@RequestMapping("/relation/patient/ofdocotor/release")
	@ResponseBody
	public TMsgResponse<Void> releasePatientOfDoctor(Locale locale, Long doctorId, Long patientId, Integer source) {
		LogUtil.log.info("解除医患关系(releasePatientOfDoctor)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		if (doctorId == null || patientId == null || source == null) {
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			return tMsgResponse;
		}
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.patientService.releasePatientOfDoctor(doctorId, patientId, source);
		}
		catch(RejectRequestExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1424.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1424.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage("delete.error", null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 
	 * @param locale
	 * @param doctorId
	 * @param patientId
	 * @param source
	 * @return
	 */
	@RequestMapping("/del/medicalRecord")
	@ResponseBody
	public TMsgResponse<Void> delHasVisibleMedicalRecord(Locale locale, Integer visibleFlag, Long doctorId, Long patientId, Integer source) {
		LogUtil.log.info("删除病例(delHasVisibleMedicalRecord)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		if (doctorId == null || patientId == null || source == null) {
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			return tMsgResponse;
		}
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.patientService.delHasVisibleMedicalRecord(visibleFlag, source, doctorId, patientId);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	@RequestMapping(value = "/patient/certificate", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> certificatePatient(Locale locale, @RequestBody PatientSimpleInfo patientSimpleInfo) {
		LogUtil.log.info("实名认证患者, certificatePatient()==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.patientService.certificatePatient(patientSimpleInfo);
			this.patientService.certificateFollowupPlan(patientSimpleInfo.getPatientId());
		} catch(EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(EmptyObjectExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(RejectRequestExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1419.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1419.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("实名认证患者完成, certificatePatient()==========<<");
		return tMsgResponse;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getPatientRemarkList
	 * @Description:获取医生对患者的备注信息
	 * @return TMsgResponse<List<TPatientRemark>>
	 * @date 2016年5月19日 上午10:46:23
	 */
	@ResponseBody
	@RequestMapping(value="/patient/remark/list",method=RequestMethod.GET)
	public TMsgResponse<Page<TPatientRemark>> getPatientRemarkList(PatientRemarkListReq req,Locale locale){
		TMsgResponse<Page<TPatientRemark>> msg = new TMsgResponse<Page<TPatientRemark>>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			msg.result = remarkService.getPatientRemarkList(req);
		}catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1400.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
		}catch(Exception ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :addPatientRemark
	 * @Description:新增患者备注
	 * @return TMsgResponse<List<TPatientRemark>>
	 * @date 2016年5月20日 下午2:29:19
	 */
	@ResponseBody
	@RequestMapping(value="/patient/remark/add",method=RequestMethod.POST)
	public TMsgResponse<Object> addPatientRemark(@RequestBody PatientRemarkReq req,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("remarkId", remarkService.createPatientRemark(req));
			msg.result = result;
		}catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1400.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
		}catch(Exception ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :modifyPatientRemark
	 * @Description:修改患者备注
	 * @return TMsgResponse<List<TPatientRemark>>
	 * @date 2016年5月20日 下午2:29:19
	 */
	@ResponseBody
	@RequestMapping(value="/patient/remark/modify",method=RequestMethod.POST)
	public TMsgResponse<Object> modifyPatientRemark(@RequestBody PatientRemarkReq req,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			remarkService.modifyPatientRemark(req);
		}catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1400.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
		}catch(EmptyObjectExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1404.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
		}catch(Exception ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :modifyPatientRemark
	 * @Description:修改患者备注
	 * @return TMsgResponse<List<TPatientRemark>>
	 * @date 2016年5月20日 下午2:29:19
	 */
	@ResponseBody
	@RequestMapping(value="/patient/remark/delete",method=RequestMethod.POST)
	public TMsgResponse<Object> deletePatientRemark(@RequestBody PatientRemarkReq req,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			remarkService.deletePatientRemark(req);
		}catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1400.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
		}catch(EmptyObjectExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1404.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
		}catch(Exception ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}
	
	
	/**
	 * 患者医院认证
	 * @author Da Loong
	 * @date 2016/5/28 
	 * @param locale
	 * @param patientSimpleInfo
	 * @return
	 */
	@RequestMapping(value = "/patient/hospital/certificate", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Object> certificateHospitalPatient(Locale locale, @RequestBody PatientHospitalCertificateReq patientSimpleInfo) {
		LogUtil.log.info("患者医院认证, certificateHospitalPatient()==========>>");
		TMsgResponse<Object> tMsgResponse = new TMsgResponse<Object>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {

			tMsgResponse.result = this.patientService.certificateHospitalPatient(patientSimpleInfo);
		} catch(EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(EmptyObjectExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}  catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("患者医院认证完成, certificateHospitalPatient()==========<<");
		return tMsgResponse;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :confirmHospitalPatientCertificate
	 * @Description:患者医院认证确认接口
	 * @return TMsgResponse<Void>
	 * @date 2017年1月10日 上午11:35:38
	 */
	@RequestMapping(value = "/patient/hospital/certificate/confirm", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> confirmHospitalPatientCertificate(Locale locale, @RequestBody PatientHospitalCertificateConfirmReq req) {
		LogUtil.log.info("患者医院认证确认, confirmHospitalPatientCertificate()==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.patientService.confirmHospitalPatientCertificated(req);
		} catch(EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(EmptyObjectExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("患者医院认证确认完成, confirmHospitalPatientCertificate()==========<<");
		return tMsgResponse;
	}
	
	/**
	 * 患者身份证上传
	 * @author Nidan
	 * @title:UploadPatientIDCard
	 * @Description:
	 * @return TMsgResponse
	 * @date 2016年10月19日上午9:43:54
	 */
	@RequestMapping(value="/patient/idcard/upload",method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<String> UploadPatientIDCard(Locale locale,@RequestBody UserInfo user){
		TMsgResponse<String> response=new TMsgResponse<String>();
		response.setRespCode(ErrorMessage.SUCCESS.getCode());
		response.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			patientService.uploadPatientIDFileUrl(user);
		}catch(Exception ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			response.setRespCode(ErrorMessage.E1500.getCode());
			response.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			response.setErrorDesc(ex.getMessage());
		}
		return response;
	}
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getPatientNoList
	 * @Description:获取患者病案号
	 * @return TMsgResponse<TPatientNoInfo>
	 * @date 2017年1月6日 上午11:39:54
	 */
	@RequestMapping(value="/patient/patientno/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<TPatientNoInfo>> getPatientNoList(PatientNoListReq req,Locale locale){
		TMsgResponse<List<TPatientNoInfo>> response=new TMsgResponse<List<TPatientNoInfo>>();
		response.setRespCode(ErrorMessage.SUCCESS.getCode());
		response.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			response.result = patientService.getPatientNoList(req);
		}catch(EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			response.setRespCode(ErrorMessage.E1410.getCode());
			response.setRespMsg(messageSource.getMessage(ErrorMessage.E1410.info, null, locale));
			response.setErrorDesc(ex.getMessage());
		}catch(Exception ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			response.setRespCode(ErrorMessage.E1500.getCode());
			response.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			response.setErrorDesc(ex.getMessage());
		}
		return response;
	}

	/**
	 * 患者医院手机号获取。获取医院、病案号、姓名完全匹配的患者联系人表中sourceFlag=3的所有手机号，并去重
	 * @param locale
	 * @param patientSimpleInfo
	 */
	@RequestMapping(value = "patient/hospital/phone/get",method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Map<String,Object>> getPatientHospitalPhone(Locale locale, @RequestBody PatientHospitalCertificateReq patientSimpleInfo){
		TMsgResponse<Map<String,Object>> tMsgResponse = new TMsgResponse<Map<String,Object>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Map<String,Object> list=this.patientService.findPatientHospitalPhone(patientSimpleInfo);
			tMsgResponse.setResult(list);
		} catch(EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1410.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1410.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(EmptyObjectExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	
	
	/**
	 * 
	 * @author fanpanwei
	 * @title :queryPatientsDataStatistics
	 * @Description:获取特定医生的患者基本信息统计数据
	 * @return TMsgResponse<TPatientNoInfo>
	 * @date 2017年1月6日 上午11:39:54
	 */
	@RequestMapping(value="patients/data/statistics",method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<PatientBaseDataStatistics> queryPatientsDataStatistics(@RequestBody Doctor doctor,Locale locale){
		TMsgResponse<PatientBaseDataStatistics> response=new TMsgResponse<PatientBaseDataStatistics>();
		response.setRespCode(ErrorMessage.SUCCESS.getCode());
		response.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			if(doctor==null) throw new NullPointerException("doctorId is null");
			Long doctorId = doctor.getDoctorId();
			PatientBaseDataStatistics patientBaseData = patientService.getPatientBaseDataBydoctorId(doctorId);
			response.setResult(patientBaseData);
		}catch(Exception ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			response.setRespCode(ErrorMessage.E1500.getCode());
			response.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			response.setErrorDesc(ex.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "patient/certificateflag/get",method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<Map<String,Object>> getPatientCertificateFlag(Long patientId,Locale locale){
		TMsgResponse<Map<String,Object>> msg=new TMsgResponse<>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info,null,locale));
		try{
			msg.result=patientService.getPatientCertificateFlag(patientId);
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
