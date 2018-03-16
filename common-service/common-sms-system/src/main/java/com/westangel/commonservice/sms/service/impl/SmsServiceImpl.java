package com.westangel.commonservice.sms.service.impl;

import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.ProductInfo;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.sms.*;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.util.*;
import com.westangel.commonservice.sms.dao.SmsDao;
import com.westangel.commonservice.sms.model.*;
import com.westangel.commonservice.sms.service.SmsInvoker;
import com.westangel.commonservice.sms.service.SmsService;
import com.westangel.commonservice.sms.timerTask.TimerTask;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;

@Service(value="smsService")
public class SmsServiceImpl implements SmsService {
	@Autowired
	SmsServiceMap serviceMap;
	
	@Autowired
	SmsChannelMap smsChannelMap;
	
	@Autowired
	CallChannelMap callChannelMap;
	
	@Autowired
	SmsTemplateMap templateMap;
	
	@Autowired
	SmsDao smsDao;

	@Autowired
	MessageSource messageSource;
	/**
	 * 易信通
	 */
	@Resource(name="yixintongService")
	SmsInvoker yixingtongService;
	/**
	 * 北京移动
	 */
	@Resource(name="bjmoblieService")
	SmsInvoker bjmoblieService;
	/**
	 * 云通讯
	 */
	@Resource(name="yuntongxunService")
	SmsInvoker yuntongxunService;
	/**
	 * 微网通
	 */
	@Resource(name="wodongService")
	SmsInvoker wodongService;
		
	@Resource(name="yunzhixunService")
	SmsInvoker yunzhixunService;
	
	@PostConstruct
	public void initConfigure()
	{
		//建立通道和服务的对应关系
		serviceMap.put("yixintong", yixingtongService);
		serviceMap.put("yuntongxun", yuntongxunService);
		serviceMap.put("bjmobile", bjmoblieService);
		serviceMap.put("wodong",wodongService);
		serviceMap.put("yunzhixun", yunzhixunService);
		//建立验证码通道和产品的映射关系
		List<SmsChannelInfo> channels = smsDao.getChannelList();
		if (null != channels) {
			for(SmsChannelInfo channel:channels){
				smsChannelMap.put(smsKey4BusinessProduct(channel.getId(),channel.getBusinessId(), channel.getProductId(), channel.getAccessType()), channel);
			}
		}
		
		//建立模版名称和模版的对应关系
		List<SmsTemplateInfo> templates = smsDao.getTemplateList();
		if (null != templates) {
			for(SmsTemplateInfo template:templates){
				templateMap.put(template.getName(), template);
			}			
		}
		
		//建立电话通道和产品的映射关系
		List<CallChannelInfo> calls = smsDao.getCallChannelList();
		if (null != calls) {
			for(CallChannelInfo call:calls){
				callChannelMap.put(callKey4BusinessProduct(call.getBusinessId(), call.getProductId()), call);
			}			
		}
	}
	
	/**
	 * 发送验证码
	 */
	@Override
	public boolean sendCaptcha(SmsCaptchaGetReq req)
	{
		List<SmsChannelInfo> channels=this.smsChannel4Product(req.getBusinessId(),req.getProductId(),0);
		return this.sendCaptcha(req,channels,0);
	}

