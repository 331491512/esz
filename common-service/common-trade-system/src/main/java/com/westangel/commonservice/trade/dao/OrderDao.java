/**
 * 
 */
package com.westangel.commonservice.trade.dao;

import com.westangel.common.bean.trade.*;
import com.westangel.commonservice.trade.model.order.TAgentPayInfo;
import com.westangel.commonservice.trade.model.order.TOrderDetailInfo;
import com.westangel.commonservice.trade.model.order.TOrderSimpleInfo;
import com.westangel.commonservice.trade.model.order.TProductOrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 订单Dao
 * @author bigdragon
 * @date  2015-12-24 上午12:50:28
 */
public interface OrderDao {

	/**
	 * @param orderDetailInfo
	 * @return
	 */
	int createOrder(TOrderDetailInfo orderDetailInfo);

	/**
	 * @param orderProductList
	 * @return
	 */
	int createOrderProductRelation(List<TProductOrderInfo> orderProductList);

	/**
	 * @param param
	 * @return
	 */
	List<TOrderSimpleInfo> listOrder(Map<String, Object> param);

	/**
	 * @param userId 
	 * @param orderId
	 * @return
	 */
	TOrderDetailInfo getOrderDetail(@Param("userId") Long userId, @Param("orderId") String orderId);

	/**
	 * @param orderPayInfo
	 * @return
	 */
	int payOrder(TOrderPayInfo orderPayInfo);

	/**
	 * @param userId
	 * @param orderId
	 * @param state
	 * @param remark
	 * @return
	 */
	int updateOrderState(@Param("userId") Long userId, @Param("orderId") String orderId,@Param("state")  int state,
			@Param("subscriptionFlag")  int subscriptionFlag,@Param("remark") String remark);

	/**
	 * 检查预支付订单是否存在
	 * @param orderId
	 * @return
	 */
	String isPreOrderExist(String orderId);

	
	/**
	 * 检查订单是否存在
	 * @param orderId
	 * @return
	 */
	String isOrderExist(String orderId);

	
	/**
	 * 获得订单最简信息
	 * @param orderId
	 * @return
	 */
	TOrderMinInfo getOrderMinInfo(String orderId);
	
	/**
	 * 获得订单发布信息。同步给服务系统时用
	 * @param orderId
	 * @return
	 */
	TOrderPublishInfo getOrderPublishInfo(String orderId);

	
	/**
	 * 获得产品订购关系和服务状态
	 * @param buyer
	 * @param tProductOrderInfo
	 * @return
	 */
	com.westangel.commonservice.trade.model.order.TProductSubscriptionInfo getProductSubscriptionInfo(@Param("buyer") Long buyer,
			@Param("productId") String productId);
	
	/**
	 * 修改订单参数
	 * @return
	 */
	Integer modifyOrder(Object params);

	/**
	 * 创建代支付记录
	 * @param agentPayInfo
	 */
	int payAgentOrder(TOrderAgentPayInfo agentPayInfo);

	/**代支付记录是否存在
	 * @param agentOrderId
	 * @return
	 */
	String isPreAgentOrderExist(@Param("agentOrderId")String agentOrderId);
	
	/**
	 * 代支付列表
	 * @param orderId
	 * @return
	 */
	List<TAgentPayInfo> getAgentPayInfo(@Param("orderId")String orderId);

	/**
	 * 订单支付项列表
	 * @param orderId
	 * @return
	 */
	public List<TOrderPaymentItemInfo> getOrderPaymentItemInfo(@Param("orderId")String orderId);

	/**
	 * 生成订单支付项明细
	 * @param orderPaymentItems
	 * @param orderId
	 * @return
	 */
	int createOrderPaymentItemInfo(@Param("orderPaymentItems") List<TOrderPaymentItemInfo> orderPaymentItems,
								   @Param("orderId") String orderId);
}
