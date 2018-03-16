/**
 * 
 */
package com.westangel.commonservice.trade.service.impl.pay;

import com.alibaba.fastjson.JSON;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.trade.*;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.trade.bean.*;
import com.westangel.commonservice.trade.dao.CouponDao;
import com.westangel.commonservice.trade.dao.PayDao;
import com.westangel.commonservice.trade.dao.UserDao;
import com.westangel.commonservice.trade.model.coupon.CouponInfo;
import com.westangel.commonservice.trade.service.account.AccountService;
import com.westangel.commonservice.trade.service.impl.pay.factory.PayServiceFactory;
import com.westangel.commonservice.trade.service.order.OrderService;
import com.westangel.commonservice.trade.service.pay.PayService;
import com.westangel.commonservice.trade.service.product.ProductService;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 支付服务实现。
 * 本类为通用实现类。具体根据不同的支付平台（支付宝、微信支付）由工厂类生成对应的实现类来完成。
 * @author bigdragon
 * @date  2016-1-10 下午7:49:52
 */
@Service(value="payServiceImpl")
public class PayServiceImpl implements PayService,com.westangel.common.service.PayService{

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.pay.PayService#preparePay(com.westangel.commonservice.trade.bean.TPayPrepareInfo)
	 */
	@Value("${server.api.url.root}")
	private String serverUrlRoot;

	@Autowired
	PayServiceFactory factory;
	
	@Autowired
	OrderService  orderService;

	@Autowired
	AccountService  accountService;

	@Autowired
	PayDao        payDao;
	
	@Autowired    
	UserDao       userDao;
	
	@Autowired
	CouponDao couponDao;
	
	@Autowired
	ProductService productService;
	
	@Override
	public TMsgResponse<Map<String, Object>> preparePay(TOrderPublishInfo orderInfo,TPayPrepareInfo payInfo) {
		// TODO Auto-generated method stub
		//由工厂类根据不同的支付类型，得到具体的PayService支付实现类
		PayService  invoker = factory.getPayServiceInvoker(payInfo.getOnlinePayWay());
		if(null==invoker){
			LogUtil.logError.error("FETAL ERROR when get payService invoker: return null: unsupported pay way: " +
					+payInfo.getOnlinePayWay());
			TMsgResponse msg = new TMsgResponse();
			msg.respCode=1400;
			msg.respMsg="pamameter error: unsupported pay way: " +
					+payInfo.getOnlinePayWay();

			return msg;
		}
		return invoker.preparePay(orderInfo,payInfo);
	}

