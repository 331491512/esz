package com.westangel.common.service;

import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.trade.TProductDetailInfo;

/**
 * 交易系统-产品（商品）接口
 * @author Daloong
 * @date 2016/1/21
 *
 */
public interface ProductService {

	/**获得产品套餐标识。
	  1: 套餐（如私人医生）；0：非套餐； -1：仅作为套餐的子元素，如预约挂号
	*/
	int getProductPackageFlag(int productType);
	
	/**
	 * 获得产品详情
	 * @param productId
	 * @return
	 */
	public TProductDetailInfo getProductDetail(String productId,Integer productSubType);
	public TProductDetailInfo getProductDetail(String productId, String orderId);
	/**
	 * 初始化设置产品
	 * @param userId
	 * @param professionalRankId
	 * @return
	 */
	public TMsgResponse initProduct(Long userId, int professionalRankId);

	/**
	 * 检查此产品是否存在，主要针对有子产品模板的产品（商品）
	 * （若有产品子模板，则必传子产品类型）
	 * @param productId
	 * @param productSubType
	 * @return
	 */
	public boolean checkProductIsExist(String productId,Integer productSubType);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :checkUserProductIsExist
	 * @Description:检查是否存在此类商品
	 * @return boolean
	 * @date 2017年9月29日 上午9:00:18
	 */
	public boolean checkUserProductIsExist(Long userId,Integer productType);
}
