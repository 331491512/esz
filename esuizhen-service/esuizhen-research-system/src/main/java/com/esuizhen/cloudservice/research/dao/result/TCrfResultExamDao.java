package com.esuizhen.cloudservice.research.dao.result;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultExam;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;

/**
 * <p>Title:CrfResultExamDao</p>
 * <p>Description:检查结果数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年5月30日 下午6:29:34
 */
public interface TCrfResultExamDao {

	/**
	 * <p>Title:findCrfResultExamExcuteDatesRecord</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年7月21日 下午3:50:25
	 * @param projectId
	 * @param patientId
	 * @param examParentTypeId
	 * @param orderBy
	 * @param orderType
	 * @return
	 */
	List<TCrfResultExam> findCrfResultExamExcuteDatesRecord(@Param("projectId")String projectId, @Param("patientId")Long patientId, @Param("examParentTypeId")String examParentTypeId, @Param("orderBy")String orderBy, @Param("orderType")String orderType);
	
	/**
	 * <p>Title:findCrfResultExamsRecord</p>
	 * <p>Description:查询历史检查记录</p>
	 * @author YYCHEN
	 * @date 2016年6月2日 上午10:05:22
	 * @param projectId
	 * @param patientId
	 * @param excuteDate
	 * @return
	 */
	List<TCrfResultMainInfo<List<TCrfResultExam>>> findCrfResultExamsRecord(@Param("projectId")String projectId, @Param("patientId")Long patientId, @Param("examParentTypeId")String examParentTypeId, @Param("examTypeId")Integer examTypeId, @Param("crfExamResultId")String crfExamResultId, @Param("excuteDate")Date excuteDate);

	/**
	 * <p>Title:findCrfResultExams</p>
	 * <p>Description:查询当期检查记录</p>
	 * @author YYCHEN
	 * @date 2016年6月2日 上午10:05:37
	 * @param crfObserveId
	 * @param patientId
	 * @return
	 */
	TCrfResultMainInfo<List<TCrfResultExam>> findCrfResultExams(@Param("crfObserveId")String crfObserveId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:deleteByCrfResultIdAndPatientId</p>
	 * <p>Description:通过crfResultId和患者ID删除检查记录</p>
	 * @author YYCHEN
	 * @date 2016年6月2日 上午10:13:32
	 * @param crfResultId
	 * @param patientId
	 * @return
	 */
	int deleteByCrfResultIdAndPatientId(@Param("crfResultId")String crfResultId, @Param("patientId")Long patientId);
	
	/**
	 * <p>Title:insertByBatch</p>
	 * <p>Description:批量新增检查记录</p>
	 * @author YYCHEN
	 * @date 2016年6月2日 上午10:12:02
	 * @param crfResultExams
	 * @return
	 */
	int insertByBatch(@Param("crfResultExams")List<TCrfResultExam> crfResultExams);
	
	/**
	 * <p>Title:insert</p>
	 * <p>Description:保存检查信息</p>
	 * @author YYCHEN
	 * @date 2016年6月8日 下午4:24:00
	 * @param crfResultExam
	 * @return
	 */
	int insert(@Param("record")TCrfResultExam crfResultExam);
	/**
	 * <p>Title:queryMedicalRecordDataSources</p>
	 * <p>Description:查询患者病历的检查数据源</p>
	 * @author YYCHEN
	 * @date 2016年7月26日 下午4:21:45
	 * @param crfResultMainInfo
	 * @return
	 */
	List<TCrfResultMainInfo<Void>> queryMedicalRecordDataSources(@Param("record")TCrfResultMainInfo<Void> crfResultMainInfo);

	/**
	 * <p>Title:queryMedicalRecordData</p>
	 * <p>Description:获取病历中的检查数据</p>
	 * @author YYCHEN
	 * @date 2016年7月26日 下午7:07:00
	 * @param emrId
	 * @return
	 */
	TCrfResultMainInfo<TCrfResultExam> queryMedicalRecordData(String emrId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午4:19:33
	 * @param projectId
	 * @return
	 */
	int deleteByProjectId(String projectId);
}
