package com.westangel.commonservice.push.service.impl;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.westangel.common.bean.push.PushConstValue;
import com.westangel.common.bean.push.PushContent;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.push.PushUserAlias;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.push.bean.PushBindReq;
import com.westangel.commonservice.push.dao.EventInfoHistoryDao;
import com.westangel.commonservice.push.dao.PushDao;
import com.westangel.commonservice.push.model.EventInfo;
import com.westangel.commonservice.push.model.EventInfoHistory;
import com.westangel.commonservice.push.model.PushBindInfo;
import com.westangel.commonservice.push.model.PushUserBriefInfo;
import com.westangel.commonservice.push.service.PushInvokerService;
import com.westangel.commonservice.push.service.PushService;

/**
* @author 作者 :LIPENG
* @Description: 推送服务实现类
* @version 创建时间：2015年12月5日 下午10:06:43
* 类说明
*/
@Service(value="pushService")
public class PushServiceImpl implements PushService {
	@Autowired
	PushDao pushDao;
	
	@Autowired
	EventInfoHistoryDao eventDao;
	
	//微信
	@Resource(name="weixinService")
	private PushInvokerService wxService;
	
	//小米
	@Resource(name="xiaomiService")
	private PushInvokerService xmService;
	
	//个推
	@Resource(name="getuiService")
	private PushInvokerService gtService;
	
	/**
	 * 绑定
	 */
	@Override
	public void bind(PushBindReq req) {
		pushDao.addBind(req);
	}
	
	/**
	 * 推送
	 */
	@Override
	public void push(PushNotifyInfo notify) 
	{
		//如果有分组别名，则按照分组推送
		if (!StringUtils.isEmpty(notify.getUserAlais())) {
			List<PushUserBriefInfo> list = pushDao.userList4Alias(notify.getBusinessId(), notify.getUserAlais());
			for (PushUserBriefInfo ubi:list){
				push2User(ubi.getUserId(), ubi.getUserRole(), notify);
			}
		} else {
			//单条推送
			push2User(notify.getUserId(), notify.getUserRole(), notify);
		}	
	}
	
	/**
	 * 
	* @Title: push2User 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param notify    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void push2User(Long userId, Integer userRole, PushNotifyInfo notify)
	{
		notify.setUserId(userId);
		notify.setUserRole(userRole);
		
		//获取目标用户绑定的推送通道
		List<PushBindInfo> binds = pushDao.binds4User(notify.getUserId(), notify.getUserRole(), notify.getBusinessId(),notify.getProductId());
		LogUtil.log.debug("-----------------------binde size ="+binds.size());
		if (null != binds) {
			for (PushBindInfo bind : binds){
				//如果是微信
				if (PushConstValue.BindType.BindTypeWeixin.ordinal() == bind.getBindType()) {
					wxService.pushNotify(notify, bind);
				}
				//如果是小米
				else if (PushConstValue.BindType.BindTypeXiaomi.ordinal() == bind.getBindType()){
					xmService.pushNotify(notify, bind);
				}
				//如果是个推
				else if (PushConstValue.BindType.BindTypeGetui.ordinal() == bind.getBindType()){
					gtService.pushNotify(notify, bind);
				}
				
				if(4==bind.getDeviceType())
				{
					EventInfo eventInfo = null ;
					try{
						eventInfo = JsonUtil.toObject(notify.getContent(), EventInfo.class);
					}catch(Exception ex)
					{
						ex.printStackTrace();
					}
					//保存推送消息
					EventInfoHistory eventInfoHistory = new EventInfoHistory();
					eventInfoHistory.setEventId(GeneralUtil.generatorTimeUUID());
					eventInfoHistory.setEventType(eventInfo==null || eventInfo.getEventType() == null  ? 1 : eventInfo.getEventType());
					eventInfoHistory.setEventInfo(eventInfo==null ? notify.getContent() : eventInfo.getEventInfo());
					eventInfoHistory.setEventTip(notify.getTipText());
					eventInfoHistory.setUserId(notify.getUserId());
					eventInfoHistory.setReadFlag(0);
					eventInfoHistory.setBusinessId(notify.getBusinessId());
					eventInfoHistory.setProductId(notify.getProductId());
					eventInfoHistory.setAppType(3==bind.getDeviceType()?"android":"ios");
					eventInfoHistory.setSendTime(new Date());
					eventDao.insertEventInfoHistory(eventInfoHistory);
				}
				
			}
		}		
}
	/**
	 * 获取pushcontent message
	 * @author lichenghao
	 * @title :getMessage
	 * @Description:TODO
	 * @return String
	 * @date 2016年6月16日 下午7:19:55
	 */
	public String getMessage(PushContent pushcontent){
		if(pushcontent==null||StringUtils.isEmpty(pushcontent.getTag()))
			throw new EmptyParamExcption("---param error tag is null");
		PushContent content = pushDao.queryPushConten(pushcontent);
		if(content!=null&&StringUtils.isNotEmpty(content.getPushContent())){
			return MessageFormat.format(content.getPushContent(), pushcontent.getArgs());
		}
		return "";
	}
	@Override
	public void addUserAlias(PushUserAlias userAlias) 
	{
		pushDao.addUserAlias(userAlias);
	}
	
	@Override
	public void removeUserAlias(PushUserAlias userAlias) 
	{
		pushDao.removeUserAlias(userAlias);
	}

}
