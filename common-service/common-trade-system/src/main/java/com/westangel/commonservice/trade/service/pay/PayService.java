/**
 * 
 */
package com.westangel.commonservice.trade.service.pay;

import java.util.Map;

import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.trade.TOrderPayInfo;
import com.westangel.common.bean.trade.TOrderPublishInfo;
import com.westangel.commonservice.trade.bean.TMsgResponseWeixin;
import com.westangel.commonservice.trade.bean.TPayPrepareInfo;
import com.westangel.commonservice.trade.bean.TPayResultSyncInfo;
import com.westangel.commonservice.trade.bean.TPayWeixinQrcodeScanCallbackReq;
import com.westangel.commonservice.trade.bean.TPayWeixinResultSyncReq;

/**
 * 支付服务模块。
 * 定义了通用的支付接口。从设计上可以灵活支持各类支付平台，如微信，支付宝等。
 * 具体支付实现对应到各类支付平台，目前暂支持微信支付。
 * 通过工厂模式来得到具体的支付实现类。
 * @author bigdragon
 * @date  2016-1-9 下午2:10:24
 */
public interface PayService {

	/**
	 * 预支付接口。向第三方支付平台发出支付请求。
	 * @param orderPublishInfo 
	 * @param payInfo
	 * @param request 
	 * @return
	 */
	TMsgResponse<Map<String, Object>> preparePay(TOrderPublishInfo orderPublishInfo, TPayPrepareInfo payInfo);

	/**
	 * @param resultSyncInfo
	 * @return respCode: 0: success; 1:failed
	 */
	int  payResultSync(TPayResultSyncInfo resultSyncInfo);

	/**
	 * 获得支付ID
	 * @param orderId
	 * @return
	 */
	String getOrderPayId(String orderId);
	
	/**
	 * 获得订单支付信息
	 * @param orderId
	 * @return
	 */
	TOrderPayInfo getOrderPayInfo(String orderId);

	/**
	 * 更新支付状态
	 * @param orderPayInfo
	 * @return
	 */
	int updatePayState(TOrderPayInfo orderPayInfo);

	/** 
	 * 退款处理
	 * @param orderId
	 * @return
	 * @throws Exception 
	 */
	int refund(int state,String orderId) throws Exception;
	
	/**
	 * 调用第三方平台的退款接口
	 * @param orderId
	 * @return
	 */
	int refund(String orderId);

	
	/**
	 * @param payWeixinQrcodeScanReq
	 * @param 
	 * @return 
	 */
	TMsgResponse<Map<String, Object>> payQrcodeScan(TPayWeixinQrcodeScanCallbackReq payWeixinQrcodeScanReq, int payWay);
	
}
