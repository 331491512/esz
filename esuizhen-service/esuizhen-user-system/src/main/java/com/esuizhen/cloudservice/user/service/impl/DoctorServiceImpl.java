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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.base.service.organization.OrganizationDoctorService;
import com.esuizhen.cloudservice.user.bean.DoctorHospitalSearchByKeywordReq;
import com.esuizhen.cloudservice.user.bean.DoctorHospitalSimpleInfo;
import com.esuizhen.cloudservice.user.bean.DoctorListReq;
import com.esuizhen.cloudservice.user.bean.DoctorSearchByCombinedConditionReq;
import com.esuizhen.cloudservice.user.bean.TDiseaseInfo;
import com.esuizhen.cloudservice.user.bean.TDoctorGroupStatisInfo;
import com.esuizhen.cloudservice.user.bean.TDoctorMinInfo;
import com.esuizhen.cloudservice.user.bean.TDoctorStatisProfile;
import com.esuizhen.cloudservice.user.dao.DoctorDao;
import com.esuizhen.cloudservice.user.dao.HospitalDao;
import com.esuizhen.cloudservice.user.dao.HospitalDoctorDao;
import com.esuizhen.cloudservice.user.dao.MetaCDiseaseTypeDao;
import com.esuizhen.cloudservice.user.dao.PatientDao;
import com.esuizhen.cloudservice.user.dao.PatientGroupDao;
import com.esuizhen.cloudservice.user.dao.TRDoctorDao;
import com.esuizhen.cloudservice.user.service.DoctorService;
import com.esuizhen.cloudservice.user.service.UserRoleService;
import com.esuizhen.cloudservice.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.DoctorProfile;
import com.westangel.common.bean.DoctorSimpleInfo;
import com.westangel.common.bean.DoctorTag;
import com.westangel.common.bean.HospitalDoctor;
import com.westangel.common.bean.LoginByThirdPartyResp;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.PatientGroup;
import com.westangel.common.bean.User;
import com.westangel.common.bean.UserProfile;
import com.westangel.common.bean.UserProfileModifyReq;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.common.bean.sys.TagInfo;
import com.westangel.common.bean.user.TRDoctor;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.ParamMismatchExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.excption.RemoteCallExcption;
import com.westangel.common.service.MessageInnerService;
import com.westangel.common.util.ImMessageUtil;
import com.westangel.common.util.PageUtil;

/** 
* @ClassName: DoctorServiceImpl 
* @Description: TODO
* @author YYCHEN
* @date 2015年12月9日 下午5:54:20  
*/
@Service(value="doctorService")
public class DoctorServiceImpl implements DoctorService{
	private Locale locale = Locale.getDefault();
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private MetaCDiseaseTypeDao diseaseDao;
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private HospitalDoctorDao hospitalDoctorDao;
	@Autowired
	private PatientGroupDao patientGroupDao;
	@Autowired
	public TRDoctorDao rdoctorDao;
	
	@Autowired
	private MessageInnerService messageInnerService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private OrganizationDoctorService organizationDoctorService;

	@Value("${server.wx.service.url.root}")
	private String serverWXServiceUrlRoot;
	@Value("${default.doctor.man.userPictureUrl}")
	private String defaultDoctorManUserPictureUrl;
	@Value("${default.doctor.wonman.userPictureUrl}")
	private String defaultDoctorWonmanUserPictureUrl;

	/**(非 Javadoc) 
	* <p>Title: searchDoctor</p> 
	* <p>Description: 根据医生编号查询医生详细信息</p> 
	* @param id
	* @return 
	 * @throws EmptyParamExcption 
	* @see com.esuizhen.cloudservice.user.service.DoctorService#searchDoctor(java.lang.Long) 
	*/
	@Override
	public Doctor searchDoctor(Long doctorId) throws EmptyParamExcption {
		if (doctorId == null) {
			throw new EmptyParamExcption("\"doctorId\" cannot be empty!");
		}
		return doctorDao.selectByPrimaryKey(doctorId);
	}

