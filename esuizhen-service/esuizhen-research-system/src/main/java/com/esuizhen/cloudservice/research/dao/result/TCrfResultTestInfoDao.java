package com.esuizhen.cloudservice.research.dao.result;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTestInfo;

/**
 * @ClassName: TCrfResultTestInfoDao
 * @Description: 检验结果数据操作接口
 * @author wang_hw
 * @date 2016年5月30日 下午7:16:14
 */
public interface TCrfResultTestInfoDao {
	/**
	 * @author wang_hw
	 * @title :insertCrfResultTest
	 * @Description:检验结果保存
	 * @return void
	 * @date 2016年5月30日 下午7:24:55
	 */
	public void insertCrfResultTest(TCrfResultTestInfo crfResultTest);

	/**
	 * @author wang_hw
	 * @title :updateCrfResultTest
	 * @Description:检验结果修改
	 * @return void
	 * @date 2016年5月30日 下午7:25:13
	 */
	public void updateCrfResultTest(TCrfResultTestInfo crfResultTest);

	/**
	 * @author wang_hw
	 * @title :deleteCrfResultTest
	 * @Description:检验结果删除
	 * @return void
	 * @date 2016年5月30日 下午7:25:25
	 */
	public void deleteCrfResultTest(String crfTestResultId);

	/**
	 * @author wang_hw
	 * @title :deleteCrfResultTestByCrfResultId
	 * @Description:检验结果删除（根据结果ID）
	 * @return void
	 * @date 2016年6月7日 上午10:13:32
	 */
	public void deleteCrfResultTestByCrfResultId(String crfResultId);

	/**
	 * @author wang_hw
	 * @title :queryCrfResultTest
	 * @Description:检验结果查询
	 * @return TCrfResultTestInfo
	 * @date 2016年5月30日 下午7:25:41
	 */
	public TCrfResultTestInfo queryCrfResultTest(String crfTestResultId);

	/**
	 * @author wang_hw
	 * @title :queryCrfResultTestByPatientIdAndCrfObserveId
	 * @Description:检验结果查询（根据观察项ID及患者ID）
	 * @return TCrfResultMainInfo<List<TCrfResultTestInfo>>
	 * @date 2016年5月30日 下午7:25:57
	 */
	public TCrfResultMainInfo<List<TCrfResultTestInfo>> queryCrfResultTestByPatientIdAndCrfObserveId(
			@Param("crfObserveId") String crfObserveId, @Param("patientId") Long patientId);

	/**
	 * @author wang_hw
	 * @title :queryCrfResultTestByPatientIdAndProjectId
	 * @Description:检验记录查询（根据专题ID及患者ID）
	 * @return TCrfResultMainInfo<TCrfResultTestInfo>
	 * @date 2016年5月31日 下午2:26:06
	 */
	public List<TCrfResultMainInfo<List<TCrfResultTestInfo>>> queryCrfResultTestRecord(
			@Param("projectId") String projectId, @Param("patientId") Long patientId);

	public List<TCrfResultTestInfo> queryBySampleTime(@Param("sampleTime") Date sampleTime,
			@Param("patientId") Long patientId);

	/**
	 * <p>
	 * Title:queryMedicalRecordDataSources
	 * </p>
	 * <p>
	 * Description:查询患者病历的检验数据源
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年7月26日 下午5:53:40
	 * @param crfResultMainInfo
	 * @return
	 */
	public List<TCrfResultMainInfo<Void>> queryMedicalRecordDataSources(
			@Param("record") TCrfResultMainInfo<Void> crfResultMainInfo);

	/**
	 * <p>
	 * Title:queryMedicalRecordData
	 * </p>
	 * <p>
	 * Description:获取病历中的检验数据
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年7月26日 下午7:15:33
	 * @param emrId
	 * @return
	 */
	TCrfResultMainInfo<List<TCrfResultTestInfo>> queryMedicalRecordData(String emrId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午4:16:00
	 * @param projectId
	 * @return
	 */
	public int deleteByProjectId(String projectId);
}
