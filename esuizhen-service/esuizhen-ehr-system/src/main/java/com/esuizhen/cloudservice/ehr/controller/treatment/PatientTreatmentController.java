package com.esuizhen.cloudservice.ehr.controller.treatment;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.model.treatment.ParentTreatmentInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.PatientTreatmentInfoReq;
import com.esuizhen.cloudservice.ehr.model.treatment.TPatientTreatmentInfo;
import com.esuizhen.cloudservice.ehr.service.common.CommonService;
import com.esuizhen.cloudservice.ehr.service.meta.MetaDataUserDefinedService;
import com.esuizhen.cloudservice.ehr.service.treatment.PatientTreatmentService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.UserDefinedMetaData;
import com.westangel.common.util.LogUtil;

@Controller
public class PatientTreatmentController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private PatientTreatmentService patientTreatmentService;
	
	@Autowired
	@Qualifier("treatmentService")
	private CommonService<TPatientTreatmentInfo> commonService;
	
	@Autowired
	private MetaDataUserDefinedService metaDataUserDefinedService;
	
	@ResponseBody
	@RequestMapping(value="/patient/treatment/query" , method=RequestMethod.POST)
	public TMsgResponse<List<TPatientTreatmentInfo>> queryPatientTreatment(@RequestBody PatientTreatmentInfoReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TPatientTreatmentInfo>> msg = new TMsgResponse<List<TPatientTreatmentInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = commonService.query(req);
			
			if(msg.result==null)
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
	
	
	@ResponseBody
	@RequestMapping(value="/patient/treatment/save" , method=RequestMethod.POST)
	public TMsgResponse<Map<String, Object>> savePatientTreatment(@RequestBody ParentTreatmentInfo treatmentInfo, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Map<String, Object>> msg = new TMsgResponse<Map<String, Object>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//保存
			if(treatmentInfo.getPatientTreatmentInfos() == null || treatmentInfo.getPatientTreatmentInfos().size() == 0) {
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
				return null;
			}
			Long operatorId = treatmentInfo.getOperatorId();
			CommonReq req = new CommonReq();
			req.setPatientId(treatmentInfo.getPatientId());
			req.setSpecialDiseaseRegisterId(treatmentInfo.getPatientTreatmentInfos().get(0).getSpecialDiseaseRegisterId());
			req.setOperateFlag(treatmentInfo.getOperateFlag());
			req.setOperatorId(operatorId);
			//add by fanpanwei更新化疗方案类型元数据信息
			List<TPatientTreatmentInfo> patientTreatmentInfos = treatmentInfo.getPatientTreatmentInfos();
			if(patientTreatmentInfos!=null){
				for (TPatientTreatmentInfo tPatientTreatmentInfo : patientTreatmentInfos) {
					if(tPatientTreatmentInfo==null)continue;
					if(StringUtils.isNotBlank(tPatientTreatmentInfo.getTreatmentName())){
						UserDefinedMetaData metaData=new UserDefinedMetaData();
						metaData.setCreator(operatorId);
						metaData.setMetaName(tPatientTreatmentInfo.getTreatmentName());
						metaData.setParentKey(tPatientTreatmentInfo.getTreatmentTypeId().toString());
						
						
						metaData.setMetaDataTable("ehr_db.meta_e_treatment_scheme");
						metaData.setMainKeyField("treatmentSchemeId");
						metaData.setMetaNameField("treatmentSchemeName");
						metaData.setParentKeyField("treatmentTypeId");
						metaData.setQueryCondition(" AND treatmentTypeId='"+tPatientTreatmentInfo.getTreatmentTypeId()+"'");
						this.metaDataUserDefinedService.addMetaDateInIntKey(metaData);
					}
				}
			}
			//更新业务数据
			Map<String, Object> resultMap = commonService.save(req, treatmentInfo.getPatientTreatmentInfos());
			msg.setResult(resultMap);
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 患者治疗明细保存
	 * @param treatmentInfo
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/patient/treatment/detail/save" , method=RequestMethod.POST)
	public TMsgResponse<String> savePatientTreatmentDetail(@RequestBody ParentTreatmentInfo treatmentInfo, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//保存
			if(treatmentInfo.getPatientTreatmentInfos() == null || treatmentInfo.getPatientTreatmentInfos().size() == 0) {
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
				return null;
			}
			treatmentInfo.getPatientTreatmentInfos().get(0).setPatientId(treatmentInfo.getPatientId());
			treatmentInfo.getPatientTreatmentInfos().get(0).setInhospitalId(treatmentInfo.getInhospitalId());
			treatmentInfo.getPatientTreatmentInfos().get(0).setClinicMedicalId(treatmentInfo.getClinicMedicalId());
			treatmentInfo.getPatientTreatmentInfos().get(0).setOperatorId(treatmentInfo.getOperatorId());
			String result = patientTreatmentService.savePatientTreatmentDetail(treatmentInfo.getPatientTreatmentInfos().get(0));
			msg.setResult(result);
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

