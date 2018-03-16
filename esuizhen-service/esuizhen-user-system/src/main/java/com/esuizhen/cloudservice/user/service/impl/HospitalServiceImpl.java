/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.service.impl<br/>  
 * <b>文件名：</b>DoctorServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月9日-下午5:54:20<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.user.bean.DepartmentQueryReq;
import com.esuizhen.cloudservice.user.bean.DeptOfpatientReq;
import com.esuizhen.cloudservice.user.bean.HospitalGuideReq;
import com.esuizhen.cloudservice.user.bean.HospitalsCertificatedOfPatientListReq;
import com.esuizhen.cloudservice.user.bean.THospitalGuideInfo;
import com.esuizhen.cloudservice.user.bean.THospitalSimpleInfo;
import com.esuizhen.cloudservice.user.common.followuppatient.BeanUtils;
import com.esuizhen.cloudservice.user.dao.DepartmentDao;
import com.esuizhen.cloudservice.user.dao.HospitalDao;
import com.esuizhen.cloudservice.user.dao.HospitalGuideDao;
import com.esuizhen.cloudservice.user.dao.HospitalPatientDao;
import com.esuizhen.cloudservice.user.dao.MetaHosiptalSpecialtyDao;
import com.esuizhen.cloudservice.user.dao.UserDao;
import com.esuizhen.cloudservice.user.service.HospitalService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.DepartmentProfile;
import com.westangel.common.bean.HospitalProfile;
import com.westangel.common.bean.HospitalSearchReq;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.SubDeptProfile;
import com.westangel.common.bean.THospitalSpecialtyInfo;
import com.westangel.common.bean.TWeixinProductIdInfo;
import com.westangel.common.bean.User;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.Codec;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;

/** 
* @ClassName: HospitalServiceImpl 
* @Description: TODO
* @author YYCHEN
* @date 2015年12月9日 下午5:54:20  
*/
@Service(value = "hospitalService")
public class HospitalServiceImpl implements HospitalService, com.westangel.common.service.HospitalService {
	@Autowired
	private HospitalDao dao;
	
	@Autowired
	private HospitalGuideDao hospitalGuideDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private HospitalPatientDao hospitalPatientDao;
	
	@Autowired
	private MetaHosiptalSpecialtyDao metaHospitalSpecialtyDao;
	
	@Value("${server.wx.service.url.root}")
	private String serverWXServiceUrlRoot;
	@Value("${default.hospital.userPictureUrl}")
	private String defaultHospitalPictureUrl;

