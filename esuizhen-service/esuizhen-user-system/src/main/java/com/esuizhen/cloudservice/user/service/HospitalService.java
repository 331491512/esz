/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.service<br/>  
 * <b>文件名：</b>UserService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月2日-下午5:37:19<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.service;

import java.util.List;

import com.esuizhen.cloudservice.user.bean.DepartmentQueryReq;
import com.esuizhen.cloudservice.user.bean.DeptOfpatientReq;
import com.esuizhen.cloudservice.user.bean.HospitalGuideReq;
import com.esuizhen.cloudservice.user.bean.HospitalsCertificatedOfPatientListReq;
import com.esuizhen.cloudservice.user.bean.THospitalGuideInfo;
import com.esuizhen.cloudservice.user.bean.THospitalSimpleInfo;
import com.westangel.common.bean.DepartmentProfile;
import com.westangel.common.bean.HospitalProfile;
import com.westangel.common.bean.HospitalSearchReq;
import com.westangel.common.bean.SubDeptProfile;
import com.westangel.common.bean.THospitalSpecialtyInfo;
import com.westangel.common.bean.TWeixinProductIdInfo;
import com.westangel.common.excption.EmptyParamExcption;

/** 
* @ClassName: HospitalService 
* @Description: TODO
* @author YYCHEN
* @date 2015年12月14日 上午10:57:19  
*/
public interface HospitalService {
	/**
	 * 获取医院列表
	 * @return
	 */
	public List<HospitalProfile> getHospitals(HospitalSearchReq hospitalSearchReq);
	
	/**
	 * 通过hospitalId获取医院详细信息
	 * @param hospitalId 医院ID
	 * @return
	 */
	public HospitalProfile getHospitalDetail(Integer hospitalId,Integer reqFlag);
		
	/**
	 * 通过医院ID获取医院部门
	 * @param hospitalId
	 * @return
	 */
	public List<DepartmentProfile> getDepartmentsByHospitalId(Integer hospitalId);
	/**
	 * 
	* @Title: addHospital 
	* @Description: 添加医院信息 
	* @param @param hospital
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public HospitalProfile addHospital(HospitalProfile hospital);
	
	/**
	 * 修改医院信息
	 * @param hospital
	 * @return
	 * @throws EmptyParamExcption 
	 */
	public boolean modifyHospital(HospitalProfile hospitalProfile) throws EmptyParamExcption;

	/**
	 * 
	* @Title: addDepartment 
	* @Description: 添加科室 
	* @param @param department
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean addDepartment(DepartmentProfile department);
	/**
	 * 
	* @Title: updateDepartment 
	* @Description: 更新科室 
	* @param @param department
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean modifyDepartment(DepartmentProfile department);
	/**
	 * 
	* @Title: addSubDepartment 
	* @Description: 添加子科室 
	* @param @param department
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean addSubDepartment(SubDeptProfile department);
	/**
	 * 
	* @Title: updateSubDepartment 
	* @Description: 更新子科室 
	* @param @param department
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean modifySubDepartment(SubDeptProfile department);

	/**
	 * 获取患者关注的医院列表
	 * @param patientId
	 * @return
	 */
	public List<THospitalSimpleInfo> getHospitalsOfPatientList(Long patientId,Integer productType);

	/**
	 * 查询开通院级服务的医院列表信息
	 * Da Loong
	 * 2016/5/28
	 * @return
	 */
	public List<HospitalProfile> queryHospitalHavingService();

	/**
	 * 获取医院Profile
	 * Da Loong
	 * 2016/5/28
	 * @param hospitalId
	 * @param patientId
	 * @return
	 */
	public HospitalProfile getHospitalProfile(Integer hospitalId, Integer patientId);

	/**
	 * 获取患者认证的医院
	 * Da Loong
	 * 2016/06/01
	 * @param req
	 * @return
	 */
	public List<THospitalSimpleInfo> getHospitalsCertificatedOfPatientList(HospitalsCertificatedOfPatientListReq req);

	/**
	 * 获取独立公众号医院名称
	 * Da Loong
	 * 2016/06/01
	 * @param wxProductId
	 * @return
	 */
	public List<THospitalSimpleInfo> queryHospitalNameByProductId(Integer wxProductId);

	/**
	 * 通过微信ID(toUserName)反查公众号对应的produtId。
	 * By Da Loong
	 * 2016/6/1
	 * @param weixinId
	 * @return
	 */
	public TWeixinProductIdInfo queryWxProductId(String weixinId);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getMetaInfoHospitalSpecialtyList
	 * @Description:获取特色专科
	 * @return THospitalSpecialtyInfo
	 * @date 2016年6月8日 下午7:05:48
	 */
	public List<THospitalSpecialtyInfo> getMetaInfoHospitalSpecialtyList();

	/**
	 * <p>Title:getSignHospitals</p>
	 * <p>Description:获取已签约的医院列表</p>
	 * @author YYCHEN
	 * @date 2016年7月4日 上午10:15:49
	 * @return
	 */
	public List<HospitalProfile> getSignHospitals();
	/**
	 * 
	 * @author lichenghao
	 * @title :getHospitalGuideList
	 * @Description:获取就医指南列表
	 * @return List<THospitalGuideInfo>
	 * @date 2016年7月19日 下午7:24:10
	 */
	public List<THospitalGuideInfo> searchHospitalGuideList(HospitalGuideReq req);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getHospitalGuideInfo
	 * @Description:获取就医指南
	 * @return THospitalGuideInfo
	 * @date 2016年7月19日 下午7:24:52
	 */
	public THospitalGuideInfo getHospitalGuideInfo(HospitalGuideReq req);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryDepartmentMetaInfo
	 * @Description:查询医院详细信息
	 * @return List<DepartmentProfile>
	 * @date 2016年8月19日 上午8:49:39
	 */
	public List<DepartmentProfile> queryDepartment(DepartmentQueryReq req);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryDepartmentMetaInfo
	 * @Description:查询医院科室元数据
	 * @return List<DepartmentProfile>
	 * @date 2016年8月19日 上午8:56:12
	 */
	public List<DepartmentProfile> queryDepartmentMetaInfo(DepartmentQueryReq req);

	public void saveDepartmentOfpatient(DeptOfpatientReq req);

	public List<HospitalProfile> getHospitalListInfo(HospitalSearchReq hospitalSearchReq);
}