	/**
	 * 支付结果同步
	 * @see com.westangel.commonservice.trade.service.pay.PayService#payResultSync(com.westangel.commonservice.trade.bean.TPayResultSyncInfo)
		return: 0: 成功； 1：失败
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int payResultSync(TPayResultSyncInfo resultSyncInfo) {
		//必须使用事务模式。一旦某个步骤的操作失败，例如交易数据生成失败，或者远程同步给服务系统失败，
		//都需要进行回滚，同时给未微信第三方支付平台返回错误。这样，让微信支付平台有机会不断重复同步，直到成功为止。
		//将来做出内部故障处理机制，可以交由运营进行后续处理。
	
		//本类中方法实现即可，无需PayServiceImplXX具体类实现
		//查询订单状态，如果找到订单，且state=0，才进行更新。否则，可能是重复的同步操作，直接忽略
		//订单处理
		//判断代理订单
		TOrderAgentPayInfo agentPayInfo = null;
		if(resultSyncInfo.getOrderId().indexOf("AGENTORDE")!=-1){
			agentPayInfo = payDao.queryOrderAgentPayByOrderAgentId(resultSyncInfo.getOrderId());
			if(agentPayInfo!=null){
				// 1.判断代订单是否支付
				int result = orderService.isPreAgentOrderExist(agentPayInfo.getAgentOrderId());
				if(result<=0){
					LogUtil.logError.error("WARN when handling pay result sync: orderId "+resultSyncInfo.getOrderId()+" not found. Maybe it is handled already. result="+result);
					return 0;//已支付或不存在
				}
				// 2.更新支付记录
				payDao.updateAgentPayState(resultSyncInfo.createOrderAgentPayInfo());
				// 3.参数替换
				resultSyncInfo.setAgentOrderId(resultSyncInfo.getOrderId());
				resultSyncInfo.setOrderId(agentPayInfo.getOrderId());
				checkAgentOrderInfo(resultSyncInfo.getAgentOrderId());
			}
		}
		LogUtil.log.info("Receive pay result sync and we handle it. orderId="+resultSyncInfo.getOrderId()+
				",state="+resultSyncInfo.getState());
		//判断订单是否支付
		int result = orderService.isPreOrderExist(resultSyncInfo.getOrderId());
		if(result<=0){
			manyOrderSyncCheck(resultSyncInfo,agentPayInfo);
			LogUtil.logError.error("WARN when handling pay result sync: orderId "+resultSyncInfo.getOrderId()+" not found. Maybe it is handled already. result="+result);
			return 0; //重复订单直接返回成功
		}
		int state = resultSyncInfo.getState();
		String orderId = resultSyncInfo.getOrderId();
		//只能是支付成功或失败
		if(state!=Constant.Pay.PAY_STATE_SUCCESS && state!=Constant.Pay.PAY_STATE_FAIL){
			LogUtil.logError.error("ERROR when handling pay result sync: state should be 1(SUCCESS) or 3(FAIL). state="+state);
			//应该写故障日志!!
			return 1;
		}
			
		//1. 先更新支付表(order_payment)以及交易表. 暂不生成账户收益表（待服务完成后正式打款时生成）
		TOrderPayInfo orderPayInfo = resultSyncInfo.createOrderPayInfo();
		try {
			TMsgResponse msg = orderService.payOrder(orderPayInfo);
			if(msg!=null && msg.respCode==0)
			{
				LogUtil.log.info("Update or create payment info succeed. pay state="+state+",orderId="+orderId);
			}
			else{
				LogUtil.log.info("Update or create payment info succeed. pay state="+state+",orderId="+orderId+
						",orderService.payOrder respMsg="+msg.respMsg);
				//必须抛出异常，从而让事务回滚
				throw new RuntimeException("Call orderService.payOrder failed! respCode="+msg.respCode);
	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogUtil.log.info("Update or create payment info failed. pay state="+state+",orderId="+orderId+",error="+e.getMessage());
			throw new RuntimeException("Call orderService.payOrder failed!");
		}
			
		//2. 更新订单表。
		int orderState=0;//未支付
		if(state==Constant.Pay.PAY_STATE_SUCCESS){
			orderState = 1;//已支付
		}
		orderService.updateOrderState(0L,orderId, orderState,
					  resultSyncInfo.getRemark());
		LogUtil.log.info("Update order info succeed. order state="+orderState+",orderId="+orderId);

		//3. 重要！！同步给服务系统
		try{
			return syncToProductApply(orderId);
		}
		catch(Exception e){
			LogUtil.logError.error("ERROR when sync service apply to Business System.");
			throw new RuntimeException("Call syncToProductApply failed!");
		}
		
			
	}
	
	/**
	 * 多订单检查
	 */
	private void manyOrderSyncCheck(TPayResultSyncInfo resultSyncInfo,TOrderAgentPayInfo agentPayInfo){
		//如果订单为代付 替换支付信息
		TOrderPayInfo payInfo = payDao.getOrderPayInfo(resultSyncInfo.getOrderId());
		if(payInfo==null) //订单不存在
			return;
		//待退订单号,这里只做待支付订单退款
		String agentOrderId = null; 
		// 上次订单为代支付订单
		if (payInfo.getAgentPayFlag() == 1) {
			if (agentPayInfo == null) { // 本次订单为原始订单
				payDao.updatePayState(resultSyncInfo.createOrderPayInfo()); //替换原始订单  agentPayFlag=0
				agentOrderId = payInfo.getAgentOrderId();
			} else {// 本次订单回调为代付订单
				agentOrderId = agentPayInfo.getAgentOrderId();
				if(agentOrderId.equals(payInfo.getAgentOrderId())){//如果同上次相同返回
					return;
				}
			}
		}else if(payInfo.getAgentPayFlag()==0){//上次支付为原始订单
			if(agentPayInfo==null)//本次支付为原始订单 不做处理
				return;
			else //退还本次订单
				agentOrderId = agentPayInfo.getAgentOrderId();
		}
		if(agentOrderId!=null){ //如果订单!=null 直接退款
			//由于需要回调，此处异步处理   优化按表处理
			final String orderId = agentOrderId;
			ExecutorService exec = Executors.newFixedThreadPool(1);
			Runnable run = new Runnable(){
				@Override
				public void run()
				{
					/**
					 * 等待2s
					 */
					try{
						Thread.sleep(2*1000);
					}catch(Exception e){
					}finally{
						//退款操作
						refund(orderId);
					}
				}
			};
			exec.execute(run);
		}
	}
	
