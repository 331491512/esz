package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.bean.PatientsInProjectSearchReq;
import com.esuizhen.cloudservice.research.model.result.TProjectInvitationPatient;
import com.westangel.common.bean.PatientSimpleInfo;

/**
 * <p>Title:ProjectInvitationPatientDao</p>
 * <p>Description:专题患者邀请数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年5月31日 上午10:54:38
 */
public interface TProjectInvitationPatientDao {
	/**
	 * <p>Title:insertByBatch</p>
	 * <p>Description:批量新增邀请患者</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 上午10:57:37
	 * @param projectInvitationPatient
	 * @param patientSimpleInfos
	 * @return
	 */
	int insertByBatch(@Param("projectInvitationPatient")TProjectInvitationPatient projectInvitationPatient, @Param("patientSimpleInfos")List<PatientSimpleInfo> patientSimpleInfos);
	
	/**
	 * <p>Title:updatePatientsState</p>
	 * <p>Description:修改集合中患者的入组状态</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午2:38:33
	 * @param projectInvitationPatient
	 * @param patientSimpleInfos
	 * @return
	 */
	int updatePatientsState(@Param("projectInvitationPatient")TProjectInvitationPatient projectInvitationPatient, @Param("patientSimpleInfos")List<PatientSimpleInfo> patientSimpleInfos);
	
	int updateInvitationPatientState(@Param("mobile")String mobile, @Param("beforState")Integer beforState, @Param("state")Integer state);

	/**
	 * <p>Title:recordInvitationContent</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年11月11日 下午7:16:10
	 * @param projectId
	 * @param subcenterId
	 * @param groupId
	 * @param doctorId
	 * @param patientId
	 * @param state
	 * @param invitationContent
	 * @return
	 */
	int recordInvitationContent(@Param("projectId")String projectId, @Param("subcenterId")Long subcenterId, @Param("groupId")String groupId,
			@Param("doctorId")Long doctorId, @Param("patientId")Long patientId, @Param("state")Integer state, @Param("invitationContent")String invitationContent);
	
	/**
	 * <p>Title:deletePendingPatients</p>
	 * <p>Description:将选择的待入组患者删除</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午3:02:51
	 * @param projectInvitationPatient
	 * @param patientSimpleInfos
	 * @return
	 */
	int deletePendingPatients(@Param("projectInvitationPatient")TProjectInvitationPatient projectInvitationPatient, @Param("patientSimpleInfos")List<PatientSimpleInfo> patientSimpleInfos);

	/**
	 * <p>Title:searchInProjectPatients</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午3:12:04
	 * @param patientsInProjectSearchReq
	 * @return
	 */
	List<PatientSimpleInfo> searchInProjectPatients(PatientsInProjectSearchReq patientsInProjectSearchReq);

	/**
	 * <p>Title:deleteProjectPatients</p>
	 * <p>Description:删除专题内患者</p>
	 * @author YYCHEN
	 * @date 2016年6月22日 下午3:31:31
	 * @param projectId
	 * @param patientSimpleInfos
	 * @return
	 */
	int deleteProjectPatients(@Param("projectId")String projectId, @Param("patientSimpleInfos")List<PatientSimpleInfo> patientSimpleInfos);

	/**
	 * <p>Title:confirmJoinProjectInvitation</p>
	 * <p>Description:保存患者确认加入专题的邀请</p>
	 * @author YYCHEN
	 * @date 2016年10月21日 下午4:14:50
	 * @param projectId
	 * @param doctorId
	 * @param patientId
	 * @param state
	 * @param confirmSource
	 * @return
	 */
	int confirmJoinProjectInvitation(@Param("projectId")String projectId, @Param("doctorId")Long doctorId, @Param("patientId")Long patientId,
			@Param("state")Integer state, @Param("confirmSource")Integer confirmSource);

	/**
	 * <p>Title:findInvitaionInfo</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年10月26日 上午11:47:59
	 * @param projectId
	 * @param subcenterId
	 * @param groupId
	 * @param doctorId
	 * @param patientId
	 * @return
	 */
	TProjectInvitationPatient findInvitaionInfo(@Param("projectId")String projectId, @Param("subcenterId")Long subcenterId,
			@Param("groupId")String groupId, @Param("doctorId")Long doctorId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除专题患者邀请</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 上午11:03:38
	 * @param projectId
	 * @return
	 */
	int deleteByProjectId(String projectId);

	/**
	 * <p>Title:deleteByDoctorId</p>
	 * <p>Description:根据医生ID删除被邀请的患者</p>
	 * @author YYCHEN
	 * @date 2016年11月8日 下午2:17:26
	 * @param projectId
	 * @param doctorId
	 * @return
	 */
	int deleteByDoctorId(@Param("projectId")String projectId, @Param("doctorId")Long doctorId);

	/**
	 * <p>Title:updatePatientIntoGroup</p>
	 * <p>Description:将邀请患者改为一个分组里</p>
	 * @author YYCHEN
	 * @date 2016年11月8日 下午3:03:34
	 * @param projectId
	 * @param groupId
	 * @return
	 */
	int updatePatientIntoGroup(@Param("projectId")String projectId, @Param("groupId")String groupId);

	/**
	 * <p>Title:deleteBySubcenterId</p>
	 * <p>Description:根据分中心ID删除</p>
	 * @author YYCHEN
	 * @date 2016年11月8日 下午3:24:48
	 * @param subcenterId
	 * @return
	 */
	int deleteBySubcenterId(Long subcenterId);

	TProjectInvitationPatient findById(Long id);
	
	int findCount(@Param("projectId")String projectId, @Param("subcenterId")Long subcenterId, @Param("doctorId")Long doctorId);

	/**
	 * <p>Title:deleteByGroupId</p>
	 * <p>Description:通过患者组ID删除邀请的患者</p>
	 * @author YYCHEN
	 * @date 2016年11月11日 下午12:05:38
	 * @param groupId
	 * @return
	 */
	int deleteByGroupId(String groupId);
}
