package com.esuizhen.cloudservice.ehr.controller.medical;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.bean.MedialRecordForwardReq;
import com.esuizhen.cloudservice.ehr.bean.medical.PatientMedicalRecordReq;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.EmedicalRecord;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.resp.MedialRecordUploadResp;
import com.esuizhen.cloudservice.ehr.service.medical.MedicalService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;
@Controller
public class MedicalController {
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private MedicalService medicalService; 
	
	@ResponseBody
	@RequestMapping(value="/upload" , method=RequestMethod.POST)
	public TMsgResponse<MedialRecordUploadResp> upload(@RequestBody EmedicalRecord emedicalRecord , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<MedialRecordUploadResp> msg = new TMsgResponse<MedialRecordUploadResp>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//病例上传
			msg.setResult(medicalService.insertEmedicalRecord(emedicalRecord));
		}catch(Exception ex)
		{
			ex.printStackTrace();
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * <p>Title:forwardMedicalRecord2Patient</p>
	 * <p>Description:将上传的病历转发给患者</p>
	 * @author YYCHEN
	 * @date 2016年12月1日 上午10:01:25
	 * @param locale
	 * @param medialRecordForwardReq
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/forward/to/patient" , method=RequestMethod.POST)
	public TMsgResponse<Object> forwardMedicalRecord2Patient(Locale locale, @RequestBody MedialRecordForwardReq medialRecordForwardReq)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//病例上传
			msg.setResult(medicalService.forwardMedicalRecord2Patient(medialRecordForwardReq));
		}catch(Exception ex)
		{
			ex.printStackTrace();
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/detail" , method=RequestMethod.GET)
	public TMsgResponse<EmedicalRecord> detail(String emrId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<EmedicalRecord> msg = new TMsgResponse<EmedicalRecord>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = medicalService.queryEmedicalRecordById(emrId);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/delete" , method=RequestMethod.GET)
	public TMsgResponse<String> delete(String emrId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//删除
			medicalService.deleteEmedicalRecord(emrId);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			//msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			msg.respMsg=messageSource.getMessage("delete.error", null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * @author wang_hw
	 * @title :medicalRecordBookList
	 * @Description:获取患者病例本
	 * @return TMsgResponse<Page<EmedicalRecord>>
	 * @date 2015年12月15日 下午4:39:35
	 */
	@ResponseBody
	@RequestMapping(value="/book/list" , method=RequestMethod.GET)
	public TMsgResponse<Page<EmedicalRecord>> medicalRecordBookList(Long userId , Integer role , Long patientId , Integer page , Integer num , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page<EmedicalRecord>> msg = new TMsgResponse<Page<EmedicalRecord>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//删除
			msg.result = medicalService.selectEmedicalRecordList(userId , role , patientId, page, num);
			
			if(msg.result==null)
			{//如果为空
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/modify" , method=RequestMethod.POST)
	public TMsgResponse<String> modify(@RequestBody EmedicalRecord emedicalRecord , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//修改电子病例
			medicalService.updateEmedicalRecord(emedicalRecord);
			msg.respMsg=messageSource.getMessage("save.success", null, locale);
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			//msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			msg.respMsg=messageSource.getMessage("save.error", null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/patient/medicalrecord/save" , method=RequestMethod.POST)
	public TMsgResponse<String> savePatientMedicalRecord(@RequestBody PatientMedicalRecordReq patientMedicalRecordReq , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//保存病案
			medicalService.savePatientMedicalRecord(patientMedicalRecordReq);
			msg.respMsg=messageSource.getMessage("save.success", null, locale);
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			//msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			msg.respMsg=messageSource.getMessage("save.error", null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}
