/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.dao.business;<br/>  
 * <b>文件名：</b>BusinessDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月12日下午4:42:10<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.dao.business;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.business.bean.DoctorClinicUsageSetReq;
import com.esuizhen.cloudservice.business.bean.TDoctorClinicInfo;
import com.esuizhen.cloudservice.business.bean.TDoctorClinicScheduleInfo;
import com.esuizhen.cloudservice.business.model.business.DoctorAnnouncement;
import com.esuizhen.cloudservice.business.model.business.RegisteringDoctors;
import com.esuizhen.cloudservice.business.model.business.TDoctorAnnouncementInfo;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.DoctorSimpleInfo;
import com.westangel.common.bean.push.PushUser;
/** 
* @ClassName: BusinessDao.java
* @Description: 
* @author lichenghao
* @date 2015年12月12日 下午4:42:10  
*/
public interface DoctorDao {
	
	/**
	 * 
	 * @author lichenghao
	 * @title :createDoctorAnnouncement
	 * @Description 创建医生公告
	 * @return void
	 * @date 2015年12月13日 下午6:08:04
	 */
	public void createDoctorAnnouncement(DoctorAnnouncement doctorAnnouncement);
	/**
	 * 获取医生公告
	 * @author lichenghao
	 * @title :quryPatientUserByDoctorId
	 * @Description:TODO
	 * @return List<Long>
	 * @date 2015年12月31日 下午1:41:33
	 */
	public List<Long> queryPatientUserByDoctorId(Long doctorId);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :deleteDoctorAnnouncement
	 * @Description:删除医生公告
	 * @return void
	 * @date 2015年12月13日 下午6:17:15
	 */
	public void deleteDoctorAnnouncement(Map<String, Object> params);
	
	/**DoctorAnnouncement
	 * 
	 * @author lichenghao
	 * @title :getDoctorAnnouncementInfoByDoctorId
	 * @Description:获取医生当前公告
	 * @return TDoctorAnnouncementInfo
	 * @date 2015年12月13日 下午3:52:11
	 */
	public TDoctorAnnouncementInfo queryDoctorAnnouncementInfoByDoctorId(Long doctorId);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryDoctorAnnouncementInfoListByDoctorId
	 * @Description:获取所有公告
	 * @return List<TDoctorAnnouncementInfo>
	 * @date 2015年12月13日 下午7:26:28
	 */
	public List<TDoctorAnnouncementInfo> queryDoctorAnnouncementInfoListByDoctorId(Long doctorId);
	
	
	/**
	 * 获取医生userId
	 * @author lichenghao
	 * @title :queryDoctorUserIdByDoctorId
	 * @Description:TODO
	 * @return Long
	 * @date 2016年1月18日 下午4:03:29
	 */
	public Long queryDoctorUserIdByDoctorId(Long doctorId);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getHospitalIdByDoctorId
	 * @Description:获取医生医院编号
	 * @return Long
	 * @date 2015年12月15日 下午2:54:48
	 */
	public Long getHospitalIdByDoctorId(@Param("doctorId") Long doctorId);
	
	
	/**
	 * 通过患者编号获取患者手机号
	 * @author lichenghao
	 * @title :queryPatientPhoneByPatientId
	 * @Description:TODO
	 * @return List<String>
	 * @date 2016年1月8日 下午5:36:47
	 */
	public List<String> queryPatientPhoneByPatientId(Map<String,Object> params);
	
	/**
	 * 获取患者userId
	 * @author lichenghao
	 * @title :queryPatientUserByPatientIds
	 * @Description:TODO
	 * @return List<String>
	 * @date 2016年1月27日 下午5:16:05
	 */
	public List<PushUser> queryPatientUserByPatientIds(Map<String,Object> params);
	
	
	/**
	 * 获取doctorId
	 * @author lichenghao
	 * @title :queryDoctorIdByDoctorUserId
	 * @Description:TODO
	 * @return Long
	 * @date 2016年1月21日 下午1:49:04
	 */
	public Long queryDoctorIdByDoctorUserId(Long doctorId);
	
	/**
	 * <p>Title:findByUserId</p>
	 * <p>Description:根据医生的userId查询医生基本信息</p>
	 * @author YYCHEN
	 * @date 2016年12月5日 下午6:55:35
	 * @param userId
	 * @return
	 */
	Doctor findByUserId(Long userId);
	
	/**
	 * 获取医生基本信息
	 * @author lichenghao
	 * @title :queryDoctorSimpleInfo
	 * @Description:TODO
	 * @return DoctorSimpleInfo
	 * @date 2016年2月6日 下午2:26:50
	 */
	public DoctorSimpleInfo queryDoctorSimpleInfo(@Param("doctorId") Long doctorId,@Param("doctorUserId")Long doctorUserId);

	/**
	 * <p>Title:findPathologyDoctors</p>
	 * <p>Description:查询基层病理医生列表</p>
	 * @author YYCHEN
	 * @date 2016年10月8日 下午5:51:15
	 * @param hospitalId
	 * @return
	 */
	public List<Doctor> findPathologyDoctors(Integer hospitalId);
	/**
	 * <p>Title:findPathologyDoctor</p>
	 * <p>Description:查询MDT服务中的基层病理医生</p>
	 * @author YYCHEN
	 * @date 2016年10月8日 下午8:24:04
	 * @param productApplyId
	 * @return
	 */
	public Doctor findPathologyDoctor(String productApplyId);
	
	/**
	 * <p>Title:findPathologyDoctor</p>
	 * <p>Description:查询产品组内医生</p>
	 * @author YYCHEN
	 * @date 2016年10月8日 下午7:10:30
	 * @param productApplyId
	 * @param productType
	 * @return
	 */
	public Doctor findProductGroupDoctor(@Param("productApplyId")String productApplyId, @Param("groupType")Integer groupType);
}
