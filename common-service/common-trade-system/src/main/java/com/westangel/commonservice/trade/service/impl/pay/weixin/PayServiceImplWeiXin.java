/**
 * 
 */
package com.westangel.commonservice.trade.service.impl.pay.weixin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.trade.TOrderAgentPayInfo;
import com.westangel.common.bean.trade.TOrderPayInfo;
import com.westangel.common.bean.trade.TOrderPublishInfo;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.trade.bean.TPayPrepareInfo;
import com.westangel.commonservice.trade.bean.TPayResultSyncInfo;
import com.westangel.commonservice.trade.bean.TPayWeixinQrcodeScanCallbackReq;
import com.westangel.commonservice.trade.dao.PayDao;
import com.westangel.commonservice.trade.dao.UserDao;
import com.westangel.commonservice.trade.model.pay.WeiXinPayInfo;
import com.westangel.commonservice.trade.service.pay.PayService;

/**
 * 支付准备接口实现类
 * @author bigdragon
 * @date  2016-1-10 下午7:58:14
 */
@Component
public class PayServiceImplWeiXin implements PayService{
	
	//@Autowired
	//private  HttpServletRequest request;
	
	@Autowired
	private UserDao  userDao;
	
	@Autowired
	private PayDao  payDao;
	
	
	private static final Locale locale = Locale.getDefault();
	
	@Value("${server.api.url.root}")
	private String serverUrlRoot;

	/**
	 * 支付商户秘钥
	 */
	private static String KEY="Ashine82607188Ashine82607188Ashi";
	
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	/**
	 * 微信支付接口
	 * @see com.westangel.commonservice.trade.service.pay.PayService#preparePay(com.westangel.commonservice.trade.bean.TPayPrepareInfo)
	 */
	@Override
	public TMsgResponse<Map<String, Object>> preparePay(TOrderPublishInfo orderInfo,TPayPrepareInfo payInfo) {
		TMsgResponse<Map<String,Object>> msg = new TMsgResponse();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null,locale);

		//String ip = request.getRemoteAddr();
		int ipRandom = (int) (Math.random()*2550%253+1);
		int ipRandom2 = (int) (Math.random()*2550%253+1);
		String  ip="192.168."+ipRandom+"."+ipRandom2;
		LogUtil.log.debug("ip="+ip);
		if(null==ip || ip.isEmpty()){
			msg.respCode = 1500;
			msg.respMsg = "can not get the weixin client ip address to complete the Weixin unified pay.";
			LogUtil.logError.error("Preparing the weixin pay failed: "+msg.respMsg);
			return msg;
		}
		String notify_url = serverUrlRoot+"/trade/pay/weixin/result/sync";
		String openId = null;
		if(StringUtils.isNotEmpty(payInfo.getAgentAccountId()))
			openId = payInfo.getAgentAccountId();
		else
			openId = userDao.getOpenId(orderInfo.getBuyer(),orderInfo.getWxProductId());//默认传入productId=2(易随诊医生官方公众号）
		if(null==openId){
			msg.respCode = 1404;
			msg.respMsg="can not get the openID for the buyer "+orderInfo.getBuyer();
			LogUtil.logError.error("Preparing the weixin pay failed: "+msg.respMsg);
			return msg;
		}
		//int total_fee = (int) (100*orderInfo.getRealPrice());//单位：分
		
		int total_fee = (int) (100
				* (orderInfo.getRealPrice() - (orderInfo.getDiscountPrice() == null ? 0f : orderInfo.getDiscountPrice())));// 单位：分
		LogUtil.log.debug("total_fee(fen): "+total_fee+",realPrice(yuan):"+orderInfo.getRealPrice());
		if(total_fee<=0){
			msg.respCode = 1400;
			msg.respMsg="invliad total_fee: "+total_fee;
			LogUtil.logError.error("Preparing the weixin pay failed: "+msg.respMsg);
			return msg;
	
		}
		try {
			msg.result = payWeixinUnifiedOrder(notify_url,ip,openId,orderInfo.getOrderTitle(),total_fee,
					orderInfo.getOrderId(),payInfo.getOnlinePayMethod(),orderInfo.getWxProductId());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg.respCode = 1501;
			msg.respMsg="getPayParam to weixin failed: buyer= "+orderInfo.getBuyer()+". error="+e.getMessage();
			LogUtil.logError.error("Preparing the weixin pay failed: "+msg.respMsg);
			return msg;
		}
		
