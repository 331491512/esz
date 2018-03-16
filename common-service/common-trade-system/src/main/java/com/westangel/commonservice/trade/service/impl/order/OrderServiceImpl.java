/**
 * 
 */
package com.westangel.commonservice.trade.service.impl.order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;

import com.westangel.common.bean.trade.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;
import com.westangel.common.util.StringUtil;
import com.westangel.common.util.TradeUtil;
import com.westangel.commonservice.trade.bean.TCouponInfo;
import com.westangel.commonservice.trade.bean.TOrderPayPrepareReq;
import com.westangel.commonservice.trade.bean.TOrderPrepareInfo;
import com.westangel.commonservice.trade.bean.TPayPrepareInfo;
import com.westangel.commonservice.trade.dao.AccountDao;
import com.westangel.commonservice.trade.dao.CouponDao;
import com.westangel.commonservice.trade.dao.OrderDao;
import com.westangel.commonservice.trade.dao.UserDao;
import com.westangel.commonservice.trade.model.account.TTradeRecordItemInfo;
import com.westangel.commonservice.trade.model.coupon.CouponInfo;
import com.westangel.commonservice.trade.model.order.TOrderDetailInfo;
import com.westangel.commonservice.trade.model.order.TOrderSimpleInfo;
import com.westangel.commonservice.trade.model.order.TProductOrderInfo;
import com.westangel.commonservice.trade.model.order.TProductSubscriptionInfo;
import com.westangel.commonservice.trade.service.account.AccountService;
import com.westangel.commonservice.trade.service.coupon.CouponService;
import com.westangel.commonservice.trade.service.order.OrderService;
import com.westangel.commonservice.trade.service.pay.PayService;
import com.westangel.commonservice.trade.service.product.ProductService;


