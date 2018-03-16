package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultTreatmentChemotherapyMedicationDetail;

/**
* @ClassName: TCrfResultTreatmentChemotherapyMedicationDetailDao 
* @Description: 化疗结果数据处理接口
* @author wang_hw
* @date 2016年6月2日 下午4:00:16
 */
public interface TCrfResultTreatmentChemotherapyMedicationDetailDao
{
	/**
	 * @author wang_hw
	 * @title :insertCrfResultTreatmentChemotherapyMedicationDetail
	 * @Description:化疗明细结果录入
	 * @return void
	 * @date 2016年6月2日 下午4:00:38
	 */
	public void insertCrfResultTreatmentChemotherapyMedicationDetail(TCrfResultTreatmentChemotherapyMedicationDetail crfResultTreatmentChemotherapyMedicationDetail);
	
	/**
	 * @author wang_hw
	 * @title :insertCrfResultTreatmentChemotherapyMedicationDetailList
	 * @Description:化疗明细结果录入（批量）
	 * @return void
	 * @date 2016年6月2日 下午4:00:54
	 */
	public void insertCrfResultTreatmentChemotherapyMedicationDetailList(List<TCrfResultTreatmentChemotherapyMedicationDetail> list);
	
	/**
	 * @author wang_hw
	 * @title :updateCrfResultTreatmentChemotherapyMedicationDetail
	 * @Description:化疗明细结果修改
	 * @return void
	 * @date 2016年6月2日 下午4:00:59
	 */
	public void updateCrfResultTreatmentChemotherapyMedicationDetail(TCrfResultTreatmentChemotherapyMedicationDetail crfResultTreatmentChemotherapyMedicationDetail);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfResultTreatmentChemotherapyMedicationDetail
	 * @Description:化疗明细结果删除
	 * @return void
	 * @date 2016年6月2日 下午4:01:04
	 */
	public void deleteCrfResultTreatmentChemotherapyMedicationDetail(String crfResultTreatmentChemotherapyMedicationDetailId);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfResultTreatmentChemotherapyMedicationDetailByCrfResultId
	 * @Description:化疗明细结果删除（根据结果ID）
	 * @return void
	 * @date 2016年6月7日 上午10:24:27
	 */
	public void deleteCrfResultTreatmentChemotherapyMedicationDetailByCrfResultId(String crfResultId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultTreatmentChemotherapyMedicationDetail
	 * @Description:结果明细结果查询
	 * @return TCrfResultTreatmentChemotherapyMedicationDetail
	 * @date 2016年6月2日 下午4:01:09
	 */
	public TCrfResultTreatmentChemotherapyMedicationDetail queryCrfResultTreatmentChemotherapyMedicationDetail(String crfResultTreatmentChemotherapyMedicationDetailId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午2:05:11
	 * @param projectId
	 * @return
	 */
	public int deleteByProjectId(String projectId);
	
}
