/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.service.business.impl;<br/>  
 * <b>文件名：</b>ProductApplyServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月31日下午2:32:20<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.service.business.impl;

import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.business.bean.DoctorClinicUsageSetReq;
import com.esuizhen.cloudservice.business.bean.MdtDiseaseEvaluationSubmitReq;
import com.esuizhen.cloudservice.business.bean.MdtEmrSubmitReq;
import com.esuizhen.cloudservice.business.bean.MdtEmrUploadReq;
import com.esuizhen.cloudservice.business.bean.MetaMDTProductStateListReq;
import com.esuizhen.cloudservice.business.bean.ProductApplyStatisGetReq;
import com.esuizhen.cloudservice.business.bean.ProductApplyUntreatedReq;
import com.esuizhen.cloudservice.business.bean.ProductSubscriptionReq;
import com.esuizhen.cloudservice.business.bean.RichTextFirstSendMessageReq;
import com.esuizhen.cloudservice.business.bean.ServiceProgressResp;
import com.esuizhen.cloudservice.business.bean.TMDTApplyInfo;
import com.esuizhen.cloudservice.business.bean.TMsgResponse;
import com.esuizhen.cloudservice.business.bean.TProductApply;
import com.esuizhen.cloudservice.business.bean.TProductApplyInfo;
import com.esuizhen.cloudservice.business.bean.TProductApplyStatisInfo;
import com.esuizhen.cloudservice.business.bean.TProductBuyerInfo;
import com.esuizhen.cloudservice.business.bean.TProductSubscriptionInfo;
import com.esuizhen.cloudservice.business.bean.TProductSubscriptionSimpleInfo;
import com.esuizhen.cloudservice.business.dao.business.DoctorClinicDao;
import com.esuizhen.cloudservice.business.dao.business.DoctorDao;
import com.esuizhen.cloudservice.business.dao.business.PatientDao;
import com.esuizhen.cloudservice.business.dao.business.ProductApplyDao;
import com.esuizhen.cloudservice.business.dao.business.UserDao;
import com.esuizhen.cloudservice.business.dao.business.mdt.SMDTApplyDao;
import com.esuizhen.cloudservice.business.model.business.ProductServiceApply;
import com.esuizhen.cloudservice.business.model.business.ProductServiceConf;
import com.esuizhen.cloudservice.business.model.business.SMDTApply;
import com.esuizhen.cloudservice.business.model.business.TMDTDetailInfo;
import com.esuizhen.cloudservice.business.model.business.TMDTEmrInfo;
import com.esuizhen.cloudservice.business.model.business.TProductPackageQuotaUsageInfo;
import com.esuizhen.cloudservice.business.model.business.TServiceSubscriptionInfo;
import com.esuizhen.cloudservice.business.notify.sender.ApplyAcceptNotifySender;
import com.esuizhen.cloudservice.business.notify.sender.ExpressNotifySender;
import com.esuizhen.cloudservice.business.notify.sender.ProductApplyNotifySender;
import com.esuizhen.cloudservice.business.notify.sender.TelConsultModifyNotifySender;
import com.esuizhen.cloudservice.business.service.business.DoctorService;
import com.esuizhen.cloudservice.business.service.business.ProductApplyService;
import com.esuizhen.cloudservice.business.service.business.express.ExpressService;
import com.esuizhen.cloudservice.business.service.business.mdt.MetaMDTDataUnitService;
import com.esuizhen.cloudservice.business.service.user.ReviewAlertService;
import com.esuizhen.cloudservice.business.util.BusinessUtil;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.common.bean.push.PushUser;
import com.westangel.common.bean.sms.CallTwoWayReq;
import com.westangel.common.bean.trade.TOrderMinInfo;
import com.westangel.common.bean.trade.TOrderPaymentItemInfo;
import com.westangel.common.bean.trade.TOrderPublishInfo;
import com.westangel.common.bean.trade.TProductApplySync;
import com.westangel.common.bean.trade.TProductDetailInfo;
import com.westangel.common.bean.user.HospitalPatientBriefInfo;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.TimeTooShortException;
import com.westangel.common.service.AccountService;
import com.westangel.common.service.MessageInnerService;
import com.westangel.common.service.OrderService;
import com.westangel.common.service.PayService;
import com.westangel.common.service.ProductService;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.service.SmsInnerService;
import com.westangel.common.util.CallUtil;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.ImMessageUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;
import com.westangel.common.util.PushContentUtil;

/**
 * @ClassName: ProductApplyServiceImpl
 * @Description:
 * @author lichenghao, bigdragon
 * @date 2015年12月31日 下午2:32:20
 */
@Service
public class ProductApplyServiceImpl implements ProductApplyService {
	private Locale locale = Locale.getDefault();

	@Value("${server.api.url.root}")
	private String serverUrlRoot;

	@Value("${url.api.trade.product.get}")
	private String tradeProductGet;

	@Value("${service.tel.sync.path}")
	private String callSyncPath;

	@Autowired
	private ProductApplyDao dao;

	@Autowired
	private SMDTApplyDao sMDTApplyDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private DoctorClinicDao doctorClinicDao;

	@Autowired
	private PatientDao patientDao;

	@Autowired
	private OrderService orderService; // 交易系统的远端RMI服务

	@Autowired
	private ProductService productService; // 交易系统的RMI服务

	@Autowired
	private PayService payService; // 交易系统的远端RMI服务

	@Autowired
	private AccountService accountService; // 交易系统的远端RMI服务

	@Autowired
	private MetaMDTDataUnitService metaMDTDataUnitService;

	@Autowired
	private MessageInnerService messageService;

	@Autowired
	private SmsInnerService smsService;

	@Autowired
	private PushInnerService pushInnerService;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ProductApplyNotifySender notifySender;

	@Autowired
	private ApplyAcceptNotifySender acceptNotifySender;

	@Autowired
	private TelConsultModifyNotifySender telNotifySender;

	@Autowired
	private PackageProductQuotaHandler packageQuotaHandler;

	@Autowired
	private TimerTaskHandler timerTaskHandler;

	@Autowired
	private SubscriptionVipFlagHandler subscriptionVipHandler;
	
	@Autowired
	private ExpressService expressService;
	
	@Autowired
	private ExpressNotifySender expressNotifySender;

	@Autowired
	private DoctorService doctorService;
	@Autowired
	private ReviewAlertService reviewAlertService;

	/**
	 * 服务申请 。仅用于微信端已经购买了私人医生之后，再申请图文咨询或电话咨询或预约挂号时使用。
	 * 
	 * @author: bigdragon
	 * @throws Exception
	 * @date: 2015/12/30
	 */
	// 这里不作为事务。而是把doProductApply作为事务
	@Override
	public com.esuizhen.cloudservice.business.bean.TMsgResponse<Map<String, Object>> createApplyProduct(
			TProductApply productApply) throws Exception {

		//-1.有子产品类型的需要确认
		if(!productService.checkProductIsExist(productApply.getOrderInfo().getProductId(),
				productApply.getOrderInfo().getProductSubType())){
			com.esuizhen.cloudservice.business.bean.TMsgResponse<Map<String, Object>> msg = new com.esuizhen.cloudservice.business.bean.TMsgResponse<Map<String, Object>>();
			msg.respCode = 1404;
			msg.respMsg = "productId or productSubType not found!";
			return msg;
		}

		// 0. 检查产品是否已经下架，如果已下架，则直接返回
		if (checkProductServiceOffShelf(productApply.getOrderInfo().getProductId(),productApply.getOrderInfo().getProductSubType())) {
			com.esuizhen.cloudservice.business.bean.TMsgResponse<Map<String, Object>> msg = new com.esuizhen.cloudservice.business.bean.TMsgResponse<Map<String, Object>>();
			msg.respCode = 1406;
			msg.respMsg = "此服务已下架!";
			return msg;
		}
		// 1. 创建申请记录
		String orderId = GeneralUtil.generateUniqueID("TEMP");// 不会同步到交易系统。用TEMP标志
		productApply.getOrderInfo().setOrderId(orderId);
		if (StringUtils.isEmpty(productApply.getOrderInfo().getProductApplyId())) {
			String applyId = GeneralUtil.generateUniqueID("APPL");
			productApply.setProductApplyId(applyId);
			//productApply.setProductApplyId(applyId);
		}else
		{
			productApply.setProductApplyId(productApply.getOrderInfo().getProductApplyId());
		}

		// createApplyProductSync(来自交易系统）和createApplyProduct（来自微信端）调用同一个内部方法进行服务申请创建
		com.esuizhen.cloudservice.business.bean.TMsgResponse<Map<String, Object>> msg = this
				.doProductApply(productApply, false, true);
		//13服务不生成任务
		if(productApply.getOrderInfo()!=null&&productApply.getOrderInfo().getProductType()==13)
			return msg;
		// 定时器任务在不同的事务中。所以要保证doProductApply已commit. 因为它要从刚生成的的产品申请表中提取数据。
		// 2. 生成定时监控任务
		if (msg.respCode == 0)
			timerTaskHandler.createMonTimerTask(productApply.getProductApplyId(),
					productApply.getOrderInfo().getProductType(), "cancel");
		else if (msg.respCode == 1) {
			// 自动确认的服务直接将服务状态修改为2
			timerTaskHandler.createDoAcceptTimeTask(productApply.getProductApplyId(),
					productApply.getOrderInfo().getProductType(), 2);
			msg.respCode = 0;
		}
		/*String url=serverUrlRoot+"/business/product/process/monitor?productApplyId="+productApply.getProductApplyId();
		String result=HttpUtil.get(url);
		if(result!=null) {
			com.westangel.common.bean.TMsgResponse resp = JsonUtil.toObject(result, com.westangel.common.bean.TMsgResponse.class);
			if(resp==null||resp.respCode!=0){
				LogUtil.logError.error("业务流程处理失败:{}",resp.getRespMsg());
			}
		}*/
		return msg;
	}

	private boolean checkProductServiceOffShelf(String productId,Integer productSubType) {
		// TODO Auto-generated method stub
		TProductDetailInfo info = productService.getProductDetail(productId,productSubType);
		if (null == info) {
			LogUtil.logError.warn(Constant.LOGTAG.ERR
					+ "WARN: checkProductServiceOffShelf: the product not found. productId=" + productId);
			return true;

		}

		if (info.getState() == 2) {
			LogUtil.logError
					.warn(Constant.LOGTAG.ERR + "WARN: checkProductServiceOffShelf: 产品已下架. productId=" + productId);
			return true;

		}

		return false;
	}