		return msg;
	}
	

	/**
	 * 微信统一下单接口
	/**
	 * 获取prepayid，网络请求之后，调用微信支付js
	 * @param fromUserName  用户微信openID
	 * @param detail 商品描述（图文咨询，电话咨询，私人医生等）
	 * @param out_trade_no商户订单号 
	 * @param total_fee 总金额（传过来是分为单位）
	 * @param notify_url 通知地址 
	 * @param trade_type 交易类型:JSAPI
	 */
	public Map<String,Object> payWeixinUnifiedOrder(String notify_url,String ip,String fromUserName,String detail,int total_fee,
			String out_trade_no,String trade_type,Integer wxProductId) throws Exception{

		 String nonce_str = WeiXinUtil.createRandomStr(32);
		 WeiXinPayInfo payInfo = payDao.queryWeiXinPayInfoByProductId(wxProductId);
		 if(payInfo==null){
			 payInfo = payDao.queryWeiXinPayInfoByProductId(null);
		 }
		 String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		 List<String> params = new ArrayList<String>();
		 if(trade_type.equals("JSAPI"))
		 params.add("openid="+fromUserName);
		 params.add("body="+detail);
		 params.add("appid="+payInfo.getAppId());
		 params.add("mch_id="+payInfo.getMchId());
		 //采用多点支付
		 params.add("out_trade_no="+out_trade_no);
		 params.add("nonce_str="+nonce_str);
		 params.add("total_fee="+total_fee);
		 params.add("notify_url="+notify_url);
		 params.add("trade_type="+trade_type);
		 params.add("spbill_create_ip="+ip);
		 LogUtil.log.debug("notify_url======================"+notify_url);
		 String sign = WeiXinUtil.getWeiXinSign(params,KEY);
		 params.add("sign="+sign);
		 LogUtil.log.debug("sign======================"+sign);
		 String xmlparams = WeiXinUtil.listToXml(params);
		 LogUtil.log.debug("xml======================\n"+xmlparams);
		 String result = WeiXinUtil.methodHttpClientData(url,"post",xmlparams,"xml");
		 LogUtil.log.debug("result======================"+result);
		 
		 Map<String,String> map = WeiXinUtil.xmlToMap(result); 
		 String return_code = map.get("return_code");
		 String return_msg = map.get("return_msg");
		 String prepay_id = map.get("prepay_id");
		 String code_url = map.get("code_url");
		 LogUtil.log.debug("return_code=" +return_code+",return_msg="+return_msg+
				 ",prepay_id"+prepay_id);
		 if(return_code==null || return_code.equals("FAIL"))
		 {
			 LogUtil.logError.error("Calling WeiXin pay return FAIL!" );
			throw new Exception("Calling WeiXin pay return FAIL! "+return_msg );
			 
		 }
		 if(prepay_id==null || prepay_id.isEmpty())
		 {
			 LogUtil.logError.error("Calling WeiXin pay failed! prepay_id is null." );
			 throw new Exception("Calling WeiXin pay failed! prepay_id is null" );
			 
		 }
		 List<String> resList = new ArrayList<String>();
		 resList.add("appId="+payInfo.getAppId());
		 String timeStamp = System.currentTimeMillis()/1000+"";
		 resList.add("timeStamp="+timeStamp);
		 resList.add("nonceStr="+nonce_str);
		 resList.add("package=prepay_id="+prepay_id);
		 resList.add("signType=MD5");
		 if(code_url!=null&&!code_url.isEmpty()){
			 resList.add("code_url="+code_url);
		 }
		 String paySign = WeiXinUtil.getWeiXinSign(resList,KEY);

		 Map<String,Object> res=new HashMap<String,Object>();
		 res.put("orderId",out_trade_no);
		 res.put("appId", payInfo.getAppId());
		 res.put("timeStamp", timeStamp);
		 res.put("nonceStr",nonce_str);
		 res.put("package","prepay_id="+prepay_id);
		 res.put("paySign", paySign);
		 if(code_url!=null&&!code_url.isEmpty())
			 res.put("code_url",code_url);
		 res.put("signType","MD5");
		 //SONObject json = JSON.parseObject(data);
		 
		 return res;
	}


	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.pay.PayService#payResultSync(com.westangel.commonservice.trade.bean.TPayResultSyncInfo)
	 */
	@Override
	public int payResultSync(TPayResultSyncInfo resultSyncInfo) {
		// TODO Auto-generated method stub
		//由父类实现
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
		//由父类实现
		return 0;
	}


	

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.pay.PayService#refund(int, java.lang.String)
	 */
	@Override
	public int refund(int state, String orderId) {
		// TODO Auto-generated method stub
		return  refund(orderId);
	}


	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.pay.PayService#refund(java.lang.String)
	 */
	@Override
	public int refund(String orderId) {
	    	// TODO Auto-generated method stub
	    	// 调用微信的退款接口
		//如果为代支付订单  直接退款
		if(orderId.indexOf("AGENTORDE")!=-1)
			return this.refundAgent(orderId);
 	    int result = 1500;
    	TOrderPayInfo payInfo = getOrderPayInfo(orderId);
    	if(payInfo==null){
    		LogUtil.logError.error(Constant.LOGTAG.ERR+"refund failed: getOrderPayInfo() return null. the pay info not found. orderId="+orderId);
    		return 1404;
    	}
    	try{
	    	String nonce_str = WeiXinUtil.createRandomStr(32);
	    	WeiXinPayInfo weixinPayInfo = payDao.queryWeiXinPayInfoByOrderId(orderId);
	    	String op_user_id = weixinPayInfo.getMchId();
	    	List<String> params = new ArrayList<String>();
		    params.add("appid="+weixinPayInfo.getAppId());
	    	params.add("mch_id="+weixinPayInfo.getMchId());
	    	params.add("nonce_str="+nonce_str);
	    	params.add("transaction_id="+payInfo.getOnlinePayNo());//微信订单号
	    	if(payInfo.getAgentPayFlag()!=1)//非代付
	    		params.add("out_trade_no="+orderId);//商户订单号
	    	else//代付传代付订单号
	    		params.add("out_trade_no="+payInfo.getAgentOrderId());//商户订单号
	    	String refundNo = GeneralUtil.generatorUUID(30);
	    	payInfo.setRefundNo(refundNo);
	    	params.add("out_refund_no="+refundNo);//商户退款单号
	    	int refund_fee = (int)(payInfo.getOnlinePayValue()*100);
	    	params.add("total_fee="+refund_fee);//总金额. 转成分。
	    	params.add("refund_fee="+refund_fee);//退款金额
	    	params.add("op_user_id="+op_user_id);
	    	String sign = WeiXinUtil.getWeiXinSign(params,KEY);
	    	params.add("sign="+sign);
	    	LogUtil.log.info(JsonUtil.toJson(params));
	    	String xmlparams = WeiXinUtil.listToXml(params);
	    	LogUtil.log.info(Constant.LOGTAG.INF+"Begin to call weixin pay https refund method... xmlparams="+xmlparams);
	    	Map<String, String> map = callHttpsWeixinRefund(xmlparams,weixinPayInfo);
	    	if(map==null){
	    		LogUtil.logError.error(Constant.LOGTAG.ERR+"Call weixin refund failed. return null. out_trade_no="+orderId);
	    		return result;
	    	}
	    	String return_code = map.get("return_code");
    		String return_msg = map.get("return_msg");
    		if("SUCCESS".equals(return_code)){//退款是否成功
	    		String result_code = map.get("result_code");
	    		if("SUCCESS".equals(result_code)){
	    	
		    		result = 0;//success
		    		LogUtil.log.info(Constant.LOGTAG.OK+"Call weixin refund succeed. out_trade_no="+orderId);
		    		payInfo.setRemark("已退款");
		    		payInfo.setState(5);//已退款
		    		payDao.updatePayState(payInfo);
		    		//修改代支付信息
		    		updateAgentPayInfo(payInfo);
		    		return result; 
	    		}
	    		else{
		    		
	    			String err_code = map.get("err_code");
	    			String err_code_des = map.get("err_code_des");
	    	  		LogUtil.logError.error(Constant.LOGTAG.ERR+"Call weixin refund failed. return_msg="+return_msg+",result_code ="+result_code+",out_trade_no="+orderId
		    				+",err_code="+err_code+",err_code_des="+err_code_des);		 
	    		}
	    	}
	    	else{
	    		LogUtil.logError.error(Constant.LOGTAG.ERR+"Call weixin refund failed. return_msg="+return_msg+", return_code="+return_code+",out_trade_no="+orderId
	    				);
	    	}
	    }catch(Exception e){
	    	e.printStackTrace();
	    	LogUtil.logError.error(Constant.LOGTAG.ERR+"refund failed: "+e.getMessage());
	    }
		payInfo.setRemark("退款失败");
		payInfo.setState(6);//退款失败
		payDao.updatePayState(payInfo);

	    return result;
	}
	
	private int refundAgent(String agentOrderId){
		int result = 1500;
		TOrderAgentPayInfo payInfo = payDao.queryOrderAgentPayByOrderAgentId(agentOrderId);
    	if(payInfo==null){
    		LogUtil.logError.error(Constant.LOGTAG.ERR+"refund failed: queryOrderAgentPayByOrderAgentId() return null. the pay info not found. agentOrder="+agentOrderId);
    		return 1404;
    	}
    	try{
	    	String nonce_str = WeiXinUtil.createRandomStr(32);
	    	WeiXinPayInfo weixinPayInfo = payDao.queryWeiXinPayInfoByOrderId(payInfo.getOrderId());
	    	String op_user_id = weixinPayInfo.getMchId();
	    	List<String> params = new ArrayList<String>();
		    params.add("appid="+weixinPayInfo.getAppId());
	    	params.add("mch_id="+weixinPayInfo.getMchId());
	    	params.add("nonce_str="+nonce_str);
	    	params.add("transaction_id="+payInfo.getOnlinePayNo());//微信订单号
	    	params.add("out_trade_no="+agentOrderId);//商户订单号
	    	String refundNo = GeneralUtil.generatorUUID(30);
	    	payInfo.setRefundNo(refundNo);
	    	params.add("out_refund_no="+refundNo);//商户退款单号
	    	int refund_fee = (int)(payInfo.getOnlinePayValue()*100);
	    	params.add("total_fee="+refund_fee);//总金额. 转成分。
	    	params.add("refund_fee="+refund_fee);//退款金额
	    	params.add("op_user_id="+op_user_id);
	    	String sign = WeiXinUtil.getWeiXinSign(params,KEY);
	    	params.add("sign="+sign);
	    	LogUtil.log.info(JsonUtil.toJson(params));
	    	String xmlparams = WeiXinUtil.listToXml(params);
	    	LogUtil.log.info(Constant.LOGTAG.INF+"Begin to call weixin pay https refund method... xmlparams="+xmlparams);
	    	Map<String, String> map = callHttpsWeixinRefund(xmlparams,weixinPayInfo);
	    	if(map==null){
	    		LogUtil.logError.error(Constant.LOGTAG.ERR+"Call weixin refund failed. return null. out_trade_no="+payInfo.getAgentOrderId());
	    		return result;
	    	}
	    	String return_code = map.get("return_code");
    		String return_msg = map.get("return_msg");
    		if("SUCCESS".equals(return_code)){//退款是否成功
	    		String result_code = map.get("result_code");
	    		if("SUCCESS".equals(result_code)){
		    		result = 0;//success
		    		LogUtil.log.info(Constant.LOGTAG.OK+"Call weixin refund succeed. out_trade_no="+agentOrderId);
		    		payInfo.setRemark("已退款");
		    		payInfo.setState(5);//已退款
		    		payDao.updateAgentPayState(payInfo);
		    		return result; 
	    		}
	    		else{
		    		
	    			String err_code = map.get("err_code");
	    			String err_code_des = map.get("err_code_des");
	    	  		LogUtil.logError.error(Constant.LOGTAG.ERR+"Call weixin refund failed. return_msg="+return_msg+",result_code ="+result_code+",out_trade_no="+agentOrderId
		    				+",err_code="+err_code+",err_code_des="+err_code_des);		 
	    		}
	    	}
	    	else{
	    		LogUtil.logError.error(Constant.LOGTAG.ERR+"Call weixin refund failed. return_msg="+return_msg+", return_code="+return_code+",out_trade_no="+agentOrderId
	    				);
	    	}
	    }catch(Exception e){
	    	e.printStackTrace();
	    	LogUtil.logError.error(Constant.LOGTAG.ERR+"refund failed: "+e.getMessage());
	    }
		payInfo.setRemark("退款失败");
		payInfo.setState(6);//退款失败
		payDao.updateAgentPayState(payInfo);

	    return result;
	} 
	/**
	 * 修改代支付订单
	 * @param payInfo
	 */
	private void updateAgentPayInfo(TOrderPayInfo payInfo){
		if(payInfo.getAgentPayFlag()!=1)
			return;
		TOrderAgentPayInfo agentPayInfo = payDao.queryOrderAgentPayByOrderAgentId(payInfo.getAgentOrderId());
		if(agentPayInfo==null)
			return;
		agentPayInfo.setState(payInfo.getState());
		agentPayInfo.setRemark(payInfo.getRemark());
		agentPayInfo.setRefundNo(payInfo.getRefundNo());
		try{
			payDao.updateAgentPayState(agentPayInfo);
		}catch(Exception e){
			//修改状态失败
			LogUtil.logError.error(Constant.LOGTAG.ERR+"refund agent order failed: "+e.getMessage());
		}
	}
	
    public Map<String,String> callHttpsWeixinRefund(String xml,WeiXinPayInfo weixinPayInfo){
		String url = "https://api.mch.weixin.qq.com/secapi/pay/refund";
		Map<String, String> map = new HashMap<String, String>();
		try {
			SSLConnectionSocketFactory socketFactory = WeiXinCertificate.instance().callHttps(weixinPayInfo);
			CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
			
			StringEntity entity = new StringEntity(xml);
			
			HttpPost httpPost = new HttpPost(url);
			httpPost.setEntity(entity);
			CloseableHttpResponse responseEntry = httpclient.execute(httpPost);
			
			HttpEntity httpEntity = responseEntry.getEntity();
			
			map = WeiXinUtil.AnalysisXml(httpEntity.getContent(),map);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.logError.error(Constant.LOGTAG.ERR+"callHttpsWeixinRefund error: "+e.getMessage());
			return null;
		}
	
		return map;
    }


	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.pay.PayService#getOrderPayInfo(java.lang.String)
	 */
	@Override
	public TOrderPayInfo getOrderPayInfo(String orderId) {
		// TODO Auto-generated method stub
		return payDao.getOrderPayInfo(orderId);
	}


	/**
	 * 微信扫码支付实现
	 * return 0： 成功； >0：失败(错误码）
	 * @see com.westangel.commonservice.trade.service.pay.PayService#payQrcodeScan(com.westangel.commonservice.trade.bean.TPayWeixinQrcodeScanCallbackReq, int)
	 */
	@Override
	public TMsgResponse<Map<String, Object>>  payQrcodeScan(TPayWeixinQrcodeScanCallbackReq payWeixinQrcodeScanReq, int payWay) {
		// TODO Auto-generated method stub
		return null; //已由父类直接实现。
		
	}

}