	/**(非 Javadoc) 
	* <p>Title: searchDoctorByUserId</p> 
	* <p>Description: 根据用户编号查询医生详细信息</p> 
	* @param userId
	* @return 
	 * @throws EmptyParamExcption 
	* @see com.esuizhen.cloudservice.user.service.DoctorService#searchDoctorByUserId(java.lang.Long) 
	*/
	@Override
	public Doctor searchDoctorByUserId(Long userId) throws EmptyParamExcption {
		if (userId == null) {
			throw new EmptyParamExcption("\"doctorId\" cannot be empty!");
		}
		Doctor doctor = doctorDao.findByUserId(userId);
		String tagIds = doctor.getTagIds();
		String tagNames = doctor.getTags();
		if (tagIds != null && tagNames != null) {
			List<DoctorTag> doctorTagList = new ArrayList<DoctorTag>();
			DoctorTag doctorTag = null;
			String[] tagIdArray = tagIds.split(",");
			String[] tagNameArray = tagNames.split(",");
			for (int i = 0; i < tagIdArray.length; i++) {
				doctorTag = new DoctorTag();
				doctorTag.setTagId(Long.valueOf(tagIdArray[i]));
				doctorTag.setTagName(tagNameArray[i]);
				doctorTagList.add(doctorTag);
			}
			doctor.setTagList(doctorTagList);
		}
		return doctor;
	}

	/**(非 Javadoc) 
	* <p>Title: searchDoctorBYMobile</p> 
	* <p>Description: 根据医生电话号查询医生详细信息</p> 
	* @param mobile
	* @return 
	 * @throws EmptyParamExcption 
	* @see com.esuizhen.cloudservice.user.service.DoctorService#searchDoctorBYMobile(java.lang.String) 
	*/
	@Override
	public Doctor searchDoctorBYMobile(String mobile) throws EmptyParamExcption {
		if (StringUtils.isBlank(mobile)) {
			throw new EmptyParamExcption("\"mobile\" cannot be empty!");
		}
		return doctorDao.searchDoctor(mobile);
	}

	/**(非 Javadoc) 
	* <p>Title: searchDoctorTagList</p> 
	* <p>Description: </p> 
	* @return 
	* @see com.esuizhen.cloudservice.user.service.DoctorService#searchDoctorTagList() 
	*/
	@Override
	public List<DoctorTag> searchDoctorTagList() {
		return doctorDao.searchDoctorTagList();
	}

	/**(非 Javadoc) 
	 * <p>Title: searchDoctorTagList</p> 
	*  <p>Description: </p>
	* @param param 传入的参数
	* @return List<DoctorScreenResp> -> 医生信息列表
	* @see com.esuizhen.cloudservice.user.service.DoctorService#searchDoctor(Long hospitalId, Long deptId, String doctorName) 
	 */
	@Override
	public List<Map<String, Object>> searchDoctor(Map<String, Object> param) {
		param.put("defaultManPicUrl", serverWXServiceUrlRoot + defaultDoctorManUserPictureUrl);
		param.put("defaultWomanPicUrl", serverWXServiceUrlRoot + defaultDoctorWonmanUserPictureUrl);
		return this.doctorDao.screenDoctor(param);
	}

	/**(非 Javadoc) 
	* <p>Title: selectDoctorProfileByDoctorId</p> 
	* <p>Description: 根据医生编号查询医生基本信息</p> 
	* @param doctorId
	* @return 
	 * @throws EmptyParamExcption 
	* @see com.esuizhen.cloudservice.user.service.DoctorService#selectDoctorProfileByDoctorId(java.lang.Long) 
	*/
	@Override
	public DoctorProfile selectDoctorProfileByDoctorId(Long doctorId, Long patientId) throws EmptyParamExcption {
		if (doctorId == null) {
			throw new EmptyParamExcption("\"doctorId\" cannot be empty!");
		}
		return doctorDao.selectDoctorProfileByDoctorId(doctorId, patientId, 
				serverWXServiceUrlRoot + defaultDoctorManUserPictureUrl, serverWXServiceUrlRoot + defaultDoctorWonmanUserPictureUrl);
	}

