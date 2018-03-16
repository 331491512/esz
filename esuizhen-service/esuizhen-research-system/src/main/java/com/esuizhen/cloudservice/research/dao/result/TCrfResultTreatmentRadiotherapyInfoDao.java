package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTreatmentRadiotherapyInfo;

/**
* @ClassName: TCrfResultTreatmentRadiotherapyInfoDao 
* @Description: 放疗结果数据操作接口
* @author wang_hw
* @date 2016年6月2日 下午5:08:01
 */
public interface TCrfResultTreatmentRadiotherapyInfoDao{
	
	/**
	 * @author wang_hw
	 * @title :insertCrfResultTreatmentRadiotherapy
	 * @Description:放疗结果录入
	 * @return void
	 * @date 2016年6月2日 下午5:08:15
	 */
	public void insertCrfResultTreatmentRadiotherapy(TCrfResultTreatmentRadiotherapyInfo crfResultTreatmentRadiotherapy);
	
	/**
	 * @author wang_hw
	 * @title :updateCrfResultTreatmentRadiotherapy
	 * @Description:放疗结果修改
	 * @return void
	 * @date 2016年6月2日 下午5:08:31
	 */
	public void updateCrfResultTreatmentRadiotherapy(TCrfResultTreatmentRadiotherapyInfo crfResultTreatmentRadiotherapy);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfResultTreatmentRadiotherapy
	 * @Description:放疗结果删除
	 * @return void
	 * @date 2016年6月2日 下午5:08:41
	 */
	public void deleteCrfResultTreatmentRadiotherapy(String crfResultTreatmentRadiotherapyId);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfResultTreatmentRadiotherapyByCrfResultId
	 * @Description:化疗结果删除（根据结果ID）
	 * @return void
	 * @date 2016年6月7日 上午10:32:00
	 */
	public void deleteCrfResultTreatmentRadiotherapyByCrfResultId(String crfResultId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultTreatmentRadiotherapy
	 * @Description:放疗结果查询
	 * @return TCrfResultTreatmentRadiotherapyInfo
	 * @date 2016年6月2日 下午5:08:54
	 */
	public TCrfResultTreatmentRadiotherapyInfo queryCrfResultTreatmentRadiotherapy(String crfResultTreatmentRadiotherapyId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultTreatmentRadiotherapyByCrfObserveIdAndPatientId
	 * @Description:放疗结果查询（根据观察项ID及患者ID）
	 * @return TCrfResultMainInfo<List<TCrfResultTreatmentRadiotherapyInfo>>
	 * @date 2016年6月3日 上午11:39:26
	 */
	public TCrfResultMainInfo<List<TCrfResultTreatmentRadiotherapyInfo>> queryCrfResultTreatmentRadiotherapyByCrfObserveIdAndPatientId(@Param("crfObserveId")String crfObserveId , @Param("patientId")Long patientId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午3:55:15
	 * @param projectId
	 * @return
	 */
	public int deleteByProjectId(String projectId);
	
}