	/**
	 * 递归发送验证码
	 * @param req
	 * @param channels
	 * @param times
	 * @return
	 */
	private boolean sendCaptcha(SmsCaptchaGetReq req,List<SmsChannelInfo> channels,int times){
		boolean result = false;
		String failedCause="";
		if(channels.size()<=times){throw ExceptionUtil.commonErrorException(ErrorMessage.E1600.code,
						messageSource.getMessage(ErrorMessage.ERRORSMSCAPTCHACHECK.info, null, Locale.CHINA),
						"已经没有可用的短信通道了");
		}
		try {
			SmsChannelInfo channel = channels.get(times);
			SmsInvoker invoker = this.smsInvoker4Product(channel.getChannelName());
			ProductInfo product = new ProductInfo(channel.getBusinessId(), channel.getProductId());
			result=invoker.sendCapatcha(product, req.getMobile(), channel.getTemplateText());
		} catch (Exception e) {
			//短信异常先不抛出，发送失败后继续使用下一通道
			//throw ExceptionUtil.commonErrorException(ErrorMessage.E1600.code,
			//		messageSource.getMessage(ErrorMessage.ERRORSMSCAPTCHACHECK.info, null, Locale.CHINA),
			//		e.toString());
			failedCause=e.toString();
			LogUtil.logError.error(e.toString());
			result=false;
		}
		if(result){
			occurOperate("发送短信验证码", JsonUtil.toJson(req), 1, "");
		}else{
			occurOperate("发送短信验证码", JsonUtil.toJson(req), 0, failedCause);
			this.sendCaptcha(req,channels,times+1);
		}
		return result;
	}

	
	/**
	 * 校验验证码
	 */
	@Override
	public boolean checkCaptcha(SmsCaptchaCheckReq req)
	{
		boolean result = false;
		SmsCaptchaRecordInfo recordInfo = smsDao.getCaptcha(req.getBusinessId(), req.getProductId(), req.getMobile(), req.getCaptcha());
		if (null == recordInfo) {
			occurOperate("短信验证码", JsonUtil.toJson(req), 0, "");
			throw ExceptionUtil.commonErrorException(ErrorMessage.E1601.code,
					messageSource.getMessage(ErrorMessage.E1601.info, null, Locale.CHINA), 
					null);
		} else {
			Long timing = 0L;
			try {
				timing = TimeUtil.timingWithNow(recordInfo.getOccurTime());	
			} catch (Exception e) {
				throw ExceptionUtil.commonErrorException(ErrorMessage.E1602.code,
						messageSource.getMessage(ErrorMessage.E1602.info, null, Locale.CHINA), 
						null);
			} finally {
				if (timing > 30*60000) {
					throw ExceptionUtil.commonErrorException(ErrorMessage.E1603.code,
							messageSource.getMessage(ErrorMessage.E1603.info, null, Locale.CHINA), 
							null);					
				}
			}
			occurOperate("短信验证码", JsonUtil.toJson(req), 1, "");
			result = true;
		}
		return result;
	}

	/**
	 * 发送短信
	 */
	@Override
	public boolean sendContent(SmsContentSendReq req)
	{
		List<SmsChannelInfo> channels=this.smsChannel4Product(req.getBusinessId(),req.getProductId(),0);
		return this.sendContent(req,channels,0);
	}

	/**
	 * 递归发送短信
	 * @param req
	 * @param channels
	 * @param times
	 * @return
	 */
	public boolean sendContent(SmsContentSendReq req,List<SmsChannelInfo> channels,int times){
		boolean result = false;
		String failedCause="";
		if(channels.size()<=times){
			throw ExceptionUtil.commonErrorException(ErrorMessage.E1604.code,
						messageSource.getMessage(ErrorMessage.E1604.info, null, Locale.CHINA),
						"已经没有可用的短信通道了");
		}
		try {
			SmsChannelInfo channel = channels.get(times);
			SmsInvoker invoker = this.smsInvoker4Product(channel.getChannelName());
			ProductInfo product = new ProductInfo(req.getBusinessId(), req.getProductId());
			result=invoker.sendContent(product, req.getMobiles(), req.getContent());
		} catch (Exception e) {
			e.printStackTrace();
			//短信异常先不抛出，发送失败后继续使用下一通道
			//throw ExceptionUtil.commonErrorException(ErrorMessage.E1604.code,
			//		messageSource.getMessage(ErrorMessage.E1604.info, null, Locale.CHINA),
			//		e.toString());
			failedCause=e.toString();
			LogUtil.logError.error(e.toString());
			result=false;
		}
		if(result){
			occurOperate("发送短信", JsonUtil.toJson(req), 1, "",req.getSendBackUrl());
			if(StringUtils.isNotEmpty(req.getSendBackUrl())){
				TimerTask.pushSmsReport = true;
				TimerTask.lastGetReportDate = new Date();
			}
		}else{
			occurOperate("发送短信", JsonUtil.toJson(req), 0, failedCause);
			this.sendContent(req,channels,times+1);
		}
		return result;
	}

	/**
	 * 发送模版
	 */
	@Override
	public boolean sendTemplate(SmsTemplateSendReq req) 
	{
		boolean result = false;
		//根据名称获取模版
		SmsTemplateInfo template = templateMap.get(req.getTemplateName());
		if (null == template) {
			occurOperate("发送模版短信", JsonUtil.toJson(req), 0, "没有找到模版："+req.getTemplateName()+"！");
		} else {
			List<SmsChannelInfo> channels=this.smsChannel4Product(req.getBusinessId(),req.getProductId(),0);
			this.sendTemplate(req,template,channels,0);
		}
		return result;
	}