	/**(非 Javadoc) 
	* <p>Title: selectDoctorProfileByUserId</p> 
	* <p>Description: 根据用户编号查询用户基本信息</p> 
	* @param userId
	* @return 
	 * @throws EmptyParamExcption 
	* @see com.esuizhen.cloudservice.user.service.DoctorService#selectDoctorProfileByUserId(java.lang.Long) 
	*/
	@Override
	public DoctorProfile selectDoctorProfileByUserId(Long userId) throws EmptyParamExcption {
		if (userId == null) {
			throw new EmptyParamExcption("\"userId\" cannot be empty!");
		}
		return doctorDao.selectDoctorProfileByUserId(userId, null, 
				serverWXServiceUrlRoot + defaultDoctorManUserPictureUrl, serverWXServiceUrlRoot + defaultDoctorWonmanUserPictureUrl);
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
			}else if(StringUtils.endsWith(cityCode, "0000")){
				prefixLength = 3;
			} else {
				prefixLength = 4; 
			}
			cityCode = StringUtils.substring(cityCode,0, prefixLength);
			map.put("cityCode", cityCode);
			map.put("prefixLen",prefixLength);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Page<DoctorHospitalSimpleInfo> searchDoctorHospitalByKeyword(DoctorHospitalSearchByKeywordReq doctorHospitalSearchByKeywordReq) {
		String cityCode = doctorHospitalSearchByKeywordReq.getCityCode();
		String keyword = doctorHospitalSearchByKeywordReq.getKeyword();
		Integer prefixLength = 0;
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("cityCode", cityCode);
		param.put("prefixLen", prefixLength);
		param.put("keyword", keyword);
		if(doctorHospitalSearchByKeywordReq.getUserId()!=null)
			param.put("userId", doctorHospitalSearchByKeywordReq.getUserId());
		param.put("defaultManPicUrl", serverWXServiceUrlRoot + defaultDoctorManUserPictureUrl);
		param.put("defaultWomanPicUrl", serverWXServiceUrlRoot + defaultDoctorWonmanUserPictureUrl);
		searchCityCodeTrans(param);
		//获取医生符合条件的总数
		Integer doctorCount = this.doctorDao.findDoctorHospitalSimpleInfoesCount(param);
		//医生数据总页数
		Integer doctorPages = doctorCount / doctorHospitalSearchByKeywordReq.getNum();
		doctorPages = doctorCount % doctorHospitalSearchByKeywordReq.getNum() == 0 ? doctorPages : doctorPages + 1;
		
		//获取医院符合条件的总数
		Integer hospitalCount = this.hospitalDao.findDoctorHospitalSimpleInfoesCount(param);
		//如果医生数据能够返回，则先返回医生的数据
		Integer hospitalPages = hospitalCount / doctorHospitalSearchByKeywordReq.getNum();
		hospitalPages = hospitalCount % doctorHospitalSearchByKeywordReq.getNum() == 0 ? hospitalPages : hospitalPages + 1;
		Page<DoctorHospitalSimpleInfo> page = null;
		com.github.pagehelper.Page<DoctorHospitalSimpleInfo> pageData = new com.github.pagehelper.Page<DoctorHospitalSimpleInfo>();
		if (doctorPages > doctorHospitalSearchByKeywordReq.getPage()) {
			PageHelper.startPage(doctorHospitalSearchByKeywordReq.getPage() + 1, doctorHospitalSearchByKeywordReq.getNum());
			List<DoctorHospitalSimpleInfo> doctorList = doctorDao.findDoctorHospitalSimpleInfoes(param);
			pageData.addAll(doctorList);
			page = PageUtil.returnPage(pageData);
		}else{
			//返回医院信息数据
			PageHelper.startPage(doctorHospitalSearchByKeywordReq.getPage() + 1 - doctorPages, doctorHospitalSearchByKeywordReq.getNum());
			List<DoctorHospitalSimpleInfo> hospitalList = hospitalDao.findDoctorHospitalSimpleInfoes(param);
			pageData.addAll(hospitalList);
			page = PageUtil.returnPage(pageData);
		}
		page.setTotalNum(doctorCount + hospitalCount);
		page.setCurrPage(doctorHospitalSearchByKeywordReq.getPage());
		page.setTotalPage(doctorPages + hospitalPages - 1);
		return page;
	}
	
