/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.service.impl;<br/>  
 * <b>文件名：</b>PatientGroupServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月23日上午10:46:06<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.base.service.organization.OrganizationDoctorService;
import com.esuizhen.cloudservice.user.bean.PatientGroupIdListReq;
import com.esuizhen.cloudservice.user.bean.PatientGroupMemberReq;
import com.esuizhen.cloudservice.user.common.PatientGroupConstant;
import com.esuizhen.cloudservice.user.dao.PatientGroupDao;
import com.esuizhen.cloudservice.user.dao.PatientGroupMembersDao;
import com.esuizhen.cloudservice.user.service.PatientGroupService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.PatientGroup;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.RemoteCallExcption;
import com.westangel.common.service.DoctorService;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;

/** 
* @ClassName: PatientGroupServiceImpl
* @Description: 
* @author lichenghao
* @date 2016年5月23日 上午10:46:06  
*/
@Service
public class PatientGroupServiceImpl implements PatientGroupService{
	@Autowired
	private PatientGroupDao patientGroupDao;
	@Autowired
	private PatientGroupMembersDao patientGroupMembersDao;
	@Autowired
	private OrganizationDoctorService organizationDoctorService;
	
	@Autowired
	private DoctorService doctorService;
	
	/**(非 Javadoc) 
	* <p>Title: getPatientGroupList</p> 
	* <p>Description: </p> 
	* @param doctorId
	* @return
	* @throws Exception 
	* @see com.esuizhen.cloudservice.user.service.PatientService#getPatientGroupList(java.lang.Long) 
	*/
	@Override
	public List<PatientGroup> getPatientGroupList(Long doctorId, Integer groupWay) throws Exception {
		return getPatientGroupList(doctorId,groupWay,null);
	}
	
	public List<PatientGroup> getPatientGroupList(Long doctorId, Integer groupWay,Long patientId) throws Exception{
		// TODO Auto-generated method stub
		// 默认为病种分组
		if (groupWay == null) {
			groupWay = 1;
		}
		
		Integer doctorLevel = null;
		String sql = organizationDoctorService.getPatientSql(doctorId, null);
		if(sql==null)
			throw new EmptyObjectExcption("doctor is null,doctorId="+doctorId);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("sql", sql);
		List<PatientGroup> list = new ArrayList<PatientGroup>();
		if (1 == groupWay) {// 1为自动分组
			param.put("groupWay", 1);
			param.put("patientId", patientId);
			list.addAll(patientGroupDao.selectPatientAutoGroup(param));
//			if (list != null && list.size() > 0) {
//				PatientGroup mdtGroup = patientGroupDao.selectPatientMdtGroup(doctorId,patientId);
//				if (mdtGroup.getGroupMembersNum() != null && mdtGroup.getGroupMembersNum() > 0)
//					list.add(0, mdtGroup);
//			}
		}
		// 患者状态分组
		if (PatientGroupConstant.GROUP_WAY_ZDY_INHOSPITAL_GROUP.equals(groupWay)
				|| PatientGroupConstant.GROUP_WAY_INHOSPITAL_GROUP.equals(groupWay)
				|| PatientGroupConstant.GROUP_WAY_DEFAULT_GROUP.equals(groupWay)) {
			list.addAll(0, this.countInhospitalGroup(doctorId));
		}
		//按病种分组
		if (2 == groupWay || PatientGroupConstant.GROUP_WAY_ALL_GROUP == groupWay ||PatientGroupConstant.GROUP_WAY_DEFAULT_GROUP.equals(groupWay)) {
			param.put("groupWay", PatientGroupConstant.GROUP_WAY_DISEASE_GROUP);
			param.put("patientId", patientId);
			list.addAll(patientGroupDao.selectPatientAutoGroup(param));
		}
		//Mdt 分组
		if (PatientGroupConstant.GROUP_WAY_MDT_GROUP == groupWay || PatientGroupConstant.GROUP_WAY_ALL_GROUP == groupWay) {
			PatientGroup mdtGroup = patientGroupDao.selectPatientMdtGroup(doctorId,patientId);
			if (mdtGroup.getGroupMembersNum() != null && mdtGroup.getGroupMembersNum() > 0){
				if(patientId!=null)
					mdtGroup = patientGroupDao.selectPatientMdtGroup(doctorId,null);
				list.add(0, mdtGroup);
			}
		}
		//自定义分组
		if (PatientGroupConstant.GROUP_WAY_ZDY_GROUP == groupWay || PatientGroupConstant.GROUP_WAY_ALL_GROUP == groupWay 
				|| PatientGroupConstant.GROUP_WAY_ZDY_INHOSPITAL_GROUP.equals(groupWay)) {
			list.addAll(patientGroupDao.selectPatientCustom(doctorId, PatientGroupConstant.GROUP_WAY_ZDY_GROUP,patientId));
		}
		//特殊关注分组
		if (PatientGroupConstant.GROUP_WAY_DOCTORFOCUS_GROUP == groupWay || PatientGroupConstant.GROUP_WAY_ALL_GROUP == groupWay) {
			list.addAll(patientGroupDao.selectPatientCustom(doctorId, PatientGroupConstant.GROUP_WAY_DOCTORFOCUS_GROUP,patientId));
		}
		return list;
	}
	
