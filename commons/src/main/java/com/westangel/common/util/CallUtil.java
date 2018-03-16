package com.westangel.common.util;

import com.westangel.common.bean.sms.CallTwoWayReq;

/**
 * 生成电话拨号数据结构
 * @author Daloong
 *
 */
public class CallUtil {

	public static CallTwoWayReq createCallReq(String fromMobile, String mobile) {
		CallTwoWayReq req = new CallTwoWayReq();
		
		req.setBusinessId(1);
		req.setProductId(1);
		req.setFrom(fromMobile);
		req.setTo(mobile);
		req.setFromSerNum("01057694434");
		req.setToSerNum("01057694434");
		
		return req;
	}
}