/**
 * @author bigdragon
 * @date  2015-12-23 上午12:26:34
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService,com.westangel.common.service.OrderService {
//注：com.westangel.common.service.OrderService 是用于dubbo公开的服务接口定义,只定义需要远程公开的接口。本地和远程Service可以分开定义，统一Implement.
	
	private static final Locale locale = Locale.getDefault();
	@Autowired
	private OrderDao   orderDao;
	
	@Autowired
	private CouponDao couponDao;
	
	@Autowired
	private CouponService couponService;
	
	@Autowired 
	private ProductService productService;

	@Autowired
	@Qualifier(value="payServiceImpl")
	private PayService     payService;

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	

	/**
	 * 生成订单
	 * 返回orderId
	 * @see com.westangel.commonservice.trade.service.order.OrderService#createOrder(com.westangel.commonservice.trade.model.order.TOrderDetailInfo)
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public TMsgResponse<Map<String, Object>> createOrder(TOrderPublishInfo orderPublishInfo) {
		TMsgResponse<Map<String,Object>> msg = new TMsgResponse<Map<String,Object>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null,locale);
	
			
		//要增加一些新属性，所以用TOrderDetailInfo结构。
		TOrderDetailInfo orderDetailInfo = getOrderDetailInfo(orderPublishInfo);
		Map<String,Object> result = new LinkedHashMap<String,Object>();
		result.put("orderId",orderDetailInfo.getOrderId());
		msg.result = result;
		
		// 0. 检查抵扣券是否可用 不可用或计算出错的情况下 直接返回
		checkCouponIsUsed(orderDetailInfo, msg);
		if(msg.getRespCode()!=0)
			return msg;
		// 1.检查是否允许重复购买，如果不允许，则直接返回。
		TProductOrderInfo productInfo = orderDetailInfo.getOrderProductList().get(0);
		if (productInfo == null) {
			LogUtil.logError.warn(Constant.LOGTAG.ERR + "createOrder() failed! The product info not found. orderId="
					+ orderDetailInfo.getOrderId() + ",buyer=" + orderDetailInfo.getBuyer());
			msg.respCode = ErrorMessage.E1400.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1400.info, null, locale);
			return msg;

		}
		
		String productId =productInfo.getProductId();
		TProductSubscriptionInfo subscriptionInfo = orderDao.getProductSubscriptionInfo(orderDetailInfo.getBuyer(),productId);
		if(subscriptionInfo!=null){
			if((subscriptionInfo.getRepurchaseFlag()==0||subscriptionInfo.getRepurchaseFlag()==2) && subscriptionInfo.getSubscriptionFlag()>-1) //
			{
				//不允许重复购买
				LogUtil.logError.warn(Constant.LOGTAG.ERR+"createOrder() failed! The product can not be repurchased. productId="+productId
						+",buyer="+orderDetailInfo.getBuyer());
				msg.respCode=ErrorMessage.E1406.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1406.info, null,locale);
				return msg;
			}
		}
		
		// 2.已经存在此orderId了。更新状态即可
		if (isOrderExist(orderDetailInfo.getOrderId()) == 1) {
			LogUtil.log.info(
					"To create order but find the orderId already exist. orderId=" + orderDetailInfo.getOrderId());
			//此处主要针对后付款账户来判断    定义服务支付位置
			//判断是否需要修改相关参数
			boolean isModifyOrder = false;
			Map<String,Object> params = new HashMap<String,Object>();
			//如果存在wxProductId 则修改wxProductId
			if(orderDetailInfo.getWxProductId()!=null){
				isModifyOrder = true;
				params.put("orderId", orderDetailInfo.getOrderId());
				params.put("wxProductId", orderDetailInfo.getWxProductId());
			}
			if(StringUtils.isNotEmpty(orderDetailInfo.getCouponIds())){
				isModifyOrder = true;
				params.put("orderId", orderDetailInfo.getOrderId());
				params.put("totalPrice", orderDetailInfo.getTotalPrice());
				params.put("realPrice", orderDetailInfo.getRealPrice());
				params.put("plusPrice", orderDetailInfo.getPlusPrice());
				params.put("discountPrice", orderDetailInfo.getDiscountPrice());
				params.put("couponIds", orderDetailInfo.getCouponIds());
			}
			//如果需要 则修改订单信息
			if(isModifyOrder){
				orderDao.modifyOrder(params);
			}
			if (orderDetailInfo.getState() > 0) {
				updateOrderState(orderDetailInfo.getVendor(), orderDetailInfo.getOrderId(), orderDetailInfo.getState(),
						"update order state to " + orderDetailInfo.getState() + " when createOrder");
				LogUtil.log.info("Update order state to " + orderDetailInfo.getState() + " when createOrder");
			}
			return msg;

		}

		//3.正式创建订单
		LogUtil.log.info("Begin to create an order: orderId="+orderDetailInfo.getOrderId()+
				",buyer="+orderDetailInfo.getBuyer()+",vendor="+orderDetailInfo.getVendor()+
				",description="+orderDetailInfo.getDescription()+",remark="+orderDetailInfo.getRemark()+
				",attachement="+orderDetailInfo.getAttachement());
		
		int rt = orderDao.createOrder(orderDetailInfo);
		//4.生成订单商品关系
		rt = orderDao.createOrderProductRelation(orderDetailInfo.getOrderProductList());

		//5.生成订单支付项明细
		if(orderDetailInfo.getOrderPaymentItemList()!=null&&orderDetailInfo.getOrderPaymentItemList().size()>0){
			orderDao.createOrderPaymentItemInfo(orderDetailInfo.getOrderPaymentItemList(),orderDetailInfo.getOrderId());
		}

		//6. 订单支付相关
		createPayOrderPayment(orderDetailInfo);
		
		LogUtil.log.info("createOrder Ok! orderId="+orderDetailInfo.getOrderId());
		
		return msg;
	}

	/**
	 * 订单支付相关操作
	 */
	private void createPayOrderPayment(TOrderDetailInfo orderDetailInfo){
		//1.判断realPrice大于0 生成 进行订单支付
		if (orderDetailInfo.getRealPrice() > 0){
			payOrder(orderDetailInfo.createPayOrderInfo());
			//2.判断订单 如果抵扣金额和实际支付金额相等 则直接订单为已支付
			if (orderDetailInfo.getRealPrice() == orderDetailInfo.getDiscountPrice()){
				updateOrderState(0L, orderDetailInfo.getOrderId(), Constant.Pay.PAY_STATE_SUCCESS, orderDetailInfo.getRemark());
			}
		}
	}
	/**
	 * 修改订单抵用券
	 */
	public void modifyOrderCoupons(List<CouponInfo> list){
		if(list!=null)
			for(CouponInfo coupon : list)
				couponService.modifyCoupon(coupon);
	}
	/**
	 * 修改抵用券
	 */
	/**
	 * @param orderPublishInfo
	 * @return
	 */
	private TOrderDetailInfo getOrderDetailInfo(
			TOrderPublishInfo orderPublishInfo) {
		TOrderDetailInfo orderDetailInfo = new TOrderDetailInfo();
		//生成订单ID
		String orderId = orderPublishInfo.getOrderId();
		if(orderId==null || orderId.isEmpty())
			orderId = GeneralUtil.generateUniqueID("ORDE");
		else
			LogUtil.log.info("!!! to createOrder: orderId already exist! orderId="+orderId);
		
		orderDetailInfo.setOrderId(orderId);	
		orderDetailInfo.setOrderNo(GeneralUtil.generatorUUID(12));

		orderDetailInfo.setProductSubType(orderPublishInfo.getProductSubType());
		orderDetailInfo.setOrderPaymentItemList(orderPublishInfo.getOrderPaymentItemList());
		orderDetailInfo.setBuyer(orderPublishInfo.getBuyer());
		orderDetailInfo.setVendor(orderPublishInfo.getVendor());
		orderDetailInfo.setOrderTitle(orderPublishInfo.getOrderTitle());
		orderDetailInfo.setRemark(orderPublishInfo.getRemark());
		orderDetailInfo.setState(orderPublishInfo.getState());
		if(orderPublishInfo.getInPackage()==1){//套餐内产品，直接置为已支付(state=1)
			orderDetailInfo.setState(1);
			orderDetailInfo.setOrderTitle(orderPublishInfo.getOrderTitle()+"（"+orderPublishInfo.getParentProductName()+"）");
			orderDetailInfo.setParentProductName(orderPublishInfo.getParentProductName());
		}
		orderDetailInfo.setSubscriptionFlag(TradeUtil.getSubscriptionFlag(orderDetailInfo.getState()));
		orderDetailInfo.setContactMobile(orderPublishInfo.getContactMobile());
		orderDetailInfo.setRealPrice(orderPublishInfo.getRealPrice());
		orderDetailInfo.setTotalPrice(orderPublishInfo.getTotalPrice());
		orderDetailInfo.setDiscount(orderPublishInfo.getDiscount());
		orderDetailInfo.setPlusPrice(orderPublishInfo.getPlusPrice());
		orderDetailInfo.setDescription(orderPublishInfo.getDescription());
		orderDetailInfo.setAttachement(orderPublishInfo.getAttachement());
		orderDetailInfo.setInPackage(orderPublishInfo.getInPackage());
		orderDetailInfo.setQuota(orderPublishInfo.getQuota());
		orderDetailInfo.setUsage(orderPublishInfo.getUsage());
		orderDetailInfo.setParentProductName(orderPublishInfo.getParentProductName());
		if(orderPublishInfo.getRecommendedDoctor()!=null)
			orderDetailInfo.setRecommendedDoctor(orderPublishInfo.getRecommendedDoctor());
		if(orderPublishInfo.getAgentApplicant()!=null){
			orderDetailInfo.setAgentApplicant(orderPublishInfo.getAgentApplicant());
		}
		//设置订单产品列表，目前一个订单只有一个产品
		List<TProductOrderInfo> list=new ArrayList<TProductOrderInfo>();
		TProductOrderInfo info = new TProductOrderInfo();
		info.setProductSubType(orderPublishInfo.getProductSubType());
		info.setAmount(orderPublishInfo.getAmount());
		info.setProductId(orderPublishInfo.getProductId());
		info.setProductType(orderPublishInfo.getProductType());
		info.setOrderId(orderId);
		info.setRealPrice(orderPublishInfo.getRealPrice());
		list.add(info);
		orderDetailInfo.setOrderProductList(list);
		//写入申请源
		orderDetailInfo.setWxProductId(orderPublishInfo.getWxProductId());
		//写入抵扣券
		orderDetailInfo.setCouponIds(orderPublishInfo.getCouponIds());
		//写入抵扣价格
		if(orderPublishInfo.getDiscountPrice()!=null)
			orderDetailInfo.setDiscountPrice(orderPublishInfo.getDiscountPrice());
		return orderDetailInfo;
	}

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.OrderService#payOrder(com.westangel.commonservice.trade.model.order.TOrderPayInfo)
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public TMsgResponse payOrder(TOrderPayInfo orderPayInfo)  {
		TMsgResponse msg = new TMsgResponse();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null,locale);
	
		//生成payId
		orderPayInfo.setPayId(GeneralUtil.generateUniqueID("PAYM"));
		//首先查看是否此支付记录存在，如果不存在，则创建；存在，则更新
		//获得订单信息，Trade记录和Account记录中，remark均填写orderTitle;同时buyer信息也更新过来
		TOrderMinInfo orderInfo = getOrderMinInfo(orderPayInfo.getOrderId());
		if(orderInfo==null){
			//没有找到订单
			String errorMsg = "PayOrder failed: no order found. orderId="+orderPayInfo.getOrderId();
			LogUtil.logError.error(errorMsg);
			msg.respCode=1404;
			msg.respMsg =errorMsg;
			return msg;
			//throw new Exception(errorMsg);
		}
		//如果存在抵扣券  则写入
		if (StringUtils.isNotEmpty(orderInfo.getCouponIds())) {
			orderPayInfo.setCoupons(orderInfo.getCouponIds().split(",").length);
			orderPayInfo.setCouponsPayValue(orderInfo.getDiscountPrice());
		}
		//检查一下order表中和传入的（如微信支付返回的）两者价格取值是否相等，因为是float，以不超过1元为判断
		float total_fee = orderPayInfo.getBalancePayValue()+orderPayInfo.getOnlinePayValue()+orderPayInfo.getPointsPayValue()+orderPayInfo.getCouponsPayValue();
		float diff = orderInfo.getRealPrice()-total_fee;
		LogUtil.log.info("orderInfo.getRealPrice["+orderInfo.getRealPrice()+"]-total_fee["+total_fee+"] : "+diff);
		if(diff>=1 || diff<=-1){
			String errorMsg = "PayOrder failed: order fee check failure. order.price[yuan]="+orderInfo.getRealPrice()+
					",pay.fee[yuan]="+total_fee;
			LogUtil.logError.error(errorMsg);
			msg.respCode=1400;
			msg.respMsg=errorMsg;
			return msg;
			//throw new Exception(errorMsg);

		}
		
		orderPayInfo.setBuyer(orderInfo.getBuyer());
		orderPayInfo.setVendor(orderInfo.getVendor());
		if(orderPayInfo.getRemark()==null || orderPayInfo.getRemark().isEmpty()){
			orderPayInfo.setRemark(orderInfo.getOrderTitle());
		}
		else
			orderPayInfo.setRemark(orderInfo.getOrderTitle()+". "+orderPayInfo.getRemark());//补一下orderTitle，如图文咨询. 已支付
		
		//先检查payId是否存在，若存在，表示已经有相应记录，只需更新状态即可
		String payId = payService.getOrderPayId(orderInfo.getOrderId());
		if(payId==null || payId.isEmpty()){
			//1.创建订单支付记录
			int rt = orderDao.payOrder(orderPayInfo);
			
			LogUtil.log.info("create order_payment record succeed. orderId="+orderPayInfo.getOrderId()
					+",buyer="+orderPayInfo.getBuyer()+",vendor="+orderPayInfo.getVendor()+",onlinePayValue="+orderPayInfo.getOnlinePayValue());
		}
		else{
			//更新支付记录
			int rt = payService.updatePayState(orderPayInfo);
			
			LogUtil.log.info("update order_payment record succeed. state = "+orderPayInfo.getState()+",remark="+orderPayInfo.getRemark()
					+",orderId="+orderPayInfo.getOrderId()
					+",buyer="+orderPayInfo.getBuyer()+",vendor="+orderPayInfo.getVendor()+",onlinePayValue="+orderPayInfo.getOnlinePayValue());

		}
		
		if(orderPayInfo.getState()!=Constant.Pay.PAY_STATE_SUCCESS){
			//订单尚未完成支付，此时不生成交易记录。
			LogUtil.logError.error("WARN in payOrder(): payment is not finished and we do not create trade record. state="
					+orderPayInfo.getState());
			msg.respMsg = "payment is not finished yet.";
			return msg;
		}
		//这里不再生成交易表记录。只有服务完成才生成
		/*
		orderPayInfo.setRemark(orderInfo.getOrderTitle());//使用orderTitle
		TTradeRecordItemInfo tradeRecordItemInfo = getTradeRecordItemInfo(orderPayInfo);//从orderPayInfo得到tradeRecordItemInfo
		tradeRecordItemInfo.setState(1);//正常
		int rt = accountDao.createTradeRecord(tradeRecordItemInfo);
		if(rt==1){
			LogUtil.log.info("create trade record succeed. tradeId="+tradeRecordItemInfo.getTradeId()
					+",buyer="+tradeRecordItemInfo.getBuyer()+",vendor="+tradeRecordItemInfo.getVendor()+",volume="+tradeRecordItemInfo.getVolume());
			
		}*/
		//这里不再生成收益账单记录，在服务完成后再生成。
	
		return msg;
	}

	

	

	

	/**
	 * @param orderPayInfo
	 * @return
	 */
	private TTradeRecordItemInfo getTradeRecordItemInfo(
			TOrderPayInfo orderPayInfo) {
		// TODO Auto-generated method stub
		TTradeRecordItemInfo item = new TTradeRecordItemInfo();
		item.setTradeId(GeneralUtil.generateUniqueID("TRAD"));
		item.setBuyer(orderPayInfo.getBuyer());
		item.setVendor(orderPayInfo.getVendor());
		item.setOrderId(orderPayInfo.getOrderId());
		item.setPayment(orderPayInfo.getBalancePayValue()+orderPayInfo.getOnlinePayValue());
		float realPrice = orderPayInfo.getBalancePayValue()+orderPayInfo.getOnlinePayValue()+orderPayInfo.getPointsPayValue();
		item.setVolume(realPrice);
		item.setRemark(orderPayInfo.getRemark());
		return item;
	}

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.OrderService#listOrder(java.lang.Long, java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Page<TOrderSimpleInfo> listOrder(Long userId, Integer role,Integer productType,
			Integer page, Integer num) {
		Map<String , Object> param = new HashMap<String , Object>();
		param.put("userId", userId);
		param.put("role", role);
		param.put("productType", productType);
		PageHelper.startPage(page+1, num);
		List<TOrderSimpleInfo> list = orderDao.listOrder(param);
		for(TOrderSimpleInfo info:list){
			//如果是套餐内产品，且未被取消或拒绝，则订单状态显示已用次数。
			if(info!=null){
				if(info.getInPackage()==1){
					int state = info.getState();
					if(checkOrderServiceSuccess(info)){//成功了
						String quota = "共"+info.getQuota()+"次";
						if(info.getQuota()==-1 || info.getQuota()>100000)
							quota = "不限次";
						info.setStateName("已用"+info.getUsage()+"次/"+quota);
					}
				}
			}
		}
		return PageUtil.returnPage((com.github.pagehelper.Page<TOrderSimpleInfo>)list);

	}

	/**
	 * @param info
	 * @return
	 */
	private boolean checkOrderServiceSuccess(TOrderSimpleInfo info) {
		// TODO Auto-generated method stub
		int state = info.getState();
		if(state==5) // 其他服务需要完成
			return true;
		if(info.getProductType()==1 && (state==2 || state==5 || state==8 || state==9)) //图文咨询只要同意即算成功了
			return true;
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.OrderService#getOrderDetail(java.lang.Long, java.lang.String)
	 */
	@Override
	public TOrderDetailInfo getOrderDetail(Long userId, String orderId) {
		// TODO Auto-generated method stub
		TOrderDetailInfo orderDetail = orderDao.getOrderDetail(userId, orderId);
		if(orderDetail!=null){
			orderDetail.setAgentPayList(orderDao.getAgentPayInfo(orderId));
			orderDetail.setOrderPaymentItemList(orderDao.getOrderPaymentItemInfo(orderId));
		}
		return orderDetail;
	}
	
	/**
	 * 更改订单状态
	 */
	public TMsgResponse updateOrderState(Long userId,String orderId,int state,String remark){
		TMsgResponse msg = new TMsgResponse();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null,locale);
		
		if(state<=0){
			msg.respCode=1400;
			msg.respMsg="parameter state[1~n) error: state="+state;
			LogUtil.logError.error("OrderService.updateOrderState() ERROR:"+msg.respMsg+",orderId="
					+orderId+"userId="+userId);
			return msg;
		}
		
		int subscriptionFlag = TradeUtil.getSubscriptionFlag(state);
		int rt = orderDao.updateOrderState(userId,orderId,state,subscriptionFlag,remark);
		if(rt<1){
			//没有记录被更新，返回1404
			msg.respCode=1404;
			msg.respMsg="maybe order not found";
			LogUtil.logError.error("OrderService.updateOrderState() ERROR:"+msg.respMsg+",orderId="
					+orderId+"userId="+userId);
			return msg;
	
		}
		
		//修改抵用券状态
		if(state==1){
			TOrderMinInfo orderInfo = getOrderMinInfo(orderId);
			if(StringUtils.isNotEmpty(orderInfo.getCouponIds())){
				List<CouponInfo> list = new ArrayList<CouponInfo>();
				for(String couponId:orderInfo.getCouponIds().split(","))
					list.add(new CouponInfo(couponId, Constant.Coupon.COUPON_STATE_USED, null, orderInfo.getBuyer()));
				modifyOrderCoupons(list);
			}
		}
		
		LogUtil.logError.info("OrderService.updateOrderState() succeed. "+",orderId="
				+orderId+"userId="+userId+",state="+state);
		
	
		return msg;
	}



	/**
	 * @param state
	 * @return
	 */
	private boolean isNeedRefund(int state) {
		// TODO Auto-generated method stub
		switch(state){
			case 3:
			case 6:
			case 7:
			case 11:
				return true;
		}
		
		return false;
	}

	/**
	 * 下单支付准备接口
	 * 需要通过Pay模块调用第三方支付平台接口
	 * @see com.westangel.commonservice.trade.service.order.OrderService#prepareOrderPay(com.westangel.commonservice.trade.bean.TOrderPayPrepareReq)
	 */
	@Override
	public TMsgResponse<Map<String, Object>> prepareOrderPay(
			TOrderPayPrepareReq orderPayPrepareReq) {
		//和微信支付对接时，需要提供微信客户端的IP地址，需要调用HttpServletRequest的getRemoteAddr方法，故传入此参数
		TMsgResponse<Map<String,Object>> msg = new TMsgResponse();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null,locale);

		TOrderPrepareInfo orderPrepareInfo = orderPayPrepareReq.getOrderInfo();

		//检查产品是否存在
		if(!productService.checkProductIsExist(orderPrepareInfo.getProductId(),orderPrepareInfo.getProductSubType())){
			msg.respCode = 1404;
			msg.respMsg = "不存在此服务产品";
			msg.errorDesc="invalid parameter: productId or ProductSubType not found: "+orderPrepareInfo.getProductId()+","+orderPrepareInfo.getProductSubType();
			LogUtil.logError.error("Preparing the order payment failed! "+ msg.respMsg+". buyer="+ orderPrepareInfo.getBuyer() +",productId="+
					orderPrepareInfo.getProductId());
			return msg;
		}
	
		//根据productId获得产品相关信息
		TProductDetailInfo productDetailInfo = productService.getProductDetail(orderPrepareInfo.getProductId(),orderPrepareInfo.getProductSubType());
		if(null==productDetailInfo){
			msg.respCode = 1404;
			msg.respMsg = "不存在此服务产品";
			msg.errorDesc="invalid parameter: productId not found: "+orderPrepareInfo.getProductId();
			LogUtil.logError.error("Preparing the order payment failed! "+ msg.respMsg+". buyer="+ orderPrepareInfo.getBuyer() +",productId="+
			  orderPrepareInfo.getProductId());
			return msg;
		}
		if(productDetailInfo.getState()==2){
			//已下架。不能购买。
			msg.respCode = 1406;
			msg.respMsg = "此服务产品已下架";
			LogUtil.logError.error("Preparing the order payment failed! the product state=2. "+ msg.respMsg+". buyer="+ orderPrepareInfo.getBuyer() +",productId="+
				  orderPrepareInfo.getProductId());
			return msg;

		}
		
		if(orderPrepareInfo.getRealPrice()<=0){
			msg.respCode = 1400;
			msg.respMsg = "价格不能为0";
			msg.errorDesc="invalid parameter: realPrice should more than zero:  "+orderPrepareInfo.getRealPrice();
			LogUtil.logError.error("Preparing the order payment failed! "+ msg.respMsg+". buyer="+ orderPrepareInfo.getBuyer() +",productId="+
				  orderPrepareInfo.getProductId());
			return msg;

		}
		//1. 先创建一个未支付订单（state=0，表示未支付）
		TOrderPublishInfo orderPublishInfo = getOrderPublishInfo(orderPrepareInfo,productDetailInfo);
		msg = createOrder(orderPublishInfo);
		if(msg.respCode!=0){
			LogUtil.logError.error("Preparing the order payment failed: create order error: "+ msg.respMsg+". buyer="+ orderPrepareInfo.getBuyer() +",productId="+
					  orderPrepareInfo.getProductId());
			return msg;
		}
		//获得orderId
		String orderId =  (String) msg.getResult().get("orderId");
		if(orderId==null || orderId.isEmpty()){
			LogUtil.logError.error("Preparing the order payment failed: get orderId error: "+ msg.respMsg+". buyer="+ orderPrepareInfo.getBuyer() +",productId="+
					  orderPrepareInfo.getProductId());
			return msg;
		}
		if(isPreOrderExist(orderId)==0){
			LogUtil.logError.error("Preparing the order payment is pay success orderId ="+orderId);
			msg.respCode = 1409;
			msg.setRespMsg("订单已支付！");
			return msg;
		}
		orderPublishInfo.setOrderId(orderId);
		//2. 处理支付流程
		prepareOrder(orderPublishInfo,orderPayPrepareReq.getPayInfo());
		//3. 发起第三方支付调用
		msg = payService.preparePay(orderPublishInfo,orderPayPrepareReq.getPayInfo());
		
		return msg;
	}
	
	/**
	 * @param orderPublishInfo
	 * @param payInfo
	 */
	private void prepareOrder(TOrderPublishInfo orderPublishInfo, TPayPrepareInfo payInfo) {
		// 1. 修改order_payment 状态为支付中
		TOrderPayInfo info = new TOrderPayInfo();
		//支付中
		info.setState(2);
		info.setOrderId(orderPublishInfo.getOrderId());
		//记录支付方式
		info.setOnlinePayWay(payInfo.getOnlinePayWay());
		//如果代支付账号不为空创建支付记录
		if(StringUtils.isNotEmpty(payInfo.getAgentAccountId())){
			TOrderAgentPayInfo agentPayInfo = new TOrderAgentPayInfo();
			agentPayInfo.setAgentPayId(GeneralUtil.generatorUUID("AGENTPAY"));
			agentPayInfo.setAgentOrderId(GeneralUtil.generatorUUID("AGENTORDE"));
			agentPayInfo.setOrderId(orderPublishInfo.getOrderId());
			agentPayInfo.setOnlinePayAccount(payInfo.getAgentAccountId());
			agentPayInfo.setOnlinePayValue(payInfo.getOnlinePayValue());
			agentPayInfo.setOnlinePayWay(payInfo.getOnlinePayWay());
			agentPayInfo.setOnlinePayAccountInfo(payInfo.getOnlinePayAccountInfo());
			//支付中
			agentPayInfo.setState(2);
			agentPayInfo.setRemark("支付中");
			orderDao.payAgentOrder(agentPayInfo);
			//回写订单
			orderPublishInfo.setOrderId(agentPayInfo.getAgentOrderId());
		}
		//修改支付状态
		payService.updatePayState(info);
	}

	/**
	 * 得到TOrderPublishInfo信息
	 * @param orderPrepareInfo
	 * @param productDetailInfo
	 * @return
	 */
	private TOrderPublishInfo getOrderPublishInfo(
			TOrderPrepareInfo orderPrepareInfo,
			TProductDetailInfo productDetailInfo) {
		
		TOrderPublishInfo orderPublishInfo = new TOrderPublishInfo();
		orderPublishInfo.setProductSubType(orderPrepareInfo.getProductSubType());
		orderPublishInfo.setState(0);//0表示未支付订单
		orderPublishInfo.setBuyer(orderPrepareInfo.getBuyer());
		orderPublishInfo.setVendor(productDetailInfo.getVendorId());
		orderPublishInfo.setProductId(orderPrepareInfo.getProductId());
		orderPublishInfo.setOrderTitle(productDetailInfo.getProductName());
		orderPublishInfo.setProductType(productDetailInfo.getProductType());
		orderPublishInfo.setRealPrice(orderPrepareInfo.getRealPrice());
		orderPublishInfo.setAmount(1);
		orderPublishInfo.setPlusPrice(orderPrepareInfo.getPlusPrice());
		orderPublishInfo.setDiscount(productDetailInfo.getDiscount());
		orderPublishInfo.setTotalPrice(orderPublishInfo.getAmount()*productDetailInfo.getUnitPrice());
		orderPublishInfo.setContactMobile(orderPrepareInfo.getContactMobile());
		orderPublishInfo.setDescription(orderPrepareInfo.getDescription());
		orderPublishInfo.setAttachement(orderPrepareInfo.getAttachement());
		if(orderPrepareInfo.getOrderId()!=null && !orderPrepareInfo.getOrderId().isEmpty()){
			orderPublishInfo.setOrderId(orderPrepareInfo.getOrderId()); //如果是微信端传入orderId，则使用之。
		}
		if(orderPrepareInfo.getRecommendedDoctor()!=null)
			orderPublishInfo.setRecommendedDoctor(orderPrepareInfo.getRecommendedDoctor());
		//判断是否允许三方收款 且三方收款人存在
		if(productDetailInfo.getIsFeeThree()!=null&&productDetailInfo.getIsFeeThree()==1&&orderPrepareInfo.getThreeVendor()!=null)
			orderPublishInfo.setVendor(orderPrepareInfo.getThreeVendor());
		//写入wxProductId
		orderPublishInfo.setWxProductId(orderPrepareInfo.getWxProductId());
		//写入抵用券
		if(StringUtils.isNotEmpty(orderPrepareInfo.getCouponIds())){
			orderPublishInfo.setCouponIds(orderPrepareInfo.getCouponIds());
		}
		//写入抵扣金额
		orderPublishInfo.setDiscountPrice(orderPrepareInfo.getDiscountPrice());
		//写入订单支付项明细
		orderPublishInfo.setOrderPaymentItemList(orderPrepareInfo.getOrderPaymentItemList());
		return orderPublishInfo;
	}
	
	private void checkCouponIsUsed(TOrderDetailInfo orderDetailInfo,TMsgResponse<Map<String, Object>> msg){
		if(StringUtils.isNotEmpty(orderDetailInfo.getCouponIds())){
			String[] couponIds = orderDetailInfo.getCouponIds().split(",");
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("reqFlag", 1);
			params.put("couponIds", couponIds);
			params.put("owner", orderDetailInfo.getBuyer());
			List<TCouponInfo> list = couponDao.queryCouponList(params);
			if(list.size()!=couponIds.length){
				LogUtil.logError.debug(Constant.LOGTAG.ERR+"createOrder() failed! The couponIds info not found. couponIds="+orderDetailInfo.getCouponIds()
				+",buyer="+orderDetailInfo.getBuyer());
				msg.respCode=ErrorMessage.E1400.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1400.info, null,locale);
				return;
			}
			Integer couponState = null;
			if(orderDetailInfo.getRealPrice()==orderDetailInfo.getDiscountPrice()){
				couponState = Constant.Coupon.COUPON_STATE_USED;
			}
			//实际折扣价格
			float discountPrice = 0;
			//实际支付价格
			float  realPrice= orderDetailInfo.getRealPrice();
			//抵扣券实际价格
			float price=0;
			orderDetailInfo.setCoupons(new ArrayList<CouponInfo>());
			for(TCouponInfo coupon : list){
				if(coupon.getCouponType()==Constant.Coupon.COUPON_TYPE_CASH){
					if(discountPrice==0){
						//判断是否满足使用条件
						if(coupon.getMinOrderPrice()!=null&&realPrice<coupon.getMinOrderPrice()){
							LogUtil.logError.warn(Constant.LOGTAG.ERR+"createOrder() failed! The order realPrice lt coupon minOrderPrice. realPrice="+orderDetailInfo.getRealPrice()
							+",minOrderPrice="+coupon.getMinOrderPrice());
							msg.respCode=ErrorMessage.E1400.code;
							msg.respMsg=messageSource.getMessage(ErrorMessage.E1400.info, null,locale);
							return;
						}
					}
					//如果大于实际价格
					if(realPrice<=coupon.getCouponNumber()){
						discountPrice+=realPrice;
						price = realPrice;
					}else{//小于总价
						discountPrice+=coupon.getCouponNumber();
						price = coupon.getCouponNumber();
						realPrice -= coupon.getCouponNumber(); 
					}
					//此处不做抵用券状态处理
					orderDetailInfo.getCoupons().add(new CouponInfo(coupon.getCouponId(), null, price, orderDetailInfo.getBuyer()));
				}
				
			}
			if(discountPrice!=orderDetailInfo.getDiscountPrice()){
				LogUtil.logError.warn(Constant.LOGTAG.ERR + "createOrder() failed! The system discountPrice not equals order discountPrice. systemPrice="
						+ discountPrice + ",orderDiscountPrice=" + orderDetailInfo.getDiscountPrice());
				msg.respCode = ErrorMessage.E1400.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1400.info, null, locale);
				return;
			}
