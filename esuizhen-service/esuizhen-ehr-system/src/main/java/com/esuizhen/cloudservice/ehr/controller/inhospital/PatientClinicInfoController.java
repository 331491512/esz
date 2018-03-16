package com.esuizhen.cloudservice.ehr.controller.inhospital;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.dao.meta.MetaInfoCountyDao;
import com.esuizhen.cloudservice.ehr.model.inhospital.PatientClinicInfo;
import com.esuizhen.cloudservice.ehr.model.inhospital.PatientClinicInfoQueryReq;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoCounty;
import com.esuizhen.cloudservice.ehr.service.common.CommonService;
import com.esuizhen.cloudservice.ehr.service.inhospital.PatientClinicInfoService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class PatientClinicInfoController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	@Qualifier("patientClinicInfoService")
	private CommonService<PatientClinicInfo> commonService;

	@Autowired
	private PatientClinicInfoService patientClinicInfoService;

	@Autowired
	private MetaInfoCountyDao metaInfoCountyDao;

	/**
	 * 患者门诊信息列表查询
	 * 
	 * @param patientSearchInfo
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/patient/clinic/info/list/query", method = RequestMethod.POST)
	public TMsgResponse<Page<PatientClinicInfo>> queryPatientClinicInfoList(@RequestBody PatientClinicInfoQueryReq req, Locale locale) {
		TMsgResponse<Page<PatientClinicInfo>> tMsgResponse = new TMsgResponse<Page<PatientClinicInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Page<PatientClinicInfo> page = commonService.queryPageList(req);
			tMsgResponse.setResult(page);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

	@ResponseBody
	@RequestMapping(value = "/patient/clinic/info/save", method = RequestMethod.POST)
	public TMsgResponse<PatientClinicInfo> savePatientClinicInfo(@RequestBody PatientClinicInfo clinicInfo, Locale locale) {
		TMsgResponse<PatientClinicInfo> tMsgResponse = new TMsgResponse<PatientClinicInfo>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.result = patientClinicInfoService.insertPatientClinicInfo(clinicInfo);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * modify by xueyongyan 20170518
	 * 门诊病案首页的省市县的保存修改
	 * 
	 * @param clinicMedicalId
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/patient/clinic/detail/query", method = RequestMethod.GET)
	public TMsgResponse<PatientClinicInfo> queryPatientClinicDetail(String clinicMedicalId, Locale locale) {
		TMsgResponse<PatientClinicInfo> tMsgResponse = new TMsgResponse<PatientClinicInfo>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			PatientClinicInfo info = commonService.queryOne(clinicMedicalId);
			String nativeCity = info.getNativePlaceCityCode();
			if (StringUtils.isNotEmpty(nativeCity)) {
				List<TMetaInfoCounty> cList = metaInfoCountyDao.getMetaInfoCountyList(null, nativeCity, null);
				if (cList.size() > 0) {
					info.setNativePlaceProvinceCode(cList.get(0).getProvinceCode());
					info.setNativePlaceCityCode(nativeCity);
				} else {
					info.setNativePlaceProvinceCode(nativeCity);
				}
			}
			String birthPlaceCountyCode = info.getBirthPlaceCountyCode();
			if (StringUtils.isNotEmpty(birthPlaceCountyCode)) {
				List<TMetaInfoCounty> cList = metaInfoCountyDao.getMetaInfoCountyList(null, null, birthPlaceCountyCode);
				if (cList.size() > 0) {
					info.setBirthPlaceProvinceCode(cList.get(0).getProvinceCode());
					info.setBirthPlaceCityCode(cList.get(0).getCityCode());
					info.setBirthPlaceCountyCode(birthPlaceCountyCode);
				} else {
					List<TMetaInfoCounty> cList2 = metaInfoCountyDao.getMetaInfoCountyList(null, birthPlaceCountyCode, null);
					if (cList2.size() > 0) {
						info.setBirthPlaceProvinceCode(cList2.get(0).getProvinceCode());
						info.setBirthPlaceCityCode(birthPlaceCountyCode);
					} else {
						info.setBirthPlaceProvinceCode(birthPlaceCountyCode);
					}
				}
			}
			tMsgResponse.result = info;
			// tMsgResponse.result =
			// commonService.queryOne(clinicMedicalId);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
}