	/**(非 Javadoc) 
	* <p>Title: getHospitals</p> 
	* <p>Description: </p> 
	* @return 
	* @see com.esuizhen.cloudservice.user.service.HospitalServiceImpl#getHospitals() 
	*/
	@Override
	public List<HospitalProfile> getHospitals(HospitalSearchReq hospitalSearchReq) {
		com.github.pagehelper.Page<HospitalProfile> pageUtil = new com.github.pagehelper.Page<HospitalProfile>();
		PageHelper.startPage(1, 500);
		hospitalSearchReq.setDefaultHospitalPictureUrl(serverWXServiceUrlRoot+defaultHospitalPictureUrl);
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("cityCode", hospitalSearchReq.getCityCode());
		param.put("prefixLen", 0);
		searchCityCodeTrans(param);
		hospitalSearchReq.setCityCode((String)param.get("cityCode"));
		hospitalSearchReq.setPrefixLength((Integer)param.get("prefixLen"));
		List<HospitalProfile> hospitalProfiles = this.dao.searchHospitals(hospitalSearchReq);
		pageUtil.addAll(hospitalProfiles);
		Page<HospitalProfile> pageDatas = PageUtil.returnPage(pageUtil);
		return pageDatas.getDataList();
	}
	
	
	public static void searchCityCodeTrans(Map<String,Object> map){
		String cityCode = (String)map.get("cityCode");
		Integer prefixLength = (Integer)map.get("prefixLen");
		if (!StringUtils.isEmpty(cityCode)) {
			if (StringUtils.startsWith(cityCode, "110")
					|| StringUtils.startsWith(cityCode, "120")
					|| StringUtils.startsWith(cityCode, "310")
					|| StringUtils.startsWith(cityCode, "500")
					) {
				prefixLength = 3;
			} else if(cityCode.endsWith("0000")){
				prefixLength = 3; 
			}else{
				prefixLength = 4;
			}
			cityCode = StringUtils.substring(cityCode,0, prefixLength);
			map.put("cityCode", cityCode);
			map.put("prefixLen",prefixLength);
		}
	}
	/**(非 Javadoc) 
	* <p>Title: getDepartmentsByHospitalId</p> 
	* <p>hospitalId: 医院ID</p> 
	* <p>Description:通过医院ID获取医院部门列表 </p> 
	* @return 
	* @see com.esuizhen.cloudservice.user.service.HospitalServiceImpl#getDepartmentsByHospitalId(Long hospitalId) 
	*/
	@Override
	public List<DepartmentProfile> getDepartmentsByHospitalId(Integer hospitalId) {
		List<DepartmentProfile> departmentProfiles = this.departmentDao.selectDepartmentByHospitalId(hospitalId);
		if (departmentProfiles == null || departmentProfiles.isEmpty()) {
			departmentProfiles = this.departmentDao.selectDepartmentByHospitalId(0);
		}
		return departmentProfiles;
	}

	/**
	 * 获取医院详细信息
	 */
	@Override
	public HospitalProfile getHospitalDetail(Integer hospitalId,Integer reqFlag) {		
		LogUtil.log.debug("reqFlag="+reqFlag);
		
		return this.dao.selectHospital(hospitalId,reqFlag);
	}

	/**(非 Javadoc) 
	* <p>Title: update</p> 
	* <p>hospital: 医院信息</p> 
	* <p>Description:修改医院信息，bean中需指定医院ID </p> 
	* @return 
	 * @throws EmptyParamExcption 
	* @see com.esuizhen.cloudservice.user.service.HospitalServiceImpl#modifyHospital(com.westangel.common.bean.HospitalModifyReq hopitalModifyReq) 
	*/
	@Override
	@Transactional
	public boolean modifyHospital(HospitalProfile hospitalProfile) throws EmptyParamExcption {
		HospitalProfile hospital = this.dao.selectHospital(hospitalProfile.getHospitalId(),1);
		if(hospital == null){
			throw new EmptyParamExcption("\"Hospital\" does not exist!");
		}
		this.dao.updateHospital(hospitalProfile);
		if(hospitalProfile.getSpecialtyList()!=null){
			this.dao.removeHospitalSpecialtyList(hospitalProfile.getHospitalId());
			this.dao.insertHospitalSpecialty(hospitalProfile.getHospitalId(),hospitalProfile.getSpecialtyList());
		}
		return true;
	}


	/**
	 * 添加医院信息
	 */
	@Override
	public HospitalProfile addHospital(HospitalProfile hospital) {
		if(hospital.getMetaDataType() != null && hospital.getMetaDataType() == 1) {
			return addCustomHospital(hospital);
		}else {
			return addInternalHospital(hospital);
		}
	}
	@Transactional
	private HospitalProfile addInternalHospital(HospitalProfile hospital) {
		User user = new User();
		user.setRole(Constant.User.ROLE_HOSPITALORDEPT);
		user.setAccountType(Constant.User.ACCOUNTTYPE_TEMPORARY);
		user.setUserName(hospital.getHospitalName());
		user.setTrueName(hospital.getHospitalName());
		user.setInfoState(1);
		user.setState(1);
		user.setPoints(1);
		user.setSyncFlag(0);
		user.setSourceFlag(0);
		user.setCreateTime(new Date());
		user.setCryptPasswd(Codec.hexMD5(GeneralUtil.getCaptchaNum()));
		user.setUserPictureUrl(hospital.getPictureUrl());
		
		userDao.insert(user);
		hospital.setUserId(user.getUserId());
		this.dao.addHospital(hospital);
		if(hospital.getSpecialtyList()!=null){
			this.dao.insertHospitalSpecialty(hospital.getHospitalId(),hospital.getSpecialtyList());
		}
		return hospital;
	}
	@Transactional
	private HospitalProfile addCustomHospital(HospitalProfile hospital) {
		this.dao.addHospital(hospital);
		return hospital;
	}
	
