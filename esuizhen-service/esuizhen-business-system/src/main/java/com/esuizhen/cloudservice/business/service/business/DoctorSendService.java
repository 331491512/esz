/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.service.business;<br/>  
 * <b>文件名：</b>BusinessService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月12日下午4:49:58<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.service.business;

import java.util.List;

import com.esuizhen.cloudservice.business.bean.DoctorSendFollowupNotifyReq;
import com.esuizhen.cloudservice.business.bean.DoctorSendKnowledgeArticleReq;
import com.esuizhen.cloudservice.business.bean.DoctorSendQuestionnarieReq;
import com.esuizhen.cloudservice.business.bean.DoctorSendReviewAlertReq;
import com.esuizhen.cloudservice.business.bean.FollowupReportApplyReq;
import com.esuizhen.cloudservice.business.bean.ReviewAppointInfoGetReq;

/** 
* @ClassName: BusinessService.java
* @Description: 
* @author lichenghao
* @date 2015年12月12日 下午4:49:58  
*/
public interface DoctorSendService {
	
	/**
	 * 发送复查提醒给患者
	 * @author lichenghao
	 * @title :sendDoctorReviewAlert
	 * @Description:TODO
	 * @return void
	 * @date 2016年3月28日 下午4:35:04
	 */
	public void sendDoctorReviewAlert(DoctorSendReviewAlertReq req);
	
	/**
	 * 发送随访通知给患者
	 * @author lichenghao
	 * @title :sendDoctorFollowupNotifySend
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月26日 下午4:05:21
	 */
	public void sendDoctorFollowupNotifySend(DoctorSendFollowupNotifyReq req);
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :sendDoctorKnowledgeArticlet
	 * @Description:患教知识发送
	 * @return void
	 * @date 2016年9月29日 下午2:31:31
	 */
	public void sendDoctorKnowledgeArticlet(DoctorSendKnowledgeArticleReq req);
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :sendDoctorQuestionnaire
	 * @Description:随访问卷发送
	 * @return void
	 * @date 2016年9月29日 下午12:06:02
	 */
	public void sendDoctorQuestionnaire(DoctorSendQuestionnarieReq req);
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getReviewAppointInfo
	 * @Description:获取复查预约信息
	 * @return Object
	 * @date 2016年10月9日 下午4:14:04
	 */
	public Object getReviewAppointInfo(ReviewAppointInfoGetReq req);
}
