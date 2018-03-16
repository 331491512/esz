/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.service;<br/>  
 * <b>文件名：</b>CouponInnerService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年6月29日下午2:28:33<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.service;


import java.util.List;

import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.trade.CouponTemplateInfoGetReq;
import com.westangel.common.bean.trade.CouponTemplateReq;
import com.westangel.common.bean.trade.TCouponTemplateDetailInfo;
import com.westangel.common.bean.trade.TCouponTemplateInfo;

/** 
* @ClassName: CouponInnerService
* @Description: 
* @author lichenghao
* @date 2016年6月29日 下午2:28:33  
*/
public interface CouponInnerService{
	
	/**
	 * 获取抵用券模版详情
	 * @author lichenghao
	 * @title :searchCouponTemplate
	 * @Description:TODO
	 * @return TCouponTemplateDetailInfo
	 * @date 2016年6月30日 下午6:40:46
	 */
	TMsgResponse<TCouponTemplateDetailInfo> getCouponTemplate(String couponTemplateId);
	/**
	 * 获取抵用券简要信息列表
	 * @author lichenghao
	 * @title :getCouponTemplate
	 * @Description:TODO
	 * @return TMsgResponse<TCouponTemplateDetailInfo>
	 * @date 2016年7月8日 上午8:32:43
	 */
	TMsgResponse<List<TCouponTemplateInfo>> getCouponTemplateInfoList(CouponTemplateInfoGetReq req);
	
	/**创建抵用券模版
	 * @param req
	 * @return
	 */
	TMsgResponse<Object> createCouponTemplate(CouponTemplateReq req);
	
	/**修改抵用券模版
	 * @param req
	 * @return
	 */
	TMsgResponse<Object> modifyCouponTemplate(CouponTemplateReq req);
	
	/**
	 * 为用户初始化抵用券
	 * @author lichenghao
	 * @title :modifyCouponTemplate
	 * @Description:TODO
	 * @return TMsgResponse<T>
	 * @date 2016年6月29日 下午2:56:00
	 */
	TMsgResponse<Object> initCoupon(CouponTemplateReq req);
}
