package com.esuizhen.cloudservice.research.service.result;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.research.bean.PatientsAdvancedSearchReq;
import com.esuizhen.cloudservice.research.bean.PatientsInProjectSearchReq;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TProjectInvitationPatient;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.bean.sms.SmsSendReportInfo;
import com.westangel.common.excption.DisableExcption;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.excption.TimeTooShortException;

/**
 * <p>Title:PatientManageService</p>
 * <p>Description:患者管理业务层接口</p>
 * @author YYCHEN
 * @date 2016年5月30日 下午3:24:04
 */
public interface PatientManageService {

	/**
	 * <p>Title:searchInProjectPatients</p>
	 * <p>Description:专题内患者筛选</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午3:10:17
	 * @param patientsInProjectSearchReq
	 * @return
	 * @throws ParseException 
	 */
	Page<PatientSimpleInfo> searchInProjectPatients(PatientsInProjectSearchReq patientsInProjectSearchReq) throws ParseException;
	
	/**
	 * <p>Title:searchUnselectedPatients</p>
	 * <p>Description:未入组患者筛选</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午3:25:14
	 * @param locale
	 * @param unselectedPatientsSearchReq
	 * @return
	 */
	Page<PatientSimpleInfo> searchUnselectedPatients(PatientsAdvancedSearchReq patientsAdvancedSearchReq);
	
	/**
	 * <p>Title:addPendingPatientsToProject</p>
	 * <p>Description:待入组患者添加</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 上午10:45:29
	 * @param crfResultMainInfo
	 * @return
	 * @throws ParameterCannotBeNullException 
	 * @throws ObjectNotAvailableExcption 
	 * @throws RejectRequestExcption 
	 * @throws DisableExcption 
	 * @throws TimeTooShortException 
	 */
	boolean addPendingPatientsToProject(TCrfResultMainInfo<List<PatientSimpleInfo>> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption, RejectRequestExcption, DisableExcption, TimeTooShortException;
	
	/**
	 * <p>Title:joinPatientsToProject</p>
	 * <p>Description:待入组患者添加为正式患者</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午2:29:36
	 * @param crfResultMainInfo
	 * @return
	 * @throws ParameterCannotBeNullException
	 * @throws ObjectNotAvailableExcption
	 * @throws RejectRequestExcption 
	 * @throws DisableExcption 
	 */
	boolean joinPatientsToProject(TCrfResultMainInfo<List<PatientSimpleInfo>> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption, RejectRequestExcption, DisableExcption;
	
	/**
	 * <p>Title:deletePendingPatients</p>
	 * <p>Description:将选择的待入组患者删除</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午2:59:49
	 * @param crfResultMainInfo
	 * @return
	 * @throws ParameterCannotBeNullException
	 * @throws ObjectNotAvailableExcption
	 */
	boolean deletePendingPatients(TCrfResultMainInfo<List<PatientSimpleInfo>> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;

	/**
	 * <p>Title:deleteProjectPatients</p>
	 * <p>Description:删除专题内患者</p>
	 * @author YYCHEN
	 * @date 2016年6月22日 下午3:20:26
	 * @param crfResultMainInfo
	 * @return
	 * @throws ParameterCannotBeNullException 
	 */
	boolean deleteProjectPatients(TCrfResultMainInfo<List<PatientSimpleInfo>> crfResultMainInfo) throws ParameterCannotBeNullException;

	/**
	 * <p>Title:getPatientInfo</p>
	 * <p>Description:获取患者个人信息</p>
	 * @author YYCHEN
	 * @date 2016年7月15日 下午6:44:26
	 * @param patientId
	 * @param patientId2
	 * @return
	 */
	PatientSimpleInfo getPatientInfo(String projectId, Long patientId);

	/**
	 * <p>Title:confirmJoinProjectOfPatient</p>
	 * <p>Description:患者确认进入专题的邀请</p>
	 * @author YYCHEN
	 * @date 2016年10月21日 下午4:10:38
	 * @param projectId
	 * @param subcenterId
	 * @param groupId
	 * @param doctorId
	 * @param patientId
	 * @param state
	 * @param confirmSource
	 * @return
	 * @throws ParameterCannotBeNullException 
	 * @throws DisableExcption 
	 * @throws RejectRequestExcption 
	 * @throws ObjectNotAvailableExcption 
	 */
	boolean confirmJoinProjectOfPatient(String projectId, Long subcenterId, String groupId, Long doctorId, Long patientId, Integer state,
			Integer confirmSource) throws ParameterCannotBeNullException, ObjectNotAvailableExcption, RejectRequestExcption, DisableExcption;

	/**
	 * <p>Title:searchStayPatientList</p>
	 * <p>Description:待入组患者列表获取</p>
	 * @author YYCHEN
	 * @date 2016年10月25日 上午11:01:53
	 * @param projectId
	 * @param subcenterId
	 * @param state
	 * @param doctorId
	 * @param page
	 * @param num
	 * @return
	 * @throws ParameterCannotBeNullException 
	 */
	Page<PatientSimpleInfo> searchStayPatientList(String projectId, Long subcenterId, Integer state, Long doctorId, Integer page,
			Integer num) throws ParameterCannotBeNullException;

	/**
	 * <p>Title:getInvitationContent</p>
	 * <p>Description:获取医生发送的邀请患者进入专题的信息</p>
	 * @author YYCHEN
	 * @date 2016年10月26日 上午11:33:38
	 * @param projectId
	 * @param subcenterId
	 * @param groupId
	 * @param doctorId
	 * @param patientId
	 * @return
	 */
	TProjectInvitationPatient getInvitationContent(String projectId, Long subcenterId, String groupId, Long doctorId, Long patientId);

	boolean receiptInvitaionPatientSmsState(Map<String, List<SmsSendReportInfo>> data);
}
