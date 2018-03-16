/**
 * 
 */
package com.westangel.common.service;

import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.trade.TOrderMinInfo;
import com.westangel.common.bean.trade.TOrderPayInfo;
import com.westangel.common.bean.trade.TOrderPaymentItemInfo;
import com.westangel.common.bean.trade.TOrderPublishInfo;

import java.util.List;
import java.util.Map;

/**
 * 交易系统-订单服务接口
 * @author bigdragon
 * 
 */
public interface OrderService {

	
	/**
	 * 生成订单
	 * @param orderPublishInfo: 订单信息
	 * @return respCode: 错误码
	 *         result.orderId: 订单ID
	 */
	public TMsgResponse<Map<String,Object>> createOrder(TOrderPublishInfo orderPublishInfo);


	
	/**
	 * 订单支付
	 * @param orderPayInfo
	 * @param locale
	 * @return
	 */
	public TMsgResponse payOrder(TOrderPayInfo orderPayInfo);
	
	/**
	 * 更改订单状态
	 */
	public TMsgResponse updateOrderState(Long userId,String orderId,int state,String remark);

	/**
	 * 内部接口
	 * 获得订单简要信息
	 * @param orderId
	 * @return
	 */
	public TOrderMinInfo getOrderMinInfo(String orderId);

	/**
	 * 获取订单支付明细
	 * @param orderId
	 * @return
	 */
	public List<TOrderPaymentItemInfo> getOrderPaymentItems(String orderId);
}
