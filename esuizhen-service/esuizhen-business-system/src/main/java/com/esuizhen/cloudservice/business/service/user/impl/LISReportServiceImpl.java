/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.service.user.impl;<br/>  
 * <b>文件名：</b>LISReportImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年8月14日下午4:16:27<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.service.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.business.bean.ReportPatientStatisLiistGetReq;
import com.esuizhen.cloudservice.business.bean.TReportPatientPushBatch;
import com.esuizhen.cloudservice.business.bean.TReportPatientPushBatchDetail;
import com.esuizhen.cloudservice.business.bean.TReportPatientStatiesDetailInfo;
import com.esuizhen.cloudservice.business.dao.business.UserDao;
import com.esuizhen.cloudservice.business.dao.user.LISReportDao;
import com.esuizhen.cloudservice.business.dao.user.LISReportToPatientDao;
import com.esuizhen.cloudservice.business.service.user.LISReportServer;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.message.structuration.TBottomInfo;
import com.westangel.common.bean.message.structuration.TButtonMsg;
import com.westangel.common.bean.message.structuration.TStructuredMsg;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.service.MessageInnerService;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.ImMessageUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;
import com.westangel.common.util.PushContentUtil;
import com.westangel.common.util.PushUtil;

/** 
* @ClassName: LISReportImpl
* @Description: 
* @author lichenghao
* @date 2017年8月14日 下午4:16:27  
*/
@Service
public class LISReportServiceImpl implements LISReportServer {
	private Locale locale=Locale.getDefault();
	
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private PushInnerService pushInnerService;
	@Value("${event.api.url.root}")
	private String eventUrl;
	@Value("${server.wx.url.root}")
	private String wxUrl;
	@Value("${server.wx.service.url.root}")
	private String wxRootUrl;
	@Value("${url.to.report.patient.list}")
	private String toPatientReportList;
	@Value("${url.to.patient.report}")
	private String toPatientReport;
	@Value("${default.doctor.man.userPictureUrl}")
	private String manUrl;
	@Value("${default.doctor.wonman.userPictureUrl}")
	private String womanUrl;
	
	//检查检验h5跳转
	@Value("${url.h5.exam.detail}")
	private String examUrl;
	@Value("${url.h5.detection.detail}")
	private String detectionUrl;
	
	
	@Autowired
	private LISReportDao lisReportDao;
	@Autowired
	private LISReportToPatientDao lisReportToPatientDao;
	@Autowired
	private MessageInnerService messageService;
	@Autowired
	private UserDao userDao;
	@Override
	public void sendPatientReportToDoctor() {
		Map<String, Object> param=new HashMap<String, Object>();
		param.put("linkUrl", eventUrl+toPatientReportList);
		//获取需要发送的医生列表
		List<LinkedHashMap> list = lisReportDao.queryNotSendReportLis(param);
		if(list!=null){
			for(Map doctorInfo:list){
				try{
					//发送给医生统计消息
					TStructuredMsg<TButtonMsg>  struMsg = new TStructuredMsg<TButtonMsg>();
					TButtonMsg buttonMsg = new TButtonMsg();
					TBottomInfo bottom = new TBottomInfo();
					struMsg.setMsgType("button");
					struMsg.setMsgBody(buttonMsg);
					buttonMsg.setBottom(bottom);
					bottom.setText("点击查看");
					bottom.setUrl((String)doctorInfo.get("linkUrl"));
					buttonMsg.setDescription((String)doctorInfo.get("content"));
					//版本大于3.6.3有点击查看按钮
					Integer flag = userDao.compareAppVersion("3.6.3", (Long)doctorInfo.get("doctorUserId"));
					if(flag==null||flag<1)
						buttonMsg.setBottom(null);
					messageService.sendInnerMessage(
							ImMessageUtil.getEDoctorAssistCustomMessage((Long)doctorInfo.get("doctorUserId"), JsonUtil.toJson(struMsg), null));
					//更新发送状态
					lisReportDao.updateExamDetectionReportStatisSendState(doctorInfo);
				}catch(Exception e){
					LogUtil.logError.error("sendToDoctorError statisBatchId="+doctorInfo.get("statisBatchId"));
				}
			}
		}
	}