	@Override
	public Page<DoctorSimpleInfo> searchDoctorByCombinedCondition(DoctorSearchByCombinedConditionReq req){
		String cityCode = req.getCityCode();
		String keyword = req.getKeyword();
		Integer hospitalId = req.getHospitalId();
		String tag = req.getTag();
		Integer prefixLength = 0;
		Map<String,Object> param = new HashMap<String, Object>();
		if(StringUtils.isNotEmpty(keyword))
			param.put("keyword", keyword);
		if(StringUtils.isNotEmpty(cityCode)&&req.getHospitalId()==null){
			param.put("cityCode", cityCode);
			param.put("prefixLen", prefixLength);
			searchCityCodeTrans(param);
		}
		param.put("hospitalId", hospitalId);
		param.put("tag", tag);
		if(req.getUserId()!=null)
			param.put("userId", req.getUserId());
		param.put("defaultManPicUrl", serverWXServiceUrlRoot + defaultDoctorManUserPictureUrl);
		param.put("defaultWomanPicUrl", serverWXServiceUrlRoot + defaultDoctorWonmanUserPictureUrl);
		param.put("deptId", req.getDeptId());
		
		PageHelper.startPage(req.getPage()+1,req.getNum());
		List<DoctorSimpleInfo> doctorList = doctorDao.findDoctorSimpleInfoes(param);
		return PageUtil.returnPage((com.github.pagehelper.Page<DoctorSimpleInfo>)doctorList);
		
		/*
		//获取医生符合条件的总数
		Integer doctorCount = this.doctorDao.findDoctorSimpleInfoesCount(param);
		//医生数据总页数
		Integer doctorPages = doctorCount / req.getNum();
		doctorPages = doctorCount % req.getNum() == 0 ? doctorPages : doctorPages + 1;
		
		//获取医院符合条件的总数
		Integer hospitalCount = 0;
		if(hospitalId==null)
			hospitalCount = this.doctorDao.findDoctorSimpleInfoesByHospitalTrueNameCount(param);
		//如果医生数据能够返回，则先返回医生的数据
		Integer hospitalPages = hospitalCount / req.getNum();
		hospitalPages = hospitalCount % req.getNum() == 0 ? hospitalPages : hospitalPages + 1;
		Page<DoctorSimpleInfo> page = null;
		com.github.pagehelper.Page<DoctorSimpleInfo> pageData = new com.github.pagehelper.Page<DoctorSimpleInfo>();
		if (doctorPages > req.getPage()) {
			PageHelper.startPage(req.getPage() + 1, req.getNum());
			List<DoctorSimpleInfo> doctorList = doctorDao.findDoctorSimpleInfoes(param);
			pageData.addAll(doctorList);
			page = PageUtil.returnPage(pageData);
		}else{
			//返回医院信息数据
			PageHelper.startPage(req.getPage() + 1 - doctorPages, req.getNum());
			List<DoctorSimpleInfo> hospitalList = doctorDao.findDoctorSimpleInfoesByHospitalTrueName(param);
			pageData.addAll(hospitalList);
			page = PageUtil.returnPage(pageData);
		}
		page.setTotalNum(doctorCount + hospitalCount);
		page.setCurrPage(req.getPage());
		page.setTotalPage(doctorPages + hospitalPages - 1);
		return page;
		*/
	}
	
