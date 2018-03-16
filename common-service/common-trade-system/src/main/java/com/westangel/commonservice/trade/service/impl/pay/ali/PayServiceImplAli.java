/**
 * 
 */
package com.westangel.commonservice.trade.service.impl.pay.ali;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.trade.TOrderPayInfo;
import com.westangel.common.bean.trade.TOrderPublishInfo;
import com.westangel.commonservice.trade.bean.TPayPrepareInfo;
import com.westangel.commonservice.trade.bean.TPayResultSyncInfo;
import com.westangel.commonservice.trade.bean.TPayWeixinQrcodeScanCallbackReq;
import com.westangel.commonservice.trade.service.pay.PayService;

/**
 * @author apple
 * @date  2016-1-10 下午8:00:37
 */
@Component
public class PayServiceImplAli implements PayService {

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.pay.PayService#preparePay(com.westangel.commonservice.trade.bean.TPayPrepareInfo)
	 */
	@Override
	public TMsgResponse<Map<String, Object>> preparePay(TOrderPublishInfo orderInfo,TPayPrepareInfo payInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.pay.PayService#payResultSync(com.westangel.commonservice.trade.bean.TPayResultSyncInfo)
	 */
	@Override
	public int payResultSync(TPayResultSyncInfo resultSyncInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.pay.PayService#getOrderPayId(java.lang.String)
	 */
	@Override
	public String getOrderPayId(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.pay.PayService#updatePayState(com.westangel.common.bean.trade.TOrderPayInfo)
	 */
	@Override
	public int updatePayState(TOrderPayInfo orderPayInfo) {
		// TODO Auto-generated method stub
		return 0;
	}


	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.pay.PayService#refund(int, java.lang.String)
	 */
	@Override
	public int refund(int state, String orderId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.pay.PayService#refund(java.lang.String)
	 */
	@Override
	public int refund(String orderId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.pay.PayService#getOrderPayInfo(java.lang.String)
	 */
	@Override
	public TOrderPayInfo getOrderPayInfo(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.pay.PayService#payQrcodeScan(com.westangel.commonservice.trade.bean.TPayWeixinQrcodeScanCallbackReq, int)
	 */
	@Override
	public TMsgResponse<Map<String, Object>>  payQrcodeScan(TPayWeixinQrcodeScanCallbackReq payWeixinQrcodeScanReq, int payWay) {
		// TODO Auto-generated method stub
		return null;
	}

}