	@Override
	public Page<TReportPatientStatiesDetailInfo> getReportPatientStatisList(ReportPatientStatisLiistGetReq req) {
		PageHelper.startPage(req.getPage()+1,req.getNum());
		Map<String, Object> param=new HashMap<String, Object>();
		param.put("linkUrl", eventUrl+toPatientReport);
		param.put("manUrl", wxRootUrl+manUrl);
		param.put("wonman", wxRootUrl+womanUrl);
		param.put("statisBatchId",req.getStatisBatchId());
		List<TReportPatientStatiesDetailInfo> list = lisReportDao.queryDoctorReportPatientList(param);
		return PageUtil.returnPage((com.github.pagehelper.Page<TReportPatientStatiesDetailInfo>)list);
	}

	@Override
	public void sendPatientReport() {
		//查询待推送列表
		List<TReportPatientPushBatch> list = lisReportToPatientDao.queryWaitPushBatch(null);
		if(list==null||list.isEmpty())
			return;
		//循环推送
		for(TReportPatientPushBatch pushBatch:list){
			//推送信息
			pushMessageToPatient(pushBatch);
			//更新状态
			lisReportToPatientDao.updatePushBatchWait(pushBatch);
		}
		//记录并删除
		lisReportToPatientDao.createPushBatchWaitHistory(list);
		lisReportToPatientDao.createPushBatchDetailWaitHistory(list);
		//删除已推送 或者 推送次数大于3的
		lisReportToPatientDao.deletePushBatchWait();
	}
	//推送消息给患者
	private void pushMessageToPatient(TReportPatientPushBatch pushBatch) {
		if(pushBatch==null||pushBatch.getDetailList().isEmpty()){
			pushBatch.setPushState(-3);
			pushBatch.setFailCause("not has detail");
			LogUtil.log.debug(pushBatch.getFailCause()+",reportId:"+pushBatch.getReportPushBatchId());
			return;
		}
		if(StringUtils.isEmpty(pushBatch.getOpenId())){
			pushBatch.setPushState(-2);
			pushBatch.setFailCause("not has openId");
			LogUtil.log.debug(pushBatch.getFailCause()+",reportId:"+pushBatch.getReportPushBatchId());
			return;
		}
		//进行消息推送
		String examDetailUrl = wxUrl+this.examUrl;
		String detectionDetailUrl = wxUrl + this.detectionUrl;
		String first=null;
		String examFirst = this.pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.wx.patient.report.exam.first", new Object[]{}));
		String detectionFirst =this.pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.wx.patient.report.detection.first", new Object[]{}));
		String detectionFailFirst =this.pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.wx.patient.report.detection.prompt.first", new Object[]{}));
		String remark = this.pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("push.wx.patient.report.remark", new Object[]{}));
		String test="";
		String testDate = "";
		String url=null;
		List<String> values = new ArrayList<String>();
		//循环详情推送
		try {
			for(TReportPatientPushBatchDetail detail: pushBatch.getDetailList()){
				values.clear();
				pushBatch.setPushCount(pushBatch.getPushCount()+1);
				if(detail.getType()==1){//检查
					url = examDetailUrl;
					first= examFirst;
				}else{
					url = detectionDetailUrl;
					if(detail.getPromptFlag()==-1)
						first = detectionFailFirst;
					else
						first = detectionFirst;
				}
				test = detail.getPushItemName();
				if(detail.getItemCheckTime()!=null)
				testDate = DateUtil.convertToStr(detail.getItemCheckTime(), DateUtil.YMR_SLASH);
				//拼装地址
				url+="?reportId="+detail.getReportId()+"&reportType="+detail.getType()+"&hospitalId="+detail.getHospitalId()+"&fromUserName="+pushBatch.getOpenId();
				values.add(first);
				values.add(test);
				values.add(testDate);
				values.add(remark);
				PushNotifyInfo pushNotifyInfo = PushUtil.getWxTemplatePushNotifyInfo("jianchajianyanjieguotongzhi",url, values);
				pushNotifyInfo.setUserId(pushBatch.getUserId());
				pushNotifyInfo.setProductId(2);
				pushInnerService.push(pushNotifyInfo);
			}
			pushBatch.setPushState(1);
			pushBatch.setPushItemCount(pushBatch.getDetailList().size());
			//推送时间
			pushBatch.setPushTime(new Date());
		} catch (Exception e) {
			pushBatch.setPushState(-1);
			pushBatch.setFailCause("push error");
			LogUtil.log.debug(pushBatch.getFailCause()+",reportId:"+pushBatch.getReportPushBatchId()+",errorMsg:"+e.getMessage());
		}
	}
}
