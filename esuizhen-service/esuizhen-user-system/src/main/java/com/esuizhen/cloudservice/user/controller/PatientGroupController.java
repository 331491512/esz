/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.controller;<br/>  
 * <b>文件名：</b>PatientGroupController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月23日上午10:37:27<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.user.bean.PatientGroupIdListReq;
import com.esuizhen.cloudservice.user.bean.PatientGroupMemberReq;
import com.esuizhen.cloudservice.user.service.PatientGroupService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.PatientGroup;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.RemoteCallExcption;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: PatientGroupController
* @Description: 患者分组controller
* @author lichenghao
* @date 2016年5月23日 上午10:37:27  
*/
@Controller
public class PatientGroupController {
	@Autowired
	private PatientGroupService patientGroupService;
	@Autowired
	private MessageSource messageSource;
	
	
	
	/**
	 * @Title: getPatientGroupList @Description: 查询患者分组 @param @return
	 * TMsgResponse<List<PatientGroup>> @throws
	 */
	@RequestMapping("/patient/group/list")
	@ResponseBody
	public TMsgResponse<List<PatientGroup>> getPatientGroupList(Long doctorId, Integer groupWay, Locale locale) {
		LogUtil.log.info("查询患者分组(getPatientGroupList)==========>>");
		TMsgResponse<List<PatientGroup>> tMsgResponse = new TMsgResponse<List<PatientGroup>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<PatientGroup> list = patientGroupService.getPatientGroupList(doctorId, groupWay);
			if (list != null) {
				tMsgResponse.setResult(list);
			} else {
				// 查询数据不存在
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			}
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return tMsgResponse;
	}

	/**
	 * @Title: getPatientGroupList @Description: 组内患者查询 @param @return
	 * TMsgResponse<List<PatientGroup>> @throws
	 */
	@RequestMapping("/patient/group/members/list")
	@ResponseBody
	public TMsgResponse<Page<PatientSimpleInfo>> getPatientGroupMembersList(PatientGroupIdListReq req, Locale locale) {
		LogUtil.log.info("组内患者查询(getPatientGroupMembersList)==========>>");
		TMsgResponse<Page<PatientSimpleInfo>> tMsgResponse = new TMsgResponse<Page<PatientSimpleInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Page<PatientSimpleInfo> list = patientGroupService.getPatientGroupMembersList(req);
			if (list != null) {
				tMsgResponse.setResult(list);
			} else {
				// 查询数据不存在
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			}
		} catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
		}catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return tMsgResponse;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :addPatientGroup
	 * @Description:添加患者自定义分组
	 * @return TMsgResponse<String>
	 * @date 2016年5月18日 下午6:30:31
	 */
	@ResponseBody
	@RequestMapping(value="/patient/group/add",method = RequestMethod.POST)
	public TMsgResponse<Object> addPatientGroup(@RequestBody PatientGroup patientGroup,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			msg.result = new HashMap<String, Object>();
			((Map<String,Object>)msg.result).put("groupNo", patientGroupService.addPatientGroup(patientGroup));
		}catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1400.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
		}catch(RemoteCallExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E140901.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E140901.info, null, locale));
		}catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :modifyPatientGroup
	 * @Description:修改医生自定义患者分组
	 * @return TMsgResponse<String>
	 * @date 2016年5月19日 上午9:48:37
	 */
	@ResponseBody
	@RequestMapping(value="/patient/group/modify",method = RequestMethod.POST)
	public TMsgResponse<String> modifyPatientGroup(@RequestBody PatientGroup patientGroup,Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			patientGroupService.updatePatientGroup(patientGroup);
		}catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1400.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
		}catch(EmptyObjectExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1417.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
		}catch(RemoteCallExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E140901.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E140901.info, null, locale));
		}catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}
	
	/**
	 * 删除患者分组
	 * @author lichenghao
	 * @title :deletePatientGroup
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2016年5月23日 上午11:04:42
	 */
	@ResponseBody
	@RequestMapping(value="/patient/group/delete",method = RequestMethod.POST)
	public TMsgResponse<String> deletePatientGroup(@RequestBody PatientGroup patientGroup,Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			patientGroupService.delPatientGroup(patientGroup);
		}catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1400.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
		}catch(EmptyObjectExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1417.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
		}catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}
	
	
	/**
	 * 医生关注患者
	 * @author lichenghao
	 * @title :focusPatientGroupDoctor
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2016年9月26日 下午12:06:26
	 */
	@ResponseBody
	@RequestMapping(value="/patient/group/doctor/focus",method = RequestMethod.POST)
	public TMsgResponse<Object> focusPatientGroupDoctor(@RequestBody PatientGroupMemberReq req,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			patientGroupService.focusPatientGroupDoctor(req);
		}catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1400.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
		}catch(RemoteCallExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E140901.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E140901.info, null, locale));
		}catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}
	/**
	 * 添加患者到组
	 * @author lichenghao
	 * @title :addPatientGroupMembers
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2016年5月23日 上午11:10:21
	 */
	@ResponseBody
	@RequestMapping(value="/patient/group/members/add",method=RequestMethod.POST)
	public TMsgResponse<String> addPatientGroupMembers(@RequestBody PatientGroupMemberReq req ,Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			patientGroupService.addPatientsToGroup(req);
		}catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1400.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
		}catch(EmptyObjectExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1417.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
		}catch(Exception ex){
			LogUtil.logError.error(ex.getCause() +"\t"+ex.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}
	
	/**
	 * 患者分组重置
	 * @author lichenghao
	 * @title :resetPatientInGroups
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2016年5月23日 上午11:13:00
	 */
	@ResponseBody
	@RequestMapping(value="/patient/in/groups/reset",method=RequestMethod.POST)
	public TMsgResponse<String> resetPatientInGroups(@RequestBody PatientGroupMemberReq req ,Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			patientGroupService.resetPatientToGroups(req);
		}catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1400.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
		}catch(EmptyObjectExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1417.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
		}catch(Exception ex){
			LogUtil.logError.error(ex.getCause() +"\t"+ex.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}
	
	/**
	 * 移除组内患者
	 * @author lichenghao
	 * @title :deletePatientGroupMembers
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2016年5月23日 上午11:36:05
	 */
	@ResponseBody
	@RequestMapping(value="/patient/group/members/delete",method=RequestMethod.POST)
	public TMsgResponse<String> deletePatientGroupMembers(@RequestBody PatientGroupMemberReq req ,Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			patientGroupService.deletePatientGroupMembers(req);
		}catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1400.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
		}catch(EmptyObjectExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1417.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
		}catch(Exception ex){
			LogUtil.logError.error(ex.getCause() +"\t"+ex.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}
	
	/**
	 * 获取患者所在分组
	 * @author lichenghao
	 * @title :deletePatientGroupMembers
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2016年5月23日 上午11:38:06
	 */
	@ResponseBody
	@RequestMapping(value="/patient/of/group/list",method=RequestMethod.GET)
	public TMsgResponse<List<PatientGroup>> getGroupOfPatient (PatientGroupMemberReq req ,Locale locale){
		TMsgResponse<List<PatientGroup>> msg = new TMsgResponse<List<PatientGroup>>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			msg.result = patientGroupService.getGroupOfPatient(req);
		}catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1400.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
		}catch(EmptyObjectExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1417.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
		}catch(Exception ex){
			LogUtil.logError.error(ex.getCause() +"\t"+ex.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}
	
	
	
}