	@Override
	public List<DoctorSimpleInfo> listDoctorsOfPatient(Long patientId, Long productType) throws EmptyParamExcption {
		if (patientId == null) {
			throw new EmptyParamExcption("\"patientId\" cannot be empty!");
		}
		if (productType == null || productType == 0) {
			productType = 0L;
			return this.doctorDao.findByPatientId(patientId, 
					serverWXServiceUrlRoot + defaultDoctorManUserPictureUrl, serverWXServiceUrlRoot + defaultDoctorWonmanUserPictureUrl);
		}
		return this.doctorDao.findByPatientIdAndProductType(patientId, productType, 
				serverWXServiceUrlRoot + defaultDoctorManUserPictureUrl, serverWXServiceUrlRoot + defaultDoctorWonmanUserPictureUrl);
	}
	
	@Override
	public List<DoctorSimpleInfo> listDoctorsOfBuyer(Long buyer, Long productType) throws EmptyParamExcption {
		if (buyer == null) {
			throw new EmptyParamExcption("\"buyer\" cannot be empty!");
		}
		return this.doctorDao.findByBuyerAndProductType(buyer, productType, 
				serverWXServiceUrlRoot + defaultDoctorManUserPictureUrl, serverWXServiceUrlRoot + defaultDoctorWonmanUserPictureUrl);
	}
	
	@Override
	public List<DoctorSimpleInfo> recommendDoctor(Long patientId, Long hospitalId) throws EmptyParamExcption {
		if (patientId == null) {
			throw new EmptyParamExcption("\"patientId\" cannot be empty!");
		}
		List<DoctorSimpleInfo> list=null;
		if(hospitalId==null){
			List<TagInfo> tagInfos=patientDao.getPatientTags(patientId);
			if(tagInfos==null||tagInfos.size()<1){
				tagInfos=new ArrayList<TagInfo>();
				TagInfo tagInfo=new TagInfo();
				tagInfo.setTagId(Constant.TAGID);
				tagInfos.add(tagInfo);
			}
			list=this.doctorDao.recommendDoctorByTag(tagInfos,serverWXServiceUrlRoot + defaultDoctorManUserPictureUrl, serverWXServiceUrlRoot + defaultDoctorWonmanUserPictureUrl);

			List<DoctorSimpleInfo> list1=this.doctorDao.recommendDoctorByHospital(patientId,serverWXServiceUrlRoot + defaultDoctorManUserPictureUrl, serverWXServiceUrlRoot + defaultDoctorWonmanUserPictureUrl);

			if(list1!=null&&list1.size()>0){
				if(list!=null&&list.size()>0){
					list.addAll(list1);
				}else{
					list=list1;
				}
			}
		}else{
			list=this.doctorDao.recommendDoctor(patientId, hospitalId,
					serverWXServiceUrlRoot + defaultDoctorManUserPictureUrl, serverWXServiceUrlRoot + defaultDoctorWonmanUserPictureUrl);
		}
		return list;
	}

