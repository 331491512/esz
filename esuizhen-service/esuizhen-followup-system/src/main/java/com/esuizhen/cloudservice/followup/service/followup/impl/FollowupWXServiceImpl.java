/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.service.followup.impl;<br/>  
 * <b>文件名：</b>FollowupWXServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月19日上午10:03:58<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.service.followup.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.followup.bean.TWXFollowupMessageInfo;
import com.esuizhen.cloudservice.followup.bean.WXFollowupResultReq;
import com.esuizhen.cloudservice.followup.bean.WXFollowupSendReq;
import com.esuizhen.cloudservice.followup.bean.WXFollowupTemplateReq;
import com.esuizhen.cloudservice.followup.dao.conf.FollowupGlobalConfigInfoDao;
import com.esuizhen.cloudservice.followup.dao.followup.FollowupWXDao;
import com.esuizhen.cloudservice.followup.dao.followupresult.TVarPatientFollowupTobDao;
import com.esuizhen.cloudservice.followup.dao.user.UserDao;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupGlobalConfigInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultDetailInfo;
import com.esuizhen.cloudservice.followup.service.followup.FollowupWXService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupResultService;
import com.esuizhen.cloudservice.followup.util.UtilValidate;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PushContentUtil;
import com.westangel.common.util.PushUtil;

/** 
* @ClassName: FollowupWXServiceImpl
* @Description: 
* @author lichenghao
* @date 2016年7月19日 上午10:03:58  
*/
@Service(value="followupWXService")
@Transactional
public class FollowupWXServiceImpl implements FollowupWXService {
	@Autowired
	private FollowupWXDao dao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private TVarPatientFollowupTobDao varPatientFollowupDao;
	@Autowired
	private FollowupGlobalConfigInfoDao followupGlobalConfigInfoDao;
	@Autowired
	private FollowupResultService followupResultService;
	@Autowired
	private PushInnerService pushInnerService;
	@Value("${server.wx.url.root}")
	private String wxHtmlRoot;
	@Value("${server.questionnaire.toB.path}")
	private String questionurl;
	

	@Override
	public void updateWXFollowupTemplate(WXFollowupTemplateReq req) {
		// TODO Auto-generated method stub
		if(req==null)
			throw new EmptyParamExcption(" param error req is null");
		if(StringUtils.isEmpty(req.getContent()))
			throw new EmptyParamExcption(" param error content is null");
		if(StringUtils.isEmpty(req.getTemplateId()))
			throw new EmptyParamExcption(" param error templateId is null");
		if(StringUtils.isEmpty(req.getSiganature()))
			throw new EmptyParamExcption(" param error siganature is null");
		if(req.getHospitalId()==null)
			throw new EmptyParamExcption(" param error hospitalId is null");
		if(dao.updateFollowupWXTemplate(req)==0){
			throw new EmptyObjectExcption(" update error");
		}
	}

	@Override
	@Transactional
	public void sendWXFollowupMessage(WXFollowupSendReq req) {
		// TODO Auto-generated method stub
		if(req==null)
			throw new EmptyParamExcption(" param error req is null");
		if(req.getMessageId()==null)
			throw new EmptyParamExcption(" param error messageId is null");
		if(StringUtils.isEmpty(req.getTemplateId())){
			if(StringUtils.isEmpty(req.getSignature())&&StringUtils.isEmpty(req.getContent()))
				throw new EmptyParamExcption(" param error template is null");
			else if(StringUtils.isEmpty(req.getSignature())||StringUtils.isEmpty(req.getContent()))
				throw new EmptyParamExcption(" param error siganature is null or content is null");
		}
		if(req.getHospitalId()==null)
			throw new EmptyParamExcption(" param error hospitalId is null");
		if(StringUtils.isEmpty(req.getOpenId()))
			throw new EmptyParamExcption(" param error openId is null");
		if(StringUtils.isEmpty(req.getTrueName()))
			throw new EmptyParamExcption(" param error trueName is null");
		if(req.getFollowupDate()==null)
			throw new EmptyParamExcption(" param error followupDate is null");
		//未发送
		req.setState(0);
		if(dao.createFollowupWXReq(req)==0)
			throw new EmptyObjectExcption(" create followup_wx_req error");
		//消息推送
		try{
			LinkedHashMap<String,Object> user = userDao.queryPatientInfoByOpenId(req.getOpenId());
			LinkedHashMap<String,Object> template = null;
			if(!StringUtils.isEmpty(req.getTemplateId()))
					dao.queryFollowupTemplate(req);
			else{
				template = new LinkedHashMap<String,Object>();
				template.put("siganature", req.getSignature());
				template.put("content", req.getContent());
			}
			List<String> values = new ArrayList<String>();
			values.add(pushInnerService.getMessage(PushContentUtil.getFollowupPushContent(null, "followup.questionnaire.info", new Object[]{template.get("siganature")})));
			values.add(req.getTrueName());
			values.add(DateUtil.getDateStr(req.getFollowupDate()));
			values.add(pushInnerService.getMessage(PushContentUtil.getFollowupPushContent(null, "followup.type.questionnaire.info")));
			values.add((String)template.get("content"));
			PushNotifyInfo notify = PushUtil.getWxTemplatePushNotifyInfo("suifangtixing", wxHtmlRoot+questionurl+"?hospitalId="+req.getHospitalId()+"&messageId="+req.getMessageId()+"&patientId="+user.get("patientId"), values);
			notify.setUserId((Long)user.get("userId"));
			notify.setProductId((Integer)user.get("productId"));
			pushInnerService.push(notify);
			//已发送
			req.setState(1);
		}catch(Exception e){
			LogUtil.logError.error(" send tob followup error error:"+e.getMessage());
			//发送失败
			req.setState(2);
		}
		
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("hospitalId", req.getHospitalId());
		params.put("messageId", req.getMessageId());
		params.put("state", req.getState());
		if(dao.updateFollowupWXReq(params)==0)
			throw new EmptyObjectExcption(" update followup_wx_req error");
	}

