/**
 * 
 */
package com.westangel.commonservice.trade.dao;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.trade.TOrderAgentPayInfo;
import com.westangel.common.bean.trade.TOrderPayInfo;
import com.westangel.commonservice.trade.model.pay.WeiXinPayInfo;

/**
 * 支付Dao
 * @author bigdragon
 * @date  2016-1-12 下午6:21:17
 */
public interface PayDao {

	/**
	 * 获得支付ID
	 * @param orderId
	 * @return
	 */
	String getOrderPayId(String orderId);

	/**
	 * 更新支付状态
	 * @param orderPayInfo
	 * @return
	 */
	int updatePayState(TOrderPayInfo orderPayInfo);

	/** 
	 * @param state
	 * @return
	 */
	String getPayIdByState(@Param("state") int state,@Param("orderId") String orderId);

	/**
	 * @param orderId
	 * @return
	 */
	Integer getPayState(String orderId);

	/**
	 * @param orderId
	 * @param state
	 * @return
	 */
	int updatePayStateOnly(@Param("orderId") String orderId, @Param("state") int state);

	/**
	 * @param orderId
	 * @return
	 */
	TOrderPayInfo getOrderPayInfo(String orderId);
	
	/**
	 * 更新打款标识
	 * @param orderId
	 * @return
	 */
	int updateProfitFlag(@Param("orderId") String orderId,@Param("profitFlag") int profileFlag);
	
	/**
	 * 获取微信支付信息 默认获取productId为2的
	 * @param productId
	 * @return
	 */
	WeiXinPayInfo queryWeiXinPayInfoByProductId(@Param("productId")Integer productId);
	/**
	 * 获取微信支付信息
	 * @param orderId
	 * @return
	 */
	WeiXinPayInfo queryWeiXinPayInfoByOrderId(@Param("orderId")String orderId);

	/**
	 * 获取代支付信息
	 * @param orderId
	 * @return
	 */
	TOrderAgentPayInfo queryOrderAgentPayByOrderAgentId(@Param("agentOrderId")String agentOrderId);
	
	/**
	 * 更新代理支付记录
	 * @param createOrderAgentPayInfo
	 */
	int updateAgentPayState(TOrderAgentPayInfo agentPayInfo);

	/**
	 * @param agentOrderInfo
	 * 查询该订单是否需要退款
	 * @return
	 */
	String queryOrderAgentNeedrefund(@Param("agentOrderId") String agentOrderId);
	
}