	@Override
	public boolean doctorHospitalRelation(HospitalDoctor hospitalDoctor) {
		hospitalDoctorDao.updateHospitalDoctor(hospitalDoctor);
		return false;
	}
	
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
	@Transactional
	public LoginByThirdPartyResp modifyDoctorProfile(UserProfileModifyReq userProfileModifyReq, User user, Doctor doctor) throws EmptyParamExcption, EmptyObjectExcption, ParamMismatchExcption, RemoteCallExcption, RejectRequestExcption {
		UserProfile userProfile = userProfileModifyReq.getUserProfile();
		//修改用户信息
		if (userProfile.getRole() == Constant.User.ROLE_DOCTOR &&
				StringUtils.isNotEmpty(userProfile.getIdentification())) {
			if (userProfile.getIdType() == null) {
				userProfile.setIdType(Constant.User.IDTYPE_ID);
			}
			if(!this.userService.verificationIdentification(userProfile)){
				throw new RejectRequestExcption("User id " + userProfile.getUserId() + " use Certificate type " + userProfile.getIdType() + ", Identification " + userProfile.getIdentification() + " has been registered");
			}
			user.setIdType(userProfile.getIdType());
			user.setIdentification(userProfile.getIdentification());
		}
		this.userService.modifyUserProfile(userProfile, user);
		Date nowTime = new Date();
		//修改医生信息
		doctor.setTrueName(user.getTrueName());
		doctor.setNickName(user.getNickName());
		doctor.setMobile(user.getMobile());
		doctor.setSex(user.getSex());
		doctor.setBirthDate(user.getBirthDate());
		doctor.setUserPictureUrl(user.getUserPictureUrl());
		
		DoctorProfile doctorProfile = userProfileModifyReq.getDoctorProfile();
		if (doctorProfile != null) {
			doctor.setSkills(doctorProfile.getSkills());
			doctor.setPositionTitle(doctorProfile.getPositionTitleId());
			doctor.setProfessionalRank(doctorProfile.getProfessionalRankId());
			doctor.setIsExpert(doctorProfile.getIsExpert());
			doctor.setProfessionCredence(doctorProfile.getProfessionCredence());
			doctor.setRegisterCredence(doctorProfile.getRegisterCredence());
			doctor.setWorkCredence(doctorProfile.getWorkCredence());
			doctor.setProfessionCredencePicUrl(doctorProfile.getProfessionCredencePicUrl());
			doctor.setRegisterCredencePicUrl(doctorProfile.getRegisterCredencePicUrl());
			doctor.setWorkCredencePicUrl(doctorProfile.getWorkCredencePicUrl());
			doctor.setIntroduction(doctorProfile.getIntroduction());
			doctor.setTel(doctorProfile.getTel());
			doctor.setUpdateTime(nowTime);
			
			//医生标签
			List<DoctorTag> doctorTags = doctorProfile.getTagList();
			if (doctorTags != null) {
				String tagIdNums = null, tagContents = null;
				if (!doctorTags.isEmpty()) {
					StringBuilder tagIds = new StringBuilder();
					StringBuilder tags = new StringBuilder();
					for (DoctorTag doctorTag : doctorTags) {
						tagIds.append(doctorTag.getTagId());
						tagIds.append(",");
						
						tags.append(doctorTag.getTagName());
						tags.append(",");
					}
					tagIdNums = tagIds.substring(0, tagIds.length() - 1);
					tagContents = tags.substring(0, tags.length() - 1);
				}
				doctor.setTagIds(tagIdNums);
				doctor.setTags(tagContents);
			}
			//如果传入的hospitalId为空，则不修改医生、医院关系
			if (doctorProfile.getHospitalId() != null) {
				//医院、医生、科室关系
				HospitalDoctor hospitalDoctor = hospitalDoctorDao.selectHospitalDoctor(doctor.getDoctorId());
				//医生关系
				//SubdeptDoctor subdeptDoctor = subdeptDoctorDao.selectSubDeptDoctor(doctor.getDoctorId());
				if (doctorProfile.getHospitalId() == null ||
						doctorProfile.getDeptId() == null) {
					//如果医院ID或科室ID为空，则删除医生与医院、科室的关系，并删除医生与子科室的关系
					if (hospitalDoctor != null) {
						this.hospitalDoctorDao.deleteById(hospitalDoctor.getId());
						hospitalDoctor = null;
					}
				} else {
					if (hospitalDoctor == null) {
						hospitalDoctor = new HospitalDoctor();
						hospitalDoctor.setHospitalId(doctorProfile.getHospitalId());
						hospitalDoctor.setHospitalName(doctorProfile.getHospitalName());
						if(doctorProfile.getChildDeptId()==null||doctorProfile.getChildDeptId()==0)
							hospitalDoctor.setDeptId(doctorProfile.getDeptId());
						else{
							hospitalDoctor.setDeptId(doctorProfile.getChildDeptId());
						}
						hospitalDoctor.setPositionTitle(doctor.getPositionTitle());
						hospitalDoctor.setDoctorId(doctor.getDoctorId());
						hospitalDoctor.setCreateTime(nowTime);
						
						this.hospitalDoctorDao.insert(hospitalDoctor);
						//医生审核，初级待审核
						if (doctor.getAuditState() <= Constant.User.AUDITSTATE_PRIMARYPENDING) {
							doctor.setAuditState(Constant.User.AUDITSTATE_PRIMARYPENDING);
						}
					} else if (hospitalDoctor.getHospitalId() != doctorProfile.getHospitalId()
							|| hospitalDoctor.getDeptId() != doctorProfile.getDeptId()) {
						hospitalDoctor.setHospitalId(doctorProfile.getHospitalId());
						hospitalDoctor.setHospitalName(doctorProfile.getHospitalName());
						if(doctorProfile.getChildDeptId()==null||doctorProfile.getChildDeptId()==0)
							hospitalDoctor.setDeptId(doctorProfile.getDeptId());
						else
							hospitalDoctor.setDeptId(doctorProfile.getChildDeptId());
						hospitalDoctor.setPositionTitle(doctor.getPositionTitle());
						this.hospitalDoctorDao.updateHospitalDoctor(hospitalDoctor);
					}
				} 
			}
		}
		//给医生分配默认角色
		this.userRoleService.addDefaultUserRole(doctor.getUserId());
		this.doctorDao.updateDoctor(doctor);
		
		LoginByThirdPartyResp loginByThirdPartyResp = new LoginByThirdPartyResp();
		loginByThirdPartyResp.setUserId(user.getUserId());
		loginByThirdPartyResp.setAccountType(user.getAccountType());
		loginByThirdPartyResp.setInfoState(user.getInfoState());
		return loginByThirdPartyResp;
	}
	
