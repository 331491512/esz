/**
 * 
 */
package com.esuizhen.cloudservice.ehr.controller.meta;


import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.bean.TMetaDiagnosisPeriodization;
import com.esuizhen.cloudservice.ehr.bean.TMetaDiseaseTypeIcdListReq;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoAdverseReaction;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoDetectionItem;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoDetectionType;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoEcog;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoExamItem;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoExamType;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoICDO3;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoIcd10Req;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoIcd9Cm3;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoKps;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoMedicationItem;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoPhysicalSigns;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoQualityoflifeScaleItem;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoSymptom;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoTcmSymptom;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoTreatmentScheme;
import com.esuizhen.cloudservice.ehr.model.disease.MetaEIcdOParent;
import com.esuizhen.cloudservice.ehr.model.disease.TDiagnosisPeriodizationInfo;
import com.esuizhen.cloudservice.ehr.model.disease.TMetaInfoDiseaseTypeIcd;
import com.esuizhen.cloudservice.ehr.model.disease.TMetaInfoTreatmentType;
import com.esuizhen.cloudservice.ehr.model.icd10.MetaEicd10;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaDetectionUnit;
import com.esuizhen.cloudservice.ehr.service.meta.MetaInfoService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
* @ClassName: MetaInfoController 
* @Description: 病历库元数据请求控制器(和专题模块共用）
* @author Da Loong
* @date 2016年4月7日 下午4:10:43
 */
@Controller
public class MetaInfoController{
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private MetaInfoService metaInfoService; 
	
	
	
	/**
	 * @author Da Loong
	 * @title :listMetaInfoPhysicalSigns
	 * @Description: 获取体征元数据列表
	 * @return TMsgResponse<List<TMetaInfoPhysicalSigns>>
	 * @date 2016年4月7日 下午4:35:52
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/physical/signs/list" , method=RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoPhysicalSigns>> listMetaInfoPhysicalSigns( Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoPhysicalSigns>> msg = new TMsgResponse<List<TMetaInfoPhysicalSigns>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询体征元数据列表
			msg.result = metaInfoService.listMetaInfoPhysicalSigns();
			
		
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * @author Da Loong
	 * @title :getMetaInfoKps
	 * @Description: 获取KPS元数据列表
	 * @return TMsgResponse<List<TMetaInfoPhysicalSigns>>
	 * @date 2016年4月7日 下午4:35:52
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/kps" , method=RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoKps>> getMetaInfoKps( Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoKps>> msg = new TMsgResponse<List<TMetaInfoKps>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询元数据列表
			msg.result = metaInfoService.getMetaInfoKps();
			
		
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * @author Da Loong
	 * @title :getMetaInfoEcog
	 * @Description: 获取ECOG元数据列表
	 * @return TMsgResponse<List<TMetaInfoPhysicalSigns>>
	 * @date 2016年4月7日 下午4:35:52
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/ecog" , method=RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoEcog>> getMetaInfoEcog( Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoEcog>> msg = new TMsgResponse<List<TMetaInfoEcog>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询元数据列表
			msg.result = metaInfoService.getMetaInfoEcog();
			
		
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * @author Da Loong
	 * @title :getMetaInfoChildExamType
	 * @Description: 获取检查子类型元数据列表
	 * @return TMsgResponse<List<TMetaInfoExamType>>
	 * @date 2016年4月8日 下午4:35:52
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/child/exam/type/query" , method=RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoExamType>> getMetaInfoChildExamType(Locale locale, Integer parentId, Integer flag)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoExamType>> msg = new TMsgResponse<List<TMetaInfoExamType>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询元数据列表
			msg.result = metaInfoService.getMetaInfoChildExamType(parentId, flag);
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * @author Da Loong
	 * @title :getMetaInfoExamItemList
	 * @Description: 获取检查项目明细元数据列表
	 * @return TMsgResponse<List<TMetaInfoExamType>>
	 * @date 2016年4月8日 下午4:35:52
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/exam/item/list" , method=RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoExamItem>> getMetaInfoExamItemList(int examTypeId, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoExamItem>> msg = new TMsgResponse<List<TMetaInfoExamItem>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询元数据列表
			msg.result = metaInfoService.getMetaInfoExamItemList(examTypeId);
			
		
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * <p>Title:getMetaInfoDetectionUnit</p>
	 * <p>Description:获取检验数据使用的单位</p>
	 * @author YYCHEN
	 * @date 2016年11月17日 下午4:40:45
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/detection/unit" , method=RequestMethod.GET)
	public TMsgResponse<List<TMetaDetectionUnit>> getMetaInfoDetectionUnit(Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaDetectionUnit>> msg = new TMsgResponse<List<TMetaDetectionUnit>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询元数据列表
			msg.result = metaInfoService.getMetaInfoDetectionUnit();
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * @author Da Loong
	 * @title :getMetaInfoChildDetectionType
	 * @Description: 获取检验子类型元数据列表
	 * @return TMsgResponse<List<TMetaInfoDetectionType>>
	 * @date 2016年4月8日 下午4:35:52
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/child/detection/type/query" , method=RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoDetectionType>> getMetaInfoChildDetectionType(int parentId, Integer flag, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoDetectionType>> msg = new TMsgResponse<List<TMetaInfoDetectionType>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询元数据列表
			msg.result = metaInfoService.getMetaInfoChildDetectionType(parentId, flag);
			
		
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * @author Da Loong
	 * @title :getMetaInfoDetectionItemList
	 * @Description: 获取检验明细元数据列表
	 * @return TMsgResponse<List<TMetaInfoDetectionType>>
	 * @date 2016年4月8日 下午4:35:52
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/detection/item/list" , method=RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoDetectionItem>> getMetaInfoDetectionItemList(Integer detectionTypeId, Integer flag, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoDetectionItem>> msg = new TMsgResponse<List<TMetaInfoDetectionItem>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询元数据列表
			msg.result = metaInfoService.getMetaInfoDetectionItemList(detectionTypeId, flag);
			
		
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * @author Da Loong
	 * @title :getMetaSymptom
	 * @Description: 获取症状元数据列表
	 * @return TMsgResponse<List<TMetaInfoSymptom>>
	 * @date 2016年4月11日 下午4:35:52
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/symptoms/list" , method=RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoSymptom>> getMetaInfoSymptoms(Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoSymptom>> msg = new TMsgResponse<List<TMetaInfoSymptom>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询元数据列表
			msg.result = metaInfoService.getMetaInfoSymptoms();
			
		
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * @author Da Loong
	 * @title :getMetaTcmSymptom
	 * @Description: 获取中医症候元数据列表
	 * @return TMsgResponse<List<TMetaInfoTcmSymptom>>
	 * @date 2016年4月12日 下午4:35:52
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/symptoms/tcm/list" , method=RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoTcmSymptom>> getMetaInfoTcmSymptoms(Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoTcmSymptom>> msg = new TMsgResponse<List<TMetaInfoTcmSymptom>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询元数据列表
			msg.result = metaInfoService.getMetaInfoTcmSymptoms();
			
		
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * @author Da Loong
	 * @title :getMetaInfoQualityoflifeScale
	 * @Description: 获取生存质量元数据列表
	 * @return TMsgResponse<List<TMetaInfoQualityoflifeScale>>
	 * @date 2016年4月8日 下午4:35:52
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/qualityoflife/scale/item/list" , method=RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoQualityoflifeScaleItem>> getMetaInfoQualityoflifeScale(int scaleTypeId, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoQualityoflifeScaleItem>> msg = new TMsgResponse<List<TMetaInfoQualityoflifeScaleItem>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询元数据列表
			msg.result = metaInfoService.getMetaInfoQualityoflifeScale(scaleTypeId);
			
		
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * @author Da Loong
	 * @title :getMetaInfoTreatmentSchemeItemList
	 * @Description: 获取生存质量元数据列表
	 * @return TMsgResponse<List<TMetaInfoTreatmentScheme>>
	 * @date 2016年4月14日 下午2:25:52
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/treatment/scheme" , method=RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoTreatmentScheme>> getMetaInfoTreatmentSchemeList(Integer treatmentTypeId, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoTreatmentScheme>> msg = new TMsgResponse<List<TMetaInfoTreatmentScheme>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询元数据列表
			msg.result = metaInfoService.getMetaInfoTreatmentSchemeList(treatmentTypeId);
			
		
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * @author Da Loong
	 * @title :getMetaInfoTreatmentSchemeItemList
	 * @Description: 获取治疗方案对应药物明细元数据列表
	 * @return TMsgResponse<List<TMetaInfoMedicationType>>
	 * @date 2016年4月14日 下午3:55:52
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/treatment/scheme/item/list" , method=RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoMedicationItem>> getMetaInfoTreatmentSchemeItemList(int treatmentSchemeId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoMedicationItem>> msg = new TMsgResponse<List<TMetaInfoMedicationItem>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询元数据列表
			msg.result = metaInfoService.getMetaInfoTreatmentSchemeItemList(treatmentSchemeId );
			
		
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * @author Da Loong
	 * @title :getMetaInfoMedicationItemList
	 * @Description: 获取化疗/靶向药物明细元数据列表
	 * @return TMsgResponse<List<TMetaInfoMedicationType>>
	 * @date 2016年4月8日 下午4:35:52
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/medication/item/list" , method=RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoMedicationItem>> getMetaInfoMedicationItemList(Integer medicationType, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoMedicationItem>> msg = new TMsgResponse<List<TMetaInfoMedicationItem>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询元数据列表
			msg.result = metaInfoService.getMetaInfoMedicationItemList(medicationType);
			
		
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * @author Da Loong
	 * @title :getMetaInfoIcd9Cm3
	 * @Description: 获取手术元数据（ICD-9-Cm3)
	 * @return TMsgResponse<List<TMetaInfoAdverseReaction>>
	 * @date 2016年4月11日 下午4:35:52
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/icd9/cm3/list" , method=RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoIcd9Cm3>> getMetaInfoIcd9Cm3(Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoIcd9Cm3>> msg = new TMsgResponse<List<TMetaInfoIcd9Cm3>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询元数据列表
			msg.result = metaInfoService.getMetaInfoIcd9Cm3();
			
		
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * @author Da Loong
	 * @title :getMetaAdverseReaction
	 * @Description: 获取不良反应元数据列表
	 * @return TMsgResponse<List<TMetaInfoAdverseReaction>>
	 * @date 2016年4月11日 下午4:35:52
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/adverse/reaction/list" , method=RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoAdverseReaction>> getMetaInfoAdverseReaction(Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoAdverseReaction>> msg = new TMsgResponse<List<TMetaInfoAdverseReaction>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询元数据列表
			msg.result = metaInfoService.getMetaInfoAdverseReaction();
			
		
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 获取诊断分期元数据接口
	 * @author lichenghao
	 * @title :getMetaInfoDiagnosisPeriodization
	 * @Description:TODO
	 * @return TMsgResponse<List<TMetaDiagnosisPeriodization>>
	 * @date 2016年5月24日 上午11:45:05
	 */
	@ResponseBody
	@RequestMapping(value="/metainfo/disagnosis/periodization/list" , method=RequestMethod.GET)
	public TMsgResponse<List<TMetaDiagnosisPeriodization>> getMetaInfoDiagnosisPeriodization(String timeFlag,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaDiagnosisPeriodization>> msg = new TMsgResponse<List<TMetaDiagnosisPeriodization>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询元数据列表
			msg.result = metaInfoService.getMetaInfoDiagnosisPeriodization(timeFlag);
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/metainfo/icdo3/list" , method=RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoICDO3>> listMetaInfoIcdO3(String timeFlag,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoICDO3>> msg = new TMsgResponse<List<TMetaInfoICDO3>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询元数据列表
			msg.result = metaInfoService.listMetaInfoIcdO3(timeFlag);
		}
		catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * <p>Title:listMetaInfoIcdOAll</p>
	 * <p>Description:查询ICD-O器官元数据列表</p>
	 * @author YYCHEN
	 * @date 2016年6月16日 上午10:12:29
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/metainfo/icdo/all/list" , method = RequestMethod.GET)
	public TMsgResponse<List<MetaEIcdOParent>> listMetaInfoIcdOAll(Integer reqFlag,Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<MetaEIcdOParent>> msg = new TMsgResponse<List<MetaEIcdOParent>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			//查询器官元数据
			msg.result = metaInfoService.getMetaInfoIcdOAll(reqFlag);
		}catch(Exception ex){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			msg.setErrorDesc(ex.getMessage());
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * <p>Title:listMetaInfoDiagnosisPeriodization</p>
	 * <p>Description:获取诊断分期元数据</p>
	 * @author YYCHEN
	 * @date 2016年6月22日 下午2:25:56
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/metainfo/diagnosis/periodization/list" , method = RequestMethod.GET)
	public TMsgResponse<List<TDiagnosisPeriodizationInfo>> listMetaInfoDiagnosisPeriodization(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<TDiagnosisPeriodizationInfo>> msgResponse = new TMsgResponse<List<TDiagnosisPeriodizationInfo>>();
		msgResponse.respCode=ErrorMessage.SUCCESS.code;
		msgResponse.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			//查询器官元数据
			msgResponse.result = metaInfoService.getMetaInfoDiagnosisPeriodizationAll();
		}catch(Exception ex){
			//设置错误代码及提示消息
			msgResponse.respCode=ErrorMessage.E1500.code;
			msgResponse.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			msgResponse.setErrorDesc(ex.getMessage());
			LogUtil.logError.error(ex.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * <p>Title:getMetaInfoTreatmentTypeList</p>
	 * <p>Description:获取治疗类型元数据</p>
	 * @author YYCHEN
	 * @date 2016年6月22日 下午2:38:41
	 * @param locale
	 * @param flag
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/metainfo/treatment/type/list" , method = RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoTreatmentType>> getMetaInfoTreatmentTypeList(Locale locale, Integer flag,Integer showFlag,String treatmentTypeName){
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoTreatmentType>> msgResponse = new TMsgResponse<List<TMetaInfoTreatmentType>>();
		msgResponse.respCode=ErrorMessage.SUCCESS.code;
		msgResponse.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			//查询器官元数据
			msgResponse.result = metaInfoService.getMetaInfoTreatmentTypeList(flag,showFlag,treatmentTypeName);
		}catch(Exception ex){
			//设置错误代码及提示消息
			msgResponse.respCode=ErrorMessage.E1500.code;
			msgResponse.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			msgResponse.setErrorDesc(ex.getMessage());
			LogUtil.logError.error(ex.getMessage());
		}
		return msgResponse;
	}
	@ResponseBody
	@RequestMapping(value = "/metainfo/diseasetype/icd/page/query" , method = RequestMethod.POST)
	public TMsgResponse<Page<TMetaInfoDiseaseTypeIcd>> queryMetaInfoDiseaseTypeIcdPageList(Locale locale,@RequestBody(required=false) TMetaDiseaseTypeIcdListReq req){
		//设置返回成功代码及提示消息
		TMsgResponse<Page<TMetaInfoDiseaseTypeIcd>> msgResponse = new TMsgResponse<Page<TMetaInfoDiseaseTypeIcd>>();
		msgResponse.respCode=ErrorMessage.SUCCESS.code;
		msgResponse.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			msgResponse.result = metaInfoService.queryMetaInfoDiseaseTypeIcdPageList(req);
		}catch(Exception ex){
			//设置错误代码及提示消息
			msgResponse.respCode=ErrorMessage.E1500.code;
			msgResponse.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			msgResponse.setErrorDesc(ex.getMessage());
			LogUtil.logError.error(ex.getMessage());
		}
		return msgResponse;
	}
	@ResponseBody
	@RequestMapping(value = "/metainfo/diseasetype/icd/query" , method = RequestMethod.POST)
	public TMsgResponse<List<TMetaInfoDiseaseTypeIcd>> queryMetaInfoDiseaseTypeIcdList(Locale locale,@RequestBody(required=false) TMetaDiseaseTypeIcdListReq req){
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoDiseaseTypeIcd>> msgResponse = new TMsgResponse<List<TMetaInfoDiseaseTypeIcd>>();
		msgResponse.respCode=ErrorMessage.SUCCESS.code;
		msgResponse.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			msgResponse.result = metaInfoService.queryMetaInfoDiseaseTypeIcdList(req);
		}catch(Exception ex){
			//设置错误代码及提示消息
			msgResponse.respCode=ErrorMessage.E1500.code;
			msgResponse.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			msgResponse.setErrorDesc(ex.getMessage());
			LogUtil.logError.error(ex.getMessage());
		}
		return msgResponse;
	}
	@ResponseBody
	@RequestMapping(value="/metainfo/icd10/search" , method=RequestMethod.POST)
	public TMsgResponse<Page<MetaEicd10>> searchMetaInfoIcd10(@RequestBody(required=false) TMetaInfoIcd10Req req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page<MetaEicd10>> msg = new TMsgResponse<Page<MetaEicd10>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			msg.result = metaInfoService.searchMetaInfoIcd10(req);
		}catch(Exception ex)
		{
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}

