/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.service<br/>  
 * <b>文件名：</b>DoctorService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月3日-下午6:00:45<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.service;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.user.bean.TDoctorMinInfo;
import com.esuizhen.cloudservice.user.bean.DoctorListReq;
import com.esuizhen.cloudservice.user.bean.DoctorHospitalSearchByKeywordReq;
import com.esuizhen.cloudservice.user.bean.DoctorHospitalSimpleInfo;
import com.esuizhen.cloudservice.user.bean.DoctorSearchByCombinedConditionReq;
import com.esuizhen.cloudservice.user.bean.TDiseaseInfo;
import com.esuizhen.cloudservice.user.bean.TDoctorStatisProfile;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.DoctorProfile;
import com.westangel.common.bean.DoctorSimpleInfo;
import com.westangel.common.bean.DoctorTag;
import com.westangel.common.bean.HospitalDoctor;
import com.westangel.common.bean.LoginByThirdPartyResp;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.User;
import com.westangel.common.bean.UserProfileModifyReq;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.ParamMismatchExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.excption.RemoteCallExcption;

/**
 * @ClassName: DoctorService
 * @Description: TODO
 * @author YYCHEN
 * @date 2015年12月3日 下午6:00:45
 */
public interface DoctorService extends com.westangel.common.service.DoctorService{
	/**
	 * 
	 * @throws EmptyParamExcption 
	 * @Title: searchDoctor @Description: 根据医生编号查询医生信息 @param @return
	 * Doctor @throws
	 */
	public Doctor searchDoctor(Long doctorId) throws EmptyParamExcption;

	/**
	 * @throws EmptyParamExcption 
	 * @Title: searchDoctorByUserId @Description: 根据用户编号查询医生信息 @param @return
	 * Doctor @throws
	 */
	public Doctor searchDoctorByUserId(Long userId) throws EmptyParamExcption;

	/**
	 * 
	 * @throws EmptyParamExcption 
	 * @Title: searchDoctorBYMobile @Description: 根据手机号查询医生账号信息 @param @return
	 * Doctor @throws
	 */
	public Doctor searchDoctorBYMobile(String mobile) throws EmptyParamExcption;

	/**
	 * 
	 * @Title: searchDoctorTagList @Description: 查询医生标签 @param @return
	 * List<DoctorTag> @throws
	 */
	public List<DoctorTag> searchDoctorTagList();

	/**
	 * @Title: searchDoctor @Description: 根据医院，科室，医生名称查询医生列表。 @param param
	 * 请求的参数 @return 医生信息列表 @throws
	 */
	public List<Map<String, Object>> searchDoctor(Map<String, Object> param);

	/**
	 * 
	 * @throws EmptyParamExcption 
	 * @Title: selectDoctorProfileByDoctorId @Description:
	 * 根据医生编号查询医生基本信息 @param @return DoctorProfile @throws
	 */
	public DoctorProfile selectDoctorProfileByDoctorId(Long doctorId, Long patientId) throws EmptyParamExcption;

	/**
	 * 
	 * @throws EmptyParamExcption 
	 * @Title: selectDoctorProfileByDoctorId @Description:
	 * 根据用户编号查询医生基本信息 @param @return DoctorProfile @throws
	 */
	public DoctorProfile selectDoctorProfileByUserId(Long userId) throws EmptyParamExcption;

	/**
	 * 
	 * @param doctorHospitalSearchByKeywordReq
	 * @return
	 */
	public Page<DoctorHospitalSimpleInfo> searchDoctorHospitalByKeyword(DoctorHospitalSearchByKeywordReq doctorHospitalSearchByKeywordReq);

	/**
	 * 
	 * @param patientId
	 * @param productType
	 * @return
	 * @throws EmptyParamExcption 
	 */
	public List<DoctorSimpleInfo> listDoctorsOfPatient(Long patientId, Long productType) throws EmptyParamExcption;

	/**
	 * 获取推荐医生列表
	 * 注意：
	 * 1. productList只返回此医生的两条数据：一个是图文咨询(productType=1)和电话咨询(productType=2)。如果state=2，则价格部分显示为"未开通".
	 * 2. 后端首先查询doctor表中recommendFlag=1的医生记录。如果此患者填写了原发诊断信息，则可以根据此患者的病种(diseaseTypeId对应的diseaseTypeName)或sourceDiagnosis，与医生的tags标签参数进行模糊匹配，返回匹配的结果。
	 * 如果hospital参数传入，则只返回属于此医院的推荐医生。
	 * @param patientId
	 * @param hospitalId
	 * @return
	 * @throws EmptyParamExcption 
	 */
	public List<DoctorSimpleInfo> recommendDoctor(Long patientId, Long hospitalId) throws EmptyParamExcption;
	
	/**
	 * 
	* @Title: modifyRelationWithHospital 
	* @Description: 修改医生和医院/科室的关系 
	* @param @param doctorId
	* @param @param hospitalId
	* @param @param deptId
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean doctorHospitalRelation(HospitalDoctor hospitalDoctor);
	
	/**
	 * 修改医生基本信息
	 * @param userProfileModifyReq
	 * @param user
	 * @param doctor
	 * @return
	 * @throws EmptyParamExcption
	 * @throws EmptyObjectExcption
	 * @throws ParamMismatchExcption
	 * @throws RemoteCallExcption
	 * @throws RejectRequestExcption
	 */
	public LoginByThirdPartyResp modifyDoctorProfile(UserProfileModifyReq userProfileModifyReq, User user, Doctor doctor) throws EmptyParamExcption, EmptyObjectExcption, ParamMismatchExcption, RemoteCallExcption, RejectRequestExcption;
	
	/**
	 * 返回疾病列表
	 * @author lichenghao
	 * @title :getDoctorPatientDiseaseList
	 * @Description:TODO
	 * @return List<TDiseaseInfo>
	 * @date 2016年5月18日 上午10:52:52
	 */
	public List<TDiseaseInfo> getDoctorPatientDiseaseList(Long doctorId);

	public TDoctorStatisProfile getDoctorStaticsInfo(Long doctorId, String staticType);
	
	/**
	 * 医生组合查询
	 * @author lichenghao
	 * @title :searchDoctorByCombinedCondition
	 * @Description:TODO
	 * @return Page<DoctorSimpleInfo>
	 * @date 2016年6月7日 上午10:45:54
	 */
	public Page<DoctorSimpleInfo> searchDoctorByCombinedCondition(DoctorSearchByCombinedConditionReq req);
	
	/**
	 * <p>Title:registerDoctor</p>
	 * <p>Description:通过用户信息新建医生</p>
	 * @author YYCHEN
	 * @date 2016年6月16日 下午4:18:28
	 * @param user
	 * @return
	 */
	public Doctor registerDoctor(User user);
	public List<TDoctorMinInfo>  getDoctorList(DoctorListReq req);

	/**
	 * 
	* @author fanpanwei
	* @date 2017年3月30日
	* @param 
	* @description:判断医生是否有激活权限
	* @return
	 */
	public Integer judgeActivateRight(Long doctorId);
	/**
	* @author fanpanwei
	* @date 2017年3月31日
	* @param 
	* @description：邀请发送短信激活微信患者列表
	* @return
	 */
	public List<Integer> getInvitePatientByMsg(Long doctorId);
	
	/**
	* @author fanpanwei
	* @date 2017年4月1日
	* @param 
	* @description:邀请发送微信完善基础资料的患者列表
	* @return
	 */
	public List<Integer> getInvitePatientByWechat(Long doctorId);
	
	public void modifyActivateDate(Long doctorId);
}
