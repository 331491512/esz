package com.westangel.commonservice.push.timerTask;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.commonservice.push.model.weixin.WeixinChannelInfo;
import com.westangel.commonservice.push.service.weixin.WeixinService;

@Service(value="timerTask")
public class TimerTask {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	WeixinService weixinService;
	
	/**
	 * 
	* @Title: invokeWhenStarup 
	* @Description: 启动时执行一次 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@PostConstruct
	public void invokeWhenStarup()
	{
		weixinAccessToken();
	}
	/**
	 * 
	* @Title: weixinAccessToken 
	* @Description:  获取所有微信通道的凭证 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@Scheduled(cron="0 0/20 * * * ? ")
	public void weixinAccessToken()
	{
		try {
			for (WeixinChannelInfo channel:weixinService.channelList()){
				//如果不是外部同步
				if (null == channel.getSyncOutter() || 0 == channel.getSyncOutter()) {
					String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+channel.getAppId()+"&secret="+channel.getAppSecret();
					String result = HttpUtil.get(url);
					logger.info("weixinAccessToken getAccessToken\n" + result);
					AccessTokenResp aToken = JsonUtil.toObject(result, AccessTokenResp.class);
		            if (!StringUtils.isEmpty(aToken.access_token)) {
		            	channel.setAccessToken(aToken.access_token);
		        		url ="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+aToken.access_token+"&type=jsapi";
		        		result = HttpUtil.get(url);
		        		logger.info("weixinAccessToken getTicket\n" + result);
		        		JSTicketResp ticket = JsonUtil.toObject(result, JSTicketResp.class);
		        		if (!StringUtils.isEmpty(ticket.ticket)) {
							channel.setJsTicket(ticket.getTicket());
						}
		            	weixinService.updateChannel(channel);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	* @ClassName: JSTicketResp 
	* @Description: 获取微信凭证结果 
	* @author LIPENG
	* @date 2015年12月19日 下午2:58:36 
	*
	 */
	static class JSTicketResp{
		//凭证
		private String ticket;
		//有效期
		private Integer expires_in;
		//错误码
		private Integer errcode;
		//错误信息
		private String errmsg;
		/** 
		* @return expires_in 
		*/
		public Integer getExpires_in() {
			return expires_in;
		}
		/** 
		* @param expires_in 要设置的 expires_in 
		*/
		public void setExpires_in(Integer expires_in) {
			this.expires_in = expires_in;
		}
		/** 
		* @return errcode 
		*/
		public Integer getErrcode() {
			return errcode;
		}
		/** 
		* @param errcode 要设置的 errcode 
		*/
		public void setErrcode(Integer errcode) {
			this.errcode = errcode;
		}
		/** 
		* @return errmsg 
		*/
		public String getErrmsg() {
			return errmsg;
		}
		/** 
		* @param errmsg 要设置的 errmsg 
		*/
		public void setErrmsg(String errmsg) {
			this.errmsg = errmsg;
		}
		/** 
		* @return ticket 
		*/
		public String getTicket() {
			return ticket;
		}
		/** 
		* @param ticket 要设置的 ticket 
		*/
		public void setTicket(String ticket) {
			this.ticket = ticket;
		}
	}	
	
	/**
	 * 
	* @ClassName: AccessTokenResp 
	* @Description: 获取微信凭证结果 
	* @author LIPENG
	* @date 2015年12月19日 下午2:58:36 
	*
	 */
	static class AccessTokenResp{
		//凭证
		private String access_token;
		//有效期
		private Integer expires_in;
		//错误码
		private Integer errcode;
		//错误信息
		private String errmsg;
		/** 
		* @return access_token 
		*/
		public String getAccess_token() {
			return access_token;
		}
		/** 
		* @param access_token 要设置的 access_token 
		*/
		public void setAccess_token(String access_token) {
			this.access_token = access_token;
		}
		/** 
		* @return expires_in 
		*/
		public Integer getExpires_in() {
			return expires_in;
		}
		/** 
		* @param expires_in 要设置的 expires_in 
		*/
		public void setExpires_in(Integer expires_in) {
			this.expires_in = expires_in;
		}
		/** 
		* @return errcode 
		*/
		public Integer getErrcode() {
			return errcode;
		}
		/** 
		* @param errcode 要设置的 errcode 
		*/
		public void setErrcode(Integer errcode) {
			this.errcode = errcode;
		}
		/** 
		* @return errmsg 
		*/
		public String getErrmsg() {
			return errmsg;
		}
		/** 
		* @param errmsg 要设置的 errmsg 
		*/
		public void setErrmsg(String errmsg) {
			this.errmsg = errmsg;
		}
	}	
}