	private List<PatientGroup> countInhospitalGroup(Long doctorId){
		List<PatientGroup> list = new ArrayList<PatientGroup>();
		String sql = organizationDoctorService.getPatientSql(doctorId, null);
		if(sql==null){
			LogUtil.logError.error("doctor is null,doctorId:{}",doctorId);
			return list;
		}
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("sql", sql);
		Map map = patientGroupDao.countInhospitalGroup(params);
		if(map==null||((Long)map.get("outPatientCount")<1&&(Long)map.get("inhospitalCount")<0)){
			return list;
		}
		// 在院 20  门诊 1
		//住院组
		if((Long)map.get("inhospitalCount")>0){
			PatientGroup group = new PatientGroup();
			list.add(group);
			group.setGroupNo("20");
			group.setGroupWay(PatientGroupConstant.GROUP_WAY_INHOSPITAL_GROUP);
			group.setGroupMembersNum(Integer.parseInt(map.get("inhospitalCount")+""));
			group.setGroupName("在院患者");
			group.setNotOperat(1);
		}
		//门诊组
		if((Long)map.get("outPatientCount")>0){
			PatientGroup group = new PatientGroup();
			list.add(group);
			group.setGroupNo("1");
			group.setGroupWay(PatientGroupConstant.GROUP_WAY_INHOSPITAL_GROUP);
			group.setGroupMembersNum(Integer.parseInt(map.get("outPatientCount")+""));
			group.setGroupName("门诊患者");
			group.setNotOperat(1);
		}
		return list;
	}
	/**(非 Javadoc) 
	* <p>Title: getPatientGroupMembersList</p> 
	* <p>Description: </p> 
	* @param req
	* @return 
	*/
	@SuppressWarnings("unchecked")
	@Override
	public Page<PatientSimpleInfo> getPatientGroupMembersList(PatientGroupIdListReq req) {
		// TODO Auto-generated method stub
		if(req.getGroupWay()==null || req.getGroupWay()==0){
			req.setGroupWay(1);
		}
		if(req.getGroupId()==null && StringUtils.isEmpty(req.getGroupNo())&&req.getGroupWay()!=8){
			throw new EmptyParamExcption(" groupNo is null groupId="+req.getGroupId()+" groupNo="+req.getGroupNo());
		}
		if(req.getGroupId()!=null){
			req.setGroupNo(req.getGroupId()+"");
		}
		
		req.sql = organizationDoctorService.getPatientSql(req.getDoctorId(), null);
		if(req.sql==null)
			throw new EmptyObjectExcption("doctor is null,doctorId="+req.getDoctorId());
		PageHelper.startPage(req.getPage() + 1, req.getNum());
		com.github.pagehelper.Page<PatientSimpleInfo> pageData = new com.github.pagehelper.Page<PatientSimpleInfo>();
		List<PatientSimpleInfo> list = patientGroupMembersDao.searchSimplePatientInfoList(req);
		if(list!=null){
			pageData.addAll(list);
			return PageUtil.returnPage(pageData);
		}else{
			return null;
		}
	}
	
	@Override
	public String addPatientGroup(PatientGroup patientGroup) {
		if(patientGroup.getGroupWay()==null || patientGroup.getCreator()==null ||StringUtils.isEmpty(patientGroup.getGroupName())){
			throw new EmptyParamExcption("param error param is "+JsonUtil.toJson(patientGroup));
		}
		if(patientGroupDao.queryPatientGroupByParam(patientGroup)!=null){
			throw new RemoteCallExcption("groupName  already exist groupName="+patientGroup.getGroupName());
		}
		patientGroup.setGroupNo(GeneralUtil.generateUniqueID("GROUP"));
		patientGroupDao.addPatientGroup(patientGroup);
		return patientGroup.getGroupNo();
	}

	@Override
	public void updatePatientGroup(PatientGroup patientGroup){
		// TODO Auto-generated method stub
		if(patientGroup.getGroupWay()==null || StringUtils.isEmpty(patientGroup.getGroupNo()) ||StringUtils.isEmpty(patientGroup.getGroupName())){
			throw new EmptyParamExcption("param error param is "+JsonUtil.toJson(patientGroup));
		}
		String groupNo = patientGroupDao.queryPatientGroupByParam(patientGroup);
		if(patientGroup.getGroupNo()!=null&&patientGroup.getGroupNo().equalsIgnoreCase(groupNo))
			return;
		if(patientGroupDao.queryPatientGroupByParam(patientGroup)!=null){
			throw new RemoteCallExcption("groupName  already exist groupName="+patientGroup.getGroupName());
		}
		if(patientGroupDao.updatePatientGroup(patientGroup)==0){
			throw new EmptyObjectExcption("update is null");
		}
	}

