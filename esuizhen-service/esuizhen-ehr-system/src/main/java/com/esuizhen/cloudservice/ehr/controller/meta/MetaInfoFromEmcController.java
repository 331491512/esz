package com.esuizhen.cloudservice.ehr.controller.meta;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.bean.TMetaInfoIcd9Cm3;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoCondition;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoCounty;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoDiagnosisperiodization;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoDoctor;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoNation;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoNationality;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoOccupation;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoPayChannel;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoSurgeryIntensive;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoTumourPeriodization;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfotreatmentHistory;
import com.esuizhen.cloudservice.ehr.service.meta.MetaInfoService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class MetaInfoFromEmcController {

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private MetaInfoService metaInfoService;

	@ResponseBody
	@RequestMapping(value = "/metainfo/pay/channel/list", method = RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoPayChannel>> getMetaInfoPayChannelList(String payChannelName, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoPayChannel>> msg = new TMsgResponse<List<TMetaInfoPayChannel>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			msg.result = metaInfoService.getMetaInfoPayChannelList(payChannelName);

			if (msg.result == null || msg.result.size() < 1) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/metainfo/occupation/list", method = RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoOccupation>> getMetaInfoOccupationList(String occupationName, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoOccupation>> msg = new TMsgResponse<List<TMetaInfoOccupation>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			msg.result = metaInfoService.getMetaInfoOccupationList(occupationName);

			if (msg.result == null || msg.result.size() < 1) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/metainfo/nation/list", method = RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoNation>> getMetaInfoNationList(String nationName, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoNation>> msg = new TMsgResponse<List<TMetaInfoNation>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			msg.result = metaInfoService.getMetaInfoNationList(nationName);

			if (msg.result == null || msg.result.size() < 1) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/metainfo/county/list", method = RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoCounty>> getMetaInfoCountyList(String provinceCode, String cityCode, String countyCode, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoCounty>> msg = new TMsgResponse<List<TMetaInfoCounty>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			msg.result = metaInfoService.getMetaInfoCountyList(provinceCode, cityCode, countyCode);

			if (msg.result == null || msg.result.size() < 1) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/metainfo/nationality/list", method = RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoNationality>> getMetaInfoNationalityList(String nationalityName, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoNationality>> msg = new TMsgResponse<List<TMetaInfoNationality>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			msg.result = metaInfoService.getMetaInfoNationalityList(nationalityName);

			if (msg.result == null || msg.result.size() < 1) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/metainfo/condition/list", method = RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoCondition>> getMetaInfoConditionList(String bussinessType, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoCondition>> msg = new TMsgResponse<List<TMetaInfoCondition>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			msg.result = metaInfoService.getMetaInfoConditionList(bussinessType);

			if (msg.result == null || msg.result.size() < 1) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/metainfo/treatment/history/list", method = RequestMethod.GET)
	public TMsgResponse<List<TMetaInfotreatmentHistory>> getMetaInfoTreatmentHistoryList(String treatmentHistoryName, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfotreatmentHistory>> msg = new TMsgResponse<List<TMetaInfotreatmentHistory>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			msg.result = metaInfoService.getMetaInfoTreatmentHistoryList(treatmentHistoryName);

			if (msg.result == null || msg.result.size() < 1) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 
	 * @Title: getMetaInfoSurgeryIntensiveList
	 * @Description: 重症监护室元数据查询
	 * @param @param surgeryCode
	 * @param @param surgeryName
	 */
	@ResponseBody
	@RequestMapping(value = "/metainfo/surgery/intensive/list", method = RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoSurgeryIntensive>> getMetaInfoSurgeryIntensiveList(String surgeryCode, String surgeryName, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoSurgeryIntensive>> msg = new TMsgResponse<List<TMetaInfoSurgeryIntensive>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			msg.result = metaInfoService.getMetaInfoSurgeryIntensiveList(surgeryCode, surgeryName);

			if (msg.result == null || msg.result.size() < 1) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * @Title: getMetaInfoIcd9Cm3List
	 * @Description: 手术元数据查询
	 * @param @param treatmentTypeName
	 */
	@ResponseBody
	@RequestMapping(value = "/metainfo/icd9/cm3/emc/list", method = RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoIcd9Cm3>> getMetaInfoIcd9Cm3List(String key, String opCode, String opName, String mnemonicCode, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoIcd9Cm3>> msg = new TMsgResponse<List<TMetaInfoIcd9Cm3>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			msg.result = metaInfoService.getMetaInfoIcd9Cm3List(key, opCode, opName, mnemonicCode);

			if (msg.result == null || msg.result.size() < 1) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * @Title: getMetaInfoTumourPeriodizationList
	 * @Description: 肿瘤分期元数据列表查询
	 * @param @param treatmentTypeName
	 */
	@ResponseBody
	@RequestMapping(value = "/metainfo/tumour/periodization/list", method = RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoTumourPeriodization>> getMetaInfoTumourPeriodizationList(String tumourCode, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoTumourPeriodization>> msg = new TMsgResponse<List<TMetaInfoTumourPeriodization>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			msg.result = metaInfoService.getMetaInfoTumourPeriodizationList(tumourCode);

			if (msg.result == null || msg.result.size() < 1) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * @Title: getMetaInfoDoctorList
	 * @Description: 医生数据查询
	 * @param trueName
	 */
	@ResponseBody
	@RequestMapping(value = "/metainfo/doctor/list", method = RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoDoctor>> getMetaInfoDoctorList(String trueName, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoDoctor>> msg = new TMsgResponse<List<TMetaInfoDoctor>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查询
			msg.result = metaInfoService.getMetaInfoDoctorList(trueName);

			if (msg.result == null || msg.result.size() < 1) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	@ResponseBody
	@RequestMapping(value="/metainfo/diagnosisperiodization/query" , method=RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoDiagnosisperiodization>> queryDiagnosisperiodization(Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoDiagnosisperiodization>> msg = new TMsgResponse<List<TMetaInfoDiagnosisperiodization>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询所有诊断依据元数据
			msg.result = metaInfoService.queryListAll();
			if(msg.result == null || msg.result.size() == 0)
			{
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}
