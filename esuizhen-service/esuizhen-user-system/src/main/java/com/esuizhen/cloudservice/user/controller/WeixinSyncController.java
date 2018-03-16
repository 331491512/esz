package com.esuizhen.cloudservice.user.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.user.bean.TWeixinSyncDiseaseInfo;
import com.esuizhen.cloudservice.user.bean.TWeixinSyncPatientInfo;
import com.esuizhen.cloudservice.user.bean.TWeixinSyncRelationInfo;
import com.esuizhen.cloudservice.user.service.WeixinSyncService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
 * 
* @ClassName: WeixinSyncController 
* @Description: 微信同步 
* @author LIPENG
* @date 2016年2月25日 下午2:56:46 
*
 */
@Controller
public class WeixinSyncController {
	@Autowired
	private WeixinSyncService syncService;
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * 
	* @Title: syncPatient 
	* @Description: 同步用户信息 
	* @param @param user
	* @param @return    设定文件 
	* @return TMsgResponse<Void>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/weixin/sync/patient", method=RequestMethod.POST)
	public TMsgResponse<Void> syncPatient(@RequestBody TWeixinSyncPatientInfo patientInfo, Locale locale)
	{
		LogUtil.log.info("登录微信同步患者(syncPatient)==========>>");
		TMsgResponse<Void> msgResponse = new TMsgResponse<Void>();
		try {
			msgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));						
			syncService.syncPatient(patientInfo);
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
	* @Title: syncDisease 
	* @Description: 同步疾病信息 
	* @param @param user
	* @param @return    设定文件 
	* @return TMsgResponse<Void>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/weixin/sync/disease", method=RequestMethod.POST)
	public TMsgResponse<Void> syncDisease(@RequestBody TWeixinSyncDiseaseInfo diseaseInfo, Locale locale)
	{
		LogUtil.log.info("登录微信同步患者疾病(syncPatient)==========>>");
		TMsgResponse<Void> msgResponse = new TMsgResponse<Void>();
		try {
			msgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));			
			syncService.syncDisease(diseaseInfo);
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
	* @Title: syncRelation 
	* @Description: 建立医患关系 
	* @param @param patientOpenId
	* @param @param doctorTicket
	* @param @return    设定文件 
	* @return TMsgResponse<Void>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/weixin/sync/relation", method=RequestMethod.POST)
	public TMsgResponse<Void> syncRelation(@RequestBody TWeixinSyncRelationInfo relationInfo, Locale locale)
	{
		LogUtil.log.info("登录微信同步医患关系(syncPatient)==========>>");
		TMsgResponse<Void> msgResponse = new TMsgResponse<Void>();
		try {
			msgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));			
			syncService.syncRelation(relationInfo);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			msgResponse.setRespCode(ErrorMessage.E1500.getCode());
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msgResponse.setErrorDesc(ex.getMessage());
		}
		return msgResponse;
	}
}
