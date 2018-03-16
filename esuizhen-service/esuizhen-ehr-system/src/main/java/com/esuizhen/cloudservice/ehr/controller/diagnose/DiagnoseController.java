package com.esuizhen.cloudservice.ehr.controller.diagnose;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.bean.PatientDiagnosisListReq;
import com.esuizhen.cloudservice.ehr.bean.TDiagnose;
import com.esuizhen.cloudservice.ehr.model.diagnose.PatientDiagnosisInfoReq;
import com.esuizhen.cloudservice.ehr.model.diagnose.TDiagnosisInfo;
import com.esuizhen.cloudservice.ehr.service.common.CommonService;
import com.esuizhen.cloudservice.ehr.service.diagnose.DiagnoseService;
import com.esuizhen.cloudservice.ehr.service.diagnose.TDiagnosisInfoService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.PatientDiagnosisReq;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

@Controller
public class DiagnoseController {
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TDiagnosisInfoService<TDiagnosisInfo> diagnosisInfoService;
	
	@Autowired
	private DiagnoseService diagnoseService;
	
	@Autowired
	@Qualifier("diagnosisInfoService")
	private CommonService<TDiagnosisInfo> commonService;
	
	/**
	 * 患者诊断信息查询
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/diagnosis/query" , method=RequestMethod.POST)
	public TMsgResponse<List<TDiagnosisInfo>> queryDiagnosis(@RequestBody PatientDiagnosisInfoReq req , Locale locale)
	{
		List<TDiagnosisInfo> diagnosisList = new ArrayList<TDiagnosisInfo>();
		//设置返回成功代码及提示消息
		TMsgResponse<List<TDiagnosisInfo>> msg = new TMsgResponse<List<TDiagnosisInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			List<TDiagnosisInfo> diagnosisInfoList = commonService.query(req);
			if(diagnosisInfoList == null || diagnosisInfoList.size() == 0) {
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}else {
				boolean flag = true;
				for(TDiagnosisInfo d : diagnosisInfoList) {
					Integer diagnosisTypeId = d.getDiagnosisTypeId();
					if(diagnosisTypeId != null && diagnosisTypeId == 1 && flag) {
						flag=false;
					}else {
						if(diagnosisTypeId != null && diagnosisTypeId == 1) {
							d.setDiagnosisTypeId(2);
						}
					}
					diagnosisList.add(d);
				}
			}
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		msg.result = diagnosisList;
		return msg;
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/diagnosis/save" , method=RequestMethod.POST)
	public TMsgResponse<List<String>> saveDiagnosis(@RequestBody List<TDiagnosisInfo> diagnosises,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<String>> msg = new TMsgResponse<List<String>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			if(diagnosises == null || diagnosises.size() == 0) {
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}else {
				//修改
				CommonReq req = new CommonReq();
				req.setPatientId(diagnosises.get(0).getPatientId());
				req.setSpecialDiseaseRegisterId(diagnosises.get(0).getSpecialDiseaseRegisterId());
				req.setOperateFlag(diagnosises.get(0).getOperateFlag());
				Map<String,Object> resultMap = commonService.save(req, diagnosises);
				if(resultMap != null) {
					if((Integer)resultMap.get("resCode") == 0) {
						msg.respCode=ErrorMessage.E1404.code;
						msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
					}else {
						msg.result = (List<String>)resultMap.get("emptyDiagnosisIdList");
					}
				}
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
	@RequestMapping(value="/patient/diagnosis/list" , method=RequestMethod.GET)
	public TMsgResponse<Page<TDiagnose>> getPatientDiagnosisList(PatientDiagnosisListReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page<TDiagnose>> msg = new TMsgResponse<Page<TDiagnose>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			msg.result = diagnoseService.getPatientDiagnosisList(req);
		}catch(Exception ex)
		{
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 添加患者诊断
	 * @author lichenghao
	 * @title :addPatientDiagnosis
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2016年5月24日 下午3:03:26
	 */
	@ResponseBody
	@RequestMapping(value="/patient/diagnosis/add",method=RequestMethod.POST)
	public TMsgResponse<Object> addPatientDiagnosis (@RequestBody PatientDiagnosisReq req,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			diagnoseService.createPatientDiagnosis(req);
		}catch(EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause()+"\t"+ex.getMessage());
			msg.respCode=ErrorMessage.E1419.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1419.info, null, locale);
		}catch(EmptyObjectExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1417.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
		}
		catch(Exception ex){
			LogUtil.logError.error(ex.getCause()+"\t"+ex.getMessage());
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
		}
		return msg;
	}
	
	/**
	 * 修改患者诊断
	 * @author lichenghao
	 * @title :modifyPatientDiagnosis
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2016年5月24日 下午3:03:48
	 */
	@ResponseBody
	@RequestMapping(value="/patient/diagnosis/modify",method=RequestMethod.POST)
	public TMsgResponse<Object> modifyPatientDiagnosis (@RequestBody PatientDiagnosisReq req,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			diagnoseService.modifyPatientDiagnosis(req);
		}catch(EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause()+"\t"+ex.getMessage());
			msg.respCode=ErrorMessage.E1419.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1419.info, null, locale);
		}catch(EmptyObjectExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1417.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
		}catch(Exception ex){
			LogUtil.logError.error(ex.getCause()+"\t"+ex.getMessage());
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
		}
		return msg;
	}
	
	
	/**
	 * 删除患者诊断信息
	 * @author lichenghao
	 * @title :delPatientDiagnosis
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2016年5月18日 下午2:43:45
	 */
	@ResponseBody
	@RequestMapping(value="/patient/diagnosis/delete",method=RequestMethod.POST)
	public TMsgResponse<Object> delPatientDiagnosis(@RequestBody PatientDiagnosisReq req,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			diagnoseService.delPatientDiagnosis(req);
		}
		catch(EmptyParamExcption e){
			msg.respCode=ErrorMessage.E1419.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1419.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		catch(EmptyObjectExcption e){
			msg.respCode=ErrorMessage.E1404.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		catch(Exception e){
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
}
