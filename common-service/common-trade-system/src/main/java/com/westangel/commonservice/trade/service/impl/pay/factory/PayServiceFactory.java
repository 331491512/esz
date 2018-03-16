/**
 * 
 */
package com.westangel.commonservice.trade.service.impl.pay.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.westangel.common.constant.Constant;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.trade.service.impl.pay.PayServiceImpl;
import com.westangel.commonservice.trade.service.impl.pay.ali.PayServiceImplAli;
import com.westangel.commonservice.trade.service.impl.pay.weixin.PayServiceImplWeiXin;
import com.westangel.commonservice.trade.service.pay.PayService;

/**
 * 支付服务工厂类。
 * 根据支付类型，生成不同的具体实现类。（微信支付、支付宝支付）
 * @author bigdragon
 * @date  2016-1-10 下午7:54:07
 */
@Component
public class PayServiceFactory {

	@Autowired
	PayServiceImplWeiXin    weixinPayService;
	
	@Autowired
	PayServiceImplAli       aliPayService;
	
	public PayService   getPayServiceInvoker(int payWay) {
		switch(payWay){
			case Constant.Pay.PAY_WAY_WEIXIN: //微信支付
				return weixinPayService;
			case Constant.Pay.PAY_WAY_ALI:    //支付宝支付
				return aliPayService;
		}	
		LogUtil.logError.error("ERROR when getPayServiceInvoker(): invlaid payWay: "+payWay);
		return null;
	}
}
