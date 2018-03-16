/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.controller.business;<br/>  
 * <b>文件名：</b>BusinessController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月12日下午4:53:32<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.controller.business;

import com.esuizhen.cloudservice.business.bean.*;
import com.esuizhen.cloudservice.business.bean.TMsgResponse;
import com.esuizhen.cloudservice.business.model.business.CallHandupModle;
import com.esuizhen.cloudservice.business.model.business.ProductServiceApply;
import com.esuizhen.cloudservice.business.model.business.TMDTDetailInfo;
import com.esuizhen.cloudservice.business.model.business.TMDTEmrInfo;
import com.esuizhen.cloudservice.business.model.business.TServiceSubscriptionInfo;
import com.esuizhen.cloudservice.business.service.business.BusinessProductProcessService;
import com.esuizhen.cloudservice.business.service.business.ProductApplyService;
import com.westangel.common.bean.*;
import com.westangel.common.bean.trade.TProductApplySync;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.TimeTooShortException;
import com.westangel.common.util.LogUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: BusinessController.java
 * @Description: 服务系统控制器
 * @author lichenghao
 * @date 2015年12月12日 下午4:53:32
 */
@Controller
public class BusinessProductApplyController {

	@Autowired
	private ProductApplyService productApplyService;
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private BusinessProductProcessService productProcessService;

