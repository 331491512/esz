package com.esuizhen.cloudservice.research.dao.result;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;

/**
* @ClassName: TCrfResultMainInfoDao 
* @Description: CRF结果主表数据操作接口
* @author wang_hw
* @date 2016年5月30日 下午6:56:18
 */
public interface TCrfResultMainInfoDao{
	
	/**
	 * @author wang_hw
	 * @title :insertCrfResultMain
	 * @Description:保存结果主表数据
	 * @return void
	 * @date 2016年5月30日 下午6:56:13
	 */
	public void insertCrfResultMain(TCrfResultMainInfo<?> crfResultMain);
	
	/**
	 * 
	 * @author wang_hw
	 * @title :updateCrfResultMain
	 * @Description:修改主表信息
	 * @return void
	 * @date 2016年5月30日 下午6:57:41
	 */
	public void updateCrfResultMain(TCrfResultMainInfo<?>  crfResultMain);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfResultMain
	 * @Description:删除主表信息
	 * @return void
	 * @date 2016年5月30日 下午6:57:45
	 */
	public void deleteCrfResultMain(String crfResultId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultMain
	 * @Description:查询主表信息
	 * @return TCrfResultMainInfo<?>
	 * @date 2016年5月30日 下午6:57:49
	 */
	public TCrfResultMainInfo<?> queryCrfResultMain(String crfResultId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultMainByPatientId
	 * @Description:查询主表信息（根据观察项ID患者ID）
	 * @return TCrfResultMainInfo<?>
	 * @date 2016年5月30日 下午7:01:57
	 */
	public TCrfResultMainInfo<?> queryCrfResultMainByCrfObserveIdAndPatientId(@Param("crfObserveId")String crfObserveId, @Param("patientId")Long patientId);
	
	/**
	 * <p>Title:gatherFlag</p>
	 * <p>Description:判断指定的患者ID和随访阶段是否采集了数据</p>
	 * @author YYCHEN
	 * @date 2016年6月22日 下午8:50:28
	 * @param crfCourseItemId
	 * @param patientId
	 * @return
	 */
	int gatherFlag(@Param("crfCourseItemId")String crfCourseItemId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午4:32:58
	 * @param projectId
	 * @return
	 */
	public int deleteByProjectId(String projectId);
}
