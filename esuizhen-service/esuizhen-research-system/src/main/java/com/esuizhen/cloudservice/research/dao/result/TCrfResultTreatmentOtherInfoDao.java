package com.esuizhen.cloudservice.research.dao.result;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTreatmentOtherInfo;

/**
* @ClassName: TCrfResultTreatmentOtherInfoDao 
* @Description: 治疗用药其他数据操作接口
* @author wang_hw
* @date 2016年6月6日 下午2:40:14
 */
public interface TCrfResultTreatmentOtherInfoDao
{
	/**
	 * @author wang_hw
	 * @title :insertCrfResultTreatmentOther
	 * @Description:其他治疗结果录入
	 * @return void
	 * @date 2016年6月6日 下午2:48:14
	 */
	public void insertCrfResultTreatmentOther(TCrfResultTreatmentOtherInfo crfResultTreatmentOtherInfo);
	
	/**
	 * @author wang_hw
	 * @title :insertCrfResultTreatmentOtherList
	 * @Description:其他治疗结果录入(列表)
	 * @return void
	 * @date 2016年6月6日 下午3:32:00
	 */
	public void insertCrfResultTreatmentOtherList(List<TCrfResultTreatmentOtherInfo> list);
	/**
	 * @author wang_hw
	 * @title :updateCrfResultTreatmentOther
	 * @Description:其他治疗结果修改
	 * @return void
	 * @date 2016年6月6日 下午2:48:39
	 */
	public void updateCrfResultTreatmentOther(TCrfResultTreatmentOtherInfo crfResultTreatmentOtherInfo);
	
	/**
	 * 
	 * @author wang_hw
	 * @title :deleteCrfResultTreatmentOther
	 * @Description:其他治疗结果删除
	 * @return void
	 * @date 2016年6月6日 下午2:48:44
	 */
	public void deleteCrfResultTreatmentOther(String crfResultTreatmentOtherId);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfResultTreatmentOtherByCrfResultId
	 * @Description:其他治疗结果删除(结果ID)
	 * @return void
	 * @date 2016年6月7日 上午10:43:01
	 */
	public void deleteCrfResultTreatmentOtherByCrfResultId(String crfResultId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultTreatmentOther
	 * @Description:其他治疗结果查询
	 * @return TCrfResultTreatmentOtherInfo
	 * @date 2016年6月6日 下午2:48:48
	 */
	public TCrfResultTreatmentOtherInfo queryCrfResultTreatmentOther(String crfResultTreatmentOtherId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultTreatmentOtherByCrfObserveIdPatientId
	 * @Description:其他治疗结果查询(根据观察项ID及患者ID)
	 * @return TCrfResultMainInfo<List<TCrfResultTreatmentOtherInfo>>
	 * @date 2016年6月6日 下午3:30:54
	 */
	public TCrfResultMainInfo<List<TCrfResultTreatmentOtherInfo>> queryCrfResultTreatmentOtherByCrfObserveIdPatientId(@Param("crfObserveId")String crfObserveId, @Param("patientId")Long patientId);

	/**
	 * @author wang_hw
	 * @title :queryCrfResultTreatmentMedication
	 * @Description:治疗及用药结果记录查询
	 * @return List<TCrfResultMainInfo<String>>
	 * @date 2016年6月6日 下午4:02:24
	 */
	public List<TCrfResultMainInfo<List<TCrfResultTreatmentOtherInfo>>> queryCrfResultTreatmentMedicationRecord(@Param("projectId")String projectId, @Param("patientId")Long patientId);
	
	/**
	 * <p>Title:queryCrfResultTreatmentMedicationRecord</p>
	 * <p>Description:通过时间获取治疗及用药发生情况</p>
	 * @author YYCHEN
	 * @date 2016年7月4日 下午6:47:19
	 * @param projectId
	 * @param patientId
	 * @return
	 */
	public List<TCrfResultTreatmentOtherInfo> queryCrfResultTreatmentMedicationByHappenTime(@Param("projectId")String projectId, @Param("patientId")Long patientId, @Param("happenTime")Date happenTime);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午1:58:02
	 * @param projectId
	 * @return
	 */
	public int deleteByProjectId(String projectId);
	
}
