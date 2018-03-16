package com.esuizhen.cloudservice.ehr.controller.inhospital;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.bean.PatientInHospitalNoteListReq;
import com.esuizhen.cloudservice.ehr.bean.TInhospitalInfo;
import com.esuizhen.cloudservice.ehr.model.inhospital.InhospitalTurnRecord;
import com.esuizhen.cloudservice.ehr.service.inhospital.InhospitalService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class InhospitalController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private InhospitalService inhospitalService;
	
	/**
	 * 获取患者住院信息
	 * @author lichenghao
	 * @title :getPatienInhospitalList
	 * @Description:TODO
	 * @return TMsgResponse<List<TInhospitalInfo>>
	 * @date 2016年5月18日 下午2:43:34
	 */
	@ResponseBody
	@RequestMapping(value="/inhospitalnote/list" , method=RequestMethod.GET)
	public TMsgResponse<Page<TInhospitalInfo>> getPatienInhospitalList(PatientInHospitalNoteListReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page<TInhospitalInfo>> msg = new TMsgResponse<Page<TInhospitalInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			msg.result = inhospitalService.getPatienInhospitalList(req);
		}catch(Exception ex)
		{
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 转科情况添加功能
	 * 
	 * @author zhuguo
	 * @date 2017-10-09 17:49:05
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/inhospital/turn/record/add", method = RequestMethod.POST)
	public TMsgResponse<Integer> addInhospitalTurnRecord(
			@RequestBody List<InhospitalTurnRecord> req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Integer> msg = new TMsgResponse<Integer>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null,
				locale);
		try {
			msg.result = inhospitalService.addInhospitalTurnRecord(req);
			if (msg.result == 0) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info,
						null, locale);
			}
		} catch (Exception ex) {
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info,
					null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 转科情况删除功能
	 * 
	 * @author zhuguo
	 * @date 2017-10-09 17:49:05
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/inhospital/turn/record/del", method = RequestMethod.POST)
	public TMsgResponse<Integer> delInhospitalTurnRecord(
			@RequestBody List<InhospitalTurnRecord> req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Integer> msg = new TMsgResponse<Integer>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null,
				locale);
		try {
			msg.result = inhospitalService.delInhospitalTurnRecord(req);
			if (msg.result == 0) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info,
						null, locale);
			}
		} catch (Exception ex) {
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info,
					null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 转科情况查询功能
	 * 
	 * @author zhuguo
	 * @date 2017-10-09 17:49:05
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/inhospital/turn/record/query", method = RequestMethod.POST)
	public TMsgResponse<List<InhospitalTurnRecord>> queryInhospitalTurnRecord(
			@RequestBody InhospitalTurnRecord req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<InhospitalTurnRecord>> msg = new TMsgResponse<List<InhospitalTurnRecord>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null,
				locale);
		try {
			msg.result = inhospitalService.queryInhospitalTurnRecord(req);
		} catch (Exception ex) {
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info,
					null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}