	/**
	 * 添加科室信息
	 */
	@Override
	public boolean addDepartment(DepartmentProfile department) {
		this.departmentDao.addDepartment(department);
		return true;
	}

	/**
	 * 添加子科室信息
	 */
	@Override
	public boolean addSubDepartment(SubDeptProfile department) {
		this.departmentDao.addSubDept(department);
		return true;
	}

	/**
	 * 修改科室信息
	 */
	@Override
	public boolean modifyDepartment(DepartmentProfile department) {
		this.departmentDao.updateDepartment(department);
		return true;
	}

	/**
	 * 修改子科室信息
	 */
	@Override
	public boolean modifySubDepartment(SubDeptProfile department) {
		this.departmentDao.updateSubDept(department);
		return true;
	}

	@Override
	public List<THospitalSimpleInfo> getHospitalsOfPatientList(Long patientId,Integer productType) {
		// TODO Auto-generated method stub
		return dao.getHospitalsOfPatientList(patientId,productType,serverWXServiceUrlRoot+defaultHospitalPictureUrl);
	}

	/**
	 * 查询开通院级服务的医院列表信息
	 * by Da loong
	 * 2016/5/28
	 */
	@Override
	public List<HospitalProfile> queryHospitalHavingService() {
		// TODO Auto-generated method stub
		return dao.queryHospitalHavingService();
	}
	
	/**
	 * 医院Profile信息获取。包含医院开通的服务列表.
	 * by Da Loong
	 * 2016/5/28
	 */

	@Override
	public HospitalProfile getHospitalProfile(Integer hospitalId, Integer patientId) {
		// TODO Auto-generated method stub
		//1. 如果传入了医院Id，则直接返回此医院的Profile
		if(hospitalId!=null && hospitalId>0){
			return dao.findHospitalProfileById(hospitalId,serverWXServiceUrlRoot+defaultHospitalPictureUrl);
		}
		
		if(patientId!=null && patientId>0){
			//2. 否则，查找最近正在服务的医院
			Integer hospitalId2 = hospitalPatientDao.findHospitalInServiceOfPatient(patientId);
			if(hospitalId2!=null && hospitalId2>0){
				return dao.findHospitalProfileById(hospitalId2,serverWXServiceUrlRoot+defaultHospitalPictureUrl);
			}
			else{
				//3. 否则，找到此患者关注的医院
				Integer hospitalId3 = hospitalPatientDao.findHospitalOfPatient(patientId);
				if(hospitalId3!=null && hospitalId3>0){
					return dao.findHospitalProfileById(hospitalId3,serverWXServiceUrlRoot+defaultHospitalPictureUrl);
				}
		
			}
		}
	
		
		return null;
	}

	/**
	 * 获取认证的医院列表
	 * By Da Loong 
	 * 2016/6/1
	 */
	@Override
	public List<THospitalSimpleInfo> getHospitalsCertificatedOfPatientList(HospitalsCertificatedOfPatientListReq req) {
		// TODO Auto-generated method stub
		//默认已通过
		if(req.getCertificatedFlag()==null)
			req.setCertificatedFlag(1);
		if(req.getCertificatedFlag()!=1)
			return dao.findHospitalsCertificatedOfPatientExam(req);
		else
			return dao.findHospitalsCertificatedOfPatient(req);
	}

