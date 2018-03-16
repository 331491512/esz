package com.westangel.commonservice.sms.dao;

import com.westangel.common.bean.sms.SmsSendReportInfo;
import com.westangel.commonservice.sms.model.BJMobile.BJMobileChannelInfo;
import com.westangel.commonservice.sms.model.*;
import com.westangel.commonservice.sms.model.wodong.WodongChannelInfo;
import com.westangel.commonservice.sms.model.yixintong.YixintongChannelInfo;
import com.westangel.commonservice.sms.model.yuntongxun.YuntongxunCallChannelInfo;
import com.westangel.commonservice.sms.model.yuntongxun.YuntongxunCallRecord;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
* @ClassName: SmsDao 
* @Description: sms 数据层 
* @author LIPENG
* @date 2015年12月21日 下午1:51:40 
*
 */
public interface SmsDao {
	/**
	 * 短信验证码列表
	 */
	public List<SmsChannelInfo> getChannelList();
	/**
	 * 
	* @Title: saveCaptcha 
	* @Description: 保存验证码 
	* @param @param businessId
	* @param @param productId
	* @param @param mobile
	* @param @param captcha    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void saveCaptcha(
			@Param("businessId") Integer businessId, 
			@Param("productId") Integer productId, 
			@Param("mobile") String mobile,
			@Param("captcha") String captcha);
	
	/**
	 * 
	* @Title: getCaptcha 
	* @Description: 根据产品和手机号获取验证码 
	* @param @param businessId
	* @param @param productId
	* @param @param mobile
	* @param @return    设定文件 
	* @return SmsCaptchaRecordInfo    返回类型 
	* @throws
	 */
	public SmsCaptchaRecordInfo getCaptcha(			
			@Param("businessId") Integer businessId, 
			@Param("productId") Integer productId, 
			@Param("mobile") String mobile,
			@Param("captcha") String captcha);
	/**
	 * 
	* @Title: getYixintongChannelList 
	* @Description: 获取易信通通道列表 
	* @param @return    设定文件 
	* @return List<YixintongChannelInfo>    返回类型 
	* @throws
	 */
	public List<YixintongChannelInfo> getYixintongChannelList();
	
	/**
	 * 
	* @Title: getBJMobileChannelList 
	* @Description: 获取北京移动通道列表 
	* @param @return    设定文件 
	* @return List<BJMobileChannelInfo>    返回类型 
	* @throws
	 */
	public List<BJMobileChannelInfo> getBJMobileChannelList();

	/**
	 * 获取沃动短信通道列表
	 * @return List<WodongChannelInfo>
	 */
	public List<WodongChannelInfo> getWodongChannelList();
	
	/**
	 * 
	* @Title: getTemplateList 
	* @Description: 模版列表 
	* @param @return    设定文件 
	* @return List<SmsTemplateInfo>    返回类型 
	* @throws
	 */
	public List<SmsTemplateInfo> getTemplateList();
	
	/**
	 * 
	* @Title: getCallChannelList 
	* @Description: 获取call通道列表 
	* @param @return    设定文件 
	* @return List<CallChannelInfo>    返回类型 
	* @throws
	 */
	public List<CallChannelInfo> getCallChannelList();
	
	/**
	 * 
	* @Title: getYuntongxunCallChannelList 
	* @Description: 获取云通讯电话通道列表 
	* @param @return    设定文件 
	* @return List<YuntongxunCallChannelInfo>    返回类型 
	* @throws
	 */
	public List<YuntongxunCallChannelInfo> getYuntongxunCallChannelList();
	/**
	 * 
	* @Title: addOperateRecord 
	* @Description: 插入操作日志 
	* @param @param record    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void addOperateRecord(OperateRecord record);
	
	/**
	 * 
	* @Title: addYuntonxunCallRecord 
	* @Description: 添加云通讯拨打电话记录 
	* @param @param record    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void addYuntongxunCallRecord(YuntongxunCallRecord record);
	/**
	 * 
	* @Title: saveYuntongxunCallRecordViaId 
	* @Description: 记录调用情况
	* @param @param record    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void saveYuntongxunCallRecordViaId(
			@Param("id") Long id,
			@Param("callSid") String callSid,
			@Param("response1") String response1);
	/**
	 * 
	* @Title: saveYuntongxunCallRecordViaSid 
	* @Description: 记录回调情况 
	* @param @param record    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void saveYuntongxunCallRecordViaSid(
			@Param("callSid") String callSid,
			@Param("response2") String response2,
			@Param("result") Integer result);
	
	/**
	 * 
	* @Title: queryYuntongxunCallRecordViaSid 
	* @Description: 查询记录通过callSid 
	* @param @param callSid
	* @param @return    设定文件 
	* @return YuntongxunCallRecord    返回类型 
	* @throws
	 */
	public YuntongxunCallRecord queryYuntongxunCallRecordViaSid(
			@Param("callSid") String callSid);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :querySendReportBackUri
	 * @Description:获取短信发送时最后一次的回执链接
	 * @return String
	 * @date 2016年8月29日 下午2:10:48
	 */
	public String queryBackUrl();
	
	/**
	 * 
	 * @author lichenghao
	 * @title :addSendReport
	 * @Description:发送状态报告
	 * @return void
	 * @date 2016年8月29日 上午11:52:05
	 */
	public void addSendReport(@Param("reports")List<SmsSendReportInfo> reports);
	public String getFromClientByMobile(String mobile);
	public void updateFromClientByMobile(@Param("fromClient")String fromClient,@Param("mobile")String mobile);
}
