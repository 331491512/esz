/**
 * 
 */
package com.westangel.commonservice.trade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.trade.CouponTemplateInfoGetReq;
import com.westangel.common.bean.trade.TCouponTemplateDetailInfo;
import com.westangel.common.bean.trade.TCouponTemplateInfo;
import com.westangel.commonservice.trade.bean.TCouponInfo;
import com.westangel.commonservice.trade.model.coupon.CouponTemplateInfo;

/**
 * @author chenghao
 * @date  2016年6月29日 下午2:27:18
 */
public interface CouponDao {

	
	/**创建模版
	 * @param req
	 */
	void createCouponTemplet(Object param);
	
	/**修改模版
	 * @param req
	 */
	void modifyCouponTemplet(Object param);
	
	/**
	 * 获取抵用券模版详情
	 * @param couponTemplate
	 * @return
	 */
	TCouponTemplateDetailInfo queryCouponTemplate(@Param("couponTemplateId")String couponTemplateId);
	
	/**
	 * 获取模版基本信息 通过编号
	 * @param couponTempleId
	 * @return
	 */
	CouponTemplateInfo queryCouponTemplateById(@Param("couponTemplateId")String couponTempleId,@Param("couponId")String couponId);
	
	/**
	 * 创建抵用券
	 * @param param
	 */
	void createCoupon(Object param);
	
	/**
	 * 修改抵用券
	 * @param param
	 */
	int modifyCoupon(Object param);
	
	/**批量创建抵用券
	 * @param req
	 */
	void createCouponList(Object param);
	
	/**
	 * 用户获取抵用券
	 * params   owner 必传
	 */
	List<TCouponInfo> queryCouponList(Object params);
	
	/**
	 * 加载过期抵用券
	 */
	Integer updateCoupon(@Param("owner") Long owner);

	/**
	 * @param req
	 * @return 
	 */
	List<TCouponTemplateInfo> queryCouponTemplateInfo(CouponTemplateInfoGetReq req);
}
