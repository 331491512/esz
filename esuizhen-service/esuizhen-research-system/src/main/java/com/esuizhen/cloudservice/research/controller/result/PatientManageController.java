package com.esuizhen.cloudservice.research.controller.result;

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

import com.esuizhen.cloudservice.research.bean.FollowupRecordInfo;
import com.esuizhen.cloudservice.research.bean.PatientsAdvancedSearchReq;
import com.esuizhen.cloudservice.research.bean.PatientsInProjectSearchReq;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TProjectInvitationPatient;
import com.esuizhen.cloudservice.research.service.result.FollowupResultService;
import com.esuizhen.cloudservice.research.service.result.PatientManageService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.sms.SmsSendReportInfo;
import com.westangel.common.excption.DisableExcption;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.excption.TimeTooShortException;
import com.westangel.common.util.LogUtil;

/**
 * <p>Title:PatientController</p>
 * <p>Description:患者管理业务控制器</p>
 * @author YYCHEN
 * @date 2016年5月30日 下午3:11:07
 */
@Controller
public class PatientManageController {
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private PatientManageService patientManageService;
	@Autowired
	private FollowupResultService followupResultService;

	/**
	 * <p>Title:searchInProjectPatients</p>
	 * <p>Description:专题内患者筛选</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午3:10:24
	 * @param locale
	 * @param patientsInProjectSearchReq
	 * @return
	 */
	@RequestMapping(value = "/patients/in/project/search", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Page<PatientSimpleInfo>> searchInProjectPatients(Locale locale, @RequestBody PatientsInProjectSearchReq patientsInProjectSearchReq) {
		LogUtil.log.info("专题内患者筛选(searchInProjectPatients)==========>>");
		TMsgResponse<Page<PatientSimpleInfo>> tMsgResponse = new TMsgResponse<Page<PatientSimpleInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(this.patientManageService.searchInProjectPatients(patientsInProjectSearchReq));
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:searchUnselectedPatients</p>
	 * <p>Description:未入组患者筛选</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午5:20:01
	 * @param locale
	 * @param unselectedPatientsSearchReq
	 * @return
	 */
	@RequestMapping(value = "/patients/unselected/search", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Page<PatientSimpleInfo>> searchUnselectedPatients(Locale locale, @RequestBody PatientsAdvancedSearchReq patientsAdvancedSearchReq) {
		LogUtil.log.info("未入组患者筛选(searchUnselectedPatients)==========>>");
		TMsgResponse<Page<PatientSimpleInfo>> tMsgResponse = new TMsgResponse<Page<PatientSimpleInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Page<PatientSimpleInfo> data = this.patientManageService.searchUnselectedPatients(patientsAdvancedSearchReq);
			if (data == null || data.getDataList() == null || data.getDataList().isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				tMsgResponse.setResult(data);
			}
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage(),ex);
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:addPendingPatientsToProject</p>
	 * <p>Description:待入组患者添加</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午5:21:28
	 * @param locale
	 * @param unselectedPatientsSearchReq
	 * @return
	 */
	@RequestMapping(value = "/patients/pending/into/project/add", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> addPendingPatientsToProject(Locale locale, @RequestBody TCrfResultMainInfo<List<PatientSimpleInfo>> crfResultMainInfo) {
		LogUtil.log.info("待入组患者添加(addPendingPatientsToProject)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.patientManageService.addPendingPatientsToProject(crfResultMainInfo);
		} catch(TimeTooShortException ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1703.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1703.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(DisableExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1702.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1702.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(ParameterCannotBeNullException ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(ObjectNotAvailableExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(RejectRequestExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1700.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1700.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	@RequestMapping(value = "/crf/project/patients/delete", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> deleteProjectPatients(Locale locale, @RequestBody TCrfResultMainInfo<List<PatientSimpleInfo>> crfResultMainInfo) {
		LogUtil.log.info("删除入组患者(deleteProjectPatients)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.patientManageService.deleteProjectPatients(crfResultMainInfo);
		} catch(ParameterCannotBeNullException ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	@RequestMapping(value = "/stay/patients/search", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<Page<PatientSimpleInfo>> searchStayPatientList(Locale locale, String projectId, Long subcenterId, Integer state, Long doctorId, Integer page, Integer num) {
		LogUtil.log.info("待入组患者列表(searchStayPatientList)==========>>");
		TMsgResponse<Page<PatientSimpleInfo>> tMsgResponse = new TMsgResponse<Page<PatientSimpleInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Page<PatientSimpleInfo> dataList = this.patientManageService.searchStayPatientList(projectId, subcenterId, state, doctorId, page, num);
			if (dataList == null || dataList.getDataList() == null || dataList.getDataList().isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				tMsgResponse.setResult(dataList);
			}
		} catch(ParameterCannotBeNullException ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:joinPatientsToProject</p>
	 * <p>Description:待入组患者添加为正式患者</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午5:25:30
	 * @param locale
	 * @param crfResultMainInfo
	 * @return
	 */
	@RequestMapping(value = "/patients/into/project/join", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> joinPatientsToProject(Locale locale, @RequestBody TCrfResultMainInfo<List<PatientSimpleInfo>> crfResultMainInfo) {
		LogUtil.log.info("待入组患者添加为正式患者(joinPatientsToProject)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.patientManageService.joinPatientsToProject(crfResultMainInfo);
		} catch(DisableExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1702.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1702.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(RejectRequestExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:deletePendingPatients</p>
	 * <p>Description:将选择的待入组患者删除</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午5:26:44
	 * @param locale
	 * @param crfResultMainInfo
	 * @return
	 */
	@RequestMapping(value = "/crf/pending/patients/delete", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> deletePendingPatients(Locale locale, @RequestBody TCrfResultMainInfo<List<PatientSimpleInfo>> crfResultMainInfo) {
		LogUtil.log.info("将选择的待入组患者删除(deletePendingPatients)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.patientManageService.deletePendingPatients(crfResultMainInfo);
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	@RequestMapping(value = "/invitation/patient/sms/send/state/receipt", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> receiptInvitaionPatientSmsState(Locale locale, @RequestBody Map<String, List<SmsSendReportInfo>> data) {
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.patientManageService.receiptInvitaionPatientSmsState(data);
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:patientFollowupRecordList</p>
	 * <p>Description:获取患者随访记录，查看患者随访的历史记录</p>
	 * @author YYCHEN
	 * @date 2016年6月24日 上午10:18:24
	 * @param locale
	 * @param projectId
	 * @param patientId
	 * @param page
	 * @param num
	 * @param orderBy
	 * @param orderType
	 * @return
	 */
	@RequestMapping(value = "/crf/patient/followup/record/list/search", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<Page<FollowupRecordInfo>> patientFollowupRecordList(Locale locale, String projectId, Long patientId, Integer page, Integer num, String orderBy, String orderType) {
		LogUtil.log.info("获取患者随访记录，查看患者随访的历史记录(patientFollowupRecordList)==========>>");
		TMsgResponse<Page<FollowupRecordInfo>> tMsgResponse = new TMsgResponse<Page<FollowupRecordInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(this.followupResultService.followupRecordList(patientId, page, num, orderBy, orderType));
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	@RequestMapping(value = "/crf/patient/info", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<PatientSimpleInfo> getPatientInfo(Locale locale, String projectId, Long patientId) {
		LogUtil.log.info("获取患者简要信息(getPatientInfo)==========>>");
		TMsgResponse<PatientSimpleInfo> tMsgResponse = new TMsgResponse<PatientSimpleInfo>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(this.patientManageService.getPatientInfo(projectId, patientId));
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:confirmJoinProjectOfPatient</p>
	 * <p>Description:患者确认进入专题的邀请</p>
	 * @author YYCHEN
	 * @date 2016年10月21日 下午4:09:11
	 * @param locale
	 * @param projectId
	 * @param doctorId
	 * @param patientId
	 * @param state
	 * @param confirmSource
	 * @return
	 */
	@RequestMapping(value = "/crf/patient/confirm/join/project/request", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<Void> confirmJoinProjectOfPatient(Locale locale, String projectId, Long subcenterId, String groupId, Long doctorId, Long patientId, Integer state, Integer confirmSource) {
		LogUtil.log.info("获取患者简要信息(getPatientInfo)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.patientManageService.confirmJoinProjectOfPatient(projectId, subcenterId, groupId, doctorId, patientId, state, confirmSource);
		} catch(ParameterCannotBeNullException ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

	@RequestMapping(value = "/join/project/invitation/content/get", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<TProjectInvitationPatient> getInvitationContent(Locale locale, String projectId, Long doctorId, Long patientId, Long subcenterId, String groupId) {
		LogUtil.log.info("获取医生发送的邀请患者进入专题的信息(getInvitationContent)==========>>");
		TMsgResponse<TProjectInvitationPatient> tMsgResponse = new TMsgResponse<TProjectInvitationPatient>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(this.patientManageService.getInvitationContent(projectId, subcenterId, groupId, doctorId, patientId));
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
}