	/**
	 * 获取独立公众号医院名称
	 * By Da Loong
	 * 2016/6/1
	 */
	@Override
	public List<THospitalSimpleInfo> queryHospitalNameByProductId(Integer wxProductId) {
		// TODO Auto-generated method stub
		return dao.getHospitalNameByProductId(wxProductId);
	}

	/**
	 * 通过微信Id反查公众号对应的productId
	 * By Da Loong
	 * 2016/6/1
	 */

	@Override
	public TWeixinProductIdInfo queryWxProductId(String weixinId) {
		// TODO Auto-generated method stub
		return dao.getWxProductIdInfo(weixinId);
	}


	@Override
	public List<THospitalSpecialtyInfo> getMetaInfoHospitalSpecialtyList() {
		// TODO Auto-generated method stub
		return metaHospitalSpecialtyDao.queryHospitalSpecialty(null);
	}


	@Override
	public List<HospitalProfile> getSignHospitals() {
		return this.dao.querySignHospitals();
	}


	@Override
	public List<THospitalGuideInfo> searchHospitalGuideList(HospitalGuideReq req) {
		// TODO Auto-generated method stub
		if(req==null)
			throw new EmptyParamExcption(" request error params is null");
		if(req.getHospitalId()==null)
			throw new EmptyParamExcption(" request error hospitalId is null");
		return hospitalGuideDao.queryHospitalGuideList(req);
	}


	@Override
	public THospitalGuideInfo getHospitalGuideInfo(HospitalGuideReq req) {
		// TODO Auto-generated method stub
		if(req==null)
			throw new EmptyParamExcption(" request error params is null");
		if(req.getGuideId()==null)
			throw new EmptyParamExcption(" request error guideId is null");
		return hospitalGuideDao.queryHospitalGuideInfo(req);
	}


	@Override
	public HospitalProfile getHospitalDetail(Integer hospitalId) {
		// TODO Auto-generated method stub
		return getHospitalDetail(hospitalId,null);
	}


	@Override
	public List<DepartmentProfile> queryDepartment(DepartmentQueryReq req) {
		// TODO Auto-generated method stub
		if(req.getHospitalId()==null)
			throw new EmptyParamExcption(" hospitalId is null");
		if(StringUtils.isEmpty(req.getDeptName()))
			req.setDeptName(null);
		return departmentDao.queryDepartment(req);
	}


	@Override
	public List<DepartmentProfile> queryDepartmentMetaInfo(DepartmentQueryReq req) {
		// TODO Auto-generated method stub
		if(req.getHospitalId()==null)
			throw new EmptyParamExcption(" hospitalId is null");
		if(StringUtils.isEmpty(req.getDeptName()))
			req.setDeptName(null);
		Map<String,Object> param = BeanUtils.toMap(req);
		return departmentDao.queryDepartmentMateInfo(param);
	}


	@Override
	public void saveDepartmentOfpatient(DeptOfpatientReq req) {
		// TODO Auto-generated method stub
		if(req.getDeptId()==null)
			throw new EmptyParamExcption("param error deptId is null ");
		if(req.getHospitalId()==null)
			throw new EmptyParamExcption("param error hospital is null ");
		Map<String,Object> param = BeanUtils.toMap(req);
		if(departmentDao.queryDepartmentMateInfo(param)==null)
			throw new EmptyObjectExcption(" query error param is "+JsonUtil.toJson(param));
		//清楚子科室信息
		departmentDao.clearDeptSubDept(param);
		//添加子科室
		if(req.getSubDeptList()!=null&&req.getSubDeptList().size()>0)
			departmentDao.saveParentDept(param);
		//修改科室信息
		DepartmentProfile department = new DepartmentProfile();
		department.setDeptId(req.getDeptId());
		department.setCreator(req.getCreator());
		departmentDao.updateDepartment(department);
	}


	@Override
	public List<HospitalProfile> getHospitalListInfo(HospitalSearchReq hospitalSearchReq) {
		return this.dao.findHospitalListInfo(hospitalSearchReq);
	}
	
}
