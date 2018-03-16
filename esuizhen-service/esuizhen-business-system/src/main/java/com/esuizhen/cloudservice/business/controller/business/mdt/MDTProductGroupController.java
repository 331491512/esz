package com.esuizhen.cloudservice.business.controller.business.mdt;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.business.bean.TMDTDoctorInProductGroupInfo;
import com.esuizhen.cloudservice.business.bean.TMsgResponse;
import com.esuizhen.cloudservice.business.bean.TProductGroupInfo;
import com.esuizhen.cloudservice.business.service.business.mdt.MDTProductGroupService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.excption.InsufficientParameterExcption;
import com.westangel.common.util.LogUtil;

@Controller
public class MDTProductGroupController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private MDTProductGroupService productGroupService;
	
	@ResponseBody
	@RequestMapping(value = "/mdt/expert/group/detail", method = RequestMethod.GET)
	public TMsgResponse<TProductGroupInfo> getMDTExpertGroupDetail(Locale locale, String productId, Long userId){
		// 设置返回成功代码及提示消息
		TMsgResponse<TProductGroupInfo> tMsgResponse = new TMsgResponse<TProductGroupInfo>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info,null, locale));
		try {
			tMsgResponse.setResult(this.productGroupService.getMDTExpertGroupDetail(userId, productId));
		} catch(InsufficientParameterExcption ex){
			tMsgResponse.setRespCode(ErrorMessage.E1404.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info,null, locale));
			LogUtil.logError.error(ex.getMessage());
		} catch (Exception ex) {
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info,null, locale));
			LogUtil.logError.error(ex.getMessage());
			//ex.printStackTrace();
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:getMDTDoctorInProductGroupList</p>
	 * <p>Description:获取MDT产品组内医生列表。</p>
	 * @author YYCHEN
	 * @date 2016年9月28日 下午5:00:56
	 * @param locale
	 * @param productId
	 * @param groupType
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/mdt/doctor/in/product/group/list", method = RequestMethod.GET)
	public TMsgResponse<List<TMDTDoctorInProductGroupInfo>> getMDTDoctorInProductGroupList(Locale locale, String productId, Integer groupType){
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TMDTDoctorInProductGroupInfo>> tMsgResponse = new TMsgResponse<List<TMDTDoctorInProductGroupInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info,null, locale));
		try {
			tMsgResponse.setResult(this.productGroupService.getMDTDoctorInProductGroupList(productId, groupType));
		} catch(InsufficientParameterExcption ex){
			tMsgResponse.setRespCode(ErrorMessage.E1404.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info,null, locale));
			LogUtil.logError.error(ex.getMessage());
		} catch (Exception ex) {
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info,null, locale));
			LogUtil.logError.error(ex.getMessage());
			//ex.printStackTrace();
		}
		return tMsgResponse;
	}
	
	@ResponseBody
	@RequestMapping(value = "/mdt/product/list", method = RequestMethod.GET)
	public TMsgResponse<List<TMDTDoctorInProductGroupInfo>> getMDTProductList(Locale locale, Integer hospitalId, Long userId){
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TMDTDoctorInProductGroupInfo>> tMsgResponse = new TMsgResponse<List<TMDTDoctorInProductGroupInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info,null, locale));
		try {
			List<TMDTDoctorInProductGroupInfo> doctorInProductGroupInfos = this.productGroupService.getMDTProductList(hospitalId, userId);
			if (doctorInProductGroupInfos == null || doctorInProductGroupInfos.isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.code);
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info,null, locale));
			} else {
				tMsgResponse.setResult(doctorInProductGroupInfos);
			}
		} catch (Exception ex) {
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info,null, locale));
			LogUtil.logError.error(ex.getMessage());
			//ex.printStackTrace();
		}
		return tMsgResponse;
	}
}