	/**
	 * 代理服务申请
	 */
	@Override
	public TMsgResponse<Map<String, Object>> agentApplyProduct(TProductApply req) throws Exception {
		// TODO Auto-generated method stub
		if (req == null || req.getOrderInfo() == null)
			throw new EmptyParamExcption("param error req is null");
		if (req.getToBApplyInfo() != null) {
			if (StringUtils.isNotEmpty(req.getToBApplyInfo().getBuyerUuid())
					|| req.getToBApplyInfo().getHospitalId() != null) {
				// 获取患者的UserId 支付方
				Long buyer = userDao.querUserIdByPatientUuid(req.getToBApplyInfo().getBuyerUuid());
				if (buyer == null)
					throw new EmptyParamExcption(
							"param error buyerUuid error ：" + req.getToBApplyInfo().getBuyerUuid());
				// 获取医院的UserId 商家
				Long vendor = userDao.queryUserIdByHospitalId(req.getToBApplyInfo().getHospitalId());
				if (vendor == null)
					throw new EmptyParamExcption(
							"param error hospitaId error ：" + req.getToBApplyInfo().getHospitalId());
				req.getOrderInfo().setBuyer(buyer);
				req.getOrderInfo().setVendor(vendor);
			} else
				LogUtil.log.error(" tobApply param error");
		}
		if (req.getOrderInfo().getBuyer() == null || req.getOrderInfo().getVendor() == null
				|| req.getOrderInfo().getProductType() == 0) {
			throw new EmptyParamExcption("param error");
		}
//		LogUtil.log.debug(JsonUtil.toJson(req));
		String url = serverUrlRoot + tradeProductGet + "?userId=" + req.getOrderInfo().getVendor() + "&productType="
				+ req.getOrderInfo().getProductType();
		String result = HttpUtil.get(url);
		TMsgResponse msg = JsonUtil.toObject(result, TMsgResponse.class);
		// 判断接口是否调用成功
		if (msg.getRespCode() != 0) {
			LogUtil.logError.error("get product error  msg =" + msg.getRespMsg());
			return msg;
		}
		List<Object> productInfoList = (List<Object>) msg.getResult();
		TProductDetailInfo productInfo = null;
		if (productInfoList != null && productInfoList.size() > 0)
			productInfo = JsonUtil.toObject(JsonUtil.toJson(productInfoList.get(0)), TProductDetailInfo.class);
		// 判断接口是否存在
		if (productInfo == null)
			throw new EmptyObjectExcption(" product error,product is null");
		TOrderPublishInfo publishInfo = req.getOrderInfo();
		// 写入产品号
		publishInfo.setProductId(productInfo.getProductId());
		// 写入产品名称
		publishInfo.setOrderTitle(productInfo.getProductName());
		// 写入单价
		publishInfo.setRealPrice(productInfo.getUnitPrice());
		PushUser user = userDao.getPushOpenIdByUserId(publishInfo.getBuyer());
		if (user != null)
			publishInfo.setWxProductId(user.getProductId());
		// 调用服务申请
		return createApplyProduct(req);
	};

	/**
	 * 产品服务申请同步。由交易系统完成支付后进行同步。
	 * 
	 * @throws Exception
	 */
	@Override
	public com.esuizhen.cloudservice.business.bean.TMsgResponse<Map<String, Object>> createApplyProductSync(
			TProductApplySync productApplySync) throws Exception {

		TProductApply productApply = new TProductApply();
		productApply.setOrderInfo(productApplySync.getOrderInfo());
		String productApplyId = GeneralUtil.generateUniqueID("APPL");
		productApply.setProductApplyId(productApplyId);

		// createApplyProductSync(来自交易系统）和createApplyProduct（来自微信端）调用同一个内部方法进行服务申请创建
		// 1.创建产品申请
		com.esuizhen.cloudservice.business.bean.TMsgResponse<Map<String, Object>> msg = this
				.doProductApply(productApply, true, false);
		//13服务不生成任务
		if(productApply.getOrderInfo()!=null&&productApply.getOrderInfo().getProductType()==Constant.Business.PRODUCT_TYPE_REVIEW_GOODS)
			return msg;
		// 定时器任务在不同的事务中。所以要保证doProductApply已commit. 因为它要从刚生成的的产品申请表中提取数据。
		// 2. 生成定时监控任务
		if (msg.respCode == 0)
			timerTaskHandler.createMonTimerTask(productApply.getProductApplyId(),
					productApply.getOrderInfo().getProductType(), "cancel");
		else if (msg.respCode == 1) {
			// 自动确认的服务直接将服务状态修改为2
			timerTaskHandler.createDoAcceptTimeTask(productApply.getProductApplyId(),
					productApply.getOrderInfo().getProductType(), 2);
			msg.respCode = 0;
		}else if(msg.respCode ==2){//申请，由于事务冲突、 后续执行为了不影响 主业务。
			final String applyId = msg.getResult().get("productApplyId").toString();
			Runnable run = new Runnable(){
				@Override
				public void run()
				{
					try{
						Thread.sleep(1000);
						LogUtil.log.debug("sync apply product sleep 0.5s");
					}catch(Exception ex){
						
					}
					setAcceptProduct(applyId, 2, null);
					setAcceptProduct(applyId, 5, null);
					LogUtil.log.debug("sync apply product ok,productApplyId:"+applyId);
				}
			};
			ExecutorService exec = Executors.newFixedThreadPool(1);
			exec.execute(run);
			msg.respCode = 0;
		}
		LogUtil.log.debug("create productApply end check msg.respCode=" + msg.respCode);
		/*String url=serverUrlRoot+"/business/product/process/monitor?productApplyId="+productApply.getProductApplyId();
		String result=HttpUtil.get(url);
		if(result!=null) {
			com.westangel.common.bean.TMsgResponse resp = JsonUtil.toObject(result, com.westangel.common.bean.TMsgResponse.class);
			if(resp==null || resp.respCode!=0){
				LogUtil.logError.error("业务流程处理失败:{}",resp.getRespMsg());
			}
		}*/
		return msg;
	}

