package com.esuizhen.cloudservice.research.dao.result;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.bean.PatientsAdvancedSearchReq;
import com.esuizhen.cloudservice.research.bean.UnselectedPatientsSearchReq;
import com.esuizhen.cloudservice.research.model.result.TCrfResultBasicDemography;
import com.esuizhen.cloudservice.research.model.result.TCrfResultDiagnosisInfo;
import com.westangel.common.bean.PatientSimpleInfo;

/**
 * <p>Title:PatientDao</p>
 * <p>Description:患者基本信息数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年5月31日 上午9:53:59
 */
public interface PatientDao {
	
	/**
	 * <p>Title:findUnselectedPatients</p>
	 * <p>Description:查找未入组患者</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 上午9:56:45
	 * @param unselectedPatientsSearchReq
	 * @return
	 */
	List<PatientSimpleInfo> findUnselectedPatients(UnselectedPatientsSearchReq unselectedPatientsSearchReq);
	
	/**
	 * <p>Title:findDemography</p>
	 * <p>Description:通过患者ID获取患者简要信息</p>
	 * @author YYCHEN
	 * @date 2016年6月12日 下午6:47:53
	 * @param patientId
	 * @return
	 */
	TCrfResultBasicDemography findDemography(Long patientId);
	
	/**
	 * <p>Title:findDiagosisInfo</p>
	 * <p>Description:获取患者诊断信息</p>
	 * @author YYCHEN
	 * @date 2016年6月13日 上午10:41:34
	 * @param patientId
	 * @param diseaseTypeId
	 * @return
	 */
	List<TCrfResultDiagnosisInfo> findDiagosisInfo(@Param("patientId")Long patientId, @Param("diseaseTypeId")Integer diseaseTypeId);
	
	/**
	 * <p>Title:findBaseDate</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年6月12日 下午6:47:11
	 * @param projectId
	 * @param patientId
	 * @return
	 */
	Date findBaseDate(@Param("projectId")String projectId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:findPatientInfo</p>
	 * <p>Description:获取患者信息</p>
	 * @author YYCHEN
	 * @date 2016年7月15日 下午6:57:57
	 * @param patientId
	 * @param patientId2
	 * @return
	 */
	PatientSimpleInfo findPatientInfo(@Param("projectId")String projectId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:selectUnselectedPatients</p>
	 * <p>Description:查询未入组的患者列表</p>
	 * @author YYCHEN
	 * @date 2016年10月25日 上午11:04:06
	 * @param patientsAdvancedSearchReq
	 * @param sqlStr
	 * @return
	 */
	List<PatientSimpleInfo> selectUnselectedPatients(@Param("req")PatientsAdvancedSearchReq patientsAdvancedSearchReq,@Param("sqlStr")String sqlStr);

	/**
	 * <p>Title:findStayPatientList</p>
	 * <p>Description:待入组患者列表查询</p>
	 * @author YYCHEN
	 * @date 2016年10月25日 上午11:05:58
	 * @param projectId
	 * @param state
	 * @param doctorId
	 * @return
	 */
	List<PatientSimpleInfo> findStayPatientList(@Param("projectId")String projectId, @Param("subcenterId")Long subcenterId, @Param("state")Integer state, @Param("doctorId")Long doctorId);
	
	int update(PatientSimpleInfo patientSimpleInfo);
	
	/**
	 * <p>Title:findDiseaseType</p>
	 * <p>Description:查询患者的病种信息</p>
	 * @author YYCHEN
	 * @date 2016年11月9日 下午6:50:20
	 * @param patientId
	 * @return
	 */
	PatientSimpleInfo findDiseaseType(Long patientId);
}
