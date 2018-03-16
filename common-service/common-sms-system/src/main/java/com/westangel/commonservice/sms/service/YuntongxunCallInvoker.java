package com.westangel.commonservice.sms.service;

import com.westangel.commonservice.sms.bean.yuntongxun.YuntongxunCallerBillReq;

public interface YuntongxunCallInvoker {
	abstract public void callerBillCallback(YuntongxunCallerBillReq req); 
}
