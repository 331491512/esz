/**
 * 
 */
package com.esuizhen.cloudservice.followup.controller.followuptask;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.esuizhen.cloudservice.followup.bean.FollowupTask;
import com.esuizhen.cloudservice.followup.bean.FollowupTaskOperatorAlloPatientReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskCreateReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskListByLeaderQueryReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskListByOperatorQueryReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskPatientListQueryReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskStopReq;
import com.esuizhen.cloudservice.followup.common.Constant;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupPatientInfo;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskDetailInfo;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskSimpleInfo;
import com.esuizhen.cloudservice.followup.service.export.FolloupTaskExportService;
import com.esuizhen.cloudservice.followup.service.followuptask.FollowupTaskService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
 * @author bigdragon
 * @date 2016/8/5
 * 
 */
@Controller
public class FollowupTaskController {

	/**
	 * 随访任务接口
	 */
	@Autowired
	private FollowupTaskService followupTaskService;

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private FolloupTaskExportService folloupTaskExportService;

	/**
	 * 2.1.1 随访任务查询(随访主任)
	 * 
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/task/query/byleader", method = RequestMethod.POST)
	public TMsgResponse<Page<TFollowupTaskSimpleInfo>> queryFollowupTaskListByLeader(@RequestBody TFollowupTaskListByLeaderQueryReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Page<TFollowupTaskSimpleInfo>> msg = new TMsgResponse<Page<TFollowupTaskSimpleInfo>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 随访任务查询
			msg.result = followupTaskService.queryFollowupTaskListByLeader(req);
			if (msg.result == null) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 2.1.2 随访任务查询(随访人员)
	 * FolloupTaskQueryByOperator
	 * 
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/task/query/byoperator", method = RequestMethod.POST)
	public TMsgResponse<Page<TFollowupTaskSimpleInfo>> queryFollowupTaskListByOperator(@RequestBody TFollowupTaskListByOperatorQueryReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Page<TFollowupTaskSimpleInfo>> msg = new TMsgResponse<Page<TFollowupTaskSimpleInfo>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 随访任务查询
			msg.result = followupTaskService.queryFollowupTaskListByOperator(req);
			if (msg.result == null) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 2.1.3 查看随访任务详情
	 * 
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/task/detail/query", method = RequestMethod.GET)
	public TMsgResponse<TFollowupTaskDetailInfo> queryFollowupTaskDetail(Long userId, String taskId, String assignId, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TFollowupTaskDetailInfo> msg = new TMsgResponse<TFollowupTaskDetailInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 查看随访任务详情
			msg.result = followupTaskService.queryFollowupTaskDetail(userId, taskId, assignId);
			if (msg.result == null) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 2.1.4 随访任务详情-患者列表
	 * FolloupTaskPatientList
	 * 
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/task/patient/list", method = RequestMethod.POST)
	public TMsgResponse<Page<TFollowupPatientInfo>> queryFollowupTaskPatientList(@RequestBody TFollowupTaskPatientListQueryReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Page<TFollowupPatientInfo>> msg = new TMsgResponse<Page<TFollowupPatientInfo>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 随访患者列表查询
			msg.result = followupTaskService.queryFollowupTaskPatientList(req);
			if (msg.result == null) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 2.1.5 随访任务创建/分配
	 * 
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "task/create", method = RequestMethod.POST)
	public TMsgResponse<String> createFollowupTask(@RequestBody TFollowupTaskCreateReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 任务分配
			if (1 == req.getIsLastFollowupControl()) {
				msg.result = followupTaskService.createFollowupTaskForLastFollowup(req);
			} else {
				msg.result = followupTaskService.createFollowupTask(req);
			}
			if (msg.result == null) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 2.1.7 随访任务终止
	 * 
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "task/stop", method = RequestMethod.POST)
	public TMsgResponse<Void> stopFollowupTask(@RequestBody TFollowupTaskStopReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Void> msg = new TMsgResponse<Void>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 任务分配
			boolean result = followupTaskService.stopFollowupTask(req);
			if (result == false) {
				msg.respCode = ErrorMessage.E1406.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1406.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 
	 * @author lichenghao
	 * @title 
	 *        :getMetaInfoFollowupTaskList
	 * @Description:2.5.4 随访任务元数据
	 * @return 
	 *         TMsgResponse<List<FollowupTask
	 *         >>
	 * @date 2016年9月14日 上午10:45:13
	 */
	@ResponseBody
	@RequestMapping(value = "/metainfo/followuptask/list", method = RequestMethod.GET)
	public TMsgResponse<List<FollowupTask>> getMetaInfoFollowupTaskList(Locale locale) {
		TMsgResponse<List<FollowupTask>> msg = new TMsgResponse<List<FollowupTask>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			msg.result = followupTaskService.getMetaInfoFollowupTaskList();
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 2.6.1 随访任务更新
	 * 
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/task/update", method = RequestMethod.POST)
	public TMsgResponse<String> updateFollowupTask(@RequestBody TFollowupTaskSimpleInfo req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 任务更新
			followupTaskService.updateFollowupTask(req);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 2.1.6 随访任务（及任务分配）跟随随访人员分配患者数列表
	 * 
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "task/operator/allo/patient/list", method = RequestMethod.POST)
	public TMsgResponse<List<HashMap<String, Object>>> createFollowupTaskOperatorAlloPatient(@RequestBody FollowupTaskOperatorAlloPatientReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String, Object>>> msg = new TMsgResponse<List<HashMap<String, Object>>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			if (req == null) {
				msg.respCode = ErrorMessage.E1400.code;
				msg.respMsg = "没有获取任何参数异常！";
				return msg;
			} else if (req.getSearchId() == null && (req.getPatientIdList() == null || req.getPatientIdList().size() == 0)) {
				msg.respCode = ErrorMessage.E1400.code;
				msg.respMsg = "SearchId和patientIdList不能同时为null";
				return msg;
			}
			msg.result = followupTaskService.getOperatorsFollowUpInfoByPatients(req);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 随访任务详情-导出随访任务。
	 * 
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/task/patient/detail/export", method = RequestMethod.POST)
	public TMsgResponse<String> exportFollowupTaskDetail(@RequestBody TFollowupTaskPatientListQueryReq req, HttpServletRequest request, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			Map<String, String> reqMap = new HashMap<String, String>();
			String patientNo = req.getPatientNo();
			String patientTrueName = req.getPatientTrueName();
			String phone = req.getPhone();
			String sourceDiagnosis = req.getSourceDiagnosis();
			LogUtil.log.info("主要诊断：sourceDiagnosis=" + sourceDiagnosis);
			List<Integer> state = req.getState();
			List<Integer> followupResultValue = req.getFollowupResultValue();
			StringBuffer paramsBuffer = new StringBuffer();
			paramsBuffer
					.append(" JOIN(SELECT t2.patientId FROM followup_db.r_followup_task_patient t1 JOIN user_db.u_patient t2 on t1.patientId=t2.patientId LEFT JOIN followup_db.followup_result t5 on t5.patientId=t1.patientId AND t1.followupTaskId=t5.followupTaskId WHERE t1.followupTaskId='")
					.append(req.getTaskId()).append("'");
			if (StringUtils.isNotEmpty(patientNo)) {
				paramsBuffer.append(" and (exists(select pn.patientId from user_db.r_uuid_patientno pn where pn.patientId=t2.patientId and (pn.patientNo LIKE '%")
						.append(patientNo).append("%')) or t2.patientNo LIKE '%").append(patientNo).append("%')");
			}
			if (StringUtils.isNotEmpty(patientTrueName)) {
				paramsBuffer.append(" AND t2.trueName LIKE '%").append(patientTrueName).append("%'");
			}
			if (StringUtils.isNotEmpty(phone)) {
				paramsBuffer.append(" AND (t2.patientId IN(SELECT patientId FROM user_db.u_patient_family WHERE familyPhone LIKE '%").append(phone).append("%')")
						.append(" OR t5.followupResultPhone LIKE '%").append(phone).append("%')");
			}

			if (StringUtils.isNotEmpty(sourceDiagnosis)) {
				paramsBuffer.append("AND t2.sourceDiagnosis LIKE '%").append(sourceDiagnosis).append("%'");
			}
			if (state != null && state.size() > 0) {
				String stateJson = JSON.toJSONString(state);
				stateJson = stateJson.replace("[", "(");
				stateJson = stateJson.replace("]", ")");
				paramsBuffer.append(" AND t1.state in ").append(stateJson);
			}
			if (followupResultValue != null && followupResultValue.size() > 0) {
				String followupResultValueJson = JSON.toJSONString(followupResultValue);
				followupResultValueJson = followupResultValueJson.replace("[", "(");
				followupResultValueJson = followupResultValueJson.replace("]", ")");
				paramsBuffer.append(" AND t5.followupResultValue in ").append(followupResultValueJson);
			}
			// 分配任务id
			if (StringUtils.isNotEmpty(req.getAssignId())) {
				paramsBuffer.append(" AND t1.followupAssignId='").append(req.getAssignId()).append("'");
			}
			paramsBuffer.append(" GROUP BY t1.patientId) t99 ON t1.patientId=t99.patientId");

			req.outFilePath = request.getSession().getServletContext().getRealPath(Constant.EXCEL_EXPORT);
			LogUtil.log.info("导出文件存放目录：outFilePath=" + req.outFilePath);
			reqMap.put("sql", paramsBuffer.toString());
			reqMap.put("exportTemplateId", req.getExportTemplateId());
			reqMap.put("outFilePath", req.outFilePath);
			// 随访患者列表查询
			msg.result = folloupTaskExportService.exportFollowupTaskDetail(reqMap);
			if (msg.result == null) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
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