/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.service.user;<br/>  
 * <b>文件名：</b>ReviewAlertServier.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年8月23日下午4:02:16<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.service.user;

import java.util.Map;

import com.esuizhen.cloudservice.business.bean.DoctorClinicUsageSetReq;
import com.esuizhen.cloudservice.business.bean.ReviewAlertDetailGetReq;
import com.esuizhen.cloudservice.business.bean.ReviewAlertDetailSetReq;
import com.esuizhen.cloudservice.business.bean.ReviewAlertPatientListGetReq;
import com.esuizhen.cloudservice.business.bean.ReviewAlertStatisReq;
import com.esuizhen.cloudservice.business.bean.ReviewAlertToPatientSendReq;
import com.esuizhen.cloudservice.business.model.business.ProductServiceApply;
import com.esuizhen.cloudservice.business.model.business.TReviewAlertDetailInfo;
import com.esuizhen.cloudservice.business.model.business.TReviewAlertStatisInfo;
import com.westangel.common.bean.Page;

/** 
* @ClassName: ReviewAlertServier
* @Description: 
* @author lichenghao
* @date 2017年8月23日 下午4:02:16  
*/
public interface ReviewAlertService {

	void sendReviewAlertToDoctor();

	Page<TReviewAlertDetailInfo> getReviewAlertPatientList(ReviewAlertPatientListGetReq req);

	void setReviewAlertSet(ReviewAlertDetailSetReq req);

	void sendReviewAlertToPatient(ReviewAlertToPatientSendReq req);

	TReviewAlertDetailInfo getReviewAlertGet(ReviewAlertDetailGetReq req);


	void updateReviewDetail(ProductServiceApply psa, String countClinicDateAndClinicTime, String reviewDetailId);
	//扫描随访计划并发送
	void scanningFollowupPlanSend();
	//预约复查数统计
	TReviewAlertStatisInfo getReviewAlertStatis(ReviewAlertStatisReq req);
	//创建预约复查详情  并推送消息
	void createReviewDetail(ProductServiceApply psa, Map<String, Object> map, DoctorClinicUsageSetReq req);
}
