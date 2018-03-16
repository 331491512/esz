/**
 * 
 */
package com.westangel.commonservice.trade.service.coupon;

import java.util.List;

import com.westangel.common.service.CouponInnerService;
import com.westangel.commonservice.trade.bean.CouponReq;
import com.westangel.commonservice.trade.bean.TCouponInfo;
import com.westangel.commonservice.trade.model.coupon.CouponInfo;

/**
 * @author chenghao
 * @date  2016年6月29日 下午2:32:06
 */
public interface CouponService extends CouponInnerService{

	/**查询抵用券
	 * @param req
	 * @return
	 */
	List<TCouponInfo> searchCoupon(CouponReq req);

	/**领取抵用券
	 * @param req
	 */
	void receiveCoupon(CouponReq req);

	/**
	 * 修改抵用券
	 */
	Integer modifyCoupon(CouponInfo coupon);
}
