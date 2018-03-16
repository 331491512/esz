package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TRSubcenterPatient;
import com.westangel.common.bean.PatientSimpleInfo;

/**
 * <p>Title:RSubcenterPatientDao</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年5月31日 上午11:55:27
 */
public interface TRSubcenterPatientDao {
	/**
	 * <p>Title:insertByBatch</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 上午11:56:20
	 * @param rSubcenterPatient
	 * @param patientSimpleInfos
	 * @return
	 */
	int insertByBatch(@Param("rSubcenterPatient")TRSubcenterPatient rSubcenterPatient, @Param("patientSimpleInfos")List<PatientSimpleInfo> patientSimpleInfos);

	int insert(TRSubcenterPatient rSubcenterPatient);
	
	/**
	 * <p>Title:deleteProjectPatients</p>
	 * <p>Description:删除专题分中心患者关系</p>
	 * @author YYCHEN
	 * @date 2016年6月22日 下午3:38:01
	 * @param projectId
	 * @param patientSimpleInfos
	 * @return
	 */
	int deleteProjectPatients(@Param("projectId")String projectId, @Param("patientSimpleInfos")List<PatientSimpleInfo> patientSimpleInfos);
	
	/**
	 * <p>Title:findSerialNo</p>
	 * <p>Description:查询医生邀请了多少患者</p>
	 * @author YYCHEN
	 * @date 2016年7月6日 上午10:27:15
	 * @param projectId
	 * @param doctorId
	 * @return
	 */
	int findInvitationCount(@Param("projectId")String projectId, @Param("doctorId")Long doctorId);

	/**
	 * <p>Title:superinduceByInvitation</p>
	 * <p>Description:通过专题与被邀请患者添加分中心与患者关系</p>
	 * @author YYCHEN
	 * @date 2016年10月25日 上午9:44:38
	 * @param crfResultMainInfo
	 * @return
	 */
	int superinduceByInvitation(TCrfResultMainInfo<List<PatientSimpleInfo>> crfResultMainInfo);

	/**
	 * <p>Title:findGroupCount</p>
	 * <p>Description:统计专题分中心入组患者人数</p>
	 * @author YYCHEN
	 * @date 2016年10月27日 上午9:47:56
	 * @param groupId
	 * @return
	 */
	int findGroupCount(@Param("projectId")String project, @Param("groupId")String groupId);

	/**
	 * <p>Title:findPatientCount</p>
	 * <p>Description:查询患者是否已被邀请进入专题</p>
	 * @author YYCHEN
	 * @date 2016年11月9日 下午4:46:04
	 * @param project
	 * @param patientId
	 * @return
	 */
	int findPatientCount(@Param("projectId")String project, @Param("patientId")Long patientId);
	
	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 上午11:10:20
	 * @param projectId
	 * @return
	 */
	int deleteByProjectId(String projectId);

	/**
	 * <p>Title:deleteByDoctorId</p>
	 * <p>Description:通过邀请医生ID删除被邀请的患者</p>
	 * @author YYCHEN
	 * @date 2016年11月8日 下午2:11:02
	 * @param projectId
	 * @param doctorId
	 * @return
	 */
	int deleteByDoctorId(@Param("projectId")String projectId, @Param("doctorId")Long doctorId);

	/**
	 * <p>Title:updatePatientIntoGroup</p>
	 * <p>Description:将分中心患者改到一个分组里</p>
	 * @author YYCHEN
	 * @date 2016年11月8日 下午3:06:37
	 * @param projectId
	 * @param groupId
	 * @return
	 */
	int updatePatientIntoGroup(@Param("projectId")String projectId, @Param("groupId")String groupId);

	/**
	 * <p>Title:deleteBySubcenterId</p>
	 * <p>Description:根据分中心ID删除</p>
	 * @author YYCHEN
	 * @date 2016年11月8日 下午3:21:18
	 * @param subcenterId
	 * @return
	 */
	int deleteBySubcenterId(Long subcenterId);

	/**
	 * <p>Title:deleteByGroupId</p>
	 * <p>Description:通过患者组ID删除分中心患者</p>
	 * @author YYCHEN
	 * @date 2016年11月11日 下午12:07:43
	 * @param groupId
	 * @return
	 */
	int deleteByGroupId(String groupId);
}
