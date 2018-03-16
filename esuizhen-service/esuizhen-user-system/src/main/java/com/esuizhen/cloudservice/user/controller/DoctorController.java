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

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.user.bean.DoctorHospitalSearchByKeywordReq;
import com.esuizhen.cloudservice.user.bean.DoctorHospitalSimpleInfo;
import com.esuizhen.cloudservice.user.bean.DoctorListReq;
import com.esuizhen.cloudservice.user.bean.DoctorSearchByCombinedConditionReq;
import com.esuizhen.cloudservice.user.bean.TDiseaseInfo;
import com.esuizhen.cloudservice.user.bean.TDoctorInvitation;
import com.esuizhen.cloudservice.user.bean.TDoctorMinInfo;
import com.esuizhen.cloudservice.user.bean.TDoctorStatisProfile;
import com.esuizhen.cloudservice.user.service.DoctorService;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.DoctorProfile;
import com.westangel.common.bean.DoctorSimpleInfo;
import com.westangel.common.bean.DoctorTag;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.HospitalDoctor;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.JsonUtil;
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
	
	@Value("${url.api.business.doctor.inite.patient.do.something}")
	private String initePatientSmsUrl;
	@Value("${server.api.url.root}")
	private String serverUrlRoot;
	
	@Autowired
	private PushInnerService pushInnerService;

	@RequestMapping("/metainfo/doctor/tag/list")
	@ResponseBody
	public TMsgResponse<List<DoctorTag>> getDoctorTagList(Locale locale) {
		LogUtil.log.info("获取所有医生标签(getDoctorTagList)==========>>");
		TMsgResponse<List<DoctorTag>> tMsgResponse = new TMsgResponse<List<DoctorTag>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<DoctorTag> doctorTagList = doctorService.searchDoctorTagList();
			tMsgResponse.setResult(doctorTagList);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 筛选医生
	 * 根据医院，科室，医生名称查询医生列表。
	 * @param hospitalId 医院ID
	 * @param deptId 部门ID
	 * @param doctorName 医生姓名
	 * @return
	 */
	@RequestMapping(value = "/doctor/search", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<List<Map<String, Object>>> searchDoctor(Locale locale, @RequestBody DoctorProfile doctorProfile) {
		LogUtil.log.info("筛选医生(searchDoctor)==========>>");
		TMsgResponse<List<Map<String, Object>>> tMsgResponse = new TMsgResponse<List<Map<String, Object>>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		HashMap<String, Object> map = new HashMap<String, Object>(3);
		if(doctorProfile.getHospitalId() != null){
			map.put("hospitalId", doctorProfile.getHospitalId());
		}
		if(doctorProfile.getDeptId() != null){
			map.put("deptId", doctorProfile.getDeptId());
		}
		if (StringUtils.isNotBlank(doctorProfile.getDoctorName())) {
			map.put("doctorName", doctorProfile.getDoctorName());
		}
		if (StringUtils.isNotEmpty(doctorProfile.getMobile())) {
			map.put("mobile", doctorProfile.getMobile());
		}
		try {
			List<Map<String, Object>> doctorList = doctorService.searchDoctor(map);
			tMsgResponse.setResult(doctorList);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 医生/医院按关键字模糊查询
	 * 根据医院\科室、病种、医生姓名，模糊查询医生或医院。先查询符合条件的医生信息；当查询完医生信息后，再查询符合条件的医院信息:即先返回医生信息，当没有更多符合条件的医生信息时，再返回医院信息
	 * @param hospitalId 医院ID
	 * @param deptId 部门ID
	 * @param doctorName 医生姓名
	 * @return
	 */
	@RequestMapping(value = "/doctor/search/bykeyword", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Page<DoctorHospitalSimpleInfo>> searchDoctorHospitalByKeyword(Locale locale, @RequestBody DoctorHospitalSearchByKeywordReq doctorHospitalSearchByKeywordReq) {
		LogUtil.logError.info("医生/医院按关键字模糊查询(searchDoctorHospitalByKeyword)==========>>");
		TMsgResponse<Page<DoctorHospitalSimpleInfo>> tMsgResponse = new TMsgResponse<Page<DoctorHospitalSimpleInfo>>();
		if (doctorHospitalSearchByKeywordReq.getPage() == null || doctorHospitalSearchByKeywordReq.getPage() < 0) {
			doctorHospitalSearchByKeywordReq.setPage(0);
		}
		if (doctorHospitalSearchByKeywordReq.getNum() == null || doctorHospitalSearchByKeywordReq.getNum() < 1) {
			doctorHospitalSearchByKeywordReq.setNum(100);
		}
		if (StringUtils.isEmpty(doctorHospitalSearchByKeywordReq.getKeyword())) {
			doctorHospitalSearchByKeywordReq.setKeyword("");
		}
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Page<DoctorHospitalSimpleInfo> doctorList = this.doctorService.searchDoctorHospitalByKeyword(doctorHospitalSearchByKeywordReq);
			tMsgResponse.setResult(doctorList);
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
	 * @param locale
	 * @param patientId
	 * @param productType
	 * @return
	 */
	@RequestMapping("/doctor/ofpatient/list")
	@ResponseBody
	public TMsgResponse<List<DoctorSimpleInfo>> listDoctorsOfPatient(Locale locale, Long patientId, Long productType) {
		LogUtil.log.info("搜索医生(listDoctorsOfPatient)==========>>");
		TMsgResponse<List<DoctorSimpleInfo>> tMsgResponse = new TMsgResponse<List<DoctorSimpleInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<DoctorSimpleInfo> doctorList = this.doctorService.listDoctorsOfPatient(patientId, productType);
			tMsgResponse.setResult(doctorList);
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}
	
	@RequestMapping("/doctor/recommed")
	@ResponseBody
	public TMsgResponse<List<DoctorSimpleInfo>> recommendDoctor(Locale locale, Long hospitalId, Long patientId) {
		LogUtil.log.info("推荐医生(recommendDoctor)==========>>");
		TMsgResponse<List<DoctorSimpleInfo>> tMsgResponse = new TMsgResponse<List<DoctorSimpleInfo>>();
		if (patientId == null) {
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			return tMsgResponse;
		}
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<DoctorSimpleInfo> doctorList = this.doctorService.recommendDoctor(patientId, hospitalId);
			tMsgResponse.setResult(doctorList);
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
	* @Title: relationOfHospital 
	* @Description: 修改医生和医院/科室的关系 
	* @param @param locale
	* @param @param hospitalDoctor
	* @param @return    设定文件 
	* @return TMsgResponse<String>    返回类型 
	* @throws
	 */
	@RequestMapping("/doctor/hospital/relation")
	@ResponseBody
	public TMsgResponse<String> doctorHospitalRelation(Locale locale, HospitalDoctor hospitalDoctor)
	{
		LogUtil.log.info("修改医生和医院/科室的关系(relationOfHospital)==========>>");
		TMsgResponse<String> msgResponse = new TMsgResponse<String>();
		msgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			doctorService.doctorHospitalRelation(hospitalDoctor);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			msgResponse.setRespCode(ErrorMessage.E1500.getCode());
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msgResponse.setErrorDesc(ex.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 获取医生所有患者的病种
	 * @author lichenghao
	 * @title :getDoctorPatientDiseaseList
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2016年5月18日 上午10:38:30
	 */
	@RequestMapping("/doctor/patient/disease/type/list")
	@ResponseBody
	public TMsgResponse<List<TDiseaseInfo>> getDoctorPatientDiseaseList(Long doctorId,Locale locale)
	{
		TMsgResponse<List<TDiseaseInfo>> msgResponse = new TMsgResponse<List<TDiseaseInfo>>();
		msgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			msgResponse.result = doctorService.getDoctorPatientDiseaseList(doctorId);
		} 
		catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msgResponse.setRespCode(ErrorMessage.E1500.getCode());
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msgResponse;
	}
	
	
	/**
	 * 医生信息统计
	 * @author lichenghao
	 * @title :getDoctorStaticsInfo
	 * @Description:TODO
	 * @return TMsgResponse<TDoctorGroupStatisInfo>
	 * @date 2016年5月25日 下午3:55:39
	 */
	@ResponseBody
	@RequestMapping(value="/relation/doctor/static/info/get",method=RequestMethod.GET)
	public TMsgResponse<TDoctorStatisProfile> getDoctorStaticsInfo(Long doctorId,String staticType,Locale locale){
		TMsgResponse<TDoctorStatisProfile> msg = new TMsgResponse<TDoctorStatisProfile>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			msg.result = doctorService.getDoctorStaticsInfo(doctorId,staticType);
		}catch(EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause()+"\t"+ex.getMessage());
			msg.setRespCode(ErrorMessage.E1419.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1419.info, null, locale));
		}catch(Exception ex){
			LogUtil.logError.error(ex.getCause()+"\t"+ex.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}
	
	
	/**
	 * 医生组合查询
	 * @author lichenghao
	 * @title :searchDoctorByCombinedCondition
	 * @Description:TODO
	 * @return TMsgResponse<Page<DoctorSimpleInfo>>
	 * @date 2016年6月7日 上午10:09:58
	 */
	@ResponseBody
	@RequestMapping(value="/doctor/search/by/combined/condition",method=RequestMethod.POST)
	public TMsgResponse<Page<DoctorSimpleInfo>> searchDoctorByCombinedCondition(@RequestBody DoctorSearchByCombinedConditionReq req,Locale locale){
		TMsgResponse<Page<DoctorSimpleInfo>> msg = new TMsgResponse<Page<DoctorSimpleInfo>>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			msg.result = doctorService.searchDoctorByCombinedCondition(req);
		}catch(EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause()+"\t"+ex.getMessage());
			msg.setRespCode(ErrorMessage.E1419.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1419.info, null, locale));
		}catch(Exception ex){
			LogUtil.logError.error(ex.getCause()+"\t"+ex.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}
	@ResponseBody
	@RequestMapping(value="/doctor/list" , method=RequestMethod.POST)
	public TMsgResponse<List<TDoctorMinInfo>> getDoctorList(@RequestBody(required=false) DoctorListReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TDoctorMinInfo>> msg = new TMsgResponse<List<TDoctorMinInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			msg.result = doctorService.getDoctorList(req);
		}catch(Exception ex)
		{
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	@ResponseBody
	@RequestMapping(value="/wechat/activate/judge" , method=RequestMethod.POST)
	public TMsgResponse<Map<String,Integer>> judgeActivateRight(@RequestBody Doctor doctor, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Map<String,Integer>> msg = new TMsgResponse<Map<String,Integer>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			if(doctor==null)throw new NullPointerException("doctorId is null");
			Long doctorId = doctor.getDoctorId();
			Map<String,Integer> map = new HashMap<String, Integer>();
			Integer state = doctorService.judgeActivateRight(doctorId);
			if(state!=null&&state>=30){
				List<Integer> patientIdSetByMsg=doctorService.getInvitePatientByMsg(doctorId);
				Integer sizeByMsg=patientIdSetByMsg!=null&&patientIdSetByMsg.size()>0?patientIdSetByMsg.size():0;
				map.put("sendMsgNum", sizeByMsg);//发短信的患者
				/*List<Integer> patientIdSetByWechat=doctorService.getInvitePatientByWechat(doctorId);
				Integer sizeByWechat=patientIdSetByWechat!=null&&patientIdSetByWechat.get(0)!=null?patientIdSetByWechat.size():0;
				map.put("sendWechatNum", sizeByWechat);//发微信的患者
*/			}
			map.put("activateState", state==null?0:state);
			msg.setResult(map);
		}catch(Exception ex)
		{
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * 
	* @Title: sendActivateWechatMsg 
	* @Description: 首页群发邀请激活信息接口
	* @param 
	* @return TMsgResponse
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/wechat/activate/msg/send", method = RequestMethod.POST)
	public TMsgResponse<Void> sendActivateWechatMsg(Locale locale, @RequestBody TDoctorInvitation tDoctorInvitation) {
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage("success", null, locale));	
		try {
			int size=0;
			//1.短信邀请激活微信开始
			List<Integer> patientIdSet = doctorService.getInvitePatientByMsg(tDoctorInvitation.getDoctorId());
			if(patientIdSet!=null&&patientIdSet.size()>0){
				size=patientIdSet.size();
				Integer[] array = (Integer[])patientIdSet.toArray(new Integer[size]);  
				tDoctorInvitation.setPatients(array);
				tDoctorInvitation.setInviteType(31);
				String mJson=JsonUtil.toJson(tDoctorInvitation);
				String weixinQRJson=HttpUtil.postWithJSON(this.serverUrlRoot+initePatientSmsUrl,mJson);
				TMsgResponse<Void> smsTMsgResponse = JsonUtil.toObject(weixinQRJson, TMsgResponse.class);
				if (smsTMsgResponse.getRespCode() != 0) {
					LogUtil.logError.error("sendActivateWechatMsg(),邀请激活微信失败,code=" + smsTMsgResponse.getRespCode() + "," + smsTMsgResponse.getRespMsg());
					tMsgResponse.setRespCode(smsTMsgResponse.getRespCode());
					tMsgResponse.setRespMsg(smsTMsgResponse.getRespMsg());
					return tMsgResponse;
				}else{
					doctorService.modifyActivateDate(tDoctorInvitation.getDoctorId());
				}
			}
			LogUtil.logError.debug("sendActivateWechatMsg(),"+size+"位患者邀请激活微信成功");
			//2.微信邀请完善资料开始
			/*List<Integer> patientIdSetByWechat=doctorService.getInvitePatientByWechat(tDoctorInvitation.getDoctorId());
			if(patientIdSetByWechat!=null&&patientIdSetByWechat.size()>0){
				size=patientIdSetByWechat.size();
				Integer[] array = (Integer[])patientIdSetByWechat.toArray(new Integer[size]);  
				tDoctorInvitation.setPatients(array);
				tDoctorInvitation.setInviteType(2);
				String mJson=JsonUtil.toJson(tDoctorInvitation);
				String weixinQRJson=HttpUtil.postWithJSON(this.serverUrlRoot+initePatientSmsUrl,mJson);
				TMsgResponse<Void> smsTMsgResponse = JsonUtil.toObject(weixinQRJson, TMsgResponse.class);
				if (smsTMsgResponse.getRespCode() != 0) {
					LogUtil.logError.error("sendActivateWechatMsg(),邀请完善基本信息失败,code=" + smsTMsgResponse.getRespCode() + "," + smsTMsgResponse.getRespMsg());
					tMsgResponse.setRespCode(smsTMsgResponse.getRespCode());
					tMsgResponse.setRespMsg(smsTMsgResponse.getRespMsg());
					return tMsgResponse;
				}
			}
			LogUtil.logError.debug("sendActivateWechatMsg(),"+size+"位患者邀请完善基本信息成功");*/
		} catch (Exception ex) {
			LogUtil.logError.error("smsInnerService.checkCaptcha()" + ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1418.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1418.info, new Object[]{ex.getMessage()}, locale));
			return tMsgResponse;
		}
		return tMsgResponse;
	}
}