	public boolean sendTemplate(SmsTemplateSendReq req,SmsTemplateInfo template,List<SmsChannelInfo> channels,int times){
		boolean result = false;
		String failedCause="";
		if(channels.size()<=times){throw ExceptionUtil.commonErrorException(ErrorMessage.E1605.code,
						messageSource.getMessage(ErrorMessage.E1605.info, null, Locale.CHINA),
						"已经没有可用的短信通道了");
		}
		try {
			SmsChannelInfo channel = channels.get(times);
			SmsInvoker invoker = this.smsInvoker4Product(channel.getChannelName());
			ProductInfo product = new ProductInfo(req.getBusinessId(), req.getProductId());
			SmsTemplateMessageInfo message = new SmsTemplateMessageInfo();
			message.setName(req.getTemplateName());
			message.setValues(req.getValues());
			message.setExpression(template.getExpression());
			result=invoker.sendTemplateMessage(product, req.getMobile(), message);
		} catch (Exception e) {
			//短信异常先不抛出，发送失败后继续使用下一通道
			//throw ExceptionUtil.commonErrorException(ErrorMessage.E1605.code,
			//		messageSource.getMessage(ErrorMessage.E1605.info, null, Locale.CHINA),
			//		e.toString());
			failedCause=e.toString();
			LogUtil.logError.error(e.toString());
			result=false;
		}
		if(result){
			occurOperate("发送模版短信", JsonUtil.toJson(req), 1, "");
		}else{
			occurOperate("发送模版短信", JsonUtil.toJson(req), 0, failedCause);
			this.sendTemplate(req,template,channels,times+1);
		}
		return result;
	}


	/**
	 * 双向拨打电话
	 */
	@Override
	public boolean callTwoWay(CallTwoWayReq req)
	{
		boolean result = false;
		try {
			SmsInvoker invoker = callInvoker4Product(req.getBusinessId(), req.getProductId());
			ProductInfo product = new ProductInfo(req.getBusinessId(), req.getProductId());
			invoker.callTwoway(product, req.getFrom(),req.getTo(), req.getFromSerNum(), req.getToSerNum(),
					req.getUserData(), req.getMaxCallTime(), req.getCallbackUrl());	
			occurOperate("拨打电话", JsonUtil.toJson(req), 1, "");
			result = true;
		} catch (Exception e) {
			occurOperate("拨打电话", JsonUtil.toJson(req), 0, e.toString());
			throw ExceptionUtil.commonErrorException(ErrorMessage.E1606.code,
					messageSource.getMessage(ErrorMessage.E1606.info, null, Locale.CHINA),
					e.toString());			
		}
		return result;
	}

	/**
	 * 
	* @Title: channel4Product 
	* @Description: 根据产品获取配置的通道 
	* @param @param businessId
	* @param @param productId
	* @param @param accessType
	* @param @return    设定文件 
	* @return List<SmsChannelInfo>    返回类型
	* @throws
	 */
	private List<SmsChannelInfo> smsChannel4Product(Integer businessId, Integer productId, Integer accessType)
	{
		String key = smsKey4BusinessProduct(null,businessId, productId, accessType);
		List<SmsChannelInfo> channels=new ArrayList<SmsChannelInfo>();
		for(String str : smsChannelMap.keySet()){
			if(str.contains(key))
				channels.add(smsChannelMap.get(str));
		}
		if (channels==null||channels.size()<=0) {
			throw new RuntimeException("没有找到合适的短信通道：（"+key+"）！");
		}
		this.channelOrdertByWeight(channels);
		return channels;
	}

	/**
	 * 根据权重为短信通道倒序排列
	 * @param channels
	 */
	private void channelOrdertByWeight(List<SmsChannelInfo> channels){
		Collections.sort(channels, new Comparator<SmsChannelInfo>() {
			@Override
			public int compare(SmsChannelInfo o1, SmsChannelInfo o2) {
				if(o1.getWeight()==null){
					return 1;
				}else if(o2.getWeight()==null){
					return -1;
				}else{
					return o2.getWeight().compareTo(o1.getWeight());
				}
			}
		});
	}
	
