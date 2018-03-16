/**
 * 
 */
package com.westangel.commonservice.trade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.trade.TProductCategoryInfo;

/**
 * 
* @ClassName: ProductCategoryDao 
* @Description: 商品类别 
* @author lichenghao
* @date 2017年8月28日 下午1:43:50
 */
public interface ProductCategoryDao {
	List<TProductCategoryInfo> queryProductCategoryList(@Param("productId")String productId);
}