	/**
	 * 获取医生所有病种
	 */
	@Override
	public List<TDiseaseInfo> getDoctorPatientDiseaseList(Long doctorId){
		// TODO Auto-generated method stub
		if(doctorId==null)
			throw new EmptyObjectExcption("doctorId is null");
		return diseaseDao.queryPatientDiseaseByDoctorId(doctorId);
	}
	
	/**
	 * 医生信息统计
	 */
	@Override
	public TDoctorStatisProfile getDoctorStaticsInfo(Long doctorId, String staticType) {
		// TODO Auto-generated method stub
		if(doctorId==null)
			throw new EmptyParamExcption(" doctorId is null");
		TDoctorStatisProfile profile = new TDoctorStatisProfile();
		String sql = organizationDoctorService.getPatientSql(doctorId, null);
		if(sql==null)
			throw new EmptyObjectExcption(" doctorId is null,doctorId="+doctorId);
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("sql", sql);
		if(StringUtils.isEmpty(staticType)||"PATIENT".equals(staticType)){
			profile = doctorDao.queryDoctorPatientNum(param);
		}
		if(StringUtils.isEmpty(staticType)||"GROUP".equals(staticType)){
			TDoctorGroupStatisInfo groupInfo = new TDoctorGroupStatisInfo();
			profile.setGroupStaticInfo(groupInfo);
			param.put("groupWay", 1);
			List list = patientGroupDao.selectPatientAutoGroup(param);
			//病种
			if(list!=null)
				groupInfo.setDisease(list.size());
			else
				groupInfo.setDisease(0);
			//患者状态分组
			Map inhospitalMap = patientGroupDao.countInhospitalGroup(param);
			int inhospitalSize=0;
			if(inhospitalMap!=null){
				if((Long)inhospitalMap.get("outPatientCount")>0)
					inhospitalSize++;
				if((Long)inhospitalMap.get("inhospitalCount")>0)
					inhospitalSize++;
			}
			groupInfo.setInhospital(inhospitalSize);
			//自定义
			list = patientGroupDao.selectPatientCustom(doctorId, 10,null);
			if(list!=null)
				groupInfo.setCustom(list.size());
			else
				groupInfo.setCustom(0);
			//MDT
			PatientGroup mdtGroup = patientGroupDao.selectPatientMdtGroup(doctorId, null);
			if(mdtGroup!=null){
				groupInfo.setMdt(mdtGroup.getGroupMembersNum());
			}else{
				groupInfo.setMdt(0);
			}
			//doctorFocus
			param.clear();
			param.put("doctorId", doctorId);
			param.put("groupWay", 8);
			groupInfo.setDoctorFocus(patientGroupDao.countGroupPatientTotalNum(param));
		}
		return profile;
	}
	/**
	 * 
	* @Title: matchDoctor 
	* @Description: 注册医生
	* @param 
	* @return TMsgResponse<UserRegisterResp>
	* @throws
	 */
	public Doctor registerDoctor(User user) {
		Doctor doctor = new Doctor();
		
		doctor.setUserId(user.getUserId());
		doctor.setMobile(user.getUserName());
		doctor.setIsExpert(Constant.User.ISEXPERT_NO);
		doctor.setSex(Constant.SEX_UNKNOWN);
		doctor.setAuditState(Constant.User.AUDITSTATE_NOT);
		doctor.setSyncFlag(Constant.User.SYNCFLAG_NO);
		
		this.doctorDao.insert(doctor);
		
		// TODO 此处需要调用邀请码信息保存的接口
		// 查询出注册账号的编号
		
		// 随诊助手推送消息
		this.sendNotifyToDoctorForRegister(doctor.getUserId());
		// TODO 调用发送短信的公共接口服务
		return doctor;
	}
	