	/**
	 * 
	 * 
	 * @author lichenghao
	 * @title :recommendProductProvider
	 * @Description: 服务产品推荐和获取
	 * @return TMsgResponse<TProductDetailInfo>
	 * @date 2015年12月15日 下午2:51:20
	 */
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/product/provider/recommend", method =
	 * RequestMethod.GET) public TMsgResponse<List<TProductDetailInfo>>
	 * recommendProductProvider(Integer productType ,Locale locale){
	 * TMsgResponse<List<TProductDetailInfo>> msg = new
	 * TMsgResponse<List<TProductDetailInfo>>(); setTmgResponseCode(msg,
	 * ErrorMessage.SUCCESS, locale); try { msg.result =
	 * productApplyService.getProductDetailInfo(productType); } catch (Exception
	 * e) { setTmgResponseCode(msg, ErrorMessage.E1500, locale);
	 * LogUtil.logError.error(e.getMessage()); } return msg; }
	 */

	/**
	 * 
	 * @author bigdragon
	 * @title :applyProductSync
	 * @Description:申请服务
	 * @return TMsgResponse<Long>
	 * @date 2016年1月12日 下午23:18:59
	 */
	@ResponseBody
	@RequestMapping(value = "/product/apply/sync", method = RequestMethod.POST)
	public TMsgResponse<Map<String, Object>> applyProductSync(@RequestBody TProductApplySync productApplySync,
			Locale locale) {
		TMsgResponse<Map<String, Object>> msg = new TMsgResponse<Map<String, Object>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			// 申请服务
			msg = productApplyService.createApplyProductSync(productApplySync);
			if (msg.result == null) {
				LogUtil.logError.error("applyProductSync failed: result return null.");
				// setTmgResponseCode(msg, ErrorMessage.E1417, locale);
			}
		} catch (Exception e) {
			e.printStackTrace();
			setTmgResponseCode(msg, ErrorMessage.E1417, locale);
			LogUtil.logError.error(e.getMessage());
		}

		return msg;
	}

	/**
	 * 
	 * @author lichenghao, bigdragon
	 * @title :applyProduct
	 * @Description:申请服务（目前仅用于微信端无须再支付的服务的申请，例如购买了私人医生后，对图文咨询或电话咨询的申请。）
	 * @return TMsgResponse<Long>
	 * @date 2015年12月15日 下午3:18:59
	 */
	@ResponseBody
	@RequestMapping(value = "/product/apply", method = RequestMethod.POST)
	public TMsgResponse<Map<String, Object>> applyProduct(@RequestBody TProductApply productApply, Locale locale) {
		TMsgResponse<Map<String, Object>> msg = new TMsgResponse<Map<String, Object>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 申请服务
			msg = productApplyService.createApplyProduct(productApply);
			if (msg.result == null) {
				LogUtil.logError.error("applyProduct failed: result return null.");
			}
		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1417, locale);
			LogUtil.logError.error(e.getMessage());
		}

		return msg;
	}

	/**
	 * 
	 * @author lichenghao
	 * @title :agentApplyProduct
	 * @Description:代理服务申请
	 * @return TMsgResponse<Map<String,Object>>
	 * @date 2016年10月20日 上午9:54:05
	 */
	@ResponseBody
	@RequestMapping(value = "/product/agent/apply", method = RequestMethod.POST)
	public TMsgResponse<Map<String, Object>> agentApplyProduct(@RequestBody TProductApply productApply, Locale locale) {
		TMsgResponse<Map<String, Object>> msg = new TMsgResponse<Map<String, Object>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 申请服务
			msg = productApplyService.agentApplyProduct(productApply);
			if (msg.result == null) {
				LogUtil.logError.error("applyProduct failed: result return null.");
			}
		} catch (EmptyParamExcption e) {
			setTmgResponseCode(msg, ErrorMessage.E1400, locale);
			LogUtil.logError.error(e.getMessage());
		} catch (EmptyObjectExcption e) {
			setTmgResponseCode(msg, ErrorMessage.E1400, locale);
			LogUtil.logError.error(e.getMessage());
		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1417, locale);
			e.printStackTrace();
			LogUtil.logError.error(e.getMessage());
		}

		return msg;
	}

	/**
	 * 
	 * 
	 * @author lichenghao, bigdragon
	 * @title :acceptProductApplication
	 * @Description:服务接受/同意/拒绝/取消
	 * @return TMsgResponse<String>
	 * @date 2015年12月15日 下午5:35:48
	 */
	@ResponseBody
	@RequestMapping(value = "/product/application/accept", method = RequestMethod.POST)
	public TMsgResponse<String> acceptProductApplication(@RequestBody TProductApply productApply, Locale locale) {
		TMsgResponse<String> msg = new TMsgResponse<String>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			int respCode = productApplyService.setAcceptProduct(productApply.getProductApplyId(),
					productApply.getAcceptFlag(), productApply.getConsultOrderTime());
			msg.respCode = respCode;
			if (respCode != 0)
				msg.respMsg = "parameter error";
		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			e.printStackTrace();
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}

	/**
	 * 
	 * 
	 * @author lichenghao
	 * @title :ModifyTelConsultingTime
	 * @Description:更改电话咨询时间
	 * @return TMsgResponse<String>
	 * @date 2015年12月15日 下午7:46:25
	 */
	@ResponseBody
	@RequestMapping(value = "/service/tel/consult/time/modify", method = RequestMethod.POST)
	public TMsgResponse<String> modifyTelConsultingTime(@RequestBody TProductApply productApply, Locale locale) {
		TMsgResponse<String> msg = new TMsgResponse<String>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			productApplyService.modifyTelConsultingTime(productApply);
		} catch (TimeTooShortException e) {
			setTmgResponseCode(msg, ErrorMessage.E1506, locale);
			LogUtil.logError.error(e.getMessage());

		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}

	/**
	 * 
	 * 
	 * @author DaLoong
	 * @title :makeCallForTelConsulting
	 * @Description:拨打电话
	 * @return TMsgResponse<String>
	 * @date 2015年12月15日 下午8:00:11
	 */
	@ResponseBody
	@RequestMapping(value = "/service/tel/consult/makecall", method = RequestMethod.GET)
	public TMsgResponse<String> makeCallForTelConsulting(TProductApply productApply, Locale locale) {
		TMsgResponse<String> msg = new TMsgResponse<String>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			/** 调用电话拨打接口 */
			msg = productApplyService.makeCallForTelConsulting(productApply);
		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
			// setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}

	/**
	 * 
	 * @Title: makeCallResultSync @Description: 保存拨打电话回调结果 @param @param
	 * productApplyId @param @param result @param @param locale @param @return
	 * 设定文件 @return TMsgResponse<String> 返回类型 @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/service/tel/consult/makecall/result/sync", method = RequestMethod.GET)
	public TMsgResponse<String> makeCallResultSync(String userData, Integer result, Locale locale) {
		TMsgResponse<String> msg = new TMsgResponse<String>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			/** 写入回调结果 */
			int acceptFlag = getAcceptFlag(result);
			result = productApplyService.setAcceptProduct(userData, acceptFlag, null);
			setTmgResponseCode(msg, ErrorMessage.getInfoViaCode(result), locale);
		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}

	
	@RequestMapping(value = "/service/call/result/sync", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<String> makeCallResultSync(HttpServletRequest request, HttpServletResponse response,Locale locale)
	{
		TMsgResponse<String> msg = new TMsgResponse<String>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			productApplyService.dealInputStreamFromYZX(request);
		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	private int getAcceptFlag(Integer result) {
		switch (result) {
		case 0:
			return 5;
		case 1:
		case 2: // 主叫（医生）未接
			return 4;
		case 3: // 被叫（患者）未接
			return 10;

		}
		return 4;
	}

	/**
	 * 
	 * 
	 * @author lichenghao
	 * @title :summarizeRichtextChatConsulting
	 * @Description:医生图文咨询总结
	 * @return TMsgResponse<String>
	 * @date 2015年12月15日 下午8:00:22
	 */
	@ResponseBody
	@RequestMapping(value = "/service/richtextchat/consult/summarize", method = RequestMethod.POST)
	public TMsgResponse<String> summarizeRichtextChatConsulting(@RequestBody TProductApply productApply,
			Locale locale) {
		TMsgResponse<String> msg = new TMsgResponse<String>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			productApplyService.setSummarizeRichtextChatConsulting(productApply);
		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}

	/**
	 * 
	 * 
	 * @author lichenghao
	 * @title :evaluateProductService
	 * @Description:患者对医生评价
	 * @return TMsgResponse<String>
	 * @date 2015年12月16日 下午1:25:10
	 */
	@ResponseBody
	@RequestMapping(value = "/product/service/evaluate", method = RequestMethod.POST)
	public TMsgResponse<String> evaluateProductService(@RequestBody TProductApply productApply, Locale locale) {
		TMsgResponse<String> msg = new TMsgResponse<String>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			productApplyService.setProductServiceEvaluate(productApply);
		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/product/service/evaluation/get", method = RequestMethod.GET)
	public TMsgResponse<ProductServiceApply> getProductServiceEvaluation(String productApplyId, Locale locale) {
		TMsgResponse<ProductServiceApply> msg = new TMsgResponse<ProductServiceApply>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			msg.result = productApplyService.getProductServiceEvaluation(productApplyId);
		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}

	/**
	 * 查询订购关系
	 * 
	 * @author bigdragon
	 * @param userId
	 * @param productType
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/product/subscription/check", method = RequestMethod.GET)
	public TMsgResponse<TProductSubscriptionInfo> checkProductSubscription(Long buyer, Long vendor, Integer productType,
			String productId, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TProductSubscriptionInfo> msg = new TMsgResponse<TProductSubscriptionInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 调用服务接口
			msg.result = productApplyService.checkProductSubscription(buyer, vendor, productType, productId);

		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 查询订购关系列表
	 * 
	 * @author bigdragon
	 * @param userId
	 * @param productType
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/product/subscription/list", method = RequestMethod.GET)
	public TMsgResponse<List<TProductSubscriptionSimpleInfo>> listProductSubscription(ProductSubscriptionReq req, Locale locale) {
		// 设置返回成功代码及提示消息

		TMsgResponse<List<TProductSubscriptionSimpleInfo>> msg = new TMsgResponse<List<TProductSubscriptionSimpleInfo>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 调用服务接口
			msg.result = productApplyService.listProductSubscription(req);

		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 查询订单状态、
	 * @author bigdragon
	 * @param userId
	 * @param orderId
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/product/order/state/query", method = RequestMethod.GET)
	public TMsgResponse<TProductSubscriptionInfo> queryProductOrderState(Long buyer, String orderId, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TProductSubscriptionInfo> msg = new TMsgResponse<TProductSubscriptionInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 调用服务接口
			msg.result = productApplyService.queryProductOrderState(buyer, orderId);

		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * @Title: getMdtDetailInfo @Description: 获取mdt详情 @param @param
	 * buyer @param @param orderId @param @return 设定文件 @return
	 * TMsgResponse<TMDTDetailInfo> 返回类型 @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/service/mdt/detail", method = RequestMethod.GET)
	public TMsgResponse<TMDTDetailInfo> getMdtDetailInfo(Long buyer, String orderId, Integer role, Long id,
			Locale locale) {
		TMsgResponse<TMDTDetailInfo> msgResponse = new TMsgResponse<TMDTDetailInfo>();
		msgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			msgResponse.setResult(this.productApplyService.queryMDTDetail(orderId, role, id));
		} catch (Exception ex) {
			msgResponse.setRespCode(ErrorMessage.E1417.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
			LogUtil.logError.error(ex.getMessage());
		}
		return msgResponse;
	}

	/**
	 * 
	 * @Title: uploadMdtEmr @Description: 上传会诊病历资料 @param @param
	 * req @param @param locale @param @return 设定文件 @return TMsgResponse<String>
	 * 返回类型 @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/service/mdt/emr/upload", method = RequestMethod.POST)
	public TMsgResponse<String> uploadMdtEmr(@RequestBody MdtEmrUploadReq req, Locale locale) {
		TMsgResponse<String> msgResponse = new TMsgResponse<String>();
		msgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			productApplyService.uploadMDTEmr(req);
		} catch (Exception ex) {
			msgResponse.setRespCode(ErrorMessage.E1417.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
			msgResponse.setResult(ex.toString());
		}
		return msgResponse;
	}
	
	/**
	 * <p>Title:getMdtEmr</p>
	 * <p>Description:获取会诊病历资料</p>
	 * @author YYCHEN
	 * @date 2016年11月21日 下午4:54:01
	 * @param locale
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/service/mdt/emr/get", method = RequestMethod.GET)
	public TMsgResponse<List<TMDTEmrInfo>> getMdtEmr(Locale locale, MdtEmrUploadReq req) {
		TMsgResponse<List<TMDTEmrInfo>> msgResponse = new TMsgResponse<List<TMDTEmrInfo>>();
		msgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<TMDTEmrInfo> list = productApplyService.getMDTEmr(req);
			if (list == null || list.isEmpty()) {
				msgResponse.setRespCode(ErrorMessage.E1404.code);
				msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				msgResponse.setResult(list);
			}
		} catch (Exception ex) {
			msgResponse.setRespCode(ErrorMessage.E1417.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
			msgResponse.setErrorDesc(ex.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 
	 * @Title: submitMdtEmr @Description: 提交会诊资料 @param @param req @param @param
	 * locale @param @return 设定文件 @return TMsgResponse<String> 返回类型 @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/service/mdt/emr/submit", method = RequestMethod.POST)
	public TMsgResponse<String> submitMdtEmr(@RequestBody MdtEmrSubmitReq req, Locale locale) {
		TMsgResponse<String> msgResponse = new TMsgResponse<String>();
		msgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			productApplyService.submitMDTEmr(req);
		} catch (Exception ex) {
			msgResponse.setRespCode(ErrorMessage.E1417.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
			msgResponse.setResult(ex.toString());
		}
		return msgResponse;
	}

	/**
	 * 
	 * @Title: listVipSubscription @Description: 获取医生VIP订购列表 @param @param
	 * locale @param @param vendor @param @return 设定文件 @return
	 * TMsgResponse<List<TServiceSubscriptionInfo>> 返回类型 @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/service/vip/subscription/list", method = RequestMethod.GET)
	public TMsgResponse<List<TServiceSubscriptionInfo>> listVipSubscription(Locale locale, Long vendor) {
		TMsgResponse<List<TServiceSubscriptionInfo>> msgResponse = new TMsgResponse<List<TServiceSubscriptionInfo>>();
		try {
			List<TServiceSubscriptionInfo> list = productApplyService.listServiceSubscriptionInfo(vendor);
			msgResponse.setRespCode(ErrorMessage.SUCCESS.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
			msgResponse.setResult(list);
		} catch (Exception ex) {
			msgResponse.setRespCode(ErrorMessage.E1417.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
			msgResponse.setErrorDesc(ex.toString());
		}
		return msgResponse;
	}

	/**
	 * 
	 * 
	 * @author lichenghao
	 * @title :listProductApply
	 * @Description:代理申请服务列表
	 * @return TMsgResponse<Object>
	 * @date 2016年3月24日 下午3:19:45
	 */
	@ResponseBody
	@RequestMapping(value = "/product/agent/apply/list", method = RequestMethod.GET)
	public TMsgResponse<Object> listProductApply(Long agentApplicant, Integer productType, Integer reqFlag,
			Locale locale) {
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		if (agentApplicant == null || productType == null) {
			msg.setRespCode(ErrorMessage.E1400.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			return msg;
		}
		try {
			msg.setRespCode(ErrorMessage.SUCCESS.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
			msg.result = productApplyService.listProductApply(agentApplicant, productType, reqFlag);
		} catch (Exception ex) {
			msg.setRespCode(ErrorMessage.E1417.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
			msg.setErrorDesc(ex.toString());
		}
		return msg;
	}

	/**
	 * 
	 * 
	 * @author lichenghao
	 * @title :submitMdtDiseaseEvaluation
	 * @Description:提交MDT病情评估报告
	 * @return TMsgResponse<Object>
	 * @date 2016年3月7日 下午10:54:52
	 */
	@ResponseBody
	@RequestMapping(value = "/service/mdt/disease/evaluation/submit", method = RequestMethod.POST)
	public TMsgResponse<Object> submitMdtDiseaseEvaluation(@RequestBody MdtDiseaseEvaluationSubmitReq req,
			Locale locale) {
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		try {
			productApplyService.submitMdtDiseaseEvaluation(req);
			setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);

		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1400, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}

	/**
	 * 
	 * 
	 * @author lichenghao
	 * @title :getMdtDiseaseEvaluationInfo
	 * @Description:查看MDT病情评估
	 * @return TMsgResponse<Object>
	 * @date 2016年3月8日 上午11:04:03
	 */
	@ResponseBody
	@RequestMapping(value = "/service/mdt/disease/evaluation/get", method = RequestMethod.GET)
	public TMsgResponse<Object> getMdtDiseaseEvaluationInfo(String productApplyId, Locale locale) {
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		if (productApplyId == null) {
			setTmgResponseCode(msg, ErrorMessage.E1400, locale);
			LogUtil.logError.error("productApplyId is null");
			return msg;
		}
		try {
			msg.result = productApplyService.getMdtDiseaseEvaluationInfo(productApplyId);
			setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		} catch (Exception ex) {
			setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 
	 * 
	 * @author lichenghao
	 * @title :getMdtDiseaseEvaluationInfo
	 * @Description:查看服务医院
	 * @return TMsgResponse<Object>
	 * @date 2016年3月18日 下午5:08:15
	 */
	@ResponseBody
	@RequestMapping(value = "/product/hospital/service/pack/list", method = RequestMethod.GET)
	public TMsgResponse<Object> getProductHospitalServicePackList(Locale locale) {
		System.out.println("==================================");
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		try {
			msg.result = productApplyService.getProductHospitalServicePackList();
			setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		} catch (Exception ex) {
			setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 
	 * 
	 * @author lichenghao
	 * @title :getProductApplySimpleInfo
	 * @Description:获取服务简要信息
	 * @return TMsgResponse<Object>
	 * @date 2016年3月18日 下午5:28:06
	 */
	@ResponseBody
	@RequestMapping(value = "/product/apply/simpleinfo", method = RequestMethod.GET)
	public TMsgResponse<Object> getProductApplySimpleInfo(String productApplyId, Locale locale) {
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		if (productApplyId == null || "".equals(productApplyId.trim())) {
			setTmgResponseCode(msg, ErrorMessage.E1400, locale);
			return msg;
		}
		try {
			msg.result = productApplyService.getProductApplySimpleInfo(productApplyId);
			setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		} catch (Exception ex) {
			setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 
	 * @author lichenghao
	 * @title :setTmgResponseCode
	 * @Description:返回编码消息封装
	 * @return void
	 * @date 2015年12月13日 上午11:27:30
	 */
	public void setTmgResponseCode(TMsgResponse msg, ErrorMessage error, Locale locale) {
		msg.setCodeAndrespMsg(error.code, messageSource.getMessage(error.info, null, locale));
	}

	/**
	 * 查询购买人信息系列表
	 * 
	 * @author jiayanzhao
	 * @param vendor
	 * @param productType
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/product/buyerInfo/list", method = RequestMethod.GET)
	public TMsgResponse<List<TProductBuyerInfo>> listProductBuyerInfo(Long vendor, Integer productType, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TProductBuyerInfo>> msg = new TMsgResponse<List<TProductBuyerInfo>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			System.out.println("vendor=" + vendor + ";productType=" + productType);
			List<TProductBuyerInfo> listT = productApplyService.listProductBuyerInfo(vendor, productType);
			// 调用服务接口
			msg.setResult(listT);
			;

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
	 * 
	 * @author jiayanzhao
	 * @title :modifyProductServiceExpress
	 * @Description:扫描那个病案邮寄的快递单 修改快递单号状态
	 * @return TMsgResponse<String>
	 * @date 2016年5月25日 下午5:09:08
	 */
	@ResponseBody
	@RequestMapping(value = "/product/service/express/state/modify", method = RequestMethod.GET)
	public TMsgResponse<String> modifyProductServiceExpress(String productApplyId, String expressNum, Long buyer,
			Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			productApplyService.updateExpressNum(productApplyId, expressNum, buyer);

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
	 * 
	 * @author lichenghao
	 * @title :getProductApplyStatis
	 * @Description:服务申请统计
	 * @return TMsgResponse<TProductApplyStatisInfo>
	 * @date 2016年5月25日 下午5:12:08
	 */
	@ResponseBody
	@RequestMapping(value = "/product/apply/statis", method = RequestMethod.GET)
	public TMsgResponse<TProductApplyStatisInfo> getProductApplyStatis(ProductApplyStatisGetReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TProductApplyStatisInfo> msg = new TMsgResponse<TProductApplyStatisInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			msg.result = productApplyService.getProductApplyStatis(req);
		} catch (EmptyParamExcption ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1419.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1419.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 */
	@ResponseBody
	@RequestMapping(value = "/product/apply/untreated/get", method = RequestMethod.GET)
	public TMsgResponse<Page<TProductApplyInfo>> getProductApplyList(ProductApplyUntreatedReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Page<TProductApplyInfo>> msg = new TMsgResponse<Page<TProductApplyInfo>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			msg.result = productApplyService.getUntreatedProductApplyList(req);
		} catch (EmptyParamExcption ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1419.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1419.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 
	 * 
	 * @author lichenghao
	 * @title :confirmReceipt
	 * @Description:确认收件
	 * @return TMsgResponse<String>
	 * @date 2016年6月21日 上午10:39:35
	 */
	@ResponseBody
	@RequestMapping(value = "/product/service/receipt/confirm", method = RequestMethod.POST)
	public TMsgResponse<String> confirmReceipt(@RequestBody TProductApply productApply, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			if (productApply != null)
				productApplyService.confirmReceipt(productApply.getProductApplyId(), productApply.getBuyer());
			else
				throw new EmptyObjectExcption("post productApply IS NULL");
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
	 * @title :confirmReceipt
	 * @Description:患者首次发送图文内容
	 * @return TMsgResponse<String>
	 * @date 2016年10月17日 下午5:43:35
	 */
	@ResponseBody
	@RequestMapping(value = "/rich/text/first/send/message", method = RequestMethod.POST)
	public TMsgResponse<String> firstSendMessageRichText(@RequestBody RichTextFirstSendMessageReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			productApplyService.firstSendMessageRichText(req);
		} catch (EmptyParamExcption e) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1400.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1400.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		} catch (EmptyObjectExcption e) {
			msg.respCode = ErrorMessage.E1404.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "product/subscription/detail",method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<TProductSubscriptionSimpleInfo> getProductSubscription(String productApplyId,String orderId,Locale locale){
		// 设置返回成功代码及提示消息
		TMsgResponse<TProductSubscriptionSimpleInfo> msg = new TMsgResponse<TProductSubscriptionSimpleInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			msg.result=productApplyService.getProductSubscriptionDetail(productApplyId,orderId);
		} catch (EmptyParamExcption e) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1400.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1400.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		} catch (EmptyObjectExcption e) {
			msg.respCode = ErrorMessage.E1404.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage(),ex);
		}
		return msg;
	}



	/**
	 * 创建业务流程监控任务(暂不使用)
	 * @author nidan
	 * @param productApplyId
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "product/process/monitor",method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<String> businessProcessMonitoring(String productApplyId, Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{

			productProcessService.businessProcessMonitoring(productApplyId);

		}catch(Exception ex){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage(),ex);
		}
		return msg;
	}

}