//			if(realPrice!=orderDetailInfo.getRealPrice()){
//				LogUtil.logError.warn(Constant.LOGTAG.ERR + "createOrder() failed! The system realPrice not equals order realPrice. systemRealPrice="
//						+ realPrice + ",orderDiscountPrice=" + orderDetailInfo.getRealPrice());
//				msg.respCode = ErrorMessage.E1400.code;
//				msg.respMsg = messageSource.getMessage(ErrorMessage.E1400.info, null, locale);
//				return;
//			}
			modifyOrderCoupons(orderDetailInfo.getCoupons());
		}
	}

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.order.OrderService#isPreOrderExist(java.lang.String)
	 */
	@Override
	public int isPreOrderExist(String orderId) {
		// TODO Auto-generated method stub
		try{
			String order = orderDao.isPreOrderExist(orderId);
			if(order==null || order.isEmpty())
				return 0;
			else
				return 1;
		}
		catch(Exception e){
			LogUtil.logError.error("Getting pre-order failed: orderId="+orderId);
		}
		
		return 0;
		
	}
	
	@Override
	public int isPreAgentOrderExist(String agentOrderId) {
		// TODO Auto-generated method stub
		try{
			String order = orderDao.isPreAgentOrderExist(agentOrderId);
			if(order==null || order.isEmpty())
				return 0;
			else
				return 1;
		}
		catch(Exception e){
			LogUtil.logError.error("Getting pre-agent-order failed: orderId="+agentOrderId);
		}
		
		return 0;
		
	}
	
	public int isOrderExist(String orderId) {
		// TODO Auto-generated method stub
		try{
			String order = orderDao.isOrderExist(orderId);
			if(order==null || order.isEmpty())
				return 0;
			else
				return 1;
		}
		catch(Exception e){
			LogUtil.logError.error("Getting order failed: orderId="+orderId);
		}
		
		return 0;
		
	}

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.order.OrderService#getOrderMinInfo(java.lang.String)
	 */
	@Override
	public TOrderMinInfo getOrderMinInfo(String orderId) {
		// TODO Auto-generated method stub
		return orderDao.getOrderMinInfo(orderId);
	}

	/**
	 * 获得订单发布信息。同步给服务系统时用
	 * @param orderId
	 * @return
	 */
	@Override
	public TOrderPublishInfo getOrderPublishInfo(String orderId){
		return orderDao.getOrderPublishInfo(orderId);
	}

	@Override
	public List<TOrderPaymentItemInfo> getOrderPaymentItems(String orderId) {
		return orderDao.getOrderPaymentItemInfo(orderId);
	}
}