	@Override
	public void delPatientGroup(PatientGroup patientGroup) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(patientGroup.getGroupNo()) ||patientGroup.getCreator()==null){
			throw new EmptyParamExcption("param error param is "+JsonUtil.toJson(patientGroup));
		}
		if(patientGroupDao.delPatientGroup(patientGroup)==0){
			throw new EmptyObjectExcption("del is null");
		}
	}
	
	@Override
	@Transactional
	public void addPatientsToGroup(PatientGroupMemberReq req) {
		// TODO Auto-generated method stub
		if(req.getPatients()==null||req.getPatients().size()==0){
			throw new EmptyParamExcption(" patients is null");
		}
		if(StringUtils.isEmpty(req.getGroupNo())){
			throw new EmptyParamExcption(" groupNo is null");
		}
		for(Long patientId:req.getPatients()){
			patientGroupMembersDao.createPatientGroupMembers(req.getGroupNo(),patientId);
		}
	}

	@Override
	@Transactional
	public void resetPatientToGroups(PatientGroupMemberReq req) {
		// TODO Auto-generated method stub
		if(req.getDoctorId()==null)
			throw new EmptyParamExcption(" doctorId is null");
		if(req.getGroupNos()==null||req.getGroupNos().size()==0)
			throw new EmptyParamExcption(" groupNos is null");
		if(req.getPatientId()==null)
			throw new EmptyParamExcption(" patientId is null");
		//删除患者所在的分组
		patientGroupMembersDao.deletePatientOfGroupMember(req);
		//循环插入所在分组
		for(String groupNo : req.getGroupNos())
			if(StringUtils.isNotEmpty(groupNo)){
				patientGroupMembersDao.createPatientGroupMembers(groupNo, req.getPatientId());
			}
	}
	
	@Override
	@Transactional
	public void deletePatientGroupMembers(PatientGroupMemberReq req) {
		// TODO Auto-generated method stub
		if(req.getPatients()==null||req.getPatients().size()==0){
			throw new EmptyParamExcption(" patients is null");
		}
		if(StringUtils.isEmpty(req.getGroupNo())){
			throw new EmptyParamExcption(" groupNo is null");
		}
		if(patientGroupMembersDao.deletePatientGroupMember(req)==0){
			throw new EmptyObjectExcption(" groupNo not has patients   params="+JsonUtil.toJson(req));
		}
	}

	@Override
	public List<PatientGroup> getGroupOfPatient(PatientGroupMemberReq req)throws Exception{
		// TODO Auto-generated method stub
		if(req.getDoctorId()==null)
			throw new EmptyParamExcption(" doctorId is null");
		if(req.getPatientId()==null)
			throw new EmptyParamExcption(" patientId is null");
		return getPatientGroupList(req.getDoctorId(),0,req.getPatientId());
	}

	
	@Override
	@Transactional
	public void focusPatientGroupDoctor(PatientGroupMemberReq req) {
		// TODO Auto-generated method stub
		if(req.getDoctorId()==null||req.getPatientId()==null || req.getFocusFlag()==null)
			throw new EmptyParamExcption(" param is error,param :"+JsonUtil.toJson(req));
		PatientGroup patientGroup  = new PatientGroup();
		patientGroup.setCreator(req.getDoctorId());
		patientGroup.setGroupWay(PatientGroupConstant.GROUP_WAY_DOCTORFOCUS_GROUP);
		patientGroup.setGroupNo(patientGroupDao.queryPatientGroupByParam(patientGroup));
		if(StringUtils.isEmpty(patientGroup.getGroupNo())){
			patientGroup.setGroupNo(GeneralUtil.generateUniqueID("GROUP"));
			patientGroup.setGroupName("特殊关注");
			patientGroupDao.addPatientGroup(patientGroup);
		}
		if(req.getFocusFlag()==PatientGroupConstant.FOCUS_ON){
			//添加患者
			patientGroupMembersDao.createPatientGroupMembers(patientGroup.getGroupNo(), req.getPatientId());
		}else{
			//删除患者
			PatientGroupMemberReq memberReq = new PatientGroupMemberReq();
			memberReq.setGroupNo(patientGroup.getGroupNo());
			memberReq.setPatients(new ArrayList<Long>());
			memberReq.getPatients().add(req.getPatientId());
			patientGroupMembersDao.deletePatientGroupMember(memberReq);
		}
	}
}