	@Override
	public TWXFollowupMessageInfo getWXFollowupMessage(WXFollowupSendReq req) {
		// TODO Auto-generated method stub
		if(req.getMessageId()==null)
			throw new EmptyParamExcption(" param error messageId is null");
		if(req.getHospitalId()==null)
			throw new EmptyParamExcption(" param error hospitalId is null");
		TWXFollowupMessageInfo info = dao.queryFollowupMessage(req);
		return info;
	}

	@Override
	public void createWXFollowupResult(WXFollowupResultReq req) {
		// TODO Auto-generated method stub
		if(req.getMessageId()==null)
			throw new EmptyParamExcption(" param error messageId is null");
		if(req.getHospitalId()==null)
			throw new EmptyParamExcption(" param error hospitalId is null");
		if(req.getPatientId()==null)
			throw new EmptyParamExcption(" param error patientId is null");
		if(req.getFollowupResultValue()==null)
			throw new EmptyParamExcption(" param error followupResultValue is null");
		
		
		TFollowupResultDetailInfo  followupResult = new TFollowupResultDetailInfo();
		followupResult.setFollowupResultBuffId(GeneralUtil.generatorUUID("RBUFF"));
		//填写B端传的任务Id
		followupResult.setFollowupTaskId(req.getMessageId());
		//随访人员
		followupResult.setOperator(9l);
		//患者填写
		followupResult.setSourceFlag(2);
		followupResult.setFollowupResultValue(req.getFollowupResultValue());
		switch (req.getFollowupResultValue()) {
		case 1: //稳定
			break;
		case 2: //复发
			if(StringUtils.isNotEmpty(req.getRelapseDate()))
			followupResult.setRelapseDate(DateUtil.stringToDate(req.getRelapseDate(), "yyyy-MM-dd"));
			if(StringUtils.isNotEmpty(req.getRelapseParts()))
			followupResult.setRelapseParts(req.getRelapseParts());
			break;
		case 3: //转移
			if(StringUtils.isNotEmpty(req.getTransferDate()))
			followupResult.setTransferDate(DateUtil.stringToDate(req.getTransferDate(), "yyyy-MM-dd"));
			if(StringUtils.isNotEmpty(req.getTransferParts()))
			followupResult.setTransferParts(req.getTransferParts());
			break;
		case 4: //死亡
			Date deathDate=null;
			DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			boolean guessFlag=true;
			if(UtilValidate.isNotEmpty(req.getDeathDate())){
				try {
					guessFlag=false;
					deathDate=sdf.parse(req.getDeathDate());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					guessFlag=true;
				}
			}
			if(guessFlag){
				TFollowupGlobalConfigInfo globalConfig = followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
				Integer autoGuessDiedFlag=globalConfig.getAutoGuessDiedFlag();
				if(autoGuessDiedFlag==1){
					Date latestTouchDate = varPatientFollowupDao.queryLatestTouchDate(req.getPatientId());
					deathDate=followupResultService.calculateDeathDate(null,latestTouchDate,new Date());
				}
			}
			followupResult.setDeathDate(deathDate);
			if(StringUtils.isNotEmpty(req.getDeathCause()))
				followupResult.setDeathCause(req.getDeathCause());
			break;
		case 5://其它原因
			if(StringUtils.isNotEmpty(req.getOtherCause()))
			followupResult.setOtherCause(req.getOtherCause());
		default:
			break;
		}
		followupResult.setSyncFlag(0);
		followupResult.setFollowupWay(4);
		followupResult.setFollowupTime(new Date());
		followupResult.setCreateTime(new Date());
		followupResult.setUpdateTime(new Date());
		followupResult.setHospitalId(req.getHospitalId());
		followupResult.setPatientId(req.getPatientId());
		//保存
		followupResultService.updateFollowupResultToC(followupResult);
		
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("hospitalId", req.getHospitalId());
		params.put("messageId", req.getMessageId());
		params.put("followupResultBuffId", followupResult.getFollowupResultBuffId());
		params.put("replyState", 1);
		if(dao.updateFollowupWXReq(params)==0)
			throw new EmptyObjectExcption(" update followup_wx_req error");
	}
	
	
}