	/**
	 * 
	* @Title: smsInvoker4Product 
	* @Description: 根据产品获取配置的通道 
	* @param @param channelName
	* @param @return    设定文件 
	* @return SmsInvoker    返回类型 
	* @throws
	 */
	private SmsInvoker smsInvoker4Product(String channelName)
	{
		SmsInvoker invoker = serviceMap.get(channelName);
		if (null == invoker) {
			throw new RuntimeException("没有找到短信invoker：（"+channelName+"）！");
		}
		return invoker;
	}
	/**
	 * 
	* @Title: callInvoker4Product 
	* @Description: 根据产品获取配置的电话通道 
	* @param @param businessId
	* @param @param productId
	* @param @return    设定文件 
	* @return SmsInvoker    返回类型 
	* @throws
	 */
	private SmsInvoker callInvoker4Product(Integer businessId, Integer productId)
	{
		String key = callKey4BusinessProduct(businessId, productId);
		CallChannelInfo channel = callChannelMap.get(key);
		if (null == channel) {
			throw new RuntimeException("没有找到合适的电话通道：（"+key+"）！");
		}
				
		SmsInvoker invoker = serviceMap.get(channel.getChannelName());
		if (null == invoker) {
			throw new RuntimeException("没有找到电话invoker：（"+channel.getChannelName()+"）！");
		}
		return invoker;
	}
	
	/**
	 * 
	* @Title: callKey4BusinessProduct 
	* @Description:  
	* @param @param businessId
	* @param @param productId
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String callKey4BusinessProduct(Integer businessId, Integer productId)
	{
		return ""+businessId+"-"+productId+"";
	}
	
	/**
	 * 
	* @Title: smsKey4BusinessProduct 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param businessId
	* @param @param productId
	* @param @param accessType
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String smsKey4BusinessProduct(Integer id,Integer businessId, Integer productId, Integer accessType)
	{
		if(id!=null){
			return id+"-"+businessId+"-"+productId+"-"+accessType+"";
		}else{
			return ""+businessId+"-"+productId+"-"+accessType+"";
		}
	}
	
	/**
	 * 
	* @Title: occurOperate 
	* @Description: 插入一条操作日志 
	* @param @param name
	* @param @param content
	* @param @param result
	* @param @param failedCause
	* @param @return    设定文件 
	* @return OperateRecord    返回类型 
	* @throws
	 */
	private void occurOperate(String name, String content, Integer result, String failedCause)
	{
		occurOperate(name,content,result,failedCause,null);
	}
	
	private void occurOperate(String name, String content, Integer result, String failedCause,String backUrl){
		OperateRecord operate = new OperateRecord();
		operate.setOperateName(name);
		operate.setOperateContent(content);
		operate.setExeResult(result);
		operate.setFailedCause(failedCause);
		operate.setBackUrl(backUrl);
		smsDao.addOperateRecord(operate);
	}
	/**
	 * 获取短信回复信息
	 */
	@Override
	public Object getReceipt(SmsReceiptReq req) {
		// TODO Auto-generated method stub
		return yixingtongService.getReceipt(new ProductInfo(1, 1));
	}
	
	/**
	 * 拉取短信发送状态
	 */
	@Override
	public boolean getSmsReport() {
		SmsInvoker invoker = null;
		SmsChannelInfo channel = null;
		List<SmsSendReportInfo> list  = new ArrayList<SmsSendReportInfo>();
		for(String key : smsChannelMap.keySet()){
			channel = smsChannelMap.get(key);
			invoker = serviceMap.get(channel.getChannelName());
			Object obj = invoker.getSmsSendReport(channel.getChannelName());
			if(obj!=null){
				list.addAll((ArrayList<SmsSendReportInfo>)obj);
				smsDao.addSendReport((ArrayList<SmsSendReportInfo>)obj);
			}
		}
		if(list.size()==0){
			return false;
		}
		else{
			sendBackReport(list);
			return true;
		}
	}
	
	
	private void sendBackReport(List<SmsSendReportInfo> list){
		String backUrl = smsDao.queryBackUrl();
		if(StringUtils.isEmpty(backUrl))
			throw new EmptyObjectExcption("backUrl is null");
		try{
			Map<String,Object> param = new HashMap<String, Object>();
			param.put("data", list);
			String result = HttpUtil.postWithJSON(backUrl, JsonUtil.toJson(param));
			TMsgResponse msg = JsonUtil.toObject(result, TMsgResponse.class);
			if(msg!=null)
				occurOperate("短信报告", backUrl, msg.respCode, msg.respMsg);
			else
				occurOperate("短信报告", backUrl, null,null);
		}catch(Exception e){
			occurOperate("短信报告", backUrl, 1,e.getMessage());
		}
	}

}
