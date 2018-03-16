package com.esuizhen.cloudservice.business.controller.business.mdt;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.business.bean.MdtReq;
import com.esuizhen.cloudservice.business.bean.TMDTApplyInfo;
import com.esuizhen.cloudservice.business.bean.TMDTWaxExpressReq;
import com.esuizhen.cloudservice.business.bean.TMsgResponse;
import com.esuizhen.cloudservice.business.service.business.mdt.MdtProductService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.InsufficientParameterExcption;
import com.westangel.common.util.LogUtil;

@Controller
public class MdtProductController {
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * MDT会诊
	 */
	@Autowired
	private MdtProductService mdtDiagnosisService;
	
	@ResponseBody
	@RequestMapping(value = "/untreated/mdt/apply/get", method = RequestMethod.GET)
	public TMsgResponse<Integer> getUntreatedMdtApple(Locale locale, Long userId){
		// 设置返回成功代码及提示消息
		TMsgResponse<Integer> msg = new TMsgResponse<Integer>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info,null, locale));
		try {
			msg.result = mdtDiagnosisService.findSMdtAppleByUserId(userId);
		} catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1400.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info,null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 查看MDT人次
	 * @param locale
	 * @param vendor
	 * @param mdtFlowStateId
	 * @param flag
	 * @param mdtRole
	 * @param userRole
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/service/mdt/statis", method = RequestMethod.GET)
	public TMsgResponse<Integer> getMdtStatis(Locale locale, Long userId, Integer mdtFlowStateId,Integer flag,Integer mdtRole, Integer userRole){
		// 设置返回成功代码及提示消息
		TMsgResponse<Integer> msg = new TMsgResponse<Integer>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info,null, locale));
		try {
			msg.result = mdtDiagnosisService.getMdtStatis(userId, mdtFlowStateId, flag, mdtRole, userRole);
		} catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1400.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info,null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 查看MDT列表信息
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/service/mdt/list", method = RequestMethod.POST)
	public TMsgResponse<Page<TMDTApplyInfo>> queryMdtList(@RequestBody MdtReq req,Locale locale){
		// 设置返回成功代码及提示消息
		TMsgResponse<Page<TMDTApplyInfo>> msg = new TMsgResponse<Page<TMDTApplyInfo>>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info,null, locale));
		try {
			msg.result = mdtDiagnosisService.queryMdtList(req);
		} catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1417.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info,null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}

	/**
	 * <p>Title:applyMDTProductService</p>
	 * <p>Description:给患者申请MDT产品服务</p>
	 * @author YYCHEN
	 * @date 2016年9月28日 下午5:29:31
	 * @param productApplyReq
	 * @param locale
	 * @return
	 */
	/*
	@ResponseBody
	@RequestMapping(value = "/mdt/product/apply", method = RequestMethod.POST)
	public TMsgResponse<Void> applyMDTProductService (@RequestBody TMDTProductApplyReq productApplyReq, Locale locale){
		// 设置返回成功代码及提示消息
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info,null, locale));
		try {
			this.mdtDiagnosisService.applyMDTProductService(productApplyReq);
		} catch(InsufficientParameterExcption ex){
			tMsgResponse.setRespCode(ErrorMessage.E1404.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info,null, locale));
			LogUtil.logError.error(ex.getMessage());
		} catch (Exception e) {
			tMsgResponse.setRespCode(ErrorMessage.E1400.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info,null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return tMsgResponse;
	}
	*/

	/**
	 * <p>Title:expressMDTWax</p>
	 * <p>Description:MDT服务流程，邮寄蜡片。</p>
	 * @author YYCHEN
	 * @date 2016年9月28日 下午5:29:20
	 * @param waxExpressReq
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/mdt/product/wax/express", method = RequestMethod.POST)
	public TMsgResponse<Void> expressMDTWax(@RequestBody TMDTWaxExpressReq waxExpressReq, Locale locale){
		// 设置返回成功代码及提示消息
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info,null, locale));
		try {
			this.mdtDiagnosisService.expressMDTWax(waxExpressReq);
		} catch(InsufficientParameterExcption ex){
			tMsgResponse.setRespCode(ErrorMessage.E1404.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info,null, locale));
			LogUtil.logError.error(ex.getMessage());
		} catch (Exception e) {
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info,null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return tMsgResponse;
	}
}
