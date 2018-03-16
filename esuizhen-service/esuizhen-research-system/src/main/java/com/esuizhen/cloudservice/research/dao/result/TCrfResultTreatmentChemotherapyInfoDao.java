package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTreatmentChemotherapyInfo;

/**
* @ClassName: TCrfResultTreatmentChemotherapyInfoDao 
* @Description: 化疗结果数据操作接口
* @author wang_hw
* @date 2016年6月2日 下午4:07:49
 */
public interface TCrfResultTreatmentChemotherapyInfoDao{
	
	/**
	 * @author wang_hw
	 * @title :insertCrfResultTreatmentChemotherapy
	 * @Description:化疗结果录入
	 * @return void
	 * @date 2016年6月2日 下午4:08:06
	 */
	public void insertCrfResultTreatmentChemotherapy(TCrfResultTreatmentChemotherapyInfo crfResultTreatmentChemotherapy);
	
	/**
	 * @author wang_hw
	 * @title :updateCrfResultTreatmentChemotherapy
	 * @Description:化疗结果修改
	 * @return void
	 * @date 2016年6月2日 下午4:08:24
	 */
	public void updateCrfResultTreatmentChemotherapy(TCrfResultTreatmentChemotherapyInfo crfResultTreatmentChemotherapy);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfResultTreatmentChemotherapy
	 * @Description:化疗结果删除
	 * @return void
	 * @date 2016年6月2日 下午4:08:36
	 */
	public void deleteCrfResultTreatmentChemotherapy(String crfResultTreatmentChemotherapyId);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfResultTreatmentChemotherapyByCrfResultId
	 * @Description:化疗结果删除（根据结果ID）
	 * @return void
	 * @date 2016年6月7日 上午10:23:01
	 */
	public void deleteCrfResultTreatmentChemotherapyByCrfResultId(String crfResultId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultTreatmentChemotherapy
	 * @Description:化疗结果查询
	 * @return TCrfResultTreatmentChemotherapyInfo
	 * @date 2016年6月2日 下午4:08:46
	 */
	public TCrfResultTreatmentChemotherapyInfo queryCrfResultTreatmentChemotherapy(String crfResultTreatmentChemotherapyId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultTreatmentChemotherapyByCrfObserveIdPatientId
	 * @Description:化疗结果查询(根据观察项ID及患者ID)
	 * @return TCrfResultMainInfo<List<TCrfResultTreatmentChemotherapyInfo>>
	 * @date 2016年6月2日 下午4:10:07
	 */
	public TCrfResultMainInfo<List<TCrfResultTreatmentChemotherapyInfo>> queryCrfResultTreatmentChemotherapyByCrfObserveIdPatientId(@Param("crfObserveId")String crfObserveId , @Param("patientId")Long patientId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午3:50:39
	 * @param projectId
	 * @return
	 */
	public int deleteByProjectId(String projectId);
}
