package com.esuizhen.cloudservice.user.controller.followuppatient;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.user.bean.followuppatient.PatientConfirmedDateReq;
import com.esuizhen.cloudservice.user.bean.followuppatient.PatientSeniorScreenReq;
import com.esuizhen.cloudservice.user.bean.followuppatient.TPatientSearchInfo;
import com.esuizhen.cloudservice.user.bean.followuppatient.TwiceSearchReq;
import com.esuizhen.cloudservice.user.model.followuppatient.FollowupPatientProfile;
import com.esuizhen.cloudservice.user.model.followuppatient.PatientCallBackInfo;
import com.esuizhen.cloudservice.user.service.PatientFamilyService;
import com.esuizhen.cloudservice.user.service.followuppatient.FollowupPatientService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.user.PatientFamily;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.search.RetrievalParamentUtil;

@Controller
public class FollowupPatientController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private FollowupPatientService patientFollowupService;
	
	
	@Autowired
	private PatientFamilyService patientFamilyService;
	/**
	 * 查询患者列表信息---预查询
	 * @param patientSearchInfo
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/patient/list",method=RequestMethod.POST)
	public TMsgResponse<Map<String,Object>> queryPatient(@RequestBody TPatientSearchInfo patientSearch,Locale locale) {
		TMsgResponse<Map<String,Object>> tMsgResponse = new TMsgResponse<Map<String,Object>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			long start = System.currentTimeMillis();
			patientSearch.setInterfaceName("/user/patient/list");
			int searchId = patientFollowupService.saveMiddlePatientSimpleInfo(patientSearch);
			long end = System.currentTimeMillis();
			long diff = (end - start) /1000l;
			LogUtil.log.info("预查询共花了：" + diff + "秒");
			
			start = System.currentTimeMillis();
			end = System.currentTimeMillis();
			diff = (end - start) /1000l;
			LogUtil.log.info("统计患者类型总数：" + diff + "秒");
			Map<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("searchId", searchId);
			tMsgResponse.setResult(resultMap);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 二次查询患者信息
	 * @param twiceSearchReq
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/patient/simple/list/search",method=RequestMethod.POST)
	public TMsgResponse<Page<PatientSimpleInfo>> getSearchPatientSimpleInfo(@RequestBody TwiceSearchReq twiceSearchReq,Locale locale) {
		TMsgResponse<Page<PatientSimpleInfo>> tMsgResponse = new TMsgResponse<Page<PatientSimpleInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			long start = System.currentTimeMillis();
			tMsgResponse.result = patientFollowupService.searchPatientSimpleInfoList(twiceSearchReq);
			long end = System.currentTimeMillis();
			long diff = (end - start) /1000l;
			LogUtil.log.info("二次查询所有患者===>：" + diff + "秒");
			if(tMsgResponse.result.getDataList() == null)
			{
				tMsgResponse.respCode=ErrorMessage.E1404.code;
				tMsgResponse.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 查询患者详细信息及患者家属信息
	 * @param patientId
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/patient/detail/query",method=RequestMethod.GET)
	public TMsgResponse<FollowupPatientProfile> queryPatientDetail(Long  patientId,HttpServletRequest request,Locale locale) {
		TMsgResponse<FollowupPatientProfile> tMsgResponse = new TMsgResponse<FollowupPatientProfile>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.result = patientFollowupService.getPatientProfileAndFimilyById(patientId,null);
			if(tMsgResponse.result == null)
			{
				tMsgResponse.respCode=ErrorMessage.E1404.code;
				tMsgResponse.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 更新患者信息以及患者家属信息
	 * @param patientProfile
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/patient/detail/update",method=RequestMethod.POST)
	public TMsgResponse<Integer> updatePatient(@RequestBody FollowupPatientProfile  patientProfile,Locale locale) {
		TMsgResponse<Integer> tMsgResponse = new TMsgResponse<Integer>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.result = patientFollowupService.savePatientAndFamily(patientProfile);
			if(tMsgResponse.result == null || tMsgResponse.result == 0)
			{
				tMsgResponse.respCode=ErrorMessage.E1404.code;
				tMsgResponse.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	@ResponseBody
	@RequestMapping(value = "/contact/phone/status/modify", method = RequestMethod.POST)
	public TMsgResponse<Integer> modifyUserContactPhoneStatus(@RequestBody PatientFamily patientFamily, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Integer> msg = new TMsgResponse<Integer>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			switch (patientFamily.getPhoneStatus()) {
			case 7:
			case 10:
			case 11:
			case 12:
			case 13:
			case 14:
				patientFamily.setIsValid(1);
				break;
			case 8:
			case 9:
				patientFamily.setIsValid(0);
				break;
			}
			msg.result=patientFamilyService.update(patientFamily);
			if(msg.result == 0) {
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "/patient/callback/info/list", method = RequestMethod.GET)
	public TMsgResponse<List<PatientCallBackInfo>> queryPatientCallBackInfo(String phone,Locale locale) {
		TMsgResponse<List<PatientCallBackInfo>> tMsgResponse = new TMsgResponse<List<PatientCallBackInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.result = patientFollowupService.queryPatientCallBackInfo(phone);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 患者高级筛选
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/patient/senior/screen/query",method=RequestMethod.POST)
	public TMsgResponse<Map<String,Object>> queryPatientSeniorScreen(@RequestBody PatientSeniorScreenReq req,Locale locale){
		TMsgResponse<Map<String,Object>> tMsgResponse = new TMsgResponse<Map<String,Object>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			if (req.getOperator() == null)
				throw new EmptyParamExcption("param error operator is null");
			if (req.getParaments() == null)
				throw new EmptyParamExcption("param error paraments is null");
			long start = System.currentTimeMillis();
			TPatientSearchInfo info=new TPatientSearchInfo();
			info.setSql(RetrievalParamentUtil.loadingParaments(req.getParaments()));
			info.setFollowupFlag(req.getFollowupFlag());
			info.setOperator(req.getOperator());
			info.setInterfaceName("/user/patient/list");
			info.setUserRole(req.getUserRole());
			info.setHospitalId(req.getHospitalId());
			info.setCatalogState(req.getCatalogState());
			info.setCatalogWithUpdate(req.getCatalogWithUpdate());
			int searchId = patientFollowupService.saveMiddlePatientSimpleInfo(info);
			long end = System.currentTimeMillis();
			long diff = (end - start) /1000l;
			LogUtil.log.info("预查询共花了：" + diff + "秒");
			Map<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("searchId", searchId);
			tMsgResponse.setResult(resultMap);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 查询患者信息列表(用户系统使用)
	 * @param twiceSearchReq
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/patient/info/list/query",method=RequestMethod.POST)
	public TMsgResponse<Page<PatientSimpleInfo>> queryPatientInfoList(@RequestBody TwiceSearchReq twiceSearchReq,HttpServletRequest request,Locale locale) {
		TMsgResponse<Page<PatientSimpleInfo>> tMsgResponse = new TMsgResponse<Page<PatientSimpleInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			long start = System.currentTimeMillis();
			tMsgResponse.result = patientFollowupService.queryPatientInfoList(twiceSearchReq);
			LogUtil.log.info("设置dataId=" + twiceSearchReq.getDataId());
			HttpSession session = request.getSession();
			session.setAttribute("dataId", twiceSearchReq.getDataId());
			ServletContext context = session.getServletContext();
			context.setAttribute("session", session);
			long end = System.currentTimeMillis();
			long diff = (end - start) /1000l;
			LogUtil.log.info("二次查询所有患者===>：" + diff + "秒");
			if(tMsgResponse.result.getDataList() == null)
			{
				tMsgResponse.respCode=ErrorMessage.E1404.code;
				tMsgResponse.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 本次批量查询详情信息
	 * @author fanpanwei
	 * @param twiceSearchReq
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/patient/serach/detail/info",method=RequestMethod.POST)
	public TMsgResponse<HashMap<String,Object>> getSearchPatientDetailInfo(@RequestBody TwiceSearchReq twiceSearchReq,Locale locale) {
		TMsgResponse<HashMap<String,Object>> tMsgResponse = new TMsgResponse<HashMap<String,Object>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.result = patientFollowupService.dealBatchQueryDetailInfo(twiceSearchReq);
		} catch(EmptyParamExcption ex){
			HashMap<String,Object> resultMap = new HashMap<String, Object>();
			HashMap<String,Object> tempMap = new HashMap<String, Object>();
			resultMap.put("patientNoTotal",0);
			resultMap.put("repeatTotal",0);
			resultMap.put("noRecordTotal",0);
			resultMap.put("mergeTotal",0);
			resultMap.put("repeatList",tempMap);
			resultMap.put("noRecordList",tempMap);
			resultMap.put("mergeList",tempMap);
			tMsgResponse.result = resultMap;
		}catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 修改患者原发/初治确诊时间和状态
	 * @author zhuguo
	 */
	@ResponseBody
	@RequestMapping(value="/patient/confirmed/date/update",method=RequestMethod.POST)
	public TMsgResponse<Integer> patientConfirmedDateModify(@RequestBody PatientConfirmedDateReq req,Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Integer> msg = new TMsgResponse<Integer>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			msg.result=patientFollowupService.patientConfirmedDateModify(req);
			if(msg.result < 2) {
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}	
}
