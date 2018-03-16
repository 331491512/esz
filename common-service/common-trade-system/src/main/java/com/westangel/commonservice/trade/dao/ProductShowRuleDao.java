/**
 * 
 */
package com.westangel.commonservice.trade.dao;

import org.apache.ibatis.annotations.Param;

import com.westangel.commonservice.trade.model.product.TProductShowRuleInfo;

/**
 * @author chenghao
 * @date  2017年2月17日 下午7:55:30
 */
public interface ProductShowRuleDao {
	public TProductShowRuleInfo getProductShowRule(@Param("ruleId") String ruleId);
}