	/**
	 * 多代付订单检查
	 */
	private void checkAgentOrderInfo(String payAgentOrderId){
		final String agentOrderId = payAgentOrderId;
		ExecutorService exec = Executors.newFixedThreadPool(1);
		Runnable run = new Runnable(){
			@Override
			public void run()
			{
				/**
				 * 等待60s 检查服务支付情况
				 */
				try{
					Thread.sleep(60*1000);
					String orderId = payDao.queryOrderAgentNeedrefund(agentOrderId);
					if(orderId!=null)
						refund(orderId);
				}catch(Exception e){
					LogUtil.logError.error(" check agent order error agentOrderId :"+agentOrderId);
				}finally{
					
				}
			}
		};
		exec.execute(run);
	}
	
	
	/**
	 * 同步给服务系统. 调用HTTP接口。
	 * @param orderId
	 * @return
	 */
	private int syncToProductApply(String orderId) {
		// TODO Auto-generated method stub
		//得到订单详情
		TOrderPublishInfo orderInfo = orderService.getOrderPublishInfo( orderId);
		if(orderInfo==null){
			LogUtil.logError.error("Sync to business system failed: getOrderPublishInfo failure. orderId="+orderId);
			throw new RuntimeException("Call syncToProductApply failed!");

		}
		TProductApplySync syncInfo = new TProductApplySync();
		syncInfo.setOrderInfo(orderInfo);
		
		String url = serverUrlRoot+"/business/product/apply/sync";
		PostMethod post = new PostMethod(url);
		post.setRequestHeader("Content-Type","application/json;charset=utf-8");	
	    String json = JSON.toJSONString(syncInfo);
	    post.setRequestBody(json);
	    post.releaseConnection();
		HttpClient httpClient = new HttpClient();
		LogUtil.log.info("Call http request: "+url+". orderId="+orderId);
		try {
			httpClient.executeMethod(post);
		    httpClient.getParams().setContentCharset("UTF-8");
		    String result = post.getResponseBodyAsString();
		    TMsgResponse resp = JSON.parseObject(result,TMsgResponse.class);
		    LogUtil.log.info("Receive response. respCode="+resp.respCode+
		    		",respMsg="+resp.respMsg);
		    if(resp.respCode!=0){
		    	LogUtil.logError.error("Response error: respCode="+resp.respCode);
				throw new RuntimeException("Call syncToProductApply failed!");

		    }
		} 
		catch(Exception e){
			e.printStackTrace();
			LogUtil.logError.error("http invoking failed! url="+url+
					",error="+e.getMessage());
			throw new RuntimeException("Call syncToProductApply failed!");

		}
		LogUtil.log.info("Call remote http request succeed.");
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.pay.PayService#getOrderPayId(java.lang.String)
	 */
	@Override
	public String getOrderPayId(String orderId) {
		// TODO Auto-generated method stub
		return payDao.getOrderPayId(orderId);
	}

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.pay.PayService#updatePayState(com.westangel.common.bean.trade.TOrderPayInfo)
	 */
	@Override
	public int updatePayState(TOrderPayInfo orderPayInfo) {
		// TODO Auto-generated method stub
		return payDao.updatePayState(orderPayInfo);
	}

	
	/* 
	 * 退款处理
	 * @see com.westangel.common.service.PayService#refund(int, java.lang.String)
	 */
	@Override
	public int refund(int state, String orderId) throws Exception {
		// TODO Auto-generated method stub
		// 1. 首先检查，如果order_payment表和account_trade_record表已经有退款标识了，则直接返回。
		LogUtil.log.info("============ Begin to refund...order state="+state+",orderId="+orderId);
		if(checkAlreadyRefund(orderId)){
			LogUtil.logError.warn("######## WARN in refund(): already refunded. state="+state+",orderId="+orderId);
			return 0;
		}
		
		//2.将状态设为退款中，然后调用微信的退款接口
		int result=payDao.updatePayStateOnly(orderId,4);
		if(result>0){
			LogUtil.log.info("======== Ok! Set payState to 4(退款中). orderId="+orderId);
		}
		//2.1判断是否需要退还抵用券
		result = checkRefundCoupon(orderId);
		//3.调用第三方支付如微信退款接口
		if(result==0)
		result = refund(orderId);

		//4.修改支付状态和收益记录。
		if(result==0)//success
		{
			LogUtil.log.info(Constant.LOGTAG.INF+"Refund succeed and we begin to update the account info...orderId="+orderId);
			accountService.refund(orderId);
		}
		else
		{
			LogUtil.logError.error(Constant.LOGTAG.ERR+"Refund failed! orderId="+orderId);
		}
		

		
		return result;
	}

	/**
	 * @param orderId
	 * @return
	 * @throws Exception 
	 */
	private boolean checkAlreadyRefund(String orderId) throws Exception {
		// TODO Auto-generated method stub
		Integer payState = payDao.getPayState(orderId);
		if(payState==null){
			LogUtil.logError.error("Exception when checkAlreadyRefund(); orderId not found. orderId="+orderId);
			throw new Exception("Exception when checkAlreadyRefund(); orderId not found. orderId="+orderId);
		}
		if(payState.intValue()==5){
			//已退款
			return true;
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.pay.PayService#refund(java.lang.String)
	 */
	@Override
	public int refund(String orderId) {
		// TODO Auto-generated method stub
		//由具体支付类实现。目前为微信支付
		PayService  invoker = factory.getPayServiceInvoker(2);
		if(null==invoker){
			LogUtil.logError.error("FETAL ERROR when get payService invoker: return null: unsupported pay way: " +
					+2);
			return 1500;
		}
		return invoker.refund(orderId);
	}

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.pay.PayService#getOrderPayInfo(java.lang.String)
	 */
	@Override
	public TOrderPayInfo getOrderPayInfo(String orderId) {
		// TODO Auto-generated method stub
		return payDao.getOrderPayInfo(orderId);
	}

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.pay.PayService#payQrcodeScan(com.westangel.commonservice.trade.bean.TPayWeixinQrcodeScanCallbackReq, int)
	 */
	@Override
	public TMsgResponse<Map<String,Object>> payQrcodeScan(TPayWeixinQrcodeScanCallbackReq payWeixinQrcodeScanReq, int payWay) {
		
		TOrderPayPrepareReq orderPayPrepareReq = createOrderPayPrepareReq(payWeixinQrcodeScanReq,payWay);
		
		return orderService.prepareOrderPay(orderPayPrepareReq);
		
	
	}
	
	
	private int checkRefundCoupon(String orderId){
		int result = 0;
		TOrderMinInfo orderInfo = orderService.getOrderMinInfo(orderId);
		if(StringUtils.isNotEmpty(orderInfo.getCouponIds())){
			for(String couponId : orderInfo.getCouponIds().split(",")){
				couponDao.modifyCoupon(new CouponInfo(couponId,Constant.Coupon.COUPON_STATE_NOT_USED,0f,orderInfo.getBuyer()));
			}
			if(orderInfo.getRealPrice()==orderInfo.getDiscountPrice()){
				TOrderPayInfo payInfo = payDao.getOrderPayInfo(orderId);
				payInfo.setRemark("已退款");
	    		payInfo.setState(5);//已退款
	    		payDao.updatePayState(payInfo);
				result=1;
			}
		}
		return result;
	}
	/**
	 * @param payWeixinQrcodeScanReq
	 * @param payWay
	 * @return
	 */
	private TOrderPayPrepareReq createOrderPayPrepareReq(TPayWeixinQrcodeScanCallbackReq payWeixinQrcodeScanReq,
			int payWay) {
		
		TOrderPayPrepareReq orderPayPrepareReq = new TOrderPayPrepareReq();
		
		TOrderPrepareInfo orderInfo = new TOrderPrepareInfo();
		orderPayPrepareReq.setOrderInfo(orderInfo);
		String productId=payWeixinQrcodeScanReq.getProduct_id();
		orderInfo.setProductId(productId);
		Long userId=userDao.getUserId(payWeixinQrcodeScanReq.getOpenid());
		if(null==userId){
			LogUtil.logError.error(Constant.LOGTAG.ERR+"createOrderPayPrepareReq failed! The patient of openId("+payWeixinQrcodeScanReq.getOpenid()+") does not exist.");
			return null;
		}
		orderInfo.setBuyer(userId);
		//获得产品价格
		TProductDetailInfo productDetailInfo = productService.getProductDetail(productId,null);
		if(null==productDetailInfo){
			LogUtil.logError.error("createOrderPayPrepareReq failed! 不存在此服务产品！,productId="+productId);
			return null;
		}
		
		orderInfo.setRealPrice(productDetailInfo.getUnitPrice()/100);
		
		TPayPrepareInfo payInfo = new TPayPrepareInfo();
		payInfo.setOnlinePayValue(orderInfo.getRealPrice());
		orderPayPrepareReq.setPayInfo(payInfo);
		
		// TODO Auto-generated method stub
		return orderPayPrepareReq;
	}



	
	
}
