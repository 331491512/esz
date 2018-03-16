package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultQualityoflifeInfo;

/**
* @ClassName: TCrfResultQualityoflifeInfoDao 
* @Description: 生存质量结果数据操作接口 
* @author wang_hw
* @date 2016年6月1日 下午7:05:27
 */
public interface TCrfResultQualityoflifeInfoDao{
	
	/**
	 * @author wang_hw
	 * @title :insertCrfResultQualityoflife
	 * @Description:生存质量结果数据录入
	 * @return void
	 * @date 2016年6月1日 下午7:05:58
	 */
	public void insertCrfResultQualityoflife(TCrfResultQualityoflifeInfo crfResultQualityoflife);
	
	/**
	 * @author wang_hw
	 * @title :insertCrfResultQualityoflifeList
	 * @Description:生存质量结果数据录入(列表)
	 * @return void
	 * @date 2016年6月1日 下午7:45:35
	 */
	public void insertCrfResultQualityoflifeList(List<TCrfResultQualityoflifeInfo> list);
	/**
	 * @author wang_hw
	 * @title :updateCrfResultQualityoflife
	 * @Description:生存质量结果数据修改
	 * @return void
	 * @date 2016年6月1日 下午7:06:02
	 */
	public void updateCrfResultQualityoflife(TCrfResultQualityoflifeInfo crfResultQualityoflife);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfResultQualityoflife
	 * @Description:生存质量结果数据删除
	 * @return void
	 * @date 2016年6月1日 下午7:06:06
	 */
	public void deleteCrfResultQualityoflife(String crfResultQualityoflifeId);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfResultQualityoflifeByCrfResultId
	 * @Description:生存质量结果数据删除（根据结果ID）
	 * @return void
	 * @date 2016年6月7日 上午11:02:39
	 */
	public void deleteCrfResultQualityoflifeByCrfResultId(String crfResultId);
	/**
	 * @author wang_hw
	 * @title :queryCrfResultQualityoflife
	 * @Description:生存质量结果数据查询
	 * @return TCrfResultQualityoflifeInfo
	 * @date 2016年6月1日 下午7:06:10
	 */
	public TCrfResultQualityoflifeInfo queryCrfResultQualityoflife(String crfResultQualityoflifeId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultQualityoflifeByCrfResultIdAndPatientId
	 * @Description:生存质量结果数据查询(根据观察项ID及患者ID)
	 * @return TCrfResultMainInfo<List<TCrfResultQualityoflifeInfo>>
	 * @date 2016年6月1日 下午7:09:20
	 */
	public TCrfResultMainInfo<List<TCrfResultQualityoflifeInfo>> queryCrfResultQualityoflifeByCrfObserveIdAndPatientId(@Param("crfObserveId")String crfObserveId , @Param("patientId")Long patientId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultQualityoflifeByProjectIdAndPatientId
	 * @Description:生存质量QOL量表
	 * @return List<TCrfResultMainInfo<List<TCrfResultQualityoflifeInfo>>>
	 * @date 2016年6月1日 下午7:09:26
	 */
	List<TCrfResultQualityoflifeInfo> queryTCrfResultQualityoflifeInfoRecord(@Param("projectId")String projectId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午4:00:06
	 * @param projectId
	 * @return
	 */
	public int deleteByProjectId(String projectId);
}