	/**
	 * 
	 * @param doctorUserId
	 * @return
	 */
	private boolean sendNotifyToDoctorForRegister(Long doctorUserId) {
		String tipContent = messageSource.getMessage("tips.doctor.user.registered.account.success", null, locale);
		String description = messageSource.getMessage("tips.doctor.user.registered.account.success.description", null, locale);
		String content = ImMessageUtil.getPicTextMessage(description, null);
		ImMessageInfo message = ImMessageUtil.getEDoctorAssistCustomMessage(doctorUserId, content, tipContent);
		//message.setServiceId(1);
		return messageInnerService.sendInnerMessage(message);
	}

	@Override
	public TRDoctor getTRDoctorByDoctorId(Long doctorId) {
		// TODO Auto-generated method stub
		TRDoctor rDoctor = rdoctorDao.queryRDoctorByDoctorId(doctorId);
		if(rDoctor!=null){
			if(5==rDoctor.getDoctorLevel())
			{
				doctorId=rDoctor.getInchargeDoctorId();
				rDoctor.setDoctorLevel(4);
			}
			rDoctor.setDoctorId(doctorId);
		}else{
			rDoctor = new TRDoctor();
			rDoctor.setDoctorId(doctorId);
		}
		return rDoctor;
	}

	@Override
	public List<TDoctorMinInfo> getDoctorList(DoctorListReq req) {
		return this.doctorDao.getDoctorList(req);
	}

	@Override
	public Integer judgeActivateRight(Long doctorId) {
		// TODO Auto-generated method stub
		return this.doctorDao.getActivateRight(doctorId);
	}
	@Override
	public List<Integer> getInvitePatientByMsg(Long doctorId) {
		// TODO Auto-generated method stub
		return this.patientDao.getInvitePatientByMsg(doctorId);
	}
	
	@Override
	public List<Integer> getInvitePatientByWechat(Long doctorId) {
		// TODO Auto-generated method stub
		return this.patientDao.getInvitePatientByWechat(doctorId);
	}
	
	@Override
	public void modifyActivateDate(Long doctorId){
		// TODO Auto-generated method stub
		this.doctorDao.modifyActivateDate(doctorId);
	}
}
