package com.esuizhen.cloudservice.user.controller;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.esuizhen.cloudservice.user.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.user.bean.DepartmentQueryReq;
import com.esuizhen.cloudservice.user.bean.DeptOfpatientReq;
import com.esuizhen.cloudservice.user.bean.HospitalGuideReq;
import com.esuizhen.cloudservice.user.bean.HospitalsCertificatedOfPatientListReq;
import com.esuizhen.cloudservice.user.bean.THospitalGuideInfo;
import com.esuizhen.cloudservice.user.bean.THospitalSimpleInfo;
import com.esuizhen.cloudservice.user.service.HospitalService;
import com.westangel.common.bean.DepartmentProfile;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.HospitalProfile;
import com.westangel.common.bean.HospitalSearchReq;
import com.westangel.common.bean.SubDeptProfile;
import com.westangel.common.bean.THospitalSpecialtyInfo;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.TWeixinProductIdInfo;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

/**
 * @ClassName: HospitalController 
 * @Description: 医院包括部门相关业务控制类
 * @author YYCHEN
 * @date 2015年12月12日 下午18:23:17  
 */
@Controller
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private PatientService patientService;
	
	/**
	 * 查询医院列表信息。
	 * @param locale
	 * @return
	 */
	@RequestMapping(value="/hospital/search", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<List<HospitalProfile>> searchHospital(Locale locale, @RequestBody HospitalSearchReq hospitalSearchReq) {
		LogUtil.log.info("查询医院列表信息(searchHospital)==========>>");
		TMsgResponse<List<HospitalProfile>> tMsgResponse = new TMsgResponse<List<HospitalProfile>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<HospitalProfile> hospitalList = hospitalService.getHospitals(hospitalSearchReq);
			tMsgResponse.setResult(hospitalList);
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
	* @Title: addHospital 
	* @Description: 添加医院 
	* @param @param locale
	* @param @param hospital
	* @param @return    设定文件 
	* @return TMsgResponse<String>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/hospital/add", method=RequestMethod.POST)
	public TMsgResponse<HospitalProfile> addHospital(Locale locale, @RequestBody HospitalProfile hospital)
	{
		LogUtil.log.info("添加医院(addHospital)==========>>");
		TMsgResponse<HospitalProfile> msgResponse = new TMsgResponse<HospitalProfile>();
		msgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			msgResponse.setResult(hospitalService.addHospital(hospital));
		} catch(Exception ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			msgResponse.setRespCode(ErrorMessage.E1500.getCode());
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msgResponse.setErrorDesc(ex.getMessage());
		}
		return msgResponse;
	}
	
	@RequestMapping("/metainfo/hospital/list")
	@ResponseBody
	public TMsgResponse<List<HospitalProfile>> searchHospital(Locale locale, Date timeFlag, Integer reqFlag) {
		LogUtil.log.info("searchHospital....timeFlag=" + timeFlag);
		TMsgResponse<List<HospitalProfile>> tMsgResponse = new TMsgResponse<List<HospitalProfile>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		HospitalSearchReq hospitalSearchReq = new HospitalSearchReq();
		hospitalSearchReq.setTimeFlag(timeFlag);
		List<HospitalProfile> hospitalList = null;
		try {
			if (null != reqFlag && reqFlag == 1) {
				hospitalList = hospitalService.getSignHospitals();
			} else {
				hospitalList = hospitalService.getHospitals(hospitalSearchReq);
			}
			tMsgResponse.setResult(hospitalList);
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return tMsgResponse;
	}
	
	/**
	 * 获取医院详细信息
	 * @param locale
	 * @param hospitalId
	 * @param reqFlag  1:不返会商品（开通的服务）信息
	 * @return
	 */
	@RequestMapping(value="/hospital/detail",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<HospitalProfile> getHospitalDetail(Integer hospitalId,Integer reqFlag,Locale locale) {
		LogUtil.log.info("获取医院详细信息(getHospitalDetail)==========>>");
		TMsgResponse<HospitalProfile> tMsgResponse = new TMsgResponse<HospitalProfile>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			HospitalProfile hospitalProfile = hospitalService.getHospitalDetail(hospitalId,reqFlag);
			tMsgResponse.setResult(hospitalProfile);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

	
	/**
	 * 修改医院
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/hospital/modify", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<String> modifyHospital(Locale locale, @RequestBody HospitalProfile hospitalProfile) {
		LogUtil.log.info("修改医院(modifyHospital)==========>>");
		//设置返回成功代码及提示消息
		TMsgResponse<String> tMsgResponse = new TMsgResponse<String>();
		tMsgResponse.respCode=ErrorMessage.SUCCESS.code;
		tMsgResponse.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			if (!hospitalService.modifyHospital(hospitalProfile)){
				tMsgResponse.respCode=ErrorMessage.E1417.code;
				tMsgResponse.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			}
		} catch (Exception ex) {
			//设置错误代码及提示消息
			tMsgResponse.respCode=ErrorMessage.E1500.code;
			tMsgResponse.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 查询患者所在医院列表信息。
	 * @param locale
	 * @return
	 */
	@RequestMapping(value="/hospital/ofpatient/list", method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<THospitalSimpleInfo>> getHospitalsOfPatientList(Long patientId,Integer productType,Locale locale) {
		LogUtil.log.info("查询患者所在医院列表信息(getHospitalsOfPatientList)==========>>");
		TMsgResponse<List<THospitalSimpleInfo>> tMsgResponse = new TMsgResponse<List<THospitalSimpleInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<THospitalSimpleInfo> hospitalList = hospitalService.getHospitalsOfPatientList(patientId,productType);
			tMsgResponse.setResult(hospitalList);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 查询医院科室元数据信息
	 * @param locale
	 * @param hospitalId
	 * @return
	 */
	@RequestMapping(value="/metainfo/department/query",method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<List<DepartmentProfile>> queryDepartmentMetaInfo(Locale locale,@RequestBody DepartmentQueryReq req) {
		TMsgResponse<List<DepartmentProfile>> tMsgResponse = new TMsgResponse<List<DepartmentProfile>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<DepartmentProfile> hospitalList = hospitalService.queryDepartmentMetaInfo(req);
			tMsgResponse.setResult(hospitalList);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 查询医院科室信息
	 * @param locale
	 * @param hospitalId
	 * @return
	 */
	@RequestMapping(value="/department/query",method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<List<DepartmentProfile>> queryDepartment(Locale locale, @RequestBody DepartmentQueryReq req) {
		TMsgResponse<List<DepartmentProfile>> tMsgResponse = new TMsgResponse<List<DepartmentProfile>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<DepartmentProfile> hospitalList = hospitalService.queryDepartment(req);
			tMsgResponse.setResult(hospitalList);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 根据医院ID获取科室列表
	 * @param locale
	 * @param hospitalId
	 * @return
	 */
	@RequestMapping("/department/list")
	@ResponseBody
	public TMsgResponse<List<DepartmentProfile>> listDepartment(Locale locale, Integer hospitalId) {
		LogUtil.log.info("根据医院ID获取科室列表(listDepartment)==========>>");
		TMsgResponse<List<DepartmentProfile>> tMsgResponse = new TMsgResponse<List<DepartmentProfile>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<DepartmentProfile> hospitalList = hospitalService.getDepartmentsByHospitalId(hospitalId);
			tMsgResponse.setResult(hospitalList);
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
	* @Title: addDepartmet 
	* @Description: 添加科室信息 
	* @param @param locale
	* @param @param department
	* @param @return    设定文件 
	* @return TMsgResponse<String>    返回类型 
	* @throws
	 */
	@RequestMapping(value="/department/add", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Object> addDepartmet(Locale locale, @RequestBody DepartmentProfile department)
	{
		LogUtil.log.info("添加科室信息(addDepartmet)==========>>");
		TMsgResponse<Object> msgResponse = new TMsgResponse<Object>();
		msgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));		
		try {
			hospitalService.addDepartment(department);
			msgResponse.result = department;
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			msgResponse.setRespCode(ErrorMessage.E1500.getCode());
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msgResponse.setErrorDesc(ex.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: modifyDepartmet 
	* @Description: 修改科室信息 
	* @param @param locale
	* @param @param department
	* @param @return    设定文件 
	* @return TMsgResponse<String>    返回类型 
	* @throws
	 */
	@RequestMapping(value="/department/modify", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<String> modifyDepartmet(Locale locale, @RequestBody DepartmentProfile department)
	{
		LogUtil.log.info("修改科室信息(modifyDepartmet)==========>>");
		TMsgResponse<String> msgResponse = new TMsgResponse<String>();
		msgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));		
		try {
			hospitalService.modifyDepartment(department);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			msgResponse.setRespCode(ErrorMessage.E1500.getCode());
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msgResponse.setErrorDesc(ex.getMessage());
		}
		return msgResponse;
	}
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :saveDepartmentOfpatient
	 * @Description:科室关系保存
	 * @return TMsgResponse<String>
	 * @date 2016年8月19日 下午5:59:26
	 */
	@RequestMapping(value="/department/ofpatient/save", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<String> saveDepartmentOfpatient(Locale locale, @RequestBody DeptOfpatientReq req)
	{
		LogUtil.log.info("修改科室信息(modifyDepartmet)==========>>");
		TMsgResponse<String> msgResponse = new TMsgResponse<String>();
		msgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));		
		try {
			hospitalService.saveDepartmentOfpatient(req);
		}catch (EmptyObjectExcption e) {
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			msgResponse.setRespCode(ErrorMessage.E1404.getCode());
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
		}catch (EmptyParamExcption e) {
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			msgResponse.setRespCode(ErrorMessage.E1419.getCode());
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1419.info, null, locale));
		}catch (Exception e) {
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			msgResponse.setRespCode(ErrorMessage.E1500.getCode());
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: addSubDepartmet 
	* @Description: 添加子科室信息 
	* @param @param locale
	* @param @param subDept
	* @param @return    设定文件 
	* @return TMsgResponse<String>    返回类型 
	* @throws
	 */
	@RequestMapping(value="/subdepartment/add", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<String> addSubDepartmet(Locale locale, @RequestBody SubDeptProfile subDept)
	{
		LogUtil.log.info("添加子科室信息(addSubDepartmet)==========>>");
		TMsgResponse<String> msgResponse = new TMsgResponse<String>();
		msgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));		

		try {
			hospitalService.addSubDepartment(subDept);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			msgResponse.setRespCode(ErrorMessage.E1500.getCode());
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msgResponse.setErrorDesc(ex.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 
	* @Title: modifySubDepartmet 
	* @Description: 更新子科室信息 
	* @param @param locale
	* @param @param subDept
	* @param @return    设定文件 
	* @return TMsgResponse<String>    返回类型 
	* @throws
	 */
	@RequestMapping(value="/subdepartment/modify", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<String> modifySubDepartmet(Locale locale, @RequestBody SubDeptProfile subDept)
	{
		LogUtil.log.info("更新子科室信息(modifySubDepartmet)==========>>");
		TMsgResponse<String> msgResponse = new TMsgResponse<String>();
		msgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));		

		try {
			hospitalService.modifySubDepartment(subDept);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			msgResponse.setRespCode(ErrorMessage.E1500.getCode());
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msgResponse.setErrorDesc(ex.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 查询开通了院级服务的医院列表信息。
	 * By Da Loong
	 * 2016/5/28
	 * @param locale
	 * @return
	 */
	@RequestMapping(value="/hospital/having/service/query", method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<HospitalProfile>> queryHospitalHavingService(Locale locale) {
		LogUtil.log.info("查询开通了院级服务的医院列表信息(queryHospitalHavingService)==========>>");
		TMsgResponse<List<HospitalProfile>> tMsgResponse = new TMsgResponse<List<HospitalProfile>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<HospitalProfile> hospitalList = hospitalService.queryHospitalHavingService();
			tMsgResponse.setResult(hospitalList);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	
	/**
	 * 获取医院Profile信息
	 * By Da Loong
	 * 2016/5/28
	 * @param locale
	 * @param hospitalId
	 * @return
	 */
	@RequestMapping("/hospital/profile")
	@ResponseBody
	public TMsgResponse<HospitalProfile> getHospitalProfile(Locale locale, Integer hospitalId,Integer patientId) {
		LogUtil.log.info("获取医院Profile信息(getHospitalProfile)==========>>");
		TMsgResponse<HospitalProfile> tMsgResponse = new TMsgResponse<HospitalProfile>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			HospitalProfile hospitalProfile = hospitalService.getHospitalProfile(hospitalId,patientId);
			tMsgResponse.setResult(hospitalProfile);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 查询患者认证的医院列表信息。
	 * By Da Loong
	 * 2016/6/1
	 * @param locale
	 * @return
	 */
	@RequestMapping(value="/hospital/certificated/ofpatient/list", method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<THospitalSimpleInfo>> getHospitalsCertificatedOfPatientList(HospitalsCertificatedOfPatientListReq req,Locale locale) {
		LogUtil.log.info("查询患者认证医院列表信息(getHospitalsCertificatedOfPatientList)==========>>");
		TMsgResponse<List<THospitalSimpleInfo>> tMsgResponse = new TMsgResponse<List<THospitalSimpleInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<THospitalSimpleInfo> hospitalList = hospitalService.getHospitalsCertificatedOfPatientList(req);
			for (THospitalSimpleInfo hospitalSimpleInfo : hospitalList){
				if(hospitalSimpleInfo.getFailState()!=null){
					hospitalSimpleInfo.setCheckResult(
							patientService.getMessgaeByCertificateHospitalResult(hospitalSimpleInfo.getFailState()));
				}
			}
			tMsgResponse.setResult(hospitalList);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 获取独立公众号医院名字。
	 * By Da Loong
	 * 2016/6/1
	 * @param locale
	 * @return
	 */
	@RequestMapping(value="/hospital/name/query", method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<THospitalSimpleInfo>> queryHospitalNameByProductId(Integer wxProductId,Locale locale) {
		LogUtil.log.info("查询独立公众号医院名称(queryHospitalNameByProductId)==========>>");
		TMsgResponse<List<THospitalSimpleInfo>> tMsgResponse = new TMsgResponse<List<THospitalSimpleInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<THospitalSimpleInfo> hospitalList = hospitalService.queryHospitalNameByProductId(wxProductId);
			tMsgResponse.setResult(hospitalList);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	
	/**
	 * 通过微信Id反查公众号对应的productId
	 * By Da Loong
	 * 2016/6/1
	 * @param locale
	 * @return
	 */
	@RequestMapping(value="/wx/productid/query", method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<TWeixinProductIdInfo> queryWxProductId(String weixinId,Locale locale) {
		LogUtil.log.info("通过微信Id反查公众号对应的productId(queryWxProductId)==========>>");
		TMsgResponse<TWeixinProductIdInfo> tMsgResponse = new TMsgResponse<TWeixinProductIdInfo>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			TWeixinProductIdInfo wxProductIdInfo = hospitalService.queryWxProductId(weixinId);
			tMsgResponse.setResult(wxProductIdInfo);
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
	 * @author lichenghao
	 * @title :getMetaInfoHospitalSpecialtyList
	 * @Description:获取特色专科元数据
	 * @return TMsgResponse<THospitalSpecialtyInfo>
	 * @date 2016年6月8日 下午7:05:28
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/hospital/specialty/list",method=RequestMethod.GET)
	public TMsgResponse<List<THospitalSpecialtyInfo>> getMetaInfoHospitalSpecialtyList(Locale locale){
		TMsgResponse<List<THospitalSpecialtyInfo>> msg = new TMsgResponse<List<THospitalSpecialtyInfo>>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			msg.result = hospitalService.getMetaInfoHospitalSpecialtyList();
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msg.setErrorDesc(ex.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getHospitalGuideList
	 * @Description:查询医院就医指南列表
	 * @return TMsgResponse<List<THospitalGuideInfo>>
	 * @date 2016年7月19日 下午7:33:33
	 */
	@ResponseBody
	@RequestMapping(value="/hospital/guide/list/search",method=RequestMethod.GET)
	public TMsgResponse<List<THospitalGuideInfo>> searchHospitalGuideList(HospitalGuideReq req,Locale locale){
		TMsgResponse<List<THospitalGuideInfo>> msg = new TMsgResponse<List<THospitalGuideInfo>>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			msg.result = hospitalService.searchHospitalGuideList(req);
		} catch(EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1400.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			msg.setErrorDesc(ex.getMessage());
		}catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msg.setErrorDesc(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getHospitalGuideInfo
	 * @Description:获取医院就医指南信息
	 * @return TMsgResponse<THospitalGuideInfo>
	 * @date 2016年7月19日 下午7:34:52
	 */
	@ResponseBody
	@RequestMapping(value="/hospital/guide/info/get",method=RequestMethod.GET)
	public TMsgResponse<THospitalGuideInfo> getHospitalGuideInfo(HospitalGuideReq req,Locale locale){
		TMsgResponse<THospitalGuideInfo> msg = new TMsgResponse<THospitalGuideInfo>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			msg.result = hospitalService.getHospitalGuideInfo(req);
		} catch(EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1400.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			msg.setErrorDesc(ex.getMessage());
		}catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msg.setErrorDesc(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/hospital/search/list",method=RequestMethod.POST)
	public TMsgResponse<List<HospitalProfile>> getHospitalListInfo(Locale locale, @RequestBody HospitalSearchReq hospitalSearchReq){
		TMsgResponse<List<HospitalProfile>> msg = new TMsgResponse<List<HospitalProfile>>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<HospitalProfile> hospitalProfiles = hospitalService.getHospitalListInfo(hospitalSearchReq);
			if (hospitalProfiles == null || hospitalProfiles.isEmpty()) {
				msg.setRespCode(ErrorMessage.E1404.getCode());
				msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				msg.setResult(hospitalProfiles);
			}
		}catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msg.setErrorDesc(ex.getMessage());
		}
		return msg;
	}
}
