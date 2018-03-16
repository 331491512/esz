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

import com.esuizhen.cloudservice.business.bean.DoctorClinicScheduleSetReq;
import com.esuizhen.cloudservice.business.bean.DoctorClinicUsageReq;
import com.esuizhen.cloudservice.business.bean.DoctorClinicUsageSetReq;
import com.esuizhen.cloudservice.business.bean.FollowupReportApplyReq;
import com.esuizhen.cloudservice.business.bean.TDoctorAnnouncement;
import com.esuizhen.cloudservice.business.bean.TDoctorClinicInfo;
import com.esuizhen.cloudservice.business.bean.TDoctorInvitation;
import com.esuizhen.cloudservice.business.bean.TMsgResponse;
import com.esuizhen.cloudservice.business.model.business.TDoctorAnnouncementInfo;

/** 
* @ClassName: BusinessService.java
* @Description: 
* @author lichenghao
* @date 2015年12月12日 下午4:49:58  
*/
public interface DoctorService {
	
	/**
	 * 医生发布公告
	 * @author lichenghao
	 * @title :createDoctorAnnouncement
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月21日 下午7:41:07
	 */
	public void publishDoctorAnnouncement(TDoctorAnnouncement tdoctorAnnouncement);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :deleteDoctorAnnouncements
	 * @Description:删除指定医生公告
	 * @return void
	 * @date 2015年12月13日 下午7:31:11
	 */
	public void deleteDoctorAnnouncementsByDoctorIdAndAnnouncements(Long doctorId,Integer[] announcements);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryTDoctorAnnouncementInfoByDoctorId
	 * @Description:获取医生当前公告
	 * @return TDoctorAnnouncementInfo
	 * @date 2015年12月13日 下午7:34:07
	 */
	public TDoctorAnnouncementInfo queryTDoctorAnnouncementInfoByDoctorId(Long doctorId);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryTDoctorAnnouncementInfoListByDoctorId
	 * @Description:获取医生所有公告
	 * @return List<TDoctorAnnouncementInfo>
	 * @date 2015年12月13日 下午7:34:36
	 */
	public List<TDoctorAnnouncementInfo> queryTDoctorAnnouncementInfoListByDoctorId(Long doctorId);
	
	/**
	 * 医生出诊时间设置
	 * @author lichenghao
	 * @title :updateDoctorClinicSchedule
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月14日 下午4:20:02
	 */
	public void setDoctorClinicSchedule(DoctorClinicScheduleSetReq req);
	
	/**
	 * 获取医生出诊时间
	 * @author lichenghao
	 * @title :getDoctorClinicScheduleInfo
	 * @Description:TODO
	 * @return List<TDoctorClinicScheduleInfo>
	 * @date 2015年12月14日 下午4:23:39
	 */
	public TDoctorClinicInfo getDoctorClinicScheduleInfo(Long doctorId);
	
	/**
	 * 医生邀请患者 上传病历/完善资料/开启随访计划/关注微信
	 * @author lichenghao
	 * @title :invitePatientDoSomething
	 * @Description:TODO
	 * @return void
	 * @date 2016年1月8日 下午5:12:29
	 */
	public void invitePatientDoSomething(TDoctorInvitation doctorInvitation);
	
	/**
	 * 预约加号设置
	 * @author lichenghao
	 * @param msg 
	 * @title :setDoctorClinicUsage
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2016年1月18日 下午6:41:48
	 */
	public String setDoctorClinicUsage(DoctorClinicUsageSetReq doctorClinicUsageSetReq, TMsgResponse msg);
	/**
	 * 
	 * @author lichenghao
	 * @title :checkDoctorClinicUsage
	 * @Description:检查患者是否可挂号
	 * @return boolean
	 * @date 2017年8月29日 上午11:21:43
	 */
	public boolean checkDoctorClinicUsage(DoctorClinicUsageSetReq req);
	
	/**
	 * 医生预约加号情况获取
	 * @author lichenghao
	 * @title :getDoctorClinicUsage
	 * @Description:TODO
	 * @return TDoctorClinicInfo
	 * @date 2016年1月18日 下午6:42:35
	 */
	public TDoctorClinicInfo getDoctorClinicScheduleUsage(DoctorClinicUsageReq req);
	
	/**
	 * 随访报告申请
	 * @author lichenghao
	 * @title :followupReportApply
	 * @Description:TODO
	 * @return String
	 * @date 2016年5月27日 下午6:53:56
	 */
	public void followupReportApply(FollowupReportApplyReq req);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :backClincUsage
	 * @Description:门诊退号
	 * @return void
	 * @date 2017年8月31日 下午10:47:01
	 */
	public void backClincUsage(DoctorClinicUsageSetReq req);
}
