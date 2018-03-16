/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.service;<br/>  
 * <b>文件名：</b>PatientGroupService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月23日上午10:40:27<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.service;

import java.util.List;

import com.esuizhen.cloudservice.user.bean.PatientGroupIdListReq;
import com.esuizhen.cloudservice.user.bean.PatientGroupMemberReq;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.PatientGroup;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.RejectRequestExcption;

/** 
* @ClassName: PatientGroupService
* @Description: 
* @author lichenghao
* @date 2016年5月23日 上午10:40:27  
*/
public interface PatientGroupService {
	
	/**
	 * 
	* @Title: getPatientGroupList 
	* @Description: 根据医生编号查询患者分组信息
	* @param 
	* @return List<PatientGroup>
	* @throws
	 */
	public List<PatientGroup> getPatientGroupList(Long doctorId,Integer groupWay)throws Exception;
	/**
	 * 
	* @Title: getPatientGroupMembersList 
	* @Description: 查询组内患者详情
	* @param 
	* @return List<PatientSimpleInfo>
	* @throws
	 */
	public Page<PatientSimpleInfo> getPatientGroupMembersList(PatientGroupIdListReq req);

	/**
	 * 
	 * @author lichenghao
	 * @title :addPatientGroup
	 * @Description:创建患者分组
	 * @return String
	 * @date 2016年5月18日 下午6:31:56
	 */
	public String addPatientGroup(PatientGroup patientGroup);
	/**
	 * 修改患者分组
	 * @author lichenghao
	 * @title :updatePatientGroup
	 * @Description:TODO
	 * @return String
	 * @date 2016年5月19日 上午9:26:08
	 */
	public void updatePatientGroup(PatientGroup patientGroup);
	
	/**
	 * 删除患者分组
	 * @author lichenghao
	 * @title :delPatientGroup
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月19日 上午9:52:54
	 */
	public void delPatientGroup(PatientGroup patientGroup);
	
	/**
	 * 插入患者到分组
	 * @author lichenghao
	 * @title :addPatientsToGroup
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月23日 上午11:10:00
	 */
	public void addPatientsToGroup(PatientGroupMemberReq req);
	
	/**
	 * 重置患者组
	 * @author lichenghao
	 * @title :resetPatientsToGroup
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月23日 上午11:12:40
	 */
	public void resetPatientToGroups(PatientGroupMemberReq req);
	
	/**
	 * 移除组内患者
	 * @author lichenghao
	 * @title :deletePatientGroupMembers
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月23日 上午11:37:09
	 */
	public void deletePatientGroupMembers(PatientGroupMemberReq req);
	
	/**
	 * 获取患者分组
	 * @author lichenghao
	 * @title :getGroupOfPatient
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月23日 上午11:39:44
	 */
	public List<PatientGroup> getGroupOfPatient(PatientGroupMemberReq req)throws Exception;
	
	/**
	 * 医生关注患者
	 * @author lichenghao
	 * @title :focusPatientGroupDoctor
	 * @Description:TODO
	 * @return void
	 * @date 2016年9月26日 下午12:09:06
	 */
	public void focusPatientGroupDoctor(PatientGroupMemberReq req);
}
