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

import com.esuizhen.cloudservice.research.bean.TProjectSubcenterDetailInfo;
import com.esuizhen.cloudservice.research.model.result.TRSubcenterDoctor;
import com.esuizhen.cloudservice.research.service.result.TRSubcenterDoctorService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.ObjectAlreadyExistExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.util.LogUtil;

/**
 * <p>
 * Title:ProjectSubcenterDoctorController
 * </p>
 * <p>
 * Description:专题分中心医生业务控制层
 * </p>
 * 
 * @author YYCHEN
 * @date 2016年6月22日 下午3:57:32
 */
@Controller
public class TProjectSubcenterDoctorController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private TRSubcenterDoctorService rSubcenterDoctorService;

	/**
	 * <p>
	 * Title:searchSubcenterDoctorList
	 * </p>
	 * <p>
	 * Description:获取专题分中心医生数据
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年6月22日 下午4:08:49
	 * @param locale
	 * @param projectId
	 * @param allFlag
	 * @return
	 */
	@RequestMapping(value = "/subcenter/doctor/search", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<TRSubcenterDoctor>> searchSubcenterDoctorList(Locale locale, String projectId,
			Integer allFlag) {
		TMsgResponse<List<TRSubcenterDoctor>> tMsgResponse = new TMsgResponse<List<TRSubcenterDoctor>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<TRSubcenterDoctor> crfResultMainInfo = this.rSubcenterDoctorService
					.searchSubcenterDoctorList(projectId, allFlag);
			if (crfResultMainInfo == null || crfResultMainInfo.isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				tMsgResponse.setResult(crfResultMainInfo);
			}
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return tMsgResponse;
	}

	@RequestMapping(value = "/subcenter/doctor/list", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<TProjectSubcenterDetailInfo>> listProjectSubcenterDoctor(Locale locale, String projectId,
			Long subcenterId, Long doctorId) {
		TMsgResponse<List<TProjectSubcenterDetailInfo>> tMsgResponse = new TMsgResponse<List<TProjectSubcenterDetailInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<TProjectSubcenterDetailInfo> crfResultMainInfo = this.rSubcenterDoctorService
					.getProjectSubcenterDoctor(projectId, subcenterId, doctorId);
			if (crfResultMainInfo == null || crfResultMainInfo.isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				tMsgResponse.setResult(crfResultMainInfo);
			}
		} catch (ParameterCannotBeNullException ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return tMsgResponse;
	}

	@ResponseBody
	@RequestMapping(value = "/subcenter/member/add", method = RequestMethod.POST)
	public TMsgResponse<Void> addProjectSubcenterMember(Locale locale, @RequestBody TProjectSubcenterDetailInfo projectSubcenterDetailInfo) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Void> msg = new TMsgResponse<Void>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			this.rSubcenterDoctorService.addProjectSubcenterMember(projectSubcenterDetailInfo);
		} catch(ObjectAlreadyExistExcption ex){
			msg.respCode = ErrorMessage.E1409.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1409.info, null, locale);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "/subcenter/member/delete", method = RequestMethod.POST)
	public TMsgResponse<Void> deleteProjectSubcenterMember(Locale locale, @RequestBody TProjectSubcenterDetailInfo projectSubcenterDetailInfo) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Void> msg = new TMsgResponse<Void>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 删除
			this.rSubcenterDoctorService.deleteProjectSubcenterMember(projectSubcenterDetailInfo);
		} catch(RejectRequestExcption ex){
			msg.respCode = ErrorMessage.E1701.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1701.info, null, locale);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}
