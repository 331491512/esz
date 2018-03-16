package com.esuizhen.cloudservice.research.controller.result;

import java.util.List;
import java.util.Locale;

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
import com.esuizhen.cloudservice.research.bean.TProjectGroupInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TProjectInvitationPatient;
import com.esuizhen.cloudservice.research.service.pro.ProjectGroupService;
import com.esuizhen.cloudservice.research.service.result.FollowupResultService;
import com.esuizhen.cloudservice.research.service.result.PatientManageService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.DisableExcption;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.util.LogUtil;

/**
 * <p>Title:ProjectGroupController</p>
 * <p>Description:专题患者组</p>
 * @author YYCHEN
 * @date 2016年10月28日 下午2:39:17
 */
@Controller
public class ProjectGroupController {
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private ProjectGroupService projectGroupService;


	@RequestMapping(value = "/crf/project/group/list", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<TProjectGroupInfo>> queryProjectGroupList(Locale locale, String projectId, Long doctorId) {
		TMsgResponse<List<TProjectGroupInfo>> tMsgResponse = new TMsgResponse<List<TProjectGroupInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<TProjectGroupInfo> projectGroupInfos = this.projectGroupService.queryProjectGroupList(projectId, doctorId);
			if (projectGroupInfos == null || projectGroupInfos.isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				tMsgResponse.setResult(projectGroupInfos);
			}
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
}