	/**
	 * 产品服务接受、拒绝、取消、关闭、终止等处理。除了申请动作外，所有通用的中间过程和结束处理，都在这个方法进行。
	 * 所以本方法是仅次于产品申请(doProductApply)的最重要的方法。
	 */
	@Override
	public int setAcceptProduct(String productApplyId, int acceptFlag, Date consultOrderTime) {

		ProductServiceApply psa = this.dao.getProductServiceApplyInfo(productApplyId);
		if (psa == null) {
			LogUtil.logError
					.error("setAcceptProduct() failed: parameter error: productApplyId or productId not found. productApplyId="
							+ productApplyId);
			return 1404;
		}

		ProductServiceConf conf = this.dao.getProductServiceConfById(psa.getProductId());
		if (conf == null) {
			LogUtil.logError
					.error("setAcceptProduct() failed: getProductServiceConfById error: ProductServiceConf not found. productApplyId="
							+ productApplyId + ",productId=" + psa.getProductId() + ",productType="
							+ psa.getProductType());
			return 1500;
		}

		// 1. 真正执行处理
		int rt = this.doAcceptProduct(psa, conf, productApplyId, acceptFlag, consultOrderTime);
		if (rt != 0)
			return rt;

		// 2. 设置或处理定时任务. 放在比较靠后处理，因为如果前面处理失败，需要回滚。但定时器无法回滚，所以放到靠后进行。
		timerTaskHandler.doAcceptTimerTask(psa, acceptFlag, conf);
		// 定时器任务在另外程序中，它需要读取服务申请表，故不能让调用定时器任务与本方法在同一个事务中.

		LogUtil.log.info("========= OK! Do setAcceptProduct and doAcceptTimerTask succeed.productApplyId="
				+ psa.getProductApplyId() + ",acceptFlag=" + acceptFlag + "=========\n");

		return 0; // success
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private int doAcceptProduct(ProductServiceApply psa, ProductServiceConf conf, String productApplyId, int acceptFlag,
			Date consultOrderTime) {
		// TODO Auto-generated method stub
		/*
		 * 状态：状态。 0: 未支付 1：已支付、待医生确认 2: 医生已接受 3： 医生已拒绝 4： 服务进行中 5： 服务已完成（已关闭） 6：
		 * 服务过期（系统取消） 7： 服务取消（患者取消） 8: 患者关闭 9: 医生关闭 10：患者未接听 11: 30分钟仍未拨打或失败
		 */
		// 服务进展状态。0：未开始；1：进行中；2：进行但失败（如电话呼叫失败）；3：已顺利结束（如关闭咨询通道，或呼叫结束）;4:已取消
		int state = acceptFlag;
		// 0. 检查和设置参数
		final int i = checkAndSetParameter(psa, acceptFlag, consultOrderTime);
		int result = i;
		if (result != 0) {
			LogUtil.logError.error("################ accept product: checkAndSetParameter() failed! result=" + result
					+ ",productType=" + psa.getProductType() + ",productApplyId=" + psa.getProductApplyId()
					+ ",acceptFlag=" + acceptFlag);
			return result;
		}

		// 首先检查是否此状态是被允许的
		result = checkAcceptState(psa, acceptFlag);
		if (result != 0) {
			LogUtil.logError.error("################ accept product: checkAcceptState() failed! result=" + result
					+ ",productType=" + psa.getProductType() + ",productApplyId=" + psa.getProductApplyId() + ",state="
					+ psa.getState() + ",acceptFlag=" + acceptFlag);
			return result;

		} else {
			setAcceptState(psa, acceptFlag);
			setExpireTime(psa, conf); // 重新设置过期时间
		}
		//如果是病案复印服务需要更新同步字段
		updateProductServiceApplySyncFlag(psa,acceptFlag);
		// 1. 更新服务系统的product_service_apply表
		dao.modifyProductServiceApplyState(psa);
		// 设置VIP或订购标识
		if (BusinessUtil.isVip(psa.getProductType()))
			subscriptionVipHandler.setVipFlag(psa);
		else
			subscriptionVipHandler.setSubscriptionFlag(psa);
		// 设置代理申请标识
		if (psa.getAgentApplicant() != null)
			subscriptionVipHandler.setAgentApplyFlag(psa);
		// 2. 更新交易系统的订单表。
		orderService.updateOrderState(psa.getVendor(), psa.getOrderId(), state, "");
		// 3. 进行打款、退款或退还（套餐内）操作处理
		if (needCancelProductService(state,conf.getIsRefund())) {
			doCancelProductService(psa);
		} else if (needMakeProfit(state, psa.getPackageFlag(), psa.getInPackage(), psa.getIsAutoAccept())) {
			String debitRecId = doMakeProfit(state, psa.getOrderId());
			if (null != debitRecId)
				// 发出推送
				acceptNotifySender.sendMakeProfitSuccessNotify(psa, debitRecId);
		}

		// 4. 对用户进行通知提示
		sendApplyAcceptNotify(psa);

		// 5. 设置或处理定时任务. 放在比较靠后处理，因为如果前面处理失败，需要回滚。但定时器无法回滚，所以放到靠后进行。
		// timerTaskHandler.doAcceptTimerTask(psa,acceptFlag,conf);
		// 定时器任务在另外程序中，它需要读取服务申请表，故不能让调用定时器任务与本方法在同一个事务中.

		LogUtil.log.info(Constant.LOGTAG.OK + "Do setAcceptProduct succeed.productApplyId=" + psa.getProductApplyId()
				+ ",acceptFlag=" + acceptFlag + "=========\n");

		return 0; // success
	}

	/**
	 * 更新syncFlag
	 * @param psa
	 */
	private void updateProductServiceApplySyncFlag(ProductServiceApply psa,int acceptFlag) {
		//病案邮寄状态更新
		if(psa.getProductType().equals(Constant.Business.PRODUCT_TYPE_MEDICAL_RECORD_MAIL)){
			if(acceptFlag==3||acceptFlag==5||acceptFlag==6||acceptFlag==7){
				if(psa.getSyncFlag().equals(0)){
					psa.setSyncFlag(3);
				}else if(psa.getSyncFlag().equals(1)){
					psa.setSyncFlag(2);
				}
			}
			if(acceptFlag==2) psa.setAuditState(1);
			else if(acceptFlag==3) psa.setAuditState(3);
			else if(acceptFlag==5) psa.setAuditState(5);
			else if(acceptFlag==7) psa.setAuditState(3);
		}else if(//预约复查状态更新
				psa.getProductType().equals(Constant.Business.PRODUCT_TYPE_REVIEW_APPOINTMENT)){
			switch (acceptFlag) {
			case 2:
				psa.setAuditState(1);
				break;
			case 3:
				psa.setAuditState(3);
				break;
			case 5:
				psa.setAuditState(4);
				break;
			case 7:
				psa.setAuditState(2);
				break;
			}
		}
	}

	/**
	 * 正式给医生打款
	 * 
	 * @param state
	 * @param orderId
	 */
	private String doMakeProfit(int state, String orderId) {
		// TODO Auto-generated method stub
		try {
			String debitRecId = accountService.makeProfit(state, orderId);
			if (debitRecId != null) {
				LogUtil.log.info(
						Constant.LOGTAG.OK + "Make profit for doctor succeed. orderId=" + orderId + ",state=" + state);
				return debitRecId;
			} else {
				// 写故障日志!!!
				LogUtil.logError.error(
						Constant.LOGTAG.ERR + "Make profit for doctor failed. orderId=" + orderId + ",state=" + state);
				return null;
			}
		} catch (Exception e) {
			LogUtil.logError.error(
					Constant.LOGTAG.ERR + "Make profit for doctor exception. orderId=" + orderId + ",state=" + state);
			return null;

		}

	}

	/**
	 * 判断是否需要打款操作。除了套餐类产品如私人医生是在同意后就打款外，其他产品都是在完成服务才进行打款
	 * 
	 * @param state
	 * @param productType
	 * @return
	 */
	private boolean needMakeProfit(int state, int packageFlag, int inPackage, int isAutoAccept) {
		// TODO Auto-generated method stub
		if (inPackage == 1) {
			return false;// 套餐内子产品，无需支付和打款，已在套餐支付和打款
		}
		if (isAutoAccept == 1) {
			if (state == 2)
				return true;
		}
		if (packageFlag == 1) {
			if (state == 2) // 套餐父类产品，同意后即打款
				return true;
			else
				return false;
		} else {
			if (state == 5 || state == 8 || state == 9)
				return true;
			else
				return false;
		}

	}

	/**
	 * 退款或退还配额（如果是套餐方式）操作
	 * 
	 * @author DaLoong
	 * @date 2016/1/25
	 * @param psa
	 */
	private void doCancelProductService(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		LogUtil.log.info("============== Do cancel product service!! productApplyId=" + psa.getProductApplyId()
				+ ",productType=" + psa.getProductType() + ",productId=" + psa.getProductId());
		try {
			if (psa.getInPackage() == 1) {
				// 套餐内产品，则只需退还配额即可
				givebackQuota(psa);
			} else {
				refund(psa);// 需要退款
			}
			if(needCancelProductService(psa.getState(),0))//特殊服务完成退款不退号
				if (psa.getProductType() == Constant.Business.PRODUCT_TYPE_CLINIC||psa.getProductType()==Constant.Business.PRODUCT_TYPE_REVIEW_APPOINTMENT)
					givebackClinic(psa); // 归还门诊预约
		} catch (Exception e) {
			LogUtil.logError.error(Constant.LOGTAG.ERR + "doCancelProductService() failed! error=" + e.getMessage());
		}
	}

	/**
	 * 退还门诊预约
	 * 
	 * @param psa
	 */
	private void givebackClinic(ProductServiceApply psa) {
		DoctorClinicUsageSetReq req = null;
		if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_CLINIC){
			req=JsonUtil.toObject(psa.getRemark(), DoctorClinicUsageSetReq.class);
		}else if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_REVIEW_APPOINTMENT){
			Map map = JsonUtil.toObject(psa.getDescription(), HashMap.class);
			if(map.get("clinicUsage")!=null){
				req = JsonUtil.toObject(JsonUtil.toJson(map.get("clinicUsage")), DoctorClinicUsageSetReq.class);
			}
		}
		if(req!=null){
			doctorService.backClincUsage(req);
		}
	}

	/**
	 * 执行真正的退款请求。调用交易系统的服务。
	 * 
	 * @param psa
	 */
	private void refund(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		LogUtil.log.info("============ Begin to call the trade system's remote method payService.refund()... orderId="
				+ psa.getOrderId() + ",state=" + psa.getState());
		int respCode = 1500;
		try {
			respCode = payService.refund(psa.getState(), psa.getOrderId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogUtil.logError.error("############ ERROR!! call payService.refund() failed.");
		}
		if (respCode == 0)// success
		{
			LogUtil.log.info("============ Ok! refund succeed.");
		} else {
			// !!!如果失败，应该重试，并且写故障日志。
			LogUtil.log.info("###########  ERROR!! refund failed.");

		}
	}

	/**
	 * 归还套餐内产品使用配额
	 * 
	 * @param psa
	 */
	private void givebackQuota(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		// 归还套餐配额
		TProductPackageQuotaUsageInfo packageUsageInfo = packageQuotaHandler.getPackageQuotaUsageInfo(psa.getBuyer(),
				psa.getVendor(), psa.getProductType());
		if (packageUsageInfo == null) {
			// 无套餐。直接返回
			LogUtil.log.error("######## givebackQuota failed! getPackageQuotaUsage return no package. productType="
					+ psa.getProductType() + ",productApplyId=" + psa.getProductApplyId());
			return;
		}
		if (packageUsageInfo.getUsage() == 0) {
			LogUtil.log.error("######## givebackQuota failed! getPackageQuotaUsage return usage = 0. productType="
					+ psa.getProductType() + ",productApplyId=" + psa.getProductApplyId() + "quotaUsageId="
					+ packageUsageInfo.getQuotaUsageId());

			return;
		}
		LogUtil.log.info("=========givebackQuota(): getPackageQuotaUsage Ok! usageAvailable="
				+ packageUsageInfo.getPackageUsageAvailable() + ". productType=" + psa.getProductType()
				+ ",productApplyId=" + psa.getProductApplyId() + ",quotaUsageId=" + packageUsageInfo.getQuotaUsageId());

		packageQuotaHandler.giveBackPackageProductQuota(packageUsageInfo.getQuotaUsageId(), psa.getProductType());

	}

	private boolean needCancelProductService(int state,int isRefund) {
		// TODO Auto-generated method stub
		// 如果state是3,6,7,11需要退款处理
		return ProductAcceptStateChecker.instance().checkCancelState(state,isRefund);
	}

	private void setAcceptState(ProductServiceApply psa, int acceptFlag) {
		// TODO Auto-generated method stub
		psa.setState(acceptFlag);
		if (psa.getProductType() != Constant.Business.PRODUCT_TYPE_MDT&&psa.getProductType()!=Constant.Business.PRODUCT_TYPE_MEDICAL_RECORD_MAIL) // MDT业务由运营平台改变progressState
			if (psa.getState() != 11) // 电话咨询11不需要设置
				psa.setProgressState(getProgressState(acceptFlag, psa.getProductType()));
	}

	private int checkAcceptState(ProductServiceApply psa, int acceptFlag) {
		// TODO Auto-generated method stub
		// 进行正式处理前，需要做状态检查。某个处理请求，必须在允许的状态下才能被执行，否则拒绝
		if (ProductAcceptStateChecker.instance().acceptStateCheck(acceptFlag, psa.getState()))
			return 0;// success
		else
			return 1417;
	}

	private int checkAndSetParameter(ProductServiceApply psa, int acceptFlag, Date consultOrderTime) {
		int state = acceptFlag;
		if (state <= 0) {
			LogUtil.logError.error("setAcceptProduct() failed: parameter error: acceptFlag can not be 0");
			return 1400;
		}
		if (psa == null) {
			LogUtil.logError.error("setAcceptProduct() failed: parameter error: productApplyId not found");
			return 1404;

		}

		// 参数检查。如果是电话咨询，则acceptFlag=2时，需要携带预约时间consultOrderTime
		if (psa.getProductType() == Constant.Business.PRODUCT_TYPE_TEL) {
			if (acceptFlag == 2) {
				if (consultOrderTime == null) {
					LogUtil.logError.error(
							"setAcceptProduct() failed: parameter error: consultOrderTime can not be empty when acceptFlag=2 and productType=2");
					return 1400;
				}
				// 设置预约时间
				psa.setConsultOrderTime(consultOrderTime);
				// 计算过期时间
				// psa.setExpireTime(caculateTelConsultExpireTime(consultOrderTime));
				LogUtil.log.info("Accept TelConsult service: buyer=" + psa.getBuyer() + "vendor=" + psa.getVendor()
						+ ",productApplyId=" + psa.getProductApplyId() + ",consultOrderTime=" + consultOrderTime
						+ ",intervalTime=" + psa.getIntervalTime() + "min.");
			} else if (acceptFlag == 5 || acceptFlag == 10) {
				// 对于电话咨询，正常关闭时或未接听时的时间即发生时间。
				psa.setConsultHappenTime(new Date());

			}
		}
		if (psa.getProductType() == Constant.Business.PRODUCT_TYPE_RICHTEXT) {
			// 对于图文咨询，关闭时间为最后发生时间
			if (acceptFlag == 8 || acceptFlag == 9)
				psa.setConsultHappenTime(new Date());
		}

		if (psa.getProductType() == Constant.Business.PRODUCT_TYPE_FOLLOWUP_MESSAGE) {
			// 随访服务 关闭最后发生
			if (acceptFlag == 9)
				psa.setConsultHappenTime(new Date());
		}
		
		if(psa.getProductType() == Constant.Business.PRODUCT_TYPE_REVIEW_APPOINTMENT){//默认5天后完成
			if(acceptFlag==2){
				if(consultOrderTime!=null){
					psa.setConsultOrderTime(new Date(consultOrderTime.getTime()+5*24*60*60*1000));
				}else{
					psa.setConsultOrderTime(new Date(System.currentTimeMillis()+5*24*60*60*1000));
				}
			}
		}
		// 如果是服务正在进行中，则修改consultHappenTime
		if (acceptFlag == 4) {
			psa.setConsultHappenTime(new Date());
		}

		return 0;// success

	}

	/**
	 * 检查服务申请请求参数
	 * 
	 * @param productApply
	 * @param msg
	 * @return
	 */

	private boolean checkProductApplyPara(TProductApply productApply,
			com.esuizhen.cloudservice.business.bean.TMsgResponse<Map<String, Object>> msg) {
		// TODO Auto-generated method stub
		TOrderPublishInfo orderInfo = productApply.getOrderInfo();
		if (orderInfo == null) {
			msg.respCode = 1400;
			msg.respMsg = "parameter error: orderInfo can not be null";
			LogUtil.logError.error("checkProductApplyPara failed: " + msg.respMsg);
			return false;
		}

		/**
		 * orderInfo check
		 */
		if (orderInfo.getOrderId() == null || orderInfo.getOrderId().isEmpty()) {// orderId不能为空。
			msg.respCode = 1400;
			msg.respMsg = "parameter error: orderInfo.orderId is empty";
			LogUtil.logError.error(msg.respMsg);
			return false;
		}
		if (orderInfo.getBuyer() < 10) {// 用户ID从10开始编号
			msg.respCode = 1400;
			msg.respMsg = "parameter error: orderInfo.buyer empty or invalid";
			LogUtil.logError.error(msg.respMsg);
			return false;
		}
		if (orderInfo.getVendor() < 9) {// 9是允许的，代表易随诊平台本身
			msg.respCode = 1400;
			msg.respMsg = "parameter error: orderInfo.vendor empty or invalid";
			LogUtil.logError.error(msg.respMsg);
			return false;
		}
		if (orderInfo.getProductType() < 1) {
			msg.respCode = 1400;
			msg.respMsg = "parameter error: orderInfo.productType invalid: " + orderInfo.getProductType();
			LogUtil.logError.error(msg.respMsg);
			return false;
		}

		if (orderInfo.getOrderTitle() == null || orderInfo.getOrderTitle().isEmpty()) {
			msg.respCode = 1400;
			msg.respMsg = "parameter error: orderInfo.orderTitle empty";
			LogUtil.logError.error(msg.respMsg);
			return false;
		}

		if (orderInfo.getProductId() == null || orderInfo.getProductId().isEmpty()) {
			msg.respCode = 1400;
			msg.respMsg = "parameter error: orderInfo.productId empty";
			LogUtil.logError.error(msg.respMsg);
			return false;

		}

		return true;
	}

	/**
	 * 发出申请通知
	 * 
	 * @param orderInfo
	 */
	private void sendConsultingApplyNotify(TOrderPublishInfo orderInfo) {
		// TODO Auto-generated method stub
		// 发出咨询消息通知到医生和患者
		try {
			switch (orderInfo.getProductType()) {
			case Constant.Business.PRODUCT_TYPE_RICHTEXT:// 图文咨询
				notifySender.sendRichTextConsultingApplyNotify(orderInfo);
				break;
			case Constant.Business.PRODUCT_TYPE_TEL:// 电话咨询
				notifySender.sendTelConsultingApplyNotify(orderInfo);
				break;
			case Constant.Business.PRODUCT_TYPE_MDT:
				notifySender.sendMdtApplyNotify(orderInfo);
				break;
			case Constant.Business.PRODUCT_TYPE_CONVENIENT:// 便利救诊包
			case Constant.Business.PRODUCT_TYPE_MONITOR_ILLNESS:// 病情监控包
			case Constant.Business.PRODUCT_TYPE_FOLLOWUP_BUSINESS:// 随诊服务包
				notifySender.sendHospitalPackApplyNotify(orderInfo);
				break;
			case Constant.Business.PRODUCT_TYPE_MEDICAL_RECORD_MAIL://病案复印
				expressNotifySender.sendExpressApplyNotifyToPatient(orderInfo);
				break;
			case Constant.Business.PRODUCT_TYPE_INSPECTION_RESULT://检查结果查询
				break;
			case Constant.Business.PRODUCT_TYPE_FOLLOWUP_MESSAGE: // 随访消息
				notifySender.sendFollowupMessageApplyNotify(orderInfo);
				break;
			case Constant.Business.PRODUCT_TYPE_REVIEW_APPOINTMENT: // 复查预约
				break;
			default:
				notifySender.sendOtherProductApplyNotify(orderInfo);
				break;
			}
		} catch (Exception e) {
			LogUtil.logError.error("ERROR in sendConsultingApplyNotify(): " + e.getMessage());
		}

	}

	private int getProgressState(int state, int productType) {
		int progressState = 0;
		switch (state) {
		case 3:
			progressState = 0;
			break;
		case 2:
			if (productType == 2)// 电话咨询，即使同意了，也是0
				progressState = 0;
			else
				progressState = 1;
			break;

		case 4:
			progressState = 1;
			break;
		case 5:
		case 8:
		case 9:
			progressState = 3;
			break;
		case 6:
		case 7:
			progressState = 0;
			break;
		case 10:
			progressState = 2;
			break;
		default:
			break;
		}

		return progressState;
	}

	private Date caculateTelConsultExpireTime(Date consultOrderTime) {
		// TODO Auto-generated method stub
		// 对于电话咨询，过期时间就是预约时间
		return DateUtil.getOffsetMinutes(consultOrderTime, 30);
	}

	/**
	 * 发送产品处理（接受/同意/取消/拒绝/关闭等）推送。关于产品服务状态变化，统一都在这里推送。
	 * 
	 * @param psa
	 */
	private void sendApplyAcceptNotify(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		try {
			switch (psa.getProductType()) {
			case Constant.Business.PRODUCT_TYPE_RICHTEXT:// 图文咨询
				acceptNotifySender.sendRichTextConsultingApplyAcceptNotify(psa);
				break;
			case Constant.Business.PRODUCT_TYPE_TEL:// 电话咨询
				acceptNotifySender.sendTelConsultingApplyAcceptNotify(psa);
				break;
			case Constant.Business.PRODUCT_TYPE_CONVENIENT: // 便利就诊包
			case Constant.Business.PRODUCT_TYPE_MONITOR_ILLNESS: // 病情监控包
			case Constant.Business.PRODUCT_TYPE_FOLLOWUP_BUSINESS: // 病情监控包
				acceptNotifySender.sendHospitalPackApplyNotify(psa);
				break;
			case Constant.Business.PRODUCT_TYPE_MEDICAL_RECORD_MAIL:// 病案邮寄
				acceptNotifySender.sendMedicalRecordMailApplyNotify(psa);
				break;
			case Constant.Business.PRODUCT_TYPE_FOLLOWUP_MESSAGE:// 随访消息
				acceptNotifySender.sendFollowupMessageApplyAcceptNotify(psa);
				break;
			case Constant.Business.PRODUCT_TYPE_GRATUITY://打赏服务
				acceptNotifySender.sendGratuityNotify(psa);
				break;
			default:
				acceptNotifySender.sendOtherApplyAcceptNotify(psa);
				break;
			}
		} catch (Exception e) {
			LogUtil.logError.error("ERROR in sendConsultingApplyNotify(): " + e.getMessage());
		}

	}

	/**
	 * 修改了电话咨询时间，需要发出推送
	 * 
	 * @param isAllowed
	 * @param productApply
	 */
	private void sendModifyTelConsultTimeNotify(ProductServiceApply psa, boolean isAllowed) {
		telNotifySender.sendModifyTelConsultTimeNotify(psa, isAllowed);

	}

	@Override
	public void modifyTelConsultingTime(TProductApply productApply) throws Exception {
		// TODO Auto-generated method stub
		ProductServiceApply psa = dao.getProductServiceApplyInfo(productApply.getProductApplyId());

		// 判断时间是否允许修改范围内。1小时内，不允许修改了。
		boolean isAllowed = isAllowedModifyTelConsultingTime(psa.getConsultOrderTime());
		if (isAllowed) {
			psa.setConsultOrderTime(productApply.getConsultOrderTime());
			dao.modifyTelConsultingTime(productApply);
			// 需要重新生成电话咨询的定时提醒任务
			timerTaskHandler.recreateTelConsultAlertTimerTask(psa);
			LogUtil.log.info("================ modifyTelConsultingTime succeed. productApplyId="
					+ psa.getProductApplyId() + ",consultTime=" + productApply.getConsultOrderTime());
		}

		// 发出推送. 如果是1小时内进行的修改请求，则下发一个失败
		sendModifyTelConsultTimeNotify(psa, isAllowed);

		if (!isAllowed)
			throw new TimeTooShortException("unacceptable request: the time to modify is in one hour.");

	}

	public static boolean isAllowedModifyTelConsultingTime(Date consultOrderTime) {
		// TODO Auto-generated method stub
		long interval = (consultOrderTime.getTime() - System.currentTimeMillis()) / 1000;
		LogUtil.log.debug("consultOrderTime= " + consultOrderTime + ",now=" + new Date() + ",interval=" + interval);
		if (interval <= 3600) {
			LogUtil.logError.error("#######  modify telconsulting time not allowed: in one hour!");
			return false;
		}
		return true;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void setSummarizeRichtextChatConsulting(TProductApply productApply) {
		// 如果没有备注信息 不保存 直接关闭咨询
		if (StringUtils.isNotEmpty(productApply.getSummarization()) && productApply.getSummarization().length() > 0)
			dao.modifyProductServiceApply(productApply);
		ProductServiceApply psa = dao.getProductServiceApplyInfo(productApply.getProductApplyId());
		int result = 0;
		// 随访通道需要特殊处理 如果患者端未回复 自动为同意
		if (psa.getProductType() == Constant.Business.PRODUCT_TYPE_FOLLOWUP_MESSAGE && psa.getState() == 1)
			result = setAcceptProduct(productApply.getProductApplyId(), 2, null);
		// 同时需要调用Accept接口，传入acceptFlag=9,表示医生关闭。
		if (result == 0)
			result = setAcceptProduct(productApply.getProductApplyId(), 9, null);

		if (0 == result) {
			LogUtil.log.info("setSummarizeRichtextChatConsulting() succeed. productApplyId="
					+ productApply.getProductApplyId() + ",acceptFlag=9");
		} else {
			LogUtil.logError.error("setSummarizeRichtextChatConsulting() failed. productApplyId="
					+ productApply.getProductApplyId() + ",acceptFlag=9. result=" + result);

		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void setProductServiceEvaluate(TProductApply productApply) {
		// TODO Auto-generated method stub
		try {
			dao.modifyProductServiceApply(productApply);
			// 给医生发送message
			String level = pushInnerService.getMessage(PushContentUtil.getBusinessPushContent(
					"tips.service.richtextconsult.score.notify.todoctor.level." + productApply.getServiceLevel()));
			String content = pushInnerService.getMessage(
					PushContentUtil.getBusinessPushContent("tips.service.richtextconsult.score.notify.todoctor",
							new Object[] { level, productApply.getEvaluationRemark() }));
			this.pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("tips.service.richtextconsult.score.notify.todoctor.title"));
			ProductServiceApply psa = dao.getProductServiceApplyInfo(productApply.getProductApplyId());
			ImMessageInfo im = ImMessageUtil.getSysImMessageInfo();
			im.setContent(content);
			im.setServiceId(1);
			im.setAudienceId(psa.getVendor());
			im.setSpeakerId(psa.getBuyer());
			im.setContentType(1);
			messageService.sendInnerMessage(im);
		} catch (Exception e) {
			LogUtil.logError.error("ERROR in setProductServiceEvaluate(): " + e.getMessage());
		}
	}

	@Override
	public ProductServiceApply getProductServiceEvaluation(String productApplyId) {
		ProductServiceApply psa = dao.getProductServiceApplyScoreInfo(productApplyId);
		if (psa.getEvaluationServiceLevel() != null && psa.getEvaluationServiceLevel() != 0)
			psa.setState(1);
		else
			psa.setState(0);
		return psa;
	}

	/**
	 * 检查订购关系 return: state: -1：无订购或失效；0:等待医生确认； 1：有订购关系且服务有效中 productApplyId
	 */
	@Override
	public TProductSubscriptionInfo checkProductSubscription(Long buyer, Long vendor, Integer productType,
			String productId) {
		// TODO Auto-generated method stub
		// 1. 查询产品申请表中state=1（已支付）、2(已同意）或4（服务进行中）的记录
		// 若无，则将订购状态设为-1返回；等待医生确认，返回订购状态为0；医生已同意，返回订购状态为1.
		TProductSubscriptionInfo resultInfo = new TProductSubscriptionInfo();
		resultInfo.setState(-1);
		try {
			resultInfo = dao.getProductSubcriptionInService(buyer, vendor, productType, productId);
			if (resultInfo == null) {
				resultInfo = new TProductSubscriptionInfo();
				resultInfo.setState(-1);
			} else {
				if (BusinessUtil.isSubscriptionValid(resultInfo.getState()))
					resultInfo.setState(1); // 医生已同意
				else if (BusinessUtil.isSubscriptionWaitConfirm(resultInfo.getState()))
					resultInfo.setState(0); // 等待医生确认
				else
					resultInfo.setState(-1);
			}

			if (productType == null)
				return resultInfo;

			// 2.对于电话咨询，调用本接口还有一个特殊用途，就是实现距离咨询时间动态刷新：如果检查到存在服务关系，则推一条新的消息，顶掉原来的消息
			if (resultInfo.getState() == 1 && productType.intValue() == Constant.Business.PRODUCT_TYPE_TEL) {
				tryRefreshTelConsultIntervalTime(resultInfo.getProductApplyId());

			}

			// 3.可能为套餐产品，所以还要查询套餐情况。
			TProductPackageQuotaUsageInfo packageUsageInfo = packageQuotaHandler.getPackageQuotaUsageInfo(buyer, vendor,
					productType);
			if (packageUsageInfo == null) {
				// 无套餐。直接返回
				LogUtil.log.info("getPackageQuotaUsage: no package. productType=" + productType + ",buyer=" + buyer
						+ ",vendor=" + vendor);
				return resultInfo;
			}
			// 是套餐
			LogUtil.log.info("getPackageQuotaUsage Ok! usageAvailale=" + packageUsageInfo.getPackageUsageAvailable()
					+ ". productType=" + productType + ",buyer=" + buyer + ",vendor=" + vendor);
			resultInfo.setInPackage(1);
			resultInfo.setAvailableNum(packageUsageInfo.getPackageUsageAvailable());
			resultInfo.setQuota(packageUsageInfo.getQuota());
			resultInfo.setParentProductName(packageUsageInfo.getParentProductName());

			return resultInfo;
		} catch (Exception e) {
			// 不在外部抛异常，始终返回成功。
			LogUtil.logError.error("Dao exeption in checkProductSubscription(): " + e.getMessage());
			return resultInfo;
		}

	}

	private void tryRefreshTelConsultIntervalTime(String productApplyId) {
		// TODO Auto-generated method stub
		try {
			ProductServiceApply psa = dao.getProductServiceApplyInfo(productApplyId);
			if (psa == null) {
				LogUtil.logError
						.error("tryRefreshTelConsultIntervalTime() failed:  productApplyId or productId not found. productApplyId="
								+ productApplyId);
			} else {
				// 先看看是否过期
				int intervalTime = psa.getIntervalTime();
				if (intervalTime < 0) {
					intervalTime = -intervalTime;
					if (intervalTime >= 30) {
						if (psa.getState() <= 4) {
							// 已过期。则调用cancel
							LogUtil.log.info(Constant.LOGTAG.INF
									+ "checkProductSubscription to refresh the interval time for telconsult but find it is already expired and we cancel it. productApplyId="
									+ psa.getProductApplyId());
							setAcceptProduct(psa.getProductApplyId(), 6, null);
							return;
						}
					}
				}
				// 刷新时间
				telNotifySender.refreshTelConsultIntervalTime(psa);
			}
		} catch (Exception e) {
			LogUtil.logError.error("tryRefreshTelConsultIntervalTime() failed:  error=" + e.getMessage());
			return;
		}

	}

	@Override
	public TProductSubscriptionInfo queryProductOrderState(Long buyer, String orderId) {
		TProductSubscriptionInfo resultInfo = new TProductSubscriptionInfo();
		resultInfo.setState(-1);
		try {
			resultInfo = dao.queryProductOrderState(buyer, orderId);
			if (resultInfo == null) {
				resultInfo = new TProductSubscriptionInfo();
				resultInfo.setState(-1);

			} else {
				if (BusinessUtil.isSubscriptionValid(resultInfo.getState()))
					resultInfo.setState(1);
				else if (BusinessUtil.isSubscriptionWaitConfirm(resultInfo.getState()))
					resultInfo.setState(0);
				else
					resultInfo.setState(-1);
			}
		} catch (Exception e) {
			// 不在外部抛异常，始终返回成功。
			LogUtil.logError.error("Dao exeption in checkProductSubscription(): " + e.getMessage());
		}
		return resultInfo;
	}


	/**
	 * 执行真正的产品服务申请 来自交易系统的回调通知（通过微信支付后：微信端-交易系统-服务系统）以及直接从微信过来的调用（无需支付时，
	 * 如购买了私人医生之后再进行的图文或电话咨询申请），均最终调用本方法完成服务产品申请记录生成。
	 * 
	 * @param productApply
	 * @return
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	private com.esuizhen.cloudservice.business.bean.TMsgResponse<Map<String, Object>> doProductApply(
			TProductApply productApply, boolean isFromTradeSystem, boolean newly) throws Exception {

		TMsgResponse<Map<String, Object>> msg = new TMsgResponse<Map<String, Object>>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		/** 参数检查 */
		if (!checkProductApplyPara(productApply, msg)) {
			LogUtil.logError.error("ERROR in createApplyProductSync(): checkProductApplyPara failed: " + msg.respMsg
					+ ",buyer=" + productApply.getOrderInfo().getBuyer() + ",vendor="
					+ productApply.getOrderInfo().getVendor());

			return msg;
		}
		/** 检查 是否是代理申请 */
		checkIsAgentApplicant(productApply);
		/** 获取申请信息附带的订单信息*/
		TOrderPublishInfo orderInfo = productApply.getOrderInfo();
		String orderId = orderInfo.getOrderId();
		/** 创建服务*/
		ProductServiceApply psa = productApply.createProductServiceApply();
		psa.setOrderId(orderId);
		ProductServiceConf conf = dao.getProductServiceConfById(psa.getProductId());
		setCancelAndExpireTime(psa, conf);
		psa.setPeriodFeeType(conf.getPeriodFeeType());

		/** 0. 这里判断订单是否存在，如果存在，则更新一下状态 */
		if (isFromTradeSystem && isExistProductApplyByOrderId(orderId)) {
			psa.setProductApplyId(dao.getProductApplyIdByOrderId(orderId));
			productApply.setProductApplyId(psa.getProductApplyId());
			// 同步或其他时该值不会初始化
			if (psa.getProgressState() == 0)
				psa.setProgressState(null);
			this.dao.modifyProductServiceApplyState(psa);
			if (psa.getProgressState() == null)
				psa.setProgressState(0);
			LogUtil.log.info("========= Such order exist already and modifyProductServiceApplyState succeed. orderId="
					+ orderId + ",state=" + psa.getState());
		} else {
			/** 1. 创建申请记录 */
			// 先判断是否允许重复购买，如果不允许，则直接报错。
			TProductSubscriptionInfo resultInfo = dao.getProductSubcriptionInService(psa.getBuyer(), psa.getVendor(),
					psa.getProductType(), null);
			if (resultInfo != null) {
				if (resultInfo.getSubscriptionFlag() > -1 && conf.getRepurchaseFlag() == 0) {
					LogUtil.logError
							.warn(Constant.LOGTAG.ERR + "create product apply failed! 此服务不允许重复购买或申请! productType="
									+ psa.getProductType() + ",buyer=" + psa.getBuyer());
					msg.respCode = 1405;
					msg.respMsg = "此服务不允许重复申请!";
					return msg;
				}
			}
			/* 微信ProductId为空判断 */
			if (psa.getWxProductId() == null) {
				PushUser pushUser = userDao.getPushOpenIdByUserId(orderInfo.getBuyer());
				if (pushUser != null) {
					psa.setWxProductId(pushUser.getProductId());
					productApply.getOrderInfo().setWxProductId(pushUser.getProductId());
				}
			}
			//子服务特殊处理
			if(psa.getProductSubType()!=null
					&&psa.getProductSubType().equals(Constant.Business.PRODUCT_TYPE_MEDICAL_RECORD_RECEIVE))//病案复印
				psa.setServiceCode(this.getProductApplyServiceCode());
			//填入productApplyTips
			setProductApplyTips(productApply, psa, conf);
			//创建服务数据
			dao.createProductServiceApply(psa);
			LogUtil.log.info("========= Ok! create product apply succeed. productApplyId=" + psa.getProductApplyId()
					+ ",buyer=" + productApply.getOrderInfo().getBuyer() + ",vendor="
					+ productApply.getOrderInfo().getVendor() + ",productType=" + psa.getProductType() + ",orderTitle="
					+ productApply.getOrderInfo().getOrderTitle() + ",inPackage="
					+ productApply.getOrderInfo().getInPackage() + ",state=" + psa.getState() + ",tips="
					+ psa.getTips());
			// 更改订购关系动态信息表
			subscriptionVipHandler.setSubscriptionFlag(psa);
			//如果为自动接收服务，直接返回 服务状态
			msg.respCode = conf.getIsAutoAccept();
		}
		boolean pushFlag = true;
		
		//服务具体详情处理
		pushFlag = this.productServiceDetailHandle(msg,productApply,psa,pushFlag,newly);
		/**
		 * 2.套餐处理。如果是套餐，则需要设置服务配额表。 对于套餐父类产品，例如私人医生，需要设置其图文咨询、电话咨询、预约挂号的配额
		 * 对于套餐的子产品，如图文咨询等，则需要修改配额的使用量
		 */
		this.packageQuotaHandler.doPackageProductQuota(productApply.getOrderInfo(), psa, isFromTradeSystem); // 如果数据库出错则抛出异常，自动回滚。

		/**
		 * 3.创建订单. 对于直接来自客户端的调用（如套餐内产品）才需要，如果是已经交易支付（来自交易系统）的，则无需创建订单了，
		 * 因为已经在交易系统通过PrepareOrderPay创建过了。
		 */
		if (!isFromTradeSystem) {
			if (psa.getInPackage() == 1) {
				orderInfo.setInPackage(1);
				orderInfo.setUsage(psa.getUsage());
				orderInfo.setQuota(psa.getQuota());
				orderInfo.setParentProductName(psa.getParentProductName());
				LogUtil.log.info(Constant.LOGTAG.INF + "InPackage!! set orderPublishInfo quota=" + orderInfo.getQuota()
						+ ",usage=" + orderInfo.getUsage());
			}
			LogUtil.log.debug(JsonUtil.toJson(orderInfo));
			this.orderService.createOrder(orderInfo);// 如果inPackage=1,则state已经被置为了1.
														// 但交易系统不做计费处理，因为套餐已经付过费了。
			LogUtil.log.info("========= Ok! Calling the trade system's remote method createOrder() succeed. orderId="
					+ orderInfo.getOrderId() + ",state=" + orderInfo.getState());
		}

		/** 4. 生成咨询消息通知 , 通知医生端进行处理 */
		productApply.getOrderInfo().setProductApplyId(psa.getProductApplyId());
		productApply.getOrderInfo().setOrderId(orderId);
		if (pushFlag) {
			sendConsultingApplyNotify(productApply.getOrderInfo());
		}

		/** 5. 返回正确响应 */
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("productApplyId", psa.getProductApplyId());
		result.put("orderId", psa.getOrderId());
		result.put("wxProductId", psa.getWxProductId());
		if (productApply.getMdtApplyInfo() != null) {
			result.put("id", productApply.getMdtApplyInfo().getId());
		}
		msg.result = result;

		LogUtil.log.info(
				"========= OK! Do ProductApply succeed.productApplyId=" + psa.getProductApplyId() + "=========\n");
		return msg;
	}
	
	private String getProductApplyServiceCode(){
		String serviceCode=dao.getRandomProductApplyServiceCode();
		if(StringUtils.isBlank(serviceCode)){
			serviceCode=getProductApplyServiceCode();
		}
		return serviceCode;
	}
	
	private void renewPatientNo(TProductApply productApply) {
		TOrderPublishInfo orderInfo=productApply.getOrderInfo();
		HospitalPatientBriefInfo hospitalPatientBriefInfo = this.patientDao
				.findHospitalProfile(productApply.getMdtApplyInfo().getApplyHospitalId(), orderInfo.getBuyer());
		Patient patient = this.patientDao.findByUserId(orderInfo.getBuyer());
		if (hospitalPatientBriefInfo == null) {

			hospitalPatientBriefInfo = new HospitalPatientBriefInfo();
			hospitalPatientBriefInfo.setHospitalId(productApply.getMdtApplyInfo().getApplyHospitalId());
			hospitalPatientBriefInfo.setPatientId(patient.getPatientId());
			hospitalPatientBriefInfo.setPatientNo(productApply.getMdtApplyInfo().getPatientNo());
			hospitalPatientBriefInfo.setSourceFlag(0);
			hospitalPatientBriefInfo.setSyncFlag(0);
			this.patientDao.inserHospitalPatientBriefInfo(hospitalPatientBriefInfo);
		} else if (StringUtils.isEmpty(hospitalPatientBriefInfo.getPatientNo())) {
			this.patientDao.updatePatientNo(productApply.getMdtApplyInfo().getApplyHospitalId(), patient.getPatientId(),
					productApply.getMdtApplyInfo().getPatientNo());
		}
	}
	/** 检查是否代理申请人 是否有推荐医生Name */
	private void checkIsAgentApplicant(TProductApply tProductApply) {
		if (tProductApply.getOrderInfo() != null) {
			TOrderPublishInfo orderInfo = tProductApply.getOrderInfo();
			if (orderInfo.getAgentApplicant() != null && StringUtils.isEmpty(orderInfo.getRecommendedDoctor())) {
				orderInfo.setRecommendedDoctor(
						this.userDao.getUserTrueName(orderInfo.getAgentApplicant(), Constant.User.ROLE_DOCTOR));
			}
		}
	}

	private void setProductApplyTips(TProductApply productApply, ProductServiceApply psa, ProductServiceConf conf) {
		// TODO Auto-generated method stub
		float price = productApply.getOrderInfo().getRealPrice();// -productApply.getOrderInfo().getPlusPrice();
		String tips = pushInnerService
				.getMessage(PushContentUtil.getBusinessPushContent("tips.service.applynotify.todoctor",
						new Object[] { productApply.getOrderInfo().getOrderTitle(), "" + price }));
		if (productApply.getOrderInfo().getPlusPrice() > 0)
			tips += pushInnerService
					.getMessage(PushContentUtil.getBusinessPushContent("tips.service.applynotify.todoctor.2",
							new Object[] { "" + productApply.getOrderInfo().getPlusPrice() }));
		psa.setTips(tips);

	}
	private void setCancelAndExpireTime(ProductServiceApply psa, ProductServiceConf conf) {
		// TODO Auto-generated method stub
		if (conf != null) {
			if (conf.getExpireTime() > 0 && conf.getSpecType() == 1) {
				if (conf.getIsAutoAccept() == 0)
					psa.setExpireTime(DateUtil.getFactOffsetMinutes(conf.getExpireTime()));
				else {
					TProductSubscriptionSimpleInfo sub = dao.getPraveProductApplySimpleInfo(psa);
					if (sub != null && sub.getExpireTime() != null)
						psa.setExpireTime(DateUtil.getFactOffsetMinutes(sub.getExpireTime(), conf.getExpireTime()));
					else
						psa.setExpireTime(DateUtil.getFactOffsetMinutes(conf.getExpireTime()));
					LogUtil.log.debug("isAutoAccept expireTime next not set");
				}
				LogUtil.log.debug(
						"========== Set expireTime=" + psa.getExpireTime() + "(" + conf.getExpireTime() + " min)");
			} else
				LogUtil.log.debug("========== Use default expireTime=" + psa.getExpireTime() + "("
						+ conf.getExpireTime() + " min)");

			if (conf.getIdleCancelTime() > 0) {
				psa.setIdleCancelTime(DateUtil.getOffsetMinutes(conf.getIdleCancelTime()));
				LogUtil.log.debug("========== Set idleCancelTime=" + psa.getIdleCancelTime() + "("
						+ conf.getIdleCancelTime() + " min)");
			} else
				LogUtil.log.debug("========== Use default idleCancelTime=" + psa.getIdleCancelTime() + "("
						+ conf.getIdleCancelTime() + " min)");
			//写入完成操作
			psa.setIsRefund(conf.getIsRefund());
		} else
			LogUtil.logError
					.error("ERROR when setCancelAndExpireTime(); read configuration from table conf_product_service failed. productType="
							+ psa.getProductType() + ",productId=" + psa.getProductId());

	}

	private void setExpireTime(ProductServiceApply psa, ProductServiceConf conf) {
		// TODO Auto-generated method stub
		if (conf != null) {
			//周期时间设置
			if (conf.getExpireTime() > 0 && conf.getSpecType() == 1) {
				if (conf.getIsAutoAccept() == 0) {
					switch (psa.getProductType()) {
					case Constant.Business.PRODUCT_TYPE_FOLLOWUP_MESSAGE: // 随访消息特殊处理，过期时间为取消服务时间
						psa.setExpireTime(psa.getIdleCancelTime());
						break;
					default:
						psa.setExpireTime(DateUtil.getFactOffsetMinutes(conf.getExpireTime()));
						break;
					}
				} else {
					LogUtil.log.debug("======== is autoAccept not set expireTime,becouse at in create set");
				}
				LogUtil.log.debug("========== Set expireTime=" + psa.getExpireTime() + "(" + conf.getExpireTime()
						+ " min), productType=" + psa.getProductType());
			} else
				LogUtil.log.debug("========== Use no expireTime=" + psa.getExpireTime() + "(" + conf.getExpireTime()
						+ " min), productType=" + psa.getProductType());

		} else
			LogUtil.logError
					.error("ERROR when setExpireTime(); read configuration from table conf_product_service failed. productType="
							+ psa.getProductType() + ",productId=" + psa.getProductId());

	}

	private boolean isExistProductApplyByOrderId(String orderId) {
		// TODO Auto-generated method stub
		int rt = dao.isExistProductApplyByOrderId(orderId);
		if (rt >= 1)
			return true;
		else
			return false;
	}

	private void setTmgResponseCode(com.esuizhen.cloudservice.business.bean.TMsgResponse<Map<String, Object>> msg,
			ErrorMessage error, Locale locale) {
		// TODO Auto-generated method stub
		msg.setCodeAndrespMsg(error.code, messageSource.getMessage(error.info, null, locale));

	}

	/**
	 * 电话拨号
	 * 
	 * @return
	 */
	@Override
	public com.esuizhen.cloudservice.business.bean.TMsgResponse<String> makeCallForTelConsulting(
			TProductApply productApply) {
		com.esuizhen.cloudservice.business.bean.TMsgResponse<String> msg = new com.esuizhen.cloudservice.business.bean.TMsgResponse<String>();
		msg.setCodeAndrespMsg(ErrorMessage.SUCCESS.code,
				messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));

		ProductServiceApply psa = dao.getProductServiceApplyInfo(productApply.getProductApplyId());
		if (psa == null) {
			msg.respCode = 1404;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			msg.errorDesc = "productApplyId not found.";
			LogUtil.logError.error("makeCall for telconsult failed:" + msg.errorDesc + ". productApplyId="
					+ productApply.getProductApplyId());
			return msg;
		}

		String fromMobile = productApply.getFromMobile();
		String mobile = psa.getContactMobile();
		if (fromMobile == null || fromMobile.isEmpty()) {
			// fromMobile为医生手机号。如果没有传入，则找到医生的注册手机号
			Long fromUserId = psa.getVendor();
			fromMobile = userDao.getUserMobile(fromUserId);
		}
		if (fromMobile == null || mobile == null) {
			msg.respCode = 1400;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1400.info, null, locale);
			msg.errorDesc = "fromMobile or toMobile not found.";
			LogUtil.logError.error("makeCall for telconsult failed:" + msg.errorDesc + ". productApplyId="
					+ productApply.getProductApplyId());
			return msg;
		}

		// 调用公共服务的拨打电话方法
		CallTwoWayReq req = CallUtil.createCallReq(fromMobile, mobile);
		req.setMaxCallTime("900");
		req.setCallbackUrl("" + serverUrlRoot + callSyncPath + "");
		req.setUserData(productApply.getProductApplyId());

		if (smsService.callTwoWay(req)) {
			// 拨打成功
			LogUtil.log.info("Make twoway call and we wait the call result. fromMobile=" + fromMobile + ",fromUserId="
					+ psa.getVendor() + ". toMobile=" + mobile + ",toUserId=" + psa.getBuyer());
			// //调用accept接口修改状态
			// setAcceptProduct(productApply.getProductApplyId(),5,null);
		} else {
			setAcceptProduct(productApply.getProductApplyId(), 4, null);// 拨打失败，设置acceptFlag=4
		}

		return msg;
	}

	/**
	 * 
	 * @Title: queryMDTDetail @Description: 获取MDT的详情 @param @param
	 * orderId @param @return 设定文件 @return TMDTDetailInfo 返回类型 @throws
	 */
	@Override
	public TMDTDetailInfo queryMDTDetail(String orderId, Integer role, Long id) {
		TMDTDetailInfo detailInfo = null;
		if (id != null) {
			detailInfo = dao.queryMDTDetailWeb(orderId, role, id);
		} else {
			detailInfo = dao.queryMDTDetail(orderId, role);
		}
		if (null != detailInfo) {
			TProductDetailInfo product = productService.getProductDetail(detailInfo.getProductId(), orderId);
			if (null != product && product.getGroupMemberList() != null && product.getGroupMemberList().size() > 0) {
				detailInfo.setGroupMemberList(product.getGroupMemberList());
			}
			MdtEmrUploadReq req = new MdtEmrUploadReq();
			req.setProductApplyId(detailInfo.getProductApplyId());
			//查询患者病历资料或会诊资料是否已转发给患者
			detailInfo.setForwardFlag(this.dao.findEmrForwardFlag(detailInfo));
			//查询病历
			detailInfo.setEmrList(dao.findMDTEmr(req));
			// 将字符串转为list
			String attachements = detailInfo.getConsultAttachement();
			if (!StringUtils.isEmpty(attachements)) {
				String[] as = attachements.split(",");
				List<String> asList = new ArrayList<String>();
				for (String a : as) {
					asList.add(a);
				}
				detailInfo.setConsultAttachementList(asList);
			}
			// 数据库查询中直接返回
			// String[] names={"资料审核", "资料待完善", "资料审核通过", "会诊安排中", "会诊安排成功",
			// "会诊安排失败", "等待专家会诊", "会诊成功"};
			// detailInfo.setAuditStateName(names[detailInfo.getAuditState()]);
		}
		return detailInfo;
	}

	/**
	 * @Title: uploadMDTEmr @Description: 上传MDT病历资料 @param @param req
	 * 设定文件 @return void 返回类型 @throws
	 */
	@Override
	public void uploadMDTEmr(MdtEmrUploadReq req) {
		dao.uploadMDTEmr(req);
	}

	@Override
	public List<TMDTEmrInfo> getMDTEmr(MdtEmrUploadReq req) {
		return this.dao.findMDTEmr(req);
	}

	/**
	 * 提交会诊资料
	 */
	@Override
	public void submitMDTEmr(MdtEmrSubmitReq req) {
		dao.submitMDTEmr(req);
	}

	/**
	 * 查询产品订购关系列表
	 */
	@Override
	public List<TProductSubscriptionSimpleInfo> listProductSubscription(ProductSubscriptionReq req) {
		// TODO Auto-generated method stub
		if (req.getProductType() != null)
			if (req.getProductType() == Constant.Business.PRODUCT_TYPE_CONVENIENT
					|| req.getProductType() == Constant.Business.PRODUCT_TYPE_MONITOR_ILLNESS
					|| req.getProductType() == Constant.Business.PRODUCT_TYPE_FOLLOWUP_BUSINESS)
				return dao.listProductHospitalSubscription(req.getBuyer());
		return dao.listProductSubscription(req.getBuyer(), req.getVendor(), req.getProductType(), req.getReqFlag(), req.getSort(),req.getNum());
	}

	/**
	 * 
	 * @Title: listServiceSubscriptionInfo @Description:
	 * 查询医生VIP患者列表 @param @param vendor @param @return 设定文件 @return
	 * List<TServiceSubscriptionInfo> 返回类型 @throws
	 */
	public List<TServiceSubscriptionInfo> listServiceSubscriptionInfo(Long vendor) {
		return dao.listServiceSubscriptionInfo(vendor);
	}

	/**
	 * 查看MDT病情评估
	 */
	@Override
	public Object getMdtDiseaseEvaluationInfo(String productApplyId) {
		// TODO Auto-generated method stub
		return dao.queryMdtDiseaseEvaluation(productApplyId);
	}

	/**
	 * 提交MDT病情评估报告
	 */
	@Override
	public void submitMdtDiseaseEvaluation(MdtDiseaseEvaluationSubmitReq req) {
		// TODO Auto-generated method stub
		dao.createMdtDiseaseEvaluation(req);
		dao.modifyMdtDescription(req);
	}

	/**
	 * 医院服务包数据返回
	 */
	@Override
	public Object getProductHospitalServicePackList() {
		// TODO Auto-generated method stub
		return dao.getHospitalProductSimpleInfoList();
	}

	/**
	 * 医院简要信息获取
	 */
	@Override
	public Object getProductApplySimpleInfo(String productApplyId) {
		// TODO Auto-generated method stub
		return dao.getProductApplySimpleInfo(productApplyId);
	}

	/**
	 * 代理申请服务列表
	 */
	@Override
	public Object listProductApply(Long agentApplicant, int productType, Integer reqFlag) {
		// TODO Auto-generated method stub
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("agentApplicant", agentApplicant);
		param.put("productType", productType);
		param.put("reqFlag", reqFlag);
		return dao.getProductApplyListByAgentApplicant(param);
	}

	@Override
	public TMsgResponse<Object> checkProductApplyDot(Long agentApplicant) {
		// TODO Auto-generated method stub
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		if (agentApplicant == null) {
			msg.respCode = ErrorMessage.E1400.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1400.info, null, locale);
		}
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("agentApplicant", agentApplicant);
		msg.result = dao.queryDotCountByAgentApplicant(param);
		return msg;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void cancelApplyDot(String orderId) {
		// TODO Auto-generated method stub
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("orderId", orderId);
		param.put("dot", 0);
		dao.modifyProductServiceApplyDot(param);
	}

	@Override
	public List<TProductBuyerInfo> listProductBuyerInfo(Long vendor, int productType) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vendor", vendor);
		param.put("productType", productType);
		return dao.getBuyerInfoList(param);
	}

	@Override
	public void updateExpressNum(String productApplyId, String expressNum, Long buyer) {
		if(StringUtils.isBlank(expressNum)) {
			expressNum="";
		}
		expressNum = "{\"expressNo\":\"" + expressNum + "\"}";
		dao.updateExpressNum(productApplyId, expressNum);
		// ProductServiceApply psa =
		// dao.getProductServiceApplyInfo(productApplyId);
		// acceptNotifySender.sendCopyOfMedicalRecordExpressSendNotifyToPatient(expressNum,psa);
		// 2. 调用acceptProduct接口，acceptFlag=4表示服务进行中，启动相应定时器（30天，超时后自动认为服务完成）
		setAcceptProduct(productApplyId, 4, null);
	}

	/**
	 * 确认收件。 病案邮寄业务。
	 */
	@Override
	public void confirmReceipt(String productApplyId, Long buyer) {
		// TODO Auto-generated method stub
		// 1. 将审核状态audit修改为5(已完成）
		if (dao.updateAuditStateFinished(productApplyId, buyer) == 0)
			throw new EmptyObjectExcption(
					"updat productApplyId error productApplyId=" + productApplyId + "   buyer=" + buyer);
		// 2. 调用acceptProduct接口，acceptFlag=5表示服务已完成，停止相应定时器
		if (setAcceptProduct(productApplyId, 5, null) != 0)
			throw new EmptyObjectExcption("setAcceptProduct error productApplyId=" + productApplyId);
	}

	/**
	 * 申请服务统计
	 */
	@Override
	public TProductApplyStatisInfo getProductApplyStatis(ProductApplyStatisGetReq req) {
		// TODO Auto-generated method stub
		if (req.getVendor() == null)
			throw new EmptyParamExcption(" vendor is null");
		return dao.queryProductApplyStatis(req);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<TProductApplyInfo> getUntreatedProductApplyList(ProductApplyUntreatedReq req) {
		// TODO Auto-generated method stub
		if (req.getVendor() == null)
			throw new EmptyParamExcption("vendor is null");
		if (req.getReqFlag() == null)
			throw new EmptyParamExcption("reqFlag is null");
		PageHelper.startPage(req.getPage() + 1, req.getNum());
		List<TProductApplyInfo> list = dao.queryProductApplyList(req);
		if (req.getReqFlag() == 0) {
			long timer = (new Date()).getTime();
			for (TProductApplyInfo info : list) {
				if (info.getConsultOrderTime() != null)
					info.setStateName(DateUtil.getIntervalTimeStr(
							(int) (info.getConsultOrderTime().getTime() - timer) / (60 * 1000)) + "后开始");
				else
					info.setStateName(DateUtil.getIntervalTimeStr(
							(int) (info.getIdleCancelTime().getTime() - timer) / (60 * 1000)) + "后过期");
			}
		}
		return PageUtil.returnPage((com.github.pagehelper.Page<TProductApplyInfo>) list);
	}

	@Transactional
	@Override
	public void firstSendMessageRichText(RichTextFirstSendMessageReq req) {
		// TODO Auto-generated method stub
		if (req == null || StringUtils.isEmpty(req.getProductApplyId()) ||( StringUtils.isEmpty(req.getMessage())&&req.getNum()==null)) {
			throw new EmptyParamExcption("param error ;");
		}
		ProductServiceApply psa = this.dao.getProductServiceApplyInfo(req.getProductApplyId());
		if (psa == null) {
			throw new EmptyObjectExcption("object error productApplyId:" + req.getProductApplyId());
		}
		if (psa.getProductType() != Constant.Business.PRODUCT_TYPE_RICHTEXT) {
			throw new EmptyObjectExcption("productServiceApply is not richtext");
		}
		if (psa.getAuditState() == 1&&StringUtils.isNotBlank(req.getMessage())) {
			throw new EmptyObjectExcption("productServiceApply auditState = 1");
		}
		if(req.getMessage()!=null){
			psa.setAuditState(1);
			dao.modifyProductServiceApplyAuditState(psa);
			psa.setMessageSource(req.getMessageSource());
			notifySender.sendRichTextConsultingFirstNotifyToDoctor(psa, req.getMessage());
		}else{
			notifySender.sendRichTextConsultingFirstNotifyToDoctor(psa, req.getNum());
		}
	}
	
	//对于具体服务业务进行处理
	private boolean productServiceDetailHandle(TMsgResponse<Map<String, Object>> msg,TProductApply productApply,ProductServiceApply psa,boolean pushFlag,boolean newly){
		//病案邮寄
		if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_MEDICAL_RECORD_MAIL){
			expressService.handleSubDetail(psa.getProductApplyId(),psa.getDescription());
		}else if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_MDT){
			/**
			 * 1.1 Mdt详情 对于mdt申请的患者
			 */
			if (productApply.getMdtApplyInfo() != null) {
				productApply.getMdtApplyInfo().setProductApplyId(productApply.getProductApplyId());
				if (null == productApply.getMdtApplyInfo().getMdtFlowStateId()) {
					productApply.getMdtApplyInfo().setMdtFlowStateId(0);
				}
				// 处理患者病案号
				if (StringUtils.isNotEmpty(productApply.getMdtApplyInfo().getPatientNo())) {
					this.renewPatientNo(productApply);
				}
				// 生成会诊号
				productApply.getMdtApplyInfo().setMdtApplyNo(this.dao.findMdtApplyNo("M", psa.getProductType()));
				this.dao.createMdtDiseaseEvaluation(productApply.getMdtApplyInfo());
				LogUtil.log.info("============add mdt diseaseEvaluation");
			}
			// 对于来自网页端的MDT只需更新MDT咨询流程状态
			{
				ProductServiceApply mdtProduct = this.dao.getProductServiceApplyInfo(productApply.getProductApplyId());
				if (mdtProduct != null && mdtProduct.getApplySource() != null && mdtProduct.getApplySource() == 4) {
					List<MetaMDTProductStateListReq> mdtProductStateListReqs = null;
					if (newly) {
						/*
					mdtProductStateListReqs = this.metaMDTDataUnitService
							.getMetaMDTProductStateList(null, null, 1, 0L);
						 */
					} else {
						pushFlag = false;
						SMDTApply smdtApply = this.sMDTApplyDao.findByProductApplyId(productApply.getProductApplyId());
						mdtProductStateListReqs = this.metaMDTDataUnitService
								.getMetaMDTProductStateList(null, null, 1, new Long(smdtApply.getMdtFlowStateId()));
						
						// 自动将服务审核置为同意
						msg.respCode = 1;
						
						// 给基层病理医生推送做病理消息
						this.notifySender.sendReportToPathologyDoctor(smdtApply,productApply.getProductApplyId());
						
//						TProductApply productApply_mdt = this.dao.findApplyInfo(mdtProduct.getProductApplyId());
						/*
						//给申请医生推送患者已付款通知
						Doctor doctor = this.doctorDao.findByUserId(productApply_mdt.getAgentApplicant());
						String tipContent = messageSource.getMessage("text.mdt.title", null, locale);
						String description = messageSource.getMessage("push.service.mdt.apply.pathology.doctor.check.news",
								new String[]{doctor.getTrueName(), doctor.getTrueName(), productApply_mdt.getPatientName()}, locale);
						this.notifySender.sendNewsToDoctor(description, tipContent, doctor.getUserId());
						*/
						//给申请医生推送基层病理医生相同的消息
//						Doctor doctor = this.doctorDao.findByUserId(productApply_mdt.getAgentApplicant());
//						this.notifySender.sendPathologyCheckNews(productApply_mdt.getPatientName(), doctor.getTrueName(), doctor);
//						push(productApply_mdt , doctor);
					}
					if (mdtProductStateListReqs != null && !mdtProductStateListReqs.isEmpty()) {
						//修改MDT流程状态
						TMDTApplyInfo tmdtApplyInfo = new TMDTApplyInfo();
						tmdtApplyInfo.setProductApplyId(productApply.getProductApplyId());
						tmdtApplyInfo.setMdtFlowStateId(mdtProductStateListReqs.get(0).getMdtFlowStateId());
						this.dao.updateMDTApplyByApplyId(tmdtApplyInfo);
					}
				}
			}
		}else if(productApply.getProductType()==Constant.Business.PRODUCT_TYPE_GRATUITY){//打赏不发送申请消息
			pushFlag = false;
		}else if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_REVIEW_APPOINTMENT){//复查预约
			Map<String, Object> map = JsonUtil.toObject(psa.getDescription(), HashMap.class);
			if(map.get("reviewDetailId")!=null||map.get("doctorId")!=null){
				DoctorClinicUsageSetReq req = JsonUtil.toObject(JsonUtil.toJson(map.get("clinicUsage")), DoctorClinicUsageSetReq.class);
				if(req!=null)
					doctorService.setDoctorClinicUsage(req,new TMsgResponse());//进行挂号
				if(map.get("reviewDetailId")!=null)
					reviewAlertService.updateReviewDetail(psa,req.countClinicDateAndClinicTime(),(String)map.get("reviewDetailId"));//进行状态更新
				else if(map.get("doctorId")!=null)
					reviewAlertService.createReviewDetail(psa,map,req);//生成批次详情数据
			}
		}
		return pushFlag;
	}

	@Override
	public TProductSubscriptionSimpleInfo getProductSubscriptionDetail(String productApplyId, String orderId) {
		if(StringUtils.isBlank(productApplyId)){
			throw new EmptyParamExcption("productApplyId is null");
		}
		TProductSubscriptionSimpleInfo psa = dao.getProductApplySimpleInfo(productApplyId);
		if(psa==null){
			throw new EmptyObjectExcption("Object is null");
		}

		List<ServiceProgressResp> sp=dao.getServiceProgressInfos(psa.getProductApplyId());
		//服务流程
		psa.setServerProgressList(sp);

		if(orderId!=null&&!orderId.equals(psa.getOrderId())){
			throw new EmptyParamExcption("orderId is not in productApply!");
		}
		//获取订单信息
		TOrderMinInfo orderMinInfo=orderService.getOrderMinInfo(psa.getOrderId());

		//获取订单支付项明细
		List<TOrderPaymentItemInfo> list=orderService.getOrderPaymentItems(psa.getOrderId());

		orderMinInfo.setOrderPaymentItemList(list);

		psa.setOrderDetail(orderMinInfo);
		psa.setSystemTime(new Date());
		return psa;
	}

	@Override
	public void dealInputStreamFromYZX(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		if(request!=null){
			 try
		        {
		            InputStream input = request.getInputStream();
		        }
		        catch (IOException e)
		        {
		            e.printStackTrace();
		        }
			 String xmlStr =recieveData(request);//接收请求发来的xml消息体
			 String domain = xmlStr.substring(xmlStr.indexOf("<request>")+9, xmlStr
		                .indexOf("</request>"));//解析xml获取参数
			 String callid=domain.substring(domain.indexOf("<callid>")+8, domain
		                .indexOf("</callid>"));//解析xml获取参数
			 String reason=domain.substring(domain.indexOf("<reason>")+8, domain
		                .indexOf("</reason>"));//解析xml获取参数
			 
			 if(callid==null||reason==null)throw new Exception("callid is "+callid+",reason is"+reason);
			String userData = this.dao.getUserDataByCallsid(callid);
			int acceptFlag=Integer.parseInt(reason)==0?5:4;
			this.setAcceptProduct(userData, acceptFlag, null);
		}else throw new Exception("request is null");
	}
	//接收请求发来的xml消息体 add by fanpanwei 
	private String recieveData(HttpServletRequest request)
	    {
	        String inputLine = null;
	        // 接收到的数据
	        StringBuffer recieveData = new StringBuffer();
	        BufferedReader in = null;
	        try
	        {
	            in = new BufferedReader(new InputStreamReader(
	                    request.getInputStream(), "UTF-8"));
	            while ((inputLine = in.readLine()) != null)
	            {
	                recieveData.append(inputLine);
	            }
	        }
	        catch (IOException e)
	        {
	        }
	        finally
	        {            
	            try
	            {
	                if (null != in)
	                {
	                    in.close();
	                }
	            }
	            catch (IOException e)
	            {
	            }            
	        }
	        
	        return recieveData.toString();
	    }
	
}
