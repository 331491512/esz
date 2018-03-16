package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTreatmentOperationInfo;

/**
* @ClassName: TCrfResultTreatmentOperationInfoDao 
* @Description: 手术结果数据操作接口 
* @author wang_hw
* @date 2016年6月3日 下午5:28:36
 */
public interface TCrfResultTreatmentOperationInfoDao{
	
	/**
	 * @author wang_hw
	 * @title :insertCrfResultTreatmentOperation
	 * @Description:手术结果数据录入
	 * @return void
	 * @date 2016年6月3日 下午5:29:08
	 */
	public void insertCrfResultTreatmentOperation(TCrfResultTreatmentOperationInfo crfResultTreatmentOperation);
	
	/**
	 * @author wang_hw
	 * @title :insertCrfResultTreatmentOperationList
	 * @Description:手术结果数据录入（列表）
	 * @return void
	 * @date 2016年6月3日 下午5:41:54
	 */
	public void insertCrfResultTreatmentOperationList(List<TCrfResultTreatmentOperationInfo> list);
	/**
	 * @author wang_hw
	 * @title :updateCrfResultTreatmentOperation
	 * @Description:手术结果数据修改
	 * @return void
	 * @date 2016年6月3日 下午5:29:13
	 */
	public void updateCrfResultTreatmentOperation(TCrfResultTreatmentOperationInfo crfResultTreatmentOperation);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfResultTreatmentOperation
	 * @Description:手术结果数据删除
	 * @return void
	 * @date 2016年6月3日 下午5:29:18
	 */
	public void deleteCrfResultTreatmentOperation(String crfResultTreatmentOperationId);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfResultTreatmentOperationByCrfResultId
	 * @Description:手术结果数据删除(根据结果ID)
	 * @return void
	 * @date 2016年6月7日 上午10:36:51
	 */
	public void deleteCrfResultTreatmentOperationByCrfResultId(String crfResultId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultTreatmentOperation
	 * @Description:手术结果数据查询
	 * @return TCrfResultTreatmentOperationInfo
	 * @date 2016年6月3日 下午5:29:23
	 */
	public TCrfResultTreatmentOperationInfo queryCrfResultTreatmentOperation(String crfResultTreatmentOperationId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultTreatmentOperationByCrfObserveIdAndPatientId
	 * @Description:手术结果数据查询（根据观察项ID及患者ID）
	 * @return TCrfResultMainInfo<List<TCrfResultTreatmentOperationInfo>>
	 * @date 2016年6月3日 下午5:44:22
	 */
	public TCrfResultMainInfo<List<TCrfResultTreatmentOperationInfo>> queryCrfResultTreatmentOperationByCrfObserveIdAndPatientId(@Param("crfObserveId")String crfObserveId , @Param("patientId")Long patientId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午2:01:50
	 * @param projectId
	 * @return
	 */
	public int deleteByProjectId(String projectId);
	
}
