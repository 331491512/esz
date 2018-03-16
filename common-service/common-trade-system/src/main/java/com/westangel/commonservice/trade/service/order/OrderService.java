/**
 * 
 */
package com.westangel.commonservice.trade.service.order;

import java.util.Map;

import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.trade.TOrderMinInfo;
import com.westangel.common.bean.trade.TOrderPayInfo;
import com.westangel.common.bean.trade.TOrderPublishInfo;
import com.westangel.commonservice.trade.bean.TOrderPayPrepareReq;
import com.westangel.commonservice.trade.model.order.TOrderDetailInfo;
import com.westangel.commonservice.trade.model.order.TOrderSimpleInfo;

/**
 * 交易系统-订单服务接口
 * @author bigdragon
 * 
 */
public interface OrderService {

	
	/**
	 * 生成订单
	 * @param orderDetailInfo: 订单详情
	 * @return respCode: 错误码
	 */
	public TMsgResponse<Map<String,Object>> createOrder(TOrderPublishInfo orderPublishInfo);


	
	/**
	 * 获取订单信息列表
	 * @param userId
	 * @param role
	 * @param page
	 * @param num
	 * @return 分页形式的订单简要信息列表
	 */
	public Page<TOrderSimpleInfo> listOrder(Long userId,Integer role,Integer productType,Integer page,Integer num);

	/**
	 * 获得订单详情
	 * @param userId
	 * @param orderId
	 * @return
	 */
	public TOrderDetailInfo getOrderDetail(Long userId, String orderId);

	/**
	 * 内部接口
	 * 获得订单简要信息
	 * @param orderId
	 * @return
	 */
	public TOrderMinInfo getOrderMinInfo(String orderId);

	/**
	 * 订单支付
	 * @param orderPayInfo
	 * @return
	 * @throws Exception 
	 */
	public TMsgResponse payOrder(TOrderPayInfo orderPayInfo);
	
	/**
	 * 更改订单状态
	 */
	public TMsgResponse updateOrderState(Long userId,String orderId,int state,String remark);



	/**
	 * 订单预支付接口
	 * @param orderPayPrepareReq
	 * @param request 
	 * @return
	 */
	public TMsgResponse<Map<String, Object>> prepareOrderPay(
			TOrderPayPrepareReq orderPayPrepareReq);



	/**
	 * 预支付订单是否存在(state=0)
	 * @param orderId
	 * @return
	 */
	public int isPreOrderExist(String agentOrderId);
	
	/**
	 * 代支付订单是否存在(state=2)
	 * @param orderId
	 * @return
	 */
	public int isPreAgentOrderExist(String orderId);
	
	/**
	 * 获得订单发布信息。同步给服务系统时用
	 * @param orderId
	 * @return
	 */
	TOrderPublishInfo getOrderPublishInfo(String orderId);


}
